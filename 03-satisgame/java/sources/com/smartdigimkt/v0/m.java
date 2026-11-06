package com.smartdigimkt.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public final int a;
    public final int b;
    public final int c;
    public final long d;

    public m(int i) {
        this(i, -1, -1, -1L);
    }

    public final m a(int i) {
        return this.a == i ? this : new m(i, this.b, this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.a == mVar.a && this.b == mVar.b && this.c == mVar.c && this.d == mVar.d;
    }

    public final int hashCode() {
        return ((((((this.a + 527) * 31) + this.b) * 31) + this.c) * 31) + ((int) this.d);
    }

    public m(int i, int i2, int i3, long j) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = j;
    }

    public final boolean a() {
        return this.b != -1;
    }
}
