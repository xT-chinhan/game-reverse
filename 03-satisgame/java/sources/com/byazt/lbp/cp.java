package com.byazt.lbp;

import android.content.Context;
import android.view.View;
import com.byazt.gct.pk;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, 29})
public class cp implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = "live_saas_interaction_type", qg = "ALL")
    public int l = -1;

    @com.byazt.phr.n(n = "material_meta", qg = "ALL")
    public pk n;

    @com.byazt.phr.n(n = "dpa_tag", qg = "ALL")
    public String q;

    @com.byazt.phr.n(n = "context", qg = "ALL")
    public Context qg;

    @com.byazt.phr.n(n = "event_tag", qg = "ALL")
    public String s;

    @com.byazt.phr.n(n = "view", qg = "ALL")
    public View w;

    @com.byazt.phr.n(n = "handle_chain_data", qg = "ALL")
    public Map<String, Object> x;

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        int iS;
        if (!n()) {
            nVar.n(map2, (com.byazt.bds.n) null);
            return true;
        }
        if (this.n.yx() != -1001) {
            iS = this.n.yx();
        } else {
            iS = com.byazt.wq.qg.n().s();
            this.n.el(iS);
        }
        map2.put("saas_status_while_click", Integer.valueOf(iS));
        com.byazt.rcj.w wVar = new com.byazt.rcj.w(this.n, this.qg, this.s, this.q, map2);
        int i = this.l;
        if (i != -1) {
            wVar.qg(i);
        }
        wVar.n(this.w);
        wVar.qg(this.x);
        if (new com.byazt.rcj.qg(new com.byazt.rcj.l(wVar, this.n, nVar, map2, this.s), this.qg, this.n, this.s, map2, nVar).n(new HashMap())) {
            nVar.n(map2);
            return false;
        }
        nVar.n(map2, (com.byazt.bds.n) null);
        return false;
    }

    private boolean n() {
        return (this.n == null || this.qg == null) ? false : true;
    }
}
