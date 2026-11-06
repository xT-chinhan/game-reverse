package com.byazt.pq;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 29})
public final class cp {
    public static final fs[] fs;
    public static final cp n;
    public static final cp qg;
    public static final cp s;
    public final boolean l;
    public final boolean q;
    public final String[] w;
    public final String[] x;

    static {
        fs[] fsVarArr = {fs.cp, fs.oa, fs.d, fs.sz, fs.cy, fs.k, fs.x, fs.rv, fs.fs, fs.tj, fs.l, fs.w, fs.s, fs.q, fs.qg};
        fs = fsVarArr;
        cp cpVarN = new n(true).n(fsVarArr).n(v.TLS_1_3, v.TLS_1_2, v.TLS_1_1, v.TLS_1_0).n(true).n();
        n = cpVarN;
        qg = new n(cpVarN).n(v.TLS_1_0).n(true).n();
        s = new n(false).n();
    }

    public cp(n nVar) {
        this.q = nVar.n;
        this.w = nVar.qg;
        this.x = nVar.s;
        this.l = nVar.q;
    }

    public boolean n() {
        return this.q;
    }

    public List<fs> qg() {
        String[] strArr = this.w;
        if (strArr != null) {
            return fs.n(strArr);
        }
        return null;
    }

    public List<v> s() {
        String[] strArr = this.x;
        if (strArr != null) {
            return v.n(strArr);
        }
        return null;
    }

    public boolean q() {
        return this.l;
    }

    public void n(SSLSocket sSLSocket, boolean z) {
        cp cpVarQg = qg(sSLSocket, z);
        String[] strArr = cpVarQg.x;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = cpVarQg.w;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    private cp qg(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.w != null) {
            enabledCipherSuites = com.byazt.zho.s.n(fs.n, sSLSocket.getEnabledCipherSuites(), this.w);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.x != null) {
            enabledProtocols = com.byazt.zho.s.n(com.byazt.zho.s.fs, sSLSocket.getEnabledProtocols(), this.x);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iN = com.byazt.zho.s.n(fs.n, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iN != -1) {
            enabledCipherSuites = com.byazt.zho.s.n(enabledCipherSuites, supportedCipherSuites[iN]);
        }
        return new n(this).n(enabledCipherSuites).qg(enabledProtocols).n();
    }

    public boolean n(SSLSocket sSLSocket) {
        if (!this.q) {
            return false;
        }
        if (this.x == null || com.byazt.zho.s.qg(com.byazt.zho.s.fs, this.x, sSLSocket.getEnabledProtocols())) {
            return this.w == null || com.byazt.zho.s.qg(fs.n, this.w, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cp)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        cp cpVar = (cp) obj;
        boolean z = this.q;
        if (z != cpVar.q) {
            return false;
        }
        return !z || (Arrays.equals(this.w, cpVar.w) && Arrays.equals(this.x, cpVar.x) && this.l == cpVar.l);
    }

    public int hashCode() {
        if (this.q) {
            return ((((Arrays.hashCode(this.w) + 527) * 31) + Arrays.hashCode(this.x)) * 31) + (!this.l ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.q) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.w != null ? qg().toString() : "[all enabled]") + ", tlsVersions=" + (this.x != null ? s().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.l + ")";
    }

    @com.byazt.cp.n(n = {0, 1, 109, 570})
    public static final class n {
        public boolean n;
        public boolean q;
        public String[] qg;
        public String[] s;

        public n(boolean z) {
            this.n = z;
        }

        public n(cp cpVar) {
            this.n = cpVar.q;
            this.qg = cpVar.w;
            this.s = cpVar.x;
            this.q = cpVar.l;
        }

        public n n(fs... fsVarArr) {
            if (!this.n) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[fsVarArr.length];
            for (int i = 0; i < fsVarArr.length; i++) {
                strArr[i] = fsVarArr[i].hd;
            }
            return n(strArr);
        }

        public n n(String... strArr) {
            if (!this.n) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.qg = (String[]) strArr.clone();
            return this;
        }

        public n n(v... vVarArr) {
            if (!this.n) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[vVarArr.length];
            for (int i = 0; i < vVarArr.length; i++) {
                strArr[i] = vVarArr[i].w;
            }
            return qg(strArr);
        }

        public n qg(String... strArr) {
            if (!this.n) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.s = (String[]) strArr.clone();
            return this;
        }

        public n n(boolean z) {
            if (!this.n) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.q = z;
            return this;
        }

        public cp n() {
            return new cp(this);
        }
    }
}
