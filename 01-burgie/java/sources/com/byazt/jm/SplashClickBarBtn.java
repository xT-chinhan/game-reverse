package com.byazt.jm;

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
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.ca.ny;
import com.byazt.dx.LottieAnimationView;
import com.byazt.hg.of;
import com.byazt.hg.pq;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 1756})
public class SplashClickBarBtn extends RelativeLayout {
    public int[] a;
    public SplashClickBarArrow aj;
    public float b;
    public LottieAnimationView c;
    public boolean cz;
    public com.byazt.az.pr fo;
    public RelativeLayout fw;
    public Rect g;
    public JSONObject gz;
    public TextView hn;
    public Paint ho;
    public pq hw;
    public JSONObject iu;
    public AnimatorSet k;
    public final ValueAnimator lb;
    public Path m;
    public int nl;
    public final AnimatorSet nt;
    public ny ny;
    public GradientDrawable pr;
    public LinearGradient qa;
    public float rc;
    public RelativeLayout uc;
    public JSONObject ve;
    public SlideUpView vk;
    public RockView w;
    public of ww;
    public TextView x;
    public int y;
    public final ValueAnimator yb;
    public float z;
    public LinearLayout zo;

    public SplashClickBarBtn(Context context, of ofVar) {
        super(context);
        this.hw = new pq();
        this.nt = new AnimatorSet();
        this.yb = new ValueAnimator();
        this.lb = new ValueAnimator();
        this.a = new int[]{Color.parseColor("#00FFFFFF"), Color.parseColor("#47FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.cz = false;
        this.rc = 13.0f;
        this.b = 50.0f;
        this.ww = ofVar;
        c();
    }

    private View pr(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        relativeLayout.setClipChildren(false);
        layoutParams.addRule(14);
        relativeLayout.setId(2114387577);
        relativeLayout.setLayoutParams(layoutParams);
        this.uc = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.uc.setId(2114387576);
        this.uc.setClipChildren(false);
        layoutParams2.addRule(13);
        this.uc.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.uc);
        this.w = new RockView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        this.w.setId(2114387575);
        layoutParams3.addRule(14);
        this.w.setLayoutParams(layoutParams3);
        er.pr((View) this.w, 8);
        this.uc.addView(this.w);
        this.fw = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        this.fw.setId(2114387574);
        this.fw.setClipChildren(false);
        layoutParams4.addRule(13);
        this.fw.setGravity(17);
        this.fw.setLayoutParams(layoutParams4);
        this.uc.addView(this.fw);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(2, 2114387573);
        layoutParams5.addRule(14);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams5);
        this.fw.addView(linearLayout);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.c = lottieAnimationView;
        lottieAnimationView.setId(2114387572);
        this.c.setAnimation("lottie_json/twist_multi_angle.json");
        this.c.setImageAssetsFolder("images/");
        this.c.pr(true);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics()));
        layoutParams6.bottomMargin = er.hn(context, 4.0f);
        layoutParams6.gravity = 17;
        this.c.setLayoutParams(layoutParams6);
        linearLayout.addView(this.c);
        er.pr((View) this.c, 8);
        SlideUpView slideUpView = new SlideUpView(context);
        this.vk = slideUpView;
        slideUpView.setId(2114387569);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 200.0f, resources.getDisplayMetrics()));
        layoutParams7.topMargin = er.hn(context, -140.0f);
        this.vk.setLayoutParams(layoutParams7);
        linearLayout.addView(this.vk);
        er.pr((View) this.vk, 8);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.zo = linearLayout2;
        linearLayout2.setId(2114387573);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(12);
        this.zo.setGravity(17);
        this.zo.setOrientation(1);
        this.zo.setLayoutParams(layoutParams8);
        this.fw.addView(this.zo);
        TextView textView = new TextView(context);
        this.x = textView;
        textView.setId(2114387568);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        this.x.setSingleLine();
        this.x.setText("查看详情");
        this.x.setTextColor(-1);
        this.x.setTextSize(20.0f);
        this.x.setTypeface(Typeface.defaultFromStyle(1));
        this.x.setLayoutParams(layoutParams9);
        this.zo.addView(this.x);
        er.pr((View) this.x, 8);
        TextView textView2 = new TextView(context);
        this.hn = textView2;
        textView2.setId(2114387567);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        this.hn.setShadowLayer(2.0f, 0.0f, 0.5f, 1291845632);
        this.hn.setSingleLine();
        this.hn.setText("查看详情");
        this.hn.setTextColor(-1);
        this.hn.setTextSize(15.0f);
        this.hn.setTypeface(Typeface.defaultFromStyle(1));
        this.hn.setLayoutParams(layoutParams10);
        this.zo.addView(this.hn);
        er.pr((View) this.hn, 8);
        return relativeLayout;
    }

    private void c() {
        View viewPr = pr(getContext());
        if (viewPr == null) {
            return;
        }
        addView(viewPr);
        SplashClickBarArrow splashClickBarArrow = new SplashClickBarArrow(getContext());
        this.aj = splashClickBarArrow;
        this.uc.addView(splashClickBarArrow);
        this.aj.setClipChildren(false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aj.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.fw.getId());
        this.pr = pr(Color.parseColor("#57000000"));
        this.m = new Path();
        Paint paint = new Paint();
        this.ho = paint;
        paint.isAntiAlias();
    }

    private GradientDrawable pr(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        gradientDrawable.setSize(32, 12);
        gradientDrawable.setStroke(1, -2130706433);
        gradientDrawable.setCornerRadius(er.hn(a.getContext(), 50.0f));
        return gradientDrawable;
    }

    public void pr(pq pqVar) {
        if (pqVar == null) {
            return;
        }
        this.hw = pqVar;
        if (pqVar.aj() == 4) {
            this.w.pr(this.hw);
            return;
        }
        TextView textView = this.hn;
        if (textView != null) {
            textView.setVisibility(0);
            this.hn.setText(TextUtils.isEmpty(this.hw.hw()) ? "点击跳转至详情页或第三方应用" : this.hw.hw());
            if (this.hw.k() != null) {
                this.hn.setTextSize(2, this.hw.k().hw());
            }
        }
        if (this.x != null && this.hw.m() != null) {
            this.x.setTextSize(2, this.hw.m().hw());
        }
        this.pr.setColor(Color.parseColor("#57000000"));
        this.aj.pr(this.hw.aj());
        switch (this.hw.aj()) {
            case 1:
            case 2:
                AnimatorSet animatorSet = new AnimatorSet();
                this.k = animatorSet;
                animatorSet.playTogether(getAnimator(), this.aj.getAnimator());
                break;
            case 3:
                TextView textView2 = this.x;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                    this.x.setText(this.hw.w());
                }
                TextView textView3 = this.hn;
                if (textView3 != null) {
                    textView3.setTypeface(Typeface.defaultFromStyle(0));
                }
                this.pr = pr(Color.parseColor(this.hw.vk()));
                break;
            case 4:
                return;
            case 5:
                SlideUpView slideUpView = this.vk;
                if (slideUpView != null) {
                    slideUpView.setVisibility(0);
                }
                LinearLayout linearLayout = this.zo;
                if (linearLayout != null) {
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    layoutParams.width = -1;
                    this.zo.setLayoutParams(layoutParams);
                }
                TextView textView4 = this.x;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    this.x.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    if (TextUtils.isEmpty(this.hw.w())) {
                        this.x.setText("向上滑动");
                    } else {
                        this.x.setText(this.hw.w());
                    }
                }
                TextView textView5 = this.hn;
                if (textView5 != null) {
                    textView5.setText(TextUtils.isEmpty(this.hw.hw()) ? "滑动查看详情" : this.hw.hw());
                    this.hn.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                    return;
                }
                return;
            case 6:
            default:
                this.pr.setStroke(0, ViewCompat.MEASURED_STATE_MASK);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.k = animatorSet2;
                animatorSet2.playTogether(getAnimator(), this.aj.getAnimator());
                try {
                    setBackgroundColor(Color.parseColor(this.hw.vk()));
                } catch (Throwable th) {
                    setBackgroundColor(Color.parseColor("#008DEA"));
                }
                break;
            case 7:
                TextView textView6 = this.x;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    this.x.setText(this.hw.w());
                    this.x.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                TextView textView7 = this.hn;
                if (textView7 != null) {
                    textView7.setTypeface(Typeface.defaultFromStyle(0));
                    this.hn.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
                }
                LottieAnimationView lottieAnimationView = this.c;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                    return;
                }
                return;
        }
        setBackgroundDrawable(this.pr);
    }

    private void uc() {
        if (this.cz) {
        }
        this.cz = true;
        switch (this.hw.aj()) {
            case 1:
            case 2:
                zo();
                fw();
                break;
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.pr.setColor(i);
        setBackgroundDrawable(this.pr);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        uc();
        super.onDraw(canvas);
        if (this.yb.isRunning()) {
            this.ho.setShader(this.qa);
            canvas.drawRoundRect(new RectF(this.g), er.hn(getContext(), 50.0f), er.hn(getContext(), 50.0f), this.ho);
        }
    }

    private void fw() {
        int color = Color.parseColor("#57000000");
        int color2 = Color.parseColor(this.hw.vk());
        this.pr.setColor(color);
        if (Build.VERSION.SDK_INT < 21) {
            this.lb.setObjectValues(Integer.valueOf(color), Integer.valueOf(color2));
            this.lb.setEvaluator(new vk());
        } else {
            this.lb.setIntValues(color, color2);
            this.lb.setEvaluator(new ArgbEvaluator());
        }
        this.lb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.jm.SplashClickBarBtn.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashClickBarBtn.this.pr.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                SplashClickBarBtn splashClickBarBtn = SplashClickBarBtn.this;
                splashClickBarBtn.setBackgroundDrawable(splashClickBarBtn.pr);
            }
        });
        this.lb.setDuration(300L);
        this.lb.setStartDelay(800L);
        this.lb.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.nt.playTogether(this.lb);
    }

    private void zo() {
        Point point = new Point(0, 0);
        Point point2 = new Point(getMeasuredWidth(), 0);
        Point point3 = new Point(getMeasuredWidth(), getMeasuredHeight());
        Point point4 = new Point(0, getMeasuredHeight());
        this.m.moveTo(point.x, point.y);
        this.m.lineTo(point2.x, point2.y);
        this.m.lineTo(point3.x, point3.y);
        this.m.lineTo(point4.x, point4.y);
        this.m.close();
        this.g = getBackground().getBounds();
        final int iHn = er.hn(getContext(), 36.0f);
        final int iHn2 = er.hn(getContext(), 45.0f);
        this.yb.setIntValues(point.x - iHn, point2.x + iHn);
        this.yb.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        this.yb.setDuration(1600L);
        this.yb.setStartDelay(1300L);
        this.yb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.jm.SplashClickBarBtn.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SplashClickBarBtn.this.qa = new LinearGradient(iIntValue, 0.0f, iIntValue + iHn, iHn2, SplashClickBarBtn.this.a, (float[]) null, Shader.TileMode.CLAMP);
                SplashClickBarBtn.this.postInvalidate();
            }
        });
        this.nt.playTogether(this.yb);
    }

    public Animator getAnimator() {
        return this.nt;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ny nyVar = this.ny;
        if (nyVar != null) {
            if (z) {
                of ofVar = this.ww;
                nyVar.pr(ofVar != null ? ofVar.nl() : 0);
            } else {
                of ofVar2 = this.ww;
                nyVar.hw(ofVar2 != null ? ofVar2.nl() : 0);
            }
        }
    }

    public ny getShakeUtils() {
        return this.ny;
    }

    public void setShakeValue(float f) {
        this.rc = f;
    }

    public void setDeepShakeValue(float f) {
        this.z = f;
    }

    public void setWriggleValue(float f) {
        this.b = f;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.iu = jSONObject;
    }

    public void setShakeInteractConf(JSONObject jSONObject) {
        this.ve = jSONObject;
    }

    public void setTwistInteractConf(JSONObject jSONObject) {
        this.gz = jSONObject;
    }

    public void setCalculationMethod(int i) {
        this.nl = i;
    }

    public void setCalculationTwistMethod(int i) {
        this.y = i;
    }

    private void aj() {
        if (this.hw == null || !isShown()) {
            return;
        }
        if (this.hw.aj() != 4 && this.hw.aj() != 7) {
            return;
        }
        if (this.ny == null) {
            if (this.hw.aj() == 4) {
                this.ny = new ny(a.getContext(), 1, com.byazt.sd.zo.nt().x());
            } else if (this.hw.aj() == 7) {
                this.ny = new ny(a.getContext(), 2, com.byazt.sd.zo.nt().x());
            }
        }
        this.ny.pr(this.rc);
        this.ny.hn(this.z);
        this.ny.hw(this.b);
        this.ny.pr(this.iu);
        this.ny.hn(this.ve);
        this.ny.hw(this.gz);
        this.ny.c(this.nl);
        this.ny.uc(this.y);
        this.ny.pr(new ny.pr() { // from class: com.byazt.jm.SplashClickBarBtn.3
            @Override // com.byazt.ca.ny.pr
            public void pr(int i) {
                if (SplashClickBarBtn.this.fo != null && SplashClickBarBtn.this.isShown()) {
                    if (SplashClickBarBtn.this.ny.pr() && SplashClickBarBtn.this.ww != null) {
                        com.byazt.wr.uc.x = true;
                    }
                    switch (i) {
                        case 1:
                            if (SplashClickBarBtn.this.hw.aj() == 4) {
                                ((com.byazt.yx.pr) SplashClickBarBtn.this.fo.pr(com.byazt.yx.pr.class)).pr();
                                SplashClickBarBtn.this.fo.onClick(SplashClickBarBtn.this);
                            }
                            break;
                        case 2:
                            if (SplashClickBarBtn.this.hw.aj() == 7) {
                                ((com.byazt.yx.pr) SplashClickBarBtn.this.fo.pr(com.byazt.yx.pr.class)).hw();
                                SplashClickBarBtn.this.fo.onClick(SplashClickBarBtn.this);
                            }
                            break;
                    }
                }
            }
        });
        ny nyVar = this.ny;
        of ofVar = this.ww;
        nyVar.pr(ofVar != null ? ofVar.nl() : 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aj();
        post(new Runnable() { // from class: com.byazt.jm.SplashClickBarBtn.4
            @Override // java.lang.Runnable
            public void run() {
                SplashClickBarBtn.this.pr();
            }
        });
    }

    public void pr() {
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.start();
        }
        hw();
        hn();
        x();
        vk();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ny nyVar = this.ny;
        if (nyVar != null) {
            of ofVar = this.ww;
            nyVar.hw(ofVar != null ? ofVar.nl() : 0);
        }
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.nt;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        SlideUpView slideUpView = this.vk;
        if (slideUpView != null) {
            slideUpView.hw();
        }
        LottieAnimationView lottieAnimationView = this.c;
        if (lottieAnimationView != null) {
            lottieAnimationView.uc();
        }
    }

    public void hw() {
        if (this.hw.aj() != 3) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.05f, 1.0f, 1.05f, getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        scaleAnimation.setInterpolator(new PathInterpolator(0.41f, 0.23f, 0.25f, 1.0f));
        scaleAnimation.setDuration(600L);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(-1);
        startAnimation(scaleAnimation);
    }

    public void hn() {
        RockView rockView;
        if (this.hw.aj() != 4 || (rockView = this.w) == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(rockView, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
        postDelayed(new Runnable() { // from class: com.byazt.jm.SplashClickBarBtn.5
            @Override // java.lang.Runnable
            public void run() {
                if (SplashClickBarBtn.this.w != null) {
                    SplashClickBarBtn.this.w.pr();
                }
            }
        }, 500L);
    }

    public void x() {
        if (this.hw.aj() != 7) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.byazt.jm.SplashClickBarBtn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SplashClickBarBtn.this.c != null) {
                        SplashClickBarBtn.this.c.pr();
                    }
                } catch (Exception e) {
                }
            }
        }, 500L);
    }

    private void vk() {
        pq pqVar = this.hw;
        if (pqVar == null || pqVar.aj() != 5) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.byazt.jm.SplashClickBarBtn.7
            @Override // java.lang.Runnable
            public void run() {
                if (SplashClickBarBtn.this.vk != null) {
                    SplashClickBarBtn.this.vk.pr();
                    final AnimatorSet slideUpAnimatorSet = SplashClickBarBtn.this.vk.getSlideUpAnimatorSet();
                    if (slideUpAnimatorSet == null) {
                        return;
                    }
                    slideUpAnimatorSet.start();
                    slideUpAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.byazt.jm.SplashClickBarBtn.7.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            SplashClickBarBtn.this.postDelayed(new Runnable() { // from class: com.byazt.jm.SplashClickBarBtn.7.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    slideUpAnimatorSet.start();
                                }
                            }, 200L);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                }
            }
        }, 500L);
    }

    public void pr(com.byazt.az.pr prVar) {
        this.fo = prVar;
        if (this.hw.aj() != 4 && this.hw.aj() != 7 && this.hw.aj() != 5 && prVar != null) {
            prVar.pr(this);
            setOnClickListener(prVar);
            setOnTouchListener(prVar);
            setId(2114387633);
        }
    }
}
