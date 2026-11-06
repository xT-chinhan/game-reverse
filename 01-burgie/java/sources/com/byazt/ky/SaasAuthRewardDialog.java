package com.byazt.ky;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.ca.aj;
import com.byazt.eg.hw;
import com.byazt.hb.hn;
import com.byazt.hg.of;
import com.byazt.hg.qi;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.sd.nl;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, 2217})
public class SaasAuthRewardDialog extends RelativeLayout implements Runnable {
    public static boolean vk = false;
    public int aj;
    public ScaleAnimation c;
    public of fw;
    public ImageView hn;
    public BaseSaasEnvelope hw;
    public SaasAuthEnvelope pr;
    public boolean uc;
    public RotateAnimation x;
    public String zo;

    public SaasAuthRewardDialog(Context context) {
        super(context);
        this.uc = false;
        pr(context);
    }

    public void pr(of ofVar, String str, int i) {
        if (ofVar == null || hw.pr().hn() != 2) {
            setVisibility(8);
            return;
        }
        qi qiVarW = ofVar.w();
        if (qiVarW == null || ((qiVarW.w() == null && qiVarW.vk() == null) || !qiVarW.aj())) {
            setVisibility(8);
            return;
        }
        this.fw = ofVar;
        this.zo = str;
        this.aj = i;
        setBackgroundColor(Color.parseColor("#aa000000"));
        aj.hw().postDelayed(this, 5000L);
        pr(getContext());
        hn();
    }

    private void pr(Context context) {
        this.hn = new ImageView(context);
        try {
            com.byazt.ub.hw.pr(hn.pr("saas_light_shine.webp")).pr(this.hn);
            this.hn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (Error e) {
        }
        int iC = er.c(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iC, iC);
        layoutParams.addRule(13);
        addView(this.hn, layoutParams);
        SaasAuthEnvelope saasAuthEnvelope = new SaasAuthEnvelope(context);
        this.pr = saasAuthEnvelope;
        saasAuthEnvelope.setId(2114387464);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.pr, layoutParams2);
        this.pr.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.ky.SaasAuthRewardDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.hw();
                aj.hw().removeCallbacks(SaasAuthRewardDialog.this);
            }
        });
        this.pr.setOnCloseClickListener(new View.OnClickListener() { // from class: com.byazt.ky.SaasAuthRewardDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.pr();
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        if (getVisibility() != 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.c = scaleAnimation;
            scaleAnimation.setDuration(600L);
            this.c.setFillAfter(true);
            this.c.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.ky.SaasAuthRewardDialog.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SaasAuthRewardDialog.this.x = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                    SaasAuthRewardDialog.this.x.setDuration(5000L);
                    SaasAuthRewardDialog.this.x.setRepeatCount(-1);
                    SaasAuthRewardDialog.this.x.setFillAfter(true);
                    SaasAuthRewardDialog.this.x.setInterpolator(new LinearInterpolator());
                    SaasAuthRewardDialog.this.hn.startAnimation(SaasAuthRewardDialog.this.x);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.hn.startAnimation(this.c);
            nl.hw(true);
            setVisibility(0);
            this.pr.pr();
            aj.hw().postDelayed(this, 2000L);
            return;
        }
        if (!this.uc) {
            aj.hw().postDelayed(this, 5000L);
            hw();
        } else {
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw() {
        this.uc = true;
        qi qiVarW = this.fw.w();
        if (qiVarW.vk() != null) {
            this.hw = new SaasAuthCouponEnvelope(getContext(), qiVarW.vk());
        } else if (qiVarW.w() != null) {
            this.hw = new SaasAuthProductEnvelope(getContext(), qiVarW.w());
        }
        BaseSaasEnvelope baseSaasEnvelope = this.hw;
        if (baseSaasEnvelope != null) {
            addView(baseSaasEnvelope, new RelativeLayout.LayoutParams(-1, -1));
            this.hw.pr();
            com.byazt.az.pr prVar = new com.byazt.az.pr(getContext(), this.fw, this.zo, this.aj);
            setTag(TTAdConstant.KEY_CLICK_AREA, 2917);
            com.byazt.lxw.pr.pr().pr(this.fw.hashCode() + this.fw.ny()).put("live_saas_interaction_type", 101);
            setOnClickListener(prVar);
            this.hw.setOnCloseClickListener(new View.OnClickListener() { // from class: com.byazt.ky.SaasAuthRewardDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SaasAuthRewardDialog.this.pr();
                }
            });
            this.hw.setOnButtonClickListener(prVar);
        }
        SaasAuthEnvelope saasAuthEnvelope = this.pr;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.hw();
        }
        removeView(this.pr);
    }

    public void pr() {
        SaasAuthEnvelope saasAuthEnvelope = this.pr;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.hw();
        }
        BaseSaasEnvelope baseSaasEnvelope = this.hw;
        if (baseSaasEnvelope != null) {
            baseSaasEnvelope.hw();
        }
        RotateAnimation rotateAnimation = this.x;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
            this.x = null;
        }
        ScaleAnimation scaleAnimation = this.c;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
            this.c = null;
        }
        aj.hw().removeCallbacks(this);
        setVisibility(8);
        nl.hw(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        nl.hw(false);
    }

    private void hn() {
        try {
            if (vk) {
                return;
            }
            pr prVar = new pr();
            com.byazt.ub.hw.pr(hn.pr("saas_light_shine.webp")).pr(prVar);
            com.byazt.ub.hw.pr(hn.pr("saas_red_envelope.webp")).pr(prVar);
            com.byazt.ub.hw.pr(hn.pr("saas_reward_goods_bg.webp")).pr(prVar);
            com.byazt.ub.hw.pr(hn.pr("saas_reward_coupon_bg.webp")).pr(prVar);
            com.byazt.ub.hw.pr(hn.pr("saas_reward_title.webp")).pr(prVar);
            vk = true;
        } catch (Throwable th) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, 2147})
    private static class pr implements rc {
        private pr() {
        }

        @Override // com.byazt.ld.rc
        public void pr(nt ntVar) {
        }

        @Override // com.byazt.ld.rc
        public void pr(int i, String str, Throwable th) {
        }
    }
}
