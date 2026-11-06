package com.byazt.jz;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.vf.um;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2277, 8})
public class s {
    public static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> n;

    private static SharedPreferences s(String str) {
        return ((um) com.byazt.qp.q.n("kv_store_factory")).n(q(str));
    }

    private static String q(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    private static Object s(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = n;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(q(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static void qg(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = n;
        if (softReference == null || softReference.get() == null) {
            n = new SoftReference<>(new ConcurrentHashMap());
        }
        String strQ = q(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = n.get();
        if (concurrentHashMap.get(strQ) == null) {
            concurrentHashMap.put(strQ, new HashMap());
        }
        concurrentHashMap.get(strQ).put(str2, obj);
    }

    private static void l(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = n;
        if (softReference == null || softReference.get() == null || (map = n.get().get(q(str))) == null) {
            return;
        }
        map.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized <T> void n(String str, String str2, T t) {
        SharedPreferences sharedPreferencesS = s(str);
        if (sharedPreferencesS == null) {
            return;
        }
        if (t.equals(s(str, str2))) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesS.edit();
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
        qg(str, str2, t);
    }

    public static String n(String str, String str2, String str3) {
        Object objS = s(str, str2);
        if (objS != null) {
            return String.valueOf(objS);
        }
        Object objQg = qg(str, str2, str3);
        qg(str, str2, objQg);
        return String.valueOf(objQg);
    }

    private static Object qg(String str, String str2, String str3) {
        String strQ = q(str);
        if (!n(strQ, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase("string")) {
            return s(strQ, str2, null);
        }
        if (str3.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(n(strQ, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(n(strQ, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(n(strQ, str2, 0L));
        }
        if (str3.equalsIgnoreCase("float")) {
            return Float.valueOf(n(strQ, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return s(strQ, str2, null);
        }
        return null;
    }

    private static String s(String str, String str2, String str3) {
        SharedPreferences sharedPreferencesS = s(str);
        return sharedPreferencesS == null ? str3 : sharedPreferencesS.getString(str2, str3);
    }

    private static int n(String str, String str2, int i) {
        SharedPreferences sharedPreferencesS = s(str);
        return sharedPreferencesS == null ? i : sharedPreferencesS.getInt(str2, i);
    }

    private static float n(String str, String str2, float f) {
        SharedPreferences sharedPreferencesS = s(str);
        return sharedPreferencesS == null ? f : sharedPreferencesS.getFloat(str2, f);
    }

    private static boolean n(String str, String str2, boolean z) {
        SharedPreferences sharedPreferencesS = s(str);
        return sharedPreferencesS == null ? z : sharedPreferencesS.getBoolean(str2, z);
    }

    private static long n(String str, String str2, long j) {
        SharedPreferences sharedPreferencesS = s(str);
        return sharedPreferencesS == null ? j : sharedPreferencesS.getLong(str2, j);
    }

    public static boolean n(String str, String str2) {
        SharedPreferences sharedPreferencesS = s(str);
        return sharedPreferencesS != null && sharedPreferencesS.contains(str2);
    }

    public static void qg(String str, String str2) {
        Map<String, Object> map;
        try {
            SharedPreferences sharedPreferencesS = s(str);
            if (sharedPreferencesS == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesS.edit();
            editorEdit.remove(str2);
            editorEdit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = n;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            String strQ = q(str);
            if (!TextUtils.isEmpty(strQ) && (map = n.get().get(strQ)) != null && map.size() != 0) {
                map.remove(str2);
                SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference2 = n;
                if (softReference2 == null || softReference2.get() == null) {
                    return;
                }
                n.get().put(strQ, map);
            }
        } catch (Throwable unused) {
        }
    }

    public static void n(String str) {
        SharedPreferences.Editor editorEdit = s(str).edit();
        editorEdit.clear();
        editorEdit.apply();
        l(str);
    }

    public static Map<String, ?> qg(String str) {
        return s(str).getAll();
    }
}
