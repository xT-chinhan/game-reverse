package com.byazt.lu;

import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.jn;
import com.byazt.hg.l;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends pr {
    public final AtomicBoolean e;
    public com.byazt.ob.pr er;
    public final AtomicBoolean ls;
    public final AtomicBoolean n;
    public final AtomicLong nl;
    public final AtomicBoolean s;
    public final com.byazt.ga.hw v;
    public long ww;
    public final int y;

    public zo(TTBaseVideoActivity tTBaseVideoActivity, of ofVar) {
        super(tTBaseVideoActivity, ofVar);
        this.y = 4;
        this.ww = 4L;
        this.n = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.s = new AtomicBoolean(false);
        this.ls = new AtomicBoolean(false);
        this.nl = new AtomicLong();
        this.v = new com.byazt.ga.hw() { // from class: com.byazt.lu.zo.1
            @Override // com.byazt.ga.hw
            public boolean pr() {
                if (zo.this.s.get() || l.hw(zo.this.hw)) {
                    zo.this.iy();
                    return true;
                }
                return false;
            }

            @Override // com.byazt.ga.hw
            public void hw() {
                zo.this.s.set(false);
                zo.this.aj.c(8);
                if (!zo.this.fw()) {
                    zo.this.pr.of();
                }
                zo.this.pr.rc();
            }

            @Override // com.byazt.ga.hw
            public void pr(long j, long j2) {
                zo.this.qa.hw(j);
                zo.this.cz();
                zo.this.nl.set(j);
            }

            @Override // com.byazt.ga.hw
            public void hn() {
                zo.this.e();
                zo.this.ls.set(true);
                zo.this.pr.m();
            }

            @Override // com.byazt.ga.hw
            public boolean x() {
                return zo.this.ls.get();
            }

            @Override // com.byazt.ga.hw
            public long c() {
                return zo.this.nl.get();
            }

            @Override // com.byazt.ga.hw
            public boolean uc() {
                return zo.this.cz.uc();
            }

            @Override // com.byazt.ga.hw
            public Map<String, Object> fw() {
                HashMap map = new HashMap();
                map.put("refer", "in_video");
                return map;
            }

            @Override // com.byazt.ga.hw
            public void zo() {
                zo.this.cr();
            }

            @Override // com.byazt.ga.hw
            public void aj() {
                zo.this.pr.of();
            }

            @Override // com.byazt.ga.hw
            public void vk() {
                if (zo.this.pr != null) {
                    zo.this.pr.k();
                }
            }

            @Override // com.byazt.ga.hw
            public int w() {
                if (zo.this.s.get()) {
                    return 1;
                }
                return 2;
            }
        };
    }

    public static boolean pr(of ofVar) {
        return l.pr(ofVar);
    }

    public void aa() {
        if (this.e.get()) {
        }
        int iGz = (int) this.qa.gz();
        int iA = (int) this.qa.a();
        switch (l.hn(this.hw)) {
            case 1:
                pr(l.x(this.hw), iA, 1000 * ((long) this.gz.c()), false);
                break;
            case 2:
                pr((int) (iA * 0.001f * 0.01f * l.x(this.hw)), iA, iGz, false);
                break;
            case 3:
                pr(er(), iA, iGz, true);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iy() {
        this.aj.c(0);
        this.pr.qn();
        this.er.hn();
        this.pr.fo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr() {
        this.n.set(false);
    }

    private void pr(int i, long j, long j2, boolean z) {
        if (z) {
            if (i <= 3) {
                j();
            }
        } else if (i > 0) {
            long j3 = ((long) i) * 1000;
            if (j3 > j) {
                return;
            }
            long j4 = j3 - j2;
            if (j4 > 0 && Math.abs(j4) <= 3200) {
                j();
            }
        }
    }

    private void j() {
        this.e.set(true);
        this.er.pr();
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
        return true;
    }

    @Override // com.byazt.lu.hw
    public boolean vj() {
        return true;
    }

    @Override // com.byazt.lu.hw
    public void pq() {
        this.aj.c(8);
        this.aj.uc(0);
        this.lb.c(true);
        this.lb.hn(true);
        this.lb.hw(true);
        this.lb.pr(true);
        this.pr.r();
    }

    @Override // com.byazt.lu.hw
    public void jw() {
        if (this.fo != null) {
            ((com.byazt.dl.pr) this.fo.pr(com.byazt.dl.pr.class)).pr(this.v);
            ((com.byazt.yx.pr) this.fo.pr(com.byazt.yx.pr.class)).pr(this.v);
        }
        if (this.zo != null) {
            ((com.byazt.dl.pr) this.zo.pr(com.byazt.dl.pr.class)).pr(this.v);
            ((com.byazt.yx.pr) this.zo.pr(com.byazt.yx.pr.class)).pr(this.v);
        }
        com.byazt.ob.pr prVar = new com.byazt.ob.pr(this.pr, this.hw, this.v);
        this.er = prVar;
        prVar.pr(this.pr.e().getSceneFrameContainer(), this.pr.e().getSceneFrame());
        this.n.set(l.hn(this.hw) != 0);
        if (this.n.get()) {
            this.nt = true;
        }
    }

    @Override // com.byazt.lu.pr
    public int y() {
        return hw(this.hw);
    }

    public static int hw(of ofVar) {
        return 10;
    }

    @Override // com.byazt.lu.hw
    public void d() {
        qo();
        if (!jn.yb(this.hw)) {
            return;
        }
        this.pr.hn(0);
        if (b() > of() || this.ho) {
            com.byazt.hb.uc.pr = 0;
        }
        hw(uc(true));
        com.byazt.hb.uc.pr = qi();
    }

    private void qo() {
        if (!this.n.get()) {
            return;
        }
        aa();
        bh();
    }

    private void bh() {
        if (!this.e.get()) {
            return;
        }
        long j = this.ww - 1;
        this.ww = j;
        if (j != 0) {
            if (j > 0) {
                this.er.pr(j);
            }
        } else {
            this.er.pr(j);
            this.s.set(true);
            if (fw()) {
                this.er.pr(this.fo);
            } else {
                this.er.pr(this.zo);
            }
        }
    }

    @Override // com.byazt.lu.pr
    public void cz() {
        super.cz();
        this.nt = false;
        boolean z = ((int) (this.qa.gz() / 1000)) >= this.gz.hn() || this.pr.ie();
        if (this.qa.y()) {
            this.lb.pr(false, null, "跳过", false, true);
            return;
        }
        int iVe = this.qa.ve();
        if (!this.qa.pr()) {
            this.lb.pr(false, iVe + an.aB, z ? "跳过" : "", false, z);
        }
    }

    @Override // com.byazt.lu.pr
    public void e() {
        super.e();
        this.lb.pr(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.byazt.lu.pr
    public void z() {
        super.z();
        this.lb.pr(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.byazt.lu.hw
    public boolean sv() {
        return true;
    }

    @Override // com.byazt.lu.hw
    public boolean gu() {
        return jn.yb(this.hw);
    }

    @Override // com.byazt.lu.pr
    public com.byazt.ga.hw s() {
        return this.v;
    }
}
