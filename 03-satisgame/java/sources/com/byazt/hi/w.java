package com.byazt.hi;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.vb;
import com.byazt.gct.y;
import com.byazt.gct.z;
import com.byazt.tk.k;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, 13})
public class w extends rv implements wo.n {
    public static boolean n = true;
    public com.byazt.se.w a;
    public com.byazt.se.q bb;
    public long cd;
    public int cp;
    public long cy;
    public int d;
    public vb h;
    public long hd;
    public com.byazt.se.rv hu;
    public long k;
    public com.byazt.zq.qg l;
    public com.byazt.se.rv m;
    public com.byazt.mz.n oa;
    public com.byazt.se.fs ou;
    public com.byazt.se.w py;
    public Context rv;
    public com.byazt.se.x sh;
    public n sz;
    public vb t;
    public final t tj;
    public long um;
    public com.byazt.se.q ur;
    public y w;
    public com.byazt.fvm.qg wm;
    public com.byazt.jr.l wo;
    public String x;
    public int q = 2;
    public com.byazt.ap.n fs = null;
    public final AtomicBoolean ln = new AtomicBoolean(false);
    public final AtomicBoolean lh = new AtomicBoolean(false);
    public final AtomicBoolean v = new AtomicBoolean(false);
    public final AtomicBoolean j = new AtomicBoolean(false);
    public final AtomicBoolean an = new AtomicBoolean(false);
    public final AtomicBoolean ae = new AtomicBoolean(false);
    public final AtomicInteger f = new AtomicInteger(0);
    public final AtomicBoolean fi = new AtomicBoolean(false);
    public final AtomicBoolean df = new AtomicBoolean(false);
    public final AtomicBoolean oj = new AtomicBoolean(false);
    public final AtomicBoolean dg = new AtomicBoolean(false);
    public final AtomicInteger u = new AtomicInteger(0);
    public boolean pk = false;
    public final qg y = new qg();

    private w(Context context) {
        if (context != null) {
            this.rv = context.getApplicationContext();
        } else {
            this.rv = com.byazt.nf.rv.getContext();
        }
        this.tj = new t(Looper.getMainLooper(), this);
        this.sz = new n();
        com.byazt.vyf.s.cy().tj(false);
        oa();
    }

    public static w n(Context context) {
        return new w(context);
    }

    private void qg(com.byazt.zq.qg qgVar) {
        this.s = UUID.randomUUID().toString();
        this.qg = (com.byazt.id.qg) com.byazt.bok.s.n(0);
        this.qg.qg(this.s, qgVar.an());
        this.qg.n(this.s, new com.byazt.oi.s());
        if (com.byazt.bh.w.n().n(3)) {
            this.qg.n(this.s, new com.byazt.bh.s());
        }
    }

    public void n(final com.byazt.zq.qg qgVar, final com.byazt.ap.n nVar, final int i) {
        if (qgVar != null && !TextUtils.isEmpty(qgVar.py())) {
            this.qg = (com.byazt.id.qg) com.byazt.bok.s.n(0);
        } else {
            qg(qgVar);
        }
        String string = UUID.randomUUID().toString();
        this.x = string;
        com.byazt.uq.qg.n(qgVar, true, string);
        this.qg.n(this.s, new com.byazt.bok.qg.n() { // from class: com.byazt.hi.w.1
            @Override // com.byazt.bok.qg.n
            public void n(com.byazt.wea.fs fsVar) {
                com.byazt.zq.qg qgVar2;
                if (!(fsVar instanceof com.byazt.wea.s) || (qgVar2 = qgVar) == null) {
                    return;
                }
                com.byazt.wea.s sVar = (com.byazt.wea.s) fsVar;
                sVar.x = qgVar2;
                sVar.s = qgVar.q();
                sVar.n = 3;
                sVar.qg = 0;
            }
        });
        qg();
        if (!com.byazt.ivn.l.n()) {
            com.byazt.di.n nVar2 = new com.byazt.di.n(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            n((String) null, false, nVar2, (pk) null);
            nVar.n(nVar2);
            return;
        }
        int iX = com.byazt.nf.rv.qg().x(com.byazt.vgx.w.qg(qgVar));
        com.byazt.qit.x xVar = new com.byazt.qit.x("loadSplashAd b") { // from class: com.byazt.hi.w.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.byazt.vyf.s.cy().x(1);
                    w.this.fs = nVar;
                    w.this.n(qgVar, i);
                } catch (Throwable th) {
                    com.byazt.di.n nVar3 = new com.byazt.di.n(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    w.this.n((String) null, false, nVar3, (pk) null);
                    nVar.n(nVar3);
                    k.n("SplashLoadManager", "splash component maybe not exist, pls check1", th);
                }
            }
        };
        if (!com.byazt.vyf.l.n) {
            k.qg("SplashLoadManager", com.byazt.yn.n.NOT_INIT_TIPS_MSG);
            com.byazt.di.n nVar3 = new com.byazt.di.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG);
            n((String) null, false, nVar3, (pk) null);
            nVar.n(nVar3);
            return;
        }
        if (com.byazt.bfv.n.qg() && (iX == 4 || n(qgVar))) {
            xVar.run();
        } else if (com.byazt.yn.n.n()) {
            com.byazt.qit.l.q(xVar);
        } else {
            com.byazt.qit.rv.qg.oa().execute(xVar);
        }
        com.byazt.wz.n.l().n(3, qgVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.zq.qg qgVar, int i) {
        if (qgVar == null) {
            return;
        }
        com.byazt.eo.n.n("Splash_FullLink", "加载开屏广告--begin ");
        this.k = System.currentTimeMillis();
        y yVarS = s(qgVar);
        this.w = yVarS;
        yVarS.um = this.x;
        this.l = qgVar;
        this.cp = com.byazt.vgx.w.qg(qgVar);
        this.oa = com.byazt.mz.n.n();
        int iN = this.y.n(this.l, this.cp);
        this.q = iN;
        com.byazt.eo.n.n("Splash_FullLink", "当前rit位 " + this.cp);
        int iW = com.byazt.nf.rv.qg().w(qgVar.q());
        n(qgVar.q(), iW, i);
        long j = i;
        this.w.tj = j;
        this.w.cp = iW;
        this.w.d = this.d;
        x.n(qgVar, j);
        q();
        s();
        n(qgVar, this.w, iN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.zq.qg qgVar, y yVar, int i) {
        x.n(this.h, this.t, yVar, this.q, i);
        n(qgVar, yVar, this.sz);
    }

    private void n(final com.byazt.zq.qg qgVar, y yVar, final n nVar) {
        if (nVar == null) {
            return;
        }
        com.byazt.mz.l lVar = new com.byazt.mz.l();
        lVar.n = this.y.qg;
        com.byazt.jr.l lVar2 = new com.byazt.jr.l(new com.byazt.se.l(qgVar, yVar, lVar), new com.byazt.jr.qg<com.byazt.se.w, com.byazt.se.x>() { // from class: com.byazt.hi.w.10
            @Override // com.byazt.jr.qg
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public void qg(com.byazt.se.w wVar) {
                com.byazt.zq.qg qgVar2;
                if (TextUtils.isEmpty(w.this.s) && (qgVar2 = qgVar) != null && !TextUtils.isEmpty(qgVar2.py()) && wVar != null && wVar.qg() != null && w.this.qg != null) {
                    w wVar2 = w.this;
                    wVar2.s = wVar2.qg.qg(wVar.qg().ou());
                }
                if (wVar == null || wVar.qg() == null) {
                    nVar.n(new com.byazt.se.x(1, "no ad model", false));
                    return;
                }
                pk pkVarQg = wVar.qg();
                if (wVar.l()) {
                    w.this.u.set(1);
                    w.this.py = wVar;
                    if (!w.this.sz()) {
                        w.this.pk = true;
                    }
                } else {
                    w.this.a = wVar;
                    w.this.pk = false;
                }
                if (w.this.ln.get() || w.this.sz.s() || w.this.f.get() > 0) {
                    w.this.n(wVar, wVar.l(), true);
                    return;
                }
                w.this.n(wVar);
                if (w.this.qg(pkVarQg, wVar.l())) {
                    com.byazt.eo.n.n("Splash_FullLink", "开始并发加载素材 ");
                    w.this.qg(wVar, nVar);
                } else {
                    com.byazt.eo.n.n("Splash_FullLink", "开始串行加载素材 getReqId " + wVar.qg().ou());
                    w.this.n(wVar, nVar);
                }
            }

            @Override // com.byazt.jr.qg
            public void n(com.byazt.se.x xVar) {
                if (w.this.q == 1 && w.this.y.s == 2) {
                    w.this.q = 2;
                    w wVar = w.this;
                    wVar.n(qgVar, wVar.w, w.this.q);
                    return;
                }
                boolean zFs = xVar.fs();
                if (zFs) {
                    w.this.u.set(-1);
                }
                if (!w.this.q(zFs)) {
                    w.this.sh = xVar;
                    if (w.this.sz()) {
                        if (w.this.u.get() != -1) {
                            if (w.this.u.get() == 1) {
                                w.this.x();
                            }
                        } else {
                            nVar.n(xVar);
                        }
                        w.this.dg.set(true);
                        return;
                    }
                    nVar.n(xVar);
                    return;
                }
                if (w.this.dg.get()) {
                    nVar.n(w.this.sh);
                }
            }
        }, this.oa, this.y);
        this.wo = lVar2;
        lVar2.n(this.q);
    }

    private void q() {
        this.ln.set(false);
        this.lh.set(false);
        this.v.set(false);
        this.j.set(false);
        this.fi.set(false);
        this.df.set(false);
        this.an.set(false);
        this.ae.set(false);
        this.oj.set(false);
        this.dg.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        int i;
        if (com.byazt.mz.n.n(this.q) && ((i = this.q) == 1 || i == 3)) {
            return;
        }
        w();
    }

    private void w() {
        com.byazt.mz.n nVar = this.oa;
        if (nVar != null) {
            nVar.qg(this.l, this.w);
        }
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message.what == 2) {
            n nVar = this.sz;
            if (nVar != null) {
                nVar.n();
            }
            t tVar = this.tj;
            if (tVar != null) {
                tVar.removeMessages(2);
            }
        }
        if (message.what == 4) {
            fs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        int iOptInt;
        com.byazt.se.w wVar = this.py;
        if (wVar != null && wVar.qg() != null && this.py.qg().pz() != null && (iOptInt = this.py.qg().pz().optInt("real_drop_cache_type", 0)) == 1) {
            com.byazt.eo.n.n("SplashLoadManager", "loadCacheWhenRealAdDrop - 缓存兜底返回配置 realDropCacheType： " + iOptInt);
            fs();
        } else if (this.y.n()) {
            com.byazt.eo.n.n("SplashLoadManager", "loadCacheWhenRealAdDrop - 计分模式下允许兜底缓存： ");
            fs();
        } else {
            n nVar = this.sz;
            if (nVar != null) {
                nVar.n(this.sh);
            }
        }
    }

    private void fs() {
        t tVar = this.tj;
        if (tVar != null) {
            tVar.removeMessages(4);
        }
        n nVar = this.sz;
        if (nVar != null) {
            nVar.qg();
        }
    }

    private boolean n(pk pkVar, boolean z) {
        return (pkVar == null || z || pkVar.iz() != 3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(pk pkVar) {
        return (pkVar != null ? pkVar.iz() : 0) == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public pk qg(boolean z) {
        if (z) {
            com.byazt.se.w wVar = this.py;
            if (wVar == null) {
                return null;
            }
            return wVar.qg();
        }
        com.byazt.se.w wVar2 = this.a;
        if (wVar2 == null) {
            return null;
        }
        return wVar2.qg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        com.byazt.eo.n.n("Splash_FullLink", "startCallBackWhenBufferTimeout ");
        this.sz.n(this.ou);
        this.df.set(true);
        if (!this.j.get() || this.fi.get()) {
            return;
        }
        this.fi.set(true);
        com.byazt.eo.n.n("Splash_FullLink", "素材加载和渲染并发 buffer_time超时 缓存素材加载成功，渲染成功开始给 onRenderSplashSuccess回调");
        this.sz.n(this.hu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj() {
        if (this.sz == null) {
            return;
        }
        if (qg(qg(true), true)) {
            AtomicBoolean atomicBoolean = this.lh;
            if (atomicBoolean == null || !atomicBoolean.get()) {
                return;
            }
            cp();
            com.byazt.eo.n.n("Splash_FullLink", "buffer_time超时-并发 缓存素材加载成功，开始给加载成功回调");
            com.byazt.se.fs fsVar = this.ou;
            if (fsVar != null) {
                fsVar.n(this.wm);
            }
            l.qg(new Runnable() { // from class: com.byazt.hi.w.11
                @Override // java.lang.Runnable
                public void run() {
                    final long jCurrentTimeMillis = System.currentTimeMillis();
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.hi.w.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            x.q(w.this.t, jCurrentTimeMillis);
                            w.this.rv();
                        }
                    });
                }
            });
            return;
        }
        AtomicBoolean atomicBoolean2 = this.lh;
        if (atomicBoolean2 == null || !atomicBoolean2.get()) {
            return;
        }
        com.byazt.eo.n.n("Splash_FullLink", "buffer_time超时-串行 缓存素材加载成功，开始给加载成功回调以及开始渲染");
        cp();
        com.byazt.jr.n nVarQg = qg(this.py, this.ou, this.sz);
        com.byazt.se.fs fsVar2 = this.ou;
        if (fsVar2 != null) {
            fsVar2.n(nVarQg.n());
        }
        l.qg(new Runnable() { // from class: com.byazt.hi.w.12
            @Override // java.lang.Runnable
            public void run() {
                final long jCurrentTimeMillis = System.currentTimeMillis();
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.hi.w.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        x.q(w.this.t, jCurrentTimeMillis);
                        w.this.sz.n(w.this.ou);
                    }
                });
            }
        });
        n(this.py, nVarQg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp() {
        t tVar = this.tj;
        if (tVar != null) {
            tVar.removeMessages(4);
        }
        t tVar2 = this.tj;
        if (tVar2 != null) {
            tVar2.removeMessages(2);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 123, 108})
    class n {
        public final AtomicBoolean qg = new AtomicBoolean(false);

        public n() {
        }

        private void q(final com.byazt.se.x xVar) {
            if (xVar == null) {
                return;
            }
            com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.hi.w.n.1
                @Override // java.lang.Runnable
                public void run() {
                    if (w.this.fs != null) {
                        w.this.fs.n(xVar.rv(), new com.byazt.di.n(xVar.q(), xVar.l()));
                        com.byazt.eo.n.n("Splash_FullLink", "onSplashRenderFail回调 true " + xVar.q());
                    }
                }
            });
            w.this.l();
        }

        public void n(final com.byazt.se.x xVar) {
            if (xVar == null) {
                return;
            }
            w.this.cp();
            if (!this.qg.get() && w.this.f.get() <= 0) {
                this.qg.set(true);
                w.this.n(false);
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.hi.w.n.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (w.this.fs != null) {
                            if (xVar.q() == 22) {
                                xVar.qg(1);
                            }
                            com.byazt.di.n nVar = new com.byazt.di.n(xVar.q(), xVar.l());
                            w.this.n((String) null, false, nVar, (pk) null);
                            w.this.fs.n(nVar);
                            com.byazt.eo.n.n("Splash_FullLink", "onSplashLoadFail 回调");
                        }
                    }
                });
                n(false, true, (Object) null);
                w.this.l();
                com.byazt.eo.n.n("Splash_FullLink", "onLoadSplashAdFail回调 广告获取失败");
                x.n(xVar.fs(), w.this.qg(xVar.fs()), w.this.l, xVar);
            }
        }

        public void n(com.byazt.se.fs fsVar) {
            if (this.qg.get()) {
                return;
            }
            if (w.this.f.get() == 0) {
                w.this.n(true);
            }
            if (fsVar != null) {
                vb vbVar = fsVar.cp() ? w.this.t : w.this.h;
                if (vbVar != null) {
                    vbVar.w(fsVar.n());
                    vbVar.cd(fsVar.sz());
                    vbVar.py(System.currentTimeMillis() - vbVar.m());
                }
                n(w.this.fs, vbVar, fsVar.qg(), fsVar.d(), fsVar.cp(), fsVar.k());
            }
        }

        private void n(com.byazt.ap.n nVar, vb vbVar, pk pkVar, com.byazt.fvm.qg qgVar, boolean z, boolean z2) {
            if (nVar == null || vbVar == null || w.this.f.get() > 0) {
                return;
            }
            if (w.this.n(pkVar)) {
                w wVar = w.this;
                x.n(z ? wVar.t : wVar.h, 2);
                w.this.cp();
            }
            w.this.oj.set(z);
            w.this.f.set(1);
            long jCurrentTimeMillis = System.currentTimeMillis();
            n(qgVar, 1);
            w.this.n(qgVar.qg(), true, (com.byazt.di.n) null, pkVar);
            com.byazt.nj.q.n(pkVar);
            nVar.n(qgVar);
            if (com.byazt.uq.s.n() && !TextUtils.isEmpty(w.this.x) && pkVar != null) {
                pkVar.n(w.this.x);
                com.byazt.uq.qg.n((List<pk>) Collections.singletonList(pkVar), w.this.x);
                com.byazt.uq.qg.n(pkVar, "splash_ad");
            }
            w.this.f.set(2);
            com.byazt.eo.n.n("Splash_FullLink", "onSplashLoadSuccess() 媒体处理完成");
            n(z, false, (Object) qgVar);
            vbVar.hd(System.currentTimeMillis() - jCurrentTimeMillis);
            if (z2) {
                x.n(w.this.rv, vbVar, pkVar, z, jCurrentTimeMillis);
            }
        }

        public void qg(final com.byazt.se.x xVar) {
            if (xVar == null) {
                return;
            }
            w.this.cp();
            if (this.qg.get()) {
                return;
            }
            this.qg.set(true);
            w.this.n(false);
            com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.hi.w.n.3
                @Override // java.lang.Runnable
                public void run() {
                    if (w.this.fs != null) {
                        if (w.this.f.get() > 0) {
                            w.this.fs.n(null, new com.byazt.di.n(1, "load splash material fail"));
                            return;
                        }
                        com.byazt.di.n nVar = new com.byazt.di.n(xVar.q(), xVar.l());
                        w.this.n((String) null, false, nVar, (pk) null);
                        w.this.fs.n(nVar);
                    }
                }
            });
            w.this.l();
            com.byazt.eo.n.s("Splash_FullLink", "onSplashLoadFail 素材加载加载失败 code: " + xVar.q());
            x.n(xVar.fs(), w.this.qg(xVar.fs()), w.this.l, xVar);
        }

        public void n(final com.byazt.se.rv rvVar) {
            w.this.cp();
            if (this.qg.get()) {
                return;
            }
            this.qg.set(true);
            boolean z = rvVar != null && rvVar.s();
            w.this.n(rvVar);
            w wVar = w.this;
            wVar.n(z, z ? wVar.t : wVar.h);
            com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.hi.w.n.4
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.se.rv rvVar2;
                    if (w.this.fs == null || (rvVar2 = rvVar) == null) {
                        return;
                    }
                    n.this.n(rvVar2.n(), 2);
                    w.this.fs.qg(rvVar.n());
                }
            });
        }

        public void s(com.byazt.se.x xVar) {
            w.this.cp();
            if (this.qg.get()) {
                return;
            }
            this.qg.set(true);
            x.n(xVar.fs(), w.this.qg(xVar.fs()), w.this.l, xVar);
            q(xVar);
            k.qg("SplashLoadManager", "渲染失败 code " + xVar.q() + " msg " + xVar.l());
        }

        public void n() {
            com.byazt.eo.n.n("Splash_FullLink", "onTimeOut start");
            w.this.ln.set(true);
            if (this.qg.get()) {
                return;
            }
            this.qg.set(true);
            if (w.this.f.get() == 0) {
                w.this.n(false);
            }
            if (w.this.wo != null) {
                w.this.wo.n();
            }
            com.byazt.eo.n.n("Splash_FullLink", "开屏超时");
            if (w.this.fs != null) {
                if (w.this.f.get() > 0) {
                    w.this.fs.n(null, new com.byazt.di.n(3, "load success but render fail"));
                } else {
                    com.byazt.di.n nVar = new com.byazt.di.n(23, "load splash time out");
                    w.this.n((String) null, false, nVar, (pk) null);
                    w.this.fs.n(nVar);
                }
                w.this.l();
            }
            boolean z = w.this.pk;
            w wVar = w.this;
            x.n(z, wVar.qg(wVar.pk), w.this.l, new com.byazt.se.x(23, "load splash time out", w.this.pk));
            boolean z2 = w.this.pk;
            w wVar2 = w.this;
            x.n(z2, wVar2.qg(wVar2.pk), w.this.l);
        }

        public void qg() {
            if (this.qg.get()) {
                return;
            }
            com.byazt.eo.n.n("Splash_FullLink", "触发 buffer_time超时 开始给加载成功回调以及开始渲染");
            w.this.tj();
        }

        public boolean s() {
            return this.qg.get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(com.byazt.fvm.qg qgVar, int i) {
            if (qgVar instanceof com.byazt.hw.n) {
                ((com.byazt.hw.n) qgVar).n(i);
            }
        }

        private void n(boolean z, boolean z2, Object obj) {
            pk pkVarQg = w.this.qg(true);
            if (w.this.oa == null || pkVarQg == null) {
                return;
            }
            String strOu = pkVarQg.ou();
            w.this.oa.n(w.this.l.q(), strOu, z, z2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final boolean z, final vb vbVar) {
        com.byazt.ag.qg.n(new com.byazt.qit.x("preloadSplash") { // from class: com.byazt.hi.w.13
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.s(z)) {
                    w.this.d();
                } else {
                    w.this.l();
                }
                vb vbVar2 = vbVar;
                boolean z2 = vbVar2 != null && vbVar2.an();
                vb vbVar3 = vbVar;
                boolean z3 = vbVar3 != null && vbVar3.v();
                boolean z4 = z;
                x.n(z4, w.this.qg(z4), w.this.l, z2, z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (com.byazt.jr.l.n(this.l, this.w)) {
            return;
        }
        this.oa.n(new z(this.a.q(), this.a.qg(), null), this.l, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(boolean z) {
        com.byazt.se.w wVar;
        return (z || this.oa == null || (wVar = this.a) == null || wVar.q() == null || this.a.qg() == null || !com.byazt.ci.l.n(this.a.qg())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.se.w wVar) {
        boolean zL = wVar.l();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.k;
        if (zL) {
            x.n(this.t);
            this.bb.n(nf.n(qg(zL)));
            this.bb.qg(nf.s(qg(zL)));
            this.bb.n(j);
            this.hd = jCurrentTimeMillis;
            com.byazt.eo.n.n("Splash_FullLink", "缓存加载物料--end 耗时S1： " + j);
            return;
        }
        x.n(this.h);
        this.ur.n(nf.n(qg(zL)));
        this.ur.qg(nf.s(qg(zL)));
        this.ur.n(j);
        this.cy = jCurrentTimeMillis;
        x.n(this.h, wVar);
        com.byazt.mw.s.n().s().n(this.h);
        com.byazt.eo.n.n("Splash_FullLink", "实时加载物料--end 耗时S1： " + j);
    }

    private void n(final com.byazt.se.fs fsVar, com.byazt.se.w wVar, final n nVar) {
        if (fsVar != null && this.f.get() <= 0) {
            final boolean zCp = fsVar.cp();
            com.byazt.jr.n nVarQg = qg(wVar, fsVar, nVar);
            fsVar.n(nVarQg.n());
            if (!q(fsVar.cp())) {
                com.byazt.eo.n.n("Splash_FullLink", "不需要等待实时广告 isCacheAd " + zCp);
                if (n()) {
                    l.qg(new Runnable() { // from class: com.byazt.hi.w.14
                        @Override // java.lang.Runnable
                        public void run() {
                            n nVar2 = nVar;
                            if (nVar2 != null) {
                                nVar2.n(fsVar);
                            }
                        }
                    });
                    n(wVar, nVarQg);
                    return;
                } else {
                    l.qg(new Runnable() { // from class: com.byazt.hi.w.15
                        @Override // java.lang.Runnable
                        public void run() {
                            final long jCurrentTimeMillis = System.currentTimeMillis();
                            com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.hi.w.15.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x.q(zCp ? w.this.t : w.this.h, jCurrentTimeMillis);
                                    nVar.n(fsVar);
                                }
                            });
                        }
                    });
                    n(wVar, nVarQg);
                    return;
                }
            }
            com.byazt.eo.n.n("Splash_FullLink", "缓存素材加载成功，等待实时广告 isCacheAd " + zCp);
            this.ou = fsVar;
            this.wm = nVarQg.n();
            this.lh.set(true);
            if (this.dg.get()) {
                x();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final com.byazt.se.w wVar, final n nVar) {
        if (wVar == null || nVar == null) {
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        x.s(wVar.l() ? this.t : this.h, System.currentTimeMillis());
        com.byazt.se.qg qgVar = new com.byazt.se.qg(wVar.qg(), wVar.l());
        qgVar.n(wVar.q());
        qgVar.n(wVar.l());
        qgVar.n(wVar.n());
        qgVar.n(wVar.s());
        new com.byazt.jr.w(qgVar, new com.byazt.jr.s<com.byazt.se.fs, com.byazt.se.x>() { // from class: com.byazt.hi.w.16
            public com.byazt.se.fs l;

            @Override // com.byazt.jr.s
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public void s(com.byazt.se.fs fsVar) {
                this.l = fsVar;
                w.this.n(fsVar, wVar, nVar, (com.byazt.fvm.qg) null, true);
            }

            @Override // com.byazt.jr.s
            public void qg(com.byazt.se.fs fsVar) {
                com.byazt.se.fs fsVar2 = this.l;
                if (fsVar2 != null) {
                    fsVar2.l(true);
                }
                w.this.n(fsVar, wVar, nVar, (com.byazt.fvm.qg) null, jElapsedRealtime, true);
            }

            @Override // com.byazt.jr.s
            public void n(com.byazt.se.x xVar) {
                w.this.n(wVar, xVar, nVar, jElapsedRealtime);
            }
        }).qg();
        n(wVar.l(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(boolean z) {
        return z && sz();
    }

    private void n(final com.byazt.jr.n nVar, final boolean z, final int i) {
        l(z);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.hi.w.2
            @Override // java.lang.Runnable
            public void run() {
                x.q(z ? w.this.t : w.this.h, jCurrentTimeMillis);
                if (nVar == null) {
                    return;
                }
                System.currentTimeMillis();
                nVar.n(i);
                nVar.qg();
            }
        });
    }

    private void n(com.byazt.se.fs fsVar, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zCp = fsVar.cp();
        if (zCp) {
            x.n(this.t, fsVar);
            x.n(this.t, fsVar, j, qg(zCp));
            x.n(qg(zCp), this.t, fsVar);
            n(zCp, fsVar, jCurrentTimeMillis - this.hd);
            com.byazt.se.fs fsVar2 = this.ou;
            if (fsVar2 != null) {
                fsVar2.l(true);
            }
        } else {
            x.n(this.h, fsVar);
            x.n(this.h, fsVar, j, qg(zCp));
            x.n(qg(zCp), this.h, fsVar);
            n(zCp, fsVar, jCurrentTimeMillis - this.cy);
        }
        qg(fsVar, jCurrentTimeMillis);
        if (this.f.get() <= 0 || this.ln.get()) {
            return;
        }
        if (this.oj.get()) {
            if (zCp) {
                x.n(this.rv, this.t, fsVar.qg(), true, jCurrentTimeMillis);
            }
        } else {
            if (zCp) {
                return;
            }
            x.n(this.rv, this.h, fsVar.qg(), false, jCurrentTimeMillis);
        }
    }

    private void qg(com.byazt.se.fs fsVar, long j) {
        if (fsVar.cp()) {
            if (this.ae.get()) {
                return;
            }
            this.bb.qg(j - this.hd);
            this.t.s(fsVar.w());
            this.t.qg(fsVar.l());
            return;
        }
        if (this.an.get()) {
            return;
        }
        this.ur.qg(j - this.cy);
        this.h.s(fsVar.w());
        this.h.qg(fsVar.l());
    }

    private void n(boolean z, com.byazt.se.fs fsVar, long j) {
        String str = z ? "缓存广告" : "实时广告";
        if (fsVar.l()) {
            if (fsVar.tj()) {
                com.byazt.eo.n.n("Splash_FullLink", str + "： 加载缓存视频素材--end, 耗时S2： " + j);
                return;
            } else {
                com.byazt.eo.n.n("Splash_FullLink", str + "： 加载网络视频素材--end, 耗时S2： " + j);
                return;
            }
        }
        if (fsVar.w()) {
            com.byazt.eo.n.n("Splash_FullLink", str + "： 加载缓存图片素材--end, 耗时S2： " + j);
        } else {
            com.byazt.eo.n.n("Splash_FullLink", str + "： 加载网络图片素材--end, 耗时S2：" + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(com.byazt.se.w wVar, n nVar) {
        if (wVar == null || nVar == null) {
            return;
        }
        pk pkVarQg = wVar.qg();
        boolean zL = wVar.l();
        com.byazt.jr.n nVarN = n(wVar, new com.byazt.se.fs(pkVarQg, zL), nVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.byazt.se.qg qgVar = new com.byazt.se.qg(pkVarQg, zL);
        qgVar.n(zL);
        qgVar.n(wVar.q());
        qgVar.n(wVar.n());
        qgVar.n(wVar.s());
        com.byazt.jr.w wVarN = n(wVar, nVar, nVarN.n(), qgVar, jElapsedRealtime);
        nVarN.n(wVarN);
        x.s(zL ? this.t : this.h, System.currentTimeMillis());
        wVarN.qg();
        n(zL, 1);
        n(wVar, nVarN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final com.byazt.se.fs fsVar, com.byazt.se.w wVar, final n nVar, com.byazt.fvm.qg qgVar) {
        if (fsVar != null && this.f.get() <= 0) {
            final boolean zCp = fsVar.cp();
            if (!q(zCp)) {
                com.byazt.eo.n.n("Splash_FullLink", "实时素材加载成功，不需要等待实时广告, 此时渲染结果: " + this.v.get());
                fsVar.n(qgVar);
                if (n()) {
                    nVar.n(fsVar);
                    if (this.v.get()) {
                        nVar.n(this.m);
                        return;
                    }
                    return;
                }
                final long jCurrentTimeMillis = System.currentTimeMillis();
                com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.hi.w.3
                    @Override // java.lang.Runnable
                    public void run() {
                        x.q(zCp ? w.this.t : w.this.h, jCurrentTimeMillis);
                        nVar.n(fsVar);
                        if (w.this.v.get()) {
                            nVar.n(w.this.m);
                        }
                    }
                });
                return;
            }
            com.byazt.eo.n.n("Splash_FullLink", "缓存广告: 素材加载成功，需要等待实时广告");
            this.ou = fsVar;
            this.wm = qgVar;
            this.lh.set(true);
            if (this.dg.get()) {
                x();
            }
        }
    }

    private com.byazt.jr.w n(final com.byazt.se.w wVar, final n nVar, final com.byazt.fvm.qg qgVar, com.byazt.se.qg qgVar2, final long j) {
        return new com.byazt.jr.w(qgVar2, new com.byazt.jr.s<com.byazt.se.fs, com.byazt.se.x>() { // from class: com.byazt.hi.w.4
            public com.byazt.se.fs w;

            @Override // com.byazt.jr.s
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public void s(com.byazt.se.fs fsVar) {
                this.w = fsVar;
                w.this.n(fsVar, wVar, nVar, qgVar, false);
            }

            @Override // com.byazt.jr.s
            public void qg(com.byazt.se.fs fsVar) {
                com.byazt.se.fs fsVar2 = this.w;
                if (fsVar2 != null) {
                    fsVar2.l(true);
                }
                w.this.n(fsVar, wVar, nVar, qgVar, j, false);
            }

            @Override // com.byazt.jr.s
            public void n(com.byazt.se.x xVar) {
                w.this.n(wVar, xVar, nVar, j);
            }
        });
    }

    private com.byazt.jr.n n(final com.byazt.se.w wVar, com.byazt.se.fs fsVar, final n nVar) {
        return new com.byazt.jr.n(new com.byazt.se.s(this.rv, "splash_ad", wVar, fsVar, this.l, false), new com.byazt.jr.q<com.byazt.se.rv, com.byazt.se.x>() { // from class: com.byazt.hi.w.5
            @Override // com.byazt.jr.q
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public void qg(com.byazt.se.rv rvVar) {
                w.this.w(wVar.l());
                if (!w.this.q(rvVar.s())) {
                    com.byazt.eo.n.n("Splash_FullLink", "createCSJSplashRenderParallel- 实时广告onSuccess");
                    w.this.v.set(true);
                    w.this.m = rvVar;
                    if (w.this.f.get() == 2) {
                        if (w.this.sz()) {
                            if (w.this.oj.get()) {
                                return;
                            }
                            nVar.n(rvVar);
                            return;
                        }
                        nVar.n(rvVar);
                        return;
                    }
                    return;
                }
                com.byazt.eo.n.n("Splash_FullLink", "缓存渲染成功 需要等待实时广告: ");
                if (w.this.df.get() && !w.this.fi.get()) {
                    com.byazt.eo.n.n("Splash_FullLink", "已经超时走缓存广告");
                    w.this.fi.set(true);
                    nVar.n(rvVar);
                }
                w.this.j.set(true);
                w.this.hu = rvVar;
            }

            @Override // com.byazt.jr.q
            public void n(com.byazt.se.x xVar) {
                if (!w.this.q(xVar.fs())) {
                    w.this.v.set(false);
                    nVar.s(xVar);
                } else {
                    w.this.j.set(false);
                }
            }

            @Override // com.byazt.jr.q
            public void n() {
                w.this.qg(wVar);
            }
        }, this.oa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qg(pk pkVar, boolean z) {
        if (pkVar == null) {
            return false;
        }
        if (sz() && z && k()) {
            return false;
        }
        if ((com.byazt.ed.q.n().oa() & 1) == 1) {
            return true;
        }
        return fs.qg(pkVar) && qg(pkVar) && pkVar.rg() == 1;
    }

    private boolean qg(pk pkVar) {
        return pkVar != null && nf.n(pkVar) == 2;
    }

    private com.byazt.jr.n qg(final com.byazt.se.w wVar, com.byazt.se.fs fsVar, final n nVar) {
        if (wVar == null || fsVar == null || nVar == null) {
            return null;
        }
        return new com.byazt.jr.n(new com.byazt.se.s(this.rv, "splash_ad", wVar, fsVar, this.l, true), new com.byazt.jr.q<com.byazt.se.rv, com.byazt.se.x>() { // from class: com.byazt.hi.w.6
            @Override // com.byazt.jr.q
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public void qg(com.byazt.se.rv rvVar) {
                w.this.w(wVar.l());
                if (w.this.oj.get()) {
                    if (wVar.l()) {
                        nVar.n(rvVar);
                    }
                } else {
                    if (wVar.l()) {
                        return;
                    }
                    nVar.n(rvVar);
                }
            }

            @Override // com.byazt.jr.q
            public void n(com.byazt.se.x xVar) {
                nVar.s(xVar);
            }

            @Override // com.byazt.jr.q
            public void n() {
                w.this.qg(wVar);
            }
        }, this.oa);
    }

    private void n(com.byazt.se.w wVar, com.byazt.jr.n nVar) {
        if (nVar == null || this.ln.get()) {
            return;
        }
        int iS = s(qg(wVar.l()));
        com.byazt.eo.n.n("Splash_FullLink", "开始渲染 isCache " + wVar.l() + ", 渲染超时设置：" + iS);
        n(nVar, wVar.l(), iS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.se.rv rvVar) {
        if (rvVar == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zS = rvVar.s();
        if (zS) {
            x.n(qg(zS), this.bb, rvVar);
            this.bb.q(jCurrentTimeMillis - this.k);
            this.bb.q(this.q);
            this.bb.n(zS);
            x.n(qg(zS), this.bb);
            x.qg(qg(zS), this.bb);
        } else {
            x.n(qg(zS), this.ur, rvVar);
            this.ur.q(jCurrentTimeMillis - this.k);
            this.ur.q(this.q);
            this.ur.n(zS);
            x.n(qg(zS), this.ur);
            x.qg(qg(zS), this.ur);
            com.byazt.eo.n.n("Splash_FullLink", "开屏广告渲染--end, 耗时S3： " + (jCurrentTimeMillis - this.cd));
        }
        com.byazt.eo.n.n("Splash_FullLink", "渲染成功回调 开屏广告类型： ".concat(zS ? "缓存" : "实时"));
        com.byazt.eo.n.n("Splash_FullLink", "加载开屏广告--end，总耗时： " + (jCurrentTimeMillis - this.k));
        com.byazt.eo.n.n("Splash_FullLink", "加载开屏广告--end，getReqId： " + qg(zS).ou());
    }

    private int s(pk pkVar) {
        return Math.max(com.byazt.ed.q.n().sz(), (this.d - ((int) (System.currentTimeMillis() - this.k))) - (pkVar != null ? nf.w(pkVar) : 100));
    }

    private y s(com.byazt.zq.qg qgVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        y yVar = new y();
        yVar.x = 2;
        yVar.fs = jCurrentTimeMillis;
        yVar.sz = com.byazt.vyf.s.cy().pe();
        Object obj = this.fs;
        if (obj != null && (obj instanceof com.byazt.yy.qg)) {
            yVar.rv = ((com.byazt.yy.qg) obj).qg();
        }
        return yVar;
    }

    private void n(String str, int i, int i2) {
        int iSz = com.byazt.nf.rv.qg().sz(str);
        if (iSz == 1) {
            this.d = i > 0 ? Math.min(i, i2) : Math.max(i2, 500);
        } else if (iSz == 2) {
            this.d = i > 0 ? i : Math.max(i2, 500);
        } else {
            this.d = i > 0 ? Math.max(i, i2) : Math.max(i2, 500);
        }
        int iCurrentTimeMillis = (int) (((long) this.d) - (System.currentTimeMillis() - this.w.rv));
        if (iCurrentTimeMillis <= 0) {
            iCurrentTimeMillis = this.d;
        }
        this.d = iCurrentTimeMillis;
        com.byazt.eo.n.n("Splash_FullLink", "splashTimeOutControlType = " + iSz + "; devTimeOut = " + i2 + "; cloudTimeOut = " + i + "; realTimeOut = " + this.d);
        this.tj.sendEmptyMessageDelayed(2, this.d);
        n(this.d);
    }

    private void n(int i) {
        int iFs = com.byazt.nf.rv.qg().fs(this.cp);
        if (iFs >= i || iFs <= 0 || !sz() || this.tj == null) {
            return;
        }
        int i2 = i - iFs;
        com.byazt.eo.n.n("Splash_FullLink", "buffer time: " + iFs + "  减去buffer time后超时时间：" + i2);
        this.tj.sendEmptyMessageDelayed(4, i2);
    }

    private void oa() {
        this.h = new vb();
        vb vbVar = new vb();
        this.t = vbVar;
        x.n(this.h, vbVar);
        this.ur = new com.byazt.se.q();
        this.bb = new com.byazt.se.q();
    }

    private void l(boolean z) {
        if (z) {
            this.um = System.currentTimeMillis();
        } else {
            this.cd = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        if (z) {
            this.bb.s(System.currentTimeMillis() - this.um);
        } else {
            this.ur.s(System.currentTimeMillis() - this.cd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sz() {
        return this.q == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final com.byazt.se.fs fsVar, final com.byazt.se.w wVar, final n nVar, final com.byazt.fvm.qg qgVar, boolean z) {
        if (this.ln.get()) {
            return;
        }
        qg(fsVar, System.currentTimeMillis());
        if (fsVar.cp()) {
            com.byazt.eo.n.n("Splash_FullLink", "缓存广告： 素材首包回调");
            this.ae.set(true);
        } else {
            com.byazt.eo.n.n("Splash_FullLink", "实时广告： 素材首包回调");
            this.an.set(true);
        }
        x.n(fsVar.cp() ? this.t : this.h, 3);
        x(fsVar.cp());
        if (z) {
            n(fsVar, wVar, nVar);
        } else {
            l.qg(new Runnable() { // from class: com.byazt.hi.w.7
                @Override // java.lang.Runnable
                public void run() {
                    w.this.n(fsVar, wVar, nVar, qgVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final com.byazt.se.fs fsVar, final com.byazt.se.w wVar, final n nVar, final com.byazt.fvm.qg qgVar, long j, boolean z) {
        if (fsVar == null) {
            return;
        }
        n(wVar, wVar.l(), false);
        if (this.ln.get()) {
            return;
        }
        if (qgVar instanceof com.byazt.hw.n) {
            ((com.byazt.hw.n) qgVar).n(fsVar, false);
        }
        n(fsVar, j);
        if (fsVar.cp() && this.ae.get()) {
            return;
        }
        if (fsVar.cp() || !this.an.get()) {
            if (n(fsVar.qg(), fsVar.l()) || n(wVar.qg())) {
                x.n(fsVar.cp() ? this.t : this.h, 2);
                x(fsVar.cp());
            }
            if (z) {
                n(fsVar, wVar, nVar);
            } else {
                l.qg(new Runnable() { // from class: com.byazt.hi.w.8
                    @Override // java.lang.Runnable
                    public void run() {
                        w.this.n(fsVar, wVar, nVar, qgVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.se.w wVar, com.byazt.se.x xVar, n nVar, long j) {
        if (xVar == null) {
            return;
        }
        boolean zFs = xVar.fs();
        if (!q(zFs)) {
            com.byazt.eo.n.n("Splash_FullLink", "实时cac广告: 素材加载失败，直接给回调");
            nVar.qg(xVar);
        } else {
            com.byazt.eo.n.n("Splash_FullLink", "缓存广告: 素材加载失败");
            this.lh.set(false);
            if (this.dg.get()) {
                nVar.qg(xVar);
            }
        }
        n(wVar, zFs, false);
        int i = xVar.w() ? -14 : -7;
        if (!xVar.w()) {
            fs.n(j, false, false, qg(xVar.fs()), i, xVar.l());
        }
        com.byazt.eo.n.n("Splash_FullLink", (zFs ? "缓存广告" : "实时广告") + "加载素材失败 " + xVar.q());
    }

    private void x(boolean z) {
        if (this.tj != null) {
            if (sz()) {
                if (z) {
                    return;
                } else {
                    this.tj.removeMessages(4);
                }
            }
            this.tj.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(com.byazt.se.w wVar) {
        if (wVar != null && wVar.l()) {
            return;
        }
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.se.w wVar, boolean z, boolean z2) {
        if (z) {
            return;
        }
        try {
            if (this.f.get() > 0 && !this.oj.get()) {
                com.byazt.eo.n.n("lqmt", "该实时广告已回调媒体");
            } else {
                if (com.byazt.jr.l.n(this.l, this.w)) {
                    return;
                }
                if (this.f.get() > 0 || this.sz.s()) {
                    this.oa.n(wVar, this.l, z2, this.q);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void n(boolean z, int i) {
        (z ? this.bb : this.ur).l(i);
    }

    public static boolean n() {
        return (com.byazt.ed.q.n().d() & 256) == 256;
    }

    public static boolean n(com.byazt.zq.qg qgVar) {
        return com.byazt.jr.l.n(qgVar, new y()) && (com.byazt.ed.q.n().d() & 4) == 4;
    }

    private boolean k() {
        return (com.byazt.ed.q.n().cp() & 4) == 4;
    }
}
