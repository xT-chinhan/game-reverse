package com.byazt.jt;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.ca.ho;
import com.byazt.dj.x;
import com.byazt.js.zo;
import com.byazt.uz.hw;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 859})
public class SlideUpView extends RelativeLayout {
    public AnimatorSet aj;
    public TextView c;
    public AnimatorSet fw;
    public ImageView hn;
    public ImageView hw;
    public ImageView pr;
    public AnimatorSet uc;
    public String vk;
    public int w;
    public TextView x;
    public AnimatorSet zo;

    public SlideUpView(Context context) {
        super(context);
        this.uc = new AnimatorSet();
        this.fw = new AnimatorSet();
        this.zo = new AnimatorSet();
        this.aj = new AnimatorSet();
        this.w = 100;
        pr(context);
    }

    public SlideUpView(Context context, String str) {
        super(context);
        this.uc = new AnimatorSet();
        this.fw = new AnimatorSet();
        this.zo = new AnimatorSet();
        this.aj = new AnimatorSet();
        this.w = 100;
        setClipChildren(false);
        this.vk = str;
        pr(context);
    }

    public void pr(Context context) {
        if (context == null) {
            context = x.getContext();
        }
        if (GlobalSetting.REWARD_VIDEO_AD.equals(this.vk)) {
            addView(hw.uc(context));
            this.w = (int) (((double) this.w) * 1.25d);
        } else {
            addView(hw.c(context));
        }
        this.pr = (ImageView) findViewById(2097610734);
        this.hw = (ImageView) findViewById(2097610735);
        this.x = (TextView) findViewById(2097610730);
        this.hn = (ImageView) findViewById(2097610733);
        this.c = (TextView) findViewById(2097610731);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.uc;
    }

    public void pr() {
        hn();
        this.uc.start();
        this.uc.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.jt.SlideUpView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideUpView.this.postDelayed(new Runnable() { // from class: com.byazt.jt.SlideUpView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideUpView.this.uc.start();
                    }
                }, 200L);
            }
        });
    }

    public void hn() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.pr, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.pr, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.pr, "translationY", 0.0f, zo.pr(getContext(), -this.w));
        if (Build.VERSION.SDK_INT >= 21) {
            objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            objectAnimatorOfFloat3.setInterpolator(com.byazt.ce.x.pr(0.2f, 0.0f, 0.3f, 1.0f));
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) zo.pr(getContext(), this.w));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.jt.SlideUpView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SlideUpView.this.hn != null) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.hn.getLayoutParams();
                    layoutParams.height = num.intValue();
                    SlideUpView.this.hn.setLayoutParams(layoutParams);
                }
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            valueAnimatorOfInt.setInterpolator(com.byazt.ce.x.pr(0.2f, 0.0f, 0.3f, 1.0f));
        }
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.hn, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.hn, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.hw, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.hw, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.hw, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.hw, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.hw, "translationY", 0.0f, zo.pr(getContext(), -this.w));
        if (Build.VERSION.SDK_INT >= 21) {
            objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            objectAnimatorOfFloat10.setInterpolator(com.byazt.ce.x.pr(0.2f, 0.0f, 0.3f, 1.0f));
        }
        this.fw.setDuration(50L);
        this.aj.setDuration(1500L);
        this.zo.setDuration(50L);
        this.fw.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.zo.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.aj.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.uc.playSequentially(this.zo, this.aj, this.fw);
    }

    public void hw() {
        try {
            AnimatorSet animatorSet = this.uc;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.zo;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.fw;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.aj;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e) {
            ho.pr(e.getMessage());
        }
    }

    public void setGuideText(String str) {
        TextView textView = this.x;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.c != null) {
            if (TextUtils.isEmpty(str)) {
                this.c.setText("");
            } else {
                this.c.setText(str);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hw();
    }
}
