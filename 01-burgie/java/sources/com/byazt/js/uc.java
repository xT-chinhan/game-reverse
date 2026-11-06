package com.byazt.js;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.ca.w;
import com.byazt.jt.GifView;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 756, 5})
public class uc {
    public static final byte[] pr = pr("VP8X");

    private static byte[] pr(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            return new byte[1];
        }
    }

    private static void hn(final ImageView imageView, byte[] bArr, int i, int i2) {
        if (pr(bArr)) {
            final com.byazt.go.pr prVarPr = com.byazt.go.pr.pr(ByteBuffer.wrap(bArr));
            com.byazt.ca.aj.hw().post(new Runnable() { // from class: com.byazt.js.uc.1
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageDrawable(prVarPr);
                }
            });
        } else {
            x(imageView, bArr, i, i2);
        }
    }

    public static boolean pr(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return pr.pr(bArr);
    }

    private static void x(final ImageView imageView, byte[] bArr, int i, int i2) {
        final Bitmap bitmapPr = new com.byazt.qnt.pr(i, i2, imageView.getScaleType(), Bitmap.Config.RGB_565, i, i2).pr(bArr);
        if (bitmapPr != null) {
            com.byazt.ca.aj.hw().post(new Runnable() { // from class: com.byazt.js.uc.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(bitmapPr);
                }
            });
        }
    }

    public static void pr(final ImageView imageView, byte[] bArr, int i, int i2) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                final Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap));
                com.byazt.ca.aj.hw().post(new Runnable() { // from class: com.byazt.js.uc.3
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
                return;
            }
        }
        x(imageView, bArr, i, i2);
    }

    public static void hw(ImageView imageView, byte[] bArr, int i, int i2) {
        try {
            if (imageView instanceof GifView) {
                ((GifView) imageView).pr(bArr, false);
                return;
            }
            if (TextUtils.equals("png", w.pr(Arrays.copyOfRange(bArr, 0, w.pr())))) {
                hn(imageView, bArr, i, i2);
            } else if (pr(bArr, 0)) {
                pr(imageView, bArr, i, i2);
            } else {
                x(imageView, bArr, i, i2);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static boolean pr(byte[] bArr, int i) {
        try {
            boolean zPr = pr(bArr, i + 12, pr);
            int i2 = i + 20;
            if (bArr.length <= i2) {
                return false;
            }
            return zPr && ((bArr[i2] & 2) == 2);
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean pr(byte[] bArr, int i, byte[] bArr2) {
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
