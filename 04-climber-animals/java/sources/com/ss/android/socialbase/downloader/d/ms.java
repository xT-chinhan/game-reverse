package com.ss.android.socialbase.downloader.d;

import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.common.e.g;
import com.anythink.core.common.e.m;
import com.anythink.core.express.b.a;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.ka;
import com.ss.android.socialbase.downloader.network.ny;
import com.ss.android.socialbase.downloader.ny.c;
import com.tapsdk.tapad.internal.tracker.experiment.h.f;
import com.taptap.sdk.db.constant.Common;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ms {
    public static void ms(DownloadTask downloadTask, BaseException baseException, int i) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            i monitorDepend = downloadTask.getMonitorDepend();
            boolean zIsMonitorStatus = DownloadStatus.isMonitorStatus(i);
            if (!zIsMonitorStatus && !(zIsMonitorStatus = ms(downloadInfo.getExtraMonitorStatus(), i)) && monitorDepend != null && (monitorDepend instanceof com.ss.android.socialbase.downloader.depend.ah)) {
                zIsMonitorStatus = ms(((com.ss.android.socialbase.downloader.depend.ah) monitorDepend).ms(), i);
            }
            if (zIsMonitorStatus) {
                try {
                    u depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.ms(downloadInfo, baseException, i);
                    }
                } catch (Throwable th) {
                    ab.ms(th);
                }
                ms(monitorDepend, downloadInfo, baseException, i);
                ms(com.ss.android.socialbase.downloader.downloader.ah.ab(), downloadInfo, baseException, i);
            }
        } catch (Throwable th2) {
            ab.ms(th2);
        }
    }

    private static boolean ms(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void ms(i iVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (iVar == null) {
            return;
        }
        try {
            String strXr = iVar.xr();
            if (TextUtils.isEmpty(strXr)) {
                strXr = a.f;
            }
            JSONObject jSONObjectMs = ms(strXr, downloadInfo, baseException, i);
            if (jSONObjectMs == null) {
                jSONObjectMs = new JSONObject();
            }
            iVar.ms(jSONObjectMs);
        } catch (Throwable unused) {
        }
    }

    public static void ms(xr xrVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (xrVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject jSONObjectMs = ms(downloadInfo.getMonitorScene(), downloadInfo, baseException, i);
            if (jSONObjectMs == null) {
                jSONObjectMs = new JSONObject();
            }
            if (i == -1) {
                jSONObjectMs.put("status", baseException.getErrorCode());
            } else {
                ms(i, jSONObjectMs, downloadInfo);
            }
        } catch (Throwable th) {
            ab.ms(th);
        }
    }

    private static void ms(int i, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = "download_cancel";
        } else if (i == -3) {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= 0.0d) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        } else if (i == -2) {
            str = "download_pause";
        } else if (i == 0) {
            str = "download_create";
        } else if (i != 2) {
            str = i != 6 ? "" : "download_first_start";
        } else {
            str = "download_start";
        }
        jSONObject.put("status", str);
    }

    public static String ms(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e) {
            ab.ms(e);
            return "";
        }
    }

    private static JSONObject ms(String str, DownloadInfo downloadInfo, BaseException baseException, int i) {
        String strXr;
        String strMs;
        String strMs2;
        int iAh;
        String lastPathSegment;
        String host;
        String path;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                h hVarHi = com.ss.android.socialbase.downloader.downloader.ah.hi();
                if (hVarHi != null) {
                    strXr = hVarHi.xr();
                    strMs = ms(strXr);
                    strMs2 = hVarHi.ms();
                    iAh = hVarHi.ah();
                } else {
                    strXr = "";
                    strMs = strXr;
                    strMs2 = strMs;
                    iAh = 0;
                }
                String strMs3 = (baseException == null || !(baseException instanceof com.ss.android.socialbase.downloader.exception.ab)) ? "" : ((com.ss.android.socialbase.downloader.exception.ab) baseException).ms();
                jSONObject2.put("event_page", str);
                jSONObject2.put("app_id", strMs2);
                jSONObject2.put("device_id", strXr);
                jSONObject2.put("device_id_postfix", strMs);
                jSONObject2.put("update_version", iAh);
                jSONObject2.put("download_status", i);
                if (downloadInfo != null) {
                    jSONObject2.put("setting_tag", com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ah("setting_tag"));
                    jSONObject2.put("download_id", downloadInfo.getId());
                    jSONObject2.put(Common.System.NAME, downloadInfo.getName());
                    jSONObject2.put("url", downloadInfo.getUrl());
                    jSONObject2.put("save_path", downloadInfo.getSavePath());
                    jSONObject2.put("download_time", downloadInfo.getDownloadTime());
                    jSONObject2.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject2.put("total_bytes", downloadInfo.getTotalBytes());
                    jSONObject2.put("network_quality", downloadInfo.getNetworkQuality());
                    int i2 = 1;
                    jSONObject2.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject2.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject2.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject2.put("md5", downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                    jSONObject2.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject2.put("is_force", downloadInfo.isForce() ? 1 : 0);
                    jSONObject2.put(m.b.h, downloadInfo.getRetryCount());
                    jSONObject2.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject2.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject2.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                    jSONObject2.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                    jSONObject2.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                    jSONObject2.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject2.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                    jSONObject2.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                    jSONObject2.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject2.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject2.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                    if (!downloadInfo.isAddListenerToSameTask()) {
                        i2 = 0;
                    }
                    jSONObject2.put("add_listener_to_same_task", i2);
                    jSONObject2.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                    jSONObject2.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                    jSONObject2.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                    jSONObject2.put("task_id", TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                    try {
                        String url = downloadInfo.getUrl();
                        if (TextUtils.isEmpty(url)) {
                            lastPathSegment = "";
                            host = lastPathSegment;
                            path = host;
                        } else {
                            Uri uri = Uri.parse(url);
                            host = uri.getHost();
                            path = uri.getPath();
                            lastPathSegment = uri.getLastPathSegment();
                            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                                try {
                                    path = path.substring(0, path.length() - lastPathSegment.length());
                                } catch (Throwable th) {
                                    ab.ms(th);
                                }
                            }
                        }
                        jSONObject2.put("url_host", host);
                        jSONObject2.put("url_path", path);
                        jSONObject2.put("url_last_path_segment", lastPathSegment);
                    } catch (Throwable th2) {
                        ab.ms(th2);
                    }
                }
                jSONObject2.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
                jSONObject2.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
                jSONObject2.put("request_log", strMs3);
                return jSONObject2;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                ab.ms(e);
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003c A[PHI: r8
      0x003c: PHI (r8v8 int) = (r8v0 int), (r8v2 int) binds: [B:12:0x0023, B:19:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    public static void ms(com.ss.android.socialbase.downloader.network.ab abVar, String str, String str2, long j, String str3, int i, IOException iOException, DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.ab.ms msVarMs;
        int iMs;
        String strKa;
        int httpStatusCode;
        if (downloadInfo == null || (iMs = (msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId())).ms("monitor_download_connect", 0)) <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        String errorMessage = null;
        int iXr = -1;
        try {
            if (abVar != null) {
                try {
                    iXr = abVar.xr();
                } catch (Throwable th) {
                    ab.ms(th);
                }
                if (abVar instanceof com.ss.android.socialbase.downloader.network.ms) {
                    strKa = ((com.ss.android.socialbase.downloader.network.ms) abVar).ka();
                } else {
                    strKa = null;
                }
            } else {
                strKa = null;
            }
            String strMs = "";
            if (iXr < 200 || iXr >= 400) {
                if (downloadInfo.getCurRetryTime() != 0 && ((httpStatusCode = downloadInfo.getHttpStatusCode()) < 200 || httpStatusCode >= 400)) {
                    return;
                }
                if (iOException != null) {
                    if (c.ah(com.ss.android.socialbase.downloader.downloader.ah.k())) {
                        try {
                            c.ms((Throwable) iOException, "");
                        } catch (BaseException e) {
                            iXr = e.getErrorCode();
                            errorMessage = e.getErrorMessage();
                            if (e instanceof com.ss.android.socialbase.downloader.exception.ab) {
                                strMs = ((com.ss.android.socialbase.downloader.exception.ab) e).ms();
                            }
                        }
                    } else {
                        iXr = 1049;
                    }
                }
            }
            Uri uri = Uri.parse(str);
            String host = uri.getHost();
            String path = uri.getPath();
            String lastPathSegment = uri.getLastPathSegment();
            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (Throwable unused) {
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("setting_tag", msVarMs.ah("setting_tag"));
                jSONObject.put("url_host", host);
                jSONObject.putOpt("host_ip", str2);
                jSONObject.putOpt("host_real_ip", strKa);
                jSONObject.put("url_path", path);
                jSONObject.put("url_last_path_segment", lastPathSegment);
                jSONObject.put("net_lib", i);
                jSONObject.put("connect_type", str3);
                jSONObject.put(f.z, iXr);
                jSONObject.put("request_log", strMs);
                if (errorMessage != null) {
                    jSONObject.put("error_msg", c.ms(errorMessage, msVarMs.ms("exception_msg_length", 500)));
                }
                jSONObject.put("connect_time", j);
                jSONObject.put(g.a.g, downloadInfo.getPackageName());
                jSONObject.put(Common.System.NAME, downloadInfo.getTitle());
            } catch (JSONException e2) {
                ab.ms(e2);
            }
            if (iMs == 1 || iMs == 3) {
                com.ss.android.socialbase.downloader.downloader.ah.ab();
            }
            if (iMs == 2 || iMs == 3) {
                com.ss.android.socialbase.downloader.downloader.ah.fm().ms(downloadInfo.getId(), "download_connect", jSONObject);
            }
        } catch (Throwable th2) {
            ab.ms(th2);
        }
    }

    public static void ms(com.ss.android.socialbase.downloader.ab.ms msVar, DownloadInfo downloadInfo, String str, ny nyVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        ms("download_io", msVar.xr("monitor_download_io"), msVar, downloadInfo, str, null, null, nyVar, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    public static void ms(com.ss.android.socialbase.downloader.ab.ms msVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, ny nyVar, BaseException baseException, long j, long j2) {
        ms("segment_io", msVar.xr("monitor_segment_io"), msVar, downloadInfo, str, str2, str3, nyVar, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.socialbase.downloader.d.ah] */
    /* JADX WARN: Type inference failed for: r14v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    private static void ms(String str, int i, com.ss.android.socialbase.downloader.ab.ms msVar, DownloadInfo downloadInfo, String str2, String str3, String str4, ny nyVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        String errorMessage;
        int errorCode;
        ?? r2;
        int i2;
        if (i <= 0 || j2 <= 0) {
            return;
        }
        try {
            Uri uri = Uri.parse(str2);
            String host = uri.getHost();
            String path = uri.getPath();
            String lastPathSegment = uri.getLastPathSegment();
            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (Throwable unused) {
                }
            }
            if (z) {
                errorMessage = null;
                errorCode = 1;
            } else if (z2) {
                errorMessage = null;
                errorCode = 2;
            } else if (baseException != null) {
                errorCode = !c.ah(com.ss.android.socialbase.downloader.downloader.ah.k()) ? 1049 : baseException.getErrorCode();
                errorMessage = baseException.getErrorMessage();
            } else {
                errorMessage = null;
                errorCode = 0;
            }
            ?? jSONObject2 = new JSONObject();
            String strC = "";
            if (nyVar != null) {
                i2 = nyVar instanceof ka ? 0 : 1;
                String strMs = nyVar.ms("X-Cache");
                ?? Contains = TextUtils.isEmpty(strMs) ? -1 : strMs.toLowerCase().contains("hit");
                msVar.ms("monitor_sla", 1);
                strC = nyVar instanceof com.ss.android.socialbase.downloader.network.ms ? ((com.ss.android.socialbase.downloader.network.ms) nyVar).c() : "";
                r2 = Contains;
            } else {
                r2 = -1;
                i2 = -1;
            }
            double d = j / 1048576.0d;
            double d2 = j2;
            double nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
            jSONObject2.put("setting_tag", msVar.ah("setting_tag"));
            jSONObject2.put("url_host", host);
            jSONObject2.putOpt("host_ip", str3);
            jSONObject2.putOpt("host_real_ip", str4);
            jSONObject2.put("url_path", path);
            jSONObject2.put("url_last_path_segment", lastPathSegment);
            jSONObject2.put("net_lib", i2);
            jSONObject2.put("hit_cdn_cache", r2);
            jSONObject2.put(f.z, errorCode);
            jSONObject2.put("request_log", strC);
            if (errorMessage != null) {
                jSONObject2.put("error_msg", c.ms(errorMessage, msVar.ms("exception_msg_length", 500)));
            }
            jSONObject2.put("download_sec", nanos);
            jSONObject2.put("download_mb", d);
            if (nanos > 0.0d) {
                jSONObject2.put("download_speed", d / nanos);
            }
            if (z3) {
                jSONObject2.put("rw_read_time", j3 / d2);
                jSONObject2.put("rw_write_time", j4 / d2);
                jSONObject2.put("rw_sync_time", j5 / d2);
            }
            jSONObject2.put(g.a.g, downloadInfo.getPackageName());
            jSONObject2.put(Common.System.NAME, downloadInfo.getTitle());
            if (i == 1 || i == 3) {
                com.ss.android.socialbase.downloader.downloader.ah.ab();
            }
            if (i == 2 || i == 3) {
                com.ss.android.socialbase.downloader.downloader.ah.fm().ms(downloadInfo.getId(), str, jSONObject2);
            }
        } catch (Throwable th) {
            ab.ms(th);
        }
    }

    public static void ms(DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.c.ny> list) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.ss.android.socialbase.downloader.c.ny.ms(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            ah ahVarFm = com.ss.android.socialbase.downloader.downloader.ah.fm();
            if (ahVarFm != null) {
                ahVarFm.ms(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            ab.ms(th);
        }
    }
}
