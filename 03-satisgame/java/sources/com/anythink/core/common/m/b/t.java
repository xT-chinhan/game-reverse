package com.anythink.core.common.m.b;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class t {
    private final ai a;
    private final i b;
    private final List<Certificate> c;
    private final List<Certificate> d;

    private t(ai aiVar, i iVar, List<Certificate> list, List<Certificate> list2) {
        this.a = aiVar;
        this.b = iVar;
        this.c = list;
        this.d = list2;
    }

    public static t a(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        List listEmptyList;
        List listEmptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        i iVarA = i.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        ai aiVarA = ai.a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        if (peerCertificates != null) {
            listEmptyList = com.anythink.core.common.m.b.a.c.a(peerCertificates);
        } else {
            listEmptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listEmptyList2 = com.anythink.core.common.m.b.a.c.a(localCertificates);
        } else {
            listEmptyList2 = Collections.emptyList();
        }
        return new t(aiVarA, iVarA, listEmptyList, listEmptyList2);
    }

    public static t a(ai aiVar, i iVar, List<Certificate> list, List<Certificate> list2) {
        if (aiVar == null) {
            throw new NullPointerException("tlsVersion == null");
        }
        if (iVar == null) {
            throw new NullPointerException("cipherSuite == null");
        }
        return new t(aiVar, iVar, com.anythink.core.common.m.b.a.c.a(list), com.anythink.core.common.m.b.a.c.a(list2));
    }

    public final ai a() {
        return this.a;
    }

    public final i b() {
        return this.b;
    }

    public final List<Certificate> c() {
        return this.c;
    }

    private Principal e() {
        if (this.c.isEmpty()) {
            return null;
        }
        return ((X509Certificate) this.c.get(0)).getSubjectX500Principal();
    }

    public final List<Certificate> d() {
        return this.d;
    }

    private Principal f() {
        if (this.d.isEmpty()) {
            return null;
        }
        return ((X509Certificate) this.d.get(0)).getSubjectX500Principal();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.a.equals(tVar.a) && this.b.equals(tVar.b) && this.c.equals(tVar.c) && this.d.equals(tVar.d);
    }

    public final int hashCode() {
        return ((((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "Handshake{tlsVersion=" + this.a + " cipherSuite=" + this.b + " peerCertificates=" + a(this.c) + " localCertificates=" + a(this.d) + AbstractJsonLexerKt.END_OBJ;
    }

    private static List<String> a(List<Certificate> list) {
        ArrayList arrayList = new ArrayList();
        for (Certificate certificate : list) {
            if (certificate instanceof X509Certificate) {
                arrayList.add(String.valueOf(((X509Certificate) certificate).getSubjectDN()));
            } else {
                arrayList.add(certificate.getType());
            }
        }
        return arrayList;
    }
}
