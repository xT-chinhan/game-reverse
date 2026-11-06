package com.byazt.yo;

import android.text.TextUtils;
import com.byazt.nf.rv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 170, 5})
public class q {
    public boolean n;
    public com.byazt.oj.s q;
    public String qg;
    public String s;

    public static q n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return n(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static q n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        q qVar = new q();
        qVar.n = jSONObject.optBoolean("enable");
        qVar.qg = jSONObject.optString("upload_api");
        qVar.s = jSONObject.optString("alert_text");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("filter_word");
        if (jSONObjectOptJSONObject != null) {
            com.byazt.oj.s sVarN = com.byazt.oj.s.n(jSONObjectOptJSONObject);
            if (sVarN != null) {
                if (TextUtils.isEmpty(sVarN.n())) {
                    sVarN.n("99:1");
                }
                if (TextUtils.isEmpty(sVarN.qg())) {
                    sVarN.qg("素材反馈");
                }
                sVarN.qg(false);
            }
            qVar.q = sVarN;
        }
        return qVar;
    }

    public static com.byazt.oj.s n() {
        q qVarLg = rv.qg().lg();
        if (qVarLg == null || TextUtils.isEmpty(qVarLg.qg)) {
            return null;
        }
        if (rv.qg().hj()) {
            com.byazt.oj.s sVar = new com.byazt.oj.s();
            sVar.n("99:1");
            sVar.qg(true);
            sVar.qg("其他问题");
            return sVar;
        }
        return qVarLg.l();
    }

    public boolean qg() {
        return this.n;
    }

    public String s() {
        return this.qg;
    }

    public String q() {
        return this.s;
    }

    public com.byazt.oj.s l() {
        return this.q;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("enable", Boolean.valueOf(this.n));
            jSONObject.putOpt("upload_api", this.qg);
            jSONObject.putOpt("alert_text", this.s);
            com.byazt.oj.s sVar = this.q;
            if (sVar != null) {
                jSONObject.putOpt("filter_word", sVar.fs());
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
