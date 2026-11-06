package com.byazt.af;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.hg.cz;
import com.byazt.hg.g;
import com.byazt.hg.lv;
import com.byazt.hg.od;
import com.byazt.hg.qi;
import com.byazt.hg.yb;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.IAction;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 948, 62})
@com.byazt.qa.hw
public class fw implements pr, w {

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "union_session_key")
    public String a;

    @com.byazt.qa.pr(hw = "DSL", pr = "live_params")
    public String aj;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "coupon")
    public JSONObject b;

    @com.byazt.qa.pr(hw = "DSL", pr = "link_url")
    public String c;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "dynamic_configs")
    public String cz;
    public lv e;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "reward_live")
    public JSONObject fo;

    @com.byazt.qa.pr(hw = "DSL", pr = "live_type")
    public int fw;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "view")
    public View g;
    public g gz;

    @com.byazt.qa.pr(hw = "DSL", pr = "has_coupon")
    public boolean hn;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "handle_chain_data")
    public Map<String, Object> ho;

    @com.byazt.qa.pr(hw = "DSL", pr = "coupon_scene")
    public int hw;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "saas_on_click_material")
    public JSONObject iu;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "dpa_tag")
    public String k;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "deep_link")
    public JSONObject lb;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "live_saas_interaction_type")
    public int m = -1;
    public yb n;
    public qi nl;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "live_info")
    public JSONObject nt;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = MediationConstant.EXTRA_ADID)
    public String ny;

    @com.byazt.qa.pr(hw = "DSL", pr = "ec_schema")
    public String pr;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "saas_info")
    public JSONObject qa;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "ext")
    public String rc;
    public od s;

    @com.byazt.qa.pr(hw = "DSL", pr = "toast")
    public String uc;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "live_sdk_status_while_first_click")
    public int ve;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = d.R)
    public Context vk;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "event_tag")
    public String w;
    public cz ww;

    @com.byazt.qa.pr(hw = "DSL", pr = IAction.BuyKey.CostAmount)
    public int x;
    public JSONObject y;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "sub_convert_link")
    public JSONObject yb;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "req_id")
    public String z;

    @com.byazt.qa.pr(hw = "DSL", pr = "room_id")
    public String zo;

    public Context getContext() {
        return this.vk;
    }

    public String hw() {
        return this.w;
    }

    public String hn() {
        return this.k;
    }

    public int fw() {
        return this.m;
    }

    public View zo() {
        return this.g;
    }

    public Map<String, Object> aj() {
        return this.ho;
    }

    @Override // com.byazt.af.w
    public String vk() {
        return this.zo;
    }

    @Override // com.byazt.af.w
    public int c() {
        return this.fw;
    }

    @Override // com.byazt.af.w
    public qi w() {
        JSONObject jSONObject = this.nt;
        if (jSONObject != null && this.nl == null) {
            this.nl = qi.pr(jSONObject);
        }
        return this.nl;
    }

    @Override // com.byazt.af.w
    public String k() {
        return this.aj;
    }

    @Override // com.byazt.af.w
    public cz m() {
        JSONObject jSONObject;
        if (this.ww == null && (jSONObject = this.yb) != null) {
            this.ww = new cz(jSONObject, false);
        }
        return this.ww;
    }

    @Override // com.byazt.af.w
    public yb g() {
        if (this.n == null) {
            this.n = new yb(this.lb);
            if (!TextUtils.isEmpty(this.c)) {
                this.n.hw(this.c);
            }
        }
        return this.n;
    }

    @Override // com.byazt.af.w
    public lv H_() {
        JSONObject jSONObject;
        if (this.e == null && (jSONObject = this.qa) != null) {
            this.e = lv.pr(jSONObject);
        }
        return this.e;
    }

    @Override // com.byazt.af.w
    public String cz() {
        return this.a;
    }

    @Override // com.byazt.af.w
    public String nt() {
        return this.cz;
    }

    @Override // com.byazt.af.w
    public String x() {
        return this.ny;
    }

    @Override // com.byazt.af.w
    public boolean D_() {
        return this.fo != null;
    }

    @Override // com.byazt.af.w
    public JSONObject v_() {
        if (this.rc != null && this.y == null) {
            try {
                this.y = new JSONObject(this.rc);
            } catch (JSONException e) {
            }
        }
        return this.y;
    }

    @Override // com.byazt.af.w
    public String y_() {
        return this.pr;
    }

    @Override // com.byazt.af.w
    public String ny() {
        return this.z;
    }

    @Override // com.byazt.af.w
    public String B_() {
        return this.rc;
    }

    @Override // com.byazt.af.w
    public g qa() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null && this.gz == null) {
            g gVarPr = g.pr(jSONObject);
            this.gz = gVarPr;
            gVarPr.pr(this.uc);
            this.gz.pr(this.hw);
            this.gz.pr(this.hn);
            this.gz.pr(this.x);
        }
        return this.gz;
    }

    @Override // com.byazt.af.pr
    public Map<String, String> pr() {
        return new HashMap();
    }

    @Override // com.byazt.af.w
    public od I_() {
        JSONObject jSONObject = this.iu;
        if (jSONObject != null && this.s == null) {
            this.s = od.pr(jSONObject);
        }
        return this.s;
    }

    public int fo() {
        return this.ve;
    }

    public void pr(int i) {
        this.ve = i;
    }
}
