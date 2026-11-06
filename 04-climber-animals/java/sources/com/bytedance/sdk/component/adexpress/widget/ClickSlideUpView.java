package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d.x;

/* JADX INFO: loaded from: classes2.dex */
public class ClickSlideUpView extends SlideUpView {
    private AnimatorSet ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private TextView f919ms;
    private View xr;

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    protected void ms(Context context) {
    }

    public ClickSlideUpView(Context context) {
        super(context);
        this.ah = new AnimatorSet();
        xr(context);
    }

    private void xr(Context context) {
        View viewMs = com.bytedance.sdk.component.adexpress.ah.ms.ms(context);
        this.xr = viewMs;
        addView(viewMs);
        setClipChildren(false);
        this.f919ms = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.f919ms == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f919ms.setText(str);
    }

    private void d() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.xr, "translationY", 0.0f, x.ms(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.xr, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.ah.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.ah.setDuration(1000L);
        this.ah.start();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void ms() {
        d();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void xr() {
        this.ah.cancel();
    }
}
