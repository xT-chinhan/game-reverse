package com.smartdigimkt.k0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements e {
    public int g;
    public g0 h;
    public ByteBuffer i;
    public ShortBuffer j;
    public ByteBuffer k;
    public long l;
    public long m;
    public boolean n;
    public float d = 1.0f;
    public float e = 1.0f;
    public int b = -1;
    public int c = -1;
    public int f = -1;

    public h0() {
        ByteBuffer byteBuffer = e.a;
        this.i = byteBuffer;
        this.j = byteBuffer.asShortBuffer();
        this.k = byteBuffer;
        this.g = -1;
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean a(int i, int i2, int i3) throws d {
        if (i3 != 2) {
            throw new d(i, i2, i3);
        }
        int i4 = this.g;
        if (i4 == -1) {
            i4 = i;
        }
        if (this.c == i && this.b == i2 && this.f == i4) {
            return false;
        }
        this.c = i;
        this.b = i2;
        this.f = i4;
        this.h = null;
        return true;
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean b() {
        return this.c != -1 && (Math.abs(this.d - 1.0f) >= 0.01f || Math.abs(this.e - 1.0f) >= 0.01f || this.f != this.c);
    }

    @Override // com.smartdigimkt.k0.e
    public final int c() {
        return this.f;
    }

    @Override // com.smartdigimkt.k0.e
    public final int d() {
        return 2;
    }

    @Override // com.smartdigimkt.k0.e
    public final void e() {
        int i;
        g0 g0Var = this.h;
        if (g0Var == null) {
            throw new IllegalStateException();
        }
        int i2 = g0Var.k;
        float f = g0Var.c;
        float f2 = g0Var.d;
        int i3 = g0Var.m + ((int) ((((i2 / (f / f2)) + g0Var.o) / (g0Var.e * f2)) + 0.5f));
        g0Var.j = g0Var.b(g0Var.j, i2, (g0Var.h * 2) + i2);
        int i4 = 0;
        while (true) {
            i = g0Var.h * 2;
            int i5 = g0Var.b;
            if (i4 >= i * i5) {
                break;
            }
            g0Var.j[(i5 * i2) + i4] = 0;
            i4++;
        }
        g0Var.k = i + g0Var.k;
        g0Var.a();
        if (g0Var.m > i3) {
            g0Var.m = i3;
        }
        g0Var.k = 0;
        g0Var.r = 0;
        g0Var.o = 0;
        this.n = true;
    }

    @Override // com.smartdigimkt.k0.e
    public final int f() {
        return this.b;
    }

    @Override // com.smartdigimkt.k0.e
    public final void flush() {
        if (b()) {
            g0 g0Var = this.h;
            if (g0Var == null) {
                this.h = new g0(this.c, this.b, this.d, this.e, this.f);
            } else {
                g0Var.k = 0;
                g0Var.m = 0;
                g0Var.o = 0;
                g0Var.p = 0;
                g0Var.q = 0;
                g0Var.r = 0;
                g0Var.s = 0;
                g0Var.t = 0;
                g0Var.u = 0;
                g0Var.v = 0;
            }
        }
        this.k = e.a;
        this.l = 0L;
        this.m = 0L;
        this.n = false;
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean g() {
        g0 g0Var;
        return this.n && ((g0Var = this.h) == null || g0Var.m == 0);
    }

    @Override // com.smartdigimkt.k0.e
    public final void h() {
        this.d = 1.0f;
        this.e = 1.0f;
        this.b = -1;
        this.c = -1;
        this.f = -1;
        ByteBuffer byteBuffer = e.a;
        this.i = byteBuffer;
        this.j = byteBuffer.asShortBuffer();
        this.k = byteBuffer;
        this.g = -1;
        this.h = null;
        this.l = 0L;
        this.m = 0L;
        this.n = false;
    }

    @Override // com.smartdigimkt.k0.e
    public final void a(ByteBuffer byteBuffer) {
        if (this.h != null) {
            if (byteBuffer.hasRemaining()) {
                ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
                int iRemaining = byteBuffer.remaining();
                this.l += (long) iRemaining;
                g0 g0Var = this.h;
                g0Var.getClass();
                int iRemaining2 = shortBufferAsShortBuffer.remaining();
                int i = g0Var.b;
                int i2 = iRemaining2 / i;
                short[] sArrB = g0Var.b(g0Var.j, g0Var.k, i2);
                g0Var.j = sArrB;
                shortBufferAsShortBuffer.get(sArrB, g0Var.k * g0Var.b, ((i * i2) * 2) / 2);
                g0Var.k += i2;
                g0Var.a();
                byteBuffer.position(byteBuffer.position() + iRemaining);
            }
            int i3 = this.h.m * this.b * 2;
            if (i3 > 0) {
                if (this.i.capacity() < i3) {
                    ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
                    this.i = byteBufferOrder;
                    this.j = byteBufferOrder.asShortBuffer();
                } else {
                    this.i.clear();
                    this.j.clear();
                }
                g0 g0Var2 = this.h;
                ShortBuffer shortBuffer = this.j;
                g0Var2.getClass();
                int iMin = Math.min(shortBuffer.remaining() / g0Var2.b, g0Var2.m);
                shortBuffer.put(g0Var2.l, 0, g0Var2.b * iMin);
                int i4 = g0Var2.m - iMin;
                g0Var2.m = i4;
                short[] sArr = g0Var2.l;
                int i5 = g0Var2.b;
                System.arraycopy(sArr, iMin * i5, sArr, 0, i4 * i5);
                this.m += (long) i3;
                this.i.limit(i3);
                this.k = this.i;
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.smartdigimkt.k0.e
    public final ByteBuffer a() {
        ByteBuffer byteBuffer = this.k;
        this.k = e.a;
        return byteBuffer;
    }
}
