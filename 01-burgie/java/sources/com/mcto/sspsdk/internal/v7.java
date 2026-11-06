package com.mcto.sspsdk.internal;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public final class v7 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ w7 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ a8 e;

    public v7(a8 a8Var, String str, w7 w7Var, int i, int i2) {
        this.e = a8Var;
        this.a = str;
        this.b = w7Var;
        this.c = i;
        this.d = i2;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c4 A[LOOP:0: B:22:0x0059->B:57:0x00c4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00dd A[Catch: Exception -> 0x00e5, TRY_LEAVE, TryCatch #3 {Exception -> 0x00e5, blocks: (B:65:0x00d7, B:67:0x00dd), top: B:79:0x00d7 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x00d4 A[EDGE_INSN: B:88:0x00d4->B:63:0x00d4 BREAK  A[LOOP:0: B:22:0x0059->B:57:0x00c4], SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmapA;
        Bitmap bitmapA2;
        HttpURLConnection httpURLConnectionA;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        e5 e5VarB;
        String strD = gj.d(this.a);
        Bitmap bitmapA3 = this.e.a.a(strD);
        if (bitmapA3 != null) {
            this.b.a(bitmapA3);
            return;
        }
        a8 a8Var = this.e;
        int i = this.c;
        int i2 = this.d;
        a8Var.getClass();
        Bitmap bitmap = null;
        try {
            f5 f5Var = a8Var.a.b;
            if (f5Var == null || (e5VarB = f5Var.b(strD)) == null || (bitmapA = a8.a(null, e5VarB.a[0], i, i2)) == null) {
                bitmapA = null;
            } else {
                a8Var.a(strD, bitmapA);
            }
        } catch (Throwable th) {
            r9.a("ssp_ImageLoad", strD, th);
        }
        if (bitmapA != null) {
            this.b.a(bitmapA);
            return;
        }
        w7 w7Var = this.b;
        a8 a8Var2 = this.e;
        String str = this.a;
        int i3 = this.c;
        int i4 = this.d;
        a8Var2.getClass();
        byte[] bArr = null;
        for (int i5 = 1; i5 <= 2; i5++) {
            try {
                httpURLConnectionA = e7.a(i5 * 5000, str, null);
                if (httpURLConnectionA != null) {
                    try {
                        if (200 <= httpURLConnectionA.getResponseCode() && httpURLConnectionA.getResponseCode() < 300) {
                            inputStream = httpURLConnectionA.getInputStream();
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                while (true) {
                                    try {
                                        int i6 = inputStream.read();
                                        if (i6 == -1) {
                                            break;
                                        } else {
                                            byteArrayOutputStream.write(i6);
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            r9.a("ssp_sdk", "download: ", th);
                                            if (httpURLConnectionA != null) {
                                                httpURLConnectionA.disconnect();
                                            }
                                            a8.a(byteArrayOutputStream);
                                            a8.a(inputStream);
                                            bArr = null;
                                        } catch (Throwable th3) {
                                            if (httpURLConnectionA != null) {
                                                httpURLConnectionA.disconnect();
                                            }
                                            a8.a(byteArrayOutputStream);
                                            a8.a(inputStream);
                                            throw th3;
                                        }
                                    }
                                }
                                byteArrayOutputStream.flush();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                httpURLConnectionA.disconnect();
                                a8.a(byteArrayOutputStream);
                                a8.a(inputStream);
                                bArr = byteArray;
                            } catch (Throwable th4) {
                                th = th4;
                                byteArrayOutputStream = null;
                                r9.a("ssp_sdk", "download: ", th);
                                if (httpURLConnectionA != null) {
                                    httpURLConnectionA.disconnect();
                                }
                                a8.a(byteArrayOutputStream);
                                a8.a(inputStream);
                                bArr = null;
                                if (bArr != null) {
                                    break;
                                    if (bArr != null) {
                                        try {
                                            bitmapA2 = a8.a(bArr, null, i3, i4);
                                            if (bitmapA2 != null) {
                                                a8Var2.a(strD, bitmapA2);
                                                a8Var2.a(strD, bArr);
                                            }
                                            bitmap = bitmapA2;
                                        } catch (Exception e) {
                                            r9.a("ssp_ImageLoad", str, e);
                                        }
                                    }
                                    w7Var.a(bitmap);
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                    }
                    if (bArr != null) {
                        break;
                    }
                }
                if (httpURLConnectionA != null) {
                    httpURLConnectionA.disconnect();
                }
            } catch (Throwable th6) {
                th = th6;
                httpURLConnectionA = null;
                inputStream = null;
                byteArrayOutputStream = null;
            }
            bArr = null;
            if (bArr != null) {
                break;
                break;
            }
        }
        if (bArr != null) {
            bitmapA2 = a8.a(bArr, null, i3, i4);
            if (bitmapA2 != null) {
                a8Var2.a(strD, bitmapA2);
                a8Var2.a(strD, bArr);
            }
            bitmap = bitmapA2;
        }
        w7Var.a(bitmap);
    }
}
