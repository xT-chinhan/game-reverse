package com.bytedance.adsdk.xr.xr.xr.ms;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b implements com.bytedance.adsdk.xr.xr.xr.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f468ms;

    public b(String str) {
        this.f468ms = str;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public Object ms(Map<String, JSONObject> map) {
        Object objMs;
        if (map == null || map.size() <= 0 || (objMs = ms(this.f468ms, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return objMs;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public com.bytedance.adsdk.xr.xr.d.ka ms() {
        return com.bytedance.adsdk.xr.xr.d.c.VARIABLE;
    }

    public String toString() {
        return "VariableNode [literals=" + this.f468ms + "]";
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public String xr() {
        return this.f468ms;
    }

    public Object ms(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ms(str.split("\\."), 0, jSONObject);
    }

    private Object ms(String[] strArr, int i, JSONObject jSONObject) {
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
                } catch (NumberFormatException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                    return null;
                }
            }
            if (i == strArr.length - 1) {
                return objOpt;
            }
            if (objOpt instanceof String) {
                try {
                    return ms(strArr, i + 1, new JSONObject((String) objOpt));
                } catch (JSONException e2) {
                    com.bytedance.sdk.component.utils.sl.ms(e2);
                    return objOpt;
                }
            }
            if (objOpt instanceof JSONObject) {
                return ms(strArr, i + 1, (JSONObject) objOpt);
            }
        }
        return null;
    }
}
