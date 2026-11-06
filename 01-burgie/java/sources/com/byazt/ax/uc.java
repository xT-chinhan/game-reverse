package com.byazt.ax;

import android.widget.FrameLayout;
import com.byazt.ca.ho;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.ihe.fw;
import com.byazt.yo.yb;
import com.byazt.zp.k;
import com.byazt.zp.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ, 5})
public class uc {
    public int c;
    public com.byazt.w.hn fw;
    public com.byazt.az.pr g;
    public com.byazt.n.uc ho;
    public FrameLayout k;
    public long m;
    public boolean uc;
    public TTBaseVideoActivity vk;
    public of w;
    public long x;
    public long zo;
    public final int aj = 210;
    public boolean pr = false;
    public boolean hw = false;
    public boolean hn = false;
    public boolean nt = false;

    public uc(TTBaseVideoActivity tTBaseVideoActivity) {
        this.vk = tTBaseVideoActivity;
    }

    public void pr(of ofVar) {
        this.w = ofVar;
    }

    public void pr(FrameLayout frameLayout, boolean z) {
        if (this.nt) {
            return;
        }
        this.nt = true;
        this.k = frameLayout;
        this.uc = z;
        if (z) {
            this.fw = new com.byazt.ji.hw(this.vk, frameLayout, this.w, this.g);
        } else {
            this.fw = new com.byazt.ji.pr(this.vk, frameLayout, this.w, this.g);
        }
        this.c = (int) iu();
    }

    public boolean pr() {
        com.byazt.w.hn hnVar = this.fw;
        return (hnVar == null || hnVar.yb() == null || !this.fw.yb().ho()) ? false : true;
    }

    public boolean hw() {
        com.byazt.w.hn hnVar = this.fw;
        return (hnVar == null || hnVar.yb() == null || !this.fw.yb().vk()) ? false : true;
    }

    public boolean hn() {
        com.byazt.w.hn hnVar = this.fw;
        return (hnVar == null || hnVar.yb() == null || !this.fw.yb().k()) ? false : true;
    }

    public boolean x() {
        com.byazt.w.hn hnVar = this.fw;
        return hnVar != null && hnVar.ny();
    }

    public boolean c() {
        return this.hw;
    }

    public void pr(boolean z) {
        this.hw = z;
    }

    public long uc() {
        return this.zo;
    }

    public void pr(long j) {
        this.zo = j;
    }

    public void hw(boolean z) {
        int i;
        if (this.fw == null) {
            return;
        }
        if (z) {
            if (n()) {
                i = 2;
            } else {
                i = 4;
            }
        } else if (n()) {
            i = 0;
        } else {
            i = 1;
        }
        yb.pr prVar = new yb.pr();
        prVar.hw(yb());
        prVar.hn(1 ^ (n() ? 1 : 0));
        prVar.x(i);
        com.byazt.w.hn hnVar = this.fw;
        if ((hnVar instanceof com.byazt.ga.pr) && !((com.byazt.ga.pr) hnVar).cz.pr(128)) {
            ((com.byazt.ga.pr) this.fw).cz.hn(128);
            com.byazt.ne.hn.hn(this.fw.lb(), prVar);
        }
    }

    private void qi() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar == null || hnVar.yb() == null) {
            return;
        }
        this.zo = this.fw.w();
        if (this.fw.yb().w() || !this.fw.yb().ho()) {
            this.fw.uc();
            this.fw.aj();
            this.hw = true;
        }
    }

    public void fw() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar == null) {
            return;
        }
        hnVar.aj();
        this.fw = null;
    }

    public void zo() {
        if (this.fw != null && hw()) {
            this.fw.hw(true);
        }
    }

    public void aj() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            hnVar.vk();
        }
    }

    public void pr(long j, boolean z) {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar == null || this.hn) {
            return;
        }
        if (j != 0) {
            hnVar.pr(j);
            this.fw.hw(z);
        } else {
            hnVar.zo();
        }
    }

    public void pr(Map<String, Object> map) {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar == null || this.hn) {
            return;
        }
        hnVar.pr(map);
    }

    public void vk() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            hnVar.hw();
        }
    }

    public boolean w() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            return hnVar.x();
        }
        return false;
    }

    public boolean k() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            return hnVar.c();
        }
        return false;
    }

    public void hw(Map<String, Object> map) {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            hnVar.hw(map);
        }
    }

    public void pr(com.byazt.ga.pr.InterfaceC0074pr interfaceC0074pr) {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar instanceof com.byazt.ga.pr) {
            ((com.byazt.ga.pr) hnVar).pr(interfaceC0074pr);
        }
    }

    public void hn(boolean z) {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            hnVar.hw(z);
        }
    }

    public boolean m() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            return hnVar.qa();
        }
        return false;
    }

    public long g() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            return hnVar.g();
        }
        return 0L;
    }

    public int ho() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            return hnVar.ho();
        }
        return 0;
    }

    public long nt() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            return hnVar.w();
        }
        return this.zo;
    }

    public long yb() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            return hnVar.k();
        }
        return 0L;
    }

    public int lb() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            return hnVar.m();
        }
        return 0;
    }

    public void qa() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null && hnVar.yb() != null) {
            this.fw.yb().fw();
        }
    }

    public long a() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            return hnVar.g();
        }
        return 0L;
    }

    public boolean cz() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            if (hnVar.yb() != null) {
                fw fwVarYb = this.fw.yb();
                if (fwVarYb.k() || fwVarYb.m()) {
                    ((com.byazt.ga.pr) this.fw).of();
                    return true;
                }
            } else if (c()) {
                pr(false);
                ((com.byazt.ga.pr) this.fw).of();
                return true;
            }
        }
        return false;
    }

    public boolean ny() {
        return this.fw != null;
    }

    public boolean fo() {
        com.byazt.w.hn hnVar = this.fw;
        return hnVar != null && hnVar.yb() == null;
    }

    public boolean pr(long j, boolean z, int i) {
        if (this.fw == null || qv.ho(this.w) == null) {
            return false;
        }
        com.byazt.n.uc ucVarPr = this.ho;
        if (ucVarPr == null) {
            File file = new File(w.pr(this.w.sd()).hw(), qv.zo(this.w));
            if (file.exists() && file.length() > 0) {
                this.pr = true;
            }
            ucVarPr = qv.pr(1, this.w);
            ucVarPr.hw(this.w.x());
            FrameLayout frameLayout = this.k;
            ucVarPr.hw(frameLayout == null ? 100 : frameLayout.getWidth());
            FrameLayout frameLayout2 = this.k;
            ucVarPr.hn(frameLayout2 != null ? frameLayout2.getHeight() : 100);
            ucVarPr.hn(this.w.B_());
            ucVarPr.pr(j);
            ucVarPr.hw(z);
            if (k.pr(this.w)) {
                ucVarPr.pr(true);
            }
        }
        return this.fw.pr(ucVarPr);
    }

    public void rc() {
        fw();
    }

    public void z() {
        try {
            this.vk.g(1);
        } catch (Throwable th) {
            ho.hw("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
        }
    }

    public void b() {
        try {
            this.vk.ho(1);
        } catch (Throwable th) {
            ho.hw("TTBaseVideoActivity", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void pr(boolean z, TTBaseVideoActivity tTBaseVideoActivity) {
        boolean zUc;
        if (z || this.vk.l()) {
            return;
        }
        if (hn()) {
            com.byazt.ga.hw hwVarS = this.vk.bm().s();
            long jC = 0;
            boolean zX = false;
            if (hwVarS == null) {
                zUc = false;
            } else {
                zX = hwVarS.x();
                jC = hwVarS.c();
                zUc = hwVarS.uc();
            }
            if (!zX) {
                pr(jC, zUc);
                return;
            }
        }
        qi();
        pr(tTBaseVideoActivity);
    }

    public void pr(TTBaseVideoActivity tTBaseVideoActivity) {
        if (cz() && tTBaseVideoActivity != null) {
            tTBaseVideoActivity.hw(uc(), true);
        }
    }

    public double iu() {
        double dFw = qv.fw(this.w);
        if (qv.ho(this.w) != null && this.w.io() > 0 && dFw > this.w.io()) {
            return this.w.io();
        }
        return dFw;
    }

    public int ve() {
        return this.c;
    }

    public long gz() {
        if (w()) {
            double dUc = qv.yb(this.w).uc() * 1000.0d * ((double) nl().qi());
            long j = this.x;
            if (dUc - j > 210.0d) {
                long j2 = (long) (j + dUc);
                this.m = j2;
                return j2;
            }
        }
        return Math.max(this.x, this.m);
    }

    public void hw(long j) {
        this.x = j;
        if (!k() && w()) {
            this.c = (int) Math.max(0L, Math.round(iu() - ((this.x + (qv.yb(this.w).uc() * 1000.0d)) / 1000.0d)));
        } else {
            this.c = Math.max(0, (int) (iu() - (this.x / 1000)));
        }
    }

    public com.byazt.ga.pr nl() {
        return (com.byazt.ga.pr) e();
    }

    public boolean y() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar == null) {
            return false;
        }
        return hnVar.hn();
    }

    public com.byazt.w.hw ww() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            return hnVar.lb();
        }
        return null;
    }

    public boolean n() {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null && hnVar.yb() != null) {
            return this.fw.yb().zo();
        }
        return false;
    }

    public void pr(int i) {
        com.byazt.w.hn hnVar = this.fw;
        if (hnVar != null) {
            hnVar.pr(i);
        }
    }

    public com.byazt.w.hn e() {
        return this.fw;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void s() {
        boolean zPr;
        yb.pr prVar = new yb.pr();
        prVar.hw(yb());
        prVar.c(3);
        prVar.uc(lb());
        com.byazt.w.hn hnVar = this.fw;
        if (!(hnVar instanceof com.byazt.ga.pr)) {
            zPr = 0;
        } else {
            ((com.byazt.ga.pr) hnVar).cz.hn(32);
            zPr = ((com.byazt.ga.pr) this.fw).cz.pr(2);
        }
        com.byazt.ne.hn.pr(ww(), prVar, this.vk.zo(), !zPr);
    }

    public boolean ls() {
        return this.hn;
    }

    public void er() {
        this.hn = true;
    }

    public void v() {
        try {
            com.byazt.w.hn hnVar = this.fw;
            if (hnVar instanceof com.byazt.ga.pr) {
                ((com.byazt.ga.pr) hnVar).nw();
            }
        } catch (Throwable th) {
        }
    }

    public void pr(of ofVar, com.byazt.w.hn hnVar, com.byazt.n.uc ucVar) {
        this.w = ofVar;
        this.fw = hnVar;
        this.ho = ucVar;
    }

    public void pr(com.byazt.az.pr prVar) {
        this.g = prVar;
    }

    public void pr(float f) {
        if (this.fw.yb() != null) {
            this.fw.yb().pr(f);
        }
    }
}
