package com.byazt.rkq;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.gct.dg;
import com.byazt.gct.pk;
import com.byazt.imu.s;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.tk.rv;
import com.byazt.wq.qg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, 2418})
public class SaasAuthRewardDialog extends RelativeLayout implements Runnable {
    public static boolean tj = false;
    public String fs;
    public ScaleAnimation l;
    public SaasAuthEnvelope n;
    public RotateAnimation q;
    public BaseSaasEnvelope qg;
    public int rv;
    public ImageView s;
    public boolean w;
    public pk x;

    public SaasAuthRewardDialog(Context context) {
        super(context);
        this.w = false;
        n(context);
    }

    public void n(pk pkVar, String str, int i) {
        if (pkVar == null || qg.n().s() != 2) {
            setVisibility(8);
            return;
        }
        dg dgVarCp = pkVar.cp();
        if (dgVarCp == null || ((dgVarCp.cp() == null && dgVarCp.tj() == null) || !dgVarCp.rv())) {
            setVisibility(8);
            return;
        }
        this.x = pkVar;
        this.fs = str;
        this.rv = i;
        setBackgroundColor(Color.parseColor("#aa000000"));
        rv.qg().postDelayed(this, 5000L);
        n(getContext());
        s();
    }

    private void n(Context context) {
        this.s = new ImageView(context);
        try {
            s.n(com.byazt.iu.n.n("saas_light_shine.webp")).n(this.s);
            this.s.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (Error unused) {
        }
        int iL = com.byazt.okk.s.l(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iL, iL);
        layoutParams.addRule(13);
        addView(this.s, layoutParams);
        SaasAuthEnvelope saasAuthEnvelope = new SaasAuthEnvelope(context);
        this.n = saasAuthEnvelope;
        saasAuthEnvelope.setId(2114387464);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.n, layoutParams2);
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.rkq.SaasAuthRewardDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.qg();
                rv.qg().removeCallbacks(SaasAuthRewardDialog.this);
            }
        });
        this.n.setOnCloseClickListener(new View.OnClickListener() { // from class: com.byazt.rkq.SaasAuthRewardDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SaasAuthRewardDialog.this.n();
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        if (getVisibility() != 0) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.l = scaleAnimation;
            scaleAnimation.setDuration(600L);
            this.l.setFillAfter(true);
            this.l.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.rkq.SaasAuthRewardDialog.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SaasAuthRewardDialog.this.q = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                    SaasAuthRewardDialog.this.q.setDuration(5000L);
                    SaasAuthRewardDialog.this.q.setRepeatCount(-1);
                    SaasAuthRewardDialog.this.q.setFillAfter(true);
                    SaasAuthRewardDialog.this.q.setInterpolator(new LinearInterpolator());
                    SaasAuthRewardDialog.this.s.startAnimation(SaasAuthRewardDialog.this.q);
                }
            });
            this.s.startAnimation(this.l);
            com.byazt.gcl.s.qg(true);
            setVisibility(0);
            this.n.n();
            rv.qg().postDelayed(this, 2000L);
            return;
        }
        if (!this.w) {
            rv.qg().postDelayed(this, 5000L);
            qg();
        } else {
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg() {
        this.w = true;
        dg dgVarCp = this.x.cp();
        if (dgVarCp.tj() != null) {
            this.qg = new SaasAuthCouponEnvelope(getContext(), dgVarCp.tj());
        } else if (dgVarCp.cp() != null) {
            this.qg = new SaasAuthProductEnvelope(getContext(), dgVarCp.cp());
        }
        BaseSaasEnvelope baseSaasEnvelope = this.qg;
        if (baseSaasEnvelope != null) {
            addView(baseSaasEnvelope, new RelativeLayout.LayoutParams(-1, -1));
            this.qg.n();
            com.byazt.ys.n nVar = new com.byazt.ys.n(getContext(), this.x, this.fs, this.rv);
            setTag(TTAdConstant.KEY_CLICK_AREA, 2917);
            com.byazt.wu.n.n().n(this.x.hashCode() + this.x.ou()).put("live_saas_interaction_type", 101);
            setOnClickListener(nVar);
            this.qg.setOnCloseClickListener(new View.OnClickListener() { // from class: com.byazt.rkq.SaasAuthRewardDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SaasAuthRewardDialog.this.n();
                }
            });
            this.qg.setOnButtonClickListener(nVar);
        }
        SaasAuthEnvelope saasAuthEnvelope = this.n;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.qg();
        }
        removeView(this.n);
    }

    public void n() {
        SaasAuthEnvelope saasAuthEnvelope = this.n;
        if (saasAuthEnvelope != null) {
            saasAuthEnvelope.qg();
        }
        BaseSaasEnvelope baseSaasEnvelope = this.qg;
        if (baseSaasEnvelope != null) {
            baseSaasEnvelope.qg();
        }
        RotateAnimation rotateAnimation = this.q;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
            this.q = null;
        }
        ScaleAnimation scaleAnimation = this.l;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
            this.l = null;
        }
        rv.qg().removeCallbacks(this);
        setVisibility(8);
        com.byazt.gcl.s.qg(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.byazt.gcl.s.qg(false);
    }

    private void s() {
        try {
            if (tj) {
                return;
            }
            n nVar = new n();
            s.n(com.byazt.iu.n.n("saas_light_shine.webp")).n(nVar);
            s.n(com.byazt.iu.n.n("saas_red_envelope.webp")).n(nVar);
            s.n(com.byazt.iu.n.n("saas_reward_goods_bg.webp")).n(nVar);
            s.n(com.byazt.iu.n.n("saas_reward_coupon_bg.webp")).n(nVar);
            s.n(com.byazt.iu.n.n("saas_reward_title.webp")).n(nVar);
            tj = true;
        } catch (Throwable unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, 1379})
    private static class n implements m {
        @Override // com.byazt.si.m
        public void n(int i, String str, Throwable th) {
        }

        @Override // com.byazt.si.m
        public void n(cy cyVar) {
        }

        private n() {
        }
    }
}
