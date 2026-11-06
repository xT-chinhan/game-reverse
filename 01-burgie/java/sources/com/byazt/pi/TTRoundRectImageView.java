package com.byazt.pi;

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
import com.byazt.vzx.pr;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 118, TTAdConstant.VALUE_CLICK_AREA_SAAS_NORMAL})
public class TTRoundRectImageView extends ImageView {
    public int hn;
    public int hw;
    public Paint pr;
    public Matrix x;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hw = 25;
        this.hn = 25;
        Paint paint = new Paint();
        this.pr = paint;
        paint.setAntiAlias(true);
        this.pr.setFilterBitmap(true);
        this.x = new Matrix();
    }

    public TTRoundRectImageView(Context context, int i, int i2) {
        this(context);
        this.hw = i;
        this.hn = i2;
    }

    public void setXRound(int i) {
        this.hw = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.hn = i;
        postInvalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmapPr = pr(drawable);
            if (bitmapPr != null) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                BitmapShader bitmapShader = new BitmapShader(bitmapPr, tileMode, tileMode);
                float fMax = (bitmapPr.getWidth() == getWidth() && bitmapPr.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapPr.getWidth(), (getHeight() * 1.0f) / bitmapPr.getHeight());
                this.x.setScale(fMax, fMax);
                bitmapShader.setLocalMatrix(this.x);
                this.pr.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.hw, this.hn, this.pr);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    private Bitmap pr(Drawable drawable) {
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
