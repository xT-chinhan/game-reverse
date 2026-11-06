package com.anythink.basead.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.anythink.basead.d.i;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.y;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseShakeView extends LinearLayout {
    protected ImageView a;
    protected ImageView b;
    ValueAnimator c;
    protected int d;
    protected String e;
    protected String f;
    protected String g;
    protected String h;
    protected Bitmap i;
    protected int j;
    protected a k;
    private int l;
    private i m;

    public interface a {
        boolean a();
    }

    abstract void a();

    static /* synthetic */ int a(BaseShakeView baseShakeView) {
        int i = baseShakeView.l;
        baseShakeView.l = i + 1;
        return i;
    }

    public BaseShakeView(Context context) {
        super(context);
        this.l = 0;
        this.m = new i() { // from class: com.anythink.basead.ui.BaseShakeView.1
            @Override // com.anythink.basead.d.i
            public final boolean a() {
                if (BaseShakeView.this.hasWindowFocus() && BaseShakeView.this.isShown() && BaseShakeView.this.k != null) {
                    return BaseShakeView.this.k.a();
                }
                return false;
            }
        };
        a();
    }

    public BaseShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 0;
        this.m = new i() { // from class: com.anythink.basead.ui.BaseShakeView.1
            @Override // com.anythink.basead.d.i
            public final boolean a() {
                if (BaseShakeView.this.hasWindowFocus() && BaseShakeView.this.isShown() && BaseShakeView.this.k != null) {
                    return BaseShakeView.this.k.a();
                }
                return false;
            }
        };
        a();
    }

    public BaseShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = 0;
        this.m = new i() { // from class: com.anythink.basead.ui.BaseShakeView.1
            @Override // com.anythink.basead.d.i
            public final boolean a() {
                if (BaseShakeView.this.hasWindowFocus() && BaseShakeView.this.isShown() && BaseShakeView.this.k != null) {
                    return BaseShakeView.this.k.a();
                }
                return false;
            }
        };
        a();
    }

    public BaseShakeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.l = 0;
        this.m = new i() { // from class: com.anythink.basead.ui.BaseShakeView.1
            @Override // com.anythink.basead.d.i
            public final boolean a() {
                if (BaseShakeView.this.hasWindowFocus() && BaseShakeView.this.isShown() && BaseShakeView.this.k != null) {
                    return BaseShakeView.this.k.a();
                }
                return false;
            }
        };
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startShakeIconAnimation();
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        c();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            b();
        } else {
            c();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (z) {
            b();
        } else {
            c();
        }
    }

    public void startShakeIconAnimation() {
        ValueAnimator valueAnimatorOfFloat;
        if (this.a != null) {
            ValueAnimator valueAnimator = this.c;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            int i = this.d;
            if (i == 1) {
                valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, -25.0f, 0.0f, 25.0f, 0.0f);
                valueAnimatorOfFloat.setDuration(500L);
                valueAnimatorOfFloat.setRepeatCount(-1);
                valueAnimatorOfFloat.addUpdateListener(new AnonymousClass10());
                valueAnimatorOfFloat.addListener(new AnonymousClass11());
                valueAnimatorOfFloat.setInterpolator(new AnonymousClass12());
                this.a.post(new AnonymousClass13());
            } else if (i == 2) {
                int iA = q.a(getContext(), 8.0f);
                float f = iA;
                int i2 = -iA;
                float f2 = i2;
                valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, f, f2, f, f2, iA / 2, i2 / 2, iA / 4, i2 / 4, 0.0f);
                valueAnimatorOfFloat.setDuration(1000L);
                valueAnimatorOfFloat.setRepeatCount(-1);
                valueAnimatorOfFloat.addUpdateListener(new AnonymousClass7());
                valueAnimatorOfFloat.addListener(new AnonymousClass8());
                valueAnimatorOfFloat.setInterpolator(new AnonymousClass9());
            } else {
                valueAnimatorOfFloat = ValueAnimator.ofFloat(-10.0f, 10.0f);
                valueAnimatorOfFloat.setDuration(150L);
                valueAnimatorOfFloat.setRepeatMode(2);
                valueAnimatorOfFloat.setRepeatCount(-1);
                valueAnimatorOfFloat.addUpdateListener(new AnonymousClass14());
                valueAnimatorOfFloat.addListener(new AnonymousClass2());
                valueAnimatorOfFloat.setInterpolator(new AnonymousClass3());
                this.a.post(new AnonymousClass4());
            }
            this.c = valueAnimatorOfFloat;
            if (valueAnimatorOfFloat != null) {
                valueAnimatorOfFloat.start();
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseShakeView$7, reason: invalid class name */
    final class AnonymousClass7 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass7() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseShakeView.this.a.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseShakeView$8, reason: invalid class name */
    final class AnonymousClass8 extends AnimatorListenerAdapter {
        AnonymousClass8() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            BaseShakeView.a(BaseShakeView.this);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseShakeView$9, reason: invalid class name */
    final class AnonymousClass9 implements Interpolator {
        AnonymousClass9() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if (BaseShakeView.this.l % 3 == 2) {
                return 0.0f;
            }
            return f;
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseShakeView$10, reason: invalid class name */
    final class AnonymousClass10 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass10() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseShakeView.this.a.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseShakeView$11, reason: invalid class name */
    final class AnonymousClass11 extends AnimatorListenerAdapter {
        AnonymousClass11() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            BaseShakeView.a(BaseShakeView.this);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseShakeView$12, reason: invalid class name */
    final class AnonymousClass12 implements Interpolator {
        AnonymousClass12() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if (BaseShakeView.this.l % 3 == 2) {
                return 0.0f;
            }
            return f;
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseShakeView$13, reason: invalid class name */
    final class AnonymousClass13 implements Runnable {
        AnonymousClass13() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int width = (int) (((double) BaseShakeView.this.a.getWidth()) * 0.5d);
            int height = (int) (((double) BaseShakeView.this.a.getHeight()) * 0.5d);
            BaseShakeView.this.a.setPivotX(width);
            BaseShakeView.this.a.setPivotY(height);
        }
    }

    private ValueAnimator a(int i) {
        if (i == 1) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, -25.0f, 0.0f, 25.0f, 0.0f);
            valueAnimatorOfFloat.setDuration(500L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.addUpdateListener(new AnonymousClass10());
            valueAnimatorOfFloat.addListener(new AnonymousClass11());
            valueAnimatorOfFloat.setInterpolator(new AnonymousClass12());
            this.a.post(new AnonymousClass13());
            return valueAnimatorOfFloat;
        }
        if (i == 2) {
            int iA = q.a(getContext(), 8.0f);
            float f = iA;
            int i2 = -iA;
            float f2 = i2;
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, f, f2, f, f2, iA / 2, i2 / 2, iA / 4, i2 / 4, 0.0f);
            valueAnimatorOfFloat2.setDuration(1000L);
            valueAnimatorOfFloat2.setRepeatCount(-1);
            valueAnimatorOfFloat2.addUpdateListener(new AnonymousClass7());
            valueAnimatorOfFloat2.addListener(new AnonymousClass8());
            valueAnimatorOfFloat2.setInterpolator(new AnonymousClass9());
            return valueAnimatorOfFloat2;
        }
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(-10.0f, 10.0f);
        valueAnimatorOfFloat3.setDuration(150L);
        valueAnimatorOfFloat3.setRepeatMode(2);
        valueAnimatorOfFloat3.setRepeatCount(-1);
        valueAnimatorOfFloat3.addUpdateListener(new AnonymousClass14());
        valueAnimatorOfFloat3.addListener(new AnonymousClass2());
        valueAnimatorOfFloat3.setInterpolator(new AnonymousClass3());
        this.a.post(new AnonymousClass4());
        return valueAnimatorOfFloat3;
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseShakeView$14, reason: invalid class name */
    final class AnonymousClass14 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass14() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseShakeView.this.a.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseShakeView$2, reason: invalid class name */
    final class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            BaseShakeView.a(BaseShakeView.this);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseShakeView$3, reason: invalid class name */
    final class AnonymousClass3 implements Interpolator {
        AnonymousClass3() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            if ((BaseShakeView.this.l / 2) % 3 == 0) {
                return 0.0f;
            }
            return f;
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseShakeView$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (BaseShakeView.this.a == null || BaseShakeView.this.a.getWidth() <= 0 || BaseShakeView.this.a.getHeight() <= 0) {
                return;
            }
            int width = (int) (((double) BaseShakeView.this.a.getWidth()) * 0.8d);
            int height = (int) (((double) BaseShakeView.this.a.getHeight()) * 0.8d);
            BaseShakeView.this.a.setPivotX(width);
            BaseShakeView.this.a.setPivotY(height);
        }
    }

    public void setOnShakeListener(a aVar, y yVar) {
        this.m.a(yVar);
        this.k = aVar;
    }

    public void setShakeSetting(y yVar, int i) {
        if (yVar != null) {
            this.d = yVar.e();
            this.e = yVar.f();
            this.f = yVar.g();
            this.g = yVar.h();
            this.h = yVar.i();
            this.j = i;
            if (TextUtils.isEmpty(this.e)) {
                d();
            } else {
                com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.ui.BaseShakeView.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        int iMin;
                        try {
                            iMin = Math.min(BaseShakeView.this.getResources().getDisplayMetrics().widthPixels, BaseShakeView.this.getResources().getDisplayMetrics().heightPixels) / 2;
                        } catch (Throwable unused) {
                            iMin = 0;
                        }
                        BaseShakeView baseShakeView = BaseShakeView.this;
                        baseShakeView.i = com.anythink.core.common.res.b.a(baseShakeView.getContext()).b(new e(3, BaseShakeView.this.e), iMin, iMin);
                        BaseShakeView.this.d();
                    }
                }, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        t.b().b(new Runnable() { // from class: com.anythink.basead.ui.BaseShakeView.6
            @Override // java.lang.Runnable
            public final void run() {
                if (BaseShakeView.this.a != null) {
                    if (BaseShakeView.this.i != null) {
                        BaseShakeView.this.a.setImageBitmap(BaseShakeView.this.i);
                    } else {
                        BaseShakeView.this.a.setImageResource(q.a(BaseShakeView.this.getContext(), "myoffer_shake_icon", "drawable"));
                    }
                }
                if (BaseShakeView.this.b != null) {
                    if (BaseShakeView.this.i != null) {
                        BaseShakeView.this.b.setImageBitmap(BaseShakeView.this.i);
                    } else {
                        BaseShakeView.this.b.setImageResource(q.a(BaseShakeView.this.getContext(), "myoffer_shake_icon", "drawable"));
                    }
                }
            }
        });
    }

    protected void b() {
        com.anythink.core.express.c.a.a().a(this.m);
    }

    protected void c() {
        com.anythink.core.express.c.a.a().b(this.m);
    }
}
