package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.SimplePlayerMediaView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class i5 implements View.OnClickListener {
    public final /* synthetic */ SimplePlayerMediaView a;

    public i5(SimplePlayerMediaView simplePlayerMediaView) {
        this.a = simplePlayerMediaView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SimplePlayerMediaView simplePlayerMediaView = this.a;
        com.smartdigimkt.u1.d dVar = simplePlayerMediaView.b;
        if (dVar == null || simplePlayerMediaView.d == null) {
            return;
        }
        BasePlayerView basePlayerView = dVar.h;
        if (!(basePlayerView != null ? basePlayerView.isMute() : false)) {
            this.a.d.setMute(true);
            this.a.b.b(true);
        } else {
            this.a.d.setMute(false);
            this.a.b.b(false);
        }
    }
}
