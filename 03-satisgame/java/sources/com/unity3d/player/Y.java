package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes3.dex */
final class Y implements DialogInterface.OnDismissListener {
    final /* synthetic */ C0492c0 a;

    Y(C0492c0 c0492c0) {
        this.a = c0492c0;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.invokeOnClose();
    }
}
