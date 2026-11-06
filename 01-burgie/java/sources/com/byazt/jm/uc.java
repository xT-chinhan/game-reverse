package com.byazt.jm;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.ca.iu;
import com.byazt.hg.i;
import com.byazt.hg.ie;
import com.byazt.hg.jw;
import com.byazt.hg.of;
import com.byazt.hg.sv;
import com.byazt.sd.a;
import com.byazt.sd.gz;
import com.byazt.sd.lb;
import com.byazt.vkw.qi;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 5})
public class uc extends com.byazt.pv.fw implements qi.pr {
    public static boolean hn = true;
    public com.byazt.zn.uc a;
    public Context aj;
    public jw b;
    public com.byazt.qe.hw c;
    public com.byazt.zn.uc cz;
    public com.byazt.mr.hw fo;
    public String fw;
    public pr g;
    public com.byazt.zn.x gz;
    public long ho;
    public com.byazt.vx.c i;
    public jw iu;
    public int k;
    public long lb;
    public com.byazt.ks.pr m;
    public long nt;
    public com.byazt.zn.zo ny;
    public long qa;
    public com.byazt.zn.fw r;
    public com.byazt.zn.aj rc;
    public i uc;
    public com.byazt.zn.x ve;
    public final iu vk;
    public int w;
    public long yb;
    public com.byazt.zn.aj z;
    public int x = 2;
    public com.byazt.pis.pr zo = null;
    public final AtomicBoolean nl = new AtomicBoolean(false);
    public final AtomicBoolean y = new AtomicBoolean(false);
    public final AtomicBoolean ww = new AtomicBoolean(false);
    public final AtomicBoolean n = new AtomicBoolean(false);
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final AtomicBoolean s = new AtomicBoolean(false);
    public final AtomicInteger ls = new AtomicInteger(0);
    public final AtomicBoolean er = new AtomicBoolean(false);
    public final AtomicBoolean v = new AtomicBoolean(false);
    public final AtomicBoolean qi = new AtomicBoolean(false);
    public final AtomicBoolean qn = new AtomicBoolean(false);
    public final AtomicInteger of = new AtomicInteger(0);
    public boolean ii = false;
    public final hw hs = new hw();

    private uc(Context context) {
        if (context != null) {
            this.aj = context.getApplicationContext();
        } else {
            this.aj = a.getContext();
        }
        this.vk = new iu(Looper.getMainLooper(), this);
        this.g = new pr();
        com.byazt.sd.zo.nt().zo(false);
        m();
    }

    public static uc pr(Context context) {
        return new uc(context);
    }

    private void hw(com.byazt.qe.hw hwVar) {
        this.hw = UUID.randomUUID().toString();
        this.pr = (com.byazt.dc.hw) com.byazt.ewt.c.pr(0);
        this.pr.hw(this.hw, hwVar.gz());
        this.pr.pr(this.hw, new com.byazt.tb.hn());
        if (com.byazt.cf.uc.pr().pr(3)) {
            this.pr.pr(this.hw, new com.byazt.cf.hn());
        }
    }

    public void pr(final com.byazt.qe.hw hwVar, final com.byazt.pis.pr prVar, final int i) {
        if (hwVar != null && !TextUtils.isEmpty(hwVar.cz())) {
            this.pr = (com.byazt.dc.hw) com.byazt.ewt.c.pr(0);
        } else {
            hw(hwVar);
        }
        String string = UUID.randomUUID().toString();
        this.fw = string;
        com.byazt.ua.hw.pr(hwVar, true, string);
        this.pr.pr(this.hw, new com.byazt.ewt.x.pr() { // from class: com.byazt.jm.uc.1
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar2) {
                com.byazt.qe.hw hwVar3;
                if ((hwVar2 instanceof com.byazt.pv.hw) && (hwVar3 = hwVar) != null) {
                    com.byazt.pv.hw hwVar4 = (com.byazt.pv.hw) hwVar2;
                    hwVar4.pr = hwVar3;
                    hwVar4.g = hwVar.x();
                    hwVar4.k = 3;
                    hwVar4.m = 0;
                }
            }
        });
        pr();
        if (!com.byazt.is.aj.pr()) {
            com.byazt.xn.hn hnVar = new com.byazt.xn.hn(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            pr((String) null, false, hnVar);
            prVar.pr(hnVar);
            return;
        }
        int iZo = a.hw().zo(ls.hw(hwVar));
        com.byazt.xlm.fw fwVar = new com.byazt.xlm.fw("loadSplashAd b") { // from class: com.byazt.jm.uc.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.byazt.sd.zo.nt().fw(1);
                    uc.this.zo = prVar;
                    uc.this.pr(hwVar, i);
                } catch (Throwable th) {
                    com.byazt.xn.hn hnVar2 = new com.byazt.xn.hn(TTAdConstant.INIT_LOCAL_FAIL_CODE, " msg = " + th.getMessage());
                    uc.this.pr((String) null, false, hnVar2);
                    prVar.pr(hnVar2);
                    ho.pr("SplashLoadManager", "splash component maybe not exist, pls check1", th);
                }
            }
        };
        if (!lb.pr) {
            ho.hw("SplashLoadManager", gz.NOT_INIT_TIPS_MSG);
            com.byazt.xn.hn hnVar2 = new com.byazt.xn.hn(10000, gz.NOT_INIT_TIPS_MSG);
            pr((String) null, false, hnVar2);
            prVar.pr(hnVar2);
            return;
        }
        if (com.byazt.b.pr.hw() && (iZo == 4 || pr(hwVar))) {
            fwVar.run();
        } else if (gz.pr()) {
            com.byazt.xlm.c.x(fwVar);
        } else {
            com.byazt.xlm.aj.hw.k().execute(fwVar);
        }
        com.byazt.ip.pr.c().pr(3, hwVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.qe.hw hwVar, int i) {
        if (hwVar == null) {
            return;
        }
        com.byazt.nz.pr.pr("Splash_FullLink", "加载开屏广告--begin ");
        this.ho = System.currentTimeMillis();
        i iVarHn = hn(hwVar);
        this.uc = iVarHn;
        iVarHn.qa = this.fw;
        this.c = hwVar;
        this.w = ls.hw(hwVar);
        this.m = com.byazt.ks.pr.pr();
        int iPr = this.hs.pr(this.c, this.w);
        this.x = iPr;
        com.byazt.nz.pr.pr("Splash_FullLink", "当前rit位 " + this.w);
        int iUc = a.hw().uc(hwVar.x());
        pr(hwVar.x(), iUc, i);
        long j = i;
        this.uc.vk = j;
        this.uc.w = iUc;
        this.uc.k = this.k;
        fw.pr(hwVar, j);
        x();
        hw();
        pr(hwVar, this.uc, iPr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.qe.hw hwVar, i iVar, int i) {
        fw.pr(this.b, this.iu, iVar, this.x, i);
        pr(hwVar, iVar, this.g);
    }

    private void pr(final com.byazt.qe.hw hwVar, i iVar, final pr prVar) {
        if (prVar == null) {
            return;
        }
        com.byazt.ks.c cVar = new com.byazt.ks.c();
        cVar.pr = this.hs.hw;
        com.byazt.vx.c cVar2 = new com.byazt.vx.c(new com.byazt.zn.c(hwVar, iVar, cVar), new com.byazt.vx.hw<com.byazt.zn.uc, com.byazt.zn.fw>() { // from class: com.byazt.jm.uc.10
            @Override // com.byazt.vx.hw
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public void hw(com.byazt.zn.uc ucVar) {
                com.byazt.qe.hw hwVar2;
                if (TextUtils.isEmpty(uc.this.hw) && (hwVar2 = hwVar) != null && !TextUtils.isEmpty(hwVar2.cz()) && ucVar != null && ucVar.hw() != null && uc.this.pr != null) {
                    uc ucVar2 = uc.this;
                    ucVar2.hw = ucVar2.pr.hw(ucVar.hw().ny());
                }
                if (ucVar == null || ucVar.hw() == null) {
                    prVar.pr(new com.byazt.zn.fw(1, "no ad model", false));
                    return;
                }
                of ofVarHw = ucVar.hw();
                if (ucVar.c()) {
                    uc.this.of.set(1);
                    uc.this.cz = ucVar;
                    if (!uc.this.g()) {
                        uc.this.ii = true;
                    }
                } else {
                    uc.this.a = ucVar;
                    uc.this.ii = false;
                }
                if (uc.this.nl.get() || uc.this.g.hn() || uc.this.ls.get() > 0) {
                    uc.this.pr(ucVar, ucVar.c(), true);
                    return;
                }
                uc.this.pr(ucVar);
                if (uc.this.hw(ofVarHw, ucVar.c())) {
                    com.byazt.nz.pr.pr("Splash_FullLink", "开始并发加载素材 ");
                    uc.this.hw(ucVar, prVar);
                } else {
                    com.byazt.nz.pr.pr("Splash_FullLink", "开始串行加载素材 getReqId " + ucVar.hw().ny());
                    uc.this.pr(ucVar, prVar);
                }
            }

            @Override // com.byazt.vx.hw
            public void pr(com.byazt.zn.fw fwVar) {
                if (uc.this.x == 1 && uc.this.hs.hn == 2) {
                    uc.this.x = 2;
                    uc ucVar = uc.this;
                    ucVar.pr(hwVar, ucVar.uc, uc.this.x);
                    return;
                }
                boolean zZo = fwVar.zo();
                if (zZo) {
                    uc.this.of.set(-1);
                }
                if (!uc.this.x(zZo)) {
                    uc.this.r = fwVar;
                    if (uc.this.g()) {
                        if (uc.this.of.get() != -1) {
                            if (uc.this.of.get() == 1) {
                                uc.this.fw();
                            }
                        } else {
                            prVar.pr(fwVar);
                        }
                        uc.this.qn.set(true);
                        return;
                    }
                    prVar.pr(fwVar);
                    return;
                }
                if (uc.this.qn.get()) {
                    prVar.pr(uc.this.r);
                }
            }
        }, this.m, this.hs);
        this.i = cVar2;
        cVar2.pr(this.x);
    }

    private void x() {
        this.nl.set(false);
        this.y.set(false);
        this.ww.set(false);
        this.n.set(false);
        this.er.set(false);
        this.v.set(false);
        this.e.set(false);
        this.s.set(false);
        this.qi.set(false);
        this.qn.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i;
        if (com.byazt.ks.pr.pr(this.x) && ((i = this.x) == 1 || i == 3)) {
            return;
        }
        uc();
    }

    private void uc() {
        com.byazt.ks.pr prVar = this.m;
        if (prVar != null) {
            prVar.hw(this.c, this.uc);
        }
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        if (message.what == 2) {
            pr prVar = this.g;
            if (prVar != null) {
                prVar.pr();
            }
            iu iuVar = this.vk;
            if (iuVar != null) {
                iuVar.removeMessages(2);
            }
        }
        if (message.what == 4) {
            zo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw() {
        int iOptInt;
        com.byazt.zn.uc ucVar = this.cz;
        if (ucVar != null && ucVar.hw() != null && this.cz.hw().xn() != null && (iOptInt = this.cz.hw().xn().optInt("real_drop_cache_type", 0)) == 1) {
            com.byazt.nz.pr.pr("SplashLoadManager", "loadCacheWhenRealAdDrop - 缓存兜底返回配置 realDropCacheType： " + iOptInt);
            zo();
        } else if (this.hs.pr()) {
            com.byazt.nz.pr.pr("SplashLoadManager", "loadCacheWhenRealAdDrop - 计分模式下允许兜底缓存： ");
            zo();
        } else {
            pr prVar = this.g;
            if (prVar != null) {
                prVar.pr(this.r);
            }
        }
    }

    private void zo() {
        iu iuVar = this.vk;
        if (iuVar != null) {
            iuVar.removeMessages(4);
        }
        pr prVar = this.g;
        if (prVar != null) {
            prVar.hw();
        }
    }

    private boolean pr(of ofVar, boolean z) {
        return (ofVar == null || z || ofVar.oj() != 3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pr(of ofVar) {
        return (ofVar != null ? ofVar.oj() : 0) == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public of hw(boolean z) {
        if (z) {
            com.byazt.zn.uc ucVar = this.cz;
            if (ucVar == null) {
                return null;
            }
            return ucVar.hw();
        }
        com.byazt.zn.uc ucVar2 = this.a;
        if (ucVar2 == null) {
            return null;
        }
        return ucVar2.hw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        com.byazt.nz.pr.pr("Splash_FullLink", "startCallBackWhenBufferTimeout ");
        this.g.pr(this.ny);
        this.v.set(true);
        if (!this.n.get() || this.er.get()) {
            return;
        }
        this.er.set(true);
        com.byazt.nz.pr.pr("Splash_FullLink", "素材加载和渲染并发 buffer_time超时 缓存素材加载成功，渲染成功开始给 onRenderSplashSuccess回调");
        this.g.pr(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vk() {
        if (this.g == null) {
            return;
        }
        if (hw(hw(true), true)) {
            AtomicBoolean atomicBoolean = this.y;
            if (atomicBoolean != null && atomicBoolean.get()) {
                w();
                com.byazt.nz.pr.pr("Splash_FullLink", "buffer_time超时-并发 缓存素材加载成功，开始给加载成功回调");
                com.byazt.zn.zo zoVar = this.ny;
                if (zoVar != null) {
                    zoVar.pr(this.fo);
                }
                c.hw(new Runnable() { // from class: com.byazt.jm.uc.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final long jCurrentTimeMillis = System.currentTimeMillis();
                        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.jm.uc.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                fw.x(uc.this.iu, jCurrentTimeMillis);
                                uc.this.aj();
                            }
                        });
                    }
                });
                return;
            }
            return;
        }
        AtomicBoolean atomicBoolean2 = this.y;
        if (atomicBoolean2 != null && atomicBoolean2.get()) {
            com.byazt.nz.pr.pr("Splash_FullLink", "buffer_time超时-串行 缓存素材加载成功，开始给加载成功回调以及开始渲染");
            w();
            com.byazt.vx.pr prVarHw = hw(this.cz, this.ny, this.g);
            com.byazt.zn.zo zoVar2 = this.ny;
            if (zoVar2 != null) {
                zoVar2.pr(prVarHw.pr());
            }
            c.hw(new Runnable() { // from class: com.byazt.jm.uc.12
                @Override // java.lang.Runnable
                public void run() {
                    final long jCurrentTimeMillis = System.currentTimeMillis();
                    com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.jm.uc.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fw.x(uc.this.iu, jCurrentTimeMillis);
                            uc.this.g.pr(uc.this.ny);
                        }
                    });
                }
            });
            pr(this.cz, prVarHw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        iu iuVar = this.vk;
        if (iuVar != null) {
            iuVar.removeMessages(4);
        }
        iu iuVar2 = this.vk;
        if (iuVar2 != null) {
            iuVar2.removeMessages(2);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 129})
    class pr {
        public final AtomicBoolean hw = new AtomicBoolean(false);

        public pr() {
        }

        private void x(final com.byazt.zn.fw fwVar) {
            if (fwVar == null) {
                return;
            }
            com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.jm.uc.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    if (uc.this.zo != null) {
                        uc.this.zo.pr(fwVar.aj(), new com.byazt.xn.hn(fwVar.x(), fwVar.c()));
                        com.byazt.nz.pr.pr("Splash_FullLink", "onSplashRenderFail回调 true " + fwVar.x());
                    }
                }
            });
            uc.this.c();
        }

        public void pr(final com.byazt.zn.fw fwVar) {
            if (fwVar != null) {
                uc.this.w();
                if (this.hw.get() || uc.this.ls.get() > 0) {
                    return;
                }
                this.hw.set(true);
                uc.this.pr(false);
                com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.jm.uc.pr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uc.this.zo != null) {
                            if (fwVar.x() == 22) {
                                fwVar.hw(1);
                            }
                            com.byazt.xn.hn hnVar = new com.byazt.xn.hn(fwVar.x(), fwVar.c());
                            uc.this.pr((String) null, false, hnVar);
                            uc.this.zo.pr(hnVar);
                            com.byazt.nz.pr.pr("Splash_FullLink", "onSplashLoadFail 回调");
                        }
                    }
                });
                pr(false, true, (Object) null);
                uc.this.c();
                com.byazt.nz.pr.pr("Splash_FullLink", "onLoadSplashAdFail回调 广告获取失败");
                fw.pr(fwVar.zo(), uc.this.hw(fwVar.zo()), uc.this.c, fwVar);
            }
        }

        public void pr(com.byazt.zn.zo zoVar) {
            if (!this.hw.get()) {
                if (uc.this.ls.get() == 0) {
                    uc.this.pr(true);
                }
                if (zoVar != null) {
                    jw jwVar = zoVar.w() ? uc.this.iu : uc.this.b;
                    if (jwVar != null) {
                        jwVar.uc(zoVar.pr());
                        jwVar.lb(zoVar.g());
                        jwVar.cz(System.currentTimeMillis() - jwVar.rc());
                    }
                    pr(uc.this.zo, jwVar, zoVar.hw(), zoVar.k(), zoVar.w(), zoVar.ho());
                }
            }
        }

        private void pr(com.byazt.pis.pr prVar, jw jwVar, of ofVar, com.byazt.mr.hw hwVar, boolean z, boolean z2) {
            if (prVar != null && jwVar != null && uc.this.ls.get() <= 0) {
                if (uc.this.pr(ofVar)) {
                    uc ucVar = uc.this;
                    fw.pr(z ? ucVar.iu : ucVar.b, 2);
                    uc.this.w();
                }
                uc.this.qi.set(z);
                uc.this.ls.set(1);
                long jCurrentTimeMillis = System.currentTimeMillis();
                pr(hwVar, 1);
                uc.this.pr(hwVar.fo(), true, (com.byazt.xn.hn) null);
                prVar.pr(hwVar);
                if (!TextUtils.isEmpty(uc.this.fw) && ofVar != null) {
                    ofVar.pr(uc.this.fw);
                    com.byazt.ua.hw.pr(ofVar, "splash_ad");
                }
                uc.this.ls.set(2);
                com.byazt.nz.pr.pr("Splash_FullLink", "onSplashLoadSuccess() 媒体处理完成");
                pr(z, false, (Object) hwVar);
                jwVar.yb(System.currentTimeMillis() - jCurrentTimeMillis);
                if (z2) {
                    fw.pr(uc.this.aj, jwVar, ofVar, z, jCurrentTimeMillis);
                }
            }
        }

        public void hw(final com.byazt.zn.fw fwVar) {
            if (fwVar != null) {
                uc.this.w();
                if (this.hw.get()) {
                    return;
                }
                this.hw.set(true);
                uc.this.pr(false);
                com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.jm.uc.pr.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (uc.this.zo != null) {
                            if (uc.this.ls.get() > 0) {
                                uc.this.zo.pr(null, new com.byazt.xn.hn(1, "load splash material fail"));
                                return;
                            }
                            com.byazt.xn.hn hnVar = new com.byazt.xn.hn(fwVar.x(), fwVar.c());
                            uc.this.pr((String) null, false, hnVar);
                            uc.this.zo.pr(hnVar);
                        }
                    }
                });
                uc.this.c();
                com.byazt.nz.pr.hn("Splash_FullLink", "onSplashLoadFail 素材加载加载失败 code: " + fwVar.x());
                fw.pr(fwVar.zo(), uc.this.hw(fwVar.zo()), uc.this.c, fwVar);
            }
        }

        public void pr(final com.byazt.zn.aj ajVar) {
            uc.this.w();
            if (this.hw.get()) {
                return;
            }
            this.hw.set(true);
            boolean z = ajVar != null && ajVar.hn();
            uc.this.pr(ajVar);
            uc ucVar = uc.this;
            ucVar.pr(z, z ? ucVar.iu : ucVar.b);
            com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.jm.uc.pr.4
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.zn.aj ajVar2;
                    if (uc.this.zo != null && (ajVar2 = ajVar) != null) {
                        pr.this.pr(ajVar2.pr(), 2);
                        uc.this.zo.hw(ajVar.pr());
                    }
                }
            });
        }

        public void hn(com.byazt.zn.fw fwVar) {
            uc.this.w();
            if (this.hw.get()) {
                return;
            }
            this.hw.set(true);
            fw.pr(fwVar.zo(), uc.this.hw(fwVar.zo()), uc.this.c, fwVar);
            x(fwVar);
            ho.hw("SplashLoadManager", "渲染失败 code " + fwVar.x() + " msg " + fwVar.c());
        }

        public void pr() {
            com.byazt.nz.pr.pr("Splash_FullLink", "onTimeOut start");
            uc.this.nl.set(true);
            if (this.hw.get()) {
                return;
            }
            this.hw.set(true);
            if (uc.this.ls.get() == 0) {
                uc.this.pr(false);
            }
            if (uc.this.i != null) {
                uc.this.i.pr();
            }
            com.byazt.nz.pr.pr("Splash_FullLink", "开屏超时");
            if (uc.this.zo != null) {
                if (uc.this.ls.get() > 0) {
                    uc.this.zo.pr(null, new com.byazt.xn.hn(3, "load success but render fail"));
                } else {
                    com.byazt.xn.hn hnVar = new com.byazt.xn.hn(23, "load splash time out");
                    uc.this.pr((String) null, false, hnVar);
                    uc.this.zo.pr(hnVar);
                }
                uc.this.c();
            }
            boolean z = uc.this.ii;
            uc ucVar = uc.this;
            fw.pr(z, ucVar.hw(ucVar.ii), uc.this.c, new com.byazt.zn.fw(23, "load splash time out", uc.this.ii));
            boolean z2 = uc.this.ii;
            uc ucVar2 = uc.this;
            fw.pr(z2, ucVar2.hw(ucVar2.ii), uc.this.c);
        }

        public void hw() {
            if (this.hw.get()) {
                return;
            }
            com.byazt.nz.pr.pr("Splash_FullLink", "触发 buffer_time超时 开始给加载成功回调以及开始渲染");
            uc.this.vk();
        }

        public boolean hn() {
            return this.hw.get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pr(com.byazt.mr.hw hwVar, int i) {
            if (hwVar instanceof com.byazt.rw.pr) {
                ((com.byazt.rw.pr) hwVar).pr(i);
            }
        }

        private void pr(boolean z, boolean z2, Object obj) {
            of ofVarHw = uc.this.hw(true);
            if (uc.this.m != null && ofVarHw != null) {
                String strNy = ofVarHw.ny();
                uc.this.m.pr(uc.this.c.x(), strNy, z, z2, obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final boolean z, final jw jwVar) {
        com.byazt.zp.zo.pr(new com.byazt.xlm.fw("preloadSplash") { // from class: com.byazt.jm.uc.13
            @Override // java.lang.Runnable
            public void run() {
                if (uc.this.hn(z)) {
                    uc.this.k();
                } else {
                    uc.this.c();
                }
                jw jwVar2 = jwVar;
                boolean z2 = jwVar2 != null && jwVar2.e();
                jw jwVar3 = jwVar;
                boolean z3 = jwVar3 != null && jwVar3.ww();
                boolean z4 = z;
                fw.pr(z4, uc.this.hw(z4), uc.this.c, z2, z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (com.byazt.vx.c.pr(this.c, this.uc)) {
            return;
        }
        this.m.pr(new sv(this.a.x(), this.a.hw(), null), this.c, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hn(boolean z) {
        com.byazt.zn.uc ucVar;
        if (z || this.m == null || (ucVar = this.a) == null || ucVar.x() == null || this.a.hw() == null || !com.byazt.py.c.pr(this.a.hw())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.zn.uc ucVar) {
        boolean zC = ucVar.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.ho;
        if (zC) {
            fw.pr(this.iu);
            this.gz.pr(ie.pr(hw(zC)));
            this.gz.hw(ie.hn(hw(zC)));
            this.gz.pr(j);
            this.yb = jCurrentTimeMillis;
            com.byazt.nz.pr.pr("Splash_FullLink", "缓存加载物料--end 耗时S1： " + j);
            return;
        }
        fw.pr(this.b);
        this.ve.pr(ie.pr(hw(zC)));
        this.ve.hw(ie.hn(hw(zC)));
        this.ve.pr(j);
        this.nt = jCurrentTimeMillis;
        fw.pr(this.b, ucVar);
        com.byazt.pk.uc.pr().hn().pr(this.b);
        com.byazt.nz.pr.pr("Splash_FullLink", "实时加载物料--end 耗时S1： " + j);
    }

    private void pr(final com.byazt.zn.zo zoVar, com.byazt.zn.uc ucVar, final pr prVar) {
        if (zoVar == null || this.ls.get() > 0) {
            return;
        }
        final boolean zW = zoVar.w();
        com.byazt.vx.pr prVarHw = hw(ucVar, zoVar, prVar);
        zoVar.pr(prVarHw.pr());
        if (!x(zoVar.w())) {
            com.byazt.nz.pr.pr("Splash_FullLink", "不需要等待实时广告 isCacheAd " + zW);
            if (hn()) {
                c.hw(new Runnable() { // from class: com.byazt.jm.uc.14
                    @Override // java.lang.Runnable
                    public void run() {
                        pr prVar2 = prVar;
                        if (prVar2 != null) {
                            prVar2.pr(zoVar);
                        }
                    }
                });
                pr(ucVar, prVarHw);
                return;
            } else {
                c.hw(new Runnable() { // from class: com.byazt.jm.uc.15
                    @Override // java.lang.Runnable
                    public void run() {
                        final long jCurrentTimeMillis = System.currentTimeMillis();
                        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.jm.uc.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                fw.x(zW ? uc.this.iu : uc.this.b, jCurrentTimeMillis);
                                prVar.pr(zoVar);
                            }
                        });
                    }
                });
                pr(ucVar, prVarHw);
                return;
            }
        }
        com.byazt.nz.pr.pr("Splash_FullLink", "缓存素材加载成功，等待实时广告 isCacheAd " + zW);
        this.ny = zoVar;
        this.fo = prVarHw.pr();
        this.y.set(true);
        if (this.qn.get()) {
            fw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final com.byazt.zn.uc ucVar, final pr prVar) {
        if (ucVar == null || prVar == null) {
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        fw.hn(ucVar.c() ? this.iu : this.b, System.currentTimeMillis());
        com.byazt.zn.hw hwVar = new com.byazt.zn.hw(ucVar.hw(), ucVar.c());
        hwVar.pr(ucVar.x());
        hwVar.pr(ucVar.c());
        hwVar.pr(ucVar.pr());
        hwVar.pr(ucVar.hn());
        new com.byazt.vx.uc(hwVar, new com.byazt.vx.hn<com.byazt.zn.zo, com.byazt.zn.fw>() { // from class: com.byazt.jm.uc.16
            public com.byazt.zn.zo c;

            @Override // com.byazt.vx.hn
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public void hn(com.byazt.zn.zo zoVar) {
                this.c = zoVar;
                uc.this.pr(zoVar, ucVar, prVar, (com.byazt.mr.hw) null, true);
            }

            @Override // com.byazt.vx.hn
            public void hw(com.byazt.zn.zo zoVar) {
                com.byazt.zn.zo zoVar2 = this.c;
                if (zoVar2 != null) {
                    zoVar2.c(true);
                }
                uc.this.pr(zoVar, ucVar, prVar, (com.byazt.mr.hw) null, jElapsedRealtime, true);
            }

            @Override // com.byazt.vx.hn
            public void pr(com.byazt.zn.fw fwVar) {
                uc.this.pr(ucVar, fwVar, prVar, jElapsedRealtime);
            }
        }).hw();
        pr(ucVar.c(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(boolean z) {
        return z && g();
    }

    private void pr(final com.byazt.vx.pr prVar, final boolean z, final int i) {
        c(z);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.jm.uc.2
            @Override // java.lang.Runnable
            public void run() {
                fw.x(z ? uc.this.iu : uc.this.b, jCurrentTimeMillis);
                if (prVar == null) {
                    return;
                }
                System.currentTimeMillis();
                prVar.pr(i);
                prVar.hw();
            }
        });
    }

    private void pr(com.byazt.zn.zo zoVar, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zW = zoVar.w();
        if (zW) {
            fw.pr(this.iu, zoVar);
            fw.pr(this.iu, zoVar, j, hw(zW));
            fw.pr(hw(zW), this.iu, zoVar);
            pr(zW, zoVar, jCurrentTimeMillis - this.yb);
            com.byazt.zn.zo zoVar2 = this.ny;
            if (zoVar2 != null) {
                zoVar2.c(true);
            }
        } else {
            fw.pr(this.b, zoVar);
            fw.pr(this.b, zoVar, j, hw(zW));
            fw.pr(hw(zW), this.b, zoVar);
            pr(zW, zoVar, jCurrentTimeMillis - this.nt);
        }
        hw(zoVar, jCurrentTimeMillis);
        if (this.ls.get() <= 0 || this.nl.get()) {
            return;
        }
        if (this.qi.get()) {
            if (zW) {
                fw.pr(this.aj, this.iu, zoVar.hw(), true, jCurrentTimeMillis);
            }
        } else if (!zW) {
            fw.pr(this.aj, this.b, zoVar.hw(), false, jCurrentTimeMillis);
        }
    }

    private void hw(com.byazt.zn.zo zoVar, long j) {
        if (zoVar.w()) {
            if (this.s.get()) {
                return;
            }
            this.gz.hw(j - this.yb);
            this.iu.hn(zoVar.uc());
            this.iu.hw(zoVar.c());
            return;
        }
        if (this.e.get()) {
            return;
        }
        this.ve.hw(j - this.nt);
        this.b.hn(zoVar.uc());
        this.b.hw(zoVar.c());
    }

    private void pr(boolean z, com.byazt.zn.zo zoVar, long j) {
        String str = z ? "缓存广告" : "实时广告";
        if (zoVar.c()) {
            if (zoVar.vk()) {
                com.byazt.nz.pr.pr("Splash_FullLink", str + "： 加载缓存视频素材--end, 耗时S2： " + j);
                return;
            } else {
                com.byazt.nz.pr.pr("Splash_FullLink", str + "： 加载网络视频素材--end, 耗时S2： " + j);
                return;
            }
        }
        if (zoVar.uc()) {
            com.byazt.nz.pr.pr("Splash_FullLink", str + "： 加载缓存图片素材--end, 耗时S2： " + j);
        } else {
            com.byazt.nz.pr.pr("Splash_FullLink", str + "： 加载网络图片素材--end, 耗时S2：" + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(com.byazt.zn.uc ucVar, pr prVar) {
        if (ucVar == null || prVar == null) {
            return;
        }
        of ofVarHw = ucVar.hw();
        boolean zC = ucVar.c();
        com.byazt.vx.pr prVarPr = pr(ucVar, new com.byazt.zn.zo(ofVarHw, zC), prVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.byazt.zn.hw hwVar = new com.byazt.zn.hw(ofVarHw, zC);
        hwVar.pr(zC);
        hwVar.pr(ucVar.x());
        hwVar.pr(ucVar.pr());
        hwVar.pr(ucVar.hn());
        com.byazt.vx.uc ucVarPr = pr(ucVar, prVar, prVarPr.pr(), hwVar, jElapsedRealtime);
        prVarPr.pr(ucVarPr);
        fw.hn(zC ? this.iu : this.b, System.currentTimeMillis());
        ucVarPr.hw();
        pr(zC, 1);
        pr(ucVar, prVarPr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final com.byazt.zn.zo zoVar, com.byazt.zn.uc ucVar, final pr prVar, com.byazt.mr.hw hwVar) {
        if (zoVar == null || this.ls.get() > 0) {
            return;
        }
        final boolean zW = zoVar.w();
        if (!x(zW)) {
            com.byazt.nz.pr.pr("Splash_FullLink", "实时素材加载成功，不需要等待实时广告, 此时渲染结果: " + this.ww.get());
            zoVar.pr(hwVar);
            if (hn()) {
                prVar.pr(zoVar);
                if (this.ww.get()) {
                    prVar.pr(this.rc);
                    return;
                }
                return;
            }
            final long jCurrentTimeMillis = System.currentTimeMillis();
            com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.jm.uc.3
                @Override // java.lang.Runnable
                public void run() {
                    fw.x(zW ? uc.this.iu : uc.this.b, jCurrentTimeMillis);
                    prVar.pr(zoVar);
                    if (uc.this.ww.get()) {
                        prVar.pr(uc.this.rc);
                    }
                }
            });
            return;
        }
        com.byazt.nz.pr.pr("Splash_FullLink", "缓存广告: 素材加载成功，需要等待实时广告");
        this.ny = zoVar;
        this.fo = hwVar;
        this.y.set(true);
        if (this.qn.get()) {
            fw();
        }
    }

    private com.byazt.vx.uc pr(final com.byazt.zn.uc ucVar, final pr prVar, final com.byazt.mr.hw hwVar, com.byazt.zn.hw hwVar2, final long j) {
        return new com.byazt.vx.uc(hwVar2, new com.byazt.vx.hn<com.byazt.zn.zo, com.byazt.zn.fw>() { // from class: com.byazt.jm.uc.4
            public com.byazt.zn.zo uc;

            @Override // com.byazt.vx.hn
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public void hn(com.byazt.zn.zo zoVar) {
                this.uc = zoVar;
                uc.this.pr(zoVar, ucVar, prVar, hwVar, false);
            }

            @Override // com.byazt.vx.hn
            public void hw(com.byazt.zn.zo zoVar) {
                com.byazt.zn.zo zoVar2 = this.uc;
                if (zoVar2 != null) {
                    zoVar2.c(true);
                }
                uc.this.pr(zoVar, ucVar, prVar, hwVar, j, false);
            }

            @Override // com.byazt.vx.hn
            public void pr(com.byazt.zn.fw fwVar) {
                uc.this.pr(ucVar, fwVar, prVar, j);
            }
        });
    }

    private com.byazt.vx.pr pr(final com.byazt.zn.uc ucVar, com.byazt.zn.zo zoVar, final pr prVar) {
        return new com.byazt.vx.pr(new com.byazt.zn.hn(this.aj, "splash_ad", ucVar, zoVar, this.c, false), new com.byazt.vx.x<com.byazt.zn.aj, com.byazt.zn.fw>() { // from class: com.byazt.jm.uc.5
            @Override // com.byazt.vx.x
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public void hw(com.byazt.zn.aj ajVar) {
                uc.this.uc(ucVar.c());
                if (!uc.this.x(ajVar.hn())) {
                    com.byazt.nz.pr.pr("Splash_FullLink", "createCSJSplashRenderParallel- 实时广告onSuccess");
                    uc.this.ww.set(true);
                    uc.this.rc = ajVar;
                    if (uc.this.ls.get() == 2) {
                        if (uc.this.g()) {
                            if (!uc.this.qi.get()) {
                                prVar.pr(ajVar);
                                return;
                            }
                            return;
                        }
                        prVar.pr(ajVar);
                        return;
                    }
                    return;
                }
                com.byazt.nz.pr.pr("Splash_FullLink", "缓存渲染成功 需要等待实时广告: ");
                if (uc.this.v.get() && !uc.this.er.get()) {
                    com.byazt.nz.pr.pr("Splash_FullLink", "已经超时走缓存广告");
                    uc.this.er.set(true);
                    prVar.pr(ajVar);
                }
                uc.this.n.set(true);
                uc.this.z = ajVar;
            }

            @Override // com.byazt.vx.x
            public void pr(com.byazt.zn.fw fwVar) {
                if (!uc.this.x(fwVar.zo())) {
                    uc.this.ww.set(false);
                    prVar.hn(fwVar);
                } else {
                    uc.this.n.set(false);
                }
            }

            @Override // com.byazt.vx.x
            public void pr() {
                uc.this.hw(ucVar);
            }
        }, this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hw(of ofVar, boolean z) {
        if (ofVar == null) {
            return false;
        }
        if (g() && z && ho()) {
            return false;
        }
        if ((com.byazt.mp.c.pr().m() & 1) == 1) {
            return true;
        }
        return zo.hw(ofVar) && hw(ofVar) && ofVar.su() == 1;
    }

    private boolean hw(of ofVar) {
        return ofVar != null && ie.pr(ofVar) == 2;
    }

    private com.byazt.vx.pr hw(final com.byazt.zn.uc ucVar, com.byazt.zn.zo zoVar, final pr prVar) {
        if (ucVar == null || zoVar == null || prVar == null) {
            return null;
        }
        return new com.byazt.vx.pr(new com.byazt.zn.hn(this.aj, "splash_ad", ucVar, zoVar, this.c, true), new com.byazt.vx.x<com.byazt.zn.aj, com.byazt.zn.fw>() { // from class: com.byazt.jm.uc.6
            @Override // com.byazt.vx.x
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public void hw(com.byazt.zn.aj ajVar) {
                uc.this.uc(ucVar.c());
                if (uc.this.qi.get()) {
                    if (ucVar.c()) {
                        prVar.pr(ajVar);
                    }
                } else if (!ucVar.c()) {
                    prVar.pr(ajVar);
                }
            }

            @Override // com.byazt.vx.x
            public void pr(com.byazt.zn.fw fwVar) {
                prVar.hn(fwVar);
            }

            @Override // com.byazt.vx.x
            public void pr() {
                uc.this.hw(ucVar);
            }
        }, this.m);
    }

    private void pr(com.byazt.zn.uc ucVar, com.byazt.vx.pr prVar) {
        if (prVar == null || this.nl.get()) {
            return;
        }
        int iHn = hn(hw(ucVar.c()));
        com.byazt.nz.pr.pr("Splash_FullLink", "开始渲染 isCache " + ucVar.c() + ", 渲染超时设置：" + iHn);
        pr(prVar, ucVar.c(), iHn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.zn.aj ajVar) {
        if (ajVar == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zHn = ajVar.hn();
        if (zHn) {
            fw.pr(hw(zHn), this.gz, ajVar);
            this.gz.x(jCurrentTimeMillis - this.ho);
            this.gz.x(this.x);
            this.gz.pr(zHn);
            fw.pr(hw(zHn), this.gz);
            fw.hw(hw(zHn), this.gz);
        } else {
            fw.pr(hw(zHn), this.ve, ajVar);
            this.ve.x(jCurrentTimeMillis - this.ho);
            this.ve.x(this.x);
            this.ve.pr(zHn);
            fw.pr(hw(zHn), this.ve);
            fw.hw(hw(zHn), this.ve);
            com.byazt.nz.pr.pr("Splash_FullLink", "开屏广告渲染--end, 耗时S3： " + (jCurrentTimeMillis - this.lb));
        }
        com.byazt.nz.pr.pr("Splash_FullLink", "渲染成功回调 开屏广告类型： " + (zHn ? "缓存" : "实时"));
        com.byazt.nz.pr.pr("Splash_FullLink", "加载开屏广告--end，总耗时： " + (jCurrentTimeMillis - this.ho));
        com.byazt.nz.pr.pr("Splash_FullLink", "加载开屏广告--end，getReqId： " + hw(zHn).ny());
    }

    private int hn(of ofVar) {
        int iUc;
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() - this.ho);
        if (ofVar == null) {
            iUc = 100;
        } else {
            iUc = ie.uc(ofVar);
        }
        return Math.max(com.byazt.mp.c.pr().g(), (this.k - iCurrentTimeMillis) - iUc);
    }

    private i hn(com.byazt.qe.hw hwVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        i iVar = new i();
        iVar.fw = 2;
        iVar.zo = jCurrentTimeMillis;
        iVar.g = com.byazt.sd.zo.nt().bm();
        Object obj = this.zo;
        if (obj != null && (obj instanceof com.byazt.cv.hw)) {
            iVar.aj = ((com.byazt.cv.hw) obj).pr();
        }
        return iVar;
    }

    private void pr(String str, int i, int i2) {
        int iG = a.hw().g(str);
        switch (iG) {
            case 1:
                this.k = i > 0 ? Math.min(i, i2) : Math.max(i2, 500);
                break;
            case 2:
                this.k = i > 0 ? i : Math.max(i2, 500);
                break;
            default:
                this.k = i > 0 ? Math.max(i, i2) : Math.max(i2, 500);
                break;
        }
        int iCurrentTimeMillis = (int) (((long) this.k) - (System.currentTimeMillis() - this.uc.aj));
        if (iCurrentTimeMillis <= 0) {
            iCurrentTimeMillis = this.k;
        }
        this.k = iCurrentTimeMillis;
        com.byazt.nz.pr.pr("Splash_FullLink", "splashTimeOutControlType = " + iG + "; devTimeOut = " + i2 + "; cloudTimeOut = " + i + "; realTimeOut = " + this.k);
        this.vk.sendEmptyMessageDelayed(2, this.k);
        pr(this.k);
    }

    private void pr(int i) {
        int iAj = a.hw().aj(this.w);
        if (iAj < i && iAj > 0 && g() && this.vk != null) {
            int i2 = i - iAj;
            com.byazt.nz.pr.pr("Splash_FullLink", "buffer time: " + iAj + "  减去buffer time后超时时间：" + i2);
            this.vk.sendEmptyMessageDelayed(4, i2);
        }
    }

    private void m() {
        this.b = new jw();
        jw jwVar = new jw();
        this.iu = jwVar;
        fw.pr(this.b, jwVar);
        this.ve = new com.byazt.zn.x();
        this.gz = new com.byazt.zn.x();
    }

    private void c(boolean z) {
        if (z) {
            this.qa = System.currentTimeMillis();
        } else {
            this.lb = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc(boolean z) {
        if (z) {
            this.gz.hn(System.currentTimeMillis() - this.qa);
        } else {
            this.ve.hn(System.currentTimeMillis() - this.lb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return this.x == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final com.byazt.zn.zo zoVar, final com.byazt.zn.uc ucVar, final pr prVar, final com.byazt.mr.hw hwVar, boolean z) {
        if (this.nl.get()) {
            return;
        }
        hw(zoVar, System.currentTimeMillis());
        if (zoVar.w()) {
            com.byazt.nz.pr.pr("Splash_FullLink", "缓存广告： 素材首包回调");
            this.s.set(true);
        } else {
            com.byazt.nz.pr.pr("Splash_FullLink", "实时广告： 素材首包回调");
            this.e.set(true);
        }
        fw.pr(zoVar.w() ? this.iu : this.b, 3);
        fw(zoVar.w());
        if (z) {
            pr(zoVar, ucVar, prVar);
        } else {
            c.hw(new Runnable() { // from class: com.byazt.jm.uc.7
                @Override // java.lang.Runnable
                public void run() {
                    uc.this.pr(zoVar, ucVar, prVar, hwVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final com.byazt.zn.zo zoVar, final com.byazt.zn.uc ucVar, final pr prVar, final com.byazt.mr.hw hwVar, long j, boolean z) {
        if (zoVar == null) {
            return;
        }
        pr(ucVar, ucVar.c(), false);
        if (this.nl.get()) {
            return;
        }
        if (hwVar instanceof com.byazt.rw.pr) {
            ((com.byazt.rw.pr) hwVar).pr(zoVar, false);
        }
        pr(zoVar, j);
        if (zoVar.w() && this.s.get()) {
            return;
        }
        if (!zoVar.w() && this.e.get()) {
            return;
        }
        if (pr(zoVar.hw(), zoVar.c()) || pr(ucVar.hw())) {
            fw.pr(zoVar.w() ? this.iu : this.b, 2);
            fw(zoVar.w());
        }
        if (z) {
            pr(zoVar, ucVar, prVar);
        } else {
            c.hw(new Runnable() { // from class: com.byazt.jm.uc.8
                @Override // java.lang.Runnable
                public void run() {
                    uc.this.pr(zoVar, ucVar, prVar, hwVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.zn.uc ucVar, com.byazt.zn.fw fwVar, pr prVar, long j) {
        int i;
        if (fwVar == null) {
            return;
        }
        boolean zZo = fwVar.zo();
        if (!x(zZo)) {
            com.byazt.nz.pr.pr("Splash_FullLink", "实时cac广告: 素材加载失败，直接给回调");
            prVar.hw(fwVar);
        } else {
            com.byazt.nz.pr.pr("Splash_FullLink", "缓存广告: 素材加载失败");
            this.y.set(false);
            if (this.qn.get()) {
                prVar.hw(fwVar);
            }
        }
        pr(ucVar, zZo, false);
        if (fwVar.uc()) {
            i = -14;
        } else {
            i = -7;
        }
        if (!fwVar.uc()) {
            zo.pr(j, false, false, hw(fwVar.zo()), i, fwVar.c());
        }
        com.byazt.nz.pr.pr("Splash_FullLink", (zZo ? "缓存广告" : "实时广告") + "加载素材失败 " + fwVar.x());
    }

    private void fw(boolean z) {
        if (this.vk != null) {
            if (g()) {
                if (!z) {
                    this.vk.removeMessages(4);
                } else {
                    return;
                }
            }
            this.vk.removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(com.byazt.zn.uc ucVar) {
        if (ucVar != null && ucVar.c()) {
            return;
        }
        uc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.zn.uc ucVar, boolean z, boolean z2) {
        if (z) {
            return;
        }
        try {
            if (this.ls.get() > 0 && !this.qi.get()) {
                com.byazt.nz.pr.pr("lqmt", "该实时广告已回调媒体");
            } else {
                if (com.byazt.vx.c.pr(this.c, this.uc)) {
                    return;
                }
                if (this.ls.get() > 0 || this.g.hn()) {
                    this.m.pr(ucVar, this.c, z2, this.x);
                }
            }
        } catch (Exception e) {
        }
    }

    private void pr(boolean z, int i) {
        (z ? this.gz : this.ve).c(i);
    }

    public static boolean hn() {
        return (com.byazt.mp.c.pr().k() & 256) == 256;
    }

    public static boolean pr(com.byazt.qe.hw hwVar) {
        return com.byazt.vx.c.pr(hwVar, new i()) && (com.byazt.mp.c.pr().k() & 4) == 4;
    }

    private boolean ho() {
        return (com.byazt.mp.c.pr().w() & 4) == 4;
    }
}
