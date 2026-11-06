package com.ss.android.socialbase.downloader.ny;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static boolean ms(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).xr("optimize_head_request") == 1;
    }

    public static boolean xr(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).xr("optimize_save_path") == 1;
    }
}
