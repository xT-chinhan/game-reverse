package com.byazt.pq;

import com.byazt.ho.BaseConstants;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 19})
public final class n {
    public final x cp;
    public final Proxy fs;
    public final List<m> l;
    public final um n;
    public final qg q;
    public final k qg;
    public final SSLSocketFactory rv;
    public final SocketFactory s;
    public final HostnameVerifier tj;
    public final List<cp> w;
    public final ProxySelector x;

    public n(String str, int i, k kVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, x xVar, qg qgVar, Proxy proxy, List<m> list, List<cp> list2, ProxySelector proxySelector) {
        this.n = new um.n().n(sSLSocketFactory != null ? BaseConstants.SCHEME_HTTPS : "http").q(str).n(i).s();
        if (kVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.qg = kVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.s = socketFactory;
        if (qgVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.q = qgVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.l = com.byazt.zho.s.n(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.w = com.byazt.zho.s.n(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.x = proxySelector;
        this.fs = proxy;
        this.rv = sSLSocketFactory;
        this.tj = hostnameVerifier;
        this.cp = xVar;
    }

    public um n() {
        return this.n;
    }

    public k qg() {
        return this.qg;
    }

    public SocketFactory s() {
        return this.s;
    }

    public qg q() {
        return this.q;
    }

    public List<m> l() {
        return this.l;
    }

    public List<cp> w() {
        return this.w;
    }

    public ProxySelector x() {
        return this.x;
    }

    public Proxy fs() {
        return this.fs;
    }

    public SSLSocketFactory rv() {
        return this.rv;
    }

    public HostnameVerifier tj() {
        return this.tj;
    }

    public x cp() {
        return this.cp;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.n.equals(nVar.n) && n(nVar);
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.n.hashCode() + 527) * 31) + this.qg.hashCode()) * 31) + this.q.hashCode()) * 31) + this.l.hashCode()) * 31) + this.w.hashCode()) * 31) + this.x.hashCode()) * 31;
        Proxy proxy = this.fs;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.rv;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.tj;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        x xVar = this.cp;
        return iHashCode4 + (xVar != null ? xVar.hashCode() : 0);
    }

    public boolean n(n nVar) {
        return this.qg.equals(nVar.qg) && this.q.equals(nVar.q) && this.l.equals(nVar.l) && this.w.equals(nVar.w) && this.x.equals(nVar.x) && com.byazt.zho.s.n(this.fs, nVar.fs) && com.byazt.zho.s.n(this.rv, nVar.rv) && com.byazt.zho.s.n(this.tj, nVar.tj) && com.byazt.zho.s.n(this.cp, nVar.cp) && n().x() == nVar.n().x();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Address{").append(this.n.w()).append(":").append(this.n.x());
        if (this.fs != null) {
            sbAppend.append(", proxy=").append(this.fs);
        } else {
            sbAppend.append(", proxySelector=").append(this.x);
        }
        sbAppend.append("}");
        return sbAppend.toString();
    }
}
