package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends AbsDownloadListener implements y {
    protected abstract com.ss.android.socialbase.downloader.notification.ms ms();

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        super.onPrepare(downloadInfo);
        xr(downloadInfo);
        ms(1, downloadInfo, null, true);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        super.onStart(downloadInfo);
        ms(2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        super.onProgress(downloadInfo);
        ah(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        super.onPause(downloadInfo);
        ms(-2, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        super.onSuccessed(downloadInfo);
        ms(-3, downloadInfo, null, false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        super.onFailed(downloadInfo, baseException);
        ms(-1, downloadInfo, baseException, false);
    }

    private void xr(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.canShowNotification()) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.ms msVarKa = com.ss.android.socialbase.downloader.notification.xr.ms().ka(downloadInfo.getId());
        if (msVarKa == null) {
            com.ss.android.socialbase.downloader.notification.xr.ms().ms(ms());
        } else {
            msVarKa.ms(downloadInfo);
        }
    }

    private void ms(int i, DownloadInfo downloadInfo, BaseException baseException, boolean z) {
        if (downloadInfo == null || !downloadInfo.canShowNotification() || i == 4) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.ms msVarKa = com.ss.android.socialbase.downloader.notification.xr.ms().ka(downloadInfo.getId());
        if (msVarKa == null) {
            msVarKa = ms();
        }
        msVarKa.xr(downloadInfo.getTotalBytes());
        if (i == -3) {
            msVarKa.ms(downloadInfo.getTotalBytes());
        } else {
            msVarKa.ms(downloadInfo.getCurBytes());
        }
        msVarKa.ms(i, baseException, z);
    }

    private void ah(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.canShowNotification() && downloadInfo.getStatus() == 4) {
            com.ss.android.socialbase.downloader.notification.ms msVarKa = com.ss.android.socialbase.downloader.notification.xr.ms().ka(downloadInfo.getId());
            if (msVarKa == null) {
                msVarKa = ms();
            }
            msVarKa.ms(downloadInfo.getCurBytes(), downloadInfo.getTotalBytes());
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.y
    public void ms(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        ms(11, downloadInfo, null, true);
    }
}
