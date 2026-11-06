package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class xr {
    public static void ms(DownloadInfo downloadInfo) {
        xr(downloadInfo);
    }

    private static void xr(final DownloadInfo downloadInfo) {
        final Context contextK = com.ss.android.socialbase.downloader.downloader.ah.k();
        boolean z = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.ss.android.socialbase.appdownloader.ah.xr(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) && com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        final int iMs = z ? com.ss.android.socialbase.appdownloader.ah.ms(contextK, downloadInfo.getId(), false) : 2;
        com.ss.android.socialbase.downloader.downloader.ah.sl().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.c.xr.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.ah.d dVarXr = com.ss.android.socialbase.appdownloader.d.ch().xr();
                yu downloadNotificationEventListener = Downloader.getInstance(contextK).getDownloadNotificationEventListener(downloadInfo.getId());
                if (dVarXr == null && downloadNotificationEventListener == null) {
                    return;
                }
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    try {
                        PackageInfo packageInfoMs = com.ss.android.socialbase.appdownloader.ah.ms(downloadInfo, file);
                        if (packageInfoMs != null) {
                            String packageName = (iMs == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? packageInfoMs.packageName : downloadInfo.getPackageName();
                            if (dVarXr != null) {
                                dVarXr.ms(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.ms(1, downloadInfo, packageName, "");
                            }
                        }
                    } catch (Exception e) {
                        ab.ms(e);
                    }
                }
            }
        });
    }
}
