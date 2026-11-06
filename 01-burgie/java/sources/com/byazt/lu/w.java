package com.byazt.lu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.wt.ny;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 109})
public class w extends pr {
    public int nl;
    public com.byazt.pj.x ww;
    public int y;

    public w(TTBaseVideoActivity tTBaseVideoActivity, of ofVar) {
        super(tTBaseVideoActivity, ofVar);
        this.nl = 0;
        this.y = 0;
        com.byazt.pj.x xVar = new com.byazt.pj.x(ofVar);
        this.ww = xVar;
        xVar.pr(true);
    }

    public static boolean pr(of ofVar) {
        return ofVar.vj() == 1 && lb.pr(ofVar);
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
        return false;
    }

    @Override // com.byazt.lu.pr
    public boolean uc() {
        return false;
    }

    @Override // com.byazt.lu.pr
    public void hw(boolean z) {
        super.hw(z);
        this.ww.hn();
        if (this.aj instanceof com.byazt.xt.pr) {
            ((com.byazt.xt.pr) this.aj).aj();
        }
    }

    @Override // com.byazt.lu.pr
    public void hn(boolean z) {
        super.hn(z);
        if (this.aj instanceof com.byazt.xt.pr) {
            if (((com.byazt.xt.pr) this.aj).uc()) {
                this.ww.pr(((com.byazt.xt.pr) this.aj).c().get());
            }
            ((com.byazt.xt.pr) this.aj).zo();
        }
    }

    @Override // com.byazt.lu.pr
    public void nt() {
        super.nt();
        if ((this.aj instanceof com.byazt.xt.pr) && ((com.byazt.xt.pr) this.aj).uc()) {
            this.ww.x();
        }
        this.aj.vk();
    }

    @Override // com.byazt.lu.pr
    public void g() {
        super.g();
    }

    @Override // com.byazt.lu.hw
    public void pq() {
        this.aj.c(0);
        this.lb.pr(true);
        if (com.byazt.ea.w.x(this.hw)) {
            this.lb.c(true);
        }
        if (com.byazt.ea.w.c(this.hw) || com.byazt.ea.w.x(this.hw)) {
            this.lb.hw(false);
        } else {
            this.lb.hw(this.hw.zz());
        }
        if (com.byazt.ea.w.hn(this.hw)) {
            this.lb.hn(true);
            this.lb.c(true);
            this.lb.pr(this.g, er() + an.aB + (this.g ? "后可领取奖励" : ""), null, true, true);
        } else {
            this.lb.c(false);
            this.lb.pr(false, null, null, true, true);
        }
    }

    @Override // com.byazt.lu.pr
    public void c(boolean z) {
        super.c(z);
        if (com.byazt.ea.w.x(this.hw)) {
            ((com.byazt.xt.pr) this.aj).hw(z);
        }
    }

    @Override // com.byazt.lu.pr
    public boolean n() {
        if (er() > 0) {
            return false;
        }
        if (com.byazt.ea.w.c(this.hw)) {
            ((com.byazt.xt.pr) this.aj).pr(0);
            return true;
        }
        return true;
    }

    @Override // com.byazt.lu.pr
    public int fw(boolean z) {
        if ((this.a.e() && lb.pr(this.hw)) || this.nl == 0) {
            return 0;
        }
        if (com.byazt.ea.w.c(this.hw) || com.byazt.ea.w.x(this.hw)) {
            return Math.max(this.nl - b(), 0);
        }
        return Math.max(Math.min(this.nl, 27) - b(), 0);
    }

    @Override // com.byazt.lu.pr
    public int v() {
        if ((this.a.e() && lb.pr(this.hw)) || this.nl == 0) {
            return 0;
        }
        if (com.byazt.ea.w.c(this.hw) || com.byazt.ea.w.x(this.hw)) {
            return Math.max(this.nl - b(), 0);
        }
        return Math.max(((int) Math.min((this.nl * this.hw.bt()) / 100.0f, 27.0f)) - b(), 0);
    }

    @Override // com.byazt.lu.pr
    public void zo() {
        JSONObject jSONObjectHn;
        super.zo();
        com.byazt.sb.hw.pr().pr(this.hw);
        if (com.byazt.ea.w.c(this.hw) || com.byazt.ea.w.x(this.hw)) {
            com.byazt.ze.pr prVarSv = this.hw.sv();
            this.nl = 30;
            if (prVarSv != null && (jSONObjectHn = prVarSv.hn()) != null) {
                this.nl = jSONObjectHn.optInt("reward_time", 30);
            }
        } else {
            this.nl = ny.c(this.hw);
        }
        this.y = ny.uc(this.hw);
    }

    @Override // com.byazt.lu.pr
    public View aj() {
        FrameLayout frameLayout = new FrameLayout(this.pr);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.byazt.lu.pr, com.byazt.lu.hw
    public void hn() {
        this.lb.pr(4);
        this.aj.hn(true);
        if (com.byazt.ea.w.c(this.hw) || com.byazt.ea.w.x(this.hw)) {
            ((com.byazt.xt.pr) this.aj).pr(Math.max(0, this.nl - b()));
        }
        this.pr.hw(true, true);
    }

    @Override // com.byazt.lu.pr
    public com.byazt.xt.hw pr(boolean z) {
        this.aj = new com.byazt.xt.pr(this.pr, this.hw, z, this.ww, this.lb);
        return this.aj;
    }

    @Override // com.byazt.lu.pr
    public com.byazt.wv.hw.pr pr(final of ofVar, final com.byazt.wv.vk vkVar) {
        this.pr.qn();
        this.pr.qi();
        com.byazt.wv.zo zoVar = new com.byazt.wv.zo(this.pr, ofVar);
        zoVar.pr(this.a.cz());
        zoVar.pr(qi());
        return zoVar.hw(new com.byazt.wv.vk() { // from class: com.byazt.lu.w.1
            @Override // com.byazt.wv.vk
            public void pr() {
                com.byazt.wv.vk vkVar2 = vkVar;
                if (vkVar2 != null) {
                    vkVar2.pr();
                }
                if (com.byazt.ea.w.x(ofVar) && ((com.byazt.xt.pr) w.this.aj).x()) {
                    return;
                }
                w.this.pr.of();
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
    public void fo() {
        if (com.byazt.ea.w.x(this.hw) && ((com.byazt.xt.pr) this.aj).hn()) {
            ((com.byazt.xt.pr) this.aj).pr(false);
        }
    }

    @Override // com.byazt.lu.hw
    public void d() {
        int iB = b();
        int iMax = Math.max(0, this.nl - iB);
        if (!this.a.e()) {
            int i = this.nl;
            if (iB >= i) {
                if (com.byazt.ea.w.hn(this.hw)) {
                    this.lb.pr(this.g, this.g ? "领取成功" : "", null, true, true);
                } else {
                    this.lb.pr(false, null, null, true, true);
                }
                this.pr.m();
            } else if (this.y >= i) {
                this.lb.pr(false, String.valueOf(iMax), null, false, false);
            } else if (com.byazt.ea.w.hn(this.hw)) {
                this.lb.pr(this.g, iMax + an.aB + (this.g ? "后可领取奖励" : ""), null, this.y <= iB, true);
            } else if (com.byazt.ea.w.c(this.hw) || com.byazt.ea.w.x(this.hw)) {
                if (iB >= this.y) {
                    this.lb.pr(false, null, null, true, true);
                }
            } else if (iB < this.y) {
                this.lb.pr(false, String.valueOf(iMax), (this.y - iB) + "s后可跳过", false, false);
            } else {
                this.lb.pr(false, String.valueOf(iMax), "跳过", false, true);
            }
        }
        this.pr.hn(0);
        if (com.byazt.ea.w.c(this.hw)) {
            ((com.byazt.xt.pr) this.aj).pr(iMax);
        }
        if (iMax == 0 && (this.aj instanceof com.byazt.xt.pr)) {
            ((com.byazt.xt.pr) this.aj).fw();
        }
    }

    @Override // com.byazt.lu.pr
    public int y() {
        return hw(this.hw);
    }

    public static int hw(of ofVar) {
        if (com.byazt.ea.w.hn(ofVar)) {
            return 6;
        }
        return 7;
    }
}
