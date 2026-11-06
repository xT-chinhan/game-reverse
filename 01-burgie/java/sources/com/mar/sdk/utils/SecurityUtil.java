package com.mar.sdk.utils;

import com.bumptech.glide.load.Key;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SecurityUtil {
    public static final String BASE_TABLE = "0123456789ABCDEF";

    protected abstract byte[] decrypt(byte[] bArr, byte[] bArr2);

    protected abstract byte[] encrypt(byte[] bArr, byte[] bArr2);

    public byte[] hexStringToByte(String hex) {
        int len = hex.length() / 2;
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) ((toByte(achar[pos]) << 4) | toByte(achar[pos + 1]));
        }
        return result;
    }

    private byte toByte(char c) {
        byte b = (byte) BASE_TABLE.indexOf(c);
        return b;
    }

    public final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        for (byte b : bArray) {
            String sTemp = Integer.toHexString(b & UByte.MAX_VALUE);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    public String encryptToBase64(String key, String src, String encoding) {
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(encrypt(key.getBytes(), src.getBytes(encoding)));
        } catch (Exception e) {
            return null;
        }
    }

    public String decryptFromBase64(String key, String src, String encoding) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            return new String(decrypt(key.getBytes(), decoder.decodeBuffer(src)), encoding);
        } catch (Exception e) {
            return null;
        }
    }

    public String encryptToBase64UTF8(String key, String src) {
        return encryptToBase64(key, src, Key.STRING_CHARSET_NAME);
    }

    public String decryptFromBase64UTF8(String key, String src) {
        return decryptFromBase64(key, src, Key.STRING_CHARSET_NAME);
    }

    public String encryptToBase64DefaultEncoding(String key, String src) {
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(encrypt(key.getBytes(), src.getBytes()));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String decryptFromBase64DefaultEncoding(String key, String src) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            return new String(decrypt(key.getBytes(), decoder.decodeBuffer(src)));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String encryptToHex(String key, String src, String encoding) {
        try {
            return bytesToHexString(encrypt(key.getBytes(), src.getBytes(encoding)));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String decryptFromHex(String key, String src, String encoding) {
        try {
            return new String(decrypt(key.getBytes(), hexStringToByte(src)), encoding);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String encryptToHexUTF8(String key, String src) {
        return encryptToHex(key, src, Key.STRING_CHARSET_NAME);
    }

    public String decryptFromHexUTF8(String key, String src) {
        return decryptFromHex(key, src, Key.STRING_CHARSET_NAME);
    }

    public String encryptToHexDefaultEncoding(String key, String src) {
        try {
            return bytesToHexString(encrypt(key.getBytes(), src.getBytes()));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String decryptFromHexDefaultEncoding(String key, String src) {
        try {
            return new String(decrypt(key.getBytes(), hexStringToByte(src)));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String decodeBase64(String str) {
        if ("".equals(str) && str == null) {
            return null;
        }
        try {
            byte[] b = new BASE64Decoder().decodeBuffer(str);
            return new String(b);
        } catch (IOException e) {
            return null;
        }
    }

    public static String encodeBase64(String src) {
        return ("".equals(src) || src == null) ? new BASE64Encoder().encode("N".getBytes()) : new BASE64Encoder().encode(src.getBytes());
    }
}
