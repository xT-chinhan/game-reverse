package com.byazt.pq;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.cp.n(n = {0, 1, 109, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC})
public class wm implements Cloneable {
    public static final List<m> n = com.byazt.zho.s.n(m.HTTP_2, m.HTTP_1_1);
    public static final List<cp> qg = com.byazt.zho.s.n(cp.n, cp.s);
    public final qg a;
    public final int bb;
    public final x cd;
    public final oa cp;
    public final com.byazt.vw.s cy;
    public final s d;
    public final List<a> fs;
    public final int h;
    public final HostnameVerifier hd;
    public final boolean hu;
    public final SSLSocketFactory k;
    public final List<m> l;
    public Set<String> ln;
    public final boolean m;
    public final com.byazt.ym.w oa;
    public final k ou;
    public final tj py;
    public final Proxy q;
    public final cy.n rv;
    public final sz s;
    public final SocketFactory sz;
    public final int t;
    public final ProxySelector tj;
    public final qg um;
    public final int ur;
    public final List<cp> w;
    public final boolean wm;
    public final List<a> x;

    static {
        com.byazt.zho.n.n = new com.byazt.zho.n() { // from class: com.byazt.pq.wm.1
            @Override // com.byazt.zho.n
            public void n(cd.n nVar, String str) {
                nVar.n(str);
            }

            @Override // com.byazt.zho.n
            public void n(cd.n nVar, String str, String str2) {
                nVar.qg(str, str2);
            }

            @Override // com.byazt.zho.n
            public boolean n(tj tjVar, com.byazt.sqs.s sVar) {
                return tjVar.qg(sVar);
            }

            @Override // com.byazt.zho.n
            public com.byazt.sqs.s n(tj tjVar, com.byazt.pq.n nVar, com.byazt.sqs.x xVar, lh lhVar) {
                return tjVar.n(nVar, xVar, lhVar);
            }

            @Override // com.byazt.zho.n
            public boolean n(com.byazt.pq.n nVar, com.byazt.pq.n nVar2) {
                return nVar.n(nVar2);
            }

            @Override // com.byazt.zho.n
            public Socket n(tj tjVar, com.byazt.pq.n nVar, com.byazt.sqs.x xVar) {
                return tjVar.n(nVar, xVar);
            }

            @Override // com.byazt.zho.n
            public void qg(tj tjVar, com.byazt.sqs.s sVar) {
                tjVar.n(sVar);
            }

            @Override // com.byazt.zho.n
            public com.byazt.sqs.q n(tj tjVar) {
                return tjVar.n;
            }

            @Override // com.byazt.zho.n
            public int n(bb.n nVar) {
                return nVar.s;
            }

            @Override // com.byazt.zho.n
            public void n(cp cpVar, SSLSocket sSLSocket, boolean z) {
                cpVar.n(sSLSocket, z);
            }
        };
    }

    public wm() {
        this(new n());
    }

    public wm(n nVar) {
        boolean z;
        this.s = nVar.n;
        this.q = nVar.qg;
        this.l = nVar.s;
        List<cp> list = nVar.q;
        this.w = list;
        this.x = com.byazt.zho.s.n(nVar.l);
        this.fs = com.byazt.zho.s.n(nVar.w);
        this.rv = nVar.x;
        this.tj = nVar.fs;
        this.cp = nVar.rv;
        this.d = nVar.tj;
        this.oa = nVar.cp;
        this.sz = nVar.d;
        this.ln = nVar.bb;
        Iterator<cp> it = list.iterator();
        loop0: while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else {
                    z = (z || it.next().n()) ? true : z;
                }
            }
        }
        if (nVar.oa != null || !z) {
            this.k = nVar.oa;
            this.cy = nVar.sz;
        } else {
            X509TrustManager x509TrustManagerHu = hu();
            this.k = n(x509TrustManagerHu);
            this.cy = com.byazt.vw.s.n(x509TrustManagerHu);
        }
        this.hd = nVar.k;
        this.cd = nVar.cy.n(this.cy);
        this.um = nVar.hd;
        this.a = nVar.cd;
        tj tjVar = nVar.um;
        this.py = tjVar;
        if (tjVar != null) {
            tjVar.n(nVar.ur);
        }
        this.ou = nVar.a;
        this.wm = nVar.py;
        this.m = nVar.ou;
        this.hu = nVar.wm;
        this.h = nVar.m;
        this.t = nVar.hu;
        this.ur = nVar.h;
        this.bb = nVar.t;
        if (this.x.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.x);
        }
        if (this.fs.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.fs);
        }
    }

    private X509TrustManager hu() {
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
            throw com.byazt.zho.s.n("No System TLS", (Exception) e);
        }
    }

    private SSLSocketFactory n(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw com.byazt.zho.s.n("No System TLS", (Exception) e);
        }
    }

    public int n() {
        return this.h;
    }

    public int qg() {
        return this.t;
    }

    public int s() {
        return this.ur;
    }

    public Proxy q() {
        return this.q;
    }

    public ProxySelector l() {
        return this.tj;
    }

    public oa w() {
        return this.cp;
    }

    public com.byazt.ym.w x() {
        s sVar = this.d;
        return sVar != null ? sVar.n : this.oa;
    }

    public k fs() {
        return this.ou;
    }

    public SocketFactory rv() {
        return this.sz;
    }

    public SSLSocketFactory tj() {
        return this.k;
    }

    public HostnameVerifier cp() {
        return this.hd;
    }

    public x d() {
        return this.cd;
    }

    public qg oa() {
        return this.a;
    }

    public qg sz() {
        return this.um;
    }

    public tj k() {
        return this.py;
    }

    public boolean cy() {
        return this.wm;
    }

    public boolean hd() {
        return this.m;
    }

    public boolean cd() {
        return this.hu;
    }

    public sz um() {
        return this.s;
    }

    public List<m> a() {
        return this.l;
    }

    public List<cp> py() {
        return this.w;
    }

    public List<a> ou() {
        return this.x;
    }

    public List<a> wm() {
        return this.fs;
    }

    public cy.n m() {
        return this.rv;
    }

    public l n(h hVar) {
        return hu.n(this, hVar, false);
    }

    @com.byazt.cp.n(n = {0, 1, 109, 1174})
    public static final class n {
        public k a;
        public Set<String> bb;
        public qg cd;
        public com.byazt.ym.w cp;
        public x cy;
        public SocketFactory d;
        public ProxySelector fs;
        public int h;
        public qg hd;
        public int hu;
        public HostnameVerifier k;
        public final List<a> l;
        public TimeUnit lh;
        public TimeUnit ln;
        public int m;
        public sz n;
        public SSLSocketFactory oa;
        public boolean ou;
        public boolean py;
        public List<cp> q;
        public Proxy qg;
        public oa rv;
        public List<m> s;
        public com.byazt.vw.s sz;
        public int t;
        public s tj;
        public tj um;
        public Bundle ur;
        public TimeUnit v;
        public final List<a> w;
        public boolean wm;
        public cy.n x;

        public n() {
            this("");
        }

        public n(String str) {
            this.l = new ArrayList();
            this.w = new ArrayList();
            this.ln = TimeUnit.MILLISECONDS;
            this.lh = TimeUnit.MILLISECONDS;
            this.v = TimeUnit.MILLISECONDS;
            this.n = new sz(str);
            this.s = wm.n;
            this.q = wm.qg;
            this.x = cy.n(cy.n);
            this.fs = ProxySelector.getDefault();
            this.rv = oa.n;
            this.d = SocketFactory.getDefault();
            this.k = com.byazt.vw.l.n;
            this.cy = x.n;
            this.hd = qg.n;
            this.cd = qg.n;
            this.um = new tj();
            this.a = k.n;
            this.py = true;
            this.ou = true;
            this.wm = true;
            this.m = 10000;
            this.hu = 10000;
            this.h = 10000;
            this.t = 0;
        }

        public n n(long j, TimeUnit timeUnit) {
            this.m = com.byazt.zho.s.n("timeout", j, timeUnit);
            return this;
        }

        public n qg(long j, TimeUnit timeUnit) {
            this.hu = com.byazt.zho.s.n("timeout", j, timeUnit);
            return this;
        }

        public n s(long j, TimeUnit timeUnit) {
            this.h = com.byazt.zho.s.n("timeout", j, timeUnit);
            return this;
        }

        public n n(Proxy proxy) {
            this.qg = proxy;
            return this;
        }

        public n n(k kVar) {
            if (kVar == null) {
                throw new NullPointerException("dns == null");
            }
            this.a = kVar;
            return this;
        }

        public n n(a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.l.add(aVar);
            return this;
        }

        public n n(cy cyVar) {
            if (cyVar == null) {
                throw new NullPointerException("eventListener == null");
            }
            this.x = cy.n(cyVar);
            return this;
        }

        public wm n() {
            return new wm(this);
        }
    }
}
