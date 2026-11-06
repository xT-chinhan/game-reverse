package com.byazt.msp;

import android.text.TextUtils;
import com.byazt.ej.tj;
import com.byazt.ep.cp;
import com.byazt.fvm.sz;
import com.byazt.gct.dw;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.v;
import com.byazt.nf.rv;
import com.byazt.za.h;
import com.byazt.za.hu;
import com.byazt.za.m;
import com.byazt.za.t;
import com.byazt.za.ur;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 107, 5})
public class q extends qg<List<sz>> {
    public List<Long> qg;
    public final int s;

    @Override // com.byazt.msp.qg
    public /* bridge */ /* synthetic */ void n(com.byazt.zq.qg qgVar, List list, List<sz> list2) {
        n2(qgVar, (List<pk>) list, list2);
    }

    public q(com.byazt.gzx.qg qgVar, int i) {
        super(qgVar);
        this.qg = new CopyOnWriteArrayList();
        this.s = i;
    }

    @Override // com.byazt.msp.qg
    public void n(final com.byazt.zq.qg qgVar, final List<pk> list, final qg.n<List<sz>> nVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.qg.add(Long.valueOf(jCurrentTimeMillis));
        final int[] iArr = {0};
        final int[] iArr2 = {list.size()};
        if (rv.qg().mq() > 0) {
            com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.msp.q.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (this) {
                        if (q.this.qg.contains(Long.valueOf(jCurrentTimeMillis))) {
                            q.this.qg.remove(Long.valueOf(jCurrentTimeMillis));
                            q.this.qg(qgVar, list, nVar);
                        }
                    }
                }
            }, rv.qg().mq());
        }
        Iterator<pk> it = list.iterator();
        while (it.hasNext()) {
            final long j = jCurrentTimeMillis;
            n(it.next(), new com.byazt.ep.s() { // from class: com.byazt.msp.q.2
                @Override // com.byazt.ep.s
                public void n(String str) {
                    synchronized (this) {
                        int[] iArr3 = iArr;
                        int i = iArr3[0] + 1;
                        iArr3[0] = i;
                        q.this.n(j, qgVar, (List<pk>) list, (qg.n<List<sz>>) nVar, i, iArr2[0]);
                    }
                }

                @Override // com.byazt.ep.s
                public void n() {
                    synchronized (this) {
                        int[] iArr3 = iArr2;
                        int i = iArr3[0] - 1;
                        iArr3[0] = i;
                        q.this.n(j, qgVar, (List<pk>) list, (qg.n<List<sz>>) nVar, iArr[0], i);
                    }
                }
            });
            jCurrentTimeMillis = jCurrentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j, com.byazt.zq.qg qgVar, List<pk> list, qg.n<List<sz>> nVar, int i, int i2) {
        if (this.qg.contains(Long.valueOf(j))) {
            if (rv.qg().hz() != 1 || i == i2) {
                this.qg.remove(Long.valueOf(j));
                qg(qgVar, list, nVar);
            }
        }
    }

    private void n(pk pkVar, com.byazt.ep.s sVar) {
        if (nf.d(pkVar)) {
            com.byazt.ns.n.n(pkVar, sVar);
            return;
        }
        if (nf.cp(pkVar)) {
            dw dwVarX = nf.x(pkVar);
            if (dwVarX != null) {
                cp.n(dwVarX.rv(), dwVarX.tj(), sVar);
                return;
            }
            return;
        }
        sVar.n(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final com.byazt.zq.qg qgVar, final List<pk> list, final qg.n<List<sz>> nVar) {
        com.byazt.ag.qg.s(new Runnable() { // from class: com.byazt.msp.q.3
            @Override // java.lang.Runnable
            public void run() {
                q.this.n(qgVar, list, nVar, new ArrayList(), 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final com.byazt.zq.qg qgVar, final List<pk> list, final qg.n<List<sz>> nVar, final List<sz> list2, final int i) {
        if (i >= list.size()) {
            if (nVar != null) {
                nVar.n(list2);
                return;
            }
            return;
        }
        sz szVarN = n(qgVar, list.get(i));
        if (szVarN != null) {
            list2.add(szVarN);
        }
        if (rv.qg().lx() && com.byazt.ag.qg.n()) {
            com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.msp.q.4
                @Override // java.lang.Runnable
                public void run() {
                    q.this.n(qgVar, list, nVar, list2, i + 1);
                }
            });
        } else {
            n(qgVar, list, nVar, list2, i + 1);
        }
    }

    /* JADX INFO: renamed from: n, reason: avoid collision after fix types in other method */
    public void n2(com.byazt.zq.qg qgVar, List<pk> list, List<sz> list2) {
        for (int i = 0; i < list2.size(); i++) {
            sz szVar = list2.get(i);
            pk pkVar = list.get(i);
            if (this.n != null) {
                this.n.qg().n(qgVar, pkVar, (Object) szVar, false);
            }
        }
    }

    private sz n(com.byazt.zq.qg qgVar, pk pkVar) {
        boolean z = ta.k(pkVar) != null;
        int i = this.s;
        if (i == 1) {
            if (z) {
                return new hu(rv.getContext(), pkVar, qgVar);
            }
            return new m(rv.getContext(), pkVar, qgVar);
        }
        if (i != 5) {
            if (i != 9) {
                return null;
            }
            return new t(rv.getContext(), pkVar, qgVar, this.s);
        }
        if (z) {
            return new ur(rv.getContext(), pkVar, qgVar, this.s);
        }
        return new h(rv.getContext(), pkVar, qgVar, this.s);
    }

    @Override // com.byazt.msp.qg, com.byazt.yxf.n
    public void n(int i, com.byazt.zq.qg qgVar, pk pkVar) {
        int i2;
        if (pkVar == null) {
            return;
        }
        String strL = (qgVar == null || !((i2 = this.s) == 3 || i2 == 4)) ? null : com.byazt.ql.qg.l();
        com.byazt.gks.n.qg(pkVar);
        if (pkVar.os() && pkVar.jo() != null && !pkVar.jo().isEmpty()) {
            for (v vVar : pkVar.jo()) {
                if (!TextUtils.isEmpty(vVar.n())) {
                    com.byazt.mw.s.n().s().n(new com.byazt.imu.q(vVar.n(), vVar.x()), com.byazt.qdx.n.qg(), vVar.qg(), vVar.s(), strL);
                }
            }
        }
        if (TextUtils.isEmpty(ta.n(pkVar))) {
            return;
        }
        if (rv.qg().q(String.valueOf(com.byazt.vgx.w.cy(pkVar))) && rv.qg().qf()) {
            com.byazt.zsl.l lVarN = ta.n(4, pkVar);
            lVarN.n("material_meta", pkVar);
            lVarN.n("ad_slot", Integer.valueOf(i));
            com.byazt.gks.s.n(lVarN, (tj.n) null);
            com.byazt.gks.s.n(pkVar, lVarN);
        }
    }
}
