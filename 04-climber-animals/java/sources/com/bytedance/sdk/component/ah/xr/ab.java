package com.bytedance.sdk.component.ah.xr;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes2.dex */
public final class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final ab f1024ms = new ms().ms();
    private final com.bytedance.sdk.component.ah.xr.ms.ny.ah ah;
    private final Set<xr> xr;

    ab(Set<xr> set, com.bytedance.sdk.component.ah.xr.ms.ny.ah ahVar) {
        this.xr = set;
        this.ah = ahVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ab)) {
            return false;
        }
        ab abVar = (ab) obj;
        return com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.ah, abVar.ah) && this.xr.equals(abVar.xr);
    }

    public int hashCode() {
        com.bytedance.sdk.component.ah.xr.ms.ny.ah ahVar = this.ah;
        return ((ahVar != null ? ahVar.hashCode() : 0) * 31) + this.xr.hashCode();
    }

    public void ms(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<xr> listMs = ms(str);
        if (listMs.isEmpty()) {
            return;
        }
        com.bytedance.sdk.component.ah.xr.ms.ny.ah ahVar = this.ah;
        if (ahVar != null) {
            list = ahVar.ms(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listMs.size();
            com.bytedance.sdk.component.ah.ms.c cVarXr = null;
            com.bytedance.sdk.component.ah.ms.c cVarMs = null;
            for (int i2 = 0; i2 < size2; i2++) {
                xr xrVar = listMs.get(i2);
                if (xrVar.ah.equals("sha256/")) {
                    if (cVarXr == null) {
                        cVarXr = xr(x509Certificate);
                    }
                    if (xrVar.d.equals(cVarXr)) {
                        return;
                    }
                } else if (xrVar.ah.equals("sha1/")) {
                    if (cVarMs == null) {
                        cVarMs = ms(x509Certificate);
                    }
                    if (xrVar.d.equals(cVarMs)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + xrVar.ah);
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ").append(ms((Certificate) x509Certificate2)).append(": ").append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ").append(str).append(":");
        int size4 = listMs.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sb.append("\n    ").append(listMs.get(i4));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    List<xr> ms(String str) {
        List<xr> listEmptyList = Collections.emptyList();
        for (xr xrVar : this.xr) {
            if (xrVar.ms(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(xrVar);
            }
        }
        return listEmptyList;
    }

    ab ms(com.bytedance.sdk.component.ah.xr.ms.ny.ah ahVar) {
        return com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.ah, ahVar) ? this : new ab(this.xr, ahVar);
    }

    public static String ms(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + xr((X509Certificate) certificate).xr();
    }

    static com.bytedance.sdk.component.ah.ms.c ms(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.ah.ms.c.ms(x509Certificate.getPublicKey().getEncoded()).ah();
    }

    static com.bytedance.sdk.component.ah.ms.c xr(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.ah.ms.c.ms(x509Certificate.getPublicKey().getEncoded()).d();
    }

    static final class xr {
        final String ah;
        final com.bytedance.sdk.component.ah.ms.c d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final String f1026ms;
        final String xr;

        boolean ms(String str) {
            if (this.f1026ms.startsWith("*.")) {
                int iIndexOf = str.indexOf(46);
                if ((str.length() - iIndexOf) - 1 != this.xr.length()) {
                    return false;
                }
                String str2 = this.xr;
                return str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length());
            }
            return str.equals(this.xr);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof xr)) {
                return false;
            }
            xr xrVar = (xr) obj;
            return this.f1026ms.equals(xrVar.f1026ms) && this.ah.equals(xrVar.ah) && this.d.equals(xrVar.d);
        }

        public int hashCode() {
            return ((((this.f1026ms.hashCode() + 527) * 31) + this.ah.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return this.ah + this.d.xr();
        }
    }

    public static final class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final List<xr> f1025ms = new ArrayList();

        public ab ms() {
            return new ab(new LinkedHashSet(this.f1025ms), null);
        }
    }
}
