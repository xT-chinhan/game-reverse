package com.byazt.x;

import android.os.Process;
import com.byazt.kl.cy;
import com.byazt.qx.BaseException;
import com.byazt.ta.w;
import java.io.InputStream;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 21, 19})
public class n implements qg {
    public com.byazt.kl.n cp;
    public int cy;
    public volatile boolean d;
    public com.byazt.kl.n fs;
    public volatile Future k;
    public final InputStream n;
    public volatile boolean oa;
    public final int qg;
    public com.byazt.kl.n rv;
    public final int s;
    public volatile Throwable sz;
    public com.byazt.kl.n tj;
    public com.byazt.kl.n w;
    public com.byazt.kl.n x;
    public final Object q = new Object();
    public final Object l = new Object();
    public final Runnable hd = new Runnable() { // from class: com.byazt.x.n.1
        @Override // java.lang.Runnable
        public void run() {
            com.byazt.kl.n nVarQ;
            Process.setThreadPriority(10);
            do {
                try {
                    nVarQ = n.this.q();
                    nVarQ.s = n.this.n.read(nVarQ.n);
                    n.this.s(nVarQ);
                } catch (Throwable th) {
                    try {
                        n.this.sz = th;
                        synchronized (n.this.l) {
                            n.this.oa = true;
                            n.this.l.notify();
                            w.n(n.this.n);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (n.this.l) {
                            n.this.oa = true;
                            n.this.l.notify();
                            w.n(n.this.n);
                            throw th2;
                        }
                    }
                }
            } while (nVarQ.s != -1);
            synchronized (n.this.l) {
                n.this.oa = true;
                n.this.l.notify();
            }
            w.n(n.this.n);
        }
    };

    public n(InputStream inputStream, int i, int i2) throws Throwable {
        this.n = inputStream;
        this.qg = i;
        if (i2 <= 0) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.s = i2;
        s();
    }

    @Override // com.byazt.x.qg
    public com.byazt.kl.n n() throws InterruptedException, BaseException {
        return l();
    }

    @Override // com.byazt.x.qg
    public void n(com.byazt.kl.n nVar) {
        qg(nVar);
    }

    @Override // com.byazt.x.qg
    public void qg() {
        synchronized (this.q) {
            this.d = true;
            this.q.notify();
        }
        Future future = this.k;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.k = null;
        }
    }

    private void s() throws Throwable {
        this.k = com.byazt.xv.s.hd().submit(this.hd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.kl.n q() throws InterruptedException, cy {
        int i;
        com.byazt.kl.n nVar = this.fs;
        if (nVar != null) {
            if (this.d) {
                throw new cy("");
            }
            this.fs = nVar.q;
            nVar.q = null;
            return nVar;
        }
        synchronized (this.q) {
            if (this.d) {
                throw new cy("");
            }
            com.byazt.kl.n nVar2 = this.w;
            if (nVar2 == null && (i = this.cy) < this.s) {
                this.cy = i + 1;
                return new com.byazt.kl.n(this.qg);
            }
            while (nVar2 == null) {
                this.q.wait();
                if (this.d) {
                    throw new cy("");
                }
                nVar2 = this.w;
            }
            this.fs = nVar2.q;
            this.x = null;
            this.w = null;
            nVar2.q = null;
            return nVar2;
        }
    }

    private void qg(com.byazt.kl.n nVar) {
        synchronized (this.q) {
            com.byazt.kl.n nVar2 = this.x;
            if (nVar2 == null) {
                this.x = nVar;
                this.w = nVar;
                this.q.notify();
            } else {
                nVar2.q = nVar;
                this.x = nVar;
            }
        }
    }

    private com.byazt.kl.n l() throws InterruptedException, BaseException {
        com.byazt.kl.n nVar;
        com.byazt.kl.n nVar2 = this.cp;
        if (nVar2 != null) {
            this.cp = nVar2.q;
            nVar2.q = null;
            return nVar2;
        }
        synchronized (this.l) {
            nVar = this.rv;
            if (nVar == null) {
                do {
                    if (this.oa) {
                        w();
                    }
                    this.l.wait();
                    nVar = this.rv;
                } while (nVar == null);
            }
            this.cp = nVar.q;
            this.tj = null;
            this.rv = null;
            nVar.q = null;
        }
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(com.byazt.kl.n nVar) {
        synchronized (this.l) {
            com.byazt.kl.n nVar2 = this.tj;
            if (nVar2 == null) {
                this.tj = nVar;
                this.rv = nVar;
                this.l.notify();
            } else {
                nVar2.q = nVar;
                this.tj = nVar;
            }
        }
    }

    private void w() throws BaseException {
        Throwable th = this.sz;
        if (th != null) {
            if (th instanceof cy) {
                throw new BaseException(1068, "async reader closed!");
            }
            w.n(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }
}
