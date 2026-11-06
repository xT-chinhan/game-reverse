package com.efs.sdk.memleaksdk.monitor.shark;

/* JADX INFO: loaded from: classes2.dex */
final class r {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    r f;
    r g;

    r() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    r(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    r a() {
        this.d = true;
        return new r(this.a, this.b, this.c, true, false);
    }

    public r b() {
        r rVar = this.f;
        r rVar2 = rVar != this ? rVar : null;
        r rVar3 = this.g;
        rVar3.f = rVar;
        this.f.g = rVar3;
        this.f = null;
        this.g = null;
        return rVar2;
    }

    public r a(r rVar) {
        rVar.g = this;
        rVar.f = this.f;
        this.f.g = rVar;
        this.f = rVar;
        return rVar;
    }

    public r a(int i) {
        r rVarA;
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            rVarA = a();
        } else {
            rVarA = s.a();
            System.arraycopy(this.a, this.b, rVarA.a, 0, i);
        }
        rVarA.c = rVarA.b + i;
        this.b += i;
        this.g.a(rVarA);
        return rVarA;
    }

    public void c() {
        r rVar = this.g;
        if (rVar == this) {
            throw new IllegalStateException();
        }
        if (rVar.e) {
            int i = this.c - this.b;
            if (i > (8192 - rVar.c) + (rVar.d ? 0 : rVar.b)) {
                return;
            }
            a(rVar, i);
            b();
            s.a(this);
        }
    }

    public void a(r rVar, int i) {
        if (!rVar.e) {
            throw new IllegalArgumentException();
        }
        int i2 = rVar.c;
        if (i2 + i > 8192) {
            if (rVar.d) {
                throw new IllegalArgumentException();
            }
            int i3 = rVar.b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = rVar.a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            rVar.c -= rVar.b;
            rVar.b = 0;
        }
        System.arraycopy(this.a, this.b, rVar.a, rVar.c, i);
        rVar.c += i;
        this.b += i;
    }
}
