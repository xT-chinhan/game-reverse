package com.anythink.core.common.r.b;

import com.anythink.core.common.r.a.h;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static volatile boolean a = false;

    private static void a() {
        if (a) {
            return;
        }
        a = true;
        com.anythink.core.common.u.b.c cVarA = com.anythink.core.common.u.b.c.a();
        h.a(new AnonymousClass1(cVarA));
        h.b(new AnonymousClass2(cVarA));
        h.a(new a());
    }

    /* JADX INFO: renamed from: com.anythink.core.common.r.b.d$1, reason: invalid class name */
    final class AnonymousClass1 implements Executor {
        final /* synthetic */ com.anythink.core.common.u.b.c a;

        AnonymousClass1(com.anythink.core.common.u.b.c cVar) {
            this.a = cVar;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            com.anythink.core.common.u.b.d dVar;
            if (runnable instanceof com.anythink.core.common.u.b.d) {
                dVar = (com.anythink.core.common.u.b.d) runnable;
            } else {
                dVar = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dB, runnable);
            }
            this.a.e(dVar);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.r.b.d$2, reason: invalid class name */
    final class AnonymousClass2 implements Executor {
        final /* synthetic */ com.anythink.core.common.u.b.c a;

        AnonymousClass2(com.anythink.core.common.u.b.c cVar) {
            this.a = cVar;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            com.anythink.core.common.u.b.d dVar;
            if (runnable instanceof com.anythink.core.common.u.b.d) {
                dVar = (com.anythink.core.common.u.b.d) runnable;
            } else {
                dVar = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dC, runnable);
            }
            this.a.i(dVar);
        }
    }

    public static f b(com.anythink.core.common.r.c cVar) {
        if (cVar != null) {
            return new f(cVar);
        }
        return null;
    }

    public static com.anythink.core.common.r.a c(com.anythink.core.common.r.c cVar) {
        if (cVar != null) {
            return new e(cVar);
        }
        return null;
    }

    static class a implements com.anythink.core.common.r.a.a.c {
        @Override // com.anythink.core.common.r.a.a.c
        public final void a(String str, Exception exc) {
        }

        @Override // com.anythink.core.common.r.a.a.c
        public final void a(String str, String str2) {
        }

        @Override // com.anythink.core.common.r.a.a.c
        public final void b(String str, Exception exc) {
        }

        a() {
        }
    }

    public static c a(com.anythink.core.common.r.c cVar) {
        if (cVar == null) {
            return null;
        }
        if (!a) {
            a = true;
            com.anythink.core.common.u.b.c cVarA = com.anythink.core.common.u.b.c.a();
            h.a(new AnonymousClass1(cVarA));
            h.b(new AnonymousClass2(cVarA));
            h.a(new a());
        }
        return new c(cVar);
    }
}
