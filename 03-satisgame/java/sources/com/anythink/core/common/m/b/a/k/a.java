package com.anythink.core.common.m.b.a.k;

import com.anythink.core.common.m.b.ab;
import com.anythink.core.common.m.b.ad;
import com.anythink.core.common.m.b.af;
import com.anythink.core.common.m.b.aj;
import com.anythink.core.common.m.b.ak;
import com.anythink.core.common.m.b.r;
import com.anythink.core.common.m.b.z;
import com.anythink.core.common.m.c.f;
import com.anythink.core.common.m.c.n;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.anythink.core.common.m.b.a.k.c.a, aj {
    static final /* synthetic */ boolean b = true;
    private static final List<ab> c = Collections.singletonList(ab.HTTP_1_1);
    private static final long d = 16777216;
    private static final long e = 60000;
    private boolean A;
    final ak a;
    private final ad f;
    private final Random g;
    private final long h;
    private final String i;
    private com.anythink.core.common.m.b.e j;
    private final Runnable k;
    private com.anythink.core.common.m.b.a.k.c l;
    private com.anythink.core.common.m.b.a.k.d m;
    private ScheduledExecutorService n;
    private e o;
    private long r;
    private boolean s;
    private ScheduledFuture<?> t;
    private String v;
    private boolean w;
    private int x;
    private int y;
    private int z;
    private final ArrayDeque<f> p = new ArrayDeque<>();
    private final ArrayDeque<Object> q = new ArrayDeque<>();
    private int u = -1;

    @Override // com.anythink.core.common.m.b.a.k.c.a
    public final void e() {
    }

    @Override // com.anythink.core.common.m.b.a.k.c.a
    public final void f() {
    }

    public a(ad adVar, ak akVar, Random random, long j) {
        if (!TapHttp.METHOD_GET.equals(adVar.b())) {
            throw new IllegalArgumentException("Request must be GET: " + adVar.b());
        }
        this.f = adVar;
        this.a = akVar;
        this.g = random;
        this.h = j;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.i = f.a(bArr).b();
        this.k = new Runnable() { // from class: com.anythink.core.common.m.b.a.k.a.1
            @Override // java.lang.Runnable
            public final void run() {
                do {
                    try {
                    } catch (IOException unused) {
                        a.this.j();
                        return;
                    }
                } while (a.this.h());
            }
        };
    }

    @Override // com.anythink.core.common.m.b.aj
    public final ad a() {
        return this.f;
    }

    @Override // com.anythink.core.common.m.b.aj
    public final synchronized long b() {
        return this.r;
    }

    @Override // com.anythink.core.common.m.b.aj
    public final void c() {
        this.j.c();
    }

    public final void a(z zVar) {
        z zVarA = zVar.t().a(r.b).a(c).a();
        final ad adVarB = this.f.e().a("Upgrade", "websocket").a("Connection", "Upgrade").a("Sec-WebSocket-Key", this.i).a("Sec-WebSocket-Version", "13").b();
        com.anythink.core.common.m.b.e eVarA = com.anythink.core.common.m.b.a.a.a.a(zVarA, adVarB);
        this.j = eVarA;
        eVarA.a(new com.anythink.core.common.m.b.f() { // from class: com.anythink.core.common.m.b.a.k.a.2
            @Override // com.anythink.core.common.m.b.f
            public final void a(af afVar) {
                com.anythink.core.common.m.b.a.b.c cVarA = com.anythink.core.common.m.b.a.a.a.a(afVar);
                try {
                    a.this.a(afVar, cVarA);
                    try {
                        a.this.a("anythink webSocket " + adVarB.a().l(), cVarA.f());
                        a.this.d();
                    } catch (Exception unused) {
                        a.this.j();
                    }
                } catch (IOException unused2) {
                    if (cVarA != null) {
                        cVarA.g();
                    }
                    a.this.j();
                    com.anythink.core.common.m.b.a.c.a(afVar);
                }
            }

            @Override // com.anythink.core.common.m.b.f
            public final void a(IOException iOException) {
                a.this.j();
            }
        });
    }

    final void a(af afVar, com.anythink.core.common.m.b.a.b.c cVar) throws ProtocolException {
        if (afVar.c() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + afVar.c() + " " + afVar.e() + "'");
        }
        String strA = afVar.a("Connection");
        if (!"Upgrade".equalsIgnoreCase(strA)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strA + "'");
        }
        String strA2 = afVar.a("Upgrade");
        if (!"websocket".equalsIgnoreCase(strA2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strA2 + "'");
        }
        String strA3 = afVar.a("Sec-WebSocket-Accept");
        String strB = f.a(this.i + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").d().b();
        if (!strB.equals(strA3)) {
            throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strB + "' but was '" + strA3 + "'");
        }
        if (cVar == null) {
            throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
        }
    }

    public final void a(String str, e eVar) {
        synchronized (this) {
            this.o = eVar;
            this.m = new com.anythink.core.common.m.b.a.k.d(eVar.c, eVar.e, this.g);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, com.anythink.core.common.m.b.a.c.a(str, false));
            this.n = scheduledThreadPoolExecutor;
            if (this.h != 0) {
                d dVar = new d();
                long j = this.h;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(dVar, j, j, TimeUnit.MILLISECONDS);
            }
            if (!this.q.isEmpty()) {
                p();
            }
        }
        this.l = new com.anythink.core.common.m.b.a.k.c(eVar.c, eVar.d, this);
    }

    public final void d() throws IOException {
        while (this.u == -1) {
            this.l.a();
        }
    }

    private boolean k() {
        try {
            this.l.a();
            return this.u == -1;
        } catch (Exception unused) {
            j();
            return false;
        }
    }

    private void a(int i, TimeUnit timeUnit) {
        this.n.awaitTermination(i, timeUnit);
    }

    private void l() {
        ScheduledFuture<?> scheduledFuture = this.t;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.n.shutdown();
        this.n.awaitTermination(10L, TimeUnit.SECONDS);
    }

    private synchronized int m() {
        return this.x;
    }

    private synchronized int n() {
        return this.y;
    }

    private synchronized int o() {
        return this.z;
    }

    @Override // com.anythink.core.common.m.b.a.k.c.a
    public final synchronized void b(f fVar) {
        if (!this.w && (!this.s || !this.q.isEmpty())) {
            this.p.add(fVar);
            p();
            this.y++;
        }
    }

    @Override // com.anythink.core.common.m.b.a.k.c.a
    public final synchronized void g() {
        this.z++;
        this.A = false;
    }

    @Override // com.anythink.core.common.m.b.a.k.c.a
    public final void a(int i, String str) {
        e eVar;
        if (i == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.u != -1) {
                throw new IllegalStateException("already closed");
            }
            this.u = i;
            this.v = str;
            eVar = null;
            if (this.s && this.q.isEmpty()) {
                e eVar2 = this.o;
                this.o = null;
                ScheduledFuture<?> scheduledFuture = this.t;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.n.shutdown();
                eVar = eVar2;
            }
        }
        com.anythink.core.common.m.b.a.c.a(eVar);
    }

    @Override // com.anythink.core.common.m.b.aj
    public final boolean a(String str) {
        if (str == null) {
            throw new NullPointerException("text == null");
        }
        return a(f.a(str), 1);
    }

    @Override // com.anythink.core.common.m.b.aj
    public final boolean a(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("bytes == null");
        }
        return a(fVar, 2);
    }

    private synchronized boolean a(f fVar, int i) {
        if (!this.w && !this.s) {
            if (this.r + ((long) fVar.j()) <= 16777216) {
                this.r += (long) fVar.j();
                this.q.add(new c(i, fVar));
                p();
                return true;
            }
            c((String) null);
            return false;
        }
        return false;
    }

    private synchronized boolean c(f fVar) {
        if (!this.w && (!this.s || !this.q.isEmpty())) {
            this.p.add(fVar);
            p();
            return true;
        }
        return false;
    }

    @Override // com.anythink.core.common.m.b.aj
    public final boolean b(String str) {
        return c(str);
    }

    private synchronized boolean c(String str) {
        f fVarA;
        com.anythink.core.common.m.b.a.k.b.b(1001);
        if (str != null) {
            fVarA = f.a(str);
            if (fVarA.j() > 123) {
                throw new IllegalArgumentException("reason.size() > 123: ".concat(String.valueOf(str)));
            }
        } else {
            fVarA = null;
        }
        if (!this.w && !this.s) {
            this.s = true;
            this.q.add(new b(fVarA));
            p();
            return true;
        }
        return false;
    }

    private void p() {
        if (!b && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ScheduledExecutorService scheduledExecutorService = this.n;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.k);
        }
    }

    final boolean h() {
        e eVar;
        synchronized (this) {
            if (this.w) {
                return false;
            }
            com.anythink.core.common.m.b.a.k.d dVar = this.m;
            f fVarPoll = this.p.poll();
            Object obj = null;
            if (fVarPoll == null) {
                Object objPoll = this.q.poll();
                if (objPoll instanceof b) {
                    if (this.u != -1) {
                        eVar = this.o;
                        this.o = null;
                        this.n.shutdown();
                    } else {
                        this.t = this.n.schedule(new RunnableC0037a(), ((b) objPoll).c, TimeUnit.MILLISECONDS);
                    }
                    obj = objPoll;
                } else if (objPoll == null) {
                    return false;
                }
                eVar = null;
                obj = objPoll;
            } else {
                eVar = null;
            }
            try {
                if (fVarPoll != null) {
                    dVar.b(fVarPoll);
                } else if (obj instanceof c) {
                    f fVar = ((c) obj).b;
                    int i = ((c) obj).a;
                    long j = fVar.j();
                    if (dVar.h) {
                        throw new IllegalStateException("Another message writer is active. Did you call close()?");
                    }
                    dVar.h = true;
                    dVar.g.a = i;
                    dVar.g.b = j;
                    dVar.g.c = true;
                    dVar.g.d = false;
                    com.anythink.core.common.m.c.d dVarA = n.a(dVar.g);
                    dVarA.d(fVar);
                    dVarA.close();
                    synchronized (this) {
                        this.r -= (long) fVar.j();
                    }
                } else if (obj instanceof b) {
                    b bVar = (b) obj;
                    dVar.a(bVar.a, bVar.b);
                } else {
                    throw new AssertionError();
                }
                com.anythink.core.common.m.b.a.c.a(eVar);
                return true;
            } catch (Throwable th) {
                com.anythink.core.common.m.b.a.c.a(eVar);
                throw th;
            }
        }
    }

    private final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.i();
        }
    }

    final void i() {
        synchronized (this) {
            if (this.w) {
                return;
            }
            com.anythink.core.common.m.b.a.k.d dVar = this.m;
            int i = this.A ? this.x : -1;
            this.x++;
            this.A = true;
            if (i != -1) {
                new SocketTimeoutException("sent ping but didn't receive pong within " + this.h + "ms (after " + (i - 1) + " successful ping/pongs)");
                j();
            } else {
                try {
                    dVar.a(f.b);
                } catch (IOException unused) {
                    j();
                }
            }
        }
    }

    public final void j() {
        synchronized (this) {
            if (this.w) {
                return;
            }
            this.w = true;
            e eVar = this.o;
            this.o = null;
            ScheduledFuture<?> scheduledFuture = this.t;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.n;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            com.anythink.core.common.m.b.a.c.a(eVar);
        }
    }

    static final class c {
        final int a;
        final f b;

        c(int i, f fVar) {
            this.a = i;
            this.b = fVar;
        }
    }

    static final class b {
        final f b;
        final int a = 1001;
        final long c = a.e;

        b(f fVar) {
            this.b = fVar;
        }
    }

    public static abstract class e implements Closeable {
        public final boolean c = true;
        public final com.anythink.core.common.m.c.e d;
        public final com.anythink.core.common.m.c.d e;

        public e(com.anythink.core.common.m.c.e eVar, com.anythink.core.common.m.c.d dVar) {
            this.d = eVar;
            this.e = dVar;
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.m.b.a.k.a$a, reason: collision with other inner class name */
    final class RunnableC0037a implements Runnable {
        RunnableC0037a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.c();
        }
    }
}
