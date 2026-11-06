package com.byazt.iy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1124, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends fs<com.byazt.gq.n, com.byazt.gq.qg> {
    public static final /* synthetic */ boolean n = true;

    public oa(com.byazt.gq.n nVar) {
        super(nVar);
    }

    @Override // com.byazt.iy.fs
    public Bitmap n(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.byazt.gq.qg qgVar) {
        Bitmap bitmapDecodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            ((com.byazt.gq.n) this.x).d_();
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.byazt.gq.n) this.x).l(), null, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.byazt.gq.n) this.x).l(), null, options2);
            }
            try {
                if (!n && bitmapDecodeStream == null) {
                    throw new AssertionError();
                }
                paint.setXfermode(null);
                canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
                return bitmapDecodeStream;
            } catch (IOException unused2) {
                bitmap2 = bitmapDecodeStream;
                return bitmap2;
            }
        } catch (IOException unused3) {
            return bitmap2;
        }
    }
}
