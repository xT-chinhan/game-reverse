package com.anythink.core.common.a;

import com.anythink.core.common.d.t;
import com.anythink.core.common.h.r;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static volatile d b;
    final String a = d.class.getName();
    private com.anythink.core.common.e.i c;
    private com.anythink.core.common.e.h d;

    private d() {
        if (t.b().g() != null) {
            this.c = com.anythink.core.common.e.i.a(com.anythink.core.common.e.e.a(t.b().g()));
            this.d = com.anythink.core.common.e.h.a(com.anythink.core.common.e.e.a(t.b().g()));
        }
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public final void a(final r rVar) {
        rVar.aD();
        t.b();
        t.c(new Runnable() { // from class: com.anythink.core.common.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                l lVar = new l();
                lVar.a = rVar.aC();
                lVar.b = rVar.aD();
                lVar.c = rVar.aE();
                lVar.d = 0;
                d.this.c.a(lVar);
            }
        });
    }

    public final void b(final r rVar) {
        rVar.aD();
        t.b();
        t.c(new Runnable() { // from class: com.anythink.core.common.a.d.2
            @Override // java.lang.Runnable
            public final void run() {
                l lVar = new l();
                lVar.a = rVar.aC();
                lVar.b = rVar.aD();
                lVar.c = rVar.aE();
                lVar.d = 1;
                d.this.c.b(lVar);
            }
        });
    }

    public final void b() {
        t.b();
        t.c(new Runnable() { // from class: com.anythink.core.common.a.d.3
            @Override // java.lang.Runnable
            public final void run() {
                d.this.c.a();
            }
        });
    }

    public final List<j> a(int i) {
        return this.c.a(i);
    }

    public final void c(final r rVar) {
        if (rVar.aF() == 1) {
            if (rVar.K() == 1 || rVar.K() == 4) {
                t.b();
                t.c(new Runnable() { // from class: com.anythink.core.common.a.d.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        rVar.aD();
                        k kVar = new k();
                        kVar.a = rVar.aC();
                        kVar.b = rVar.aD();
                        kVar.c = rVar.I();
                        d.this.d.a(kVar);
                    }
                });
                return;
            } else {
                rVar.K();
                return;
            }
        }
        rVar.aF();
    }

    public final List<j> b(int i) {
        return this.d.a(i);
    }
}
