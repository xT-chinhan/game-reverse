package com.byazt.pq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public final class hd {
    public final v n;
    public final List<Certificate> q;
    public final fs qg;
    public final List<Certificate> s;

    private hd(v vVar, fs fsVar, List<Certificate> list, List<Certificate> list2) {
        this.n = vVar;
        this.qg = fsVar;
        this.s = list;
        this.q = list2;
    }

    public static hd n(SSLSession sSLSession) {
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
        fs fsVarN = fs.n(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        v vVarN = v.n(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused2) {
        }
        if (peerCertificates != null) {
            listEmptyList = com.byazt.zho.s.n(peerCertificates);
        } else {
            listEmptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listEmptyList2 = com.byazt.zho.s.n(localCertificates);
        } else {
            listEmptyList2 = Collections.emptyList();
        }
        return new hd(vVarN, fsVarN, listEmptyList, listEmptyList2);
    }

    public v n() {
        return this.n;
    }

    public fs qg() {
        return this.qg;
    }

    public List<Certificate> s() {
        return this.s;
    }

    public List<Certificate> q() {
        return this.q;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof hd)) {
            return false;
        }
        hd hdVar = (hd) obj;
        return this.n.equals(hdVar.n) && this.qg.equals(hdVar.qg) && this.s.equals(hdVar.s) && this.q.equals(hdVar.q);
    }

    public int hashCode() {
        return ((((((this.n.hashCode() + 527) * 31) + this.qg.hashCode()) * 31) + this.s.hashCode()) * 31) + this.q.hashCode();
    }
}
