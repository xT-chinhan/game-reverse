package com.anythink.basead.h;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.x;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements a {
    public static final String h = "extra_request_id";
    public static final String i = "extra_scenario";
    public static final String j = "extra_orientation";
    public String b = getClass().getSimpleName();
    protected Context c;
    protected x d;
    protected String e;
    protected boolean f;
    protected ay g;

    public void c() {
    }

    public c(Context context, x xVar, String str, boolean z) {
        this.c = context.getApplicationContext();
        this.d = xVar;
        this.e = str;
        this.f = z;
    }

    @Override // com.anythink.basead.h.a
    public boolean a() {
        try {
            if (d()) {
                return com.anythink.basead.h.a.a.a(this.c).a(this.g, this.d, this.f);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private com.anythink.basead.d.f b() {
        if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.d.b)) {
            return com.anythink.basead.d.g.a(com.anythink.basead.d.g.i, com.anythink.basead.d.g.A);
        }
        ay ayVarA = com.anythink.basead.h.a.a.a(this.c).a(this.d.b, this.e);
        this.g = ayVarA;
        if (ayVarA == null) {
            return com.anythink.basead.d.g.a(com.anythink.basead.d.g.i, com.anythink.basead.d.g.D);
        }
        if (this.d.o == null) {
            return com.anythink.basead.d.g.a(com.anythink.basead.d.g.j, com.anythink.basead.d.g.E);
        }
        return null;
    }

    protected final boolean d() {
        if (this.c == null || TextUtils.isEmpty(this.d.b) || TextUtils.isEmpty(this.e)) {
            return false;
        }
        if (this.g != null) {
            return true;
        }
        ay ayVarA = com.anythink.basead.h.a.a.a(this.c).a(this.d.b, this.e);
        this.g = ayVarA;
        return ayVarA != null;
    }

    public final ay e() {
        return this.g;
    }

    public final int f() {
        return com.anythink.basead.b.e.d(this.g, this.d);
    }

    @Override // com.anythink.basead.h.a
    public final void a(final com.anythink.basead.g.c cVar) {
        com.anythink.basead.d.f fVarA;
        try {
            if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.d.b)) {
                fVarA = com.anythink.basead.d.g.a(com.anythink.basead.d.g.i, com.anythink.basead.d.g.A);
            } else {
                ay ayVarA = com.anythink.basead.h.a.a.a(this.c).a(this.d.b, this.e);
                this.g = ayVarA;
                if (ayVarA == null) {
                    fVarA = com.anythink.basead.d.g.a(com.anythink.basead.d.g.i, com.anythink.basead.d.g.D);
                } else {
                    fVarA = this.d.o == null ? com.anythink.basead.d.g.a(com.anythink.basead.d.g.j, com.anythink.basead.d.g.E) : null;
                }
            }
            if (fVarA != null) {
                cVar.onAdLoadFailed(fVarA);
            } else {
                com.anythink.basead.h.a.a.a(this.c).a(this.d.b, this.g, this.d, new com.anythink.basead.b.c.c.b() { // from class: com.anythink.basead.h.c.1
                    @Override // com.anythink.basead.b.c.c.b
                    public final void a() {
                        s sVarC = t.b().c();
                        if (sVarC != null && sVarC.a()) {
                            sVarC.fillDataFetchStatus(c.this.c, c.this.g, c.this.d);
                        }
                        com.anythink.basead.g.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onAdCacheLoaded();
                        }
                    }

                    @Override // com.anythink.basead.b.c.c.b
                    public final void a(com.anythink.basead.d.f fVar) {
                        com.anythink.basead.g.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onAdLoadFailed(fVar);
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            cVar.onAdLoadFailed(com.anythink.basead.d.g.a("-9999", e.getMessage()));
        }
    }
}
