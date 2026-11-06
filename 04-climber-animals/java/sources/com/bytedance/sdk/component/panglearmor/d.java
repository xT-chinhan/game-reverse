package com.bytedance.sdk.component.panglearmor;

import android.util.Base64;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.sl;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static boolean f1307ms = false;

    @DungeonFlag
    private static PublicKey ms() throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    @DungeonFlag
    public static boolean ms(String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(ms().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    @DungeonFlag
    public static boolean ms(final String str) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.d.1
                @Override // java.lang.Runnable
                public void run() {
                    String hostAddress;
                    try {
                        hostAddress = InetAddress.getByName(str).getHostAddress();
                    } catch (Exception unused) {
                        hostAddress = "";
                    }
                    if (hostAddress.equals("127.0.0.1") || hostAddress.equals("::1")) {
                        boolean unused2 = d.f1307ms = true;
                    }
                }
            });
        } catch (UnsatisfiedLinkError e) {
            sl.ms(e);
        }
        return f1307ms;
    }
}
