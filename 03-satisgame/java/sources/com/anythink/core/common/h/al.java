package com.anythink.core.common.h;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class al {
    private int a;
    private long b = com.anythink.core.common.g.c.a;
    private List<String> c;
    private Map<String, List<String>> d;

    public final void a(int i) {
        this.a = i;
    }

    public final void a(long j) {
        this.b = j;
    }

    public final void a(List<String> list) {
        this.c = list;
    }

    public final List<String> a() {
        return this.c;
    }

    private int d() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final Map<String, List<String>> c() {
        return this.d;
    }

    public final void a(Map<String, List<String>> map) {
        this.d = map;
    }
}
