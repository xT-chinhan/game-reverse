package com.smartdigimkt.f;

import com.hollywood.nexus.ArcherBridge;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements ArcherBridge {
    public final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    public final Object getDateObject() {
        return this.a.b.i;
    }

    public final int getSdkType() {
        return com.smartdigimkt.r4.h.z() ? 0 : 2;
    }

    public final String getUserAgent() {
        return this.a.b.j;
    }

    public final boolean supportURAction() {
        return this.a.b.l;
    }
}
