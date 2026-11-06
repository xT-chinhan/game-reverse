package com.byazt.kl;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 445, 101})
public class fs implements l {
    public final l n;
    public final l qg;

    public fs(l lVar, l lVar2) {
        this.n = lVar;
        this.qg = lVar2;
    }

    @Override // com.byazt.kl.l
    public void qg(n nVar) throws IOException {
        nVar.qg = this.qg;
        this.n.qg(nVar);
    }
}
