package com.bytedance.sdk.component.ah.xr;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class ms {
    final ProxySelector ab;
    final SocketFactory ah;
    final List<hi> c;
    final HostnameVerifier ch;
    final xr d;
    final ab hi;
    final List<i> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final y f1047ms;
    final SSLSocketFactory ny;
    final Proxy x;
    final ub xr;

    public ms(String str, int i, ub ubVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, ab abVar, xr xrVar, Proxy proxy, List<i> list, List<hi> list2, ProxySelector proxySelector) {
        this.f1047ms = new y.ms().ms(sSLSocketFactory != null ? "https" : "http").d(str).ms(i).ah();
        if (ubVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.xr = ubVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.ah = socketFactory;
        if (xrVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.d = xrVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.ka = com.bytedance.sdk.component.ah.xr.ms.ah.ms(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.c = com.bytedance.sdk.component.ah.xr.ms.ah.ms(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.ab = proxySelector;
        this.x = proxy;
        this.ny = sSLSocketFactory;
        this.ch = hostnameVerifier;
        this.hi = abVar;
    }

    public y ms() {
        return this.f1047ms;
    }

    public ub xr() {
        return this.xr;
    }

    public SocketFactory ah() {
        return this.ah;
    }

    public xr d() {
        return this.d;
    }

    public List<i> ka() {
        return this.ka;
    }

    public List<hi> c() {
        return this.c;
    }

    public ProxySelector ab() {
        return this.ab;
    }

    public Proxy x() {
        return this.x;
    }

    public SSLSocketFactory ny() {
        return this.ny;
    }

    public HostnameVerifier ch() {
        return this.ch;
    }

    public ab hi() {
        return this.hi;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ms)) {
            return false;
        }
        ms msVar = (ms) obj;
        return this.f1047ms.equals(msVar.f1047ms) && ms(msVar);
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.f1047ms.hashCode() + 527) * 31) + this.xr.hashCode()) * 31) + this.d.hashCode()) * 31) + this.ka.hashCode()) * 31) + this.c.hashCode()) * 31) + this.ab.hashCode()) * 31;
        Proxy proxy = this.x;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.ny;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.ch;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        ab abVar = this.hi;
        return iHashCode4 + (abVar != null ? abVar.hashCode() : 0);
    }

    boolean ms(ms msVar) {
        return this.xr.equals(msVar.xr) && this.d.equals(msVar.d) && this.ka.equals(msVar.ka) && this.c.equals(msVar.c) && this.ab.equals(msVar.ab) && com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.x, msVar.x) && com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.ny, msVar.ny) && com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.ch, msVar.ch) && com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.hi, msVar.hi) && ms().x() == msVar.ms().x();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Address{").append(this.f1047ms.ab()).append(":").append(this.f1047ms.x());
        if (this.x != null) {
            sbAppend.append(", proxy=").append(this.x);
        } else {
            sbAppend.append(", proxySelector=").append(this.ab);
        }
        sbAppend.append("}");
        return sbAppend.toString();
    }
}
