package com.byazt.rl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
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
@com.byazt.cp.n(n = {0, 1, 488, 26})
public class qg {
    public static String n = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALo9WqslO45/EjPWz6YMAu8PBgzV9Ujk3TSQSgebYdNPLJ2u0Y69eSj5DRk7uVplC+WkdEJGznST4OXTRZyKI9ECAwEAAQ==";
    public static volatile qg qg = null;
    public static String s = "OutProcessEncryptUtils";
    public q l;
    public PublicKey q = null;

    private qg() {
    }

    public static qg n() {
        if (qg == null) {
            synchronized (qg.class) {
                if (qg == null) {
                    qg = new qg();
                }
            }
        }
        return qg;
    }

    private PublicKey qg(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (this.q == null) {
            this.q = s(context);
        }
        return this.q;
    }

    private PublicKey s(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(n, 2)));
    }

    private byte[] n(PublicKey publicKey, byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        return cipher.doFinal(bArr);
    }

    public q n(Context context) {
        q qVarQ;
        q qVar = this.l;
        if (qVar != null) {
            return qVar;
        }
        synchronized (this) {
            qVarQ = q(context);
            this.l = qVarQ;
        }
        return qVarQ;
    }

    private q q(Context context) {
        q qVar = new q();
        qVar.n = s.n();
        qVar.qg = s.n();
        String str = qVar.n + "#" + qVar.qg;
        for (int i = 2; i >= 0; i--) {
            byte[] bArrN = n(context, str);
            if (bArrN != null && bArrN.length > 0) {
                qVar.s = Base64.encodeToString(bArrN, 2);
            }
            if (!TextUtils.isEmpty(qVar.s)) {
                break;
            }
        }
        return qVar;
    }

    private byte[] n(Context context, String str) {
        try {
            return n(qg(context), str.getBytes());
        } catch (Exception unused) {
            return null;
        }
    }
}
