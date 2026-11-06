package com.anythink.core.common.n.a;

import java.net.InetAddress;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    private final InetAddress[] a;
    private final i b;

    public m(InetAddress[] inetAddressArr, i iVar) {
        this.a = inetAddressArr;
        this.b = iVar;
    }

    public final InetAddress[] a() {
        return this.a;
    }

    private i c() {
        return this.b;
    }

    public final f b() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.a();
        }
        return null;
    }
}
