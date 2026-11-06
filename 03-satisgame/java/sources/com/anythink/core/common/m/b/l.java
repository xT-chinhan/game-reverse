package com.anythink.core.common.m.b;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static final l a;
    public static final l b;
    public static final l c;
    public static final l d;
    private static final i[] i;
    private static final i[] j;
    final boolean e;
    final boolean f;
    final String[] g;
    final String[] h;

    static {
        i[] iVarArr = {i.bl, i.bm, i.bn, i.aX, i.bb, i.aY, i.bc, i.bi, i.bh};
        i = iVarArr;
        i[] iVarArr2 = {i.bl, i.bm, i.bn, i.aX, i.bb, i.aY, i.bc, i.bi, i.bh, i.aI, i.aJ, i.ag, i.ah, i.E, i.I, i.i};
        j = iVarArr2;
        a = new a(true).a(iVarArr).a(ai.TLS_1_3, ai.TLS_1_2).a().b();
        b = new a(true).a(iVarArr2).a(ai.TLS_1_3, ai.TLS_1_2).a().b();
        c = new a(true).a(iVarArr2).a(ai.TLS_1_3, ai.TLS_1_2, ai.TLS_1_1, ai.TLS_1_0).a().b();
        d = new a(false).b();
    }

    l(a aVar) {
        this.e = aVar.a;
        this.g = aVar.b;
        this.h = aVar.c;
        this.f = aVar.d;
    }

    private boolean b() {
        return this.e;
    }

    private List<i> c() {
        String[] strArr = this.g;
        if (strArr != null) {
            return i.a(strArr);
        }
        return null;
    }

    private List<ai> d() {
        String[] strArr = this.h;
        if (strArr != null) {
            return ai.a(strArr);
        }
        return null;
    }

    public final boolean a() {
        return this.f;
    }

    private l b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.g != null) {
            enabledCipherSuites = com.anythink.core.common.m.b.a.c.a(i.a, sSLSocket.getEnabledCipherSuites(), this.g);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.h != null) {
            enabledProtocols = com.anythink.core.common.m.b.a.c.a(com.anythink.core.common.m.b.a.c.g, sSLSocket.getEnabledProtocols(), this.h);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iA = com.anythink.core.common.m.b.a.c.a(i.a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iA != -1) {
            enabledCipherSuites = com.anythink.core.common.m.b.a.c.a(enabledCipherSuites, supportedCipherSuites[iA]);
        }
        return new a(this).a(enabledCipherSuites).b(enabledProtocols).b();
    }

    public final boolean a(SSLSocket sSLSocket) {
        if (!this.e) {
            return false;
        }
        if (this.h == null || com.anythink.core.common.m.b.a.c.b(com.anythink.core.common.m.b.a.c.g, this.h, sSLSocket.getEnabledProtocols())) {
            return this.g == null || com.anythink.core.common.m.b.a.c.b(i.a, this.g, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        l lVar = (l) obj;
        boolean z = this.e;
        if (z != lVar.e) {
            return false;
        }
        return !z || (Arrays.equals(this.g, lVar.g) && Arrays.equals(this.h, lVar.h) && this.f == lVar.f);
    }

    public final int hashCode() {
        if (this.e) {
            return ((((Arrays.hashCode(this.g) + 527) * 31) + Arrays.hashCode(this.h)) * 31) + (!this.f ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        if (!this.e) {
            return "ConnectionSpec()";
        }
        StringBuilder sb = new StringBuilder("ConnectionSpec(cipherSuites=");
        String[] strArr = this.g;
        StringBuilder sbAppend = sb.append(Objects.toString(strArr != null ? i.a(strArr) : null, "[all enabled]")).append(", tlsVersions=");
        String[] strArr2 = this.h;
        return sbAppend.append(Objects.toString(strArr2 != null ? ai.a(strArr2) : null, "[all enabled]")).append(", supportsTlsExtensions=").append(this.f).append(")").toString();
    }

    public static final class a {
        boolean a;
        String[] b;
        String[] c;
        boolean d;

        a(boolean z) {
            this.a = z;
        }

        public a(l lVar) {
            this.a = lVar.e;
            this.b = lVar.g;
            this.c = lVar.h;
            this.d = lVar.f;
        }

        private a c() {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            this.b = null;
            return this;
        }

        public final a a(i... iVarArr) {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[iVarArr.length];
            for (int i = 0; i < iVarArr.length; i++) {
                strArr[i] = iVarArr[i].bq;
            }
            return a(strArr);
        }

        public final a a(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.b = (String[]) strArr.clone();
            return this;
        }

        private a d() {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            this.c = null;
            return this;
        }

        public final a a(ai... aiVarArr) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[aiVarArr.length];
            for (int i = 0; i < aiVarArr.length; i++) {
                strArr[i] = aiVarArr[i].f;
            }
            return b(strArr);
        }

        public final a b(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.c = (String[]) strArr.clone();
            return this;
        }

        public final a a() {
            if (!this.a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.d = true;
            return this;
        }

        public final l b() {
            return new l(this);
        }
    }

    private void a(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.g != null) {
            enabledCipherSuites = com.anythink.core.common.m.b.a.c.a(i.a, sSLSocket.getEnabledCipherSuites(), this.g);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.h != null) {
            enabledProtocols = com.anythink.core.common.m.b.a.c.a(com.anythink.core.common.m.b.a.c.g, sSLSocket.getEnabledProtocols(), this.h);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iA = com.anythink.core.common.m.b.a.c.a(i.a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iA != -1) {
            enabledCipherSuites = com.anythink.core.common.m.b.a.c.a(enabledCipherSuites, supportedCipherSuites[iA]);
        }
        l lVarB = new a(this).a(enabledCipherSuites).b(enabledProtocols).b();
        String[] strArr = lVarB.h;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = lVarB.g;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }
}
