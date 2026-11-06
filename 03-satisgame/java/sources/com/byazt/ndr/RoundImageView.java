package com.byazt.ndr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.widget.ImageView;
import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 1851})
public class RoundImageView extends ImageView {
    public int n;
    public int qg;
    public int s;

    public RoundImageView(Context context) {
        super(context);
        this.n = 0;
        this.qg = 0;
        this.s = 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmapCopy;
        Bitmap bitmapN;
        Drawable drawable = getDrawable();
        if (drawable == null || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        measure(0, 0);
        if (drawable.getClass() == NinePatchDrawable.class || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
            return;
        }
        try {
            bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        } catch (Throwable unused) {
            bitmapCopy = null;
        }
        if (bitmapCopy == null) {
            super.onDraw(canvas);
            return;
        }
        if (this.n == 0) {
            this.n = getWidth();
        }
        if (this.qg == 0) {
            this.qg = getHeight();
        }
        int i = this.n;
        int i2 = this.qg;
        if (i >= i2) {
            i = i2;
        }
        int i3 = i / 2;
        try {
            bitmapN = n(bitmapCopy, i3);
        } catch (Throwable unused2) {
            bitmapN = null;
        }
        if (bitmapN == null) {
            super.onDraw(canvas);
        } else {
            canvas.drawBitmap(bitmapN, (this.n / 2) - i3, (this.qg / 2) - i3, (Paint) null);
        }
    }

    private Bitmap n(Bitmap bitmap, int i) {
        Bitmap bitmapCreateBitmap;
        int i2 = i * 2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height > width) {
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
        } else {
            bitmapCreateBitmap = height < width ? Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height) : null;
        }
        if (bitmapCreateBitmap != null) {
            bitmap = bitmapCreateBitmap;
        }
        if (bitmap.getWidth() != i2 || bitmap.getHeight() != i2) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i2, i2, true);
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap2;
    }
}
