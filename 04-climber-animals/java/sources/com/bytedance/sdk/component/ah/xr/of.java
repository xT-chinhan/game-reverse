package com.bytedance.sdk.component.ah.xr;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public final class of {
    final InetSocketAddress ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final ms f1133ms;
    final Proxy xr;

    public of(ms msVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (msVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f1133ms = msVar;
        this.xr = proxy;
        this.ah = inetSocketAddress;
    }

    public ms ms() {
        return this.f1133ms;
    }

    public Proxy xr() {
        return this.xr;
    }

    public InetSocketAddress ah() {
        return this.ah;
    }

    public boolean d() {
        return this.f1133ms.ny != null && this.xr.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof of)) {
            return false;
        }
        of ofVar = (of) obj;
        return ofVar.f1133ms.equals(this.f1133ms) && ofVar.xr.equals(this.xr) && ofVar.ah.equals(this.ah);
    }

    public int hashCode() {
        return ((((this.f1133ms.hashCode() + 527) * 31) + this.xr.hashCode()) * 31) + this.ah.hashCode();
    }

    public String toString() {
        return "Route{" + this.ah + "}";
    }
}
