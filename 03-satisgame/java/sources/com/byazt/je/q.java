package com.byazt.je;

import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 88, 5})
public abstract class q extends AbsDownloadListener implements um {
    public abstract com.byazt.av.n n();

    @Override // com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        qg(downloadInfo);
        n(1, downloadInfo, null, true);
    }

    @Override // com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        n(2, downloadInfo, null, false);
    }

    @Override // com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        s(downloadInfo);
    }

    @Override // com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        n(-2, downloadInfo, null, false);
    }

    @Override // com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        n(-3, downloadInfo, null, false);
    }

    @Override // com.byazt.je.AbsDownloadListener, com.byazt.je.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        n(-1, downloadInfo, baseException, false);
    }

    private void qg(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        com.byazt.av.n nVarL = com.byazt.av.qg.n().l(downloadInfo.getId());
        if (nVarL == null) {
            com.byazt.av.qg.n().n(n());
        } else {
            nVarL.n(downloadInfo);
        }
    }

    private void n(int i, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i == 4) {
            return;
        }
        com.byazt.av.n nVarL = com.byazt.av.qg.n().l(downloadInfo.getId());
        if (nVarL == null) {
            nVarL = n();
        }
        nVarL.qg(downloadInfo.getTotalBytes());
        if (i == -3) {
            nVarL.n(downloadInfo.getTotalBytes());
        } else {
            nVarL.n(downloadInfo.getCurBytes());
        }
        nVarL.n(i, baseException, z);
    }

    private void s(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            com.byazt.av.n nVarL = com.byazt.av.qg.n().l(downloadInfo.getId());
            if (nVarL == null) {
                nVarL = n();
            }
            nVarL.n(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    @Override // com.byazt.je.um
    public void n(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        n(11, downloadInfo, null, true);
    }
}
