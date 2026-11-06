package com.anythink.basead.ui.guidetoclickv2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class FullOrientationG2CV2View extends BaseG2CV2View {
    public static final int DEFAULT_SIZE = 120;
    ValueAnimator d;
    ViewGroup e;
    ImageView f;
    c g;
    RelativeLayout.LayoutParams h;
    private int i;
    private float j;
    private float k;
    private float l;
    private float m;
    private int n;
    private int o;

    public static class a {
        public static final int a = 501;
        public static final int b = 502;
        public static final int c = 504;
        public static final int d = 505;
        public static final int e = 507;
    }

    static /* synthetic */ int b(FullOrientationG2CV2View fullOrientationG2CV2View) {
        int i = fullOrientationG2CV2View.i;
        fullOrientationG2CV2View.i = i + 1;
        return i;
    }

    static /* synthetic */ float c(FullOrientationG2CV2View fullOrientationG2CV2View, float f) {
        float f2 = fullOrientationG2CV2View.l + f;
        fullOrientationG2CV2View.l = f2;
        return f2;
    }

    static /* synthetic */ float d(FullOrientationG2CV2View fullOrientationG2CV2View, float f) {
        float f2 = fullOrientationG2CV2View.m + f;
        fullOrientationG2CV2View.m = f2;
        return f2;
    }

    public FullOrientationG2CV2View(Context context) {
        super(context);
        this.i = 0;
        this.o = q.a(getContext(), 120.0f);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    final void a(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_g2c_v2_full_orientation", "layout"), this);
        this.n = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        ViewGroup viewGroup = (ViewGroup) findViewById(q.a(getContext(), "myoffer_g2c_fullori_container", "id"));
        this.e = viewGroup;
        RelativeLayout.LayoutParams layoutParams = this.h;
        if (layoutParams != null) {
            viewGroup.setLayoutParams(layoutParams);
        }
        this.f = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_fullori_finger", "id"));
        if (this.d == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, q.a(getContext(), 12.0f), 0.0f);
            this.d = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(500L);
            this.d.setRepeatCount(-1);
            this.d.addUpdateListener(new AnonymousClass1());
            this.d.addListener(new AnonymousClass2());
        }
    }

    private void d() {
        if (this.d == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, q.a(getContext(), 12.0f), 0.0f);
            this.d = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(500L);
            this.d.setRepeatCount(-1);
            this.d.addUpdateListener(new AnonymousClass1());
            this.d.addListener(new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View$1, reason: invalid class name */
    final class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (FullOrientationG2CV2View.this.f != null) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = FullOrientationG2CV2View.this.i % 4;
                if (i == 1) {
                    FullOrientationG2CV2View.this.f.setTranslationY(fFloatValue);
                    return;
                }
                if (i == 2) {
                    FullOrientationG2CV2View.this.f.setTranslationX(-fFloatValue);
                } else if (i == 3) {
                    FullOrientationG2CV2View.this.f.setTranslationX(fFloatValue);
                } else {
                    FullOrientationG2CV2View.this.f.setTranslationY(-fFloatValue);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View$2, reason: invalid class name */
    final class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            FullOrientationG2CV2View.b(FullOrientationG2CV2View.this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        c cVar;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        while (true) {
            if (parent.getParent() == null) {
                cVar = null;
                break;
            } else {
                if (parent instanceof c) {
                    cVar = (c) parent;
                    break;
                }
                parent = parent.getParent();
            }
        }
        this.g = cVar;
        if (cVar != null) {
            cVar.setCallback(new d() { // from class: com.anythink.basead.ui.guidetoclickv2.FullOrientationG2CV2View.3
                @Override // com.anythink.basead.ui.guidetoclickv2.d
                public final boolean a(MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        FullOrientationG2CV2View.this.j = motionEvent.getX();
                        FullOrientationG2CV2View.this.k = motionEvent.getY();
                        return true;
                    }
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX() - FullOrientationG2CV2View.this.j;
                            float y = motionEvent.getY() - FullOrientationG2CV2View.this.k;
                            FullOrientationG2CV2View.c(FullOrientationG2CV2View.this, Math.abs(x));
                            FullOrientationG2CV2View.d(FullOrientationG2CV2View.this, Math.abs(y));
                            FullOrientationG2CV2View.this.j = motionEvent.getX();
                            FullOrientationG2CV2View.this.k = motionEvent.getY();
                            return false;
                        }
                        if (action != 3) {
                            return false;
                        }
                    }
                    if (FullOrientationG2CV2View.this.l + FullOrientationG2CV2View.this.m <= FullOrientationG2CV2View.this.n) {
                        return false;
                    }
                    if (FullOrientationG2CV2View.this.c != null) {
                        FullOrientationG2CV2View.this.c.a(11, 21);
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.g;
        if (cVar != null) {
            cVar.setCallback(null);
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected final void a() {
        super.a();
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected final void b() {
        super.b();
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    private c e() {
        for (ViewParent parent = getParent(); parent.getParent() != null; parent = parent.getParent()) {
            if (parent instanceof c) {
                return (c) parent;
            }
        }
        return null;
    }

    public void setViewMode(int i) {
        int i2 = this.o;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
        this.h = layoutParams;
        if (i == 502 || i == 504 || i == 505) {
            layoutParams.addRule(13);
            return;
        }
        layoutParams.addRule(12);
        this.h.addRule(14);
        this.h.addRule(14);
        this.h.setMargins(0, 0, 0, q.a(getContext(), 140.0f));
    }

    public void updateSize(int i) {
        int i2 = (int) (i * 0.72f);
        this.h.width = -2;
        this.h.height = i2;
        this.e.setBackgroundColor(0);
        View viewFindViewById = findViewById(q.a(getContext(), "myoffer_g2c_fullori_bg", "id"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams.width = i2;
        layoutParams.height = i2;
        layoutParams.topMargin = 0;
        layoutParams.addRule(15);
        viewFindViewById.setLayoutParams(layoutParams);
        this.f = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_fullori_finger", "id"));
        float f = i2;
        float f2 = f * 0.5f;
        int i3 = (int) f2;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams2.topMargin = 0;
        layoutParams2.leftMargin = (int) ((f - f2) * 0.5f);
        layoutParams2.addRule(15);
        this.f.setLayoutParams(layoutParams2);
        TextView textView = (TextView) findViewById(q.a(getContext(), "myoffer_g2c_fullori_text", "id"));
        textView.setTextSize(2, 10.0f);
        textView.setText(q.a(getContext(), "myoffer_g2c_fuu_ori_hint_small", "string"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.width = -2;
        layoutParams3.topMargin = 0;
        layoutParams3.leftMargin = q.a(getContext(), 10.0f);
        layoutParams3.addRule(15);
        layoutParams3.addRule(1, viewFindViewById.getId());
        textView.setLayoutParams(layoutParams3);
        this.e.setLayoutParams(this.h);
    }
}
