package com.byazt.jt;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.ca.ny;
import com.byazt.rk.vk;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1672})
public class ShakeAnimationView extends LinearLayout {
    public LinearLayout aj;
    public ny c;
    public TextView fw;
    public TextView hn;
    public TextView hw;
    public int pr;
    public TextView uc;
    public vk vk;
    public boolean w;
    public ImageView x;
    public pr zo;

    public interface pr {
        void pr(boolean z);
    }

    public ShakeAnimationView(Context context, View view, vk vkVar, boolean z, int i) {
        super(context);
        this.w = true;
        this.vk = vkVar;
        this.w = z;
        this.pr = i;
        pr(context, view);
    }

    public void pr(Context context, View view) {
        addView(view);
        this.aj = (LinearLayout) findViewById(2097610727);
        this.x = (ImageView) findViewById(2097610725);
        this.hw = (TextView) findViewById(2097610724);
        this.hn = (TextView) findViewById(2097610726);
        this.uc = (TextView) findViewById(2097610723);
        this.fw = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.aj.setBackground(gradientDrawable);
    }

    public void setShakeText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.uc.setVisibility(8);
            this.fw.setVisibility(8);
        } else {
            this.uc.setText(str);
        }
    }

    public LinearLayout getShakeLayout() {
        return this.aj;
    }

    public void setOnShakeViewListener(pr prVar) {
        this.zo = prVar;
    }

    public void pr() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }

    /* JADX INFO: renamed from: com.byazt.jt.ShakeAnimationView$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 86, 1404})
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ShakeAnimationView.this.x != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new hw(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.jt.ShakeAnimationView.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ShakeAnimationView.this.postDelayed(new Runnable() { // from class: com.byazt.jt.ShakeAnimationView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ShakeAnimationView.this.x.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                ShakeAnimationView.this.x.startAnimation(rotateAnimation);
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 86, 707})
    private static class hw implements Interpolator {
        private hw() {
        }

        public /* synthetic */ hw(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.25f) {
                return (f * (-2.0f)) + 0.5f;
            }
            if (f <= 0.5f) {
                return (f * 4.0f) - 1.0f;
            }
            if (f <= 0.75f) {
                return (f * (-4.0f)) + 3.0f;
            }
            return (f * 2.0f) - 1.5f;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.c == null) {
                this.c = new ny(getContext().getApplicationContext(), 1, this.w);
            }
            this.c.pr(new ny.pr() { // from class: com.byazt.jt.ShakeAnimationView.2
                @Override // com.byazt.ca.ny.pr
                public void pr(int i) {
                    boolean zPr;
                    if (ShakeAnimationView.this.c != null) {
                        zPr = ShakeAnimationView.this.c.pr();
                    } else {
                        zPr = false;
                    }
                    if (i == 1 && ShakeAnimationView.this.isShown() && ShakeAnimationView.this.zo != null) {
                        ShakeAnimationView.this.zo.pr(zPr);
                    }
                }
            });
            vk vkVar = this.vk;
            if (vkVar != null) {
                this.c.pr(vkVar.pr());
                this.c.hn(this.vk.fw());
                this.c.hn(this.vk.hw());
                this.c.c(this.vk.x());
                this.c.hw(this.vk.hn());
                this.c.uc(this.vk.c());
                this.c.pr(this.vk.uc());
                this.c.hw(this.vk.zo());
                this.c.pr(this.pr);
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ny nyVar = this.c;
        if (nyVar != null) {
            if (z) {
                nyVar.pr(this.pr);
            } else {
                nyVar.hw(this.pr);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ny nyVar = this.c;
        if (nyVar != null) {
            nyVar.hw(this.pr);
        }
    }
}
