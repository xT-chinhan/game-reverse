package com.byazt.za;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 5})
public class q extends FrameLayout {
    public int fs;
    public com.byazt.zq.qg l;
    public final Context n;
    public pk q;
    public NativeExpressView qg;
    public boolean rv;
    public NativeExpressView s;
    public String tj;
    public n w;
    public com.byazt.fx.s x;

    public q(Context context, pk pkVar, com.byazt.zq.qg qgVar) {
        super(context);
        this.tj = com.byazt.wg.qg.AD_TAG_BANNER;
        this.n = context;
        this.q = pkVar;
        this.l = qgVar;
        n();
    }

    public void n() {
        NativeExpressView nativeExpressView = new NativeExpressView(this.n, this.q, this.l, this.tj);
        this.qg = nativeExpressView;
        addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void n(pk pkVar, com.byazt.zq.qg qgVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(this.n, pkVar, qgVar, this.tj);
        this.s = nativeExpressView;
        nativeExpressView.setExpressInteractionListener(new n() { // from class: com.byazt.za.q.1
            @Override // com.byazt.za.n
            public void n(View view, int i) {
                if (q.this.w != null) {
                    q.this.w.n(q.this, i);
                }
            }

            @Override // com.byazt.za.n
            public void n(View view, float f, float f2) {
                q.this.n(f, f2);
                q.this.w();
            }
        });
        com.byazt.okk.s.n((View) this.s, 8);
        addView(this.s, new ViewGroup.LayoutParams(-1, -1));
    }

    public void setVideoAdListener(com.byazt.fx.s sVar) {
        this.x = sVar;
    }

    public void setExpressInteractionListener(n nVar) {
        this.w = nVar;
        NativeExpressView nativeExpressView = this.qg;
        if (nativeExpressView != null) {
            nativeExpressView.setExpressInteractionListener(new n() { // from class: com.byazt.za.q.2
                @Override // com.byazt.za.n
                public void n(View view, int i) {
                    if (q.this.w != null) {
                        q.this.w.n(q.this, i);
                    }
                }

                @Override // com.byazt.za.n
                public void n(View view, String str, int i) {
                    if (q.this.w != null) {
                        q.this.w.n(q.this, str, i);
                    }
                }

                @Override // com.byazt.za.n
                public void n(View view, float f, float f2) {
                    if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).py()) {
                        q.this.n(f, f2);
                    }
                    if (q.this.w != null) {
                        q.this.w.n(q.this, f, f2);
                    }
                }
            });
        }
    }

    public void n(float f, float f2) {
        int iS = com.byazt.okk.s.s(this.n, f);
        int iS2 = com.byazt.okk.s.s(this.n, f2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(iS, iS2);
        }
        layoutParams.width = iS;
        layoutParams.height = iS2;
        setLayoutParams(layoutParams);
    }

    public void l() {
        NativeExpressView nativeExpressView = this.qg;
        if (nativeExpressView != null) {
            nativeExpressView.cy();
        }
    }

    public void q() {
        NativeExpressView nativeExpressView = this.qg;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.qg.oa();
            this.qg = null;
        }
        NativeExpressView nativeExpressView2 = this.s;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.s.oa();
            this.s = null;
        }
    }

    public NativeExpressView getCurView() {
        return this.qg;
    }

    public NativeExpressView getNextView() {
        return this.s;
    }

    public void setDuration(int i) {
        this.fs = i;
    }

    private ObjectAnimator n(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, -getWidth());
    }

    private ObjectAnimator qg(NativeExpressView nativeExpressView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), 0.0f);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.za.q.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                q.this.rv = false;
            }
        });
        return objectAnimatorOfFloat;
    }

    public void s() {
        NativeExpressView nativeExpressView = this.s;
        if (nativeExpressView != null) {
            nativeExpressView.cy();
        }
    }

    public void w() {
        if (this.rv || this.s == null || this.qg == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(n(this.qg)).with(qg(this.s));
        animatorSet.setDuration(this.fs).start();
        com.byazt.okk.s.n((View) this.s, 0);
        this.rv = true;
        NativeExpressView nativeExpressView = this.qg;
        this.qg = this.s;
        this.s = nativeExpressView;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.s.oa();
            this.s = null;
        }
    }

    public boolean qg() {
        return this.s != null;
    }
}
