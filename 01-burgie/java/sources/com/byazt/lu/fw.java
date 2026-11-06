package com.byazt.lu;

import android.view.View;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.jn;
import com.byazt.hg.lb;
import com.byazt.hg.nw;
import com.byazt.hg.of;
import com.byazt.wt.ny;
import com.byazt.xz.RewardJointEndCardFrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 62})
public class fw extends pr {
    public int nl;
    public boolean ww;
    public int y;

    public fw(TTBaseVideoActivity tTBaseVideoActivity, of ofVar) {
        super(tTBaseVideoActivity, ofVar);
        this.nl = 0;
        this.y = 0;
        this.ww = false;
    }

    public static boolean pr(of ofVar) {
        return ny.hn(ofVar);
    }

    @Override // com.byazt.lu.pr
    public View aj() {
        return com.byazt.sdv.c.pr(this.pr);
    }

    @Override // com.byazt.lu.pr
    public View vk() {
        if (lb.x(this.hw)) {
            this.w = new RewardJointEndCardFrameLayout(this.pr, this.hw);
        }
        return super.vk();
    }

    @Override // com.byazt.lu.pr, com.byazt.lu.hw
    public void hn() {
        this.lb.pr(4);
        this.a.hw();
        this.pr.qa();
        if (lb.m(this.hw)) {
            this.lb.hw(true);
        }
        this.nl = ny.c(this.hw);
        this.y = ny.uc(this.hw);
        if (lb.x(this.hw)) {
            this.pr.uc();
        }
    }

    @Override // com.byazt.lu.hw
    public boolean l() {
        return true;
    }

    @Override // com.byazt.lu.hw
    public boolean lv() {
        return true;
    }

    @Override // com.byazt.lu.hw
    public boolean od() {
        return lb.x(this.hw) && of.hn(this.hw);
    }

    @Override // com.byazt.lu.pr
    public boolean uc() {
        return false;
    }

    @Override // com.byazt.lu.pr
    public int fw(boolean z) {
        int i;
        if (lb.m(this.hw) || (i = this.nl) == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min(i, 27.0f)) - b());
    }

    @Override // com.byazt.lu.pr
    public int v() {
        if (lb.m(this.hw) || this.nl == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min((this.nl * this.hw.bt()) / 100.0f, 27.0f)) - b());
    }

    @Override // com.byazt.lu.hw
    public void pq() {
        this.lb.pr(true);
        this.aj.uc(8);
        if (lb.pr(this.hw)) {
            aa();
        } else {
            this.lb.c(true);
            this.lb.hw(this.hw.zz());
        }
    }

    public void aa() {
        switch (this.hw.ej()) {
            case 0:
                this.aj.c(0);
                this.lb.c(true);
                this.lb.hw(this.hw.zz());
                break;
            case 1:
                this.aj.c(0);
                this.lb.hw(this.hw.zz());
                if (lb.x(this.hw)) {
                    this.lb.c(of.hn(this.hw));
                } else {
                    this.lb.c(com.byazt.zp.k.pr(this.hw));
                }
                break;
            case 3:
                this.lb.c(false);
                this.lb.hw(false);
                this.lb.pr(false, null, null, true, true);
                break;
        }
    }

    @Override // com.byazt.lu.pr
    public void zo() {
        super.zo();
        com.byazt.sb.hw.pr().pr(this.hw);
    }

    @Override // com.byazt.lu.pr
    public void hw(boolean z) {
        super.hw(z);
    }

    @Override // com.byazt.lu.pr
    public void g() {
        super.g();
        this.pr.qi();
    }

    @Override // com.byazt.lu.pr
    public void nt() {
        super.nt();
        com.byazt.sb.hw.pr().hw(this.hw);
    }

    @Override // com.byazt.lu.pr
    public boolean n() {
        if (er() > 0) {
            return false;
        }
        if (lb.x(this.hw)) {
            return true;
        }
        switch (nw.pr(this.hw)) {
            case 0:
                return this.a.cz();
            default:
                return true;
        }
    }

    @Override // com.byazt.lu.hw
    public void d() {
        if (lb.m(this.hw)) {
            return;
        }
        int iB = b();
        int i = this.nl;
        int i2 = i - iB;
        if (iB >= i) {
            this.lb.pr(false, null, null, true, true);
            if (!lb.m(this.hw)) {
                this.pr.m();
            }
        } else {
            int i3 = this.y;
            if (i3 >= i) {
                this.lb.pr(false, String.valueOf(i2), null, false, false);
            } else if (iB < i3) {
                this.lb.pr(false, String.valueOf(i2), (this.y - iB) + "s后可跳过", false, false);
            } else {
                this.lb.pr(false, String.valueOf(i2), "跳过", false, true);
            }
        }
        this.pr.hn(0);
    }

    @Override // com.byazt.lu.hw
    public boolean sv() {
        return lb.x(this.hw);
    }

    @Override // com.byazt.lu.hw
    public boolean gu() {
        return jn.yb(this.hw);
    }

    @Override // com.byazt.lu.pr
    public com.byazt.wv.hw.pr pr(of ofVar, final com.byazt.wv.vk vkVar) {
        if (this.cz.c()) {
            return new com.byazt.wv.hw.pr(false, 0, "");
        }
        this.pr.qn();
        this.pr.qi();
        com.byazt.wv.zo zoVar = new com.byazt.wv.zo(this.pr, ofVar);
        zoVar.pr(this.a.cz());
        zoVar.pr(qi());
        return zoVar.hw(new com.byazt.wv.vk() { // from class: com.byazt.lu.fw.1
            @Override // com.byazt.wv.vk
            public void pr() {
                com.byazt.wv.vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.pr();
                }
                fw.this.pr.of();
            }

            @Override // com.byazt.wv.vk
            public void hw() {
                com.byazt.wv.vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.hw();
                }
            }
        });
    }

    @Override // com.byazt.lu.pr
    public int y() {
        return hw(this.hw);
    }

    public static int hw(of ofVar) {
        if (lb.pr(ofVar)) {
            return 6;
        }
        return 0;
    }
}
