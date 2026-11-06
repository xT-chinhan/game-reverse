package com.anythink.core.common.m.c;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a extends x {
    private static final int a = 65536;
    static a b;
    private static final long d;
    private static final long e;
    private boolean f;
    private a g;
    private long h;

    protected void a() {
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        d = millis;
        e = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void c() {
        if (this.f) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jE_ = e_();
        boolean zB_ = b_();
        if (jE_ != 0 || zB_) {
            this.f = true;
            a(this, jE_, zB_);
        }
    }

    private static synchronized void a(a aVar, long j, boolean z) {
        a aVar2;
        if (b == null) {
            b = new a();
            new C0039a().start();
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            aVar.h = Math.min(j, aVar.c_() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            aVar.h = j + jNanoTime;
        } else if (z) {
            aVar.h = aVar.c_();
        } else {
            throw new AssertionError();
        }
        long j2 = aVar.h - jNanoTime;
        a aVar3 = b;
        while (true) {
            aVar2 = aVar3.g;
            if (aVar2 == null || j2 < aVar2.h - jNanoTime) {
                break;
                break;
            }
            aVar3 = aVar2;
        }
        aVar.g = aVar2;
        aVar3.g = aVar;
        if (aVar3 == b) {
            a.class.notify();
        }
    }

    public final boolean d() {
        if (!this.f) {
            return false;
        }
        this.f = false;
        return a(this);
    }

    private static synchronized boolean a(a aVar) {
        a aVar2 = b;
        while (aVar2 != null) {
            a aVar3 = aVar2.g;
            if (aVar3 == aVar) {
                aVar2.g = aVar.g;
                aVar.g = null;
                return false;
            }
            aVar2 = aVar3;
        }
        return true;
    }

    private long b(long j) {
        return this.h - j;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.m.c.a$1, reason: invalid class name */
    final class AnonymousClass1 implements v {
        final /* synthetic */ v a;

        AnonymousClass1(v vVar) {
            this.a = vVar;
        }

        @Override // com.anythink.core.common.m.c.v
        public final void a(c cVar, long j) throws IOException {
            y.a(cVar.c, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                s sVar = cVar.b;
                while (j2 < com.anythink.china.a.c.q) {
                    j2 += (long) (sVar.e - sVar.d);
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    sVar = sVar.h;
                }
                a.this.c();
                try {
                    try {
                        this.a.a(cVar, j2);
                        j -= j2;
                        a.this.a(true);
                    } catch (IOException e) {
                        throw a.this.b(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }
        }

        @Override // com.anythink.core.common.m.c.v, java.io.Flushable
        public final void flush() throws IOException {
            a.this.c();
            try {
                try {
                    this.a.flush();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.b(e);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // com.anythink.core.common.m.c.v, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            a.this.c();
            try {
                try {
                    this.a.close();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.b(e);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // com.anythink.core.common.m.c.v
        public final x a() {
            return a.this;
        }

        public final String toString() {
            return "AsyncTimeout.sink(" + this.a + ")";
        }
    }

    private v a(v vVar) {
        return new AnonymousClass1(vVar);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.m.c.a$2, reason: invalid class name */
    final class AnonymousClass2 implements w {
        final /* synthetic */ w a;

        AnonymousClass2(w wVar) {
            this.a = wVar;
        }

        @Override // com.anythink.core.common.m.c.w
        public final long a_(c cVar, long j) throws IOException {
            a.this.c();
            try {
                try {
                    long jA_ = this.a.a_(cVar, j);
                    a.this.a(true);
                    return jA_;
                } catch (IOException e) {
                    throw a.this.b(e);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // com.anythink.core.common.m.c.w, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            a.this.c();
            try {
                try {
                    this.a.close();
                    a.this.a(true);
                } catch (IOException e) {
                    throw a.this.b(e);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // com.anythink.core.common.m.c.w
        public final x a() {
            return a.this;
        }

        public final String toString() {
            return "AsyncTimeout.source(" + this.a + ")";
        }
    }

    private w a(w wVar) {
        return new AnonymousClass2(wVar);
    }

    final void a(boolean z) throws IOException {
        if (d() && z) {
            throw a((IOException) null);
        }
    }

    final IOException b(IOException iOException) {
        return !d() ? iOException : a(iOException);
    }

    protected IOException a(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.m.c.a$a, reason: collision with other inner class name */
    private static final class C0039a extends Thread {
        C0039a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.a();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<com.anythink.core.common.m.c.a> r0 = com.anythink.core.common.m.c.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                com.anythink.core.common.m.c.a r1 = com.anythink.core.common.m.c.a.e()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                com.anythink.core.common.m.c.a r2 = com.anythink.core.common.m.c.a.b     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                com.anythink.core.common.m.c.a.b = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.InterruptedException -> L0
                r1.a()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.InterruptedException -> L0
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.m.c.a.C0039a.run():void");
        }
    }

    static a e() throws InterruptedException {
        a aVar = b.g;
        if (aVar == null) {
            long jNanoTime = System.nanoTime();
            a.class.wait(d);
            if (b.g != null || System.nanoTime() - jNanoTime < e) {
                return null;
            }
            return b;
        }
        long jNanoTime2 = aVar.h - System.nanoTime();
        if (jNanoTime2 > 0) {
            long j = jNanoTime2 / C.MICROS_PER_SECOND;
            a.class.wait(j, (int) (jNanoTime2 - (C.MICROS_PER_SECOND * j)));
            return null;
        }
        b.g = aVar.g;
        aVar.g = null;
        return aVar;
    }
}
