package com.mar.sdk.platform;

import android.app.Activity;
import com.mar.sdk.INetworkTimeListener;
import com.mar.sdk.MARCallBack;
import com.mar.sdk.MARCloudCallBack;
import com.mar.sdk.MARPayVerify;
import com.mar.sdk.MARSDK;
import com.mar.sdk.PayParams;
import com.mar.sdk.SDKParams;
import com.mar.sdk.UserExtraData;
import com.mar.sdk.base.IMARSDKListener;
import com.mar.sdk.gg.push.CrossPushStyle;
import com.mar.sdk.gg.push.PushStyle;
import com.mar.sdk.log.Log;
import com.mar.sdk.permission.MARProtocolActivity;
import com.mar.sdk.plugin.BlockWordsCallBack;
import com.mar.sdk.plugin.MARAction;
import com.mar.sdk.plugin.MARBlockWords;
import com.mar.sdk.plugin.MARCloudArchive;
import com.mar.sdk.plugin.MARGameResource;
import com.mar.sdk.plugin.MARMutualPush;
import com.mar.sdk.plugin.MARPay;
import com.mar.sdk.plugin.MARSpecialInterface;
import com.mar.sdk.plugin.MARUser;
import com.mar.sdk.plugin.MARVisitorLogin;
import com.mar.sdk.utils.StoreUtils;
import com.mar.sdk.verify.UToken;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MARPlatform {
    private static MARPlatform instance;
    private boolean isSwitchAccount = false;

    private MARPlatform() {
    }

    public static MARPlatform getInstance() {
        if (instance == null) {
            instance = new MARPlatform();
        }
        return instance;
    }

    public void init(final Activity context, final MARInitListener callback) {
        StoreUtils.putlong(context, "init_marsdk_time", System.currentTimeMillis());
        if (callback == null) {
            Log.d("MARSDK", "MARInitListener must be not null.");
            return;
        }
        try {
            MARSDK.getInstance().setSDKListener(new IMARSDKListener() { // from class: com.mar.sdk.platform.MARPlatform.1
                @Override // com.mar.sdk.base.IMARSDKListener
                public void onResult(final int code, final String msg) {
                    Log.d("MARSDK", "onResult.code:" + code + ";msg:" + msg);
                    MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            switch (code) {
                                case 1:
                                    MARUser.sdkInited();
                                    callback.onInitResult(1, msg);
                                    break;
                                case 2:
                                    MARUser.sdkInited();
                                    callback.onInitResult(2, msg);
                                    break;
                                case 3:
                                case 4:
                                default:
                                    callback.onResult(code, msg);
                                    break;
                                case 5:
                                    MARUser.logging = false;
                                    callback.onLoginResult(5, null);
                                    MARPlatform.this.setloginEvent(TrackAction.FAIL);
                                    break;
                            }
                        }
                    });
                }

                @Override // com.mar.sdk.base.IMARSDKListener
                public void onPayResult(int code, String msg) {
                    Log.d("MARSDK", "onPayResult:" + code);
                    callback.onPayResult(code, msg);
                }

                @Override // com.mar.sdk.base.IMARSDKListener
                public void onLogout() {
                    MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onLogout();
                        }
                    });
                }

                @Override // com.mar.sdk.base.IMARSDKListener
                public void onLoginResult(String data) {
                    Log.d("MARSDK", "SDK 登录成功,不用做处理，在onAuthResult中处理登录成功, 参数如下:");
                    Log.d("MARSDK", data);
                    MARPlatform.this.isSwitchAccount = false;
                }

                @Override // com.mar.sdk.base.IMARSDKListener
                public void onSwitchAccount(String data) {
                    Log.d("MARSDK", "SDK 切换帐号并登录成功,不用做处理，在onAuthResult中处理登录成功, 参数如下:");
                    Log.d("MARSDK", data);
                    MARPlatform.this.isSwitchAccount = true;
                }

                @Override // com.mar.sdk.base.IMARSDKListener
                public void onRedeemResult(String data) {
                    Log.d("MARSDK", "redeem data: " + data);
                    callback.onRedeemResult(data);
                }

                @Override // com.mar.sdk.base.IMARSDKListener
                public void onAuthResult(final UToken authResult) {
                    MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (MARPlatform.this.isSwitchAccount) {
                                    if (authResult.isSuc()) {
                                        callback.onSwitchAccount(authResult);
                                    } else {
                                        Log.e("MARSDK", "switch account auth failed.");
                                    }
                                } else if (!authResult.isSuc()) {
                                    callback.onLoginResult(5, null);
                                    MARPlatform.this.setloginEvent(TrackAction.FAIL);
                                } else {
                                    callback.onLoginResult(4, authResult);
                                    MARPlatform.this.setloginEvent(TrackAction.SUCCESS);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
            if (MARSDK.getInstance().isMainThread()) {
                MARSDK.getInstance().init(context);
                MARSDK.getInstance().onCreate();
            } else {
                MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MARSDK.getInstance().init(context);
                        MARSDK.getInstance().onCreate();
                    }
                });
            }
        } catch (Exception e) {
            callback.onInitResult(2, e.getMessage());
            Log.e("MARSDK", "init failed.", e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setloginEvent(String statue) {
        if (statue.equals(TrackAction.START)) {
            Long init_marsdk_time = StoreUtils.getLong(MARSDK.getInstance().getContext(), "init_marsdk_time", 0L);
            SDKParams sdkParams = new SDKParams();
            sdkParams.put("config_time", init_marsdk_time.longValue());
            UmCustomEvent("marsdk_config", sdkParams);
        }
        SDKParams sdkParams2 = new SDKParams();
        sdkParams2.put("login_type", statue);
        sdkParams2.put("login_time", System.currentTimeMillis());
        UmCustomEvent("login_behavior", sdkParams2);
    }

    public void login(Activity context) {
        MARSDK.getInstance().setContext(context);
        setloginEvent(TrackAction.START);
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.3
            @Override // java.lang.Runnable
            public void run() {
                MARUser.getInstance().login();
            }
        });
    }

    public void loginCustom(Activity context, final String loginType) {
        MARSDK.getInstance().setContext(context);
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.4
            @Override // java.lang.Runnable
            public void run() {
                if (MARUser.getInstance().isSupport("loginCustom")) {
                    MARUser.getInstance().login(loginType);
                } else {
                    MARUser.getInstance().login();
                }
            }
        });
    }

    public void logout() {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.5
            @Override // java.lang.Runnable
            public void run() {
                if (MARUser.getInstance().isSupport("logout")) {
                    MARUser.getInstance().logout();
                }
            }
        });
    }

    public void deregister() {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.6
            @Override // java.lang.Runnable
            public void run() {
                MARSDK.getInstance().deregister();
            }
        });
    }

    public void switchAccount() {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.7
            @Override // java.lang.Runnable
            public void run() {
                MARUser.getInstance().switchLogin();
            }
        });
    }

    public void showAccountCenter() {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.8
            @Override // java.lang.Runnable
            public void run() {
                if (MARUser.getInstance().isSupport("showAccountCenter")) {
                    MARUser.getInstance().showAccountCenter();
                }
            }
        });
    }

    public void submitExtraData(final UserExtraData data) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.9
            @Override // java.lang.Runnable
            public void run() {
                MARUser.getInstance().submitExtraData(data);
            }
        });
    }

    public void exitSDK(final MARExitListener callback) {
        MARSDK.getInstance().getContext().runOnUiThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.10
            @Override // java.lang.Runnable
            public void run() {
                if (MARUser.getInstance().isSupport("exit")) {
                    MARUser.getInstance().exit();
                } else if (callback != null) {
                    callback.onGameExit();
                }
            }
        });
    }

    public boolean queryAntiAddiction() {
        if (!MARUser.getInstance().isSupport("queryAntiAddiction")) {
            return false;
        }
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.11
            @Override // java.lang.Runnable
            public void run() {
                MARUser.getInstance().queryAntiAddiction();
            }
        });
        return true;
    }

    public void updateApk() {
        if (MARUser.getInstance().isSupport("updateApk")) {
            MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.12
                @Override // java.lang.Runnable
                public void run() {
                    MARUser.getInstance().updateApk();
                }
            });
        }
    }

    public boolean realNameRegister() {
        if (!MARUser.getInstance().isSupport("realNameRegister")) {
            return false;
        }
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.13
            @Override // java.lang.Runnable
            public void run() {
                MARUser.getInstance().realNameRegister();
            }
        });
        return true;
    }

    public void showProtocol(Activity context) {
        MARProtocolActivity.showProtocol(context);
    }

    public void pay(Activity context, final PayParams data) {
        MARSDK.getInstance().setContext(context);
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.14
            @Override // java.lang.Runnable
            public void run() {
                MARPay.getInstance().pay(data);
            }
        });
    }

    public void setPropDeliveredComplete(final String orderID) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.15
            @Override // java.lang.Runnable
            public void run() {
                MARPayVerify.getInstance().setPropDeliveredComplete(orderID);
            }
        });
    }

    public void exchangeGift(final String code) {
        Log.d("MARSDK", "exchangeGift ===================== code :" + code);
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.16
            @Override // java.lang.Runnable
            public void run() {
                MARUser.getInstance().postRedeemCode(code);
            }
        });
    }

    public boolean isNonConsumable(String productId) {
        Log.d("MARSDK", "isNonConsumable ===================== productId :" + productId);
        return false;
    }

    public void restorePurchases(String productId) {
        Log.d("MARSDK", "restorePurchases ===================== productId :" + productId);
    }

    public void openAppStore() {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.17
            @Override // java.lang.Runnable
            public void run() {
                MARSDK.getInstance().openAppStore();
            }
        });
    }

    public boolean isSupportExit() {
        return MARUser.getInstance().isSupport("exit");
    }

    public void UmTaskLevel(final SDKParams params) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.18
            @Override // java.lang.Runnable
            public void run() {
                MARAction.getInstance().task(params);
            }
        });
    }

    public void UmLevelUp(final SDKParams params) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.19
            @Override // java.lang.Runnable
            public void run() {
                MARAction.getInstance().levelUp(params);
            }
        });
    }

    public void UmPurchase(final SDKParams params) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.20
            @Override // java.lang.Runnable
            public void run() {
                MARAction.getInstance().purchase(params);
            }
        });
    }

    public void UmBuyProp(final SDKParams params) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.21
            @Override // java.lang.Runnable
            public void run() {
                MARAction.getInstance().buy(params);
            }
        });
    }

    public void UmCustomEvent(final String eventName, final SDKParams params) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.22
            @Override // java.lang.Runnable
            public void run() {
                MARAction.getInstance().customEvent(eventName, params);
            }
        });
    }

    public void ssReportEvent(final String eventName, final JSONObject json) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.23
            @Override // java.lang.Runnable
            public void run() {
                MARAction.getInstance().reportEvent(eventName, json);
            }
        });
    }

    public void UmRegisterEvent(final SDKParams params) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.24
            @Override // java.lang.Runnable
            public void run() {
                MARAction.getInstance().register(params);
            }
        });
    }

    public void UmLoginEvent(final SDKParams params) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.25
            @Override // java.lang.Runnable
            public void run() {
                MARAction.getInstance().login(params);
            }
        });
    }

    public void setUserProperty(final String params) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.26
            @Override // java.lang.Runnable
            public void run() {
                MARAction.getInstance().setUserProperty(params);
            }
        });
    }

    public void setUserSetOnce(final String params) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.27
            @Override // java.lang.Runnable
            public void run() {
                MARAction.getInstance().setUserSetOnce(params);
            }
        });
    }

    public void setTrackUserAdd(final String params) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.28
            @Override // java.lang.Runnable
            public void run() {
                MARAction.getInstance().setTrackUserAdd(params);
            }
        });
    }

    public void setSuperProperties(final String params) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.29
            @Override // java.lang.Runnable
            public void run() {
                MARAction.getInstance().setSuperProperties(params);
            }
        });
    }

    public void callSpecailFunc(final String funcName, final SDKParams params) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.30
            @Override // java.lang.Runnable
            public void run() {
                MARSpecialInterface.getInstance().callSpecailFunc(MARSDK.getInstance().getContext(), funcName, params);
            }
        });
    }

    public void openMoment() {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.31
            @Override // java.lang.Runnable
            public void run() {
                MARSpecialInterface.getInstance().openMoment();
            }
        });
    }

    public void gotoMoreGame() {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.32
            @Override // java.lang.Runnable
            public void run() {
                MARSpecialInterface.getInstance().gotoMoreGame();
            }
        });
    }

    public void visitorLogin() {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.33
            @Override // java.lang.Runnable
            public void run() {
                MARVisitorLogin.getInstance().visitorLogin();
            }
        });
    }

    public void updateGameArchive(final String gameArchive, final int serialNumber, final MARCloudCallBack callBack) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.34
            @Override // java.lang.Runnable
            public void run() {
                MARCloudArchive.getInstance().updateGameArchive(gameArchive, serialNumber, callBack);
            }
        });
    }

    public void getGameArchive(final int serialNumber, final MARCloudCallBack callBack) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.35
            @Override // java.lang.Runnable
            public void run() {
                MARCloudArchive.getInstance().getGameArchive(serialNumber, callBack);
            }
        });
    }

    public void clearGameArchive(final int serialNumber, final MARCloudCallBack callBack) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.36
            @Override // java.lang.Runnable
            public void run() {
                MARCloudArchive.getInstance().clearGameArchive(serialNumber, callBack);
            }
        });
    }

    public void getDownloadUrl(final String gameVersion, final MARCallBack callBack) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.37
            @Override // java.lang.Runnable
            public void run() {
                MARGameResource.getInstance().getDownloadUrl(gameVersion, callBack);
            }
        });
    }

    @Deprecated
    public void getNetworkTime(INetworkTimeListener iNetworkListener) {
        MARSDK.getInstance().getNetworkTime(iNetworkListener);
    }

    public long getNetworkTime() {
        return MARSDK.getInstance().getNetworkTime();
    }

    public void getBlockedWords(final String words, final BlockWordsCallBack callBack) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.38
            @Override // java.lang.Runnable
            public void run() {
                MARBlockWords.getInstance().getBlockWords(words, callBack);
            }
        });
    }

    public void mutualPush(final PushStyle pushStyle) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.39
            @Override // java.lang.Runnable
            public void run() {
                MARMutualPush.getInstance().showGame(pushStyle);
            }
        });
    }

    public void showCrossPush(final CrossPushStyle crossPushStyle) {
        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.platform.MARPlatform.40
            @Override // java.lang.Runnable
            public void run() {
                MARMutualPush.getInstance().showCrossPush(crossPushStyle);
            }
        });
    }
}
