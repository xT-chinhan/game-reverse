package com.anythink.core.common.m.c;

/* JADX INFO: loaded from: classes.dex */
final class s {
    static final int a = 8192;
    static final int b = 1024;
    final byte[] c;
    int d;
    int e;
    boolean f;
    boolean g;
    s h;
    s i;

    s() {
        this.c = new byte[8192];
        this.g = true;
        this.f = false;
    }

    s(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.c = bArr;
        this.d = i;
        this.e = i2;
        this.f = z;
        this.g = z2;
    }

    final s a() {
        this.f = true;
        return new s(this.c, this.d, this.e, true, false);
    }

    final s b() {
        return new s((byte[]) this.c.clone(), this.d, this.e, false, true);
    }

    public final s c() {
        s sVar = this.h;
        s sVar2 = sVar != this ? sVar : null;
        s sVar3 = this.i;
        sVar3.h = sVar;
        this.h.i = sVar3;
        this.h = null;
        this.i = null;
        return sVar2;
    }

    public final s a(s sVar) {
        sVar.i = this;
        sVar.h = this.h;
        this.h.i = sVar;
        this.h = sVar;
        return sVar;
    }

    public final s a(int i) {
        s sVarA;
        if (i <= 0 || i > this.e - this.d) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            sVarA = a();
        } else {
            sVarA = t.a();
            System.arraycopy(this.c, this.d, sVarA.c, 0, i);
        }
        sVarA.e = sVarA.d + i;
        this.d += i;
        this.i.a(sVarA);
        return sVarA;
    }

    public final void d() {
        s sVar = this.i;
        if (sVar == this) {
            throw new IllegalStateException();
        }
        if (sVar.g) {
            int i = this.e - this.d;
            if (i > (8192 - sVar.e) + (sVar.f ? 0 : sVar.d)) {
                return;
            }
            a(sVar, i);
            c();
            t.a(this);
        }
    }

    public final void a(s sVar, int i) {
        if (!sVar.g) {
            throw new IllegalArgumentException();
        }
        int i2 = sVar.e;
        if (i2 + i > 8192) {
            if (sVar.f) {
                throw new IllegalArgumentException();
            }
            int i3 = sVar.d;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sVar.c;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            sVar.e -= sVar.d;
            sVar.d = 0;
        }
        System.arraycopy(this.c, this.d, sVar.c, sVar.e, i);
        sVar.e += i;
        this.d += i;
    }
}
