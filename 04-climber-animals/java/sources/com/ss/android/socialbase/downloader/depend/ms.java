package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ms extends AbsDownloadListener implements y {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4642ms = "ms";

    public void ms(DownloadInfo downloadInfo) {
        if (!com.ss.android.socialbase.downloader.ah.ms.ms() || downloadInfo == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(f4642ms, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
