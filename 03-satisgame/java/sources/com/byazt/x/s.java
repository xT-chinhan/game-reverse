package com.byazt.x;

import com.byazt.ta.w;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 21, 8})
public class s implements qg {
    public final InputStream n;
    public final com.byazt.kl.n qg;

    @Override // com.byazt.x.qg
    public void n(com.byazt.kl.n nVar) {
    }

    public s(InputStream inputStream, int i) {
        this.n = inputStream;
        this.qg = new com.byazt.kl.n(i);
    }

    @Override // com.byazt.x.qg
    public com.byazt.kl.n n() throws IOException {
        com.byazt.kl.n nVar = this.qg;
        nVar.s = this.n.read(nVar.n);
        return this.qg;
    }

    @Override // com.byazt.x.qg
    public void qg() {
        w.n(this.n);
    }
}
