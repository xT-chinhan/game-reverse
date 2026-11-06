package com.byazt.ndr;

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
import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 1215})
public class TTRoundRectImageView extends ImageView {
    public Paint n;
    public Matrix q;
    public int qg;
    public int s;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qg = 25;
        this.s = 25;
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setFilterBitmap(true);
        this.q = new Matrix();
    }

    public TTRoundRectImageView(Context context, int i, int i2) {
        this(context);
        this.qg = i;
        this.s = i2;
    }

    public void setXRound(int i) {
        this.qg = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.s = i;
        postInvalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmapN = n(drawable);
            if (bitmapN != null) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                BitmapShader bitmapShader = new BitmapShader(bitmapN, tileMode, tileMode);
                float fMax = (bitmapN.getWidth() == getWidth() && bitmapN.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapN.getWidth(), (getHeight() * 1.0f) / bitmapN.getHeight());
                this.q.setScale(fMax, fMax);
                bitmapShader.setLocalMatrix(this.q);
                this.n.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.qg, this.s, this.n);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    private Bitmap n(Drawable drawable) {
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
