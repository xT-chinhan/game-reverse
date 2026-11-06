package com.bytedance.sdk.component.ah.ms;

import com.umeng.analytics.pro.ek;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Serializable, Comparable<c> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final char[] f1006ms = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final c xr = ms(new byte[0]);
    final byte[] ah;
    transient int d;
    transient String ka;

    c(byte[] bArr) {
        this.ah = bArr;
    }

    public static c ms(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new c((byte[]) bArr.clone());
    }

    public static c ms(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        c cVar = new c(str.getBytes(nw.f1012ms));
        cVar.ka = str;
        return cVar;
    }

    public String ms() {
        String str = this.ka;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.ah, nw.f1012ms);
        this.ka = str2;
        return str2;
    }

    public String xr() {
        return xr.ms(this.ah);
    }

    public c ah() {
        return ah("SHA-1");
    }

    public c d() {
        return ah("SHA-256");
    }

    private c ah(String str) {
        try {
            return ms(MessageDigest.getInstance(str).digest(this.ah));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public String ka() {
        byte[] bArr = this.ah;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f1006ms;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & ek.m];
        }
        return new String(cArr);
    }

    public static c xr(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(String.valueOf(str)));
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((ms(str.charAt(i2)) << 4) + ms(str.charAt(i2 + 1)));
        }
        return ms(bArr);
    }

    private static int ms(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: ".concat(String.valueOf(c)));
            }
        }
        return (c - c2) + 10;
    }

    public c c() {
        int i = 0;
        while (true) {
            byte[] bArr = this.ah;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new c(bArr2);
            }
            i++;
        }
    }

    public c ms(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.ah;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.ah.length + ")");
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
        return new c(bArr2);
    }

    public byte ms(int i) {
        return this.ah[i];
    }

    public int ab() {
        return this.ah.length;
    }

    public byte[] x() {
        return (byte[]) this.ah.clone();
    }

    void ms(ah ahVar) {
        byte[] bArr = this.ah;
        ahVar.ah(bArr, 0, bArr.length);
    }

    public boolean ms(int i, c cVar, int i2, int i3) {
        return cVar.ms(i2, this.ah, i, i3);
    }

    public boolean ms(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.ah;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && nw.ms(bArr2, i, bArr, i2, i3);
    }

    public final boolean ms(c cVar) {
        return ms(0, cVar, 0, cVar.ab());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            int iAb = cVar.ab();
            byte[] bArr = this.ah;
            if (iAb == bArr.length && cVar.ms(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.ah);
        this.d = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        int iAb = ab();
        int iAb2 = cVar.ab();
        int iMin = Math.min(iAb, iAb2);
        for (int i = 0; i < iMin; i++) {
            int iMs = ms(i) & UByte.MAX_VALUE;
            int iMs2 = cVar.ms(i) & UByte.MAX_VALUE;
            if (iMs != iMs2) {
                return iMs < iMs2 ? -1 : 1;
            }
        }
        if (iAb == iAb2) {
            return 0;
        }
        return iAb < iAb2 ? -1 : 1;
    }

    public String toString() {
        if (this.ah.length == 0) {
            return "[size=0]";
        }
        String strMs = ms();
        int iMs = ms(strMs, 64);
        if (iMs == -1) {
            if (this.ah.length <= 64) {
                return "[hex=" + ka() + "]";
            }
            return "[size=" + this.ah.length + " hex=" + ms(0, 64).ka() + "…]";
        }
        String strReplace = strMs.substring(0, iMs).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return iMs < strMs.length() ? "[size=" + this.ah.length + " text=" + strReplace + "…]" : "[text=" + strReplace + "]";
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
