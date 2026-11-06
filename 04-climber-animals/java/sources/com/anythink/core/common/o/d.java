package com.anythink.core.common.o;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    protected int a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected long f;
    protected long g;
    protected int h;

    public final int a() {
        return this.a;
    }

    private void a(int i) {
        this.a = i;
    }

    public final int b() {
        return this.b;
    }

    private void b(int i) {
        this.b = i;
    }

    public final int c() {
        return this.c;
    }

    private void c(int i) {
        this.c = i;
    }

    public final int d() {
        return this.d;
    }

    private void d(int i) {
        this.d = i;
    }

    public final int e() {
        return this.e;
    }

    private void e(int i) {
        this.e = i;
    }

    public final long f() {
        return this.f;
    }

    private void a(long j) {
        this.f = j;
    }

    public final long g() {
        return this.g;
    }

    private void b(long j) {
        this.g = j;
    }

    public final int h() {
        return this.h;
    }

    private void f(int i) {
        this.h = i;
    }

    public final String toString() {
        return "PerformaceEntry{totalMemory=" + this.a + ", phoneVailMemory=" + this.b + ", appJavaMemory=" + this.c + ", appMaxJavaMemory=" + this.d + ", cpuNum=" + this.e + ", totalStorage=" + this.f + ", lastStorage=" + this.g + ", cpuRate=" + this.h + AbstractJsonLexerKt.END_OBJ;
    }
}
