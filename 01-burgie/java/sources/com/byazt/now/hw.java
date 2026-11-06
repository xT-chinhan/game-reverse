package com.byazt.now;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fn.b;
import com.byazt.lj.Downloader;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1862, 13})
public class hw {
    public static void pr(DownloadInfo downloadInfo) {
        hw(downloadInfo);
    }

    private static void hw(final DownloadInfo downloadInfo) {
        final Context contextOf = com.byazt.lj.hn.of();
        boolean z = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.byazt.mdu.hn.hw(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK)) && com.byazt.ew.pr.pr(downloadInfo.getId()).pr("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        final int iPr = z ? com.byazt.mdu.hn.pr(contextOf, downloadInfo.getId(), false) : 2;
        com.byazt.lj.hn.k().execute(new Runnable() { // from class: com.byazt.now.hw.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.zkm.c cVarHn = com.byazt.mdu.x.w().hn();
                b downloadNotificationEventListener = Downloader.getInstance(contextOf).getDownloadNotificationEventListener(downloadInfo.getId());
                if (cVarHn != null || downloadNotificationEventListener != null) {
                    File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                    if (file.exists()) {
                        try {
                            PackageInfo packageInfoPr = com.byazt.mdu.hn.pr(downloadInfo, file);
                            if (packageInfoPr != null) {
                                String packageName = (iPr == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? packageInfoPr.packageName : downloadInfo.getPackageName();
                                if (cVarHn != null) {
                                    cVarHn.pr(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                                }
                                if (downloadNotificationEventListener != null) {
                                    downloadNotificationEventListener.pr(1, downloadInfo, packageName, "");
                                }
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        });
    }
}
