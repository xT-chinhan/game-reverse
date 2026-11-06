package com.byazt.rz;

import com.byazt.q.AdBaseConstants;
import com.byazt.wm.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 13})
public class w {
    public static void n(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            s(downloadInfo, jSONObject);
            com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(downloadInfo);
            if (qgVarN == null) {
                return;
            }
            jSONObject.put("is_update_download", qgVarN.b() ? 1 : 2);
            n(qgVarN, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void qg(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.byazt.h.qg qgVarN;
        if (jSONObject == null || (qgVarN = com.byazt.vl.w.n().n(downloadInfo)) == null) {
            return;
        }
        try {
            s(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - qgVarN.rf()));
            jSONObject.putOpt("click_download_size", Long.valueOf(qgVarN.dh()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            qgVarN.t();
            com.byazt.vl.rv.n().n(qgVarN);
            jSONObject.put("click_pause_times", qgVarN.h());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            jSONObject.put("download_percent", (curBytes < 0 || totalBytes <= 0) ? 0.0d : curBytes / totalBytes);
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jAn = qgVarN.an();
            if (jAn > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - jAn);
            }
            long jUr = qgVarN.ur();
            if (jUr > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - jUr);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(qgVarN.lh()));
            jSONObject.putOpt("fail_msg", qgVarN.v());
            jSONObject.put("download_failed_times", qgVarN.m());
            jSONObject.put("can_show_notification", com.byazt.j.q.n() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable unused) {
        }
    }

    public static void s(DownloadInfo downloadInfo, JSONObject jSONObject) {
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
                com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(downloadInfo.getId());
                if (qgVarN != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(qgVarN.rf()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(qgVarN.dh()));
                }
            } catch (Exception unused) {
                return;
            }
        }
        int i = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.byazt.j.q.n() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(com.byazt.ta.w.s(com.byazt.ug.d.getContext()) ? 1 : 2));
        if (!com.byazt.ta.w.qg(com.byazt.ug.d.getContext())) {
            i = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i));
    }

    public static void n(com.byazt.h.qg qgVar, JSONObject jSONObject) {
        if (jSONObject == null || qgVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", qgVar.nf() ? 1 : 0);
            jSONObject.put("origin_mime_type", qgVar.ri());
        } catch (Throwable unused) {
        }
    }

    public static void n(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        JSONArray jSONArrayL = com.byazt.f.n.n(i).l("ah_report_config");
        if (jSONArrayL != null) {
            for (int i2 = 0; i2 < jSONArrayL.length(); i2++) {
                try {
                    String string = jSONArrayL.getString(i2);
                    com.byazt.e.w.n nVarN = com.byazt.bk.n.n(string);
                    if (nVarN != null) {
                        jSONObject.put(string.replaceAll("\\.", "_"), nVarN.w() + "_" + nVarN.x());
                    }
                } catch (Throwable unused) {
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.byazt.e.qg.n(com.byazt.xv.s.u()) ? 1 : 2);
        } catch (Throwable unused2) {
        }
    }

    public static JSONObject n(JSONObject jSONObject, com.byazt.h.n nVar) {
        oa.n(jSONObject, AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, oa.n(nVar.w(), "open_url_not_exist"));
        return jSONObject;
    }

    public static JSONObject qg(JSONObject jSONObject, com.byazt.h.n nVar) {
        oa.n(jSONObject, com.byazt.bk.l.tj().replaceAll("\\.", "_") + " versionCode", Integer.valueOf(oa.qg(com.byazt.ug.d.getContext(), com.byazt.bk.l.tj())));
        oa.n(jSONObject, com.byazt.bk.l.tj().replaceAll("\\.", "_") + " versionName", oa.s(com.byazt.ug.d.getContext(), com.byazt.bk.l.tj()));
        return jSONObject;
    }

    public static void n(JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.byazt.bk.q.n());
            jSONObject.putOpt("harmony_release_type", com.byazt.bk.q.s());
            jSONObject.putOpt("harmony_build_version", com.byazt.bk.q.q());
            int i = 1;
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.byazt.bk.q.n(com.byazt.ug.d.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.byazt.bk.q.l() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.byazt.bk.q.qg());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.byazt.bk.q.qg(com.byazt.ug.d.getContext()) ? 1 : 2));
            if (!com.byazt.bk.q.w()) {
                i = 2;
            }
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(i));
        } catch (Exception unused) {
        }
    }
}
