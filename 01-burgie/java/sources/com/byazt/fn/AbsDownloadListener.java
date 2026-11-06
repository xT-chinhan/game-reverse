package com.byazt.fn;

import com.byazt.auw.DownloadInfo;
import com.byazt.lhc.BaseException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 157, 1851})
public abstract class AbsDownloadListener implements IDownloadListener {
    public static final String TAG = AbsDownloadListener.class.getSimpleName();

    @Override // com.byazt.fn.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (com.byazt.p000do.pr.pr() && downloadInfo != null) {
            com.byazt.p000do.pr.hw(TAG, " onPrepare -- " + downloadInfo.getName());
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (com.byazt.p000do.pr.pr() && downloadInfo != null) {
            com.byazt.p000do.pr.hw(TAG, " onStart -- " + downloadInfo.getName());
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (com.byazt.p000do.pr.pr() && downloadInfo != null && downloadInfo.getTotalBytes() != 0) {
            com.byazt.p000do.pr.hw(TAG, String.format("onProgress %s %.2f%%", downloadInfo.getName(), Float.valueOf((downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()) * 100.0f)));
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (com.byazt.p000do.pr.pr() && downloadInfo != null) {
            com.byazt.p000do.pr.hw(TAG, " onPause -- " + downloadInfo.getName());
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (com.byazt.p000do.pr.pr() && downloadInfo != null) {
            com.byazt.p000do.pr.hw(TAG, " onSuccessed -- " + downloadInfo.getName() + " " + downloadInfo.isSuccessByCache());
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (com.byazt.p000do.pr.pr() && downloadInfo != null) {
            String str = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = downloadInfo.getName();
            objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
            com.byazt.p000do.pr.hw(str, String.format("onFailed on %s because of : %s", objArr));
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
        if (com.byazt.p000do.pr.pr() && downloadInfo != null) {
            com.byazt.p000do.pr.hw(TAG, " onCanceled -- " + downloadInfo.getName());
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
        if (com.byazt.p000do.pr.pr() && downloadInfo != null) {
            com.byazt.p000do.pr.hw(TAG, " onFirstStart -- " + downloadInfo.getName());
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
        if (com.byazt.p000do.pr.pr() && downloadInfo != null) {
            com.byazt.p000do.pr.hw(TAG, " onFirstSuccess -- " + downloadInfo.getName());
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
        if (com.byazt.p000do.pr.pr() && downloadInfo != null) {
            String str = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = downloadInfo.getName();
            objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
            com.byazt.p000do.pr.hw(str, String.format("onRetry on %s because of : %s", objArr));
        }
    }

    @Override // com.byazt.fn.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
        if (com.byazt.p000do.pr.pr() && downloadInfo != null) {
            String str = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = downloadInfo.getName();
            objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
            com.byazt.p000do.pr.hw(str, String.format("onRetryDelay on %s because of : %s", objArr));
        }
    }

    public void onIntercept(DownloadInfo downloadInfo) {
        if (com.byazt.p000do.pr.pr() && downloadInfo != null) {
            com.byazt.p000do.pr.hw(TAG, " onIntercept -- " + downloadInfo.getName());
        }
    }
}
