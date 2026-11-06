package com.byazt.ky;

import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadModel;
import com.byazt.hj.DownloadStatusChangeListener;
import com.byazt.os.DownloadShortInfo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 936, 19})
public class n implements DownloadStatusChangeListener {
    @Override // com.byazt.hj.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i) {
    }

    @Override // com.byazt.hj.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
    }

    @Override // com.byazt.hj.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
    }

    @Override // com.byazt.hj.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i) {
    }

    @Override // com.byazt.hj.DownloadStatusChangeListener
    public void onDownloadStart(DownloadModel downloadModel, DownloadController downloadController) {
    }

    @Override // com.byazt.hj.DownloadStatusChangeListener
    public void onIdle() {
    }

    @Override // com.byazt.hj.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
    }
}
