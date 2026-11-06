package com.mcto.sspsdk.component.imageview2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.Movie;
import android.os.Build;
import com.mcto.sspsdk.internal.a8;
import com.mcto.sspsdk.internal.b8;
import com.mcto.sspsdk.internal.r9;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ File b;
    public final /* synthetic */ String c;
    public final /* synthetic */ QYImageView2 d;

    public c(QYImageView2 qYImageView2, String str, File file, String str2) {
        this.d = qYImageView2;
        this.a = str;
        this.b = file;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.equals(this.d.m)) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.b));
                try {
                    byte[] bArr = new byte[512];
                    bufferedInputStream.mark(512);
                    int i = bufferedInputStream.read(bArr);
                    if (i > 0) {
                        bufferedInputStream.reset();
                        boolean zB = b8.b(bArr, i);
                        boolean zA = b8.a(bArr, i);
                        if (Build.VERSION.SDK_INT >= 28 && (zB || zA)) {
                            try {
                                this.d.a.post(new b(this, ImageDecoder.decodeDrawable(ImageDecoder.createSource(this.b))));
                            } catch (Throwable th) {
                                r9.a("ssp_ImageView2", "ImageDecoder decodeDrawable(file) failed: " + this.c, th);
                                QYImageView2.b(this.d, 0);
                            }
                            bufferedInputStream.close();
                            return;
                        }
                        if (zB) {
                            Movie movieDecodeFile = Movie.decodeFile(this.c);
                            if (movieDecodeFile == null) {
                                QYImageView2.b(this.d, 0);
                            } else {
                                QYImageView2.a(movieDecodeFile, this.d, this.a);
                            }
                        } else {
                            this.d.getClass();
                            this.d.getClass();
                            Bitmap bitmapA = a8.a(null, bufferedInputStream, 0, 0);
                            if (bitmapA == null) {
                                QYImageView2.b(this.d, 0);
                            } else {
                                this.d.a(bitmapA);
                            }
                        }
                        r9.a("ssp_ImageView2", "setImageFile failed: " + this.c, th);
                        QYImageView2.b(this.d, 0);
                    }
                    QYImageView2.b(this.d, 0);
                    bufferedInputStream.close();
                } catch (Throwable th2) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                r9.a("ssp_ImageView2", "setImageFile failed: " + this.c, th4);
                QYImageView2.b(this.d, 0);
            }
        }
    }
}
