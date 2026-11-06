package com.anythink.core.common.s.a;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.ek;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
final class f {
    private static final int c = 2048;
    private static final String d = "Invalid String";
    public byte[] a;
    public int b;
    private char[] e;

    private static int f(int i) {
        if ((i >> 7) == 0) {
            return 1;
        }
        if ((i >> 14) == 0) {
            return 2;
        }
        if ((i >> 21) == 0) {
            return 3;
        }
        return (i >> 28) == 0 ? 4 : 5;
    }

    public f(int i) {
        this(new byte[i], 0);
    }

    public f(byte[] bArr) {
        this(bArr, 0);
    }

    public f(byte[] bArr, int i) {
        this.e = null;
        this.a = bArr;
        this.b = i;
    }

    public final byte a() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i];
    }

    public final void a(byte b) {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
    }

    public final short b() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & UByte.MAX_VALUE;
        this.b = i2 + 1;
        return (short) ((bArr[i2] << 8) | i3);
    }

    public final void a(short s) {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        bArr[i] = (byte) s;
        this.b = i2 + 1;
        bArr[i2] = (byte) (s >> 8);
    }

    public final int a(int i) {
        byte[] bArr = this.a;
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i] & UByte.MAX_VALUE) | ((bArr[i2] & UByte.MAX_VALUE) << 8) | ((bArr[i3] & UByte.MAX_VALUE) << 16) | (bArr[i3 + 1] << 24);
    }

    public final int c() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & UByte.MAX_VALUE) | ((bArr[i2] & UByte.MAX_VALUE) << 8);
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        this.b = i5 + 1;
        return (bArr[i5] << 24) | i6;
    }

    public final int a(com.anythink.core.common.s.a.a.a aVar) {
        return aVar != null ? aVar.d() : c();
    }

    public final void b(int i) {
        byte[] bArr = this.a;
        int i2 = this.b;
        int i3 = i2 + 1;
        bArr[i2] = (byte) i;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >> 16);
        this.b = i5 + 1;
        bArr[i5] = (byte) (i >> 24);
    }

    public final void a(int i, int i2) {
        byte[] bArr = this.a;
        int i3 = i + 1;
        bArr[i] = (byte) i2;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >> 8);
        bArr[i4] = (byte) (i2 >> 16);
        bArr[i4 + 1] = (byte) (i2 >> 24);
    }

    private int e() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        if ((b >> 7) == 0) {
            return b;
        }
        int i3 = i2 + 1;
        this.b = i3;
        int i4 = (b & 127) | (bArr[i2] << 7);
        if ((i4 >> 14) == 0) {
            return i4;
        }
        int i5 = i3 + 1;
        this.b = i5;
        int i6 = (i4 & 16383) | (bArr[i3] << ek.l);
        if ((i6 >> 21) == 0) {
            return i6;
        }
        int i7 = i5 + 1;
        this.b = i7;
        int i8 = (i6 & 2097151) | (bArr[i5] << 21);
        if ((i8 >> 28) == 0) {
            return i8;
        }
        this.b = i7 + 1;
        return (bArr[i7] << 28) | (i8 & 268435455);
    }

    private int c(int i, int i2) {
        while ((i2 & (-128)) != 0) {
            this.a[i] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i++;
        }
        int i3 = i + 1;
        this.a[i] = (byte) i2;
        return i3;
    }

    private void e(int i) {
        int i2 = this.b;
        while ((i & (-128)) != 0) {
            this.a[i2] = (byte) ((i & 127) | 128);
            i >>>= 7;
            i2++;
        }
        this.a[i2] = (byte) i;
        this.b = i2 + 1;
    }

    public final void a(int i, long j) {
        byte[] bArr = this.a;
        int i2 = i + 1;
        bArr[i] = (byte) j;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j >> 8);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j >> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j >> 24);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j >> 32);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j >> 40);
        bArr[i7] = (byte) (j >> 48);
        bArr[i7 + 1] = (byte) (j >> 56);
    }

    public final void a(long j) {
        a(this.b, j);
        this.b += 8;
    }

    public final long c(int i) {
        byte[] bArr = this.a;
        int i2 = i + 1;
        long j = ((long) bArr[i]) & 255;
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8) | ((((long) bArr[i3]) & 255) << 16);
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 24);
        int i6 = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 32);
        int i7 = i6 + 1;
        return j4 | ((((long) bArr[i6]) & 255) << 40) | ((255 & ((long) bArr[i7])) << 48) | (((long) bArr[i7 + 1]) << 56);
    }

    public final long d() {
        long jC = c(this.b);
        this.b += 8;
        return jC;
    }

    public final long b(com.anythink.core.common.s.a.a.a aVar) {
        return aVar != null ? aVar.f() : d();
    }

    private float c(com.anythink.core.common.s.a.a.a aVar) {
        return Float.intBitsToFloat(a(aVar));
    }

    private double d(com.anythink.core.common.s.a.a.a aVar) {
        return Double.longBitsToDouble(b(aVar));
    }

    private byte[] g(int i) {
        byte[] bArr = new byte[i];
        System.arraycopy(this.a, this.b, bArr, 0, i);
        this.b += i;
        return bArr;
    }

    public final void a(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.a, this.b, length);
            this.b += length;
        }
    }

    public final String a(com.anythink.core.common.s.a.a.a aVar, int i) {
        String str;
        if (aVar == null || i <= 0) {
            return d(i);
        }
        byte[] bArr = this.a;
        int i2 = this.b;
        Arrays.copyOfRange(bArr, i2, i2 + i);
        byte[] bArrB = aVar.b();
        if (bArrB == null) {
            str = null;
        } else {
            str = bArrB.length > 2048 ? new String(bArrB, StandardCharsets.UTF_8) : a(bArrB, 0, bArrB.length);
        }
        this.b += i;
        return str;
    }

    public final String d(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String str = i > 2048 ? new String(this.a, this.b, i, StandardCharsets.UTF_8) : a(this.a, this.b, i);
        this.b += i;
        return str;
    }

    public final void a(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        byte[] bArr = this.a;
        int i = this.b;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                bArr[i] = (byte) cCharAt;
                i2 = i3;
                i++;
            } else if (cCharAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((cCharAt >>> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                i = i4 + 1;
                bArr[i4] = (byte) ((cCharAt & '?') | 128);
                i2 = i3;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                int i5 = i + 1;
                bArr[i] = (byte) ((cCharAt >>> '\f') | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((cCharAt >>> 6) & 63) | 128);
                bArr[i6] = (byte) ((cCharAt & '?') | 128);
                i2 = i3;
                i = i6 + 1;
            } else {
                int i7 = i3 + 1;
                int iCharAt = ((cCharAt << '\n') + str.charAt(i3)) - 56613888;
                int i8 = i + 1;
                bArr[i] = (byte) ((iCharAt >>> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((iCharAt >>> 12) & 63) | 128);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((iCharAt >>> 6) & 63) | 128);
                i = i10 + 1;
                bArr[i10] = (byte) ((iCharAt & 63) | 128);
                i2 = i7;
            }
        }
        this.b = i;
    }

    public static int b(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                i2++;
            } else if (cCharAt < 2048) {
                i2 += 2;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                i2 += 3;
            } else {
                i = i3 + 1;
                i2 += 4;
            }
            i = i3;
        }
        return i2;
    }

    private char[] h(int i) {
        char[] cArr = this.e;
        if (cArr == null) {
            char[] cArr2 = i <= 256 ? new char[256] : new char[2048];
            this.e = cArr2;
            return cArr2;
        }
        if (cArr.length >= i) {
            return cArr;
        }
        char[] cArr3 = new char[2048];
        this.e = cArr3;
        return cArr3;
    }

    private void c(String str) {
        byte[] bArr = this.a;
        int i = this.b;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                bArr[i] = (byte) cCharAt;
                i2 = i3;
                i++;
            } else if (cCharAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((cCharAt >>> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                i = i4 + 1;
                bArr[i4] = (byte) ((cCharAt & '?') | 128);
                i2 = i3;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                int i5 = i + 1;
                bArr[i] = (byte) ((cCharAt >>> '\f') | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((cCharAt >>> 6) & 63) | 128);
                bArr[i6] = (byte) ((cCharAt & '?') | 128);
                i2 = i3;
                i = i6 + 1;
            } else {
                int i7 = i3 + 1;
                int iCharAt = ((cCharAt << '\n') + str.charAt(i3)) - 56613888;
                int i8 = i + 1;
                bArr[i] = (byte) ((iCharAt >>> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((iCharAt >>> 12) & 63) | 128);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((iCharAt >>> 6) & 63) | 128);
                i = i10 + 1;
                bArr[i10] = (byte) ((iCharAt & 63) | 128);
                i2 = i7;
            }
        }
        this.b = i;
    }

    final long b(int i, int i2) {
        long jC = 0;
        if (i2 <= 0) {
            return 0L;
        }
        int i3 = i2 >> 3;
        int i4 = i2 & 7;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            jC ^= c(i6);
            i6 += 8;
        }
        int i8 = i4 << 3;
        while (i5 < i8) {
            jC ^= (((long) this.a[i6]) & 255) << i5;
            i5 += 8;
            i6++;
        }
        int i9 = (i & 7) << 3;
        return (jC >>> (64 - i9)) | (jC << i9);
    }

    private byte[] b(com.anythink.core.common.s.a.a.a aVar, int i) {
        byte[] bArr = new byte[i];
        System.arraycopy(this.a, this.b, bArr, 0, i);
        this.b += i;
        return aVar != null ? aVar.b() : bArr;
    }

    final synchronized String a(byte[] bArr, int i, int i2) {
        char[] cArr;
        int i3;
        int i4;
        cArr = this.e;
        if (cArr == null) {
            cArr = i2 <= 256 ? new char[256] : new char[2048];
            this.e = cArr;
        } else if (cArr.length < i2) {
            cArr = new char[2048];
            this.e = cArr;
        }
        int i5 = i2 + i;
        i3 = 0;
        while (i < i5) {
            int i6 = i + 1;
            byte b = bArr[i];
            if (b > 0) {
                cArr[i3] = (char) b;
                i = i6;
                i3++;
            } else if (b < -32) {
                int i7 = i6 + 1;
                byte b2 = bArr[i6];
                if (b < -62 || b2 > -65) {
                    throw new IllegalArgumentException(d);
                }
                cArr[i3] = (char) (((b & 31) << 6) | (b2 & c.c));
                i = i7;
                i3++;
            } else {
                if (b < -16) {
                    int i8 = i6 + 1;
                    byte b3 = bArr[i6];
                    i4 = i8 + 1;
                    byte b4 = bArr[i8];
                    if ((b == -32 && b3 < -96) || ((b == -19 && b3 >= -96) || b3 > -65 || b4 > -65)) {
                        throw new IllegalArgumentException(d);
                    }
                    cArr[i3] = (char) (((b & ek.m) << 12) | ((b3 & c.c) << 6) | (b4 & c.c));
                    i3++;
                } else {
                    int i9 = i6 + 1;
                    byte b5 = bArr[i6];
                    int i10 = i9 + 1;
                    byte b6 = bArr[i9];
                    i4 = i10 + 1;
                    byte b7 = bArr[i10];
                    if (b5 > -65 || (((b << 28) + (b5 + 112)) >> 30) != 0 || b6 > -65 || b7 > -65) {
                        throw new IllegalArgumentException(d);
                    }
                    int i11 = ((b & 7) << 18) | ((b5 & c.c) << 12) | ((b6 & c.c) << 6) | (b7 & c.c);
                    int i12 = i3 + 1;
                    cArr[i3] = (char) ((i11 >>> 10) + 55232);
                    i3 = i12 + 1;
                    cArr[i12] = (char) ((i11 & 1023) + 56320);
                }
                i = i4;
            }
        }
        if (i > i5) {
            throw new IllegalArgumentException(d);
        }
        return new String(cArr, 0, i3);
    }
}
