package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class WriggleGuideView extends View {
    private boolean ab;
    private Bitmap ah;
    private int c;
    private Bitmap d;
    private Paint ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f988ms;
    private ms ny;
    private boolean x;
    private int xr;

    public interface ms {
    }

    private Bitmap ms(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getContext().getResources(), t.ka(getContext(), "tt_wriggle_union"));
        if (bitmapDecodeResource != null) {
            canvas.drawBitmap(bitmapDecodeResource, (Rect) null, new RectF(0.0f, 0.0f, i, i2), this.ka);
        }
        return bitmapCreateBitmap;
    }

    private Bitmap xr(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getContext().getResources(), t.ka(getContext(), "tt_wriggle_union_white"));
        if (bitmapDecodeResource != null) {
            canvas.drawBitmap(bitmapDecodeResource, (Rect) null, new RectF(0.0f, 0.0f, i, i2), paint);
        }
        return bitmapCreateBitmap;
    }

    private Bitmap ah(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(i / 2, 10.0f, this.c, paint);
        return bitmapCreateBitmap;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ab) {
            this.f988ms = getWidth();
            int height = getHeight();
            this.xr = height;
            this.ah = ms(this.f988ms, height);
            this.d = xr(this.f988ms, this.xr);
            this.ab = false;
        }
        Bitmap bitmap = this.ah;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.ka);
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        Bitmap bitmap2 = this.d;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, this.ka);
        }
        this.ka.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(ah(this.f988ms, this.xr), 0.0f, 0.0f, this.ka);
        this.ka.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
        if (this.x) {
            this.c += 5;
            invalidate();
            if (this.c >= this.f988ms) {
                this.x = false;
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ny != null) {
            this.ny = null;
        }
    }
}
