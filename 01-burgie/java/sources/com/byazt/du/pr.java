package com.byazt.du;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, 37})
public class pr extends a {
    public static final long hw;
    public static pr pr;
    public static final long x;
    public boolean c;
    public long fw;
    public pr uc;

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        hw = millis;
        x = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void pr() {
        if (this.c) {
            return;
        }
        long jF_ = f_();
        boolean zHn = hn();
        if (jF_ == 0 && !zHn) {
            return;
        }
        this.c = true;
        pr(this, jF_, zHn);
    }

    private static synchronized void pr(pr prVar, long j, boolean z) {
        if (pr == null) {
            pr = new pr();
            C0045pr c0045pr = new C0045pr();
            c0045pr.setName("csj_watch_dog");
            try {
                c0045pr.start();
            } catch (Throwable th) {
            }
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            prVar.fw = Math.min(j, prVar.g_() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            prVar.fw = j + jNanoTime;
        } else if (z) {
            prVar.fw = prVar.g_();
        } else {
            throw new AssertionError();
        }
        long jHw = prVar.hw(jNanoTime);
        pr prVar2 = pr;
        while (true) {
            pr prVar3 = prVar2.uc;
            if (prVar3 == null || jHw < prVar3.hw(jNanoTime)) {
                break;
                break;
            }
            prVar2 = prVar2.uc;
        }
        prVar.uc = prVar2.uc;
        prVar2.uc = prVar;
        if (prVar2 == pr) {
            pr.class.notify();
        }
    }

    public final boolean hw() {
        if (!this.c) {
            return false;
        }
        this.c = false;
        return pr(this);
    }

    private static synchronized boolean pr(pr prVar) {
        pr prVar2 = pr;
        while (prVar2 != null) {
            pr prVar3 = prVar2.uc;
            if (prVar3 != prVar) {
                prVar2 = prVar3;
            } else {
                prVar2.uc = prVar.uc;
                prVar.uc = null;
                return false;
            }
        }
        return true;
    }

    private long hw(long j) {
        return this.fw - j;
    }

    public void e_() {
    }

    public final lb pr(final lb lbVar) {
        return new lb() { // from class: com.byazt.du.pr.1
            @Override // com.byazt.du.lb
            public void a_(hn hnVar, long j) throws IOException {
                try {
                    cz.pr(hnVar.hw, 0L, j);
                    while (true) {
                        long j2 = 0;
                        if (j > 0) {
                            ho hoVar = hnVar.pr;
                            while (j2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                                j2 += (long) (hoVar.hn - hoVar.hw);
                                if (j2 < j) {
                                    hoVar = hoVar.uc;
                                } else {
                                    j2 = j;
                                    break;
                                }
                            }
                            pr.this.pr();
                            try {
                                try {
                                    lbVar.a_(hnVar, j2);
                                    j -= j2;
                                    pr.this.pr(true);
                                } catch (IOException e) {
                                    throw pr.this.pr(e);
                                }
                            } catch (Throwable th) {
                                pr.this.pr(false);
                                throw th;
                            }
                        } else {
                            return;
                        }
                    }
                } catch (Exception e2) {
                    throw new IOException(e2);
                }
            }

            @Override // com.byazt.du.lb, java.io.Flushable
            public void flush() throws IOException {
                pr.this.pr();
                try {
                    try {
                        lbVar.flush();
                        pr.this.pr(true);
                    } catch (IOException e) {
                        throw pr.this.pr(e);
                    }
                } catch (Throwable th) {
                    pr.this.pr(false);
                    throw th;
                }
            }

            @Override // com.byazt.du.lb, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                pr.this.pr();
                try {
                    try {
                        lbVar.close();
                        pr.this.pr(true);
                    } catch (IOException e) {
                        throw pr.this.pr(e);
                    }
                } catch (Throwable th) {
                    pr.this.pr(false);
                    throw th;
                }
            }

            @Override // com.byazt.du.lb
            public a pr() {
                return pr.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + lbVar + ")";
            }
        };
    }

    public final qa pr(final qa qaVar) {
        return new qa() { // from class: com.byazt.du.pr.2
            @Override // com.byazt.du.qa
            public long pr(hn hnVar, long j) throws IOException {
                pr.this.pr();
                try {
                    try {
                        long jPr = qaVar.pr(hnVar, j);
                        pr.this.pr(true);
                        return jPr;
                    } catch (IOException e) {
                        throw pr.this.pr(e);
                    }
                } catch (Throwable th) {
                    pr.this.pr(false);
                    throw th;
                }
            }

            @Override // com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                pr.this.pr();
                try {
                    try {
                        qaVar.close();
                        pr.this.pr(true);
                    } catch (IOException e) {
                        throw pr.this.pr(e);
                    }
                } catch (Throwable th) {
                    pr.this.pr(false);
                    throw th;
                }
            }

            @Override // com.byazt.du.qa
            public a pr() {
                return pr.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + qaVar + ")";
            }
        };
    }

    public final void pr(boolean z) throws IOException {
        if (hw() && z) {
            throw hw((IOException) null);
        }
    }

    public final IOException pr(IOException iOException) throws IOException {
        return !hw() ? iOException : hw(iOException);
    }

    public IOException hw(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: renamed from: com.byazt.du.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static final class C0045pr extends com.byazt.fr.hn {
        public C0045pr() {
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
                java.lang.Class<com.byazt.du.pr> r0 = com.byazt.du.pr.class
                monitor-enter(r0)     // Catch: java.lang.Throwable -> L1c java.lang.InterruptedException -> L1e
                com.byazt.du.pr r1 = com.byazt.du.pr.x()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                com.byazt.du.pr r2 = com.byazt.du.pr.pr     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                com.byazt.du.pr.pr = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.e_()     // Catch: java.lang.Throwable -> L1c java.lang.InterruptedException -> L1e
                goto L1f
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.Throwable -> L1c java.lang.InterruptedException -> L1e
            L1c:
                r0 = move-exception
                return
            L1e:
                r0 = move-exception
            L1f:
                goto L0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.byazt.du.pr.C0045pr.run():void");
        }
    }

    public static pr x() throws InterruptedException {
        pr prVar = pr.uc;
        if (prVar == null) {
            long jNanoTime = System.nanoTime();
            pr.class.wait(hw);
            if (pr.uc != null || System.nanoTime() - jNanoTime < x) {
                return null;
            }
            return pr;
        }
        long jHw = prVar.hw(System.nanoTime());
        if (jHw > 0) {
            long j = jHw / C.MICROS_PER_SECOND;
            pr.class.wait(j, (int) (jHw - (C.MICROS_PER_SECOND * j)));
            return null;
        }
        pr.uc = prVar.uc;
        prVar.uc = null;
        return prVar;
    }
}
