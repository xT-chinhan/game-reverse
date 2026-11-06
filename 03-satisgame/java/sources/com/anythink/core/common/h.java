package com.anythink.core.common;

import com.anythink.core.common.h.by;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    private final String a = getClass().getSimpleName();
    private String b;
    private d c;
    private b d;
    private boolean e;
    private boolean f;
    private long g;
    private long h;
    private long i;
    private boolean j;
    private final g k;
    private boolean l;

    public interface b {
        void a(com.anythink.core.c.d dVar, int i);
    }

    public interface d {
        void a(g gVar);
    }

    static /* synthetic */ boolean f(h hVar) {
        hVar.j = true;
        return true;
    }

    static /* synthetic */ boolean g(h hVar) {
        hVar.e = false;
        return false;
    }

    public h(String str, g gVar) {
        this.b = str;
        this.k = gVar;
    }

    public final void a(com.anythink.core.e.l lVar, boolean z) {
        if (lVar == null) {
            this.f = false;
            return;
        }
        this.l = z;
        this.f = lVar.b() == 1;
        this.g = lVar.e();
        this.h = lVar.f();
        this.i = lVar.d();
        if (this.f) {
            return;
        }
        this.g = 0L;
        this.h = 0L;
        this.i = 0L;
    }

    private static boolean a(List<by> list, by byVar) {
        return list == null || list.isEmpty() || com.anythink.core.common.u.k.a(byVar, list.get(0)) == -1;
    }

    public final void a() {
        this.e = true;
        new c();
    }

    public class c {
        public c() {
            if (!h.this.f) {
                h.this.b();
            } else {
                com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aI, new Runnable() { // from class: com.anythink.core.common.h.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.this.b();
                    }
                }), h.this.i);
            }
        }
    }

    public final synchronized void b() {
        com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aG, new Runnable() { // from class: com.anythink.core.common.h.1
            @Override // java.lang.Runnable
            public final void run() {
                if (h.this.c != null && !h.this.j) {
                    h.this.c.a(h.this.k);
                }
                h.f(h.this);
                h.g(h.this);
            }
        }));
    }

    private void a(com.anythink.core.c.d dVar, int i) {
        if (dVar != null) {
            new a(dVar, i);
        }
    }

    public class a {
        private boolean b;
        private com.anythink.core.c.d c;
        private int d;

        static /* synthetic */ boolean c(a aVar) {
            aVar.b = true;
            return true;
        }

        public a(com.anythink.core.c.d dVar, int i) {
            this.c = dVar;
            this.d = i;
            if (!h.this.f) {
                a();
            } else {
                com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aH, new Runnable() { // from class: com.anythink.core.common.h.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.a();
                    }
                }), 2 == i ? h.this.g : h.this.h);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void a() {
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aJ, new Runnable() { // from class: com.anythink.core.common.h.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.b) {
                        return;
                    }
                    a.c(a.this);
                    if (h.this.d != null) {
                        h.this.d.a(a.this.c, a.this.d);
                    }
                }
            }));
        }
    }

    public final long c() {
        if (this.f) {
            return Math.max(this.h, this.g);
        }
        return 0L;
    }

    public final void a(d dVar) {
        this.c = dVar;
    }

    public final void a(b bVar) {
        this.d = bVar;
    }

    public final boolean d() {
        return this.e;
    }

    private void a(boolean z) {
        this.f = z;
    }

    public final boolean e() {
        return this.f;
    }
}
