package com.ss.android.downloadlib.ah;

import com.anythink.dlopt.common.a.a;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.downloader.depend.zb;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class ah implements zb {
    @Override // com.ss.android.socialbase.downloader.depend.zb
    public void ms(DownloadInfo downloadInfo) throws BaseException {
        com.ss.android.download.api.config.zb zbVarHi = hi.hi();
        if (downloadInfo == null || zbVarHi == null) {
            return;
        }
        File fileMs = ms(downloadInfo.getPackageName(), downloadInfo.getTargetFilePath());
        com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo);
        if (xrVarMs != null) {
            com.ss.android.downloadlib.ab.zb.ms(xrVarMs.ab());
        }
        downloadInfo.setMimeType("application/vnd.android.package-archive");
        downloadInfo.setName(fileMs.getName());
        downloadInfo.setMd5(null);
    }

    @Override // com.ss.android.socialbase.downloader.depend.zb
    public boolean xr(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.download.api.ah.xr.ms(com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }

    private File ms(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            str = name.substring(0, iLastIndexOf);
        }
        return new File(file.getParent(), str + a.h);
    }
}
