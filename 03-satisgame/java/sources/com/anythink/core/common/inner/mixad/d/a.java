package com.anythink.core.common.inner.mixad.d;

import android.app.Activity;
import com.anythink.core.basead.b.c;
import com.anythink.core.common.inner.ui.activity.ATMixSplashActivity;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.anythink.core.common.k.f.a.a {
    @Override // com.anythink.core.common.k.f.a.a
    public final void a(Activity activity, c cVar, com.anythink.core.common.k.f.a.a.InterfaceC0030a interfaceC0030a) {
        if (activity == null || cVar == null || interfaceC0030a == null) {
            return;
        }
        com.anythink.core.common.inner.mixad.a.a().a(cVar.d, interfaceC0030a);
        ATMixSplashActivity.b(activity, cVar);
    }
}
