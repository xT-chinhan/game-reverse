package com.byazt.jl;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1568, 20})
public class hn {
    public long aj;
    public int c;
    public int fw;
    public int pr;
    public int uc;
    public String zo;
    public long hw = 0;
    public long hn = 0;
    public long x = 0;
    public final long vk = 30;

    public int pr() {
        return this.pr;
    }

    public void pr(int i) {
        this.pr = i;
    }

    public long hw() {
        long j = this.hn;
        if (j <= 0) {
            return this.x;
        }
        return j;
    }

    public long hn() {
        return x() + hw();
    }

    public long x() {
        return ((long) this.c) + 30 + ((long) this.fw);
    }

    public long c() {
        return 28L;
    }

    public void hw(int i) {
        this.fw = i;
    }

    public int uc() {
        return this.fw;
    }

    public long fw() {
        return this.hw;
    }

    public void pr(long j) {
        this.hw = j;
    }

    public long zo() {
        return this.hn;
    }

    public void hw(long j) {
        this.hn = j;
    }

    public long aj() {
        return this.x;
    }

    public void hn(long j) {
        this.x = j;
    }

    public int vk() {
        return this.c;
    }

    public void hn(int i) {
        this.c = i;
    }

    public int w() {
        return this.uc;
    }

    public void x(int i) {
        this.uc = i;
    }

    public String k() {
        return this.zo;
    }

    public void pr(String str) {
        this.zo = str;
    }

    public long m() {
        return this.aj;
    }

    public void x(long j) {
        this.aj = j;
    }
}
