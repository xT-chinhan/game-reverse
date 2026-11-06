package com.byazt.jt;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.ca.ve;
import com.byazt.js.aj;
import com.byazt.js.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1331})
public class CircleLongPressView extends FrameLayout {
    public RingProgressView c;
    public ImageView hn;
    public ImageView hw;
    public Context pr;
    public AnimatorSet uc;
    public TextView x;

    public CircleLongPressView(Context context) {
        super(context);
        this.uc = new AnimatorSet();
        this.pr = context;
        c();
        uc();
    }

    private void c() {
        FrameLayout frameLayout = new FrameLayout(this.pr);
        this.c = new RingProgressView(this.pr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) zo.pr(this.pr, 95.0f), (int) zo.pr(this.pr, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.c, layoutParams);
        this.hw = new ImageView(this.pr);
        int iPr = ve.pr(this.pr, 60.0f);
        this.hw.setImageDrawable(aj.pr(1, null, null, new int[]{iPr, iPr}, Integer.valueOf(ve.pr(this.pr, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) zo.pr(this.pr, 75.0f), (int) zo.pr(this.pr, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.hw, layoutParams2);
        this.hn = new ImageView(this.pr);
        int iPr2 = ve.pr(this.pr, 50.0f);
        this.hn.setImageDrawable(aj.pr(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{iPr2, iPr2}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) zo.pr(this.pr, 63.0f), (int) zo.pr(this.pr, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.hn, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.pr);
        this.x = textView;
        textView.setTextColor(-1);
        this.x.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.x, layoutParams4);
    }

    private void uc() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.hn, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatMode(2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.hn, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.uc.setDuration(800L);
        this.uc.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.x.setText(str);
    }

    public void pr() {
        this.uc.start();
    }

    public void hw() {
        this.uc.cancel();
    }

    public void hn() {
        this.c.pr();
    }

    public void x() {
        this.c.hw();
        this.c.hn();
    }
}
