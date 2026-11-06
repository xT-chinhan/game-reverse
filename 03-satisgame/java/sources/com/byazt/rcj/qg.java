package com.byazt.rcj;

import android.content.Context;
import com.byazt.gct.sz;
import com.byazt.llp.cp;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 104, 26})
public class qg implements com.byazt.wj.n {
    public com.byazt.dm.n l;
    public cp n;
    public com.byazt.wj.n q;
    public Context qg;
    public String s;
    public Map<String, Object> w;

    public qg(com.byazt.wj.n nVar, Context context, cp cpVar, String str, Map<String, Object> map, com.byazt.dm.n nVar2) {
        this.q = nVar;
        this.qg = context;
        this.n = cpVar;
        this.s = str;
        this.l = nVar2;
        this.w = map;
    }

    @Override // com.byazt.wj.n
    public boolean n(final Map<String, Object> map) {
        sz szVarUm;
        if (this.n.l() == 9 && Objects.equals(this.w.get("saas_status_while_click"), 2)) {
            szVarUm = this.n.M_() != null ? this.n.M_().qg() : null;
        } else {
            szVarUm = this.n.um();
        }
        if (!com.byazt.soz.s.n(szVarUm, false)) {
            com.byazt.wj.n nVar = this.q;
            return nVar != null && nVar.n(map);
        }
        if (com.byazt.ep.cp.l(com.byazt.ukb.qg.n(this.n, this.w))) {
            com.byazt.wj.n nVar2 = this.q;
            return nVar2 != null && nVar2.n(map);
        }
        if (com.byazt.ep.cp.q(com.byazt.ukb.qg.n(this.n, this.w))) {
            com.byazt.wj.n nVar3 = this.q;
            return nVar3 != null && nVar3.n(map);
        }
        new com.byazt.soz.s(this.n, szVarUm, this.qg, this.w).n(this.s).n(new com.byazt.soz.s.n() { // from class: com.byazt.rcj.qg.1
            @Override // com.byazt.soz.s.n
            public void n() {
                if (qg.this.q.n(map)) {
                    return;
                }
                qg.this.l.n(qg.this.w, (com.byazt.bds.n) null);
            }
        });
        return true;
    }
}
