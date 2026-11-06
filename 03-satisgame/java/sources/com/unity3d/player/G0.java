package com.unity3d.player;

/* JADX INFO: loaded from: classes3.dex */
final class G0 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ UnityPlayer b;

    G0(UnityPlayer unityPlayer, int i) {
        this.b = unityPlayer;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            UnityPlayer unityPlayer = this.b;
            AbstractC0491c.a(unityPlayer.mActivity, unityPlayer, this.a);
        } catch (Exception e) {
            AbstractC0537z.Log(6, "Exception when opening Activity Indicator " + e);
        }
    }
}
