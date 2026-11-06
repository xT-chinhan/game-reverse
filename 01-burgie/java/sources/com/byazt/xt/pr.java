package com.byazt.xt;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.ar.RewardLpBottomView;
import com.byazt.ca.g;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.ea.w;
import com.byazt.hg.of;
import com.byazt.pg.PlayableEndcardFrameLayout;
import com.byazt.sd.lb;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 37})
public class pr extends hw {
    public String a;
    public RewardLpBottomView cz;
    public AtomicBoolean fo;
    public com.byazt.qk.pr g;
    public com.byazt.pj.x ho;
    public com.byazt.ze.hw lb;
    public com.byazt.ze.x nt;
    public AtomicBoolean ny;
    public AtomicBoolean qa;
    public com.byazt.ax.c rc;
    public com.byazt.sr.pr yb;
    public boolean z;

    public pr(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, boolean z, com.byazt.pj.x xVar, com.byazt.ax.c cVar) {
        super(tTBaseVideoActivity, ofVar, z);
        this.g = ofVar.mw();
        this.ho = xVar;
        this.hw.fw(0);
        this.qa = new AtomicBoolean();
        this.ny = new AtomicBoolean();
        this.fo = new AtomicBoolean();
        this.rc = cVar;
    }

    @Override // com.byazt.xt.hw
    public void pr() {
        super.pr();
        this.a = ls.pr(ls.x(this.pr));
        com.byazt.qk.pr prVar = this.g;
        if (prVar == null) {
            lb.uc().post(new Runnable() { // from class: com.byazt.xt.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.hw.fw(8);
                    pr.this.hw.qa();
                }
            });
        }
        switch (prVar.x()) {
            case 2:
                yb();
                break;
            case 3:
                lb();
                break;
            case 4:
                qa();
                break;
            default:
                this.hw.fw(8);
                this.hw.qa();
                break;
        }
    }

    private void yb() {
        com.byazt.ze.x xVar = new com.byazt.ze.x(this.hw, this.fw, this.ho, this.hn, this.a, ls.x(this.pr));
        this.nt = xVar;
        xVar.hw(true);
        this.nt.pr(new com.byazt.ql.pr() { // from class: com.byazt.xt.pr.2
            @Override // com.byazt.ql.pr
            public void pr(View view) {
                pr.this.hw.fw(8);
                pr.this.qa.set(true);
            }

            @Override // com.byazt.ql.pr
            public void pr(int i) {
                lb.uc().post(new Runnable() { // from class: com.byazt.xt.pr.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pr.this.hw.fw(8);
                        pr.this.hw.qa();
                    }
                });
                pr.this.qa.set(false);
            }
        });
        this.nt.k();
    }

    private void lb() {
        FrameLayout frameLayout = new FrameLayout(this.hw);
        this.fw.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        com.byazt.ze.hw hwVar = new com.byazt.ze.hw(this.hw, frameLayout, this.ho, this.hn, this.a, ls.x(this.pr));
        this.lb = hwVar;
        hwVar.hw(true);
        this.lb.pr(new com.byazt.sa.hw() { // from class: com.byazt.xt.pr.3
            @Override // com.byazt.sa.hw
            public void pr() {
                pr.this.hw.qn();
            }

            @Override // com.byazt.sa.hw
            public void hw() {
                pr.this.hw.of();
                pr.this.ny.set(true);
                pr.this.lb.qa();
            }
        });
        this.lb.pr(new com.byazt.ql.pr() { // from class: com.byazt.xt.pr.4
            @Override // com.byazt.ql.pr
            public void pr(View view) {
                pr.this.hw.fw(8);
                pr.this.qa.set(true);
            }

            @Override // com.byazt.ql.pr
            public void pr(int i) {
                lb.uc().post(new Runnable() { // from class: com.byazt.xt.pr.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pr.this.hw.fw(8);
                        pr.this.lb.nt();
                        pr.this.lb.pr("\"暂无更多内容，奖励已发放\"");
                        pr.this.hw.x(0);
                    }
                });
                pr.this.qa.set(false);
            }
        });
        this.lb.pr(new com.byazt.sa.pr.InterfaceC0182pr() { // from class: com.byazt.xt.pr.5
            @Override // com.byazt.sa.pr.InterfaceC0182pr
            public void pr() {
                lb.uc().post(new Runnable() { // from class: com.byazt.xt.pr.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (pr.this.hw.jn()) {
                            pr.this.lb.pr("\"暂无更多内容，奖励已发放\"");
                        } else {
                            pr.this.lb.pr(String.format("\"暂无更多内容，继续浏览%1$s秒可得奖励\"", Integer.valueOf(pr.this.hw.bm().er())));
                        }
                    }
                });
            }
        });
        this.lb.k();
        com.byazt.sd.zo.nt().hn().hn(new com.byazt.wt.pr.hw() { // from class: com.byazt.xt.pr.6
            @Override // com.byazt.wt.pr.hw
            public void pr() {
            }

            @Override // com.byazt.wt.pr.hw
            public void hw() {
                if (pr.this.ny.get() || !pr.this.lb.m()) {
                    pr.this.fo.set(false);
                } else {
                    pr.this.fo.set(true);
                }
            }

            @Override // com.byazt.wt.pr.hw
            public void hn() {
            }

            @Override // com.byazt.wt.pr.hw
            public void x() {
            }
        });
        if (!TextUtils.equals(this.g.pr(), GlobalSetting.SPLASH_AD)) {
            hw();
        }
    }

    public void hw() {
        final ImageView imageView = new ImageView(this.hw);
        float fHn = er.hn(this.hw, 18.0f);
        float fHn2 = er.hn(this.hw, 20.0f);
        int i = (int) fHn;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 53;
        int i2 = (int) fHn2;
        layoutParams.setMargins(i2, i2, i2, i2);
        this.fw.addView(imageView, layoutParams);
        g.pr((Context) this.hw, "tt_unmute", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.xt.pr.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pr prVar = pr.this;
                prVar.z = !prVar.z;
                g.pr((Context) pr.this.hw, pr.this.z ? "tt_mute" : "tt_unmute", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                pr.this.lb.hn(pr.this.z);
            }
        });
    }

    private void qa() {
        com.byazt.sr.pr prVar = new com.byazt.sr.pr(this.hw, a(), this.g, this.hn);
        this.yb = prVar;
        prVar.pr(this.hw.ii());
        this.yb.pr(new com.byazt.ql.pr() { // from class: com.byazt.xt.pr.8
            @Override // com.byazt.ql.pr
            public void pr(View view) {
                com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.xt.pr.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pr.this.hw.fw(8);
                        pr.this.qa.set(true);
                        if (pr.this.cz != null) {
                            pr.this.cz.pr();
                        }
                    }
                });
            }

            @Override // com.byazt.ql.pr
            public void pr(int i) {
                lb.uc().post(new Runnable() { // from class: com.byazt.xt.pr.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        pr.this.hw.fw(8);
                        pr.this.hw.qa();
                    }
                });
                pr.this.qa.set(false);
            }
        });
        this.yb.pr();
    }

    private ViewGroup a() {
        if (this.fw == null) {
            return null;
        }
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.hw);
        this.fw.addView(playableEndcardFrameLayout);
        this.cz = new RewardLpBottomView(this.hw);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.fw.addView(this.cz, layoutParams);
        this.cz.pr(this.hn, this.a);
        playableEndcardFrameLayout.pr(new PlayableEndcardFrameLayout.pr() { // from class: com.byazt.xt.pr.9
            @Override // com.byazt.pg.PlayableEndcardFrameLayout.pr
            public void pr() {
                if (pr.this.cz != null) {
                    pr.this.cz.hw();
                }
            }
        });
        return playableEndcardFrameLayout;
    }

    public boolean hn() {
        return this.fo.get();
    }

    public void pr(boolean z) {
        this.fo.set(z);
    }

    @Override // com.byazt.xt.hw
    public void pr(com.byazt.az.hw hwVar, com.byazt.az.hw hwVar2) {
        super.pr(hwVar, hwVar2);
        com.byazt.ze.x xVar = this.nt;
        if (xVar != null) {
            xVar.pr(this.hw.ii());
        }
        com.byazt.ze.hw hwVar3 = this.lb;
        if (hwVar3 != null) {
            hwVar3.pr(this.hw.ii());
        }
        com.byazt.sr.pr prVar = this.yb;
        if (prVar != null) {
            prVar.pr(hwVar);
        }
    }

    public boolean x() {
        com.byazt.ze.hw hwVar = this.lb;
        if (hwVar != null) {
            return hwVar.m();
        }
        return false;
    }

    public AtomicInteger c() {
        return new AtomicInteger(0);
    }

    public void pr(int i) {
        if (this.nt != null && w.c(this.hn)) {
            this.nt.c(i);
        }
    }

    public void hw(boolean z) {
        if (this.lb != null && w.x(this.hn)) {
            this.lb.hn(z);
        }
    }

    public boolean uc() {
        return this.qa.get();
    }

    @Override // com.byazt.xt.hw
    public void pr(DownloadListener downloadListener) {
        com.byazt.sr.pr prVar = this.yb;
        if (prVar != null) {
            prVar.pr(downloadListener);
        }
    }

    public void fw() {
        com.byazt.ze.hw hwVar = this.lb;
        if (hwVar != null) {
            hwVar.lb();
        }
    }

    public void zo() {
        com.byazt.ze.hw hwVar = this.lb;
        if (hwVar != null) {
            hwVar.yb();
        }
    }

    public void aj() {
        com.byazt.ze.hw hwVar = this.lb;
        if (hwVar != null) {
            hwVar.a();
        }
    }

    @Override // com.byazt.xt.hw
    public void vk() {
        com.byazt.sr.pr prVar = this.yb;
        if (prVar != null) {
            prVar.hw();
        }
        com.byazt.ze.hw hwVar = this.lb;
        if (hwVar != null) {
            hwVar.ho();
        }
        RewardLpBottomView rewardLpBottomView = this.cz;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.hw();
        }
    }
}
