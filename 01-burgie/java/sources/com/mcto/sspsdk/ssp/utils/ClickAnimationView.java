package com.mcto.sspsdk.ssp.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public class ClickAnimationView extends FrameLayout {
    private final ImageView a;
    private final ImageView b;
    private AnimatorSet c;
    private AnimatorSet d;

    public ClickAnimationView(Context context) {
        super(context);
        ImageView imageView = new ImageView(context);
        this.a = imageView;
        imageView.setImageResource(R.drawable.qy_ic_ripple);
        imageView.setAlpha(0.0f);
        addView(imageView);
        ImageView imageView2 = new ImageView(context);
        this.b = imageView2;
        imageView2.setImageResource(R.drawable.qy_lg_hand_click);
        addView(imageView2);
    }

    public final void a(Size size, Size size2) {
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.width = size.getWidth();
        layoutParams.height = size.getHeight();
        this.a.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.b.getLayoutParams();
        layoutParams2.width = size2.getWidth();
        layoutParams2.height = size2.getHeight();
        this.b.setLayoutParams(layoutParams2);
        b();
        this.c = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.b, "scaleX", 1.0f, 0.8f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.b, "scaleY", 1.0f, 0.8f, 1.0f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat2.setDuration(1000L);
        this.c.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.d = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.a, "scaleX", 0.8f, 2.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.a, "scaleY", 0.8f, 2.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.a, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat5.setRepeatCount(-1);
        objectAnimatorOfFloat3.setDuration(1000L);
        objectAnimatorOfFloat4.setDuration(1000L);
        objectAnimatorOfFloat5.setDuration(1000L);
        this.d.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat5);
        this.d.setStartDelay(500L);
    }

    public final void b() {
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.c;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public ClickAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ImageView imageView = new ImageView(context);
        this.a = imageView;
        imageView.setImageResource(R.drawable.qy_ic_ripple);
        imageView.setAlpha(0.0f);
        addView(imageView);
        ImageView imageView2 = new ImageView(context);
        this.b = imageView2;
        imageView2.setImageResource(R.drawable.qy_lg_hand_click);
        addView(imageView2);
    }

    public final void a() {
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimatorSet animatorSet2 = this.c;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }
}
