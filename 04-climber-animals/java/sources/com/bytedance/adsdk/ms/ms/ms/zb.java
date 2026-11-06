package com.bytedance.adsdk.ms.ms.ms;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class zb extends x<com.bytedance.adsdk.ms.ms.xr.ms, com.bytedance.adsdk.ms.ms.xr.xr> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final /* synthetic */ boolean f322ms = true;

    public zb(com.bytedance.adsdk.ms.ms.xr.ms msVar) {
        super(msVar);
    }

    @Override // com.bytedance.adsdk.ms.ms.ms.x
    public Bitmap ms(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.bytedance.adsdk.ms.ms.xr.xr xrVar) {
        Bitmap bitmapDecodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            ((com.bytedance.adsdk.ms.ms.xr.ms) this.ab).d_();
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.bytedance.adsdk.ms.ms.xr.ms) this.ab).ka(), null, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.bytedance.adsdk.ms.ms.xr.ms) this.ab).ka(), null, options2);
            }
            try {
                if (!f322ms && bitmapDecodeStream == null) {
                    throw new AssertionError();
                }
                paint.setXfermode(null);
                canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
                return bitmapDecodeStream;
            } catch (IOException e) {
                e = e;
                bitmap2 = bitmapDecodeStream;
                com.bytedance.sdk.component.utils.sl.ms(e);
                return bitmap2;
            }
        } catch (IOException e2) {
            e = e2;
            com.bytedance.sdk.component.utils.sl.ms(e);
            return bitmap2;
        }
    }
}
