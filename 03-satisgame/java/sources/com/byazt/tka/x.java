package com.byazt.tka;

import android.util.Base64;
import com.byazt.vf.wo;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 689, 21})
public class x {
    public static boolean n = false;

    @DungeonFlag
    private static PublicKey n() throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    @DungeonFlag
    public static boolean n(String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(n().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    @DungeonFlag
    public static boolean n(final String str) {
        try {
            ((wo) com.byazt.qp.q.n("thread_service")).q().post(new Runnable() { // from class: com.byazt.tka.x.1
                @Override // java.lang.Runnable
                public void run() {
                    String hostAddress;
                    try {
                        hostAddress = InetAddress.getByName(str).getHostAddress();
                    } catch (Exception unused) {
                        hostAddress = "";
                    }
                    if (hostAddress.equals("127.0.0.1") || hostAddress.equals("::1")) {
                        boolean unused2 = x.n = true;
                    }
                }
            });
        } catch (UnsatisfiedLinkError unused) {
        }
        return n;
    }
}
