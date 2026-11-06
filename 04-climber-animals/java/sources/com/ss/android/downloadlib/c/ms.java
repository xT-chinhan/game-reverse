package com.ss.android.downloadlib.c;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.xr.c;
import com.ss.android.socialbase.appdownloader.ah.ch;
import com.ss.android.socialbase.appdownloader.ah.ny;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class ms implements ch {
    @Override // com.ss.android.socialbase.appdownloader.ah.ch
    public void ms(DownloadInfo downloadInfo, final ny nyVar) {
        ms(downloadInfo, new com.ss.android.downloadlib.guide.install.ms() { // from class: com.ss.android.downloadlib.c.ms.1
            @Override // com.ss.android.downloadlib.guide.install.ms
            public void ms() {
                nyVar.ms();
            }
        });
    }

    public void ms(final DownloadInfo downloadInfo, final com.ss.android.downloadlib.guide.install.ms msVar) {
        com.ss.android.downloadad.api.ms.xr xrVarMs = c.ms().ms(downloadInfo);
        if (xrVarMs != null && com.ss.android.downloadlib.xr.ny.ms(xrVarMs)) {
            TTDelegateActivity.ms(xrVarMs, new com.ss.android.downloadlib.guide.install.ms() { // from class: com.ss.android.downloadlib.c.ms.2
                @Override // com.ss.android.downloadlib.guide.install.ms
                public void ms() {
                    ms.this.xr(downloadInfo, msVar);
                }
            });
        } else {
            xr(downloadInfo, msVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(DownloadInfo downloadInfo, final com.ss.android.downloadlib.guide.install.ms msVar) {
        com.ss.android.downloadad.api.ms.xr xrVarMs = c.ms().ms(downloadInfo);
        boolean zMs = com.ss.android.downloadlib.xr.c.ms(xrVarMs);
        boolean zXr = com.ss.android.downloadlib.xr.c.xr(xrVarMs);
        if (!zMs || !zXr) {
            msVar.ms();
        } else {
            com.ss.android.downloadlib.xr.ah.ms(xrVarMs, new com.ss.android.downloadlib.guide.install.ms() { // from class: com.ss.android.downloadlib.c.ms.3
                @Override // com.ss.android.downloadlib.guide.install.ms
                public void ms() {
                    msVar.ms();
                }
            });
        }
    }
}
