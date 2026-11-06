package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.x.ah;
import com.bytedance.sdk.openadsdk.x.xr;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseSaasEnvelope extends RelativeLayout {
    private AnimatorSet ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private View f2276ms;
    private ImageView xr;

    public abstract void ms();

    public BaseSaasEnvelope(Context context) {
        super(context);
    }

    protected void ms(Context context, String str, RelativeLayout relativeLayout) {
        View viewMs = ms(context, str);
        this.f2276ms = viewMs;
        relativeLayout.addView(viewMs);
        relativeLayout.addView(xr(context));
        this.f2276ms.setTag(TTAdConstant.KEY_CLICK_AREA, 2917);
        addView(ms(context, relativeLayout));
        ImageView imageView = new ImageView(context);
        this.xr = imageView;
        imageView.setImageResource(t.ka(context, "tt_saas_close"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, relativeLayout.getId());
        layoutParams.topMargin = ul.ah(context, 25.0f);
        addView(this.xr, layoutParams);
    }

    private View ms(Context context, String str) {
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ul.ah(context, 166.0f), ul.ah(context, 40.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = ul.ah(context, 26.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#9D301A"));
        textView.setTypeface(null, 1);
        int iAh = ul.ah(context, 40.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f = iAh;
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
        this.ah = animatorSet;
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        this.ah.start();
        return textView;
    }

    private View xr(Context context) {
        String strKa = f.ka(getContext());
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = ul.ah(context, 80.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 10.0f);
        textView.setGravity(17);
        textView.setText("关联后" + strKa + "将获取你的抖音头像和昵称");
        textView.setTextColor(Color.parseColor("#AAFFFFFF"));
        return textView;
    }

    protected RelativeLayout ms(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ul.ah(getContext(), 301.0f), ul.ah(getContext(), 344.0f));
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setId(2114387464);
        return relativeLayout;
    }

    private View ms(Context context, View view) {
        ImageView imageView = new ImageView(context);
        xr.ms(ah.ms("saas_reward_title.webp")).ms(imageView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, view.getId());
        layoutParams.setMargins(0, 0, 0, ul.ah(context, 20.0f));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public void xr() {
        AnimatorSet animatorSet = this.ah;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.ah = null;
        }
    }

    public void setOnButtonClickListener(final View.OnClickListener onClickListener) {
        View view = this.f2276ms;
        if (view == null || onClickListener == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BaseSaasEnvelope.this.xr();
                onClickListener.onClick(view2);
            }
        });
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.xr;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}
