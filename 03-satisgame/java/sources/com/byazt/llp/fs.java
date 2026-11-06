package com.byazt.llp;

import android.content.Context;
import com.anythink.core.common.f.a;
import com.byazt.gct.df;
import com.byazt.gct.hd;
import com.byazt.gct.py;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 2088, 101})
public class fs implements n, oa {

    @com.byazt.phr.n(n = "is_click_button", qg = "CONTEXT")
    public volatile boolean a;

    @com.byazt.phr.n(n = "live_interaction_type", qg = "DATA_SOURCE")
    public int cd;

    @com.byazt.phr.n(n = "convert_tag", qg = "CONTEXT")
    public String cp;

    @com.byazt.phr.n(n = "reward_live", qg = "DATA_SOURCE")
    public JSONObject cy;

    @com.byazt.phr.n(n = "sub_convert_link", qg = "DATA_SOURCE")
    public JSONObject d;

    @com.byazt.phr.n(n = "convert_from_landing_page", qg = "CONTEXT")
    public boolean fs;

    @com.byazt.phr.n(n = "req_id", qg = "DATA_SOURCE")
    public String hd;

    @com.byazt.phr.n(n = "reward_live_deep_link_params", qg = "DATA_SOURCE")
    public JSONObject k;

    @com.byazt.phr.n(n = "event_tag", qg = "CONTEXT")
    public String l;
    public df m;

    @com.byazt.phr.n(n = ImagesContract.URL, qg = "DSL")
    public String n;

    @com.byazt.phr.n(n = "if_double_deeplink", qg = "DATA_SOURCE")
    public int oa;
    public hd ou;
    public py py;

    @com.byazt.phr.n(n = "context", qg = "CONTEXT")
    public Context q;

    @com.byazt.phr.n(n = "type", qg = "DSL")
    public int qg;

    @com.byazt.phr.n(n = "convert_from_downloader", qg = "CONTEXT")
    public boolean rv;

    @com.byazt.phr.n(n = "download_conf.download_type", qg = "DATA_SOURCE")
    public int s = -1;

    @com.byazt.phr.n(n = MediationConstant.EXTRA_ADID, qg = "DATA_SOURCE")
    public String sz;

    @com.byazt.phr.n(n = "download_adapter", qg = "CONTEXT")
    public ITTInnerDownloadAdapter tj;

    @com.byazt.phr.n(n = "is_web_meta", qg = "DATA_SOURCE")
    public boolean um;

    @com.byazt.phr.n(n = "deep_link", qg = "DATA_SOURCE")
    public JSONObject w;
    public com.byazt.gct.l wm;

    @com.byazt.phr.n(n = a.C0017a.c, qg = "DATA_SOURCE")
    public JSONObject x;

    @Override // com.byazt.llp.oa, com.byazt.llp.rv
    public com.byazt.gct.l k() {
        if (this.wm == null) {
            this.wm = com.byazt.vgx.qg.qg(this.x);
        }
        return this.wm;
    }

    public JSONObject qg() {
        return this.k;
    }

    @Override // com.byazt.llp.oa, com.byazt.llp.rv, com.byazt.llp.tj
    public String q() {
        return this.sz;
    }

    public String s() {
        return this.n;
    }

    @Override // com.byazt.llp.oa
    public int w() {
        return this.s;
    }

    public boolean x() {
        return this.a;
    }

    public int fs() {
        return this.qg;
    }

    public Context getContext() {
        return this.q;
    }

    public String rv() {
        return this.l;
    }

    @Override // com.byazt.llp.oa
    public hd sz() {
        if (this.ou == null) {
            this.ou = new hd(this.w);
        }
        return this.ou;
    }

    public boolean tj() {
        return this.fs;
    }

    public boolean cp() {
        return this.rv;
    }

    public ITTInnerDownloadAdapter d() {
        return this.tj;
    }

    public String cy() {
        return this.cp;
    }

    @Override // com.byazt.llp.oa
    public py oa() {
        if (this.py == null) {
            this.py = new py(this.d, false);
        }
        return this.py;
    }

    @Override // com.byazt.llp.oa
    public boolean hd() {
        return this.oa == 1;
    }

    public JSONObject cd() {
        return this.cy;
    }

    @Override // com.byazt.llp.oa, com.byazt.llp.rv, com.byazt.llp.tj
    public String ou() {
        return this.hd;
    }

    @Override // com.byazt.llp.oa, com.byazt.llp.tj
    public int l() {
        return this.cd;
    }

    @Override // com.byazt.llp.oa
    public boolean B_() {
        return this.um;
    }

    @Override // com.byazt.llp.oa
    public df a() {
        if (this.m == null && qg() != null) {
            this.m = new df(qg());
        }
        return this.m;
    }

    @Override // com.byazt.llp.oa
    public boolean I_() {
        return cd() != null && cd().optBoolean("isValid", false);
    }

    @Override // com.byazt.llp.n
    public Map<String, String> n() {
        return new HashMap();
    }
}
