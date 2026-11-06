package com.anythink.core.common.h;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    JSONArray d;
    int e;
    String f;
    long g;

    public e(JSONArray jSONArray, int i, String str, long j) {
        this.d = jSONArray;
        this.e = i;
        this.f = str;
        this.g = j;
    }

    private JSONArray a() {
        return this.d;
    }

    private int b() {
        return this.e;
    }

    private String c() {
        return this.f;
    }

    private long d() {
        return this.g;
    }
}
