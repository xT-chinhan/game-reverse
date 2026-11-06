package com.tapsdk.tapad.oaid.huawei;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.a;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HuaweiD {
    private static final byte[] a = new byte[0];
    private static final byte[] b = new byte[0];
    private static SoftReference c;

    public static final class HuaweiD1 implements Runnable {
        final HuaweiDA a;
        final String b;

        public HuaweiD1(HuaweiDA huaweiDA, String str) {
            this.a = huaweiDA;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d(this.b);
        }
    }

    public static String a(String str, String str2) {
        String strA;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        synchronized (a) {
            try {
                try {
                    strA = a(str, b(str2));
                } catch (Throwable th) {
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return strA;
    }

    public static String b(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            if (d()) {
                return c(str, bArr);
            }
        } catch (Throwable th) {
        }
        return "";
    }

    private static String c(String str, byte[] bArr) {
        byte[] bArrA;
        byte[] bArrA2;
        return (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || !d() || (bArrA2 = a(str, bArr, (bArrA = a(12)))) == null || bArrA2.length == 0) ? "" : a.a(a(bArrA), a(bArrA2));
    }

    private static boolean d() {
        return true;
    }

    private static byte[] e(Context context) {
        return a(context, f(context));
    }

    private static String f(Context context) {
        HuaweiDA huaweiDAA = HuaweiDA.a(context);
        String strH = huaweiDAA.h();
        if (!TextUtils.isEmpty(strH)) {
            return strH;
        }
        String strB = b(64);
        HuaweiE.a.execute(new HuaweiD1(huaweiDAA, strB));
        return strB;
    }

    private static byte[] d(Context context) {
        if (context == null) {
            return new byte[0];
        }
        HuaweiDA huaweiDAA = HuaweiDA.a(context);
        try {
            return a(a(e(context)).toCharArray(), a(huaweiDAA.g()));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return null;
        }
    }

    public static class HuaweiDA {
        private static final Long a = 120000L;
        private static final byte[] h = new byte[0];
        private static volatile HuaweiDA i;
        private SharedPreferences b;
        private SharedPreferences c;
        private SharedPreferences d;
        private final byte[] e = new byte[0];
        private final byte[] f = new byte[0];
        private final byte[] g = new byte[0];
        private Context j;

        private HuaweiDA(Context context) {
            this.b = null;
            this.c = null;
            this.d = null;
            try {
                this.j = context.getApplicationContext();
                Context contextA = HuaweiE.a(context);
                this.b = contextA.getSharedPreferences("identifier_sp_story_book_file", 4);
                this.c = contextA.getSharedPreferences("identifier_hiad_sp_bed_rock_file", 4);
                this.d = contextA.getSharedPreferences("identifier_hiad_sp_red_stone_file", 4);
            } catch (Throwable th) {
            }
        }

        public static HuaweiDA a(Context context) {
            HuaweiDA huaweiDA;
            if (i != null) {
                return i;
            }
            synchronized (h) {
                if (i == null) {
                    i = new HuaweiDA(context);
                }
                huaweiDA = i;
            }
            return huaweiDA;
        }

        public void b() {
            synchronized (this.g) {
                SharedPreferences sharedPreferences = this.b;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong("read_first_chapter_time", System.currentTimeMillis()).apply();
                }
            }
        }

        public boolean c() {
            synchronized (this.g) {
                SharedPreferences sharedPreferences = this.b;
                if (sharedPreferences == null) {
                    return false;
                }
                long j = sharedPreferences.getLong("read_first_chapter_time", -1L);
                if (j < 0) {
                    return false;
                }
                return j + a.longValue() > System.currentTimeMillis();
            }
        }

        public void d() {
            synchronized (this.g) {
                SharedPreferences sharedPreferences = this.b;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putBoolean("has_read_first_chapter", true).apply();
                }
            }
        }

        public boolean e() {
            boolean z;
            synchronized (this.g) {
                SharedPreferences sharedPreferences = this.b;
                z = false;
                if (sharedPreferences != null && sharedPreferences.getBoolean("has_read_first_chapter", false)) {
                    z = true;
                }
            }
            return z;
        }

        public String f() {
            String string;
            synchronized (this.e) {
                SharedPreferences sharedPreferences = this.c;
                string = sharedPreferences != null ? sharedPreferences.getString("get_a_book", null) : null;
            }
            return string;
        }

        public String g() {
            synchronized (this.g) {
                SharedPreferences sharedPreferences = this.b;
                if (sharedPreferences == null) {
                    return null;
                }
                String string = sharedPreferences.getString("catch_a_cat", null);
                if (string == null) {
                    string = HuaweiD.a(HuaweiD.a());
                    c(string);
                }
                return string;
            }
        }

        public String h() {
            String string;
            synchronized (this.g) {
                string = this.b.getString("read_second_chapter", "");
            }
            return string;
        }

        public void b(String str) {
            synchronized (this.e) {
                SharedPreferences sharedPreferences = this.c;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("get_a_book", str).apply();
                }
            }
        }

        public void d(String str) {
            synchronized (this.g) {
                this.b.edit().putString("read_second_chapter", str).apply();
            }
        }

        public void a(String str) {
            synchronized (this.f) {
                if (this.d != null) {
                    this.d.edit().putString("read_first_chapter", HuaweiD.b(str, HuaweiD.a(this.j))).apply();
                }
            }
        }

        public void c(String str) {
            synchronized (this.g) {
                SharedPreferences sharedPreferences = this.b;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("catch_a_cat", str).apply();
                }
            }
        }

        public String a() {
            synchronized (this.f) {
                SharedPreferences sharedPreferences = this.d;
                if (sharedPreferences == null) {
                    return "";
                }
                String string = sharedPreferences.getString("read_first_chapter", "");
                if (TextUtils.isEmpty(string)) {
                    return string;
                }
                return HuaweiD.a(string, HuaweiD.a(this.j));
            }
        }
    }

    private static String d(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || !d()) {
            return "";
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            String strC = c(str);
            String strD = d(str);
            if (TextUtils.isEmpty(strC) || TextUtils.isEmpty(strD)) {
                return "";
            }
            cipher.init(2, secretKeySpec, d(a(strC)));
            return new String(cipher.doFinal(a(strD)), StandardCharsets.UTF_8);
        } catch (GeneralSecurityException e) {
            e.getMessage();
            return "";
        }
    }

    private static boolean b(byte[] bArr) {
        return bArr != null && bArr.length >= 12;
    }

    private static String b(Context context) {
        String strA;
        String strA2;
        if (context == null) {
            return "";
        }
        synchronized (b) {
            HuaweiDA huaweiDAA = HuaweiDA.a(context);
            String strF = huaweiDAA.f();
            if (strF == null) {
                strA2 = a(context, huaweiDAA);
            } else {
                strA = a(strF, d(context));
                if (TextUtils.isEmpty(strA)) {
                    strA2 = a(context, huaweiDAA);
                }
            }
            strA = strA2;
        }
        return strA;
    }

    public static String a(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || str.length() < 32 || bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            if (d()) {
                return d(str, bArr);
            }
        } catch (Throwable th) {
        }
        return "";
    }

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & UByte.MAX_VALUE);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        }
        return "";
    }

    public static byte[] b() {
        return a(16);
    }

    private static String b(int i) {
        try {
            SecureRandom secureRandomC = c();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(Integer.toHexString(secureRandomC.nextInt(16)));
            }
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    private static AlgorithmParameterSpec d(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    private static String d(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    public static byte[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = upperCase.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            byte[] bArr2 = {bytes[i2]};
            Charset charset = StandardCharsets.UTF_8;
            bArr[i] = (byte) (((byte) (Byte.decode("0x".concat(new String(bArr2, charset))).byteValue() << 4)) ^ Byte.decode("0x".concat(new String(new byte[]{bytes[i2 + 1]}, charset))).byteValue());
        }
        return bArr;
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (!TextUtils.isEmpty(str) && c(bArr) && b(bArr2) && d()) {
            return a(str.getBytes(StandardCharsets.UTF_8), bArr, bArr2);
        }
        return new byte[0];
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr != null && bArr.length != 0) {
            if (bArr2 != null && bArr2.length >= 16) {
                if (!d()) {
                    return new byte[0];
                }
                if (bArr3 != null && bArr3.length >= 12) {
                    try {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                        cipher.init(1, secretKeySpec, d(bArr3));
                        return cipher.doFinal(bArr);
                    } catch (GeneralSecurityException e) {
                        e.getMessage();
                        return new byte[0];
                    }
                }
                return new byte[0];
            }
            return new byte[0];
        }
        return new byte[0];
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        c().nextBytes(bArr);
        return bArr;
    }

    public static byte[] a() {
        return a(16);
    }

    public static byte[] a(Context context) {
        byte[] bArrC;
        synchronized (b) {
            SoftReference softReference = c;
            if (softReference == null) {
                bArrC = null;
            } else {
                bArrC = (byte[]) softReference.get();
            }
            if (bArrC == null) {
                try {
                    bArrC = b(b(context));
                } catch (UnsupportedEncodingException e) {
                    bArrC = c(context);
                } catch (Throwable th) {
                    bArrC = c(context);
                }
                c = new SoftReference(bArrC);
            }
        }
        return bArrC;
    }

    private static String a(Context context, HuaweiDA huaweiDA) {
        String strA = a(b());
        huaweiDA.b(b(strA, d(context)));
        return strA;
    }

    private static SecureRandom c() {
        SecureRandom secureRandom;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                secureRandom = SecureRandom.getInstanceStrong();
            } else {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            }
        } catch (Exception e) {
            secureRandom = null;
        }
        return secureRandom == null ? new SecureRandom() : secureRandom;
    }

    private static byte[] a(Context context, String str) {
        return a(str, context.getString(R.string.tapad_huawei_identifier_hiad_str_2), context.getString(R.string.tapad_huawei_identifier_hiad_str_3));
    }

    private static byte[] a(String str, String str2, String str3) {
        byte[] bArrA = a(str);
        byte[] bArrA2 = a(str2);
        return a(a(bArrA, bArrA2), a(str3));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= bArr2.length) {
            bArr2 = bArr;
            bArr = bArr2;
        }
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length];
        int i = 0;
        while (i < length2) {
            bArr3[i] = (byte) (bArr2[i] ^ bArr[i]);
            i++;
        }
        while (i < bArr.length) {
            bArr3[i] = bArr[i];
            i++;
        }
        return bArr3;
    }

    private static boolean c(byte[] bArr) {
        return bArr != null && bArr.length >= 16;
    }

    private static byte[] c(Context context) {
        HuaweiDA.a(context).b("");
        return a(b(context));
    }

    private static String c(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        return "";
    }

    public static byte[] a(char[] cArr, byte[] bArr) throws NoSuchAlgorithmException {
        SecretKeyFactory secretKeyFactory;
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr, bArr, 10000, 256);
        if (Build.VERSION.SDK_INT > 26) {
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        } else {
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        }
        return secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
    }

    public static byte[] a(String str) {
        try {
            return b(str);
        } catch (Throwable th) {
            return new byte[0];
        }
    }
}
