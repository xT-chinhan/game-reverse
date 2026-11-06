package com.smartdigimkt.g2;

import com.smartdigimkt.a1.k;
import com.smartdigimkt.sdk.basead.ui.simpleview.SimplePlayer;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements k {
    public final /* synthetic */ SimplePlayer a;

    public e(SimplePlayer simplePlayer) {
        this.a = simplePlayer;
    }

    @Override // com.smartdigimkt.a1.k
    public final void a(int i, int i2) {
        SimplePlayer simplePlayer = this.a;
        simplePlayer.autoFitVideoSize(i, i2, simplePlayer.c);
    }
}
