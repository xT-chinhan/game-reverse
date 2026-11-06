package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.SimplePlayerMediaView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class f5 implements View.OnClickListener {
    public final /* synthetic */ SimplePlayerMediaView a;

    public f5(SimplePlayerMediaView simplePlayerMediaView) {
        this.a = simplePlayerMediaView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.u1.d dVar = this.a.b;
        if (dVar != null) {
            BasePlayerView basePlayerView = dVar.h;
            if (basePlayerView != null) {
                dVar.j = null;
                dVar.g = null;
                basePlayerView.setListener(dVar.l);
                dVar.h.rePlayVideo();
            }
            this.a.j.setVisibility(8);
        }
    }
}
