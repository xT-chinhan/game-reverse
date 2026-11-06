package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TProtocolException.java */
/* JADX INFO: loaded from: classes3.dex */
public class bw extends bc {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    private static final long h = 1;
    protected int g;

    public bw() {
        this.g = 0;
    }

    public bw(int i) {
        this.g = 0;
        this.g = i;
    }

    public bw(int i, String str) {
        super(str);
        this.g = 0;
        this.g = i;
    }

    public bw(String str) {
        super(str);
        this.g = 0;
    }

    public bw(int i, Throwable th) {
        super(th);
        this.g = 0;
        this.g = i;
    }

    public bw(Throwable th) {
        super(th);
        this.g = 0;
    }

    public bw(String str, Throwable th) {
        super(str, th);
        this.g = 0;
    }

    public bw(int i, String str, Throwable th) {
        super(str, th);
        this.g = 0;
        this.g = i;
    }

    public int a() {
        return this.g;
    }
}
