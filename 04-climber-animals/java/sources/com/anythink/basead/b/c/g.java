package com.anythink.basead.b.c;

import android.text.TextUtils;
import com.anythink.basead.d.j;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;

/* JADX INFO: loaded from: classes.dex */
public class g {
    long b;
    String c;
    com.anythink.core.common.res.b.a.C0098a d;
    private String e;
    private String f;
    private String g;
    private int h;
    private w i;
    private y j;
    private x k;
    private com.anythink.core.common.res.b.a l;
    final String a = com.anythink.basead.f.g.i;
    private long m = 0;

    public g(String str, final w wVar, y yVar, final x xVar) {
        this.c = "";
        this.e = wVar.E();
        this.i = wVar;
        this.j = yVar;
        this.k = xVar;
        this.f = str;
        this.g = wVar.v();
        this.h = wVar.b();
        if (wVar instanceof bj) {
            this.c = ((bj) wVar).aC();
        }
        this.l = com.anythink.core.common.res.b.c.a().a(this.e);
        this.b = 0L;
        if (TextUtils.equals(String.valueOf(yVar.D()), "4") && yVar.aH() != 1 && yVar.aa() > 0) {
            this.b = yVar.x();
        }
        this.l.a(new com.anythink.core.common.res.b.b(this.j.aa(), this.j.ac(), this.b));
        this.l.a(new com.anythink.core.common.res.b.a.b() { // from class: com.anythink.basead.b.c.g.1
            @Override // com.anythink.core.common.res.b.a.b
            public final boolean a(int i, long j, long j2) {
                if (i < g.this.j.aa()) {
                    return false;
                }
                if (g.this.d != null) {
                    com.anythink.core.common.u.e.a(wVar, xVar, true, "", j2, j, System.currentTimeMillis() - g.this.m, g.this.d.b(), g.this.d.c(), g.this.d.d());
                } else {
                    com.anythink.core.common.u.e.a(wVar, xVar, j2, j, System.currentTimeMillis() - g.this.m);
                }
                e.a().a(g.this.e, i);
                return true;
            }

            @Override // com.anythink.core.common.res.b.a.b
            public final void a(String str2, String str3) {
                com.anythink.core.common.u.e.a(wVar, xVar, str3);
            }

            @Override // com.anythink.core.common.res.b.a.b
            public final void a(com.anythink.core.common.res.b.a.C0098a c0098a) {
                if (c0098a != null) {
                    g.this.d = c0098a;
                    if (g.this.b <= 0 || g.this.b != g.this.d.a()) {
                        return;
                    }
                    String unused = g.this.g;
                    String unused2 = g.this.e;
                    c0098a.b();
                    c0098a.d();
                    g.this.j.O(g.this.d.d());
                }
            }
        });
        this.l.k = new com.anythink.core.common.res.b.a.c() { // from class: com.anythink.basead.b.c.g.2
            @Override // com.anythink.core.common.res.b.a.c
            public final void a() {
                com.anythink.basead.b.b.a(30, wVar, new j("", ""));
            }

            @Override // com.anythink.core.common.res.b.a.c
            public final void a(String str2, String str3) {
                e.a().a(g.this.e, com.anythink.basead.d.g.a(str2, str3));
            }
        };
    }

    public final void a() {
        this.m = System.currentTimeMillis();
        this.l.e();
    }
}
