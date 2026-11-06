package com.byazt.lu;

import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.ie;
import com.byazt.hg.jn;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 250})
public class k extends pr {
    public k(TTBaseVideoActivity tTBaseVideoActivity, of ofVar) {
        super(tTBaseVideoActivity, ofVar);
    }

    @Override // com.byazt.lu.hw
    public boolean l() {
        return lv();
    }

    public static boolean pr(of ofVar) {
        return true;
    }

    @Override // com.byazt.lu.hw
    public boolean lv() {
        return true;
    }

    @Override // com.byazt.lu.hw
    public boolean od() {
        return !fw() || jn.hn(this.hw, fw());
    }

    @Override // com.byazt.lu.hw
    public void pq() {
        this.lb.hw(this.hw.zz());
        if (uc()) {
            this.aj.c(8);
            this.aj.uc(8);
            this.lb.pr(false);
        } else {
            this.aj.c(0);
            this.aj.uc(0);
            this.lb.c(true);
        }
        this.pr.r();
    }

    @Override // com.byazt.lu.hw
    public void jw() {
        if (this.ny != null) {
            ((com.byazt.dl.pr) this.ny.pr(com.byazt.dl.pr.class)).pr((Object) this.pr);
        }
        if (this.fo != null) {
            ((com.byazt.dl.pr) this.fo.pr(com.byazt.dl.pr.class)).pr((Object) this.pr);
        }
    }

    @Override // com.byazt.lu.pr
    public void yb() {
        super.yb();
        this.pr.r();
    }

    @Override // com.byazt.lu.hw
    public void d() {
        if (!jn.yb(this.hw)) {
            return;
        }
        boolean z = !jn.hn();
        boolean zHn = jn.hn();
        this.pr.hn(0);
        if (b() > of() || this.ho) {
            com.byazt.hb.uc.pr = 0;
            this.lb.pr(this.g, this.g ? "领取成功" : "", z ? "跳过" : "", zHn, true);
            this.pr.nw();
            return;
        }
        int iUc = uc(true);
        int iUc2 = uc(false);
        com.byazt.hb.uc.pr = iUc;
        boolean z2 = b() > this.gz.hn() || this.pr.ie();
        this.lb.pr(this.g, iUc2 + an.aB + (this.g ? "后可领取奖励" : ""), z && z2 ? "跳过" : "", zHn && z2, z2);
        hw(iUc);
    }

    @Override // com.byazt.lu.hw
    public boolean mw() {
        return true;
    }

    @Override // com.byazt.lu.hw
    public boolean sv() {
        if (!this.g) {
            return false;
        }
        if (ie.pr(this.hw) == 2 && ie.hn(this.hw) == 3) {
            return false;
        }
        return (ie.pr(this.hw) == 2 && ie.hn(this.hw) == 7) ? false : true;
    }

    @Override // com.byazt.lu.hw
    public boolean gu() {
        return jn.yb(this.hw);
    }

    @Override // com.byazt.lu.pr
    public int y() {
        return hw(this.hw);
    }

    public static int hw(of ofVar) {
        return 1;
    }
}
