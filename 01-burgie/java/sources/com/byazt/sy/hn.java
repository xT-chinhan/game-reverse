package com.byazt.sy;

import com.byazt.tuy.uc;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1616, 20})
public class hn implements hw {
    public final com.byazt.stx.pr hw;
    public final InputStream pr;

    public hn(InputStream inputStream, int i) {
        this.pr = inputStream;
        this.hw = new com.byazt.stx.pr(i);
    }

    @Override // com.byazt.sy.hw
    public com.byazt.stx.pr pr() throws IOException {
        com.byazt.stx.pr prVar = this.hw;
        prVar.hn = this.pr.read(prVar.pr);
        return this.hw;
    }

    @Override // com.byazt.sy.hw
    public void pr(com.byazt.stx.pr prVar) {
    }

    @Override // com.byazt.sy.hw
    public void hw() {
        uc.pr(this.pr);
    }
}
