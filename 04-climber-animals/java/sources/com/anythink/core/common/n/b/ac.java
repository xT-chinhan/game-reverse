package com.anythink.core.common.n.b;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
final class ac implements e {
    final z a;
    final ad b;
    final boolean c;
    private com.anythink.core.common.n.b.a.b.j d;
    private boolean e;

    private ac(z zVar, ad adVar, boolean z) {
        this.a = zVar;
        this.b = adVar;
        this.c = z;
    }

    static ac a(z zVar, ad adVar, boolean z) {
        ac acVar = new ac(zVar, adVar, z);
        acVar.d = new com.anythink.core.common.n.b.a.b.j(zVar, acVar);
        return acVar;
    }

    @Override // com.anythink.core.common.n.b.e
    public final ad a() {
        return this.b;
    }

    @Override // com.anythink.core.common.n.b.e
    public final af b() {
        synchronized (this) {
            if (this.e) {
                throw new IllegalStateException("Already Executed");
            }
            this.e = true;
        }
        this.d.b();
        this.d.d();
        try {
            this.a.c.a(this);
            return j();
        } finally {
            this.a.c.b(this);
        }
    }

    @Override // com.anythink.core.common.n.b.e
    public final void a(f fVar) {
        synchronized (this) {
            if (this.e) {
                throw new IllegalStateException("Already Executed");
            }
            this.e = true;
        }
        this.d.d();
        this.a.c.a(new a(fVar));
    }

    @Override // com.anythink.core.common.n.b.e
    public final void c() {
        this.d.i();
    }

    @Override // com.anythink.core.common.n.b.e
    public final com.anythink.core.common.n.c.x f() {
        return this.d.a();
    }

    @Override // com.anythink.core.common.n.b.e
    public final synchronized boolean d() {
        return this.e;
    }

    @Override // com.anythink.core.common.n.b.e
    public final boolean e() {
        return this.d.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.anythink.core.common.n.b.e
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public ac g() {
        return a(this.a, this.b, this.c);
    }

    final class a extends com.anythink.core.common.n.b.a.b {
        static final /* synthetic */ boolean a = true;
        private final f d;
        private volatile AtomicInteger e;

        a(f fVar) {
            super("%s %s", aa.a, ac.this.i());
            this.e = new AtomicInteger(0);
            this.d = fVar;
        }

        final AtomicInteger a() {
            return this.e;
        }

        final void a(a aVar) {
            this.e = aVar.e;
        }

        final String b() {
            return ac.this.b.a.m;
        }

        private ad d() {
            return ac.this.b;
        }

        private ac e() {
            return ac.this;
        }

        final void a(ExecutorService executorService) {
            if (!a && Thread.holdsLock(ac.this.a.c)) {
                throw new AssertionError();
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    ac.this.d.a(interruptedIOException);
                    this.d.a(interruptedIOException);
                    ac.this.a.c.b(this);
                }
            } catch (Throwable th) {
                ac.this.a.c.b(this);
                throw th;
            }
        }

        @Override // com.anythink.core.common.n.b.a.b
        protected final void c() {
            boolean z;
            Throwable th;
            IOException e;
            p pVar;
            ac.this.d.b();
            try {
                try {
                    z = true;
                    try {
                        this.d.a(ac.this.j());
                        pVar = ac.this.a.c;
                    } catch (IOException e2) {
                        e = e2;
                        if (z) {
                            com.anythink.core.common.n.b.a.g.c.e().a(4, "Callback failure for " + ac.this.h(), e);
                        } else {
                            this.d.a(e);
                        }
                        pVar = ac.this.a.c;
                    } catch (Throwable th2) {
                        th = th2;
                        ac.this.c();
                        if (!z) {
                            IOException iOException = new IOException("canceled due to ".concat(String.valueOf(th)));
                            iOException.addSuppressed(th);
                            this.d.a(iOException);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    ac.this.a.c.b(this);
                    throw th3;
                }
            } catch (IOException e3) {
                z = false;
                e = e3;
            } catch (Throwable th4) {
                z = false;
                th = th4;
            }
            pVar.b(this);
        }
    }

    final String h() {
        return (this.d.j() ? "canceled " : "") + (this.c ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + i();
    }

    final String i() {
        return this.b.a.l();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00a1  */
    final af j() throws Throwable {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a.g);
        arrayList.add(new com.anythink.core.common.n.b.a.c.j(this.a));
        arrayList.add(new com.anythink.core.common.n.b.a.c.a(this.a.k));
        z zVar = this.a;
        arrayList.add(new com.anythink.core.common.n.b.a.a.a(zVar.l != null ? zVar.l.a : zVar.m));
        arrayList.add(new com.anythink.core.common.n.b.a.b.a(this.a));
        if (!this.c) {
            arrayList.addAll(this.a.h);
        }
        arrayList.add(new com.anythink.core.common.n.b.a.c.b(this.c));
        com.anythink.core.common.n.b.a.c.g gVar = new com.anythink.core.common.n.b.a.c.g(arrayList, this.d, null, 0, this.b, this, this.a.A, this.a.B, this.a.C);
        boolean z = false;
        try {
            af afVarA = gVar.a(this.b);
            if (this.d.j()) {
                com.anythink.core.common.n.b.a.c.a(afVarA);
                throw new IOException("Canceled");
            }
            this.d.a((IOException) null);
            return afVarA;
        } catch (IOException e) {
            try {
                throw this.d.a(e);
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    this.d.a((IOException) null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z) {
                this.d.a((IOException) null);
            }
            throw th;
        }
    }
}
