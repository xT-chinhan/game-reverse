package com.smartdigimkt.sdk.basead.ui.animplayerview.viewpager;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.smartdigimkt.q1.m;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import com.smartdigimkt.t1.a;
import com.smartdigimkt.t1.c;
import com.smartdigimkt.t1.d;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class VpMainImgAnimatorView extends RelativeLayout implements m {
    public static final /* synthetic */ int l = 0;
    public WrapRoundImageView a;
    public WrapRoundImageView b;
    public CircleIndicatorView c;
    public CircleIndicatorView d;
    public int e;
    public float f;
    public float g;
    public final a h;
    public ObjectAnimator i;
    public ObjectAnimator j;
    public AnimatorSet k;

    public VpMainImgAnimatorView(Context context) {
        this(context, null);
    }

    public final void a() {
        WrapRoundImageView wrapRoundImageView = this.a;
        float translationX = wrapRoundImageView.getTranslationX();
        float f = this.f;
        if (translationX != f) {
            f = this.g;
        }
        float translationX2 = wrapRoundImageView.getTranslationX();
        float f2 = this.f;
        if (translationX2 == f2) {
            f2 = -this.g;
        }
        float[] fArr = {f, f2};
        WrapRoundImageView wrapRoundImageView2 = this.b;
        float translationX3 = wrapRoundImageView2.getTranslationX();
        float f3 = this.f;
        if (translationX3 != f3) {
            f3 = this.g;
        }
        float translationX4 = wrapRoundImageView2.getTranslationX();
        float f4 = this.f;
        if (translationX4 == f4) {
            f4 = -this.g;
        }
        float[] fArr2 = {f3, f4};
        ObjectAnimator objectAnimator = this.i;
        WrapRoundImageView wrapRoundImageView3 = this.a;
        float f5 = fArr[0];
        float f6 = fArr[1];
        if (objectAnimator == null) {
            objectAnimator = new ObjectAnimator();
            objectAnimator.setPropertyName("translationX");
            objectAnimator.addListener(new d(this, wrapRoundImageView3));
        }
        objectAnimator.setTarget(wrapRoundImageView3);
        objectAnimator.setFloatValues(f5, f6);
        this.i = objectAnimator;
        ObjectAnimator objectAnimator2 = this.j;
        WrapRoundImageView wrapRoundImageView4 = this.b;
        float f7 = fArr2[0];
        float f8 = fArr2[1];
        if (objectAnimator2 == null) {
            objectAnimator2 = new ObjectAnimator();
            objectAnimator2.setPropertyName("translationX");
            objectAnimator2.addListener(new d(this, wrapRoundImageView4));
        }
        objectAnimator2.setTarget(wrapRoundImageView4);
        objectAnimator2.setFloatValues(f7, f8);
        this.j = objectAnimator2;
        if (this.k == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.k = animatorSet;
            animatorSet.playTogether(this.i, this.j);
            this.k.setDuration(500L);
            this.k.setInterpolator(new AccelerateDecelerateInterpolator());
            this.k.addListener(new c(this));
        }
        this.k.start();
    }

    @Override // com.smartdigimkt.q1.m
    public void addMainView(Bitmap bitmap, WrapRoundImageView... wrapRoundImageViewArr) {
        if (wrapRoundImageViewArr == null || bitmap == null || wrapRoundImageViewArr.length < 2) {
            return;
        }
        removeAllViews();
        this.a = wrapRoundImageViewArr[0];
        this.b = wrapRoundImageViewArr[1];
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        layoutParams2.addRule(13);
        this.a.setLayoutParams(layoutParams);
        this.b.setLayoutParams(layoutParams2);
        addView(this.a);
        addView(this.b);
        int i = getContext().getResources().getDisplayMetrics().widthPixels;
        int i2 = getContext().getResources().getDisplayMetrics().heightPixels;
        this.a.setBitmapAndResize(bitmap, i, i2);
        this.b.setBitmapAndResize(bitmap, i, i2);
        ViewGroup.LayoutParams layoutParams3 = this.a.getLayoutParams();
        this.e = layoutParams3.width;
        int i3 = layoutParams3.height;
        ViewGroup.LayoutParams layoutParams4 = getLayoutParams();
        layoutParams4.width = this.e;
        layoutParams4.height = i3;
        setLayoutParams(layoutParams4);
        float translationX = this.a.getTranslationX();
        this.f = translationX;
        float f = translationX + this.e;
        this.g = f;
        this.b.setTranslationX(f);
        this.c = new CircleIndicatorView(getContext());
        this.d = new CircleIndicatorView(getContext());
        int iA = k.a(getContext(), 8.0f);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(iA, iA);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(iA, iA);
        layoutParams6.leftMargin = k.a(getContext(), 4.0f);
        linearLayout.addView(this.c, layoutParams5);
        linearLayout.addView(this.d, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(12);
        layoutParams7.addRule(14);
        layoutParams7.bottomMargin = k.a(getContext(), 3.0f);
        addView(linearLayout, layoutParams7);
        b();
    }

    public final void b() {
        WrapRoundImageView wrapRoundImageView;
        if (this.c == null || this.d == null || (wrapRoundImageView = this.a) == null) {
            return;
        }
        if (wrapRoundImageView.getTranslationX() == this.f) {
            this.c.setSelectStatus(true);
            this.d.setSelectStatus(false);
        } else {
            this.c.setSelectStatus(false);
            this.d.setSelectStatus(true);
        }
    }

    @Override // com.smartdigimkt.q1.l
    public void pause() {
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.pause();
        }
    }

    @Override // com.smartdigimkt.q1.m
    public void release() {
        stop();
    }

    public void resume() {
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.resume();
            return;
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.removeMessages(100);
            this.h.sendEmptyMessageDelayed(100, 1500L);
        }
    }

    @Override // com.smartdigimkt.q1.l
    public void setBitmapResources(List<Bitmap> list) {
    }

    @Override // com.smartdigimkt.q1.l
    public void start() {
        if (this.k != null) {
            resume();
            return;
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.sendEmptyMessageDelayed(100, 1500L);
        }
    }

    @Override // com.smartdigimkt.q1.l
    public void stop() {
        a aVar = this.h;
        if (aVar != null) {
            aVar.removeMessages(100);
        }
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.i = null;
        }
        ObjectAnimator objectAnimator2 = this.j;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllListeners();
            this.j = null;
        }
        AnimatorSet animatorSet = this.k;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.k.cancel();
            this.k = null;
        }
    }

    public VpMainImgAnimatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VpMainImgAnimatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = new a(this, Looper.getMainLooper());
    }
}
