package com.byazt.bk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.byazt.je.h;
import com.byazt.q.AdBaseConstants;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 26})
public class qg {
    public static void n(DownloadInfo downloadInfo) {
        qg(downloadInfo);
    }

    private static void qg(final DownloadInfo downloadInfo) {
        final Context contextU = com.byazt.xv.s.u();
        boolean z = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.byazt.e.s.qg(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK)) && com.byazt.f.n.n(downloadInfo.getId()).n("auto_install_when_resume", 0) != 1) {
            z = false;
        }
        final int iN = z ? com.byazt.e.s.n(contextU, downloadInfo.getId(), false) : 2;
        com.byazt.xv.s.d().execute(new Runnable() { // from class: com.byazt.bk.qg.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.z.l lVarS = com.byazt.e.q.cp().s();
                h downloadNotificationEventListener = Downloader.getInstance(contextU).getDownloadNotificationEventListener(downloadInfo.getId());
                if (lVarS == null && downloadNotificationEventListener == null) {
                    return;
                }
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    try {
                        PackageInfo packageInfoN = com.byazt.e.s.n(downloadInfo, file);
                        if (packageInfoN != null) {
                            String packageName = (iN == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? packageInfoN.packageName : downloadInfo.getPackageName();
                            if (lVarS != null) {
                                lVarS.n(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.n(1, downloadInfo, packageName, "");
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }
}
