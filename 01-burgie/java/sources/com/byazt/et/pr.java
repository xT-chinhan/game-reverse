package com.byazt.et;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.hg.of;
import com.byazt.qx.NativeExpressView;
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 51, 37})
public class pr extends FrameLayout {
    public boolean aj;
    public com.byazt.qe.hw c;
    public com.byazt.qh.hn fw;
    public NativeExpressView hn;
    public NativeExpressView hw;
    public final Context pr;
    public com.byazt.qx.pr uc;
    public String vk;
    public of x;
    public int zo;

    public pr(Context context, of ofVar, com.byazt.qe.hw hwVar) {
        super(context);
        this.vk = com.byazt.pfl.hw.AD_TAG_BANNER;
        this.pr = context;
        this.x = ofVar;
        this.c = hwVar;
        pr();
    }

    public void pr() {
        NativeExpressView nativeExpressView = new NativeExpressView(this.pr, this.x, this.c, this.vk);
        this.hw = nativeExpressView;
        addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void pr(of ofVar, com.byazt.qe.hw hwVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(this.pr, ofVar, hwVar, this.vk);
        this.hn = nativeExpressView;
        nativeExpressView.setExpressInteractionListener(new com.byazt.qx.pr() { // from class: com.byazt.et.pr.1
            @Override // com.byazt.qx.pr
            public void pr(View view, int i) {
                if (pr.this.uc != null) {
                    pr.this.uc.pr(pr.this, i);
                }
            }

            @Override // com.byazt.qx.pr
            public void pr(View view, float f, float f2) {
                pr.this.pr(f, f2);
                pr.this.uc();
            }
        });
        er.pr((View) this.hn, 8);
        addView(this.hn, new ViewGroup.LayoutParams(-1, -1));
    }

    public void setVideoAdListener(com.byazt.qh.hn hnVar) {
        this.fw = hnVar;
    }

    public void setExpressInteractionListener(com.byazt.qx.pr prVar) {
        this.uc = prVar;
        NativeExpressView nativeExpressView = this.hw;
        if (nativeExpressView != null) {
            nativeExpressView.setExpressInteractionListener(new com.byazt.qx.pr() { // from class: com.byazt.et.pr.2
                @Override // com.byazt.qx.pr
                public void pr(View view, int i) {
                    if (pr.this.uc != null) {
                        pr.this.uc.pr(pr.this, i);
                    }
                }

                @Override // com.byazt.qx.pr
                public void pr(View view, String str, int i) {
                    if (pr.this.uc != null) {
                        pr.this.uc.pr(pr.this, str, i);
                    }
                }

                @Override // com.byazt.qx.pr
                public void pr(View view, float f, float f2) {
                    if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).cz()) {
                        pr.this.pr(f, f2);
                    }
                    if (pr.this.uc != null) {
                        pr.this.uc.pr(pr.this, f, f2);
                    }
                }
            });
        }
    }

    public void pr(float f, float f2) {
        int iHn = er.hn(this.pr, f);
        int iHn2 = er.hn(this.pr, f2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(iHn, iHn2);
        }
        layoutParams.width = iHn;
        layoutParams.height = iHn2;
        setLayoutParams(layoutParams);
    }

    public void c() {
        NativeExpressView nativeExpressView = this.hw;
        if (nativeExpressView != null) {
            nativeExpressView.nt();
        }
    }

    public void x() {
        NativeExpressView nativeExpressView = this.hw;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.hw.k();
            this.hw = null;
        }
        NativeExpressView nativeExpressView2 = this.hn;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.hn.k();
            this.hn = null;
        }
    }

    public NativeExpressView getCurView() {
        return this.hw;
    }

    public NativeExpressView getNextView() {
        return this.hn;
    }

    public void setDuration(int i) {
        this.zo = i;
    }

    private ObjectAnimator pr(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, -getWidth());
    }

    private ObjectAnimator hw(NativeExpressView nativeExpressView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), 0.0f);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.et.pr.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                pr.this.aj = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        return objectAnimatorOfFloat;
    }

    public void hn() {
        NativeExpressView nativeExpressView = this.hn;
        if (nativeExpressView != null) {
            nativeExpressView.nt();
        }
    }

    public void uc() {
        if (!this.aj && this.hn != null && this.hw != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(pr(this.hw)).with(hw(this.hn));
            animatorSet.setDuration(this.zo).start();
            er.pr((View) this.hn, 0);
            this.aj = true;
            NativeExpressView nativeExpressView = this.hw;
            this.hw = this.hn;
            this.hn = nativeExpressView;
            if (nativeExpressView != null) {
                removeView(nativeExpressView);
                this.hn.k();
                this.hn = null;
            }
        }
    }

    public boolean hw() {
        return this.hn != null;
    }
}
