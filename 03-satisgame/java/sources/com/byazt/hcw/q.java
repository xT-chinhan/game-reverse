package com.byazt.hcw;

import com.byazt.pq.bb;
import com.byazt.tbt.cy;
import com.byazt.tbt.sz;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 95, 5})
public class q implements com.byazt.tbt.qg {
    public com.byazt.pq.l n;

    public q(com.byazt.pq.l lVar) {
        this.n = lVar;
    }

    @Override // com.byazt.tbt.qg
    public sz n() {
        return new fs(this.n.n());
    }

    @Override // com.byazt.tbt.qg
    public cy qg() throws IOException {
        return new rv(this.n.qg());
    }

    @Override // com.byazt.tbt.qg
    public void n(final com.byazt.tbt.s sVar) {
        this.n.n(new com.byazt.pq.w() { // from class: com.byazt.hcw.q.1
            @Override // com.byazt.pq.w
            public void n(com.byazt.pq.l lVar, IOException iOException) {
                sVar.onFailure(new q(lVar), iOException);
            }

            @Override // com.byazt.pq.w
            public void n(com.byazt.pq.l lVar, bb bbVar) throws IOException {
                sVar.onResponse(new q(lVar), new rv(bbVar));
            }
        });
    }

    @Override // com.byazt.tbt.qg
    public void s() {
        this.n.s();
    }

    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.byazt.tbt.qg clone() {
        return new q(this.n.l());
    }

    @Override // com.byazt.tbt.qg
    public boolean q() {
        return this.n.q();
    }
}
