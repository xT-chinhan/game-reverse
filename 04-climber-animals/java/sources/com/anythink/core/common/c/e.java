package com.anythink.core.common.c;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements f {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    protected final long d = 86400000;
    protected String e;
    protected Context f;
    protected String g;
    protected long h;

    public e(Context context, String str, String str2, long j) {
        this.e = str;
        this.f = context;
        this.g = str2;
        this.h = j;
    }

    private String c() {
        return this.e;
    }

    private String d() {
        return this.g;
    }

    private long e() {
        return this.h;
    }
}
