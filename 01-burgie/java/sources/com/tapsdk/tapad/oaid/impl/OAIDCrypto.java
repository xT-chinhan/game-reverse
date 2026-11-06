package com.tapsdk.tapad.oaid.impl;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class OAIDCrypto {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String SALT = "TapAD_OAID_Cr7pt";
    private static volatile String[] cachedEntry;

    private OAIDCrypto() {
    }

    public static String decrypt(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null && str2.length() == 16) {
            try {
                Charset charset = StandardCharsets.UTF_8;
                byte[] bytes = str2.getBytes(charset);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes);
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return new String(cipher.doFinal(Base64.decode(str, 10)), charset);
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static String deriveKey(String str) {
        if (str == null) {
            return null;
        }
        String[] strArr = cachedEntry;
        if (strArr != null && str.equals(strArr[0])) {
            return strArr[1];
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.concat(SALT).getBytes(StandardCharsets.UTF_8));
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Integer.valueOf(b & UByte.MAX_VALUE)));
            }
            String strSubstring = sb.substring(0, 16);
            cachedEntry = new String[]{str, strSubstring};
            return strSubstring;
        } catch (Exception e) {
            return null;
        }
    }

    public static String encrypt(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null && str2.length() == 16) {
            try {
                Charset charset = StandardCharsets.UTF_8;
                byte[] bytes = str2.getBytes(charset);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes);
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return Base64.encodeToString(cipher.doFinal(str.getBytes(charset)), 10);
            } catch (Exception e) {
            }
        }
        return null;
    }
}
