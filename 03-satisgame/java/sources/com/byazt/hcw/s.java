package com.byazt.hcw;

import com.byazt.pq.cy;
import com.byazt.pq.m;
import com.byazt.tbt.oa;
import com.byazt.tbt.sz;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 95, 8})
public class s extends cy {
    public com.byazt.hcw.n qg;

    public s(com.byazt.hcw.n nVar) {
        this.qg = nVar;
    }

    @Override // com.byazt.pq.cy
    public void n(com.byazt.pq.l lVar, InetSocketAddress inetSocketAddress, Proxy proxy, m mVar, IOException iOException) {
        super.n(lVar, inetSocketAddress, proxy, mVar, iOException);
        com.byazt.hcw.n nVar = this.qg;
        if (nVar != null) {
            nVar.n(new n(lVar), inetSocketAddress, proxy, n(mVar), iOException);
        }
    }

    @Override // com.byazt.pq.cy
    public void n(com.byazt.pq.l lVar, IOException iOException) {
        super.n(lVar, iOException);
        com.byazt.hcw.n nVar = this.qg;
        if (nVar != null) {
            nVar.n(new n(lVar), iOException);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 95, 546})
    private static class n implements com.byazt.tbt.qg {
        public com.byazt.pq.l n;

        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public com.byazt.tbt.qg clone() {
            return null;
        }

        @Override // com.byazt.tbt.qg
        public void n(com.byazt.tbt.s sVar) {
        }

        @Override // com.byazt.tbt.qg
        public com.byazt.tbt.cy qg() throws IOException {
            return null;
        }

        public n(com.byazt.pq.l lVar) {
            this.n = lVar;
        }

        @Override // com.byazt.tbt.qg
        public sz n() {
            return new fs(this.n.n());
        }

        @Override // com.byazt.tbt.qg
        public void s() {
            this.n.s();
        }

        @Override // com.byazt.tbt.qg
        public boolean q() {
            return this.n.q();
        }
    }

    private oa n(m mVar) {
        if (mVar != null) {
            try {
                return oa.n(mVar.toString());
            } catch (IOException unused) {
            }
        }
        return null;
    }
}
