package com.mar.sdk.plugin;

import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.mar.sdk.IUser;
import com.mar.sdk.MARPayVerify;
import com.mar.sdk.MARSDK;
import com.mar.sdk.PayParams;
import com.mar.sdk.SDKTools;
import com.mar.sdk.UserExtraData;
import com.mar.sdk.base.PluginFactory;
import com.mar.sdk.gg.MARGgPlatform;
import com.mar.sdk.gg.control.MggControl;
import com.mar.sdk.permission.INetworkListener;
import com.mar.sdk.permission.MARNetworkDialog;
import com.mar.sdk.platform.MARPlatform;
import com.mar.sdk.verify.MARProxy;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MARUser {
    private static MARUser instance;
    private boolean clickBack;
    private IUser userPlugin;
    public static boolean logging = false;
    public static boolean inited = false;

    private MARUser() {
    }

    public void init() {
        this.userPlugin = (IUser) PluginFactory.getInstance().initPlugin(1);
    }

    public static void sdkInited() {
        inited = true;
        if (logging) {
            logging = false;
            getInstance().login();
        }
    }

    public static MARUser getInstance() {
        if (instance == null) {
            instance = new MARUser();
        }
        return instance;
    }

    public IUser getPlug() {
        return this.userPlugin;
    }

    public void setPlug(IUser plug) {
        this.userPlugin = plug;
    }

    public boolean isSupport(String method) {
        if (this.userPlugin == null) {
            return false;
        }
        return this.userPlugin.isSupportMethod(method);
    }

    public void login() {
        if (this.userPlugin != null) {
            Log.d("MARSDK", "marsdk begin to call login...");
            if (logging || !inited) {
                logging = true;
                Log.d("MARSDK", "login in now, please do not click again");
                return;
            }
            if (!SDKTools.isNetworkAvailable(MARSDK.getInstance().getContext()) && !MARSDK.getInstance().getFreeStyle() && MARSDK.getInstance().getGameType() != 1) {
                MARNetworkDialog.showDialog(MARSDK.getInstance().getContext(), true, new INetworkListener() { // from class: com.mar.sdk.plugin.MARUser.1
                    @Override // com.mar.sdk.permission.INetworkListener
                    public void retry() {
                        MARUser.this.login();
                    }

                    @Override // com.mar.sdk.permission.INetworkListener
                    public void exit() {
                        MARSDK.getInstance().getContext().finish();
                        System.exit(0);
                    }
                });
                return;
            }
            logging = true;
            if (!this.userPlugin.isSupportMethod("customSkipLogin") && MggControl.getInstance().isDisableRealnameSwitch()) {
                MARPlatform.getInstance().visitorLogin();
                Log.d("MARSDK", "use visitor login");
            } else {
                this.userPlugin.login();
            }
        }
    }

    public void login(String customData) {
        if (this.userPlugin != null) {
            this.userPlugin.loginCustom(customData);
        }
    }

    public void switchLogin() {
        if (this.userPlugin != null) {
            this.userPlugin.switchLogin();
        }
    }

    public void showAccountCenter() {
        if (this.userPlugin != null) {
            this.userPlugin.showAccountCenter();
        }
    }

    public void logout() {
        if (this.userPlugin != null) {
            this.userPlugin.logout();
        }
    }

    public void submitExtraData(UserExtraData extraData) {
        if (this.userPlugin != null) {
            if (!MARSDK.getInstance().isSingleGame()) {
                submitData(extraData);
            }
            this.userPlugin.submitExtraData(extraData);
        }
    }

    public void exit() {
        if (this.userPlugin != null) {
            if (!this.clickBack) {
                this.clickBack = true;
                if (MARGgPlatform.getInstance().isAndroidKeyBackFlag()) {
                    MARGgPlatform.getInstance().backKeyShowSplash();
                    return;
                }
            }
            this.userPlugin.exit();
        }
    }

    public void postGiftCode(String code) {
        if (this.userPlugin != null) {
            this.userPlugin.postGiftCode(code);
        }
    }

    public void queryAntiAddiction() {
        if (this.userPlugin != null) {
            this.userPlugin.queryAntiAddiction();
        }
    }

    public void updateApk() {
        if (this.userPlugin != null) {
            this.userPlugin.updateApk();
        }
    }

    public void realNameRegister() {
        if (this.userPlugin != null) {
            this.userPlugin.realNameRegister();
        }
    }

    private void submitData(UserExtraData userExtraData) {
        Log.d("MARSDK", "start submit user data");
        if (userExtraData != null) {
            SubmitData submitData = new SubmitData();
            submitData.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, userExtraData);
        }
    }

    class SubmitData extends AsyncTask<UserExtraData, Void, Boolean> {
        SubmitData() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(UserExtraData... userExtraData) {
            return Boolean.valueOf(MARProxy.submitUserData(userExtraData[0]));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean aBoolean) {
            if (aBoolean.booleanValue()) {
                Log.d("MARSDK", "submit user data suc");
            }
        }
    }

    public void postRedeemCode(String code) {
        if (TextUtils.isEmpty(code)) {
            Log.d("MARSDK", "code is null");
            RedeemFail();
            return;
        }
        if (isSupport("postRedeemCode")) {
            this.userPlugin.postGiftCode(code);
            return;
        }
        String giftCode = code.trim();
        int len = giftCode.length();
        Log.d("MARSDK", "postRedeemCode: len:" + len);
        if (giftCode.length() == 8) {
            GetGiftTask authTask = new GetGiftTask(giftCode);
            authTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            RedeemFail();
        }
    }

    private void RedeemFail() {
        JSONObject js = new JSONObject();
        try {
            js.put("propNumber", 0);
            js.put("propType", 0);
            js.put(NotificationCompat.CATEGORY_MESSAGE, "兑换码错误,请输入8位兑换码!");
            MARSDK.getInstance().onRedeemResult(js.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    class GetGiftTask extends AsyncTask<Void, Void, String> {
        private String code;

        public GetGiftTask(String code) {
            this.code = code;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... args) {
            Log.d("MARSDK", "begin to GetGiftTask from ascserver...");
            return MARProxy.getGiftInfo(this.code.trim());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String ret) {
            if (ret == null) {
                Log.e("MARSDK", "GetGiftTask from ascserver failed");
                JSONObject js = new JSONObject();
                try {
                    js.put("propNumber", 0);
                    js.put("propType", 0);
                    js.put(NotificationCompat.CATEGORY_MESSAGE, "兑换码不存在,请重新输入兑换码!");
                    MARSDK.getInstance().onRedeemResult(js.toString());
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            Log.e("MARSDK", "GetGiftTask msg : " + ret);
            MARSDK.getInstance().onRedeemResult(ret);
        }
    }

    public void checkServiceFailOrders() {
        Log.d("MARSDK", "checkServiceFailOrders -------------------------");
        GetFailOrders authTask = new GetFailOrders();
        authTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    class GetFailOrders extends AsyncTask<Void, Void, String> {
        public GetFailOrders() {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            Log.d("MARSDK", "before to GetFailOrders from ascserver...");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... args) {
            return MARProxy.getOrdersFailForService();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String ret) {
            if (ret != null && ret.length() > 5) {
                try {
                    JSONArray ojs = new JSONArray(ret);
                    for (int i = 0; i < ojs.length(); i++) {
                        JSONObject js = (JSONObject) ojs.get(i);
                        String orderId = js.getString("orderId");
                        String productId = js.getString(BillingClientConstants.PRODUCT_ID);
                        if (!TextUtils.isEmpty(orderId)) {
                            if (MARPayVerify.getInstance().isHaveOrderId(orderId)) {
                                Log.d("MARSDK", "orderId is have from store." + orderId);
                            } else {
                                PayParams pp1 = new PayParams();
                                pp1.setOrderID(orderId);
                                pp1.setProductId(productId);
                                MARPayVerify.getInstance().storeOrder(pp1);
                            }
                        }
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            Log.d("MARSDK", "not fail orders in service");
        }
    }
}
