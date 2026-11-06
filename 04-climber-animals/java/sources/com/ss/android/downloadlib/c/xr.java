package com.ss.android.downloadlib.c;

import com.ss.android.downloadlib.addownload.xr.c;
import com.ss.android.socialbase.appdownloader.ah.ch;
import com.ss.android.socialbase.appdownloader.ah.ny;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class xr implements ch {
    @Override // com.ss.android.socialbase.appdownloader.ah.ch
    public void ms(DownloadInfo downloadInfo, ny nyVar) {
        com.ss.android.downloadad.api.ms.xr xrVarMs;
        if (downloadInfo != null && (xrVarMs = c.ms().ms(downloadInfo)) != null) {
            downloadInfo.setLinkMode(xrVarMs.k());
        }
        if (nyVar != null) {
            nyVar.ms();
        }
    }
}
