package com.mar.sdk.verify;

import android.annotation.SuppressLint;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.widget.Toast;
import com.mar.sdk.IAction;
import com.mar.sdk.InitResult;
import com.mar.sdk.MARSDK;
import com.mar.sdk.PayParams;
import com.mar.sdk.SDKParams;
import com.mar.sdk.SDKTools;
import com.mar.sdk.UserExtraData;
import com.mar.sdk.gg.push.GetPushConfigCB;
import com.mar.sdk.gg.push.PushConfig;
import com.mar.sdk.gg.push.PushStyle;
import com.mar.sdk.http.HttpListener;
import com.mar.sdk.http.MARHttp;
import com.mar.sdk.log.Log;
import com.mar.sdk.utils.Des3Util;
import com.mar.sdk.utils.GUtils;
import com.mar.sdk.utils.MARHttpUtils;
import com.mar.sdk.utils.PassWordCreate;
import com.mar.sdk.utils.StoreUtils;
import com.qq.e.comm.constants.ErrorCode;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MARProxy {
    public static InitResult init() {
        try {
            boolean isIpProxy = SDKTools.isProxy(MARSDK.getInstance().getContext()) || SDKTools.checkVPN(MARSDK.getInstance().getContext());
            Map<String, String> params = new HashMap<>();
            params.put("channelId", MARSDK.getInstance().getCurrChannel() + "");
            params.put("gameVersion", GUtils.getAppVersionName(MARSDK.getInstance().getContext()));
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("channelId", MARSDK.getInstance().getCurrChannel());
            PassWordCreate passWordCreate = new PassWordCreate();
            String key = passWordCreate.createPassWord(24);
            params.put("sign", key + Des3Util.encrypt(jsonObject.toString(), key));
            params.put("isIpProxy", isIpProxy + "");
            String result = MARHttp.postRequest(MARSDK.getInstance().getInitUrl(), params);
            Log.d("MARSDK", "init result is:" + result);
            return parseInitResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static InitResult parseInitResult(String s) {
        if (TextUtils.isEmpty(s)) {
            return null;
        }
        try {
            JSONObject jsonObject = new JSONObject(s);
            if (jsonObject.getInt(NotificationCompat.CATEGORY_STATUS) == 200) {
                JSONObject data = jsonObject.getJSONObject("data");
                return new InitResult(data.optLong("timeStamp"), data.optString("advertObjectId"), data.optString("ip"), data.optBoolean("disableRealnameSwitch"), data.optBoolean("rebootSkipLoginSwitch"), data.getBoolean("customSwitch"));
            }
        } catch (JSONException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @SuppressLint({"DefaultLocale"})
    public static UToken auth(String result) {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("channelId", "" + MARSDK.getInstance().getCurrChannel());
            params.put("extension", result);
            SDKParams sdkParams = MARSDK.getInstance().getSDKParams();
            if (sdkParams != null && !TextUtils.isEmpty(sdkParams.getString("MAR_AscribeTrack_CHANNELID"))) {
                String tdid = StoreUtils.getString(MARSDK.getInstance().getContext(), "trackDeviceId");
                String oaid = StoreUtils.getString(MARSDK.getInstance().getContext(), "oaid");
                if (!TextUtils.isEmpty(tdid)) {
                    oaid = tdid;
                }
                params.put("trackDeviceId", oaid);
            }
            params.put("sdkVersionCode", MARSDK.getInstance().getSDKVersionCode());
            params.put("userId", MARSDK.getInstance().getSeverUserID());
            params.put("gameVersion", GUtils.getAppVersionName(MARSDK.getInstance().getContext()));
            String authResult = MARHttp.postRequest(MARSDK.getInstance().getAuthURL(), params);
            Log.d("MARSDK", " The auth result is " + authResult);
            return parseAuthResult(authResult);
        } catch (Exception e) {
            Log.e("MARSDK", "marserver auth exception.", e);
            e.printStackTrace();
            return new UToken();
        }
    }

    public static boolean submitUserData(UserExtraData userExtraData) {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("opType", userExtraData.getDataType() + "");
            params.put("roleId", userExtraData.getRoleID());
            params.put(IAction.RoleKey.RoleLevel, userExtraData.getRoleLevel());
            params.put(IAction.RoleKey.RoleName, userExtraData.getRoleName());
            params.put("serverId", userExtraData.getServerID() + "");
            params.put(IAction.RoleKey.ServerName, userExtraData.getServerName());
            params.put("vip", userExtraData.getVip());
            String result = MARHttp.postRequest(MARSDK.getInstance().getSubmitDataURL(), MARSDK.getInstance().getServerToken(), params);
            if (result == null || TextUtils.isEmpty(result)) {
                return false;
            }
            Log.d("MARSDK", "submit data result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            return jsonObject.getInt(NotificationCompat.CATEGORY_STATUS) == 200;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static UPrivacy getPrivacy() {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("channelId", "" + MARSDK.getInstance().getCurrChannel());
            String privacyResult = MARHttp.postRequest(MARSDK.getInstance().getPrivacyURL(), MARSDK.getInstance().getServerToken(), params);
            Log.d("MARSDK", " The Privacy result is " + privacyResult);
            JSONObject jsonObject = new JSONObject(privacyResult);
            int status = jsonObject.getInt(NotificationCompat.CATEGORY_STATUS);
            if (status == 200) {
                JSONObject jData = jsonObject.getJSONObject("data");
                String icon = jData.getString("icon");
                String content = jData.getString("content");
                String privacyAgreementPath = jData.getString("privacyAgreementPath");
                String userAgreementPath = jData.getString("userAgreementPath");
                boolean floatingSwitch = jData.getBoolean("floatingSwitch");
                String appBeianCode = jData.optString("appBeianCode");
                String appBeianUrl = jData.optString("appBeianUrl");
                UPrivacy uPrivacy = new UPrivacy();
                uPrivacy.setContent(content);
                uPrivacy.setFloatingSwitch(floatingSwitch);
                uPrivacy.setIcon(icon);
                uPrivacy.setPrivacyAgreementPath(privacyAgreementPath);
                uPrivacy.setUserAgreementPath(userAgreementPath);
                uPrivacy.setAppBeianCode(appBeianCode);
                uPrivacy.setAppBeianUrl(appBeianUrl);
                return uPrivacy;
            }
            Log.d("MARSDK", "marserver privacyResult exception:" + jsonObject.getString(NotificationCompat.CATEGORY_MESSAGE));
            return new UPrivacy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UOrder getOrder(PayParams data) {
        UOrder orderResult = null;
        try {
            String userId = MARSDK.getInstance().getSeverUserID();
            if (userId == null) {
                Log.e("MARSDK", "The user not logined. the token is null");
            } else {
                Map<String, String> params = new HashMap<>();
                params.put("userId", userId);
                params.put("channelId", MARSDK.getInstance().getCurrChannel() + "");
                params.put("extension", data.getExtension());
                params.put("gameId", MARSDK.getInstance().getAppID() + "");
                params.put("gameVersion", GUtils.getAppVersionName(MARSDK.getInstance().getContext()));
                params.put("orderMoney", "" + (data.getPrice() * 100));
                params.put(BillingClientConstants.PRODUCT_ID, data.getProductId());
                params.put(IAction.PurchaseKey.ProductName, data.getProductName());
                params.put("productDesc", data.getProductDesc());
                params.put("sdkVersionCode", MARSDK.getInstance().getSDKVersionCode());
                params.put("notifyUrl", data.getPayNotifyUrl());
                params.put("roleId", data.getRoleId());
                params.put(IAction.RoleKey.RoleLevel, data.getRoleLevel() + "");
                params.put(IAction.RoleKey.RoleName, data.getRoleName());
                params.put("serverId", data.getServerId());
                params.put(IAction.RoleKey.ServerName, data.getServerName());
                params.put("vip", data.getVip());
                String orderResult2 = MARHttp.postRequest(MARSDK.getInstance().getOrderURL(), MARSDK.getInstance().getServerToken(), params);
                Log.d("MARSDK", "The order result is " + orderResult2);
                orderResult = parseOrderResult(data.getProductId(), orderResult2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderResult;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean completePay(String orderId) {
        if (orderId == null) {
            return false;
        }
        try {
            Map<String, String> params = new HashMap<>();
            params.put("userId", MARSDK.getInstance().getSeverUserID());
            params.put("channelId", "" + MARSDK.getInstance().getCurrChannel());
            params.put("orderId", orderId);
            String result = MARHttpUtils.httpPost(MARSDK.getInstance().getPayCompleteURL(), params);
            Log.d("MARSDK", "The completePay get result is " + result);
            if (result == null || TextUtils.isEmpty(result)) {
                return false;
            }
            JSONObject jsonObj = new JSONObject(result);
            int state = jsonObj.getInt(NotificationCompat.CATEGORY_STATUS);
            return state == 200;
        } catch (Exception e) {
            Log.e("MARSDK", "marserver completePay exception.", e);
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000b A[Catch: Exception -> 0x0081, TryCatch #0 {Exception -> 0x0081, blocks: (B:4:0x0003, B:8:0x0013, B:10:0x007c, B:6:0x000b), top: B:15:0x0003 }] */
    @SuppressLint({"DefaultLocale"})
    public static UCheckResult check(String orderId) {
        UCheckResult checkResult = null;
        if (orderId == null) {
            Log.d("MARSDK", "pay check orderId  is null");
        } else {
            try {
                if (orderId.equals("")) {
                    Log.d("MARSDK", "pay check orderId  is null");
                } else {
                    Map<String, String> params = new HashMap<>();
                    params.put("userId", MARSDK.getInstance().getSeverUserID());
                    params.put("channelId", "" + MARSDK.getInstance().getCurrChannel());
                    params.put("orderId", orderId);
                    String result = MARHttp.postRequest(MARSDK.getInstance().getPayCheckURL(), MARSDK.getInstance().getServerToken(), params);
                    Log.d("MARSDK", "pay check the result is " + result);
                    if (!TextUtils.isEmpty(result)) {
                        checkResult = parseCheckResult(result, orderId);
                    }
                }
            } catch (Exception e) {
                Log.e("MARSDK", "marserver check exception.", e);
                e.printStackTrace();
            }
        }
        return checkResult;
    }

    public static String getGiftInfo(String code) {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("gameId", "" + MARSDK.getInstance().getAppID());
            params.put("redeemCode", code);
            params.put("userId", MARSDK.getInstance().getSeverUserID());
            String authResult = MARHttp.postRequest(MARSDK.getInstance().getGiftURL(), MARSDK.getInstance().getServerToken(), params);
            Log.d("MARSDK", " The gift result is " + authResult);
            return parseGiftResult(authResult);
        } catch (Exception e) {
            Log.e("MARSDK", "marserver auth exception.", e);
            e.printStackTrace();
            return null;
        }
    }

    public static String getOrdersFailForService() {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("gameId", "" + MARSDK.getInstance().getAppID());
            params.put("gameVersion", GUtils.getAppVersionName(MARSDK.getInstance().getContext()));
            params.put("userId", MARSDK.getInstance().getSeverUserID());
            String orderResult = MARHttp.postRequest(MARSDK.getInstance().getOrderFail(), MARSDK.getInstance().getServerToken(), params);
            Log.d("MARSDK", " The orders Fail url result is " + orderResult);
            return parseOrdersFailResult(orderResult);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAdConfigToApp() {
        boolean isIpProxy = SDKTools.isProxy(MARSDK.getInstance().getContext()) || SDKTools.checkVPN(MARSDK.getInstance().getContext());
        Map<String, String> params = new HashMap<>();
        params.put("userId", MARSDK.getInstance().getSeverUserID());
        params.put("channelId", "" + MARSDK.getInstance().getCurrChannel());
        params.put("gameVersion", GUtils.getAppVersionName(MARSDK.getInstance().getContext()));
        params.put("isIpProxy", isIpProxy + "");
        String result = MARHttp.getRequest(MARSDK.getInstance().getAdConfigToApp(), MARSDK.getInstance().getServerToken(), params);
        Log.d("MARSDK", "ggconfig the result is " + result);
        if (result == null || TextUtils.isEmpty(result)) {
            return null;
        }
        try {
            JSONObject jsonObj = new JSONObject(result);
            int state = jsonObj.getInt(NotificationCompat.CATEGORY_STATUS);
            if (state != 200) {
                return null;
            }
            JSONObject jsonData = jsonObj.getJSONObject("data");
            return jsonData.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void getMutualConfig(final GetPushConfigCB getPushConfigCB) {
        if (getPushConfigCB == null) {
            Log.d("MARSDK", "get push config fail, call back is null");
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("channelId", "" + MARSDK.getInstance().getCurrChannel());
        MARHttp.getRequest(MARSDK.getInstance().getNavigateConfigToApp(), MARSDK.getInstance().getServerToken(), params, new HttpListener() { // from class: com.mar.sdk.verify.MARProxy.1
            @Override // com.mar.sdk.http.HttpListener
            public void onSuccess(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int status = jsonObject.getInt(NotificationCompat.CATEGORY_STATUS);
                    if (status == 200) {
                        Map<PushStyle, List<PushConfig>> configs = new HashMap<>();
                        JSONObject data = jsonObject.getJSONObject("data");
                        JSONArray gameCenter = data.getJSONArray("centerStyleList");
                        List<PushConfig> gameCenterList = MARProxy.getPushConfig(gameCenter);
                        configs.put(PushStyle.GAME_CENTER, gameCenterList);
                        JSONArray settle = data.getJSONArray("settlementStyleList");
                        List<PushConfig> settleList = MARProxy.getPushConfig(settle);
                        configs.put(PushStyle.GAME_SETTLE, settleList);
                        JSONArray exit = data.getJSONArray("logoutStyleList");
                        List<PushConfig> exitList = MARProxy.getPushConfig(exit);
                        configs.put(PushStyle.GAME_EXIT, exitList);
                        getPushConfigCB.onSuc(data.getString("settlementPosition"), configs);
                    } else {
                        getPushConfigCB.onFail();
                    }
                } catch (JSONException exception) {
                    exception.printStackTrace();
                }
            }

            @Override // com.mar.sdk.http.HttpListener
            public void onFail() {
                getPushConfigCB.onFail();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<PushConfig> getPushConfig(JSONArray jsonArray) {
        List<PushConfig> pushConfigs = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject games = jsonArray.getJSONObject(i);
                PushConfig pushConfig = new PushConfig();
                pushConfig.setPushId(games.getInt("pushId"));
                pushConfig.setGameName(games.getString("pushGameName"));
                pushConfig.setGameUrl(games.getString("pushGameUrl"));
                pushConfig.setGameIcon(games.getString("pushGamePicture"));
                pushConfig.setPackageName(games.getString(BillingClientConstants.PACKAGE_NAME));
                pushConfig.setSort(games.getInt("sort"));
                pushConfigs.add(pushConfig);
            } catch (Exception e) {
                Log.d("MARSDK", "get push config fail");
            }
        }
        return pushConfigs;
    }

    public static String setTokenActive() {
        Map<String, String> params = new HashMap<>();
        params.put("userId", MARSDK.getInstance().getSeverUserID());
        params.put("marsdkToken", "" + MARSDK.getInstance().getServerToken());
        String result = MARHttp.postRequest(MARSDK.getInstance().getTokenActive(), params);
        Log.d("MARSDK", "token the result is " + result);
        if (result == null || TextUtils.isEmpty(result)) {
            return null;
        }
        try {
            JSONObject jsonObj = new JSONObject(result);
            int state = jsonObj.getInt(NotificationCompat.CATEGORY_STATUS);
            if (state == 200) {
                return "1";
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static UToken parseAuthResult(String authResult) {
        UToken uToken;
        if (authResult == null || TextUtils.isEmpty(authResult)) {
            return new UToken();
        }
        try {
            JSONObject jsonObj = new JSONObject(authResult);
            int state = jsonObj.getInt(NotificationCompat.CATEGORY_STATUS);
            if (state != 200) {
                Log.d("MARSDK", "auth failed. the state is " + state);
                uToken = new UToken();
            } else {
                JSONObject jsonData = jsonObj.getJSONObject("data");
                uToken = new UToken(jsonData.optString("userId"), jsonData.optString("username"), jsonData.optString("nickName"), jsonData.optString("avatar"), jsonData.optString("channelUserId"), jsonData.optString("token"), jsonData.optString("extension"), jsonData.optString("timestamp"));
            }
            return uToken;
        } catch (JSONException e) {
            e.printStackTrace();
            return new UToken();
        }
    }

    private static UOrder parseOrderResult(String productID, String orderResult) {
        UOrder uOrder;
        try {
            JSONObject jsonObj = new JSONObject(orderResult);
            int state = jsonObj.getInt(NotificationCompat.CATEGORY_STATUS);
            if (state == 5003) {
                Toast.makeText(MARSDK.getInstance().getContext(), "商品ID不存在", 0).show();
                uOrder = new UOrder(5003);
            } else if (state == 5004) {
                Toast.makeText(MARSDK.getInstance().getContext(), "商品价格不匹配", 0).show();
                uOrder = new UOrder(ErrorCode.NO_AD_FILL);
            } else if (state != 200) {
                Log.d("MARSDK", "get order failed. the state is " + state);
                uOrder = null;
            } else {
                JSONObject jsonData = jsonObj.getJSONObject("data");
                uOrder = new UOrder(jsonData.getString("orderId"), jsonData.optString("extension", ""), jsonData.optString(BillingClientConstants.PRODUCT_ID, productID));
            }
            return uOrder;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static UCheckResult parseCheckResult(String result, String orderId) {
        UCheckResult uCheckResult = null;
        try {
            JSONObject jsonObj = new JSONObject(result);
            int state = jsonObj.getInt(NotificationCompat.CATEGORY_STATUS);
            if (state == 200) {
                if (jsonObj.isNull("data")) {
                    Log.d("MARSDK", "check failed. the data is null");
                } else {
                    JSONObject jsonData = jsonObj.getJSONObject("data");
                    uCheckResult = new UCheckResult(jsonData.optInt("orderState"), jsonData.optInt("pollOrderNum"), jsonData.optInt("pollOrderNumLimited", 20));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uCheckResult;
    }

    private static String parseGiftResult(String result) {
        String string = null;
        try {
            JSONObject jsonObj = new JSONObject(result);
            int state = jsonObj.getInt(NotificationCompat.CATEGORY_STATUS);
            if (state != 200) {
                Log.d("MARSDK", "get gift failed. the msg is " + jsonObj.getString(NotificationCompat.CATEGORY_MESSAGE));
            } else {
                JSONObject jsonData = jsonObj.getJSONObject("data");
                jsonData.put(NotificationCompat.CATEGORY_MESSAGE, jsonObj.getString(NotificationCompat.CATEGORY_MESSAGE));
                string = jsonData.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string;
    }

    private static String parseOrdersFailResult(String result) {
        String string = null;
        try {
            JSONObject jsonObj = new JSONObject(result);
            int state = jsonObj.getInt(NotificationCompat.CATEGORY_STATUS);
            if (state != 200) {
                Log.d("MARSDK", "get orders failed. the msg is " + jsonObj.getString(NotificationCompat.CATEGORY_MESSAGE));
            } else {
                JSONArray jsonData = jsonObj.getJSONArray("data");
                string = jsonData.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string;
    }
}
