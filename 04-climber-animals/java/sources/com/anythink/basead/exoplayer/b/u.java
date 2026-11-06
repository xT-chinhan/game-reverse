package com.anythink.basead.exoplayer.b;

import com.anythink.basead.exoplayer.k.af;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
final class u implements f {
    private boolean b;
    private int c;
    private int d;
    private int g;
    private int k;
    private boolean l;
    private ByteBuffer h = a;
    private ByteBuffer i = a;
    private int e = -1;
    private int f = -1;
    private byte[] j = new byte[0];

    @Override // com.anythink.basead.exoplayer.b.f
    public final int c() {
        return 2;
    }

    public final void a(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final boolean a(int i, int i2, int i3) throws f.a {
        if (i3 != 2) {
            throw new f.a(i, i2, i3);
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

    @Override // com.anythink.basead.exoplayer.b.f
    public final boolean a() {
        return this.b;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final int b() {
        return this.e;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final int d() {
        return this.f;
    }

    @Override // com.anythink.basead.exoplayer.b.f
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
        int iA = af.a(length, 0, this.k);
        this.h.put(this.j, 0, iA);
        int iA2 = af.a(length - iA, 0, i2);
        byteBuffer.limit(byteBuffer.position() + iA2);
        this.h.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i3 = i2 - iA2;
        int i4 = this.k - iA;
        this.k = i4;
        byte[] bArr = this.j;
        System.arraycopy(bArr, iA, bArr, 0, i4);
        byteBuffer.get(this.j, this.k, i3);
        this.k += i3;
        this.h.flip();
        this.i = this.h;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final void e() {
        this.l = true;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final ByteBuffer f() {
        ByteBuffer byteBuffer = this.i;
        this.i = a;
        return byteBuffer;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final boolean g() {
        return this.l && this.i == a;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final void h() {
        this.i = a;
        this.l = false;
        this.g = 0;
        this.k = 0;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final void i() {
        h();
        this.h = a;
        this.e = -1;
        this.f = -1;
        this.j = new byte[0];
    }
}
