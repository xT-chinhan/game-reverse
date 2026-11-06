package com.byazt.fcl;

import android.text.TextUtils;
import android.util.Base64;
import com.byazt.ehw.w;
import com.byazt.so.x;
import com.byazt.vgx.s;
import com.taptap.sdk.core.internal.event.iap.lib2plus.BillingClientConstants;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2488, 19})
public class n {
    public static void n(x xVar, int i, String str, int i2) throws Exception {
        if (xVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (i2 != 2 && i2 != 3) {
            String[] strArrN = w.n(true, s.l());
            jSONObject.put("ipv4List", strArrN[0]);
            jSONObject.put("ipv6List", strArrN[1]);
        }
        jSONObject.put("networkType", String.valueOf(i));
        jSONObject.put(BillingClientConstants.PACKAGE_NAME, str);
        String string = jSONObject.toString();
        byte[] bArrN = n(16);
        String strN = n(bArrN, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkzi87lcyX1t/OSjlmjmj\nUFTAb0Y0wPZ79j10sjVrDtV+lMZXz/hOalITFyXRpmS8g8I1H3AlhihQQsierIFa\nQj5omUsXhzvNO+4DorkMJ14n1o1sfL0iOLTrzydghuUpyspj0M8v5bJTBbLv8DGM\nreKtJ8sbIYC5aj8pAdxn+YTnZ4Rhp/pNRbmIAlxs4Btu3whJt/RTfEASgsDRaTgO\nr9Rlj2YDiyEM4T3d0LsLjNed7B0Ogulzj6OzvHj+foIyb+YEEn6C5F9r+uNY2l2i\nYlHfaizd1HKfISrcAseJu6lGKRP0I3mv538Twqg1u0DFV6waQ9gwgOhq4ORCiNpd\nIQIDAQAB");
        String strN2 = n(string.getBytes(), bArrN);
        xVar.n("sdkSecret", strN);
        xVar.n("sdkData", strN2);
    }

    public static String n(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, new SecretKeySpec(bArr2, "AES"), new GCMParameterSpec(128, Arrays.copyOf(bArr2, 12)));
        return Base64.encodeToString(cipher.doFinal(bArr), 2);
    }

    public static String n(byte[] bArr, String str) throws Exception {
        if (bArr == null || TextUtils.isEmpty(str)) {
            return null;
        }
        RSAPublicKey rSAPublicKeyN = n(str);
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(1, rSAPublicKeyN);
        return Base64.encodeToString(n(bArr, cipher, (rSAPublicKeyN.getModulus().bitLength() / 8) - 66), 2);
    }

    private static RSAPublicKey n(String str) throws Exception {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
    }

    private static byte[] n(byte[] bArr, Cipher cipher, int i) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int length = bArr.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = length - i2;
                if (i4 > 0) {
                    byte[] bArrDoFinal = cipher.doFinal(bArr, i2, Math.min(i4, i));
                    byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                    i3++;
                    i2 = i3 * i;
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static byte[] n(int i) {
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
