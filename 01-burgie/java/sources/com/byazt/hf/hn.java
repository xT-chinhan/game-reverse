package com.byazt.hf;

import com.byazt.ax.uc;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.wt.ls;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 219, 20})
public class hn {
    public int c;
    public final com.byazt.lu.pr fw;
    public final uc uc;
    public final int x;
    public int pr = 0;
    public int hw = 0;
    public int hn = 1000;

    public hn(boolean z, of ofVar, uc ucVar, com.byazt.lu.pr prVar) {
        this.uc = ucVar;
        this.fw = prVar;
        this.x = z ? a.hw().x(ls.m(ofVar)) : a.hw().c(ls.m(ofVar));
    }

    public long pr() {
        return this.uc.gz();
    }

    public int hw() {
        return this.c;
    }

    public void pr(int i) {
        this.c += i;
    }

    public int hn() {
        return this.x;
    }

    public int x() {
        return this.fw.er();
    }

    public int c() {
        return this.pr;
    }

    public int uc() {
        return this.hw;
    }

    public void fw() {
        this.pr++;
    }

    public void zo() {
        this.hw++;
    }

    public void hw(int i) {
        this.hw = i;
    }

    public void hn(int i) {
        this.hn = i;
    }

    public int aj() {
        return this.hn;
    }
}
