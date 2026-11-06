package com.bytedance.pangle.x;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestException;

/* JADX INFO: loaded from: classes2.dex */
class x implements hi {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ByteBuffer f728ms;

    x(ByteBuffer byteBuffer) {
        this.f728ms = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.x.hi
    public long ms() {
        return this.f728ms.capacity();
    }

    @Override // com.bytedance.pangle.x.hi
    public void ms(ch chVar, long j, int i) throws DigestException, IOException {
        ByteBuffer byteBufferSlice;
        synchronized (this.f728ms) {
            this.f728ms.position(0);
            int i2 = (int) j;
            this.f728ms.limit(i + i2);
            this.f728ms.position(i2);
            byteBufferSlice = this.f728ms.slice();
        }
        chVar.ms(byteBufferSlice);
    }
}
