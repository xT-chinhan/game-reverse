package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.v;
import com.bytedance.sdk.openadsdk.core.re;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SplashClickBarBtn extends RelativeLayout {
    private RelativeLayout ab;
    private TextView ah;
    private final AnimatorSet ao;
    private b b;
    private RelativeLayout c;
    private SlideUpView ch;
    private JSONObject cv;
    private TextView d;
    private int g;
    private final ValueAnimator h;
    private RockView hi;
    private float i;
    private LottieAnimationView ka;
    private JSONObject le;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private GradientDrawable f2328ms;
    private boolean nw;
    private SplashClickBarArrow ny;
    private int of;
    private JSONObject op;
    private lm p;
    private final ValueAnimator qv;
    private com.bytedance.sdk.openadsdk.core.xr.ms re;
    private AnimatorSet sl;
    private int[] t;
    private Rect u;
    private Paint ub;
    private float w;
    private LinearLayout x;
    private v xr;
    private LinearGradient y;
    private float yu;
    private Path zb;

    public SplashClickBarBtn(Context context, lm lmVar) {
        super(context);
        this.xr = new v();
        this.ao = new AnimatorSet();
        this.h = new ValueAnimator();
        this.qv = new ValueAnimator();
        this.t = new int[]{Color.parseColor("#00FFFFFF"), Color.parseColor("#47FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.nw = false;
        this.i = 13.0f;
        this.yu = 50.0f;
        this.p = lmVar;
        ka();
    }

    private View ms(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        relativeLayout.setClipChildren(false);
        layoutParams.addRule(14);
        relativeLayout.setId(2114387583);
        relativeLayout.setLayoutParams(layoutParams);
        this.c = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.c.setId(2114387582);
        this.c.setClipChildren(false);
        layoutParams2.addRule(13);
        this.c.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.c);
        this.hi = new RockView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        this.hi.setId(2114387581);
        layoutParams3.addRule(14);
        this.hi.setLayoutParams(layoutParams3);
        ul.ms((View) this.hi, 8);
        this.c.addView(this.hi);
        this.ab = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        this.ab.setId(2114387580);
        this.ab.setClipChildren(false);
        layoutParams4.addRule(13);
        this.ab.setGravity(17);
        this.ab.setLayoutParams(layoutParams4);
        this.c.addView(this.ab);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(2, 2114387579);
        layoutParams5.addRule(14);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams5);
        this.ab.addView(linearLayout);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.ka = lottieAnimationView;
        lottieAnimationView.setId(2114387578);
        this.ka.setAnimation("lottie_json/twist_multi_angle.json");
        this.ka.setImageAssetsFolder("images/");
        this.ka.ms(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()));
        layoutParams6.bottomMargin = ul.ah(context, 4.0f);
        layoutParams6.gravity = 17;
        this.ka.setLayoutParams(layoutParams6);
        linearLayout.addView(this.ka);
        ul.ms((View) this.ka, 8);
        SlideUpView slideUpView = new SlideUpView(context);
        this.ch = slideUpView;
        slideUpView.setId(2114387575);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 200.0f, resources.getDisplayMetrics()));
        layoutParams7.topMargin = ul.ah(context, -140.0f);
        this.ch.setLayoutParams(layoutParams7);
        linearLayout.addView(this.ch);
        ul.ms((View) this.ch, 8);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.x = linearLayout2;
        linearLayout2.setId(2114387579);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(12);
        this.x.setGravity(17);
        this.x.setOrientation(1);
        this.x.setLayoutParams(layoutParams8);
        this.ab.addView(this.x);
        TextView textView = new TextView(context);
        this.d = textView;
        textView.setId(2114387574);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        this.d.setSingleLine();
        this.d.setText(t.ms(context, "tt_splash_click_bar_text"));
        this.d.setTextColor(-1);
        this.d.setTextSize(20.0f);
        this.d.setTypeface(Typeface.defaultFromStyle(1));
        this.d.setLayoutParams(layoutParams9);
        this.x.addView(this.d);
        ul.ms((View) this.d, 8);
        TextView textView2 = new TextView(context);
        this.ah = textView2;
        textView2.setId(2114387573);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        this.ah.setShadowLayer(2.0f, 0.0f, 0.5f, t.ny(context, "tt_splash_click_bar_text_shadow"));
        this.ah.setSingleLine();
        this.ah.setText(t.ms(context, "tt_splash_click_bar_text"));
        this.ah.setTextColor(-1);
        this.ah.setTextSize(15.0f);
        this.ah.setTypeface(Typeface.defaultFromStyle(1));
        this.ah.setLayoutParams(layoutParams10);
        this.x.addView(this.ah);
        ul.ms((View) this.ah, 8);
        return relativeLayout;
    }

    private void ka() {
        View viewMs = ms(getContext());
        if (viewMs == null) {
            return;
        }
        addView(viewMs);
        SplashClickBarArrow splashClickBarArrow = new SplashClickBarArrow(getContext());
        this.ny = splashClickBarArrow;
        this.c.addView(splashClickBarArrow);
        this.ny.setClipChildren(false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ny.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.ab.getId());
        this.f2328ms = ms(Color.parseColor("#57000000"));
        this.zb = new Path();
        Paint paint = new Paint();
        this.ub = paint;
        paint.isAntiAlias();
    }

    private GradientDrawable ms(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setSize(32, 12);
        gradientDrawable.setStroke(1, -2130706433);
        gradientDrawable.setCornerRadius(ul.ah(re.getContext(), 50.0f));
        return gradientDrawable;
    }

    public void ms(v vVar) {
        if (vVar == null) {
            return;
        }
        this.xr = vVar;
        if (vVar.ny() == 4) {
            this.hi.ms(this.xr);
            return;
        }
        TextView textView = this.ah;
        if (textView != null) {
            textView.setVisibility(0);
            this.ah.setText(TextUtils.isEmpty(this.xr.xr()) ? "点击跳转至详情页或第三方应用" : this.xr.xr());
            if (this.xr.sl() != null) {
                this.ah.setTextSize(2, this.xr.sl().xr());
            }
        }
        if (this.d != null && this.xr.zb() != null) {
            this.d.setTextSize(2, this.xr.zb().xr());
        }
        this.f2328ms.setColor(Color.parseColor("#57000000"));
        this.ny.ms(this.xr.ny());
        int iNy = this.xr.ny();
        if (iNy == 1 || iNy == 2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.sl = animatorSet;
            animatorSet.playTogether(getAnimator(), this.ny.getAnimator());
        } else if (iNy == 3) {
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.d.setText(this.xr.hi());
            }
            TextView textView3 = this.ah;
            if (textView3 != null) {
                textView3.setTypeface(Typeface.defaultFromStyle(0));
            }
            this.f2328ms = ms(Color.parseColor(this.xr.ch()));
        } else {
            if (iNy == 4) {
                return;
            }
            if (iNy == 5) {
                SlideUpView slideUpView = this.ch;
                if (slideUpView != null) {
                    slideUpView.setVisibility(0);
                }
                LinearLayout linearLayout = this.x;
                if (linearLayout != null) {
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    layoutParams.width = -1;
                    this.x.setLayoutParams(layoutParams);
                }
                TextView textView4 = this.d;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    this.d.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    if (TextUtils.isEmpty(this.xr.hi())) {
                        this.d.setText("向上滑动");
                    } else {
                        this.d.setText(this.xr.hi());
                    }
                }
                TextView textView5 = this.ah;
                if (textView5 != null) {
                    textView5.setText(TextUtils.isEmpty(this.xr.xr()) ? "滑动查看详情" : this.xr.xr());
                    this.ah.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    return;
                }
                return;
            }
            if (iNy == 7) {
                TextView textView6 = this.d;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    this.d.setText(this.xr.hi());
                    this.d.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                TextView textView7 = this.ah;
                if (textView7 != null) {
                    textView7.setTypeface(Typeface.defaultFromStyle(0));
                    this.ah.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                LottieAnimationView lottieAnimationView = this.ka;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                    return;
                }
                return;
            }
            this.f2328ms.setStroke(0, ViewCompat.MEASURED_STATE_MASK);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.sl = animatorSet2;
            animatorSet2.playTogether(getAnimator(), this.ny.getAnimator());
            try {
                setBackgroundColor(Color.parseColor(this.xr.ch()));
            } catch (Throwable unused) {
                setBackgroundColor(Color.parseColor("#008DEA"));
            }
        }
        setBackgroundDrawable(this.f2328ms);
    }

    private void c() {
        if (this.nw) {
            return;
        }
        this.nw = true;
        int iNy = this.xr.ny();
        if (iNy == 1 || iNy == 2) {
            x();
            ab();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f2328ms.setColor(i);
        setBackgroundDrawable(this.f2328ms);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        c();
        super.onDraw(canvas);
        if (this.h.isRunning()) {
            this.ub.setShader(this.y);
            canvas.drawRoundRect(new RectF(this.u), ul.ah(getContext(), 50.0f), ul.ah(getContext(), 50.0f), this.ub);
        }
    }

    private void ab() {
        int color = Color.parseColor("#57000000");
        int color2 = Color.parseColor(this.xr.ch());
        this.f2328ms.setColor(color);
        this.qv.setIntValues(color, color2);
        this.qv.setEvaluator(new ArgbEvaluator());
        this.qv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashClickBarBtn.this.f2328ms.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                SplashClickBarBtn splashClickBarBtn = SplashClickBarBtn.this;
                splashClickBarBtn.setBackgroundDrawable(splashClickBarBtn.f2328ms);
            }
        });
        this.qv.setDuration(300L);
        this.qv.setStartDelay(800L);
        this.qv.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.ao.playTogether(this.qv);
    }

    private void x() {
        Point point = new Point(0, 0);
        Point point2 = new Point(getMeasuredWidth(), 0);
        Point point3 = new Point(getMeasuredWidth(), getMeasuredHeight());
        Point point4 = new Point(0, getMeasuredHeight());
        this.zb.moveTo(point.x, point.y);
        this.zb.lineTo(point2.x, point2.y);
        this.zb.lineTo(point3.x, point3.y);
        this.zb.lineTo(point4.x, point4.y);
        this.zb.close();
        this.u = getBackground().getBounds();
        final int iAh = ul.ah(getContext(), 36.0f);
        final int iAh2 = ul.ah(getContext(), 45.0f);
        this.h.setIntValues(point.x - iAh, point2.x + iAh);
        this.h.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.h.setDuration(1600L);
        this.h.setStartDelay(1300L);
        this.h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SplashClickBarBtn.this.y = new LinearGradient(iIntValue, 0.0f, iIntValue + iAh, iAh2, SplashClickBarBtn.this.t, (float[]) null, Shader.TileMode.CLAMP);
                SplashClickBarBtn.this.postInvalidate();
            }
        });
        this.ao.playTogether(this.h);
    }

    public Animator getAnimator() {
        return this.ao;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        b bVar = this.b;
        if (bVar != null) {
            if (z) {
                lm lmVar = this.p;
                bVar.ms(lmVar != null ? lmVar.ka() : 0);
            } else {
                lm lmVar2 = this.p;
                bVar.xr(lmVar2 != null ? lmVar2.ka() : 0);
            }
        }
    }

    public b getShakeUtils() {
        return this.b;
    }

    public void setShakeValue(float f) {
        this.i = f;
    }

    public void setDeepShakeValue(float f) {
        this.w = f;
    }

    public void setWriggleValue(float f) {
        this.yu = f;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.op = jSONObject;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.le = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.cv = jSONObject;
    }

    public void setCalculationMethod(int i) {
        this.g = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.of = i;
    }

    private void ny() {
        if (this.xr != null && isShown()) {
            if (this.xr.ny() == 4 || this.xr.ny() == 7) {
                if (this.b == null) {
                    if (this.xr.ny() == 4) {
                        this.b = new b(re.getContext(), 1, ch.ub().ka());
                    } else if (this.xr.ny() == 7) {
                        this.b = new b(re.getContext(), 2, ch.ub().ka());
                    }
                }
                this.b.ms(this.i);
                this.b.ah(this.w);
                this.b.xr(this.yu);
                this.b.ms(this.op);
                this.b.ah(this.le);
                this.b.xr(this.cv);
                this.b.ka(this.g);
                this.b.c(this.of);
                this.b.ms(new b.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.3
                    @Override // com.bytedance.sdk.component.utils.b.ms
                    public void ms(int i) {
                        if (SplashClickBarBtn.this.re == null || !SplashClickBarBtn.this.isShown()) {
                            return;
                        }
                        if (SplashClickBarBtn.this.b.ms() && SplashClickBarBtn.this.p != null) {
                            com.bytedance.sdk.openadsdk.core.hi.ah.ah.c.d = true;
                        }
                        if (i != 1) {
                            if (i == 2 && SplashClickBarBtn.this.xr.ny() == 7) {
                                ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) SplashClickBarBtn.this.re.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).xr();
                                SplashClickBarBtn.this.re.onClick(SplashClickBarBtn.this);
                                return;
                            }
                            return;
                        }
                        if (SplashClickBarBtn.this.xr.ny() == 4) {
                            ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) SplashClickBarBtn.this.re.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms();
                            SplashClickBarBtn.this.re.onClick(SplashClickBarBtn.this);
                        }
                    }
                });
                b bVar = this.b;
                lm lmVar = this.p;
                bVar.ms(lmVar != null ? lmVar.ka() : 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ny();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.4
            @Override // java.lang.Runnable
            public void run() {
                SplashClickBarBtn.this.ms();
            }
        });
    }

    public void ms() {
        AnimatorSet animatorSet = this.sl;
        if (animatorSet != null) {
            animatorSet.start();
        }
        xr();
        ah();
        d();
        ch();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.b;
        if (bVar != null) {
            lm lmVar = this.p;
            bVar.xr(lmVar != null ? lmVar.ka() : 0);
        }
        AnimatorSet animatorSet = this.sl;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.ao;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        SlideUpView slideUpView = this.ch;
        if (slideUpView != null) {
            slideUpView.xr();
        }
        LottieAnimationView lottieAnimationView = this.ka;
        if (lottieAnimationView != null) {
            lottieAnimationView.c();
        }
    }

    public void xr() {
        if (this.xr.ny() != 3) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        scaleAnimation.setInterpolator(new PathInterpolator(0.41f, 0.23f, 0.25f, 1.0f));
        scaleAnimation.setDuration(600L);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(-1);
        startAnimation(scaleAnimation);
    }

    public void ah() {
        RockView rockView;
        if (this.xr.ny() == 4 && (rockView = this.hi) != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(rockView, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setDuration(300L);
            objectAnimatorOfFloat.start();
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.5
                @Override // java.lang.Runnable
                public void run() {
                    if (SplashClickBarBtn.this.hi != null) {
                        SplashClickBarBtn.this.hi.ms();
                    }
                }
            }, 500L);
        }
    }

    public void d() {
        if (this.xr.ny() != 7) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SplashClickBarBtn.this.ka != null) {
                        SplashClickBarBtn.this.ka.ms();
                    }
                } catch (Exception unused) {
                }
            }
        }, 500L);
    }

    private void ch() {
        v vVar = this.xr;
        if (vVar == null || vVar.ny() != 5) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7
            @Override // java.lang.Runnable
            public void run() {
                if (SplashClickBarBtn.this.ch == null) {
                    return;
                }
                SplashClickBarBtn.this.ch.ms();
                final AnimatorSet slideUpAnimatorSet = SplashClickBarBtn.this.ch.getSlideUpAnimatorSet();
                if (slideUpAnimatorSet == null) {
                    return;
                }
                slideUpAnimatorSet.start();
                slideUpAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7.1
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
                        SplashClickBarBtn.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn.7.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                slideUpAnimatorSet.start();
                            }
                        }, 200L);
                    }
                });
            }
        }, 500L);
    }

    public void ms(com.bytedance.sdk.openadsdk.core.xr.ms msVar) {
        this.re = msVar;
        if (this.xr.ny() == 4 || this.xr.ny() == 7 || this.xr.ny() == 5 || msVar == null) {
            return;
        }
        msVar.ms(this);
        setOnClickListener(msVar);
        setOnTouchListener(msVar);
        setId(2114387639);
    }
}
