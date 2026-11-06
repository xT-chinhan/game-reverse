package com.smartdigimkt.g2;

import com.smartdigimkt.sdk.basead.ui.simpleview.SimplePlayer;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ SimplePlayer a;

    public c(SimplePlayer simplePlayer) {
        this.a = simplePlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimplePlayer simplePlayer = this.a;
        if (simplePlayer.i) {
            return;
        }
        simplePlayer.a();
    }
}
