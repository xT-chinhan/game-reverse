package com.smartdigimkt.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public final m a;
    public final m b;

    public j(m mVar, m mVar2) {
        this.a = mVar;
        this.b = mVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.a.equals(jVar.a) && this.b.equals(jVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return com.smartdigimkt.f.i.a(new StringBuilder("[").append(this.a), this.a.equals(this.b) ? "" : ", " + this.b, "]");
    }
}
