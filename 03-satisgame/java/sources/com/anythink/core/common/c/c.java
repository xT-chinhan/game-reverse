package com.anythink.core.common.c;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private String a;
    private long b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;

    private c(String str, String str2, boolean z, long j, boolean z2) {
        this(str, str2, z, j, z2, null);
    }

    private c(String str, String str2, boolean z, long j, boolean z2, String str3) {
        this.a = str;
        this.f = str2;
        this.e = z;
        this.b = j;
        this.c = z2;
        this.d = str3;
    }

    private String b() {
        return this.a;
    }

    private long c() {
        return this.b;
    }

    private boolean d() {
        return this.c;
    }

    private String e() {
        return this.d;
    }

    public final boolean a() {
        return this.e;
    }

    private String f() {
        return this.f;
    }

    public final String toString() {
        return "ApkInspectResult{pkgName='" + this.a + "', inspectTime=" + this.b + ", inspectResult=" + this.c + ", appVersion='" + this.d + "', isRealTimeInspect=" + this.e + ", uploadKey='" + this.f + "'}";
    }
}
