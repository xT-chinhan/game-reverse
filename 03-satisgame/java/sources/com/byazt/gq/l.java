package com.byazt.gq;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1959, 18})
public class l implements w {
    public w n;

    public l(w wVar) {
        this.n = wVar;
    }

    @Override // com.byazt.gq.w
    public long n(long j) throws IOException {
        return this.n.n(j);
    }

    @Override // com.byazt.gq.w
    public byte c_() throws IOException {
        return this.n.c_();
    }

    @Override // com.byazt.gq.w
    public void d_() throws IOException {
        this.n.d_();
    }

    @Override // com.byazt.gq.w
    public int s() {
        return this.n.s();
    }

    @Override // com.byazt.gq.w
    public int n(byte[] bArr, int i, int i2) throws IOException {
        return this.n.n(bArr, i, i2);
    }

    @Override // com.byazt.gq.w
    public int q() throws IOException {
        return this.n.q();
    }

    @Override // com.byazt.gq.w
    public InputStream l() throws IOException {
        d_();
        return this.n.l();
    }
}
