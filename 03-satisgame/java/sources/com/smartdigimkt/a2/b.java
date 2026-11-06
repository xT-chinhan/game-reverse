package com.smartdigimkt.a2;

import com.smartdigimkt.h0.g;
import com.smartdigimkt.j1.v;
import com.smartdigimkt.n1.i1;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.sdk.basead.ui.h5template.WTWebViewBaseScreenATView;
import com.smartdigimkt.x.l;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.smartdigimkt.l2.a {
    public final /* synthetic */ WTWebViewBaseScreenATView a;

    public b(WTWebViewBaseScreenATView wTWebViewBaseScreenATView) {
        this.a = wTWebViewBaseScreenATView;
    }

    @Override // com.smartdigimkt.l2.a
    public final void a(int i, int i2) {
        WTWebViewBaseScreenATView wTWebViewBaseScreenATView = this.a;
        int i3 = WTWebViewBaseScreenATView.C0;
        wTWebViewBaseScreenATView.a(i, i2);
    }

    @Override // com.smartdigimkt.l2.a
    public final void b(int i) {
        this.a.c(i);
    }

    @Override // com.smartdigimkt.l2.a
    public final void b() {
        WTWebViewBaseScreenATView wTWebViewBaseScreenATView = this.a;
        int i = WTWebViewBaseScreenATView.C0;
        wTWebViewBaseScreenATView.a(111);
        wTWebViewBaseScreenATView.U = false;
        com.smartdigimkt.u1.d dVar = wTWebViewBaseScreenATView.n;
        if (dVar != null) {
            dVar.b();
        }
        if (wTWebViewBaseScreenATView.j0 == null) {
            wTWebViewBaseScreenATView.j0 = new l();
        }
        wTWebViewBaseScreenATView.j0.a(wTWebViewBaseScreenATView.getContext(), wTWebViewBaseScreenATView.c, wTWebViewBaseScreenATView.b, new i1(wTWebViewBaseScreenATView));
    }

    @Override // com.smartdigimkt.l2.a
    public final void a(String str, String str2) {
        WTWebViewBaseScreenATView wTWebViewBaseScreenATView = this.a;
        g gVar = new g(com.anythink.core.common.inner.b.b.k, com.anythink.core.common.inner.b.b.af + str + "," + str2);
        int i = WTWebViewBaseScreenATView.C0;
        v vVar = wTWebViewBaseScreenATView.t0;
        if (vVar != null) {
            vVar.a(gVar);
        }
        this.a.c(10);
    }

    @Override // com.smartdigimkt.l2.a
    public final void a(int i) {
        if (i == 1) {
            this.a.a(303);
        } else {
            this.a.a(304);
        }
    }

    @Override // com.smartdigimkt.l2.a
    public final void a() {
        WTWebViewBaseScreenATView wTWebViewBaseScreenATView = this.a;
        int i = WTWebViewBaseScreenATView.C0;
        BasePlayerView basePlayerView = wTWebViewBaseScreenATView.n.h;
        if (basePlayerView != null) {
            basePlayerView.setVisibility(0);
        }
        com.smartdigimkt.u1.d dVar = this.a.n;
        if (dVar != null) {
            dVar.s = true;
            dVar.d();
        }
    }
}
