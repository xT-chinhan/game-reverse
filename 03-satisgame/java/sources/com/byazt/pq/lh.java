package com.byazt.pq;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 1475})
public final class lh {
    public final n n;
    public final Proxy qg;
    public final InetSocketAddress s;

    public lh(n nVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (nVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.n = nVar;
        this.qg = proxy;
        this.s = inetSocketAddress;
    }

    public n n() {
        return this.n;
    }

    public Proxy qg() {
        return this.qg;
    }

    public InetSocketAddress s() {
        return this.s;
    }

    public boolean q() {
        return this.n.rv != null && this.qg.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof lh)) {
            return false;
        }
        lh lhVar = (lh) obj;
        return lhVar.n.equals(this.n) && lhVar.qg.equals(this.qg) && lhVar.s.equals(this.s);
    }

    public int hashCode() {
        return ((((this.n.hashCode() + 527) * 31) + this.qg.hashCode()) * 31) + this.s.hashCode();
    }

    public String toString() {
        return "Route{" + this.s + "}";
    }
}
