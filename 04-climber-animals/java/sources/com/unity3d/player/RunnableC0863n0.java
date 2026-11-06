package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC0863n0 implements Runnable {
    final /* synthetic */ UnityPlayer a;

    RunnableC0863n0(UnityPlayer unityPlayer) {
        this.a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0853i0 c0853i0 = this.a.mGlView;
        if (c0853i0 != null) {
            c0853i0.b();
        }
    }
}
