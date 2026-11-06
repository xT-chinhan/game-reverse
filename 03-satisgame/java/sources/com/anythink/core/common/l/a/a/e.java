package com.anythink.core.common.l.a.a;

import com.anythink.core.common.m.b.k;
import com.anythink.core.common.m.b.p;
import com.anythink.core.common.m.b.q;
import com.anythink.core.common.m.b.z;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final String a = "e";
    private static volatile e b;
    private volatile z c;
    private volatile z d;
    private final ExecutorService f = new b(0);
    private final k e = new k(10, TimeUnit.MINUTES);

    private e() {
    }

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    public final synchronized z a(com.anythink.core.common.l.a.f fVar) {
        z zVar;
        com.anythink.core.common.l.a.d dVar = fVar.h;
        if (dVar != null) {
            if (this.d == null) {
                this.d = new z.a().c(fVar.c, fVar.d).b(fVar.a, fVar.b).a(fVar.e, fVar.f).a(this.e).a(new p(this.f)).a(new a(dVar)).a(com.anythink.core.common.l.b.c.a).a();
            } else {
                this.d = this.d.t().a(new a(dVar)).a();
            }
            zVar = this.d;
        } else {
            zVar = null;
        }
        if (zVar == null) {
            if (this.c == null) {
                this.c = new z.a().c(fVar.c, fVar.d).b(fVar.a, fVar.b).a(fVar.e, fVar.f).a(this.e).a(new p(this.f)).a(c.a).a(com.anythink.core.common.l.b.c.a).a();
            }
            zVar = this.c;
        }
        return zVar;
    }

    public final int b() {
        try {
            k kVar = this.e;
            if (kVar == null) {
                return 0;
            }
            int iA = kVar.a();
            if (iA > 0) {
                com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bW, new Runnable() { // from class: com.anythink.core.common.l.a.a.e.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            e.this.e.c();
                        } catch (Throwable unused) {
                        }
                    }
                }));
            }
            return iA;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private int c() {
        k kVar = this.e;
        if (kVar != null) {
            return kVar.b();
        }
        return 0;
    }

    private int d() {
        k kVar = this.e;
        if (kVar != null) {
            return kVar.a();
        }
        return 0;
    }

    private static class b extends AbstractExecutorService {
        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j, TimeUnit timeUnit) {
            return false;
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return false;
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return false;
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
        }

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            com.anythink.core.common.u.b.c.a().b().execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return Collections.emptyList();
        }
    }

    private static class a implements q {
        private final com.anythink.core.common.l.a.d a;

        public a(com.anythink.core.common.l.a.d dVar) {
            this.a = dVar;
        }

        @Override // com.anythink.core.common.m.b.q
        public final List<InetAddress> a(String str) {
            com.anythink.core.common.l.a.d dVar = this.a;
            return dVar != null ? dVar.a(str) : q.b.a(str);
        }
    }

    private static class c implements q {
        static final c a = new c();

        private c() {
        }

        @Override // com.anythink.core.common.m.b.q
        public final List<InetAddress> a(String str) throws UnknownHostException {
            List<InetAddress> listA = q.b.a(str);
            List<InetAddress> listA2 = d.a(listA);
            if (listA2 == null || listA2.isEmpty()) {
                throw new UnknownHostException("System DNS returned no valid address for " + str + " (raw size: " + (listA == null ? 0 : listA.size()) + ", all filtered as invalid)");
            }
            return listA2;
        }
    }
}
