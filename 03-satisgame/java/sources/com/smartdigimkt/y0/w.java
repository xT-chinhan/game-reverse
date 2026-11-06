package com.smartdigimkt.y0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.smartdigimkt.v0.e0;
import com.smartdigimkt.v0.l0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends Handler implements Runnable {
    public final int a;
    public final com.smartdigimkt.v0.f b;
    public final long c;
    public v d;
    public IOException e;
    public int f;
    public volatile Thread g;
    public volatile boolean h;
    public volatile boolean i;
    public final /* synthetic */ a0 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(a0 a0Var, Looper looper, com.smartdigimkt.v0.f fVar, v vVar, int i, long j) {
        super(looper);
        this.j = a0Var;
        this.b = fVar;
        this.d = vVar;
        this.a = i;
        this.c = j;
    }

    public final void a(boolean z) {
        this.i = z;
        this.e = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.h = true;
            this.b.f = true;
            if (this.g != null) {
                this.g.interrupt();
            }
        }
        if (z) {
            this.j.b = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ((com.smartdigimkt.v0.i) this.d).a(this.b, jElapsedRealtime, jElapsedRealtime - this.c, true);
            this.d = null;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        char c;
        com.smartdigimkt.n0.l lVar;
        if (this.i) {
            return;
        }
        int i = message.what;
        if (i == 0) {
            this.e = null;
            a0 a0Var = this.j;
            a0Var.a.execute(a0Var.b);
            return;
        }
        if (i == 4) {
            throw ((Error) message.obj);
        }
        this.j.b = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.c;
        if (this.h) {
            ((com.smartdigimkt.v0.i) this.d).a(this.b, jElapsedRealtime, j, false);
            return;
        }
        int i2 = message.what;
        if (i2 == 1) {
            ((com.smartdigimkt.v0.i) this.d).a(this.b, jElapsedRealtime, j, false);
            return;
        }
        if (i2 == 2) {
            try {
                ((com.smartdigimkt.v0.i) this.d).a(this.b, jElapsedRealtime, j);
                return;
            } catch (RuntimeException e) {
                this.j.c = new z(e);
                return;
            }
        }
        if (i2 != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.e = iOException;
        v vVar = this.d;
        com.smartdigimkt.v0.f fVar = this.b;
        com.smartdigimkt.v0.i iVar = (com.smartdigimkt.v0.i) vVar;
        iVar.getClass();
        boolean z = iOException instanceof l0;
        com.smartdigimkt.v0.x xVar = iVar.d;
        k kVar = fVar.i;
        long j2 = fVar.h;
        long j3 = iVar.A;
        com.smartdigimkt.v0.y yVar = new com.smartdigimkt.v0.y();
        xVar.a(j2);
        xVar.a(j3);
        com.smartdigimkt.v0.z zVar = new com.smartdigimkt.v0.z();
        for (com.smartdigimkt.v0.w wVar : xVar.c) {
            com.smartdigimkt.v0.x.a(wVar.a, new com.smartdigimkt.v0.t(xVar, wVar.b, yVar, zVar, iOException, z));
            xVar = xVar;
        }
        if (iVar.F == -1) {
            iVar.F = fVar.j;
        }
        if (z) {
            c = 3;
        } else {
            int iF = iVar.f();
            boolean z2 = iF > iVar.J;
            if (iVar.F == -1 && ((lVar = iVar.p) == null || lVar.b() == -9223372036854775807L)) {
                boolean z3 = iVar.t;
                if (z3 && !iVar.w && iVar.H == -9223372036854775807L) {
                    iVar.I = true;
                    c = 2;
                } else {
                    iVar.w = z3;
                    iVar.G = 0L;
                    iVar.J = 0;
                    for (e0 e0Var : iVar.q) {
                        e0Var.d();
                    }
                    fVar.e.a = 0L;
                    fVar.h = 0L;
                    fVar.g = true;
                }
            } else {
                iVar.J = iF;
            }
            c = z2 ? (char) 1 : (char) 0;
        }
        if (c == 3) {
            this.j.c = this.e;
            return;
        }
        if (c != 2) {
            int i3 = c == 1 ? 1 : this.f + 1;
            this.f = i3;
            long jMin = Math.min((i3 - 1) * 1000, 5000);
            a0 a0Var2 = this.j;
            if (a0Var2.b != null) {
                throw new IllegalStateException();
            }
            a0Var2.b = this;
            if (jMin > 0) {
                sendEmptyMessageDelayed(0, jMin);
            } else {
                this.e = null;
                a0Var2.a.execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.g = Thread.currentThread();
            if (!this.h) {
                com.smartdigimkt.z0.s.a("load:".concat(this.b.getClass().getSimpleName()));
                try {
                    this.b.a();
                    com.smartdigimkt.z0.s.a();
                } catch (Throwable th) {
                    com.smartdigimkt.z0.s.a();
                    throw th;
                }
            }
            if (this.i) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e) {
            if (this.i) {
                return;
            }
            obtainMessage(3, e).sendToTarget();
        } catch (Error e2) {
            if (!this.i) {
                obtainMessage(4, e2).sendToTarget();
            }
            throw e2;
        } catch (InterruptedException unused) {
            if (!this.h) {
                throw new IllegalStateException();
            }
            if (this.i) {
                return;
            }
            sendEmptyMessage(2);
        } catch (Exception e3) {
            if (this.i) {
                return;
            }
            obtainMessage(3, new z(e3)).sendToTarget();
        } catch (OutOfMemoryError e4) {
            if (this.i) {
                return;
            }
            obtainMessage(3, new z(e4)).sendToTarget();
        }
    }
}
