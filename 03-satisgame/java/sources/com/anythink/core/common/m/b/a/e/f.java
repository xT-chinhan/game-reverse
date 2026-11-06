package com.anythink.core.common.m.b.a.e;

import androidx.core.internal.view.SupportMenu;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Closeable {
    static final int a = 16777216;
    static final int b = 1;
    static final int c = 2;
    static final int d = 3;
    static final long e = 1000000000;
    static final /* synthetic */ boolean u = true;
    private static final ExecutorService v = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.anythink.core.common.m.b.a.c.a("anythink Http2Connection", true));
    final boolean f;
    final c g;
    final String i;
    int j;
    int k;
    final l l;
    long n;
    final m p;
    final Socket q;
    final j r;
    final e s;
    final Set<Integer> t;
    private boolean w;
    private final ScheduledExecutorService x;
    private final ExecutorService y;
    final Map<Integer, i> h = new LinkedHashMap();
    private long z = 0;
    private long A = 0;
    private long B = 0;
    private long C = 0;
    private long D = 0;
    private long E = 0;
    private long F = 0;
    long m = 0;
    m o = new m();

    public static abstract class c {
        public static final c h = new c() { // from class: com.anythink.core.common.m.b.a.e.f.c.1
            @Override // com.anythink.core.common.m.b.a.e.f.c
            public final void a(i iVar) {
                iVar.a(com.anythink.core.common.m.b.a.e.b.REFUSED_STREAM, (IOException) null);
            }
        };

        public void a(f fVar) {
        }

        public abstract void a(i iVar);
    }

    static boolean c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    static /* synthetic */ long c(f fVar) {
        long j = fVar.z;
        fVar.z = 1 + j;
        return j;
    }

    static /* synthetic */ long f(f fVar) {
        long j = fVar.A;
        fVar.A = 1 + j;
        return j;
    }

    static /* synthetic */ long g(f fVar) {
        long j = fVar.C;
        fVar.C = 1 + j;
        return j;
    }

    static /* synthetic */ long h(f fVar) {
        long j = fVar.E;
        fVar.E = 1 + j;
        return j;
    }

    static /* synthetic */ boolean i(f fVar) {
        fVar.w = true;
        return true;
    }

    f(a aVar) {
        m mVar = new m();
        this.p = mVar;
        this.t = new LinkedHashSet();
        this.l = aVar.f;
        boolean z = aVar.g;
        this.f = z;
        this.g = aVar.e;
        this.k = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.k += 2;
        }
        if (aVar.g) {
            this.o.a(7, 16777216);
        }
        String str = aVar.b;
        this.i = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, com.anythink.core.common.m.b.a.c.a(com.anythink.core.common.m.b.a.c.a("%s %s Writer", "anythink", str), false));
        this.x = scheduledThreadPoolExecutor;
        if (aVar.h != 0) {
            scheduledThreadPoolExecutor.scheduleAtFixedRate(new b(), aVar.h, aVar.h, TimeUnit.MILLISECONDS);
        }
        this.y = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.anythink.core.common.m.b.a.c.a(com.anythink.core.common.m.b.a.c.a("%s %s Push Observer", "anythink", str), true));
        mVar.a(7, SupportMenu.USER_MASK);
        mVar.a(5, 16384);
        this.n = mVar.e();
        this.q = aVar.a;
        this.r = new j(aVar.d, z);
        this.s = new e(new h(aVar.c, z));
    }

    private synchronized int e() {
        return this.h.size();
    }

    final synchronized i a(int i) {
        return this.h.get(Integer.valueOf(i));
    }

    final synchronized i b(int i) {
        i iVarRemove;
        iVarRemove = this.h.remove(Integer.valueOf(i));
        notifyAll();
        return iVarRemove;
    }

    public final synchronized int a() {
        return this.p.d();
    }

    final synchronized void a(long j) {
        long j2 = this.m + j;
        this.m = j2;
        if (j2 >= this.o.e() / 2) {
            a(0, this.m);
            this.m = 0L;
        }
    }

    private i b(int i, List<com.anythink.core.common.m.b.a.e.c> list, boolean z) {
        if (this.f) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        return c(i, list, z);
    }

    public final i a(List<com.anythink.core.common.m.b.a.e.c> list, boolean z) {
        return c(0, list, z);
    }

    private i c(int i, List<com.anythink.core.common.m.b.a.e.c> list, boolean z) {
        int i2;
        i iVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.r) {
            synchronized (this) {
                if (this.k > 1073741823) {
                    a(com.anythink.core.common.m.b.a.e.b.REFUSED_STREAM);
                }
                if (this.w) {
                    throw new com.anythink.core.common.m.b.a.e.a();
                }
                i2 = this.k;
                this.k = i2 + 2;
                iVar = new i(i2, this, z3, false, null);
                z2 = !z || this.n == 0 || iVar.b == 0;
                if (iVar.a()) {
                    this.h.put(Integer.valueOf(i2), iVar);
                }
            }
            if (i == 0) {
                this.r.a(z3, i2, list);
            } else {
                if (this.f) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.r.a(i, i2, list);
            }
        }
        if (z2) {
            this.r.b();
        }
        return iVar;
    }

    final void a(int i, boolean z, List<com.anythink.core.common.m.b.a.e.c> list) {
        this.r.a(z, i, list);
    }

    public final void a(int i, boolean z, com.anythink.core.common.m.c.c cVar, long j) {
        long j2;
        int iMin;
        long j3;
        if (j == 0) {
            this.r.a(z, i, cVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        j2 = this.n;
                        if (j2 <= 0) {
                            if (!this.h.containsKey(Integer.valueOf(i))) {
                                throw new IOException("stream closed");
                            }
                            wait();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j, j2), this.r.c());
                j3 = iMin;
                this.n -= j3;
            }
            j -= j3;
            this.r.a(z && j == 0, i, cVar, iMin);
        }
    }

    final void a(final int i, final com.anythink.core.common.m.b.a.e.b bVar) {
        try {
            this.x.execute(new com.anythink.core.common.m.b.a.b("%s %s stream %d", new Object[]{"anythink", this.i, Integer.valueOf(i)}) { // from class: com.anythink.core.common.m.b.a.e.f.1
                @Override // com.anythink.core.common.m.b.a.b
                public final void c() {
                    try {
                        f.this.b(i, bVar);
                    } catch (IOException e2) {
                        f.this.a(e2);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    final void b(int i, com.anythink.core.common.m.b.a.e.b bVar) {
        this.r.a(i, bVar);
    }

    final void a(final int i, final long j) {
        try {
            this.x.execute(new com.anythink.core.common.m.b.a.b("%s Window Update %s stream %d", new Object[]{"anythink", this.i, Integer.valueOf(i)}) { // from class: com.anythink.core.common.m.b.a.e.f.2
                @Override // com.anythink.core.common.m.b.a.b
                public final void c() {
                    try {
                        f.this.r.a(i, j);
                    } catch (IOException e2) {
                        f.this.a(e2);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    final class d extends com.anythink.core.common.m.b.a.b {
        final boolean a;
        final int b;
        final int d;

        d(int i, int i2) {
            super("anythink %s ping %08x%08x", f.this.i, Integer.valueOf(i), Integer.valueOf(i2));
            this.a = true;
            this.b = i;
            this.d = i2;
        }

        @Override // com.anythink.core.common.m.b.a.b
        public final void c() {
            f.this.a(this.a, this.b, this.d);
        }
    }

    final class b extends com.anythink.core.common.m.b.a.b {
        b() {
            super("anythink %s ping", f.this.i);
        }

        @Override // com.anythink.core.common.m.b.a.b
        public final void c() {
            boolean z;
            synchronized (f.this) {
                if (f.this.A < f.this.z) {
                    z = true;
                } else {
                    f.c(f.this);
                    z = false;
                }
            }
            if (z) {
                f.this.a((IOException) null);
            } else {
                f.this.a(false, 1, 0);
            }
        }
    }

    final void a(boolean z, int i, int i2) {
        try {
            this.r.a(z, i, i2);
        } catch (IOException e2) {
            a(e2);
        }
    }

    private void g() {
        synchronized (this) {
            this.D++;
        }
        a(false, 3, 1330343787);
    }

    private synchronized void h() {
        while (this.E < this.D) {
            wait();
        }
    }

    private void i() {
        this.r.b();
    }

    private void a(com.anythink.core.common.m.b.a.e.b bVar) {
        synchronized (this.r) {
            synchronized (this) {
                if (this.w) {
                    return;
                }
                this.w = true;
                this.r.a(this.j, bVar, com.anythink.core.common.m.b.a.c.a);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a(com.anythink.core.common.m.b.a.e.b.NO_ERROR, com.anythink.core.common.m.b.a.e.b.CANCEL, (IOException) null);
    }

    final void a(com.anythink.core.common.m.b.a.e.b bVar, com.anythink.core.common.m.b.a.e.b bVar2, IOException iOException) {
        i[] iVarArr;
        if (!u && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        try {
            a(bVar);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.h.isEmpty()) {
                iVarArr = null;
            } else {
                iVarArr = (i[]) this.h.values().toArray(new i[this.h.size()]);
                this.h.clear();
            }
        }
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                try {
                    iVar.a(bVar2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.r.close();
        } catch (IOException unused3) {
        }
        try {
            this.q.close();
        } catch (IOException unused4) {
        }
        this.x.shutdown();
        this.y.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IOException iOException) {
        com.anythink.core.common.m.b.a.e.b bVar = com.anythink.core.common.m.b.a.e.b.PROTOCOL_ERROR;
        a(bVar, bVar, iOException);
    }

    private void j() {
        this.r.a();
        this.r.b(this.o);
        int iE = this.o.e();
        if (iE != 65535) {
            this.r.a(0, iE - SupportMenu.USER_MASK);
        }
        new Thread(this.s).start();
    }

    private void a(m mVar) {
        synchronized (this.r) {
            synchronized (this) {
                if (this.w) {
                    throw new com.anythink.core.common.m.b.a.e.a();
                }
                this.o.a(mVar);
            }
            this.r.b(mVar);
        }
    }

    public final synchronized boolean b(long j) {
        if (this.w) {
            return false;
        }
        return this.C >= this.B || j < this.F;
    }

    final void c() {
        synchronized (this) {
            long j = this.C;
            long j2 = this.B;
            if (j < j2) {
                return;
            }
            this.B = j2 + 1;
            this.F = System.nanoTime() + 1000000000;
            try {
                this.x.execute(new com.anythink.core.common.m.b.a.b("anythink %s ping", this.i) { // from class: com.anythink.core.common.m.b.a.e.f.3
                    @Override // com.anythink.core.common.m.b.a.b
                    public final void c() {
                        f.this.a(false, 2, 0);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public static class a {
        Socket a;
        String b;
        com.anythink.core.common.m.c.e c;
        com.anythink.core.common.m.c.d d;
        c e = c.h;
        l f = l.a;
        boolean g = true;
        int h;

        private a a(Socket socket) {
            String string;
            SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
            if (remoteSocketAddress instanceof InetSocketAddress) {
                string = ((InetSocketAddress) remoteSocketAddress).getHostName();
            } else {
                string = remoteSocketAddress.toString();
            }
            return a(socket, string, com.anythink.core.common.m.c.n.a(com.anythink.core.common.m.c.n.b(socket)), com.anythink.core.common.m.c.n.a(com.anythink.core.common.m.c.n.a(socket)));
        }

        public final a a(Socket socket, String str, com.anythink.core.common.m.c.e eVar, com.anythink.core.common.m.c.d dVar) {
            this.a = socket;
            this.b = str;
            this.c = eVar;
            this.d = dVar;
            return this;
        }

        public final a a(c cVar) {
            this.e = cVar;
            return this;
        }

        private a a(l lVar) {
            this.f = lVar;
            return this;
        }

        public final a a(int i) {
            this.h = i;
            return this;
        }

        public final f a() {
            return new f(this);
        }
    }

    class e extends com.anythink.core.common.m.b.a.b implements h.b {
        final h a;

        @Override // com.anythink.core.common.m.b.a.e.h.b
        public final void a() {
        }

        @Override // com.anythink.core.common.m.b.a.e.h.b
        public final void b() {
        }

        @Override // com.anythink.core.common.m.b.a.e.h.b
        public final void d() {
        }

        e(h hVar) {
            super("anythink %s", f.this.i);
            this.a = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.anythink.core.common.m.b.a.e.b] */
        /* JADX WARN: Type inference failed for: r0v5, types: [com.anythink.core.common.m.b.a.e.h, java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r0v6, types: [com.anythink.core.common.m.b.a.e.b] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.anythink.core.common.m.b.a.b
        protected final void c() {
            com.anythink.core.common.m.b.a.e.b bVar;
            com.anythink.core.common.m.b.a.e.b bVar2 = com.anythink.core.common.m.b.a.e.b.INTERNAL_ERROR;
            com.anythink.core.common.m.b.a.e.b bVar3 = com.anythink.core.common.m.b.a.e.b.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.a.a(this);
                    while (this.a.a(false, (h.b) this)) {
                    }
                    bVar2 = com.anythink.core.common.m.b.a.e.b.NO_ERROR;
                    bVar3 = com.anythink.core.common.m.b.a.e.b.CANCEL;
                    bVar = bVar2;
                } catch (IOException e2) {
                    e = e2;
                    com.anythink.core.common.m.b.a.e.b bVar4 = com.anythink.core.common.m.b.a.e.b.PROTOCOL_ERROR;
                    bVar3 = com.anythink.core.common.m.b.a.e.b.PROTOCOL_ERROR;
                    bVar = bVar4;
                }
            } finally {
                f.this.a(bVar2, bVar3, e);
                com.anythink.core.common.m.b.a.c.a(this.a);
            }
        }

        @Override // com.anythink.core.common.m.b.a.e.h.b
        public final void a(boolean z, int i, com.anythink.core.common.m.c.e eVar, int i2) throws IOException {
            if (f.c(i)) {
                f.this.a(i, eVar, i2, z);
                return;
            }
            i iVarA = f.this.a(i);
            if (iVarA == null) {
                f.this.a(i, com.anythink.core.common.m.b.a.e.b.PROTOCOL_ERROR);
                long j = i2;
                f.this.a(j);
                eVar.i(j);
                return;
            }
            iVarA.a(eVar, i2);
            if (z) {
                iVarA.a(com.anythink.core.common.m.b.a.c.c, true);
            }
        }

        @Override // com.anythink.core.common.m.b.a.e.h.b
        public final void a(boolean z, int i, List<com.anythink.core.common.m.b.a.e.c> list) {
            if (f.c(i)) {
                f.this.a(i, list, z);
                return;
            }
            synchronized (f.this) {
                i iVarA = f.this.a(i);
                if (iVarA == null) {
                    if (f.this.w) {
                        return;
                    }
                    if (i <= f.this.j) {
                        return;
                    }
                    if (i % 2 == f.this.k % 2) {
                        return;
                    }
                    final i iVar = new i(i, f.this, false, z, com.anythink.core.common.m.b.a.c.b(list));
                    f.this.j = i;
                    f.this.h.put(Integer.valueOf(i), iVar);
                    f.v.execute(new com.anythink.core.common.m.b.a.b("anythink %s stream %d", new Object[]{f.this.i, Integer.valueOf(i)}) { // from class: com.anythink.core.common.m.b.a.e.f.e.1
                        @Override // com.anythink.core.common.m.b.a.b
                        public final void c() {
                            try {
                                f.this.g.a(iVar);
                            } catch (IOException e) {
                                com.anythink.core.common.m.b.a.g.c.e().a(4, "Http2Connection.Listener failure for " + f.this.i, e);
                                try {
                                    iVar.a(com.anythink.core.common.m.b.a.e.b.PROTOCOL_ERROR, e);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                    return;
                }
                iVarA.a(com.anythink.core.common.m.b.a.c.b(list), z);
            }
        }

        @Override // com.anythink.core.common.m.b.a.e.h.b
        public final void a(int i, com.anythink.core.common.m.b.a.e.b bVar) {
            if (f.c(i)) {
                f.this.c(i, bVar);
                return;
            }
            i iVarB = f.this.b(i);
            if (iVarB != null) {
                iVarB.b(bVar);
            }
        }

        @Override // com.anythink.core.common.m.b.a.e.h.b
        public final void a(final m mVar) {
            try {
                f.this.x.execute(new com.anythink.core.common.m.b.a.b("anythink %s ACK Settings", new Object[]{f.this.i}) { // from class: com.anythink.core.common.m.b.a.e.f.e.2
                    final /* synthetic */ boolean a = false;

                    @Override // com.anythink.core.common.m.b.a.b
                    public final void c() {
                        i[] iVarArr;
                        long j;
                        e eVar = e.this;
                        boolean z = this.a;
                        m mVar2 = mVar;
                        synchronized (f.this.r) {
                            synchronized (f.this) {
                                int iE = f.this.p.e();
                                if (z) {
                                    f.this.p.a();
                                }
                                f.this.p.a(mVar2);
                                int iE2 = f.this.p.e();
                                iVarArr = null;
                                if (iE2 == -1 || iE2 == iE) {
                                    j = 0;
                                } else {
                                    j = iE2 - iE;
                                    if (!f.this.h.isEmpty()) {
                                        iVarArr = (i[]) f.this.h.values().toArray(new i[f.this.h.size()]);
                                    }
                                }
                            }
                            try {
                                f.this.r.a(f.this.p);
                            } catch (IOException e) {
                                f.this.a(e);
                            }
                        }
                        if (iVarArr != null) {
                            for (i iVar : iVarArr) {
                                synchronized (iVar) {
                                    iVar.a(j);
                                }
                            }
                        }
                        f.v.execute(eVar.new AnonymousClass3("anythink %s settings", f.this.i));
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        private void a(boolean z, m mVar) {
            i[] iVarArr;
            long j;
            synchronized (f.this.r) {
                synchronized (f.this) {
                    int iE = f.this.p.e();
                    if (z) {
                        f.this.p.a();
                    }
                    f.this.p.a(mVar);
                    int iE2 = f.this.p.e();
                    iVarArr = null;
                    if (iE2 == -1 || iE2 == iE) {
                        j = 0;
                    } else {
                        j = iE2 - iE;
                        if (!f.this.h.isEmpty()) {
                            iVarArr = (i[]) f.this.h.values().toArray(new i[f.this.h.size()]);
                        }
                    }
                }
                try {
                    f.this.r.a(f.this.p);
                } catch (IOException e) {
                    f.this.a(e);
                }
            }
            if (iVarArr != null) {
                for (i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.a(j);
                    }
                }
            }
            f.v.execute(new AnonymousClass3("anythink %s settings", f.this.i));
        }

        /* JADX INFO: renamed from: com.anythink.core.common.m.b.a.e.f$e$3, reason: invalid class name */
        final class AnonymousClass3 extends com.anythink.core.common.m.b.a.b {
            AnonymousClass3(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // com.anythink.core.common.m.b.a.b
            public final void c() {
                f.this.g.a(f.this);
            }
        }

        @Override // com.anythink.core.common.m.b.a.e.h.b
        public final void a(boolean z, int i, int i2) {
            if (!z) {
                try {
                    f.this.x.execute(f.this.new d(i, i2));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (f.this) {
                try {
                    if (i == 1) {
                        f.f(f.this);
                    } else if (i == 2) {
                        f.g(f.this);
                    } else if (i == 3) {
                        f.h(f.this);
                        f.this.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.anythink.core.common.m.b.a.e.h.b
        public final void a(int i, com.anythink.core.common.m.c.f fVar) {
            i[] iVarArr;
            fVar.j();
            synchronized (f.this) {
                iVarArr = (i[]) f.this.h.values().toArray(new i[f.this.h.size()]);
                f.i(f.this);
            }
            for (i iVar : iVarArr) {
                if (iVar.c > i && iVar.b()) {
                    iVar.b(com.anythink.core.common.m.b.a.e.b.REFUSED_STREAM);
                    f.this.b(iVar.c);
                }
            }
        }

        @Override // com.anythink.core.common.m.b.a.e.h.b
        public final void a(int i, long j) {
            if (i == 0) {
                synchronized (f.this) {
                    f.this.n += j;
                    f.this.notifyAll();
                }
                return;
            }
            i iVarA = f.this.a(i);
            if (iVarA != null) {
                synchronized (iVarA) {
                    iVarA.a(j);
                }
            }
        }

        @Override // com.anythink.core.common.m.b.a.e.h.b
        public final void a(int i, List<com.anythink.core.common.m.b.a.e.c> list) {
            f.this.a(i, list);
        }
    }

    final void a(final int i, final List<com.anythink.core.common.m.b.a.e.c> list) {
        synchronized (this) {
            if (this.t.contains(Integer.valueOf(i))) {
                a(i, com.anythink.core.common.m.b.a.e.b.PROTOCOL_ERROR);
                return;
            }
            this.t.add(Integer.valueOf(i));
            try {
                a(new com.anythink.core.common.m.b.a.b("anythink %s Push Request[%s]", new Object[]{this.i, Integer.valueOf(i)}) { // from class: com.anythink.core.common.m.b.a.e.f.4
                    @Override // com.anythink.core.common.m.b.a.b
                    public final void c() {
                        try {
                            f.this.r.a(i, com.anythink.core.common.m.b.a.e.b.CANCEL);
                            synchronized (f.this) {
                                f.this.t.remove(Integer.valueOf(i));
                            }
                        } catch (IOException unused) {
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    final void a(final int i, final List<com.anythink.core.common.m.b.a.e.c> list, final boolean z) {
        try {
            a(new com.anythink.core.common.m.b.a.b("anythink %s Push Headers[%s]", new Object[]{this.i, Integer.valueOf(i)}) { // from class: com.anythink.core.common.m.b.a.e.f.5
                @Override // com.anythink.core.common.m.b.a.b
                public final void c() {
                    try {
                        f.this.r.a(i, com.anythink.core.common.m.b.a.e.b.CANCEL);
                        synchronized (f.this) {
                            f.this.t.remove(Integer.valueOf(i));
                        }
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    final void a(final int i, com.anythink.core.common.m.c.e eVar, final int i2, final boolean z) throws IOException {
        final com.anythink.core.common.m.c.c cVar = new com.anythink.core.common.m.c.c();
        long j = i2;
        eVar.a(j);
        eVar.a_(cVar, j);
        if (cVar.b() != j) {
            throw new IOException(cVar.b() + " != " + i2);
        }
        a(new com.anythink.core.common.m.b.a.b("anythink %s Push Data[%s]", new Object[]{this.i, Integer.valueOf(i)}) { // from class: com.anythink.core.common.m.b.a.e.f.6
            @Override // com.anythink.core.common.m.b.a.b
            public final void c() {
                try {
                    f.this.l.a(cVar, i2);
                    f.this.r.a(i, com.anythink.core.common.m.b.a.e.b.CANCEL);
                    synchronized (f.this) {
                        f.this.t.remove(Integer.valueOf(i));
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    final void c(final int i, final com.anythink.core.common.m.b.a.e.b bVar) {
        a(new com.anythink.core.common.m.b.a.b("anythink %s Push Reset[%s]", new Object[]{this.i, Integer.valueOf(i)}) { // from class: com.anythink.core.common.m.b.a.e.f.7
            @Override // com.anythink.core.common.m.b.a.b
            public final void c() {
                synchronized (f.this) {
                    f.this.t.remove(Integer.valueOf(i));
                }
            }
        });
    }

    private synchronized void a(com.anythink.core.common.m.b.a.b bVar) {
        if (!this.w) {
            this.y.execute(bVar);
        }
    }

    private void f() {
        synchronized (this) {
            this.D++;
        }
        a(false, 3, 1330343787);
        h();
    }

    public final void b() {
        this.r.a();
        this.r.b(this.o);
        int iE = this.o.e();
        if (iE != 65535) {
            this.r.a(0, iE - SupportMenu.USER_MASK);
        }
        new Thread(this.s).start();
    }
}
