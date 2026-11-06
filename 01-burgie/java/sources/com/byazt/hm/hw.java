package com.byazt.hm;

import android.text.TextUtils;
import com.byazt.cr.c;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 437, 13})
public class hw {
    public static <T> void pr(String str, T t, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("min_version", 7714);
            jSONObject.put("data", t);
            cVar.pr(pr(str, true), jSONObject.toString());
        } catch (Exception e) {
        }
    }

    public static int pr(String str, c cVar, int i) {
        String strHn = hn(str, cVar);
        if (TextUtils.isEmpty(strHn)) {
            return i;
        }
        try {
            return Integer.parseInt(strHn);
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public static long pr(String str, c cVar, long j) {
        String strHn = hn(str, cVar);
        if (TextUtils.isEmpty(strHn)) {
            return j;
        }
        try {
            return Long.parseLong(strHn);
        } catch (NumberFormatException e) {
            return j;
        }
    }

    public static float pr(String str, c cVar, float f) {
        String strHn = hn(str, cVar);
        if (TextUtils.isEmpty(strHn)) {
            return f;
        }
        try {
            return Float.parseFloat(strHn);
        } catch (NumberFormatException e) {
            return f;
        }
    }

    public static Set<String> pr(String str, c cVar, Set<String> set) {
        String strHn = hn(str, cVar);
        if (TextUtils.isEmpty(strHn)) {
            return set;
        }
        try {
            JSONArray jSONArray = new JSONArray(strHn);
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                String strOptString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString)) {
                    hashSet.add(strOptString);
                }
            }
            return hashSet;
        } catch (JSONException e) {
            return set;
        }
    }

    public static boolean pr(String str, c cVar, boolean z) {
        String strHn = hn(str, cVar);
        if (TextUtils.isEmpty(strHn)) {
            return z;
        }
        try {
            return Boolean.parseBoolean(strHn);
        } catch (NumberFormatException e) {
            return z;
        }
    }

    public static String pr(String str, c cVar, String str2) {
        String strHn = hn(str, cVar);
        return TextUtils.isEmpty(strHn) ? str2 : strHn;
    }

    private static String hn(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(null)) {
                return pr(pr(str, true), cVar);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static String pr(String str, c cVar) {
        return pr(cVar.hw(str, (String) null));
    }

    public static String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (7714 < jSONObject.optInt("min_version")) {
                return null;
            }
            String strOptString = jSONObject.optString("data");
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            return strOptString;
        } catch (Exception e) {
            return null;
        }
    }

    private static String pr(String str, boolean z) {
        if (z) {
            return str + "_bst";
        }
        return str + "_pl";
    }

    public static void hw(String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            cVar.pr(pr(str, true));
        } catch (Exception e) {
        }
    }
}
