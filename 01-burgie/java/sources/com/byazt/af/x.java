package com.byazt.af;

import android.content.Context;
import com.byazt.hg.u;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 948, 121})
@com.byazt.qa.hw
public class x implements k, pr {

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "event_tag")
    public String aj;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "target_url")
    public String c;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = d.R)
    public Context fw;

    @com.byazt.qa.pr(hw = "DSL", pr = "type")
    public int hn;

    @com.byazt.qa.pr(hw = "DSL", pr = Common.System.NAME)
    public String hw;

    @com.byazt.qa.pr(hw = "DSL", pr = "path")
    public String pr;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "ext")
    public String uc;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "landing_page_source")
    public int vk;

    @com.byazt.qa.pr(hw = "DATA_SOURCE", pr = "wc_miniapp_info")
    public JSONObject x;

    @com.byazt.qa.pr(hw = "CONTEXT", pr = "convert_from_landing_page")
    public boolean zo;

    public Context getContext() {
        return this.fw;
    }

    public boolean hw() {
        return this.zo;
    }

    public String hn() {
        return this.aj;
    }

    public int x() {
        return this.vk;
    }

    @Override // com.byazt.af.k
    public u F_() {
        return u.pr(this.x);
    }

    public String fw() {
        return this.pr;
    }

    public String aj() {
        return this.hw;
    }

    @Override // com.byazt.af.k
    public String zo() {
        return this.c;
    }

    @Override // com.byazt.af.k
    public String B_() {
        return this.uc;
    }

    public int vk() {
        return this.hn;
    }

    @Override // com.byazt.af.pr
    public Map<String, String> pr() {
        return new HashMap();
    }
}
