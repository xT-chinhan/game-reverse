package com.smartdigimkt.n0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public final int a;
    public final byte[] b;
    public final int c;
    public final int d;

    public n(int i, byte[] bArr, int i2, int i3) {
        this.a = i;
        this.b = bArr;
        this.c = i2;
        this.d = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.a == nVar.a && this.c == nVar.c && this.d == nVar.d && Arrays.equals(this.b, nVar.b);
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.b) + (this.a * 31)) * 31) + this.c) * 31) + this.d;
    }
}
