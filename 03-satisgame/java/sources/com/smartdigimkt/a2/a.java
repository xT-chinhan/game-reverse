package com.smartdigimkt.a2;

import com.smartdigimkt.h0.g;
import com.smartdigimkt.j1.v;
import com.smartdigimkt.k2.k;
import com.smartdigimkt.n1.a1;
import com.smartdigimkt.sdk.basead.ui.CloseImageView;
import com.smartdigimkt.sdk.basead.ui.h5template.WTWebViewBaseScreenATView;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements k {
    public final /* synthetic */ WTWebViewBaseScreenATView a;

    public a(WTWebViewBaseScreenATView wTWebViewBaseScreenATView) {
        this.a = wTWebViewBaseScreenATView;
    }

    @Override // com.smartdigimkt.k2.k
    public final void a() {
        WTWebViewBaseScreenATView wTWebViewBaseScreenATView = this.a;
        int i = WTWebViewBaseScreenATView.C0;
        CloseImageView closeImageView = wTWebViewBaseScreenATView.l0;
        if (closeImageView != null) {
            closeImageView.setVisibility(8);
        }
        this.a.a(302);
        WTWebViewBaseScreenATView wTWebViewBaseScreenATView2 = this.a;
        if (3 != wTWebViewBaseScreenATView2.D || c0.h(wTWebViewBaseScreenATView2.c, wTWebViewBaseScreenATView2.b)) {
            return;
        }
        WTWebViewBaseScreenATView wTWebViewBaseScreenATView3 = this.a;
        Math.max(0, wTWebViewBaseScreenATView3.b.s.R);
        wTWebViewBaseScreenATView3.A = new a1(wTWebViewBaseScreenATView3);
        wTWebViewBaseScreenATView3.c();
    }

    @Override // com.smartdigimkt.k2.k
    public final void a(g gVar) {
        WTWebViewBaseScreenATView wTWebViewBaseScreenATView = this.a;
        g gVar2 = new g(com.anythink.core.common.inner.b.b.k, com.anythink.core.common.inner.b.b.af + gVar.a());
        int i = WTWebViewBaseScreenATView.C0;
        v vVar = wTWebViewBaseScreenATView.t0;
        if (vVar != null) {
            vVar.a(gVar2);
        }
        this.a.c(10);
    }
}
