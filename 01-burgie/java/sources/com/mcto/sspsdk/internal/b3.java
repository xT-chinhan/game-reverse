package com.mcto.sspsdk.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b3 extends Drawable {
    public ColorFilter b;
    public ColorStateList c;
    public PorterDuffColorFilter e;
    public int a = 255;
    public PorterDuff.Mode d = PorterDuff.Mode.SRC_IN;
    public final a3 f = new a3(this);

    public final boolean a() {
        ColorStateList colorStateList = this.c;
        if (colorStateList != null && this.d != null) {
            this.e = new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), this.d);
            return true;
        }
        boolean z = this.e != null;
        this.e = null;
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.width() == 0 || bounds.height() == 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        vj vjVar = (vj) this;
        vjVar.g.setAlpha(vjVar.a);
        ColorFilter colorFilter = vjVar.b;
        if (colorFilter == null) {
            colorFilter = vjVar.e;
        }
        if (colorFilter != null) {
            vjVar.g.setColorFilter(colorFilter);
        }
        int intrinsicHeight = vjVar.g.getIntrinsicHeight();
        float f = iHeight / intrinsicHeight;
        canvas.scale(f, f);
        float f2 = iWidth / f;
        int i = vjVar.h;
        if (i < 0) {
            int intrinsicWidth = vjVar.g.getIntrinsicWidth();
            int i2 = 0;
            while (i2 < f2) {
                int i3 = i2 + intrinsicWidth;
                vjVar.g.setBounds(i2, 0, i3, intrinsicHeight);
                vjVar.g.draw(canvas);
                i2 = i3;
            }
        } else {
            float f3 = f2 / i;
            for (int i4 = 0; i4 < vjVar.h; i4++) {
                float f4 = (i4 + 0.5f) * f3;
                float intrinsicWidth2 = vjVar.g.getIntrinsicWidth() / 2.0f;
                vjVar.g.setBounds(Math.round(f4 - intrinsicWidth2), 0, Math.round(f4 + intrinsicWidth2), intrinsicHeight);
                vjVar.g.draw(canvas);
            }
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        return a();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.a != i) {
            this.a = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.b = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.c = colorStateList;
        if (a()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.d = mode;
        if (a()) {
            invalidateSelf();
        }
    }
}
