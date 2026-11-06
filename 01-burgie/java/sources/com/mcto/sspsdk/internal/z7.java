package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public final class z7 {
    public static volatile z7 d;
    public final u7 a;
    public final Object b = new Object();
    public final HashMap c;

    public z7(Context context) {
        new HashMap();
        new HashMap();
        this.c = new HashMap();
        this.a = u7.a(context);
    }

    /* JADX WARN: Code duplicated, block: B:69:0x00fc A[Catch: all -> 0x0014, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x0014, blocks: (B:8:0x0010, B:55:0x00cc, B:69:0x00fc), top: B:86:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:98:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.BufferedInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static y7 a(z7 z7Var, String str, String str2) {
        e5 e5VarB;
        InputStream inputStream;
        ?? bufferedInputStream;
        byte[] byteArray;
        f5 f5Var = z7Var.a.b;
        try {
            if (f5Var == null) {
                return null;
            }
            try {
                e5VarB = f5Var.b(str);
                if (e5VarB == null) {
                    if (e5VarB == null) {
                        return null;
                    }
                    e5VarB.close();
                    return null;
                }
                try {
                    inputStream = e5VarB.a[0];
                    try {
                        bufferedInputStream = inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
                        try {
                            byte[] bArr = new byte[512];
                            bufferedInputStream.mark(512);
                            int i = bufferedInputStream.read(bArr);
                            if (i <= 0) {
                                a(bufferedInputStream);
                                a(inputStream);
                            } else {
                                bufferedInputStream.reset();
                                boolean zB = b8.b(bArr, i);
                                boolean zA = b8.a(bArr, i);
                                a(bArr, i);
                                if (zB || zA) {
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.min(32768, 12582912));
                                    byte[] bArr2 = new byte[8192];
                                    int i2 = 0;
                                    while (true) {
                                        int i3 = bufferedInputStream.read(bArr2);
                                        if (i3 == -1) {
                                            byteArrayOutputStream.flush();
                                            byteArray = byteArrayOutputStream.toByteArray();
                                            break;
                                        }
                                        i2 += i3;
                                        if (i2 > 12582912) {
                                            byteArray = null;
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr2, 0, i3);
                                    }
                                    if (byteArray != null && byteArray.length != 0) {
                                        SystemClock.uptimeMillis();
                                        y7 y7Var = new y7(null, byteArray);
                                        a(bufferedInputStream);
                                        a(inputStream);
                                        try {
                                            e5VarB.close();
                                            return y7Var;
                                        } catch (Throwable th) {
                                            return y7Var;
                                        }
                                    }
                                    a(bufferedInputStream);
                                    a(inputStream);
                                } else {
                                    Bitmap bitmapA = a8.a(null, bufferedInputStream, 0, 0);
                                    if (bitmapA != null) {
                                        z7Var.a.a.put(str, bitmapA);
                                        SystemClock.uptimeMillis();
                                        bitmapA.getByteCount();
                                        y7 y7Var2 = new y7(bitmapA, null);
                                        a(bufferedInputStream);
                                        a(inputStream);
                                        try {
                                            e5VarB.close();
                                            return y7Var2;
                                        } catch (Throwable th2) {
                                            return y7Var2;
                                        }
                                    }
                                    a(bufferedInputStream);
                                    a(inputStream);
                                }
                            }
                            e5VarB.close();
                            return null;
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                r9.a("ssp_ImageView2", "loadFromDiskClassified failed: " + str2, th);
                                a(bufferedInputStream);
                                a(inputStream);
                                if (e5VarB != null) {
                                    return null;
                                }
                                e5VarB.close();
                                return null;
                            } catch (Throwable th4) {
                                a(bufferedInputStream);
                                a(inputStream);
                                if (e5VarB != null) {
                                    try {
                                        e5VarB.close();
                                    } catch (Throwable th5) {
                                    }
                                }
                                throw th4;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedInputStream = 0;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    inputStream = null;
                    bufferedInputStream = inputStream;
                    r9.a("ssp_ImageView2", "loadFromDiskClassified failed: " + str2, th);
                    a(bufferedInputStream);
                    a(inputStream);
                    if (e5VarB != null) {
                        return null;
                    }
                    e5VarB.close();
                    return null;
                }
            } catch (Throwable th8) {
                th = th8;
                e5VarB = null;
                inputStream = null;
            }
        } catch (Throwable th9) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00db  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00e4 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable, java.io.InputStream] */
    public static x7 b(z7 z7Var, String str, String str2) {
        HttpURLConnection httpURLConnectionA;
        c5 c5VarA;
        OutputStream outputStreamA;
        ?? inputStream;
        x7 x7Var;
        f5 f5Var = z7Var.a.b;
        if (f5Var == null) {
            return null;
        }
        loop0: for (int i = 1; i <= 2; i++) {
            SystemClock.uptimeMillis();
            try {
                httpURLConnectionA = e7.a(i * 5000, str, null);
                if (httpURLConnectionA != null) {
                    try {
                        if (httpURLConnectionA.getResponseCode() >= 200 && httpURLConnectionA.getResponseCode() < 300) {
                            c5VarA = f5Var.a(str2);
                            if (c5VarA != null) {
                                try {
                                    outputStreamA = c5VarA.a();
                                    try {
                                        inputStream = httpURLConnectionA.getInputStream();
                                        try {
                                            byte[] bArr = new byte[8192];
                                            int i2 = 0;
                                            while (true) {
                                                int i3 = inputStream.read(bArr);
                                                if (i3 == -1) {
                                                    outputStreamA.flush();
                                                    if (c5VarA.c) {
                                                        f5.a(c5VarA.d, c5VarA, false);
                                                        c5VarA.d.d(c5VarA.a.a);
                                                    } else {
                                                        f5.a(c5VarA.d, c5VarA, true);
                                                    }
                                                    synchronized (f5Var) {
                                                        f5Var.a();
                                                        f5Var.e();
                                                        f5Var.i.flush();
                                                    }
                                                    SystemClock.uptimeMillis();
                                                    SystemClock.uptimeMillis();
                                                    x7Var = new x7(true);
                                                    break loop0;
                                                }
                                                i2 += i3;
                                                if (i2 > 12582912) {
                                                    f5.a(c5VarA.d, c5VarA, false);
                                                    SystemClock.uptimeMillis();
                                                    SystemClock.uptimeMillis();
                                                    x7Var = new x7(false);
                                                    break loop0;
                                                }
                                                outputStreamA.write(bArr, 0, i3);
                                            }
                                            httpURLConnectionA.disconnect();
                                            a(outputStreamA);
                                            a(inputStream);
                                            return x7Var;
                                        } catch (Throwable th) {
                                            th = th;
                                            if (c5VarA != null) {
                                                try {
                                                    f5.a(c5VarA.d, c5VarA, false);
                                                } catch (Throwable th2) {
                                                }
                                            }
                                            try {
                                                r9.a("ssp_ImageView2", "downloadToDisk failed: " + str, th);
                                                if (httpURLConnectionA != null) {
                                                    httpURLConnectionA.disconnect();
                                                }
                                                a(outputStreamA);
                                                a(inputStream);
                                            } catch (Throwable th3) {
                                                if (httpURLConnectionA != null) {
                                                    httpURLConnectionA.disconnect();
                                                }
                                                a(outputStreamA);
                                                a(inputStream);
                                                throw th3;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        inputStream = 0;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    outputStreamA = null;
                                    inputStream = outputStreamA;
                                    if (c5VarA != null) {
                                        f5.a(c5VarA.d, c5VarA, false);
                                    }
                                    r9.a("ssp_ImageView2", "downloadToDisk failed: " + str, th);
                                    if (httpURLConnectionA != null) {
                                        httpURLConnectionA.disconnect();
                                    }
                                    a(outputStreamA);
                                    a(inputStream);
                                }
                            }
                        } else if (httpURLConnectionA != null) {
                        }
                        httpURLConnectionA.disconnect();
                    } catch (Throwable th6) {
                        th = th6;
                        c5VarA = null;
                        outputStreamA = c5VarA;
                        inputStream = outputStreamA;
                        if (c5VarA != null) {
                            f5.a(c5VarA.d, c5VarA, false);
                        }
                        r9.a("ssp_ImageView2", "downloadToDisk failed: " + str, th);
                        if (httpURLConnectionA != null) {
                            httpURLConnectionA.disconnect();
                        }
                        a(outputStreamA);
                        a(inputStream);
                    }
                } else if (httpURLConnectionA != null) {
                    httpURLConnectionA.disconnect();
                }
            } catch (Throwable th7) {
                th = th7;
                httpURLConnectionA = null;
                c5VarA = null;
            }
        }
        return new x7(false);
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th) {
        }
    }

    public static void a(byte[] bArr, int i) {
        if (i > 0 && !b8.b(bArr, i)) {
            if (i >= 12 && bArr[0] == 82 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 70 && bArr[8] == 87 && bArr[9] == 69 && bArr[10] == 66 && bArr[11] == 80) {
                return;
            }
            if (!(i >= 8 && (bArr[0] & UByte.MAX_VALUE) == 137 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71) && i >= 2 && (bArr[0] & UByte.MAX_VALUE) == 255) {
                byte b = bArr[1];
            }
        }
    }
}
