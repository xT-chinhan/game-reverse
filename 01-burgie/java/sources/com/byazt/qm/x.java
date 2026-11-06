package com.byazt.qm;

import com.bumptech.glide.load.Key;
import com.umeng.analytics.pro.cc;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2253, 121})
public class x implements Serializable, Comparable<x> {
    public transient int c;
    public transient String uc;
    public final byte[] x;
    public static final char[] pr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset hw = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final x hn = pr(new byte[0]);

    public x(byte[] bArr) {
        this.x = bArr;
    }

    public static x pr(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new x((byte[]) bArr.clone());
    }

    public String pr() {
        String str = this.uc;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.x, hw);
        this.uc = str2;
        return str2;
    }

    public static x pr(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        x xVar = new x(str.getBytes(vk.pr));
        xVar.uc = str;
        return xVar;
    }

    public String hw() {
        byte[] bArr = this.x;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = pr;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & cc.m];
        }
        return new String(cArr);
    }

    public x pr(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.x;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.x.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new x(bArr2);
    }

    public byte pr(int i) {
        return this.x[i];
    }

    public int hn() {
        return this.x.length;
    }

    public byte[] x() {
        return (byte[]) this.x.clone();
    }

    public boolean pr(int i, x xVar, int i2, int i3) {
        return xVar.pr(i2, this.x, i, i3);
    }

    public boolean pr(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.x;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && vk.pr(bArr2, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x) {
            x xVar = (x) obj;
            int iHn = xVar.hn();
            byte[] bArr = this.x;
            if (iHn == bArr.length && xVar.pr(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.x);
        this.c = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public int compareTo(x xVar) {
        int iHn = hn();
        int iHn2 = xVar.hn();
        int iMin = Math.min(iHn, iHn2);
        for (int i = 0; i < iMin; i++) {
            int iPr = pr(i) & UByte.MAX_VALUE;
            int iPr2 = xVar.pr(i) & UByte.MAX_VALUE;
            if (iPr != iPr2) {
                return iPr < iPr2 ? -1 : 1;
            }
        }
        if (iHn == iHn2) {
            return 0;
        }
        return iHn < iHn2 ? -1 : 1;
    }

    public String toString() {
        if (this.x.length == 0) {
            return "[size=0]";
        }
        String strPr = pr();
        int iPr = pr(strPr, 64);
        if (iPr == -1) {
            if (this.x.length <= 64) {
                return "[hex=" + hw() + "]";
            }
            return "[size=" + this.x.length + " hex=" + pr(0, 64).hw() + "…]";
        }
        String strReplace = strPr.substring(0, iPr).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return (iPr < strPr.length() ? new StringBuilder("[size=").append(this.x.length).append(" text=").append(strReplace).append("…]") : new StringBuilder("[text=").append(strReplace).append("]")).toString();
    }

    public static int pr(String str, int i) {
        int length = str.length();
        int iCharCount = 0;
        int i2 = 0;
        while (iCharCount < length) {
            if (i2 == i) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i2++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }
}
