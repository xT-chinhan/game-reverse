package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TTransportException.java */
/* JADX INFO: loaded from: classes3.dex */
public class ck extends bc {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static final long g = 1;
    protected int f;

    public ck() {
        this.f = 0;
    }

    public ck(int i) {
        this.f = 0;
        this.f = i;
    }

    public ck(int i, String str) {
        super(str);
        this.f = 0;
        this.f = i;
    }

    public ck(String str) {
        super(str);
        this.f = 0;
    }

    public ck(int i, Throwable th) {
        super(th);
        this.f = 0;
        this.f = i;
    }

    public ck(Throwable th) {
        super(th);
        this.f = 0;
    }

    public ck(String str, Throwable th) {
        super(str, th);
        this.f = 0;
    }

    public ck(int i, String str, Throwable th) {
        super(str, th);
        this.f = 0;
        this.f = i;
    }

    public int a() {
        return this.f;
    }
}
