package com.anythink.core.d;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private static final String a = "g";
    private long b = System.currentTimeMillis();
    private long c = 86400000;
    private List<com.anythink.core.common.i.b> d = new ArrayList();
    private int e = 1;
    private long f = 28800000;

    private List<com.anythink.core.common.i.b> a() {
        return this.d;
    }

    private g() {
    }

    private boolean b() {
        return System.currentTimeMillis() >= this.b + this.c;
    }

    private long c() {
        return this.b;
    }

    private void a(long j) {
        this.b = j;
    }

    private int d() {
        return this.e;
    }

    private long e() {
        return this.f;
    }
}
