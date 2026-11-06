package com.mar.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.multidex.MultiDex;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.widget.Toast;
import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mar.sdk.base.IActivityCallback;
import com.mar.sdk.base.IMARSDKListener;
import com.mar.sdk.base.PluginFactory;
import com.mar.sdk.dialog.DeregisterDialog;
import com.mar.sdk.dialog.PrivacyDialog;
import com.mar.sdk.gg.AdEvent;
import com.mar.sdk.gg.IAdGameEvent;
import com.mar.sdk.gg.IAdResult;
import com.mar.sdk.gg.MARGg;
import com.mar.sdk.gg.control.MggControl;
import com.mar.sdk.http.MARHttp;
import com.mar.sdk.log.Log;
import com.mar.sdk.manager.MARPluginAppManager;
import com.mar.sdk.permission.IAutoPermissionListener;
import com.mar.sdk.permission.INetworkListener;
import com.mar.sdk.permission.MARAutoPermission;
import com.mar.sdk.permission.MARNetworkDialog;
import com.mar.sdk.platform.InitCallBack;
import com.mar.sdk.platform.MARPlatform;
import com.mar.sdk.plugin.MARAction;
import com.mar.sdk.plugin.MARBlockWords;
import com.mar.sdk.plugin.MARCloudArchive;
import com.mar.sdk.plugin.MARCommonPlugin;
import com.mar.sdk.plugin.MARGameResource;
import com.mar.sdk.plugin.MARMutualPush;
import com.mar.sdk.plugin.MARPay;
import com.mar.sdk.plugin.MARTool;
import com.mar.sdk.plugin.MARUser;
import com.mar.sdk.plugin.MARVisitorLogin;
import com.mar.sdk.privacy.FloatPrivacyWindow;
import com.mar.sdk.rule.IPluginListener;
import com.mar.sdk.utils.GUtils;
import com.mar.sdk.utils.StoreUtils;
import com.mar.sdk.verify.MARProxy;
import com.mar.sdk.verify.UPrivacy;
import com.mar.sdk.verify.UToken;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MARSDK {
    private static final String APP_GAME_NAME = "MAR_Game_Application";
    private static final String APP_PROXY_NAME = "MAR_APPLICATION_PROXY_NAME";
    private static final String DEFAULT_PKG_NAME = "com.mar.sdk";
    private static final String MARSDK_VERSION = "3.6.6";
    private static final String TAG = "MARSDK";
    private static MARSDK instance;
    private Application application;
    private Activity context;
    private SDKParams developInfo;
    private FloatPrivacyWindow floatPrivacyWindow;
    private boolean isMainRun;
    private Bundle metaData;
    private IPluginListener pluginListener;
    private SDKParams MarUrlConfig = new SDKParams();
    private final List<IMARSDKListener> listeners = new CopyOnWriteArrayList();
    private final List<IActivityCallback> activityCallbacks = new ArrayList();
    private MARPluginAppManager pluginAppManager = new MARPluginAppManager();
    private InitResult initResult = null;
    private String sdkUserID = null;
    private UToken tokenData = null;
    private String severUserID = "";
    private String serverToken = null;
    private boolean initFinish = false;
    private InitCallBack initCallBack = null;
    private final List<IAdResult> adListeners = new ArrayList();
    private List<IAdGameEvent> iAdGameEventList = new ArrayList();
    int drmtype = 0;
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    public MARPluginAppManager getPluginAppManager() {
        return this.pluginAppManager;
    }

    public static MARSDK getInstance() {
        if (instance == null) {
            instance = new MARSDK();
        }
        return instance;
    }

    public SDKParams getSDKParams() {
        return this.developInfo;
    }

    public Bundle getMetaData() {
        return this.metaData;
    }

    public String getDeviceID() {
        String device_id = GUtils.getDeviceID(this.context);
        return device_id;
    }

    public int getSubChannel() {
        if (this.developInfo == null || !this.developInfo.contains("MAR_Sub_Channel")) {
            return 0;
        }
        return this.developInfo.getInt("MAR_Sub_Channel");
    }

    public int getCurrChannel() {
        return (this.developInfo == null || !this.developInfo.contains("MAR_Channel")) ? getAppID() * 1000 : this.developInfo.getInt("MAR_Channel");
    }

    public String getTestId() {
        return (this.developInfo == null || !this.developInfo.contains("MAR_PLAYID")) ? "" : this.developInfo.getString("MAR_PLAYID");
    }

    public String getArchiveUrl() {
        if (this.MarUrlConfig != null && !SDKTools.isNullOrEmpty(this.MarUrlConfig.getString("MAR_ARCHIVE"))) {
            return this.MarUrlConfig.getString("MAR_ARCHIVE");
        }
        if (this.developInfo == null || !this.developInfo.contains("MAR_ARCHIVE")) {
            return "";
        }
        return this.developInfo.getString("MAR_ARCHIVE");
    }

    public int getAppID() {
        if (this.developInfo == null || !this.developInfo.contains("MAR_APPID")) {
            return 0;
        }
        return this.developInfo.getInt("MAR_APPID");
    }

    public String getAppKey() {
        return (this.developInfo == null || !this.developInfo.contains("MAR_APPKEY")) ? "" : this.developInfo.getString("MAR_APPKEY");
    }

    public String getPayPrivateKey() {
        return (this.developInfo == null || !this.developInfo.contains("MAR_PAY_PRIVATEKEY")) ? "" : this.developInfo.getString("MAR_PAY_PRIVATEKEY");
    }

    public boolean isSingleGame() {
        if (this.developInfo == null || !this.developInfo.contains("MAR_SINGLE_GAME")) {
            return false;
        }
        return this.developInfo.getBoolean("MAR_SINGLE_GAME").booleanValue();
    }

    public boolean isAuth() {
        return getAuthURL() != null;
    }

    public boolean isGetOrder() {
        return getOrderURL() != null;
    }

    public String getOrderURL() {
        if (this.developInfo == null) {
            return null;
        }
        if (this.developInfo.contains("MAR_ORDER_URL")) {
            return this.developInfo.getString("MAR_ORDER_URL");
        }
        String baseUrl = getMARServerURL();
        if (baseUrl != null) {
            return baseUrl + "/mobile/pay/getOrderId";
        }
        return null;
    }

    public String getAuthURL() {
        if (this.developInfo == null) {
            return null;
        }
        if (this.developInfo.contains("MAR_AUTH_URL")) {
            return this.developInfo.getString("MAR_AUTH_URL");
        }
        String baseUrl = getMARServerURL();
        if (baseUrl != null) {
            return baseUrl + "/mobile/login/getMobileToken";
        }
        return null;
    }

    public String getGiftURL() {
        String baseUrl;
        if (this.developInfo == null || (baseUrl = getMARServerURL()) == null) {
            return null;
        }
        return baseUrl + "/mobile/giftbag/exchangeGiftbag";
    }

    public String getDownloadURL() {
        String baseUrl;
        if (this.developInfo == null || (baseUrl = getMARServerURL()) == null) {
            return null;
        }
        return baseUrl + "/mobile/margameresources/getResources";
    }

    public String getOrderFail() {
        String baseUrl;
        if (this.developInfo == null || (baseUrl = getMARServerURL()) == null) {
            return null;
        }
        return baseUrl + "/mobile/pay/automaticResendOrder";
    }

    public String getPayCompleteURL() {
        String baseUrl;
        if (this.developInfo == null || (baseUrl = getMARServerURL()) == null) {
            return null;
        }
        return baseUrl + "/mobile/pay/propComplete";
    }

    public String getPayCheckURL() {
        String baseUrl;
        if (this.developInfo == null || (baseUrl = getMARServerURL()) == null) {
            return null;
        }
        return baseUrl + "/mobile/pay/payQuery";
    }

    public String getTokenActive() {
        String baseUrl;
        if (this.developInfo == null || (baseUrl = getMARServerURL()) == null) {
            return null;
        }
        return baseUrl + "/mobile/login/loginMarToken";
    }

    public String getPrivacyURL() {
        String baseUrl;
        if (this.developInfo == null || (baseUrl = getMARServerURL()) == null) {
            return null;
        }
        return baseUrl + "/mobile/privacyfloating/getPrivacyFloating";
    }

    public String getInitUrl() {
        String baseUrl;
        if (this.developInfo == null || (baseUrl = getMARServerURL()) == null) {
            return null;
        }
        if (baseUrl.contains("martian-marsdk-server")) {
            baseUrl = baseUrl.replace("martian-marsdk-server", "martian-marsdk-advert");
        }
        return baseUrl + "/mobile/login/initializeAdvert";
    }

    public String getAdLoginUrl() {
        String baseUrl;
        if (this.developInfo == null || (baseUrl = getMARServerURL()) == null) {
            return null;
        }
        if (baseUrl.contains("martian-marsdk-server")) {
            baseUrl = baseUrl.replace("martian-marsdk-server", "martian-marsdk-advert");
        }
        return baseUrl + "/mobile/login/getAdvertToken";
    }

    public String getAdConfigToApp() {
        String baseUrl;
        if (this.developInfo == null || (baseUrl = getMARServerURL()) == null) {
            return null;
        }
        if (baseUrl.contains("martian-marsdk-server")) {
            baseUrl = baseUrl.replace("martian-marsdk-server", "martian-marsdk-advert");
        }
        return baseUrl + "/mobile/advert/downAdConfigure";
    }

    public String getSubmitDataURL() {
        String base;
        if (this.developInfo == null || (base = getMARServerURL()) == null) {
            return null;
        }
        return base + "/mobile/gameuserrole/updateGameUserRole";
    }

    public String getMARServerURL() {
        String url;
        if (this.MarUrlConfig != null && !SDKTools.isNullOrEmpty(this.MarUrlConfig.getString("MARSERVER_URL"))) {
            url = this.MarUrlConfig.getString("MARSERVER_URL") + "/martian-marsdk-server";
        } else {
            if (this.developInfo == null || !this.developInfo.contains("MARSERVER_URL")) {
                return null;
            }
            url = this.developInfo.getString("MARSERVER_URL");
            if (url == null || url.trim().length() == 0) {
                return null;
            }
            while (url.endsWith("/")) {
                url = url.substring(0, url.length() - 1);
            }
        }
        return url;
    }

    public String getNavigateConfigToApp() {
        String baseUrl;
        if (this.developInfo == null || (baseUrl = getMARServerURL()) == null) {
            return null;
        }
        if (baseUrl.contains("martian-marsdk-server")) {
            baseUrl = baseUrl.replace("martian-marsdk-server", "martian-marsdk-advert");
        }
        return baseUrl + "/mobile/pushgame/downPushGames";
    }

    public String getBlockWordsUrl() {
        return (this.developInfo != null || this.developInfo.contains("BW_URL")) ? this.developInfo.getString("BW_URL") : "";
    }

    public boolean isUseMARAnalytics() {
        if (this.developInfo == null || !this.developInfo.contains("MAR_ANALYTICS")) {
            return false;
        }
        String use = this.developInfo.getString("MAR_ANALYTICS");
        return "true".equalsIgnoreCase(use);
    }

    public boolean isSDKShowSplash() {
        if (this.developInfo == null || !this.developInfo.contains("MAR_SDK_SHOW_SPLASH")) {
            return false;
        }
        String show = this.developInfo.getString("MAR_SDK_SHOW_SPLASH");
        return "true".equalsIgnoreCase(show);
    }

    public String getSDKVersionCode() {
        return (this.developInfo == null || !this.developInfo.contains("MAR_SDK_VERSION_CODE")) ? "" : this.developInfo.getString("MAR_SDK_VERSION_CODE");
    }

    public String getSDKVersionName() {
        return (this.developInfo == null || !this.developInfo.contains("MAR_SDK_VERSION_NAME")) ? "" : this.developInfo.getString("MAR_SDK_VERSION_NAME");
    }

    public int getGameType() {
        if (this.developInfo == null || !this.developInfo.contains("MAR_CASHTYPE")) {
            return 0;
        }
        return this.developInfo.getInt("MAR_CASHTYPE");
    }

    public boolean getFreeStyle() {
        if (this.developInfo == null || !this.developInfo.contains("MAR_FREE")) {
            return false;
        }
        return this.developInfo.getBoolean("MAR_FREE").booleanValue();
    }

    public void setSDKListener(IMARSDKListener listener) {
        if (!this.listeners.contains(listener) && listener != null) {
            this.listeners.add(listener);
        }
    }

    public void setActivityCallback(IActivityCallback callback) {
        if (!this.activityCallbacks.contains(callback) && callback != null) {
            this.activityCallbacks.add(callback);
        }
    }

    public Application getApplication() {
        return this.application;
    }

    public String getSDKUserID() {
        return this.sdkUserID;
    }

    public UToken getUToken() {
        return this.tokenData;
    }

    public void onAppCreate(Application application) {
        this.application = application;
        this.pluginAppManager.onAppCreate(application);
        MARAutoPermission.getInstance().init(application);
    }

    public void onAppCreateAll(Application application) {
        this.pluginAppManager.onAppCreateAll(application);
    }

    public void onAppAttachBaseContext(Application application, Context context) {
        this.application = application;
        try {
            MultiDex.install(context);
            Log.init(context);
            PluginFactory.getInstance().getMarUrlConfig(this.MarUrlConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            PluginFactory.getInstance().loadPluginInfo(context);
            PluginFactory.getInstance().printMarSdk(context);
            this.developInfo = PluginFactory.getInstance().getSDKParams(context);
            this.metaData = PluginFactory.getInstance().getMetaData(context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.pluginAppManager.onAppAttachBaseContext(application, context, this.metaData);
    }

    public void onAppConfigurationChanged(Application application, Configuration newConfig) {
        this.pluginAppManager.onAppConfigurationChanged(application, newConfig);
    }

    public void onTerminate() {
        this.pluginAppManager.onTerminate();
    }

    public void init(final Activity context) {
        this.context = context;
        if (MARAutoPermission.getInstance().isDirectPermission()) {
            Log.d(TAG, "begin to request dangerous permissions in MARSDK");
            MARAutoPermission.getInstance().requestDangerousPermissions(context, new IAutoPermissionListener() { // from class: com.mar.sdk.MARSDK.1
                @Override // com.mar.sdk.permission.IAutoPermissionListener
                public void onAutoPermissionSuccess() {
                    MARSDK.this.doInit(context);
                }

                @Override // com.mar.sdk.permission.IAutoPermissionListener
                public void onAutoPermissionFailed(String[] deniedPermissions, String[] deniedForeverPermissions) {
                    Log.e(MARSDK.TAG, "permission request failed with auto permission.");
                    MARSDK.this.doInit(context);
                }
            });
        } else {
            doInit(context);
        }
    }

    public void doInit(Activity context) {
        this.context = context;
        initializeAdvert();
        try {
            StoreUtils.putlong(context, "init_marsdk_time", System.currentTimeMillis());
            Log.d(TAG, "begin init marsdk version : 3.6.6");
            MARUser.getInstance().init();
            MARPay.getInstance().init();
            MARCommonPlugin.getInstance().init();
            MARAction.getInstance().init();
            MARGg.getInstance().init();
            MARTool.getInstance().init();
            MARVisitorLogin.getInstance().init();
            MARCloudArchive.getInstance().init();
            MARGameResource.getInstance().init();
            MARBlockWords.getInstance().init();
            MARMutualPush.getInstance().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeAdvert() {
        if (getFreeStyle()) {
            this.initFinish = true;
            Log.d(TAG, "free mode don't need init ad");
        } else if (getGameType() == 1) {
            doInitTask();
        } else {
            this.initFinish = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInitTask() {
        if (!SDKTools.isNetworkAvailable(this.context) && getGameType() != 1) {
            MARNetworkDialog.showDialog(this.context, true, new INetworkListener() { // from class: com.mar.sdk.MARSDK.2
                @Override // com.mar.sdk.permission.INetworkListener
                public void retry() {
                    MARSDK.this.doInitTask();
                }

                @Override // com.mar.sdk.permission.INetworkListener
                public void exit() {
                    MARSDK.this.context.finish();
                    System.exit(0);
                }
            });
            return;
        }
        InitResult result = MARProxy.init();
        if (result != null) {
            Log.d(TAG, "init suc:" + result.toString());
            this.initResult = result;
            String objectId = StoreUtils.getString(instance.getContext(), "ADVERT_OBJECT");
            if (TextUtils.isEmpty(objectId)) {
                StoreUtils.putString(instance.getContext(), "ADVERT_OBJECT", result.getAdvertId());
            }
            MggControl.getInstance().setDisableRealnameSwitch(result.isDisableRealName());
            MggControl.getInstance().setRebootSkipLoginSwitch(result.isRebootSkipLoginSwitch());
            MggControl.getInstance().setCustomSwitch(result.isCustomSwitch());
        }
        if (this.initCallBack != null) {
            this.initCallBack.onInitFinish();
        }
        this.initFinish = true;
    }

    public void runOnMainThread(Runnable runnable) {
        if (this.mainThreadHandler != null) {
            this.mainThreadHandler.post(runnable);
        } else if (this.context != null) {
            this.context.runOnUiThread(runnable);
        }
    }

    public boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public void setContext(Activity context) {
        this.context = context;
    }

    public Activity getContext() {
        return this.context;
    }

    public List<IMARSDKListener> getAllListeners() {
        return this.listeners;
    }

    public void onResult(int code, final String msg) {
        Log.d(TAG, "onResult in MARSDK. code:" + code + ";msg:" + msg);
        if (getGameType() == 1 && (code == 2 || code == 1)) {
            if (this.initFinish) {
                Log.d(TAG, "inner init finish");
                initCB(msg);
                return;
            } else {
                waitInitResult(new InitCallBack() { // from class: com.mar.sdk.MARSDK.3
                    @Override // com.mar.sdk.platform.InitCallBack
                    public void onInitFinish() {
                        Log.d(MARSDK.TAG, "inner init finish now");
                        MARSDK.this.initCB(msg);
                    }
                });
                Log.d(TAG, "wait inner init finish");
                return;
            }
        }
        if (MggControl.getInstance().getSaveFlagType() == 4 && code == 100) {
            MggControl.getInstance().resetSaveFlagType();
        } else if (!this.listeners.isEmpty()) {
            for (IMARSDKListener listener : this.listeners) {
                listener.onResult(code, msg);
            }
        }
    }

    public void setAdListener(IAdResult adResult) {
        if (!this.adListeners.contains(adResult) && adResult != null) {
            this.adListeners.add(adResult);
        }
    }

    public void onAdResult(int code, AdEvent event) {
        Log.d(TAG, "onAdResult in MARSDK. code:" + code + ";event:" + event.toString());
        for (IAdResult result : this.adListeners) {
            result.onAdResult(code, event);
        }
    }

    public void setADGameEvens(IAdGameEvent iAdGameEvent) {
        if (!this.iAdGameEventList.contains(iAdGameEvent) && iAdGameEvent != null) {
            this.iAdGameEventList.add(iAdGameEvent);
        }
    }

    public void onADGameEvens(AdEvent.AdType adType, String json) {
        Log.d(TAG, "onADGameEvens in MARSDK. adType:" + adType.name() + ";json:" + json);
        for (IAdGameEvent result : this.iAdGameEventList) {
            result.onAdGameEvent(adType, json);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCB(String msg) {
        for (IMARSDKListener listener : this.listeners) {
            listener.onResult((getFreeStyle() || this.initResult != null) ? 1 : 2, msg);
        }
    }

    private void waitInitResult(InitCallBack initCallBack) {
        this.initCallBack = initCallBack;
    }

    public void onPayQuery(String orderId) {
        if (orderId != null && !orderId.isEmpty()) {
            MARPayVerify.getInstance().payQueryTask(orderId);
        }
    }

    public void onPayResult(final int code, String msg) {
        runOnMainThread(new Runnable() { // from class: com.mar.sdk.MARSDK.4
            @Override // java.lang.Runnable
            public void run() {
                String orderId = "";
                String productId = "";
                if (MARPay.getInstance().getCurrPayParams() != null) {
                    PayParams payParams = MARPay.getInstance().getCurrPayParams();
                    String cpProductId = payParams.getCpProductId();
                    orderId = payParams.getOrderID();
                    productId = (cpProductId == null || cpProductId.equals("")) ? payParams.getProductId() : cpProductId;
                    if (code == 10) {
                        try {
                            Log.d(MARSDK.TAG, "onPayResult UmPurchase:" + payParams.toString());
                            SDKParams params = new SDKParams();
                            params.put(IAction.PurchaseKey.OrderID, orderId);
                            params.put(IAction.PurchaseKey.PayType, "default");
                            params.put("currency", "CNY");
                            params.put(IAction.PurchaseKey.Price, payParams.getPrice() + "");
                            params.put(IAction.PurchaseKey.ProductNum, "1");
                            params.put(IAction.PurchaseKey.ProductID, productId);
                            params.put(IAction.PurchaseKey.ProductName, payParams.getProductName());
                            params.put(IAction.PurchaseKey.ProductType, "default");
                            MARPlatform.getInstance().UmPurchase(params);
                        } catch (Exception e) {
                            Log.d(MARSDK.TAG, "onPayResult UmPurchase Exception:" + e.toString());
                        }
                    }
                }
                Log.d(MARSDK.TAG, "onPayResult code:" + code + "==orderId:" + orderId + "===productId:" + productId);
                if (MARSDK.this.isSingleGame()) {
                    MARPayVerify.getInstance().handleResult(code, orderId);
                } else {
                    MARPayVerify.getInstance().handleResult(code, orderId, productId);
                }
            }
        });
    }

    public void onRedeemResult(String data) {
        for (IMARSDKListener listener : this.listeners) {
            listener.onRedeemResult(data);
        }
    }

    public void onLoginResult(String result) {
        for (IMARSDKListener listener : this.listeners) {
            listener.onLoginResult(result);
        }
        if (isAuth()) {
            startAuthTask(result);
        }
    }

    public void onSwitchAccount(String result) {
        for (IMARSDKListener listener : this.listeners) {
            listener.onSwitchAccount(result);
        }
        if (isAuth()) {
            startAuthTask(result);
        }
    }

    public void onLogout() {
        for (IMARSDKListener listener : this.listeners) {
            listener.onLogout();
        }
    }

    public void onAuthnVisitor(UToken token) {
        onAuthResult(token);
    }

    private void onAuthResult(UToken token) {
        MARUser.logging = false;
        if (token.isSuc()) {
            this.sdkUserID = token.getSdkUserID();
            this.tokenData = token;
            this.serverToken = token.getToken();
            this.severUserID = token.getUserID();
            SDKParams params = new SDKParams();
            params.put("userID", token.getUserID() + "");
            params.put("method", "default");
            MARPlatform.getInstance().UmLoginEvent(params);
            Log.d(TAG, "onAuthResult  UmLoginEvent:" + params.toString());
            if (!TextUtils.isEmpty(this.severUserID.trim())) {
                GUtils.setServiceUserId(this.context, this.severUserID);
            }
            if (isSingleGame() && getGameType() != 1) {
                runOnMainThread(new Runnable() { // from class: com.mar.sdk.MARSDK.5
                    @Override // java.lang.Runnable
                    public void run() {
                        MARUser.getInstance().checkServiceFailOrders();
                        new Handler().postDelayed(new Runnable() { // from class: com.mar.sdk.MARSDK.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MARPay.getInstance().checkFailedOrders();
                            }
                        }, 1000L);
                    }
                });
            }
            runOnMainThread(new Runnable() { // from class: com.mar.sdk.MARSDK.6
                @Override // java.lang.Runnable
                public void run() {
                    MARSDK.this.getPrivacy();
                }
            });
        }
        for (IMARSDKListener listener : this.listeners) {
            listener.onAuthResult(token);
        }
    }

    public void onPayResultBack(int code, String msg) {
        for (IMARSDKListener listener : this.listeners) {
            listener.onPayResult(code, msg);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.activityCallbacks != null) {
            for (IActivityCallback callback : this.activityCallbacks) {
                callback.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    public void onBackPressed() {
        if (this.activityCallbacks != null) {
            for (IActivityCallback callback : this.activityCallbacks) {
                callback.onBackPressed();
            }
        }
    }

    public void onCreate() {
        if (this.activityCallbacks != null) {
            for (IActivityCallback callback : this.activityCallbacks) {
                callback.onCreate();
            }
        }
    }

    public void onStart() {
        if (this.activityCallbacks != null) {
            for (IActivityCallback callback : this.activityCallbacks) {
                callback.onStart();
            }
        }
    }

    public void onPause() {
        if (this.activityCallbacks != null) {
            for (IActivityCallback callback : this.activityCallbacks) {
                callback.onPause();
            }
        }
        this.isMainRun = false;
    }

    public void onResume() {
        if (MARAutoPermission.getInstance().isDirectPermission()) {
            if (MARAutoPermission.getInstance().isJumpingPermission()) {
                Log.d(TAG, "permission return from permission page. request again to check permission");
                MARAutoPermission.getInstance().requestDangerousPermissions(getInstance().getContext(), new IAutoPermissionListener() { // from class: com.mar.sdk.MARSDK.7
                    @Override // com.mar.sdk.permission.IAutoPermissionListener
                    public void onAutoPermissionSuccess() {
                        MARSDK.this.doInit(MARSDK.getInstance().getContext());
                    }

                    @Override // com.mar.sdk.permission.IAutoPermissionListener
                    public void onAutoPermissionFailed(String[] deniedPermissions, String[] deniedForeverPermissions) {
                        Log.e(MARSDK.TAG, "marsdk with auto permission failed.");
                        MARSDK.this.doInit(MARSDK.getInstance().getContext());
                    }
                });
                return;
            } else if (MARAutoPermission.getInstance().isJumpingWriteSettings()) {
                Log.d(TAG, "permission return from write settings page. request again to check permission");
                MARAutoPermission.getInstance().requestWriteSettings(getInstance().getContext());
                return;
            }
        }
        if (this.activityCallbacks != null) {
            for (IActivityCallback callback : this.activityCallbacks) {
                callback.onResume();
            }
        }
        this.isMainRun = true;
    }

    public void onNewIntent(Intent newIntent) {
        if (this.activityCallbacks != null) {
            for (IActivityCallback callback : this.activityCallbacks) {
                callback.onNewIntent(newIntent);
            }
        }
    }

    public void onStop() {
        if (this.activityCallbacks != null) {
            for (IActivityCallback callback : this.activityCallbacks) {
                callback.onStop();
            }
        }
    }

    public void onDestroy() {
        if (this.activityCallbacks != null) {
            for (IActivityCallback callback : this.activityCallbacks) {
                callback.onDestroy();
            }
        }
    }

    public void onRestart() {
        if (this.activityCallbacks != null) {
            for (IActivityCallback callback : this.activityCallbacks) {
                callback.onRestart();
            }
        }
    }

    public void attachBaseContext(Activity activity, Context newBase) {
        this.context = activity;
        if (this.activityCallbacks != null) {
            for (IActivityCallback callback : this.activityCallbacks) {
                callback.attachBaseContext(newBase);
            }
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (this.activityCallbacks != null) {
            for (IActivityCallback callback : this.activityCallbacks) {
                callback.onConfigurationChanged(newConfig);
            }
        }
    }

    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) {
        if (MARAutoPermission.getInstance().isDirectPermission()) {
            MARAutoPermission.getInstance().onRequestPermissionsResult(this.context, requestCode, permissions, grantResults);
        }
        if (this.activityCallbacks != null) {
            for (IActivityCallback callback : this.activityCallbacks) {
                callback.onRequestPermissionResult(requestCode, permissions, grantResults);
            }
        }
    }

    private void startAuthTask(String result) {
        Log.d(TAG, "begin to startAuthTask...");
        UToken uToken = MARProxy.auth(result);
        if (uToken == null || uToken.getUserID() == null) {
            onResult(5, "login http fail...........");
        } else {
            MARUser.logging = true;
            onAuthResult(uToken);
        }
    }

    public InitResult getInitResult() {
        return this.initResult;
    }

    public void initPrivacyFloat(final UPrivacy uPrivacyBean) {
        if (uPrivacyBean == null) {
            Log.e(TAG, "initPrivacyFloat UPrivacy is null");
        } else {
            this.floatPrivacyWindow = new FloatPrivacyWindow(this.context, 1, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX, uPrivacyBean.getIcon(), new FloatPrivacyWindow.IOnItemClicked() { // from class: com.mar.sdk.MARSDK.8
                @Override // com.mar.sdk.privacy.FloatPrivacyWindow.IOnItemClicked
                public void onBackItemClick() {
                    PrivacyDialog dialog = new PrivacyDialog(MARSDK.this.context, uPrivacyBean);
                    dialog.show();
                    MARSDK.this.floatPrivacyWindow.setExpandedHasOperator(true);
                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mar.sdk.MARSDK.8.1
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialog2) {
                            MARSDK.this.floatPrivacyWindow.setExpandedHasOperator(false);
                        }
                    });
                }

                @Override // com.mar.sdk.privacy.FloatPrivacyWindow.IOnItemClicked
                public void onCloseItemClick() {
                }

                @Override // com.mar.sdk.privacy.FloatPrivacyWindow.IOnItemClicked
                public void onClose() {
                }

                @Override // com.mar.sdk.privacy.FloatPrivacyWindow.IOnItemClicked
                public void onExpand() {
                }
            });
        }
    }

    public void getPrivacy() {
        UPrivacy uPrivacy;
        String icon;
        try {
            if (SDKTools.isNetworkAvailable(this.context) && (icon = (uPrivacy = MARProxy.getPrivacy()).getIcon()) != null && !icon.equals("")) {
                if (uPrivacy.isFloatingSwitch()) {
                    if (this.floatPrivacyWindow == null) {
                        initPrivacyFloat(uPrivacy);
                    }
                    this.floatPrivacyWindow.show();
                    return;
                }
                return;
            }
            Log.d(TAG, "getPrivacy " + (!SDKTools.isNetworkAvailable(this.context) ? "无网" : "后台没配置"));
            SDKParams params = getSDKParams();
            String text = params.contains("PRIVACYFLOAT_TXT") ? params.getString("PRIVACYFLOAT_TXT") : "";
            if (text == null || "".equals(text)) {
                Log.e(TAG, "getPrivacy PRIVACYFLOAT_TXT is null");
                return;
            }
            UPrivacy uPrivacy2 = new UPrivacy();
            uPrivacy2.setPrivacyAgreementPath("file:///android_asset/yszc.html");
            uPrivacy2.setUserAgreementPath("file:///android_asset/userAgreement.html");
            uPrivacy2.setContent(text);
            uPrivacy2.setIcon("");
            if (this.floatPrivacyWindow == null) {
                initPrivacyFloat(uPrivacy2);
            }
            this.floatPrivacyWindow.show();
        } catch (Exception e) {
            Log.e(TAG, "getPrivacy  Exception:" + e.toString());
        }
    }

    public void deregister() {
        if (TextUtils.isEmpty(this.serverToken)) {
            Toast.makeText(this.context, "当前未登录", 0).show();
        } else {
            DeregisterDialog deregisterDialog = new DeregisterDialog(this.context);
            deregisterDialog.show();
        }
    }

    public void setPluginListener(IPluginListener listener) {
        this.pluginListener = listener;
    }

    public IPluginListener getPluginListener() {
        return this.pluginListener;
    }

    @Deprecated
    public void getNetworkTime(INetworkTimeListener listener) {
        if (listener == null) {
            Log.d(TAG, "INetworkTimeListener can not null");
        } else {
            listener.onSuccess(getNetworkTime());
        }
    }

    public long getNetworkTime() {
        long time = MARHttp.getNetworkTime();
        return time > 0 ? time : System.currentTimeMillis();
    }

    public String getSeverUserID() {
        if (TextUtils.isEmpty(this.severUserID.trim())) {
            this.severUserID = GUtils.getServiceUserId(this.context);
        }
        return this.severUserID;
    }

    public void setSeverUserID(String severUserID) {
        this.severUserID = severUserID;
    }

    public String getServerToken() {
        return this.serverToken;
    }

    public void setServerToken(String serverToken) {
        this.serverToken = serverToken;
    }

    public boolean getMainRunFlag() {
        return this.isMainRun;
    }

    public void openAppStore() {
        try {
            String appStorePkg = getAppstorePkg();
            if (appStorePkg.isEmpty()) {
                openDefaultAppStore();
            } else {
                Uri uri = Uri.parse(BaseConstants.MARKET_PREFIX + this.context.getPackageName());
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                intent.setPackage(appStorePkg);
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
                this.context.startActivity(intent);
            }
        } catch (Exception e) {
            openDefaultAppStore();
            e.printStackTrace();
        }
    }

    private void openDefaultAppStore() {
        Uri uri = Uri.parse(BaseConstants.MARKET_PREFIX + this.context.getPackageName());
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        this.context.startActivity(intent);
    }

    private int getChan() {
        String cId = getCurrChannel() + "";
        String chan = cId.substring(4);
        return Integer.parseInt(chan);
    }

    private String getAppstorePkg() {
        int chan = getChan();
        switch (chan) {
            case 1001:
                return "cn.ninegame.gamemanager";
            case 1003:
                return "com.qihoo.appstore";
            case 1004:
                return "com.baidu.appsearch";
            case 1005:
                return "com.xiaomi.market";
            case 1006:
                return "com.m4399.gamecenter";
            case 1007:
                return "";
            case 1008:
                return "com.bbk.appstore";
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                return "com.huawei.appmarket";
            case 1041:
                return "com.tencent.android.qqdownloader";
            case 1131:
                return "";
            case 1208:
                return "com.meta.box";
            case 1239:
                return SysExtKt.PACKAGE_NAME_CN;
            default:
                return "";
        }
    }

    public void installApk(String apkpath) {
        try {
            if (MARTool.getInstance().getPlug() == null) {
                Log.d(TAG, "安装apk--未找到插件");
            } else {
                MARTool.getInstance().getPlug().installApk(apkpath);
            }
        } catch (Exception e) {
            Log.d(TAG, "安装apk调用异常" + e.toString());
        }
    }

    public void unloadApk(String pkgName) {
        try {
            if (MARTool.getInstance().getPlug() == null) {
                Log.d(TAG, "卸载apk--未找到插件");
            } else {
                MARTool.getInstance().getPlug().unloadApk(pkgName);
            }
        } catch (Exception e) {
            Log.d(TAG, "卸载apk调用异常" + e.toString());
        }
    }

    public void setCheckDRM(int drmtypes) {
        this.drmtype = drmtypes;
        Log.d(TAG, "DRM setCheckDRM" + drmtypes);
    }

    public int getCheckDRM() {
        Log.d(TAG, "DRM getCheckDRM" + this.drmtype);
        return this.drmtype;
    }
}
