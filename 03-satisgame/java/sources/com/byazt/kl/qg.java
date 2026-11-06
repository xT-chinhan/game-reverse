package com.byazt.kl;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 445, 26})
public class qg implements l, q, s {
    public int cp;
    public n fs;
    public n l;
    public final int n;
    public final int qg;
    public n rv;
    public volatile boolean tj;
    public n w;
    public n x;
    public final Object s = new Object();
    public final Object q = new Object();

    public qg(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.n = i;
        this.qg = i2;
    }

    @Override // com.byazt.kl.q
    public n n() throws InterruptedException, cy {
        n nVar;
        n nVar2 = this.rv;
        if (nVar2 != null) {
            this.rv = nVar2.q;
            nVar2.q = null;
            return nVar2;
        }
        synchronized (this.q) {
            nVar = this.x;
            while (nVar == null) {
                if (this.tj) {
                    throw new cy("read");
                }
                this.q.wait();
                nVar = this.x;
            }
            this.rv = nVar.q;
            this.fs = null;
            this.x = null;
            nVar.q = null;
        }
        return nVar;
    }

    @Override // com.byazt.kl.s
    public void n(n nVar) {
        synchronized (this.s) {
            n nVar2 = this.w;
            if (nVar2 == null) {
                this.w = nVar;
                this.l = nVar;
            } else {
                nVar2.q = nVar;
                this.w = nVar;
            }
            this.s.notify();
        }
    }

    @Override // com.byazt.kl.s
    public n qg() throws InterruptedException, cy {
        synchronized (this.s) {
            if (this.tj) {
                throw new cy("obtain");
            }
            n nVar = this.l;
            if (nVar == null) {
                int i = this.cp;
                if (i < this.n) {
                    this.cp = i + 1;
                    return new n(this.qg);
                }
                do {
                    this.s.wait();
                    if (this.tj) {
                        throw new cy("obtain");
                    }
                    nVar = this.l;
                } while (nVar == null);
            }
            this.l = nVar.q;
            if (nVar == this.w) {
                this.w = null;
            }
            nVar.q = null;
            return nVar;
        }
    }

    @Override // com.byazt.kl.l
    public void qg(n nVar) {
        synchronized (this.q) {
            n nVar2 = this.fs;
            if (nVar2 == null) {
                this.fs = nVar;
                this.x = nVar;
                this.q.notify();
            } else {
                nVar2.q = nVar;
                this.fs = nVar;
            }
        }
    }

    public void s() {
        this.tj = true;
        synchronized (this.s) {
            this.s.notifyAll();
        }
        synchronized (this.q) {
            this.q.notifyAll();
        }
    }
}
