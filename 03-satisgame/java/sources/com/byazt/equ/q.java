package com.byazt.equ;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 777, 5})
public class q implements Serializable, Comparable<q> {
    public static final char[] n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset qg = Charset.forName("UTF-8");
    public static final q s = n(new byte[0]);
    public transient int l;
    public final byte[] q;
    public transient String w;

    public q(byte[] bArr) {
        this.q = bArr;
    }

    public static q n(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new q((byte[]) bArr.clone());
    }

    public String n() {
        String str = this.w;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.q, qg);
        this.w = str2;
        return str2;
    }

    public static q n(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        q qVar = new q(str.getBytes(tj.n));
        qVar.w = str;
        return qVar;
    }

    public String qg() {
        byte[] bArr = this.q;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = n;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public q n(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.q;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.q.length + ")");
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
        return new q(bArr2);
    }

    public byte n(int i) {
        return this.q[i];
    }

    public int s() {
        return this.q.length;
    }

    public byte[] q() {
        return (byte[]) this.q.clone();
    }

    public boolean n(int i, q qVar, int i2, int i3) {
        return qVar.n(i2, this.q, i, i3);
    }

    public boolean n(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.q;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && tj.n(bArr2, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            int iS = qVar.s();
            byte[] bArr = this.q;
            if (iS == bArr.length && qVar.n(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.l;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.q);
        this.l = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int compareTo(q qVar) {
        int iS = s();
        int iS2 = qVar.s();
        int iMin = Math.min(iS, iS2);
        for (int i = 0; i < iMin; i++) {
            int iN = n(i) & UByte.MAX_VALUE;
            int iN2 = qVar.n(i) & UByte.MAX_VALUE;
            if (iN != iN2) {
                return iN < iN2 ? -1 : 1;
            }
        }
        if (iS == iS2) {
            return 0;
        }
        return iS < iS2 ? -1 : 1;
    }

    public String toString() {
        if (this.q.length == 0) {
            return "[size=0]";
        }
        String strN = n();
        int iN = n(strN, 64);
        if (iN == -1) {
            if (this.q.length <= 64) {
                return "[hex=" + qg() + "]";
            }
            return "[size=" + this.q.length + " hex=" + n(0, 64).qg() + "…]";
        }
        String strReplace = strN.substring(0, iN).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return iN < strN.length() ? "[size=" + this.q.length + " text=" + strReplace + "…]" : "[text=" + strReplace + "]";
    }

    public static int n(String str, int i) {
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
