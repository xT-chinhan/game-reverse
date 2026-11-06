package com.umeng.umcrash.customlog;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.bv;
import com.umeng.umcrash.UMCrashUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class UAPMCustomLogManager {
    private static final int MAX_CACHE_SIZE = 100;
    private static final int MAX_MSG_LENGTH = 2048;
    private static final int MAX_TAG_LENGTH = 64;
    private static final String TAG = "UAPMCustomLogManager";
    private static final JSONArray jsonObjects = new JSONArray();
    private static int sCacheSize = 100;

    private static boolean checkParams(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        Log.e(TAG, "tag or msg is empty");
        return false;
    }

    private static void addCustomLogs(String str, String str2, int i) {
        synchronized (UAPMCustomLogManager.class) {
            try {
                if (str.length() > 64) {
                    str = UMCrashUtils.splitByByte(str, 64);
                }
                if (str2.length() > 2048) {
                    str2 = UMCrashUtils.splitByByte(str2, 2048);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(TTDownloadField.TT_TAG, str);
                jSONObject.put("msg", str2);
                jSONObject.put(t.d, i);
                jSONObject.put(bv.aI, System.currentTimeMillis());
                jSONObject.put("pid", Process.myPid());
                jSONObject.put("tid", Process.myTid());
                JSONArray jSONArray = jsonObjects;
                if (jSONArray.length() >= sCacheSize) {
                    jSONArray.remove(0);
                    jSONArray.put(jSONObject);
                } else {
                    jSONArray.put(jSONObject);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void v(String str, String str2) {
        if (checkParams(str, str2)) {
            Log.v(str, str2);
            addCustomLogs(str, str2, 0);
        }
    }

    public static void d(String str, String str2) {
        if (checkParams(str, str2)) {
            Log.d(str, str2);
            addCustomLogs(str, str2, 1);
        }
    }

    public static void i(String str, String str2) {
        if (checkParams(str, str2)) {
            Log.i(str, str2);
            addCustomLogs(str, str2, 2);
        }
    }

    public static void w(String str, String str2) {
        if (checkParams(str, str2)) {
            Log.w(str, str2);
            addCustomLogs(str, str2, 3);
        }
    }

    public static void e(String str, String str2) {
        if (checkParams(str, str2)) {
            Log.e(str, str2);
            addCustomLogs(str, str2, 4);
        }
    }

    public static void setCache(int i) {
        if (i > 100) {
            Log.e(TAG, "size should be less than 100");
        }
        sCacheSize = Math.min(i, 100);
    }

    public static String getCustomLogs() {
        String string;
        synchronized (UAPMCustomLogManager.class) {
            try {
                string = jsonObjects.toString();
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return string;
    }
}
