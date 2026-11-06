package com.bytedance.sdk.component.adexpress.widget;

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
import com.bytedance.sdk.component.adexpress.dynamic.ah.ch;
import com.bytedance.sdk.component.utils.b;

/* JADX INFO: loaded from: classes2.dex */
public class ShakeAnimationView extends LinearLayout {
    private TextView ab;
    private TextView ah;
    private TextView c;
    private ch ch;
    private ImageView d;
    private boolean hi;
    private b ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public int f966ms;
    private LinearLayout ny;
    private ms x;
    private TextView xr;

    public interface ms {
        void ms(boolean z);
    }

    public ShakeAnimationView(Context context, View view, ch chVar, boolean z, int i) {
        super(context);
        this.ch = chVar;
        this.hi = z;
        this.f966ms = i;
        ms(context, view);
    }

    protected void ms(Context context, View view) {
        addView(view);
        this.ny = (LinearLayout) findViewById(2097610727);
        this.d = (ImageView) findViewById(2097610725);
        this.xr = (TextView) findViewById(2097610724);
        this.ah = (TextView) findViewById(2097610726);
        this.c = (TextView) findViewById(2097610723);
        this.ab = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.ny.setBackground(gradientDrawable);
    }

    public void setShakeText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.c.setVisibility(8);
            this.ab.setVisibility(8);
        } else {
            this.c.setText(str);
        }
    }

    public LinearLayout getShakeLayout() {
        return this.ny;
    }

    public void setOnShakeViewListener(ms msVar) {
        this.x = msVar;
    }

    public void ms() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ShakeAnimationView.this.d != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new xr(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ShakeAnimationView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ShakeAnimationView.this.d.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }
                });
                ShakeAnimationView.this.d.startAnimation(rotateAnimation);
            }
        }
    }

    private static class xr implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.25f) {
                return (f * (-2.0f)) + 0.5f;
            }
            if (f <= 0.5f) {
                return (f * 4.0f) - 1.0f;
            }
            return f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }

        private xr() {
        }

        /* synthetic */ xr(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.ka == null) {
                this.ka = new b(getContext().getApplicationContext(), 1, this.hi);
            }
            this.ka.ms(new b.ms() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.2
                @Override // com.bytedance.sdk.component.utils.b.ms
                public void ms(int i) {
                    boolean zMs = ShakeAnimationView.this.ka != null ? ShakeAnimationView.this.ka.ms() : false;
                    if (i == 1 && ShakeAnimationView.this.isShown() && ShakeAnimationView.this.x != null) {
                        ShakeAnimationView.this.x.ms(zMs);
                    }
                }
            });
            ch chVar = this.ch;
            if (chVar != null) {
                this.ka.ms(chVar.ms());
                this.ka.ah(this.ch.ab());
                this.ka.ah(this.ch.xr());
                this.ka.ka(this.ch.d());
                this.ka.xr(this.ch.ah());
                this.ka.c(this.ch.ka());
                this.ka.ms(this.ch.c());
                this.ka.xr(this.ch.x());
                this.ka.ms(this.f966ms);
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        b bVar = this.ka;
        if (bVar != null) {
            if (z) {
                bVar.ms(this.f966ms);
            } else {
                bVar.xr(this.f966ms);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.ka;
        if (bVar != null) {
            bVar.xr(this.f966ms);
        }
    }
}
