package com.byazt.je;

import com.byazt.wm.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 88, 19})
public abstract class n extends AbsDownloadListener implements um {
    public static final String n = "n";

    @Override // com.byazt.je.um
    public void n(DownloadInfo downloadInfo) {
        if (!com.byazt.fe.n.n() || downloadInfo == null) {
            return;
        }
        com.byazt.fe.n.qg(n, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
