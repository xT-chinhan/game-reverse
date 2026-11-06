package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.basead.exoplayer.i.a;
import com.anythink.core.common.e.m;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kwad.library.solder.lib.ext.PluginError;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.downloadlib.addownload.sl;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.tapsdk.tapad.internal.tracker.experiment.h.f;
import com.taptap.sdk.db.constant.Common;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ms implements com.ss.android.downloadad.api.ms, com.ss.android.socialbase.appdownloader.xr.ah, p, com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms {
    private static volatile ms d = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f4502ms = "ms";
    private xr ah;
    private long xr;

    private ms() {
        com.ss.android.socialbase.appdownloader.xr.ms(this);
        com.ss.android.socialbase.downloader.ms.ms.ms().ms(this);
    }

    public static ms ms() {
        if (d == null) {
            synchronized (ms.class) {
                if (d == null) {
                    d = new ms();
                }
            }
        }
        return d;
    }

    public static synchronized void ms(DownloadInfo downloadInfo, com.ss.android.downloadad.api.ms.xr xrVar) {
        try {
            if (downloadInfo == null) {
                com.ss.android.downloadlib.ka.ah.ms().ms("onDownloadFinish info null");
                return;
            }
            if (xrVar == null) {
                com.ss.android.downloadlib.ka.ah.ms().ms("onDownloadFinish nativeModel null");
                return;
            }
            if (xrVar.pc() != 1) {
                return;
            }
            com.ss.android.downloadlib.ah.x.ms().d(xrVar);
            String strAh = ah(downloadInfo, xrVar);
            com.ss.android.downloadlib.addownload.xr.c.ms().xr(downloadInfo.getUrl(), strAh);
            Map<Long, com.ss.android.downloadad.api.ms.xr> mapMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo.getUrl(), strAh);
            xrVar.c(System.currentTimeMillis());
            xrVar.ka(2);
            xrVar.xr(strAh);
            mapMs.put(Long.valueOf(xrVar.xr()), xrVar);
            com.ss.android.downloadlib.addownload.xr.ny.ms().ms(mapMs.values());
            ms(xrVar);
            x.ms().ms(downloadInfo, strAh);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                if (com.ss.android.downloadlib.ab.ka.ms((com.ss.android.downloadad.api.ms.ms) xrVar).ms("enable_app_install_receiver", 1) != 1 && hi.ny().optInt("enable_app_install_receiver", 1) != 1) {
                    sl.ms().ms(xrVar);
                }
                ms().xr(downloadInfo, xrVar);
                if (xrVar.m()) {
                    com.ss.android.downloadlib.addownload.ms.ms.ms().ms(downloadInfo.getId(), xrVar.xr(), xrVar.sl(), strAh, downloadInfo.getTitle(), xrVar.d(), downloadInfo.getTargetFilePath());
                }
                xrVar.xr();
                xrVar.d();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void ms(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (zb.xr()) {
            throw new RuntimeException("handleAppInstalled in main thread.");
        }
        final com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(str);
        if (xrVarMs == null) {
            com.ss.android.downloadlib.addownload.xr.d.ms().ms(str);
            return;
        }
        com.ss.android.downloadlib.addownload.ka kaVarMs = x.ms().ms(xrVarMs.ms());
        if (kaVarMs != null) {
            kaVarMs.c();
        }
        if (xrVarMs.ah.get()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.ab.ms.ms(xrVarMs.y()).xr("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.xr.ms().c(xrVarMs.y());
        }
        new com.ss.android.downloadlib.xr.xr().ms(xrVarMs, new com.ss.android.downloadlib.xr.ab() { // from class: com.ss.android.downloadlib.ms.1
            @Override // com.ss.android.downloadlib.xr.ab
            public void ms(boolean z) {
                com.ss.android.socialbase.downloader.ah.ms.xr(ms.f4502ms, "appBackForeground->".concat(String.valueOf(z)));
                if (z) {
                    if (!(com.ss.android.downloadlib.xr.c.ah(xrVarMs) ? com.ss.android.downloadlib.xr.ms.ms(str, xrVarMs) : false) && com.ss.android.downloadlib.xr.c.d(xrVarMs) && xrVarMs.az() == 4) {
                        com.ss.android.downloadlib.addownload.ms.ms.ms().ms(xrVarMs);
                        return;
                    }
                    return;
                }
                if (com.ss.android.downloadlib.xr.ms.ms(str, xrVarMs) || xrVarMs.az() != 4) {
                    return;
                }
                com.ss.android.downloadlib.addownload.ms.ms.ms().ms(xrVarMs);
            }
        }, com.ss.android.downloadlib.ab.ka.ms((com.ss.android.downloadad.api.ms.ms) xrVarMs).ms("try_applink_delay_after_installed", 0));
        com.ss.android.downloadlib.ah.x.ms().c(xrVarMs);
        ms(str, xrVarMs);
        com.ss.android.downloadlib.addownload.ms.ms.ms().xr(str);
        DownloadInfo downloadInfoMs = ms((List<DownloadInfo>) Downloader.getInstance(hi.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive"), str);
        if (downloadInfoMs != null) {
            if (com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfoMs.getId()).xr("no_hide_notification") != 1) {
                com.ss.android.socialbase.downloader.notification.xr.ms().ms(downloadInfoMs.getId());
            }
            x.ms().xr(downloadInfoMs, str);
            com.ss.android.downloadlib.addownload.ah.d.ms(downloadInfoMs);
            return;
        }
        x.ms().xr(null, str);
    }

    void ms(DownloadInfo downloadInfo, com.ss.android.downloadad.api.ms.xr xrVar, int i) {
        long jMax;
        if (downloadInfo == null || xrVar == null) {
            return;
        }
        d();
        long jCurrentTimeMillis = System.currentTimeMillis();
        xrVar.xr(jCurrentTimeMillis);
        xrVar.ab(zb.ms(Environment.getDataDirectory(), -1L));
        if (i != 2000) {
            jMax = a.f;
        } else {
            long jMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("check_install_failed_delay_time", 120000L);
            if (jMs < 0) {
                return;
            } else {
                jMax = Math.max(jMs, 30000L);
            }
        }
        long j = jMax;
        xr xrVar2 = new xr(xrVar.xr(), downloadInfo.getId(), jCurrentTimeMillis, i);
        ka.ms().ms(xrVar2, j);
        this.ah = xrVar2;
        com.ss.android.downloadlib.addownload.xr.ny.ms().ms(xrVar);
    }

    private static class xr implements Runnable {
        private long ah;
        private int d;
        private long ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private long f4508ms;
        private int xr;

        private xr(long j, int i, long j2, int i2) {
            this.f4508ms = j;
            this.xr = i;
            this.ah = j2;
            this.d = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xr() {
            this.ka = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (ms()) {
                    ms.ms().ms(this.f4508ms, this.xr);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00ad A[Catch: Exception -> 0x00f1, TryCatch #1 {Exception -> 0x00f1, blocks: (B:24:0x008c, B:26:0x00ad, B:31:0x00c0, B:34:0x00cd, B:39:0x00dc, B:42:0x00ed), top: B:54:0x008c }] */
        /* JADX WARN: Code duplicated, block: B:29:0x00bc  */
        /* JADX WARN: Code duplicated, block: B:30:0x00bf  */
        /* JADX WARN: Code duplicated, block: B:37:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:38:0x00db  */
        /* JADX WARN: Code duplicated, block: B:41:0x00eb  */
        boolean ms() {
            DownloadInfo downloadInfo;
            double d;
            boolean zMs;
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i;
            int i2;
            com.ss.android.downloadad.api.ms.xr xrVarD = com.ss.android.downloadlib.addownload.xr.c.ms().d(this.f4508ms);
            boolean z = false;
            if (xrVarD == null || zb.xr(xrVarD) || xrVarD.ah.get() || (downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(xrVarD.y())) == null) {
                return false;
            }
            long jLm = xrVarD.lm();
            long jMs = zb.ms(Environment.getDataDirectory());
            long jMin = Math.min(524288000L, jMs / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = totalBytes;
            double d3 = jMin + (2.5d * d2);
            try {
                try {
                    if (jLm > -1 && totalBytes > -1) {
                        d = d2;
                        if (jLm >= d3) {
                        }
                        zMs = com.ss.android.socialbase.appdownloader.xr.ms(hi.getContext());
                        jSONObject = new JSONObject();
                        int iMs = ms(z, xrVarD, downloadInfo, zMs, jSONObject);
                        this.d = iMs;
                        jSONObject2 = jSONObject;
                        jSONObject2.putOpt("fail_status", Integer.valueOf(iMs));
                        jSONObject2.putOpt("available_space", Long.valueOf(jLm / BaseConstants.MB_VALUE));
                        jSONObject2.putOpt("total_space", Long.valueOf(jMs / BaseConstants.MB_VALUE));
                        if (totalBytes > 0) {
                            jSONObject2.putOpt(NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, Long.valueOf(totalBytes / BaseConstants.MB_VALUE));
                        }
                        if (z) {
                            i = 1;
                        } else {
                            i = 2;
                        }
                        jSONObject2.putOpt("space_enough", Integer.valueOf(i));
                        if (jLm > 0 && totalBytes > 0) {
                            jSONObject2.put("available_space_ratio", jLm / d);
                        }
                        if (zMs) {
                            i2 = 1;
                        } else {
                            i2 = 2;
                        }
                        jSONObject2.putOpt("permission_unknown_source_install", Integer.valueOf(i2));
                        jSONObject2.put("is_update_download", xrVarD.am() ? 1 : 2);
                        com.ss.android.downloadlib.d.ms.ms().xr("install_failed", jSONObject2, xrVarD);
                        return true;
                    }
                    d = d2;
                    jSONObject2.putOpt("fail_status", Integer.valueOf(iMs));
                    jSONObject2.putOpt("available_space", Long.valueOf(jLm / BaseConstants.MB_VALUE));
                    jSONObject2.putOpt("total_space", Long.valueOf(jMs / BaseConstants.MB_VALUE));
                    if (totalBytes > 0) {
                        jSONObject2.putOpt(NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, Long.valueOf(totalBytes / BaseConstants.MB_VALUE));
                    }
                    if (z) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    jSONObject2.putOpt("space_enough", Integer.valueOf(i));
                    if (jLm > 0) {
                        jSONObject2.put("available_space_ratio", jLm / d);
                    }
                    if (zMs) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    jSONObject2.putOpt("permission_unknown_source_install", Integer.valueOf(i2));
                    jSONObject2.put("is_update_download", xrVarD.am() ? 1 : 2);
                } catch (Exception e) {
                    e = e;
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
                jSONObject2 = jSONObject;
            } catch (Exception e2) {
                e = e2;
                jSONObject2 = jSONObject;
            }
            z = true;
            zMs = com.ss.android.socialbase.appdownloader.xr.ms(hi.getContext());
            jSONObject = new JSONObject();
            int iMs2 = ms(z, xrVarD, downloadInfo, zMs, jSONObject);
            this.d = iMs2;
            com.ss.android.downloadlib.d.ms.ms().xr("install_failed", jSONObject2, xrVarD);
            return true;
        }

        private int ms(boolean z, com.ss.android.downloadad.api.ms.xr xrVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId());
            int i = 1;
            if (msVarMs.ms("install_failed_check_ttmd5", 1) == 1) {
                int iCheckMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", iCheckMd5Status);
                } catch (Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.ny.c.ms(iCheckMd5Status)) {
                    return 2005;
                }
            }
            int i2 = this.d;
            if (i2 != 2000) {
                return i2;
            }
            if (msVarMs.ms("install_failed_check_signature", 1) == 1 && zb.ka(hi.getContext(), xrVar.ka())) {
                if (!zb.ms(zb.ny(hi.getContext(), downloadInfo.getTargetFilePath()), zb.x(hi.getContext(), xrVar.ka()))) {
                    return PluginError.ERROR_UPD_REQUEST;
                }
            }
            if (!z) {
                return 2002;
            }
            long j = this.ka;
            long j2 = this.ah;
            if (j <= j2) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j - j2);
                if (xrVar.cv() <= this.ah) {
                    i = 0;
                }
                jSONObject.put("install_again", i);
            } catch (Throwable unused2) {
            }
            return !z2 ? 2003 : 2004;
        }
    }

    public void ms(final long j, int i) {
        long jMs = com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("check_install_finish_hijack_delay_time", 900000L);
        if (jMs < 0) {
            return;
        }
        ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.ms.2
            @Override // java.lang.Runnable
            public void run() {
                ms.ms().ms(j);
            }
        }, Math.max(jMs, 300000L));
    }

    public void ms(long j) {
        com.ss.android.downloadlib.addownload.xr.d.ms msVarMs;
        int iIntValue;
        try {
            com.ss.android.downloadad.api.ms.xr xrVarD = com.ss.android.downloadlib.addownload.xr.c.ms().d(j);
            if (xrVarD != null && !zb.xr(xrVarD) && !xrVarD.ah.get()) {
                Pair<com.ss.android.downloadlib.addownload.xr.d.ms, Integer> pairXr = com.ss.android.downloadlib.addownload.xr.d.ms().xr(xrVarD);
                if (pairXr != null) {
                    msVarMs = (com.ss.android.downloadlib.addownload.xr.d.ms) pairXr.first;
                    iIntValue = ((Integer) pairXr.second).intValue();
                } else {
                    msVarMs = com.ss.android.downloadlib.addownload.xr.d.ms().ms(xrVarD);
                    iIntValue = -1;
                }
                if (msVarMs == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.xr.d.ms().xr(msVarMs.f4453ms);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", msVarMs.d);
                jSONObject.put("installed_pkg_name", msVarMs.f4453ms);
                if (iIntValue != -1) {
                    jSONObject.put("error_code", iIntValue);
                    com.ss.android.downloadlib.ab.c.ms(jSONObject, xrVarD.y());
                    com.ss.android.downloadlib.d.ms.ms().xr("install_finish_hijack", jSONObject, xrVarD);
                    return;
                }
                com.ss.android.downloadlib.d.ms.ms().xr("install_finish_may_hijack", jSONObject, xrVarD);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.ka.ah.ms().ms(th, "trySendInstallFinishHijack");
        }
    }

    public void ms(String str, com.ss.android.downloadad.api.ms.xr xrVar) {
        if (xrVar != null && zb.xr(xrVar) && xrVar.ah.compareAndSet(false, true)) {
            com.ss.android.downloadlib.d.ms.ms().ms(xrVar.ch(), "install_finish", ms(xrVar, str, xrVar.az() != 4 ? 3 : 4), xrVar);
            com.ss.android.downloadlib.addownload.xr.ny.ms().ms(xrVar);
        }
    }

    private static DownloadInfo ms(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (zb.ms(hi.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject ms(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i = 1;
            if (com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put(Common.System.NAME, downloadInfo.getName());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.put("current_network_quality", com.ss.android.socialbase.downloader.network.hi.ms().xr().name());
                jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put(m.b.h, downloadInfo.getRetryCount());
                jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put("total_retry_count", downloadInfo.getTotalRetryCount());
                jSONObject.put("cur_retry_time_in_total", downloadInfo.getCurRetryTimeInTotal());
                jSONObject.put("real_download_time", downloadInfo.getRealDownloadTime());
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                jSONObject.put("chunk_downgrade_retry_used", downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                jSONObject.put("need_chunk_downgrade_retry", downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                jSONObject.put("preconnect_level", downloadInfo.getPreconnectLevel());
                jSONObject.put("md5", downloadInfo.getMd5());
                jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                if (curBytes > 0.0d && realDownloadTime > 0.0d) {
                    double d2 = curBytes / realDownloadTime;
                    try {
                        jSONObject.put("download_speed", d2);
                    } catch (Exception unused) {
                    }
                    com.ss.android.socialbase.downloader.ah.ms.xr(f4502ms, "download speed : " + d2 + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", Downloader.getInstance(hi.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                    jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.ah.d.ms().xr(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!com.ss.android.socialbase.downloader.ny.c.ah(hi.getContext())) {
                    i = 2;
                }
                jSONObject.put("network_available", i);
                jSONObject.put(f.z, downloadInfo.getHttpStatusCode());
                xr(jSONObject, downloadInfo);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        }
        return jSONObject;
    }

    public static JSONObject xr(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long jXr = zb.xr(0L);
            double d2 = jXr;
            jSONObject.put("available_space", d2 / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d3 = totalBytes;
            jSONObject.put("apk_size", d3 / 1048576.0d);
            if (jXr > 0 && totalBytes > 0) {
                jSONObject.put("available_space_ratio", d2 / d3);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        return jSONObject;
    }

    public void xr(DownloadInfo downloadInfo, final com.ss.android.downloadad.api.ms.xr xrVar) {
        if (downloadInfo == null || xrVar == null || com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        ka.ms().xr(new Runnable() { // from class: com.ss.android.downloadlib.ms.3
            @Override // java.lang.Runnable
            public void run() {
                String strMs = com.ss.android.downloadlib.ab.ms.ms(targetFilePath);
                if (TextUtils.isEmpty(strMs)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.ats.ah.ms(hi.getContext(), "sp_ttdownloader_md5", 0).edit().putString(String.valueOf(xrVar.xr()), strMs).apply();
            }
        });
    }

    private static void ms(com.ss.android.downloadad.api.ms.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        String strEg = TextUtils.isEmpty(xrVar.eg()) ? "" : xrVar.eg();
        DownloadInfo downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(xrVar.y());
        xrVar.sl("");
        com.ss.android.downloadlib.addownload.xr.ny.ms().ms(xrVar);
        JSONObject jSONObjectMs = ms(new JSONObject(), downloadInfo);
        int i = 1;
        try {
            jSONObjectMs.putOpt("finish_reason", strEg);
            jSONObjectMs.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo);
        com.ss.android.downloadlib.ab.c.ms(jSONObjectMs, downloadInfo.getId());
        try {
            jSONObjectMs.put("download_failed_times", xrVarMs.i());
            jSONObjectMs.put("can_show_notification", com.ss.android.socialbase.appdownloader.ka.d.ms() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                jSONObjectMs.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            jSONObjectMs.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            jSONObjectMs.put("has_send_download_failed_finally", xrVarMs.d.get() ? 1 : 2);
            if (!xrVarMs.am()) {
                i = 2;
            }
            jSONObjectMs.put("is_update_download", i);
            com.ss.android.downloadlib.ab.c.ms(xrVarMs, jSONObjectMs);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        com.ss.android.downloadlib.d.ms.ms().xr("download_finish", jSONObjectMs, xrVar);
    }

    private int ms(com.ss.android.downloadad.api.ms.xr xrVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int iXr = com.ss.android.socialbase.appdownloader.ah.xr(hi.getContext(), downloadInfo);
        int iXr2 = zb.xr(hi.getContext(), str);
        if (iXr > 0 && iXr2 > 0 && iXr != iXr2) {
            return iXr2 > iXr ? 3011 : 3010;
        }
        if (com.ss.android.socialbase.downloader.ab.ms.ms(xrVar.y()).ms("install_finish_check_ttmd5", 1) != 1) {
            return 3001;
        }
        String string = com.bytedance.sdk.openadsdk.ats.ah.ms(hi.getContext(), "sp_ttdownloader_md5", 0).getString(String.valueOf(xrVar.xr()), null);
        if (TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.ss.android.downloadlib.ab.ms.ms(downloadInfo.getTargetFilePath());
        }
        int iMs = com.ss.android.downloadlib.ab.ms.ms(string, com.ss.android.downloadlib.ab.ms.xr(str));
        try {
            jSONObject.put("ttmd5_status", iMs);
        } catch (Throwable unused) {
        }
        if (iMs == 0) {
            return 3000;
        }
        return iMs == 1 ? 3002 : 3001;
    }

    public static String ah(DownloadInfo downloadInfo, com.ss.android.downloadad.api.ms.xr xrVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = hi.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.ah.ms());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", downloadInfo.getPackageName());
            } catch (JSONException e2) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e2);
            }
            com.ss.android.downloadlib.d.ms.ms().ms("embeded_ad", "package_name_error", jSONObject, xrVar);
            return str;
        }
        return downloadInfo.getPackageName();
    }

    @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
    public void xr() {
        com.ss.android.socialbase.downloader.ah.ms.xr(f4502ms, "onAppForeground()");
        d();
        ms(5);
    }

    @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
    public void ah() {
        com.ss.android.socialbase.downloader.ah.ms.xr(f4502ms, "onAppBackground()");
        ms(6);
    }

    synchronized void d() {
        xr xrVar = this.ah;
        if (xrVar != null) {
            xrVar.xr();
            this.ah = null;
        }
    }

    @Override // com.ss.android.downloadad.api.ms
    public void ms(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.xr < 120000) {
            return;
        }
        ka.ms().ms(new RunnableC0538ms(i), this.xr > 0 ? a.f : 8000L);
        this.xr = jCurrentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(ConcurrentHashMap<Long, com.ss.android.downloadad.api.ms.xr> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.ms.xr xrVar : concurrentHashMap.values()) {
            if (xrVar.ah.get()) {
                if (jCurrentTimeMillis - xrVar.jw() >= com.ss.android.socialbase.downloader.ab.ms.ms(xrVar.y()).ms("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(xrVar.xr()));
                }
            } else if (xrVar.pc() == 1) {
                if (xr(xrVar) <= 0 && jCurrentTimeMillis - xrVar.jw() >= com.ss.android.socialbase.downloader.ab.ms.ms(xrVar.y()).ms("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(xrVar.xr()));
                }
            } else if (xrVar.pc() == 2) {
                if (!xrVar.ti()) {
                    if (zb.xr(xrVar)) {
                        if (xrVar.az() == 4) {
                            i = xrVar.az();
                        }
                        xrVar.ch(false);
                        com.ss.android.downloadlib.d.ms.ms().ms(ms(xrVar, xrVar.ka(), i), xrVar);
                        arrayList.add(Long.valueOf(xrVar.xr()));
                        com.ss.android.downloadlib.addownload.ah.d.ms(xrVar);
                    } else if (xrVar.ti() && xrVar.az() == 4 && i == 1 && !zb.xr(xrVar)) {
                        com.ss.android.downloadlib.ab.sl.ms().ms(f4502ms, "trySendAndRefreshAdEvent", "命中兜底逻辑,尝试对广播监听执行冷启兜底逻辑");
                        ny.ms().ms(xrVar);
                    } else if (jCurrentTimeMillis - xrVar.jw() >= com.ss.android.socialbase.downloader.ab.ms.ms(xrVar.y()).ms("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(xrVar.xr()));
                    } else if (TextUtils.isEmpty(xrVar.ka())) {
                        arrayList.add(Long.valueOf(xrVar.xr()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(xrVar.xr()));
            }
        }
        com.ss.android.downloadlib.addownload.xr.c.ms().ms(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.xr.ah
    public void ms(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.ms msVar) {
        JSONObject jSONObjectXr;
        if (downloadInfo == null || msVar == null) {
            return;
        }
        JSONArray jSONArrayKa = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ka("ah_report_config");
        if (msVar.xr != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (jSONArrayKa == null || (jSONObjectXr = xr(downloadInfo, msVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", jSONObjectXr);
    }

    @Override // com.ss.android.socialbase.downloader.depend.p
    public void ms(final DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.ka.ah.ms().ms("info is null");
        } else if ((com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo).xr("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.ss.android.downloadlib.xr.ka.ms().xr(new com.ss.android.downloadlib.xr.d() { // from class: com.ss.android.downloadlib.ms.4
                @Override // com.ss.android.downloadlib.xr.d
                public void ms(boolean z) {
                    if (!z) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.ss.android.socialbase.appdownloader.ah.ms(hi.getContext(), intent);
                            zb.ms(jSONObject, LiveConfigKey.BACKUP, (Object) 1);
                        } else {
                            zb.ms(jSONObject, LiveConfigKey.BACKUP, (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo);
                    if (xrVarMs != null) {
                        com.ss.android.downloadlib.d.ms.ms().ms(z ? "installer_delay_success" : "installer_delay_failed", jSONObject, xrVarMs);
                    } else {
                        com.ss.android.downloadlib.ka.ah.ms().xr("ah nativeModel=null");
                    }
                    if (z) {
                        hi.nw();
                        hi.getContext();
                    }
                }
            });
        }
    }

    private int xr(com.ss.android.downloadad.api.ms.xr xrVar) {
        int realStatus;
        double dMs = com.ss.android.socialbase.downloader.ab.ms.ms(xrVar.y()).ms("download_failed_finally_hours", 48.0d);
        if (dMs <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - xrVar.jw() < dMs * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (xrVar.d.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(xrVar.y());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && xrVar.d.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                ms(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(xrVar.of()));
                jSONObject.putOpt("fail_msg", xrVar.p());
                jSONObject.put("download_failed_times", xrVar.i());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put("is_update_download", xrVar.am() ? 1 : 2);
                com.ss.android.downloadlib.d.ms.ms().ms(xrVar.ch(), "download_failed_finally", jSONObject, xrVar);
                com.ss.android.downloadlib.addownload.xr.ny.ms().ms(xrVar);
                return 0;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        }
        return 1;
    }

    private JSONObject xr(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.ms msVar) {
        com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo);
        if (xrVarMs == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        msVar.ms(jSONObject);
        try {
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put(Common.System.NAME, downloadInfo.getName());
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        com.ss.android.downloadlib.ab.c.ms(jSONObject, downloadInfo.getId());
        com.ss.android.downloadlib.d.ms.ms().ms("embeded_ad", "ah_result", jSONObject, xrVarMs);
        return jSONObject;
    }

    /* JADX INFO: renamed from: com.ss.android.downloadlib.ms$ms, reason: collision with other inner class name */
    private class RunnableC0538ms implements Runnable {
        private final int xr;

        public RunnableC0538ms(int i) {
            this.xr = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.xr.c.ms().xr();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.ms.xr> concurrentHashMapAh = com.ss.android.downloadlib.addownload.xr.c.ms().ah();
                if (concurrentHashMapAh == null || concurrentHashMapAh.isEmpty()) {
                    return;
                }
                ms.this.ms(concurrentHashMapAh, this.xr);
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
    }

    private JSONObject ms(com.ss.android.downloadad.api.ms.xr xrVar, String str, int i) {
        com.ss.android.socialbase.appdownloader.ms msVarMs;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(xrVar.y());
            jSONObject.putOpt(com.umeng.ccg.a.j, Integer.valueOf(i));
            com.ss.android.downloadlib.ab.c.ms(jSONObject, xrVar.y());
            com.ss.android.downloadlib.ab.c.ms(xrVar, jSONObject);
            jSONObject.put("is_update_download", xrVar.am() ? 1 : 2);
            jSONObject.put("install_after_back_app", xrVar.qk() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", xrVar.xn() ? "1" : "2");
            if (downloadInfo != null) {
                ms(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (xrVar.cv() > 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - xrVar.cv();
                        jSONObject.put("install_time", jCurrentTimeMillis);
                        if (jCurrentTimeMillis > com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String strMs = com.ss.android.socialbase.downloader.ny.c.ms(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(strMs) && (msVarMs = com.ss.android.socialbase.appdownloader.ms.ms(strMs)) != null) {
                    msVarMs.ms(jSONObject);
                }
            }
            int iMs = ms(xrVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", iMs);
            if (iMs == 3000) {
                jSONObject.put("hijack", 2);
            } else if (iMs == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        return jSONObject;
    }

    public void ms(DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo);
        if (xrVarMs == null) {
            com.ss.android.downloadlib.ka.ah.ms().ms("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j2 - j) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j3 - j2) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            com.ss.android.downloadlib.ab.c.ah(downloadInfo, jSONObject);
            com.ss.android.downloadlib.d.ms.ms().ms("cleanup", jSONObject, xrVarMs);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }
}
