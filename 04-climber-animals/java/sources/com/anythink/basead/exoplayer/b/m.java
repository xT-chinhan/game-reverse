package com.anythink.basead.exoplayer.b;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.uc.crashsdk.export.LogType;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    private static final int a = 2147385345;
    private static final int b = 536864768;
    private static final int c = -25230976;
    private static final int d = -14745368;
    private static final byte e = 127;
    private static final byte f = 31;
    private static final byte g = -2;
    private static final byte h = -1;
    private static final int[] i = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] j = {-1, 8000, 16000, LogType.UNEXP_KNOWN_REASON, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] k = {64, 112, 128, MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT, 224, 256, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_500, 448, 512, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, LogType.UNEXP_OTHER, 896, 1024, 1152, LogType.UNEXP_ANR, 1536, 1920, 2048, LogType.UNEXP_LOW_MEMORY, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    private static boolean a(int i2) {
        return i2 == a || i2 == c || i2 == b || i2 == d;
    }

    private static int a(byte[] bArr) {
        int i2;
        byte b2;
        int i3;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i2 = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            } else if (b4 == 31) {
                i2 = (bArr[5] & 7) << 4;
                b3 = bArr[6];
            } else {
                i2 = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            }
            i3 = b3 & 60;
            return (((i3 >> 2) | i2) + 1) * 32;
        }
        i2 = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        i3 = b2 & 252;
        return (((i3 >> 2) | i2) + 1) * 32;
    }

    public static int a(ByteBuffer byteBuffer) {
        int i2;
        byte b2;
        int i3;
        byte b3;
        int iPosition = byteBuffer.position();
        byte b4 = byteBuffer.get(iPosition);
        if (b4 != -2) {
            if (b4 == -1) {
                i2 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                b3 = byteBuffer.get(iPosition + 7);
            } else if (b4 == 31) {
                i2 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                b3 = byteBuffer.get(iPosition + 6);
            } else {
                i2 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                b2 = byteBuffer.get(iPosition + 5);
            }
            i3 = b3 & 60;
            return (((i3 >> 2) | i2) + 1) * 32;
        }
        i2 = (byteBuffer.get(iPosition + 5) & 1) << 6;
        b2 = byteBuffer.get(iPosition + 4);
        i3 = b2 & 252;
        return (((i3 >> 2) | i2) + 1) * 32;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005f  */
    /* JADX WARN: Code duplicated, block: B:17:? A[RETURN, SYNTHETIC] */
    private static int b(byte[] bArr) {
        int i2;
        byte b2;
        int i3;
        int i4;
        byte b3;
        boolean z = false;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i4 = ((bArr[7] & 3) << 12) | ((bArr[6] & 255) << 4);
                b3 = bArr[9];
            } else if (b4 == 31) {
                i4 = ((bArr[6] & 3) << 12) | ((bArr[7] & 255) << 4);
                b3 = bArr[8];
            } else {
                i2 = ((bArr[5] & 3) << 12) | ((bArr[6] & 255) << 4);
                b2 = bArr[7];
            }
            i3 = (((b3 & 60) >> 2) | i4) + 1;
            z = true;
            if (z) {
                return (i3 * 16) / 14;
            }
            return i3;
        }
        i2 = ((bArr[4] & 3) << 12) | ((bArr[7] & 255) << 4);
        b2 = bArr[6];
        i3 = (((b2 & 240) >> 4) | i2) + 1;
        if (z) {
            return (i3 * 16) / 14;
        }
        return i3;
    }

    private static com.anythink.basead.exoplayer.k.r c(byte[] bArr) {
        if (bArr[0] == 127) {
            return new com.anythink.basead.exoplayer.k.r(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        byte b2 = bArrCopyOf[0];
        if (b2 == -2 || b2 == -1) {
            for (int i2 = 0; i2 < bArrCopyOf.length - 1; i2 += 2) {
                byte b3 = bArrCopyOf[i2];
                int i3 = i2 + 1;
                bArrCopyOf[i2] = bArrCopyOf[i3];
                bArrCopyOf[i3] = b3;
            }
        }
        com.anythink.basead.exoplayer.k.r rVar = new com.anythink.basead.exoplayer.k.r(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            com.anythink.basead.exoplayer.k.r rVar2 = new com.anythink.basead.exoplayer.k.r(bArrCopyOf);
            while (rVar2.a() >= 16) {
                rVar2.b(2);
                rVar.d(rVar2.c(14));
            }
        }
        rVar.a(bArrCopyOf, bArrCopyOf.length);
        return rVar;
    }

    private static boolean d(byte[] bArr) {
        byte b2 = bArr[0];
        return b2 == -2 || b2 == -1;
    }

    private m() {
    }

    private static com.anythink.basead.exoplayer.m a(byte[] bArr, String str, String str2, com.anythink.basead.exoplayer.d.e eVar) {
        com.anythink.basead.exoplayer.k.r rVar;
        if (bArr[0] == 127) {
            rVar = new com.anythink.basead.exoplayer.k.r(bArr);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            byte b2 = bArrCopyOf[0];
            if (b2 == -2 || b2 == -1) {
                for (int i2 = 0; i2 < bArrCopyOf.length - 1; i2 += 2) {
                    byte b3 = bArrCopyOf[i2];
                    int i3 = i2 + 1;
                    bArrCopyOf[i2] = bArrCopyOf[i3];
                    bArrCopyOf[i3] = b3;
                }
            }
            rVar = new com.anythink.basead.exoplayer.k.r(bArrCopyOf);
            if (bArrCopyOf[0] == 31) {
                com.anythink.basead.exoplayer.k.r rVar2 = new com.anythink.basead.exoplayer.k.r(bArrCopyOf);
                while (rVar2.a() >= 16) {
                    rVar2.b(2);
                    rVar.d(rVar2.c(14));
                }
            }
            rVar.a(bArrCopyOf, bArrCopyOf.length);
        }
        rVar.b(60);
        int i4 = i[rVar.c(6)];
        int i5 = j[rVar.c(4)];
        int iC = rVar.c(5);
        int[] iArr = k;
        int i6 = iC < iArr.length ? (iArr[iC] * 1000) / 2 : -1;
        rVar.b(10);
        return com.anythink.basead.exoplayer.m.a(str, com.anythink.basead.exoplayer.k.o.D, null, i6, i4 + (rVar.c(2) > 0 ? 1 : 0), i5, null, eVar, str2);
    }
}
