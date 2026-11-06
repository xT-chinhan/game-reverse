package com.unity3d.player;

import android.window.OnBackInvokedCallback;

/* JADX INFO: renamed from: com.unity3d.player.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C0842d implements OnBackInvokedCallback {
    final /* synthetic */ com.unity3d.player.a.c a;

    C0842d(com.unity3d.player.a.c cVar) {
        this.a = cVar;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        Runnable runnable = ((B) this.a).a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
