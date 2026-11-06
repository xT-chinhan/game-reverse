package com.byazt.rkq;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.cp.n;
import com.byazt.okk.s;
import com.byazt.tk.sz;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, 1702})
public abstract class BaseSaasEnvelope extends RelativeLayout {
    public View n;
    public ImageView qg;
    public AnimatorSet s;

    public abstract void n();

    public BaseSaasEnvelope(Context context) {
        super(context);
    }

    public void n(Context context, String str, RelativeLayout relativeLayout) {
        View viewN = n(context, str);
        this.n = viewN;
        relativeLayout.addView(viewN);
        relativeLayout.addView(qg(context));
        this.n.setTag(TTAdConstant.KEY_CLICK_AREA, 2917);
        addView(n(context, relativeLayout));
        ImageView imageView = new ImageView(context);
        this.qg = imageView;
        sz.n(context, "tt_saas_close", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, relativeLayout.getId());
        layoutParams.topMargin = s.s(context, 25.0f);
        addView(this.qg, layoutParams);
    }

    private View n(Context context, String str) {
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(s.s(context, 166.0f), s.s(context, 40.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = s.s(context, 26.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#9D301A"));
        textView.setTypeface(null, 1);
        int iS = s.s(context, 40.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f = iS;
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
        this.s = animatorSet;
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        this.s.start();
        return textView;
    }

    private View qg(Context context) {
        String strQ = w.q(getContext());
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = s.s(context, 80.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 10.0f);
        textView.setGravity(17);
        textView.setText("关联后" + strQ + "将获取你的抖音头像和昵称");
        textView.setTextColor(Color.parseColor("#AAFFFFFF"));
        return textView;
    }

    public RelativeLayout n(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(s.s(getContext(), 301.0f), s.s(getContext(), 344.0f));
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setId(2114387458);
        return relativeLayout;
    }

    private View n(Context context, View view) {
        ImageView imageView = new ImageView(context);
        com.byazt.imu.s.n(com.byazt.iu.n.n("saas_reward_title.webp")).n(imageView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, view.getId());
        layoutParams.setMargins(0, 0, 0, s.s(context, 20.0f));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public void qg() {
        AnimatorSet animatorSet = this.s;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.s = null;
        }
    }

    public void setOnButtonClickListener(final View.OnClickListener onClickListener) {
        View view = this.n;
        if (view == null || onClickListener == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.rkq.BaseSaasEnvelope.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BaseSaasEnvelope.this.qg();
                onClickListener.onClick(view2);
            }
        });
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.qg;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}
