package com.smartdigimkt.r4;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ OnBackInvokedDispatcher a;
    public final /* synthetic */ OnBackInvokedCallback b;

    public b(OnBackInvokedDispatcher onBackInvokedDispatcher, a aVar) {
        this.a = onBackInvokedDispatcher;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.unregisterOnBackInvokedCallback(this.b);
    }
}
