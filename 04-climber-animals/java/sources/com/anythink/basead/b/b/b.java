package com.anythink.basead.b.b;

import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.common.d.t;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class b implements com.anythink.basead.b.c.a {
    com.anythink.basead.b.c.a a;
    boolean b = false;
    boolean c = false;
    boolean d = false;
    private final AtomicBoolean e;
    private boolean f;

    public b() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.e = atomicBoolean;
        this.f = false;
        atomicBoolean.set(false);
        this.f = false;
        g();
    }

    public final void d() {
        this.e.set(true);
        g();
    }

    public final boolean e() {
        return this.e.get();
    }

    private void g() {
        this.b = false;
        this.c = false;
        this.d = false;
    }

    public final void a(com.anythink.basead.b.c.a aVar) {
        this.a = aVar;
    }

    @Override // com.anythink.basead.b.c.a
    public final void a() {
        if (this.f || this.b) {
            return;
        }
        this.b = true;
        com.anythink.basead.b.c.a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.anythink.basead.b.c.a
    public final void b() {
        if (this.f || this.c) {
            return;
        }
        this.c = true;
        t.b().b(new Runnable() { // from class: com.anythink.basead.b.b.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.b();
                }
            }
        });
    }

    @Override // com.anythink.basead.b.c.a
    public final void c() {
        this.e.set(false);
        if (this.f || this.d) {
            return;
        }
        this.d = true;
        t.b().b(new Runnable() { // from class: com.anythink.basead.b.b.b.2
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.a != null) {
                    b.this.a.c();
                }
            }
        });
    }

    @Override // com.anythink.basead.b.c.a
    public final void a(boolean z) {
        com.anythink.basead.b.c.a aVar;
        if (this.f || (aVar = this.a) == null) {
            return;
        }
        aVar.a(z);
    }

    @Override // com.anythink.basead.b.c.a
    public final boolean a(String str, IOfferClickHandler iOfferClickHandler) {
        com.anythink.basead.b.c.a aVar = this.a;
        if (aVar != null) {
            return aVar.a(str, iOfferClickHandler);
        }
        return false;
    }

    public final void f() {
        this.a = null;
        this.e.set(false);
        this.f = true;
    }
}
