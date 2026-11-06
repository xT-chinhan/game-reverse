package com.byazt.cri;

import com.byazt.pq.a;
import com.byazt.pq.bb;
import com.byazt.pq.h;
import com.byazt.wa.cd;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1393, 26})
public final class qg implements a {
    public final boolean n;

    public qg(boolean z) {
        this.n = z;
    }

    @Override // com.byazt.pq.a
    public bb n(a.n nVar) throws IOException {
        bb bbVarN;
        x xVar = (x) nVar;
        s sVarX = xVar.x();
        com.byazt.sqs.x xVarW = xVar.w();
        com.byazt.sqs.s sVar = (com.byazt.sqs.s) xVar.l();
        h hVarN = xVar.n();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (hVarN != null && hVarN.x != null) {
            hVarN.x.n(jCurrentTimeMillis);
        }
        xVar.call();
        sVarX.n(hVarN);
        xVar.call();
        bb.n nVarN = null;
        if (w.s(hVarN.qg()) && hVarN.q() != null) {
            if ("100-continue".equalsIgnoreCase(hVarN.n("Expect"))) {
                sVarX.n();
                xVar.call();
                nVarN = sVarX.n(true);
            }
            if (nVarN == null) {
                xVar.call();
                com.byazt.wa.q qVarN = com.byazt.wa.d.n(new n(sVarX.n(hVarN, hVarN.q().qg())));
                hVarN.q().n(qVarN);
                qVarN.close();
                xVar.call();
            } else if (!sVar.l()) {
                xVarW.q();
            }
        }
        sVarX.qg();
        if (nVarN == null) {
            xVar.call();
            nVarN = sVarX.n(false);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (hVarN.x != null) {
            hVarN.x.qg(jCurrentTimeMillis2);
        }
        bb bbVarN2 = nVarN.n(hVarN).n(xVarW.qg().q()).n(jCurrentTimeMillis).qg(jCurrentTimeMillis2).n();
        xVar.call();
        int iQ = bbVarN2.q();
        if (this.n && iQ == 101) {
            bbVarN = bbVarN2.tj().n(com.byazt.zho.s.s).n();
        } else {
            bbVarN = bbVarN2.tj().n(sVarX.n(bbVarN2)).n();
        }
        if (ILivePush.ClickType.CLOSE.equalsIgnoreCase(bbVarN.qg().n("Connection")) || ILivePush.ClickType.CLOSE.equalsIgnoreCase(bbVarN.qg("Connection"))) {
            xVarW.q();
        }
        if ((iQ == 204 || iQ == 205) && bbVarN.rv().qg() > 0) {
            throw new ProtocolException("HTTP " + iQ + " had non-zero Content-Length: " + bbVarN.rv().qg());
        }
        return bbVarN;
    }

    @com.byazt.cp.n(n = {0, 1, 1393, 48})
    static final class n extends com.byazt.wa.x {
        public long n;

        public n(cd cdVar) {
            super(cdVar);
        }

        @Override // com.byazt.wa.x, com.byazt.wa.cd
        public void a_(com.byazt.wa.s sVar, long j) throws IOException {
            super.a_(sVar, j);
            this.n += j;
        }
    }
}
