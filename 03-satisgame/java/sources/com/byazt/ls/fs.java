package com.byazt.ls;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 32, 101})
public class fs implements cp {
    public final ByteBuffer n;

    public fs(ByteBuffer byteBuffer) {
        this.n = byteBuffer.slice();
    }

    @Override // com.byazt.ls.cp
    public long n() {
        return this.n.capacity();
    }

    @Override // com.byazt.ls.cp
    public void n(tj tjVar, long j, int i) throws DigestException, IOException {
        ByteBuffer byteBufferSlice;
        synchronized (this.n) {
            this.n.position(0);
            int i2 = (int) j;
            this.n.limit(i + i2);
            this.n.position(i2);
            byteBufferSlice = this.n.slice();
        }
        tjVar.n(byteBufferSlice);
    }
}
