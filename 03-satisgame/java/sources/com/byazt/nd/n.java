package com.byazt.nd;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 674, 19})
public abstract class n implements x {
    public static final AtomicLong d = new AtomicLong();
    public volatile String fs;
    public com.byazt.mly.n l;
    public volatile com.byazt.lp.n n;
    public final com.byazt.frl.s qg;
    public volatile fs rv;
    public volatile List<w.qg> w;
    public volatile String x;
    public final AtomicInteger s = new AtomicInteger();
    public final AtomicLong q = new AtomicLong();
    public volatile boolean tj = false;
    public final long cp = d.incrementAndGet();
    public final AtomicInteger oa = new AtomicInteger(0);
    public int sz = -1;

    public n(com.byazt.lp.n nVar, com.byazt.frl.s sVar) {
        this.n = nVar;
        this.qg = sVar;
    }

    public void n() {
        this.oa.compareAndSet(0, 1);
    }

    public boolean qg() {
        return this.oa.get() == 1;
    }

    public void s() {
        this.oa.compareAndSet(0, 2);
    }

    public void q() throws com.byazt.gy.n {
        if (qg()) {
            throw new com.byazt.gy.n();
        }
    }

    public com.byazt.ien.n n(fs.n nVar, int i, int i2, String str) throws IOException {
        com.byazt.ien.qg qgVarQg = com.byazt.ien.s.n().qg();
        com.byazt.ien.l lVar = new com.byazt.ien.l();
        HashMap map = new HashMap();
        lVar.qg = nVar.n;
        lVar.n = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            lVar.n = 4;
        }
        List<w.qg> list = this.w;
        if (list != null && !list.isEmpty()) {
            for (w.qg qgVar : list) {
                if (!"Range".equalsIgnoreCase(qgVar.n) && !"Connection".equalsIgnoreCase(qgVar.n) && !"Proxy-Connection".equalsIgnoreCase(qgVar.n) && !"Host".equalsIgnoreCase(qgVar.n)) {
                    map.put(qgVar.n, qgVar.qg);
                }
            }
        }
        String strN = com.byazt.cmv.n.n(i, i2);
        if (strN != null) {
            map.put("Range", strN);
        }
        if (q.fs) {
            map.put("Cache-Control", "no-cache");
        }
        lVar.l = map;
        if (this.tj) {
            this.tj = false;
            return null;
        }
        return qgVarQg.n(lVar);
    }

    public int l() {
        return this.n instanceof com.byazt.lp.qg ? 1 : 0;
    }

    public boolean w() {
        return l() == 1;
    }

    public void n(int i, int i2) {
        if (i <= 0 || i2 < 0) {
            return;
        }
        int i3 = q.rv;
        int iL = l();
        if (i3 == 1 || (i3 == 2 && iL == 1)) {
            int i4 = (int) ((i2 / i) * 100.0f);
            if (i4 > 100) {
                i4 = 100;
            }
            synchronized (this) {
                if (i4 <= this.sz) {
                    return;
                }
                this.sz = i4;
                com.byazt.cmv.n.qg(new Runnable() { // from class: com.byazt.nd.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (n.this.l != null) {
                            fs fsVar = n.this.rv;
                            int unused = n.this.sz;
                        }
                    }
                });
            }
        }
    }
}
