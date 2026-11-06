package com.ss.android.download.api.download.ms;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface ms {
    void ms(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig);

    void ms(DownloadInfo downloadInfo);

    void ms(DownloadInfo downloadInfo, BaseException baseException, String str);

    void ms(DownloadInfo downloadInfo, String str);

    void xr(DownloadInfo downloadInfo, String str);
}
