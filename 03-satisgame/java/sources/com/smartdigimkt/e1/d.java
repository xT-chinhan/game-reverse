package com.smartdigimkt.e1;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.b3.k;
import com.smartdigimkt.b3.l;
import com.smartdigimkt.d0.s;
import com.smartdigimkt.j1.t;
import com.smartdigimkt.k.u;
import com.smartdigimkt.sdk.basead.ui.BaseSplashATView;
import com.smartdigimkt.sdk.basead.ui.SdkBannerATView;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public final Context b;
    public final com.smartdigimkt.a3.a c;
    public e d;
    public com.smartdigimkt.b3.b e;
    public t f;
    public Map h;
    public com.smartdigimkt.g1.c i;
    public final com.smartdigimkt.p4.g j;
    public final com.smartdigimkt.d3.c k;
    public com.smartdigimkt.f3.a l;
    public k m;
    public boolean g = false;
    public int n = -1;
    public final AtomicBoolean o = new AtomicBoolean(false);
    public final int a = 1;

    public d(Context context, com.smartdigimkt.a3.a aVar, com.smartdigimkt.p4.g gVar) {
        this.b = context.getApplicationContext();
        this.c = aVar;
        this.j = gVar;
        this.k = gVar.a;
    }

    public static void a(d dVar, String str, com.smartdigimkt.b3.b bVar, String str2, boolean z, int i) {
        dVar.getClass();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            k kVarA = com.smartdigimkt.n3.b.a().a(str);
            kVarA.f = bVar != null ? bVar.a : "";
            boolean z2 = false;
            int i2 = 1;
            kVarA.g = (bVar == null || bVar.k0 != 1) ? 1 : 0;
            kVarA.h = str2;
            kVarA.i = z;
            kVarA.j = TextUtils.equals(String.valueOf(dVar.c.c), "0") ? 0 : -1;
            if (bVar != null && bVar.h()) {
                z2 = true;
            }
            if (i == 7 || i == 8) {
                if (!z2) {
                    i2 = 2;
                }
            } else if (i < 0) {
                i2 = -1;
            } else {
                i2 = z2 ? 3 : 4;
            }
            kVarA.k = i2;
            dVar.m = kVarA;
            dVar.n = i;
        } catch (Throwable th) {
            try {
                th.toString();
            } finally {
                com.smartdigimkt.n3.b.a().b.remove(str);
            }
        }
    }

    public final int b() {
        l lVar;
        if (u.a(this.a) != 0) {
            return 3;
        }
        if (this.e == null) {
            com.smartdigimkt.q3.f.a().getClass();
            if (com.smartdigimkt.q3.f.c()) {
                return 0;
            }
            this.e = com.smartdigimkt.f1.d.a(this.b).a(this.c);
        }
        com.smartdigimkt.b3.b bVar = this.e;
        if (bVar == null) {
            return 0;
        }
        if (bVar.j()) {
            return 1;
        }
        if (this.i == null) {
            this.i = new com.smartdigimkt.g1.c(this.e, this.c);
        }
        if (this.o.get()) {
            return 2;
        }
        if (this.g) {
            return -1;
        }
        com.smartdigimkt.g1.c cVar = this.i;
        if (cVar == null || (lVar = cVar.a) == null || !s.a(lVar, cVar.b)) {
            return 3;
        }
        this.g = true;
        return -1;
    }

    public final void c() {
        com.smartdigimkt.d3.c cVar;
        if (!this.o.compareAndSet(false, true) || (cVar = this.k) == null || TextUtils.isEmpty(cVar.e)) {
            return;
        }
        com.smartdigimkt.t2.e eVarA = com.smartdigimkt.t2.e.a();
        Context contextD = SDKContext.getInstance().d();
        String str = this.k.e;
        eVarA.getClass();
        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.c(eVarA, contextD, str));
    }

    public final void d() {
        com.smartdigimkt.a3.a aVar = this.c;
        if (aVar == null || this.l == null || aVar.a != null) {
            return;
        }
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        com.smartdigimkt.p3.f fVar = aVarA == null ? new com.smartdigimkt.p3.f(null) : aVarA.e;
        com.smartdigimkt.a3.a aVar2 = this.c;
        aVar2.a = new com.smartdigimkt.p3.e(aVar2, this.e, this.l, fVar);
        com.smartdigimkt.f3.a aVar3 = this.l;
        com.smartdigimkt.p3.e eVar = this.c.a;
        aVar3.a = eVar;
        eVar.i();
    }

    public void a(e eVar) {
        this.d = eVar;
    }

    public final boolean a(int i) {
        if (i != -1) {
            return false;
        }
        com.smartdigimkt.d3.c cVar = this.k;
        return cVar == null || !cVar.w;
    }

    public void a() {
        com.smartdigimkt.p3.e eVar;
        com.smartdigimkt.a3.a aVar = this.c;
        if (aVar != null && (eVar = aVar.a) != null) {
            eVar.c();
        }
        t tVar = this.f;
        if (tVar instanceof t) {
            tVar.h = true;
            tVar.g = null;
        }
        this.f = null;
        com.smartdigimkt.g1.c cVar = this.i;
        if (cVar != null) {
            BaseSplashATView baseSplashATView = cVar.d;
            if (baseSplashATView != null) {
                baseSplashATView.destroy();
                cVar.d = null;
            }
            SdkBannerATView sdkBannerATView = cVar.e;
            if (sdkBannerATView != null) {
                sdkBannerATView.destroy();
                cVar.e = null;
            }
            this.i = null;
        }
    }
}
