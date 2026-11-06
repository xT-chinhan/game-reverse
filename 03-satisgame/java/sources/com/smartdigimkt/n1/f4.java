package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.PlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class f4 implements View.OnClickListener {
    public final /* synthetic */ PlayerView a;

    public f4(PlayerView playerView) {
        this.a = playerView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PlayerView playerView = this.a;
        String str = PlayerView.TAG;
        com.smartdigimkt.q1.k kVar = playerView.o;
        if (kVar != null) {
            kVar.g();
        }
    }
}
