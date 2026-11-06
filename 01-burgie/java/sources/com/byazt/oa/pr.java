package com.byazt.oa;

import com.byazt.du.k;
import com.byazt.du.vk;
import com.byazt.lp.c;
import com.byazt.xx.hn;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, 37})
public final class pr {
    public byte[] fw;
    public byte[] zo;
    public static final byte[] pr = {42};
    public static final String[] hw = new String[0];
    public static final String[] hn = {"*"};
    public static final pr x = new pr();
    public final AtomicBoolean c = new AtomicBoolean(false);
    public final CountDownLatch uc = new CountDownLatch(1);

    public static pr pr() {
        return x;
    }

    public String pr(String str) {
        int length;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrPr = pr(strArrSplit);
        if (strArrSplit.length == strArrPr.length && strArrPr[0].charAt(0) != '!') {
            return null;
        }
        if (strArrPr[0].charAt(0) == '!') {
            length = strArrSplit.length - strArrPr.length;
        } else {
            length = strArrSplit.length - (strArrPr.length + 1);
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        while (length < strArrSplit2.length) {
            sb.append(strArrSplit2[length]).append('.');
            length++;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] pr(String[] strArr) {
        String str;
        String strPr;
        String strPr2;
        if (!this.c.get() && this.c.compareAndSet(false, true)) {
            hw();
        } else {
            try {
                this.uc.await();
            } catch (InterruptedException e) {
            }
        }
        synchronized (this) {
            if (this.fw == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = strArr[i].getBytes(hn.c);
        }
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= length) {
                strPr = null;
                break;
            }
            strPr = pr(this.fw, bArr, i2);
            if (strPr != null) {
                break;
            }
            i2++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            int i3 = 0;
            while (true) {
                if (i3 < bArr2.length - 1) {
                    bArr2[i3] = pr;
                    strPr2 = pr(this.fw, bArr2, i3);
                    if (strPr2 != null) {
                        break;
                    }
                    i3++;
                } else {
                    strPr2 = null;
                    break;
                }
            }
        } else {
            strPr2 = null;
            break;
        }
        if (strPr2 != null) {
            for (int i4 = 0; i4 < length - 1; i4++) {
                String strPr3 = pr(this.zo, bArr, i4);
                if (strPr3 != null) {
                    str = strPr3;
                    break;
                }
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strPr == null && strPr2 == null) {
            return hn;
        }
        String[] strArrSplit = strPr != null ? strPr.split("\\.") : hw;
        String[] strArrSplit2 = strPr2 != null ? strPr2.split("\\.") : hw;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    private static String pr(byte[] bArr, byte[][] bArr2, int i) {
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
                if (bArr2[i10].length == i11) {
                    if (i10 == bArr2.length - 1) {
                        break;
                    }
                    i10++;
                    i11 = -1;
                    z2 = true;
                } else {
                    z2 = z;
                }
            }
            if (i4 < 0) {
                length = i7 - 1;
            } else if (i4 > 0) {
                i5 = i2 + 1;
            } else {
                int i13 = i9 - i12;
                int length2 = bArr2[i10].length - i11;
                while (true) {
                    i10++;
                    if (i10 >= bArr2.length) {
                        break;
                    }
                    length2 += bArr2[i10].length;
                }
                if (length2 < i13) {
                    length = i7 - 1;
                } else {
                    if (length2 <= i13) {
                        return new String(bArr, i7, i9, hn.c);
                    }
                    i5 = i2 + 1;
                }
            }
        }
        return null;
    }

    private void hw() {
        boolean z = false;
        while (true) {
            try {
                try {
                    hn();
                    break;
                } catch (InterruptedIOException e) {
                    z = true;
                } catch (IOException e2) {
                    c.hw().pr(5, "Failed to read public suffix list", e2);
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

    private void hn() throws IOException {
        InputStream resourceAsStream = pr.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        com.byazt.du.c cVarPr = k.pr(new vk(k.pr(resourceAsStream)));
        try {
            byte[] bArr = new byte[cVarPr.vk()];
            cVarPr.pr(bArr);
            byte[] bArr2 = new byte[cVarPr.vk()];
            cVarPr.pr(bArr2);
            hn.pr(cVarPr);
            synchronized (this) {
                this.fw = bArr;
                this.zo = bArr2;
            }
            this.uc.countDown();
        } catch (Throwable th) {
            hn.pr(cVarPr);
            throw th;
        }
    }
}
