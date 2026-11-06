package com.smartdigimkt.china.based.twist;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.GradientDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.d.i;
import com.smartdigimkt.c.a;
import com.smartdigimkt.c.b;
import com.smartdigimkt.c.c;
import com.smartdigimkt.c.d;
import com.smartdigimkt.c.e;
import com.smartdigimkt.c.f;
import com.smartdigimkt.c.k;
import com.smartdigimkt.n1.a0;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public class TwistG2CV2View extends BaseG2CV2View {
    public static final /* synthetic */ int t = 0;
    public RelativeLayout h;
    public ImageView i;
    public boolean j;
    public AnimatorSet k;
    public SensorManager l;
    public Sensor m;
    public k n;
    public float o;
    public float p;
    public float q;
    public f r;
    public boolean s;

    public TwistG2CV2View(Context context) {
        super(context);
        this.o = 30.0f;
        this.p = 30.0f;
        this.q = 30.0f;
    }

    public static void a(TwistG2CV2View twistG2CV2View) {
        twistG2CV2View.getClass();
        try {
            ImageView imageView = twistG2CV2View.i;
            if (imageView != null) {
                int width = imageView.getWidth();
                int height = twistG2CV2View.i.getHeight();
                if (width <= 0) {
                    twistG2CV2View.post(new b(twistG2CV2View));
                } else {
                    twistG2CV2View.i.setPivotX(width / 2.0f);
                    twistG2CV2View.i.setPivotY(height / 2.0f);
                    twistG2CV2View.i.setRotation(0.0f);
                    twistG2CV2View.i.setRotationX(0.0f);
                    twistG2CV2View.c();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void applyBannerForegroundProfile(a0 a0Var) {
        if (!this.j || a0Var == null || this.h == null) {
            return;
        }
        setClickable(false);
        setLongClickable(false);
        setFocusable(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.h.setScaleX(1.0f);
        this.h.setScaleY(1.0f);
        this.h.setClipChildren(true);
        float f = 10;
        this.h.setPadding(com.smartdigimkt.r4.k.a(getContext(), f), 0, com.smartdigimkt.r4.k.a(getContext(), f), 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{0, Integer.MIN_VALUE});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setCornerRadius(com.smartdigimkt.r4.k.a(getContext(), a0Var.b == 1 ? 4 : 5));
        this.h.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = this.h.getLayoutParams() instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) this.h.getLayoutParams() : new RelativeLayout.LayoutParams(0, 0);
        layoutParams.width = com.smartdigimkt.r4.k.a(getContext(), a0Var.d);
        layoutParams.height = com.smartdigimkt.r4.k.a(getContext(), a0Var.e);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.addRule(13, 0);
        layoutParams.addRule(12, 0);
        layoutParams.addRule(14, 0);
        if (a0Var.c) {
            layoutParams.addRule(13, -1);
        } else {
            layoutParams.addRule(12, -1);
            layoutParams.addRule(14, -1);
        }
        this.h.setLayoutParams(layoutParams);
        if (this.h.getChildCount() > 0 && (this.h.getChildAt(0) instanceof LinearLayout)) {
            LinearLayout linearLayout = (LinearLayout) this.h.getChildAt(0);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            linearLayout.setPadding(0, 0, 0, 0);
            ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            linearLayout.setLayoutParams(layoutParams2);
        }
        View viewFindViewById = this.h.findViewById(com.smartdigimkt.r4.k.a(getContext(), "twist_main_title", "id"));
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        if (this.i != null) {
            int iA = com.smartdigimkt.r4.k.a(getContext(), "interaction_twist_icon", "drawable");
            if (iA != 0) {
                this.i.setImageResource(iA);
            }
            this.i.setColorFilter((ColorFilter) null);
            this.i.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ViewGroup.LayoutParams layoutParams3 = this.i.getLayoutParams();
            layoutParams3.width = com.smartdigimkt.r4.k.a(getContext(), a0Var.b == 1 ? 16 : 18);
            layoutParams3.height = com.smartdigimkt.r4.k.a(getContext(), a0Var.b != 1 ? 18 : 16);
            this.i.setLayoutParams(layoutParams3);
            this.i.setContentDescription(null);
        }
        View viewFindViewById2 = this.h.findViewById(com.smartdigimkt.r4.k.a(getContext(), "twist_subtitle", "id"));
        if (viewFindViewById2 instanceof TextView) {
            TextView textView = (TextView) viewFindViewById2;
            textView.setText(com.smartdigimkt.r4.k.a(getContext(), "banner_interaction_twist_hint", "string"));
            textView.setTextColor(-1);
            textView.setTextSize(2, f);
            textView.setIncludeFontPadding(false);
            textView.setSingleLine(true);
            textView.setMaxLines(1);
            textView.setEllipsize(null);
            textView.setGravity(17);
            textView.setPadding(0, 0, 0, 0);
            ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
            layoutParams4.width = -2;
            layoutParams4.height = -2;
            textView.setLayoutParams(layoutParams4);
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams.leftMargin = com.smartdigimkt.r4.k.a(getContext(), 4);
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.bottomMargin = 0;
                textView.setLayoutParams(marginLayoutParams);
            }
        }
        this.h.requestLayout();
    }

    public final void b() {
        this.h.setMinimumHeight(0);
        ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.h.setLayoutParams(layoutParams);
        }
        if (this.h.getChildCount() > 0) {
            View childAt = this.h.getChildAt(0);
            ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = -2;
                layoutParams2.height = -2;
                childAt.setLayoutParams(layoutParams2);
            }
            if (childAt instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) childAt;
                linearLayout.setGravity(1);
                linearLayout.setPadding(0, 0, 0, 0);
            }
        }
        int iA = com.smartdigimkt.r4.k.a(getContext(), 10.0f);
        int iA2 = this.j ? 0 : com.smartdigimkt.r4.k.a(getContext(), 6.0f);
        this.h.setPadding(iA, iA2, iA, iA2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1725553114);
        gradientDrawable.setCornerRadius(com.smartdigimkt.r4.k.a(getContext(), 20.0f));
        this.h.setBackground(gradientDrawable);
        int iA3 = com.smartdigimkt.r4.k.a(getContext(), "twist_main_title", "id");
        int iA4 = com.smartdigimkt.r4.k.a(getContext(), "twist_subtitle", "id");
        View viewFindViewById = this.h.findViewById(iA3);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        if (this.i != null) {
            int iA5 = com.smartdigimkt.r4.k.a(getContext(), 22.0f);
            ViewGroup.LayoutParams layoutParams3 = this.i.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.width = iA5;
                layoutParams3.height = iA5;
                this.i.setLayoutParams(layoutParams3);
            }
        }
        View viewFindViewById2 = this.h.findViewById(iA4);
        if (viewFindViewById2 instanceof TextView) {
            TextView textView = (TextView) viewFindViewById2;
            ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
            if (layoutParams4 != null) {
                layoutParams4.width = -2;
                textView.setLayoutParams(layoutParams4);
            }
            if (!this.j) {
                textView.setMaxWidth(com.smartdigimkt.r4.k.a(getContext(), 94.0f));
            }
            textView.setTextSize(1, 10);
            textView.setTextColor(-1);
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = 0;
                textView.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final void c() {
        try {
            if (this.i == null) {
                return;
            }
            AnimatorSet animatorSet = this.k;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.k.removeAllListeners();
                this.k = null;
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.i, "rotation", 0.0f, 30.0f);
            objectAnimatorOfFloat.setDuration(750L);
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 1);
            valueAnimatorOfInt.setDuration(100L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.i, "rotation", 30.0f, -30.0f);
            objectAnimatorOfFloat2.setDuration(750L);
            ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(0, 1);
            valueAnimatorOfInt2.setDuration(100L);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.i, "rotation", -30.0f, 0.0f);
            objectAnimatorOfFloat3.setDuration(750L);
            ValueAnimator valueAnimatorOfInt3 = ValueAnimator.ofInt(0, 1);
            valueAnimatorOfInt3.setDuration(100L);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.i, "rotationY", 0.0f, 60.0f);
            objectAnimatorOfFloat4.setDuration(1500L);
            ValueAnimator valueAnimatorOfInt4 = ValueAnimator.ofInt(0, 1);
            valueAnimatorOfInt4.setDuration(100L);
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.i, "rotationY", 60.0f, -60.0f);
            objectAnimatorOfFloat5.setDuration(1500L);
            ValueAnimator valueAnimatorOfInt5 = ValueAnimator.ofInt(0, 1);
            valueAnimatorOfInt5.setDuration(100L);
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.i, "rotationY", -60.0f, -30.0f);
            objectAnimatorOfFloat6.setDuration(1500L);
            ValueAnimator valueAnimatorOfInt6 = ValueAnimator.ofInt(0, 1);
            valueAnimatorOfInt6.setDuration(100L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.k = animatorSet2;
            animatorSet2.playSequentially(objectAnimatorOfFloat, valueAnimatorOfInt, objectAnimatorOfFloat2, valueAnimatorOfInt2, objectAnimatorOfFloat3, valueAnimatorOfInt3, objectAnimatorOfFloat4, valueAnimatorOfInt4, objectAnimatorOfFloat5, valueAnimatorOfInt5, objectAnimatorOfFloat6, valueAnimatorOfInt6);
            this.k.addListener(new c(this));
            this.k.start();
        } catch (Throwable unused) {
        }
    }

    public final void d() {
        if (this.n != null) {
            return;
        }
        if (this.l == null) {
            this.l = (SensorManager) getContext().getSystemService("sensor");
        }
        SensorManager sensorManager = this.l;
        if (sensorManager == null) {
            return;
        }
        if (this.m == null) {
            this.m = sensorManager.getDefaultSensor(4);
        }
        Sensor sensor = this.m;
        if (sensor == null) {
            return;
        }
        k kVar = new k(this.o, this.p, this.q, new e(this));
        this.n = kVar;
        this.l.registerListener(kVar, sensor, i.w.y);
    }

    public k getTwistSensorEventListener() {
        return this.n;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void initView(int i, int i2) {
        try {
            if (getContext() == null) {
                return;
            }
            a(i);
            post(new a(this));
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.j) {
            post(new d(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        k kVar;
        super.onDetachedFromWindow();
        SensorManager sensorManager = this.l;
        if (sensorManager != null && (kVar = this.n) != null) {
            sensorManager.unregisterListener(kVar);
            this.n = null;
        }
        try {
            AnimatorSet animatorSet = this.k;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
                this.k.cancel();
                this.k = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!this.j || i <= 0 || i2 <= 0) {
            return;
        }
        applyBannerForegroundProfile(a0.a(com.smartdigimkt.r4.k.b(getContext(), i), com.smartdigimkt.r4.k.b(getContext(), i2), 2));
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        k kVar;
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            if (this.s) {
                d();
            }
            resumeAnim();
        } else {
            SensorManager sensorManager = this.l;
            if (sensorManager != null && (kVar = this.n) != null) {
                sensorManager.unregisterListener(kVar);
                this.n = null;
            }
            pauseAnim();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void pauseAnim() {
        try {
            AnimatorSet animatorSet = this.k;
            if (animatorSet == null || !animatorSet.isRunning()) {
                return;
            }
            this.k.pause();
        } catch (Throwable unused) {
        }
    }

    public void registerGyroscopeAfterShowNotified() {
        this.s = true;
        d();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        k kVar;
        try {
            this.s = false;
            SensorManager sensorManager = this.l;
            if (sensorManager != null && (kVar = this.n) != null) {
                sensorManager.unregisterListener(kVar);
                this.n = null;
            }
            try {
                AnimatorSet animatorSet = this.k;
                if (animatorSet != null) {
                    animatorSet.removeAllListeners();
                    this.k.cancel();
                    this.k = null;
                }
            } catch (Throwable unused) {
            }
            this.l = null;
            this.m = null;
            this.r = null;
            super.release();
        } catch (Throwable unused2) {
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void resumeAnim() {
        try {
            AnimatorSet animatorSet = this.k;
            if (animatorSet != null) {
                animatorSet.resume();
            }
        } catch (Throwable unused) {
        }
    }

    public void setTwistConfig(float f, float f2, float f3, f fVar) {
        this.o = f;
        this.p = f2;
        this.q = f3;
        this.r = fVar;
    }

    public TwistG2CV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.o = 30.0f;
        this.p = 30.0f;
        this.q = 30.0f;
    }

    public TwistG2CV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = 30.0f;
        this.p = 30.0f;
        this.q = 30.0f;
    }

    public final void a(int i) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        try {
            if (getContext() == null) {
                return;
            }
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(com.smartdigimkt.r4.k.a(getContext(), "twist_g2c_v2_guide", "layout"), (ViewGroup) this, false);
            this.h = relativeLayout;
            if (relativeLayout == null) {
                return;
            }
            relativeLayout.setClipChildren(false);
            this.h.setBackgroundColor(0);
            this.i = (ImageView) this.h.findViewById(com.smartdigimkt.r4.k.a(getContext(), "twist_phone_icon", "id"));
            boolean z = i == 2;
            boolean z2 = i == 5 || i == 6;
            boolean z3 = i == 4;
            if (z3) {
                this.j = true;
            }
            if (z2) {
                b();
            }
            if (z2) {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            } else if (z3) {
                setClipChildren(false);
                setClipToPadding(false);
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(13);
            } else {
                if (z) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(13);
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    if (!com.smartdigimkt.r4.k.b(getContext())) {
                        layoutParams.bottomMargin = com.smartdigimkt.r4.k.a(getContext(), 195.0f);
                    }
                }
                layoutParams2 = layoutParams;
            }
            addView(this.h, layoutParams2);
        } catch (Throwable unused) {
        }
    }
}
