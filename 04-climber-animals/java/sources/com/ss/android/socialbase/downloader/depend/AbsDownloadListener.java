package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsDownloadListener implements IDownloadListener {
    private static final String TAG = "AbsDownloadListener";

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.ah.ms.ms() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(TAG, " onPrepare -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.ah.ms.ms() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(TAG, " onStart -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.ah.ms.ms() || downloadInfo == null || downloadInfo.getTotalBytes() == 0) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(TAG, String.format("onProgress %s %.2f%%", downloadInfo.getName(), Float.valueOf((downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()) * 100.0f)));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.ah.ms.ms() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(TAG, " onPause -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.ah.ms.ms() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(TAG, " onSuccessed -- " + downloadInfo.getName() + " " + downloadInfo.isSuccessByCache());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.ah.ms.ms() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.ss.android.socialbase.downloader.ah.ms.xr(str, String.format("onFailed on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.ah.ms.ms() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(TAG, " onCanceled -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.ah.ms.ms() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(TAG, " onFirstStart -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.ah.ms.ms() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(TAG, " onFirstSuccess -- " + downloadInfo.getName());
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.ah.ms.ms() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.ss.android.socialbase.downloader.ah.ms.xr(str, String.format("onRetry on %s because of : %s", objArr));
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.ah.ms.ms() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.ss.android.socialbase.downloader.ah.ms.xr(str, String.format("onRetryDelay on %s because of : %s", objArr));
    }

    public void onIntercept(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.ah.ms.ms() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(TAG, " onIntercept -- " + downloadInfo.getName());
    }
}
