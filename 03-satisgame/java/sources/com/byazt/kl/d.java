package com.byazt.kl;

import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 445, 113})
public class d implements l {
    public final rv n;
    public final com.byazt.wm.l qg;
    public final l s;

    public d(DownloadInfo downloadInfo, qg qgVar, rv rvVar) throws BaseException {
        this.n = rvVar;
        this.qg = n(downloadInfo, rvVar);
        this.s = new fs(qgVar, this);
    }

    public l n() {
        return this.s;
    }

    @Override // com.byazt.kl.l
    public void qg(n nVar) throws IOException {
        this.qg.n(nVar.n, 0, nVar.s);
        this.n.qg(nVar.s);
    }

    public void qg() throws IOException {
        this.qg.qg();
    }

    public void s() throws IOException {
        this.qg.s();
    }

    public void q() {
        com.byazt.ta.w.n(this.qg);
    }

    public rv l() {
        return this.n;
    }

    private com.byazt.wm.l n(DownloadInfo downloadInfo, rv rvVar) throws BaseException {
        com.byazt.wm.l lVarN = com.byazt.ta.w.n(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.byazt.f.n.n(downloadInfo.getId()).n("flush_buffer_size_byte", -1));
        try {
            lVarN.n(rvVar.l());
            return lVarN;
        } catch (IOException e) {
            throw new BaseException(1054, e);
        }
    }
}
