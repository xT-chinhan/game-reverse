package com.mar.sdk;

import android.text.TextUtils;
import com.mar.sdk.base.IMARSDKListener;
import com.mar.sdk.log.Log;
import com.mar.sdk.verify.UToken;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UMAnalyticsSDK {
    private static UMAnalyticsSDK instance;
    private String umeng_app_key;
    private String umeng_app_channel = "_default";
    private boolean log = false;

    private UMAnalyticsSDK() {
    }

    public static UMAnalyticsSDK getInstance() {
        if (instance == null) {
            instance = new UMAnalyticsSDK();
        }
        return instance;
    }

    public void initSDKInApplication(SDKParams params) {
        parseSDKParams(params);
    }

    public void parseSDKParams(SDKParams params) {
        if (params == null) {
            return;
        }
        this.umeng_app_key = params.contains("UMENG_APPKEY") ? params.getString("UMENG_APPKEY") : "";
        this.umeng_app_channel = params.contains("UMENG_CHANNEL") ? params.getString("UMENG_CHANNEL") : "_default";
        this.log = params.contains("UMENG_TEST") ? params.getBoolean("UMENG_TEST").booleanValue() : false;
        if (!TextUtils.isEmpty(this.umeng_app_key)) {
            UMConfigure.setLogEnabled(this.log);
            UMConfigure.preInit(MARSDK.getInstance().getApplication(), this.umeng_app_key, this.umeng_app_channel);
        }
    }

    public void initSDK() {
        MARSDK.getInstance().setActivityCallback(new ActivityCallbackAdapter() { // from class: com.mar.sdk.UMAnalyticsSDK.1
            @Override // com.mar.sdk.ActivityCallbackAdapter, com.mar.sdk.base.IActivityCallback
            public void onCreate() {
                if (!TextUtils.isEmpty(UMAnalyticsSDK.this.umeng_app_key)) {
                    Log.d("MARSDK", "um sdk init");
                    UMConfigure.init(MARSDK.getInstance().getApplication(), UMAnalyticsSDK.this.umeng_app_key, UMAnalyticsSDK.this.umeng_app_channel, 1, "");
                    MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
                    UMConfigure.setProcessEvent(true);
                }
            }
        });
        MARSDK.getInstance().setSDKListener(new IMARSDKListener() { // from class: com.mar.sdk.UMAnalyticsSDK.2
            @Override // com.mar.sdk.base.IMARSDKListener
            public void onResult(int code, String msg) {
                if (code == 40) {
                    MobclickAgent.onKillProcess(MARSDK.getInstance().getContext());
                }
            }

            @Override // com.mar.sdk.base.IMARSDKListener
            public void onPayResult(int code, String msg) {
            }

            @Override // com.mar.sdk.base.IMARSDKListener
            public void onLoginResult(String data) {
            }

            @Override // com.mar.sdk.base.IMARSDKListener
            public void onSwitchAccount(String data) {
            }

            @Override // com.mar.sdk.base.IMARSDKListener
            public void onLogout() {
            }

            @Override // com.mar.sdk.base.IMARSDKListener
            public void onAuthResult(UToken authResult) {
            }

            @Override // com.mar.sdk.base.IMARSDKListener
            public void onRedeemResult(String data) {
            }
        });
    }

    public void pay(double money, int num) {
    }

    public void buy(String item, int num, double price) {
    }

    public void startLevel(String level) {
    }

    public void failLevel(String level) {
    }

    public void finishLevel(String level) {
    }

    public void levelup(int level) {
    }

    public void customEvent(String eventName, Map<String, String> map) throws Throwable {
        Map<String, Object> data = getMobclickAgentEventMap(map);
        Log.d("MARSDK", " um custom event:" + eventName + "--" + data);
        MobclickAgent.onEventObject(MARSDK.getInstance().getContext(), eventName, data);
    }

    private Map<String, Object> getMobclickAgentEventMap(Map<String, String> var1) {
        Map<String, Object> map = new HashMap<>();
        if (var1 == null || var1.size() <= 0) {
            map.put("game", Integer.valueOf(MARSDK.getInstance().getAppID()));
            return map;
        }
        for (String var2 : var1.keySet()) {
            map.put(var2, var1.get(var2));
        }
        return map;
    }
}
