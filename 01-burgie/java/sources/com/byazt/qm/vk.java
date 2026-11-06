package com.byazt.qm;

import com.bumptech.glide.load.Key;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2253, 50})
public final class vk {
    public static final Charset pr = Charset.forName(Key.STRING_CHARSET_NAME);

    public static void pr(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static <T> List<T> pr(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static int pr(String str, int i, int i2) {
        while (i < i2) {
            switch (str.charAt(i)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i++;
                    break;
                default:
                    return i;
            }
        }
        return i2;
    }

    public static int hw(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    break;
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    public static int pr(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int pr(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static String pr(String str) {
        InetAddress inetAddressHn;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressHn = hn(str, 1, str.length() - 1);
            } else {
                inetAddressHn = hn(str, 0, str.length());
            }
            if (inetAddressHn == null) {
                return null;
            }
            byte[] address = inetAddressHn.getAddress();
            if (address.length == 16) {
                return pr(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            if (!str.contains("toutiao") && !str.contains("bytedance")) {
                str = IDN.toASCII(str);
            }
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.isEmpty() || hw(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static boolean hw(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static String pr(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static int pr(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0055  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f A[LOOP:1: B:30:0x0053->B:33:0x005f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:59:0x0065 A[EDGE_INSN: B:59:0x0065->B:34:0x0065 BREAK  A[LOOP:1: B:30:0x0053->B:33:0x005f], SYNTHETIC] */
    private static InetAddress hn(String str, int i, int i2) {
        int i3;
        int i4;
        int iPr;
        byte[] bArr = new byte[16];
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        while (i < i2) {
            if (i7 == 16) {
                return null;
            }
            int i8 = i + 2;
            if (i8 <= i2 && str.regionMatches(i, "::", 0, 2)) {
                if (i5 != -1) {
                    return null;
                }
                i7 += 2;
                i5 = i7;
                if (i8 == i2) {
                    break;
                }
                i6 = i8;
                i3 = 0;
                i = i6;
                while (i < i2) {
                    iPr = pr(str.charAt(i));
                    if (iPr != -1) {
                        break;
                        break;
                    }
                    i3 = (i3 << 4) + iPr;
                    i++;
                }
                i4 = i - i6;
                if (i4 != 0) {
                }
                return null;
            }
            if (i7 == 0) {
                i6 = i;
            } else if (str.regionMatches(i, ":", 0, 1)) {
                i6 = i + 1;
            } else {
                if (!str.regionMatches(i, ".", 0, 1) || !pr(str, i6, i2, bArr, i7 - 2)) {
                    return null;
                }
                i7 += 2;
                break;
            }
            i3 = 0;
            i = i6;
            while (i < i2) {
                iPr = pr(str.charAt(i));
                if (iPr != -1) {
                    break;
                }
                i3 = (i3 << 4) + iPr;
                i++;
            }
            i4 = i - i6;
            if (i4 != 0 || i4 > 4) {
                return null;
            }
            int i9 = i7 + 1;
            bArr[i7] = (byte) ((i3 >>> 8) & 255);
            i7 = i9 + 1;
            bArr[i9] = (byte) (i3 & 255);
        }
        if (i7 != 16) {
            if (i5 == -1) {
                return null;
            }
            int i10 = i7 - i5;
            System.arraycopy(bArr, i5, bArr, 16 - i10, i10);
            Arrays.fill(bArr, i5, (16 - i7) + i5, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError();
        }
    }

    private static boolean pr(String str, int i, int i2, byte[] bArr, int i3) {
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
        if (i4 != i3 + 4) {
            return false;
        }
        return true;
    }

    private static String pr(byte[] bArr) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i2 = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        pr prVar = new pr();
        while (i < bArr.length) {
            if (i == i2) {
                prVar.hw(58);
                i += i4;
                if (i == 16) {
                    prVar.hw(58);
                }
            } else {
                if (i > 0) {
                    prVar.hw(58);
                }
                prVar.hw(((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i + 1] & UByte.MAX_VALUE));
                i += 2;
            }
        }
        return prVar.hn();
    }

    public static boolean pr(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
