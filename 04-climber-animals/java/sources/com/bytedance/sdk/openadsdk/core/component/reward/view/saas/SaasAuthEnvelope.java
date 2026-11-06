package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.x.ah;
import com.bytedance.sdk.openadsdk.x.xr;

/* JADX INFO: loaded from: classes2.dex */
public class SaasAuthEnvelope extends RelativeLayout {
    private ImageView ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private AnimationSet f2279ms;
    private ImageView xr;

    public SaasAuthEnvelope(Context context) {
        super(context);
        ms(context);
        setVisibility(8);
    }

    private void ms(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setId(2114387470);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        addView(linearLayout);
        this.ah = new ImageView(context);
        try {
            xr.ms(ah.ms("saas_red_envelope.webp")).ms(this.ah);
        } catch (Error unused) {
        }
        linearLayout.addView(this.ah, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(context);
        this.xr = imageView;
        try {
            imageView.setImageResource(t.ka(context, "tt_saas_close"));
        } catch (Error unused2) {
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = ul.ah(context, 25.0f);
        linearLayout.addView(this.xr, layoutParams2);
    }

    public void ms() {
        setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(800L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(800L);
        AnimationSet animationSet = new AnimationSet(true);
        this.f2279ms = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.f2279ms.addAnimation(scaleAnimation);
        startAnimation(this.f2279ms);
    }

    public void xr() {
        AnimationSet animationSet = this.f2279ms;
        if (animationSet != null) {
            animationSet.cancel();
            this.f2279ms = null;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xr();
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.xr;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}
