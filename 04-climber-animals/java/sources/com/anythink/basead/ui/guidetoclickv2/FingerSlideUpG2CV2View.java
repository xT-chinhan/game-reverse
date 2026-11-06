package com.anythink.basead.ui.guidetoclickv2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class FingerSlideUpG2CV2View extends BaseG2CV2View {
    float d;
    float e;
    int f;
    float g;
    private int h;
    private int i;
    private ImageView j;
    private ImageView k;
    private AnimatorSet l;
    private ObjectAnimator m;
    private ObjectAnimator n;

    public FingerSlideUpG2CV2View(Context context) {
        super(context);
    }

    public FingerSlideUpG2CV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public FingerSlideUpG2CV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    final void a(int i, int i2) {
        this.h = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (i == 2) {
            LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_g2c_v2_finger_slide_up_s", "layout"), this);
            this.i = q.a(getContext(), 44.0f);
            int i3 = this.f;
            if (i3 > 0) {
                setPadding(0, 0, 0, i3);
            }
        } else {
            LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_g2c_v2_finger_slide_up", "layout"), this);
            this.i = q.a(getContext(), 178.0f);
            int iA = q.a(getContext(), 192.0f);
            this.f = iA;
            setPadding(0, 0, 0, iA);
        }
        this.k = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_item_finger", "id"));
        this.j = (ImageView) findViewById(q.a(getContext(), "myoffer_g2c_item_point", "id"));
        startAnim();
    }

    public void updateIsEmptyHalfInterLayout() {
        this.f = q.a(getContext(), 80.0f);
    }

    public void startAnim() {
        if (this.l == null) {
            ImageView imageView = this.k;
            int i = this.i;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationY", 0.0f, -i, -i);
            this.m = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.m.setRepeatCount(-1);
            ImageView imageView2 = this.j;
            int i2 = this.i;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView2, "translationY", 0.0f, -i2, -i2);
            this.n = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(1800L);
            this.n.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            this.l = animatorSet;
            animatorSet.playTogether(this.m, this.n);
            this.l.start();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected final void a() {
        super.a();
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    protected final void b() {
        super.b();
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        ObjectAnimator objectAnimator = this.m;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.m.cancel();
        }
        ObjectAnimator objectAnimator2 = this.n;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllListeners();
            this.n.cancel();
        }
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.l.cancel();
            this.l = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        if (measuredHeight > 0) {
            this.g = measuredHeight - this.f;
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (motionEvent.getY() > this.g) {
                return false;
            }
            this.d = motionEvent.getY();
            return true;
        }
        if (action == 1) {
            if (this.e <= this.h) {
                return false;
            }
            if (this.c != null) {
                this.c.a(11, 48);
            }
            return true;
        }
        if (action != 2) {
            return false;
        }
        this.e += Math.abs(motionEvent.getY() - this.d);
        this.d = motionEvent.getY();
        return false;
    }
}
