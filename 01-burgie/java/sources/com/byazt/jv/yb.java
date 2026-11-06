package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public final class yb {
    public final List<Certificate> hn;
    public final zo hw;
    public final ww pr;
    public final List<Certificate> x;

    private yb(ww wwVar, zo zoVar, List<Certificate> list, List<Certificate> list2) {
        this.pr = wwVar;
        this.hw = zoVar;
        this.hn = list;
        this.x = list2;
    }

    public static yb pr(SSLSession sSLSession) {
        String cipherSuite;
        List listEmptyList;
        List listEmptyList2;
        Certificate[] peerCertificates = null;
        try {
            cipherSuite = sSLSession.getCipherSuite();
        } catch (Exception e) {
            cipherSuite = null;
        }
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        zo zoVarPr = zo.pr(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        ww wwVarPr = ww.pr(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e2) {
        }
        if (peerCertificates != null) {
            listEmptyList = com.byazt.xx.hn.pr(peerCertificates);
        } else {
            listEmptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listEmptyList2 = com.byazt.xx.hn.pr(localCertificates);
        } else {
            listEmptyList2 = Collections.emptyList();
        }
        return new yb(wwVarPr, zoVarPr, listEmptyList, listEmptyList2);
    }

    public ww pr() {
        return this.pr;
    }

    public zo hw() {
        return this.hw;
    }

    public List<Certificate> hn() {
        return this.hn;
    }

    public List<Certificate> x() {
        return this.x;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof yb)) {
            return false;
        }
        yb ybVar = (yb) obj;
        return this.pr.equals(ybVar.pr) && this.hw.equals(ybVar.hw) && this.hn.equals(ybVar.hn) && this.x.equals(ybVar.x);
    }

    public int hashCode() {
        return ((((((this.pr.hashCode() + 527) * 31) + this.hw.hashCode()) * 31) + this.hn.hashCode()) * 31) + this.x.hashCode();
    }
}
