package com.byazt.mz;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.v;
import com.byazt.gct.vb;
import com.byazt.gct.y;
import com.byazt.gct.z;
import com.byazt.hi.fs;
import com.byazt.se.rv;
import com.byazt.se.w;
import com.byazt.se.x;
import com.byazt.si.cy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 895, 19})
public abstract class n {
    public l w;
    public long n = 0;
    public long qg = 0;
    public AtomicBoolean s = new AtomicBoolean(false);
    public AtomicBoolean q = new AtomicBoolean(false);
    public AtomicBoolean l = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.byazt.mz.n$n, reason: collision with other inner class name */
    public interface InterfaceC0253n {
        void n();

        void n(w wVar);
    }

    public abstract void n(z zVar, com.byazt.zq.qg qgVar, boolean z);

    public abstract void n(com.byazt.jr.q<rv, x> qVar, pk pkVar, com.byazt.zq.qg qgVar, boolean z);

    public abstract void n(x xVar, String str, InterfaceC0253n interfaceC0253n, l lVar);

    public abstract void n(String str, pk pkVar);

    public abstract void n(String str, String str2, boolean z, boolean z2, Object obj);

    public abstract void qg();

    public abstract void s();

    public static n n() {
        return (com.byazt.ed.q.n().cp() & 16) == 16 ? new s() : new q();
    }

    public void n(w wVar, com.byazt.zq.qg qgVar, boolean z, int i) {
        if (n(i) && com.byazt.ci.l.n(wVar.qg()) && !this.s.get()) {
            this.s.set(true);
            com.byazt.eo.n.n("Splash_FullLink", "cacheRealTimeAdWhenTimeout start");
            n(new z(wVar.q(), wVar.qg(), null), qgVar, false);
            if (z) {
                n(wVar.q(), wVar.qg(), qgVar);
            }
            com.byazt.eo.n.n("Splash_FullLink", "cacheRealTimeAdWhenTimeout end");
        }
    }

    public static boolean n(int i) {
        int iCp = com.byazt.ed.q.n().cp();
        if (i == 2) {
            return (iCp & 2) == 2;
        }
        return (i == 3 || i == 1) && (iCp & 32) == 32;
    }

    public void n(final com.byazt.zq.qg qgVar, y yVar) {
        if (this.s.get()) {
            com.byazt.eo.n.n("lqmt", "已经存储了一个实时广告");
            return;
        }
        if (this.q.getAndSet(true)) {
            com.byazt.eo.n.n("lqmt", "已在预加载开屏广告....不再发出");
            return;
        }
        if (com.byazt.nf.rv.qg().tj(qgVar.q()) && yVar != null) {
            yVar.x = 2;
        }
        com.byazt.nf.rv.n().n(qgVar, yVar, 4, new com.byazt.mw.n.qg() { // from class: com.byazt.mz.n.1
            @Override // com.byazt.mw.n.qg
            public void n(int i, String str, com.byazt.gct.qg qgVar2) {
                n.this.q.set(false);
                qgVar2.n(i);
                com.byazt.gct.qg.n(qgVar2);
            }

            @Override // com.byazt.mw.n.qg
            public void n(com.byazt.gct.n nVar, com.byazt.gct.qg qgVar2) {
                if (fs.qg(nVar)) {
                    pk pkVar = nVar.qg().get(0);
                    if (pkVar.os()) {
                        if ((n.this.s == null || !n.this.s.get()) && com.byazt.ci.l.n(pkVar)) {
                            n.this.n(new z(nVar, pkVar, null), qgVar, false);
                            n.this.n(nVar, pkVar, qgVar);
                            return;
                        }
                        return;
                    }
                    qgVar2.n(-4);
                    com.byazt.gct.qg.n(qgVar2);
                    return;
                }
                n.this.q.set(false);
            }
        });
    }

    public void n(final com.byazt.gct.n nVar, final pk pkVar, com.byazt.zq.qg qgVar) {
        if (pkVar.jo() == null || pkVar.jo().size() <= 0) {
            return;
        }
        v vVar = pkVar.jo().get(0);
        String strN = vVar.n();
        int iQg = vVar.qg();
        int iS = vVar.s();
        this.n = System.currentTimeMillis();
        this.qg = SystemClock.elapsedRealtime();
        vb vbVarS = com.byazt.mw.s.n().s().s();
        if (vbVarS != null) {
            vbVarS.n(false);
        }
        final boolean z = ta.k(pkVar) != null;
        com.byazt.imu.n.n(new com.byazt.imu.q(strN, vVar.x()), iQg, iS, new com.byazt.imu.n.InterfaceC0203n() { // from class: com.byazt.mz.n.2
            @Override // com.byazt.imu.n.InterfaceC0203n
            public void n(com.byazt.qdx.qg qgVar2, cy cyVar) {
                fs.n(nVar);
                if (!z) {
                    com.byazt.hm.n.n(pkVar, "splash_ad", System.currentTimeMillis() - n.this.n);
                }
                n.this.n = 0L;
                if (z) {
                    fs.n(n.this.qg, false, true, pkVar, 0L, "preLoadImageSuccess");
                }
                n.this.q.set(false);
            }

            @Override // com.byazt.imu.n.InterfaceC0203n
            public void n() {
                fs.n(nVar);
                if (z) {
                    fs.n(n.this.qg, false, false, pkVar, -7L, "preLoadImageFailed");
                }
                n.this.q.set(false);
            }
        }, com.byazt.ql.qg.l(), 4, null, false);
    }

    public void qg(com.byazt.zq.qg qgVar, y yVar) {
        if (com.byazt.nf.rv.qg().n(com.byazt.vgx.w.qg(qgVar)) && qgVar != null && TextUtils.isEmpty(qgVar.py())) {
            com.byazt.eo.n.n("lqmt", "preLoadSplashAd... ");
            y yVar2 = yVar == null ? new y() : yVar.n();
            yVar2.fs = System.currentTimeMillis();
            yVar2.x = 2;
            yVar2.sz = com.byazt.vyf.s.cy().pe();
            yVar2.qg = 2;
            n(qgVar, yVar2);
        }
    }
}
