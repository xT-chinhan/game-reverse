package com.smartdigimkt.sdk.basead.ui.animplayerview.scale;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.smartdigimkt.q1.l;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseAlbumScaleItemView extends FrameLayout implements l {
    public AnimatorSet a;
    public float b;
    public boolean c;
    public long d;

    public BaseAlbumScaleItemView(Context context) {
        this(context, null);
    }

    public abstract int a(Context context);

    public float dip2px(float f) {
        return (f * getContext().getResources().getDisplayMetrics().density) + 0.5f;
    }

    public List<Animator> getAnimatorList(View view, float f, float f2, int i) {
        ArrayList arrayList = new ArrayList();
        if (f > 0.0f || f2 > 0.0f) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, f2);
            arrayList.add(objectAnimatorOfFloat);
            arrayList.add(objectAnimatorOfFloat2);
        }
        if (i > 0) {
            float f3 = i;
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, f3);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, f3);
            arrayList.add(objectAnimatorOfFloat3);
            arrayList.add(objectAnimatorOfFloat4);
        }
        return arrayList;
    }

    public int getScreenHeight() {
        return getContext().getResources().getDisplayMetrics().heightPixels;
    }

    public int getScreenWidth() {
        return getContext().getResources().getDisplayMetrics().widthPixels;
    }

    public void initView(View view) {
    }

    @Override // com.smartdigimkt.q1.l
    public void pause() {
        AnimatorSet animatorSet = this.a;
        if (animatorSet != null) {
            animatorSet.pause();
        }
    }

    public void release() {
        stop();
    }

    public void resume() {
        AnimatorSet animatorSet = this.a;
        if (animatorSet != null) {
            animatorSet.resume();
        }
    }

    public void setBitmapResources(List<Bitmap> list) {
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            Objects.toString(childAt);
            if (childAt instanceof WrapRoundImageView) {
                ((WrapRoundImageView) childAt).setImageBitmap(list.get(i % 4));
            }
        }
    }

    public void setMainViewScale(float f) {
        this.b = f;
    }

    public void setOrientation(boolean z) {
        this.c = z;
    }

    public void setStartDelay(long j) {
        this.d = j;
    }

    public void start() {
    }

    @Override // com.smartdigimkt.q1.l
    public void stop() {
        AnimatorSet animatorSet = this.a;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.a = null;
        }
    }

    public BaseAlbumScaleItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseAlbumScaleItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View viewInflate = LayoutInflater.from(context).inflate(a(context), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(viewInflate, layoutParams);
        initView(viewInflate);
    }
}
