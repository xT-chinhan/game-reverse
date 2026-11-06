package com.bytedance.sdk.component.xr.ms.xr;

import com.umeng.analytics.pro.ek;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Serializable, Comparable<d> {
    transient String c;
    final byte[] d;
    transient int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final char[] f1628ms = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset xr = Charset.forName("UTF-8");
    public static final d ah = ms(new byte[0]);

    d(byte[] bArr) {
        this.d = bArr;
    }

    public static d ms(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new d((byte[]) bArr.clone());
    }

    public String ms() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.d, xr);
        this.c = str2;
        return str2;
    }

    public static d ms(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        d dVar = new d(str.getBytes(ch.f1627ms));
        dVar.c = str;
        return dVar;
    }

    public String xr() {
        byte[] bArr = this.d;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f1628ms;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & ek.m];
        }
        return new String(cArr);
    }

    public d ms(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.d;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.d.length + ")");
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
        return new d(bArr2);
    }

    public byte ms(int i) {
        return this.d[i];
    }

    public int ah() {
        return this.d.length;
    }

    public byte[] d() {
        return (byte[]) this.d.clone();
    }

    public boolean ms(int i, d dVar, int i2, int i3) {
        return dVar.ms(i2, this.d, i, i3);
    }

    public boolean ms(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.d;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && ch.ms(bArr2, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            int iAh = dVar.ah();
            byte[] bArr = this.d;
            if (iAh == bArr.length && dVar.ms(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.ka;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.d);
        this.ka = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public int compareTo(d dVar) {
        int iAh = ah();
        int iAh2 = dVar.ah();
        int iMin = Math.min(iAh, iAh2);
        for (int i = 0; i < iMin; i++) {
            int iMs = ms(i) & UByte.MAX_VALUE;
            int iMs2 = dVar.ms(i) & UByte.MAX_VALUE;
            if (iMs != iMs2) {
                return iMs < iMs2 ? -1 : 1;
            }
        }
        if (iAh == iAh2) {
            return 0;
        }
        return iAh < iAh2 ? -1 : 1;
    }

    public String toString() {
        if (this.d.length == 0) {
            return "[size=0]";
        }
        String strMs = ms();
        int iMs = ms(strMs, 64);
        if (iMs == -1) {
            if (this.d.length <= 64) {
                return "[hex=" + xr() + "]";
            }
            return "[size=" + this.d.length + " hex=" + ms(0, 64).xr() + "…]";
        }
        String strReplace = strMs.substring(0, iMs).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return iMs < strMs.length() ? "[size=" + this.d.length + " text=" + strReplace + "…]" : "[text=" + strReplace + "]";
    }

    static int ms(String str, int i) {
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
