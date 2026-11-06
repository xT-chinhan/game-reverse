package com.byazt.sb;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.byazt.ca.iu;
import com.byazt.hg.lb;
import com.byazt.hg.nw;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.n.uc;
import com.byazt.vkw.qi;
import com.byazt.wt.er;
import com.byazt.zp.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 765, 37})
public class pr implements qi.pr {
    public final int c;
    public PlayableVideoContainer fw;
    public final com.byazt.ga.hw g;
    public final of hn;
    public final Context hw;
    public final String pr;
    public FrameLayout uc;
    public boolean w;
    public hn zo;
    public final iu x = new iu(Looper.getMainLooper(), this);
    public boolean aj = false;
    public boolean vk = true;
    public boolean k = false;
    public boolean m = false;

    public pr(String str, Activity activity, of ofVar, int i, com.byazt.ga.hw hwVar, FrameLayout frameLayout) {
        this.pr = str;
        this.hw = activity;
        this.hn = ofVar;
        this.c = i;
        if (!lb.x(ofVar)) {
            this.uc = frameLayout;
        }
        c();
        this.g = hwVar;
    }

    private void c() {
        if (this.uc == null) {
            return;
        }
        if (nw.hw(this.hn) == 1) {
            PlayableVideoContainer playableVideoContainer = new PlayableVideoContainer(this.hw);
            playableVideoContainer.setBackgroundColor(0);
            playableVideoContainer.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(er.hn(this.hw, 156.0f), er.hn(this.hw, 87.0f));
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = er.hn(this.hw, 55.0f);
            layoutParams.rightMargin = er.hn(this.hw, 20.0f);
            this.uc.addView(playableVideoContainer, layoutParams);
            this.fw = playableVideoContainer;
            return;
        }
        PlayableVideoContainer playableVideoContainer2 = new PlayableVideoContainer(this.hw);
        playableVideoContainer2.setBackgroundColor(0);
        playableVideoContainer2.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(er.hn(this.hw, 73.0f), er.hn(this.hw, 130.0f));
        layoutParams2.gravity = 8388661;
        layoutParams2.topMargin = er.hn(this.hw, 55.0f);
        layoutParams2.rightMargin = er.hn(this.hw, 30.0f);
        this.uc.addView(playableVideoContainer2, layoutParams2);
        this.fw = playableVideoContainer2;
    }

    public void pr(long j, boolean z) {
        PlayableVideoContainer playableVideoContainer;
        this.m = true;
        this.vk = z;
        pr(j);
        if (!this.aj) {
            return;
        }
        if (this.g != null && (playableVideoContainer = this.fw) != null) {
            playableVideoContainer.postDelayed(new Runnable() { // from class: com.byazt.sb.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.vk();
                }
            }, 500L);
            this.fw.setCustomClickListener(new View.OnClickListener() { // from class: com.byazt.sb.pr.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (pr.this.uc != null) {
                        pr.this.pr();
                        pr.this.g.hw();
                    }
                }
            });
        } else if (k.pr(this.hn)) {
            uc();
        } else {
            fw();
        }
    }

    public void pr() {
        this.m = false;
        x();
        uc();
    }

    private void uc() {
        er.pr((View) this.uc, 8);
        er.pr((View) this.fw, 8);
    }

    private void fw() {
        er.pr((View) this.uc, 0);
        er.pr((View) this.fw, 0);
    }

    private void pr(long j) {
        if (this.fw == null) {
            return;
        }
        if (this.g == null && !k.pr(this.hn)) {
            return;
        }
        if (this.aj) {
            hn hnVar = this.zo;
            if (hnVar != null) {
                hnVar.hw(j);
                this.zo.pr(j);
                return;
            }
            return;
        }
        this.aj = true;
        uc ucVarPr = qv.pr(1, this.hn);
        ucVarPr.hw(this.hn.x());
        ucVarPr.hw(this.fw.getWidth());
        ucVarPr.hn(this.fw.getHeight());
        ucVarPr.hn(this.hn.B_());
        ucVarPr.pr(j);
        ucVarPr.hw(this.vk);
        if (k.pr(this.hn)) {
            ucVarPr.pr(true);
        }
        hn hnVar2 = new hn(this.hw, this.fw.getVideoContainer(), this.hn, null);
        this.zo = hnVar2;
        hnVar2.pr(new com.byazt.ga.pr.InterfaceC0074pr() { // from class: com.byazt.sb.pr.3
            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void pr() {
                if (pr.this.g == null) {
                    if (k.pr(pr.this.hn) && pr.this.zo != null && !pr.this.zo.c()) {
                        pr.this.pr();
                        return;
                    }
                    return;
                }
                pr.this.pr();
                pr.this.g.hn();
            }

            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void pr(int i, String str) {
                if (i != 308) {
                    pr.this.fw.pr(true);
                }
            }

            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void hw() {
                pr.this.fw.pr(true);
                if (pr.this.g != null) {
                    pr.this.g.vk();
                }
            }

            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void pr(long j2, long j3) {
                pr.this.fw.pr(false);
                if (pr.this.g != null) {
                    pr.this.g.pr(j2, j3);
                }
            }

            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void hn() {
                pr.this.zo();
            }
        });
        this.zo.hw(j);
        this.zo.pr(ucVarPr);
        if (this.g != null) {
            this.zo.rc();
            this.zo.fw(false);
            this.fw.pr();
        } else {
            if (k.pr(this.hn)) {
                this.zo.fw(true);
            }
            aj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zo() {
        this.k = true;
        if (this.w) {
            this.w = false;
            hw();
        }
        pr(this.vk);
    }

    public void hw() {
        if (!this.m || !this.aj || this.zo == null) {
            return;
        }
        this.x.removeMessages(1);
        if (this.k) {
            this.zo.uc();
        } else {
            this.w = true;
        }
    }

    public void hn() {
        if (!this.m || !this.aj || this.zo == null) {
            return;
        }
        this.w = false;
        this.x.sendEmptyMessageDelayed(1, 2000L);
        if (!this.zo.r()) {
            this.zo.zo();
        }
    }

    public void x() {
        hn hnVar = this.zo;
        if (hnVar == null) {
            return;
        }
        hnVar.vk();
        this.zo = null;
        this.aj = false;
        this.w = false;
        this.k = false;
    }

    public void pr(boolean z) {
        hn hnVar = this.zo;
        if (hnVar == null) {
            return;
        }
        this.vk = z;
        hnVar.hw(z);
    }

    private void aj() {
        PlayableVideoContainer playableVideoContainer = this.fw;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.hw(true);
        this.x.sendEmptyMessageDelayed(1, 2000L);
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        PlayableVideoContainer playableVideoContainer = this.fw;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.hw(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vk() {
        if (this.fw == null || this.uc == null) {
            return;
        }
        fw();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.fw, "translationX", -er.hn(this.hw, 150.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.fw, "translationY", -er.hn(this.hw, 100.0f), 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.fw, "alpha", 0.1f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(500L);
        animatorSet.start();
    }
}
