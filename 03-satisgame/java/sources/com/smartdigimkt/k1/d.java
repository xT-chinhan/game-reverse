package com.smartdigimkt.k1;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.z.c0;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public final Context a;
    public final com.smartdigimkt.a3.a b;
    public final String c;
    public final boolean d;
    public com.smartdigimkt.e3.a e;
    public com.smartdigimkt.f3.a f;
    public boolean g;
    public Map h;

    public d(Context context, com.smartdigimkt.a3.a aVar, String str, boolean z) {
        this.a = context.getApplicationContext();
        this.b = aVar;
        this.c = str;
        this.d = z;
    }

    public final boolean a() {
        if (this.a == null || TextUtils.isEmpty(this.b.b) || TextUtils.isEmpty(this.c)) {
            return false;
        }
        if (this.e != null) {
            return true;
        }
        com.smartdigimkt.l1.b bVarA = com.smartdigimkt.l1.b.a(this.a);
        String str = this.b.b;
        String str2 = this.c;
        bVarA.getClass();
        com.smartdigimkt.e3.a aVarA = com.smartdigimkt.l1.b.a(str, str2);
        this.e = aVarA;
        return aVarA != null;
    }

    public final com.smartdigimkt.h0.g b() {
        if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.b.b)) {
            return new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.i, com.anythink.core.common.inner.b.b.A);
        }
        com.smartdigimkt.l1.b bVarA = com.smartdigimkt.l1.b.a(this.a);
        String str = this.b.b;
        String str2 = this.c;
        bVarA.getClass();
        com.smartdigimkt.e3.a aVarA = com.smartdigimkt.l1.b.a(str, str2);
        this.e = aVarA;
        if (aVarA == null) {
            return new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.i, com.anythink.core.common.inner.b.b.D);
        }
        if (this.b.s == null) {
            return new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.j, com.anythink.core.common.inner.b.b.E);
        }
        return null;
    }

    public void c() {
        this.g = true;
        com.smartdigimkt.p3.e eVar = this.b.a;
        if (eVar != null) {
            eVar.c();
        }
    }

    public boolean d() {
        try {
            if (a()) {
                return com.smartdigimkt.l1.b.a(this.a).a(this.e, this.b, this.d);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void e() {
        if (this.g || this.f == null || this.e == null || this.b.a != null) {
            return;
        }
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        com.smartdigimkt.p3.f fVar = aVarA == null ? new com.smartdigimkt.p3.f(null) : aVarA.e;
        this.f.i0 = c0.a(this.e, this.b);
        com.smartdigimkt.a3.a aVar = this.b;
        aVar.a = new com.smartdigimkt.p3.e(aVar, this.e, this.f, fVar);
        com.smartdigimkt.f3.a aVar2 = this.f;
        com.smartdigimkt.p3.e eVar = this.b.a;
        aVar2.a = eVar;
        eVar.i();
    }
}
