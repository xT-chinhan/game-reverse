package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.unity3d.player.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class DialogInterfaceOnCancelListenerC0365a0 implements DialogInterface.OnCancelListener {
    final /* synthetic */ C0369c0 a;

    DialogInterfaceOnCancelListenerC0365a0(C0369c0 c0369c0) {
        this.a = c0369c0;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        F f = this.a.f;
        if (f != null) {
            ((C0387l0) f).a();
        }
    }
}
