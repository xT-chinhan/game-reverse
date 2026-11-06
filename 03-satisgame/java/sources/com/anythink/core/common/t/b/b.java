package com.anythink.core.common.t.b;

import com.anythink.core.common.d.s;
import com.anythink.core.common.h.n;

/* JADX INFO: loaded from: classes.dex */
class b implements a {
    private static final String a = "b";
    private static final long b = 3000;
    private final f c;

    public b(f fVar) {
        this.c = fVar;
    }

    @Override // com.anythink.core.common.t.b.a
    public final void a(e eVar) {
        eVar.d = System.currentTimeMillis();
    }

    @Override // com.anythink.core.common.t.b.a
    public final void b(e eVar) {
        eVar.e = true;
        eVar.f = System.currentTimeMillis();
        if (c(eVar.c)) {
            String str = eVar.a;
            if (this.c.b(str)) {
                return;
            }
            this.c.a(str, new AnonymousClass1(eVar, str));
        }
    }

    @Override // com.anythink.core.common.t.b.a
    public final void c(e eVar) {
        eVar.g = true;
    }

    @Override // com.anythink.core.common.t.b.a
    public final void d(e eVar) {
        eVar.h = true;
    }

    @Override // com.anythink.core.common.t.b.a
    public final boolean e(e eVar) {
        a(eVar.a);
        return false;
    }

    @Override // com.anythink.core.common.t.b.a
    public final void a(String str) {
        this.c.a(str);
    }

    private void g(e eVar) {
        String str = eVar.a;
        if (this.c.b(str)) {
            return;
        }
        this.c.a(str, new AnonymousClass1(eVar, str));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.t.b.b$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ e a;
        final /* synthetic */ String b;

        AnonymousClass1(e eVar, String str) {
            this.a = eVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!this.a.g && this.a.e && b.c(this.a.c)) {
                    b.f(this.a);
                }
            } catch (Throwable unused) {
            }
            b.this.a(this.b);
        }
    }

    private static void h(e eVar) {
        n nVar = eVar.b;
        if (eVar.i) {
            return;
        }
        nVar.aj();
        com.anythink.core.common.t.e.a(s.b().g());
        com.anythink.core.common.t.e.a(6, nVar);
        eVar.i = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(String str) {
        return "2".equals(str) || "0".equals(str);
    }

    static /* synthetic */ void f(e eVar) {
        n nVar = eVar.b;
        if (eVar.i) {
            return;
        }
        nVar.aj();
        com.anythink.core.common.t.e.a(s.b().g());
        com.anythink.core.common.t.e.a(6, nVar);
        eVar.i = true;
    }
}
