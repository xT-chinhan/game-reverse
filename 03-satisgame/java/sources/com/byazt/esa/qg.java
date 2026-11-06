package com.byazt.esa;

import com.byazt.gct.pk;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1065, 26})
public class qg {
    public pk n;
    public JSONObject q;
    public String qg;
    public String s;

    public static qg n() {
        return new qg();
    }

    public static qg n(JSONObject jSONObject) {
        String strOptString;
        String strOptString2;
        JSONObject jSONObjectOptJSONObject;
        pk pkVarN = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            strOptString = jSONObject.optString("tag", null);
            try {
                strOptString2 = jSONObject.optString("label", null);
                try {
                    jSONObjectOptJSONObject = jSONObject.optJSONObject("extra");
                    try {
                        pkVarN = com.byazt.vgx.qg.n(jSONObject.optJSONObject("material_meta"));
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    jSONObjectOptJSONObject = null;
                }
            } catch (Exception unused3) {
                strOptString2 = null;
                jSONObjectOptJSONObject = strOptString2;
            }
        } catch (Exception unused4) {
            strOptString = null;
            strOptString2 = null;
        }
        return n().n(strOptString).qg(strOptString2).qg(jSONObjectOptJSONObject).n(pkVarN);
    }

    public qg n(pk pkVar) {
        this.n = pkVar;
        return this;
    }

    public qg n(String str) {
        this.qg = str;
        return this;
    }

    public qg qg(String str) {
        this.s = str;
        return this;
    }

    public qg qg(JSONObject jSONObject) {
        this.q = jSONObject;
        return this;
    }

    public JSONObject qg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", this.qg);
            jSONObject.put("label", this.s);
            JSONObject jSONObject2 = this.q;
            if (jSONObject2 != null) {
                jSONObject.put("extra", jSONObject2);
            }
            pk pkVar = this.n;
            if (pkVar != null) {
                jSONObject.put("material_meta", pkVar.pv());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
