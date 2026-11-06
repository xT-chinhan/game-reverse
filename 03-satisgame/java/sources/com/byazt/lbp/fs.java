package com.byazt.lbp;

import android.content.Context;
import com.byazt.gct.pk;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, 101})
public class fs implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = "dynamic_download_dialog_type", qg = "ALL")
    public int cp;

    @com.byazt.phr.n(n = "is_direct_download", qg = "ALL")
    public boolean d;

    @com.byazt.phr.n(n = "start_download_listener", qg = "ALL")
    public com.byazt.pma.qg fs;

    @com.byazt.phr.n(n = "app_manage_model", qg = "ALL")
    public com.byazt.gct.q l;

    @com.byazt.phr.n(n = "convert_from_landing_page", qg = "ALL")
    public boolean n;

    @com.byazt.phr.n(n = "download_dialog_listener", qg = "ALL")
    public com.byazt.pma.n oa;

    @com.byazt.phr.n(n = "is_app_market_convert", qg = "ALL")
    public boolean q;

    @com.byazt.phr.n(n = "context", qg = "ALL")
    public Context qg;

    @com.byazt.phr.n(n = "is_show_download_dialog", qg = "ALL")
    public boolean rv = true;

    @com.byazt.phr.n(n = "material_meta", qg = "ALL")
    public pk s;

    @com.byazt.phr.n(n = "is_from_new_click_event", qg = "ALL")
    public boolean tj;

    @com.byazt.phr.n(n = "event_tag", qg = "ALL")
    public String w;

    @com.byazt.phr.n(n = SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, qg = "ALL")
    public String x;

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        com.byazt.wif.s sVar = new com.byazt.wif.s(this.qg, this.s);
        sVar.s(this.d);
        sVar.n(this.rv);
        sVar.n(this.cp);
        sVar.qg(this.tj);
        sVar.n(this.oa);
        sVar.n(n());
        if (!sVar.q(false)) {
            nVar.n(map2, (com.byazt.bds.n) null);
            return true;
        }
        sVar.n(this.l, this.w, this.x, this.fs);
        nVar.n(map2);
        return true;
    }

    private com.byazt.wif.n n() {
        if (this.q) {
            return new com.byazt.wif.l();
        }
        if (this.n) {
            return new com.byazt.wif.q();
        }
        return new com.byazt.wif.qg();
    }
}
