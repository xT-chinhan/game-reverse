package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
final class Y implements DialogInterface.OnDismissListener {
    final /* synthetic */ C0841c0 a;

    Y(C0841c0 c0841c0) {
        this.a = c0841c0;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.invokeOnClose();
    }
}
