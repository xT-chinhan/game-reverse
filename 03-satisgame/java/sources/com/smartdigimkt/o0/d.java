package com.smartdigimkt.o0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public final int a;
    public int b;
    public int c;
    public long d;
    public final boolean e;
    public final com.smartdigimkt.z0.m f;
    public final com.smartdigimkt.z0.m g;
    public int h;
    public int i;

    public d(com.smartdigimkt.z0.m mVar, com.smartdigimkt.z0.m mVar2, boolean z) {
        this.g = mVar;
        this.f = mVar2;
        this.e = z;
        mVar2.c(12);
        this.a = mVar2.h();
        mVar.c(12);
        this.i = mVar.h();
        if (!(mVar.a() == 1)) {
            throw new IllegalStateException("first_chunk must be 1");
        }
        this.b = -1;
    }

    public final boolean a() {
        int i = this.b + 1;
        this.b = i;
        if (i == this.a) {
            return false;
        }
        this.d = this.e ? this.f.i() : this.f.f();
        if (this.b == this.h) {
            this.c = this.g.h();
            com.smartdigimkt.z0.m mVar = this.g;
            mVar.c(mVar.b + 4);
            int i2 = this.i - 1;
            this.i = i2;
            this.h = i2 > 0 ? this.g.h() - 1 : -1;
        }
        return true;
    }
}
