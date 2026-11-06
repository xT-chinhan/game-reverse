package com.unity3d.player;

import android.view.SurfaceHolder;

/* JADX INFO: renamed from: com.unity3d.player.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class SurfaceHolderCallbackC0502h0 implements SurfaceHolder.Callback {
    final /* synthetic */ C0504i0 a;

    SurfaceHolderCallbackC0502h0(C0504i0 c0504i0) {
        this.a = c0504i0;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.a.b.updateGLDisplay(0, surfaceHolder.getSurface());
        this.a.b.sendSurfaceChangedEvent();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.a.b.updateGLDisplay(0, surfaceHolder.getSurface());
        C0504i0 c0504i0 = this.a;
        K k = c0504i0.c;
        UnityPlayer unityPlayer = c0504i0.b;
        J j = k.b;
        if (j == null || j.getParent() != null) {
            return;
        }
        unityPlayer.addView(k.b);
        unityPlayer.bringChildToFront(k.b);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C0504i0 c0504i0 = this.a;
        K k = c0504i0.c;
        C0497f c0497f = c0504i0.a;
        k.getClass();
        if (PlatformSupport.NOUGAT_SUPPORT && k.a != null) {
            if (k.b == null) {
                k.b = new J(k.a);
            }
            k.b.a(c0497f);
        }
        this.a.b.updateGLDisplay(0, null);
    }
}
