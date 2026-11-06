package com.byazt.g;

import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.common.f.h;
import com.byazt.je.m;
import com.byazt.je.sz;
import com.byazt.m.l;
import com.byazt.m.rv;
import com.byazt.qx.BaseException;
import com.byazt.qx.x;
import com.byazt.sk.DownloadStatus;
import com.byazt.ta.w;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
import com.byazt.xv.hd;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1306, 19})
public class n {
    public static void n(DownloadTask downloadTask, BaseException baseException, int i) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            m monitorDepend = downloadTask.getMonitorDepend();
            boolean zIsMonitorStatus = DownloadStatus.isMonitorStatus(i);
            if (!zIsMonitorStatus && !(zIsMonitorStatus = n(downloadInfo.getExtraMonitorStatus(), i)) && monitorDepend != null && (monitorDepend instanceof com.byazt.je.s)) {
                zIsMonitorStatus = n(((com.byazt.je.s) monitorDepend).n(), i);
            }
            if (zIsMonitorStatus) {
                try {
                    sz depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.n(downloadInfo, baseException, i);
                    }
                } catch (Throwable unused) {
                }
                n(monitorDepend, downloadInfo, baseException, i);
                n(com.byazt.xv.s.x(), downloadInfo, baseException, i);
            }
        } catch (Throwable unused2) {
        }
    }

    private static boolean n(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void n(m mVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (mVar == null) {
            return;
        }
        try {
            String strQg = mVar.qg();
            if (TextUtils.isEmpty(strQg)) {
                strQg = "default";
            }
            JSONObject jSONObjectN = n(strQg, downloadInfo, baseException, i);
            if (jSONObjectN == null) {
                jSONObjectN = new JSONObject();
            }
            mVar.n(jSONObjectN);
        } catch (Throwable unused) {
        }
    }

    public static void n(qg qgVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (qgVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject jSONObjectN = n(downloadInfo.getMonitorScene(), downloadInfo, baseException, i);
            if (jSONObjectN == null) {
                jSONObjectN = new JSONObject();
            }
            if (i == -1) {
                jSONObjectN.put("status", baseException.getErrorCode());
            } else {
                n(i, jSONObjectN, downloadInfo);
            }
        } catch (Throwable unused) {
        }
    }

    private static void n(int i, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
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

    public static String n(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static JSONObject n(String str, DownloadInfo downloadInfo, BaseException baseException, int i) {
        String strQg;
        String strN;
        String strN2;
        int iS;
        String lastPathSegment;
        String host;
        String path;
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                hd hdVarCp = com.byazt.xv.s.cp();
                if (hdVarCp != null) {
                    strQg = hdVarCp.qg();
                    strN = n(strQg);
                    strN2 = hdVarCp.n();
                    iS = hdVarCp.s();
                } else {
                    strQg = "";
                    strN = strQg;
                    strN2 = strN;
                    iS = 0;
                }
                String strN3 = (baseException == null || !(baseException instanceof x)) ? "" : ((x) baseException).n();
                jSONObject.put("event_page", str);
                jSONObject.put("app_id", strN2);
                jSONObject.put(TapEventParamConstants.PARAM_DEVICE_ID, strQg);
                jSONObject.put("device_id_postfix", strN);
                jSONObject.put("update_version", iS);
                jSONObject.put("download_status", i);
                if (downloadInfo != null) {
                    jSONObject.put("setting_tag", com.byazt.f.n.n(downloadInfo.getId()).s("setting_tag"));
                    jSONObject.put("download_id", downloadInfo.getId());
                    jSONObject.put(TapEventParamConstants.PARAM_NAME, downloadInfo.getName());
                    jSONObject.put(ImagesContract.URL, downloadInfo.getUrl());
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
                    jSONObject.put(h.b.h, downloadInfo.getRetryCount());
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
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        jSONObject.put("url_host", host);
                        jSONObject.put("url_path", path);
                        jSONObject.put("url_last_path_segment", lastPathSegment);
                    } catch (Throwable unused2) {
                    }
                }
                jSONObject.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
                jSONObject.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
                jSONObject.put("request_log", strN3);
                return jSONObject;
            } catch (JSONException unused3) {
                return jSONObject;
            }
        } catch (JSONException unused4) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0037 A[PHI: r7
      0x0037: PHI (r7v6 int) = (r7v0 int), (r7v2 int) binds: [B:12:0x0023, B:15:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    public static void n(com.byazt.m.x xVar, String str, String str2, long j, String str3, int i, IOException iOException, DownloadInfo downloadInfo) {
        com.byazt.f.n nVarN;
        int iN;
        String strL;
        int errorCode;
        int httpStatusCode;
        if (downloadInfo == null || (iN = (nVarN = com.byazt.f.n.n(downloadInfo.getId())).n("monitor_download_connect", 0)) <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        String errorMessage = null;
        int iQg = -1;
        if (xVar != null) {
            try {
                iQg = xVar.qg();
            } catch (Throwable unused) {
            }
            try {
                if (xVar instanceof com.byazt.m.n) {
                    int i2 = iQg;
                    strL = ((com.byazt.m.n) xVar).l();
                    errorCode = i2;
                } else {
                    errorCode = iQg;
                    strL = null;
                }
            } catch (Throwable unused2) {
                return;
            }
        } else {
            errorCode = iQg;
            strL = null;
        }
        String strN = "";
        if (errorCode < 200 || errorCode >= 400) {
            if (downloadInfo.getCurRetryTime() != 0 && ((httpStatusCode = downloadInfo.getHttpStatusCode()) < 200 || httpStatusCode >= 400)) {
                return;
            }
            if (iOException != null) {
                if (w.s(com.byazt.xv.s.u())) {
                    try {
                        w.n((Throwable) iOException, "");
                    } catch (BaseException e) {
                        errorCode = e.getErrorCode();
                        errorMessage = e.getErrorMessage();
                        if (e instanceof x) {
                            strN = ((x) e).n();
                        }
                    }
                } else {
                    errorCode = 1049;
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
            } catch (Throwable unused3) {
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("setting_tag", nVarN.s("setting_tag"));
            jSONObject.put("url_host", host);
            jSONObject.putOpt("host_ip", str2);
            jSONObject.putOpt("host_real_ip", strL);
            jSONObject.put("url_path", path);
            jSONObject.put("url_last_path_segment", lastPathSegment);
            jSONObject.put("net_lib", i);
            jSONObject.put("connect_type", str3);
            jSONObject.put("status_code", errorCode);
            jSONObject.put("request_log", strN);
            if (errorMessage != null) {
                jSONObject.put("error_msg", w.n(errorMessage, nVarN.n("exception_msg_length", 500)));
            }
            jSONObject.put("connect_time", j);
            jSONObject.put("pkg_name", downloadInfo.getPackageName());
            jSONObject.put(TapEventParamConstants.PARAM_NAME, downloadInfo.getTitle());
        } catch (JSONException unused4) {
        }
        if (iN == 1 || iN == 3) {
            com.byazt.xv.s.x();
        }
        if (iN == 2 || iN == 3) {
            com.byazt.xv.s.wo().n(downloadInfo.getId(), "download_connect", jSONObject);
        }
    }

    public static void n(com.byazt.f.n nVar, DownloadInfo downloadInfo, String str, rv rvVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        n("download_io", nVar.qg("monitor_download_io"), nVar, downloadInfo, str, null, null, rvVar, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    public static void n(com.byazt.f.n nVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, rv rvVar, BaseException baseException, long j, long j2) {
        n("segment_io", nVar.qg("monitor_segment_io"), nVar, downloadInfo, str, str2, str3, rvVar, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.byazt.g.s] */
    /* JADX WARN: Type inference failed for: r14v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    private static void n(String str, int i, com.byazt.f.n nVar, DownloadInfo downloadInfo, String str2, String str3, String str4, rv rvVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
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
                errorCode = !w.s(com.byazt.xv.s.u()) ? 1049 : baseException.getErrorCode();
                errorMessage = baseException.getErrorMessage();
            } else {
                errorMessage = null;
                errorCode = 0;
            }
            ?? jSONObject2 = new JSONObject();
            String strW = "";
            if (rvVar != null) {
                i2 = rvVar instanceof l ? 0 : 1;
                String strN = rvVar.n("X-Cache");
                ?? Contains = TextUtils.isEmpty(strN) ? -1 : strN.toLowerCase().contains("hit");
                nVar.n("monitor_sla", 1);
                strW = rvVar instanceof com.byazt.m.n ? ((com.byazt.m.n) rvVar).w() : "";
                r2 = Contains;
            } else {
                r2 = -1;
                i2 = -1;
            }
            double d = j / 1048576.0d;
            double d2 = j2;
            double nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
            jSONObject2.put("setting_tag", nVar.s("setting_tag"));
            jSONObject2.put("url_host", host);
            jSONObject2.putOpt("host_ip", str3);
            jSONObject2.putOpt("host_real_ip", str4);
            jSONObject2.put("url_path", path);
            jSONObject2.put("url_last_path_segment", lastPathSegment);
            jSONObject2.put("net_lib", i2);
            jSONObject2.put("hit_cdn_cache", r2);
            jSONObject2.put("status_code", errorCode);
            jSONObject2.put("request_log", strW);
            if (errorMessage != null) {
                jSONObject2.put("error_msg", w.n(errorMessage, nVar.n("exception_msg_length", 500)));
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
            jSONObject2.put(TapEventParamConstants.PARAM_NAME, downloadInfo.getTitle());
            if (i == 1 || i == 3) {
                com.byazt.xv.s.x();
            }
            if (i == 2 || i == 3) {
                com.byazt.xv.s.wo().n(downloadInfo.getId(), str, jSONObject2);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void n(DownloadInfo downloadInfo, List<com.byazt.kl.rv> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.byazt.kl.rv.n(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            s sVarWo = com.byazt.xv.s.wo();
            if (sVarWo != null) {
                sVarWo.n(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable unused) {
        }
    }
}
