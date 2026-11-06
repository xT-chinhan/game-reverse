package com.umeng.umcrash.custominfo;

import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.memleaksdk.MemLeakManager;
import com.uc.crashsdk.export.CrashApi;
import com.umeng.crash.UCrash;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class UAPMCustomInfo {
    private static final String TAG = "UAPMCustomInfo";
    private static Map<String, String> sCustomInfo = new ConcurrentHashMap();

    public static void addCustomInfo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e(TAG, "addCustomInfo failed ! key or value is empty .");
            return;
        }
        if (!sCustomInfo.containsKey(str) && sCustomInfo.size() >= 10) {
            Log.e(TAG, "addCustomInfo failed ! sCustomInfo is full with 10 limit.");
        } else {
            sCustomInfo.put(str, str2);
        }
        JSONObject jSONObject = new JSONObject(sCustomInfo);
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo("um_custom_info", jSONObject.toString());
        }
        UCrash.addHeader("um_custom_info", jSONObject.toString());
        MemLeakManager.setUMCustomInfo(jSONObject.toString());
    }
}
