package com.byazt.zn;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 94, 5})
public class uc extends pr {
    public long aj;
    public boolean c;
    public long fw;
    public long uc;
    public com.byazt.hg.pr x;
    public long zo;

    public uc(com.byazt.hg.pr prVar, boolean z) {
        this.x = prVar;
        if (prVar != null && prVar.hw() != null && !this.x.hw().isEmpty()) {
            this.hw = this.x.hw().get(0);
        }
        this.c = z;
    }

    public com.byazt.hg.pr x() {
        return this.x;
    }

    public boolean c() {
        return this.c;
    }

    public long uc() {
        return this.uc;
    }

    public void hw(long j) {
        this.uc = j;
    }

    public long fw() {
        return this.fw;
    }

    public void hn(long j) {
        this.fw = j;
    }

    public long zo() {
        return this.zo;
    }

    public void x(long j) {
        this.zo = j;
    }

    public long aj() {
        return this.aj;
    }

    public void c(long j) {
        this.aj = j;
    }
}
