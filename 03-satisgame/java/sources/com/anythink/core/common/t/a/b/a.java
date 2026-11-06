package com.anythink.core.common.t.a.b;

import com.anythink.core.common.h.o;
import com.anythink.core.common.h.u;
import com.anythink.core.common.t.a.b.a.b;
import com.anythink.core.common.t.a.b.a.c;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final int a = 5;
    private static volatile a d;
    private final com.anythink.core.common.t.a.b.a.c.a<com.anythink.core.common.t.a.b.a.a> b = new com.anythink.core.common.t.a.b.a.c.a<>(new com.anythink.core.common.t.a.b.a.c.a.InterfaceC0051a<com.anythink.core.common.t.a.b.a.a>() { // from class: com.anythink.core.common.t.a.b.a.1
        private static com.anythink.core.common.t.a.b.a.a b() {
            return new com.anythink.core.common.t.a.b.a.a();
        }

        @Override // com.anythink.core.common.t.a.b.a.c.a.InterfaceC0051a
        public final /* synthetic */ b a() {
            return new com.anythink.core.common.t.a.b.a.a();
        }
    });
    private final com.anythink.core.common.t.a.b.a.c.a<c> c = new com.anythink.core.common.t.a.b.a.c.a<>(new com.anythink.core.common.t.a.b.a.c.a.InterfaceC0051a<c>() { // from class: com.anythink.core.common.t.a.b.a.2
        private static c b() {
            return new c();
        }

        @Override // com.anythink.core.common.t.a.b.a.c.a.InterfaceC0051a
        public final /* synthetic */ b a() {
            return new c();
        }
    });

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public final void a(u uVar) throws Throwable {
        com.anythink.core.common.t.a.b.a.a aVar = null;
        try {
            com.anythink.core.common.t.a.b.a.a aVar2 = (com.anythink.core.common.t.a.b.a.a) this.b.a();
            try {
                aVar2.d(uVar);
                if (aVar2 != null) {
                    this.b.a(aVar2);
                }
            } catch (Throwable th) {
                th = th;
                aVar = aVar2;
                if (aVar != null) {
                    this.b.a(aVar);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void a(o oVar) throws Throwable {
        c cVar = null;
        try {
            c cVar2 = (c) this.c.a();
            try {
                cVar2.d(oVar);
                if (cVar2 != null) {
                    this.c.a(cVar2);
                }
            } catch (Throwable th) {
                th = th;
                cVar = cVar2;
                if (cVar != null) {
                    this.c.a(cVar);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(boolean z) {
        new com.anythink.core.common.t.a.b.a.b.c().a(z);
    }

    public static void b(boolean z) {
        new com.anythink.core.common.t.a.b.a.b.b().a(z);
    }
}
