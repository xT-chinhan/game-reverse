package com.bytedance.sdk.component.ah.xr;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    private final List<Certificate> ah;
    private final List<Certificate> d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final p f1042ms;
    private final x xr;

    private h(p pVar, x xVar, List<Certificate> list, List<Certificate> list2) {
        this.f1042ms = pVar;
        this.xr = xVar;
        this.ah = list;
        this.d = list2;
    }

    public static h ms(SSLSession sSLSession) {
        String cipherSuite;
        List listEmptyList;
        List listEmptyList2;
        Certificate[] peerCertificates = null;
        try {
            cipherSuite = sSLSession.getCipherSuite();
        } catch (Exception unused) {
            cipherSuite = null;
        }
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        x xVarMs = x.ms(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        p pVarMs = p.ms(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused2) {
        }
        if (peerCertificates != null) {
            listEmptyList = com.bytedance.sdk.component.ah.xr.ms.ah.ms(peerCertificates);
        } else {
            listEmptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listEmptyList2 = com.bytedance.sdk.component.ah.xr.ms.ah.ms(localCertificates);
        } else {
            listEmptyList2 = Collections.emptyList();
        }
        return new h(pVarMs, xVarMs, listEmptyList, listEmptyList2);
    }

    public p ms() {
        return this.f1042ms;
    }

    public x xr() {
        return this.xr;
    }

    public List<Certificate> ah() {
        return this.ah;
    }

    public List<Certificate> d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f1042ms.equals(hVar.f1042ms) && this.xr.equals(hVar.xr) && this.ah.equals(hVar.ah) && this.d.equals(hVar.d);
    }

    public int hashCode() {
        return ((((((this.f1042ms.hashCode() + 527) * 31) + this.xr.hashCode()) * 31) + this.ah.hashCode()) * 31) + this.d.hashCode();
    }
}
