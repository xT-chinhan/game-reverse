package com.smartdigimkt.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final m c = new m(0, 0);
    public final long a;
    public final long b;

    public m(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.a == mVar.a && this.b == mVar.b;
    }

    public final int hashCode() {
        return (((int) this.a) * 31) + ((int) this.b);
    }

    public final String toString() {
        return "[timeUs=" + this.a + ", position=" + this.b + "]";
    }
}
