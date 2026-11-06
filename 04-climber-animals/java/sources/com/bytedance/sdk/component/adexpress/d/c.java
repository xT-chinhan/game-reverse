package com.bytedance.sdk.component.adexpress.d;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.utils.sl;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final byte[] f751ms = ms("VP8X");

    private static byte[] ms(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }

    private static void ah(final ImageView imageView, byte[] bArr, int i, int i2) {
        if (ms(bArr)) {
            final com.bytedance.adsdk.ms.ms.ms msVarMs = com.bytedance.adsdk.ms.ms.ms.ms(ByteBuffer.wrap(bArr));
            com.bytedance.sdk.component.utils.x.xr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.d.c.1
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageDrawable(msVarMs);
                }
            });
        } else {
            d(imageView, bArr, i, i2);
        }
    }

    public static boolean ms(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return ms.ms(bArr);
    }

    private static void d(final ImageView imageView, byte[] bArr, int i, int i2) {
        final Bitmap bitmapMs = new com.bytedance.sdk.component.c.ah.xr.ms(i, i2, imageView.getScaleType(), Bitmap.Config.RGB_565, i, i2).ms(bArr);
        if (bitmapMs != null) {
            com.bytedance.sdk.component.utils.x.xr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.d.c.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(bitmapMs);
                }
            });
        }
    }

    public static void ms(final ImageView imageView, byte[] bArr, int i, int i2) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                final Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap));
                com.bytedance.sdk.component.utils.x.xr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.d.c.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable = drawableDecodeDrawable;
                        if (drawable instanceof AnimatedImageDrawable) {
                            ((AnimatedImageDrawable) drawable).start();
                        }
                        imageView.setImageDrawable(drawableDecodeDrawable);
                    }
                });
                return;
            } catch (IOException e) {
                sl.ms(e);
                return;
            }
        }
        d(imageView, bArr, i, i2);
    }

    public static void xr(ImageView imageView, byte[] bArr, int i, int i2) {
        try {
            if (imageView instanceof GifView) {
                ((GifView) imageView).ms(bArr, false);
                return;
            }
            if (TextUtils.equals("png", com.bytedance.sdk.component.utils.ny.ms(Arrays.copyOfRange(bArr, 0, com.bytedance.sdk.component.utils.ny.ms())))) {
                ah(imageView, bArr, i, i2);
            } else if (ms(bArr, 0)) {
                ms(imageView, bArr, i, i2);
            } else {
                d(imageView, bArr, i, i2);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static boolean ms(byte[] bArr, int i) {
        try {
            boolean zMs = ms(bArr, i + 12, f751ms);
            int i2 = i + 20;
            if (bArr.length <= i2) {
                return false;
            }
            return zMs && ((bArr[i2] & 2) == 2);
        } catch (Throwable th) {
            sl.ms(th);
            return false;
        }
    }

    private static boolean ms(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
