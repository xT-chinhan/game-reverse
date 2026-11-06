package com.byazt.uk;

import com.byazt.bek.DownloadModel;
import com.byazt.eyv.AdBaseConstants;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static JSONObject pr() {
        return com.byazt.eld.k.aj().optJSONObject(an.aw);
    }

    public static JSONObject pr(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? m.pr(com.byazt.eld.k.aj(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    public static com.byazt.ew.pr hw(DownloadModel downloadModel) {
        return com.byazt.ew.pr.pr(pr(downloadModel));
    }

    public static com.byazt.ew.pr pr(com.byazt.tia.pr prVar) {
        if (prVar == null) {
            return com.byazt.ew.pr.hn();
        }
        if (prVar.qa() != 0) {
            return com.byazt.ew.pr.pr(prVar.qa());
        }
        if (prVar.hn()) {
            return com.byazt.ew.pr.pr(pr());
        }
        if (prVar.lb() != null) {
            return com.byazt.ew.pr.pr(prVar.lb());
        }
        return com.byazt.ew.pr.hn();
    }

    public static int pr(com.byazt.ew.pr prVar) {
        return prVar.pr("external_storage_permission_path_type", 0);
    }

    public static int hn(DownloadModel downloadModel) {
        return pr(hw(downloadModel));
    }

    public static boolean hw(com.byazt.tia.pr prVar) {
        return pr(prVar).pr("pause_reserve_on_wifi", 0) == 1 && prVar.yb();
    }

    public static boolean hn(com.byazt.tia.pr prVar) {
        return pr(prVar).pr("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && prVar.yb();
    }

    public static double pr(int i) {
        return com.byazt.ew.pr.pr(i).pr("clean_min_install_size", 0.0d);
    }

    public static long hw(int i) {
        return com.byazt.ew.pr.pr(i).pr("storage_min_size", 0L);
    }

    public static long hn(int i) {
        return com.byazt.ew.pr.pr(i).pr("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean x(int i) {
        return com.byazt.ew.pr.pr(i).pr("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean c(int i) {
        return com.byazt.ew.pr.pr(i).pr("clean_space_before_download_switch", 0L) == 1;
    }

    public static boolean uc(int i) {
        return com.byazt.ew.pr.pr(i).pr("clean_space_switch", 0) == 1;
    }

    public static boolean fw(int i) {
        return com.byazt.ew.pr.pr(i).pr("clean_app_cache_dir", 0) == 1;
    }

    public static boolean hw(com.byazt.ew.pr prVar) {
        return prVar != null && prVar.pr("kllk_need_rename_apk", 0) == 1;
    }

    public static boolean hw() {
        if (com.byazt.ew.pr.hn().pr("fix_notification_anr")) {
            return true;
        }
        return false;
    }

    public static boolean hn() {
        return com.byazt.eld.k.aj().optInt("is_enable_start_install_again") == 1;
    }

    public static long x() {
        long jOptLong = com.byazt.eld.k.aj().optLong("start_install_interval");
        if (jOptLong == 0) {
            return 300000L;
        }
        return jOptLong;
    }

    public static long c() {
        long jOptLong = com.byazt.eld.k.aj().optLong("next_install_min_interval");
        return jOptLong == 0 ? ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT : jOptLong;
    }

    public static int pr(com.byazt.tia.hw hwVar) {
        return pr((com.byazt.tia.pr) hwVar).pr("ttdownloader_app_install_detect_count", 15);
    }

    public static int hw(com.byazt.tia.hw hwVar) {
        return pr((com.byazt.tia.pr) hwVar).pr("ttdownloader_app_install_detect_interval_ms", AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS);
    }

    public static boolean hn(com.byazt.tia.hw hwVar) {
        return com.byazt.eld.k.aj().optInt("market_install_finish_opt_switch", 0) == 1 || pr((com.byazt.tia.pr) hwVar).pr("market_install_finish_opt_switch", 0) == 1;
    }

    public static boolean x(com.byazt.tia.hw hwVar) {
        return com.byazt.eld.k.aj().optInt("market_install_finish_opt_broadcast", 0) == 1 || pr((com.byazt.tia.pr) hwVar).pr("market_install_finish_opt_broadcast", 0) == 1;
    }

    public static boolean c(com.byazt.tia.hw hwVar) {
        return com.byazt.eld.k.aj().optInt("market_install_finish_opt_polling_thread", 0) == 1 || pr((com.byazt.tia.pr) hwVar).pr("market_install_finish_opt_polling_thread", 0) == 1;
    }

    public static int uc(com.byazt.tia.hw hwVar) {
        return pr((com.byazt.tia.pr) hwVar).pr("app_install_keep_receiver_time_s", 60);
    }

    public static long fw(com.byazt.tia.hw hwVar) {
        return pr((com.byazt.tia.pr) hwVar).pr("ttdownloader_app_install_detect_sum_timestamp", 600000L);
    }
}
