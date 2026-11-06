package com.byazt.s;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.common.d.i;
import com.anythink.core.common.f.h;
import com.byazt.je.v;
import com.byazt.q.AdBaseConstants;
import com.byazt.sk.DownloadStatus;
import com.byazt.ug.cp;
import com.byazt.ug.d;
import com.byazt.ug.oa;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.qq.e.comm.constants.ErrorCode;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 8, 19})
public class n implements com.byazt.w.n, com.byazt.e.qg.s, v, com.byazt.b.n.InterfaceC0133n {
    public static String n = "n";
    public static volatile n q;
    public long qg;
    public qg s;

    private n() {
        com.byazt.e.qg.n(this);
        com.byazt.b.n.n().n(this);
    }

    public static n n() {
        if (q == null) {
            synchronized (n.class) {
                if (q == null) {
                    q = new n();
                }
            }
        }
        return q;
    }

    public static synchronized void n(DownloadInfo downloadInfo, com.byazt.h.qg qgVar) {
        try {
            if (downloadInfo == null) {
                com.byazt.ch.s.n().n("onDownloadFinish info null");
                return;
            }
            if (qgVar == null) {
                com.byazt.ch.s.n().n("onDownloadFinish nativeModel null");
                return;
            }
            if (qgVar.j() != 1) {
                return;
            }
            com.byazt.ht.fs.n().q(qgVar);
            String strS = s(downloadInfo, qgVar);
            com.byazt.vl.w.n().qg(downloadInfo.getUrl(), strS);
            Map<Long, com.byazt.h.qg> mapN = com.byazt.vl.w.n().n(downloadInfo.getUrl(), strS);
            qgVar.w(System.currentTimeMillis());
            qgVar.l(2);
            qgVar.qg(strS);
            mapN.put(Long.valueOf(qgVar.qg()), qgVar);
            com.byazt.vl.rv.n().n(mapN.values());
            n(qgVar);
            cp.n().qg(qgVar.py(), downloadInfo);
            qgVar.d(System.currentTimeMillis());
            fs.n().n(downloadInfo, strS);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                if (com.byazt.rz.l.n((com.byazt.h.n) qgVar).n("enable_app_install_receiver", 1) != 1 && d.rv().optInt("enable_app_install_receiver", 1) != 1) {
                    oa.n().n(qgVar);
                }
                n().qg(downloadInfo, qgVar);
                if (qgVar.df()) {
                    com.byazt.bn.n.n().n(downloadInfo.getId(), qgVar.qg(), qgVar.d(), strS, downloadInfo.getTitle(), qgVar.q(), downloadInfo.getTargetFilePath());
                }
                qgVar.qg();
                qgVar.q();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void n(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.byazt.rz.oa.qg()) {
            throw new RuntimeException("handleAppInstalled in main thread.");
        }
        final com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(str);
        if (qgVarN == null) {
            com.byazt.vl.q.n().n(str);
            return;
        }
        com.byazt.ug.l lVarN = fs.n().n(qgVarN.n());
        if (lVarN != null) {
            lVarN.w();
        }
        if (qgVarN.s.get()) {
            return;
        }
        if (com.byazt.f.n.n(qgVarN.um()).qg("notification_opt_2") == 1) {
            com.byazt.av.qg.n().w(qgVarN.um());
        }
        new com.byazt.t.qg().n(qgVarN, new com.byazt.t.x() { // from class: com.byazt.s.n.1
            @Override // com.byazt.t.x
            public void n(boolean z) {
                com.byazt.fe.n.qg(n.n, "appBackForeground->".concat(String.valueOf(z)));
                if (z) {
                    if (!(com.byazt.t.w.s(qgVarN) ? com.byazt.t.n.n(str, qgVarN) : false) && com.byazt.t.w.q(qgVarN) && qgVarN.fi() == 4) {
                        com.byazt.bn.n.n().n(qgVarN);
                        return;
                    }
                    return;
                }
                if (com.byazt.t.n.n(str, qgVarN) || qgVarN.fi() != 4) {
                    return;
                }
                com.byazt.bn.n.n().n(qgVarN);
            }
        }, com.byazt.rz.l.n((com.byazt.h.n) qgVarN).n("try_applink_delay_after_installed", 0));
        com.byazt.ht.fs.n().w(qgVarN);
        n(str, qgVarN);
        com.byazt.bn.n.n().qg(str);
        DownloadInfo downloadInfoN = n((List<DownloadInfo>) Downloader.getInstance(d.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK), str);
        if (downloadInfoN != null) {
            if (com.byazt.f.n.n(downloadInfoN.getId()).qg("no_hide_notification") != 1) {
                com.byazt.av.qg.n().n(downloadInfoN.getId());
            }
            fs.n().qg(downloadInfoN, str);
            com.byazt.nb.q.n(downloadInfoN);
            return;
        }
        fs.n().qg(null, str);
    }

    public void n(DownloadInfo downloadInfo, com.byazt.h.qg qgVar, int i) {
        long jMax;
        if (downloadInfo == null || qgVar == null) {
            return;
        }
        q();
        long jCurrentTimeMillis = System.currentTimeMillis();
        qgVar.qg(jCurrentTimeMillis);
        qgVar.x(com.byazt.rz.oa.n(Environment.getDataDirectory(), -1L));
        if (i != 2000) {
            jMax = 2000;
        } else {
            long jN = com.byazt.f.n.n(downloadInfo.getId()).n("check_install_failed_delay_time", i.l.c);
            if (jN < 0) {
                return;
            } else {
                jMax = Math.max(jN, 30000L);
            }
        }
        long j = jMax;
        qg qgVar2 = new qg(qgVar.qg(), downloadInfo.getId(), jCurrentTimeMillis, i);
        l.n().n(qgVar2, j);
        this.s = qgVar2;
        com.byazt.vl.rv.n().n(qgVar);
    }

    @com.byazt.cp.n(n = {0, 1, 8, 226})
    private static class qg implements Runnable {
        public long l;
        public long n;
        public int q;
        public int qg;
        public long s;

        private qg(long j, int i, long j2, int i2) {
            this.n = j;
            this.qg = i;
            this.s = j2;
            this.q = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void qg() {
            this.l = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (n()) {
                    n.n().n(this.n, this.qg);
                }
            } catch (Throwable unused) {
            }
        }

        public boolean n() {
            DownloadInfo downloadInfo;
            JSONObject jSONObject;
            com.byazt.h.qg qgVarQ = com.byazt.vl.w.n().q(this.n);
            if (qgVarQ == null || com.byazt.rz.oa.qg(qgVarQ) || qgVarQ.s.get() || (downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(qgVarQ.um())) == null) {
                return false;
            }
            long jOj = qgVarQ.oj();
            long jN = com.byazt.rz.oa.n(Environment.getDataDirectory());
            long jMin = Math.min(524288000L, jN / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d = totalBytes;
            boolean z = jOj <= -1 || totalBytes <= -1 || ((double) jOj) >= ((double) jMin) + (2.5d * d);
            boolean zN = com.byazt.e.qg.n(d.getContext());
            JSONObject jSONObject2 = new JSONObject();
            int iN = n(z, qgVarQ, downloadInfo, zN, jSONObject2);
            this.q = iN;
            try {
                jSONObject = jSONObject2;
                try {
                    jSONObject.putOpt("fail_status", Integer.valueOf(iN));
                    jSONObject.putOpt("available_space", Long.valueOf(jOj / 1048576));
                    jSONObject.putOpt("total_space", Long.valueOf(jN / 1048576));
                    if (totalBytes > 0) {
                        jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, Long.valueOf(totalBytes / 1048576));
                    }
                    jSONObject.putOpt("space_enough", Integer.valueOf(z ? 1 : 2));
                    if (jOj > 0 && totalBytes > 0) {
                        jSONObject.put("available_space_ratio", jOj / d);
                    }
                    jSONObject.putOpt("permission_unknown_source_install", Integer.valueOf(zN ? 1 : 2));
                    jSONObject.put("is_update_download", qgVarQ.b() ? 1 : 2);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                jSONObject = jSONObject2;
            }
            com.byazt.vj.n.n().qg("install_failed", jSONObject, qgVarQ);
            return true;
        }

        private int n(boolean z, com.byazt.h.qg qgVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            com.byazt.f.n nVarN = com.byazt.f.n.n(downloadInfo.getId());
            int i = 1;
            if (nVarN.n("install_failed_check_ttmd5", 1) == 1) {
                int iCheckMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", iCheckMd5Status);
                } catch (Throwable unused) {
                }
                if (!com.byazt.ta.w.n(iCheckMd5Status)) {
                    return 2005;
                }
            }
            int i2 = this.q;
            if (i2 != 2000) {
                return i2;
            }
            if (nVarN.n("install_failed_check_signature", 1) == 1 && com.byazt.rz.oa.l(d.getContext(), qgVar.l())) {
                if (!com.byazt.rz.oa.n(com.byazt.rz.oa.rv(d.getContext(), downloadInfo.getTargetFilePath()), com.byazt.rz.oa.fs(d.getContext(), qgVar.l()))) {
                    return 2006;
                }
            }
            if (!z) {
                return 2002;
            }
            long j = this.l;
            long j2 = this.s;
            if (j <= j2) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j - j2);
                if (qgVar.bb() <= this.s) {
                    i = 0;
                }
                jSONObject.put("install_again", i);
            } catch (Throwable unused2) {
            }
            if (z2) {
                return 2004;
            }
            return ErrorCode.NOT_INIT;
        }
    }

    public void n(final long j, int i) {
        long jN = com.byazt.f.n.n(i).n("check_install_finish_hijack_delay_time", 900000L);
        if (jN < 0) {
            return;
        }
        l.n().n(new Runnable() { // from class: com.byazt.s.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.n().n(j);
            }
        }, Math.max(jN, 300000L));
    }

    public void n(long j) {
        com.byazt.vl.q.n nVarN;
        int iIntValue;
        try {
            com.byazt.h.qg qgVarQ = com.byazt.vl.w.n().q(j);
            if (qgVarQ != null && !com.byazt.rz.oa.qg(qgVarQ) && !qgVarQ.s.get()) {
                Pair<com.byazt.vl.q.n, Integer> pairQg = com.byazt.vl.q.n().qg(qgVarQ);
                if (pairQg != null) {
                    nVarN = (com.byazt.vl.q.n) pairQg.first;
                    iIntValue = ((Integer) pairQg.second).intValue();
                } else {
                    nVarN = com.byazt.vl.q.n().n(qgVarQ);
                    iIntValue = -1;
                }
                if (nVarN == null) {
                    return;
                }
                com.byazt.vl.q.n().qg(nVarN.n);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", nVarN.q);
                jSONObject.put("installed_pkg_name", nVarN.n);
                if (iIntValue != -1) {
                    jSONObject.put("error_code", iIntValue);
                    com.byazt.rz.w.n(jSONObject, qgVarQ.um());
                    com.byazt.vj.n.n().qg("install_finish_hijack", jSONObject, qgVarQ);
                    return;
                }
                com.byazt.vj.n.n().qg("install_finish_may_hijack", jSONObject, qgVarQ);
            }
        } catch (Throwable th) {
            com.byazt.ch.s.n().n(th, "trySendInstallFinishHijack");
        }
    }

    public void n(String str, com.byazt.h.qg qgVar) {
        if (qgVar != null && com.byazt.rz.oa.qg(qgVar) && qgVar.s.compareAndSet(false, true)) {
            int i = 4;
            if (qgVar.fi() == 4) {
                com.byazt.ky.tj tjVarOu = d.ou();
                if (tjVarOu != null) {
                    tjVarOu.n(qgVar.py());
                }
            } else {
                i = 3;
            }
            com.byazt.vj.n.n().n(qgVar.tj(), "install_finish", n(qgVar, str, i), qgVar);
            com.byazt.vl.rv.n().n(qgVar);
        }
    }

    private static DownloadInfo n(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (com.byazt.rz.oa.n(d.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject n(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i = 1;
            if (com.byazt.f.n.n(downloadInfo.getId()).n("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put(TapEventParamConstants.PARAM_NAME, downloadInfo.getName());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.put("current_network_quality", com.byazt.m.cp.n().qg().name());
                jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put(h.b.h, downloadInfo.getRetryCount());
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
                    } catch (Exception unused) {
                    }
                    com.byazt.fe.n.qg(n, "download speed : " + d + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", Downloader.getInstance(d.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception unused2) {
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                    jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.byazt.nb.q.n().qg(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!com.byazt.ta.w.s(d.getContext())) {
                    i = 2;
                }
                jSONObject.put("network_available", i);
                jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                qg(jSONObject, downloadInfo);
            } catch (Throwable unused3) {
            }
        }
        return jSONObject;
    }

    public static JSONObject qg(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || com.byazt.f.n.n(downloadInfo.getId()).n("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long jQg = com.byazt.rz.oa.qg(0L);
            double d = jQg;
            jSONObject.put("available_space", d / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = totalBytes;
            jSONObject.put("apk_size", d2 / 1048576.0d);
            if (jQg > 0 && totalBytes > 0) {
                jSONObject.put("available_space_ratio", d / d2);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public void qg(DownloadInfo downloadInfo, final com.byazt.h.qg qgVar) {
        if (downloadInfo == null || qgVar == null || com.byazt.f.n.n(downloadInfo.getId()).n("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        l.n().qg(new Runnable() { // from class: com.byazt.s.n.3
            @Override // java.lang.Runnable
            public void run() {
                String strN = com.byazt.rz.n.n(targetFilePath);
                if (TextUtils.isEmpty(strN)) {
                    return;
                }
                com.byazt.qp.x.n(d.getContext(), "sp_ttdownloader_md5", 0).edit().putString(String.valueOf(qgVar.qg()), strN).apply();
            }
        });
    }

    private static void n(com.byazt.h.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        String strPk = TextUtils.isEmpty(qgVar.pk()) ? "" : qgVar.pk();
        DownloadInfo downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(qgVar.um());
        qgVar.d("");
        com.byazt.vl.rv.n().n(qgVar);
        JSONObject jSONObjectN = n(new JSONObject(), downloadInfo);
        int i = 1;
        try {
            jSONObjectN.putOpt("finish_reason", strPk);
            jSONObjectN.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException unused) {
        }
        com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(downloadInfo);
        com.byazt.rz.w.n(jSONObjectN, downloadInfo.getId());
        try {
            jSONObjectN.put("download_failed_times", qgVarN.m());
            jSONObjectN.put("can_show_notification", com.byazt.j.q.n() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                jSONObjectN.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            jSONObjectN.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            jSONObjectN.put("has_send_download_failed_finally", qgVarN.q.get() ? 1 : 2);
            if (!qgVarN.b()) {
                i = 2;
            }
            jSONObjectN.put("is_update_download", i);
            com.byazt.rz.w.n(qgVarN, jSONObjectN);
        } catch (Throwable unused2) {
        }
        com.byazt.vj.n.n().qg("download_finish", jSONObjectN, qgVar);
    }

    private int n(com.byazt.h.qg qgVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int iQg = com.byazt.e.s.qg(d.getContext(), downloadInfo);
        int iQg2 = com.byazt.rz.oa.qg(d.getContext(), str);
        if (iQg > 0 && iQg2 > 0 && iQg != iQg2) {
            return iQg2 > iQg ? 3011 : 3010;
        }
        if (com.byazt.f.n.n(qgVar.um()).n("install_finish_check_ttmd5", 1) != 1) {
            return ErrorCode.NETWORK_ERROR;
        }
        String string = com.byazt.qp.x.n(d.getContext(), "sp_ttdownloader_md5", 0).getString(String.valueOf(qgVar.qg()), null);
        if (TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.byazt.rz.n.n(downloadInfo.getTargetFilePath());
        }
        int iN = com.byazt.rz.n.n(string, com.byazt.rz.n.qg(str));
        try {
            jSONObject.put("ttmd5_status", iN);
        } catch (Throwable unused) {
        }
        if (iN == 0) {
            return 3000;
        }
        return iN == 1 ? ErrorCode.NETWORK_TIMEOUT : ErrorCode.NETWORK_ERROR;
    }

    public static String s(DownloadInfo downloadInfo, com.byazt.h.qg qgVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = d.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.byazt.e.s.n());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception unused) {
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", downloadInfo.getPackageName());
            } catch (JSONException unused2) {
            }
            com.byazt.vj.n.n().n(com.byazt.wg.qg.AD_TAG_FEED, "package_name_error", jSONObject, qgVar);
            return str;
        }
        return downloadInfo.getPackageName();
    }

    @Override // com.byazt.b.n.InterfaceC0133n
    public void qg() {
        com.byazt.fe.n.qg(n, "onAppForeground()");
        q();
        n(5);
    }

    @Override // com.byazt.b.n.InterfaceC0133n
    public void s() {
        com.byazt.fe.n.qg(n, "onAppBackground()");
        n(6);
    }

    public synchronized void q() {
        qg qgVar = this.s;
        if (qgVar != null) {
            qgVar.qg();
            this.s = null;
        }
    }

    @Override // com.byazt.w.n
    public void n(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.qg < i.l.c) {
            return;
        }
        l.n().n(new RunnableC0331n(i), this.qg > 0 ? 2000L : 8000L);
        this.qg = jCurrentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(ConcurrentHashMap<Long, com.byazt.h.qg> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (com.byazt.h.qg qgVar : concurrentHashMap.values()) {
            if (qgVar.s.get()) {
                if (jCurrentTimeMillis - qgVar.an() >= com.byazt.f.n.n(qgVar.um()).n("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(qgVar.qg()));
                }
            } else if (qgVar.j() == 1) {
                if (qg(qgVar) <= 0 && jCurrentTimeMillis - qgVar.an() >= com.byazt.f.n.n(qgVar.um()).n("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(qgVar.qg()));
                }
            } else if (qgVar.j() == 2) {
                if (!qgVar.pe()) {
                    if (com.byazt.rz.oa.qg(qgVar)) {
                        if (qgVar.fi() == 4) {
                            i = qgVar.fi();
                            com.byazt.ky.tj tjVarOu = d.ou();
                            if (tjVarOu != null) {
                                tjVarOu.n(qgVar.py());
                            }
                        }
                        qgVar.tj(false);
                        com.byazt.vj.n.n().n(n(qgVar, qgVar.l(), i), qgVar);
                        arrayList.add(Long.valueOf(qgVar.qg()));
                        com.byazt.nb.q.n(qgVar);
                    } else if (qgVar.pe() && qgVar.fi() == 4 && i == 1 && !com.byazt.rz.oa.qg(qgVar)) {
                        com.byazt.rz.d.n().n(n, "trySendAndRefreshAdEvent", "命中兜底逻辑,尝试对广播监听执行冷启兜底逻辑");
                        rv.n().n(qgVar);
                    } else if (jCurrentTimeMillis - qgVar.an() >= com.byazt.f.n.n(qgVar.um()).n("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(qgVar.qg()));
                    } else if (TextUtils.isEmpty(qgVar.l())) {
                        arrayList.add(Long.valueOf(qgVar.qg()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(qgVar.qg()));
            }
        }
        com.byazt.vl.w.n().n(arrayList);
    }

    @Override // com.byazt.e.qg.s
    public void n(DownloadInfo downloadInfo, com.byazt.e.n nVar) {
        JSONObject jSONObjectQg;
        if (downloadInfo == null || nVar == null) {
            return;
        }
        JSONArray jSONArrayL = com.byazt.f.n.n(downloadInfo.getId()).l("ah_report_config");
        if (nVar.qg != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (jSONArrayL == null || (jSONObjectQg = qg(downloadInfo, nVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", jSONObjectQg);
    }

    @Override // com.byazt.je.v
    public void n(final DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null) {
            com.byazt.ch.s.n().n("info is null");
        } else if ((com.byazt.f.n.n(downloadInfo).qg("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.byazt.t.l.n().qg(new com.byazt.t.q() { // from class: com.byazt.s.n.4
                @Override // com.byazt.t.q
                public void n(boolean z) {
                    if (!z) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.byazt.e.s.n(d.getContext(), intent);
                            com.byazt.rz.oa.n(jSONObject, LiveConfigKey.BACKUP, (Object) 1);
                        } else {
                            com.byazt.rz.oa.n(jSONObject, LiveConfigKey.BACKUP, (Object) 2);
                        }
                    }
                    com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(downloadInfo);
                    if (qgVarN != null) {
                        com.byazt.vj.n.n().n(z ? "installer_delay_success" : "installer_delay_failed", jSONObject, qgVarN);
                    } else {
                        com.byazt.ch.s.n().qg("ah nativeModel=null");
                    }
                    if (z) {
                        d.py().n(d.getContext(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    private int qg(com.byazt.h.qg qgVar) {
        int realStatus;
        double dN = com.byazt.f.n.n(qgVar.um()).n("download_failed_finally_hours", 48.0d);
        if (dN <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - qgVar.an() < dN * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (qgVar.q.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(qgVar.um());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && qgVar.q.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                n(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(qgVar.lh()));
                jSONObject.putOpt("fail_msg", qgVar.v());
                jSONObject.put("download_failed_times", qgVar.m());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put("is_update_download", qgVar.b() ? 1 : 2);
                com.byazt.vj.n.n().n(qgVar.tj(), "download_failed_finally", jSONObject, qgVar);
                com.byazt.vl.rv.n().n(qgVar);
                return 0;
            } catch (Throwable unused) {
            }
        }
        return 1;
    }

    private JSONObject qg(DownloadInfo downloadInfo, com.byazt.e.n nVar) {
        com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(downloadInfo);
        if (qgVarN == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        nVar.n(jSONObject);
        try {
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put(TapEventParamConstants.PARAM_NAME, downloadInfo.getName());
        } catch (Throwable unused) {
        }
        com.byazt.rz.w.n(jSONObject, downloadInfo.getId());
        com.byazt.vj.n.n().n(com.byazt.wg.qg.AD_TAG_FEED, "ah_result", jSONObject, qgVarN);
        return jSONObject;
    }

    /* JADX INFO: renamed from: com.byazt.s.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private class RunnableC0331n implements Runnable {
        public final int qg;

        public RunnableC0331n(int i) {
            this.qg = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.byazt.vl.w.n().qg();
                ConcurrentHashMap<Long, com.byazt.h.qg> concurrentHashMapS = com.byazt.vl.w.n().s();
                if (concurrentHashMapS == null || concurrentHashMapS.isEmpty()) {
                    return;
                }
                n.this.n(concurrentHashMapS, this.qg);
            } catch (Exception unused) {
            }
        }
    }

    private JSONObject n(com.byazt.h.qg qgVar, String str, int i) {
        com.byazt.e.n nVarN;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(qgVar.um());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            com.byazt.rz.w.n(jSONObject, qgVar.um());
            com.byazt.rz.w.n(qgVar, jSONObject);
            jSONObject.put("is_update_download", qgVar.b() ? 1 : 2);
            jSONObject.put("install_after_back_app", qgVar.cx() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", qgVar.sh() ? "1" : "2");
            if (downloadInfo != null) {
                n(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (qgVar.bb() > 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - qgVar.bb();
                        jSONObject.put("install_time", jCurrentTimeMillis);
                        if (jCurrentTimeMillis > com.byazt.f.n.n(downloadInfo.getId()).n("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String strN = com.byazt.ta.w.n(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(strN) && (nVarN = com.byazt.e.n.n(strN)) != null) {
                    nVarN.n(jSONObject);
                }
            }
            int iN = n(qgVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", iN);
            if (iN == 3000) {
                jSONObject.put("hijack", 2);
            } else if (iN == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    public void n(DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(downloadInfo);
        if (qgVarN == null) {
            com.byazt.ch.s.n().n("trySendClearSpaceEvent nativeModel null");
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
            com.byazt.rz.w.s(downloadInfo, jSONObject);
            com.byazt.vj.n.n().n("cleanup", jSONObject, qgVarN);
        } catch (Exception unused) {
        }
    }
}
