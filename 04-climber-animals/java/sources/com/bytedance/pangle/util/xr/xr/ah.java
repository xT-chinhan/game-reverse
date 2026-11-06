package com.bytedance.pangle.util.xr.xr;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private int ab;
    private int c;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f705ms;
    private long ny;
    private String x;
    private long xr = 0;
    private long ah = 0;
    private long d = 0;
    private final long ch = 30;

    public long ka() {
        return 28L;
    }

    public int ms() {
        return this.f705ms;
    }

    public void ms(int i) {
        this.f705ms = i;
    }

    public long xr() {
        long j = this.ah;
        return j > 0 ? j : this.d;
    }

    public long ah() {
        return d() + xr();
    }

    public long d() {
        return ((long) this.ka) + 30 + ((long) this.ab);
    }

    public void xr(int i) {
        this.ab = i;
    }

    public int c() {
        return this.ab;
    }

    public long ab() {
        return this.xr;
    }

    public void ms(long j) {
        this.xr = j;
    }

    public long x() {
        return this.ah;
    }

    public void xr(long j) {
        this.ah = j;
    }

    public long ny() {
        return this.d;
    }

    public void ah(long j) {
        this.d = j;
    }

    public int ch() {
        return this.ka;
    }

    public void ah(int i) {
        this.ka = i;
    }

    public int hi() {
        return this.c;
    }

    public void d(int i) {
        this.c = i;
    }

    public String sl() {
        return this.x;
    }

    public void ms(String str) {
        this.x = str;
    }

    public long zb() {
        return this.ny;
    }

    public void d(long j) {
        this.ny = j;
    }
}
