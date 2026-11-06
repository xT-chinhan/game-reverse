package com.ss.android.downloadlib.ah;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c implements com.ss.android.socialbase.appdownloader.ah.d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f4469ms;

    public c(Context context) {
        this.f4469ms = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.d
    public void ms(Context context, String str) {
        com.ss.android.downloadlib.ms.ms().ms(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.d
    public void ms(int i, int i2, String str, int i3, long j) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.ms.xr xrVarMs;
        Context context = this.f4469ms;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() == 0 || (xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo)) == null) {
            return;
        }
        if (i2 == 1) {
            com.ss.android.downloadlib.ms.ms(downloadInfo, xrVarMs);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.ms.ms().ms(downloadInfo, xrVarMs.xr(), xrVarMs.sl(), xrVarMs.ka(), downloadInfo.getTitle(), xrVarMs.d(), downloadInfo.getTargetFilePath());
                return;
            }
            return;
        }
        if (i2 == 3) {
            com.ss.android.downloadlib.d.ms.ms().ms("download_notification", "download_notification_install", com.ss.android.downloadlib.ms.xr(new JSONObject(), downloadInfo), xrVarMs);
            return;
        }
        if (i2 == 5) {
            com.ss.android.downloadlib.d.ms.ms().ms("download_notification", "download_notification_pause", xrVarMs);
        } else if (i2 == 6) {
            com.ss.android.downloadlib.d.ms.ms().ms("download_notification", "download_notification_continue", xrVarMs);
        } else {
            if (i2 != 7) {
                return;
            }
            com.ss.android.downloadlib.d.ms.ms().ms("download_notification", "download_notification_click", xrVarMs);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.d
    public boolean ms(int i, boolean z) {
        if (hi.ub() != null) {
            return hi.ub().ms(z);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.d
    public void ms(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.x.ms().ms(downloadInfo);
        if (com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("report_download_cancel", 1) == 1) {
            com.ss.android.downloadlib.d.ms.ms().ms(downloadInfo, new BaseException(PointerIconCompat.TYPE_NO_DROP, ""));
        } else {
            com.ss.android.downloadlib.d.ms.ms().xr(downloadInfo, new BaseException(PointerIconCompat.TYPE_NO_DROP, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.d
    public void ms(int i, int i2, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.f4469ms;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.xr.ms().ms(this.f4469ms, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.d
    public boolean ms() {
        return com.ss.android.downloadlib.addownload.xr.ms().xr();
    }
}
