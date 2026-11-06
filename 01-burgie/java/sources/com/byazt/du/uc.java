package com.byazt.du;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.cc;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, 5})
public class uc implements Serializable, Comparable<uc> {
    public transient String c;
    public final byte[] hn;
    public transient int x;
    public static final char[] pr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final uc hw = pr(new byte[0]);

    public uc(byte[] bArr) {
        this.hn = bArr;
    }

    public static uc pr(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new uc((byte[]) bArr.clone());
    }

    public static uc pr(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        uc ucVar = new uc(str.getBytes(cz.pr));
        ucVar.c = str;
        return ucVar;
    }

    public String pr() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.hn, cz.pr);
        this.c = str2;
        return str2;
    }

    public String hw() {
        return hw.pr(this.hn);
    }

    public uc hn() {
        return hn("SHA-1");
    }

    public uc x() {
        return hn("SHA-256");
    }

    private uc hn(String str) {
        try {
            return pr(MessageDigest.getInstance(str).digest(this.hn));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public String c() {
        byte[] bArr = this.hn;
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

    public static uc hw(String str) {
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
            bArr[i] = (byte) ((pr(str.charAt(i2)) << 4) + pr(str.charAt(i2 + 1)));
        }
        return pr(bArr);
    }

    private static int pr(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        throw new IllegalArgumentException("Unexpected hex digit: ".concat(String.valueOf(c)));
    }

    public uc uc() {
        int i = 0;
        while (true) {
            byte[] bArr = this.hn;
            if (i < bArr.length) {
                byte b = bArr[i];
                if (b < 65 || b > 90) {
                    i++;
                } else {
                    byte[] bArr2 = (byte[]) bArr.clone();
                    bArr2[i] = (byte) (b + 32);
                    for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                        byte b2 = bArr2[i2];
                        if (b2 >= 65 && b2 <= 90) {
                            bArr2[i2] = (byte) (b2 + 32);
                        }
                    }
                    return new uc(bArr2);
                }
            } else {
                return this;
            }
        }
    }

    public uc pr(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.hn;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.hn.length + ")");
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
        return new uc(bArr2);
    }

    public byte pr(int i) {
        return this.hn[i];
    }

    public int fw() {
        return this.hn.length;
    }

    public byte[] zo() {
        return (byte[]) this.hn.clone();
    }

    public void pr(hn hnVar) {
        byte[] bArr = this.hn;
        hnVar.hn(bArr, 0, bArr.length);
    }

    public boolean pr(int i, uc ucVar, int i2, int i3) {
        return ucVar.pr(i2, this.hn, i, i3);
    }

    public boolean pr(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.hn;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && cz.pr(bArr2, i, bArr, i2, i3);
    }

    public final boolean pr(uc ucVar) {
        return pr(0, ucVar, 0, ucVar.fw());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof uc) {
            uc ucVar = (uc) obj;
            int iFw = ucVar.fw();
            byte[] bArr = this.hn;
            if (iFw == bArr.length && ucVar.pr(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.x;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.hn);
        this.x = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public int compareTo(uc ucVar) {
        int iFw = fw();
        int iFw2 = ucVar.fw();
        int iMin = Math.min(iFw, iFw2);
        for (int i = 0; i < iMin; i++) {
            int iPr = pr(i) & UByte.MAX_VALUE;
            int iPr2 = ucVar.pr(i) & UByte.MAX_VALUE;
            if (iPr != iPr2) {
                return iPr < iPr2 ? -1 : 1;
            }
        }
        if (iFw == iFw2) {
            return 0;
        }
        return iFw < iFw2 ? -1 : 1;
    }

    public String toString() {
        if (this.hn.length == 0) {
            return "[size=0]";
        }
        String strPr = pr();
        int iPr = pr(strPr, 64);
        if (iPr == -1) {
            if (this.hn.length <= 64) {
                return "[hex=" + c() + "]";
            }
            return "[size=" + this.hn.length + " hex=" + pr(0, 64).c() + "…]";
        }
        String strReplace = strPr.substring(0, iPr).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return (iPr < strPr.length() ? new StringBuilder("[size=").append(this.hn.length).append(" text=").append(strReplace).append("…]") : new StringBuilder("[text=").append(strReplace).append("]")).toString();
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
