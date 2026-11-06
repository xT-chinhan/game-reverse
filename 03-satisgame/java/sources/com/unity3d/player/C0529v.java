package com.unity3d.player;

import android.graphics.SurfaceTexture;

/* JADX INFO: renamed from: com.unity3d.player.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class C0529v implements SurfaceTexture.OnFrameAvailableListener {
    final /* synthetic */ C0531w a;

    C0529v(C0531w c0531w) {
        this.a = c0531w;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        ((Camera2Wrapper) this.a.a).a(surfaceTexture);
    }
}
