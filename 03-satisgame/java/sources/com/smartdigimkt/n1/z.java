package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.AsseblemSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements Runnable {
    public final /* synthetic */ AsseblemSplashATView a;

    public z(AsseblemSplashATView asseblemSplashATView) {
        this.a = asseblemSplashATView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AsseblemSplashATView asseblemSplashATView = this.a;
        if (asseblemSplashATView.L == null) {
            return;
        }
        asseblemSplashATView.m();
    }
}
