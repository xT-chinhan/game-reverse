package com.byazt.fn;

import com.byazt.auw.DownloadInfo;
import com.byazt.lhc.BaseException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 157, 121})
public abstract class x extends AbsDownloadListener implements qa {
    public abstract com.byazt.lxs.pr pr();

    @Override // com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        hw(downloadInfo);
        pr(1, downloadInfo, null, true);
    }

    @Override // com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        pr(2, downloadInfo, null, false);
    }

    @Override // com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        hn(downloadInfo);
    }

    @Override // com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        pr(-2, downloadInfo, null, false);
    }

    @Override // com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        pr(-3, downloadInfo, null, false);
    }

    @Override // com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        pr(-1, downloadInfo, baseException, false);
    }

    private void hw(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        com.byazt.lxs.pr prVarC = com.byazt.lxs.hw.pr().c(downloadInfo.getId());
        if (prVarC == null) {
            com.byazt.lxs.hw.pr().pr(pr());
        } else {
            prVarC.pr(downloadInfo);
        }
    }

    private void pr(int i, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i == 4) {
            return;
        }
        com.byazt.lxs.pr prVarC = com.byazt.lxs.hw.pr().c(downloadInfo.getId());
        if (prVarC == null) {
            prVarC = pr();
        }
        prVarC.hw(downloadInfo.getTotalBytes());
        if (i == -3) {
            prVarC.pr(downloadInfo.getTotalBytes());
        } else {
            prVarC.pr(downloadInfo.getCurBytes());
        }
        prVarC.pr(i, baseException, z);
    }

    private void hn(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || downloadInfo.getStatus() != 4) {
            return;
        }
        com.byazt.lxs.pr prVarC = com.byazt.lxs.hw.pr().c(downloadInfo.getId());
        if (prVarC == null) {
            prVarC = pr();
        }
        prVarC.pr(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
    }

    @Override // com.byazt.fn.qa
    public void pr(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        pr(11, downloadInfo, null, true);
    }
}
