package com.mcto.sspsdk.internal;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class be extends RatingBar {
    public final ColorStateList a;
    public final ColorStateList b;
    public final ColorStateList c;
    public final int d;
    public final int e;
    public final boolean f;
    public final float g;
    public float h;
    public final boolean i;
    public final hj j;

    public be(AppCompatActivity appCompatActivity) {
        super(appCompatActivity, null);
        TypedArray typedArrayObtainStyledAttributes = appCompatActivity.obtainStyledAttributes(null, R.styleable.qy_reward_andratingbar, 0, 0);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.qy_reward_andratingbar_qy_right2left, false);
        this.i = z;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.qy_reward_andratingbar_qy_star_color)) {
            if (z) {
                this.c = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.qy_reward_andratingbar_qy_star_color);
            } else {
                this.a = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.qy_reward_andratingbar_qy_star_color);
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.qy_reward_andratingbar_qy_substar_color) && !z) {
            this.b = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.qy_reward_andratingbar_qy_substar_color);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.qy_reward_andratingbar_qy_bg_color)) {
            if (z) {
                this.a = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.qy_reward_andratingbar_qy_bg_color);
            } else {
                this.c = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.qy_reward_andratingbar_qy_bg_color);
            }
        }
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.qy_reward_andratingbar_qy_keep_origincolor, false);
        this.f = z2;
        this.g = typedArrayObtainStyledAttributes.getFloat(R.styleable.qy_reward_andratingbar_qy_scale_factor, 1.0f);
        this.h = typedArrayObtainStyledAttributes.getDimension(R.styleable.qy_reward_andratingbar_qy_star_spacing, 0.0f);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.qy_reward_andratingbar_qy_star_drawable, R.drawable.qy_ic_baseline_star_24);
        this.d = resourceId;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.qy_reward_andratingbar_qy_bg_drawable)) {
            this.e = typedArrayObtainStyledAttributes.getResourceId(R.styleable.qy_reward_andratingbar_qy_bg_drawable, R.drawable.qy_ic_baseline_star_24);
        } else {
            this.e = resourceId;
        }
        typedArrayObtainStyledAttributes.recycle();
        hj hjVar = new hj(resourceId, this.e, appCompatActivity, z2);
        this.j = hjVar;
        int numStars = getNumStars();
        vj vjVarA = hjVar.a(android.R.id.background);
        vjVarA.h = numStars;
        vjVarA.invalidateSelf();
        vj vjVarA2 = hjVar.a(android.R.id.secondaryProgress);
        vjVarA2.h = numStars;
        vjVarA2.invalidateSelf();
        vj vjVarA3 = hjVar.a(android.R.id.progress);
        vjVarA3.h = numStars;
        vjVarA3.invalidateSelf();
        setProgressDrawable(hjVar);
        if (z) {
            setRating(getNumStars() - getRating());
        }
    }

    public final Drawable a(int i, boolean z) {
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable == null) {
            return null;
        }
        progressDrawable.mutate();
        Drawable drawableFindDrawableByLayerId = progressDrawable instanceof LayerDrawable ? ((LayerDrawable) progressDrawable).findDrawableByLayerId(i) : null;
        return (drawableFindDrawableByLayerId == null && z) ? progressDrawable : drawableFindDrawableByLayerId;
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        Drawable drawable = this.j.a(android.R.id.progress).g;
        setMeasuredDimension(View.resolveSizeAndState(Math.round((drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) * measuredHeight * getNumStars() * this.g) + ((int) ((getNumStars() - 1) * this.h)), i, 0), measuredHeight);
    }

    @Override // android.widget.RatingBar
    public final void setNumStars(int i) {
        super.setNumStars(i);
        hj hjVar = this.j;
        if (hjVar != null) {
            vj vjVarA = hjVar.a(android.R.id.background);
            vjVarA.h = i;
            vjVarA.invalidateSelf();
            vj vjVarA2 = hjVar.a(android.R.id.secondaryProgress);
            vjVarA2.h = i;
            vjVarA2.invalidateSelf();
            vj vjVarA3 = hjVar.a(android.R.id.progress);
            vjVarA3.h = i;
            vjVarA3.invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar
    public final void setProgressDrawable(Drawable drawable) {
        Drawable drawableA;
        Drawable drawableA2;
        Drawable drawableA3;
        super.setProgressDrawable(drawable);
        if (getProgressDrawable() == null) {
            return;
        }
        if (this.a != null && (drawableA3 = a(android.R.id.progress, true)) != null) {
            a(drawableA3, this.a);
        }
        if (this.c != null && (drawableA2 = a(android.R.id.background, false)) != null) {
            a(drawableA2, this.c);
        }
        if (this.b == null || (drawableA = a(android.R.id.secondaryProgress, false)) == null) {
            return;
        }
        a(drawableA, this.b);
    }

    @Override // android.widget.ProgressBar
    public final synchronized void setSecondaryProgress(int i) {
        super.setSecondaryProgress(i);
        getRating();
    }

    public final void a(Drawable drawable, ColorStateList colorStateList) {
        if (colorStateList != null) {
            if ((drawable instanceof b3) || Build.VERSION.SDK_INT >= 21) {
                drawable.setTintList(colorStateList);
            }
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
    }
}
