package com.bytedance.sdk.component.ah.ms;

/* JADX INFO: loaded from: classes2.dex */
final class ub {
    ub ab;
    int ah;
    ub c;
    boolean d;
    boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final byte[] f1020ms;
    int xr;

    ub() {
        this.f1020ms = new byte[8192];
        this.ka = true;
        this.d = false;
    }

    ub(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f1020ms = bArr;
        this.xr = i;
        this.ah = i2;
        this.d = z;
        this.ka = z2;
    }

    final ub ms() {
        this.d = true;
        return new ub(this.f1020ms, this.xr, this.ah, true, false);
    }

    public final ub xr() {
        ub ubVar = this.c;
        ub ubVar2 = ubVar != this ? ubVar : null;
        ub ubVar3 = this.ab;
        if (ubVar3 != null) {
            ubVar3.c = ubVar;
        }
        ub ubVar4 = this.c;
        if (ubVar4 != null) {
            ubVar4.ab = ubVar3;
        }
        this.c = null;
        this.ab = null;
        return ubVar2;
    }

    public final ub ms(ub ubVar) {
        ubVar.ab = this;
        ubVar.c = this.c;
        this.c.ab = ubVar;
        this.c = ubVar;
        return ubVar;
    }

    public final ub ms(int i) {
        ub ubVarMs;
        if (i <= 0 || i > this.ah - this.xr) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            ubVarMs = ms();
        } else {
            ubVarMs = ao.ms();
            System.arraycopy(this.f1020ms, this.xr, ubVarMs.f1020ms, 0, i);
        }
        ubVarMs.ah = ubVarMs.xr + i;
        this.xr += i;
        this.ab.ms(ubVarMs);
        return ubVarMs;
    }

    public final void ah() {
        ub ubVar = this.ab;
        if (ubVar == this) {
            throw new IllegalStateException();
        }
        if (ubVar.ka) {
            int i = this.ah - this.xr;
            if (i > (8192 - ubVar.ah) + (ubVar.d ? 0 : ubVar.xr)) {
                return;
            }
            ms(ubVar, i);
            xr();
            ao.ms(this);
        }
    }

    public final void ms(ub ubVar, int i) {
        if (!ubVar.ka) {
            throw new IllegalArgumentException();
        }
        int i2 = ubVar.ah;
        if (i2 + i > 8192) {
            if (ubVar.d) {
                throw new IllegalArgumentException();
            }
            int i3 = ubVar.xr;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = ubVar.f1020ms;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            ubVar.ah -= ubVar.xr;
            ubVar.xr = 0;
        }
        System.arraycopy(this.f1020ms, this.xr, ubVar.f1020ms, ubVar.ah, i);
        ubVar.ah += i;
        this.xr += i;
    }
}
