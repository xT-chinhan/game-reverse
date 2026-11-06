package com.byazt.jc;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.vkw.lb;
import com.byazt.zs.uc;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 120, 20})
public class hn {
    public static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> pr;

    private static SharedPreferences hn(String str) {
        return ((lb) uc.pr("kv_store_factory")).pr(x(str));
    }

    private static String x(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static Object hn(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = pr;
        if (softReference != null && (concurrentHashMap = softReference.get()) != null && (map = concurrentHashMap.get(x(str))) != null) {
            return map.get(str2);
        }
        return null;
    }

    private static void hw(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = pr;
        if (softReference == null || softReference.get() == null) {
            pr = new SoftReference<>(new ConcurrentHashMap());
        }
        String strX = x(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = pr.get();
        if (concurrentHashMap.get(strX) == null) {
            concurrentHashMap.put(strX, new HashMap());
        }
        concurrentHashMap.get(strX).put(str2, obj);
    }

    private static void c(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = pr;
        if (softReference != null && softReference.get() != null && (map = pr.get().get(x(str))) != null) {
            map.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized <T> void pr(String str, String str2, T t) {
        SharedPreferences sharedPreferencesHn = hn(str);
        if (sharedPreferencesHn == null) {
            return;
        }
        if (t.equals(hn(str, str2))) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesHn.edit();
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
        hw(str, str2, t);
    }

    public static String pr(String str, String str2, String str3) {
        Object objHn = hn(str, str2);
        if (objHn != null) {
            return String.valueOf(objHn);
        }
        Object objHw = hw(str, str2, str3);
        hw(str, str2, objHw);
        return String.valueOf(objHw);
    }

    private static Object hw(String str, String str2, String str3) {
        String strX = x(str);
        if (!pr(strX, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase("string")) {
            return hn(strX, str2, null);
        }
        if (str3.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(pr(strX, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(pr(strX, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(pr(strX, str2, 0L));
        }
        if (str3.equalsIgnoreCase("float")) {
            return Float.valueOf(pr(strX, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return hn(strX, str2, null);
        }
        return null;
    }

    private static String hn(String str, String str2, String str3) {
        SharedPreferences sharedPreferencesHn = hn(str);
        return sharedPreferencesHn == null ? str3 : sharedPreferencesHn.getString(str2, str3);
    }

    private static int pr(String str, String str2, int i) {
        SharedPreferences sharedPreferencesHn = hn(str);
        return sharedPreferencesHn == null ? i : sharedPreferencesHn.getInt(str2, i);
    }

    private static float pr(String str, String str2, float f) {
        SharedPreferences sharedPreferencesHn = hn(str);
        return sharedPreferencesHn == null ? f : sharedPreferencesHn.getFloat(str2, f);
    }

    private static boolean pr(String str, String str2, boolean z) {
        SharedPreferences sharedPreferencesHn = hn(str);
        return sharedPreferencesHn == null ? z : sharedPreferencesHn.getBoolean(str2, z);
    }

    private static long pr(String str, String str2, long j) {
        SharedPreferences sharedPreferencesHn = hn(str);
        return sharedPreferencesHn == null ? j : sharedPreferencesHn.getLong(str2, j);
    }

    public static boolean pr(String str, String str2) {
        SharedPreferences sharedPreferencesHn = hn(str);
        return sharedPreferencesHn != null && sharedPreferencesHn.contains(str2);
    }

    public static void hw(String str, String str2) {
        Map<String, Object> map;
        try {
            SharedPreferences sharedPreferencesHn = hn(str);
            if (sharedPreferencesHn == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesHn.edit();
            editorEdit.remove(str2);
            editorEdit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = pr;
            if (softReference != null && softReference.get() != null) {
                String strX = x(str);
                if (!TextUtils.isEmpty(strX) && (map = pr.get().get(strX)) != null && map.size() != 0) {
                    map.remove(str2);
                    SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference2 = pr;
                    if (softReference2 != null && softReference2.get() != null) {
                        pr.get().put(strX, map);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public static void pr(String str) {
        SharedPreferences.Editor editorEdit = hn(str).edit();
        editorEdit.clear();
        editorEdit.apply();
        c(str);
    }

    public static Map<String, ?> hw(String str) {
        return hn(str).getAll();
    }
}
