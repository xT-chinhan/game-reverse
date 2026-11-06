package com.mcto.sspsdk.internal;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ye implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ gf a;

    public ye(gf gfVar) {
        this.a = gfVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        gf gfVar = this.a;
        int i3 = gfVar.l;
        SurfaceTexture surfaceTexture2 = gfVar.t;
        if (surfaceTexture2 == null) {
            gfVar.t = surfaceTexture;
            if (gfVar.u == null) {
                gfVar.u = new Surface(this.a.t);
            }
            gf gfVar2 = this.a;
            if (gfVar2.s == null) {
                gfVar2.s = new vd(gfVar2.I);
                gf gfVar3 = this.a;
                int i4 = gfVar3.l;
                vd vdVar = gfVar3.s;
                boolean z = gfVar3.m;
                String str = gfVar3.q;
                String str2 = gfVar3.r;
                vdVar.h = 0;
                vdVar.d = i4;
                vdVar.e = gj.c(str);
                vdVar.f = gj.c(str2);
                HashMap map = new HashMap(1);
                vdVar.g = map;
                StringBuilder sb = new StringBuilder();
                y4 y4Var = y4.r;
                map.put("User-Agent", sb.append(y4Var.f()).append(";QYPlayer/Android/").append(y4Var.c()).toString());
                vdVar.i = z;
                vdVar.b();
            }
            gf gfVar4 = this.a;
            vd vdVar2 = gfVar4.s;
            vdVar2.a.setSurface(gfVar4.u);
            gf gfVar5 = this.a;
            if (gfVar5.a == 0) {
                gfVar5.a = 1;
                gfVar5.s.a();
                gf gfVar6 = this.a;
                if (gfVar6.e == 0) {
                    gfVar6.e = 1;
                    l lVarA = l.a();
                    p pVar = gfVar6.B;
                    lVarA.getClass();
                    l.b(1, pVar, null);
                }
            }
        } else {
            gfVar.o.setSurfaceTexture(surfaceTexture2);
        }
        this.a.d();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        int i = this.a.l;
        return this.a.t == null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
