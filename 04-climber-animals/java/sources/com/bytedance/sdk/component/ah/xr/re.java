package com.bytedance.sdk.component.ah.xr;

import android.os.Bundle;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public class re implements Cloneable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final List<i> f1138ms = com.bytedance.sdk.component.ah.xr.ms.ah.ms(i.HTTP_2, i.HTTP_1_1);
    static final List<hi> xr = com.bytedance.sdk.component.ah.xr.ms.ah.ms(hi.f1043ms, hi.ah);
    final List<t> ab;
    final u ah;
    final com.bytedance.sdk.component.ah.xr.ms.ny.ah ao;
    final ub b;
    final List<hi> c;
    final ProxySelector ch;
    final int cv;
    final Proxy d;
    public Set<String> g;
    final HostnameVerifier h;
    final zb hi;
    final boolean i;
    final List<i> ka;
    final int le;
    final ch nw;
    final ao.ms ny;
    final int op;
    final ab qv;
    final boolean re;
    final ah sl;
    final xr t;
    final SocketFactory u;
    final SSLSocketFactory ub;
    final boolean w;
    final List<t> x;
    final xr y;
    final int yu;
    final com.bytedance.sdk.component.ah.xr.ms.ms.c zb;

    static {
        com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms = new com.bytedance.sdk.component.ah.xr.ms.ms() { // from class: com.bytedance.sdk.component.ah.xr.re.1
            @Override // com.bytedance.sdk.component.ah.xr.ms.ms
            public void ms(qv.ms msVar, String str) {
                msVar.ms(str);
            }

            @Override // com.bytedance.sdk.component.ah.xr.ms.ms
            public void ms(qv.ms msVar, String str, String str2) {
                msVar.xr(str, str2);
            }

            @Override // com.bytedance.sdk.component.ah.xr.ms.ms
            public boolean ms(ch chVar, com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar) {
                return chVar.xr(ahVar);
            }

            @Override // com.bytedance.sdk.component.ah.xr.ms.ms
            public com.bytedance.sdk.component.ah.xr.ms.xr.ah ms(ch chVar, com.bytedance.sdk.component.ah.xr.ms msVar, com.bytedance.sdk.component.ah.xr.ms.xr.ab abVar, of ofVar) {
                return chVar.ms(msVar, abVar, ofVar);
            }

            @Override // com.bytedance.sdk.component.ah.xr.ms.ms
            public boolean ms(com.bytedance.sdk.component.ah.xr.ms msVar, com.bytedance.sdk.component.ah.xr.ms msVar2) {
                return msVar.ms(msVar2);
            }

            @Override // com.bytedance.sdk.component.ah.xr.ms.ms
            public Socket ms(ch chVar, com.bytedance.sdk.component.ah.xr.ms msVar, com.bytedance.sdk.component.ah.xr.ms.xr.ab abVar) {
                return chVar.ms(msVar, abVar);
            }

            @Override // com.bytedance.sdk.component.ah.xr.ms.ms
            public void xr(ch chVar, com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar) {
                chVar.ms(ahVar);
            }

            @Override // com.bytedance.sdk.component.ah.xr.ms.ms
            public com.bytedance.sdk.component.ah.xr.ms.xr.d ms(ch chVar) {
                return chVar.f1035ms;
            }

            @Override // com.bytedance.sdk.component.ah.xr.ms.ms
            public int ms(cv.ms msVar) {
                return msVar.ah;
            }

            @Override // com.bytedance.sdk.component.ah.xr.ms.ms
            public void ms(hi hiVar, SSLSocket sSLSocket, boolean z) {
                hiVar.ms(sSLSocket, z);
            }
        };
    }

    public re() {
        this(new ms());
    }

    re(ms msVar) {
        boolean z;
        this.ah = msVar.f1139ms;
        this.d = msVar.xr;
        this.ka = msVar.ah;
        List<hi> list = msVar.d;
        this.c = list;
        this.ab = com.bytedance.sdk.component.ah.xr.ms.ah.ms(msVar.ka);
        this.x = com.bytedance.sdk.component.ah.xr.ms.ah.ms(msVar.c);
        this.ny = msVar.ab;
        this.ch = msVar.x;
        this.hi = msVar.ny;
        this.sl = msVar.ch;
        this.zb = msVar.hi;
        this.u = msVar.sl;
        this.g = msVar.cv;
        Iterator<hi> it = list.iterator();
        loop0: while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else {
                    z = (z || it.next().ms()) ? true : z;
                }
            }
        }
        if (msVar.zb != null || !z) {
            this.ub = msVar.zb;
            this.ao = msVar.u;
        } else {
            X509TrustManager x509TrustManagerW = w();
            this.ub = ms(x509TrustManagerW);
            this.ao = com.bytedance.sdk.component.ah.xr.ms.ny.ah.ms(x509TrustManagerW);
        }
        this.h = msVar.ub;
        this.qv = msVar.ao.ms(this.ao);
        this.y = msVar.h;
        this.t = msVar.qv;
        ch chVar = msVar.y;
        this.nw = chVar;
        if (chVar != null) {
            chVar.ms(msVar.le);
        }
        this.b = msVar.t;
        this.re = msVar.nw;
        this.i = msVar.b;
        this.w = msVar.re;
        this.yu = msVar.i;
        this.op = msVar.w;
        this.le = msVar.yu;
        this.cv = msVar.op;
        if (this.ab.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.ab);
        }
        if (this.x.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.x);
        }
    }

    private X509TrustManager w() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw com.bytedance.sdk.component.ah.xr.ms.ah.ms("No System TLS", (Exception) e);
        }
    }

    private SSLSocketFactory ms(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw com.bytedance.sdk.component.ah.xr.ms.ah.ms("No System TLS", (Exception) e);
        }
    }

    public int ms() {
        return this.yu;
    }

    public int xr() {
        return this.op;
    }

    public int ah() {
        return this.le;
    }

    public Proxy d() {
        return this.d;
    }

    public ProxySelector ka() {
        return this.ch;
    }

    public zb c() {
        return this.hi;
    }

    com.bytedance.sdk.component.ah.xr.ms.ms.c ab() {
        ah ahVar = this.sl;
        return ahVar != null ? ahVar.f1027ms : this.zb;
    }

    public ub x() {
        return this.b;
    }

    public SocketFactory ny() {
        return this.u;
    }

    public SSLSocketFactory ch() {
        return this.ub;
    }

    public HostnameVerifier hi() {
        return this.h;
    }

    public ab sl() {
        return this.qv;
    }

    public xr zb() {
        return this.t;
    }

    public xr u() {
        return this.y;
    }

    public ch ub() {
        return this.nw;
    }

    public boolean ao() {
        return this.re;
    }

    public boolean h() {
        return this.i;
    }

    public boolean qv() {
        return this.w;
    }

    public u y() {
        return this.ah;
    }

    public List<i> t() {
        return this.ka;
    }

    public List<hi> nw() {
        return this.c;
    }

    public List<t> b() {
        return this.ab;
    }

    public List<t> re() {
        return this.x;
    }

    public ao.ms i() {
        return this.ny;
    }

    public ka ms(yu yuVar) {
        return w.ms(this, yuVar, false);
    }

    public static final class ms {
        ao.ms ab;
        public List<i> ah;
        ab ao;
        boolean b;
        final List<t> c;
        ah ch;
        public Set<String> cv;
        List<hi> d;
        public TimeUnit g;
        xr h;
        com.bytedance.sdk.component.ah.xr.ms.ms.c hi;
        public int i;
        public final List<t> ka;
        public Bundle le;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        u f1139ms;
        boolean nw;
        zb ny;
        public TimeUnit of;
        int op;
        public TimeUnit p;
        xr qv;
        boolean re;
        SocketFactory sl;
        ub t;
        com.bytedance.sdk.component.ah.xr.ms.ny.ah u;
        HostnameVerifier ub;
        public int w;
        ProxySelector x;
        Proxy xr;
        ch y;
        public int yu;
        SSLSocketFactory zb;

        public ms() {
            this("");
        }

        public ms(String str) {
            this.ka = new ArrayList();
            this.c = new ArrayList();
            this.g = TimeUnit.MILLISECONDS;
            this.of = TimeUnit.MILLISECONDS;
            this.p = TimeUnit.MILLISECONDS;
            this.f1139ms = new u(str);
            this.ah = re.f1138ms;
            this.d = re.xr;
            this.ab = ao.ms(ao.f1030ms);
            this.x = ProxySelector.getDefault();
            this.ny = zb.f1152ms;
            this.sl = SocketFactory.getDefault();
            this.ub = com.bytedance.sdk.component.ah.xr.ms.ny.ka.f1119ms;
            this.ao = ab.f1024ms;
            this.h = xr.f1146ms;
            this.qv = xr.f1146ms;
            this.y = new ch();
            this.t = ub.f1142ms;
            this.nw = true;
            this.b = true;
            this.re = true;
            this.i = 10000;
            this.w = 10000;
            this.yu = 10000;
            this.op = 0;
        }

        public ms ms(long j, TimeUnit timeUnit) {
            this.i = com.bytedance.sdk.component.ah.xr.ms.ah.ms("timeout", j, timeUnit);
            return this;
        }

        public ms xr(long j, TimeUnit timeUnit) {
            this.w = com.bytedance.sdk.component.ah.xr.ms.ah.ms("timeout", j, timeUnit);
            return this;
        }

        public ms ah(long j, TimeUnit timeUnit) {
            this.yu = com.bytedance.sdk.component.ah.xr.ms.ah.ms("timeout", j, timeUnit);
            return this;
        }

        public ms ms(t tVar) {
            if (tVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.ka.add(tVar);
            return this;
        }

        public ms ms(ao aoVar) {
            if (aoVar == null) {
                throw new NullPointerException("eventListener == null");
            }
            this.ab = ao.ms(aoVar);
            return this;
        }

        public ms ms(Set<String> set) {
            this.cv = set;
            return this;
        }

        public re ms() {
            return new re(this);
        }
    }
}
