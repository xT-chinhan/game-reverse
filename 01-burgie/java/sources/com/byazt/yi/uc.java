package com.byazt.yi;

import android.util.Base64;
import com.bumptech.glide.load.Key;
import com.byazt.vkw.qi;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.mar.sdk.utils.RSAUtils;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 586, 5})
public class uc {
    public static boolean pr = false;

    @DungeonFlag
    private static PublicKey pr() throws Exception {
        return KeyFactory.getInstance(RSAUtils.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName(Key.STRING_CHARSET_NAME)), 2)));
    }

    @DungeonFlag
    public static boolean pr(String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(RSAUtils.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(pr().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName(Key.STRING_CHARSET_NAME)), 2));
    }

    @DungeonFlag
    public static boolean pr(final String str) {
        try {
            ((qi) com.byazt.zs.uc.pr("thread_service")).x().post(new Runnable() { // from class: com.byazt.yi.uc.1
                @Override // java.lang.Runnable
                public void run() {
                    String hostAddress;
                    try {
                        hostAddress = InetAddress.getByName(str).getHostAddress();
                    } catch (Exception e) {
                        hostAddress = "";
                    }
                    if (hostAddress.equals("127.0.0.1") || hostAddress.equals("::1")) {
                        boolean unused = uc.pr = true;
                    }
                }
            });
        } catch (UnsatisfiedLinkError e) {
        }
        return pr;
    }
}
