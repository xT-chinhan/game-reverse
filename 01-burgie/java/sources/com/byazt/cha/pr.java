package com.byazt.cha;

import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.edb.aj;
import com.byazt.edb.c;
import com.byazt.fn.g;
import com.byazt.fn.rc;
import com.byazt.lhc.BaseException;
import com.byazt.lhc.fw;
import com.byazt.lj.yb;
import com.byazt.mg.PluginConstants;
import com.byazt.mrs.DownloadStatus;
import com.byazt.tuy.uc;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.runtime.download.ApkNotificationReceiver;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2342, 37})
public class pr {
    public static void pr(DownloadTask downloadTask, BaseException baseException, int i) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            rc monitorDepend = downloadTask.getMonitorDepend();
            boolean zIsMonitorStatus = DownloadStatus.isMonitorStatus(i);
            if (!zIsMonitorStatus && !(zIsMonitorStatus = pr(downloadInfo.getExtraMonitorStatus(), i)) && monitorDepend != null && (monitorDepend instanceof com.byazt.fn.hn)) {
                zIsMonitorStatus = pr(((com.byazt.fn.hn) monitorDepend).pr(), i);
            }
            if (zIsMonitorStatus) {
                try {
                    g depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.pr(downloadInfo, baseException, i);
                    }
                } catch (Throwable th) {
                }
                pr(monitorDepend, downloadInfo, baseException, i);
                pr(com.byazt.lj.hn.fw(), downloadInfo, baseException, i);
            }
        } catch (Throwable th2) {
        }
    }

    private static boolean pr(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void pr(rc rcVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (rcVar == null) {
            return;
        }
        try {
            String strHw = rcVar.hw();
            if (TextUtils.isEmpty(strHw)) {
                strHw = "default";
            }
            JSONObject jSONObjectPr = pr(strHw, downloadInfo, baseException, i);
            if (jSONObjectPr == null) {
                jSONObjectPr = new JSONObject();
            }
            rcVar.pr(jSONObjectPr);
        } catch (Throwable th) {
        }
    }

    public static void pr(hw hwVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (hwVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject jSONObjectPr = pr(downloadInfo.getMonitorScene(), downloadInfo, baseException, i);
            if (jSONObjectPr == null) {
                jSONObjectPr = new JSONObject();
            }
            if (i == -1) {
                jSONObjectPr.put(NotificationCompat.CATEGORY_STATUS, baseException.getErrorCode());
            } else {
                pr(i, jSONObjectPr, downloadInfo);
            }
        } catch (Throwable th) {
        }
    }

    private static void pr(int i, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        switch (i) {
            case DownloadStatus.PAUSED_BY_DB_INIT /* -5 */:
                str = "download_uncomplete";
                break;
            case -4:
                str = "download_cancel";
                break;
            case -3:
                double downloadSpeed = downloadInfo.getDownloadSpeed();
                if (downloadSpeed >= 0.0d) {
                    jSONObject.put("download_speed", downloadSpeed);
                }
                str = "download_success";
                break;
            case -2:
                str = "download_pause";
                break;
            case -1:
            case 1:
            case 3:
            case 4:
            case 5:
            default:
                str = "";
                break;
            case 0:
                str = "download_create";
                break;
            case 2:
                str = "download_start";
                break;
            case 6:
                str = "download_first_start";
                break;
        }
        jSONObject.put(NotificationCompat.CATEGORY_STATUS, str);
    }

    public static String pr(String str) {
        try {
            if (TextUtils.isDigitsOnly(str)) {
                return String.valueOf(Long.valueOf(str).longValue() % 100);
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    private static JSONObject pr(String str, DownloadInfo downloadInfo, BaseException baseException, int i) {
        String strHw;
        String strPr;
        String strPr2;
        int iHn;
        String strPr3;
        String lastPathSegment;
        String host;
        String path;
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                yb ybVarW = com.byazt.lj.hn.w();
                if (ybVarW == null) {
                    strHw = "";
                    strPr = strHw;
                    strPr2 = strPr;
                    iHn = 0;
                } else {
                    strHw = ybVarW.hw();
                    strPr = pr(strHw);
                    strPr2 = ybVarW.pr();
                    iHn = ybVarW.hn();
                }
                if (baseException == null || !(baseException instanceof fw)) {
                    strPr3 = "";
                } else {
                    strPr3 = ((fw) baseException).pr();
                }
                jSONObject.put("event_page", str);
                jSONObject.put(PluginConstants.KEY_APP_ID, strPr2);
                jSONObject.put("device_id", strHw);
                jSONObject.put("device_id_postfix", strPr);
                jSONObject.put("update_version", iHn);
                jSONObject.put("download_status", i);
                if (downloadInfo != null) {
                    jSONObject.put("setting_tag", com.byazt.ew.pr.pr(downloadInfo.getId()).hn("setting_tag"));
                    jSONObject.put(ApkNotificationReceiver.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
                    jSONObject.put(Common.System.NAME, downloadInfo.getName());
                    jSONObject.put(BreakpointSQLiteKey.URL, downloadInfo.getUrl());
                    jSONObject.put("save_path", downloadInfo.getSavePath());
                    jSONObject.put("download_time", downloadInfo.getDownloadTime());
                    jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                    jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                    int i2 = 1;
                    jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject.put("md5", downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                    jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject.put("is_force", downloadInfo.isForce() ? 1 : 0);
                    jSONObject.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                    jSONObject.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                    jSONObject.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                    jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                    jSONObject.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                    jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                    if (!downloadInfo.isAddListenerToSameTask()) {
                        i2 = 0;
                    }
                    jSONObject.put("add_listener_to_same_task", i2);
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                    jSONObject.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                    jSONObject.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                    jSONObject.put("task_id", TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
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
                                }
                            }
                        }
                        jSONObject.put("url_host", host);
                        jSONObject.put("url_path", path);
                        jSONObject.put("url_last_path_segment", lastPathSegment);
                    } catch (Throwable th2) {
                    }
                }
                jSONObject.put(Constants.ERROR_CODE_FIELD, baseException != null ? baseException.getErrorCode() : 0);
                jSONObject.put(Constants.ERROR_MSG_FIELD, baseException != null ? baseException.getErrorMessage() : "");
                jSONObject.put("request_log", strPr3);
                return jSONObject;
            } catch (JSONException e) {
                return jSONObject;
            }
        } catch (JSONException e2) {
            return null;
        }
    }

    public static void pr(com.byazt.edb.fw fwVar, String str, String str2, long j, String str3, int i, IOException iOException, DownloadInfo downloadInfo) {
        com.byazt.ew.pr prVarPr;
        int iPr;
        String strC;
        int httpStatusCode;
        if (downloadInfo == null || (iPr = (prVarPr = com.byazt.ew.pr.pr(downloadInfo.getId())).pr("monitor_download_connect", 0)) <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        int iHw = -1;
        String errorMessage = null;
        if (fwVar == null) {
            strC = null;
        } else {
            try {
                iHw = fwVar.hw();
            } catch (Throwable th) {
            }
            try {
                if (!(fwVar instanceof com.byazt.edb.pr)) {
                    strC = null;
                } else {
                    strC = ((com.byazt.edb.pr) fwVar).c();
                }
            } catch (Throwable th2) {
                return;
            }
        }
        String strPr = "";
        if (iHw < 200 || iHw >= 400) {
            if (downloadInfo.getCurRetryTime() != 0 && ((httpStatusCode = downloadInfo.getHttpStatusCode()) < 200 || httpStatusCode >= 400)) {
                return;
            }
            if (iOException != null) {
                if (!uc.hn(com.byazt.lj.hn.of())) {
                    iHw = 1049;
                } else {
                    try {
                        uc.pr((Throwable) iOException, "");
                    } catch (BaseException e) {
                        iHw = e.getErrorCode();
                        errorMessage = e.getErrorMessage();
                        if (e instanceof fw) {
                            strPr = ((fw) e).pr();
                        }
                    }
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
            } catch (Throwable th3) {
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("setting_tag", prVarPr.hn("setting_tag"));
            jSONObject.put("url_host", host);
            jSONObject.putOpt("host_ip", str2);
            jSONObject.putOpt("host_real_ip", strC);
            jSONObject.put("url_path", path);
            jSONObject.put("url_last_path_segment", lastPathSegment);
            jSONObject.put("net_lib", i);
            jSONObject.put("connect_type", str3);
            jSONObject.put("status_code", iHw);
            jSONObject.put("request_log", strPr);
            if (errorMessage != null) {
                jSONObject.put(Constants.ERROR_MSG_FIELD, uc.pr(errorMessage, prVarPr.pr("exception_msg_length", 500)));
            }
            jSONObject.put("connect_time", j);
            jSONObject.put("pkg_name", downloadInfo.getPackageName());
            jSONObject.put(Common.System.NAME, downloadInfo.getTitle());
        } catch (JSONException e2) {
        }
        if (iPr == 1 || iPr == 3) {
            com.byazt.lj.hn.fw();
        }
        if (iPr == 2 || iPr == 3) {
            com.byazt.lj.hn.i().pr(downloadInfo.getId(), "download_connect", jSONObject);
        }
    }

    public static void pr(com.byazt.ew.pr prVar, DownloadInfo downloadInfo, String str, aj ajVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        pr("download_io", prVar.hw("monitor_download_io"), prVar, downloadInfo, str, null, null, ajVar, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    public static void pr(com.byazt.ew.pr prVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, aj ajVar, BaseException baseException, long j, long j2) {
        pr("segment_io", prVar.hw("monitor_segment_io"), prVar, downloadInfo, str, str2, str3, ajVar, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [com.byazt.cha.hn] */
    /* JADX WARN: Type inference failed for: r14v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    private static void pr(String str, int i, com.byazt.ew.pr prVar, DownloadInfo downloadInfo, String str2, String str3, String str4, aj ajVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        String errorMessage;
        int errorCode;
        ?? r3;
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
                } catch (Throwable th) {
                }
            }
            if (z) {
                errorMessage = null;
                errorCode = 1;
            } else if (z2) {
                errorMessage = null;
                errorCode = 2;
            } else if (baseException != null) {
                if (!uc.hn(com.byazt.lj.hn.of())) {
                    errorCode = 1049;
                } else {
                    errorCode = baseException.getErrorCode();
                }
                errorMessage = baseException.getErrorMessage();
            } else {
                errorMessage = null;
                errorCode = 0;
            }
            ?? jSONObject2 = new JSONObject();
            String strUc = "";
            ?? Contains = -1;
            if (ajVar == null) {
                r3 = -1;
                i2 = -1;
            } else {
                if (ajVar instanceof c) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                String strPr = ajVar.pr("X-Cache");
                if (!TextUtils.isEmpty(strPr)) {
                    Contains = strPr.toLowerCase().contains("hit");
                }
                prVar.pr("monitor_sla", 1);
                if (!(ajVar instanceof com.byazt.edb.pr)) {
                    r3 = Contains;
                } else {
                    strUc = ((com.byazt.edb.pr) ajVar).uc();
                    r3 = Contains;
                }
            }
            double d = j / 1048576.0d;
            double d2 = j2;
            double nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
            jSONObject2.put("setting_tag", prVar.hn("setting_tag"));
            jSONObject2.put("url_host", host);
            jSONObject2.putOpt("host_ip", str3);
            jSONObject2.putOpt("host_real_ip", str4);
            jSONObject2.put("url_path", path);
            jSONObject2.put("url_last_path_segment", lastPathSegment);
            jSONObject2.put("net_lib", i2);
            jSONObject2.put("hit_cdn_cache", r3);
            jSONObject2.put("status_code", errorCode);
            jSONObject2.put("request_log", strUc);
            if (errorMessage != null) {
                jSONObject2.put(Constants.ERROR_MSG_FIELD, uc.pr(errorMessage, prVar.pr("exception_msg_length", 500)));
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
            jSONObject2.put("pkg_name", downloadInfo.getPackageName());
            jSONObject2.put(Common.System.NAME, downloadInfo.getTitle());
            if (i == 1 || i == 3) {
                com.byazt.lj.hn.fw();
            }
            if (i == 2 || i == 3) {
                com.byazt.lj.hn.i().pr(downloadInfo.getId(), str, jSONObject2);
            }
        } catch (Throwable th2) {
        }
    }

    public static void pr(DownloadInfo downloadInfo, List<com.byazt.stx.aj> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.byazt.stx.aj.pr(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            hn hnVarI = com.byazt.lj.hn.i();
            if (hnVarI != null) {
                hnVarI.pr(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
        }
    }
}
