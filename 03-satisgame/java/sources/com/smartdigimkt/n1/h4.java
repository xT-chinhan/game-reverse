package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.PlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class h4 implements Runnable {
    public final /* synthetic */ Thread a;
    public final /* synthetic */ PlayerView b;

    public h4(PlayerView playerView, Thread thread) {
        this.b = playerView;
        this.a = thread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            if (!this.b.M) {
                PlayerView playerView = this.b;
                if (playerView.N == this.a) {
                    playerView.N = null;
                    com.smartdigimkt.q1.k kVar = playerView.o;
                    if (kVar != null) {
                        com.smartdigimkt.h0.g gVar = new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.k, "Video player error!Buffer timeout");
                        if (kVar != null) {
                            kVar.a(gVar);
                        }
                        if (playerView.r) {
                            return;
                        }
                        playerView.o = null;
                    }
                }
            }
        }
    }
}
