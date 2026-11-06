package com.byazt.sy;

import android.os.Process;
import com.byazt.lhc.BaseException;
import com.byazt.stx.nt;
import com.byazt.tuy.uc;
import java.io.InputStream;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1616, 37})
public class pr implements hw {
    public com.byazt.stx.pr aj;
    public com.byazt.stx.pr fw;
    public volatile Throwable g;
    public final int hn;
    public volatile Future ho;
    public final int hw;
    public volatile boolean k;
    public volatile boolean m;
    public int nt;
    public final InputStream pr;
    public com.byazt.stx.pr uc;
    public com.byazt.stx.pr vk;
    public com.byazt.stx.pr w;
    public com.byazt.stx.pr zo;
    public final Object x = new Object();
    public final Object c = new Object();
    public final Runnable yb = new Runnable() { // from class: com.byazt.sy.pr.1
        @Override // java.lang.Runnable
        public void run() {
            com.byazt.stx.pr prVarX;
            Process.setThreadPriority(10);
            do {
                try {
                    prVarX = pr.this.x();
                    prVarX.hn = pr.this.pr.read(prVarX.pr);
                    pr.this.hn(prVarX);
                } catch (Throwable th) {
                    try {
                        pr.this.g = th;
                        synchronized (pr.this.c) {
                            pr.this.m = true;
                            pr.this.c.notify();
                            uc.pr(pr.this.pr);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (pr.this.c) {
                            pr.this.m = true;
                            pr.this.c.notify();
                            uc.pr(pr.this.pr);
                            throw th2;
                        }
                    }
                }
            } while (prVarX.hn != -1);
            synchronized (pr.this.c) {
                pr.this.m = true;
                pr.this.c.notify();
            }
            uc.pr(pr.this.pr);
        }
    };

    public pr(InputStream inputStream, int i, int i2) throws Throwable {
        this.pr = inputStream;
        this.hw = i;
        if (i2 <= 0) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.hn = i2;
        hn();
    }

    @Override // com.byazt.sy.hw
    public com.byazt.stx.pr pr() throws InterruptedException, BaseException {
        return c();
    }

    @Override // com.byazt.sy.hw
    public void pr(com.byazt.stx.pr prVar) {
        hw(prVar);
    }

    @Override // com.byazt.sy.hw
    public void hw() {
        synchronized (this.x) {
            this.k = true;
            this.x.notify();
        }
        Future future = this.ho;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
            }
            this.ho = null;
        }
    }

    private void hn() throws Throwable {
        this.ho = com.byazt.lj.hn.yb().submit(this.yb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.stx.pr x() throws InterruptedException, nt {
        int i;
        com.byazt.stx.pr prVar = this.zo;
        if (prVar != null) {
            if (this.k) {
                throw new nt("");
            }
            this.zo = prVar.x;
            prVar.x = null;
            return prVar;
        }
        synchronized (this.x) {
            if (this.k) {
                throw new nt("");
            }
            com.byazt.stx.pr prVar2 = this.uc;
            if (prVar2 == null && (i = this.nt) < this.hn) {
                this.nt = i + 1;
                return new com.byazt.stx.pr(this.hw);
            }
            while (prVar2 == null) {
                this.x.wait();
                if (this.k) {
                    throw new nt("");
                }
                prVar2 = this.uc;
            }
            this.zo = prVar2.x;
            this.fw = null;
            this.uc = null;
            prVar2.x = null;
            return prVar2;
        }
    }

    private void hw(com.byazt.stx.pr prVar) {
        synchronized (this.x) {
            com.byazt.stx.pr prVar2 = this.fw;
            if (prVar2 == null) {
                this.fw = prVar;
                this.uc = prVar;
                this.x.notify();
            } else {
                prVar2.x = prVar;
                this.fw = prVar;
            }
        }
    }

    private com.byazt.stx.pr c() throws InterruptedException, BaseException {
        com.byazt.stx.pr prVar;
        com.byazt.stx.pr prVar2 = this.w;
        if (prVar2 != null) {
            this.w = prVar2.x;
            prVar2.x = null;
            return prVar2;
        }
        synchronized (this.c) {
            prVar = this.aj;
            if (prVar == null) {
                do {
                    if (this.m) {
                        uc();
                    }
                    this.c.wait();
                    prVar = this.aj;
                } while (prVar == null);
            }
            this.w = prVar.x;
            this.vk = null;
            this.aj = null;
            prVar.x = null;
        }
        return prVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(com.byazt.stx.pr prVar) {
        synchronized (this.c) {
            com.byazt.stx.pr prVar2 = this.vk;
            if (prVar2 == null) {
                this.vk = prVar;
                this.aj = prVar;
                this.c.notify();
            } else {
                prVar2.x = prVar;
                this.vk = prVar;
            }
        }
    }

    private void uc() throws BaseException {
        Throwable th = this.g;
        if (th != null) {
            if (th instanceof nt) {
                throw new BaseException(1068, "async reader closed!");
            }
            uc.pr(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }
}
