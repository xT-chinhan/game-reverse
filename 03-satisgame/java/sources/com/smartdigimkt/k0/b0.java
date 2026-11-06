package com.smartdigimkt.k0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements e {
    public static final int h = Float.floatToIntBits(Float.NaN);
    public int b = -1;
    public int c = -1;
    public int d = 0;
    public ByteBuffer e;
    public ByteBuffer f;
    public boolean g;

    public b0() {
        ByteBuffer byteBuffer = e.a;
        this.e = byteBuffer;
        this.f = byteBuffer;
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean a(int i, int i2, int i3) throws d {
        int i4 = com.smartdigimkt.z0.u.a;
        if (i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new d(i, i2, i3);
        }
        if (this.b == i && this.c == i2 && this.d == i3) {
            return false;
        }
        this.b = i;
        this.c = i2;
        this.d = i3;
        return true;
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean b() {
        int i = this.d;
        int i2 = com.smartdigimkt.z0.u.a;
        return i == Integer.MIN_VALUE || i == 1073741824;
    }

    @Override // com.smartdigimkt.k0.e
    public final int c() {
        return this.b;
    }

    @Override // com.smartdigimkt.k0.e
    public final int d() {
        return 4;
    }

    @Override // com.smartdigimkt.k0.e
    public final void e() {
        this.g = true;
    }

    @Override // com.smartdigimkt.k0.e
    public final int f() {
        return this.c;
    }

    @Override // com.smartdigimkt.k0.e
    public final void flush() {
        this.f = e.a;
        this.g = false;
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean g() {
        return this.g && this.f == e.a;
    }

    @Override // com.smartdigimkt.k0.e
    public final void h() {
        ByteBuffer byteBuffer = e.a;
        this.f = byteBuffer;
        this.g = false;
        this.b = -1;
        this.c = -1;
        this.d = 0;
        this.e = byteBuffer;
    }

    @Override // com.smartdigimkt.k0.e
    public final void a(ByteBuffer byteBuffer) {
        boolean z = this.d == 1073741824;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        if (!z) {
            i = (i / 3) * 4;
        }
        if (this.e.capacity() < i) {
            this.e = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.e.clear();
        }
        if (z) {
            while (iPosition < iLimit) {
                int i2 = (byteBuffer.get(iPosition) & UByte.MAX_VALUE) | ((byteBuffer.get(iPosition + 1) & UByte.MAX_VALUE) << 8) | ((byteBuffer.get(iPosition + 2) & UByte.MAX_VALUE) << 16) | ((byteBuffer.get(iPosition + 3) & UByte.MAX_VALUE) << 24);
                ByteBuffer byteBuffer2 = this.e;
                int iFloatToIntBits = Float.floatToIntBits((float) (((double) i2) * 4.656612875245797E-10d));
                if (iFloatToIntBits == h) {
                    iFloatToIntBits = Float.floatToIntBits(0.0f);
                }
                byteBuffer2.putInt(iFloatToIntBits);
                iPosition += 4;
            }
        } else {
            while (iPosition < iLimit) {
                int i3 = ((byteBuffer.get(iPosition) & UByte.MAX_VALUE) << 8) | ((byteBuffer.get(iPosition + 1) & UByte.MAX_VALUE) << 16) | ((byteBuffer.get(iPosition + 2) & UByte.MAX_VALUE) << 24);
                ByteBuffer byteBuffer3 = this.e;
                int iFloatToIntBits2 = Float.floatToIntBits((float) (((double) i3) * 4.656612875245797E-10d));
                if (iFloatToIntBits2 == h) {
                    iFloatToIntBits2 = Float.floatToIntBits(0.0f);
                }
                byteBuffer3.putInt(iFloatToIntBits2);
                iPosition += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.e.flip();
        this.f = this.e;
    }

    @Override // com.smartdigimkt.k0.e
    public final ByteBuffer a() {
        ByteBuffer byteBuffer = this.f;
        this.f = e.a;
        return byteBuffer;
    }
}
