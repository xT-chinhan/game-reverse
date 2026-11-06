package com.byazt.ghh;

import android.text.TextUtils;
import com.byazt.gct.fs;
import com.byazt.gct.pk;
import com.byazt.qit.x;
import com.byazt.vgx.w;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1006, 8})
public class s implements l {
    public static ReferenceQueue<Object> qg = new ReferenceQueue<>();
    public Map<Object, n> n = new ConcurrentHashMap();
    public final int s;

    @Override // com.byazt.ghh.l
    public boolean n(String str) {
        return true;
    }

    public s(int i) {
        this.s = i;
    }

    @Override // com.byazt.ghh.l
    public void n(final com.byazt.zq.qg qgVar, final pk pkVar) {
        if (TextUtils.isEmpty(qgVar.py())) {
            if (pkVar.aj() <= 0) {
                pkVar.l((System.currentTimeMillis() + 10500000) / 1000);
            }
            com.byazt.ag.qg.l(new x("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.byazt.ghh.s.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = s.this.s;
                    qgVar.q();
                    com.byazt.ci.l.n(s.this.s).n(qgVar, pkVar, false);
                }
            });
        }
    }

    @Override // com.byazt.ghh.l
    public void n(final com.byazt.zq.qg qgVar, final List<pk> list) {
        if (TextUtils.isEmpty(qgVar.py())) {
            qgVar.q();
            fs.s sVarN = fs.n(this.s);
            if (((sVarN != null ? sVarN.tj() : 0) & 1) != 1) {
                return;
            }
            qgVar.q();
            pk pkVar = list.get(0);
            if (pkVar != null) {
                try {
                    if (sVarN.n("disable_trans_cache", new fs.qg.n().n(qgVar).n(pkVar).n())) {
                        qgVar.q();
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            com.byazt.ag.qg.l(new x("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.byazt.ghh.s.2
                @Override // java.lang.Runnable
                public void run() {
                    for (pk pkVar2 : list) {
                        if (pkVar2.aj() <= 0) {
                            pkVar2.l((System.currentTimeMillis() + 10500000) / 1000);
                        }
                        pkVar2.y(104);
                        int unused2 = s.this.s;
                        qgVar.q();
                        com.byazt.ci.l.n(s.this.s).n(qgVar, pkVar2, false);
                    }
                }
            });
        }
    }

    @Override // com.byazt.ghh.l
    public void qg(final com.byazt.zq.qg qgVar, final List<pk> list) {
        if (TextUtils.isEmpty(qgVar.py())) {
            com.byazt.ag.qg.l(new x("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.byazt.ghh.s.3
                @Override // java.lang.Runnable
                public void run() {
                    for (pk pkVar : list) {
                        if (pkVar.aj() <= 0) {
                            pkVar.l((System.currentTimeMillis() + 10500000) / 1000);
                        }
                        int unused = s.this.s;
                        qgVar.q();
                        com.byazt.ci.l.n(s.this.s).n(qgVar.q(), pkVar.cs(), false);
                    }
                }
            });
        }
    }

    @Override // com.byazt.ghh.l
    public void qg(String str) {
        for (Reference<? extends Object> referencePoll = qg.poll(); referencePoll != null; referencePoll = qg.poll()) {
            n nVar = this.n.get(referencePoll);
            if (nVar != null) {
                com.byazt.ci.l.n(this.s).n(nVar.n, nVar.qg, false);
            }
        }
        com.byazt.ci.l.n(this.s).qg(str);
        com.byazt.ci.l.n(this.s).s(str);
    }

    @Override // com.byazt.ghh.l
    public pk n(String str, long j) {
        fs.s sVarN = fs.n(this.s);
        pk pkVarN = com.byazt.ci.l.n(this.s).n(str, true, j);
        if (pkVarN != null && sVarN != null) {
            try {
                if (sVarN.n("delete_on_load", new fs.qg.n().n(pkVarN).n())) {
                    com.byazt.ci.l.n(this.s).n(str, pkVarN.cs());
                }
            } catch (Exception unused) {
            }
        }
        return pkVarN;
    }

    @Override // com.byazt.ghh.l
    public List<pk> n(String str, long j, int i, double d) {
        fs.s sVarN = fs.n(this.s);
        List<pk> listN = com.byazt.ci.l.n(this.s).n(str, true, j, i, d);
        for (pk pkVar : listN) {
            if (pkVar != null && sVarN != null) {
                try {
                    if (sVarN.n("delete_on_load", new fs.qg.n().n(pkVar).n())) {
                        try {
                            com.byazt.ci.l.n(this.s).n(str, pkVar.cs());
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }
        listN.size();
        return listN;
    }

    @Override // com.byazt.ghh.l
    public void n(final com.byazt.zq.qg qgVar, final pk pkVar, final Object obj, boolean z) {
        final String strQ = qgVar.q();
        fs.s sVarN = fs.n(this.s);
        int iTj = sVarN != null ? sVarN.tj() : 0;
        if (z) {
            if (pkVar.vx() != 0) {
                this.n.put(new PhantomReference(obj, qg), new n(strQ, pkVar.cs()));
            }
        } else {
            if ((iTj & 2) != 2) {
                return;
            }
            try {
                if (sVarN.n("disable_trans_cache", new fs.qg.n().n(qgVar).n(pkVar).n())) {
                    return;
                }
            } catch (Exception unused) {
            }
            com.byazt.ag.qg.l(new x("PreloadStrategyRecovery-onLoad") { // from class: com.byazt.ghh.s.4
                @Override // java.lang.Runnable
                public void run() {
                    if (pkVar.vx() != 0) {
                        s.this.n.put(new PhantomReference(obj, s.qg), new n(strQ, pkVar.cs()));
                    }
                    pkVar.y(105);
                    com.byazt.ci.l.n(s.this.s).n(qgVar, pkVar, true);
                }
            });
        }
    }

    @Override // com.byazt.ghh.l
    public void n(final pk pkVar) {
        final int iCy = w.cy(pkVar);
        com.byazt.ag.qg.l(new x("PreloadStrategyRecovery-onShow") { // from class: com.byazt.ghh.s.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                com.byazt.ci.l.n(s.this.s).n(new StringBuilder().append(iCy).toString(), pkVar.cs());
                System.currentTimeMillis();
            }
        });
    }

    @Override // com.byazt.ghh.l
    public void n(String str, pk pkVar) {
        com.byazt.ci.l.n(this.s).n(str, pkVar.cs());
    }

    @com.byazt.cp.n(n = {0, 1, 1006, 546})
    private static class n {
        public String n;
        public String qg;

        public n(String str, String str2) {
            this.n = str;
            this.qg = str2;
        }
    }
}
