package com.byazt.tki;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1549, 36})
public class ny implements com.byazt.awu.pr {
    public final String pr;

    public ny(String str) {
        this.pr = str;
    }

    @Override // com.byazt.awu.pr
    public Object pr(Map<String, JSONObject> map) {
        Object objPr;
        if (map == null || map.size() <= 0 || (objPr = pr(this.pr, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return objPr;
    }

    @Override // com.byazt.awu.pr
    public com.byazt.yiq.c pr() {
        return com.byazt.yiq.uc.VARIABLE;
    }

    public String toString() {
        return "VariableNode [literals=" + this.pr + "]";
    }

    @Override // com.byazt.awu.pr
    public String hw() {
        return this.pr;
    }

    public Object pr(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return pr(str.split("\\."), 0, jSONObject);
    }

    private Object pr(String[] strArr, int i, JSONObject jSONObject) {
        Object objOpt;
        if (strArr == null || strArr.length <= 0 || i >= strArr.length || jSONObject == null) {
            return null;
        }
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
                if (!(objOpt2 instanceof JSONArray)) {
                    objOpt = null;
                } else {
                    objOpt = ((JSONArray) objOpt2).opt(i2);
                }
            } catch (NumberFormatException e) {
                return null;
            }
        }
        if (i == strArr.length - 1) {
            return objOpt;
        }
        if (objOpt instanceof String) {
            try {
                return pr(strArr, i + 1, new JSONObject((String) objOpt));
            } catch (JSONException e2) {
                return objOpt;
            }
        }
        if (!(objOpt instanceof JSONObject)) {
            return null;
        }
        return pr(strArr, i + 1, (JSONObject) objOpt);
    }
}
