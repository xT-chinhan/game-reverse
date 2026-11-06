package com.byazt.llp;

import android.content.Context;
import com.anythink.core.common.f.a;
import com.byazt.gct.um;
import com.byazt.hj.DownloadStatusChangeListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 2088, 26})
public class qg implements n, rv {

    @com.byazt.phr.n(n = "app_manage", qg = "DATA_SOURCE")
    public JSONObject a;

    @com.byazt.phr.n(n = "if_both_open", qg = "DATA_SOURCE")
    public int cd;

    @com.byazt.phr.n(n = SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, qg = "CONTEXT")
    public String cp;

    @com.byazt.phr.n(n = "ext", qg = "DATA_SOURCE")
    public String cy;

    @com.byazt.phr.n(n = "download_conf", qg = "DATA_SOURCE")
    public JSONObject d;
    public um h;

    @com.byazt.phr.n(n = MediationConstant.EXTRA_ADID, qg = "DATA_SOURCE")
    public String hd;
    public com.byazt.gct.w hu;

    @com.byazt.phr.n(n = "pip_controller", qg = "CONTEXT")
    public com.byazt.zx.qg k;

    @com.byazt.phr.n(n = "download_popup_manager", qg = "CONTEXT")
    public com.byazt.wif.s l;

    @com.byazt.phr.n(n = "market_url", qg = "DATA_SOURCE")
    public String m;

    @com.byazt.phr.n(n = "id", qg = "DSL")
    public String n;

    @com.byazt.phr.n(n = a.C0017a.c, qg = "DATA_SOURCE")
    public JSONObject oa;

    @com.byazt.phr.n(n = "union_session_key", qg = "DATA_SOURCE")
    public String ou;

    @com.byazt.phr.n(n = "enable_update_download_model", qg = "CONTEXT")
    public boolean py;

    @com.byazt.phr.n(n = "download_status_listener", qg = "CONTEXT")
    public DownloadStatusChangeListener q;

    @com.byazt.phr.n(n = ImagesContract.URL, qg = "DSL")
    public String qg;

    @com.byazt.phr.n(n = "is_open_market_intercept_for_dsp", qg = "CONTEXT")
    public volatile boolean rv;

    @com.byazt.phr.n(n = "event_tag", qg = "CONTEXT")
    public String s;

    @com.byazt.phr.n(n = "dialog_to_landing_page_convert", qg = "CONTEXT")
    public com.byazt.wj.n sz;
    public com.byazt.gct.l t;

    @com.byazt.phr.n(n = "is_click_button", qg = "CONTEXT")
    public volatile boolean tj;

    @com.byazt.phr.n(n = "not_valid_download_url", qg = "DATA_SOURCE")
    public boolean um;

    @com.byazt.phr.n(n = "context", qg = "CONTEXT")
    public Context w;

    @com.byazt.phr.n(n = "req_id", qg = "DATA_SOURCE")
    public String wm;

    @com.byazt.phr.n(n = "convert_from_landing_page", qg = "CONTEXT")
    public volatile boolean x = false;

    @com.byazt.phr.n(n = "need_check_compliance", qg = "CONTEXT")
    public int fs = 0;

    @Override // com.byazt.llp.rv
    public boolean K_() {
        return this.um;
    }

    @Override // com.byazt.llp.rv
    public boolean G_() {
        return this.cd == 1;
    }

    @Override // com.byazt.llp.rv, com.byazt.llp.tj
    public String q() {
        return this.hd;
    }

    public String l() {
        return this.cy;
    }

    @Override // com.byazt.llp.rv
    public JSONObject A_() {
        try {
            return new JSONObject(l());
        } catch (JSONException unused) {
            return null;
        }
    }

    public Context getContext() {
        return this.w;
    }

    public boolean x() {
        return this.x;
    }

    public String fs() {
        return this.s;
    }

    public DownloadStatusChangeListener rv() {
        return this.q;
    }

    public com.byazt.wif.s tj() {
        return this.l;
    }

    public int cp() {
        return this.fs;
    }

    public boolean d() {
        return this.rv;
    }

    public boolean oa() {
        return this.tj;
    }

    public String sz() {
        return this.cp;
    }

    public void n(String str) {
        this.cp = str;
    }

    @Override // com.byazt.llp.rv
    public com.byazt.gct.l k() {
        JSONObject jSONObject;
        if (this.t == null && (jSONObject = this.oa) != null) {
            com.byazt.gct.l lVarQg = com.byazt.vgx.qg.qg(jSONObject);
            this.t = lVarQg;
            lVarQg.q(this.n);
            this.t.qg(this.qg);
        }
        return this.t;
    }

    public com.byazt.wj.n cy() {
        return this.sz;
    }

    public com.byazt.zx.qg hd() {
        return this.k;
    }

    @Override // com.byazt.llp.rv
    public com.byazt.gct.w cd() {
        if (this.hu == null && this.a != null) {
            this.hu = new com.byazt.gct.w(this.a);
        }
        return this.hu;
    }

    @Override // com.byazt.llp.rv
    public um D_() {
        if (this.h == null && this.d != null) {
            this.h = new um(this.d);
        }
        return this.h;
    }

    public boolean a() {
        return this.py;
    }

    @Override // com.byazt.llp.rv, com.byazt.llp.tj
    public String py() {
        return this.ou;
    }

    @Override // com.byazt.llp.rv, com.byazt.llp.tj
    public String ou() {
        return this.wm;
    }

    @Override // com.byazt.llp.rv
    public String wm() {
        return A_() != null ? A_().optString(MediationConstant.EXTRA_ADID) : "";
    }

    @Override // com.byazt.llp.rv
    public String m() {
        return this.m;
    }

    @Override // com.byazt.llp.n
    public Map<String, String> n() {
        return new HashMap();
    }
}
