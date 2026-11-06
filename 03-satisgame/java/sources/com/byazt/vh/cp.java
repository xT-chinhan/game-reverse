package com.byazt.vh;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1778, 29})
public class cp implements x {
    public ou fs;
    public AtomicInteger l;
    public AtomicInteger n;
    public AtomicInteger q;
    public AtomicInteger qg;
    public um rv;
    public AtomicInteger s;
    public float w;
    public d x;

    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if ((TextUtils.equals(str, "src") || TextUtils.equals(str, "backgroundImage")) && str2.startsWith("http")) {
            this.qg.incrementAndGet();
        }
    }

    public int qg() {
        int i = (int) (this.w * this.qg.get());
        this.n.set(i);
        return i;
    }

    public boolean s() {
        return this.n.get() > 0;
    }

    public void n(um umVar) {
        this.rv = umVar;
    }

    public void n(ou ouVar) {
        this.fs = ouVar;
    }

    @Override // com.byazt.vh.x
    public void n() {
        this.q.incrementAndGet();
        if (this.q.get() == 1) {
            synchronized (this) {
                this.q.get();
            }
        }
    }

    @Override // com.byazt.vh.x
    public void n(com.byazt.ih.s sVar, String str) {
        if (this.s.incrementAndGet() == this.n.get()) {
            synchronized (this) {
                if (this.s.get() == this.n.get()) {
                    if (this.x != null) {
                        this.qg.get();
                    }
                    if (this.rv != null) {
                        py pyVar = new py();
                        pyVar.n(0);
                        pyVar.n(sVar.qg(sVar));
                    }
                }
            }
        }
    }

    @Override // com.byazt.vh.x
    public void qg(com.byazt.ih.s sVar, String str) {
        int iIncrementAndGet = this.l.incrementAndGet();
        if (iIncrementAndGet > this.qg.get() - this.n.get()) {
            synchronized (this) {
                if (iIncrementAndGet > this.qg.get() - this.n.get() && this.rv != null) {
                    py pyVar = new py();
                    pyVar.n(-3);
                    pyVar.n("image download fail");
                    pyVar.n(sVar.qg(sVar));
                }
            }
        }
    }
}
