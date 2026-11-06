package com.smartdigimkt.l4;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.charset.StandardCharsets;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    public char[] a = null;
    public byte[] b;
    public int c;

    public s(int i, byte[] bArr) {
        this.b = bArr;
        this.c = i;
    }

    public final void a(byte b) {
        byte[] bArr = this.b;
        int i = this.c;
        this.c = i + 1;
        bArr[i] = b;
    }

    public final void b(int i, int i2) {
        byte[] bArr = this.b;
        bArr[i] = (byte) i2;
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    public final int a() {
        byte[] bArr = this.b;
        int i = this.c;
        int i2 = ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | (bArr[i] & UByte.MAX_VALUE);
        int i3 = i + 3;
        int i4 = i2 | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
        this.c = i + 4;
        return (bArr[i3] << 24) | i4;
    }

    public final void a(int i, long j) {
        byte[] bArr = this.b;
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >> 8);
        bArr[i + 2] = (byte) (j >> 16);
        bArr[i + 3] = (byte) (j >> 24);
        bArr[i + 4] = (byte) (j >> 32);
        bArr[i + 5] = (byte) (j >> 40);
        bArr[i + 6] = (byte) (j >> 48);
        bArr[i + 7] = (byte) (j >> 56);
    }

    public final String c(int i) {
        String strA;
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        if (i > 2048) {
            strA = new String(this.b, this.c, i, StandardCharsets.UTF_8);
        } else {
            strA = a(this.b, this.c, i);
        }
        this.c += i;
        return strA;
    }

    public final String b(int i) {
        return c(i);
    }

    public final void b(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        byte[] bArr = this.b;
        int i = this.c;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                bArr[i] = (byte) cCharAt;
                i++;
            } else if (cCharAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((cCharAt >>> 6) | MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT);
                i += 2;
                bArr[i4] = (byte) ((cCharAt & '?') | 128);
            } else if (cCharAt >= 55296 && cCharAt <= 57343) {
                i2 += 2;
                int iCharAt = ((cCharAt << '\n') + str.charAt(i3)) - 56613888;
                bArr[i] = (byte) ((iCharAt >>> 18) | MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                bArr[i + 1] = (byte) (((iCharAt >>> 12) & 63) | 128);
                int i5 = i + 3;
                bArr[i + 2] = (byte) (((iCharAt >>> 6) & 63) | 128);
                i += 4;
                bArr[i5] = (byte) ((iCharAt & 63) | 128);
            } else {
                bArr[i] = (byte) ((cCharAt >>> '\f') | 224);
                int i6 = i + 2;
                bArr[i + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                i += 3;
                bArr[i6] = (byte) ((cCharAt & '?') | 128);
            }
            i2 = i3;
        }
        this.c = i;
    }

    public final long a(int i) {
        byte[] bArr = this.b;
        int i2 = i + 6;
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i2]) & 255) << 48) | (((long) bArr[i + 7]) << 56);
    }

    public static int a(String str) {
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
                i += 2;
                i2 += 4;
            }
            i = i3;
        }
        return i2;
    }

    public final synchronized String a(byte[] bArr, int i, int i2) {
        char[] cArr;
        int i3;
        int i4;
        cArr = this.a;
        if (cArr == null) {
            cArr = i2 <= 256 ? new char[256] : new char[2048];
            this.a = cArr;
        } else if (cArr.length < i2) {
            cArr = new char[2048];
            this.a = cArr;
        }
        int i5 = i2 + i;
        i3 = 0;
        while (i < i5) {
            int i6 = i + 1;
            byte b = bArr[i];
            if (b > 0) {
                cArr[i3] = (char) b;
                i3++;
                i = i6;
            } else {
                if (b < -32) {
                    i += 2;
                    byte b2 = bArr[i6];
                    if (b >= -62 && b2 <= -65) {
                        i4 = i3 + 1;
                        cArr[i3] = (char) ((b2 & com.anythink.core.common.r.a.c.c) | ((b & 31) << 6));
                    } else {
                        throw new IllegalArgumentException("Invalid String");
                    }
                } else if (b < -16) {
                    int i7 = i + 2;
                    byte b3 = bArr[i6];
                    i += 3;
                    byte b4 = bArr[i7];
                    if ((b != -32 || b3 >= -96) && ((b != -19 || b3 < -96) && b3 <= -65 && b4 <= -65)) {
                        i4 = i3 + 1;
                        cArr[i3] = (char) (((b3 & com.anythink.core.common.r.a.c.c) << 6) | ((b & 15) << 12) | (b4 & com.anythink.core.common.r.a.c.c));
                    } else {
                        throw new IllegalArgumentException("Invalid String");
                    }
                } else {
                    byte b5 = bArr[i6];
                    int i8 = i + 3;
                    byte b6 = bArr[i + 2];
                    i += 4;
                    byte b7 = bArr[i8];
                    if (b5 <= -65) {
                        if ((((b5 + 112) + (b << 28)) >> 30) == 0 && b6 <= -65 && b7 <= -65) {
                            int i9 = ((b5 & com.anythink.core.common.r.a.c.c) << 12) | ((b & 7) << 18) | ((b6 & com.anythink.core.common.r.a.c.c) << 6) | (b7 & com.anythink.core.common.r.a.c.c);
                            int i10 = i3 + 1;
                            cArr[i3] = (char) ((i9 >>> 10) + 55232);
                            i3 += 2;
                            cArr[i10] = (char) ((i9 & 1023) + 56320);
                        }
                    }
                    throw new IllegalArgumentException("Invalid String");
                }
                i3 = i4;
            }
        }
        if (i > i5) {
            throw new IllegalArgumentException("Invalid String");
        }
        return new String(cArr, 0, i3);
    }

    public final long a(int i, int i2) {
        long jA = 0;
        if (i2 <= 0) {
            return 0L;
        }
        int i3 = i2 >> 3;
        int i4 = i2 & 7;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            jA ^= a(i6);
            i6 += 8;
        }
        int i8 = i4 << 3;
        while (i5 < i8) {
            jA ^= (((long) this.b[i6]) & 255) << i5;
            i5 += 8;
            i6++;
        }
        int i9 = (i & 7) << 3;
        return (jA >>> (64 - i9)) | (jA << i9);
    }
}
