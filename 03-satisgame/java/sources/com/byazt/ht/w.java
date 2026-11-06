package com.byazt.ht;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import com.byazt.q.AdBaseConstants;
import com.byazt.qx.BaseException;
import com.byazt.ug.d;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1169, 13})
public class w implements com.byazt.z.l {
    public Context n;

    public w(Context context) {
        this.n = context.getApplicationContext();
    }

    @Override // com.byazt.z.l
    public void n(Context context, String str) {
        com.byazt.s.n.n().n(str);
    }

    @Override // com.byazt.z.l
    public void n(int i, int i2, String str, int i3, long j) {
        DownloadInfo downloadInfo;
        com.byazt.h.qg qgVarN;
        Context context = this.n;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() == 0 || (qgVarN = com.byazt.vl.w.n().n(downloadInfo)) == null) {
            return;
        }
        if (i2 == 1) {
            com.byazt.s.n.n(downloadInfo, qgVarN);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                com.byazt.ug.n.n().n(downloadInfo, qgVarN.qg(), qgVarN.d(), qgVarN.l(), downloadInfo.getTitle(), qgVarN.q(), downloadInfo.getTargetFilePath());
                return;
            }
            return;
        }
        if (i2 == 3) {
            com.byazt.vj.n.n().n("download_notification", "download_notification_install", com.byazt.s.n.qg(new JSONObject(), downloadInfo), qgVarN);
            return;
        }
        if (i2 == 5) {
            com.byazt.vj.n.n().n("download_notification", "download_notification_pause", qgVarN);
        } else if (i2 == 6) {
            com.byazt.vj.n.n().n("download_notification", "download_notification_continue", qgVarN);
        } else {
            if (i2 != 7) {
                return;
            }
            com.byazt.vj.n.n().n("download_notification", "download_notification_click", qgVarN);
        }
    }

    @Override // com.byazt.z.l
    public boolean n(int i, boolean z) {
        if (d.k() != null) {
            return d.k().n(z);
        }
        return false;
    }

    @Override // com.byazt.z.l
    public void n(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.byazt.s.fs.n().n(downloadInfo);
        if (com.byazt.f.n.n(downloadInfo.getId()).n("report_download_cancel", 1) == 1) {
            com.byazt.vj.n.n().n(downloadInfo, new BaseException(PointerIconCompat.TYPE_NO_DROP, ""));
        } else {
            com.byazt.vj.n.n().qg(downloadInfo, new BaseException(PointerIconCompat.TYPE_NO_DROP, ""));
        }
    }

    @Override // com.byazt.z.l
    public void n(int i, int i2, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.n;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.byazt.ug.qg.n().n(this.n, downloadInfo);
    }

    @Override // com.byazt.z.l
    public boolean n() {
        return com.byazt.ug.qg.n().qg();
    }
}
