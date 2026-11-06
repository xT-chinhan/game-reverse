package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
class ms extends FrameLayout {
    protected com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ab;
    protected NativeExpressView ah;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.ms c;
    protected String ch;
    protected lm d;
    protected com.bytedance.sdk.openadsdk.ao.xr.ah.xr ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final Context f2014ms;
    protected boolean ny;
    protected int x;
    protected NativeExpressView xr;

    public ms(Context context, lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        super(context);
        this.ch = "banner_ad";
        this.f2014ms = context;
        this.d = lmVar;
        this.ka = xrVar;
        ms();
    }

    protected void ms() {
        NativeExpressView nativeExpressView = new NativeExpressView(this.f2014ms, this.d, this.ka, this.ch);
        this.xr = nativeExpressView;
        addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void ms(lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(this.f2014ms, lmVar, xrVar, this.ch);
        this.ah = nativeExpressView;
        nativeExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.ms() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.ms.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
            public void ms(View view, int i) {
                if (ms.this.c != null) {
                    ms.this.c.ms(ms.this, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
            public void ms(View view, float f, float f2) {
                ms.this.ms(f, f2);
                ms.this.c();
            }
        });
        ul.ms((View) this.ah, 8);
        addView(this.ah, new ViewGroup.LayoutParams(-1, -1));
    }

    public void setVideoAdListener(com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ahVar) {
        this.ab = ahVar;
    }

    public void setExpressInteractionListener(com.bytedance.sdk.openadsdk.core.nativeexpress.ms msVar) {
        this.c = msVar;
        NativeExpressView nativeExpressView = this.xr;
        if (nativeExpressView != null) {
            nativeExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.ms() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.ms.2
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
                public void ms(View view, int i) {
                    if (ms.this.c != null) {
                        ms.this.c.ms(ms.this, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
                public void ms(View view, String str, int i) {
                    if (ms.this.c != null) {
                        ms.this.c.ms(ms.this, str, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ms
                public void ms(View view, float f, float f2) {
                    if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).nw()) {
                        ms.this.ms(f, f2);
                    }
                    if (ms.this.c != null) {
                        ms.this.c.ms(ms.this, f, f2);
                    }
                }
            });
        }
    }

    protected void ms(float f, float f2) {
        int iAh = ul.ah(this.f2014ms, f);
        int iAh2 = ul.ah(this.f2014ms, f2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(iAh, iAh2);
        }
        layoutParams.width = iAh;
        layoutParams.height = iAh2;
        setLayoutParams(layoutParams);
    }

    public void ka() {
        NativeExpressView nativeExpressView = this.xr;
        if (nativeExpressView != null) {
            nativeExpressView.h();
        }
    }

    public void d() {
        NativeExpressView nativeExpressView = this.xr;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.xr.zb();
            this.xr = null;
        }
        NativeExpressView nativeExpressView2 = this.ah;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.ah.zb();
            this.ah = null;
        }
    }

    public NativeExpressView getCurView() {
        return this.xr;
    }

    public NativeExpressView getNextView() {
        return this.ah;
    }

    public void setDuration(int i) {
        this.x = i;
    }

    private ObjectAnimator ms(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, -getWidth());
    }

    private ObjectAnimator xr(NativeExpressView nativeExpressView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), 0.0f);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.ms.3
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
                ms.this.ny = false;
            }
        });
        return objectAnimatorOfFloat;
    }

    public void ah() {
        NativeExpressView nativeExpressView = this.ah;
        if (nativeExpressView != null) {
            nativeExpressView.h();
        }
    }

    protected void c() {
        if (this.ny || this.ah == null || this.xr == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ms(this.xr)).with(xr(this.ah));
        animatorSet.setDuration(this.x).start();
        ul.ms((View) this.ah, 0);
        this.ny = true;
        NativeExpressView nativeExpressView = this.xr;
        this.xr = this.ah;
        this.ah = nativeExpressView;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.ah.zb();
            this.ah = null;
        }
    }

    public boolean xr() {
        return this.ah != null;
    }
}
