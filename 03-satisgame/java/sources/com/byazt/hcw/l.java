package com.byazt.hcw;

import com.byazt.pq.a;
import com.byazt.tbt.cy;
import com.byazt.tbt.sz;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 95, 18})
public class l implements com.byazt.tbt.rv.n {
    public a.n n;

    public l(a.n nVar) {
        this.n = nVar;
    }

    @Override // com.byazt.tbt.rv.n
    public sz n() {
        return new fs(this.n.n());
    }

    @Override // com.byazt.tbt.rv.n
    public cy n(sz szVar) throws IOException {
        return new rv(this.n.n(this.n.n().x().n(szVar.s()).n()));
    }
}
