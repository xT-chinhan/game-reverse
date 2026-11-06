package com.umeng.commonsdk.deeplink;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeepLinkCache.java */
/* JADX INFO: loaded from: classes4.dex */
final class d {
    private d() {
    }

    static void a(Context context, JSONObject jSONObject, String str) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                jSONObject2.put("install_params", jSONObject);
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("install_path", str);
            }
            if (jSONObject2.length() <= 0 || (sharedPreferences = PreferenceWrapper.getDefault(context.getApplicationContext())) == null) {
                return;
            }
            sharedPreferences.edit().putString("umdeeplink_install_cache", jSONObject2.toString()).commit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] cache saved: " + jSONObject2.toString());
        } catch (Throwable unused) {
        }
    }

    static Map<String, Object> a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context.getApplicationContext());
            if (sharedPreferences == null) {
                return null;
            }
            String string = sharedPreferences.getString("umdeeplink_install_cache", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.length() == 0) {
                return null;
            }
            HashMap map = new HashMap();
            if (jSONObject.has("install_params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("install_params");
                HashMap map2 = new HashMap();
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map2.put(next, jSONObject2.opt(next));
                }
                map.put("install_params", map2);
            }
            if (jSONObject.has("install_path")) {
                map.put("install_path", jSONObject.getString("install_path"));
            }
            if (map.isEmpty()) {
                return null;
            }
            return map;
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [deeplink] cache read error: " + th.getMessage());
            return null;
        }
    }

    static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context.getApplicationContext());
            if (sharedPreferences == null) {
                return false;
            }
            return !TextUtils.isEmpty(sharedPreferences.getString("umdeeplink_install_cache", ""));
        } catch (Throwable unused) {
            return false;
        }
    }
}
