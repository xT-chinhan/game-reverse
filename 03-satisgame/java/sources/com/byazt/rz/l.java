package com.byazt.rz;

import com.byazt.hj.DownloadModel;
import com.byazt.q.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 18})
public class l {
    public static JSONObject n() {
        return com.byazt.ug.d.rv().optJSONObject("ad");
    }

    public static JSONObject n(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? oa.n(com.byazt.ug.d.rv(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    public static com.byazt.f.n qg(DownloadModel downloadModel) {
        return com.byazt.f.n.n(n(downloadModel));
    }

    public static com.byazt.f.n n(com.byazt.h.n nVar) {
        if (nVar == null) {
            return com.byazt.f.n.s();
        }
        if (nVar.um() != 0) {
            return com.byazt.f.n.n(nVar.um());
        }
        if (nVar.s()) {
            return com.byazt.f.n.n(n());
        }
        if (nVar.cd() != null) {
            return com.byazt.f.n.n(nVar.cd());
        }
        return com.byazt.f.n.s();
    }

    public static int n(com.byazt.f.n nVar) {
        return nVar.n("external_storage_permission_path_type", 0);
    }

    public static int s(DownloadModel downloadModel) {
        return n(qg(downloadModel));
    }

    public static boolean qg(com.byazt.h.n nVar) {
        return n(nVar).n("pause_reserve_on_wifi", 0) == 1 && nVar.hd();
    }

    public static boolean s(com.byazt.h.n nVar) {
        return n(nVar).n("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && nVar.hd();
    }

    public static double n(int i) {
        return com.byazt.f.n.n(i).n("clean_min_install_size", 0.0d);
    }

    public static long qg(int i) {
        return com.byazt.f.n.n(i).n("storage_min_size", 0L);
    }

    public static long s(int i) {
        return com.byazt.f.n.n(i).n("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean q(int i) {
        return com.byazt.f.n.n(i).n("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean l(int i) {
        return com.byazt.f.n.n(i).n("clean_space_before_download_switch", 0L) == 1;
    }

    public static boolean w(int i) {
        return com.byazt.f.n.n(i).n("clean_space_switch", 0) == 1;
    }

    public static boolean x(int i) {
        return com.byazt.f.n.n(i).n("clean_app_cache_dir", 0) == 1;
    }

    public static boolean qg(com.byazt.f.n nVar) {
        return nVar != null && nVar.n("kllk_need_rename_apk", 0) == 1;
    }

    public static boolean qg() {
        return com.byazt.f.n.s().n("fix_notification_anr");
    }

    public static boolean s() {
        return com.byazt.ug.d.rv().optInt("is_enable_start_install_again") == 1;
    }

    public static long q() {
        long jOptLong = com.byazt.ug.d.rv().optLong("start_install_interval");
        if (jOptLong == 0) {
            return 300000L;
        }
        return jOptLong;
    }

    public static long l() {
        long jOptLong = com.byazt.ug.d.rv().optLong("next_install_min_interval");
        if (jOptLong == 0) {
            return 10000L;
        }
        return jOptLong;
    }

    public static int n(com.byazt.h.qg qgVar) {
        return n((com.byazt.h.n) qgVar).n("ttdownloader_app_install_detect_count", 15);
    }

    public static int qg(com.byazt.h.qg qgVar) {
        return n((com.byazt.h.n) qgVar).n("ttdownloader_app_install_detect_interval_ms", AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS);
    }

    public static boolean s(com.byazt.h.qg qgVar) {
        return com.byazt.ug.d.rv().optInt("market_install_finish_opt_switch", 0) == 1 || n((com.byazt.h.n) qgVar).n("market_install_finish_opt_switch", 0) == 1;
    }

    public static boolean q(com.byazt.h.qg qgVar) {
        return com.byazt.ug.d.rv().optInt("market_install_finish_opt_broadcast", 0) == 1 || n((com.byazt.h.n) qgVar).n("market_install_finish_opt_broadcast", 0) == 1;
    }

    public static boolean l(com.byazt.h.qg qgVar) {
        return com.byazt.ug.d.rv().optInt("market_install_finish_opt_polling_thread", 0) == 1 || n((com.byazt.h.n) qgVar).n("market_install_finish_opt_polling_thread", 0) == 1;
    }

    public static int w(com.byazt.h.qg qgVar) {
        return n((com.byazt.h.n) qgVar).n("app_install_keep_receiver_time_s", 60);
    }

    public static long x(com.byazt.h.qg qgVar) {
        return n((com.byazt.h.n) qgVar).n("ttdownloader_app_install_detect_sum_timestamp", 600000L);
    }
}
