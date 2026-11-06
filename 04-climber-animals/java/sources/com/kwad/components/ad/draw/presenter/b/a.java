package com.kwad.components.ad.draw.presenter.b;

import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private InterfaceC0364a eH;
    private b eI;
    private boolean eJ = false;
    private AdTemplate mAdTemplate;

    /* JADX INFO: renamed from: com.kwad.components.ad.draw.presenter.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0364a {
        void aV();
    }

    public interface b {
        boolean aW();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void aU() {
        InterfaceC0364a interfaceC0364a;
        if (this.eJ) {
            return;
        }
        this.eJ = true;
        if (e.el(this.mAdTemplate).status == 1 || e.el(this.mAdTemplate).status == 2 || e.el(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.eI;
        if ((bVar == null || !bVar.aW()) && (interfaceC0364a = this.eH) != null) {
            interfaceC0364a.aV();
        }
    }

    public final void a(InterfaceC0364a interfaceC0364a) {
        this.eH = interfaceC0364a;
    }

    public final void a(b bVar) {
        this.eI = bVar;
    }
}
