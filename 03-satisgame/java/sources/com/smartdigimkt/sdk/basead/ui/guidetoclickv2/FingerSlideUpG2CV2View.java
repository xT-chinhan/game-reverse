package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.smartdigimkt.b2.e;
import com.smartdigimkt.r4.k;

/* JADX INFO: loaded from: classes3.dex */
public class FingerSlideUpG2CV2View extends BaseG2CV2View {
    public int h;
    public int i;
    public ImageView j;
    public ImageView k;
    public AnimatorSet l;
    public ObjectAnimator m;
    public ObjectAnimator n;
    public float o;
    public float p;
    public int q;
    public float r;

    public FingerSlideUpG2CV2View(Context context) {
        super(context);
    }

    public final boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (motionEvent.getY() > this.r) {
                return false;
            }
            this.o = motionEvent.getY();
            return true;
        }
        if (action == 1) {
            if (this.p <= this.h) {
                return false;
            }
            e eVar = this.e;
            if (eVar != null) {
                eVar.a(11, 48);
            }
            return true;
        }
        if (action != 2) {
            return false;
        }
        this.p = Math.abs(motionEvent.getY() - this.o) + this.p;
        this.o = motionEvent.getY();
        return false;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void initView(int i, int i2) {
        this.h = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (i == 2) {
            LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_g2c_v2_finger_slide_up_s", "layout"), this);
            this.i = k.a(getContext(), 44.0f);
            int i3 = this.q;
            if (i3 > 0) {
                setPadding(0, 0, 0, i3);
            }
        } else {
            LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_g2c_v2_finger_slide_up", "layout"), this);
            this.i = k.a(getContext(), 178.0f);
            int iA = k.a(getContext(), 192.0f);
            this.q = iA;
            setPadding(0, 0, 0, iA);
        }
        this.k = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_item_finger", "id"));
        this.j = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_item_point", "id"));
        startAnim();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        if (measuredHeight > 0) {
            this.r = measuredHeight - this.q;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void pauseAnim() {
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
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

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void resumeAnim() {
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void startAnim() {
        if (this.l == null) {
            ImageView imageView = this.k;
            float f = -this.i;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationY", 0.0f, f, f);
            this.m = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.m.setRepeatCount(-1);
            ImageView imageView2 = this.j;
            float f2 = -this.i;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView2, "translationY", 0.0f, f2, f2);
            this.n = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(1800L);
            this.n.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            this.l = animatorSet;
            animatorSet.playTogether(this.m, this.n);
            this.l.start();
        }
    }

    public void updateIsEmptyHalfInterLayout() {
        this.q = k.a(getContext(), 80.0f);
    }

    public FingerSlideUpG2CV2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public FingerSlideUpG2CV2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
