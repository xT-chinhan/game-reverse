package com.byazt.uc;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, 849})
public class ou implements com.byazt.uk.n {
    public final String n;

    public ou(String str) {
        this.n = str;
    }

    @Override // com.byazt.uk.n
    public Object n(Map<String, JSONObject> map) {
        Object objN;
        if (map == null || map.size() <= 0 || (objN = n(this.n, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return objN;
    }

    @Override // com.byazt.uk.n
    public com.byazt.mn.l n() {
        return com.byazt.mn.w.VARIABLE;
    }

    public String toString() {
        return "VariableNode [literals=" + this.n + "]";
    }

    @Override // com.byazt.uk.n
    public String qg() {
        return this.n;
    }

    public Object n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return n(str.split("\\."), 0, jSONObject);
    }

    private Object n(String[] strArr, int i, JSONObject jSONObject) {
        Object objOpt;
        if (strArr != null && strArr.length > 0 && i < strArr.length && jSONObject != null) {
            String str = strArr[i];
            int iIndexOf = str.indexOf("[");
            int iIndexOf2 = str.indexOf("]");
            if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf > iIndexOf2) {
                objOpt = jSONObject.opt(str);
            } else {
                String strSubstring = str.substring(0, iIndexOf);
                try {
                    int i2 = Integer.parseInt(str.substring(iIndexOf + 1, iIndexOf2));
                    Object objOpt2 = jSONObject.opt(strSubstring);
                    objOpt = objOpt2 instanceof JSONArray ? ((JSONArray) objOpt2).opt(i2) : null;
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            if (i == strArr.length - 1) {
                return objOpt;
            }
            if (objOpt instanceof String) {
                try {
                    return n(strArr, i + 1, new JSONObject((String) objOpt));
                } catch (JSONException unused2) {
                    return objOpt;
                }
            }
            if (objOpt instanceof JSONObject) {
                return n(strArr, i + 1, (JSONObject) objOpt);
            }
        }
        return null;
    }
}
