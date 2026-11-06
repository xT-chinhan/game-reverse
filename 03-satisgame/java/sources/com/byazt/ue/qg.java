package com.byazt.ue;

import com.byazt.vl.w;
import com.byazt.wm.DownloadInfo;
import com.byazt.z.cp;
import com.byazt.z.tj;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1907, 26})
public class qg implements cp {
    @Override // com.byazt.z.cp
    public void n(DownloadInfo downloadInfo, tj tjVar) {
        com.byazt.h.qg qgVarN;
        if (downloadInfo != null && (qgVarN = w.n().n(downloadInfo)) != null) {
            downloadInfo.setLinkMode(qgVarN.u());
        }
        if (tjVar != null) {
            tjVar.n();
        }
    }
}
