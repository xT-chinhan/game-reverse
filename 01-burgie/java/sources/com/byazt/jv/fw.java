package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 62})
public final class fw {
    public static final fw pr = new pr().pr();
    public final com.byazt.di.hn hn;
    public final Set<hw> hw;

    public fw(Set<hw> set, com.byazt.di.hn hnVar) {
        this.hw = set;
        this.hn = hnVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fw)) {
            return false;
        }
        fw fwVar = (fw) obj;
        return com.byazt.xx.hn.pr(this.hn, fwVar.hn) && this.hw.equals(fwVar.hw);
    }

    public int hashCode() {
        com.byazt.di.hn hnVar = this.hn;
        return ((hnVar != null ? hnVar.hashCode() : 0) * 31) + this.hw.hashCode();
    }

    public void pr(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<hw> listPr = pr(str);
        if (listPr.isEmpty()) {
            return;
        }
        com.byazt.di.hn hnVar = this.hn;
        if (hnVar != null) {
            list = hnVar.pr(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listPr.size();
            com.byazt.du.uc ucVarHw = null;
            com.byazt.du.uc ucVarPr = null;
            for (int i2 = 0; i2 < size2; i2++) {
                hw hwVar = listPr.get(i2);
                if (hwVar.hn.equals("sha256/")) {
                    if (ucVarHw == null) {
                        ucVarHw = hw(x509Certificate);
                    }
                    if (hwVar.x.equals(ucVarHw)) {
                        return;
                    }
                } else if (hwVar.hn.equals("sha1/")) {
                    if (ucVarPr == null) {
                        ucVarPr = pr(x509Certificate);
                    }
                    if (hwVar.x.equals(ucVarPr)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + hwVar.hn);
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ").append(pr((Certificate) x509Certificate2)).append(": ").append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ").append(str).append(":");
        int size4 = listPr.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sb.append("\n    ").append(listPr.get(i4));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public List<hw> pr(String str) {
        List<hw> listEmptyList = Collections.emptyList();
        for (hw hwVar : this.hw) {
            if (hwVar.pr(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(hwVar);
            }
        }
        return listEmptyList;
    }

    public fw pr(com.byazt.di.hn hnVar) {
        return com.byazt.xx.hn.pr(this.hn, hnVar) ? this : new fw(this.hw, hnVar);
    }

    public static String pr(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + hw((X509Certificate) certificate).hw();
    }

    public static com.byazt.du.uc pr(X509Certificate x509Certificate) {
        return com.byazt.du.uc.pr(x509Certificate.getPublicKey().getEncoded()).hn();
    }

    public static com.byazt.du.uc hw(X509Certificate x509Certificate) {
        return com.byazt.du.uc.pr(x509Certificate.getPublicKey().getEncoded()).x();
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 984})
    static final class hw {
        public final String hn;
        public final String hw;
        public final String pr;
        public final com.byazt.du.uc x;

        public boolean pr(String str) {
            if (this.pr.startsWith("*.")) {
                int iIndexOf = str.indexOf(46);
                if ((str.length() - iIndexOf) - 1 != this.hw.length()) {
                    return false;
                }
                String str2 = this.hw;
                return str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length());
            }
            return str.equals(this.hw);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof hw)) {
                return false;
            }
            hw hwVar = (hw) obj;
            return this.pr.equals(hwVar.pr) && this.hn.equals(hwVar.hn) && this.x.equals(hwVar.x);
        }

        public int hashCode() {
            return ((((this.pr.hashCode() + 527) * 31) + this.hn.hashCode()) * 31) + this.x.hashCode();
        }

        public String toString() {
            return this.hn + this.x.hw();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 766})
    public static final class pr {
        public final List<hw> pr = new ArrayList();

        public fw pr() {
            return new fw(new LinkedHashSet(this.pr), null);
        }
    }
}
