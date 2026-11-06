package com.byazt.fo;

import com.byazt.km.cp;
import com.byazt.km.sz;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1154, 19})
public class n extends qg {
    public long qg;

    @Override // com.byazt.fo.qg
    public String q() {
        return "ab";
    }

    public n(q qVar) {
        super(qVar);
    }

    @Override // com.byazt.fo.qg
    public long n() {
        long jCd = this.n.s().cd();
        if (jCd < 600000) {
            jCd = 600000;
        }
        return this.qg + jCd;
    }

    @Override // com.byazt.fo.qg
    public long[] qg() {
        return l.s;
    }

    @Override // com.byazt.fo.qg
    public boolean s() throws JSONException {
        JSONObject jSONObjectN = this.n.q().n();
        if (this.n.q().d() == 0 || jSONObjectN == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.n.q().n());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", jCurrentTimeMillis);
        JSONObject jSONObjectS = com.byazt.jy.n.s(com.byazt.jy.n.n(com.byazt.jy.qg.n(this.n.getContext(), this.n.q().n(), this.n.x().q(), true, com.byazt.wv.n.q()), com.byazt.jy.n.s), jSONObject);
        if (jSONObjectS == null) {
            return false;
        }
        com.byazt.wv.n.d().qg(!sz.n(com.byazt.wv.n.w(), jSONObjectS), jSONObjectS);
        if (cp.qg) {
            cp.n("getAbConfig ".concat(String.valueOf(jSONObjectS)), null);
        }
        this.n.q().n(jSONObjectS);
        this.qg = jCurrentTimeMillis;
        return true;
    }
}
