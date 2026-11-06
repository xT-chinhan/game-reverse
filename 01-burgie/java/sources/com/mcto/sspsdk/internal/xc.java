package com.mcto.sspsdk.internal;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.interaction.QyRingView;

/* JADX INFO: loaded from: classes2.dex */
public final class xc extends ConstraintLayout {
    public final QyRingView a;
    public final ImageView[] b;
    public final Handler c;

    public xc(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        this.b = new ImageView[]{(ImageView) findViewById(R.id.qy_arrow_top), (ImageView) findViewById(R.id.qy_arrow_right), (ImageView) findViewById(R.id.qy_arrow_bottom), (ImageView) findViewById(R.id.qy_arrow_left)};
        this.c = new Handler();
        LayoutInflater.from(appCompatActivity).inflate(R.layout.qy_view_breathing_ring_arrows, (ViewGroup) this, true);
        setBackgroundColor(0);
        this.a = (QyRingView) findViewById(R.id.qy_ring_view);
    }

    public static void a(xc xcVar, ImageView imageView) {
        xcVar.getClass();
        float rotation = imageView.getRotation() % 360.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, (rotation > 0.0f ? 1 : (rotation == 0.0f ? 0 : -1)) == 0 || (rotation > 180.0f ? 1 : (rotation == 180.0f ? 0 : -1)) == 0 ? "translationX" : "translationY", 0.0f, ((rotation == 0.0f || rotation == 90.0f) ? -1.0f : 1.0f) * 25.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
        this.a.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c.removeCallbacksAndMessages(null);
        for (ImageView imageView : this.b) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).stop();
            }
            imageView.clearAnimation();
        }
    }

    public final void a() {
        int i = 0;
        while (true) {
            ImageView[] imageViewArr = this.b;
            if (i < imageViewArr.length) {
                this.c.postDelayed(new vc(this, i), ((long) i) * 600);
                Drawable drawable = this.b[i].getDrawable();
                if (drawable instanceof AnimatedVectorDrawable) {
                    ((AnimatedVectorDrawable) drawable).start();
                }
                i++;
            } else {
                this.c.postDelayed(new wc(this), (((long) imageViewArr.length) * 600) + 600);
                return;
            }
        }
    }
}
