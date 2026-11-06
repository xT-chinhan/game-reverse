package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC0855j0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    RunnableC0855j0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.nativeLowMemory();
    }
}
