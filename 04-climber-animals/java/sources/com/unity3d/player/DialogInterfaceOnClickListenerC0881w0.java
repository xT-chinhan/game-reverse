package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.unity3d.player.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class DialogInterfaceOnClickListenerC0881w0 implements DialogInterface.OnClickListener {
    final /* synthetic */ UnityPlayer a;

    DialogInterfaceOnClickListenerC0881w0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.finish();
    }
}
