package com.anythink.core.common.h;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class v {
    private final String a;
    private final String b;
    private String c;
    private Map<String, String> d;
    private boolean e;

    public v(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final Map<String, String> d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public final void f() {
        this.e = true;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void a(Map<String, String> map) {
        this.d = map;
    }
}
