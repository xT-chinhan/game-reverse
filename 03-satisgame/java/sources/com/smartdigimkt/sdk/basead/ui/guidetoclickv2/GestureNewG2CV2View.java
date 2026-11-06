package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smartdigimkt.o3.d;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.y1.g0;
import com.smartdigimkt.y1.y;

/* JADX INFO: loaded from: classes3.dex */
public class GestureNewG2CV2View extends BaseG2CV2View {
    public ImageView h;
    public ImageView i;
    public TextView j;
    public AnimatorSet k;
    public int l;
    public int m;
    public float n;
    public float o;
    public int p;
    public g0 q;
    public int r;

    public GestureNewG2CV2View(Context context) {
        super(context);
        this.r = -1;
    }

    public final void b() {
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.k = null;
        }
        if (this.k == null) {
            ImageView imageView = this.h;
            int i = this.l;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationX", i, -i);
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat.setRepeatMode(2);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.h, "translationY", 0.0f, (-this.m) / 2, 0.0f);
            objectAnimatorOfFloat2.setDuration(1000L);
            objectAnimatorOfFloat2.setRepeatCount(-1);
            objectAnimatorOfFloat2.setRepeatMode(2);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.k = animatorSet2;
            animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            this.k.start();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void initView(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_g2c_v2_gesture_v2", "layout"), this);
        this.p = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.h = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_slide_finger", "id"));
        this.i = (ImageView) findViewById(k.a(getContext(), "myoffer_g2c_white_line", "id"));
        this.j = (TextView) findViewById(k.a(getContext(), "myoffer_g2c_slide_hint", "id"));
        this.l = k.a(getContext(), 32.0f);
        this.m = k.a(getContext(), 10.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        g0 g0Var;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        while (true) {
            if (parent.getParent() == null) {
                g0Var = null;
                break;
            } else {
                if (parent instanceof g0) {
                    g0Var = (g0) parent;
                    break;
                }
                parent = parent.getParent();
            }
        }
        this.q = g0Var;
        if (g0Var != null) {
            g0Var.setCallback(new y(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g0 g0Var = this.q;
        if (g0Var != null) {
            g0Var.setCallback(null);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getMeasuredWidth() < k.a(getContext(), 50.0f)) {
            a();
            return;
        }
        int measuredHeight = getMeasuredHeight();
        if (measuredHeight < k.a(getContext(), 50.0f)) {
            a();
            return;
        }
        if (measuredHeight >= k.a(getContext(), 50.0f) && measuredHeight < k.a(getContext(), 80.0f)) {
            if (this.r == 12) {
                return;
            }
            this.r = 12;
            this.l = k.a(getContext(), 18.0f);
            this.m = k.a(getContext(), 6.0f);
            ImageView imageView = this.i;
            if (imageView != null) {
                d.a(k.a(getContext(), 118.0f), k.a(getContext(), 21.0f), imageView);
            }
            ImageView imageView2 = this.h;
            if (imageView2 != null) {
                d.a(k.a(getContext(), 18.0f), k.a(getContext(), 19.0f), imageView2);
            }
            TextView textView = this.j;
            if (textView != null) {
                textView.setVisibility(8);
            }
            b();
            return;
        }
        if (measuredHeight < k.a(getContext(), 80.0f) || measuredHeight > k.a(getContext(), 110.0f)) {
            if (this.r == 10) {
                return;
            }
            this.r = 10;
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            b();
            return;
        }
        if (this.r == 11) {
            return;
        }
        this.r = 11;
        this.l = k.a(getContext(), 22.0f);
        this.m = k.a(getContext(), 6.0f);
        ImageView imageView3 = this.i;
        if (imageView3 != null) {
            d.a(k.a(getContext(), 142.0f), k.a(getContext(), 24.0f), imageView3);
        }
        ImageView imageView4 = this.h;
        if (imageView4 != null) {
            d.a(k.a(getContext(), 22.0f), k.a(getContext(), 24.0f), imageView4);
        }
        TextView textView3 = this.j;
        if (textView3 != null) {
            textView3.setVisibility(0);
            if (this.j.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
                layoutParams.topMargin = k.a(getContext(), 2.0f);
                this.j.setLayoutParams(layoutParams);
            }
        }
        b();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void pauseAnim() {
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void resumeAnim() {
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }
}
