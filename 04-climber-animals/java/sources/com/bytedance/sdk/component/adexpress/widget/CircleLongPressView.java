package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d.ny;
import com.bytedance.sdk.component.adexpress.d.x;
import com.bytedance.sdk.component.utils.cv;

/* JADX INFO: loaded from: classes2.dex */
public class CircleLongPressView extends FrameLayout {
    private ImageView ah;
    private AnimatorSet c;
    private TextView d;
    private RingProgressView ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f915ms;
    private ImageView xr;

    public CircleLongPressView(Context context) {
        super(context);
        this.c = new AnimatorSet();
        this.f915ms = context;
        ka();
        c();
    }

    private void ka() {
        FrameLayout frameLayout = new FrameLayout(this.f915ms);
        this.ka = new RingProgressView(this.f915ms);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) x.ms(this.f915ms, 95.0f), (int) x.ms(this.f915ms, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.ka, layoutParams);
        this.xr = new ImageView(this.f915ms);
        int iMs = cv.ms(this.f915ms, 60.0f);
        this.xr.setImageDrawable(ny.ms(1, null, null, new int[]{iMs, iMs}, Integer.valueOf(cv.ms(this.f915ms, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) x.ms(this.f915ms, 75.0f), (int) x.ms(this.f915ms, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.xr, layoutParams2);
        this.ah = new ImageView(this.f915ms);
        int iMs2 = cv.ms(this.f915ms, 50.0f);
        this.ah.setImageDrawable(ny.ms(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{iMs2, iMs2}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) x.ms(this.f915ms, 63.0f), (int) x.ms(this.f915ms, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.ah, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.f915ms);
        this.d = textView;
        textView.setTextColor(-1);
        this.d.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.d, layoutParams4);
    }

    private void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.ah, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatMode(2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.ah, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.c.setDuration(800L);
        this.c.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.d.setText(str);
    }

    public void ms() {
        this.c.start();
    }

    public void xr() {
        this.c.cancel();
    }

    public void ah() {
        this.ka.ms();
    }

    public void d() {
        this.ka.xr();
        this.ka.ah();
    }
}
