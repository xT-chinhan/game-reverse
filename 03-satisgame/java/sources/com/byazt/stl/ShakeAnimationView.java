package com.byazt.stl;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.lh.tj;
import com.byazt.tk.ou;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1833})
public class ShakeAnimationView extends LinearLayout {
    public boolean cp;
    public n fs;
    public ou l;
    public int n;
    public ImageView q;
    public TextView qg;
    public LinearLayout rv;
    public TextView s;
    public tj tj;
    public TextView w;
    public TextView x;

    public interface n {
        void n(boolean z);
    }

    public ShakeAnimationView(Context context, View view, tj tjVar, boolean z, int i) {
        super(context);
        this.tj = tjVar;
        this.cp = z;
        this.n = i;
        n(context, view);
    }

    public void n(Context context, View view) {
        addView(view);
        this.rv = (LinearLayout) findViewById(2097610727);
        this.q = (ImageView) findViewById(2097610725);
        this.qg = (TextView) findViewById(2097610724);
        this.s = (TextView) findViewById(2097610726);
        this.w = (TextView) findViewById(2097610723);
        this.x = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.rv.setBackground(gradientDrawable);
    }

    public void setShakeText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.w.setVisibility(8);
            this.x.setVisibility(8);
        } else {
            this.w.setText(str);
        }
    }

    public LinearLayout getShakeLayout() {
        return this.rv;
    }

    public void setOnShakeViewListener(n nVar) {
        this.fs = nVar;
    }

    public void n() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }

    /* JADX INFO: renamed from: com.byazt.stl.ShakeAnimationView$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1518})
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ShakeAnimationView.this.q != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new qg(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.byazt.stl.ShakeAnimationView.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ShakeAnimationView.this.postDelayed(new Runnable() { // from class: com.byazt.stl.ShakeAnimationView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ShakeAnimationView.this.q.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }
                });
                ShakeAnimationView.this.q.startAnimation(rotateAnimation);
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 771})
    private static class qg implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.25f) {
                return (f * (-2.0f)) + 0.5f;
            }
            if (f <= 0.5f) {
                return (f * 4.0f) - 1.0f;
            }
            return f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }

        private qg() {
        }

        public /* synthetic */ qg(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.l == null) {
                this.l = new ou(getContext().getApplicationContext(), 1, this.cp);
            }
            this.l.n(new ou.n() { // from class: com.byazt.stl.ShakeAnimationView.2
                @Override // com.byazt.tk.ou.n
                public void n(int i) {
                    boolean zN = ShakeAnimationView.this.l != null ? ShakeAnimationView.this.l.n() : false;
                    if (i == 1 && ShakeAnimationView.this.isShown() && ShakeAnimationView.this.fs != null) {
                        ShakeAnimationView.this.fs.n(zN);
                    }
                }
            });
            tj tjVar = this.tj;
            if (tjVar != null) {
                this.l.n(tjVar.n());
                this.l.s(this.tj.x());
                this.l.s(this.tj.qg());
                this.l.l(this.tj.q());
                this.l.qg(this.tj.s());
                this.l.w(this.tj.l());
                this.l.n(this.tj.w());
                this.l.qg(this.tj.fs());
                this.l.n(this.n);
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ou ouVar = this.l;
        if (ouVar != null) {
            if (z) {
                ouVar.n(this.n);
            } else {
                ouVar.qg(this.n);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ou ouVar = this.l;
        if (ouVar != null) {
            ouVar.qg(this.n);
        }
    }
}
