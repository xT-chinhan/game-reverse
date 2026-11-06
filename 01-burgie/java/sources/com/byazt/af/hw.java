package com.byazt.af;

import android.content.Context;
import com.byazt.bek.DownloadStatusChangeListener;
import com.byazt.hg.qa;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 948, 13})
@com.byazt.qa.hw
public class hw implements aj, pr {

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "app_manage")
    public JSONObject a;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "is_open_market_intercept_for_dsp")
    public volatile boolean aj;
    public qa b;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "download_popup_manager")
    public com.byazt.wr.hn c;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "enable_update_download_model")
    public boolean cz;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "req_id")
    public String fo;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "dialog_to_landing_page_convert")
    public com.byazt.ni.pr g;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "event_tag")
    public String hn;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "pip_controller")
    public com.byazt.ga.hw ho;

    @com.byazt.qa.pr(hw = "DSL", pr = BreakpointSQLiteKey.URL)
    public String hw;
    public com.byazt.hg.c iu;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "download_conf")
    public JSONObject k;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "if_both_open")
    public int lb;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "app")
    public JSONObject m;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "ext")
    public String nt;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "union_session_key")
    public String ny;

    @com.byazt.qa.pr(hw = "DSL", pr = "id")
    public String pr;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "not_valid_download_url")
    public boolean qa;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "market_url")
    public String rc;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = d.R)
    public Context uc;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "is_click_button")
    public volatile boolean vk;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "download_url")
    public String w;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "download_status_listener")
    public DownloadStatusChangeListener x;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = MediationConstant.EXTRA_ADID)
    public String yb;
    public com.byazt.hg.uc z;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "convert_from_landing_page")
    public volatile boolean fw = false;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "need_check_compliance")
    public int zo = 0;

    @Override // com.byazt.af.aj
    public boolean G_() {
        return this.qa;
    }

    @Override // com.byazt.af.aj
    public boolean C_() {
        return this.lb == 1;
    }

    @Override // com.byazt.af.aj
    public String x() {
        return this.yb;
    }

    public String c() {
        return this.nt;
    }

    @Override // com.byazt.af.aj
    public JSONObject v_() {
        try {
            return new JSONObject(c());
        } catch (JSONException e) {
            return null;
        }
    }

    public Context getContext() {
        return this.uc;
    }

    public boolean fw() {
        return this.fw;
    }

    public String zo() {
        return this.hn;
    }

    public DownloadStatusChangeListener aj() {
        return this.x;
    }

    public com.byazt.wr.hn vk() {
        return this.c;
    }

    public int w() {
        return this.zo;
    }

    public boolean k() {
        return this.aj;
    }

    public boolean m() {
        return this.vk;
    }

    public String g() {
        return this.w;
    }

    public void pr(String str) {
        this.w = str;
    }

    @Override // com.byazt.af.aj
    public com.byazt.hg.c ho() {
        JSONObject jSONObject;
        if (this.iu == null && (jSONObject = this.m) != null) {
            com.byazt.hg.c cVarHw = com.byazt.sd.pr.hw(jSONObject);
            this.iu = cVarHw;
            cVarHw.x(this.pr);
            this.iu.hw(this.hw);
        }
        return this.iu;
    }

    public com.byazt.ni.pr nt() {
        return this.g;
    }

    public com.byazt.ga.hw yb() {
        return this.ho;
    }

    @Override // com.byazt.af.aj
    public com.byazt.hg.uc lb() {
        JSONObject jSONObject;
        if (this.z == null && (jSONObject = this.a) != null) {
            this.z = new com.byazt.hg.uc(jSONObject);
        }
        return this.z;
    }

    @Override // com.byazt.af.aj
    public qa z_() {
        JSONObject jSONObject;
        if (this.b == null && (jSONObject = this.k) != null) {
            this.b = new qa(jSONObject);
        }
        return this.b;
    }

    public boolean a() {
        return this.cz;
    }

    @Override // com.byazt.af.aj
    public String cz() {
        return this.ny;
    }

    @Override // com.byazt.af.aj
    public String ny() {
        return this.fo;
    }

    @Override // com.byazt.af.aj
    public String fo() {
        if (v_() != null) {
            return v_().optString(MediationConstant.EXTRA_ADID);
        }
        return "";
    }

    @Override // com.byazt.af.aj
    public String rc() {
        return this.rc;
    }

    @Override // com.byazt.af.pr
    public Map<String, String> pr() {
        return new HashMap();
    }
}
