package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 109})
public final class w {
    public static final w hn;
    public static final w hw;
    public static final w pr;
    public static final zo[] zo;
    public final boolean c;
    public final String[] fw;
    public final String[] uc;
    public final boolean x;

    static {
        zo[] zoVarArr = {zo.w, zo.m, zo.k, zo.g, zo.nt, zo.ho, zo.fw, zo.aj, zo.zo, zo.vk, zo.c, zo.uc, zo.hn, zo.x, zo.hw};
        zo = zoVarArr;
        w wVarPr = new pr(true).pr(zoVarArr).pr(ww.TLS_1_3, ww.TLS_1_2, ww.TLS_1_1, ww.TLS_1_0).pr(true).pr();
        pr = wVarPr;
        hw = new pr(wVarPr).pr(ww.TLS_1_0).pr(true).pr();
        hn = new pr(false).pr();
    }

    public w(pr prVar) {
        this.x = prVar.pr;
        this.uc = prVar.hw;
        this.fw = prVar.hn;
        this.c = prVar.x;
    }

    public boolean pr() {
        return this.x;
    }

    public List<zo> hw() {
        String[] strArr = this.uc;
        if (strArr != null) {
            return zo.pr(strArr);
        }
        return null;
    }

    public List<ww> hn() {
        String[] strArr = this.fw;
        if (strArr != null) {
            return ww.pr(strArr);
        }
        return null;
    }

    public boolean x() {
        return this.c;
    }

    public void pr(SSLSocket sSLSocket, boolean z) {
        w wVarHw = hw(sSLSocket, z);
        String[] strArr = wVarHw.fw;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = wVarHw.uc;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    private w hw(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.uc != null) {
            enabledCipherSuites = com.byazt.xx.hn.pr(zo.pr, sSLSocket.getEnabledCipherSuites(), this.uc);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.fw != null) {
            enabledProtocols = com.byazt.xx.hn.pr(com.byazt.xx.hn.zo, sSLSocket.getEnabledProtocols(), this.fw);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iPr = com.byazt.xx.hn.pr(zo.pr, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iPr != -1) {
            enabledCipherSuites = com.byazt.xx.hn.pr(enabledCipherSuites, supportedCipherSuites[iPr]);
        }
        return new pr(this).pr(enabledCipherSuites).hw(enabledProtocols).pr();
    }

    public boolean pr(SSLSocket sSLSocket) {
        if (!this.x) {
            return false;
        }
        if (this.fw == null || com.byazt.xx.hn.hw(com.byazt.xx.hn.zo, this.fw, sSLSocket.getEnabledProtocols())) {
            return this.uc == null || com.byazt.xx.hn.hw(zo.pr, this.uc, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        w wVar = (w) obj;
        boolean z = this.x;
        if (z != wVar.x) {
            return false;
        }
        return !z || (Arrays.equals(this.uc, wVar.uc) && Arrays.equals(this.fw, wVar.fw) && this.c == wVar.c);
    }

    public int hashCode() {
        if (!this.x) {
            return 17;
        }
        return ((((Arrays.hashCode(this.uc) + 527) * 31) + Arrays.hashCode(this.fw)) * 31) + (!this.c ? 1 : 0);
    }

    public String toString() {
        if (!this.x) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.uc != null ? hw().toString() : "[all enabled]") + ", tlsVersions=" + (this.fw != null ? hn().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.c + ")";
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 1272})
    public static final class pr {
        public String[] hn;
        public String[] hw;
        public boolean pr;
        public boolean x;

        public pr(boolean z) {
            this.pr = z;
        }

        public pr(w wVar) {
            this.pr = wVar.x;
            this.hw = wVar.uc;
            this.hn = wVar.fw;
            this.x = wVar.c;
        }

        public pr pr(zo... zoVarArr) {
            if (!this.pr) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[zoVarArr.length];
            for (int i = 0; i < zoVarArr.length; i++) {
                strArr[i] = zoVarArr[i].yb;
            }
            return pr(strArr);
        }

        public pr pr(String... strArr) {
            if (!this.pr) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.hw = (String[]) strArr.clone();
            return this;
        }

        public pr pr(ww... wwVarArr) {
            if (!this.pr) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[wwVarArr.length];
            for (int i = 0; i < wwVarArr.length; i++) {
                strArr[i] = wwVarArr[i].uc;
            }
            return hw(strArr);
        }

        public pr hw(String... strArr) {
            if (!this.pr) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.hn = (String[]) strArr.clone();
            return this;
        }

        public pr pr(boolean z) {
            if (!this.pr) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.x = z;
            return this;
        }

        public w pr() {
            return new w(this);
        }
    }
}
