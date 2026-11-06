package com.byazt.zs;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.vyf.s;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 45, 19})
public class n {
    public static volatile n n;
    public Function<SparseArray<Object>, Object> l;
    public qg s;
    public boolean qg = false;
    public boolean q = false;

    private n() {
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    public void qg() {
        this.qg = true;
    }

    public boolean s() {
        return this.qg;
    }

    public boolean n(String str, int i, boolean z) {
        return z || n(str) || com.byazt.qt.qg.n().n(str, i, 101) != null;
    }

    public boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("200000000".equals(str)) {
            return true;
        }
        return str.matches("^1[0-9]{8}$");
    }

    public void n(qg qgVar) {
        this.s = qgVar;
    }

    public void n(JSONObject jSONObject) {
        qg qgVar = this.s;
        if (qgVar != null) {
            qgVar.n(jSONObject);
        }
    }

    public void n(int i, String str) {
        qg qgVar = this.s;
        if (qgVar != null) {
            qgVar.n(i, str);
        }
    }

    public void q() {
        this.q = true;
    }

    public void n(Function<SparseArray<Object>, Object> function) {
        this.l = function;
    }

    public Function<SparseArray<Object>, Object> l() {
        return this.l;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:19:0x004d A[RETURN] */
    public String qg(String str) {
        JSONObject jSONObject;
        JSONObject jSONObjectQg;
        String strYw = s.cy().yw();
        if (TextUtils.isEmpty(strYw) || TextUtils.isEmpty(strYw.trim())) {
            return str;
        }
        try {
            return n(str, "app_ab_version", strYw);
        } catch (Throwable th) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", "app_ab_version");
                jSONObject2.put("json", str);
                com.byazt.eji.s.n().n("gm_add_csj_libra_vids", jSONObject2, th);
            } catch (Throwable unused) {
            }
            if (str != null) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException unused2) {
                    jSONObject = null;
                    jSONObjectQg = qg(jSONObject);
                    if (jSONObjectQg != null) {
                        return jSONObjectQg.toString();
                    }
                    return null;
                }
            } else {
                jSONObject = null;
            }
            jSONObjectQg = qg(jSONObject);
            if (jSONObjectQg != null) {
                return jSONObjectQg.toString();
            }
            return null;
        }
    }

    public JSONObject qg(JSONObject jSONObject) {
        String strYw = s.cy().yw();
        if (TextUtils.isEmpty(strYw)) {
            return jSONObject;
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("app_ab_version", strYw);
                return jSONObject2;
            } catch (JSONException unused) {
                return null;
            }
        }
        try {
            if (jSONObject.has("app_ab_version")) {
                String strOptString = jSONObject.optString("app_ab_version");
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject.put("app_ab_version", strYw);
                } else {
                    jSONObject.put("app_ab_version", strOptString + "," + strYw);
                }
            } else {
                jSONObject.put("app_ab_version", strYw);
            }
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:19:0x004d A[RETURN] */
    public String s(String str) {
        JSONObject jSONObject;
        JSONObject jSONObjectS;
        String strYw = s.cy().yw();
        if (TextUtils.isEmpty(strYw) || TextUtils.isEmpty(strYw.trim())) {
            return str;
        }
        try {
            return n(str, "waterfall_ab_version", strYw);
        } catch (Throwable th) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", "waterfall_ab_version");
                jSONObject2.put("json", str);
                com.byazt.eji.s.n().n("gm_add_csj_libra_vids", jSONObject2, th);
            } catch (Throwable unused) {
            }
            if (str != null) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException unused2) {
                    jSONObject = null;
                    jSONObjectS = s(jSONObject);
                    if (jSONObjectS != null) {
                        return jSONObjectS.toString();
                    }
                    return null;
                }
            } else {
                jSONObject = null;
            }
            jSONObjectS = s(jSONObject);
            if (jSONObjectS != null) {
                return jSONObjectS.toString();
            }
            return null;
        }
    }

    public JSONObject s(JSONObject jSONObject) {
        String strYw = s.cy().yw();
        if (TextUtils.isEmpty(strYw)) {
            return jSONObject;
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("waterfall_ab_version", strYw);
                return jSONObject2;
            } catch (JSONException unused) {
                return null;
            }
        }
        try {
            if (jSONObject.has("waterfall_ab_version")) {
                String strOptString = jSONObject.optString("waterfall_ab_version");
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject.put("waterfall_ab_version", strYw);
                } else {
                    jSONObject.put("waterfall_ab_version", strOptString + "," + strYw);
                }
            } else {
                jSONObject.put("waterfall_ab_version", strYw);
            }
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    private static String n(String str, String str2, String str3) {
        if (str == null || str.trim().isEmpty()) {
            return "{\"" + str2 + "\":\"" + str3 + "\"}";
        }
        String strTrim = str.trim();
        if (!strTrim.startsWith("{") || !strTrim.endsWith("}")) {
            return str;
        }
        int iIndexOf = strTrim.indexOf("\"" + str2 + "\"");
        if (iIndexOf != -1) {
            int iIndexOf2 = strTrim.indexOf(58, iIndexOf) + 1;
            while (iIndexOf2 < strTrim.length() && Character.isWhitespace(strTrim.charAt(iIndexOf2))) {
                iIndexOf2++;
            }
            String strSubstring = strTrim.substring(0, iIndexOf2);
            String strSubstring2 = strTrim.substring(iIndexOf2);
            if (strSubstring2.startsWith("\"")) {
                return strSubstring + "\"" + str3 + "," + strSubstring2.substring(1);
            }
            return strSubstring2.startsWith("'") ? strSubstring + "'" + str3 + "," + strSubstring2.substring(1) : str;
        }
        String strTrim2 = strTrim.substring(0, strTrim.length() - 1).trim();
        if (!strTrim2.endsWith(",")) {
            strTrim2 = strTrim2 + ",";
        }
        return strTrim2 + "\"" + str2 + "\":\"" + str3 + "\"}";
    }
}
