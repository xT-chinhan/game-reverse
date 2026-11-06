package com.byazt.xhr;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.js.zo;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1087, 1088})
public class BottomGradientHintView extends LinearLayout {
    public AnimatorSet hw;
    public ImageView pr;

    public BottomGradientHintView(Context context) {
        super(context);
        this.hw = new AnimatorSet();
        pr(context);
    }

    private void pr(Context context) {
        setLayoutParams(new LinearLayout.LayoutParams(-1, pr(context, 80.0f)));
        setOrientation(1);
        setGravity(17);
        setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, Color.parseColor("#cc000000")}));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText("向上滑动浏览更多");
        textView.setTextSize(14.0f);
        textView.setTextColor(-1);
        ImageView imageView = new ImageView(context);
        this.pr = imageView;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        g.pr(context, "tt_splash_slide_up_10", (View) this.pr, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(pr(context, 8.0f), pr(context, 8.0f));
        layoutParams.leftMargin = pr(context, 10.0f);
        this.pr.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        linearLayout.addView(this.pr);
        addView(linearLayout);
    }

    public void pr() {
        hn();
    }

    public void hw() {
        AnimatorSet animatorSet = this.hw;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.hw.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hw();
    }

    private void hn() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.pr, "translationY", 0.0f, zo.pr(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.pr, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.hw.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.hw.setDuration(1000L);
        this.hw.start();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 8) {
            hw();
        }
        super.setVisibility(i);
    }

    private int pr(Context context, float f) {
        return er.hn(context, f);
    }
}
