package com.byazt.gq;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1959, 5})
public class q implements x {
    public ByteBuffer n;

    public q() {
        s(10240);
    }

    public void n(byte b) {
        this.n.put(b);
    }

    public void n(byte[] bArr) {
        this.n.put(bArr);
    }

    public int n() {
        return this.n.position();
    }

    public void q(int i) {
        this.n.position(i + n());
    }

    public byte[] qg() {
        return this.n.array();
    }

    public void s(int i) {
        ByteBuffer byteBuffer = this.n;
        if (byteBuffer == null || i > byteBuffer.capacity()) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            this.n = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.n.clear();
    }
}
