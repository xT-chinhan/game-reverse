package com.anythink.core.common.u;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    private volatile boolean a;
    private volatile boolean d;
    private volatile boolean f;
    private final com.anythink.core.common.s.a b = com.anythink.core.common.s.c.a();
    private final com.anythink.core.common.u.b.d c = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dn, new Runnable() { // from class: com.anythink.core.common.u.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.a) {
                return;
            }
            b.b(b.this);
            b.this.d();
        }
    });
    private final com.anythink.core.common.u.b.d e = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.f1do, new Runnable() { // from class: com.anythink.core.common.u.b.2
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.d) {
                return;
            }
            b.d(b.this);
            b.this.e();
        }
    });
    private final com.anythink.core.common.u.b.d g = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dp, new Runnable() { // from class: com.anythink.core.common.u.b.3
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.f) {
                return;
            }
            b.f(b.this);
            b.this.f();
        }
    });

    protected abstract void d();

    protected abstract void e();

    protected abstract void f();

    static /* synthetic */ boolean b(b bVar) {
        bVar.a = true;
        return true;
    }

    static /* synthetic */ boolean d(b bVar) {
        bVar.d = true;
        return true;
    }

    static /* synthetic */ boolean f(b bVar) {
        bVar.f = true;
        return true;
    }

    protected final synchronized void a(long j) {
        this.b.a(this.c, j);
    }

    public final synchronized void a() {
        this.b.a(this.c);
    }

    private boolean h() {
        return this.a;
    }

    protected final synchronized void b(long j) {
        this.b.a(this.e, j);
    }

    public final synchronized void b() {
        this.b.a(this.e);
    }

    public final boolean c() {
        return this.d;
    }

    protected final synchronized void c(long j) {
        this.b.a(this.g, j);
    }

    public final synchronized void g() {
        this.b.a(this.g);
    }

    private boolean i() {
        return this.f;
    }
}
