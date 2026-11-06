package com.byazt.tiu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, 108})
public class m extends zo<com.byazt.fe.pr, com.byazt.fe.hw> {
    public static final /* synthetic */ boolean pr = true;

    public m(com.byazt.fe.pr prVar) {
        super(prVar);
    }

    @Override // com.byazt.tiu.zo
    public Bitmap pr(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.byazt.fe.hw hwVar) {
        Bitmap bitmapDecodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            ((com.byazt.fe.pr) this.fw).d_();
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.byazt.fe.pr) this.fw).c(), null, options);
            } catch (IllegalArgumentException e) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.byazt.fe.pr) this.fw).c(), null, options2);
            }
            try {
                if (!pr && bitmapDecodeStream == null) {
                    throw new AssertionError();
                }
                paint.setXfermode(null);
                canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
                return bitmapDecodeStream;
            } catch (IOException e2) {
                bitmap2 = bitmapDecodeStream;
                return bitmap2;
            }
        } catch (IOException e3) {
            return bitmap2;
        }
    }
}
