package com.byazt.owr;

import android.content.Context;
import com.byazt.auw.DownloadInfo;
import com.byazt.lhc.BaseException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 404, 13})
public class hw extends com.byazt.fn.x {
    public String c;
    public com.byazt.lxs.pr fw;
    public String hn;
    public int hw;
    public Context pr;
    public String uc;
    public String x;

    public hw(Context context, int i, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.pr = context.getApplicationContext();
        } else {
            this.pr = com.byazt.lj.hn.of();
        }
        this.hw = i;
        this.hn = str;
        this.x = str2;
        this.c = str3;
        this.uc = str4;
    }

    public hw(com.byazt.lxs.pr prVar) {
        this.pr = com.byazt.lj.hn.of();
        this.fw = prVar;
    }

    @Override // com.byazt.fn.x
    public com.byazt.lxs.pr pr() {
        Context context;
        com.byazt.lxs.pr prVar = this.fw;
        if (prVar == null && (context = this.pr) != null) {
            return new pr(context, this.hw, this.hn, this.x, this.c, this.uc);
        }
        return prVar;
    }

    @Override // com.byazt.fn.x, com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.byazt.fn.x, com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.byazt.fn.x, com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.byazt.fn.x, com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.byazt.fn.x, com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.pr == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            com.byazt.now.hw.pr(downloadInfo);
        }
    }

    @Override // com.byazt.fn.x, com.byazt.fn.AbsDownloadListener, com.byazt.fn.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.pr == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }
}
