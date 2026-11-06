package com.tapsdk.tapad.internal.download.m.f;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class e extends IOException {
    private final long a;
    private final long b;

    public e(long j, long j2) {
        super("There is Free space less than Require space: " + j2 + " < " + j);
        this.a = j;
        this.b = j2;
    }

    public long a() {
        return this.b;
    }

    public long b() {
        return this.a;
    }
}
