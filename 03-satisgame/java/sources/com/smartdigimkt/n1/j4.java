package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.PlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class j4 implements com.smartdigimkt.a1.k {
    public final /* synthetic */ PlayerView a;

    public j4(PlayerView playerView) {
        this.a = playerView;
    }

    @Override // com.smartdigimkt.a1.k
    public final void a(int i, int i2) {
        PlayerView playerView = this.a;
        playerView.autoFitVideoSize(i, i2, playerView.v);
    }
}
