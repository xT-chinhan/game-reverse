package com.anythink.basead.exoplayer.i;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public final int a;
    private final f[] b;
    private int c;

    public g(f... fVarArr) {
        this.b = fVarArr;
        this.a = fVarArr.length;
    }

    public final f a(int i) {
        return this.b[i];
    }

    public final f[] a() {
        return (f[]) this.b.clone();
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b) + 527;
        }
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.b, ((g) obj).b);
    }
}
