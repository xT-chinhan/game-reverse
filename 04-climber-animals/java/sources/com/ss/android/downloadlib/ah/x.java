package com.ss.android.downloadlib.ah;

import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class x {

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static x f4475ms = new x();
    }

    public static x ms() {
        return ms.f4475ms;
    }

    private x() {
    }

    public void ms(com.ss.android.downloadad.api.ms.xr xrVar) {
        xr(xrVar, 5L);
    }

    public void xr(com.ss.android.downloadad.api.ms.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        xr(xrVar, com.ss.android.socialbase.downloader.ab.ms.ms(xrVar.y()).ms("noti_continue_delay_secs", 5));
    }

    private void xr(final com.ss.android.downloadad.api.ms.xr xrVar, long j) {
        final int iY = xrVar.y();
        if (com.ss.android.socialbase.downloader.ab.ms.ms(iY).xr("notification_opt_2") != 1) {
            return;
        }
        ms(iY);
        com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.ah.x.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(iY);
                JSONObject jSONObject = new JSONObject();
                zb.ms(jSONObject, "ttdownloader_type", (Object) 1);
                com.ss.android.downloadlib.ab.c.ah(downloadInfo, jSONObject);
                if (downloadInfo != null && -2 == downloadInfo.getRealStatus() && !downloadInfo.isPauseReserveOnWifi()) {
                    x.this.ms(iY, xrVar, jSONObject);
                } else {
                    zb.ms(jSONObject, "error_code", (Object) 1001);
                }
                com.ss.android.downloadlib.d.ms.ms().xr("download_notification_try_show", jSONObject, xrVar);
            }
        }, j * 1000);
    }

    public void ah(com.ss.android.downloadad.api.ms.xr xrVar) {
        ah(xrVar, 5L);
    }

    public void d(com.ss.android.downloadad.api.ms.xr xrVar) {
        ah(xrVar, com.ss.android.socialbase.downloader.ab.ms.ms(xrVar.y()).ms("noti_install_delay_secs", 5));
    }

    private void ah(final com.ss.android.downloadad.api.ms.xr xrVar, long j) {
        final int iY = xrVar.y();
        if (com.ss.android.socialbase.downloader.ab.ms.ms(iY).xr("notification_opt_2") != 1) {
            return;
        }
        ms(iY);
        com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.ah.x.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(iY);
                JSONObject jSONObject = new JSONObject();
                zb.ms(jSONObject, "ttdownloader_type", (Object) 2);
                com.ss.android.downloadlib.ab.c.ah(downloadInfo, jSONObject);
                if (!zb.xr(xrVar)) {
                    x.this.ms(iY, xrVar, jSONObject);
                } else {
                    zb.ms(jSONObject, "error_code", (Object) 1002);
                }
                com.ss.android.downloadlib.d.ms.ms().xr("download_notification_try_show", jSONObject, xrVar);
            }
        }, j * 1000);
    }

    public void ka(com.ss.android.downloadad.api.ms.xr xrVar) {
        ms(xrVar, 5L);
    }

    public void c(com.ss.android.downloadad.api.ms.xr xrVar) {
        ms(xrVar, com.ss.android.socialbase.downloader.ab.ms.ms(xrVar.y()).ms("noti_open_delay_secs", 5));
    }

    public void ms(final com.ss.android.downloadad.api.ms.xr xrVar, long j) {
        final int iY = xrVar.y();
        if (com.ss.android.socialbase.downloader.ab.ms.ms(iY).xr("notification_opt_2") != 1) {
            return;
        }
        ms(iY);
        com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.ah.x.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(iY);
                JSONObject jSONObject = new JSONObject();
                zb.ms(jSONObject, "ttdownloader_type", (Object) 3);
                com.ss.android.downloadlib.ab.c.ah(downloadInfo, jSONObject);
                if (!zb.ah(xrVar.ka())) {
                    x.this.ms(iY, xrVar, jSONObject);
                } else {
                    zb.ms(jSONObject, "error_code", (Object) 1003);
                }
                com.ss.android.downloadlib.d.ms.ms().xr("download_notification_try_show", jSONObject, xrVar);
            }
        }, j * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, com.ss.android.downloadad.api.ms.xr xrVar, JSONObject jSONObject) {
        if (!com.ss.android.socialbase.appdownloader.ka.d.ms()) {
            zb.ms(jSONObject, "error_code", (Object) 1004);
            return;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(i);
        if (downloadInfo == null) {
            zb.ms(jSONObject, "error_code", (Object) 1005);
            return;
        }
        if (com.ss.android.socialbase.downloader.notification.xr.ms().ka(i) != null) {
            com.ss.android.socialbase.downloader.notification.xr.ms().c(i);
        }
        com.ss.android.socialbase.appdownloader.ka.ms msVar = new com.ss.android.socialbase.appdownloader.ka.ms(hi.getContext(), i, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
        msVar.ms(downloadInfo.getCurBytes());
        msVar.xr(downloadInfo.getTotalBytes());
        msVar.ms(downloadInfo.getStatus(), null, false, false);
        com.ss.android.socialbase.downloader.notification.xr.ms().ms(msVar);
        msVar.ms((BaseException) null, false);
        com.ss.android.downloadlib.d.ms.ms().xr("download_notification_show", jSONObject, xrVar);
    }

    public void ms(int i) {
        DownloadInfo downloadInfo;
        if (com.ss.android.socialbase.appdownloader.ka.ah.ms().ms(i) != null || (downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(i)) == null) {
            return;
        }
        com.ss.android.socialbase.appdownloader.ka.ah.ms().ms(i, downloadInfo.getIconUrl());
    }
}
