package com.byazt.lu;

import android.view.View;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.jn;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends pr {
    public c(TTBaseVideoActivity tTBaseVideoActivity, of ofVar) {
        super(tTBaseVideoActivity, ofVar);
    }

    @Override // com.byazt.lu.pr
    public View aj() {
        if (this.x != 100.0f) {
            return jn();
        }
        if (this.hn == 2) {
            switch (this.hw.jg()) {
                case 3:
                    return com.byazt.sdv.c.yb(this.pr);
                case 33:
                    return com.byazt.sdv.c.lb(this.pr);
                default:
                    return com.byazt.sdv.c.qa(this.pr);
            }
        }
        switch (this.hw.jg()) {
            case 3:
                return com.byazt.sdv.c.a(this.pr);
            case 33:
                return com.byazt.sdv.c.cz(this.pr);
            default:
                return com.byazt.sdv.c.ny(this.pr);
        }
    }

    @Override // com.byazt.lu.pr
    public com.byazt.xt.hw pr(boolean z) {
        if (this.x != 100.0f) {
            this.aj = new com.byazt.xt.fw(this.pr, this.hw, z);
        } else {
            this.aj = new com.byazt.xt.uc(this.pr, this.hw, z);
        }
        return this.aj;
    }

    public static boolean pr(of ofVar) {
        return (ofVar == null || of.hn(ofVar)) ? false : true;
    }

    @Override // com.byazt.lu.hw
    public boolean l() {
        return false;
    }

    @Override // com.byazt.lu.hw
    public boolean lv() {
        return false;
    }

    @Override // com.byazt.lu.hw
    public boolean od() {
        if (!a.hw().sh()) {
            return jn.hn(this.hw, fw()) && qv.k(this.hw);
        }
        if (this.hw.oq() != 100.0f) {
            return of.hn(this.hw) || com.byazt.zp.k.pr(this.hw);
        }
        if (this.vk.c()) {
            return this.vk.vk();
        }
        return true;
    }

    @Override // com.byazt.lu.hw
    public void pq() {
        this.aj.c(8);
        this.aj.uc(8);
        this.lb.c(od());
        this.lb.hw(this.hw.zz());
        this.pr.r();
    }

    @Override // com.byazt.lu.hw
    public boolean mw() {
        return true;
    }

    @Override // com.byazt.lu.hw
    public boolean sv() {
        return this.g;
    }

    @Override // com.byazt.lu.hw
    public boolean gu() {
        if (!jn.hn(this.hw, fw())) {
            return false;
        }
        if (jn.yb(this.hw)) {
            return true;
        }
        return (a.hw().sh() || od()) ? false : true;
    }

    @Override // com.byazt.lu.hw
    public boolean zo(boolean z) {
        if (a.hw().sh()) {
            return false;
        }
        return (z || !jn.yb(this.hw)) && !od() && gu();
    }

    @Override // com.byazt.lu.pr
    public int of() {
        if (zo(false)) {
            return (int) Math.min(jn.pr() / 1000, (int) qv.fw(this.hw));
        }
        if (jn.yb(this.hw)) {
            return super.of();
        }
        return (int) qv.fw(this.hw);
    }

    @Override // com.byazt.lu.hw
    public void d() {
        super.d();
        if (!gu()) {
            return;
        }
        int iIu = iu();
        int iB = b();
        if (!a.hw().sh() && !od() && jn.hn(this.hw, fw()) && iIu > qv.fw(this.hw)) {
            this.pr.vj();
        }
        this.pr.hn(0);
        if (zo(false)) {
            if (this.a.e()) {
                return;
            }
            if (iB > of() || this.ho) {
                com.byazt.hb.uc.pr = 0;
                this.pr.r();
                if (this.vk != null && rc() == 7) {
                    this.vk.pr("0", iB, 0, false);
                    return;
                }
                return;
            }
            int iUc = uc(true);
            int iUc2 = uc(false);
            com.byazt.hb.uc.pr = iUc;
            this.pr.r();
            hw(iUc);
            if (this.vk != null && rc() == 7) {
                this.vk.pr(String.valueOf(iUc2), iB, 0, false);
                return;
            }
            return;
        }
        if (iB > of() || this.ho) {
            this.pr.nw();
            com.byazt.hb.uc.pr = 0;
            this.lb.pr(this.g, this.g ? "领取成功" : "", null, true, true);
            if (this.vk != null && rc() == 7) {
                this.vk.pr("0", iB, 0, false);
                return;
            }
            return;
        }
        int iUc3 = uc(true);
        int iUc4 = uc(false);
        com.byazt.hb.uc.pr = iUc3;
        boolean z = iB > this.gz.hn() || this.pr.ie();
        this.lb.pr(this.g, iUc4 + an.aB + (this.g ? "后可领取奖励" : ""), null, z, z);
        hw(iUc3);
        if (this.vk != null && rc() == 7) {
            this.vk.pr(String.valueOf(iUc4), iB, 0, false);
        }
    }

    @Override // com.byazt.lu.pr
    public int y() {
        return hw(this.hw);
    }

    public static int hw(of ofVar) {
        return 3;
    }
}
