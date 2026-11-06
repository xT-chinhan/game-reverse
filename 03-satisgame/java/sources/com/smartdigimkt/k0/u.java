package com.smartdigimkt.k0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements e {
    public int b;
    public int c;
    public int[] d;
    public boolean e;
    public int[] f;
    public ByteBuffer g;
    public ByteBuffer h;
    public boolean i;

    public u() {
        ByteBuffer byteBuffer = e.a;
        this.g = byteBuffer;
        this.h = byteBuffer;
        this.b = -1;
        this.c = -1;
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean a(int i, int i2, int i3) throws d {
        boolean z = !Arrays.equals(this.d, this.f);
        int[] iArr = this.d;
        this.f = iArr;
        if (iArr == null) {
            this.e = false;
            return z;
        }
        if (i3 != 2) {
            throw new d(i, i2, i3);
        }
        if (!z && this.c == i && this.b == i2) {
            return false;
        }
        this.c = i;
        this.b = i2;
        this.e = i2 != iArr.length;
        int i4 = 0;
        while (true) {
            int[] iArr2 = this.f;
            if (i4 >= iArr2.length) {
                return true;
            }
            int i5 = iArr2[i4];
            if (i5 >= i2) {
                throw new d(i, i2, i3);
            }
            this.e = (i5 != i4) | this.e;
            i4++;
        }
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean b() {
        return this.e;
    }

    @Override // com.smartdigimkt.k0.e
    public final int c() {
        return this.c;
    }

    @Override // com.smartdigimkt.k0.e
    public final int d() {
        return 2;
    }

    @Override // com.smartdigimkt.k0.e
    public final void e() {
        this.i = true;
    }

    @Override // com.smartdigimkt.k0.e
    public final int f() {
        int[] iArr = this.f;
        return iArr == null ? this.b : iArr.length;
    }

    @Override // com.smartdigimkt.k0.e
    public final void flush() {
        this.h = e.a;
        this.i = false;
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean g() {
        return this.i && this.h == e.a;
    }

    @Override // com.smartdigimkt.k0.e
    public final void h() {
        ByteBuffer byteBuffer = e.a;
        this.h = byteBuffer;
        this.i = false;
        this.g = byteBuffer;
        this.b = -1;
        this.c = -1;
        this.f = null;
        this.d = null;
        this.e = false;
    }

    @Override // com.smartdigimkt.k0.e
    public final void a(ByteBuffer byteBuffer) {
        if (this.f != null) {
            int iPosition = byteBuffer.position();
            int iLimit = byteBuffer.limit();
            int length = ((iLimit - iPosition) / (this.b * 2)) * this.f.length * 2;
            if (this.g.capacity() < length) {
                this.g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.g.clear();
            }
            while (iPosition < iLimit) {
                for (int i : this.f) {
                    this.g.putShort(byteBuffer.getShort((i * 2) + iPosition));
                }
                iPosition += this.b * 2;
            }
            byteBuffer.position(iLimit);
            this.g.flip();
            this.h = this.g;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.smartdigimkt.k0.e
    public final ByteBuffer a() {
        ByteBuffer byteBuffer = this.h;
        this.h = e.a;
        return byteBuffer;
    }
}
