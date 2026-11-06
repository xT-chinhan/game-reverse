package com.anythink.core.common.m.b;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class ah {
    final a a;
    final Proxy b;
    final InetSocketAddress c;

    public ah(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.a = aVar;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public final a a() {
        return this.a;
    }

    public final Proxy b() {
        return this.b;
    }

    public final InetSocketAddress c() {
        return this.c;
    }

    public final boolean d() {
        return this.a.i != null && this.b.type() == Proxy.Type.HTTP;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ah)) {
            return false;
        }
        ah ahVar = (ah) obj;
        return ahVar.a.equals(this.a) && ahVar.b.equals(this.b) && ahVar.c.equals(this.c);
    }

    public final int hashCode() {
        return ((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "Route{" + this.c + "}";
    }
}
