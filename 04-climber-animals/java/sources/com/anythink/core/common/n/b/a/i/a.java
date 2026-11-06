package com.anythink.core.common.n.b.a.i;

import com.anythink.core.common.n.b.a.g.c;
import com.anythink.core.common.n.c.e;
import com.anythink.core.common.n.c.l;
import com.anythink.core.common.n.c.n;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final String a = "publicsuffixes.gz";
    private static final byte e = 33;
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final CountDownLatch h = new CountDownLatch(1);
    private byte[] i;
    private byte[] j;
    private static final byte[] b = {42};
    private static final String[] c = new String[0];
    private static final String[] d = {"*"};
    private static final a f = new a();

    public static a a() {
        return f;
    }

    public final String a(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrA = a(strArrSplit);
        if (strArrSplit.length == strArrA.length && strArrA[0].charAt(0) != '!') {
            return null;
        }
        if (strArrA[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrA.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrA.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i = length - length2; i < strArrSplit2.length; i++) {
            sb.append(strArrSplit2[i]).append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] a(String[] strArr) {
        String str;
        String strA;
        String strA2;
        String[] strArrSplit;
        String[] strArrSplit2;
        if (this.g.get() || !this.g.compareAndSet(false, true)) {
            try {
                this.h.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z = false;
            while (true) {
                try {
                    try {
                        try {
                            c();
                            break;
                        } catch (Throwable th) {
                            if (z) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        c.e().a(5, "Failed to read public suffix list", e2);
                        if (z) {
                        }
                    }
                } catch (InterruptedIOException unused2) {
                    Thread.interrupted();
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
        synchronized (this) {
            if (this.i == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = strArr[i].getBytes(StandardCharsets.UTF_8);
        }
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= length) {
                strA = null;
                break;
            }
            strA = a(this.i, bArr, i2);
            if (strA != null) {
                break;
            }
            i2++;
        }
        if (length <= 1) {
            strA2 = null;
            break;
        }
        byte[][] bArr2 = (byte[][]) bArr.clone();
        int i3 = 0;
        while (true) {
            if (i3 >= bArr2.length - 1) {
                strA2 = null;
                break;
            }
            bArr2[i3] = b;
            strA2 = a(this.i, bArr2, i3);
            if (strA2 != null) {
                break;
            }
            i3++;
        }
        if (strA2 != null) {
            for (int i4 = 0; i4 < length - 1; i4++) {
                String strA3 = a(this.j, bArr, i4);
                if (strA3 != null) {
                    str = strA3;
                    break;
                }
            }
        }
        if (str != null) {
            return "!".concat(String.valueOf(str)).split("\\.");
        }
        if (strA == null && strA2 == null) {
            return d;
        }
        if (strA != null) {
            strArrSplit = strA.split("\\.");
        } else {
            strArrSplit = c;
        }
        if (strA2 != null) {
            strArrSplit2 = strA2.split("\\.");
        } else {
            strArrSplit2 = c;
        }
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 >= 0 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & UByte.MAX_VALUE;
                }
                i4 = i3 - (bArr[i7 + i12] & UByte.MAX_VALUE);
                if (i4 != 0) {
                    break;
                }
                i12++;
                i11++;
                if (i12 == i9) {
                    break;
                }
                if (bArr2[i10].length != i11) {
                    z2 = z;
                } else {
                    if (i10 == bArr2.length - 1) {
                        break;
                    }
                    i10++;
                    i11 = -1;
                    z2 = true;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, StandardCharsets.UTF_8);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    private void b() {
        boolean z = false;
        while (true) {
            try {
                try {
                    c();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e2) {
                    c.e().a(5, "Failed to read public suffix list", e2);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void c() {
        InputStream resourceAsStream = a.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        e eVarA = n.a(new l(n.a(resourceAsStream)));
        try {
            byte[] bArr = new byte[eVarA.m()];
            eVarA.b(bArr);
            byte[] bArr2 = new byte[eVarA.m()];
            eVarA.b(bArr2);
            eVarA.close();
            synchronized (this) {
                this.i = bArr;
                this.j = bArr2;
            }
            this.h.countDown();
        } catch (Throwable th) {
            try {
                eVarA.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void a(byte[] bArr, byte[] bArr2) {
        this.i = bArr;
        this.j = bArr2;
        this.g.set(true);
        this.h.countDown();
    }
}
