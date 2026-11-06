package com.unity3d.player;

import android.view.SurfaceHolder;

/* JADX INFO: renamed from: com.unity3d.player.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class SurfaceHolderCallbackC0379h0 implements SurfaceHolder.Callback {
    final /* synthetic */ C0381i0 a;

    SurfaceHolderCallbackC0379h0(C0381i0 c0381i0) {
        this.a = c0381i0;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.a.b.updateGLDisplay(0, surfaceHolder.getSurface());
        this.a.b.sendSurfaceChangedEvent();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.a.b.updateGLDisplay(0, surfaceHolder.getSurface());
        C0381i0 c0381i0 = this.a;
        K k = c0381i0.c;
        UnityPlayer unityPlayer = c0381i0.b;
        J j = k.b;
        if (j == null || j.getParent() != null) {
            return;
        }
        unityPlayer.addView(k.b);
        unityPlayer.bringChildToFront(k.b);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C0381i0 c0381i0 = this.a;
        K k = c0381i0.c;
        C0374f c0374f = c0381i0.a;
        k.getClass();
        if (PlatformSupport.NOUGAT_SUPPORT && k.a != null) {
            if (k.b == null) {
                k.b = new J(k.a);
            }
            k.b.a(c0374f);
        }
        this.a.b.updateGLDisplay(0, null);
    }
}
