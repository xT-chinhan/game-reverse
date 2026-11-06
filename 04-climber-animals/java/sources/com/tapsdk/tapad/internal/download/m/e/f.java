package com.tapsdk.tapad.internal.download.m.e;

import com.tapsdk.tapad.internal.download.core.breakpoint.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class f implements Runnable {
    private static final ExecutorService q = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.tapsdk.tapad.internal.download.m.c.a("OkDownload Cancel Block", false));
    private static final String r = "DownloadChain";
    private final int a;
    private final com.tapsdk.tapad.internal.download.f b;
    private final com.tapsdk.tapad.internal.download.core.breakpoint.c c;
    private final d d;
    private long i;
    private volatile com.tapsdk.tapad.internal.download.core.connection.a j;
    long k;
    volatile Thread l;
    private final i n;
    final List<com.tapsdk.tapad.internal.download.m.h.c.a> e = new ArrayList();
    final List<com.tapsdk.tapad.internal.download.m.h.c.b> f = new ArrayList();
    int g = 0;
    int h = 0;
    final AtomicBoolean o = new AtomicBoolean(false);
    private final Runnable p = new a();
    private final com.tapsdk.tapad.internal.download.m.d.a m = com.tapsdk.tapad.internal.download.i.j().b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.p();
        }
    }

    private f(int i, com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, d dVar, i iVar) {
        this.a = i;
        this.b = fVar;
        this.d = dVar;
        this.c = cVar;
        this.n = iVar;
    }

    static f a(int i, com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, d dVar, i iVar) {
        return new f(i, fVar, cVar, dVar, iVar);
    }

    public void a() {
        if (this.o.get() || this.l == null) {
            return;
        }
        this.l.interrupt();
    }

    public void a(long j) {
        this.k += j;
    }

    public synchronized void a(com.tapsdk.tapad.internal.download.core.connection.a aVar) {
        this.j = aVar;
    }

    public void a(String str) {
        this.d.a(str);
    }

    public void b() {
        if (this.k == 0) {
            return;
        }
        this.m.a().a(this.b, this.a, this.k);
        this.k = 0L;
    }

    public void b(long j) {
        this.i = j;
    }

    public int c() {
        return this.a;
    }

    public d d() {
        return this.d;
    }

    public synchronized com.tapsdk.tapad.internal.download.core.connection.a e() {
        return this.j;
    }

    public synchronized com.tapsdk.tapad.internal.download.core.connection.a f() throws IOException {
        if (this.d.f()) {
            throw com.tapsdk.tapad.internal.download.m.f.c.a;
        }
        if (this.j == null) {
            String strC = this.d.c();
            if (strC == null) {
                strC = this.c.j();
            }
            com.tapsdk.tapad.internal.download.m.c.a(r, "create connection on url: " + strC);
            this.j = com.tapsdk.tapad.internal.download.i.j().c().a(strC);
        }
        return this.j;
    }

    public i g() {
        return this.n;
    }

    public com.tapsdk.tapad.internal.download.core.breakpoint.c h() {
        return this.c;
    }

    public com.tapsdk.tapad.internal.download.m.g.d i() {
        return this.d.a();
    }

    public long j() {
        return this.i;
    }

    public com.tapsdk.tapad.internal.download.f k() {
        return this.b;
    }

    boolean l() {
        return this.o.get();
    }

    public long m() throws IOException {
        if (this.h == this.f.size()) {
            this.h--;
        }
        return o();
    }

    public com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a n() throws IOException {
        if (this.d.f()) {
            throw com.tapsdk.tapad.internal.download.m.f.c.a;
        }
        List<com.tapsdk.tapad.internal.download.m.h.c.a> list = this.e;
        int i = this.g;
        this.g = i + 1;
        return list.get(i).b(this);
    }

    public long o() throws IOException {
        if (this.d.f()) {
            throw com.tapsdk.tapad.internal.download.m.f.c.a;
        }
        List<com.tapsdk.tapad.internal.download.m.h.c.b> list = this.f;
        int i = this.h;
        this.h = i + 1;
        return list.get(i).a(this);
    }

    public synchronized void p() {
        if (this.j != null) {
            this.j.d();
            com.tapsdk.tapad.internal.download.m.c.a(r, "release connection " + this.j + " task[" + this.b.b() + "] block[" + this.a + "]");
        }
        this.j = null;
    }

    void q() {
        q.execute(this.p);
    }

    public void r() {
        this.g = 1;
        p();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (l()) {
            throw new IllegalAccessError("The chain has been finished!");
        }
        this.l = Thread.currentThread();
        try {
            s();
        } catch (IOException unused) {
        } finally {
            this.o.set(true);
            q();
        }
    }

    void s() throws IOException {
        com.tapsdk.tapad.internal.download.m.d.a aVarB = com.tapsdk.tapad.internal.download.i.j().b();
        com.tapsdk.tapad.internal.download.m.h.d dVar = new com.tapsdk.tapad.internal.download.m.h.d();
        com.tapsdk.tapad.internal.download.m.h.a aVar = new com.tapsdk.tapad.internal.download.m.h.a();
        this.e.add(dVar);
        this.e.add(aVar);
        this.e.add(new com.tapsdk.tapad.internal.download.m.h.e.b());
        this.e.add(new com.tapsdk.tapad.internal.download.m.h.e.a());
        this.g = 0;
        com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a interfaceC0605aN = n();
        if (this.d.f()) {
            throw com.tapsdk.tapad.internal.download.m.f.c.a;
        }
        aVarB.a().b(this.b, this.a, j());
        com.tapsdk.tapad.internal.download.m.h.b bVar = new com.tapsdk.tapad.internal.download.m.h.b(this.a, interfaceC0605aN.b(), i(), this.b);
        this.f.add(dVar);
        this.f.add(aVar);
        this.f.add(bVar);
        this.h = 0;
        aVarB.a().c(this.b, this.a, o());
    }
}
