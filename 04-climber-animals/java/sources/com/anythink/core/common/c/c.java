package com.anythink.core.common.c;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private String a;
    private long b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;

    public c(String str, String str2, boolean z, long j, boolean z2) {
        this(str, str2, z, j, z2, null);
    }

    public c(String str, String str2, boolean z, long j, boolean z2, String str3) {
        this.a = str;
        this.f = str2;
        this.e = z;
        this.b = j;
        this.c = z2;
        this.d = str3;
    }

    private String f() {
        return this.a;
    }

    public final long a() {
        return this.b;
    }

    public final boolean b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final boolean d() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    public final String toString() {
        return "ApkInspectResult{pkgName='" + this.a + "', inspectTime=" + this.b + ", inspectResult=" + this.c + ", appVersion='" + this.d + "', isRealTimeInspect=" + this.e + ", uploadKey='" + this.f + "'}";
    }
}
