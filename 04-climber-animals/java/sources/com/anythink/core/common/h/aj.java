package com.anythink.core.common.h;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class aj {
    private String a;
    private int b;
    private long c;
    private long d;

    private aj() {
    }

    public static aj a(String str, int i) {
        aj ajVar = new aj();
        ajVar.a = str;
        ajVar.b = i;
        return ajVar;
    }

    public final void a(long j) {
        this.c = j;
        if (j > 0) {
            this.d = System.currentTimeMillis() + j;
        }
    }

    public final long a() {
        return this.d;
    }

    public final long b() {
        return this.c;
    }

    public final String c() {
        String str = this.a;
        return str == null ? "" : str;
    }

    public final int d() {
        return this.b;
    }

    public final String toString() {
        return "DynWFAdSourceFilterEntity{adSourceId='" + this.a + "', filterReason=" + this.b + ", reqLimitIntervalTime=" + this.c + ", reqLimitEndTime=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }
}
