package com.bytedance.sdk.component.ah.xr;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
public final class hi {
    public static final hi ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final hi f1043ms;
    private static final x[] x;
    public static final hi xr;
    final String[] ab;
    final String[] c;
    final boolean d;
    final boolean ka;

    static {
        x[] xVarArr = {x.hi, x.zb, x.sl, x.u, x.ao, x.ub, x.ab, x.ny, x.x, x.ch, x.ka, x.c, x.ah, x.d, x.xr};
        x = xVarArr;
        hi hiVarMs = new ms(true).ms(xVarArr).ms(p.TLS_1_3, p.TLS_1_2, p.TLS_1_1, p.TLS_1_0).ms(true).ms();
        f1043ms = hiVarMs;
        xr = new ms(hiVarMs).ms(p.TLS_1_0).ms(true).ms();
        ah = new ms(false).ms();
    }

    hi(ms msVar) {
        this.d = msVar.f1044ms;
        this.c = msVar.xr;
        this.ab = msVar.ah;
        this.ka = msVar.d;
    }

    public boolean ms() {
        return this.d;
    }

    public List<x> xr() {
        String[] strArr = this.c;
        if (strArr != null) {
            return x.ms(strArr);
        }
        return null;
    }

    public List<p> ah() {
        String[] strArr = this.ab;
        if (strArr != null) {
            return p.ms(strArr);
        }
        return null;
    }

    public boolean d() {
        return this.ka;
    }

    void ms(SSLSocket sSLSocket, boolean z) {
        hi hiVarXr = xr(sSLSocket, z);
        String[] strArr = hiVarXr.ab;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = hiVarXr.c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    private hi xr(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.c != null) {
            enabledCipherSuites = com.bytedance.sdk.component.ah.xr.ms.ah.ms(x.f1145ms, sSLSocket.getEnabledCipherSuites(), this.c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.ab != null) {
            enabledProtocols = com.bytedance.sdk.component.ah.xr.ms.ah.ms(com.bytedance.sdk.component.ah.xr.ms.ah.x, sSLSocket.getEnabledProtocols(), this.ab);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iMs = com.bytedance.sdk.component.ah.xr.ms.ah.ms(x.f1145ms, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iMs != -1) {
            enabledCipherSuites = com.bytedance.sdk.component.ah.xr.ms.ah.ms(enabledCipherSuites, supportedCipherSuites[iMs]);
        }
        return new ms(this).ms(enabledCipherSuites).xr(enabledProtocols).ms();
    }

    public boolean ms(SSLSocket sSLSocket) {
        if (!this.d) {
            return false;
        }
        if (this.ab == null || com.bytedance.sdk.component.ah.xr.ms.ah.xr(com.bytedance.sdk.component.ah.xr.ms.ah.x, this.ab, sSLSocket.getEnabledProtocols())) {
            return this.c == null || com.bytedance.sdk.component.ah.xr.ms.ah.xr(x.f1145ms, this.c, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof hi)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        hi hiVar = (hi) obj;
        boolean z = this.d;
        if (z != hiVar.d) {
            return false;
        }
        return !z || (Arrays.equals(this.c, hiVar.c) && Arrays.equals(this.ab, hiVar.ab) && this.ka == hiVar.ka);
    }

    public int hashCode() {
        if (this.d) {
            return ((((Arrays.hashCode(this.c) + 527) * 31) + Arrays.hashCode(this.ab)) * 31) + (!this.ka ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.d) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.c != null ? xr().toString() : "[all enabled]") + ", tlsVersions=" + (this.ab != null ? ah().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.ka + ")";
    }

    public static final class ms {
        String[] ah;
        boolean d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        boolean f1044ms;
        String[] xr;

        ms(boolean z) {
            this.f1044ms = z;
        }

        public ms(hi hiVar) {
            this.f1044ms = hiVar.d;
            this.xr = hiVar.c;
            this.ah = hiVar.ab;
            this.d = hiVar.ka;
        }

        public ms ms(x... xVarArr) {
            if (!this.f1044ms) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[xVarArr.length];
            for (int i = 0; i < xVarArr.length; i++) {
                strArr[i] = xVarArr[i].h;
            }
            return ms(strArr);
        }

        public ms ms(String... strArr) {
            if (!this.f1044ms) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.xr = (String[]) strArr.clone();
            return this;
        }

        public ms ms(p... pVarArr) {
            if (!this.f1044ms) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[pVarArr.length];
            for (int i = 0; i < pVarArr.length; i++) {
                strArr[i] = pVarArr[i].c;
            }
            return xr(strArr);
        }

        public ms xr(String... strArr) {
            if (!this.f1044ms) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.ah = (String[]) strArr.clone();
            return this;
        }

        public ms ms(boolean z) {
            if (!this.f1044ms) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.d = z;
            return this;
        }

        public hi ms() {
            return new hi(this);
        }
    }
}
