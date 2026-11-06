package com.byazt.hi;

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
import com.byazt.gct.el;
import com.byazt.gct.pk;
import com.byazt.pp.LottieAnimationView;
import com.byazt.tk.ou;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, 1914})
public class SplashClickBarBtn extends RelativeLayout {
    public int[] a;
    public JSONObject bb;
    public final ValueAnimator cd;
    public RockView cp;
    public final AnimatorSet cy;
    public AnimatorSet d;
    public LinearLayout fs;
    public float h;
    public final ValueAnimator hd;
    public float hu;
    public Paint k;
    public LottieAnimationView l;
    public int lh;
    public int ln;
    public float m;
    public GradientDrawable n;
    public Path oa;
    public ou ou;
    public boolean py;
    public TextView q;
    public el qg;
    public SplashClickBarArrow rv;
    public TextView s;
    public Rect sz;
    public JSONObject t;
    public SlideUpView tj;
    public LinearGradient um;
    public JSONObject ur;
    public pk v;
    public RelativeLayout w;
    public com.byazt.ys.n wm;
    public RelativeLayout x;

    public SplashClickBarBtn(Context context, pk pkVar) {
        super(context);
        this.qg = new el();
        this.cy = new AnimatorSet();
        this.hd = new ValueAnimator();
        this.cd = new ValueAnimator();
        this.a = new int[]{Color.parseColor("#00FFFFFF"), Color.parseColor("#47FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.py = false;
        this.m = 13.0f;
        this.h = 50.0f;
        this.v = pkVar;
        l();
    }

    private View n(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        relativeLayout.setClipChildren(false);
        layoutParams.addRule(14);
        relativeLayout.setId(2114387577);
        relativeLayout.setLayoutParams(layoutParams);
        this.w = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.w.setId(2114387576);
        this.w.setClipChildren(false);
        layoutParams2.addRule(13);
        this.w.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.w);
        this.cp = new RockView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        this.cp.setId(2114387575);
        layoutParams3.addRule(14);
        this.cp.setLayoutParams(layoutParams3);
        com.byazt.okk.s.n((View) this.cp, 8);
        this.w.addView(this.cp);
        this.x = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        this.x.setId(2114387574);
        this.x.setClipChildren(false);
        layoutParams4.addRule(13);
        this.x.setGravity(17);
        this.x.setLayoutParams(layoutParams4);
        this.w.addView(this.x);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(2, 2114387573);
        layoutParams5.addRule(14);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams5);
        this.x.addView(linearLayout);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.l = lottieAnimationView;
        lottieAnimationView.setId(2114387572);
        this.l.setAnimation("lottie_json/twist_multi_angle.json");
        this.l.setImageAssetsFolder("images/");
        this.l.n(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()));
        layoutParams6.bottomMargin = com.byazt.okk.s.s(context, 4.0f);
        layoutParams6.gravity = 17;
        this.l.setLayoutParams(layoutParams6);
        linearLayout.addView(this.l);
        com.byazt.okk.s.n((View) this.l, 8);
        SlideUpView slideUpView = new SlideUpView(context);
        this.tj = slideUpView;
        slideUpView.setId(2114387569);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 200.0f, resources.getDisplayMetrics()));
        layoutParams7.topMargin = com.byazt.okk.s.s(context, -140.0f);
        this.tj.setLayoutParams(layoutParams7);
        linearLayout.addView(this.tj);
        com.byazt.okk.s.n((View) this.tj, 8);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.fs = linearLayout2;
        linearLayout2.setId(2114387573);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(12);
        this.fs.setGravity(17);
        this.fs.setOrientation(1);
        this.fs.setLayoutParams(layoutParams8);
        this.x.addView(this.fs);
        TextView textView = new TextView(context);
        this.q = textView;
        textView.setId(2114387568);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        this.q.setSingleLine();
        this.q.setText("查看详情");
        this.q.setTextColor(-1);
        this.q.setTextSize(20.0f);
        this.q.setTypeface(Typeface.defaultFromStyle(1));
        this.q.setLayoutParams(layoutParams9);
        this.fs.addView(this.q);
        com.byazt.okk.s.n((View) this.q, 8);
        TextView textView2 = new TextView(context);
        this.s = textView2;
        textView2.setId(2114387567);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        this.s.setShadowLayer(2.0f, 0.0f, 0.5f, 1291845632);
        this.s.setSingleLine();
        this.s.setText("查看详情");
        this.s.setTextColor(-1);
        this.s.setTextSize(15.0f);
        this.s.setTypeface(Typeface.defaultFromStyle(1));
        this.s.setLayoutParams(layoutParams10);
        this.fs.addView(this.s);
        com.byazt.okk.s.n((View) this.s, 8);
        return relativeLayout;
    }

    private void l() {
        View viewN = n(getContext());
        if (viewN == null) {
            return;
        }
        addView(viewN);
        SplashClickBarArrow splashClickBarArrow = new SplashClickBarArrow(getContext());
        this.rv = splashClickBarArrow;
        this.w.addView(splashClickBarArrow);
        this.rv.setClipChildren(false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.rv.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.x.getId());
        this.n = n(Color.parseColor("#57000000"));
        this.oa = new Path();
        Paint paint = new Paint();
        this.k = paint;
        paint.isAntiAlias();
    }

    private GradientDrawable n(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setSize(32, 12);
        gradientDrawable.setStroke(1, -2130706433);
        gradientDrawable.setCornerRadius(com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), 50.0f));
        return gradientDrawable;
    }

    public void n(el elVar) {
        if (elVar == null) {
            return;
        }
        this.qg = elVar;
        if (elVar.rv() == 4) {
            this.cp.n(this.qg);
            return;
        }
        TextView textView = this.s;
        if (textView != null) {
            textView.setVisibility(0);
            this.s.setText(TextUtils.isEmpty(this.qg.qg()) ? "点击跳转至详情页或第三方应用" : this.qg.qg());
            if (this.qg.d() != null) {
                this.s.setTextSize(2, this.qg.d().qg());
            }
        }
        if (this.q != null && this.qg.oa() != null) {
            this.q.setTextSize(2, this.qg.oa().qg());
        }
        this.n.setColor(Color.parseColor("#57000000"));
        this.rv.n(this.qg.rv());
        int iRv = this.qg.rv();
        if (iRv == 1 || iRv == 2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.d = animatorSet;
            animatorSet.playTogether(getAnimator(), this.rv.getAnimator());
        } else if (iRv == 3) {
            TextView textView2 = this.q;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.q.setText(this.qg.cp());
            }
            TextView textView3 = this.s;
            if (textView3 != null) {
                textView3.setTypeface(Typeface.defaultFromStyle(0));
            }
            this.n = n(Color.parseColor(this.qg.tj()));
        } else {
            if (iRv == 4) {
                return;
            }
            if (iRv == 5) {
                SlideUpView slideUpView = this.tj;
                if (slideUpView != null) {
                    slideUpView.setVisibility(0);
                }
                LinearLayout linearLayout = this.fs;
                if (linearLayout != null) {
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    layoutParams.width = -1;
                    this.fs.setLayoutParams(layoutParams);
                }
                TextView textView4 = this.q;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    this.q.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    if (TextUtils.isEmpty(this.qg.cp())) {
                        this.q.setText("向上滑动");
                    } else {
                        this.q.setText(this.qg.cp());
                    }
                }
                TextView textView5 = this.s;
                if (textView5 != null) {
                    textView5.setText(TextUtils.isEmpty(this.qg.qg()) ? "滑动查看详情" : this.qg.qg());
                    this.s.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    return;
                }
                return;
            }
            if (iRv == 7) {
                TextView textView6 = this.q;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    this.q.setText(this.qg.cp());
                    this.q.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                TextView textView7 = this.s;
                if (textView7 != null) {
                    textView7.setTypeface(Typeface.defaultFromStyle(0));
                    this.s.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                LottieAnimationView lottieAnimationView = this.l;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                    return;
                }
                return;
            }
            this.n.setStroke(0, ViewCompat.MEASURED_STATE_MASK);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.d = animatorSet2;
            animatorSet2.playTogether(getAnimator(), this.rv.getAnimator());
            try {
                setBackgroundColor(Color.parseColor(this.qg.tj()));
            } catch (Throwable unused) {
                setBackgroundColor(Color.parseColor("#008DEA"));
            }
        }
        setBackgroundDrawable(this.n);
    }

    private void w() {
        if (this.py) {
            return;
        }
        this.py = true;
        int iRv = this.qg.rv();
        if (iRv == 1 || iRv == 2) {
            fs();
            x();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.n.setColor(i);
        setBackgroundDrawable(this.n);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        w();
        super.onDraw(canvas);
        if (this.hd.isRunning()) {
            this.k.setShader(this.um);
            canvas.drawRoundRect(new RectF(this.sz), com.byazt.okk.s.s(getContext(), 50.0f), com.byazt.okk.s.s(getContext(), 50.0f), this.k);
        }
    }

    private void x() {
        int color = Color.parseColor("#57000000");
        int color2 = Color.parseColor(this.qg.tj());
        this.n.setColor(color);
        this.cd.setIntValues(color, color2);
        this.cd.setEvaluator(new ArgbEvaluator());
        this.cd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.hi.SplashClickBarBtn.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashClickBarBtn.this.n.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                SplashClickBarBtn splashClickBarBtn = SplashClickBarBtn.this;
                splashClickBarBtn.setBackgroundDrawable(splashClickBarBtn.n);
            }
        });
        this.cd.setDuration(300L);
        this.cd.setStartDelay(800L);
        this.cd.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.cy.playTogether(this.cd);
    }

    private void fs() {
        Point point = new Point(0, 0);
        Point point2 = new Point(getMeasuredWidth(), 0);
        Point point3 = new Point(getMeasuredWidth(), getMeasuredHeight());
        Point point4 = new Point(0, getMeasuredHeight());
        this.oa.moveTo(point.x, point.y);
        this.oa.lineTo(point2.x, point2.y);
        this.oa.lineTo(point3.x, point3.y);
        this.oa.lineTo(point4.x, point4.y);
        this.oa.close();
        this.sz = getBackground().getBounds();
        final int iS = com.byazt.okk.s.s(getContext(), 36.0f);
        final int iS2 = com.byazt.okk.s.s(getContext(), 45.0f);
        this.hd.setIntValues(point.x - iS, point2.x + iS);
        this.hd.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.hd.setDuration(1600L);
        this.hd.setStartDelay(1300L);
        this.hd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.hi.SplashClickBarBtn.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SplashClickBarBtn.this.um = new LinearGradient(iIntValue, 0.0f, iIntValue + iS, iS2, SplashClickBarBtn.this.a, (float[]) null, Shader.TileMode.CLAMP);
                SplashClickBarBtn.this.postInvalidate();
            }
        });
        this.cy.playTogether(this.hd);
    }

    public Animator getAnimator() {
        return this.cy;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ou ouVar = this.ou;
        if (ouVar != null) {
            if (z) {
                pk pkVar = this.v;
                ouVar.n(pkVar != null ? pkVar.v() : 0);
            } else {
                pk pkVar2 = this.v;
                ouVar.qg(pkVar2 != null ? pkVar2.v() : 0);
            }
        }
    }

    public ou getShakeUtils() {
        return this.ou;
    }

    public void setShakeValue(float f) {
        this.m = f;
    }

    public void setDeepShakeValue(float f) {
        this.hu = f;
    }

    public void setWriggleValue(float f) {
        this.h = f;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.t = jSONObject;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.ur = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.bb = jSONObject;
    }

    public void setCalculationMethod(int i) {
        this.ln = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.lh = i;
    }

    private void rv() {
        if (this.qg != null && isShown()) {
            if (this.qg.rv() == 4 || this.qg.rv() == 7) {
                if (this.ou == null) {
                    if (this.qg.rv() == 4) {
                        this.ou = new ou(com.byazt.nf.rv.getContext(), 1, com.byazt.vyf.s.cy().q());
                    } else if (this.qg.rv() == 7) {
                        this.ou = new ou(com.byazt.nf.rv.getContext(), 2, com.byazt.vyf.s.cy().q());
                    }
                }
                this.ou.n(this.m);
                this.ou.s(this.hu);
                this.ou.qg(this.h);
                this.ou.n(this.t);
                this.ou.s(this.ur);
                this.ou.qg(this.bb);
                this.ou.l(this.ln);
                this.ou.w(this.lh);
                this.ou.n(new ou.n() { // from class: com.byazt.hi.SplashClickBarBtn.3
                    @Override // com.byazt.tk.ou.n
                    public void n(int i) {
                        if (SplashClickBarBtn.this.wm == null || !SplashClickBarBtn.this.isShown()) {
                            return;
                        }
                        if (SplashClickBarBtn.this.ou.n() && SplashClickBarBtn.this.v != null) {
                            com.byazt.wif.w.q = true;
                        }
                        if (i != 1) {
                            if (i == 2 && SplashClickBarBtn.this.qg.rv() == 7) {
                                ((com.byazt.fq.n) SplashClickBarBtn.this.wm.n(com.byazt.fq.n.class)).qg();
                                SplashClickBarBtn.this.wm.onClick(SplashClickBarBtn.this);
                                return;
                            }
                            return;
                        }
                        if (SplashClickBarBtn.this.qg.rv() == 4) {
                            ((com.byazt.fq.n) SplashClickBarBtn.this.wm.n(com.byazt.fq.n.class)).n();
                            SplashClickBarBtn.this.wm.onClick(SplashClickBarBtn.this);
                        }
                    }
                });
                ou ouVar = this.ou;
                pk pkVar = this.v;
                ouVar.n(pkVar != null ? pkVar.v() : 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        rv();
        post(new Runnable() { // from class: com.byazt.hi.SplashClickBarBtn.4
            @Override // java.lang.Runnable
            public void run() {
                SplashClickBarBtn.this.n();
            }
        });
    }

    public void n() {
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.start();
        }
        qg();
        s();
        q();
        tj();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ou ouVar = this.ou;
        if (ouVar != null) {
            pk pkVar = this.v;
            ouVar.qg(pkVar != null ? pkVar.v() : 0);
        }
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.cy;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        SlideUpView slideUpView = this.tj;
        if (slideUpView != null) {
            slideUpView.qg();
        }
        LottieAnimationView lottieAnimationView = this.l;
        if (lottieAnimationView != null) {
            lottieAnimationView.w();
        }
    }

    public void qg() {
        if (this.qg.rv() != 3) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        scaleAnimation.setInterpolator(new PathInterpolator(0.41f, 0.23f, 0.25f, 1.0f));
        scaleAnimation.setDuration(600L);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(-1);
        startAnimation(scaleAnimation);
    }

    public void s() {
        RockView rockView;
        if (this.qg.rv() == 4 && (rockView = this.cp) != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(rockView, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setDuration(300L);
            objectAnimatorOfFloat.start();
            postDelayed(new Runnable() { // from class: com.byazt.hi.SplashClickBarBtn.5
                @Override // java.lang.Runnable
                public void run() {
                    if (SplashClickBarBtn.this.cp != null) {
                        SplashClickBarBtn.this.cp.n();
                    }
                }
            }, 500L);
        }
    }

    public void q() {
        if (this.qg.rv() != 7) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.byazt.hi.SplashClickBarBtn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SplashClickBarBtn.this.l != null) {
                        SplashClickBarBtn.this.l.n();
                    }
                } catch (Exception unused) {
                }
            }
        }, 500L);
    }

    private void tj() {
        el elVar = this.qg;
        if (elVar == null || elVar.rv() != 5) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.byazt.hi.SplashClickBarBtn.7
            @Override // java.lang.Runnable
            public void run() {
                if (SplashClickBarBtn.this.tj == null) {
                    return;
                }
                SplashClickBarBtn.this.tj.n();
                final AnimatorSet slideUpAnimatorSet = SplashClickBarBtn.this.tj.getSlideUpAnimatorSet();
                if (slideUpAnimatorSet == null) {
                    return;
                }
                slideUpAnimatorSet.start();
                slideUpAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.byazt.hi.SplashClickBarBtn.7.1
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
                        SplashClickBarBtn.this.postDelayed(new Runnable() { // from class: com.byazt.hi.SplashClickBarBtn.7.1.1
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

    public void n(com.byazt.ys.n nVar) {
        this.wm = nVar;
        if (this.qg.rv() == 4 || this.qg.rv() == 7 || this.qg.rv() == 5 || nVar == null) {
            return;
        }
        nVar.n(this);
        setOnClickListener(nVar);
        setOnTouchListener(nVar);
        setId(2114387633);
    }
}
