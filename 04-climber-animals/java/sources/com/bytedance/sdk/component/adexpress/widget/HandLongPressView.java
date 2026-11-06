package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d.x;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class HandLongPressView extends FrameLayout {
    private CircleRippleView ah;
    private TextView c;
    private AnimatorSet d;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f943ms;
    private ImageView xr;

    public HandLongPressView(Context context) {
        super(context);
        this.ka = true;
        this.f943ms = context;
        this.d = new AnimatorSet();
        ah();
        d();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.HandLongPressView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) HandLongPressView.this.xr.getLayoutParams();
                layoutParams.topMargin = ((int) ((HandLongPressView.this.ah.getMeasuredHeight() / 2.0f) - x.ms(HandLongPressView.this.getContext(), 5.0f))) + ((int) x.ms(HandLongPressView.this.f943ms, 20.0f));
                layoutParams.leftMargin = ((int) ((HandLongPressView.this.ah.getMeasuredWidth() / 2.0f) - x.ms(HandLongPressView.this.getContext(), 5.0f))) + ((int) x.ms(HandLongPressView.this.f943ms, 20.0f));
                layoutParams.bottomMargin = (int) (((-HandLongPressView.this.ah.getMeasuredHeight()) / 2.0f) + x.ms(HandLongPressView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-HandLongPressView.this.ah.getMeasuredWidth()) / 2.0f) + x.ms(HandLongPressView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                HandLongPressView.this.xr.setLayoutParams(layoutParams);
            }
        });
    }

    private void ah() {
        this.ah = new CircleRippleView(this.f943ms);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) x.ms(this.f943ms, 80.0f), (int) x.ms(this.f943ms, 80.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) x.ms(this.f943ms, 20.0f);
        layoutParams.leftMargin = (int) x.ms(this.f943ms, 20.0f);
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.ah, layoutParams);
        this.ah.ms();
        this.xr = new ImageView(this.f943ms);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) x.ms(this.f943ms, 80.0f), (int) x.ms(this.f943ms, 80.0f));
        this.xr.setImageResource(t.ka(this.f943ms, "tt_splash_hand"));
        addView(this.xr, layoutParams2);
        TextView textView = new TextView(this.f943ms);
        this.c = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) x.ms(this.f943ms, 10.0f);
        addView(this.c, layoutParams3);
    }

    private void d() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.xr, "scaleX", 1.0f, 0.8f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.HandLongPressView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(HandLongPressView.this.xr, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                HandLongPressView.this.xr.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (HandLongPressView.this.ka) {
                    HandLongPressView.this.ah.ms();
                    HandLongPressView.this.ah.setAlpha(1.0f);
                } else {
                    HandLongPressView.this.ah.xr();
                    HandLongPressView.this.ah.setAlpha(0.0f);
                }
                HandLongPressView handLongPressView = HandLongPressView.this;
                handLongPressView.ka = !handLongPressView.ka;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.xr, "scaleY", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.d.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.c.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.c.setTextColor(i);
    }

    public void ms() {
        this.d.start();
    }

    public void xr() {
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        CircleRippleView circleRippleView = this.ah;
        if (circleRippleView != null) {
            circleRippleView.xr();
        }
    }
}
