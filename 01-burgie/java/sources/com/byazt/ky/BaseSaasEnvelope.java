package com.byazt.ky;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.hb.hn;
import com.byazt.ub.hw;
import com.byazt.vzx.pr;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes.dex */
@pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, 1567})
public abstract class BaseSaasEnvelope extends RelativeLayout {
    public AnimatorSet hn;
    public ImageView hw;
    public View pr;

    public abstract void pr();

    public BaseSaasEnvelope(Context context) {
        super(context);
    }

    public void pr(Context context, String str, RelativeLayout relativeLayout) {
        View viewPr = pr(context, str);
        this.pr = viewPr;
        relativeLayout.addView(viewPr);
        relativeLayout.addView(hw(context));
        this.pr.setTag(TTAdConstant.KEY_CLICK_AREA, 2917);
        addView(pr(context, relativeLayout));
        ImageView imageView = new ImageView(context);
        this.hw = imageView;
        g.pr(context, "tt_saas_close", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, relativeLayout.getId());
        layoutParams.topMargin = er.hn(context, 25.0f);
        addView(this.hw, layoutParams);
    }

    private View pr(Context context, String str) {
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(er.hn(context, 166.0f), er.hn(context, 40.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = er.hn(context, 26.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#9D301A"));
        textView.setTypeface(null, 1);
        int iHn = er.hn(context, 40.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f = iHn;
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#F2AC5F"), Color.parseColor("#FFEECC")});
        textView.setBackground(gradientDrawable);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, "scaleX", 1.0f, 1.05f, 1.0f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setDuration(800L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView, "scaleY", 1.0f, 1.05f, 1.0f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setDuration(800L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.hn = animatorSet;
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        this.hn.start();
        return textView;
    }

    private View hw(Context context) {
        String strX = ls.x(getContext());
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = er.hn(context, 80.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 10.0f);
        textView.setGravity(17);
        textView.setText("关联后" + strX + "将获取你的抖音头像和昵称");
        textView.setTextColor(Color.parseColor("#AAFFFFFF"));
        return textView;
    }

    public RelativeLayout pr(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(er.hn(getContext(), 301.0f), er.hn(getContext(), 344.0f));
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setId(2114387458);
        return relativeLayout;
    }

    private View pr(Context context, View view) {
        ImageView imageView = new ImageView(context);
        hw.pr(hn.pr("saas_reward_title.webp")).pr(imageView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, view.getId());
        layoutParams.setMargins(0, 0, 0, er.hn(context, 20.0f));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public void hw() {
        AnimatorSet animatorSet = this.hn;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.hn = null;
        }
    }

    public void setOnButtonClickListener(final View.OnClickListener onClickListener) {
        View view = this.pr;
        if (view != null && onClickListener != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ky.BaseSaasEnvelope.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BaseSaasEnvelope.this.hw();
                    onClickListener.onClick(view2);
                }
            });
        }
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.hw;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}
