package com.smartdigimkt.x0;

import com.smartdigimkt.i0.s;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Comparable {
    public final d a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    public b(s sVar, d dVar, int i) {
        this.a = dVar;
        this.b = g.a(i, false) ? 1 : 0;
        this.c = g.a(sVar, dVar.c) ? 1 : 0;
        this.d = (sVar.x & 1) != 0 ? 1 : 0;
        this.e = sVar.s;
        this.f = sVar.t;
        this.g = sVar.b;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(b bVar) {
        int i = this.b;
        int i2 = bVar.b;
        if (i != i2) {
            return g.a(i, i2);
        }
        int i3 = this.c;
        int i4 = bVar.c;
        if (i3 != i4) {
            return g.a(i3, i4);
        }
        int i5 = this.d;
        int i6 = bVar.d;
        if (i5 != i6) {
            return g.a(i5, i6);
        }
        if (this.a.n) {
            return g.a(bVar.g, this.g);
        }
        int i7 = i != 1 ? -1 : 1;
        int i8 = this.e;
        int i9 = bVar.e;
        if (i8 != i9) {
            return g.a(i8, i9) * i7;
        }
        int i10 = this.f;
        int i11 = bVar.f;
        return i10 != i11 ? g.a(i10, i11) * i7 : g.a(this.g, bVar.g) * i7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f && this.g == bVar.g;
    }

    public final int hashCode() {
        return (((((((((this.b * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g;
    }
}
