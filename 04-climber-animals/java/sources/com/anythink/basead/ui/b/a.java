package com.anythink.basead.ui.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Drawable {
    Paint a = new Paint();

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.drawColor(-13750739);
        if (canvas.getHeight() <= 0 || canvas.getWidth() <= 0) {
            return;
        }
        float fMax = Math.max(canvas.getHeight(), canvas.getWidth()) / 2;
        this.a.setShader(new RadialGradient(canvas.getWidth() / 2, canvas.getHeight() / 2, fMax, -1, 0, Shader.TileMode.CLAMP));
        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, fMax, this.a);
    }
}
