package com.anythink.core.activity.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.anythink.core.common.u.p;

/* JADX INFO: loaded from: classes.dex */
public class LoadingView extends ImageView {
    public LoadingView(Context context) {
        super(context);
        a();
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        setImageDrawable(getResources().getDrawable(p.a(getContext(), "core_loading", "drawable")));
        try {
            setLayerType(2, null);
        } catch (Exception unused) {
        }
        a(this);
    }

    private static void a(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(linearInterpolator);
        rotateAnimation.setDuration(1000L);
        view.startAnimation(rotateAnimation);
    }

    public void startAnimation() {
        a(this);
    }
}
