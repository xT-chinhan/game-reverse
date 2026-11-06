package com.ss.android.downloadlib.ah;

import android.content.pm.PackageInfo;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.downloader.depend.zb;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class xr implements zb {
    @Override // com.ss.android.socialbase.downloader.depend.zb
    public void ms(DownloadInfo downloadInfo) throws BaseException {
        PackageInfo packageInfoMs = com.ss.android.socialbase.appdownloader.ah.ms(hi.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (packageInfoMs != null) {
            downloadInfo.setAppVersionCode(packageInfoMs.versionCode);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.zb
    public boolean xr(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.downloadlib.ab.ka.xr() && downloadInfo.getPackageInfo() == null;
    }
}
