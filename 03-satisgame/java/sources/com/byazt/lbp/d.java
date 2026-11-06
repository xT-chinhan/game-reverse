package com.byazt.lbp;

import android.content.Context;
import com.byazt.gct.pk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, 113})
public class d implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = "wc_miniapp_info", qg = "ALL")
    public JSONObject l;

    @com.byazt.phr.n(n = "material_meta", qg = "ALL")
    public pk n;

    @com.byazt.phr.n(n = "event_tag", qg = "ALL")
    public String q;

    @com.byazt.phr.n(n = "context", qg = "ALL")
    public Context qg;

    @com.byazt.phr.n(n = "convert_from_landing_page", qg = "ALL")
    public boolean s;

    @com.byazt.phr.n(n = "landing_page_source", qg = "ALL")
    public int w;

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        if (!n()) {
            nVar.n(map2, (com.byazt.bds.n) null);
            return true;
        }
        if (new com.byazt.rcj.fs(this.n, this.qg, this.s, this.q, map2, nVar, this.w, false).n(new HashMap())) {
            nVar.n(map2);
        } else {
            nVar.n(map2, (com.byazt.bds.n) null);
        }
        return true;
    }

    private boolean n() {
        return (this.n == null || this.qg == null || this.l == null) ? false : true;
    }
}
