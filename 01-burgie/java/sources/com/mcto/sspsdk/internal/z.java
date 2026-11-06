package com.mcto.sspsdk.internal;

import android.view.SurfaceHolder;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements SurfaceHolder.Callback {
    public final /* synthetic */ a0 a;

    public z(a0 a0Var) {
        this.a = a0Var;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        surfaceHolder.hashCode();
        int i4 = this.a.b.a;
        surfaceHolder.hashCode();
        int width = this.a.getWidth();
        int height = this.a.getHeight();
        if (width > 0 && height > 0) {
            surfaceHolder.hashCode();
            if (width != i2 || height != i3) {
                surfaceHolder.hashCode();
                surfaceHolder.setFixedSize(width, height);
            }
        }
        x xVar = this.a.b;
        if (xVar.b == 3) {
            xVar.b();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        surfaceHolder.hashCode();
        a0 a0Var = this.a;
        a0Var.a = surfaceHolder;
        x xVar = a0Var.b;
        if (xVar.g == null || surfaceHolder.getSurface() == null || !surfaceHolder.getSurface().isValid()) {
            xVar.a(xVar.c, surfaceHolder);
        } else {
            xVar.g.setDisplay(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.a.b.a();
    }
}
