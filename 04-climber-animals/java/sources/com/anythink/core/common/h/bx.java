package com.anythink.core.common.h;

/* JADX INFO: loaded from: classes.dex */
public final class bx {
    long a;

    public bx(long j, long j2) {
        this.a = j + j2;
    }

    public final boolean a() {
        return System.currentTimeMillis() <= this.a;
    }
}
