package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class RunnableC0391n0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    RunnableC0391n0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0381i0 c0381i0 = this.a.mGlView;
        if (c0381i0 != null) {
            c0381i0.b();
        }
    }
}
