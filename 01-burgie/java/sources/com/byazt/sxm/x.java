package com.byazt.sxm;

import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.fn.w;
import com.byazt.lj.Downloader;
import com.byazt.shh.aj;
import com.byazt.uk.m;
import com.tapsdk.tapad.internal.runtime.download.ApkNotificationReceiver;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 448, 121})
public class x implements com.byazt.zkm.zo, w {
    @Override // com.byazt.zkm.zo
    public void pr(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        pr(downloadInfo, downloadInfo.getRealStatus(), z);
    }

    public void pr(DownloadInfo downloadInfo, int i, boolean z) {
        com.byazt.shh.uc.pr().hw();
        com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo);
        if (hwVarPr == null) {
            return;
        }
        try {
            if (z) {
                hwVarPr.hn(downloadInfo.getFailedResumeCount());
            } else if (hwVarPr.nl() == -1) {
                return;
            } else {
                hwVarPr.hn(-1);
            }
            aj.pr().pr(hwVarPr);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ApkNotificationReceiver.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put(Common.System.NAME, downloadInfo.getName());
            jSONObject.put(BreakpointSQLiteKey.URL, downloadInfo.getUrl());
            jSONObject.put("download_time", downloadInfo.getDownloadTime());
            jSONObject.put("download_status", i);
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            int i2 = 1;
            jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put("chunk_count", downloadInfo.getChunkCount());
            if (!z) {
                i2 = 2;
            }
            jSONObject.put("launch_resumed", i2);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            com.byazt.mf.pr.pr().pr(com.byazt.pfl.hw.AD_TAG_FEED, "download_uncompleted", jSONObject, hwVarPr);
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.fn.w
    public void pr() {
        com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.sxm.x.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.byazt.shh.uc.pr().hw();
                for (com.byazt.tia.hw hwVar : com.byazt.shh.uc.pr().hn().values()) {
                    int iQa = hwVar.qa();
                    if (iQa != 0) {
                        com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(iQa);
                        if (prVarPr.hw("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(iQa)) != null) {
                            if (m.hw(hwVar) && !m.hn(hwVar.c())) {
                                int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                if (spIntVal2 < prVarPr.pr("noti_open_restart_times", 1)) {
                                    zo.pr().c(hwVar);
                                    downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                if (spIntVal3 < prVarPr.pr("noti_continue_restart_times", 1)) {
                                    zo.pr().pr(hwVar);
                                    downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && com.byazt.tuy.uc.hn(downloadInfo) && !m.hw(hwVar) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < prVarPr.pr("noti_install_restart_times", 1)) {
                                zo.pr().hn(hwVar);
                                downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }
}
