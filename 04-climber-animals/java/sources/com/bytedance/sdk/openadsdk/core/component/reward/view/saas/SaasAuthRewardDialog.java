package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.basead.exoplayer.i.a;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.live.xr;
import com.bytedance.sdk.openadsdk.core.nw.az;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.core.x.ah;
import com.bytedance.sdk.openadsdk.core.xr.ms.xr.c;

/* JADX INFO: loaded from: classes2.dex */
public class SaasAuthRewardDialog extends RelativeLayout implements Runnable {
    private static boolean ch = false;
    private lm ab;
    private ImageView ah;
    private boolean c;
    private RotateAnimation d;
    private ScaleAnimation ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private SaasAuthEnvelope f2280ms;
    private int ny;
    private String x;
    private BaseSaasEnvelope xr;

    public SaasAuthRewardDialog(Context context) {
        super(context);
        this.c = false;
        ms(context);
    }

    public void ms(lm lmVar, String str, int i) {
        if (lmVar == null || xr.ms().ah() != 2) {
            setVisibility(8);
            return;
        }
        az azVarMl = lmVar.ml();
        if (azVarMl == null || ((azVarMl.hi() == null && azVarMl.ch() == null) || !azVarMl.ny())) {
            setVisibility(8);
            return;
        }
        this.ab = lmVar;
        this.x = str;
        this.ny = i;
        setBackgroundColor(Color.parseColor("#aa000000"));
        x.xr().postDelayed(this, 5000L);
        ms(getContext());
        ah();
    }

    private void ms(Context context) {
        this.ah = new ImageView(context);
        try {
            com.bytedance.sdk.openadsdk.x.xr.ms(ah.ms("saas_light_shine.webp")).ms(this.ah);
            this.ah.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (Error unused) {
        }
        int iD = ul.d(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iD, iD);
        layoutParams.addRule(13);
        addView(this.ah, layoutParams);
        SaasAuthEnvelope saasAuthEnvelope = new SaasAuthEnvelope(context);
        this.f2280ms = saasAuthEnvelope;
        saasAuthEnvelope.setId(2114387470);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.f2280ms, layoutParams2);
        this.f2280ms.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.xr();
                x.xr().removeCallbacks(SaasAuthRewardDialog.this);
            }
        });
        this.f2280ms.setOnCloseClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.ms();
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        if (getVisibility() != 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.ka = scaleAnimation;
            scaleAnimation.setDuration(600L);
            this.ka.setFillAfter(true);
            this.ka.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SaasAuthRewardDialog.this.d = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                    SaasAuthRewardDialog.this.d.setDuration(5000L);
                    SaasAuthRewardDialog.this.d.setRepeatCount(-1);
                    SaasAuthRewardDialog.this.d.setFillAfter(true);
                    SaasAuthRewardDialog.this.d.setInterpolator(new LinearInterpolator());
                    SaasAuthRewardDialog.this.ah.startAnimation(SaasAuthRewardDialog.this.d);
                }
            });
            this.ah.startAnimation(this.ka);
            pc.xr(true);
            setVisibility(0);
            this.f2280ms.ms();
            x.xr().postDelayed(this, a.f);
            return;
        }
        if (!this.c) {
            x.xr().postDelayed(this, 5000L);
            xr();
        } else {
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr() {
        this.c = true;
        az azVarMl = this.ab.ml();
        if (azVarMl.ch() != null) {
            this.xr = new SaasAuthCouponEnvelope(getContext(), azVarMl.ch());
        } else if (azVarMl.hi() != null) {
            this.xr = new SaasAuthProductEnvelope(getContext(), azVarMl.hi());
        }
        View view = this.xr;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-1, -1));
            this.xr.ms();
            com.bytedance.sdk.openadsdk.core.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms(getContext(), this.ab, this.x, this.ny);
            setTag(TTAdConstant.KEY_CLICK_AREA, 2917);
            ((c) msVar.ms(c.class)).ms(101);
            com.bytedance.sdk.component.hi.ka.ms.ms().ms(this.ab.hashCode() + this.ab.eu()).put("live_saas_interaction_type", 101);
            setOnClickListener(msVar);
            this.xr.setOnCloseClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    SaasAuthRewardDialog.this.ms();
                }
            });
            this.xr.setOnButtonClickListener(msVar);
        }
        SaasAuthEnvelope saasAuthEnvelope = this.f2280ms;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.xr();
        }
        removeView(this.f2280ms);
    }

    public void ms() {
        SaasAuthEnvelope saasAuthEnvelope = this.f2280ms;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.xr();
        }
        BaseSaasEnvelope baseSaasEnvelope = this.xr;
        if (baseSaasEnvelope != null) {
            baseSaasEnvelope.xr();
        }
        RotateAnimation rotateAnimation = this.d;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
            this.d = null;
        }
        ScaleAnimation scaleAnimation = this.ka;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
            this.ka = null;
        }
        x.xr().removeCallbacks(this);
        setVisibility(8);
        pc.xr(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pc.xr(false);
    }

    private void ah() {
        try {
            if (ch) {
                return;
            }
            ms msVar = new ms();
            com.bytedance.sdk.openadsdk.x.xr.ms(ah.ms("saas_light_shine.webp")).ms(msVar);
            com.bytedance.sdk.openadsdk.x.xr.ms(ah.ms("saas_red_envelope.webp")).ms(msVar);
            com.bytedance.sdk.openadsdk.x.xr.ms(ah.ms("saas_reward_goods_bg.webp")).ms(msVar);
            com.bytedance.sdk.openadsdk.x.xr.ms(ah.ms("saas_reward_coupon_bg.webp")).ms(msVar);
            com.bytedance.sdk.openadsdk.x.xr.ms(ah.ms("saas_reward_title.webp")).ms(msVar);
            ch = true;
        } catch (Throwable unused) {
        }
    }

    private static class ms implements ao {
        @Override // com.bytedance.sdk.component.c.ao
        @ATSMethod(2)
        public void ms(int i, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.component.c.ao
        @ATSMethod(1)
        public void ms(hi hiVar) {
        }

        private ms() {
        }
    }
}
