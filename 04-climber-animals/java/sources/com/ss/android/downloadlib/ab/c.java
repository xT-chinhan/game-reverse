package com.ss.android.downloadlib.ab;

import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static void ms(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            ah(downloadInfo, jSONObject);
            com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo);
            if (xrVarMs == null) {
                return;
            }
            jSONObject.put("is_update_download", xrVarMs.am() ? 1 : 2);
            ms(xrVarMs, jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    public static void xr(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.ss.android.downloadad.api.ms.xr xrVarMs;
        if (jSONObject == null || (xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo)) == null) {
            return;
        }
        try {
            ah(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - xrVarMs.qf()));
            jSONObject.putOpt("click_download_size", Long.valueOf(xrVarMs.l()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            xrVarMs.op();
            com.ss.android.downloadlib.addownload.xr.ny.ms().ms(xrVarMs);
            jSONObject.put("click_pause_times", xrVarMs.yu());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            jSONObject.put("download_percent", (curBytes < 0 || totalBytes <= 0) ? 0.0d : curBytes / totalBytes);
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jJw = xrVarMs.jw();
            if (jJw > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - jJw);
            }
            long jLe = xrVarMs.le();
            if (jLe > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - jLe);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(xrVarMs.of()));
            jSONObject.putOpt("fail_msg", xrVarMs.p());
            jSONObject.put("download_failed_times", xrVarMs.i());
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.ka.d.ms() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    public static void ah(DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt("app_name", downloadInfo.getTitle());
                jSONObject.putOpt("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.putOpt("save_path", downloadInfo.getSavePath());
                jSONObject.putOpt("file_name", downloadInfo.getName());
                jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.getRealStatus()));
                com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo.getId());
                if (xrVarMs != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(xrVarMs.qf()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(xrVarMs.l()));
                }
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
                return;
            }
        }
        int i = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.ka.d.ms() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(com.ss.android.socialbase.downloader.ny.c.ah(com.ss.android.downloadlib.addownload.hi.getContext()) ? 1 : 2));
        if (!com.ss.android.socialbase.downloader.ny.c.xr(com.ss.android.downloadlib.addownload.hi.getContext())) {
            i = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i));
    }

    public static void ms(com.ss.android.downloadad.api.ms.xr xrVar, JSONObject jSONObject) {
        if (jSONObject == null || xrVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", xrVar.tz() ? 1 : 0);
            jSONObject.put("origin_mime_type", xrVar.sa());
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    public static void ms(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        JSONArray jSONArrayKa = com.ss.android.socialbase.downloader.ab.ms.ms(i).ka("ah_report_config");
        if (jSONArrayKa != null) {
            for (int i2 = 0; i2 < jSONArrayKa.length(); i2++) {
                try {
                    String string = jSONArrayKa.getString(i2);
                    com.ss.android.socialbase.appdownloader.ab.ms msVarMs = com.ss.android.socialbase.appdownloader.c.ms.ms(string);
                    if (msVarMs != null) {
                        jSONObject.put(string.replaceAll("\\.", "_"), msVarMs.c() + "_" + msVarMs.ab());
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.xr.ms(com.ss.android.socialbase.downloader.downloader.ah.k()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject ms(JSONObject jSONObject, com.ss.android.downloadad.api.ms.ms msVar) {
        zb.ms(jSONObject, AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, zb.ms(msVar.c(), "open_url_not_exist"));
        return jSONObject;
    }

    public static JSONObject xr(JSONObject jSONObject, com.ss.android.downloadad.api.ms.ms msVar) {
        zb.ms(jSONObject, com.ss.android.socialbase.appdownloader.c.ka.ch().replaceAll("\\.", "_") + " versionCode", Integer.valueOf(zb.xr(com.ss.android.downloadlib.addownload.hi.getContext(), com.ss.android.socialbase.appdownloader.c.ka.ch())));
        zb.ms(jSONObject, com.ss.android.socialbase.appdownloader.c.ka.ch().replaceAll("\\.", "_") + " versionName", zb.ah(com.ss.android.downloadlib.addownload.hi.getContext(), com.ss.android.socialbase.appdownloader.c.ka.ch()));
        return jSONObject;
    }

    public static void ms(JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.ss.android.socialbase.appdownloader.c.d.ms());
            jSONObject.putOpt("harmony_release_type", com.ss.android.socialbase.appdownloader.c.d.ah());
            jSONObject.putOpt("harmony_build_version", com.ss.android.socialbase.appdownloader.c.d.d());
            int i = 1;
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.c.d.ms(com.ss.android.downloadlib.addownload.hi.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.c.d.ka() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.ss.android.socialbase.appdownloader.c.d.xr());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.c.d.xr(com.ss.android.downloadlib.addownload.hi.getContext()) ? 1 : 2));
            if (!com.ss.android.socialbase.appdownloader.c.d.c()) {
                i = 2;
            }
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(i));
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }
}
