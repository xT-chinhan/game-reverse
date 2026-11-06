package com.byazt.af;

import android.content.Context;
import com.byazt.hg.cz;
import com.byazt.hg.er;
import com.byazt.hg.yb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 948, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
@com.byazt.qa.hw
public class zo implements m, pr {

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "is_click_button")
    public volatile boolean a;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "convert_from_downloader")
    public boolean aj;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "event_tag")
    public String c;
    public cz cz;
    public com.byazt.hg.c fo;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "app")
    public JSONObject fw;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = MediationConstant.EXTRA_ADID)
    public String g;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "download_conf.download_type")
    public int hn = -1;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "reward_live_deep_link_params")
    public JSONObject ho;

    @com.byazt.qa.pr(hw = "DSL", pr = "type")
    public int hw;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "sub_convert_link")
    public JSONObject k;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "live_interaction_type")
    public int lb;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "if_double_deeplink")
    public int m;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "reward_live")
    public JSONObject nt;
    public yb ny;

    @com.byazt.qa.pr(hw = "DSL", pr = BreakpointSQLiteKey.URL)
    public String pr;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "is_web_meta")
    public boolean qa;
    public er rc;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "deep_link")
    public JSONObject uc;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "download_adapter")
    public com.byazt.nv.hn vk;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "convert_tag")
    public String w;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = d.R)
    public Context x;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "req_id")
    public String yb;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "convert_from_landing_page")
    public boolean zo;

    @Override // com.byazt.af.m
    public com.byazt.hg.c ho() {
        if (this.fo == null) {
            this.fo = com.byazt.sd.pr.hw(this.fw);
        }
        return this.fo;
    }

    public JSONObject hw() {
        return this.ho;
    }

    @Override // com.byazt.af.m
    public String x() {
        return this.g;
    }

    public String hn() {
        return this.pr;
    }

    @Override // com.byazt.af.m
    public int uc() {
        return this.hn;
    }

    public boolean fw() {
        return this.a;
    }

    public int zo() {
        return this.hw;
    }

    public Context getContext() {
        return this.x;
    }

    public String aj() {
        return this.c;
    }

    @Override // com.byazt.af.m
    public yb g() {
        if (this.ny == null) {
            this.ny = new yb(this.uc);
        }
        return this.ny;
    }

    public boolean vk() {
        return this.zo;
    }

    public boolean w() {
        return this.aj;
    }

    public com.byazt.nv.hn k() {
        return this.vk;
    }

    public String nt() {
        return this.w;
    }

    @Override // com.byazt.af.m
    public cz m() {
        if (this.cz == null) {
            this.cz = new cz(this.k, false);
        }
        return this.cz;
    }

    @Override // com.byazt.af.m
    public boolean yb() {
        return this.m == 1;
    }

    public JSONObject lb() {
        return this.nt;
    }

    @Override // com.byazt.af.m
    public String ny() {
        return this.yb;
    }

    @Override // com.byazt.af.m
    public int c() {
        return this.lb;
    }

    @Override // com.byazt.af.m
    public boolean x_() {
        return this.qa;
    }

    @Override // com.byazt.af.m
    public er a() {
        if (this.rc == null && hw() != null) {
            this.rc = new er(hw());
        }
        return this.rc;
    }

    @Override // com.byazt.af.m
    public boolean E_() {
        return lb() != null && lb().optBoolean("isValid", false);
    }

    @Override // com.byazt.af.pr
    public Map<String, String> pr() {
        return new HashMap();
    }
}
