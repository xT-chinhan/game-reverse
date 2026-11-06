package com.anythink.basead.mixad.b;

import android.app.Activity;

/* JADX INFO: loaded from: classes.dex */
public final class f extends a implements com.anythink.core.common.l.c.a.e {
    private com.anythink.core.common.l.f.a.a b;

    @Override // com.anythink.core.common.l.c.a.e
    public final void a(Activity activity, com.anythink.core.basead.b.c cVar, com.anythink.core.common.l.f.a.a.InterfaceC0087a interfaceC0087a) {
        com.anythink.core.common.l.f.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a(activity, cVar, interfaceC0087a);
        }
    }

    @Override // com.anythink.core.common.l.c.a.e
    public final void a(com.anythink.core.common.l.f.a.a aVar) {
        this.b = aVar;
    }
}
