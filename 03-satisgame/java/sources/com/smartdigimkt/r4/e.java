package com.smartdigimkt.r4;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import kotlin.UByte;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static final char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    public static final byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, com.anythink.core.common.r.a.c.c, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    public static String c = "";
    public static final HashMap d = new HashMap();

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : new String(c(str));
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : a(str.getBytes());
    }

    public static byte[] c(String str) {
        int i;
        byte b2;
        int i2;
        byte b3;
        int i3;
        byte b4;
        int i4;
        byte b5;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i5 = 0;
        while (i5 < length) {
            while (true) {
                i = i5 + 1;
                b2 = b[bytes[i5]];
                if (i >= length || b2 != -1) {
                    break;
                }
                i5 = i;
            }
            if (b2 == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                b3 = b[bytes[i]];
                if (i2 >= length || b3 != -1) {
                    break;
                }
                i = i2;
            }
            if (b3 == -1) {
                break;
            }
            byteArrayOutputStream.write((b2 << 2) | ((b3 & 48) >>> 4));
            while (true) {
                i3 = i2 + 1;
                byte b6 = bytes[i2];
                if (b6 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b4 = b[b6];
                if (i3 >= length || b4 != -1) {
                    break;
                }
                i2 = i3;
            }
            if (b4 == -1) {
                break;
            }
            byteArrayOutputStream.write(((b3 & 15) << 4) | ((b4 & 60) >>> 2));
            while (true) {
                i4 = i3 + 1;
                byte b7 = bytes[i3];
                if (b7 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b5 = b[b7];
                if (i4 >= length || b5 != -1) {
                    break;
                }
                i3 = i4;
            }
            if (b5 == -1) {
                break;
            }
            byteArrayOutputStream.write(b5 | ((b4 & 3) << 6));
            i5 = i4;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strA = a(str.getBytes());
        if (TextUtils.isEmpty(c)) {
            c = a("ZE1XbmhiZXlLcjBKSXZMTk94M0JGa0V1bWw5Mlk1ZmpTcUdUN1I4cFpWY2lQSEFzdEM0VVhhNlFEdzFnb3orLw==");
        }
        StringBuilder sb = new StringBuilder();
        for (char cCharAt : strA.toCharArray()) {
            int i = 0;
            while (true) {
                char[] cArr = a;
                if (i >= 64) {
                    break;
                }
                if (cArr[i] == cCharAt && i < c.length()) {
                    cCharAt = c.charAt(i);
                    break;
                }
                i++;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String strA = a(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(strA.length());
            for (char cCharAt : strA.toCharArray()) {
                int i = 0;
                while (true) {
                    char[] cArr = a;
                    if (i >= 64) {
                        break;
                    }
                    if (cArr[i] == cCharAt && i < 64) {
                        cCharAt = "dMWnhbeyKr0JIvLNOx3BFkEuml92Y5fjSqGT7R8pZVciPHAstC4UXa6QDw1goz+/".charAt(i);
                        break;
                    }
                    i++;
                }
                sb.append(cCharAt);
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            char[] charArray = str.toCharArray();
            if (charArray != null && charArray.length > 0) {
                char[] cArr = new char[charArray.length];
                for (int i = 0; i < charArray.length; i++) {
                    cArr[i] = a(charArray[i]).charValue();
                }
                str2 = new String(cArr);
            }
            return new String(c(str2));
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            byte b2 = bArr[i];
            int i3 = b2 & UByte.MAX_VALUE;
            if (i2 == length) {
                char[] cArr = a;
                stringBuffer.append(cArr[i3 >>> 2]);
                stringBuffer.append(cArr[(b2 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i + 2;
            byte b3 = bArr[i2];
            if (i4 == length) {
                char[] cArr2 = a;
                stringBuffer.append(cArr2[i3 >>> 2]);
                stringBuffer.append(cArr2[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
                stringBuffer.append(cArr2[(b3 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i += 3;
            byte b4 = bArr[i4];
            char[] cArr3 = a;
            stringBuffer.append(cArr3[i3 >>> 2]);
            stringBuffer.append(cArr3[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
            stringBuffer.append(cArr3[((b3 & 15) << 2) | ((b4 & 192) >>> 6)]);
            stringBuffer.append(cArr3[b4 & com.anythink.core.common.r.a.c.c]);
        }
        return stringBuffer.toString();
    }

    public static synchronized Character a(char c2) {
        String str = null;
        if (TextUtils.isEmpty(null)) {
            if (TextUtils.isEmpty(c)) {
                c = a("ZE1XbmhiZXlLcjBKSXZMTk94M0JGa0V1bWw5Mlk1ZmpTcUdUN1I4cFpWY2lQSEFzdEM0VVhhNlFEdzFnb3orLw==");
            }
            str = c;
        }
        HashMap map = (HashMap) d.get(str);
        if (map == null) {
            map = new HashMap();
            if (str.length() >= 64) {
                int i = 0;
                while (true) {
                    char[] cArr = a;
                    if (i >= 64) {
                        break;
                    }
                    map.put(Character.valueOf(str.charAt(i)), Character.valueOf(cArr[i]));
                    i++;
                }
                d.put(str, map);
            }
        }
        if (map.containsKey(Character.valueOf(c2))) {
            return (Character) map.get(Character.valueOf(c2));
        }
        return Character.valueOf(c2);
    }
}
