package com.smartdigimkt.k0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements e {
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public ByteBuffer h;
    public ByteBuffer i;
    public byte[] j;
    public int k;
    public boolean l;

    public i0() {
        ByteBuffer byteBuffer = e.a;
        this.h = byteBuffer;
        this.i = byteBuffer;
        this.e = -1;
        this.f = -1;
        this.j = new byte[0];
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean a(int i, int i2, int i3) throws d {
        if (i3 != 2) {
            throw new d(i, i2, i3);
        }
        this.e = i2;
        this.f = i;
        int i4 = this.d;
        this.j = new byte[i4 * i2 * 2];
        this.k = 0;
        int i5 = this.c;
        this.g = i2 * i5 * 2;
        boolean z = this.b;
        boolean z2 = (i5 == 0 && i4 == 0) ? false : true;
        this.b = z2;
        return z != z2;
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean b() {
        return this.b;
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
        this.l = true;
    }

    @Override // com.smartdigimkt.k0.e
    public final int f() {
        return this.e;
    }

    @Override // com.smartdigimkt.k0.e
    public final void flush() {
        this.i = e.a;
        this.l = false;
        this.g = 0;
        this.k = 0;
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean g() {
        return this.l && this.i == e.a;
    }

    @Override // com.smartdigimkt.k0.e
    public final void h() {
        flush();
        this.h = e.a;
        this.e = -1;
        this.f = -1;
        this.j = new byte[0];
    }

    @Override // com.smartdigimkt.k0.e
    public final void a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        int iMin = Math.min(i, this.g);
        this.g -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.g > 0) {
            return;
        }
        int i2 = i - iMin;
        int length = (this.k + i2) - this.j.length;
        if (this.h.capacity() < length) {
            this.h = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.h.clear();
        }
        int i3 = this.k;
        int i4 = com.smartdigimkt.z0.u.a;
        int iMax = Math.max(0, Math.min(length, i3));
        this.h.put(this.j, 0, iMax);
        int iMax2 = Math.max(0, Math.min(length - iMax, i2));
        byteBuffer.limit(byteBuffer.position() + iMax2);
        this.h.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i5 = i2 - iMax2;
        int i6 = this.k - iMax;
        this.k = i6;
        byte[] bArr = this.j;
        System.arraycopy(bArr, iMax, bArr, 0, i6);
        byteBuffer.get(this.j, this.k, i5);
        this.k += i5;
        this.h.flip();
        this.i = this.h;
    }

    @Override // com.smartdigimkt.k0.e
    public final ByteBuffer a() {
        ByteBuffer byteBuffer = this.i;
        this.i = e.a;
        return byteBuffer;
    }
}
