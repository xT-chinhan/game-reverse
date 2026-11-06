package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes3.dex */
final class Y implements DialogInterface.OnDismissListener {
    final /* synthetic */ C0369c0 a;

    Y(C0369c0 c0369c0) {
        this.a = c0369c0;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.invokeOnClose();
    }
}
