package com.byazt.gzx;

import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.common.d.f;
import com.byazt.gct.pk;
import com.byazt.gct.y;
import com.byazt.nf.rv;
import com.byazt.tk.hd;
import com.byazt.tk.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1081, 5})
public class q<T> extends qg {
    public final long qg;

    private interface n {
        void n(boolean z);
    }

    public q(int i) {
        super(i);
        this.qg = System.currentTimeMillis();
    }

    public void n(final com.byazt.zq.qg qgVar, final y yVar, final l<T> lVar) {
        com.byazt.ag.qg.l(new Runnable() { // from class: com.byazt.gzx.q.1
            @Override // java.lang.Runnable
            public void run() {
                q.this.qg(qgVar, yVar, new w(lVar));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    public void qg(com.byazt.zq.qg qgVar, y yVar, l<T> lVar) {
        if (qgVar == null) {
            return;
        }
        int iS = s();
        int i = 0;
        if (yVar.a) {
            iS = 0;
        }
        if (com.byazt.gct.fs.n(this.n).n("load_only_online", new com.byazt.gct.fs.qg.n().n(qgVar).n())) {
            iS = 0;
        }
        try {
            fs.n nVarN = fs.n(qgVar.q());
            if (nVarN != null) {
                yVar.py = nVarN.n;
                yVar.ou = nVarN.qg;
                if (nVarN.n == 1 || nVarN.qg == 1) {
                    try {
                        qgVar.q();
                    } catch (Throwable unused) {
                    }
                } else {
                    i = iS;
                }
            } else {
                i = iS;
            }
        } catch (Throwable unused2) {
        }
        qgVar.q();
        if (i == 0) {
            q(qgVar, lVar, yVar);
            return;
        }
        if (i == 1) {
            n(qgVar, lVar, yVar);
            return;
        }
        if (i == 2) {
            qg(qgVar, lVar, yVar);
            return;
        }
        if (i == 3) {
            s(qgVar, lVar, yVar);
            return;
        }
        if (i == 4) {
            l(qgVar, lVar, yVar);
        } else if (i == 5) {
            x(qgVar, lVar, yVar);
        } else {
            k.qg("cache_tag", "仅实时：走到了兜底逻辑，预期不会走到！！！");
            q(qgVar, lVar, yVar);
        }
    }

    private void n(final com.byazt.zq.qg qgVar, final l<T> lVar, final y yVar) {
        final com.byazt.fli.n nVar = new com.byazt.fli.n(lVar, n()) { // from class: com.byazt.gzx.q.6
            @Override // com.byazt.fli.n
            public void n() {
                q.this.n(qgVar, lVar, yVar, this);
            }
        };
        n(qgVar, lVar, yVar, yVar.x == 2, nVar, 0L, new n() { // from class: com.byazt.gzx.q.7
            @Override // com.byazt.gzx.q.n
            public void n(boolean z) {
                if (z) {
                    return;
                }
                nVar.n(false);
            }
        });
    }

    private void qg(com.byazt.zq.qg qgVar, l<T> lVar, y yVar) {
        final com.byazt.fli.q qVar = new com.byazt.fli.q(lVar, n(), this.n, qgVar.q());
        qVar.n();
        n(qgVar, lVar, yVar, qVar);
        n(qgVar, lVar, yVar, yVar.x == 2, qVar, 0L, new n() { // from class: com.byazt.gzx.q.8
            @Override // com.byazt.gzx.q.n
            public void n(boolean z) {
                qVar.n(true);
            }
        });
    }

    private void s(com.byazt.zq.qg qgVar, l<T> lVar, y yVar) {
        final com.byazt.fli.s sVar = new com.byazt.fli.s(lVar, n());
        n(qgVar, lVar, yVar, sVar);
        n(qgVar, lVar, yVar, yVar.x == 2, sVar, 0L, new n() { // from class: com.byazt.gzx.q.9
            @Override // com.byazt.gzx.q.n
            public void n(boolean z) {
                if (z) {
                    return;
                }
                sVar.n(false);
            }
        });
    }

    private void q(com.byazt.zq.qg qgVar, l<T> lVar, y yVar) {
        n(qgVar, lVar, yVar, (com.byazt.fli.qg) null);
    }

    private void l(com.byazt.zq.qg qgVar, final l<T> lVar, y yVar) {
        n(qgVar, lVar, yVar, yVar.x == 2, (com.byazt.fli.qg) null, 0L, new n() { // from class: com.byazt.gzx.q.10
            @Override // com.byazt.gzx.q.n
            public void n(boolean z) {
                if (z) {
                    return;
                }
                lVar.n(-3, "no cache");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final com.byazt.zq.qg qgVar, l<T> lVar, y yVar) {
        long jCurrentTimeMillis;
        final com.byazt.gct.fs.l lVarCp = n().cp();
        final com.byazt.msp.w.n nVarN = com.byazt.msp.w.n(qgVar.q(), lVarCp);
        final com.byazt.fli.q qVar = new com.byazt.fli.q(lVar, n(), this.n, qgVar.q());
        qVar.n();
        n(qgVar, lVar, yVar, qVar);
        qgVar.q();
        final int iN = nVarN.n(lVarCp.l(), lVarCp);
        if (iN < 0) {
            qgVar.q();
            qVar.n(false);
            return;
        }
        if (iN > 0) {
            jCurrentTimeMillis = System.currentTimeMillis() - ((((long) iN) * 60) * 1000);
            qgVar.q();
        } else {
            jCurrentTimeMillis = 0;
        }
        n(qgVar, lVar, yVar, yVar.x == 2, qVar, jCurrentTimeMillis, new n() { // from class: com.byazt.gzx.q.11
            @Override // com.byazt.gzx.q.n
            public void n(boolean z) {
                qgVar.q();
                qVar.n(z);
                if (z) {
                    nVarN.n(q.this.n, qgVar, lVarCp, "backup_cache", new StringBuilder().append(iN).toString());
                }
            }
        });
    }

    private void x(com.byazt.zq.qg qgVar, l<T> lVar, y yVar) {
        double d;
        com.byazt.gct.fs.l lVarCp = n().cp();
        com.byazt.msp.w.n nVarN = com.byazt.msp.w.n(qgVar.q(), lVarCp);
        if (lVarCp.qg() > 0) {
            qgVar.q();
            try {
                d = Double.parseDouble(com.byazt.gh.n.n().n("DeviceRate", "bytebench_value", qgVar.an()));
            } catch (Exception unused) {
                d = 0.0d;
            }
            if (d > 0.0d && d < lVarCp.qg()) {
                qgVar.q();
                n(qgVar, (l) lVar, yVar, true, 0L, "device_score", String.valueOf(d));
                return;
            }
        }
        if (lVarCp.s() > 0) {
            qgVar.q();
            int iS = hd.s(rv.getContext());
            boolean z = true;
            if (iS == 2 ? (lVarCp.s() & 1) == 0 : iS == 3 ? (2 & lVarCp.s()) == 0 : iS == 4 ? (lVarCp.s() & 16) == 0 : iS == 5 ? (4 & lVarCp.s()) == 0 : iS != 6 || (lVarCp.s() & 8) == 0) {
                z = false;
            }
            if (z) {
                qgVar.q();
                n(qgVar, (l) lVar, yVar, true, 0L, "net_type", String.valueOf(iS));
                return;
            }
        }
        if (lVarCp.q() > 0) {
            qgVar.q();
            int iN = nVarN.n(lVarCp.q(), lVarCp);
            if (iN > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - ((((long) iN) * 60) * 1000);
                qgVar.q();
                n(qgVar, (l) lVar, yVar, true, jCurrentTimeMillis, "good_cache", String.valueOf(iN));
                return;
            } else if (iN == 0) {
                qgVar.q();
                n(qgVar, (l) lVar, yVar, true, 0L, "behavior_score", String.valueOf(iN));
                return;
            }
        }
        qgVar.q();
        n(qgVar, (l) lVar, yVar, false, 0L, "", "");
    }

    private void n(final com.byazt.zq.qg qgVar, final l<T> lVar, final y yVar, boolean z, long j, final String str, final String str2) {
        final com.byazt.gct.fs.l lVarCp = n().cp();
        final com.byazt.msp.w.n nVarN = com.byazt.msp.w.n(qgVar.q(), lVarCp);
        if (z) {
            qgVar.q();
            final com.byazt.fli.n nVar = new com.byazt.fli.n(lVar, n()) { // from class: com.byazt.gzx.q.12
                @Override // com.byazt.fli.n
                public void n() {
                    qgVar.q();
                    q.this.w(qgVar, lVar, yVar);
                }
            };
            n(qgVar, lVar, yVar, yVar.x == 2, nVar, j, new n() { // from class: com.byazt.gzx.q.13
                @Override // com.byazt.gzx.q.n
                public void n(boolean z2) {
                    qgVar.q();
                    if (!z2) {
                        nVar.n(false);
                    } else {
                        nVarN.n(q.this.n, qgVar, lVarCp, str, str2);
                    }
                }
            });
        } else {
            qgVar.q();
            w(qgVar, lVar, yVar);
        }
    }

    private void n(final com.byazt.zq.qg qgVar, final l<T> lVar, final y yVar, final boolean z, final com.byazt.fli.qg qgVar2, long j, final n nVar) {
        List<pk> listN;
        qgVar.q();
        if (!TextUtils.isEmpty(qgVar.py())) {
            nVar.n(false);
            qgVar.q();
            return;
        }
        if (n(z) == null) {
            k.qg("cache_tag", "广告类型 " + this.n + " ---缓存请求结束--- rit: " + qgVar.q() + " 无配置");
            nVar.n(false);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iMin = Math.min(com.byazt.gct.fs.n(this.n).d(), qgVar.d());
        double dCy = com.byazt.gct.fs.n(this.n).cy();
        if (qg() != null) {
            qg().qg(qgVar.q());
            listN = qg().n(qgVar.q(), j, iMin, dCy);
        } else {
            listN = null;
        }
        if (listN == null || listN.isEmpty()) {
            nVar.n(false);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (pk pkVar : listN) {
            if (n(pkVar)) {
                arrayList.add(pkVar);
            }
        }
        if (arrayList.isEmpty()) {
            nVar.n(false);
            return;
        }
        if (!n(z).n(qgVar, arrayList)) {
            nVar.n(false);
            return;
        }
        qgVar.q();
        arrayList.size();
        com.byazt.fxc.n nVar2 = new com.byazt.fxc.n(this.n);
        nVar2.n(jCurrentTimeMillis);
        nVar2.qg(System.currentTimeMillis());
        nVar2.n(arrayList, new com.byazt.fxc.w() { // from class: com.byazt.gzx.q.2
            @Override // com.byazt.fxc.w
            public void n(List<pk> list) {
                q.this.n(list, qgVar, yVar, z, qgVar2, lVar, nVar);
            }

            @Override // com.byazt.fxc.w
            public void qg(List<pk> list) {
                qgVar.q();
                list.size();
                if (!list.isEmpty()) {
                    q.this.n(list, qgVar, yVar, z, qgVar2, lVar, nVar);
                } else {
                    nVar.n(false);
                }
            }

            @Override // com.byazt.fxc.w
            public void s(List<pk> list) {
                Iterator<pk> it = list.iterator();
                while (it.hasNext()) {
                    q.this.qg().n(qgVar.q(), it.next());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final com.byazt.zq.qg qgVar, final l<T> lVar, final y yVar, final com.byazt.fli.qg qgVar2) {
        qgVar.q();
        rv.n().n(qgVar, yVar, this.n, new com.byazt.mw.n.qg() { // from class: com.byazt.gzx.q.3
            @Override // com.byazt.mw.n.qg
            public void n(int i, String str, com.byazt.gct.qg qgVar3) {
                qgVar.q();
                if (q.this.n(yVar.x == 2) != null) {
                    q.this.n(yVar.x == 2).n(qgVar, i, str, qgVar3);
                }
                com.byazt.fli.qg qgVar4 = qgVar2;
                if (qgVar4 != null) {
                    qgVar4.n(i, str);
                    return;
                }
                l lVar2 = lVar;
                if (lVar2 != null) {
                    lVar2.n(i, str);
                }
            }

            @Override // com.byazt.mw.n.qg
            public void n(final com.byazt.gct.n nVar, final com.byazt.gct.qg qgVar3) {
                qgVar.q();
                try {
                    if (yVar != null && nVar != null && nVar.qg() != null) {
                        for (pk pkVar : nVar.qg()) {
                            if (pkVar != null) {
                                pkVar.m(yVar.py);
                                pkVar.hu(yVar.ou);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
                com.byazt.yxf.n nVarN = q.this.n(yVar.x == 2);
                if (nVarN == null) {
                    return;
                }
                nVarN.n(q.this.n, nVar, qgVar3, yVar, qgVar, lVar, new x() { // from class: com.byazt.gzx.q.3.1
                    @Override // com.byazt.gzx.x
                    public void n(s sVar) {
                        qgVar.q();
                        if (q.this.n(q.this.n(qgVar, nVar, qgVar2))) {
                            qgVar.q();
                            if (sVar != null) {
                                sVar.s();
                            }
                            if (qgVar2 == null) {
                                if (lVar != null) {
                                    lVar.n(-3, com.byazt.bxg.n.n(-3));
                                    return;
                                }
                                return;
                            } else {
                                qgVar2.qg(-3, com.byazt.bxg.n.n(-3));
                                qgVar2.s();
                                return;
                            }
                        }
                        if (sVar != null) {
                            if (qgVar2 == null) {
                                sVar.n();
                            } else {
                                qgVar2.n(sVar);
                            }
                        }
                        if (qgVar2 != null) {
                            qgVar2.s();
                        }
                    }

                    @Override // com.byazt.gzx.x
                    public void n(int i) {
                        if (lVar != null) {
                            lVar.n(i, com.byazt.bxg.n.n(i));
                        }
                        qgVar3.n(i);
                        com.byazt.gct.qg.n(qgVar3);
                        if (qgVar2 != null) {
                            qgVar2.s();
                        }
                    }
                });
            }
        });
    }

    public void n(final com.byazt.zq.qg qgVar, final y yVar) {
        if (qgVar == null) {
            return;
        }
        qgVar.a();
        if (!com.byazt.hoz.q.n(qgVar.ou())) {
            qgVar.a();
            return;
        }
        if (com.byazt.gct.fs.n(this.n).n("forbid_preload", new com.byazt.gct.fs.qg.n().n(qgVar).n())) {
            qgVar.a();
            qgVar.q();
            return;
        }
        if (s() == 0) {
            qgVar.a();
            return;
        }
        if (!qg().n(qgVar.q())) {
            qgVar.a();
            return;
        }
        if (!TextUtils.isEmpty(qgVar.py())) {
            qgVar.a();
            if (n(yVar.x == 2) != null) {
                n(yVar.x == 2).n(qgVar);
                return;
            }
            return;
        }
        com.byazt.ag.qg.l(new Runnable() { // from class: com.byazt.gzx.q.4
            @Override // java.lang.Runnable
            public void run() {
                qgVar.a();
                q.this.n(qgVar, (l) null, yVar, (com.byazt.fli.qg) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final List<pk> list, final com.byazt.zq.qg qgVar, y yVar, boolean z, final com.byazt.fli.qg qgVar2, l<T> lVar, final n nVar) {
        String str = yVar != null ? yVar.um : null;
        if (!TextUtils.isEmpty(str)) {
            Iterator<pk> it = list.iterator();
            while (it.hasNext()) {
                it.next().n(str);
            }
        }
        com.byazt.uq.qg.n(list, str);
        if (yVar != null && list != null) {
            try {
                for (pk pkVar : list) {
                    if (pkVar != null) {
                        pkVar.m(yVar.py);
                        pkVar.hu(yVar.ou);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", false);
        bundle.putBoolean("is_cache", true);
        bundle.putLong(f.a, this.qg);
        n(z).n(this.n, list, qgVar, lVar, bundle, new x() { // from class: com.byazt.gzx.q.5
            @Override // com.byazt.gzx.x
            public void n(int i) {
            }

            @Override // com.byazt.gzx.x
            public void n(s sVar) {
                com.byazt.fli.qg qgVar3 = qgVar2;
                if (qgVar3 != null) {
                    qgVar3.qg(sVar);
                    qgVar2.n(true);
                    list.size();
                    qgVar.q();
                } else {
                    sVar.n();
                    list.size();
                    qgVar.q();
                }
                nVar.n(true);
            }
        });
    }

    private int s() {
        if (n() == null) {
            return com.byazt.gzx.n.n(this.n);
        }
        if (n().rv() < 0 || n().rv() > 5) {
            return com.byazt.gzx.n.n(this.n);
        }
        return n().rv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gct.fs.qg n(com.byazt.zq.qg qgVar, com.byazt.gct.n nVar, com.byazt.fli.qg qgVar2) {
        com.byazt.gct.fs.qg.n nVarN = new com.byazt.gct.fs.qg.n().n(qgVar).n(qgVar2 != null && qgVar2.q());
        pk pkVarN = n(nVar);
        if (pkVarN != null) {
            nVarN.n(pkVarN);
        }
        return nVarN.n();
    }

    private pk n(com.byazt.gct.n nVar) {
        if (nVar == null || nVar.qg() == null || nVar.qg().isEmpty()) {
            return null;
        }
        return nVar.qg().get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(com.byazt.gct.fs.qg qgVar) {
        return com.byazt.gct.fs.n(this.n).n("forbid_realtime", qgVar);
    }
}
