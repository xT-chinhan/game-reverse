package com.byazt.cq;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.stl.GifView;
import com.byazt.tk.cp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 883, 13})
public class w {
    public static final byte[] n = n("VP8X");

    private static byte[] n(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }

    private static void s(final ImageView imageView, byte[] bArr, int i, int i2) {
        if (n(bArr)) {
            final com.byazt.kd.n nVarN = com.byazt.kd.n.n(ByteBuffer.wrap(bArr));
            com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.cq.w.1
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageDrawable(nVarN);
                }
            });
        } else {
            q(imageView, bArr, i, i2);
        }
    }

    public static boolean n(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return n.n(bArr);
    }

    private static void q(final ImageView imageView, byte[] bArr, int i, int i2) {
        final Bitmap bitmapN = new com.byazt.gms.n(i, i2, imageView.getScaleType(), Bitmap.Config.RGB_565, i, i2).n(bArr);
        if (bitmapN != null) {
            com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.cq.w.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(bitmapN);
                }
            });
        }
    }

    public static void n(final ImageView imageView, byte[] bArr, int i, int i2) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                final Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap));
                com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.cq.w.3
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
            } catch (IOException unused) {
                return;
            }
        }
        q(imageView, bArr, i, i2);
    }

    public static void qg(ImageView imageView, byte[] bArr, int i, int i2) {
        try {
            if (imageView instanceof GifView) {
                ((GifView) imageView).n(bArr, false);
                return;
            }
            if (TextUtils.equals("png", cp.n(Arrays.copyOfRange(bArr, 0, cp.n())))) {
                s(imageView, bArr, i, i2);
            } else if (n(bArr, 0)) {
                n(imageView, bArr, i, i2);
            } else {
                q(imageView, bArr, i, i2);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static boolean n(byte[] bArr, int i) {
        try {
            boolean zN = n(bArr, i + 12, n);
            int i2 = i + 20;
            if (bArr.length <= i2) {
                return false;
            }
            boolean z = (bArr[i2] & 2) == 2;
            if (zN && z) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean n(byte[] bArr, int i, byte[] bArr2) {
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
