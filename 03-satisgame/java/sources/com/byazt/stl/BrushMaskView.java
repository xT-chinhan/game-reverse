package com.byazt.stl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1473})
public class BrushMaskView extends View {
    public static final String n = "BrushMaskView";
    public Paint fs;
    public Paint l;
    public Canvas q;
    public Paint qg;
    public Bitmap s;
    public BitmapDrawable w;
    public Paint x;

    public void setEraserSize(float f) {
        this.x.setStrokeWidth(f);
        this.fs.setStrokeWidth(f);
    }

    public void setMaskColor(int i) {
        this.qg.setColor(i);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(n(i), n(i2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.s;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.l);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        n(i, i2);
    }

    private void n(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.s = bitmapCreateBitmap;
            Canvas canvas = this.q;
            if (canvas == null) {
                this.q = new Canvas(this.s);
            } else {
                canvas.setBitmap(bitmapCreateBitmap);
            }
            this.q.drawRoundRect(new RectF(0.0f, 0.0f, i, i2), 120.0f, 120.0f, this.qg);
            if (this.w != null) {
                this.w.setBounds(new Rect(0, 0, i, i2));
                this.w.draw(this.q);
            }
        } catch (Exception e) {
            k.qg(n, e.getMessage());
        }
    }

    private int n(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(0, size);
        }
        return 0;
    }

    public void setWatermark(int i) {
        if (i == -1) {
            this.w = null;
        } else {
            this.w = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), i));
        }
    }
}
