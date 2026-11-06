package com.byazt.rcj;

import android.content.Context;
import com.byazt.llp.d;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 104, 101})
public class fs implements com.byazt.wj.n {
    public final d fs;
    public Map<String, Object> l;
    public com.byazt.wj.n n;
    public String q;
    public Context qg;
    public com.byazt.vku.q.n rv;
    public boolean s;
    public final boolean tj;
    public com.byazt.dm.n w;
    public int x;

    public fs(d dVar, Context context, boolean z, String str, Map<String, Object> map, com.byazt.dm.n nVar, int i, boolean z2) {
        this.fs = dVar;
        this.qg = context;
        this.s = z;
        this.q = str;
        this.l = map;
        this.w = nVar;
        this.x = i;
        this.tj = z2;
    }

    public void n(com.byazt.vku.q.n nVar) {
        this.rv = nVar;
    }

    @Override // com.byazt.wj.n
    public boolean n(final Map<String, Object> map) {
        boolean z = false;
        boolean zN = !com.byazt.soz.l.n() ? new com.byazt.soz.l(this.fs, this.qg, this.tj).n(this.q).n(this.x).qg(this.s).n(this.l).n(new com.byazt.soz.l.n() { // from class: com.byazt.rcj.fs.1
            @Override // com.byazt.soz.l.n
            public void n() {
                if (fs.this.rv != null) {
                    fs.this.rv.n(true);
                }
            }

            @Override // com.byazt.soz.l.n
            public void n(com.byazt.wr.n nVar) {
                if (fs.this.n != null ? fs.this.n.n(map) : false) {
                    return;
                }
                com.byazt.ukb.qg.n((Map<String, Object>) fs.this.l, nVar);
                if (fs.this.tj) {
                    if (fs.this.rv != null) {
                        fs.this.rv.n(false);
                        return;
                    } else {
                        fs.this.w.qg(fs.this.l, null);
                        return;
                    }
                }
                fs.this.w.n(fs.this.l, (com.byazt.bds.n) null);
            }
        }) : false;
        com.byazt.soz.l.n(false);
        if (zN) {
            return true;
        }
        com.byazt.wj.n nVar = this.n;
        if (nVar != null && nVar.n(map)) {
            z = true;
        }
        com.byazt.vku.q.n nVar2 = this.rv;
        if (nVar2 != null) {
            nVar2.n(z);
        }
        return z;
    }
}
