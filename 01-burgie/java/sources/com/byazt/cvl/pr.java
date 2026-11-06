package com.byazt.cvl;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.eld.m;
import com.byazt.eld.w;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fn.ww;
import com.byazt.lj.Downloader;
import com.byazt.mrs.DownloadStatus;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.qq.e.comm.constants.ErrorCode;
import com.tapsdk.tapad.internal.Constants;
import com.tapsdk.tapad.internal.runtime.download.ApkNotificationReceiver;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.time.TapTime;
import com.taptap.sdk.update.download.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, 37})
public class pr implements com.byazt.wqt.pr, com.byazt.mdu.hw.hn, ww, com.byazt.wel.pr.InterfaceC0223pr {
    public static String pr = pr.class.getSimpleName();
    public static volatile pr x;
    public hw hn;
    public long hw;

    private pr() {
        com.byazt.mdu.hw.pr(this);
        com.byazt.wel.pr.pr().pr(this);
    }

    public static pr pr() {
        if (x == null) {
            synchronized (pr.class) {
                if (x == null) {
                    x = new pr();
                }
            }
        }
        return x;
    }

    public static synchronized void pr(DownloadInfo downloadInfo, com.byazt.tia.hw hwVar) {
        try {
            if (downloadInfo == null) {
                com.byazt.vi.hn.pr().pr("onDownloadFinish info null");
                return;
            }
            if (hwVar == null) {
                com.byazt.vi.hn.pr().pr("onDownloadFinish nativeModel null");
                return;
            }
            if (hwVar.n() != 1) {
                return;
            }
            com.byazt.sxm.zo.pr().x(hwVar);
            String strHn = hn(downloadInfo, hwVar);
            com.byazt.shh.uc.pr().hw(downloadInfo.getUrl(), strHn);
            Map<Long, com.byazt.tia.hw> mapPr = com.byazt.shh.uc.pr().pr(downloadInfo.getUrl(), strHn);
            hwVar.uc(System.currentTimeMillis());
            hwVar.c(2);
            hwVar.hw(strHn);
            mapPr.put(Long.valueOf(hwVar.hw()), hwVar);
            com.byazt.shh.aj.pr().pr(mapPr.values());
            pr(hwVar);
            w.pr().hw(hwVar.cz(), downloadInfo);
            hwVar.k(System.currentTimeMillis());
            zo.pr().pr(downloadInfo, strHn);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                if (com.byazt.uk.c.pr((com.byazt.tia.pr) hwVar).pr("enable_app_install_receiver", 1) != 1 && k.aj().optInt("enable_app_install_receiver", 1) != 1) {
                    m.pr().pr(hwVar);
                }
                pr().hw(downloadInfo, hwVar);
                if (hwVar.v()) {
                    com.byazt.wc.pr.pr().pr(downloadInfo.getId(), hwVar.hw(), hwVar.k(), strHn, downloadInfo.getTitle(), hwVar.x(), downloadInfo.getTargetFilePath());
                }
                hwVar.hw();
                hwVar.x();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void pr(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.byazt.uk.m.hw()) {
            throw new RuntimeException("handleAppInstalled in main thread.");
        }
        final com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(str);
        if (hwVarPr == null) {
            com.byazt.shh.x.pr().pr(str);
            return;
        }
        com.byazt.eld.c cVarPr = zo.pr().pr(hwVarPr.pr());
        if (cVarPr != null) {
            cVarPr.uc();
        }
        if (hwVarPr.hn.get()) {
            return;
        }
        if (com.byazt.ew.pr.pr(hwVarPr.qa()).hw("notification_opt_2") == 1) {
            com.byazt.lxs.hw.pr().uc(hwVarPr.qa());
        }
        new com.byazt.ds.hw().pr(hwVarPr, new com.byazt.ds.fw() { // from class: com.byazt.cvl.pr.1
            @Override // com.byazt.ds.fw
            public void pr(boolean z) {
                com.byazt.p000do.pr.hw(pr.pr, "appBackForeground->".concat(String.valueOf(z)));
                if (z) {
                    boolean zPr = false;
                    if (com.byazt.ds.uc.hn(hwVarPr)) {
                        zPr = com.byazt.ds.pr.pr(str, hwVarPr);
                    }
                    if (!zPr && com.byazt.ds.uc.x(hwVarPr) && hwVarPr.er() == 4) {
                        com.byazt.wc.pr.pr().pr(hwVarPr);
                        return;
                    }
                    return;
                }
                if (!com.byazt.ds.pr.pr(str, hwVarPr) && hwVarPr.er() == 4) {
                    com.byazt.wc.pr.pr().pr(hwVarPr);
                }
            }
        }, com.byazt.uk.c.pr((com.byazt.tia.pr) hwVarPr).pr("try_applink_delay_after_installed", 0));
        com.byazt.sxm.zo.pr().uc(hwVarPr);
        pr(str, hwVarPr);
        com.byazt.wc.pr.pr().hw(str);
        DownloadInfo downloadInfoPr = pr((List<DownloadInfo>) Downloader.getInstance(k.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK), str);
        if (downloadInfoPr != null) {
            if (com.byazt.ew.pr.pr(downloadInfoPr.getId()).hw("no_hide_notification") != 1) {
                com.byazt.lxs.hw.pr().pr(downloadInfoPr.getId());
            }
            zo.pr().hw(downloadInfoPr, str);
            com.byazt.ute.x.pr(downloadInfoPr);
            return;
        }
        zo.pr().hw(null, str);
    }

    public void pr(DownloadInfo downloadInfo, com.byazt.tia.hw hwVar, int i) {
        long jMax;
        if (downloadInfo == null || hwVar == null) {
            return;
        }
        x();
        long jCurrentTimeMillis = System.currentTimeMillis();
        hwVar.hw(jCurrentTimeMillis);
        hwVar.fw(com.byazt.uk.m.pr(Environment.getDataDirectory(), -1L));
        if (i != 2000) {
            jMax = 2000;
        } else {
            long jPr = com.byazt.ew.pr.pr(downloadInfo.getId()).pr("check_install_failed_delay_time", 120000L);
            if (jPr < 0) {
                return;
            } else {
                jMax = Math.max(jPr, 30000L);
            }
        }
        hw hwVar2 = new hw(hwVar.hw(), downloadInfo.getId(), jCurrentTimeMillis, i);
        c.pr().pr(hwVar2, jMax);
        this.hn = hwVar2;
        com.byazt.shh.aj.pr().pr(hwVar);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    private static class hw implements Runnable {
        public long c;
        public long hn;
        public int hw;
        public long pr;
        public int x;

        private hw(long j, int i, long j2, int i2) {
            this.pr = j;
            this.hw = i;
            this.hn = j2;
            this.x = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void hw() {
            this.c = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (pr()) {
                    pr.pr().pr(this.pr, this.hw);
                }
            } catch (Throwable th) {
            }
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00ae A[Catch: Exception -> 0x00f2, TryCatch #1 {Exception -> 0x00f2, blocks: (B:24:0x008d, B:26:0x00ae, B:31:0x00c1, B:34:0x00ce, B:39:0x00dd, B:42:0x00ee), top: B:53:0x008d }] */
        /* JADX WARN: Code duplicated, block: B:29:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:30:0x00c0  */
        /* JADX WARN: Code duplicated, block: B:37:0x00d9  */
        /* JADX WARN: Code duplicated, block: B:38:0x00dc  */
        /* JADX WARN: Code duplicated, block: B:41:0x00ec  */
        public boolean pr() {
            DownloadInfo downloadInfo;
            double d;
            boolean zPr;
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i;
            int i2;
            com.byazt.tia.hw hwVarX = com.byazt.shh.uc.pr().x(this.pr);
            boolean z = false;
            if (hwVarX == null || com.byazt.uk.m.hw(hwVarX) || hwVarX.hn.get() || (downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(hwVarX.qa())) == null) {
                return false;
            }
            long jQi = hwVarX.qi();
            long jPr = com.byazt.uk.m.pr(Environment.getDataDirectory());
            long jMin = Math.min(524288000L, jPr / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = totalBytes;
            double d3 = jMin + (2.5d * d2);
            try {
                try {
                    if (jQi <= -1 || totalBytes <= -1) {
                        d = d2;
                    } else {
                        d = d2;
                        if (jQi >= d3) {
                        }
                        zPr = com.byazt.mdu.hw.pr(k.getContext());
                        jSONObject = new JSONObject();
                        int iPr = pr(z, hwVarX, downloadInfo, zPr, jSONObject);
                        this.x = iPr;
                        jSONObject2 = jSONObject;
                        jSONObject2.putOpt("fail_status", Integer.valueOf(iPr));
                        jSONObject2.putOpt("available_space", Long.valueOf(jQi / 1048576));
                        jSONObject2.putOpt("total_space", Long.valueOf(jPr / 1048576));
                        if (totalBytes > 0) {
                            jSONObject2.putOpt(NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, Long.valueOf(totalBytes / 1048576));
                        }
                        if (z) {
                            i = 1;
                        } else {
                            i = 2;
                        }
                        jSONObject2.putOpt("space_enough", Integer.valueOf(i));
                        if (jQi > 0 && totalBytes > 0) {
                            jSONObject2.put("available_space_ratio", jQi / d);
                        }
                        if (zPr) {
                            i2 = 1;
                        } else {
                            i2 = 2;
                        }
                        jSONObject2.putOpt("permission_unknown_source_install", Integer.valueOf(i2));
                        jSONObject2.put("is_update_download", hwVarX.o() ? 1 : 2);
                        com.byazt.mf.pr.pr().hw("install_failed", jSONObject2, hwVarX);
                        return true;
                    }
                    jSONObject2.putOpt("fail_status", Integer.valueOf(iPr));
                    jSONObject2.putOpt("available_space", Long.valueOf(jQi / 1048576));
                    jSONObject2.putOpt("total_space", Long.valueOf(jPr / 1048576));
                    if (totalBytes > 0) {
                        jSONObject2.putOpt(NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, Long.valueOf(totalBytes / 1048576));
                    }
                    if (z) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    jSONObject2.putOpt("space_enough", Integer.valueOf(i));
                    if (jQi > 0) {
                        jSONObject2.put("available_space_ratio", jQi / d);
                    }
                    if (zPr) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    jSONObject2.putOpt("permission_unknown_source_install", Integer.valueOf(i2));
                    jSONObject2.put("is_update_download", hwVarX.o() ? 1 : 2);
                } catch (Exception e) {
                }
                jSONObject2 = jSONObject;
            } catch (Exception e2) {
                jSONObject2 = jSONObject;
            }
            z = true;
            zPr = com.byazt.mdu.hw.pr(k.getContext());
            jSONObject = new JSONObject();
            int iPr2 = pr(z, hwVarX, downloadInfo, zPr, jSONObject);
            this.x = iPr2;
            com.byazt.mf.pr.pr().hw("install_failed", jSONObject2, hwVarX);
            return true;
        }

        private int pr(boolean z, com.byazt.tia.hw hwVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(downloadInfo.getId());
            int i = 1;
            if (prVarPr.pr("install_failed_check_ttmd5", 1) == 1) {
                int iCheckMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", iCheckMd5Status);
                } catch (Throwable th) {
                }
                if (!com.byazt.tuy.uc.pr(iCheckMd5Status)) {
                    return Constants.OAIDErrorCode.OAID_INVALID_RESULT;
                }
            }
            int i2 = this.x;
            if (i2 != 2000) {
                return i2;
            }
            if (prVarPr.pr("install_failed_check_signature", 1) == 1 && com.byazt.uk.m.c(k.getContext(), hwVar.c())) {
                if (!com.byazt.uk.m.pr(com.byazt.uk.m.aj(k.getContext(), downloadInfo.getTargetFilePath()), com.byazt.uk.m.zo(k.getContext(), hwVar.c()))) {
                    return 2006;
                }
            }
            if (!z) {
                return 2002;
            }
            long j = this.c;
            long j2 = this.hn;
            if (j <= j2) {
                return DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS;
            }
            try {
                jSONObject.put("install_time", j - j2);
                if (hwVar.gz() <= this.hn) {
                    i = 0;
                }
                jSONObject.put("install_again", i);
            } catch (Throwable th2) {
            }
            if (!z2) {
                return 2003;
            }
            return Constants.OAIDErrorCode.OAID_CLIENT_FETCH_INTERRUPTED;
        }
    }

    public void pr(final long j, int i) {
        long jPr = com.byazt.ew.pr.pr(i).pr("check_install_finish_hijack_delay_time", TapTime.MAX_SKEW_MS);
        if (jPr < 0) {
            return;
        }
        c.pr().pr(new Runnable() { // from class: com.byazt.cvl.pr.2
            @Override // java.lang.Runnable
            public void run() {
                pr.pr().pr(j);
            }
        }, Math.max(jPr, 300000L));
    }

    public void pr(long j) {
        com.byazt.shh.x.pr prVarPr;
        int iIntValue;
        try {
            com.byazt.tia.hw hwVarX = com.byazt.shh.uc.pr().x(j);
            if (hwVarX != null && !com.byazt.uk.m.hw(hwVarX) && !hwVarX.hn.get()) {
                Pair<com.byazt.shh.x.pr, Integer> pairHw = com.byazt.shh.x.pr().hw(hwVarX);
                if (pairHw != null) {
                    prVarPr = (com.byazt.shh.x.pr) pairHw.first;
                    iIntValue = ((Integer) pairHw.second).intValue();
                } else {
                    prVarPr = com.byazt.shh.x.pr().pr(hwVarX);
                    iIntValue = -1;
                }
                if (prVarPr == null) {
                    return;
                }
                com.byazt.shh.x.pr().hw(prVarPr.pr);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", prVarPr.x);
                jSONObject.put("installed_pkg_name", prVarPr.pr);
                if (iIntValue != -1) {
                    jSONObject.put(com.tapsdk.tapad.group.constants.Constants.ERROR_CODE_FIELD, iIntValue);
                    com.byazt.uk.uc.pr(jSONObject, hwVarX.qa());
                    com.byazt.mf.pr.pr().hw("install_finish_hijack", jSONObject, hwVarX);
                    return;
                }
                com.byazt.mf.pr.pr().hw("install_finish_may_hijack", jSONObject, hwVarX);
            }
        } catch (Throwable th) {
            com.byazt.vi.hn.pr().pr(th, "trySendInstallFinishHijack");
        }
    }

    public void pr(String str, com.byazt.tia.hw hwVar) {
        if (hwVar != null && com.byazt.uk.m.hw(hwVar) && hwVar.hn.compareAndSet(false, true)) {
            int i = 4;
            if (hwVar.er() == 4) {
                com.byazt.zv.vk vkVarNy = k.ny();
                if (vkVarNy != null) {
                    vkVarNy.pr(hwVar.cz());
                }
            } else {
                i = 3;
            }
            com.byazt.mf.pr.pr().pr(hwVar.vk(), "install_finish", pr(hwVar, str, i), hwVar);
            com.byazt.shh.aj.pr().pr(hwVar);
        }
    }

    private static DownloadInfo pr(List<DownloadInfo> list, String str) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        for (DownloadInfo downloadInfo : list) {
            if (downloadInfo != null) {
                if (str.equals(downloadInfo.getPackageName())) {
                    return downloadInfo;
                }
                if (com.byazt.uk.m.pr(k.getContext(), downloadInfo.getTargetFilePath(), str)) {
                    return downloadInfo;
                }
            }
        }
        return null;
    }

    public static JSONObject pr(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null) {
            return jSONObject;
        }
        int i = 1;
        if (com.byazt.ew.pr.pr(downloadInfo.getId()).pr("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            jSONObject.put(ApkNotificationReceiver.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put(Common.System.NAME, downloadInfo.getName());
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
            jSONObject.put("current_network_quality", com.byazt.edb.w.pr().hw().name());
            jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
            jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
            jSONObject.put("chunk_count", downloadInfo.getChunkCount());
            jSONObject.put("retry_count", downloadInfo.getRetryCount());
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
                double d = curBytes / realDownloadTime;
                try {
                    jSONObject.put("download_speed", d);
                } catch (Exception e) {
                }
                com.byazt.p000do.pr.hw(pr, "download speed : " + d + "MB/s");
            }
            try {
                jSONObject.put("is_download_service_foreground", Downloader.getInstance(k.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
            } catch (Exception e2) {
            }
            if (downloadInfo.getBackUpUrls() != null) {
                jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
            }
            jSONObject.put("clear_space_restart_times", com.byazt.ute.x.pr().hw(downloadInfo.getUrl()));
            jSONObject.put("mime_type", downloadInfo.getMimeType());
            if (!com.byazt.tuy.uc.hn(k.getContext())) {
                i = 2;
            }
            jSONObject.put("network_available", i);
            jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
            hw(jSONObject, downloadInfo);
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    public static JSONObject hw(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || com.byazt.ew.pr.pr(downloadInfo.getId()).pr("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long jHw = com.byazt.uk.m.hw(0L);
            double d = jHw;
            jSONObject.put("available_space", d / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = totalBytes;
            jSONObject.put(com.tapsdk.tapad.group.constants.Constants.APK_SIZE_FIELD, d2 / 1048576.0d);
            if (jHw > 0 && totalBytes > 0) {
                jSONObject.put("available_space_ratio", d / d2);
            }
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    public void hw(DownloadInfo downloadInfo, final com.byazt.tia.hw hwVar) {
        if (downloadInfo == null || hwVar == null || com.byazt.ew.pr.pr(downloadInfo.getId()).pr("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        c.pr().hw(new Runnable() { // from class: com.byazt.cvl.pr.3
            @Override // java.lang.Runnable
            public void run() {
                String strPr = com.byazt.uk.pr.pr(targetFilePath);
                if (TextUtils.isEmpty(strPr)) {
                    return;
                }
                com.byazt.zs.aj.pr(k.getContext(), "sp_ttdownloader_md5", 0).edit().putString(String.valueOf(hwVar.hw()), strPr).apply();
            }
        });
    }

    private static void pr(com.byazt.tia.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        String strIi = TextUtils.isEmpty(hwVar.ii()) ? "" : hwVar.ii();
        DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(hwVar.qa());
        hwVar.k("");
        com.byazt.shh.aj.pr().pr(hwVar);
        JSONObject jSONObjectPr = pr(new JSONObject(), downloadInfo);
        int i = 1;
        try {
            jSONObjectPr.putOpt("finish_reason", strIi);
            jSONObjectPr.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e) {
        }
        com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo);
        com.byazt.uk.uc.pr(jSONObjectPr, downloadInfo.getId());
        try {
            jSONObjectPr.put("download_failed_times", hwVarPr.rc());
            jSONObjectPr.put("can_show_notification", com.byazt.owr.x.pr() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                jSONObjectPr.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            jSONObjectPr.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            jSONObjectPr.put("has_send_download_failed_finally", hwVarPr.x.get() ? 1 : 2);
            if (!hwVarPr.o()) {
                i = 2;
            }
            jSONObjectPr.put("is_update_download", i);
            com.byazt.uk.uc.pr(hwVarPr, jSONObjectPr);
        } catch (Throwable th) {
        }
        com.byazt.mf.pr.pr().hw("download_finish", jSONObjectPr, hwVar);
    }

    private int pr(com.byazt.tia.hw hwVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int iHw = com.byazt.mdu.hn.hw(k.getContext(), downloadInfo);
        int iHw2 = com.byazt.uk.m.hw(k.getContext(), str);
        if (iHw > 0 && iHw2 > 0 && iHw != iHw2) {
            return iHw2 > iHw ? 3011 : 3010;
        }
        if (com.byazt.ew.pr.pr(hwVar.qa()).pr("install_finish_check_ttmd5", 1) == 1) {
            String string = com.byazt.zs.aj.pr(k.getContext(), "sp_ttdownloader_md5", 0).getString(String.valueOf(hwVar.hw()), null);
            if (TextUtils.isEmpty(string) && downloadInfo != null) {
                string = com.byazt.uk.pr.pr(downloadInfo.getTargetFilePath());
            }
            int iPr = com.byazt.uk.pr.pr(string, com.byazt.uk.pr.hw(str));
            try {
                jSONObject.put("ttmd5_status", iPr);
            } catch (Throwable th) {
            }
            if (iPr == 0) {
                return 3000;
            }
            if (iPr == 1) {
                return ErrorCode.NETWORK_TIMEOUT;
            }
            return 3001;
        }
        return 3001;
    }

    public static String hn(DownloadInfo downloadInfo, com.byazt.tia.hw hwVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = k.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.byazt.mdu.hn.pr());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e) {
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", downloadInfo.getPackageName());
            } catch (JSONException e2) {
            }
            com.byazt.mf.pr.pr().pr(com.byazt.pfl.hw.AD_TAG_FEED, "package_name_error", jSONObject, hwVar);
            return str;
        }
        return downloadInfo.getPackageName();
    }

    @Override // com.byazt.wel.pr.InterfaceC0223pr
    public void hw() {
        com.byazt.p000do.pr.hw(pr, "onAppForeground()");
        x();
        pr(5);
    }

    @Override // com.byazt.wel.pr.InterfaceC0223pr
    public void hn() {
        com.byazt.p000do.pr.hw(pr, "onAppBackground()");
        pr(6);
    }

    public synchronized void x() {
        hw hwVar = this.hn;
        if (hwVar != null) {
            hwVar.hw();
            this.hn = null;
        }
    }

    @Override // com.byazt.wqt.pr
    public void pr(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.hw < 120000) {
            return;
        }
        c.pr().pr(new RunnableC0035pr(i), this.hw > 0 ? 2000L : 8000L);
        this.hw = jCurrentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(ConcurrentHashMap<Long, com.byazt.tia.hw> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (com.byazt.tia.hw hwVar : concurrentHashMap.values()) {
            if (hwVar.hn.get()) {
                if (jCurrentTimeMillis - hwVar.e() >= com.byazt.ew.pr.pr(hwVar.qa()).pr("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(hwVar.hw()));
                }
            } else if (hwVar.n() == 1) {
                if (hw(hwVar) <= 0 && jCurrentTimeMillis - hwVar.e() >= com.byazt.ew.pr.pr(hwVar.qa()).pr("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(hwVar.hw()));
                }
            } else if (hwVar.n() == 2) {
                if (!hwVar.jn()) {
                    if (com.byazt.uk.m.hw(hwVar)) {
                        if (hwVar.er() == 4) {
                            i = hwVar.er();
                            com.byazt.zv.vk vkVarNy = k.ny();
                            if (vkVarNy != null) {
                                vkVarNy.pr(hwVar.cz());
                            }
                        }
                        hwVar.vk(false);
                        com.byazt.mf.pr.pr().pr(pr(hwVar, hwVar.c(), i), hwVar);
                        arrayList.add(Long.valueOf(hwVar.hw()));
                        com.byazt.ute.x.pr(hwVar);
                    } else if (hwVar.jn() && hwVar.er() == 4 && i == 1 && !com.byazt.uk.m.hw(hwVar)) {
                        com.byazt.uk.k.pr().pr(pr, "trySendAndRefreshAdEvent", "命中兜底逻辑,尝试对广播监听执行冷启兜底逻辑");
                        aj.pr().pr(hwVar);
                    } else if (jCurrentTimeMillis - hwVar.e() >= com.byazt.ew.pr.pr(hwVar.qa()).pr("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(hwVar.hw()));
                    } else if (TextUtils.isEmpty(hwVar.c())) {
                        arrayList.add(Long.valueOf(hwVar.hw()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(hwVar.hw()));
            }
        }
        com.byazt.shh.uc.pr().pr(arrayList);
    }

    @Override // com.byazt.mdu.hw.hn
    public void pr(DownloadInfo downloadInfo, com.byazt.mdu.pr prVar) {
        JSONObject jSONObjectHw;
        if (downloadInfo == null || prVar == null) {
            return;
        }
        JSONArray jSONArrayC = com.byazt.ew.pr.pr(downloadInfo.getId()).c("ah_report_config");
        if (prVar.hw != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (jSONArrayC != null && (jSONObjectHw = hw(downloadInfo, prVar)) != null) {
            downloadInfo.getTempCacheData().put("ah_ext_json", jSONObjectHw);
        }
    }

    @Override // com.byazt.fn.ww
    public void pr(final DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null) {
            com.byazt.vi.hn.pr().pr("info is null");
        } else if ((com.byazt.ew.pr.pr(downloadInfo).hw("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.byazt.ds.c.pr().hw(new com.byazt.ds.x() { // from class: com.byazt.cvl.pr.4
                @Override // com.byazt.ds.x
                public void pr(boolean z) {
                    if (!z) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent == null) {
                            com.byazt.uk.m.pr(jSONObject, LiveConfigKey.BACKUP, (Object) 2);
                        } else {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.byazt.mdu.hn.pr(k.getContext(), intent);
                            com.byazt.uk.m.pr(jSONObject, LiveConfigKey.BACKUP, (Object) 1);
                        }
                    }
                    com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo);
                    if (hwVarPr != null) {
                        com.byazt.mf.pr.pr().pr(z ? "installer_delay_success" : "installer_delay_failed", jSONObject, hwVarPr);
                    } else {
                        com.byazt.vi.hn.pr().hw("ah nativeModel=null");
                    }
                    if (z) {
                        k.cz().pr(k.getContext(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    private int hw(com.byazt.tia.hw hwVar) {
        int realStatus;
        double dPr = com.byazt.ew.pr.pr(hwVar.qa()).pr("download_failed_finally_hours", 48.0d);
        if (dPr <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - hwVar.e() < dPr * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (hwVar.x.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(hwVar.qa());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && hwVar.x.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                pr(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(hwVar.y()));
                jSONObject.putOpt("fail_msg", hwVar.ww());
                jSONObject.put("download_failed_times", hwVar.rc());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put("is_update_download", hwVar.o() ? 1 : 2);
                com.byazt.mf.pr.pr().pr(hwVar.vk(), "download_failed_finally", jSONObject, hwVar);
                com.byazt.shh.aj.pr().pr(hwVar);
                return 0;
            } catch (Throwable th) {
            }
        }
        return 1;
    }

    private JSONObject hw(DownloadInfo downloadInfo, com.byazt.mdu.pr prVar) {
        com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo);
        if (hwVarPr == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        prVar.pr(jSONObject);
        try {
            jSONObject.put(ApkNotificationReceiver.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put(Common.System.NAME, downloadInfo.getName());
        } catch (Throwable th) {
        }
        com.byazt.uk.uc.pr(jSONObject, downloadInfo.getId());
        com.byazt.mf.pr.pr().pr(com.byazt.pfl.hw.AD_TAG_FEED, "ah_result", jSONObject, hwVarPr);
        return jSONObject;
    }

    /* JADX INFO: renamed from: com.byazt.cvl.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private class RunnableC0035pr implements Runnable {
        public final int hw;

        public RunnableC0035pr(int i) {
            this.hw = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.byazt.shh.uc.pr().hw();
                ConcurrentHashMap<Long, com.byazt.tia.hw> concurrentHashMapHn = com.byazt.shh.uc.pr().hn();
                if (concurrentHashMapHn != null && !concurrentHashMapHn.isEmpty()) {
                    pr.this.pr(concurrentHashMapHn, this.hw);
                }
            } catch (Exception e) {
            }
        }
    }

    private JSONObject pr(com.byazt.tia.hw hwVar, String str, int i) {
        com.byazt.mdu.pr prVarPr;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(hwVar.qa());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            com.byazt.uk.uc.pr(jSONObject, hwVar.qa());
            com.byazt.uk.uc.pr(hwVar, jSONObject);
            jSONObject.put("is_update_download", hwVar.o() ? 1 : 2);
            jSONObject.put("install_after_back_app", hwVar.od() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", hwVar.r() ? "1" : "2");
            if (downloadInfo != null) {
                pr(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (hwVar.gz() > 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - hwVar.gz();
                        jSONObject.put("install_time", jCurrentTimeMillis);
                        if (jCurrentTimeMillis > com.byazt.ew.pr.pr(downloadInfo.getId()).pr("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable th) {
                }
                String strPr = com.byazt.tuy.uc.pr(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(strPr) && (prVarPr = com.byazt.mdu.pr.pr(strPr)) != null) {
                    prVarPr.pr(jSONObject);
                }
            }
            int iPr = pr(hwVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", iPr);
            if (iPr == 3000) {
                jSONObject.put("hijack", 2);
            } else if (iPr == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th2) {
        }
        return jSONObject;
    }

    public void pr(DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo);
        if (hwVarPr == null) {
            com.byazt.vi.hn.pr().pr("trySendClearSpaceEvent nativeModel null");
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
            com.byazt.uk.uc.hn(downloadInfo, jSONObject);
            com.byazt.mf.pr.pr().pr("cleanup", jSONObject, hwVarPr);
        } catch (Exception e) {
        }
    }
}
