package com.bytedance.sdk.component.ah.xr.ms.ny;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
public final class xr implements c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Map<X500Principal, Set<X509Certificate>> f1121ms = new LinkedHashMap();

    public xr(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> linkedHashSet = this.f1121ms.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>(1);
                this.f1121ms.put(subjectX500Principal, linkedHashSet);
            }
            linkedHashSet.add(x509Certificate);
        }
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ny.c
    public X509Certificate ms(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.f1121ms.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof xr) && ((xr) obj).f1121ms.equals(this.f1121ms);
    }

    public int hashCode() {
        return this.f1121ms.hashCode();
    }
}
