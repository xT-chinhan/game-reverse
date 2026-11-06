package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class a8 {
    public static volatile a8 b;
    public final u7 a;

    public a8(Context context) {
        this.a = u7.a(context);
    }

    public static a8 a(Context context) {
        if (b == null) {
            synchronized (a8.class) {
                if (b == null) {
                    b = new a8(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    public final void a(String str, Bitmap bitmap) {
        this.a.a.put(str, bitmap);
        bitmap.getByteCount();
    }

    public final void a(String str, byte[] bArr) {
        if (bArr.length == 0) {
            return;
        }
        OutputStream outputStreamA = null;
        try {
            f5 f5Var = this.a.b;
            if (f5Var == null) {
                return;
            }
            c5 c5VarA = f5Var.a(str);
            if (c5VarA != null) {
                outputStreamA = c5VarA.a();
                outputStreamA.write(bArr);
                outputStreamA.flush();
                if (c5VarA.c) {
                    f5.a(c5VarA.d, c5VarA, false);
                    c5VarA.d.d(c5VarA.a.a);
                } else {
                    f5.a(c5VarA.d, c5VarA, true);
                }
            }
            synchronized (f5Var) {
                try {
                    f5Var.a();
                    f5Var.e();
                    f5Var.i.flush();
                } catch (Throwable th) {
                    throw th;
                }
            }
            a(outputStreamA);
        } catch (Throwable th2) {
            try {
                r9.a("ssp_ImageLoad", "addBitmapToDiskCache: ", th2);
            } finally {
                a(outputStreamA);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                r9.a("ssp_ImageLoad", "closeQuietly: ", e2);
            }
        }
    }

    public static Bitmap a(byte[] bArr, InputStream inputStream, int i, int i2) {
        if ((bArr == null || bArr.length == 0) && inputStream == null) {
            return null;
        }
        if (inputStream != null) {
            try {
                if (!inputStream.markSupported()) {
                    inputStream = new BufferedInputStream(inputStream);
                }
            } catch (Exception e) {
                r9.a("BitmapDecoder", "decodeSafely error", e);
                return null;
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i3 = 1;
        options.inJustDecodeBounds = true;
        if (bArr != null) {
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            inputStream.mark(Integer.MAX_VALUE);
            BitmapFactory.decodeStream(inputStream, null, options);
            inputStream.reset();
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (i > 0 && i2 > 0) {
            int i6 = i5 / 2;
            int i7 = i4 / 2;
            while (i6 / i3 >= i2 && i7 / i3 >= i) {
                i3 *= 2;
            }
        } else {
            float f = i4;
            float f2 = 1080;
            float f3 = i5;
            float fMax = Math.max(f / f2, f3 / f2);
            if (fMax > 1.0f) {
                i4 = (int) (f / fMax);
                i5 = (int) (f3 / fMax);
            }
            while (true) {
                if (i5 / i3 <= 1080 && i4 / i3 <= 1080) {
                    break;
                }
                i3 *= 2;
            }
        }
        options.inSampleSize = i3;
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = "image/jpeg".equals(options.outMimeType) ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
        int i8 = 4;
        Bitmap bitmapDecodeStream = null;
        while (true) {
            i8--;
            if (i8 <= 0) {
                break;
            }
            if (bArr != null) {
                try {
                    bitmapDecodeStream = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                } catch (OutOfMemoryError e2) {
                    options.inSampleSize *= 2;
                }
            } else {
                inputStream.reset();
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            }
            if (bitmapDecodeStream != null) {
                break;
            }
        }
        if (bitmapDecodeStream == null) {
            r9.a("BitmapDecoder", "decodeSafely failed, final inSampleSize: " + options.inSampleSize, null);
        }
        return bitmapDecodeStream;
    }
}
