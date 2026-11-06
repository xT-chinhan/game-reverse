package com.smartdigimkt.i0;

import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 {
    public static final g0 c;
    public static final g0 d;
    public final long a;
    public final long b;

    static {
        g0 g0Var = new g0(0L, 0L);
        c = g0Var;
        new g0(LongCompanionObject.MAX_VALUE, LongCompanionObject.MAX_VALUE);
        new g0(LongCompanionObject.MAX_VALUE, 0L);
        new g0(0L, LongCompanionObject.MAX_VALUE);
        d = g0Var;
    }

    public g0(long j, long j2) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j2 < 0) {
            throw new IllegalArgumentException();
        }
        this.a = j;
        this.b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g0.class != obj.getClass()) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.a == g0Var.a && this.b == g0Var.b;
    }

    public final int hashCode() {
        return (((int) this.a) * 31) + ((int) this.b);
    }
}
