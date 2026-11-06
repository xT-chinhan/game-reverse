package com.byazt.gq;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1959, 8})
public class s implements w {
    public final ByteBuffer n;

    public s(ByteBuffer byteBuffer) {
        this.n = byteBuffer;
        byteBuffer.position(0);
    }

    @Override // com.byazt.gq.w
    public long n(long j) throws IOException {
        ByteBuffer byteBuffer = this.n;
        byteBuffer.position((int) (((long) byteBuffer.position()) + j));
        return j;
    }

    @Override // com.byazt.gq.w
    public byte c_() throws IOException {
        return this.n.get();
    }

    @Override // com.byazt.gq.w
    public void d_() throws IOException {
        this.n.position(0);
    }

    @Override // com.byazt.gq.w
    public int s() {
        return this.n.position();
    }

    @Override // com.byazt.gq.w
    public int n(byte[] bArr, int i, int i2) throws IOException {
        this.n.get(bArr, i, i2);
        return i2;
    }

    @Override // com.byazt.gq.w
    public int q() throws IOException {
        return this.n.limit() - this.n.position();
    }

    @Override // com.byazt.gq.w
    public InputStream l() throws IOException {
        return new ByteArrayInputStream(this.n.array());
    }
}
