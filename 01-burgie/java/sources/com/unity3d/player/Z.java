package com.unity3d.player;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes3.dex */
final class Z implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ C0369c0 a;

    Z(C0369c0 c0369c0) {
        this.a = c0369c0;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.reportSoftInputArea();
        this.a.h.b();
    }
}
