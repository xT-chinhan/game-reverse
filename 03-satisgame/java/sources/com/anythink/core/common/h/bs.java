package com.anythink.core.common.h;

/* JADX INFO: loaded from: classes.dex */
public final class bs {
    private String a;
    private boolean b;
    private Boolean c;

    public bs(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public final synchronized void a(boolean z) {
        this.c = Boolean.valueOf(z);
    }

    public final synchronized String a() {
        return this.a;
    }

    private synchronized boolean b() {
        return this.b;
    }

    private synchronized Boolean c() {
        return this.c;
    }
}
