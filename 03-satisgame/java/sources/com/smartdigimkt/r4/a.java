package com.smartdigimkt.r4;

import android.window.OnBackInvokedCallback;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements OnBackInvokedCallback {
    public final /* synthetic */ Runnable a;

    public a(Runnable runnable) {
        this.a = runnable;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.a.run();
    }
}
