package com.byazt.wa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 13})
public class w implements Serializable, Comparable<w> {
    public static final char[] n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final w qg = n(new byte[0]);
    public transient String l;
    public transient int q;
    public final byte[] s;

    public w(byte[] bArr) {
        this.s = bArr;
    }

    public static w n(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new w((byte[]) bArr.clone());
    }

    public static w n(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        w wVar = new w(str.getBytes(py.n));
        wVar.l = str;
        return wVar;
    }

    public String n() {
        String str = this.l;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.s, py.n);
        this.l = str2;
        return str2;
    }

    public String qg() {
        return qg.n(this.s);
    }

    public w s() {
        return s("SHA-1");
    }

    public w q() {
        return s("SHA-256");
    }

    private w s(String str) {
        try {
            return n(MessageDigest.getInstance(str).digest(this.s));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public String l() {
        byte[] bArr = this.s;
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

    public static w qg(String str) {
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
            bArr[i] = (byte) ((n(str.charAt(i2)) << 4) + n(str.charAt(i2 + 1)));
        }
        return n(bArr);
    }

    private static int n(char c) {
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

    public w w() {
        int i = 0;
        while (true) {
            byte[] bArr = this.s;
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
                return new w(bArr2);
            }
            i++;
        }
    }

    public w n(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.s;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.s.length + ")");
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
        return new w(bArr2);
    }

    public byte n(int i) {
        return this.s[i];
    }

    public int x() {
        return this.s.length;
    }

    public byte[] fs() {
        return (byte[]) this.s.clone();
    }

    public void n(s sVar) {
        byte[] bArr = this.s;
        sVar.s(bArr, 0, bArr.length);
    }

    public boolean n(int i, w wVar, int i2, int i3) {
        return wVar.n(i2, this.s, i, i3);
    }

    public boolean n(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.s;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && py.n(bArr2, i, bArr, i2, i3);
    }

    public final boolean n(w wVar) {
        return n(0, wVar, 0, wVar.x());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            int iX = wVar.x();
            byte[] bArr = this.s;
            if (iX == bArr.length && wVar.n(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.q;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.s);
        this.q = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public int compareTo(w wVar) {
        int iX = x();
        int iX2 = wVar.x();
        int iMin = Math.min(iX, iX2);
        for (int i = 0; i < iMin; i++) {
            int iN = n(i) & UByte.MAX_VALUE;
            int iN2 = wVar.n(i) & UByte.MAX_VALUE;
            if (iN != iN2) {
                return iN < iN2 ? -1 : 1;
            }
        }
        if (iX == iX2) {
            return 0;
        }
        return iX < iX2 ? -1 : 1;
    }

    public String toString() {
        if (this.s.length == 0) {
            return "[size=0]";
        }
        String strN = n();
        int iN = n(strN, 64);
        if (iN == -1) {
            if (this.s.length <= 64) {
                return "[hex=" + l() + "]";
            }
            return "[size=" + this.s.length + " hex=" + n(0, 64).l() + "…]";
        }
        String strReplace = strN.substring(0, iN).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return iN < strN.length() ? "[size=" + this.s.length + " text=" + strReplace + "…]" : "[text=" + strReplace + "]";
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
