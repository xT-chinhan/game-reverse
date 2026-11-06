package com.byazt.cri;

import com.byazt.pq.a;
import com.byazt.pq.bb;
import com.byazt.pq.cy;
import com.byazt.pq.h;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1393, 21})
public final class x implements a.n {
    public final int cp;
    public int d;
    public final cy fs;
    public final int l;
    public final List<a> n;
    public final com.byazt.sqs.s q;
    public final com.byazt.sqs.x qg;
    public final int rv;
    public final s s;
    public final int tj;
    public final h w;
    public final com.byazt.pq.l x;

    public x(List<a> list, com.byazt.sqs.x xVar, s sVar, com.byazt.sqs.s sVar2, int i, h hVar, com.byazt.pq.l lVar, cy cyVar, int i2, int i3, int i4) {
        this.n = list;
        this.q = sVar2;
        this.qg = xVar;
        this.s = sVar;
        this.l = i;
        this.w = hVar;
        this.x = lVar;
        this.fs = cyVar;
        this.rv = i2;
        this.tj = i3;
        this.cp = i4;
    }

    public com.byazt.pq.rv l() {
        return this.q;
    }

    @Override // com.byazt.pq.a.n
    public int qg() {
        return this.rv;
    }

    @Override // com.byazt.pq.a.n
    public int s() {
        return this.tj;
    }

    @Override // com.byazt.pq.a.n
    public int q() {
        return this.cp;
    }

    public com.byazt.sqs.x w() {
        return this.qg;
    }

    public s x() {
        return this.s;
    }

    @Override // com.byazt.pq.a.n
    public com.byazt.pq.l call() {
        return this.x;
    }

    public cy fs() {
        return this.fs;
    }

    @Override // com.byazt.pq.a.n
    public h n() {
        return this.w;
    }

    @Override // com.byazt.pq.a.n
    public bb n(h hVar) throws IOException {
        return n(hVar, this.qg, this.s, this.q);
    }

    public bb n(h hVar, com.byazt.sqs.x xVar, s sVar, com.byazt.sqs.s sVar2) throws Exception {
        if (this.l >= this.n.size()) {
            throw new AssertionError();
        }
        this.d++;
        if (this.s != null && !this.q.n(hVar.n())) {
            throw new IllegalStateException("network interceptor " + this.n.get(this.l - 1) + " must retain the same host and port");
        }
        if (this.s != null && this.d > 1) {
            throw new IllegalStateException("network interceptor " + this.n.get(this.l - 1) + " must call proceed() exactly once");
        }
        x xVar2 = new x(this.n, xVar, sVar, sVar2, this.l + 1, hVar, this.x, this.fs, this.rv, this.tj, this.cp);
        a aVar = this.n.get(this.l);
        try {
            bb bbVarN = aVar.n(xVar2);
            if (sVar != null && this.l + 1 < this.n.size() && xVar2.d != 1) {
                throw new IllegalStateException("network interceptor " + aVar + " must call proceed() exactly once");
            }
            if (bbVarN == null) {
                throw new NullPointerException("interceptor " + aVar + " returned a null response");
            }
            if (bbVarN.rv() != null) {
                return bbVarN;
            }
            throw new IllegalStateException("interceptor " + aVar + " returned a response with no body");
        } catch (Exception e) {
            throw e;
        }
    }
}
