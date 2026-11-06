package com.smartdigimkt.l0;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    public int a;
    public ByteBuffer b;
    public long c;
    public final c d = new c();
    public final int e;

    public e(int i) {
        this.e = i;
    }

    public final void a() {
        this.a = 0;
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final boolean b(int i) {
        return (this.a & i) == i;
    }

    public final ByteBuffer a(int i) {
        int i2 = this.e;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.b;
        throw new IllegalStateException("Buffer too small (" + (byteBuffer == null ? 0 : byteBuffer.capacity()) + " < " + i + ")");
    }
}
