package com.anythink.core.common.m.b;

import com.byazt.ho.BaseConstants;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    final v a;
    final q b;
    final SocketFactory c;
    final b d;
    final List<ab> e;
    final List<l> f;
    final ProxySelector g;
    final Proxy h;
    final SSLSocketFactory i;
    final HostnameVerifier j;
    final g k;

    public a(String str, int i, q qVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b bVar, Proxy proxy, List<ab> list, List<l> list2, ProxySelector proxySelector) {
        v.a aVar = new v.a();
        String str2 = sSLSocketFactory != null ? BaseConstants.SCHEME_HTTPS : "http";
        if (str2.equalsIgnoreCase("http")) {
            aVar.a = "http";
        } else if (str2.equalsIgnoreCase(BaseConstants.SCHEME_HTTPS)) {
            aVar.a = BaseConstants.SCHEME_HTTPS;
        } else {
            throw new IllegalArgumentException("unexpected scheme: ".concat(str2));
        }
        v.a aVarA = aVar.a(str);
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException("unexpected port: ".concat(String.valueOf(i)));
        }
        aVarA.e = i;
        this.a = aVarA.b();
        if (qVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.b = qVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.c = socketFactory;
        if (bVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.d = bVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.e = com.anythink.core.common.m.b.a.c.a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f = com.anythink.core.common.m.b.a.c.a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = gVar;
    }

    public final v a() {
        return this.a;
    }

    public final q b() {
        return this.b;
    }

    public final SocketFactory c() {
        return this.c;
    }

    public final b d() {
        return this.d;
    }

    public final List<ab> e() {
        return this.e;
    }

    public final List<l> f() {
        return this.f;
    }

    public final ProxySelector g() {
        return this.g;
    }

    public final Proxy h() {
        return this.h;
    }

    public final SSLSocketFactory i() {
        return this.i;
    }

    public final HostnameVerifier j() {
        return this.j;
    }

    public final g k() {
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a.equals(aVar.a) && a(aVar);
    }

    public final int hashCode() {
        return ((((((((((((((((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Objects.hashCode(this.h)) * 31) + Objects.hashCode(this.i)) * 31) + Objects.hashCode(this.j)) * 31) + Objects.hashCode(this.k);
    }

    final boolean a(a aVar) {
        return this.b.equals(aVar.b) && this.d.equals(aVar.d) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && Objects.equals(this.h, aVar.h) && Objects.equals(this.i, aVar.i) && Objects.equals(this.j, aVar.j) && Objects.equals(this.k, aVar.k) && this.a.n == aVar.a.n;
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder("Address{").append(this.a.m).append(":").append(this.a.n);
        if (this.h != null) {
            sbAppend.append(", proxy=").append(this.h);
        } else {
            sbAppend.append(", proxySelector=").append(this.g);
        }
        sbAppend.append("}");
        return sbAppend.toString();
    }
}
