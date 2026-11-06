package com.byazt.sl;

import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.eau.l;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1837, 26})
public class qg {
    public static <T> void n(String str, T t, l lVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("min_version", 7814);
            jSONObject.put(f.R, t);
            lVar.n(n(str, true), jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    public static int n(String str, l lVar, int i) {
        String strS = s(str, lVar);
        if (TextUtils.isEmpty(strS)) {
            return i;
        }
        try {
            return Integer.parseInt(strS);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long n(String str, l lVar, long j) {
        String strS = s(str, lVar);
        if (TextUtils.isEmpty(strS)) {
            return j;
        }
        try {
            return Long.parseLong(strS);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static float n(String str, l lVar, float f) {
        String strS = s(str, lVar);
        if (TextUtils.isEmpty(strS)) {
            return f;
        }
        try {
            return Float.parseFloat(strS);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static Set<String> n(String str, l lVar, Set<String> set) {
        String strS = s(str, lVar);
        if (TextUtils.isEmpty(strS)) {
            return set;
        }
        try {
            JSONArray jSONArray = new JSONArray(strS);
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                String strOptString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString)) {
                    hashSet.add(strOptString);
                }
            }
            return hashSet;
        } catch (JSONException unused) {
            return set;
        }
    }

    public static boolean n(String str, l lVar, boolean z) {
        String strS = s(str, lVar);
        if (TextUtils.isEmpty(strS)) {
            return z;
        }
        try {
            return Boolean.parseBoolean(strS);
        } catch (NumberFormatException unused) {
            return z;
        }
    }

    public static String n(String str, l lVar, String str2) {
        String strS = s(str, lVar);
        return TextUtils.isEmpty(strS) ? str2 : strS;
    }

    private static String s(String str, l lVar) {
        if (!TextUtils.isEmpty(str) && lVar != null) {
            try {
                if (TextUtils.isEmpty(null)) {
                    return n(n(str, true), lVar);
                }
                return null;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String n(String str, l lVar) {
        return n(lVar.qg(str, (String) null));
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (7814 < jSONObject.optInt("min_version")) {
                return null;
            }
            String strOptString = jSONObject.optString(f.R);
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            return strOptString;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String n(String str, boolean z) {
        if (z) {
            return str + "_bst";
        }
        return str + "_pl";
    }

    public static void qg(String str, l lVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            lVar.n(n(str, true));
        } catch (Exception unused) {
        }
    }
}
