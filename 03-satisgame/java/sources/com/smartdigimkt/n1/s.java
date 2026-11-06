package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.AsseblemCardSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements Runnable {
    public final /* synthetic */ AsseblemCardSplashATView a;

    public s(AsseblemCardSplashATView asseblemCardSplashATView) {
        this.a = asseblemCardSplashATView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AsseblemCardSplashATView asseblemCardSplashATView = this.a;
        if (asseblemCardSplashATView.L == null) {
            return;
        }
        asseblemCardSplashATView.m();
    }
}
