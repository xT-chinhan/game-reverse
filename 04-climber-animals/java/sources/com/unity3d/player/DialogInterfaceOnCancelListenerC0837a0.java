package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.unity3d.player.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class DialogInterfaceOnCancelListenerC0837a0 implements DialogInterface.OnCancelListener {
    final /* synthetic */ C0841c0 a;

    DialogInterfaceOnCancelListenerC0837a0(C0841c0 c0841c0) {
        this.a = c0841c0;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        F f = this.a.f;
        if (f != null) {
            ((C0859l0) f).a();
        }
    }
}
