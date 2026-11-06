package com.anythink.basead.ui.animplayerview.scale;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.basead.ui.WrapRoundImageView;
import com.anythink.basead.ui.animplayerview.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAlbumScaleItemView extends FrameLayout implements b {
    protected List<Bitmap> a;
    protected AnimatorSet b;
    protected float c;
    protected boolean d;
    protected long e;

    protected abstract int a(Context context);

    public void initView(View view) {
    }

    public void start() {
    }

    public BaseAlbumScaleItemView(Context context) {
        this(context, null);
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

    public void setBitmapResources(List<Bitmap> list) {
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            Log.d("AlbumScaleItemView03", "view: ".concat(String.valueOf(childAt)));
            if (childAt instanceof WrapRoundImageView) {
                ((WrapRoundImageView) childAt).setImageBitmap(list.get(i % 4));
            }
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void pause() {
        if (this.b != null) {
            this.b.pause();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void resume() {
        if (this.b != null) {
            this.b.resume();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void stop() {
        AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.b = null;
        }
    }

    public void release() {
        stop();
    }

    public void setMainViewScale(float f) {
        this.c = f;
    }

    public float dip2px(float f) {
        return (f * getContext().getResources().getDisplayMetrics().density) + 0.5f;
    }

    protected final int a() {
        return getContext().getResources().getDisplayMetrics().widthPixels;
    }

    protected final int b() {
        return getContext().getResources().getDisplayMetrics().heightPixels;
    }

    public void setOrientation(boolean z) {
        this.d = z;
    }

    public void setStartDelay(long j) {
        this.e = j;
    }
}
