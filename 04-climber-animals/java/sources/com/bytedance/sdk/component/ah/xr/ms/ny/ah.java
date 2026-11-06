package com.bytedance.sdk.component.ah.xr.ms.ny;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah {
    public abstract List<Certificate> ms(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    public static ah ms(X509TrustManager x509TrustManager) {
        return com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().ms(x509TrustManager);
    }
}
