package com.smartdigimkt.k0;

import com.bykv.vk.component.ttvideo.player.C;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements e {
    public int b;
    public int c;
    public int d;
    public boolean e;
    public ByteBuffer f;
    public ByteBuffer g;
    public boolean h;
    public byte[] i;
    public byte[] j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public long o;

    public f0() {
        ByteBuffer byteBuffer = e.a;
        this.f = byteBuffer;
        this.g = byteBuffer;
        this.b = -1;
        this.c = -1;
        this.i = new byte[0];
        this.j = new byte[0];
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean a(int i, int i2, int i3) throws d {
        if (i3 != 2) {
            throw new d(i, i2, i3);
        }
        if (this.c == i && this.b == i2) {
            return false;
        }
        this.c = i;
        this.b = i2;
        this.d = i2 * 2;
        return true;
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean b() {
        return this.c != -1 && this.e;
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
        this.h = true;
        int i = this.l;
        if (i > 0) {
            byte[] bArr = this.i;
            if (this.f.capacity() < i) {
                this.f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
            } else {
                this.f.clear();
            }
            if (i > 0) {
                this.n = true;
            }
            this.f.put(bArr, 0, i);
            this.f.flip();
            this.g = this.f;
        }
        if (this.n) {
            return;
        }
        this.o += (long) (this.m / this.d);
    }

    @Override // com.smartdigimkt.k0.e
    public final int f() {
        return this.b;
    }

    @Override // com.smartdigimkt.k0.e
    public final void flush() {
        if (b()) {
            long j = this.c;
            int i = (int) ((150000 * j) / C.MICROS_PER_SECOND);
            int i2 = this.d;
            int i3 = i * i2;
            if (this.i.length != i3) {
                this.i = new byte[i3];
            }
            int i4 = ((int) ((j * 20000) / C.MICROS_PER_SECOND)) * i2;
            this.m = i4;
            if (this.j.length != i4) {
                this.j = new byte[i4];
            }
        }
        this.k = 0;
        this.g = e.a;
        this.h = false;
        this.o = 0L;
        this.l = 0;
        this.n = false;
    }

    @Override // com.smartdigimkt.k0.e
    public final boolean g() {
        return this.h && this.g == e.a;
    }

    @Override // com.smartdigimkt.k0.e
    public final void h() {
        this.e = false;
        flush();
        this.f = e.a;
        this.b = -1;
        this.c = -1;
        this.m = 0;
        this.i = new byte[0];
        this.j = new byte[0];
    }

    @Override // com.smartdigimkt.k0.e
    public final void a(ByteBuffer byteBuffer) {
        int iLimit;
        int iLimit2;
        int iPosition;
        while (byteBuffer.hasRemaining() && !this.g.hasRemaining()) {
            int i = this.k;
            if (i == 0) {
                int iLimit3 = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit3, byteBuffer.position() + this.i.length));
                int iLimit4 = byteBuffer.limit() - 1;
                while (true) {
                    if (iLimit4 >= byteBuffer.position()) {
                        if (Math.abs((int) byteBuffer.get(iLimit4)) > 4) {
                            int i2 = this.d;
                            iPosition = ((iLimit4 / i2) * i2) + i2;
                            break;
                        }
                        iLimit4 -= 2;
                    } else {
                        iPosition = byteBuffer.position();
                        break;
                    }
                }
                if (iPosition == byteBuffer.position()) {
                    this.k = 1;
                } else {
                    byteBuffer.limit(iPosition);
                    int iRemaining = byteBuffer.remaining();
                    if (this.f.capacity() < iRemaining) {
                        this.f = ByteBuffer.allocateDirect(iRemaining).order(ByteOrder.nativeOrder());
                    } else {
                        this.f.clear();
                    }
                    if (iRemaining > 0) {
                        this.n = true;
                    }
                    this.f.put(byteBuffer);
                    this.f.flip();
                    this.g = this.f;
                }
                byteBuffer.limit(iLimit3);
            } else if (i == 1) {
                int iLimit5 = byteBuffer.limit();
                int iPosition2 = byteBuffer.position() + 1;
                while (true) {
                    if (iPosition2 < byteBuffer.limit()) {
                        if (Math.abs((int) byteBuffer.get(iPosition2)) > 4) {
                            int i3 = this.d;
                            iLimit2 = (iPosition2 / i3) * i3;
                            break;
                        }
                        iPosition2 += 2;
                    } else {
                        iLimit2 = byteBuffer.limit();
                        break;
                    }
                }
                int iPosition3 = iLimit2 - byteBuffer.position();
                byte[] bArr = this.i;
                int length = bArr.length;
                int i4 = this.l;
                int i5 = length - i4;
                if (iLimit2 < iLimit5 && iPosition3 < i5) {
                    if (this.f.capacity() < i4) {
                        this.f = ByteBuffer.allocateDirect(i4).order(ByteOrder.nativeOrder());
                    } else {
                        this.f.clear();
                    }
                    if (i4 > 0) {
                        this.n = true;
                    }
                    this.f.put(bArr, 0, i4);
                    this.f.flip();
                    this.g = this.f;
                    this.l = 0;
                    this.k = 0;
                } else {
                    int iMin = Math.min(iPosition3, i5);
                    byteBuffer.limit(byteBuffer.position() + iMin);
                    byteBuffer.get(this.i, this.l, iMin);
                    int i6 = this.l + iMin;
                    this.l = i6;
                    byte[] bArr2 = this.i;
                    if (i6 == bArr2.length) {
                        if (this.n) {
                            int i7 = this.m;
                            if (this.f.capacity() < i7) {
                                this.f = ByteBuffer.allocateDirect(i7).order(ByteOrder.nativeOrder());
                            } else {
                                this.f.clear();
                            }
                            if (i7 > 0) {
                                this.n = true;
                            }
                            this.f.put(bArr2, 0, i7);
                            this.f.flip();
                            this.g = this.f;
                            this.o += (long) ((this.l - (this.m * 2)) / this.d);
                        } else {
                            this.o += (long) ((i6 - this.m) / this.d);
                        }
                        byte[] bArr3 = this.i;
                        int i8 = this.l;
                        int iMin2 = Math.min(byteBuffer.remaining(), this.m);
                        int i9 = this.m - iMin2;
                        System.arraycopy(bArr3, i8 - i9, this.j, 0, i9);
                        byteBuffer.position(byteBuffer.limit() - iMin2);
                        byteBuffer.get(this.j, i9, iMin2);
                        this.l = 0;
                        this.k = 2;
                    }
                    byteBuffer.limit(iLimit5);
                }
            } else if (i == 2) {
                int iLimit6 = byteBuffer.limit();
                int iPosition4 = byteBuffer.position() + 1;
                while (true) {
                    if (iPosition4 < byteBuffer.limit()) {
                        if (Math.abs((int) byteBuffer.get(iPosition4)) > 4) {
                            int i10 = this.d;
                            iLimit = (iPosition4 / i10) * i10;
                            break;
                        }
                        iPosition4 += 2;
                    } else {
                        iLimit = byteBuffer.limit();
                        break;
                    }
                }
                byteBuffer.limit(iLimit);
                this.o += (long) (byteBuffer.remaining() / this.d);
                byte[] bArr4 = this.j;
                int i11 = this.m;
                int iMin3 = Math.min(byteBuffer.remaining(), this.m);
                int i12 = this.m - iMin3;
                System.arraycopy(bArr4, i11 - i12, this.j, 0, i12);
                byteBuffer.position(byteBuffer.limit() - iMin3);
                byteBuffer.get(this.j, i12, iMin3);
                if (iLimit < iLimit6) {
                    byte[] bArr5 = this.j;
                    int i13 = this.m;
                    if (this.f.capacity() < i13) {
                        this.f = ByteBuffer.allocateDirect(i13).order(ByteOrder.nativeOrder());
                    } else {
                        this.f.clear();
                    }
                    if (i13 > 0) {
                        this.n = true;
                    }
                    this.f.put(bArr5, 0, i13);
                    this.f.flip();
                    this.g = this.f;
                    this.k = 0;
                    byteBuffer.limit(iLimit6);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.smartdigimkt.k0.e
    public final ByteBuffer a() {
        ByteBuffer byteBuffer = this.g;
        this.g = e.a;
        return byteBuffer;
    }
}
