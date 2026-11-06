package com.byazt.yq;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mar.sdk.utils.RSAUtils;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1396, 13})
public class hw {
    public static volatile hw hw;
    public x c;
    public PublicKey x = null;
    public static String hn = "OutProcessEncryptUtils";
    public static String pr = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALo9WqslO45/EjPWz6YMAu8PBgzV9Ujk3TSQSgebYdNPLJ2u0Y69eSj5DRk7uVplC+WkdEJGznST4OXTRZyKI9ECAwEAAQ==";

    private hw() {
    }

    public static hw pr() {
        if (hw == null) {
            synchronized (hw.class) {
                if (hw == null) {
                    hw = new hw();
                }
            }
        }
        return hw;
    }

    private PublicKey hw(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (this.x == null) {
            this.x = hn(context);
        }
        return this.x;
    }

    private PublicKey hn(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return KeyFactory.getInstance(RSAUtils.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(pr, 2)));
    }

    private byte[] pr(PublicKey publicKey, byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        return cipher.doFinal(bArr);
    }

    public x pr(Context context) {
        x xVarX;
        x xVar = this.c;
        if (xVar != null) {
            return xVar;
        }
        synchronized (this) {
            xVarX = x(context);
            this.c = xVarX;
        }
        return xVarX;
    }

    private x x(Context context) {
        x xVar = new x();
        xVar.pr = hn.pr();
        xVar.hw = hn.pr();
        String str = xVar.pr + "#" + xVar.hw;
        for (int i = 2; i >= 0; i--) {
            byte[] bArrPr = pr(context, str);
            if (bArrPr != null && bArrPr.length > 0) {
                xVar.hn = Base64.encodeToString(bArrPr, 2);
            }
            if (!TextUtils.isEmpty(xVar.hn)) {
                break;
            }
        }
        return xVar;
    }

    private byte[] pr(Context context, String str) {
        try {
            return pr(hw(context), str.getBytes());
        } catch (Exception e) {
            return null;
        }
    }
}
