package com.byazt.cri;

import com.anythink.core.common.l.b;
import com.byazt.pq.a;
import com.byazt.pq.bb;
import com.byazt.pq.h;
import com.byazt.pq.oa;
import com.byazt.pq.py;
import com.byazt.pq.t;
import com.kwad.sdk.api.core.RequestParamsUtils;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1393, 19})
public final class n implements a {
    public final oa n;

    public n(oa oaVar) {
        this.n = oaVar;
    }

    @Override // com.byazt.pq.a
    public bb n(a.n nVar) throws IOException {
        h hVarN = nVar.n();
        h.n nVarX = hVarN.x();
        t tVarQ = hVarN.q();
        if (tVarQ != null) {
            py pyVarN = tVarQ.n();
            if (pyVarN != null) {
                nVarX.n(b.g, pyVarN.toString());
            }
            long jQg = tVarQ.qg();
            if (jQg != -1) {
                nVarX.n("Content-Length", Long.toString(jQg));
                nVarX.qg("Transfer-Encoding");
            } else {
                nVarX.n("Transfer-Encoding", "chunked");
                nVarX.qg("Content-Length");
            }
        }
        boolean z = false;
        if (hVarN.n("Host") == null) {
            nVarX.n("Host", com.byazt.zho.s.n(hVarN.n(), false));
        }
        if (hVarN.n("Connection") == null) {
            nVarX.n("Connection", "Keep-Alive");
        }
        if (hVarN.n("Accept-Encoding") == null && hVarN.n("Range") == null) {
            nVarX.n("Accept-Encoding", "gzip");
            z = true;
        }
        List<com.byazt.pq.d> listN = this.n.n(hVarN.n());
        if (!listN.isEmpty()) {
            nVarX.n("Cookie", n(listN));
        }
        if (hVarN.n(RequestParamsUtils.USER_AGENT_KEY) == null) {
            nVarX.n(RequestParamsUtils.USER_AGENT_KEY, com.byazt.zho.q.n());
        }
        bb bbVarN = nVar.n(nVarX.n());
        l.n(this.n, hVarN.n(), bbVarN.fs());
        bb.n nVarN = bbVarN.tj().n(hVarN);
        if (z && "gzip".equalsIgnoreCase(bbVarN.qg("Content-Encoding")) && l.s(bbVarN)) {
            com.byazt.wa.tj tjVar = new com.byazt.wa.tj(bbVarN.rv().s());
            nVarN.n(bbVarN.fs().qg().qg("Content-Encoding").qg("Content-Length").n());
            nVarN.n(new fs(bbVarN.qg(b.g), -1L, com.byazt.wa.d.n(tjVar)));
        }
        return nVarN.n();
    }

    private String n(List<com.byazt.pq.d> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            com.byazt.pq.d dVar = list.get(i);
            sb.append(dVar.n()).append('=').append(dVar.qg());
        }
        return sb.toString();
    }
}
