package com.smartdigimkt.q1;

import com.smartdigimkt.b3.v;
import com.smartdigimkt.sdk.basead.ui.animplayerview.WebLandpagePlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements Runnable {
    public final /* synthetic */ WebLandpagePlayerView a;

    public t(WebLandpagePlayerView webLandpagePlayerView) {
        this.a = webLandpagePlayerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebLandpagePlayerView webLandpagePlayerView = this.a;
        if (webLandpagePlayerView.G != null) {
            v vVarB = com.smartdigimkt.c0.h.b(webLandpagePlayerView.N);
            WebLandpagePlayerView webLandpagePlayerView2 = this.a;
            webLandpagePlayerView2.H = vVarB.a;
            webLandpagePlayerView2.G.loadUrl(vVarB.d);
            WebLandpagePlayerView webLandpagePlayerView3 = this.a;
            webLandpagePlayerView3.recordRedirectUrl(webLandpagePlayerView3.G.getUrl());
            if (this.a.C.getAnimation() != null) {
                this.a.C.getAnimation().cancel();
            }
            WebLandpagePlayerView webLandpagePlayerView4 = this.a;
            webLandpagePlayerView4.C.startAnimation(webLandpagePlayerView4.E);
            WebLandpagePlayerView webLandpagePlayerView5 = this.a;
            webLandpagePlayerView5.G.startAnimation(webLandpagePlayerView5.F);
        }
    }
}
