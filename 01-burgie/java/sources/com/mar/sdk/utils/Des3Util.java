package com.mar.sdk.utils;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class Des3Util extends SecurityUtil {
    private static final String ALGORITHM = "DESede";

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("eqBa3eHPhBiDlqS1zakp9Ee1".length());
        System.out.println("加密后：eqBa3eHPhBiDlqS1zakp9Ee1u4INk/6LEKFey8rLSXKFVPIQmOsehmdn9bT2Wd/tcZ+/x8Z5rAvADGrnHrK9FyPxDEIBntInJqDxOThoPAoNzlI9O+qdBKH1/NMXnXEqQHQ=");
        String decryResult = decrypt("eqBa3eHPhBiDlqS1zakp9Ee1u4INk/6LEKFey8rLSXKFVPIQmOsehmdn9bT2Wd/tcZ+/x8Z5rAvADGrnHrK9FyPxDEIBntInJqDxOThoPAoNzlI9O+qdBKH1/NMXnXEqQHQ=", "eqBa3eHPhBiDlqS1zakp9Ee1");
        System.out.println("解密后：" + decryResult);
        System.out.println("解密后：" + decrypt("u4INk/6LEKFey8rLSXKFVPIQmOsehmdn9bT2Wd/tcZ+/x8Z5rAvADGrnHrK9FyPxDEIBntInJqDxOThoPAoNzlI9O+qdBKH1/NMXnXEqQHQ=", "eqBa3eHPhBiDlqS1zakp9Ee1"));
    }

    @Override // com.mar.sdk.utils.SecurityUtil
    public byte[] encrypt(byte[] keybyte, byte[] src) {
        try {
            SecretKey deskey = new SecretKeySpec(keybyte, ALGORITHM);
            Cipher c1 = Cipher.getInstance(ALGORITHM);
            c1.init(1, deskey);
            return c1.doFinal(src);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.mar.sdk.utils.SecurityUtil
    public byte[] decrypt(byte[] keybyte, byte[] src) {
        try {
            SecretKey deskey = new SecretKeySpec(keybyte, ALGORITHM);
            Cipher c1 = Cipher.getInstance(ALGORITHM);
            c1.init(2, deskey);
            return c1.doFinal(src);
        } catch (Exception e) {
            return null;
        }
    }

    public static String decrypt(String args, String key) {
        try {
            Des3Util d3u = new Des3Util();
            return d3u.decryptFromBase64(key, args, Key.STRING_CHARSET_NAME);
        } catch (Exception e) {
            return null;
        }
    }

    public static String decryptForUserToken(String args, String key) {
        try {
            Des3Util d3u = new Des3Util();
            return d3u.decryptFromBase64(key, args, Key.STRING_CHARSET_NAME);
        } catch (Exception e) {
            return null;
        }
    }

    public static String encrypt(String body, String key) {
        try {
            Des3Util d3u = new Des3Util();
            return filter(d3u.encryptToBase64(key, body, Key.STRING_CHARSET_NAME));
        } catch (Exception e) {
            return null;
        }
    }

    public static String getSigned(String buf) {
        try {
            byte[] input = buf.getBytes(Key.STRING_CHARSET_NAME);
            MessageDigest alga = MessageDigest.getInstance("MD5");
            alga.update(input);
            byte[] md5Hash = alga.digest();
            if (md5Hash != null) {
                return new BASE64Encoder().encode(md5Hash);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static String filter(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            int asc = str.charAt(i);
            if (asc != 10 && asc != 13) {
                sb.append(str.subSequence(i, i + 1));
            }
        }
        String output = new String(sb);
        return output;
    }
}
