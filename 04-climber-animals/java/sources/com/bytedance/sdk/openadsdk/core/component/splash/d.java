package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ny;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qk;
import com.bytedance.sdk.openadsdk.core.nw.tz;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class d implements le.ms {
    private int ab;
    private e ah;
    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c ao;
    private qk b;
    private final le c;
    private ms ch;
    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab e;
    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c h;
    private long hi;
    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.d i;
    private Context ka;
    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka lm;
    private ny nw;
    private com.bytedance.sdk.openadsdk.core.component.splash.ms.ms ny;
    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x qv;
    private qk re;
    private long sl;
    private ny t;
    private long u;
    private long ub;
    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.d w;
    private int x;
    private com.bytedance.sdk.openadsdk.ao.xr.ah.xr xr;
    private com.bytedance.sdk.openadsdk.ao.xr.xr.xr y;
    private long zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f2383ms = 2;
    private com.bytedance.sdk.openadsdk.t.ms.xr.ms.ms d = null;
    private final AtomicBoolean yu = new AtomicBoolean(false);
    private final AtomicBoolean op = new AtomicBoolean(false);
    private final AtomicBoolean le = new AtomicBoolean(false);
    private final AtomicBoolean cv = new AtomicBoolean(false);
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean of = new AtomicBoolean(false);
    private final AtomicInteger p = new AtomicInteger(0);
    private final AtomicBoolean pc = new AtomicBoolean(false);
    private final AtomicBoolean jw = new AtomicBoolean(false);
    private final AtomicBoolean f = new AtomicBoolean(false);
    private final AtomicBoolean ul = new AtomicBoolean(false);
    private final AtomicInteger az = new AtomicInteger(0);
    private boolean m = false;

    private d(Context context) {
        if (context != null) {
            this.ka = context.getApplicationContext();
        } else {
            this.ka = re.getContext();
        }
        this.c = new le(Looper.getMainLooper(), this);
        this.ch = new ms();
        ch.ub().ny(false);
        hi();
    }

    public static d ms(Context context) {
        return new d(context);
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, com.bytedance.sdk.openadsdk.t.ms.xr.ms.ms msVar, int i) {
        this.d = msVar;
        ms(xrVar, i);
    }

    private void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, int i) {
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "加载开屏广告--begin ");
        this.hi = System.currentTimeMillis();
        this.ah = xr(xrVar);
        this.xr = xrVar;
        this.ab = f.xr(xrVar);
        this.ny = com.bytedance.sdk.openadsdk.core.component.splash.ms.ms.ms();
        int iNy = re.xr().ny(this.ab);
        this.f2383ms = iNy;
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "当前rit位 " + this.ab);
        int iC = re.xr().c(xrVar.d());
        ms(xrVar.d(), iC, i);
        long j = i;
        this.ah.ny = j;
        this.ah.ch = iC;
        this.ah.hi = this.x;
        ka.ms(xrVar, j);
        xr();
        ms(xrVar, this.ah, iNy);
    }

    private void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar, int i) {
        if (xrVar == null) {
            return;
        }
        ka.ms(this.b, this.re, eVar, this.f2383ms, i);
        ms(xrVar, eVar, this.ch);
    }

    private void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, e eVar, final ms msVar) {
        if (msVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka kaVar = new com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka(new com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ka(xrVar, eVar), new com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr<com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.1
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar) {
                if (cVar == null || cVar.xr() == null) {
                    msVar.ms(new com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab(1, "no ad model", false));
                    return;
                }
                lm lmVarXr = cVar.xr();
                if (cVar.ka()) {
                    d.this.az.set(1);
                    d.this.h = cVar;
                    if (!d.this.sl()) {
                        d.this.m = true;
                    }
                } else {
                    d.this.ao = cVar;
                    d.this.m = false;
                }
                if (d.this.yu.get() || d.this.ch.ah() || d.this.p.get() > 0) {
                    d.this.ms(cVar, cVar.ka(), true);
                    return;
                }
                d.this.ms(cVar);
                if (d.this.xr(lmVarXr, cVar.ka())) {
                    com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "开始并发加载素材 ");
                    d.this.xr(cVar, msVar);
                } else {
                    com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "开始串行加载素材 getReqId " + cVar.xr().eu());
                    d.this.ms(cVar, msVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.xr
            public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar) {
                boolean zX = abVar.x();
                if (zX) {
                    d.this.az.set(-1);
                }
                if (!d.this.ah(zX)) {
                    d.this.e = abVar;
                    if (d.this.sl()) {
                        if (d.this.az.get() != -1) {
                            if (d.this.az.get() == 1) {
                                d.this.ka();
                            }
                        } else {
                            msVar.ms(abVar);
                        }
                        d.this.ul.set(true);
                        return;
                    }
                    msVar.ms(abVar);
                    return;
                }
                if (d.this.ul.get()) {
                    msVar.ms(d.this.e);
                }
            }
        }, this.ny);
        this.lm = kaVar;
        kaVar.ms(this.f2383ms);
    }

    private void xr() {
        this.yu.set(false);
        this.op.set(false);
        this.le.set(false);
        this.cv.set(false);
        this.pc.set(false);
        this.jw.set(false);
        this.g.set(false);
        this.of.set(false);
        this.f.set(false);
        this.ul.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah() {
        int i;
        if (com.bytedance.sdk.openadsdk.core.component.splash.ms.ms.ms(this.f2383ms) && ((i = this.f2383ms) == 1 || i == 3)) {
            return;
        }
        d();
    }

    private void d() {
        com.bytedance.sdk.openadsdk.core.component.splash.ms.ms msVar = this.ny;
        if (msVar != null) {
            msVar.xr(this.xr, this.ah);
        }
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message.what == 2) {
            ms msVar = this.ch;
            if (msVar != null) {
                msVar.ms();
            }
            le leVar = this.c;
            if (leVar != null) {
                leVar.removeMessages(2);
            }
        }
        if (message.what == 4) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        int iOptInt;
        com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar = this.h;
        if (cVar != null && cVar.xr() != null && this.h.xr().br() != null && (iOptInt = this.h.xr().br().optInt("real_drop_cache_type", 0)) == 1) {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("SplashLoadManager", "loadCacheWhenRealAdDrop - 缓存兜底返回配置 realDropCacheType： " + iOptInt);
            c();
        } else {
            ms msVar = this.ch;
            if (msVar != null) {
                msVar.ms(this.e);
            }
        }
    }

    private void c() {
        le leVar = this.c;
        if (leVar != null) {
            leVar.removeMessages(4);
        }
        ms msVar = this.ch;
        if (msVar != null) {
            msVar.xr();
        }
    }

    private boolean ms(lm lmVar, boolean z) {
        return (lmVar == null || z || lmVar.ce() != 3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ms(lm lmVar) {
        return (lmVar != null ? lmVar.ce() : 0) == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public lm ms(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar = this.h;
            if (cVar == null) {
                return null;
            }
            return cVar.xr();
        }
        com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar2 = this.ao;
        if (cVar2 == null) {
            return null;
        }
        return cVar2.xr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab() {
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "startCallBackWhenBufferTimeout ");
        this.ch.ms(this.qv);
        this.jw.set(true);
        if (!this.cv.get() || this.pc.get()) {
            return;
        }
        this.pc.set(true);
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "素材加载和渲染并发 buffer_time超时 缓存素材加载成功，渲染成功开始给 onRenderSplashSuccess回调");
        this.ch.ms(this.nw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.ch == null) {
            return;
        }
        if (xr(ms(true), true)) {
            AtomicBoolean atomicBoolean = this.op;
            if (atomicBoolean == null || !atomicBoolean.get()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "buffer_time超时-并发 缓存素材加载成功，开始给加载成功回调");
            com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar = this.qv;
            if (xVar != null) {
                xVar.ms(this.y);
            }
            final long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.4
                @Override // java.lang.Runnable
                public void run() {
                    ka.d(d.this.re, jCurrentTimeMillis);
                    d.this.ab();
                }
            });
            return;
        }
        AtomicBoolean atomicBoolean2 = this.op;
        if (atomicBoolean2 == null || !atomicBoolean2.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "buffer_time超时-串行 缓存素材加载成功，开始给加载成功回调以及开始渲染");
        final com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ms msVarXr = xr(this.h, this.qv, this.ch);
        com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar2 = this.qv;
        if (xVar2 != null) {
            xVar2.ms(msVarXr.ms());
        }
        final long jCurrentTimeMillis2 = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.5
            @Override // java.lang.Runnable
            public void run() {
                ka.d(d.this.re, jCurrentTimeMillis2);
                d.this.ch.ms(d.this.qv);
                d dVar = d.this;
                dVar.ms(dVar.h, msVarXr, d.this.qv.ka());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny() {
        le leVar = this.c;
        if (leVar != null) {
            leVar.removeMessages(4);
        }
        le leVar2 = this.c;
        if (leVar2 != null) {
            leVar2.removeMessages(2);
        }
    }

    class ms {
        private final AtomicBoolean xr = new AtomicBoolean(false);

        ms() {
        }

        private void d(final com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar) {
            if (abVar == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.d != null) {
                        d.this.d.ms(abVar.ny(), new com.bytedance.sdk.openadsdk.ao.xr.ka(abVar.d(), abVar.ka()));
                        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "onSplashRenderFail回调 true " + abVar.d());
                    }
                }
            });
            d.this.ah();
        }

        public void ms(final com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar) {
            if (abVar == null) {
                return;
            }
            d.this.ny();
            if (this.xr.get()) {
                return;
            }
            this.xr.set(true);
            com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.d != null) {
                        if (abVar.d() == 22) {
                            abVar.xr(1);
                        }
                        d.this.d.ms(new com.bytedance.sdk.openadsdk.ao.xr.ka(abVar.d(), abVar.ka()));
                        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "onSplashLoadFail 回调");
                    }
                }
            });
            ms(false, true, (Object) null);
            d.this.ah();
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "onLoadSplashAdFail回调 广告获取失败");
            ka.ms(abVar.x(), d.this.ms(abVar.x()), d.this.xr, abVar);
        }

        public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar) {
            if (this.xr.get() || xVar == null) {
                return;
            }
            qk qkVar = xVar.hi() ? d.this.re : d.this.b;
            if (qkVar != null) {
                qkVar.c(xVar.ms());
                qkVar.qv(xVar.u());
                qkVar.nw(System.currentTimeMillis() - qkVar.i());
            }
            ms(d.this.d, qkVar, xVar.xr(), xVar.sl(), xVar.hi(), xVar.ub());
        }

        private void ms(com.bytedance.sdk.openadsdk.t.ms.xr.ms.ms msVar, qk qkVar, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.xr.xr xrVar, boolean z, boolean z2) {
            if (msVar == null || qkVar == null || d.this.p.get() > 0) {
                return;
            }
            if (d.this.ms(lmVar)) {
                d dVar = d.this;
                ka.ms(z ? dVar.re : dVar.b, 2);
                d.this.ny();
            }
            d.this.f.set(z);
            d.this.p.set(1);
            long jCurrentTimeMillis = System.currentTimeMillis();
            ms(xrVar, 1);
            msVar.ms(xrVar);
            d.this.p.set(2);
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "onSplashLoadSuccess() 媒体处理完成");
            ms(z, false, (Object) xrVar);
            qkVar.h(System.currentTimeMillis() - jCurrentTimeMillis);
            if (z2) {
                ka.ms(d.this.ka, qkVar, lmVar, z, jCurrentTimeMillis);
            }
        }

        public void xr(final com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar) {
            if (abVar == null) {
                return;
            }
            d.this.ny();
            if (this.xr.get()) {
                return;
            }
            this.xr.set(true);
            com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.3
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.d != null) {
                        if (d.this.p.get() > 0) {
                            d.this.d.ms(null, new com.bytedance.sdk.openadsdk.ao.xr.ka(1, "load splash material fail"));
                        } else {
                            d.this.d.ms(new com.bytedance.sdk.openadsdk.ao.xr.ka(abVar.d(), abVar.ka()));
                        }
                    }
                }
            });
            d.this.ah();
            com.bytedance.sdk.openadsdk.core.ab.ms.d("Splash_FullLink", "onSplashLoadFail 素材加载加载失败 code: " + abVar.d());
            ka.ms(abVar.x(), d.this.ms(abVar.x()), d.this.xr, abVar);
        }

        public void ms(final ny nyVar) {
            d.this.ny();
            if (this.xr.get()) {
                return;
            }
            this.xr.set(true);
            boolean z = nyVar != null && nyVar.ah();
            d.this.ms(nyVar);
            d dVar = d.this;
            dVar.ms(z, z ? dVar.re : dVar.b);
            com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.ms.4
                @Override // java.lang.Runnable
                public void run() {
                    ny nyVar2;
                    if (d.this.d == null || (nyVar2 = nyVar) == null) {
                        return;
                    }
                    ms.this.ms(nyVar2.ms(), 2);
                    d.this.d.xr(nyVar.ms());
                }
            });
        }

        public void ah(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar) {
            d.this.ny();
            if (this.xr.get()) {
                return;
            }
            this.xr.set(true);
            ka.ms(abVar.x(), d.this.ms(abVar.x()), d.this.xr, abVar);
            d(abVar);
            sl.d("SplashLoadManager", "渲染失败 code " + abVar.d() + " msg " + abVar.ka());
        }

        public void ms() {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "onTimeOut start");
            d.this.yu.set(true);
            if (this.xr.get()) {
                return;
            }
            this.xr.set(true);
            if (d.this.lm != null) {
                d.this.lm.ms();
            }
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "开屏超时");
            if (d.this.d != null) {
                if (d.this.p.get() > 0) {
                    d.this.d.ms(null, new com.bytedance.sdk.openadsdk.ao.xr.ka(3, "load success but render fail"));
                } else {
                    d.this.d.ms(new com.bytedance.sdk.openadsdk.ao.xr.ka(23, "load splash time out"));
                }
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "回调开屏超时 true");
                d.this.ah();
            }
            boolean z = d.this.m;
            d dVar = d.this;
            ka.ms(z, dVar.ms(dVar.m), d.this.xr, new com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab(23, "load splash time out", d.this.m));
            boolean z2 = d.this.m;
            d dVar2 = d.this;
            ka.ms(z2, dVar2.ms(dVar2.m), d.this.xr);
        }

        public void xr() {
            if (this.xr.get()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "触发 buffer_time超时 开始给加载成功回调以及开始渲染");
            d.this.x();
        }

        public boolean ah() {
            return this.xr.get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ms(com.bytedance.sdk.openadsdk.ao.xr.xr.xr xrVar, int i) {
            if (xrVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.d.ms) {
                ((com.bytedance.sdk.openadsdk.core.component.splash.d.ms) xrVar).ms(i);
            }
        }

        private void ms(boolean z, boolean z2, Object obj) {
            lm lmVarMs = d.this.ms(true);
            if (d.this.ny == null || lmVarMs == null) {
                return;
            }
            String strEu = lmVarMs.eu();
            d.this.ny.ms(d.this.xr.d(), strEu, z, z2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final boolean z, final qk qkVar) {
        com.bytedance.sdk.openadsdk.op.ab.ms(new com.bytedance.sdk.component.ch.ny("preloadSplash") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.xr(z)) {
                    d.this.ch();
                } else {
                    d.this.ah();
                }
                qk qkVar2 = qkVar;
                boolean z2 = qkVar2 != null && qkVar2.jw();
                qk qkVar3 = qkVar;
                boolean z3 = qkVar3 != null && qkVar3.p();
                boolean z4 = z;
                ka.ms(z4, d.this.ms(z4), d.this.xr, z2, z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch() {
        if (com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka.ms(this.xr, this.ah)) {
            return;
        }
        this.ny.ms(new tz(this.ao.d(), this.ao.xr(), null), this.xr, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xr(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar;
        return (z || this.ny == null || (cVar = this.ao) == null || cVar.d() == null || this.ao.xr() == null || !com.bytedance.sdk.openadsdk.core.ka.d.d.ms(this.ao.xr())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar) {
        boolean zKa = cVar.ka();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.hi;
        if (zKa) {
            ka.ms(this.re);
            this.w.ms(ms(zKa).fm());
            this.w.xr(ms(zKa).du());
            this.w.ms(j);
            this.zb = jCurrentTimeMillis;
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "缓存加载物料--end 耗时S1： " + j);
            return;
        }
        ka.ms(this.b);
        this.i.ms(ms(zKa).fm());
        this.i.xr(ms(zKa).du());
        this.i.ms(j);
        this.sl = jCurrentTimeMillis;
        ka.ms(this.b, cVar);
        com.bytedance.sdk.openadsdk.core.re.ka.ms().ah().ms(this.b);
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "实时加载物料--end 耗时S1： " + j);
    }

    private void ms(final com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar, final com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar, final ms msVar) {
        if (xVar != null && this.p.get() <= 0) {
            final boolean zHi = xVar.hi();
            final com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ms msVarXr = xr(cVar, xVar, msVar);
            xVar.ms(msVarXr.ms());
            if (!ah(xVar.hi())) {
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "不需要等待实时广告 isCacheAd " + zHi);
                if (ms()) {
                    msVar.ms(xVar);
                    ms(cVar, msVarXr, xVar.ka());
                    return;
                } else {
                    final long jCurrentTimeMillis = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.7
                        @Override // java.lang.Runnable
                        public void run() {
                            ka.d(zHi ? d.this.re : d.this.b, jCurrentTimeMillis);
                            msVar.ms(xVar);
                            d.this.ms(cVar, msVarXr, xVar.ka());
                        }
                    });
                    return;
                }
            }
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "缓存素材加载成功，等待实时广告 isCacheAd " + zHi);
            this.qv = xVar;
            this.y = msVarXr.ms();
            this.op.set(true);
            if (this.ul.get()) {
                ka();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar, final ms msVar) {
        if (cVar == null || msVar == null) {
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        ka.ah(cVar.ka() ? this.re : this.b, System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr xrVar = new com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr(cVar.xr(), cVar.ka());
        xrVar.ms(cVar.d());
        xrVar.ms(cVar.ka());
        xrVar.ms(cVar.ms());
        xrVar.ms(cVar.ah());
        new com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.c(xrVar, new com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah<com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.8
            private com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x ka;

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public void ah(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar) {
                this.ka = xVar;
                d.this.ms(xVar, cVar, msVar, (com.bytedance.sdk.openadsdk.ao.xr.xr.xr) null, true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah
            public void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar2 = this.ka;
                if (xVar2 != null) {
                    xVar2.ka(true);
                }
                d.this.ms(xVar, cVar, msVar, (com.bytedance.sdk.openadsdk.ao.xr.xr.xr) null, jElapsedRealtime, true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah
            public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar) {
                d.this.ms(cVar, abVar, msVar, jElapsedRealtime);
            }
        }).xr();
        ms(cVar.ka(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ah(boolean z) {
        return z && sl();
    }

    private void ms(final com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ms msVar, boolean z, final int i) {
        d(z);
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.9
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ms msVar2 = msVar;
                if (msVar2 == null) {
                    return;
                }
                msVar2.ms(i);
                msVar.xr();
            }
        });
    }

    private void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zHi = xVar.hi();
        if (zHi) {
            ka.ms(this.re, xVar);
            ka.ms(this.re, xVar, j, ms(zHi));
            ka.ms(ms(zHi), this.re, xVar);
            ms(zHi, xVar, jCurrentTimeMillis - this.zb);
            com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar2 = this.qv;
            if (xVar2 != null) {
                xVar2.ka(true);
            }
        } else {
            ka.ms(this.b, xVar);
            ka.ms(this.b, xVar, j, ms(zHi));
            ka.ms(ms(zHi), this.b, xVar);
            ms(zHi, xVar, jCurrentTimeMillis - this.sl);
        }
        xr(xVar, jCurrentTimeMillis);
        if (this.p.get() <= 0 || this.yu.get()) {
            return;
        }
        if (this.f.get()) {
            if (zHi) {
                ka.ms(this.ka, this.re, xVar.xr(), true, jCurrentTimeMillis);
            }
        } else {
            if (zHi) {
                return;
            }
            ka.ms(this.ka, this.b, xVar.xr(), false, jCurrentTimeMillis);
        }
    }

    private void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar, long j) {
        if (xVar.hi()) {
            if (this.of.get()) {
                return;
            }
            this.w.xr(j - this.zb);
            this.re.ah(xVar.c());
            this.re.xr(xVar.ka());
            return;
        }
        if (this.g.get()) {
            return;
        }
        this.i.xr(j - this.sl);
        this.b.ah(xVar.c());
        this.b.xr(xVar.ka());
    }

    private void ms(boolean z, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar, long j) {
        String str = z ? "缓存广告" : "实时广告";
        if (xVar.ka()) {
            if (xVar.ch()) {
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", str + "： 加载缓存视频素材--end, 耗时S2： " + j);
                return;
            } else {
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", str + "： 加载网络视频素材--end, 耗时S2： " + j);
                return;
            }
        }
        if (xVar.c()) {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", str + "： 加载缓存图片素材--end, 耗时S2： " + j);
        } else {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", str + "： 加载网络图片素材--end, 耗时S2：" + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar, ms msVar) {
        if (cVar == null || msVar == null) {
            return;
        }
        lm lmVarXr = cVar.xr();
        boolean zKa = cVar.ka();
        com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ms msVarMs = ms(cVar, new com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x(lmVarXr, zKa), msVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr xrVar = new com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr(lmVarXr, zKa);
        xrVar.ms(zKa);
        xrVar.ms(cVar.d());
        xrVar.ms(cVar.ms());
        xrVar.ms(cVar.ah());
        com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.c cVarMs = ms(cVar, msVar, msVarMs.ms(), xrVar, jElapsedRealtime);
        msVarMs.ms(cVarMs);
        ka.ah(zKa ? this.re : this.b, System.currentTimeMillis());
        cVarMs.xr();
        int iAh = ah(lmVarXr);
        if (this.yu.get()) {
            return;
        }
        if (ms(lmVarXr, xrVar.d()) && this.c != null && iAh <= 0) {
            iAh = 0;
        }
        ms(zKa, 1);
        ms(msVarMs, zKa, iAh);
    }

    private void ms(final com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar, final ms msVar, com.bytedance.sdk.openadsdk.ao.xr.xr.xr xrVar) {
        if (xVar != null && this.p.get() <= 0) {
            final boolean zHi = xVar.hi();
            if (!ah(zHi)) {
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "实时素材加载成功，不需要等待实时广告, 此时渲染结果: " + this.le.get());
                xVar.ms(xrVar);
                if (ms()) {
                    msVar.ms(xVar);
                    if (this.le.get()) {
                        msVar.ms(this.t);
                        return;
                    }
                    return;
                }
                final long jCurrentTimeMillis = System.currentTimeMillis();
                com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.10
                    @Override // java.lang.Runnable
                    public void run() {
                        ka.d(zHi ? d.this.re : d.this.b, jCurrentTimeMillis);
                        msVar.ms(xVar);
                        if (d.this.le.get()) {
                            msVar.ms(d.this.t);
                        }
                    }
                });
                return;
            }
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "缓存广告: 素材加载成功，需要等待实时广告");
            this.qv = xVar;
            this.y = xrVar;
            this.op.set(true);
            if (this.ul.get()) {
                ka();
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.c ms(final com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar, final ms msVar, final com.bytedance.sdk.openadsdk.ao.xr.xr.xr xrVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.xr xrVar2, final long j) {
        return new com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.c(xrVar2, new com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah<com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.11
            private com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x c;

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public void ah(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar) {
                this.c = xVar;
                d.this.ms(xVar, cVar, msVar, xrVar, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah
            public void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar) {
                com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar2 = this.c;
                if (xVar2 != null) {
                    xVar2.ka(true);
                }
                d.this.ms(xVar, cVar, msVar, xrVar, j, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ah
            public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar) {
                d.this.ms(cVar, abVar, msVar, j);
            }
        });
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ms ms(final com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar, final ms msVar) {
        return new com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ms(new com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ah(this.ka, "splash_ad", cVar, xVar, this.xr), new com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d<ny, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.2
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public void xr(ny nyVar) {
                d.this.ka(cVar.ka());
                if (!d.this.ah(nyVar.ah())) {
                    d.this.le.set(true);
                    d.this.t = nyVar;
                    if (d.this.p.get() == 2) {
                        if (d.this.sl()) {
                            if (d.this.f.get()) {
                                return;
                            }
                            msVar.ms(nyVar);
                            return;
                        }
                        msVar.ms(nyVar);
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "缓存渲染成功 需要等待实时广告: ");
                if (d.this.jw.get() && !d.this.pc.get()) {
                    com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "已经超时走缓存广告");
                    d.this.pc.set(true);
                    msVar.ms(nyVar);
                }
                d.this.cv.set(true);
                d.this.nw = nyVar;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d
            public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar) {
                if (!d.this.ah(abVar.x())) {
                    d.this.le.set(false);
                    msVar.ah(abVar);
                } else {
                    d.this.cv.set(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d
            public void ms() {
                d.this.xr(cVar);
            }
        }, this.ny);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xr(lm lmVar, boolean z) {
        if (lmVar == null) {
            return false;
        }
        if (sl() && z && zb()) {
            return false;
        }
        if ((com.bytedance.sdk.openadsdk.core.ah.ka.ms().zb() & 1) == 1) {
            return true;
        }
        return c.xr(lmVar) && xr(lmVar) && lmVar.o() == 1;
    }

    private boolean xr(lm lmVar) {
        return lmVar != null && lmVar.fm() == 2;
    }

    private com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ms xr(final com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar, final ms msVar) {
        if (cVar == null || xVar == null || msVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ms(new com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ah(this.ka, "splash_ad", cVar, xVar, this.xr), new com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d<ny, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.d.3
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public void xr(ny nyVar) {
                d.this.ka(cVar.ka());
                if (d.this.f.get()) {
                    if (cVar.ka()) {
                        msVar.ms(nyVar);
                    }
                } else {
                    if (cVar.ka()) {
                        return;
                    }
                    msVar.ms(nyVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d
            public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar) {
                msVar.ah(abVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.d
            public void ms() {
                d.this.xr(cVar);
            }
        }, this.ny);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ms msVar, boolean z) {
        if (msVar == null) {
            return;
        }
        int iAh = ah(ms(cVar.ka()));
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "渲染 timeout " + iAh);
        if (this.yu.get()) {
            return;
        }
        if (ms(cVar.xr(), z) && this.c != null && iAh <= 0) {
            iAh = 0;
        }
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "开始渲染 isCache " + cVar.ka());
        ms(msVar, cVar.ka(), iAh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(ny nyVar) {
        if (nyVar == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zAh = nyVar.ah();
        if (zAh) {
            ka.ms(ms(zAh), this.w, nyVar);
            this.w.d(jCurrentTimeMillis - this.hi);
            this.w.d(this.f2383ms);
            this.w.ms(zAh);
            ka.ms(ms(zAh), this.w);
            ka.xr(ms(zAh), this.w);
        } else {
            ka.ms(ms(zAh), this.i, nyVar);
            this.i.d(jCurrentTimeMillis - this.hi);
            this.i.d(this.f2383ms);
            this.i.ms(zAh);
            ka.ms(ms(zAh), this.i);
            ka.xr(ms(zAh), this.i);
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "开屏广告渲染--end, 耗时S3： " + (jCurrentTimeMillis - this.u));
        }
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "渲染成功回调 开屏广告类型： ".concat(zAh ? "缓存" : "实时"));
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "加载开屏广告--end，总耗时： " + (jCurrentTimeMillis - this.hi));
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "加载开屏广告--end，getReqId： " + ms(zAh).eu());
    }

    private int ah(lm lmVar) {
        return Math.max(com.bytedance.sdk.openadsdk.core.ah.ka.ms().u(), (this.x - ((int) (System.currentTimeMillis() - this.hi))) - (lmVar != null ? lmVar.nk() : 100));
    }

    private e xr(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        e eVar = new e();
        eVar.ab = jCurrentTimeMillis;
        eVar.zb = ch.ub().ti();
        Object obj = this.d;
        if (obj != null && (obj instanceof com.bytedance.sdk.openadsdk.core.ms.xr)) {
            eVar.x = ((com.bytedance.sdk.openadsdk.core.ms.xr) obj).ms();
        }
        return eVar;
    }

    private void ms(String str, int i, int i2) {
        int iUb = re.xr().ub(str);
        if (iUb == 1) {
            this.x = i > 0 ? Math.min(i, i2) : Math.max(i2, 500);
        } else if (iUb == 2) {
            this.x = i > 0 ? i : Math.max(i2, 500);
        } else {
            this.x = i > 0 ? Math.max(i, i2) : Math.max(i2, 500);
        }
        int iCurrentTimeMillis = (int) (((long) this.x) - (System.currentTimeMillis() - this.ah.x));
        if (iCurrentTimeMillis <= 0) {
            iCurrentTimeMillis = this.x;
        }
        this.x = iCurrentTimeMillis;
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "splashTimeOutControlType = " + iUb + "; devTimeOut = " + i2 + "; cloudTimeOut = " + i + "; realTimeOut = " + this.x);
        this.c.sendEmptyMessageDelayed(2, this.x);
        ms(this.x);
    }

    private void ms(int i) {
        int iCh = re.xr().ch(this.ab);
        if (iCh >= i || iCh <= 0 || !sl() || this.c == null) {
            return;
        }
        int i2 = i - iCh;
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "buffer time: " + iCh + "  减去buffer time后超时时间：" + i2);
        this.c.sendEmptyMessageDelayed(4, i2);
    }

    private void hi() {
        this.b = new qk();
        qk qkVar = new qk();
        this.re = qkVar;
        ka.ms(this.b, qkVar);
        this.i = new com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.d();
        this.w = new com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.d();
    }

    private void d(boolean z) {
        if (z) {
            this.ub = System.currentTimeMillis();
        } else {
            this.u = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka(boolean z) {
        if (z) {
            this.w.ah(System.currentTimeMillis() - this.ub);
        } else {
            this.i.ah(System.currentTimeMillis() - this.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sl() {
        return this.f2383ms == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar, ms msVar, com.bytedance.sdk.openadsdk.ao.xr.xr.xr xrVar, boolean z) {
        if (this.yu.get()) {
            return;
        }
        xr(xVar, System.currentTimeMillis());
        if (xVar.hi()) {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "缓存广告： 素材首包回调");
            this.of.set(true);
        } else {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "实时广告： 素材首包回调");
            this.g.set(true);
        }
        ka.ms(xVar.hi() ? this.re : this.b, 3);
        c(xVar.hi());
        if (z) {
            ms(xVar, cVar, msVar);
        } else {
            ms(xVar, cVar, msVar, xrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.x xVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar, ms msVar, com.bytedance.sdk.openadsdk.ao.xr.xr.xr xrVar, long j, boolean z) {
        if (xVar == null) {
            return;
        }
        ms(cVar, cVar.ka(), false);
        if (this.yu.get()) {
            return;
        }
        if (xrVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.d.ms) {
            ((com.bytedance.sdk.openadsdk.core.component.splash.d.ms) xrVar).ms(xVar, false);
        }
        ms(xVar, j);
        if (xVar.hi() && this.of.get()) {
            return;
        }
        if (xVar.hi() || !this.g.get()) {
            if (ms(xVar.xr(), xVar.ka()) || ms(cVar.xr())) {
                ka.ms(xVar.hi() ? this.re : this.b, 2);
                c(xVar.hi());
            }
            if (z) {
                ms(xVar, cVar, msVar);
            } else {
                ms(xVar, cVar, msVar, xrVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar, com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ab abVar, ms msVar, long j) {
        if (abVar == null) {
            return;
        }
        boolean zX = abVar.x();
        if (!ah(zX)) {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "实时cac广告: 素材加载失败，直接给回调");
            msVar.xr(abVar);
        } else {
            com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", "缓存广告: 素材加载失败");
            this.op.set(false);
            if (this.ul.get()) {
                msVar.xr(abVar);
            }
        }
        ms(cVar, zX, false);
        int i = abVar.c() ? -14 : -7;
        if (!abVar.c()) {
            c.ms(j, false, false, ms(abVar.x()), i, abVar.ka());
        }
        com.bytedance.sdk.openadsdk.core.ab.ms.ms("Splash_FullLink", (zX ? "缓存广告" : "实时广告") + "加载素材失败 " + abVar.d());
    }

    private void c(boolean z) {
        if (this.c != null) {
            if (sl()) {
                if (z) {
                    return;
                } else {
                    this.c.removeMessages(4);
                }
            }
            this.c.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar) {
        if (cVar != null && cVar.ka()) {
            return;
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.c cVar, boolean z, boolean z2) {
        if (z) {
            return;
        }
        try {
            if (this.p.get() > 0 && !this.f.get()) {
                com.bytedance.sdk.openadsdk.core.ab.ms.ms("lqmt", "该实时广告已回调媒体");
            } else {
                if (com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka.ms(this.xr, this.ah)) {
                    return;
                }
                if (this.p.get() > 0 || this.ch.ah()) {
                    this.ny.ms(cVar, this.xr, z2, this.f2383ms);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void ms(boolean z, int i) {
        (z ? this.w : this.i).ka(i);
    }

    public static boolean ms() {
        return (com.bytedance.sdk.openadsdk.core.ah.ka.ms().sl() & 256) == 256;
    }

    public static boolean ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        return com.bytedance.sdk.openadsdk.core.component.splash.ah.ah.ka.ms(xrVar, new e()) && (com.bytedance.sdk.openadsdk.core.ah.ka.ms().sl() & 4) == 4;
    }

    private boolean zb() {
        return (com.bytedance.sdk.openadsdk.core.ah.ka.ms().hi() & 4) == 4;
    }
}
