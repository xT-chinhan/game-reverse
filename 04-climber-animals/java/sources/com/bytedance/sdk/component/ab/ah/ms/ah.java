package com.bytedance.sdk.component.ab.ah.ms;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> f745ms;

    private static SharedPreferences ah(String str) {
        return ((com.bytedance.sdk.component.d.xr) AutoService.ms(com.bytedance.sdk.component.d.xr.class)).ms(d(str));
    }

    private static String d(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static Object ah(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f745ms;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(d(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static void xr(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f745ms;
        if (softReference == null || softReference.get() == null) {
            f745ms = new SoftReference<>(new ConcurrentHashMap());
        }
        String strD = d(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = f745ms.get();
        if (concurrentHashMap.get(strD) == null) {
            concurrentHashMap.put(strD, new HashMap());
        }
        concurrentHashMap.get(strD).put(str2, obj);
    }

    private static void ka(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f745ms;
        if (softReference == null || softReference.get() == null || (map = f745ms.get().get(d(str))) == null) {
            return;
        }
        map.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static synchronized <T> void ms(String str, String str2, T t) {
        SharedPreferences sharedPreferencesAh = ah(str);
        if (sharedPreferencesAh == null) {
            return;
        }
        if (t.equals(ah(str, str2))) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesAh.edit();
        if (t instanceof Boolean) {
            editorEdit.putBoolean(str2, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            editorEdit.putString(str2, (String) t);
        }
        if (t instanceof Integer) {
            editorEdit.putInt(str2, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            editorEdit.putLong(str2, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            editorEdit.putFloat(str2, ((Float) t).floatValue());
        }
        editorEdit.apply();
        xr(str, str2, t);
    }

    static String ms(String str, String str2, String str3) {
        Object objAh = ah(str, str2);
        if (objAh != null) {
            return String.valueOf(objAh);
        }
        Object objXr = xr(str, str2, str3);
        xr(str, str2, objXr);
        return String.valueOf(objXr);
    }

    private static Object xr(String str, String str2, String str3) {
        String strD = d(str);
        if (!ms(strD, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase("string")) {
            return ah(strD, str2, null);
        }
        if (str3.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(ms(strD, str2, false));
        }
        if (str3.equalsIgnoreCase(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
            return Integer.valueOf(ms(strD, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(ms(strD, str2, 0L));
        }
        if (str3.equalsIgnoreCase("float")) {
            return Float.valueOf(ms(strD, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return ah(strD, str2, null);
        }
        return null;
    }

    private static String ah(String str, String str2, String str3) {
        SharedPreferences sharedPreferencesAh = ah(str);
        return sharedPreferencesAh == null ? str3 : sharedPreferencesAh.getString(str2, str3);
    }

    private static int ms(String str, String str2, int i) {
        SharedPreferences sharedPreferencesAh = ah(str);
        return sharedPreferencesAh == null ? i : sharedPreferencesAh.getInt(str2, i);
    }

    private static float ms(String str, String str2, float f) {
        SharedPreferences sharedPreferencesAh = ah(str);
        return sharedPreferencesAh == null ? f : sharedPreferencesAh.getFloat(str2, f);
    }

    private static boolean ms(String str, String str2, boolean z) {
        SharedPreferences sharedPreferencesAh = ah(str);
        return sharedPreferencesAh == null ? z : sharedPreferencesAh.getBoolean(str2, z);
    }

    private static long ms(String str, String str2, long j) {
        SharedPreferences sharedPreferencesAh = ah(str);
        return sharedPreferencesAh == null ? j : sharedPreferencesAh.getLong(str2, j);
    }

    static boolean ms(String str, String str2) {
        SharedPreferences sharedPreferencesAh = ah(str);
        return sharedPreferencesAh != null && sharedPreferencesAh.contains(str2);
    }

    static void xr(String str, String str2) {
        Map<String, Object> map;
        try {
            SharedPreferences sharedPreferencesAh = ah(str);
            if (sharedPreferencesAh == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesAh.edit();
            editorEdit.remove(str2);
            editorEdit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f745ms;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            String strD = d(str);
            if (!TextUtils.isEmpty(strD) && (map = f745ms.get().get(strD)) != null && map.size() != 0) {
                map.remove(str2);
                SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference2 = f745ms;
                if (softReference2 == null || softReference2.get() == null) {
                    return;
                }
                f745ms.get().put(strD, map);
            }
        } catch (Throwable unused) {
        }
    }

    static void ms(String str) {
        SharedPreferences.Editor editorEdit = ah(str).edit();
        editorEdit.clear();
        editorEdit.apply();
        ka(str);
    }

    static Map<String, ?> xr(String str) {
        return ah(str).getAll();
    }
}
