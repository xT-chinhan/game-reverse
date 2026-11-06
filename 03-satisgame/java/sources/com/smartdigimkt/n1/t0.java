package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseScreenATView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 implements View.OnClickListener {
    public final /* synthetic */ BaseScreenATView a;

    public t0(BaseScreenATView baseScreenATView) {
        this.a = baseScreenATView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseScreenATView baseScreenATView = this.a;
        com.smartdigimkt.u1.d dVar = baseScreenATView.n;
        if (dVar == null || baseScreenATView.n0 == null) {
            return;
        }
        BasePlayerView basePlayerView = dVar.h;
        dVar.b(!(basePlayerView != null ? basePlayerView.isMute() : false));
        BaseScreenATView baseScreenATView2 = this.a;
        BasePlayerView basePlayerView2 = baseScreenATView2.n.h;
        baseScreenATView2.a0 = basePlayerView2 != null ? basePlayerView2.isMute() : false;
        BaseScreenATView baseScreenATView3 = this.a;
        baseScreenATView3.n0.setMute(baseScreenATView3.a0);
    }
}
