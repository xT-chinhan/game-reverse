package com.smartdigimkt.j0;

import com.smartdigimkt.v0.m;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final int a;
    public final m b;

    public b(int i, m mVar) {
        this.a = i;
        this.b = mVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b.equals(bVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a * 31);
    }
}
