package com.ss.android.downloadlib.ab;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.ss.android.download.api.download.DownloadModel;
import com.umeng.analytics.pro.bv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ka {
    public static JSONObject ms() {
        return com.ss.android.downloadlib.addownload.hi.ny().optJSONObject(bv.aw);
    }

    public static JSONObject ms(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? zb.ms(com.ss.android.downloadlib.addownload.hi.ny(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    public static com.ss.android.socialbase.downloader.ab.ms xr(DownloadModel downloadModel) {
        return com.ss.android.socialbase.downloader.ab.ms.ms(ms(downloadModel));
    }

    public static com.ss.android.socialbase.downloader.ab.ms ms(com.ss.android.downloadad.api.ms.ms msVar) {
        if (msVar == null) {
            return com.ss.android.socialbase.downloader.ab.ms.ah();
        }
        if (msVar.y() != 0) {
            return com.ss.android.socialbase.downloader.ab.ms.ms(msVar.y());
        }
        if (msVar.ah()) {
            return com.ss.android.socialbase.downloader.ab.ms.ms(ms());
        }
        if (msVar.qv() != null) {
            return com.ss.android.socialbase.downloader.ab.ms.ms(msVar.qv());
        }
        return com.ss.android.socialbase.downloader.ab.ms.ah();
    }

    public static int ms(com.ss.android.socialbase.downloader.ab.ms msVar) {
        return msVar.ms("external_storage_permission_path_type", 0);
    }

    public static int ah(DownloadModel downloadModel) {
        return ms(xr(downloadModel));
    }

    public static boolean xr(com.ss.android.downloadad.api.ms.ms msVar) {
        return ms(msVar).ms("pause_reserve_on_wifi", 0) == 1 && msVar.h();
    }

    public static boolean ah(com.ss.android.downloadad.api.ms.ms msVar) {
        return ms(msVar).ms("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && msVar.h();
    }

    public static double ms(int i) {
        return com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("clean_min_install_size", 0.0d);
    }

    public static long xr(int i) {
        return com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("storage_min_size", 0L);
    }

    public static long ah(int i) {
        return com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean d(int i) {
        return com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean ka(int i) {
        return com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("clean_space_before_download_switch", 0L) == 1;
    }

    public static boolean c(int i) {
        return com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("clean_space_switch", 0) == 1;
    }

    public static boolean ab(int i) {
        return com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("clean_app_cache_dir", 0) == 1;
    }

    public static boolean xr(com.ss.android.socialbase.downloader.ab.ms msVar) {
        return msVar != null && msVar.ms("kllk_need_rename_apk", 0) == 1;
    }

    public static boolean xr() {
        return com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_notification_anr");
    }

    public static boolean ah() {
        return com.ss.android.downloadlib.addownload.hi.ny().optInt("is_enable_start_install_again") == 1;
    }

    public static long d() {
        long jOptLong = com.ss.android.downloadlib.addownload.hi.ny().optLong("start_install_interval");
        if (jOptLong == 0) {
            return 300000L;
        }
        return jOptLong;
    }

    public static long ka() {
        long jOptLong = com.ss.android.downloadlib.addownload.hi.ny().optLong("next_install_min_interval");
        return jOptLong == 0 ? ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT : jOptLong;
    }

    public static int ms(com.ss.android.downloadad.api.ms.xr xrVar) {
        return ms((com.ss.android.downloadad.api.ms.ms) xrVar).ms("ttdownloader_app_install_detect_count", 15);
    }

    public static int xr(com.ss.android.downloadad.api.ms.xr xrVar) {
        return ms((com.ss.android.downloadad.api.ms.ms) xrVar).ms("ttdownloader_app_install_detect_interval_ms", 20000);
    }

    public static boolean ah(com.ss.android.downloadad.api.ms.xr xrVar) {
        return com.ss.android.downloadlib.addownload.hi.ny().optInt("market_install_finish_opt_switch", 0) == 1 || ms((com.ss.android.downloadad.api.ms.ms) xrVar).ms("market_install_finish_opt_switch", 0) == 1;
    }

    public static boolean d(com.ss.android.downloadad.api.ms.xr xrVar) {
        return com.ss.android.downloadlib.addownload.hi.ny().optInt("market_install_finish_opt_broadcast", 0) == 1 || ms((com.ss.android.downloadad.api.ms.ms) xrVar).ms("market_install_finish_opt_broadcast", 0) == 1;
    }

    public static boolean ka(com.ss.android.downloadad.api.ms.xr xrVar) {
        return com.ss.android.downloadlib.addownload.hi.ny().optInt("market_install_finish_opt_polling_thread", 0) == 1 || ms((com.ss.android.downloadad.api.ms.ms) xrVar).ms("market_install_finish_opt_polling_thread", 0) == 1;
    }

    public static int c(com.ss.android.downloadad.api.ms.xr xrVar) {
        return ms((com.ss.android.downloadad.api.ms.ms) xrVar).ms("app_install_keep_receiver_time_s", 60);
    }

    public static long ab(com.ss.android.downloadad.api.ms.xr xrVar) {
        return ms((com.ss.android.downloadad.api.ms.ms) xrVar).ms("ttdownloader_app_install_detect_sum_timestamp", 600000L);
    }
}
