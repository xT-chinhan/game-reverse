package com.byazt.lbp;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.f.a;
import com.byazt.gct.pk;
import com.byazt.gct.um;
import com.byazt.hj.DownloadStatusChangeListener;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, 21})
public class x implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = "download_conf", qg = "ALL")
    public JSONObject cp;

    @com.byazt.phr.n(n = a.C0017a.c, qg = "ALL")
    public JSONObject d;

    @com.byazt.phr.n(n = "is_open_market_intercept_for_dsp", qg = "ALL")
    public volatile boolean fs;

    @com.byazt.phr.n(n = "enable_update_download_model", qg = "ALL")
    public boolean k;

    @com.byazt.phr.n(n = "download_status_listener", qg = "ALL")
    public DownloadStatusChangeListener l;

    @com.byazt.phr.n(n = "material_meta", qg = "ALL")
    public pk n;

    @com.byazt.phr.n(n = "dialog_to_landing_page_convert", qg = "ALL")
    public com.byazt.wj.n oa;

    @com.byazt.phr.n(n = "event_tag", qg = "ALL")
    public String q;

    @com.byazt.phr.n(n = "context", qg = "ALL")
    public Context qg;

    @com.byazt.phr.n(n = "is_click_button", qg = "ALL")
    public volatile boolean rv;

    @com.byazt.phr.n(n = "pip_controller", qg = "ALL")
    public com.byazt.zx.qg sz;

    @com.byazt.phr.n(n = SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, qg = "ALL")
    public String tj;

    @com.byazt.phr.n(n = "download_popup_manager", qg = "ALL")
    public com.byazt.wif.s w;

    @com.byazt.phr.n(n = "convert_from_landing_page", qg = "ALL")
    public volatile boolean s = false;

    @com.byazt.phr.n(n = "need_check_compliance", qg = "ALL")
    public int x = 0;

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        if (!n()) {
            nVar.n(map2, (com.byazt.bds.n) null);
            return true;
        }
        int iQ = com.byazt.rcj.n.q(map2);
        com.byazt.rcj.q qVar = new com.byazt.rcj.q(this.n, this.qg, this.q, this.w, this.tj, this.k, map2, false);
        qVar.qg(this.rv);
        qVar.n(this.fs, iQ);
        qVar.n(this.l);
        qVar.n(this.s);
        qVar.n(this.x);
        qVar.n(this.oa);
        qVar.n(new um(this.cp));
        if (new com.byazt.xwj.qg(qVar, this.sz).n(map2)) {
            nVar.n(map2);
        } else {
            nVar.n(map2, (com.byazt.bds.n) null);
        }
        return true;
    }

    private boolean n() {
        if (this.n == null || this.qg == null) {
            return false;
        }
        if (TextUtils.isEmpty(this.tj)) {
            com.byazt.gct.l lVarQg = com.byazt.vgx.qg.qg(this.d);
            if (lVarQg != null) {
                this.tj = lVarQg.qg();
            }
            if (TextUtils.isEmpty(this.tj)) {
                return false;
            }
        }
        return (TextUtils.isEmpty(this.q) || this.w == null) ? false : true;
    }
}
