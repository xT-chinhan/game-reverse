package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class q1 implements View.OnClickListener {
    public final /* synthetic */ BaseSdkSplashATView a;

    public q1(BaseSdkSplashATView baseSdkSplashATView) {
        this.a = baseSdkSplashATView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseSdkSplashATView baseSdkSplashATView = this.a;
        com.smartdigimkt.u1.d dVar = baseSdkSplashATView.n;
        if (dVar == null || baseSdkSplashATView.f0 == null) {
            return;
        }
        BasePlayerView basePlayerView = dVar.h;
        if (!(basePlayerView != null ? basePlayerView.isMute() : false)) {
            this.a.f0.setMute(true);
            this.a.n.b(true);
        } else {
            this.a.f0.setMute(false);
            this.a.n.b(false);
        }
    }
}
