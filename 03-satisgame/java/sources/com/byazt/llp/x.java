package com.byazt.llp;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.gct.ci;
import com.byazt.gct.dg;
import com.byazt.gct.hd;
import com.byazt.gct.ic;
import com.byazt.gct.py;
import com.byazt.gct.sz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 2088, 21})
public class x implements cp, n {

    @com.byazt.phr.n(n = "union_session_key", qg = "DATA_SOURCE")
    public String a;
    public ci ae;
    public ic an;
    public sz bb;

    @com.byazt.phr.n(n = "deep_link", qg = "DATA_SOURCE")
    public JSONObject cd;

    @com.byazt.phr.n(n = "event_tag", qg = "CONTEXT")
    public String cp;

    @com.byazt.phr.n(n = "live_info", qg = "DATA_SOURCE")
    public JSONObject cy;

    @com.byazt.phr.n(n = "dpa_tag", qg = "CONTEXT")
    public String d;

    @com.byazt.phr.n(n = "room_id", qg = "DSL")
    public String fs;

    @com.byazt.phr.n(n = "coupon", qg = "DATA_SOURCE")
    public JSONObject h;

    @com.byazt.phr.n(n = "sub_convert_link", qg = "DATA_SOURCE")
    public JSONObject hd;

    @com.byazt.phr.n(n = "req_id", qg = "DATA_SOURCE")
    public String hu;
    public hd j;

    @com.byazt.phr.n(n = "handle_chain_data", qg = "CONTEXT")
    public Map<String, Object> k;

    @com.byazt.phr.n(n = "link_url", qg = "DSL")
    public String l;
    public JSONObject lh;
    public dg ln;

    @com.byazt.phr.n(n = "ext", qg = "DATA_SOURCE")
    public String m;

    @com.byazt.phr.n(n = "ec_schema", qg = "DSL")
    public String n;

    @com.byazt.phr.n(n = "live_saas_interaction_type", qg = "CONTEXT")
    public int oa = -1;

    @com.byazt.phr.n(n = MediationConstant.EXTRA_ADID, qg = "DATA_SOURCE")
    public String ou;

    @com.byazt.phr.n(n = "dynamic_configs", qg = "DATA_SOURCE")
    public String py;

    @com.byazt.phr.n(n = "amount", qg = "DSL")
    public int q;

    @com.byazt.phr.n(n = "coupon_scene", qg = "DSL")
    public int qg;

    @com.byazt.phr.n(n = "live_params", qg = "DSL")
    public String rv;

    @com.byazt.phr.n(n = "has_coupon", qg = "DSL")
    public boolean s;

    @com.byazt.phr.n(n = "view", qg = "CONTEXT")
    public View sz;

    @com.byazt.phr.n(n = "saas_on_click_material", qg = "DATA_SOURCE")
    public JSONObject t;

    @com.byazt.phr.n(n = "context", qg = "CONTEXT")
    public Context tj;

    @com.byazt.phr.n(n = "saas_info", qg = "DATA_SOURCE")
    public JSONObject um;

    @com.byazt.phr.n(n = "live_sdk_status_while_first_click", qg = "DATA_SOURCE")
    public int ur;
    public py v;

    @com.byazt.phr.n(n = "toast", qg = "DSL")
    public String w;

    @com.byazt.phr.n(n = "reward_live", qg = "DATA_SOURCE")
    public JSONObject wm;

    @com.byazt.phr.n(n = "live_type", qg = "DSL")
    public int x;

    public Context getContext() {
        return this.tj;
    }

    public String qg() {
        return this.cp;
    }

    public String s() {
        return this.d;
    }

    public int x() {
        return this.oa;
    }

    public View fs() {
        return this.sz;
    }

    public Map<String, Object> rv() {
        return this.k;
    }

    @Override // com.byazt.llp.cp
    public String tj() {
        return this.fs;
    }

    @Override // com.byazt.llp.cp, com.byazt.llp.oa, com.byazt.llp.tj
    public int l() {
        return this.x;
    }

    @Override // com.byazt.llp.cp
    public dg cp() {
        JSONObject jSONObject = this.cy;
        if (jSONObject != null && this.ln == null) {
            this.ln = dg.n(jSONObject);
        }
        return this.ln;
    }

    @Override // com.byazt.llp.cp
    public String d() {
        return this.rv;
    }

    @Override // com.byazt.llp.cp, com.byazt.llp.oa
    public py oa() {
        if (this.v == null && this.hd != null) {
            this.v = new py(this.hd, false);
        }
        return this.v;
    }

    @Override // com.byazt.llp.cp, com.byazt.llp.oa
    public hd sz() {
        if (this.j == null) {
            this.j = new hd(this.cd);
            if (!TextUtils.isEmpty(this.l)) {
                this.j.qg(this.l);
            }
        }
        return this.j;
    }

    @Override // com.byazt.llp.cp
    public ic L_() {
        JSONObject jSONObject;
        if (this.an == null && (jSONObject = this.um) != null) {
            this.an = ic.n(jSONObject);
        }
        return this.an;
    }

    @Override // com.byazt.llp.cp, com.byazt.llp.rv, com.byazt.llp.tj
    public String py() {
        return this.a;
    }

    @Override // com.byazt.llp.cp
    public String cy() {
        return this.py;
    }

    @Override // com.byazt.llp.cp, com.byazt.llp.oa, com.byazt.llp.rv, com.byazt.llp.tj
    public String q() {
        return this.ou;
    }

    @Override // com.byazt.llp.cp
    public boolean H_() {
        return this.wm != null;
    }

    @Override // com.byazt.llp.cp, com.byazt.llp.rv
    public JSONObject A_() {
        if (this.m != null && this.lh == null) {
            try {
                this.lh = new JSONObject(this.m);
            } catch (JSONException unused) {
            }
        }
        return this.lh;
    }

    @Override // com.byazt.llp.cp
    public String C_() {
        return this.n;
    }

    @Override // com.byazt.llp.cp, com.byazt.llp.oa, com.byazt.llp.rv, com.byazt.llp.tj
    public String ou() {
        return this.hu;
    }

    @Override // com.byazt.llp.cp, com.byazt.llp.d, com.byazt.llp.tj
    public String F_() {
        return this.m;
    }

    @Override // com.byazt.llp.cp
    public sz um() {
        JSONObject jSONObject = this.h;
        if (jSONObject != null && this.bb == null) {
            sz szVarN = sz.n(jSONObject);
            this.bb = szVarN;
            szVarN.n(this.w);
            this.bb.n(this.qg);
            this.bb.n(this.s);
            this.bb.n(this.q);
        }
        return this.bb;
    }

    @Override // com.byazt.llp.n
    public Map<String, String> n() {
        return new HashMap();
    }

    @Override // com.byazt.llp.cp
    public ci M_() {
        JSONObject jSONObject = this.t;
        if (jSONObject != null && this.ae == null) {
            this.ae = ci.n(jSONObject);
        }
        return this.ae;
    }

    public int wm() {
        return this.ur;
    }

    public void n(int i) {
        this.ur = i;
    }
}
