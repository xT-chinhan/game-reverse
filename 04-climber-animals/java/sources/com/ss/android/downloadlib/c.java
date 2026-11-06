package com.ss.android.downloadlib;

import android.text.TextUtils;
import com.ss.android.download.api.config.h;
import com.ss.android.download.api.config.nw;
import com.ss.android.download.api.config.sl;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.of;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
class c implements com.ss.android.download.api.ms {
    c() {
    }

    @Override // com.ss.android.download.api.ms
    public com.ss.android.download.api.ms ms(com.ss.android.download.api.config.ny nyVar) {
        hi.ms(nyVar);
        return this;
    }

    @Override // com.ss.android.download.api.ms
    public com.ss.android.download.api.ms ms(com.ss.android.download.api.config.ab abVar) {
        hi.ms(abVar);
        return this;
    }

    @Override // com.ss.android.download.api.ms
    public com.ss.android.download.api.ms ms(sl slVar) {
        hi.ms(slVar);
        return this;
    }

    @Override // com.ss.android.download.api.ms
    public com.ss.android.download.api.ms ms(com.ss.android.download.api.config.x xVar) {
        hi.ms(xVar);
        return this;
    }

    @Override // com.ss.android.download.api.ms
    public com.ss.android.download.api.ms ms(com.ss.android.download.api.config.ch chVar) {
        hi.ms(chVar);
        return this;
    }

    @Override // com.ss.android.download.api.ms
    public com.ss.android.download.api.ms ms(com.ss.android.download.api.model.ms msVar) {
        hi.ms(msVar);
        return this;
    }

    @Override // com.ss.android.download.api.ms
    public com.ss.android.download.api.ms ms(String str) {
        hi.ms(str);
        return this;
    }

    @Override // com.ss.android.download.api.ms
    public com.ss.android.download.api.ms ms(final com.ss.android.download.api.config.xr xrVar) {
        hi.ms(xrVar);
        com.ss.android.socialbase.downloader.ms.ms.ms().ms(new com.ss.android.socialbase.downloader.ms.ms.ah() { // from class: com.ss.android.downloadlib.c.1
        });
        return this;
    }

    @Override // com.ss.android.download.api.ms
    public com.ss.android.download.api.ms ms(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new of() { // from class: com.ss.android.downloadlib.c.2
                @Override // com.ss.android.socialbase.downloader.depend.of
                public boolean xr(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.of
                public boolean ms(DownloadInfo downloadInfo) {
                    com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId());
                    if (msVarMs.xr("notification_opt_2") == 1) {
                        if (downloadInfo.getStatus() == -2) {
                            DownloadHandlerService.ms(hi.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.d.ch().xr(), Downloader.getInstance(hi.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                        }
                        return true;
                    }
                    boolean zD = d(downloadInfo);
                    if (msVarMs.ms("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return zD;
                }

                private boolean d(DownloadInfo downloadInfo) {
                    String strMs;
                    nw nwVarY = hi.y();
                    if (nwVarY == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo);
                    if (xrVarMs != null && xrVarMs.ah()) {
                        strMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("ad_notification_jump_url", (String) null);
                    } else {
                        strMs = com.ss.android.downloadlib.addownload.ny.ms(downloadInfo);
                    }
                    if (TextUtils.isEmpty(strMs)) {
                        return false;
                    }
                    return nwVarY.ms(hi.getContext(), strMs);
                }

                @Override // com.ss.android.socialbase.downloader.depend.of
                public boolean ah(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo);
                    if (xrVarMs != null) {
                        com.ss.android.downloadlib.xr.ms.ms(xrVarMs);
                    } else {
                        com.ss.android.downloadlib.ab.ny.xr(hi.getContext(), downloadInfo.getPackageName());
                    }
                    com.ss.android.socialbase.downloader.notification.xr.ms().c(downloadInfo.getId());
                    return true;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.ah.ah());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.ms
    public com.ss.android.download.api.ms ms(h hVar) {
        hi.ms(hVar);
        return this;
    }

    @Override // com.ss.android.download.api.ms
    public void ms() {
        if (!hi.re()) {
            com.ss.android.downloadlib.ka.ah.ms().ms("ttdownloader init error");
        }
        hi.ms(com.ss.android.downloadlib.ka.ah.ms());
        try {
            com.ss.android.socialbase.appdownloader.d.ch().xr(hi.b());
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.socialbase.appdownloader.d.ch().ms(ms.ms());
        ka.ms().xr(new Runnable() { // from class: com.ss.android.downloadlib.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.c.ka.ms("");
                if (com.ss.android.socialbase.appdownloader.c.ka.ub()) {
                    com.ss.android.socialbase.downloader.downloader.ah.ms(true);
                }
                if (com.ss.android.socialbase.downloader.ab.ms.ah().ms("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.c.c.ms(hi.getContext());
                }
            }
        });
    }
}
