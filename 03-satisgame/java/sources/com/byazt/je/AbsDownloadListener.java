package com.byazt.je;

import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 88, 2007})
public abstract class AbsDownloadListener implements IDownloadListener {
    public static final String TAG = "AbsDownloadListener";

    @Override // com.byazt.je.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (!com.byazt.fe.n.n() || downloadInfo == null) {
            return;
        }
        com.byazt.fe.n.qg(TAG, " onPrepare -- " + downloadInfo.getName());
    }

    @Override // com.byazt.je.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (!com.byazt.fe.n.n() || downloadInfo == null) {
            return;
        }
        com.byazt.fe.n.qg(TAG, " onStart -- " + downloadInfo.getName());
    }

    @Override // com.byazt.je.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (!com.byazt.fe.n.n() || downloadInfo == null || downloadInfo.getTotalBytes() == 0) {
            return;
        }
        com.byazt.fe.n.qg(TAG, String.format("onProgress %s %.2f%%", downloadInfo.getName(), Float.valueOf((downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()) * 100.0f)));
    }

    @Override // com.byazt.je.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (!com.byazt.fe.n.n() || downloadInfo == null) {
            return;
        }
        com.byazt.fe.n.qg(TAG, " onPause -- " + downloadInfo.getName());
    }

    @Override // com.byazt.je.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (!com.byazt.fe.n.n() || downloadInfo == null) {
            return;
        }
        com.byazt.fe.n.qg(TAG, " onSuccessed -- " + downloadInfo.getName() + " " + downloadInfo.isSuccessByCache());
    }

    @Override // com.byazt.je.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.byazt.fe.n.n() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.byazt.fe.n.qg(str, String.format("onFailed on %s because of : %s", objArr));
    }

    @Override // com.byazt.je.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
        if (!com.byazt.fe.n.n() || downloadInfo == null) {
            return;
        }
        com.byazt.fe.n.qg(TAG, " onCanceled -- " + downloadInfo.getName());
    }

    @Override // com.byazt.je.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
        if (!com.byazt.fe.n.n() || downloadInfo == null) {
            return;
        }
        com.byazt.fe.n.qg(TAG, " onFirstStart -- " + downloadInfo.getName());
    }

    @Override // com.byazt.je.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
        if (!com.byazt.fe.n.n() || downloadInfo == null) {
            return;
        }
        com.byazt.fe.n.qg(TAG, " onFirstSuccess -- " + downloadInfo.getName());
    }

    @Override // com.byazt.je.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.byazt.fe.n.n() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.byazt.fe.n.qg(str, String.format("onRetry on %s because of : %s", objArr));
    }

    @Override // com.byazt.je.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
        if (!com.byazt.fe.n.n() || downloadInfo == null) {
            return;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = downloadInfo.getName();
        objArr[1] = baseException != null ? baseException.getErrorMessage() : "unkown";
        com.byazt.fe.n.qg(str, String.format("onRetryDelay on %s because of : %s", objArr));
    }

    public void onIntercept(DownloadInfo downloadInfo) {
        if (!com.byazt.fe.n.n() || downloadInfo == null) {
            return;
        }
        com.byazt.fe.n.qg(TAG, " onIntercept -- " + downloadInfo.getName());
    }
}
