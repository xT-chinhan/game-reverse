package com.anythink.core.common.q;

import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.common.v.k;
import com.umeng.analytics.pro.ek;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String a = "UTF-8";
    private static Map<Character, Character> b;
    private static char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static char[] d = {'5', 'P', 'V', AbstractJsonLexerKt.UNICODE_ESC, '3', 'J', 'j', 'l', 'e', 'Q', 'b', 'H', '9', 'A', 'v', 'h', 't', 's', 'g', 'W', 'I', 'C', 'U', 'i', 'F', '2', 'a', 'd', 'M', '8', 'D', 'y', 'Z', 'O', 'N', 'k', '/', '4', 'R', '7', '0', 'f', 'n', '+', 'z', 'G', 'Y', 'L', 'X', 'p', 'm', '1', 'E', 'K', 'S', 'T', 'o', 'x', '6', 'q', 'w', 'r', 'c', 'B'};
    private static byte[] e = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, com.anythink.core.common.s.a.c.c, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, ek.k, ek.l, ek.m, ek.n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    private static String f;
    private static String g;
    private static String h;

    public static b a(String str, String str2) {
        return c(str, str2);
    }

    private static b c(String str, String str2) {
        byte[] bArrDoFinal;
        b bVar = new b();
        try {
            if (TextUtils.isEmpty(g)) {
                g = k.b("UlNB");
            }
            KeyFactory keyFactory = KeyFactory.getInstance(g);
            str.getBytes();
            PublicKey publicKeyGeneratePublic = keyFactory.generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(), 2)));
            int iBitLength = publicKeyGeneratePublic instanceof RSAPublicKey ? ((RSAPublicKey) publicKeyGeneratePublic).getModulus().bitLength() : 0;
            if (TextUtils.isEmpty(h)) {
                h = k.b("UlNBL0VDQi9QS0NTMVBhZGRpbmc=");
            }
            Cipher cipher = Cipher.getInstance(h);
            cipher.init(1, publicKeyGeneratePublic);
            int i = (iBitLength / 8) - 11;
            if (i > 0) {
                bArrDoFinal = a(cipher, str2.getBytes(), i);
            } else {
                bArrDoFinal = cipher.doFinal(str2.getBytes());
            }
            bVar.a(new String(Base64.encode(bArrDoFinal, 2)));
        } catch (Throwable th) {
            bVar.b(th.getMessage());
        }
        return bVar;
    }

    private static byte[] a(Cipher cipher, byte[] bArr, int i) throws BadPaddingException, IllegalBlockSizeException, IOException {
        byte[] bArrDoFinal;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = length - i2;
            if (i4 > 0) {
                if (i4 > i) {
                    bArrDoFinal = cipher.doFinal(bArr, i2, i);
                } else {
                    bArrDoFinal = cipher.doFinal(bArr, i2, i4);
                }
                byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                i3++;
                i2 = i3 * i;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static String a(String str) {
        Character chValueOf;
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            char[] charArray = str.toCharArray();
            if (charArray != null && charArray.length > 0) {
                char[] cArr = new char[charArray.length];
                for (int i = 0; i < charArray.length; i++) {
                    char c2 = charArray[i];
                    if (b == null) {
                        b = new HashMap();
                        for (int i2 = 0; i2 < c.length; i2++) {
                            b.put(Character.valueOf(d[i2]), Character.valueOf(c[i2]));
                        }
                    }
                    if (b.containsKey(Character.valueOf(c2))) {
                        chValueOf = b.get(Character.valueOf(c2));
                    } else {
                        chValueOf = Character.valueOf(c2);
                    }
                    cArr[i] = chValueOf.charValue();
                }
                str2 = new String(cArr);
            }
            return new String(b(str2));
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    private static Character a(char c2) {
        if (b == null) {
            b = new HashMap();
            for (int i = 0; i < c.length; i++) {
                b.put(Character.valueOf(d[i]), Character.valueOf(c[i]));
            }
        }
        if (b.containsKey(Character.valueOf(c2))) {
            return b.get(Character.valueOf(c2));
        }
        return Character.valueOf(c2);
    }

    private static byte[] b(String str) {
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
                b2 = e[bytes[i5]];
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
                b3 = e[bytes[i]];
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
                b4 = e[b6];
                if (i3 >= length || b4 != -1) {
                    break;
                }
                i2 = i3;
            }
            if (b4 == -1) {
                break;
            }
            byteArrayOutputStream.write(((b3 & ek.m) << 4) | ((b4 & 60) >>> 2));
            while (true) {
                i4 = i3 + 1;
                byte b7 = bytes[i3];
                if (b7 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b5 = e[b7];
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

    public static b b(String str, String str2) {
        return a(str, str2, true);
    }

    public static b a(String str, String str2, boolean z) {
        if (z) {
            if (TextUtils.isEmpty(f)) {
                f = k.b(k.a);
            }
            str = k.a(str, f);
        }
        Object[] objArr = new Object[2];
        return c(str.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s", ""), str2);
    }
}
