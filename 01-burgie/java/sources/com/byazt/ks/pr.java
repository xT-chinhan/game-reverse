package com.byazt.ks;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.hg.i;
import com.byazt.hg.jw;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.sv;
import com.byazt.hg.y;
import com.byazt.jm.zo;
import com.byazt.ld.nt;
import com.byazt.sd.a;
import com.byazt.sd.fo;
import com.byazt.wt.ls;
import com.byazt.wt.yb;
import com.byazt.zn.aj;
import com.byazt.zn.fw;
import com.byazt.zn.uc;
import com.byazt.zp.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, 37})
public abstract class pr {
    public c uc;
    public long pr = 0;
    public long hw = 0;
    public AtomicBoolean hn = new AtomicBoolean(false);
    public AtomicBoolean x = new AtomicBoolean(false);
    public AtomicBoolean c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.byazt.ks.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0116pr {
        void pr();

        void pr(uc ucVar);
    }

    public abstract void hn();

    public abstract void hw();

    public abstract void pr(sv svVar, com.byazt.qe.hw hwVar, boolean z);

    public abstract void pr(com.byazt.vx.x<aj, fw> xVar, of ofVar, com.byazt.qe.hw hwVar, boolean z);

    public abstract void pr(fw fwVar, String str, InterfaceC0116pr interfaceC0116pr, c cVar);

    public abstract void pr(String str, of ofVar);

    public abstract void pr(String str, String str2, boolean z, boolean z2, Object obj);

    public static pr pr() {
        return (com.byazt.mp.c.pr().w() & 16) == 16 ? new hn() : new x();
    }

    public void pr(uc ucVar, com.byazt.qe.hw hwVar, boolean z, int i) {
        if (!pr(i) || !com.byazt.py.c.pr(ucVar.hw()) || this.hn.get()) {
            return;
        }
        this.hn.set(true);
        com.byazt.nz.pr.pr("Splash_FullLink", "cacheRealTimeAdWhenTimeout start");
        pr(new sv(ucVar.x(), ucVar.hw(), null), hwVar, false);
        if (z) {
            pr(ucVar.x(), ucVar.hw(), hwVar);
        }
        com.byazt.nz.pr.pr("Splash_FullLink", "cacheRealTimeAdWhenTimeout end");
    }

    public static boolean pr(int i) {
        int iW = com.byazt.mp.c.pr().w();
        if (i == 2) {
            return (iW & 2) == 2;
        }
        return (i == 3 || i == 1) && (iW & 32) == 32;
    }

    public void pr(final com.byazt.qe.hw hwVar, i iVar) {
        if (this.hn.get()) {
            com.byazt.nz.pr.pr("lqmt", "已经存储了一个实时广告");
            return;
        }
        if (this.x.getAndSet(true)) {
            com.byazt.nz.pr.pr("lqmt", "已在预加载开屏广告....不再发出");
            return;
        }
        if (a.hw().vk(hwVar.x()) && iVar != null) {
            iVar.fw = 2;
        }
        a.pr().pr(hwVar, iVar, 4, new fo.hw() { // from class: com.byazt.ks.pr.1
            @Override // com.byazt.sd.fo.hw
            public void pr(int i, String str, com.byazt.hg.hw hwVar2) {
                pr.this.x.set(false);
                hwVar2.pr(i);
                com.byazt.hg.hw.pr(hwVar2);
            }

            @Override // com.byazt.sd.fo.hw
            public void pr(com.byazt.hg.pr prVar, com.byazt.hg.hw hwVar2) {
                if (zo.hw(prVar)) {
                    of ofVar = prVar.hw().get(0);
                    if (ofVar.rq()) {
                        if ((pr.this.hn == null || !pr.this.hn.get()) && com.byazt.py.c.pr(ofVar)) {
                            pr.this.pr(new sv(prVar, ofVar, null), hwVar, false);
                            pr.this.pr(prVar, ofVar, hwVar);
                            return;
                        }
                        return;
                    }
                    hwVar2.pr(-4);
                    com.byazt.hg.hw.pr(hwVar2);
                    return;
                }
                pr.this.x.set(false);
            }
        });
    }

    public void pr(final com.byazt.hg.pr prVar, final of ofVar, com.byazt.qe.hw hwVar) {
        if (ofVar.de() == null || ofVar.de().size() <= 0) {
            return;
        }
        y yVar = ofVar.de().get(0);
        String strPr = yVar.pr();
        int iHw = yVar.hw();
        int iHn = yVar.hn();
        this.pr = System.currentTimeMillis();
        this.hw = SystemClock.elapsedRealtime();
        jw jwVarHn = com.byazt.pk.uc.pr().hn().hn();
        if (jwVarHn != null) {
            jwVarHn.pr(false);
        }
        final boolean z = qv.ho(ofVar) != null;
        yb.pr(new com.byazt.vl.hw(strPr, yVar.fw()), iHw, iHn, new yb.pr() { // from class: com.byazt.ks.pr.2
            @Override // com.byazt.wt.yb.pr
            public void pr(com.byazt.bd.hw hwVar2, nt ntVar) {
                zo.pr(prVar);
                if (!z) {
                    com.byazt.pj.pr.pr(ofVar, "splash_ad", System.currentTimeMillis() - pr.this.pr);
                }
                pr.this.pr = 0L;
                if (z) {
                    zo.pr(pr.this.hw, false, true, ofVar, 0L, "preLoadImageSuccess");
                }
                pr.this.x.set(false);
            }

            @Override // com.byazt.wt.yb.pr
            public void pr() {
                zo.pr(prVar);
                if (z) {
                    zo.pr(pr.this.hw, false, false, ofVar, -7L, "preLoadImageFailed");
                }
                pr.this.x.set(false);
            }
        }, w.c(), 4, null, false);
    }

    public void hw(com.byazt.qe.hw hwVar, i iVar) {
        if (a.hw().hw(ls.hw(hwVar)) && hwVar != null && TextUtils.isEmpty(hwVar.cz())) {
            com.byazt.nz.pr.pr("lqmt", "preLoadSplashAd... ");
            i iVar2 = iVar == null ? new i() : iVar.pr();
            iVar2.zo = System.currentTimeMillis();
            iVar2.fw = 2;
            iVar2.g = com.byazt.sd.zo.nt().bm();
            iVar2.hw = 2;
            pr(hwVar, iVar2);
        }
    }
}
