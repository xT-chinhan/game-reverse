package com.byazt.hcw;

import android.text.TextUtils;
import com.byazt.pq.a;
import com.byazt.pq.bb;
import com.byazt.pq.h;
import com.byazt.pq.ou;
import com.byazt.pq.py;
import com.byazt.pq.t;
import com.byazt.pq.wm;
import com.byazt.tbt.d;
import com.byazt.tbt.k;
import com.byazt.tbt.sz;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 95, 13})
public class w extends d {
    public wm d;
    public com.byazt.tbt.q oa;

    public w(d.n nVar) {
        super(nVar);
        n(nVar);
        this.oa = new x(this.d);
    }

    private void n(d.n nVar) {
        wm.n nVar2 = new wm.n();
        nVar2.m = (int) nVar.s;
        nVar2.ln = nVar.q;
        nVar2.hu = (int) nVar.l;
        nVar2.lh = nVar.w;
        nVar2.h = (int) nVar.x;
        nVar2.v = nVar.fs;
        nVar2.bb = nVar.tj;
        nVar2.ur = nVar.cp;
        nVar2.n(new s(nVar.qg));
        List<com.byazt.tbt.rv> list = nVar.n;
        if (list != null && !list.isEmpty()) {
            for (final com.byazt.tbt.rv rvVar : list) {
                nVar2.n(new a() { // from class: com.byazt.hcw.w.1
                    @Override // com.byazt.pq.a
                    public bb n(a.n nVar3) throws IOException {
                        return ((rv) rvVar.n(new l(nVar3))).n;
                    }
                });
            }
        }
        this.d = nVar2.n();
    }

    @Override // com.byazt.tbt.d
    public com.byazt.tbt.q n() {
        return this.oa;
    }

    @Override // com.byazt.tbt.d
    public com.byazt.tbt.qg n(sz szVar) {
        if (szVar == null) {
            return null;
        }
        h.n nVar = new h.n();
        nVar.n(szVar.n());
        nVar.s(szVar.l());
        if (szVar.s() != null) {
            nVar.n(szVar.s());
        }
        if (szVar.fs() != null) {
            if (s(szVar.fs())) {
                nVar.n(szVar.q(), t.n(py.n(szVar.fs().s.toString()), szVar.fs().q));
            } else if (n(szVar.fs())) {
                nVar.n(szVar.q(), new ou.n().n(ou.l).n(szVar.fs().qg(), szVar.fs().n(), t.n(py.n("multipart/form-data"), szVar.fs().l)).n());
            } else if (qg(szVar.fs())) {
                nVar.n(szVar.q(), t.n(py.n(szVar.fs().s.toString()), szVar.fs().l));
            }
        }
        if (szVar.x() != null && szVar.x().n) {
            nVar.n(new com.byazt.pq.q.n().n().s());
        }
        if (szVar.w() != null && szVar.w().size() > 0) {
            for (Map.Entry<String, List<String>> entry : szVar.w().entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    nVar.n(entry.getKey(), it.next());
                }
            }
        }
        return new q(this.d.n(nVar.n()));
    }

    private boolean n(k kVar) {
        return kVar != null && kVar.w == k.n.FILE_TYPE && kVar.l != null && kVar.l.length > 0;
    }

    private boolean qg(k kVar) {
        return kVar != null && kVar.w == k.n.BYTE_ARRAY_TYPE && kVar.l != null && kVar.l.length > 0;
    }

    private boolean s(k kVar) {
        return (kVar == null || kVar.w != k.n.STRING_TYPE || TextUtils.isEmpty(kVar.q)) ? false : true;
    }
}
