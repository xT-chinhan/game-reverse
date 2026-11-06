package com.anythink.basead.exoplayer.b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
final class p implements f {
    private int b = -1;
    private int c = -1;
    private int d = 0;
    private ByteBuffer e = a;
    private ByteBuffer f = a;
    private boolean g;

    @Override // com.anythink.basead.exoplayer.b.f
    public final int c() {
        return 2;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final boolean a(int i, int i2, int i3) throws f.a {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new f.a(i, i2, i3);
        }
        if (this.b == i && this.c == i2 && this.d == i3) {
            return false;
        }
        this.b = i;
        this.c = i2;
        this.d = i3;
        return true;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final boolean a() {
        int i = this.d;
        return (i == 0 || i == 2) ? false : true;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final int b() {
        return this.c;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final int d() {
        return this.b;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002b  */
    /* JADX WARN: Code duplicated, block: B:14:0x003a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0043 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0045 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0047 A[ADDED_TO_REGION, LOOP:0: B:19:0x0047->B:20:0x0049, LOOP_START, PHI: r0
      0x0047: PHI (r0v6 int) = (r0v0 int), (r0v7 int) binds: [B:18:0x0045, B:20:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x0049 A[LOOP:0: B:19:0x0047->B:20:0x0049, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x0062  */
    /* JADX WARN: Code duplicated, block: B:23:0x0068 A[ADDED_TO_REGION, LOOP:1: B:23:0x0068->B:24:0x006a, LOOP_START, PHI: r0
      0x0068: PHI (r0v4 int) = (r0v0 int), (r0v5 int) binds: [B:17:0x0043, B:24:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:24:0x006a A[LOOP:1: B:23:0x0068->B:24:0x006a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x0081 A[ADDED_TO_REGION, LOOP:2: B:25:0x0081->B:26:0x0083, LOOP_START, PHI: r0
      0x0081: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:16:0x0041, B:26:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0083 A[LOOP:2: B:25:0x0081->B:26:0x0083, LOOP_END] */
    @Override // com.anythink.basead.exoplayer.b.f
    public final void a(ByteBuffer byteBuffer) {
        int i;
        int i2;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i3 = iLimit - iPosition;
        int i4 = this.d;
        if (i4 == Integer.MIN_VALUE) {
            i3 /= 3;
        } else {
            if (i4 != 3) {
                if (i4 == 1073741824) {
                    i = i3 / 2;
                } else {
                    throw new IllegalStateException();
                }
            }
            if (this.e.capacity() < i) {
                this.e = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
            } else {
                this.e.clear();
            }
            i2 = this.d;
            if (i2 != Integer.MIN_VALUE) {
                while (iPosition < iLimit) {
                    this.e.put(byteBuffer.get(iPosition + 1));
                    this.e.put(byteBuffer.get(iPosition + 2));
                    iPosition += 3;
                }
            } else if (i2 != 3) {
                while (iPosition < iLimit) {
                    this.e.put((byte) 0);
                    this.e.put((byte) ((byteBuffer.get(iPosition) & UByte.MAX_VALUE) - 128));
                    iPosition++;
                }
            } else {
                if (i2 == 1073741824) {
                    throw new IllegalStateException();
                }
                while (iPosition < iLimit) {
                    this.e.put(byteBuffer.get(iPosition + 2));
                    this.e.put(byteBuffer.get(iPosition + 3));
                    iPosition += 4;
                }
            }
            byteBuffer.position(byteBuffer.limit());
            this.e.flip();
            this.f = this.e;
        }
        i = i3 * 2;
        if (this.e.capacity() < i) {
            this.e = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.e.clear();
        }
        i2 = this.d;
        if (i2 != Integer.MIN_VALUE) {
            while (iPosition < iLimit) {
                this.e.put(byteBuffer.get(iPosition + 1));
                this.e.put(byteBuffer.get(iPosition + 2));
                iPosition += 3;
            }
        } else if (i2 != 3) {
            while (iPosition < iLimit) {
                this.e.put((byte) 0);
                this.e.put((byte) ((byteBuffer.get(iPosition) & UByte.MAX_VALUE) - 128));
                iPosition++;
            }
        } else {
            if (i2 == 1073741824) {
                throw new IllegalStateException();
            }
            while (iPosition < iLimit) {
                this.e.put(byteBuffer.get(iPosition + 2));
                this.e.put(byteBuffer.get(iPosition + 3));
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.e.flip();
        this.f = this.e;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final void e() {
        this.g = true;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final ByteBuffer f() {
        ByteBuffer byteBuffer = this.f;
        this.f = a;
        return byteBuffer;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final boolean g() {
        return this.g && this.f == a;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final void h() {
        this.f = a;
        this.g = false;
    }

    @Override // com.anythink.basead.exoplayer.b.f
    public final void i() {
        h();
        this.b = -1;
        this.c = -1;
        this.d = 0;
        this.e = a;
    }
}
