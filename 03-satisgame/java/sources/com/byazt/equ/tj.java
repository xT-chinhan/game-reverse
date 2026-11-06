package com.byazt.equ;

import com.anythink.core.common.d.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 777, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public final class tj {
    public static final Charset n = Charset.forName("UTF-8");

    public static int n(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    public static void n(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static <T> List<T> n(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static int n(String str, int i, int i2) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int qg(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static int n(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int n(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static String n(String str) {
        InetAddress inetAddressS;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressS = s(str, 1, str.length() - 1);
            } else {
                inetAddressS = s(str, 0, str.length());
            }
            if (inetAddressS == null) {
                return null;
            }
            byte[] address = inetAddressS.getAddress();
            if (address.length == 16) {
                return n(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            if (!str.contains("toutiao") && !str.contains("bytedance")) {
                str = IDN.toASCII(str);
            }
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.isEmpty() || qg(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static boolean qg(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static String n(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x004f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0059 A[LOOP:1: B:30:0x004d->B:33:0x0059, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x005f A[EDGE_INSN: B:58:0x005f->B:34:0x005f BREAK  A[LOOP:1: B:30:0x004d->B:33:0x0059], SYNTHETIC] */
    private static InetAddress s(String str, int i, int i2) {
        int i3;
        int i4;
        int iN;
        byte[] bArr = new byte[16];
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        while (i < i2) {
            if (i5 == 16) {
                return null;
            }
            int i8 = i + 2;
            if (i8 <= i2 && str.regionMatches(i, "::", 0, 2)) {
                if (i6 != -1) {
                    return null;
                }
                i5 += 2;
                i6 = i5;
                if (i8 == i2) {
                    break;
                }
                i7 = i8;
                i3 = 0;
                i = i7;
                while (i < i2) {
                    iN = n(str.charAt(i));
                    if (iN != -1) {
                        break;
                        break;
                    }
                    i3 = (i3 << 4) + iN;
                    i++;
                }
                i4 = i - i7;
                if (i4 != 0) {
                }
                return null;
            }
            if (i5 != 0) {
                if (!str.regionMatches(i, ":", 0, 1)) {
                    if (!str.regionMatches(i, i.E, 0, 1) || !n(str, i7, i2, bArr, i5 - 2)) {
                        return null;
                    }
                    i5 += 2;
                    break;
                }
                i++;
            }
            i7 = i;
            i3 = 0;
            i = i7;
            while (i < i2) {
                iN = n(str.charAt(i));
                if (iN != -1) {
                    break;
                }
                i3 = (i3 << 4) + iN;
                i++;
            }
            i4 = i - i7;
            if (i4 != 0 || i4 > 4) {
                return null;
            }
            int i9 = i5 + 1;
            bArr[i5] = (byte) ((i3 >>> 8) & 255);
            i5 = i9 + 1;
            bArr[i9] = (byte) (i3 & 255);
        }
        if (i5 != 16) {
            if (i6 == -1) {
                return null;
            }
            int i10 = i5 - i6;
            System.arraycopy(bArr, i6, bArr, 16 - i10, i10);
            Arrays.fill(bArr, i6, (16 - i5) + i6, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    private static boolean n(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    private static String n(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        n nVar = new n();
        while (i2 < bArr.length) {
            if (i2 == i) {
                nVar.qg(58);
                i2 += i4;
                if (i2 == 16) {
                    nVar.qg(58);
                }
            } else {
                if (i2 > 0) {
                    nVar.qg(58);
                }
                nVar.qg(((bArr[i2] & UByte.MAX_VALUE) << 8) | (bArr[i2 + 1] & UByte.MAX_VALUE));
                i2 += 2;
            }
        }
        return nVar.s();
    }

    public static boolean n(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
