package com.bytedance.sdk.component.xr.ms.xr;

/* JADX INFO: loaded from: classes2.dex */
final class c {
    c ab;
    int ah;
    c c;
    boolean d;
    boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final byte[] f1626ms;
    int xr;

    c() {
        this.f1626ms = new byte[8192];
        this.ka = true;
        this.d = false;
    }

    c(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f1626ms = bArr;
        this.xr = i;
        this.ah = i2;
        this.d = z;
        this.ka = z2;
    }

    final c ms() {
        this.d = true;
        return new c(this.f1626ms, this.xr, this.ah, true, false);
    }

    public final c xr() {
        c cVar = this.c;
        c cVar2 = cVar != this ? cVar : null;
        c cVar3 = this.ab;
        if (cVar3 != null) {
            cVar3.c = cVar;
        }
        c cVar4 = this.c;
        if (cVar4 != null) {
            cVar4.ab = cVar3;
        }
        this.c = null;
        this.ab = null;
        return cVar2;
    }

    public final c ms(c cVar) {
        cVar.ab = this;
        cVar.c = this.c;
        this.c.ab = cVar;
        this.c = cVar;
        return cVar;
    }
}
