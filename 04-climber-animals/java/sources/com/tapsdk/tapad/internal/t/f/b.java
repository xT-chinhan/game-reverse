package com.tapsdk.tapad.internal.t.f;

import com.tapsdk.tapad.model.entities.TapAdReq;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.RequestBody;
import okio.Buffer;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static TapAdReq.d a(RequestBody requestBody) throws IOException {
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        return TapAdReq.d.b(buffer.inputStream());
    }

    public static String a(byte[] bArr, String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(Arrays.copyOfRange(str.getBytes(), 0, 16)));
        return com.tapsdk.tapad.internal.t.b.b().a(cipher.doFinal(bArr));
    }

    public static byte[] a(String str, String str2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        byte[] bArrCopyOfRange = Arrays.copyOfRange(str2.getBytes(), 0, 16);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArrCopyOfRange));
        return cipher.doFinal(com.tapsdk.tapad.internal.t.b.b().a(str));
    }

    public static String b(String str, String str2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(Arrays.copyOfRange(str2.getBytes(), 0, 16)));
        return com.tapsdk.tapad.internal.t.b.b().a(cipher.doFinal(str.getBytes()));
    }

    public static String b(RequestBody requestBody) throws IOException {
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        return buffer.readUtf8();
    }
}
