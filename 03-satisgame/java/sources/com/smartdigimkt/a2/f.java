package com.smartdigimkt.a2;

import com.smartdigimkt.h0.g;
import com.smartdigimkt.n1.m2;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.sdk.basead.ui.h5template.WTWebViewSplashATView;
import com.smartdigimkt.x.l;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.smartdigimkt.l2.a {
    public final /* synthetic */ WTWebViewSplashATView a;

    public f(WTWebViewSplashATView wTWebViewSplashATView) {
        this.a = wTWebViewSplashATView;
    }

    @Override // com.smartdigimkt.l2.a
    public final void a(int i, int i2) {
        WTWebViewSplashATView wTWebViewSplashATView = this.a;
        int i3 = WTWebViewSplashATView.o0;
        wTWebViewSplashATView.a(i, i2);
    }

    @Override // com.smartdigimkt.l2.a
    public final void b(int i) {
        WTWebViewSplashATView wTWebViewSplashATView = this.a;
        int i2 = WTWebViewSplashATView.o0;
        wTWebViewSplashATView.a(i, true);
    }

    @Override // com.smartdigimkt.l2.a
    public final void a(String str, String str2) {
        WTWebViewSplashATView wTWebViewSplashATView = this.a;
        String str3 = str + "," + str2;
        int i = WTWebViewSplashATView.o0;
        wTWebViewSplashATView.getClass();
        wTWebViewSplashATView.b(new g(com.anythink.core.common.inner.b.b.k, str3));
    }

    @Override // com.smartdigimkt.l2.a
    public final void b() {
        WTWebViewSplashATView wTWebViewSplashATView = this.a;
        int i = WTWebViewSplashATView.o0;
        wTWebViewSplashATView.a(111);
        if (wTWebViewSplashATView.R == null) {
            wTWebViewSplashATView.R = new l();
        }
        wTWebViewSplashATView.R.a(wTWebViewSplashATView.getContext(), wTWebViewSplashATView.c, wTWebViewSplashATView.b, new m2(wTWebViewSplashATView));
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
        WTWebViewSplashATView wTWebViewSplashATView = this.a;
        int i = WTWebViewSplashATView.o0;
        BasePlayerView basePlayerView = wTWebViewSplashATView.n.h;
        if (basePlayerView != null) {
            basePlayerView.setVisibility(0);
        }
        this.a.u();
    }
}
