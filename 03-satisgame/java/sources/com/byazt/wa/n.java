package com.byazt.wa;

import com.anythink.china.a.c;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 19})
public class n extends a {
    public static n n;
    public static final long q;
    public static final long qg;
    public boolean l;
    public n w;
    public long x;

    public void m_() {
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        qg = millis;
        q = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void n() {
        if (this.l) {
            return;
        }
        long jN_ = n_();
        boolean zS = s();
        if (jN_ != 0 || zS) {
            this.l = true;
            n(this, jN_, zS);
        }
    }

    private static synchronized void n(n nVar, long j, boolean z) {
        if (n == null) {
            n = new n();
            C0383n c0383n = new C0383n();
            c0383n.setName("csj_watch_dog");
            try {
                c0383n.start();
            } catch (Throwable unused) {
            }
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            nVar.x = Math.min(j, nVar.o_() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            nVar.x = j + jNanoTime;
        } else if (z) {
            nVar.x = nVar.o_();
        } else {
            throw new AssertionError();
        }
        long jQg = nVar.qg(jNanoTime);
        n nVar2 = n;
        while (true) {
            n nVar3 = nVar2.w;
            if (nVar3 == null || jQg < nVar3.qg(jNanoTime)) {
                break;
                break;
            }
            nVar2 = nVar2.w;
        }
        nVar.w = nVar2.w;
        nVar2.w = nVar;
        if (nVar2 == n) {
            n.class.notify();
        }
    }

    public final boolean qg() {
        if (!this.l) {
            return false;
        }
        this.l = false;
        return n(this);
    }

    private static synchronized boolean n(n nVar) {
        n nVar2 = n;
        while (nVar2 != null) {
            n nVar3 = nVar2.w;
            if (nVar3 == nVar) {
                nVar2.w = nVar.w;
                nVar.w = null;
                return false;
            }
            nVar2 = nVar3;
        }
        return true;
    }

    private long qg(long j) {
        return this.x - j;
    }

    public final cd n(final cd cdVar) {
        return new cd() { // from class: com.byazt.wa.n.1
            @Override // com.byazt.wa.cd
            public void a_(s sVar, long j) throws IOException {
                try {
                    py.n(sVar.qg, 0L, j);
                    while (true) {
                        long j2 = 0;
                        if (j <= 0) {
                            return;
                        }
                        k kVar = sVar.n;
                        while (j2 < c.q) {
                            j2 += (long) (kVar.s - kVar.qg);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            kVar = kVar.w;
                        }
                        n.this.n();
                        try {
                            try {
                                cdVar.a_(sVar, j2);
                                j -= j2;
                                n.this.n(true);
                            } catch (IOException e) {
                                throw n.this.n(e);
                            }
                        } catch (Throwable th) {
                            n.this.n(false);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    throw new IOException(e2);
                }
            }

            @Override // com.byazt.wa.cd, java.io.Flushable
            public void flush() throws IOException {
                n.this.n();
                try {
                    try {
                        cdVar.flush();
                        n.this.n(true);
                    } catch (IOException e) {
                        throw n.this.n(e);
                    }
                } catch (Throwable th) {
                    n.this.n(false);
                    throw th;
                }
            }

            @Override // com.byazt.wa.cd, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                n.this.n();
                try {
                    try {
                        cdVar.close();
                        n.this.n(true);
                    } catch (IOException e) {
                        throw n.this.n(e);
                    }
                } catch (Throwable th) {
                    n.this.n(false);
                    throw th;
                }
            }

            @Override // com.byazt.wa.cd
            public a n() {
                return n.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + cdVar + ")";
            }
        };
    }

    public final um n(final um umVar) {
        return new um() { // from class: com.byazt.wa.n.2
            @Override // com.byazt.wa.um
            public long n(s sVar, long j) throws IOException {
                n.this.n();
                try {
                    try {
                        long jN = umVar.n(sVar, j);
                        n.this.n(true);
                        return jN;
                    } catch (IOException e) {
                        throw n.this.n(e);
                    }
                } catch (Throwable th) {
                    n.this.n(false);
                    throw th;
                }
            }

            @Override // com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                n.this.n();
                try {
                    try {
                        umVar.close();
                        n.this.n(true);
                    } catch (IOException e) {
                        throw n.this.n(e);
                    }
                } catch (Throwable th) {
                    n.this.n(false);
                    throw th;
                }
            }

            @Override // com.byazt.wa.um
            public a n() {
                return n.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + umVar + ")";
            }
        };
    }

    public final void n(boolean z) throws IOException {
        if (qg() && z) {
            throw qg((IOException) null);
        }
    }

    public final IOException n(IOException iOException) throws IOException {
        return !qg() ? iOException : qg(iOException);
    }

    public IOException qg(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: renamed from: com.byazt.wa.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0383n extends com.byazt.xis.s {
        public C0383n() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.m_();
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
                java.lang.Class<com.byazt.wa.n> r0 = com.byazt.wa.n.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
                com.byazt.wa.n r1 = com.byazt.wa.n.q()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                com.byazt.wa.n r2 = com.byazt.wa.n.n     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                com.byazt.wa.n.n = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.m_()     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0 java.lang.Throwable -> L1c
            L1c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.byazt.wa.n.C0383n.run():void");
        }
    }

    public static n q() throws InterruptedException {
        n nVar = n.w;
        if (nVar == null) {
            long jNanoTime = System.nanoTime();
            n.class.wait(qg);
            if (n.w != null || System.nanoTime() - jNanoTime < q) {
                return null;
            }
            return n;
        }
        long jQg = nVar.qg(System.nanoTime());
        if (jQg > 0) {
            long j = jQg / C.MICROS_PER_SECOND;
            n.class.wait(j, (int) (jQg - (C.MICROS_PER_SECOND * j)));
            return null;
        }
        n.w = nVar.w;
        nVar.w = null;
        return nVar;
    }
}
