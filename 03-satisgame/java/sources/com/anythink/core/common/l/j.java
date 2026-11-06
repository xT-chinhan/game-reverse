package com.anythink.core.common.l;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.cg;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class j extends b {
    public static final int c = 1;
    String a;
    int b;
    boolean l;
    private cg m;

    @Override // com.anythink.core.common.l.b
    protected final int a() {
        return 2;
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, String> c() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final byte[] d() {
        return new byte[0];
    }

    @Override // com.anythink.core.common.l.b
    protected final String e() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final Context f() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final String g() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final Map<String, Object> h() {
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final String k() {
        return "";
    }

    @Override // com.anythink.core.common.l.b
    protected final void l() {
    }

    private j(String str) {
        this.b = 0;
        this.l = false;
        this.a = str;
    }

    private j(String str, cg cgVar) {
        this(str);
        this.b = 1;
        this.m = cgVar;
    }

    public static j b(String str) {
        return new j(str);
    }

    public static j a(String str, cg cgVar) {
        return new j(str, cgVar);
    }

    @Override // com.anythink.core.common.l.b
    protected final String b() {
        return this.a;
    }

    @Override // com.anythink.core.common.l.b
    protected final Object a(Object obj) {
        cg cgVar;
        if (1 != this.b || (cgVar = this.m) == null) {
            return null;
        }
        cgVar.a("200");
        com.anythink.core.common.u.d.a().a(this.m.y(), this.m.z(), com.anythink.core.common.u.d.c, "0");
        com.anythink.core.c.d.c.a(this.m);
        return null;
    }

    @Override // com.anythink.core.common.l.b
    protected final void a(AdError adError) {
        cg cgVar;
        if (1 != this.b || (cgVar = this.m) == null) {
            return;
        }
        int iK = cgVar.k();
        com.anythink.core.common.h.n nVarY = this.m.y();
        by byVarZ = this.m.z();
        if (iK == 50 && com.anythink.core.common.u.d.a().a(nVarY, byVarZ) && !this.l) {
            this.l = true;
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aE, new Runnable() { // from class: com.anythink.core.common.l.j$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.t();
                }
            }), 3000L);
        } else {
            this.m.a(adError.getPlatformCode());
            this.m.b(adError.getPlatformMSG());
            com.anythink.core.common.u.d.a().a(nVarY, byVarZ, com.anythink.core.common.u.d.c, "1");
            com.anythink.core.c.d.c.a(this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        com.anythink.core.common.u.b.c.a().c(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aF, new Runnable() { // from class: com.anythink.core.common.l.j$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.u();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        a(0, this.i);
    }
}
