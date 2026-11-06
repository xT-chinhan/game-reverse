package com.byazt.msp;

import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.common.d.f;
import com.byazt.ej.tj;
import com.byazt.gct.fs;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.y;
import com.byazt.gzx.x;
import com.byazt.nf.rv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 107, 26})
public abstract class qg<V> extends com.byazt.yxf.n<V> {
    public com.byazt.gzx.qg n;

    public interface n<V> {
        void n(V v);
    }

    public abstract void n(com.byazt.zq.qg qgVar, List<pk> list, n<V> nVar);

    public abstract void n(com.byazt.zq.qg qgVar, List<pk> list, V v);

    @Override // com.byazt.yxf.n
    public boolean n(com.byazt.zq.qg qgVar, List<pk> list) {
        return true;
    }

    public qg(com.byazt.gzx.qg qgVar) {
        this.n = qgVar;
    }

    @Override // com.byazt.yxf.n
    public void n(com.byazt.zq.qg qgVar, int i, String str, com.byazt.gct.qg qgVar2) {
        qgVar2.n(i);
        com.byazt.gct.qg.n(qgVar2);
    }

    @Override // com.byazt.yxf.n
    public void n(int i, com.byazt.gct.n nVar, com.byazt.gct.qg qgVar, y yVar, com.byazt.zq.qg qgVar2, com.byazt.gzx.l<V> lVar, x xVar) {
        if (nVar.qg() == null || nVar.qg().isEmpty()) {
            if (xVar != null) {
                xVar.n(-3);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (nVar.qg().size() > 1) {
            if (fs.n(i).n("mix_ad", new fs.qg.n().n(qgVar2).n(nVar.qg().get(0)).n())) {
                com.byazt.vgx.qg.n(nVar.qg());
                arrayList.add(nVar.qg().get(0));
            } else {
                arrayList.addAll(nVar.qg());
            }
        } else {
            arrayList.addAll(nVar.qg());
        }
        for (pk pkVar : arrayList) {
            if (pkVar.os()) {
                if (pkVar.aj() <= 0) {
                    pkVar.l((System.currentTimeMillis() + 10500000) / 1000);
                }
                pkVar.y(102);
                n(i, qgVar2, pkVar);
            }
            if (yVar != null && !TextUtils.isEmpty(yVar.um)) {
                pkVar.n(yVar.um);
            }
        }
        if (arrayList.isEmpty()) {
            if (xVar != null) {
                xVar.n(-4);
            }
        } else {
            com.byazt.uq.qg.n(arrayList, yVar != null ? yVar.um : null);
            Bundle bundle = new Bundle();
            bundle.putLong(f.a, yVar.rv);
            bundle.putBoolean("is_second_page_ad", yVar.hd > 0);
            n(i, arrayList, qgVar2, lVar, bundle, xVar);
        }
    }

    @Override // com.byazt.yxf.n
    public void n(final int i, final List<pk> list, final com.byazt.zq.qg qgVar, final com.byazt.gzx.l<V> lVar, final Bundle bundle, final x xVar) {
        boolean z = bundle.getBoolean("is_cache", false);
        Iterator<pk> it = list.iterator();
        while (it.hasNext()) {
            it.next().d(z);
        }
        n(qgVar, list, (n) new n<V>() { // from class: com.byazt.msp.qg.1
            @Override // com.byazt.msp.qg.n
            public void n(V v) {
                com.byazt.gzx.s sVarN = qg.this.n(i, qgVar, v, (List<pk>) list, bundle, lVar);
                x xVar2 = xVar;
                if (xVar2 != null) {
                    xVar2.n(sVarN);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gzx.s n(final int i, final com.byazt.zq.qg qgVar, final V v, final List<pk> list, Bundle bundle, final com.byazt.gzx.l<V> lVar) {
        final long j = bundle.getLong(f.a);
        final boolean z = bundle.getBoolean("is_cache");
        final boolean z2 = bundle.getBoolean("is_second_page_ad", false);
        Iterator<pk> it = list.iterator();
        while (it.hasNext()) {
            it.next().kx().qg();
        }
        final pk pkVar = list.get(0);
        return new com.byazt.gzx.s() { // from class: com.byazt.msp.qg.2
            public final AtomicBoolean cp = new AtomicBoolean(false);

            @Override // com.byazt.gzx.s
            public void qg() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.byazt.gzx.s
            public void n() {
                if (!z2) {
                    qg.this.n(qgVar, (List<pk>) list, v);
                }
                com.byazt.hm.n.qg(pkVar, com.byazt.vgx.w.qg(i), j);
                if (lVar != null) {
                    com.byazt.nj.q.n((List<pk>) list);
                    lVar.n(v, z, pkVar);
                }
            }

            @Override // com.byazt.gzx.s
            public void s() {
                if (this.cp.compareAndSet(false, true)) {
                    qg.this.n(z, qgVar, list);
                }
            }
        };
    }

    public void n(boolean z, com.byazt.zq.qg qgVar, List<pk> list) {
        if (z) {
            com.byazt.gzx.qg qgVar2 = this.n;
            if (qgVar2 != null) {
                qgVar2.qg().qg(qgVar, list);
                return;
            }
            return;
        }
        com.byazt.gzx.qg qgVar3 = this.n;
        if (qgVar3 != null) {
            qgVar3.qg().n(qgVar, list);
        }
    }

    @Override // com.byazt.yxf.n
    public void n(final int i, com.byazt.zq.qg qgVar, final pk pkVar) {
        com.byazt.ag.qg.n(new com.byazt.qit.x("preloadResOnMetaCreated") { // from class: com.byazt.msp.qg.3
            @Override // java.lang.Runnable
            public void run() {
                if ((!pk.n(pkVar) || com.byazt.ql.s.n(pkVar)) && !TextUtils.isEmpty(ta.n(pkVar))) {
                    if (rv.qg().q(String.valueOf(com.byazt.vgx.w.cy(pkVar))) && rv.qg().qf()) {
                        if (ta.k(pkVar) != null) {
                            ta.k(pkVar).w(1);
                        }
                        if (ta.cy(pkVar) != null) {
                            ta.cy(pkVar).w(1);
                        }
                        com.byazt.zsl.l lVarN = ta.n(4, pkVar);
                        lVarN.n("material_meta", pkVar);
                        lVarN.n("ad_slot", Integer.valueOf(i));
                        com.byazt.gks.s.n(lVarN, (tj.n) null);
                        com.byazt.gks.s.n(pkVar, lVarN);
                    }
                }
            }
        });
    }
}
