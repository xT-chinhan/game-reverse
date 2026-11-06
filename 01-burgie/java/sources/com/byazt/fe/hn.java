package com.byazt.fe;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1390, 20})
public class hn implements uc {
    public final ByteBuffer pr;

    public hn(ByteBuffer byteBuffer) {
        this.pr = byteBuffer;
        byteBuffer.position(0);
    }

    @Override // com.byazt.fe.uc
    public long pr(long j) throws IOException {
        ByteBuffer byteBuffer = this.pr;
        byteBuffer.position((int) (((long) byteBuffer.position()) + j));
        return j;
    }

    @Override // com.byazt.fe.uc
    public byte c_() throws IOException {
        return this.pr.get();
    }

    @Override // com.byazt.fe.uc
    public void d_() throws IOException {
        this.pr.position(0);
    }

    @Override // com.byazt.fe.uc
    public int hn() {
        return this.pr.position();
    }

    @Override // com.byazt.fe.uc
    public int pr(byte[] bArr, int i, int i2) throws IOException {
        this.pr.get(bArr, i, i2);
        return i2;
    }

    @Override // com.byazt.fe.uc
    public int x() throws IOException {
        return this.pr.limit() - this.pr.position();
    }

    @Override // com.byazt.fe.uc
    public InputStream c() throws IOException {
        return new ByteArrayInputStream(this.pr.array());
    }
}
