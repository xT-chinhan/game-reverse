package com.byazt.stl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.cq.fs;
import com.byazt.tk.k;
import com.byazt.twc.q;
import com.byazt.xta.qg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST})
public class SlideUpView extends RelativeLayout {
    public int cp;
    public AnimatorSet fs;
    public TextView l;
    public ImageView n;
    public TextView q;
    public ImageView qg;
    public AnimatorSet rv;
    public ImageView s;
    public String tj;
    public AnimatorSet w;
    public AnimatorSet x;

    public SlideUpView(Context context) {
        super(context);
        this.w = new AnimatorSet();
        this.x = new AnimatorSet();
        this.fs = new AnimatorSet();
        this.rv = new AnimatorSet();
        this.cp = 100;
        n(context);
    }

    public SlideUpView(Context context, String str) {
        super(context);
        this.w = new AnimatorSet();
        this.x = new AnimatorSet();
        this.fs = new AnimatorSet();
        this.rv = new AnimatorSet();
        this.cp = 100;
        setClipChildren(false);
        this.tj = str;
        n(context);
    }

    public void n(Context context) {
        if (context == null) {
            context = q.getContext();
        }
        if ("5".equals(this.tj)) {
            addView(qg.w(context));
            this.cp = (int) (((double) this.cp) * 1.25d);
        } else {
            addView(qg.l(context));
        }
        this.n = (ImageView) findViewById(2097610734);
        this.qg = (ImageView) findViewById(2097610735);
        this.q = (TextView) findViewById(2097610730);
        this.s = (ImageView) findViewById(2097610733);
        this.l = (TextView) findViewById(2097610731);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.w;
    }

    public void n() {
        s();
        this.w.start();
        this.w.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.stl.SlideUpView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideUpView.this.postDelayed(new Runnable() { // from class: com.byazt.stl.SlideUpView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideUpView.this.w.start();
                    }
                }, 200L);
            }
        });
    }

    public void s() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.n, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.n, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.n, "translationY", 0.0f, fs.n(getContext(), -this.cp));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) fs.n(getContext(), this.cp));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.stl.SlideUpView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SlideUpView.this.s != null) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.s.getLayoutParams();
                    layoutParams.height = num.intValue();
                    SlideUpView.this.s.setLayoutParams(layoutParams);
                }
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.s, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.s, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.qg, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.qg, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.qg, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.qg, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.qg, "translationY", 0.0f, fs.n(getContext(), -this.cp));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.x.setDuration(50L);
        this.rv.setDuration(1500L);
        this.fs.setDuration(50L);
        this.x.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.fs.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.rv.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.w.playSequentially(this.fs, this.rv, this.x);
    }

    public void qg() {
        try {
            AnimatorSet animatorSet = this.w;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.fs;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.x;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.rv;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e) {
            k.n(e.getMessage());
        }
    }

    public void setGuideText(String str) {
        TextView textView = this.q;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.l != null) {
            if (TextUtils.isEmpty(str)) {
                this.l.setText("");
            } else {
                this.l.setText(str);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        qg();
    }
}
