package com.mcto.sspsdk.internal;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class cd extends ConstraintLayout {
    public final AppCompatActivity a;
    public DownloadButtonView b;
    public final e c;
    public ArrayList d;
    public View e;
    public AnimatorSet f;

    public cd(AppCompatActivity appCompatActivity, e eVar) {
        super(appCompatActivity);
        this.a = appCompatActivity;
        setBackgroundColor(-1);
        this.c = eVar;
    }

    public final void a(int i) {
        if (this.b == null) {
            return;
        }
        a();
        if (i == 1) {
            if (this.e == null) {
                ImageView imageView = new ImageView(this.a);
                imageView.setImageResource(R.drawable.qy_lg_cycle);
                imageView.setId(R.id.qy_card_download_cycle_heart_img);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.e = imageView;
            }
            if (findViewById(R.id.qy_card_download_cycle_heart_img) == null) {
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(hk.a(this.a, 14.0f), hk.a(this.a, 14.0f));
                int i2 = R.id.qy_card_download_btn;
                layoutParams.topToTop = i2;
                layoutParams.leftToLeft = i2;
                layoutParams.rightToRight = i2;
                layoutParams.bottomToBottom = i2;
                layoutParams.dimensionRatio = "H,1:1";
                addView(this.e, layoutParams);
            }
            AnimatorSet animatorSetA = r0.a(this.e, 2.5f, 2.5f, 0.0f);
            this.f = animatorSetA;
            animatorSetA.start();
            AnimatorSet animatorSetA2 = r0.a(this.b, 1.08f, 1.08f);
            this.f = animatorSetA2;
            animatorSetA2.start();
            return;
        }
        if (i == 2) {
            AnimatorSet animatorSetB = r0.b(this.b);
            this.f = animatorSetB;
            animatorSetB.start();
            return;
        }
        if (i == 3 && this.b != null) {
            hk.a(this.d);
            FrameLayout frameLayout = new FrameLayout(this.a);
            frameLayout.setId(R.id.qy_card_download_cycle_heart_img);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(this.b.getWidth(), this.b.getHeight());
            int i3 = R.id.qy_card_download_btn;
            layoutParams2.topToTop = i3;
            layoutParams2.leftToLeft = i3;
            layoutParams2.rightToRight = i3;
            layoutParams2.bottomToBottom = i3;
            addView(frameLayout, layoutParams2);
            this.e = frameLayout;
            Point point = new Point((this.b.getWidth() * 3) / 4, this.b.getHeight() / 2);
            int iA = hk.a(getContext(), 21.0f);
            int iA2 = hk.a(getContext(), 21.0f);
            int iA3 = hk.a(getContext(), 48.0f);
            int iA4 = hk.a(getContext(), 48.0f);
            FrameLayout frameLayout2 = new FrameLayout(frameLayout.getContext());
            frameLayout2.setBackgroundColor(0);
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            ArrayList arrayList = new ArrayList();
            arrayList.add(frameLayout2);
            ImageView imageView2 = new ImageView(frameLayout.getContext());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iA, iA2);
            layoutParams3.setMargins(point.x - (iA / 2), point.y - (iA2 / 2), 0, 0);
            imageView2.setImageResource(R.drawable.qy_ic_ripple);
            imageView2.setAlpha(0.0f);
            frameLayout2.addView(imageView2, layoutParams3);
            arrayList.add(imageView2);
            ImageView imageView3 = new ImageView(frameLayout.getContext());
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(iA3, iA4);
            layoutParams4.setMargins(point.x - (iA3 / 15), point.y - (iA4 / 15), 0, 0);
            imageView3.setImageResource(R.drawable.qy_lg_hand_click);
            frameLayout2.addView(imageView3, layoutParams4);
            arrayList.add(imageView3);
            View view = new View(frameLayout.getContext());
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(1, 1);
            layoutParams5.gravity = 17;
            view.setBackgroundColor(0);
            frameLayout2.addView(view, layoutParams5);
            arrayList.add(view);
            if (!TextUtils.isEmpty(null)) {
                TextView textView = new TextView(frameLayout.getContext());
                FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams6.gravity = 1;
                layoutParams6.setMargins(0, hk.a(frameLayout.getContext(), 20.0f) + point.y + iA4, 0, 0);
                textView.setText((CharSequence) null);
                textView.setTextSize(1, 14.0f);
                textView.setTextColor(-1);
                frameLayout2.addView(textView, layoutParams6);
                arrayList.add(textView);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView3, "scaleX", 1.0f, 1.0f, 0.8f, 1.0f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView3, "scaleY", 1.0f, 1.0f, 0.8f, 1.0f, 1.0f);
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat2.setRepeatCount(-1);
            objectAnimatorOfFloat2.setDuration(1000L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            imageView3.setTag(animatorSet);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(imageView2, "scaleX", 0.8f, 2.0f);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(imageView2, "scaleY", 0.8f, 2.0f);
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(imageView2, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat3.setRepeatCount(-1);
            objectAnimatorOfFloat3.setDuration(1000L);
            objectAnimatorOfFloat4.setRepeatCount(-1);
            objectAnimatorOfFloat4.setDuration(1000L);
            objectAnimatorOfFloat5.setRepeatCount(-1);
            objectAnimatorOfFloat5.setDuration(1000L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat5);
            animatorSet2.setStartDelay(500L);
            imageView2.setTag(animatorSet2);
            animatorSet2.addListener(new fk(frameLayout2));
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, frameLayout.getWidth());
            ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, frameLayout.getHeight());
            objectAnimatorOfFloat6.setDuration(400L);
            objectAnimatorOfFloat7.setDuration(400L);
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(objectAnimatorOfFloat6, objectAnimatorOfFloat7);
            view.setTag(animatorSet3);
            animatorSet3.addListener(new gk(frameLayout2, view));
            animatorSet3.start();
            animatorSet2.start();
            animatorSet.start();
            this.d = arrayList;
        }
    }

    public abstract void a(int i, int i2);

    public abstract void a(me meVar);

    public void b() {
        a();
        e();
    }

    public boolean c() {
        return false;
    }

    public void d() {
    }

    public void e() {
    }

    public final void a() {
        AnimatorSet animatorSet = this.f;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f.cancel();
        }
        View view = this.e;
        if (view != null) {
            removeView(view);
            this.e = null;
        }
        hk.a(this.d);
    }

    public void a(int i, long j) {
    }
}
