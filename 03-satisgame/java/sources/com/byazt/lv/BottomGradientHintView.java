package com.byazt.lv;

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
import com.byazt.cq.fs;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1420, 2517})
public class BottomGradientHintView extends LinearLayout {
    public ImageView n;
    public AnimatorSet qg;

    public BottomGradientHintView(Context context) {
        super(context);
        this.qg = new AnimatorSet();
        n(context);
    }

    private void n(Context context) {
        setLayoutParams(new LinearLayout.LayoutParams(-1, n(context, 80.0f)));
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
        this.n = imageView;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        sz.n(context, "tt_splash_slide_up_10", (View) this.n, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n(context, 8.0f), n(context, 8.0f));
        layoutParams.leftMargin = n(context, 10.0f);
        this.n.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        linearLayout.addView(this.n);
        addView(linearLayout);
    }

    public void n() {
        s();
    }

    public void qg() {
        AnimatorSet animatorSet = this.qg;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        this.qg.cancel();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        qg();
    }

    private void s() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.n, "translationY", 0.0f, fs.n(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.n, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.qg.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.qg.setDuration(1000L);
        this.qg.start();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 8) {
            qg();
        }
        super.setVisibility(i);
    }

    private int n(Context context, float f) {
        return com.byazt.okk.s.s(context, f);
    }
}
