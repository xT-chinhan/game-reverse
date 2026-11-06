package com.bytedance.sdk.component.ah.xr.ms.ny;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes2.dex */
public final class ms extends ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final c f1120ms;

    public ms(c cVar) {
        this.f1120ms = cVar;
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ny.ah
    public List<Certificate> ms(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        X509Certificate x509Certificate;
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate2 = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate x509CertificateMs = this.f1120ms.ms(x509Certificate2);
            if (x509CertificateMs != null) {
                if (arrayList.size() > 1 || !x509Certificate2.equals(x509CertificateMs)) {
                    arrayList.add(x509CertificateMs);
                }
                if (ms(x509CertificateMs, x509CertificateMs)) {
                    return arrayList;
                }
                z = true;
            } else {
                Iterator it = arrayDeque.iterator();
                do {
                    if (!it.hasNext()) {
                        if (z) {
                            return arrayList;
                        }
                        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed ".concat(String.valueOf(x509Certificate2)));
                    }
                    x509Certificate = (X509Certificate) it.next();
                } while (!ms(x509Certificate2, x509Certificate));
                it.remove();
                arrayList.add(x509Certificate);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: ".concat(String.valueOf(arrayList)));
    }

    private boolean ms(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public int hashCode() {
        return this.f1120ms.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ms) && ((ms) obj).f1120ms.equals(this.f1120ms);
    }
}
