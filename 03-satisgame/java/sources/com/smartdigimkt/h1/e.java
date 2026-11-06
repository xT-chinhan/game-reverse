package com.smartdigimkt.h1;

import com.smartdigimkt.sdk.basead.ui.OwnNativeATView;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.smartdigimkt.u1.c {
    public final /* synthetic */ k a;

    public e(k kVar) {
        this.a = kVar;
    }

    @Override // com.smartdigimkt.u1.c
    public final com.smartdigimkt.h0.m a() {
        return this.a.a();
    }

    @Override // com.smartdigimkt.u1.c
    public final com.smartdigimkt.h0.a b() {
        OwnNativeATView ownNativeATView = this.a.q;
        if (ownNativeATView != null) {
            return ownNativeATView.getAdClickRecord(13);
        }
        return null;
    }
}
