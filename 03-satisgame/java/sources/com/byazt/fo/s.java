package com.byazt.fo;

import com.byazt.km.sz;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1154, 8})
public class s extends qg {
    @Override // com.byazt.fo.qg
    public String q() {
        return "c";
    }

    public s(q qVar) {
        super(qVar);
    }

    @Override // com.byazt.fo.qg
    public long n() {
        return this.n.s().fs() + 21600000;
    }

    @Override // com.byazt.fo.qg
    public long[] qg() {
        return l.s;
    }

    @Override // com.byazt.fo.qg
    public boolean s() throws JSONException {
        JSONObject jSONObjectN = this.n.q().n();
        if (this.n.q().d() == 0 || jSONObjectN == null || this.n.s().fs() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", jSONObjectN);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject jSONObjectQg = com.byazt.jy.n.qg(com.byazt.jy.n.n(com.byazt.jy.qg.n(this.n.getContext(), this.n.q().n(), this.n.x().s(), true, com.byazt.wv.n.q()), com.byazt.jy.n.s), jSONObject);
        com.byazt.wv.n.d().n(!sz.n(jSONObjectQg, this.n.s().x()), jSONObjectQg);
        if (jSONObjectQg == null) {
            return false;
        }
        this.n.s().n(jSONObjectQg);
        return true;
    }
}
