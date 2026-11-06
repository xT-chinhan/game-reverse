package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;

/* JADX INFO: loaded from: classes2.dex */
public class SmallSlideView extends RelativeLayout {
    private ObjectAnimator ah;
    private ObjectAnimator d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final View f2104ms;
    private final xr xr;

    public SmallSlideView(Context context) {
        super(context);
        View msVar = new ms(context);
        this.f2104ms = msVar;
        xr xrVar = new xr(context);
        this.xr = xrVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ul.ah(context, 10.0f), 0);
        layoutParams.setMargins(0, ul.ah(context, 8.0f), 0, ul.ah(context, 8.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(xrVar, layoutParams);
        addView(msVar);
        setLayoutParams(new LinearLayout.LayoutParams(ul.ah(context, 80.0f), ul.ah(context, 80.0f)));
    }

    public void ms() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f2104ms, "translationY", ul.ah(getContext(), 30.0f), ul.ah(getContext(), -20.0f));
        this.ah = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(800L);
        this.ah.setRepeatCount(1);
        this.ah.setRepeatMode(1);
        this.ah.start();
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.xr, "newHeight", ul.ah(getContext(), 0.0f), ul.ah(getContext(), 48.0f));
        this.d = objectAnimatorOfInt;
        objectAnimatorOfInt.setDuration(800L);
        this.d.setRepeatCount(1);
        this.d.setRepeatMode(1);
        this.d.start();
    }

    public void xr() {
        ObjectAnimator objectAnimator = this.ah;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.d;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    private static class ms extends FrameLayout {
        public ms(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            t.ms(context, "tt_splash_slide_up_finger", imageView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = ul.ah(context, 38.0f);
            layoutParams.bottomMargin = ul.ah(context, 10.0f);
            ImageView imageView2 = new ImageView(context);
            t.ms(context, "tt_splash_slide_up_circle", imageView2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            int iAh = ul.ah(context, 30.0f);
            layoutParams2.setMargins(iAh, iAh, iAh, iAh);
            addView(imageView2, layoutParams2);
            addView(imageView, layoutParams);
        }
    }

    private static class xr extends FrameLayout {
        public xr(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            t.ms(context, "tt_splash_slide_up_bg", (View) imageView);
            addView(imageView);
        }
    }
}
