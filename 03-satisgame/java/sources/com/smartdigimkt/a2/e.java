package com.smartdigimkt.a2;

import com.smartdigimkt.h0.g;
import com.smartdigimkt.k2.k;
import com.smartdigimkt.sdk.basead.ui.h5template.WTWebViewSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements k {
    public final /* synthetic */ WTWebViewSplashATView a;

    public e(WTWebViewSplashATView wTWebViewSplashATView) {
        this.a = wTWebViewSplashATView;
    }

    @Override // com.smartdigimkt.k2.k
    public final void a() {
        this.a.a(302);
        WTWebViewSplashATView wTWebViewSplashATView = this.a;
        int i = wTWebViewSplashATView.b.s.R;
        wTWebViewSplashATView.A = new d(this);
        wTWebViewSplashATView.c();
    }

    @Override // com.smartdigimkt.k2.k
    public final void a(g gVar) {
        WTWebViewSplashATView wTWebViewSplashATView = this.a;
        int i = WTWebViewSplashATView.o0;
        wTWebViewSplashATView.b(gVar);
    }
}
