package com.byazt.osx;

import com.byazt.jv.a;
import com.byazt.jv.b;
import com.byazt.jv.cz;
import com.byazt.jv.gz;
import com.byazt.jv.iu;
import com.byazt.jv.m;
import com.efs.sdk.base.Constants;
import com.taptap.sdk.update.download.core.Util;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 442, 37})
public final class pr implements a {
    public final m pr;

    public pr(m mVar) {
        this.pr = mVar;
    }

    @Override // com.byazt.jv.a
    public gz pr(a.pr prVar) throws IOException {
        b bVarPr = prVar.pr();
        b.pr prVarUc = bVarPr.uc();
        iu iuVarX = bVarPr.x();
        if (iuVarX != null) {
            cz czVarPr = iuVarX.pr();
            if (czVarPr != null) {
                prVarUc.pr("Content-Type", czVarPr.toString());
            }
            long jHw = iuVarX.hw();
            if (jHw != -1) {
                prVarUc.pr(Util.CONTENT_LENGTH, Long.toString(jHw));
                prVarUc.hw(Util.TRANSFER_ENCODING);
            } else {
                prVarUc.pr(Util.TRANSFER_ENCODING, "chunked");
                prVarUc.hw(Util.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (bVarPr.pr("Host") == null) {
            prVarUc.pr("Host", com.byazt.xx.hn.pr(bVarPr.pr(), false));
        }
        if (bVarPr.pr("Connection") == null) {
            prVarUc.pr("Connection", "Keep-Alive");
        }
        if (bVarPr.pr("Accept-Encoding") == null && bVarPr.pr(Util.RANGE) == null) {
            z = true;
            prVarUc.pr("Accept-Encoding", Constants.CP_GZIP);
        }
        List<com.byazt.jv.k> listPr = this.pr.pr(bVarPr.pr());
        if (!listPr.isEmpty()) {
            prVarUc.pr("Cookie", pr(listPr));
        }
        if (bVarPr.pr("User-Agent") == null) {
            prVarUc.pr("User-Agent", com.byazt.xx.x.pr());
        }
        gz gzVarPr = prVar.pr(prVarUc.pr());
        c.pr(this.pr, bVarPr.pr(), gzVarPr.zo());
        gz.pr prVarPr = gzVarPr.vk().pr(bVarPr);
        if (z && Constants.CP_GZIP.equalsIgnoreCase(gzVarPr.hw("Content-Encoding")) && c.hn(gzVarPr)) {
            com.byazt.du.vk vkVar = new com.byazt.du.vk(gzVarPr.aj().hn());
            prVarPr.pr(gzVarPr.zo().hw().hw("Content-Encoding").hw(Util.CONTENT_LENGTH).pr());
            prVarPr.pr(new zo(gzVarPr.hw("Content-Type"), -1L, com.byazt.du.k.pr(vkVar)));
        }
        return prVarPr.pr();
    }

    private String pr(List<com.byazt.jv.k> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            com.byazt.jv.k kVar = list.get(i);
            sb.append(kVar.pr()).append('=').append(kVar.hw());
        }
        return sb.toString();
    }
}
