package com.bytedance.sdk.component.ah.ms;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends t {
    private static final long d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static ms f1009ms;
    private static final long xr;
    private long ab;
    private ms c;
    private boolean ka;

    protected void e_() {
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        xr = millis;
        d = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void ms() {
        if (this.ka) {
            return;
        }
        long jF_ = f_();
        boolean zAh = ah();
        if (jF_ != 0 || zAh) {
            this.ka = true;
            ms(this, jF_, zAh);
        }
    }

    private static synchronized void ms(ms msVar, long j, boolean z) {
        if (f1009ms == null) {
            f1009ms = new ms();
            C0239ms c0239ms = new C0239ms();
            c0239ms.setName("csj_watch_dog");
            try {
                c0239ms.start();
            } catch (Throwable unused) {
            }
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            msVar.ab = Math.min(j, msVar.g_() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            msVar.ab = j + jNanoTime;
        } else if (z) {
            msVar.ab = msVar.g_();
        } else {
            throw new AssertionError();
        }
        long jXr = msVar.xr(jNanoTime);
        ms msVar2 = f1009ms;
        while (true) {
            ms msVar3 = msVar2.c;
            if (msVar3 == null || jXr < msVar3.xr(jNanoTime)) {
                break;
                break;
            }
            msVar2 = msVar2.c;
        }
        msVar.c = msVar2.c;
        msVar2.c = msVar;
        if (msVar2 == f1009ms) {
            ms.class.notify();
        }
    }

    public final boolean xr() {
        if (!this.ka) {
            return false;
        }
        this.ka = false;
        return ms(this);
    }

    private static synchronized boolean ms(ms msVar) {
        ms msVar2 = f1009ms;
        while (msVar2 != null) {
            ms msVar3 = msVar2.c;
            if (msVar3 == msVar) {
                msVar2.c = msVar.c;
                msVar.c = null;
                return false;
            }
            msVar2 = msVar3;
        }
        return true;
    }

    private long xr(long j) {
        return this.ab - j;
    }

    public final qv ms(final qv qvVar) {
        return new qv() { // from class: com.bytedance.sdk.component.ah.ms.ms.1
            @Override // com.bytedance.sdk.component.ah.ms.qv
            public void a_(ah ahVar, long j) throws IOException {
                try {
                    nw.ms(ahVar.xr, 0L, j);
                    while (true) {
                        long j2 = 0;
                        if (j <= 0) {
                            return;
                        }
                        ub ubVar = ahVar.f1003ms;
                        while (j2 < 65536) {
                            j2 += (long) (ubVar.ah - ubVar.xr);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            ubVar = ubVar.c;
                        }
                        ms.this.ms();
                        try {
                            try {
                                qvVar.a_(ahVar, j2);
                                j -= j2;
                                ms.this.ms(true);
                            } catch (IOException e) {
                                throw ms.this.ms(e);
                            }
                        } catch (Throwable th) {
                            ms.this.ms(false);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    throw new IOException(e2);
                }
            }

            @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Flushable
            public void flush() throws IOException {
                ms.this.ms();
                try {
                    try {
                        qvVar.flush();
                        ms.this.ms(true);
                    } catch (IOException e) {
                        throw ms.this.ms(e);
                    }
                } catch (Throwable th) {
                    ms.this.ms(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                ms.this.ms();
                try {
                    try {
                        qvVar.close();
                        ms.this.ms(true);
                    } catch (IOException e) {
                        throw ms.this.ms(e);
                    }
                } catch (Throwable th) {
                    ms.this.ms(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.ah.ms.qv
            public t ms() {
                return ms.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + qvVar + ")";
            }
        };
    }

    public final y ms(final y yVar) {
        return new y() { // from class: com.bytedance.sdk.component.ah.ms.ms.2
            @Override // com.bytedance.sdk.component.ah.ms.y
            public long ms(ah ahVar, long j) throws IOException {
                ms.this.ms();
                try {
                    try {
                        long jMs = yVar.ms(ahVar, j);
                        ms.this.ms(true);
                        return jMs;
                    } catch (IOException e) {
                        throw ms.this.ms(e);
                    }
                } catch (Throwable th) {
                    ms.this.ms(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.ah.ms.y, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                ms.this.ms();
                try {
                    try {
                        yVar.close();
                        ms.this.ms(true);
                    } catch (IOException e) {
                        throw ms.this.ms(e);
                    }
                } catch (Throwable th) {
                    ms.this.ms(false);
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.component.ah.ms.y
            public t ms() {
                return ms.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + yVar + ")";
            }
        };
    }

    final void ms(boolean z) throws IOException {
        if (xr() && z) {
            throw xr((IOException) null);
        }
    }

    final IOException ms(IOException iOException) throws IOException {
        return !xr() ? iOException : xr(iOException);
    }

    protected IOException xr(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.ah.ms.ms$ms, reason: collision with other inner class name */
    private static final class C0239ms extends com.bytedance.sdk.component.ch.d.ah {
        C0239ms() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.e_();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<com.bytedance.sdk.component.ah.ms.ms> r0 = com.bytedance.sdk.component.ah.ms.ms.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
                com.bytedance.sdk.component.ah.ms.ms r1 = com.bytedance.sdk.component.ah.ms.ms.d()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                com.bytedance.sdk.component.ah.ms.ms r2 = com.bytedance.sdk.component.ah.ms.ms.f1009ms     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                com.bytedance.sdk.component.ah.ms.ms.f1009ms = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.e_()     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
            L1c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ah.ms.ms.C0239ms.run():void");
        }
    }

    static ms d() throws InterruptedException {
        ms msVar = f1009ms.c;
        if (msVar == null) {
            long jNanoTime = System.nanoTime();
            ms.class.wait(xr);
            if (f1009ms.c != null || System.nanoTime() - jNanoTime < d) {
                return null;
            }
            return f1009ms;
        }
        long jXr = msVar.xr(System.nanoTime());
        if (jXr > 0) {
            long j = jXr / 1000000;
            ms.class.wait(j, (int) (jXr - (1000000 * j)));
            return null;
        }
        f1009ms.c = msVar.c;
        msVar.c = null;
        return msVar;
    }
}
