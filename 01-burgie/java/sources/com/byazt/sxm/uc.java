package com.byazt.sxm;

import android.content.Context;
import android.support.v4.view.PointerIconCompat;
import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.lhc.BaseException;
import com.byazt.lj.Downloader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 448, 5})
public class uc implements com.byazt.zkm.c {
    public Context pr;

    public uc(Context context) {
        this.pr = context.getApplicationContext();
    }

    @Override // com.byazt.zkm.c
    public void pr(Context context, String str) {
        com.byazt.cvl.pr.pr().pr(str);
    }

    @Override // com.byazt.zkm.c
    public void pr(int i, int i2, String str, int i3, long j) {
        DownloadInfo downloadInfo;
        com.byazt.tia.hw hwVarPr;
        Context context = this.pr;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() == 0 || (hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo)) == null) {
            return;
        }
        switch (i2) {
            case 1:
                com.byazt.cvl.pr.pr(downloadInfo, hwVarPr);
                if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                    com.byazt.eld.pr.pr().pr(downloadInfo, hwVarPr.hw(), hwVarPr.k(), hwVarPr.c(), downloadInfo.getTitle(), hwVarPr.x(), downloadInfo.getTargetFilePath());
                }
                break;
            case 3:
                com.byazt.mf.pr.pr().pr("download_notification", "download_notification_install", com.byazt.cvl.pr.hw(new JSONObject(), downloadInfo), hwVarPr);
                break;
            case 5:
                com.byazt.mf.pr.pr().pr("download_notification", "download_notification_pause", hwVarPr);
                break;
            case 6:
                com.byazt.mf.pr.pr().pr("download_notification", "download_notification_continue", hwVarPr);
                break;
            case 7:
                com.byazt.mf.pr.pr().pr("download_notification", "download_notification_click", hwVarPr);
                break;
        }
    }

    @Override // com.byazt.zkm.c
    public boolean pr(int i, boolean z) {
        if (k.ho() == null) {
            return false;
        }
        return k.ho().pr(z);
    }

    @Override // com.byazt.zkm.c
    public void pr(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.byazt.cvl.zo.pr().pr(downloadInfo);
        if (com.byazt.ew.pr.pr(downloadInfo.getId()).pr("report_download_cancel", 1) == 1) {
            com.byazt.mf.pr.pr().pr(downloadInfo, new BaseException(PointerIconCompat.TYPE_NO_DROP, ""));
        } else {
            com.byazt.mf.pr.pr().hw(downloadInfo, new BaseException(PointerIconCompat.TYPE_NO_DROP, ""));
        }
    }

    @Override // com.byazt.zkm.c
    public void pr(int i, int i2, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.pr;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.byazt.eld.hw.pr().pr(this.pr, downloadInfo);
    }

    @Override // com.byazt.zkm.c
    public boolean pr() {
        return com.byazt.eld.hw.pr().hw();
    }
}
