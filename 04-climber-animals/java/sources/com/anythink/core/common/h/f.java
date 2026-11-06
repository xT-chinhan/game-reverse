package com.anythink.core.common.h;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private int i;
    private int j;
    private long k;
    private String l;
    private String m;
    private int n;
    private int o;
    private long p;

    public f(String str) {
        this.b = str;
    }

    public f(String str, String str2, String str3, long j, int i) {
        this.b = str;
        this.k = j;
        this.a = i;
        str3.hashCode();
        switch (str3) {
            case "network_format":
                this.m = str2;
                break;
            case "source_id":
                this.f = str2;
                break;
            case "format":
                this.d = str2;
                break;
            case "network_id":
                this.c = str2;
                break;
            case "app":
                this.l = str2;
                break;
            case "placement_id":
                this.e = str2;
                break;
        }
    }

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, int i3, long j) {
        this.b = str;
        this.l = str2;
        this.c = str3;
        this.d = str4;
        this.m = str5;
        this.e = str6;
        this.f = str7;
        this.h = i;
        this.i = i2;
        this.j = i3;
        this.k = j;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    private String o() {
        return this.g;
    }

    public final int f() {
        return this.h;
    }

    public final int g() {
        return this.i;
    }

    public final int h() {
        return this.j;
    }

    public final long i() {
        return this.k;
    }

    private int p() {
        return this.a;
    }

    public final void a(long j) {
        this.k = j;
    }

    private void c(int i) {
        this.a = i;
    }

    public final String j() {
        return this.l;
    }

    public final String k() {
        return this.m;
    }

    public final void a(String str) {
        this.f = str;
    }

    public final int l() {
        return this.n;
    }

    public final void a(int i) {
        this.n = i;
    }

    public final int m() {
        return this.o;
    }

    public final void b(int i) {
        this.o = i;
    }

    public final long n() {
        return this.p;
    }

    public final void b(long j) {
        this.p = j;
    }

    public final String toString() {
        return "{eventType='" + this.b + "', networkId='" + this.c + "', format='" + this.d + "', placementId='" + this.e + "', sourceId='" + this.f + "', extra='" + this.g + "', month=" + this.h + ", day=" + this.i + ", hour=" + this.j + ", timeStamp=" + this.k + ", reqNum=" + this.a + ", app='" + this.l + "', networkFormat='" + this.m + "'}";
    }
}
