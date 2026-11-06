package com.byazt.uk;

import com.byazt.auw.DownloadInfo;
import com.byazt.eyv.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, 5})
public class uc {
    public static void pr(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            hn(downloadInfo, jSONObject);
            com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo);
            if (hwVarPr == null) {
                return;
            }
            jSONObject.put("is_update_download", hwVarPr.o() ? 1 : 2);
            pr(hwVarPr, jSONObject);
        } catch (Throwable th) {
        }
    }

    public static void hw(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.byazt.tia.hw hwVarPr;
        double d;
        if (jSONObject == null || (hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo)) == null) {
            return;
        }
        try {
            hn(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - hwVarPr.nw()));
            jSONObject.putOpt("click_download_size", Long.valueOf(hwVarPr.ie()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            hwVarPr.iu();
            com.byazt.shh.aj.pr().pr(hwVarPr);
            jSONObject.put("click_pause_times", hwVarPr.b());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            if (curBytes >= 0 && totalBytes > 0) {
                d = curBytes / totalBytes;
            } else {
                d = 0.0d;
            }
            jSONObject.put("download_percent", d);
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jE = hwVarPr.e();
            if (jE > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - jE);
            }
            long jVe = hwVarPr.ve();
            if (jVe > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - jVe);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(hwVarPr.y()));
            jSONObject.putOpt("fail_msg", hwVarPr.ww());
            jSONObject.put("download_failed_times", hwVarPr.rc());
            jSONObject.put("can_show_notification", com.byazt.owr.x.pr() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
        }
    }

    public static void hn(DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, downloadInfo.getTitle());
                jSONObject.putOpt("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.putOpt("save_path", downloadInfo.getSavePath());
                jSONObject.putOpt("file_name", downloadInfo.getName());
                jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.getRealStatus()));
                com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo.getId());
                if (hwVarPr != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(hwVarPr.nw()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(hwVarPr.ie()));
                }
            } catch (Exception e) {
                return;
            }
        }
        int i = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.byazt.owr.x.pr() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(com.byazt.tuy.uc.hn(com.byazt.eld.k.getContext()) ? 1 : 2));
        if (!com.byazt.tuy.uc.hw(com.byazt.eld.k.getContext())) {
            i = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i));
    }

    public static void pr(com.byazt.tia.hw hwVar, JSONObject jSONObject) {
        if (jSONObject == null || hwVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", hwVar.bm() ? 1 : 0);
            jSONObject.put("origin_mime_type", hwVar.f());
        } catch (Throwable th) {
        }
    }

    public static void pr(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        JSONArray jSONArrayC = com.byazt.ew.pr.pr(i).c("ah_report_config");
        if (jSONArrayC != null) {
            for (int i2 = 0; i2 < jSONArrayC.length(); i2++) {
                String string = jSONArrayC.getString(i2);
                com.byazt.mdu.uc.pr prVarPr = com.byazt.now.pr.pr(string);
                if (prVarPr != null) {
                    jSONObject.put(string.replaceAll("\\.", "_"), prVarPr.uc() + "_" + prVarPr.fw());
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.byazt.mdu.hw.pr(com.byazt.lj.hn.of()) ? 1 : 2);
        } catch (Throwable th) {
        }
    }

    public static JSONObject pr(JSONObject jSONObject, com.byazt.tia.pr prVar) {
        m.pr(jSONObject, AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, m.pr(prVar.uc(), "open_url_not_exist"));
        return jSONObject;
    }

    public static JSONObject hw(JSONObject jSONObject, com.byazt.tia.pr prVar) {
        m.pr(jSONObject, com.byazt.now.c.vk().replaceAll("\\.", "_") + " versionCode", Integer.valueOf(m.hw(com.byazt.eld.k.getContext(), com.byazt.now.c.vk())));
        m.pr(jSONObject, com.byazt.now.c.vk().replaceAll("\\.", "_") + " versionName", m.hn(com.byazt.eld.k.getContext(), com.byazt.now.c.vk()));
        return jSONObject;
    }

    public static void pr(JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.byazt.now.x.pr());
            jSONObject.putOpt("harmony_release_type", com.byazt.now.x.hn());
            jSONObject.putOpt("harmony_build_version", com.byazt.now.x.x());
            int i = 1;
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.byazt.now.x.pr(com.byazt.eld.k.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.byazt.now.x.c() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.byazt.now.x.hw());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.byazt.now.x.hw(com.byazt.eld.k.getContext()) ? 1 : 2));
            if (!com.byazt.now.x.uc()) {
                i = 2;
            }
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(i));
        } catch (Exception e) {
        }
    }
}
