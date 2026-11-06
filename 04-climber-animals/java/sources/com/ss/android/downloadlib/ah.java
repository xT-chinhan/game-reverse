package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.ab.hi;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ah implements com.ss.android.socialbase.appdownloader.ah.x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f4461ms = "ah";
    private Handler xr = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.ah.x
    public void ms(DownloadInfo downloadInfo, BaseException baseException, int i) {
        BaseException baseException2;
        final DownloadModel downloadModelMs;
        if (downloadInfo == null) {
            return;
        }
        if (i == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.ab.c.ah(downloadInfo, jSONObject);
            ms.ms(jSONObject, downloadInfo);
            hi.ms("download_failed", jSONObject.toString());
        }
        com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo);
        if (xrVarMs == null) {
            return;
        }
        try {
            if (i != -1) {
                if (i == -3) {
                    ms.ms(downloadInfo, xrVarMs);
                    return;
                }
                if (i == 2001) {
                    ms.ms().ms(downloadInfo, xrVarMs, 2001);
                    return;
                } else {
                    if (i == 11) {
                        ms.ms().ms(downloadInfo, xrVarMs, 2000);
                        if (xrVarMs.il()) {
                            return;
                        }
                        ms(downloadInfo, xrVarMs);
                        return;
                    }
                    return;
                }
            }
            if (baseException != null) {
                if (com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.xr.post(new Runnable() { // from class: com.ss.android.downloadlib.ah.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.hi.ah().ms(5, com.ss.android.downloadlib.addownload.hi.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (com.ss.android.socialbase.downloader.ny.c.x(baseException)) {
                    if (com.ss.android.downloadlib.addownload.hi.zb() != null) {
                        com.ss.android.downloadlib.addownload.hi.zb();
                        xrVarMs.xr();
                    }
                    com.ss.android.downloadlib.d.ms.ms().ms("download_failed_for_space", xrVarMs);
                    if (!xrVarMs.fm()) {
                        com.ss.android.downloadlib.d.ms.ms().ms("download_can_restart", xrVarMs);
                        ms(downloadInfo);
                    }
                    if ((com.ss.android.downloadlib.addownload.hi.zb() == null || !com.ss.android.downloadlib.addownload.hi.zb().ah()) && (downloadModelMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(xrVarMs.xr())) != null && downloadModelMs.isShowToast()) {
                        final com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId());
                        if (msVarMs.ms("show_no_enough_space_toast", 0) == 1) {
                            this.xr.post(new Runnable() { // from class: com.ss.android.downloadlib.ah.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.ss.android.downloadlib.addownload.hi.ah().ms(2, com.ss.android.downloadlib.addownload.hi.getContext(), downloadModelMs, msVarMs.ms("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), zb.ms(baseException.getMessage(), com.ss.android.downloadlib.addownload.hi.ny().optInt("exception_msg_length", 500)));
            } else {
                baseException2 = null;
            }
            com.ss.android.downloadlib.d.ms.ms().xr(downloadInfo, baseException2);
            x.ms().ms(downloadInfo, baseException, "");
        } catch (Exception e) {
            com.ss.android.downloadlib.addownload.hi.t().ms(e, "onAppDownloadMonitorSend");
        }
    }

    private void ms(final DownloadInfo downloadInfo, final com.ss.android.downloadad.api.ms.xr xrVar) {
        final long jMs = zb.ms(Environment.getDataDirectory(), -1L);
        long jMin = Math.min(524288000L, zb.ms(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        final double d = (totalBytes * 2.5d) + jMin;
        if (jMs > -1 && totalBytes > -1) {
            double d2 = jMs;
            if (d2 < d && d - d2 > com.ss.android.downloadlib.addownload.d.xr()) {
                com.ss.android.downloadlib.addownload.d.ms(downloadInfo.getId());
            }
        }
        com.ss.android.socialbase.downloader.ms.ms.ms().ms(new com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms() { // from class: com.ss.android.downloadlib.ah.3
            @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
            public void ah() {
            }

            @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
            public void xr() {
                if (!zb.xr(xrVar)) {
                    long j = jMs;
                    if (j <= -1 || totalBytes <= -1 || j >= d) {
                        return;
                    }
                    com.ss.android.downloadlib.d.ms.ms().ms("clean_space_install", com.ss.android.downloadlib.addownload.d.ms("install_no_enough_space"), xrVar);
                    if (com.ss.android.downloadlib.addownload.d.ms(downloadInfo, ((long) d) - jMs)) {
                        com.ss.android.socialbase.downloader.ms.ms.ms().xr(this);
                        xrVar.ab(true);
                        return;
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.ms.ms.ms().xr(this);
            }
        });
    }

    private void ms(DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.ab.ka.c(downloadInfo.getId())) {
            ka.ms().xr(new com.ss.android.downloadlib.addownload.ah.xr(downloadInfo));
        }
    }
}
