package com.anythink.core.common.inner.mixad.b;

import android.app.Activity;

/* JADX INFO: loaded from: classes.dex */
public final class d extends a implements com.anythink.core.common.k.c.a.c {
    private com.anythink.core.common.k.f.a.a b;

    @Override // com.anythink.core.common.k.c.a.c
    public final void a(Activity activity, com.anythink.core.basead.b.c cVar, com.anythink.core.common.k.e.a.a.InterfaceC0029a interfaceC0029a) {
        if (this.a != null) {
            this.a.a(activity, cVar, interfaceC0029a);
        }
    }

    @Override // com.anythink.core.common.k.c.a.c
    public final void a(Activity activity, com.anythink.core.basead.b.c cVar, com.anythink.core.common.k.f.a.a.InterfaceC0030a interfaceC0030a) {
        com.anythink.core.common.k.f.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a(activity, cVar, interfaceC0030a);
        }
    }

    @Override // com.anythink.core.common.k.c.a.c
    public final void a(com.anythink.core.common.k.f.a.a aVar) {
        this.b = aVar;
    }
}
