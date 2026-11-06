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
import com.byazt.ca.ho;
import com.byazt.wt.er;
import com.byazt.xhr.BottomGradientHintView;
import com.byazt.xk.hw;

/* JADX INFO: loaded from: classes2.dex */
public class TTSevenScreenWebPageActivity extends TTWebPageActivity {
    private float d;
    private View f;
    private float gu;
    private float hs;
    private View i;
    private GestureDetector ie;
    private int ii;
    private boolean jw;
    private BottomGradientHintView mw;
    private float nw;
    private GestureDetector o;
    private float od;
    private int of;
    private boolean pq;
    private int qi;
    private int qn;
    private FrameLayout r;
    private long sv;
    private boolean wt;
    private boolean ls = false;
    private boolean er = false;
    private boolean v = false;
    private int bm = 0;
    private Rect jn = new Rect();
    private Rect l = new Rect();
    private Rect lv = new Rect();
    private boolean vj = true;

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity, com.byazt.rg.BaseLandingPageActivity
    public View fw() {
        g();
        this.f = super.fw();
        FrameLayout frameLayout = new FrameLayout(this);
        this.r = frameLayout;
        if (this.f == null) {
            ho.pr("mSevenScreenContainer is null");
            hw.pr().pr("sc_finish", (Throwable) null);
            finish();
            return this.r;
        }
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.i = new View(this);
        this.i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.i.setBackgroundColor(Integer.MIN_VALUE);
        this.i.setAlpha(0.0f);
        this.i.setVisibility(8);
        this.r.addView(this.i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = this.qi;
        this.f.setLayoutParams(layoutParams);
        this.f.setBackgroundColor(-1);
        this.r.addView(this.f);
        return this.r;
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity
    protected int k() {
        return -1;
    }

    private boolean pr(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.hs = motionEvent.getY();
                this.od = 0.0f;
                return false;
            case 1:
            default:
                return false;
            case 2:
                float y = motionEvent.getY() - this.hs;
                this.od = y;
                return this.vj && y > 0.0f;
        }
    }

    private boolean hw(MotionEvent motionEvent) {
        boolean z = false;
        switch (motionEvent.getAction()) {
            case 0:
                this.sv = System.currentTimeMillis();
                this.gu = motionEvent.getX();
                this.d = motionEvent.getY();
                this.hs = motionEvent.getY();
                this.od = 0.0f;
                break;
            case 2:
                float fAbs = Math.abs(motionEvent.getX() - this.gu);
                float fAbs2 = Math.abs(motionEvent.getY() - this.d);
                float fHn = er.hn(this.c, 5.0f);
                if (fAbs > fHn || fAbs2 > fHn) {
                    z = true;
                }
                break;
        }
        BottomGradientHintView bottomGradientHintView = this.mw;
        if (bottomGradientHintView != null && bottomGradientHintView.getVisibility() == 0) {
            this.mw.setVisibility(8);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hn(MotionEvent motionEvent) {
        if (this.g != null) {
            this.g.getHitRect(this.jn);
        }
        if (this.ho != null) {
            this.ho.getHitRect(this.l);
        }
        if (this.yb != null) {
            this.yb.getHitRect(this.lv);
        }
        this.pq = this.jn.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        this.jw = this.l.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        boolean zContains = this.lv.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        this.wt = zContains;
        if (this.pq || this.jw || zContains || this.v || !this.ls) {
            return false;
        }
        return this.er ? pr(motionEvent) : hw(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                int iNt = nt();
                if (!this.er) {
                    int i = iNt - this.qi;
                    if (i > this.ii) {
                        lb();
                    } else if (Math.abs(i) > this.ii) {
                        qa();
                    } else {
                        a();
                    }
                } else if (iNt > this.ii) {
                    a();
                } else {
                    this.er = false;
                    qa();
                }
                return true;
            case 2:
                hw((int) Math.min(Math.max(this.nw + (motionEvent.getY() - this.hs), 0.0f), this.qn));
                return true;
            default:
                return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity
    protected LinearLayout m() {
        return new LinearLayout(this.c) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.1
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return TTSevenScreenWebPageActivity.this.hn(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (TTSevenScreenWebPageActivity.this.v || !TTSevenScreenWebPageActivity.this.ls || TTSevenScreenWebPageActivity.this.pq || TTSevenScreenWebPageActivity.this.jw || TTSevenScreenWebPageActivity.this.wt) {
                    return false;
                }
                return TTSevenScreenWebPageActivity.this.x(motionEvent) || super.onTouchEvent(motionEvent);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.rg.BaseLandingPageActivity
    public void hn() {
        super.hn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.rg.BaseLandingPageActivity
    public boolean zo() {
        if (super.zo()) {
            return true;
        }
        lb();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.rg.BaseLandingPageActivity
    public void x() {
        pr("detail_skip");
        lb();
    }

    private void g() {
        int i = getResources().getDisplayMetrics().heightPixels;
        this.qn = i;
        this.of = i;
        this.qi = (int) (i * 0.3f);
        this.ii = er.hn(this, 55.0f);
        this.bm = er.hn(this, 44.0f);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity, com.byazt.rg.BaseLandingPageActivity
    public void c() {
        super.c();
        this.mw = new BottomGradientHintView(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, er.hn(this, 80.0f));
        layoutParams.gravity = 80;
        this.mw.setVisibility(8);
        this.mw.setAlpha(0.0f);
        this.r.addView(this.mw, layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity, com.byazt.rg.BaseLandingPageActivity
    public void uc() {
        super.uc();
        ho();
        yb();
    }

    private void ho() {
        this.ie = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.12
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (TTSevenScreenWebPageActivity.this.ls && !TTSevenScreenWebPageActivity.this.v) {
                    TTSevenScreenWebPageActivity.this.lb();
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (TTSevenScreenWebPageActivity.this.ls && !TTSevenScreenWebPageActivity.this.v) {
                    TTSevenScreenWebPageActivity.this.lb();
                    return true;
                }
                return false;
            }
        });
        this.o = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.17
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (TTSevenScreenWebPageActivity.this.ls && !TTSevenScreenWebPageActivity.this.v) {
                    TTSevenScreenWebPageActivity.this.hs = motionEvent.getY();
                    TTSevenScreenWebPageActivity tTSevenScreenWebPageActivity = TTSevenScreenWebPageActivity.this;
                    tTSevenScreenWebPageActivity.nw = tTSevenScreenWebPageActivity.nt();
                    return true;
                }
                return true;
            }
        });
        this.i.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (TTSevenScreenWebPageActivity.this.ls) {
                    return TTSevenScreenWebPageActivity.this.ie.onTouchEvent(motionEvent);
                }
                return false;
            }
        });
        this.f.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.19
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (TTSevenScreenWebPageActivity.this.ls) {
                    return TTSevenScreenWebPageActivity.this.o.onTouchEvent(motionEvent);
                }
                return false;
            }
        });
        if (this.ny != null) {
            this.ny.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.20
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!TTSevenScreenWebPageActivity.this.ls || TTSevenScreenWebPageActivity.this.er || TTSevenScreenWebPageActivity.this.pq || TTSevenScreenWebPageActivity.this.jw || TTSevenScreenWebPageActivity.this.wt) {
                        return false;
                    }
                    switch (motionEvent.getAction()) {
                        case 0:
                            TTSevenScreenWebPageActivity.this.sv = System.currentTimeMillis();
                            TTSevenScreenWebPageActivity.this.gu = motionEvent.getX();
                            TTSevenScreenWebPageActivity.this.d = motionEvent.getY();
                            return false;
                        case 1:
                        case 3:
                            long jCurrentTimeMillis = System.currentTimeMillis() - TTSevenScreenWebPageActivity.this.sv;
                            float fAbs = Math.abs(motionEvent.getX() - TTSevenScreenWebPageActivity.this.gu);
                            float fAbs2 = Math.abs(motionEvent.getY() - TTSevenScreenWebPageActivity.this.d);
                            int iHn = er.hn(TTSevenScreenWebPageActivity.this.c, 5.0f);
                            if (jCurrentTimeMillis < 200) {
                                float f = iHn;
                                if (fAbs < f && fAbs2 < f) {
                                    return false;
                                }
                            }
                            return true;
                        case 2:
                            return true;
                        default:
                            return false;
                    }
                }
            });
            this.ny.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.21
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    TTSevenScreenWebPageActivity.this.vj = i2 == 0;
                }
            });
        }
        if (this.g != null) {
            this.g.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.22
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.performClick();
                    }
                    return true;
                }
            });
        }
        if (this.ho != null) {
            this.ho.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.23
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.performClick();
                    }
                    return true;
                }
            });
        }
        if (this.yb != null) {
            this.yb.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.2
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
    public void hw(int i) {
        View view = this.f;
        if (view == null) {
            return;
        }
        try {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i;
            this.f.setLayoutParams(layoutParams);
            this.nw = i;
        } catch (Exception e) {
            hw.pr().pr("sc_updateContainerTop", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nt() {
        try {
            return ((FrameLayout.LayoutParams) this.f.getLayoutParams()).topMargin;
        } catch (Exception e) {
            hw.pr().pr("sc_getContainerTop", e);
            return (int) this.nw;
        }
    }

    private void yb() {
        this.v = true;
        this.i.setVisibility(0);
        this.mw.setVisibility(0);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (TTSevenScreenWebPageActivity.this.i != null) {
                    TTSevenScreenWebPageActivity.this.i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                if (TTSevenScreenWebPageActivity.this.mw != null) {
                    TTSevenScreenWebPageActivity.this.mw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTSevenScreenWebPageActivity.this.mw != null) {
                    TTSevenScreenWebPageActivity.this.mw.pr();
                }
            }
        });
        valueAnimatorOfFloat.start();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.qn, this.qi);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTSevenScreenWebPageActivity.this.hw(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TTSevenScreenWebPageActivity.this.ls = true;
                TTSevenScreenWebPageActivity.this.v = false;
                TTSevenScreenWebPageActivity tTSevenScreenWebPageActivity = TTSevenScreenWebPageActivity.this;
                tTSevenScreenWebPageActivity.nw = tTSevenScreenWebPageActivity.qi;
                if (TTSevenScreenWebPageActivity.this.mw != null) {
                    TTSevenScreenWebPageActivity.this.mw.setVisibility(0);
                }
            }
        });
        valueAnimatorOfInt.start();
        pr(er.hn(this, 20.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lb() {
        this.v = true;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (TTSevenScreenWebPageActivity.this.i != null) {
                    TTSevenScreenWebPageActivity.this.i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
                if (TTSevenScreenWebPageActivity.this.mw != null) {
                    TTSevenScreenWebPageActivity.this.mw.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTSevenScreenWebPageActivity.this.i != null) {
                    TTSevenScreenWebPageActivity.this.i.setVisibility(8);
                }
                if (TTSevenScreenWebPageActivity.this.mw != null) {
                    TTSevenScreenWebPageActivity.this.mw.setVisibility(8);
                }
            }
        });
        valueAnimatorOfFloat.start();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(nt(), this.qn);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTSevenScreenWebPageActivity.this.hw(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TTSevenScreenWebPageActivity.this.ls = false;
                TTSevenScreenWebPageActivity.this.er = false;
                TTSevenScreenWebPageActivity.this.v = false;
                TTSevenScreenWebPageActivity.this.finish();
            }
        });
        valueAnimatorOfInt.start();
    }

    private void qa() {
        if (this.v || this.er) {
            return;
        }
        this.v = true;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(nt(), 0);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTSevenScreenWebPageActivity.this.hw(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TTSevenScreenWebPageActivity.this.er = true;
                TTSevenScreenWebPageActivity.this.v = false;
                TTSevenScreenWebPageActivity.this.nw = 0.0f;
                if (TTSevenScreenWebPageActivity.this.mw != null) {
                    TTSevenScreenWebPageActivity.this.mw.setVisibility(8);
                }
                TTSevenScreenWebPageActivity.this.pr(0.0f);
            }
        });
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final float f) {
        View view = this.f;
        if (view != null) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.14
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
                }
            });
            this.f.setClipToOutline(true);
        }
    }

    private void a() {
        if (this.v || !this.ls) {
            return;
        }
        this.v = true;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(nt(), this.qi);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TTSevenScreenWebPageActivity.this.hw(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity.16
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TTSevenScreenWebPageActivity.this.er = false;
                TTSevenScreenWebPageActivity.this.v = false;
                TTSevenScreenWebPageActivity tTSevenScreenWebPageActivity = TTSevenScreenWebPageActivity.this;
                tTSevenScreenWebPageActivity.nw = tTSevenScreenWebPageActivity.qi;
            }
        });
        valueAnimatorOfInt.start();
        pr(er.hn(this, 20.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity, com.byazt.rg.BaseLandingPageActivity, com.byazt.rg.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BottomGradientHintView bottomGradientHintView = this.mw;
        if (bottomGradientHintView != null) {
            bottomGradientHintView.hw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.rg.BaseLandingPageActivity
    public void vk() {
    }
}
