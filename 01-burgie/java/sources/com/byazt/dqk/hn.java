package com.byazt.dqk;

import com.byazt.jv.nt;
import com.byazt.jv.rc;
import com.byazt.nzn.g;
import com.byazt.nzn.m;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1320, 20})
public class hn extends nt {
    public com.byazt.dqk.pr hw;

    public hn(com.byazt.dqk.pr prVar) {
        this.hw = prVar;
    }

    @Override // com.byazt.jv.nt
    public void pr(com.byazt.jv.c cVar, InetSocketAddress inetSocketAddress, Proxy proxy, rc rcVar, IOException iOException) {
        super.pr(cVar, inetSocketAddress, proxy, rcVar, iOException);
        com.byazt.dqk.pr prVar = this.hw;
        if (prVar != null) {
            prVar.pr(new pr(cVar), inetSocketAddress, proxy, pr(rcVar), iOException);
        }
    }

    @Override // com.byazt.jv.nt
    public void pr(com.byazt.jv.c cVar, IOException iOException) {
        super.pr(cVar, iOException);
        com.byazt.dqk.pr prVar = this.hw;
        if (prVar != null) {
            prVar.pr(new pr(cVar), iOException);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1320, 116})
    private static class pr implements com.byazt.nzn.hw {
        public com.byazt.jv.c pr;

        public pr(com.byazt.jv.c cVar) {
            this.pr = cVar;
        }

        @Override // com.byazt.nzn.hw
        public g pr() {
            return new zo(this.pr.pr());
        }

        @Override // com.byazt.nzn.hw
        public com.byazt.nzn.nt hw() throws IOException {
            return null;
        }

        @Override // com.byazt.nzn.hw
        public void pr(com.byazt.nzn.hn hnVar) {
        }

        @Override // com.byazt.nzn.hw
        public void hn() {
            this.pr.hn();
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.byazt.nzn.hw clone() {
            return null;
        }

        @Override // com.byazt.nzn.hw
        public boolean x() {
            return this.pr.x();
        }
    }

    private m pr(rc rcVar) {
        if (rcVar == null) {
            return null;
        }
        try {
            return m.pr(rcVar.toString());
        } catch (IOException e) {
            return null;
        }
    }
}
