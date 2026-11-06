package com.byazt.pq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 21})
public final class x {
    public static final x n = new n().n();
    public final Set<qg> qg;
    public final com.byazt.vw.s s;

    public x(Set<qg> set, com.byazt.vw.s sVar) {
        this.qg = set;
        this.s = sVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return com.byazt.zho.s.n(this.s, xVar.s) && this.qg.equals(xVar.qg);
    }

    public int hashCode() {
        com.byazt.vw.s sVar = this.s;
        return ((sVar != null ? sVar.hashCode() : 0) * 31) + this.qg.hashCode();
    }

    public void n(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<qg> listN = n(str);
        if (listN.isEmpty()) {
            return;
        }
        com.byazt.vw.s sVar = this.s;
        if (sVar != null) {
            list = sVar.n(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listN.size();
            com.byazt.wa.w wVarQg = null;
            com.byazt.wa.w wVarN = null;
            for (int i2 = 0; i2 < size2; i2++) {
                qg qgVar = listN.get(i2);
                if (qgVar.s.equals("sha256/")) {
                    if (wVarQg == null) {
                        wVarQg = qg(x509Certificate);
                    }
                    if (qgVar.q.equals(wVarQg)) {
                        return;
                    }
                } else if (qgVar.s.equals("sha1/")) {
                    if (wVarN == null) {
                        wVarN = n(x509Certificate);
                    }
                    if (qgVar.q.equals(wVarN)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + qgVar.s);
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ").append(n((Certificate) x509Certificate2)).append(": ").append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ").append(str).append(":");
        int size4 = listN.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sb.append("\n    ").append(listN.get(i4));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public List<qg> n(String str) {
        List<qg> listEmptyList = Collections.emptyList();
        for (qg qgVar : this.qg) {
            if (qgVar.n(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(qgVar);
            }
        }
        return listEmptyList;
    }

    public x n(com.byazt.vw.s sVar) {
        return com.byazt.zho.s.n(this.s, sVar) ? this : new x(this.qg, sVar);
    }

    public static String n(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + qg((X509Certificate) certificate).qg();
    }

    public static com.byazt.wa.w n(X509Certificate x509Certificate) {
        return com.byazt.wa.w.n(x509Certificate.getPublicKey().getEncoded()).s();
    }

    public static com.byazt.wa.w qg(X509Certificate x509Certificate) {
        return com.byazt.wa.w.n(x509Certificate.getPublicKey().getEncoded()).q();
    }

    @com.byazt.cp.n(n = {0, 1, 109, 1181})
    static final class qg {
        public final String n;
        public final com.byazt.wa.w q;
        public final String qg;
        public final String s;

        public boolean n(String str) {
            if (this.n.startsWith("*.")) {
                int iIndexOf = str.indexOf(46);
                if ((str.length() - iIndexOf) - 1 != this.qg.length()) {
                    return false;
                }
                String str2 = this.qg;
                return str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length());
            }
            return str.equals(this.qg);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof qg)) {
                return false;
            }
            qg qgVar = (qg) obj;
            return this.n.equals(qgVar.n) && this.s.equals(qgVar.s) && this.q.equals(qgVar.q);
        }

        public int hashCode() {
            return ((((this.n.hashCode() + 527) * 31) + this.s.hashCode()) * 31) + this.q.hashCode();
        }

        public String toString() {
            return this.s + this.q.qg();
        }
    }

    @com.byazt.cp.n(n = {0, 1, 109, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    public static final class n {
        public final List<qg> n = new ArrayList();

        public x n() {
            return new x(new LinkedHashSet(this.n), null);
        }
    }
}
