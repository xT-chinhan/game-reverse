package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class TTRoundRectImageView extends ImageView {
    private int ah;
    private Matrix d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Paint f984ms;
    private int xr;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xr = 25;
        this.ah = 25;
        Paint paint = new Paint();
        this.f984ms = paint;
        paint.setAntiAlias(true);
        this.f984ms.setFilterBitmap(true);
        this.d = new Matrix();
    }

    public void setXRound(int i) {
        this.xr = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.ah = i;
        postInvalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmapMs = ms(drawable);
            if (bitmapMs != null) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                BitmapShader bitmapShader = new BitmapShader(bitmapMs, tileMode, tileMode);
                float fMax = (bitmapMs.getWidth() == getWidth() && bitmapMs.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapMs.getWidth(), (getHeight() * 1.0f) / bitmapMs.getHeight());
                this.d.setScale(fMax, fMax);
                bitmapShader.setLocalMatrix(this.d);
                this.f984ms.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.xr, this.ah, this.f984ms);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    private Bitmap ms(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
