package com.byazt.af;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 948, 20})
@com.byazt.qa.hw
public class hn implements pr, vk {

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "icon.url")
    public String a;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "landing_page_source")
    public int aj = -1;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "convert_from_landing_page")
    public boolean c;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "union_session_key")
    public String cz;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "event_tag")
    public String fw;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "get_phone_num_status")
    public int g;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = d.R)
    public Context hn;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "ext")
    public String ho;

    @com.byazt.qa.pr(hw = "DSL", pr = BundleKey.TITLE)
    public String hw;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "target_url")
    public String k;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "gecko_id")
    public String lb;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "interaction_type")
    public int m;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "live_interaction_type")
    public int nt;

    @com.byazt.qa.pr(hw = "DSL", pr = BreakpointSQLiteKey.URL)
    public String pr;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = MediationConstant.EXTRA_ADID)
    public String qa;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "pip_controller")
    public com.byazt.ga.hw uc;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "open_video_detail_page_direct")
    public boolean vk;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "is_from_video_layout")
    public boolean w;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "is_open_web_page")
    public boolean x;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "req_id")
    public String yb;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "landing_page_url")
    public String zo;

    @Override // com.byazt.af.vk
    public String cz() {
        return this.cz;
    }

    @Override // com.byazt.af.vk
    public String hw() {
        return this.a;
    }

    @Override // com.byazt.af.vk
    public String x() {
        return this.qa;
    }

    @Override // com.byazt.af.vk
    public String hn() {
        return this.lb;
    }

    @Override // com.byazt.af.vk
    public String ny() {
        return this.yb;
    }

    @Override // com.byazt.af.vk
    public int c() {
        return this.nt;
    }

    @Override // com.byazt.af.vk
    public String B_() {
        return this.ho;
    }

    @Override // com.byazt.af.vk
    public int fw() {
        return this.g;
    }

    @Override // com.byazt.af.vk
    public String zo() {
        return this.k;
    }

    @Override // com.byazt.af.vk
    public int aj() {
        return this.m;
    }

    @Override // com.byazt.af.vk
    public String A_() {
        return this.hw;
    }

    public Context getContext() {
        return this.hn;
    }

    public boolean w() {
        return this.x;
    }

    public boolean k() {
        return this.c;
    }

    public com.byazt.ga.hw m() {
        return this.uc;
    }

    public String g() {
        return this.fw;
    }

    public String ho() {
        if (!TextUtils.isEmpty(this.zo)) {
            return this.zo;
        }
        return this.pr;
    }

    public boolean nt() {
        return this.vk;
    }

    public boolean yb() {
        return this.w;
    }

    @Override // com.byazt.af.pr
    public Map<String, String> pr() {
        HashMap map = new HashMap();
        map.put(BundleKey.TITLE, BundleKey.TITLE);
        map.put("button_text", "button_text");
        map.put("block_auto_open", "block_auto_open");
        map.put("disable_top_bar", "disable_top_bar");
        map.put("disable_safe_area", "disable_safe_area");
        map.put("disable_rtn_button", "disable_rtn_button");
        return map;
    }
}
