package com.smartdigimkt.i0;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements com.smartdigimkt.a1.t, com.smartdigimkt.k0.m, com.smartdigimkt.q0.g, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    public final /* synthetic */ i0 a;

    public h0(i0 i0Var) {
        this.a = i0Var;
    }

    @Override // com.smartdigimkt.a1.t
    public final void a(com.smartdigimkt.l0.d dVar) {
        this.a.getClass();
        Iterator it = this.a.g.iterator();
        while (it.hasNext()) {
            ((com.smartdigimkt.a1.t) it.next()).a(dVar);
        }
    }

    @Override // com.smartdigimkt.a1.t
    public final void b(String str, long j, long j2) {
        Iterator it = this.a.g.iterator();
        while (it.hasNext()) {
            ((com.smartdigimkt.a1.t) it.next()).b(str, j, j2);
        }
    }

    @Override // com.smartdigimkt.k0.m
    public final void c(com.smartdigimkt.l0.d dVar) {
        Iterator it = this.a.h.iterator();
        while (it.hasNext()) {
            ((com.smartdigimkt.k0.m) it.next()).c(dVar);
        }
        this.a.getClass();
        this.a.getClass();
        this.a.getClass();
    }

    @Override // com.smartdigimkt.k0.m
    public final void d(com.smartdigimkt.l0.d dVar) {
        this.a.getClass();
        Iterator it = this.a.h.iterator();
        while (it.hasNext()) {
            ((com.smartdigimkt.k0.m) it.next()).d(dVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.a.a(new Surface(surfaceTexture), true);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.a.a(null, true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.a.a(surfaceHolder.getSurface(), false);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.a.a(null, false);
    }

    @Override // com.smartdigimkt.a1.t
    public final void b(com.smartdigimkt.l0.d dVar) {
        Iterator it = this.a.g.iterator();
        while (it.hasNext()) {
            ((com.smartdigimkt.a1.t) it.next()).b(dVar);
        }
        this.a.getClass();
        this.a.getClass();
    }

    @Override // com.smartdigimkt.a1.t
    public final void a(s sVar) {
        this.a.getClass();
        Iterator it = this.a.g.iterator();
        while (it.hasNext()) {
            ((com.smartdigimkt.a1.t) it.next()).a(sVar);
        }
    }

    @Override // com.smartdigimkt.a1.t
    public final void a(int i, long j) {
        Iterator it = this.a.g.iterator();
        while (it.hasNext()) {
            ((com.smartdigimkt.a1.t) it.next()).a(i, j);
        }
    }

    @Override // com.smartdigimkt.k0.m
    public final void b(int i) {
        this.a.getClass();
        Iterator it = this.a.h.iterator();
        while (it.hasNext()) {
            ((com.smartdigimkt.k0.m) it.next()).b(i);
        }
    }

    @Override // com.smartdigimkt.a1.t
    public final void a(int i, int i2, int i3, float f) {
        Iterator it = this.a.e.iterator();
        while (it.hasNext()) {
            ((com.smartdigimkt.a1.k) it.next()).a(i, i2);
        }
        Iterator it2 = this.a.g.iterator();
        while (it2.hasNext()) {
            ((com.smartdigimkt.a1.t) it2.next()).a(i, i2, i3, f);
        }
    }

    @Override // com.smartdigimkt.k0.m
    public final void b(s sVar) {
        this.a.getClass();
        Iterator it = this.a.h.iterator();
        while (it.hasNext()) {
            ((com.smartdigimkt.k0.m) it.next()).b(sVar);
        }
    }

    @Override // com.smartdigimkt.a1.t
    public final void a(Surface surface) {
        i0 i0Var = this.a;
        if (i0Var.j == surface) {
            Iterator it = i0Var.e.iterator();
            while (it.hasNext()) {
                ((com.smartdigimkt.a1.k) it.next()).getClass();
            }
        }
        Iterator it2 = this.a.g.iterator();
        while (it2.hasNext()) {
            ((com.smartdigimkt.a1.t) it2.next()).a(surface);
        }
    }

    @Override // com.smartdigimkt.k0.m
    public final void a(String str, long j, long j2) {
        Iterator it = this.a.h.iterator();
        while (it.hasNext()) {
            ((com.smartdigimkt.k0.m) it.next()).a(str, j, j2);
        }
    }

    @Override // com.smartdigimkt.k0.m
    public final void a(int i, long j, long j2) {
        Iterator it = this.a.h.iterator();
        while (it.hasNext()) {
            ((com.smartdigimkt.k0.m) it.next()).a(i, j, j2);
        }
    }

    @Override // com.smartdigimkt.q0.g
    public final void a(com.smartdigimkt.q0.c cVar) {
        Iterator it = this.a.f.iterator();
        while (it.hasNext()) {
            ((com.smartdigimkt.q0.g) it.next()).a(cVar);
        }
    }
}
