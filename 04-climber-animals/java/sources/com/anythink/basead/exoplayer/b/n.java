package com.anythink.basead.exoplayer.b;

import com.anythink.basead.exoplayer.k.af;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
final class n implements f {
    private static final int b = Float.floatToIntBits(Float.NaN);
    private static final double c = 4.656612875245797E-10d;
    private int d = -1;
    private int e = -1;
    private int f = 0;
    private ByteBuffer g = a;
    private ByteBuffer h = a;
    private boolean i;

    @Override // com.anythink.basead.exoplayer.b.f
    public final int c() {
        return 4;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final boolean a(int i, int i2, int i3) throws f.a {
        if (!af.c(i3)) {
            throw new f.a(i, i2, i3);
        }
        if (this.d == i && this.e == i2 && this.f == i3) {
            return false;
        }
        this.d = i;
        this.e = i2;
        this.f = i3;
        return true;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final boolean a() {
        return af.c(this.f);
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final int b() {
        return this.e;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final int d() {
        return this.d;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final void a(ByteBuffer byteBuffer) {
        boolean z = this.f == 1073741824;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        if (!z) {
            i = (i / 3) * 4;
        }
        if (this.g.capacity() < i) {
            this.g = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.g.clear();
        }
        if (z) {
            while (iPosition < iLimit) {
                a((byteBuffer.get(iPosition) & UByte.MAX_VALUE) | ((byteBuffer.get(iPosition + 1) & UByte.MAX_VALUE) << 8) | ((byteBuffer.get(iPosition + 2) & UByte.MAX_VALUE) << 16) | ((byteBuffer.get(iPosition + 3) & UByte.MAX_VALUE) << 24), this.g);
                iPosition += 4;
            }
        } else {
            while (iPosition < iLimit) {
                a(((byteBuffer.get(iPosition) & UByte.MAX_VALUE) << 8) | ((byteBuffer.get(iPosition + 1) & UByte.MAX_VALUE) << 16) | ((byteBuffer.get(iPosition + 2) & UByte.MAX_VALUE) << 24), this.g);
                iPosition += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.g.flip();
        this.h = this.g;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final void e() {
        this.i = true;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final ByteBuffer f() {
        ByteBuffer byteBuffer = this.h;
        this.h = a;
        return byteBuffer;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final boolean g() {
        return this.i && this.h == a;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final void h() {
        this.h = a;
        this.i = false;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final void i() {
        h();
        this.d = -1;
        this.e = -1;
        this.f = 0;
        this.g = a;
    }

    private static void a(int i, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i) * c));
        if (iFloatToIntBits == b) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }
}
