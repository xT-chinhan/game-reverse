package com.byazt.llp;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 2088, 8})
public class s implements n, tj {

    @com.byazt.phr.n(n = "icon.url", qg = "DATA_SOURCE")
    public String a;

    @com.byazt.phr.n(n = "gecko_id", qg = "DATA_SOURCE")
    public String cd;

    @com.byazt.phr.n(n = "is_from_video_layout", qg = "CONTEXT")
    public boolean cp;

    @com.byazt.phr.n(n = "live_interaction_type", qg = "DATA_SOURCE")
    public int cy;

    @com.byazt.phr.n(n = "target_url", qg = "DATA_SOURCE")
    public String d;

    @com.byazt.phr.n(n = "landing_page_url", qg = "CONTEXT")
    public String fs;

    @com.byazt.phr.n(n = "req_id", qg = "DATA_SOURCE")
    public String hd;

    @com.byazt.phr.n(n = "ext", qg = "DATA_SOURCE")
    public String k;

    @com.byazt.phr.n(n = "convert_from_landing_page", qg = "CONTEXT")
    public boolean l;

    @com.byazt.phr.n(n = ImagesContract.URL, qg = "DSL")
    public String n;

    @com.byazt.phr.n(n = "interaction_type", qg = "DATA_SOURCE")
    public int oa;

    @com.byazt.phr.n(n = "union_session_key", qg = "DATA_SOURCE")
    public String py;

    @com.byazt.phr.n(n = "is_open_web_page", qg = "CONTEXT")
    public boolean q;

    @com.byazt.phr.n(n = "title", qg = "DSL")
    public String qg;

    @com.byazt.phr.n(n = "landing_page_source", qg = "CONTEXT")
    public int rv = -1;

    @com.byazt.phr.n(n = "context", qg = "CONTEXT")
    public Context s;

    @com.byazt.phr.n(n = "get_phone_num_status", qg = "DATA_SOURCE")
    public int sz;

    @com.byazt.phr.n(n = "open_video_detail_page_direct", qg = "CONTEXT")
    public boolean tj;

    @com.byazt.phr.n(n = MediationConstant.EXTRA_ADID, qg = "DATA_SOURCE")
    public String um;

    @com.byazt.phr.n(n = "pip_controller", qg = "CONTEXT")
    public com.byazt.zx.qg w;

    @com.byazt.phr.n(n = "event_tag", qg = "CONTEXT")
    public String x;

    @Override // com.byazt.llp.tj
    public String py() {
        return this.py;
    }

    @Override // com.byazt.llp.tj
    public String qg() {
        return this.a;
    }

    @Override // com.byazt.llp.tj
    public String q() {
        return this.um;
    }

    @Override // com.byazt.llp.tj
    public String s() {
        return this.cd;
    }

    @Override // com.byazt.llp.tj
    public String ou() {
        return this.hd;
    }

    @Override // com.byazt.llp.tj
    public int l() {
        return this.cy;
    }

    @Override // com.byazt.llp.tj
    public String F_() {
        return this.k;
    }

    @Override // com.byazt.llp.tj
    public int x() {
        return this.sz;
    }

    @Override // com.byazt.llp.tj
    public String fs() {
        return this.d;
    }

    @Override // com.byazt.llp.tj
    public int rv() {
        return this.oa;
    }

    @Override // com.byazt.llp.tj
    public String E_() {
        return this.qg;
    }

    public Context getContext() {
        return this.s;
    }

    public boolean cp() {
        return this.q;
    }

    public boolean d() {
        return this.l;
    }

    public com.byazt.zx.qg oa() {
        return this.w;
    }

    public String sz() {
        return this.x;
    }

    public String k() {
        if (!TextUtils.isEmpty(this.fs)) {
            return this.fs;
        }
        return this.n;
    }

    public boolean cy() {
        return this.tj;
    }

    public boolean hd() {
        return this.cp;
    }

    @Override // com.byazt.llp.n
    public Map<String, String> n() {
        HashMap map = new HashMap();
        map.put("title", "title");
        map.put("button_text", "button_text");
        map.put("block_auto_open", "block_auto_open");
        map.put("disable_top_bar", "disable_top_bar");
        map.put("disable_safe_area", "disable_safe_area");
        map.put("disable_rtn_button", "disable_rtn_button");
        return map;
    }
}
