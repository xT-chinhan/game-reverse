package com.byazt.fj;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 102, 2277})
public class TTProgressBar extends ProgressBar {
    public static RotateDrawable pr(Context context, Drawable drawable, int i, int i2, float f, float f2) {
        RotateDrawable rotateDrawable = new RotateDrawable();
        rotateDrawable.setDrawable(drawable);
        rotateDrawable.setFromDegrees(i);
        rotateDrawable.setToDegrees(i2);
        rotateDrawable.setPivotX(f);
        rotateDrawable.setPivotY(f2);
        rotateDrawable.setLevel(0);
        return rotateDrawable;
    }

    public TTProgressBar(Context context) {
        super(context);
    }

    public TTProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ProgressBar
    public void setInterpolator(Context context, int i) {
        setInterpolator(new LinearInterpolator());
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        try {
            super.onRestoreInstanceState(parcelable);
        } catch (Exception e) {
            try {
                Field field = getClass().getField("mPrivateFlags");
                field.setAccessible(true);
                field.set(this, Integer.valueOf(((Integer) field.get(this)).intValue() | 131072));
            } catch (Throwable th) {
            }
        }
    }
}
