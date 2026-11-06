package com.byazt.rcj;

import com.byazt.llp.cp;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 104, 18})
public class l implements com.byazt.wj.n {
    public cp l;
    public com.byazt.wj.n n;
    public String q;
    public com.byazt.dm.n qg;
    public Map<String, Object> s;

    public l(com.byazt.wj.n nVar, cp cpVar, com.byazt.dm.n nVar2, Map<String, Object> map, String str) {
        this.l = cpVar;
        this.n = nVar;
        this.qg = nVar2;
        this.s = map;
        this.q = str;
    }

    @Override // com.byazt.wj.n
    public boolean n(final Map<String, Object> map) {
        int iN = com.byazt.wq.qg.n().n(this.l, new com.byazt.op.s() { // from class: com.byazt.rcj.l.1
            @Override // com.byazt.op.s
            public void n(int i) {
                if (l.this.n != null && l.this.n.n(map)) {
                    return;
                }
                l.this.qg.n(l.this.s, (com.byazt.bds.n) null);
            }
        }, this.q, this.s);
        if (iN == 1 || iN == 2) {
            n();
            return true;
        }
        com.byazt.wj.n nVar = this.n;
        return nVar != null && nVar.n(map);
    }

    private void n() {
        Map<String, Object> map;
        Map<String, Object> map2 = this.s;
        if (map2 != null) {
            Object obj = map2.get("click_chain");
            Object obj2 = this.s.get("handle_chain_data");
            if (obj == null || !(obj instanceof com.byazt.dj.s)) {
                return;
            }
            com.byazt.dj.s sVar = (com.byazt.dj.s) obj;
            com.byazt.fq.n nVar = (com.byazt.fq.n) sVar.n(com.byazt.fq.n.class);
            if (nVar != null) {
                if (obj2 != null && (obj2 instanceof Map)) {
                    map = (Map) obj2;
                } else {
                    map = new HashMap<>();
                }
                nVar.n(map, sVar);
            }
        }
    }
}
