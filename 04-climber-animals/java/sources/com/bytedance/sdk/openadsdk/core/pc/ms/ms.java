package com.bytedance.sdk.openadsdk.core.pc.ms;

import android.util.Base64;
import com.taptap.sdk.kit.internal.http.TapHttpUtil;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final byte[] f3276ms = "0000000000000000".getBytes();

    public static String ms(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), TapHttpUtil.HMAC_SHA1);
            Mac mac = Mac.getInstance(TapHttpUtil.HMAC_SHA1);
            mac.init(secretKeySpec);
            return com.bytedance.sdk.component.utils.ka.ms(mac.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String ms(byte[] bArr, String str) {
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
            cipher.init(1, rSAPublicKey);
            return com.bytedance.sdk.component.utils.ka.ms(cipher.doFinal(bArr));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String ms(boolean z, byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f3276ms);
            if (z) {
                cipher.init(1, secretKeySpec, ivParameterSpec);
            } else {
                cipher.init(2, secretKeySpec, ivParameterSpec);
            }
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            if (z) {
                return com.bytedance.sdk.component.utils.ka.ms(bArrDoFinal);
            }
            return new String(bArrDoFinal);
        } catch (Exception unused) {
            return "";
        }
    }
}
