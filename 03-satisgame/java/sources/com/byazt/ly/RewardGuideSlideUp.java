package com.byazt.ly;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.nf.rv;
import com.byazt.tk.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 119, 1175})
public class RewardGuideSlideUp extends RelativeLayout {
    public final AnimatorSet l;
    public ImageView n;
    public AnimatorSet q;
    public ImageView qg;
    public ImageView s;
    public final AnimatorSet w;
    public final AnimatorSet x;

    public RewardGuideSlideUp(Context context) {
        super(context);
        this.l = new AnimatorSet();
        this.w = new AnimatorSet();
        this.x = new AnimatorSet();
        n(context);
    }

    private void n(Context context) {
        if (context == null) {
            context = rv.getContext();
        }
        addView(com.byazt.cb.qg.cp(context));
        this.n = (ImageView) findViewById(2114387644);
        this.qg = (ImageView) findViewById(2114387939);
        this.s = (ImageView) findViewById(2114387639);
    }

    public void n() {
        this.q = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.n, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.n, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.n, "translationY", 0.0f, com.byazt.okk.s.s(getContext(), -110.0f));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, com.byazt.okk.s.s(getContext(), 110.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.ly.RewardGuideSlideUp.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) RewardGuideSlideUp.this.qg.getLayoutParams();
                layoutParams.height = num.intValue();
                RewardGuideSlideUp.this.qg.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.qg, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.qg, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.s, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.s, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.s, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.s, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.s, "translationY", 0.0f, com.byazt.okk.s.s(getContext(), -110.0f));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.l.setDuration(50L);
        this.x.setDuration(3000L);
        this.w.setDuration(50L);
        this.l.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.w.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.x.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.q.playSequentially(this.w, this.x, this.l);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.q;
    }

    public void qg() {
        try {
            AnimatorSet animatorSet = this.q;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.w;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.l;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.x;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable th) {
            k.n(th.getMessage());
        }
    }
}
