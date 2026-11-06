package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.FullScreenATView;

/* JADX INFO: loaded from: classes3.dex */
public final class v2 implements Runnable {
    public final /* synthetic */ FullScreenATView a;

    public v2(FullScreenATView fullScreenATView) {
        this.a = fullScreenATView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.O();
        this.a.c(1);
    }
}
