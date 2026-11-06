package com.anythink.basead.mixad.d;

import android.app.Activity;
import com.anythink.basead.ui.activity.ATMixSplashActivity;
import com.anythink.core.basead.b.c;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.anythink.core.common.l.f.a.a {
    @Override // com.anythink.core.common.l.f.a.a
    public final void a(Activity activity, c cVar, com.anythink.core.common.l.f.a.a.InterfaceC0087a interfaceC0087a) {
        if (activity == null || cVar == null || interfaceC0087a == null) {
            return;
        }
        com.anythink.basead.mixad.a.a().a(cVar.d, interfaceC0087a);
        ATMixSplashActivity.b(activity, cVar);
    }
}
