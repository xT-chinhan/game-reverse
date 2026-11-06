package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.SimplePlayerMediaView;

/* JADX INFO: loaded from: classes3.dex */
public final class j5 extends com.smartdigimkt.p3.a {
    public final /* synthetic */ SimplePlayerMediaView b;

    public j5(SimplePlayerMediaView simplePlayerMediaView) {
        this.b = simplePlayerMediaView;
    }

    @Override // com.smartdigimkt.p3.a
    public final int a() {
        return 50;
    }

    @Override // com.smartdigimkt.p3.a
    public final void b() {
        com.smartdigimkt.u1.d dVar;
        this.b.p.set(false);
        SimplePlayerMediaView simplePlayerMediaView = this.b;
        if (simplePlayerMediaView.o || (dVar = simplePlayerMediaView.b) == null) {
            return;
        }
        dVar.d();
    }
}
