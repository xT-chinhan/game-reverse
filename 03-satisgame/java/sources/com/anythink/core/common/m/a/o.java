package com.anythink.core.common.m.a;

import java.net.InetAddress;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    private final InetAddress[] a;
    private final k b;

    public o(InetAddress[] inetAddressArr, k kVar) {
        this.a = inetAddressArr;
        this.b = kVar;
    }

    public final InetAddress[] a() {
        return this.a;
    }

    private k c() {
        return this.b;
    }

    public final g b() {
        k kVar = this.b;
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }
}
