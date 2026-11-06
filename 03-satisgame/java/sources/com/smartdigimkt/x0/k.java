package com.smartdigimkt.x0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public final int a;
    public final h[] b;
    public int c;

    public k(h... hVarArr) {
        this.b = hVarArr;
        this.a = hVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.b, ((k) obj).b);
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b) + 527;
        }
        return this.c;
    }
}
