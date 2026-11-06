package com.ss.android.downloadlib.ah;

import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.xr.ny;
import com.ss.android.socialbase.downloader.depend.hi;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.taptap.sdk.db.constant.Common;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d implements com.ss.android.socialbase.appdownloader.ah.ab, hi {
    @Override // com.ss.android.socialbase.appdownloader.ah.ab
    public void ms(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        ms(downloadInfo, downloadInfo.getRealStatus(), z);
    }

    public void ms(DownloadInfo downloadInfo, int i, boolean z) {
        com.ss.android.downloadlib.addownload.xr.c.ms().xr();
        com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo);
        if (xrVarMs == null) {
            return;
        }
        try {
            if (z) {
                xrVarMs.ah(downloadInfo.getFailedResumeCount());
            } else if (xrVarMs.g() == -1) {
                return;
            } else {
                xrVarMs.ah(-1);
            }
            ny.ms().ms(xrVarMs);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put(Common.System.NAME, downloadInfo.getName());
            jSONObject.put("url", downloadInfo.getUrl());
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
            com.ss.android.downloadlib.d.ms.ms().ms("embeded_ad", "download_uncompleted", jSONObject, xrVarMs);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.hi
    public void ms() {
        com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.ah.d.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.ss.android.downloadlib.addownload.xr.c.ms().xr();
                for (com.ss.android.downloadad.api.ms.xr xrVar : com.ss.android.downloadlib.addownload.xr.c.ms().ah().values()) {
                    int iY = xrVar.y();
                    if (iY != 0) {
                        com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(iY);
                        if (msVarMs.xr("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.hi.getContext()).getDownloadInfo(iY)) != null) {
                            if (zb.xr(xrVar) && !zb.ah(xrVar.ka())) {
                                int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                if (spIntVal2 < msVarMs.ms("noti_open_restart_times", 1)) {
                                    x.ms().ka(xrVar);
                                    downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                if (spIntVal3 < msVarMs.ms("noti_continue_restart_times", 1)) {
                                    x.ms().ms(xrVar);
                                    downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && com.ss.android.socialbase.downloader.ny.c.ah(downloadInfo) && !zb.xr(xrVar) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < msVarMs.ms("noti_install_restart_times", 1)) {
                                x.ms().ah(xrVar);
                                downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }
}
