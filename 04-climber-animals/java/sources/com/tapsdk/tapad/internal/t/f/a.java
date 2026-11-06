package com.tapsdk.tapad.internal.t.f;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static String a(String str, String str2) throws Exception {
        if (str2 == null || str2.length() != 16) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPadding");
        int blockSize = cipher.getBlockSize();
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length % blockSize;
        int i = length % blockSize;
        if (i != 0) {
            length += blockSize - i;
        }
        int length2 = length - bytes.length;
        byte[] bArr = new byte[length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        for (int i2 = 0; i2 < length2; i2++) {
            bArr[bytes.length + i2] = 32;
        }
        cipher.init(1, secretKeySpec);
        return new String(Base64.encode(cipher.doFinal(bArr), 8));
    }
}
