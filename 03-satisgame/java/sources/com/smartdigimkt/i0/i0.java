package com.smartdigimkt.i0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements h {
    public final a[] a;
    public final k b;
    public final Handler c;
    public final h0 d;
    public final CopyOnWriteArraySet e;
    public final CopyOnWriteArraySet f;
    public final CopyOnWriteArraySet g;
    public final CopyOnWriteArraySet h;
    public final com.smartdigimkt.j0.c i;
    public Surface j;
    public boolean k;
    public TextureView l;
    public com.smartdigimkt.v0.j m;

    public i0(f fVar, com.smartdigimkt.x0.g gVar, c cVar) {
        h0 h0Var = new h0(this);
        this.d = h0Var;
        this.e = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.f = copyOnWriteArraySet;
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        this.g = copyOnWriteArraySet2;
        CopyOnWriteArraySet copyOnWriteArraySet3 = new CopyOnWriteArraySet();
        this.h = copyOnWriteArraySet3;
        Handler handler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.c = handler;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.smartdigimkt.a1.g(fVar.a, 5000L, handler, h0Var));
        Context context = fVar.a;
        com.smartdigimkt.k0.e[] eVarArr = new com.smartdigimkt.k0.e[0];
        com.smartdigimkt.k0.c cVar2 = com.smartdigimkt.k0.c.c;
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        arrayList.add(new com.smartdigimkt.k0.d0(context, handler, h0Var, (intentRegisterReceiver == null || intentRegisterReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? com.smartdigimkt.k0.c.c : new com.smartdigimkt.k0.c(intentRegisterReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), intentRegisterReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0)), eVarArr));
        arrayList.add(new com.smartdigimkt.q0.h(h0Var, handler.getLooper()));
        a[] aVarArr = (a[]) arrayList.toArray(new a[arrayList.size()]);
        this.a = aVarArr;
        k kVar = new k(aVarArr, gVar, cVar);
        this.b = kVar;
        com.smartdigimkt.j0.c cVar3 = new com.smartdigimkt.j0.c(kVar);
        this.i = cVar3;
        kVar.g.add(cVar3);
        copyOnWriteArraySet2.add(cVar3);
        copyOnWriteArraySet3.add(cVar3);
        copyOnWriteArraySet.add(cVar3);
    }

    public final void a(float f) {
        for (a aVar : this.a) {
            if (aVar.a == 1) {
                k kVar = this.b;
                e0 e0Var = new e0(kVar.e, aVar, kVar.p.c, kVar.c(), kVar.f);
                if (!(!e0Var.f)) {
                    throw new IllegalStateException();
                }
                e0Var.c = 2;
                Float fValueOf = Float.valueOf(f);
                if (!(!e0Var.f)) {
                    throw new IllegalStateException();
                }
                e0Var.d = fValueOf;
                e0Var.b();
            }
        }
    }

    @Override // com.smartdigimkt.i0.h
    public final long b() {
        return this.b.b();
    }

    @Override // com.smartdigimkt.i0.h
    public final int c() {
        return this.b.c();
    }

    @Override // com.smartdigimkt.i0.h
    public final long d() {
        return this.b.d();
    }

    @Override // com.smartdigimkt.i0.h
    public final m0 e() {
        return this.b.p.c;
    }

    @Override // com.smartdigimkt.i0.h
    public final long f() {
        return this.b.f();
    }

    @Override // com.smartdigimkt.i0.h
    public final int g() {
        return this.b.g();
    }

    public final long h() {
        try {
            return this.b.h();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public final boolean i() {
        k kVar = this.b;
        return kVar.p.h == 3 && kVar.k;
    }

    public final void j() {
        k kVar = this.b;
        kVar.getClass();
        Integer.toHexString(System.identityHashCode(kVar));
        int i = com.smartdigimkt.z0.u.a;
        synchronized (q.class) {
            int i2 = q.a;
        }
        kVar.e.f();
        kVar.d.removeCallbacksAndMessages(null);
        TextureView textureView = this.l;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() == this.d) {
                this.l.setSurfaceTextureListener(null);
            }
            this.l = null;
        }
        Surface surface = this.j;
        if (surface != null) {
            if (this.k) {
                surface.release();
            }
            this.j = null;
        }
        com.smartdigimkt.v0.j jVar = this.m;
        if (jVar != null) {
            jVar.a(this.i);
        }
    }

    public final void k() {
        k kVar = this.b;
        z zVarA = kVar.a(false, false, 1);
        kVar.l++;
        kVar.e.f.a.obtainMessage(6, 0, 0).sendToTarget();
        kVar.a(zVarA, false, 4, 1, false, false);
        com.smartdigimkt.v0.j jVar = this.m;
        if (jVar != null) {
            jVar.a(this.i);
            this.m = null;
            com.smartdigimkt.j0.c cVar = this.i;
            cVar.getClass();
            for (com.smartdigimkt.j0.b bVar : new ArrayList(cVar.d.a)) {
                cVar.b(bVar.a, bVar.b);
            }
        }
    }

    public final void a(com.smartdigimkt.v0.j jVar) {
        com.smartdigimkt.v0.j jVar2 = this.m;
        if (jVar2 != jVar) {
            if (jVar2 != null) {
                jVar2.a(this.i);
                com.smartdigimkt.j0.c cVar = this.i;
                cVar.getClass();
                for (com.smartdigimkt.j0.b bVar : new ArrayList(cVar.d.a)) {
                    cVar.b(bVar.a, bVar.b);
                }
            }
            Handler handler = this.c;
            com.smartdigimkt.j0.c cVar2 = this.i;
            com.smartdigimkt.v0.x xVar = jVar.b;
            xVar.getClass();
            if (handler != null && cVar2 != null) {
                xVar.c.add(new com.smartdigimkt.v0.w(handler, cVar2));
                this.m = jVar;
            } else {
                throw new IllegalArgumentException();
            }
        }
        k kVar = this.b;
        z zVarA = kVar.a(true, true, 2);
        kVar.m = true;
        kVar.l++;
        kVar.e.f.a.obtainMessage(0, 1, 1, jVar).sendToTarget();
        kVar.a(zVarA, false, 4, 1, false, false);
    }

    public final void a(boolean z) {
        k kVar = this.b;
        if (kVar.k != z) {
            kVar.k = z;
            kVar.e.f.a.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            kVar.a(kVar.p, false, 4, 1, false, true);
        }
    }

    @Override // com.smartdigimkt.i0.h
    public final int a() {
        return this.b.a();
    }

    public final void a(TextureView textureView) {
        TextureView textureView2 = this.l;
        if (textureView2 != null) {
            if (textureView2.getSurfaceTextureListener() == this.d) {
                this.l.setSurfaceTextureListener(null);
            }
            this.l = null;
        }
        this.l = textureView;
        if (textureView == null) {
            a(null, true);
            return;
        }
        textureView.getSurfaceTextureListener();
        textureView.setSurfaceTextureListener(this.d);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        a(surfaceTexture != null ? new Surface(surfaceTexture) : null, true);
    }

    public final void a(Surface surface, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (a aVar : this.a) {
            if (aVar.a == 2) {
                k kVar = this.b;
                e0 e0Var = new e0(kVar.e, aVar, kVar.p.c, kVar.c(), kVar.f);
                boolean z2 = !e0Var.f;
                if (z2) {
                    e0Var.c = 1;
                    if (z2) {
                        e0Var.d = surface;
                        arrayList.add(e0Var.b());
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        }
        Surface surface2 = this.j;
        if (surface2 != null && surface2 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((e0) it.next()).a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                k kVar2 = this.b;
                z zVarA = kVar2.a(false, false, 1);
                kVar2.l++;
                kVar2.e.f.a.obtainMessage(6, 0, 0).sendToTarget();
                kVar2.a(zVarA, false, 4, 1, false, false);
            }
            if (this.k) {
                this.j.release();
            }
        }
        this.j = surface;
        this.k = z;
    }
}
