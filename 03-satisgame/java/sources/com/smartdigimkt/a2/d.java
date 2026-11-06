package com.smartdigimkt.a2;

import com.smartdigimkt.sdk.basead.ui.h5template.WTWebViewSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ e a;

    public d(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WTWebViewSplashATView wTWebViewSplashATView = this.a.a;
        int i = WTWebViewSplashATView.o0;
        if (wTWebViewSplashATView.L == null) {
            return;
        }
        wTWebViewSplashATView.m();
    }
}
