package com.anythink.core.common.u;

import android.text.TextUtils;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class ah {
    public static final byte[] a;
    public static final byte[] b;
    private static final String c = "TcpEnvelopeUtil";
    private static final Charset d;
    private static final String e = "9dc9db6c31b95a9e373cbc4894b58722515dff4a9b64e2d461d4ba9ffaf53124";
    private static final String f = "HmacSHA256";

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        d = charsetForName;
        a = "api/v1/mac".getBytes(charsetForName);
        b = "bid/v1/mac".getBytes(charsetForName);
    }

    private ah() {
    }

    public static String a(String str, String str2, String str3, String str4, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && str2 != null && str4 != null && bArr != null) {
            try {
                Charset charset = d;
                return a(a(a(e.getBytes(charset), str.getBytes(charset), bArr), (str2 + str3 + str4).getBytes(charset)));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArrA = a(bArr2, bArr);
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + 1);
        bArrCopyOf[bArr3.length] = 1;
        return Arrays.copyOf(a(bArrA, bArrCopyOf), 32);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(bArr, "HmacSHA256"));
        return mac.doFinal(bArr2);
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 2;
            cArr2[i3] = cArr[i2 >>> 4];
            cArr2[i3 + 1] = cArr[i2 & 15];
        }
        return new String(cArr2);
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;

        /* synthetic */ b(String str, String str2, String str3, byte b) {
            this(str, str2, str3);
        }

        private b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    public static b a(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            a aVar = new a(str);
            aVar.c();
            if (!aVar.a(AbstractJsonLexerKt.BEGIN_OBJ)) {
                return null;
            }
            String strSubstring = null;
            String strSubstring2 = null;
            String strSubstring3 = null;
            while (true) {
                aVar.c();
                if (aVar.a() == '}') {
                    aVar.b();
                    break;
                }
                if (aVar.a() != '\"') {
                    string = null;
                    break;
                }
                aVar.b++;
                StringBuilder sb = new StringBuilder();
                while (true) {
                    if (aVar.b < aVar.a.length()) {
                        String str2 = aVar.a;
                        int i = aVar.b;
                        aVar.b = i + 1;
                        char cCharAt = str2.charAt(i);
                        if (cCharAt == '\\') {
                            if (aVar.b < aVar.a.length()) {
                                String str3 = aVar.a;
                                int i2 = aVar.b;
                                aVar.b = i2 + 1;
                                char cCharAt2 = str3.charAt(i2);
                                if (cCharAt2 == '\"') {
                                    sb.append('\"');
                                } else if (cCharAt2 == '/') {
                                    sb.append('/');
                                } else if (cCharAt2 == '\\') {
                                    sb.append(AbstractJsonLexerKt.STRING_ESC);
                                } else if (cCharAt2 == 'b') {
                                    sb.append('\b');
                                } else if (cCharAt2 == 'f') {
                                    sb.append('\f');
                                } else if (cCharAt2 == 'n') {
                                    sb.append('\n');
                                } else if (cCharAt2 == 'r') {
                                    sb.append('\r');
                                } else if (cCharAt2 == 't') {
                                    sb.append('\t');
                                } else if (cCharAt2 == 'u' && aVar.b + 4 <= aVar.a.length()) {
                                    sb.append((char) Integer.parseInt(aVar.a.substring(aVar.b, aVar.b + 4), 16));
                                    aVar.b += 4;
                                }
                            }
                        } else {
                            if (cCharAt == '\"') {
                                string = sb.toString();
                                break;
                            }
                            sb.append(cCharAt);
                        }
                    }
                    string = null;
                    break;
                }
                if (string != null) {
                    aVar.c();
                    if (!aVar.a(AbstractJsonLexerKt.COLON)) {
                        return null;
                    }
                    aVar.c();
                    int i3 = aVar.b;
                    if (!aVar.d()) {
                        return null;
                    }
                    int i4 = aVar.b;
                    if ("h".equals(string)) {
                        if (str.charAt(i3) != '{') {
                            return null;
                        }
                        strSubstring = str.substring(i3, i4);
                    } else if ("b".equals(string)) {
                        if (str.charAt(i3) != '{') {
                            return null;
                        }
                        strSubstring2 = str.substring(i3, i4);
                    } else if ("mac".equals(string)) {
                        if (i4 - i3 >= 2 && str.charAt(i3) == '\"') {
                            int i5 = i4 - 1;
                            if (str.charAt(i5) == '\"') {
                                strSubstring3 = str.substring(i3 + 1, i5);
                            }
                        }
                        return null;
                    }
                    aVar.c();
                    char cA = aVar.a();
                    if (cA != ',') {
                        if (cA == '}') {
                            aVar.b();
                            break;
                        }
                    } else {
                        aVar.b();
                    }
                } else {
                    return null;
                }
            }
            if (strSubstring != null && strSubstring2 != null && strSubstring3 != null) {
                return new b(strSubstring, strSubstring2, strSubstring3, (byte) 0);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String a(String str, String str2, String str3, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && str2 != null && str3 != null && bArr != null) {
            try {
                Charset charset = d;
                return a(a(a(e.getBytes(charset), str.getBytes(charset), bArr), (str2 + str3).getBytes(charset)));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static boolean a(String str, String str2) {
        if (str != null && str2 != null && str.length() == str2.length() && (str.length() & 1) == 0) {
            try {
                return MessageDigest.isEqual(c(str), c(str2));
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String path = new URL(str).getPath();
            if (TextUtils.isEmpty(path)) {
                return null;
            }
            return path;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int iDigit = Character.digit(str.charAt(i2), 16);
            int iDigit2 = Character.digit(str.charAt(i2 + 1), 16);
            if (iDigit < 0 || iDigit2 < 0) {
                throw new NumberFormatException("invalid hex");
            }
            bArr[i] = (byte) (iDigit2 | (iDigit << 4));
        }
        return bArr;
    }

    private static final class a {
        final String a;
        int b = 0;

        a(String str) {
            this.a = str;
        }

        final char a() {
            if (this.b < this.a.length()) {
                return this.a.charAt(this.b);
            }
            return (char) 0;
        }

        final void b() {
            if (this.b < this.a.length()) {
                this.b++;
            }
        }

        final void c() {
            while (this.b < this.a.length() && Character.isWhitespace(this.a.charAt(this.b))) {
                this.b++;
            }
        }

        final boolean a(char c) {
            if (this.b >= this.a.length() || this.a.charAt(this.b) != c) {
                return false;
            }
            this.b++;
            return true;
        }

        private String e() {
            if (a() != '\"') {
                return null;
            }
            this.b++;
            StringBuilder sb = new StringBuilder();
            while (this.b < this.a.length()) {
                String str = this.a;
                int i = this.b;
                this.b = i + 1;
                char cCharAt = str.charAt(i);
                if (cCharAt == '\\') {
                    if (this.b >= this.a.length()) {
                        return null;
                    }
                    String str2 = this.a;
                    int i2 = this.b;
                    this.b = i2 + 1;
                    char cCharAt2 = str2.charAt(i2);
                    if (cCharAt2 == '\"') {
                        sb.append('\"');
                    } else if (cCharAt2 == '/') {
                        sb.append('/');
                    } else if (cCharAt2 == '\\') {
                        sb.append(AbstractJsonLexerKt.STRING_ESC);
                    } else if (cCharAt2 == 'b') {
                        sb.append('\b');
                    } else if (cCharAt2 == 'f') {
                        sb.append('\f');
                    } else if (cCharAt2 == 'n') {
                        sb.append('\n');
                    } else if (cCharAt2 == 'r') {
                        sb.append('\r');
                    } else if (cCharAt2 == 't') {
                        sb.append('\t');
                    } else {
                        if (cCharAt2 != 'u' || this.b + 4 > this.a.length()) {
                            return null;
                        }
                        String str3 = this.a;
                        int i3 = this.b;
                        sb.append((char) Integer.parseInt(str3.substring(i3, i3 + 4), 16));
                        this.b += 4;
                    }
                } else {
                    if (cCharAt == '\"') {
                        return sb.toString();
                    }
                    sb.append(cCharAt);
                }
            }
            return null;
        }

        final boolean d() {
            char cCharAt;
            if (this.b >= this.a.length()) {
                return false;
            }
            char cCharAt2 = this.a.charAt(this.b);
            if (cCharAt2 == '{') {
                return a(AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ);
            }
            if (cCharAt2 == '[') {
                return a(AbstractJsonLexerKt.BEGIN_LIST, AbstractJsonLexerKt.END_LIST);
            }
            if (cCharAt2 == '\"') {
                if (a() == '\"') {
                    this.b++;
                    loop0: while (true) {
                        boolean z = false;
                        while (this.b < this.a.length()) {
                            String str = this.a;
                            int i = this.b;
                            this.b = i + 1;
                            char cCharAt3 = str.charAt(i);
                            if (!z) {
                                if (cCharAt3 == '\\') {
                                    z = true;
                                } else if (cCharAt3 == '\"') {
                                    return true;
                                }
                            }
                        }
                        break loop0;
                    }
                }
                return false;
            }
            int i2 = this.b;
            while (this.b < this.a.length() && (cCharAt = this.a.charAt(this.b)) != ',' && cCharAt != '}' && cCharAt != ']' && !Character.isWhitespace(cCharAt)) {
                this.b++;
            }
            return this.b > i2;
        }

        private boolean a(char c, char c2) {
            boolean z = false;
            boolean z2 = false;
            int i = 0;
            while (this.b < this.a.length()) {
                String str = this.a;
                int i2 = this.b;
                this.b = i2 + 1;
                char cCharAt = str.charAt(i2);
                if (z) {
                    if (z2) {
                        z2 = false;
                    } else if (cCharAt == '\\') {
                        z2 = true;
                    } else if (cCharAt == '\"') {
                        z = false;
                    }
                } else if (cCharAt == '\"') {
                    z = true;
                } else if (cCharAt == c) {
                    i++;
                } else if (cCharAt == c2 && (i = i - 1) == 0) {
                    return true;
                }
            }
            return false;
        }

        private boolean f() {
            if (a() != '\"') {
                return false;
            }
            this.b++;
            while (true) {
                boolean z = false;
                while (this.b < this.a.length()) {
                    String str = this.a;
                    int i = this.b;
                    this.b = i + 1;
                    char cCharAt = str.charAt(i);
                    if (!z) {
                        if (cCharAt == '\\') {
                            z = true;
                        } else if (cCharAt == '\"') {
                            return true;
                        }
                    }
                }
                return false;
            }
        }

        private boolean g() {
            char cCharAt;
            int i = this.b;
            while (this.b < this.a.length() && (cCharAt = this.a.charAt(this.b)) != ',' && cCharAt != '}' && cCharAt != ']' && !Character.isWhitespace(cCharAt)) {
                this.b++;
            }
            return this.b > i;
        }
    }
}
