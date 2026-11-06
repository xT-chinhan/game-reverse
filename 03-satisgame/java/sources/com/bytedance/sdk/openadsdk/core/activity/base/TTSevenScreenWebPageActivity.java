package com.bytedance.sdk.openadsdk.core.activity.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.byazt.eji.s;
import com.byazt.lv.BottomGradientHintView;
import com.byazt.tk.k;

/* JADX INFO: loaded from: classes2.dex */
public class TTSevenScreenWebPageActivity extends TTWebPageActivity {
    private GestureDetector b;
    private long ci;
    private float cx;
    private int dg;
    private GestureDetector dh;
    private boolean dn;
    private boolean he;
    private float hf;
    private BottomGradientHintView ic;
    private float kc;
    private int oj;
    private int pk;
    private float rf;
    private View ri;
    private FrameLayout sh;
    private int u;
    private View wo;
    private float y;
    private boolean z;
    private boolean f = false;
    private boolean fi = false;
    private boolean df = false;
    private int nf = 0;
    private Rect pe = new Rect();
    private Rect e = new Rect();
    private Rect yw = new Rect();
    private boolean lq = true;

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity
    protected int d() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.pt.BaseLandingPageActivity
    public void tj() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity, com.byazt.pt.BaseLandingPageActivity
    public View x() {
        sz();
        this.ri = super.x();
        FrameLayout frameLayout = new FrameLayout(this);
        this.sh = frameLayout;
        if (this.ri == null) {
            k.n("mSevenScreenContainer is null");
            s.n().n("sc_finish", (Throwable) null);
            finish();
            return this.sh;
        }
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.wo = new View(this);
        this.wo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.wo.setBackgroundColor(Integer.MIN_VALUE);
        this.wo.setAlpha(0.0f);
        this.wo.setVisibility(8);
        this.sh.addView(this.wo);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = this.oj;
        this.ri.setLayoutParams(layoutParams);
        this.ri.setBackgroundColor(-1);
        this.sh.addView(this.ri);
        return this.sh;
    }

    private boolean n(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.y = motionEvent.getY();
            this.cx = 0.0f;
            return false;
        }
        if (action != 2) {
            return false;
        }
        float y = motionEvent.getY() - this.y;
        this.cx = y;
        return this.lq && y > 0.0f;
    }

    private boolean qg(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.ci = System.currentTimeMillis();
            this.hf = motionEvent.getX();
            this.kc = motionEvent.getY();
            this.y = motionEvent.getY();
            this.cx = 0.0f;
        } else if (action == 2) {
            float fAbs = Math.abs(motionEvent.getX() - this.hf);
            float fAbs2 = Math.abs(motionEvent.getY() - this.kc);
            float fS = com.byazt.okk.s.s(this.l, 5.0f);
            if (fAbs > fS || fAbs2 > fS) {
                z = true;
            }
        }
        BottomGradientHintView bottomGradientHintView = this.ic;
        if (bottomGradientHintView != null && bottomGradientHintView.getVisibility() == 0) {
            this.ic.setVisibility(8);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(MotionEvent motionEvent) {
        if (this.sz != null) {
            this.sz.getHitRect(this.pe);
        }
        if (this.k != null) {
            this.k.getHitRect(this.e);
        }
        if (this.hd != null) {
            this.hd.getHitRect(this.yw);
        }
        this.z = this.pe.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        this.dn = this.e.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        boolean zContains = this.yw.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        this.he = zContains;
        if (this.z || this.dn || zContains || this.df || !this.f) {
            return false;
        }
        return this.fi ? n(motionEvent) : qg(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                qg((int) Math.min(Math.max(this.rf + (motionEvent.getY() - this.y), 0.0f), this.dg));
                return true;
            }
            if (action != 3) {
                return false;
            }
        }
        int iCy = cy();
        if (!this.fi) {
            int i = iCy - this.oj;
            if (i > this.pk) {
                cd();
                return true;
            }
            if (Math.abs(i) > this.pk) {
                um();
                return true;
            }
            a();
            return true;
        }
        if (iCy > this.pk) {
            a();
            return true;
        }
        this.fi = false;
        um();
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity
    protected LinearLayout oa() {
        return new LinearLayout(this.l) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.1
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return TTSevenScreenWebPageActivity.this.s(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (TTSevenScreenWebPageActivity.this.df || !TTSevenScreenWebPageActivity.this.f || TTSevenScreenWebPageActivity.this.z || TTSevenScreenWebPageActivity.this.dn || TTSevenScreenWebPageActivity.this.he) {
                    return false;
                }
                return TTSevenScreenWebPageActivity.this.q(motionEvent) || super.onTouchEvent(motionEvent);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.pt.BaseLandingPageActivity
    public void s() {
        super.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.pt.BaseLandingPageActivity
    public boolean fs() {
        if (!super.fs()) {
            cd();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.pt.BaseLandingPageActivity
    public void q() {
        n("detail_skip");
        cd();
    }

    private void sz() {
        int i = getResources().getDisplayMetrics().heightPixels;
        this.dg = i;
        this.u = i;
        this.oj = (int) (i * 0.3f);
        this.pk = com.byazt.okk.s.s(this, 55.0f);
        this.nf = com.byazt.okk.s.s(this, 44.0f);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity, com.byazt.pt.BaseLandingPageActivity
    public void l() {
        super.l();
        this.ic = new BottomGradientHintView(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.byazt.okk.s.s(this, 80.0f));
        layoutParams.gravity = 80;
        this.ic.setVisibility(8);
        this.ic.setAlpha(0.0f);
        this.sh.addView(this.ic, layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity, com.byazt.pt.BaseLandingPageActivity
    public void w() {
        super.w();
        k();
        hd();
    }

    private void k() {
        this.dh = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.12
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!TTSevenScreenWebPageActivity.this.f || TTSevenScreenWebPageActivity.this.df) {
                    return false;
                }
                TTSevenScreenWebPageActivity.this.cd();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (!TTSevenScreenWebPageActivity.this.f || TTSevenScreenWebPageActivity.this.df) {
                    return false;
                }
                TTSevenScreenWebPageActivity.this.cd();
                return true;
            }
        });
        this.b = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.17
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!TTSevenScreenWebPageActivity.this.f || TTSevenScreenWebPageActivity.this.df) {
                    return true;
                }
                TTSevenScreenWebPageActivity.this.y = motionEvent.getY();
                TTSevenScreenWebPageActivity tTSevenScreenWebPageActivity = TTSevenScreenWebPageActivity.this;
                tTSevenScreenWebPageActivity.rf = tTSevenScreenWebPageActivity.cy();
                return true;
            }
        });
        this.wo.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (TTSevenScreenWebPageActivity.this.f) {
                    return TTSevenScreenWebPageActivity.this.dh.onTouchEvent(motionEvent);
                }
                return false;
            }
        });
        this.ri.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.19
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (TTSevenScreenWebPageActivity.this.f) {
                    return TTSevenScreenWebPageActivity.this.b.onTouchEvent(motionEvent);
                }
                return false;
            }
        });
        if (this.ou != null) {
            this.ou.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.20
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (TTSevenScreenWebPageActivity.this.f && !TTSevenScreenWebPageActivity.this.fi && !TTSevenScreenWebPageActivity.this.z && !TTSevenScreenWebPageActivity.this.dn && !TTSevenScreenWebPageActivity.this.he) {
                        int action = motionEvent.getAction();
                        if (action != 0) {
                            if (action != 1) {
                                if (action == 2) {
                                    return true;
                                }
                                if (action != 3) {
                                    return false;
                                }
                            }
                            long jCurrentTimeMillis = System.currentTimeMillis() - TTSevenScreenWebPageActivity.this.ci;
                            float fAbs = Math.abs(motionEvent.getX() - TTSevenScreenWebPageActivity.this.hf);
                            float fAbs2 = Math.abs(motionEvent.getY() - TTSevenScreenWebPageActivity.this.kc);
                            int iS = com.byazt.okk.s.s(TTSevenScreenWebPageActivity.this.l, 5.0f);
                            if (jCurrentTimeMillis < 200) {
                                float f = iS;
                                if (fAbs < f && fAbs2 < f) {
                                    return false;
                                }
                            }
                            return true;
                        }
                        TTSevenScreenWebPageActivity.this.ci = System.currentTimeMillis();
                        TTSevenScreenWebPageActivity.this.hf = motionEvent.getX();
                        TTSevenScreenWebPageActivity.this.kc = motionEvent.getY();
                    }
                    return false;
                }
            });
            this.ou.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.21
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    TTSevenScreenWebPageActivity.this.lq = i2 == 0;
                }
            });
        }
        if (this.sz != null) {
            this.sz.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.22
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.performClick();
                    }
                    return true;
                }
            });
        }
        if (this.k != null) {
            this.k.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.23
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.performClick();
                    }
                    return true;
                }
            });
        }
        if (this.hd != null) {
            this.hd.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.performClick();
                    }
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(int i) {
        View view = this.ri;
        if (view == null) {
            return;
        }
        try {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i;
            this.ri.setLayoutParams(layoutParams);
            this.rf = i;
        } catch (Exception e) {
            s.n().n("sc_updateContainerTop", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cy() {
        try {
            return ((FrameLayout.LayoutParams) this.ri.getLayoutParams()).topMargin;
        } catch (Exception e) {
            s.n().n("sc_getContainerTop", e);
            return (int) this.rf;
        }
    }

    private void hd() {
        this.df = true;
        this.wo.setVisibility(0);
        this.ic.setVisibility(0);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (TTSevenScreenWebPageActivity.this.wo != null) {
                    TTSevenScreenWebPageActivity.this.wo.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                if (TTSevenScreenWebPageActivity.this.ic != null) {
                    TTSevenScreenWebPageActivity.this.ic.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTSevenScreenWebPageActivity.this.ic != null) {
                    TTSevenScreenWebPageActivity.this.ic.n();
                }
            }
        });
        valueAnimatorOfFloat.start();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.dg, this.oj);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTSevenScreenWebPageActivity.this.qg(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TTSevenScreenWebPageActivity.this.f = true;
                TTSevenScreenWebPageActivity.this.df = false;
                TTSevenScreenWebPageActivity tTSevenScreenWebPageActivity = TTSevenScreenWebPageActivity.this;
                tTSevenScreenWebPageActivity.rf = tTSevenScreenWebPageActivity.oj;
                if (TTSevenScreenWebPageActivity.this.ic != null) {
                    TTSevenScreenWebPageActivity.this.ic.setVisibility(0);
                }
            }
        });
        valueAnimatorOfInt.start();
        n(com.byazt.okk.s.s(this, 20.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd() {
        this.df = true;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (TTSevenScreenWebPageActivity.this.wo != null) {
                    TTSevenScreenWebPageActivity.this.wo.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                if (TTSevenScreenWebPageActivity.this.ic != null) {
                    TTSevenScreenWebPageActivity.this.ic.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTSevenScreenWebPageActivity.this.wo != null) {
                    TTSevenScreenWebPageActivity.this.wo.setVisibility(8);
                }
                if (TTSevenScreenWebPageActivity.this.ic != null) {
                    TTSevenScreenWebPageActivity.this.ic.setVisibility(8);
                }
            }
        });
        valueAnimatorOfFloat.start();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(cy(), this.dg);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTSevenScreenWebPageActivity.this.qg(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TTSevenScreenWebPageActivity.this.f = false;
                TTSevenScreenWebPageActivity.this.fi = false;
                TTSevenScreenWebPageActivity.this.df = false;
                TTSevenScreenWebPageActivity.this.finish();
            }
        });
        valueAnimatorOfInt.start();
    }

    private void um() {
        if (this.df || this.fi) {
            return;
        }
        this.df = true;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(cy(), 0);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTSevenScreenWebPageActivity.this.qg(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TTSevenScreenWebPageActivity.this.fi = true;
                TTSevenScreenWebPageActivity.this.df = false;
                TTSevenScreenWebPageActivity.this.rf = 0.0f;
                if (TTSevenScreenWebPageActivity.this.ic != null) {
                    TTSevenScreenWebPageActivity.this.ic.setVisibility(8);
                }
                TTSevenScreenWebPageActivity.this.n(0.0f);
            }
        });
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final float f) {
        View view = this.ri;
        if (view != null) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.14
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
                }
            });
            this.ri.setClipToOutline(true);
        }
    }

    private void a() {
        if (this.df || !this.f) {
            return;
        }
        this.df = true;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(cy(), this.oj);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTSevenScreenWebPageActivity.this.qg(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.16
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TTSevenScreenWebPageActivity.this.fi = false;
                TTSevenScreenWebPageActivity.this.df = false;
                TTSevenScreenWebPageActivity tTSevenScreenWebPageActivity = TTSevenScreenWebPageActivity.this;
                tTSevenScreenWebPageActivity.rf = tTSevenScreenWebPageActivity.oj;
            }
        });
        valueAnimatorOfInt.start();
        n(com.byazt.okk.s.s(this, 20.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity, com.byazt.pt.BaseLandingPageActivity, com.byazt.pt.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BottomGradientHintView bottomGradientHintView = this.ic;
        if (bottomGradientHintView != null) {
            bottomGradientHintView.qg();
        }
    }
}
