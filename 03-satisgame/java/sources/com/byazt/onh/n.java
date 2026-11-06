package com.byazt.onh;

import com.byazt.quz.l;
import com.byazt.wa.d;
import com.byazt.wa.tj;
import com.byazt.zho.s;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 779, 19})
public final class n {
    public byte[] fs;
    public final AtomicBoolean l = new AtomicBoolean(false);
    public final CountDownLatch w = new CountDownLatch(1);
    public byte[] x;
    public static final byte[] n = {42};
    public static final String[] qg = new String[0];
    public static final String[] s = {"*"};
    public static final n q = new n();

    public static n n() {
        return q;
    }

    public String n(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrN = n(strArrSplit);
        if (strArrSplit.length == strArrN.length && strArrN[0].charAt(0) != '!') {
            return null;
        }
        if (strArrN[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrN.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrN.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i = length - length2; i < strArrSplit2.length; i++) {
            sb.append(strArrSplit2[i]).append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] n(String[] strArr) {
        String str;
        String strN;
        String strN2;
        if (!this.l.get() && this.l.compareAndSet(false, true)) {
            qg();
        } else {
            try {
                this.w.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.x == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = strArr[i].getBytes(s.l);
        }
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= length) {
                strN = null;
                break;
            }
            strN = n(this.x, bArr, i2);
            if (strN != null) {
                break;
            }
            i2++;
        }
        if (length <= 1) {
            strN2 = null;
            break;
        }
        byte[][] bArr2 = (byte[][]) bArr.clone();
        int i3 = 0;
        while (true) {
            if (i3 >= bArr2.length - 1) {
                strN2 = null;
                break;
            }
            bArr2[i3] = n;
            strN2 = n(this.x, bArr2, i3);
            if (strN2 != null) {
                break;
            }
            i3++;
        }
        if (strN2 != null) {
            for (int i4 = 0; i4 < length - 1; i4++) {
                String strN3 = n(this.fs, bArr, i4);
                if (strN3 != null) {
                    str = strN3;
                    break;
                }
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strN == null && strN2 == null) {
            return s;
        }
        String[] strArrSplit = strN != null ? strN.split("\\.") : qg;
        String[] strArrSplit2 = strN2 != null ? strN2.split("\\.") : qg;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    private static String n(byte[] bArr, byte[][] bArr2, int i) {
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
                            return new String(bArr, i7, i9, s.l);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    private void qg() {
        boolean z = false;
        while (true) {
            try {
                try {
                    s();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e) {
                    l.qg().n(5, "Failed to read public suffix list", e);
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

    private void s() throws IOException {
        InputStream resourceAsStream = n.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        com.byazt.wa.l lVarN = d.n(new tj(d.n(resourceAsStream)));
        try {
            byte[] bArr = new byte[lVarN.tj()];
            lVarN.n(bArr);
            byte[] bArr2 = new byte[lVarN.tj()];
            lVarN.n(bArr2);
            s.n(lVarN);
            synchronized (this) {
                this.x = bArr;
                this.fs = bArr2;
            }
            this.w.countDown();
        } catch (Throwable th) {
            s.n(lVarN);
            throw th;
        }
    }
}
