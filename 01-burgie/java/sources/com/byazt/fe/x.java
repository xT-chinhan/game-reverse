package com.byazt.fe;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1390, 121})
public class x implements fw {
    public ByteBuffer pr;

    public x() {
        hn(10240);
    }

    public void pr(byte b) {
        this.pr.put(b);
    }

    public void pr(byte[] bArr) {
        this.pr.put(bArr);
    }

    public int pr() {
        return this.pr.position();
    }

    public void x(int i) {
        this.pr.position(i + pr());
    }

    public byte[] hw() {
        return this.pr.array();
    }

    public void hn(int i) {
        ByteBuffer byteBuffer = this.pr;
        if (byteBuffer == null || i > byteBuffer.capacity()) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            this.pr = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.pr.clear();
    }
}
