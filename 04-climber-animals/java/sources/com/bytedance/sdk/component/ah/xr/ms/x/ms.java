package com.bytedance.sdk.component.ah.xr.ms.x;

import com.bytedance.sdk.component.ah.ms.ch;
import com.bytedance.sdk.component.ah.ms.sl;
import com.bytedance.sdk.component.ah.xr.ms.ab.ka;
import com.bytedance.sdk.component.ah.xr.ms.ah;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public final class ms {
    private byte[] ab;
    private byte[] x;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final byte[] f1122ms = {42};
    private static final String[] xr = new String[0];
    private static final String[] ah = {"*"};
    private static final ms d = new ms();
    private final AtomicBoolean ka = new AtomicBoolean(false);
    private final CountDownLatch c = new CountDownLatch(1);

    public static ms ms() {
        return d;
    }

    public String ms(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrMs = ms(strArrSplit);
        if (strArrSplit.length == strArrMs.length && strArrMs[0].charAt(0) != '!') {
            return null;
        }
        if (strArrMs[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrMs.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrMs.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i = length - length2; i < strArrSplit2.length; i++) {
            sb.append(strArrSplit2[i]).append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] ms(String[] strArr) {
        String str;
        String strMs;
        String strMs2;
        if (!this.ka.get() && this.ka.compareAndSet(false, true)) {
            xr();
        } else {
            try {
                this.c.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.ab == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = strArr[i].getBytes(ah.ka);
        }
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= length) {
                strMs = null;
                break;
            }
            strMs = ms(this.ab, bArr, i2);
            if (strMs != null) {
                break;
            }
            i2++;
        }
        if (length <= 1) {
            strMs2 = null;
            break;
        }
        byte[][] bArr2 = (byte[][]) bArr.clone();
        int i3 = 0;
        while (true) {
            if (i3 >= bArr2.length - 1) {
                strMs2 = null;
                break;
            }
            bArr2[i3] = f1122ms;
            strMs2 = ms(this.ab, bArr2, i3);
            if (strMs2 != null) {
                break;
            }
            i3++;
        }
        if (strMs2 != null) {
            for (int i4 = 0; i4 < length - 1; i4++) {
                String strMs3 = ms(this.x, bArr, i4);
                if (strMs3 != null) {
                    str = strMs3;
                    break;
                }
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strMs == null && strMs2 == null) {
            return ah;
        }
        String[] strArrSplit = strMs != null ? strMs.split("\\.") : xr;
        String[] strArrSplit2 = strMs2 != null ? strMs2.split("\\.") : xr;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    private static String ms(byte[] bArr, byte[][] bArr2, int i) {
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
                            return new String(bArr, i7, i9, ah.ka);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    private void xr() {
        boolean z = false;
        while (true) {
            try {
                try {
                    ah();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e) {
                    ka.xr().ms(5, "Failed to read public suffix list", e);
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

    private void ah() throws IOException {
        InputStream resourceAsStream = ms.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        com.bytedance.sdk.component.ah.ms.ka kaVarMs = sl.ms(new ch(sl.ms(resourceAsStream)));
        try {
            byte[] bArr = new byte[kaVarMs.ch()];
            kaVarMs.ms(bArr);
            byte[] bArr2 = new byte[kaVarMs.ch()];
            kaVarMs.ms(bArr2);
            ah.ms(kaVarMs);
            synchronized (this) {
                this.ab = bArr;
                this.x = bArr2;
            }
            this.c.countDown();
        } catch (Throwable th) {
            ah.ms(kaVarMs);
            throw th;
        }
    }
}
