package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.anythink.basead.exoplayer.i.a;
import com.bytedance.sdk.component.adexpress.d.x;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class ClickInteractView extends FrameLayout {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ImageView f917ms;
    private AnimatorSet xr;

    public ClickInteractView(Context context) {
        super(context);
        ah();
        d();
    }

    private void ah() {
        ImageView imageView = new ImageView(getContext());
        this.f917ms = imageView;
        imageView.setImageResource(t.ka(getContext(), "tt_white_hand"));
        int iMs = (int) x.ms(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iMs, iMs);
        layoutParams.gravity = 17;
        addView(this.f917ms, layoutParams);
    }

    private void d() {
        this.xr = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f917ms, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(a.f);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f917ms, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(a.f);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.xr.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void ms() {
        AnimatorSet animatorSet = this.xr;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void xr() {
        AnimatorSet animatorSet = this.xr;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
