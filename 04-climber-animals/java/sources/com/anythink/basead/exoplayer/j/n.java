package com.anythink.basead.exoplayer.j;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.anythink.basead.exoplayer.k.af;

/* JADX INFO: loaded from: classes.dex */
public final class n implements h {
    private static final String a = "DefaultDataSource";
    private static final String b = "asset";
    private static final String c = "content";
    private static final String d = "rtmp";
    private static final String e = "rawresource";
    private final Context f;
    private final aa<? super h> g;
    private final h h;
    private h i;
    private h j;
    private h k;
    private h l;
    private h m;
    private h n;
    private h o;

    private n(Context context, aa<? super h> aaVar, String str, boolean z) {
        this(context, aaVar, str, z, (byte) 0);
    }

    private n(Context context, aa<? super h> aaVar, String str, boolean z, byte b2) {
        this(context, aaVar, new p(str, null, aaVar, 8000, 8000, z, null));
    }

    public n(Context context, aa<? super h> aaVar, h hVar) {
        this.f = context.getApplicationContext();
        this.g = aaVar;
        this.h = (h) com.anythink.basead.exoplayer.k.a.a(hVar);
    }

    @Override // com.anythink.basead.exoplayer.j.h
    public final long a(k kVar) {
        com.anythink.basead.exoplayer.k.a.b(this.o == null);
        String scheme = kVar.c.getScheme();
        if (af.a(kVar.c)) {
            if (kVar.c.getPath().startsWith("/android_asset/")) {
                this.o = d();
            } else {
                if (this.i == null) {
                    this.i = new r(this.g);
                }
                this.o = this.i;
            }
        } else if (b.equals(scheme)) {
            this.o = d();
        } else if (!"content".equals(scheme)) {
            if ("rtmp".equals(scheme)) {
                this.o = f();
            } else if (!"data".equals(scheme)) {
                if (!"rawresource".equals(scheme)) {
                    this.o = this.h;
                } else {
                    if (this.n == null) {
                        this.n = new y(this.f, this.g);
                    }
                    this.o = this.n;
                }
            } else {
                if (this.m == null) {
                    this.m = new f();
                }
                this.o = this.m;
            }
        } else {
            if (this.k == null) {
                this.k = new e(this.f, this.g);
            }
            this.o = this.k;
        }
        return this.o.a(kVar);
    }

    @Override // com.anythink.basead.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        return this.o.a(bArr, i, i2);
    }

    @Override // com.anythink.basead.exoplayer.j.h
    public final Uri a() {
        h hVar = this.o;
        if (hVar == null) {
            return null;
        }
        return hVar.a();
    }

    @Override // com.anythink.basead.exoplayer.j.h
    public final void b() {
        h hVar = this.o;
        if (hVar != null) {
            try {
                hVar.b();
            } finally {
                this.o = null;
            }
        }
    }

    private h c() {
        if (this.i == null) {
            this.i = new r(this.g);
        }
        return this.i;
    }

    private h d() {
        if (this.j == null) {
            this.j = new c(this.f, this.g);
        }
        return this.j;
    }

    private h e() {
        if (this.k == null) {
            this.k = new e(this.f, this.g);
        }
        return this.k;
    }

    private h f() {
        if (this.l == null) {
            try {
                this.l = (h) Class.forName("com.anythink.expressad.exoplayer.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
                Log.w(a, "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.l == null) {
                this.l = this.h;
            }
        }
        return this.l;
    }

    private h g() {
        if (this.m == null) {
            this.m = new f();
        }
        return this.m;
    }

    private h h() {
        if (this.n == null) {
            this.n = new y(this.f, this.g);
        }
        return this.n;
    }
}
