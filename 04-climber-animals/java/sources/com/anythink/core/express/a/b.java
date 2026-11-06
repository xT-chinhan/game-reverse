package com.anythink.core.express.a;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import kotlin.UByte;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final int a = 256;
    private static Map<Character, Character> b = null;
    private static Map<Character, Character> c = null;
    private static final char[] d;
    private static char[] e = null;
    private static final char f = '=';
    private static final byte[] g;

    static {
        char[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        d = cArr;
        HashMap map = new HashMap();
        b = map;
        map.put('A', 'v');
        b.put('B', 'S');
        b.put('C', 'o');
        b.put('D', 'a');
        b.put('E', 'j');
        b.put('F', 'c');
        b.put('G', '7');
        b.put('H', 'd');
        b.put('I', 'R');
        b.put('J', 'z');
        b.put('K', 'p');
        b.put('L', 'W');
        b.put('M', 'i');
        b.put('N', 'f');
        b.put('O', 'G');
        b.put('P', 'y');
        b.put('Q', 'N');
        b.put('R', 'x');
        b.put('S', 'Z');
        b.put('T', 'n');
        b.put('U', 'V');
        b.put('V', '5');
        b.put('W', 'k');
        b.put('X', '+');
        b.put('Y', 'D');
        b.put('Z', 'H');
        b.put('a', 'L');
        b.put('b', 'Y');
        b.put('c', 'h');
        b.put('d', 'J');
        b.put('e', '4');
        b.put('f', '6');
        b.put('g', 'l');
        b.put('h', 't');
        b.put('i', '0');
        b.put('j', 'U');
        b.put('k', '3');
        b.put('l', 'Q');
        b.put('m', 'r');
        b.put('n', 'g');
        b.put('o', 'E');
        b.put('p', Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC));
        b.put('q', 'q');
        b.put('r', '8');
        b.put('s', 's');
        b.put('t', 'w');
        b.put(Character.valueOf(AbstractJsonLexerKt.UNICODE_ESC), '/');
        b.put('v', 'X');
        b.put('w', 'M');
        b.put('x', 'e');
        b.put('y', 'B');
        b.put('z', 'A');
        b.put('0', 'T');
        b.put('1', '2');
        b.put('2', 'F');
        b.put('3', 'b');
        b.put('4', '9');
        b.put('5', 'P');
        b.put('6', '1');
        b.put('7', 'O');
        b.put('8', 'I');
        b.put('9', 'K');
        b.put('+', 'm');
        b.put('/', 'C');
        e = new char[cArr.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            char[] cArr2 = d;
            if (i2 >= cArr2.length) {
                break;
            }
            e[i2] = b.get(Character.valueOf(cArr2[i2])).charValue();
            i2++;
        }
        g = new byte[128];
        int i3 = 0;
        while (true) {
            byte[] bArr = g;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = 127;
            i3++;
        }
        while (true) {
            char[] cArr3 = e;
            if (i >= cArr3.length) {
                return;
            }
            g[cArr3[i]] = (byte) i;
            i++;
        }
    }

    private static int a(char[] cArr, byte[] bArr, int i) {
        try {
            char c2 = cArr[3];
            char c3 = c2 == '=' ? (char) 2 : (char) 3;
            char c4 = cArr[2];
            if (c4 == '=') {
                c3 = 1;
            }
            byte[] bArr2 = g;
            byte b2 = bArr2[cArr[0]];
            byte b3 = bArr2[cArr[1]];
            byte b4 = bArr2[c4];
            byte b5 = bArr2[c2];
            if (c3 == 2) {
                bArr[i] = (byte) ((3 & (b3 >> 4)) | ((b2 << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF));
                bArr[i + 1] = (byte) (((b3 << 4) & MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA) | ((b4 >> 2) & 15));
                return 2;
            }
            if (c3 != 3) {
                bArr[i] = (byte) (((b3 >> 4) & 3) | ((b2 << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF));
                return 1;
            }
            int i2 = i + 1;
            bArr[i] = (byte) (((b2 << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) | ((b3 >> 4) & 3));
            bArr[i2] = (byte) (((b3 << 4) & MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA) | ((b4 >> 2) & 15));
            bArr[i2 + 1] = (byte) (((b4 << 6) & MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT) | (b5 & com.anythink.core.common.s.a.c.c));
            return 3;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0024 A[Catch: Exception -> 0x003e, TryCatch #0 {Exception -> 0x003e, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0013, B:8:0x0019, B:10:0x001e, B:16:0x0032, B:12:0x0024, B:14:0x002a, B:19:0x0038), top: B:23:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x002a A[Catch: Exception -> 0x003e, TryCatch #0 {Exception -> 0x003e, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0013, B:8:0x0019, B:10:0x001e, B:16:0x0032, B:12:0x0024, B:14:0x002a, B:19:0x0038), top: B:23:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    private static byte[] a(char[] cArr, int i, int i2) {
        int i3;
        try {
            char[] cArr2 = new char[4];
            int i4 = ((i2 >> 2) * 3) + 3;
            byte[] bArr = new byte[i4];
            int iA = 0;
            int i5 = 0;
            for (int i6 = i; i6 < i + i2; i6++) {
                char c2 = cArr[i6];
                if (c2 != '=') {
                    byte[] bArr2 = g;
                    if (c2 < bArr2.length && bArr2[c2] != 127) {
                        i3 = i5 + 1;
                        cArr2[i5] = c2;
                        if (i3 == 4) {
                            iA += a(cArr2, bArr, iA);
                            i5 = 0;
                        } else {
                            i5 = i3;
                        }
                    }
                } else {
                    i3 = i5 + 1;
                    cArr2[i5] = c2;
                    if (i3 == 4) {
                        iA += a(cArr2, bArr, iA);
                        i5 = 0;
                    } else {
                        i5 = i3;
                    }
                }
            }
            if (iA == i4) {
                return bArr;
            }
            byte[] bArr3 = new byte[iA];
            System.arraycopy(bArr, 0, bArr3, 0, iA);
            return bArr3;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str) {
        byte[] bArrC = c(str);
        if (bArrC == null || bArrC.length <= 0) {
            return null;
        }
        return new String(bArrC);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003d A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:2:0x0000, B:5:0x0009, B:7:0x0019, B:9:0x001d, B:13:0x002c, B:15:0x0032, B:17:0x0037, B:23:0x004c, B:19:0x003d, B:21:0x0044, B:10:0x0023, B:27:0x0055), top: B:31:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0044 A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:2:0x0000, B:5:0x0009, B:7:0x0019, B:9:0x001d, B:13:0x002c, B:15:0x0032, B:17:0x0037, B:23:0x004c, B:19:0x003d, B:21:0x0044, B:10:0x0023, B:27:0x0055), top: B:31:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x004b  */
    private static byte[] c(String str) {
        int i;
        int i2;
        try {
            int length = str.length();
            int i3 = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME;
            if (length < 259) {
                i3 = length;
            }
            char[] cArr = new char[i3];
            int i4 = ((length >> 2) * 3) + 3;
            byte[] bArr = new byte[i4];
            int i5 = 0;
            int iA = 0;
            int i6 = 0;
            while (i5 < length) {
                int i7 = i5 + 256;
                if (i7 <= length) {
                    str.getChars(i5, i7, cArr, i6);
                    i = i6 + 256;
                } else {
                    str.getChars(i5, length, cArr, i6);
                    i = (length - i5) + i6;
                }
                int i8 = i6;
                while (i6 < i) {
                    char c2 = cArr[i6];
                    if (c2 != '=') {
                        byte[] bArr2 = g;
                        if (c2 < bArr2.length && bArr2[c2] != 127) {
                            i2 = i8 + 1;
                            cArr[i8] = c2;
                            if (i2 == 4) {
                                iA += a(cArr, bArr, iA);
                                i8 = 0;
                            } else {
                                i8 = i2;
                            }
                        }
                    } else {
                        i2 = i8 + 1;
                        cArr[i8] = c2;
                        if (i2 == 4) {
                            iA += a(cArr, bArr, iA);
                            i8 = 0;
                        } else {
                            i8 = i2;
                        }
                    }
                    i6++;
                }
                i5 = i7;
                i6 = i8;
            }
            if (iA == i4) {
                return bArr;
            }
            byte[] bArr3 = new byte[iA];
            System.arraycopy(bArr, 0, bArr3, 0, iA);
            return bArr3;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str) {
        byte[] bytes = str.getBytes();
        return a(bytes, bytes.length);
    }

    private static String a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    private static String a(byte[] bArr, int i) {
        if (i <= 0) {
            return "";
        }
        try {
            char[] cArr = new char[((i / 3) << 2) + 4];
            int i2 = 0;
            int i3 = 0;
            while (i >= 3) {
                int i4 = ((bArr[i2] & UByte.MAX_VALUE) << 16) + ((bArr[i2 + 1] & UByte.MAX_VALUE) << 8) + (bArr[i2 + 2] & UByte.MAX_VALUE);
                int i5 = i3 + 1;
                char[] cArr2 = e;
                cArr[i3] = cArr2[i4 >> 18];
                int i6 = i5 + 1;
                cArr[i5] = cArr2[(i4 >> 12) & 63];
                int i7 = i6 + 1;
                cArr[i6] = cArr2[(i4 >> 6) & 63];
                i3 = i7 + 1;
                cArr[i7] = cArr2[i4 & 63];
                i2 += 3;
                i -= 3;
            }
            if (i == 1) {
                int i8 = bArr[i2] & UByte.MAX_VALUE;
                int i9 = i3 + 1;
                char[] cArr3 = e;
                cArr[i3] = cArr3[i8 >> 2];
                int i10 = i9 + 1;
                cArr[i9] = cArr3[(i8 << 4) & 63];
                int i11 = i10 + 1;
                cArr[i10] = f;
                i3 = i11 + 1;
                cArr[i11] = f;
            } else if (i == 2) {
                int i12 = ((bArr[i2] & UByte.MAX_VALUE) << 8) + (bArr[i2 + 1] & UByte.MAX_VALUE);
                int i13 = i3 + 1;
                char[] cArr4 = e;
                cArr[i3] = cArr4[i12 >> 10];
                int i14 = i13 + 1;
                cArr[i13] = cArr4[(i12 >> 4) & 63];
                int i15 = i14 + 1;
                cArr[i14] = cArr4[(i12 << 2) & 63];
                i3 = i15 + 1;
                cArr[i15] = f;
            }
            return new String(cArr, 0, i3);
        } catch (Exception unused) {
            return null;
        }
    }
}
