package com.anythink.core.common.c;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements e {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    protected String d;
    protected Context e;
    protected String f;
    protected long g;

    public d(Context context, String str, String str2, long j) {
        this.d = str;
        this.e = context;
        this.f = str2;
        this.g = j;
    }

    @Override // com.anythink.core.common.c.e
    public final String a() {
        return this.d;
    }

    private String d() {
        return this.f;
    }

    private long e() {
        return this.g;
    }
}
