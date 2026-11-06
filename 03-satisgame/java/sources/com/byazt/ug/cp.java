package com.byazt.ug;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.hj.DownloadModel;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 29})
public class cp {
    public volatile boolean l;
    public volatile DownloadInfo n;
    public volatile DownloadInfo q;
    public volatile DownloadInfo qg;
    public volatile DownloadInfo s;
    public volatile boolean w;
    public volatile boolean x;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 570})
    private static class n {
        public static cp n = new cp();
    }

    public static cp n() {
        return n.n;
    }

    private cp() {
        this.n = null;
        this.qg = null;
        this.s = null;
        this.q = null;
        this.l = false;
        this.w = false;
        this.x = false;
        com.byazt.s.l.n().qg(new Runnable() { // from class: com.byazt.ug.cp.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cp.this.s();
                } catch (Exception e) {
                    com.byazt.ch.s.n().n(false, e, "读取sp出错");
                }
            }
        });
    }

    public void n(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        if (n(downloadInfo) && d.ou() != null && d.ou().n(downloadModel, downloadInfo)) {
            com.byazt.vj.n.n().n("download_unfinished_push_retain", downloadModel.getId());
        }
    }

    public void qg(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        if (n(downloadInfo, downloadModel) && d.ou() != null && d.ou().qg(downloadModel, downloadInfo)) {
            com.byazt.vj.n.n().n("download_uninstalled_push_retain", downloadModel.getId());
        }
    }

    public long qg() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.l) {
            return;
        }
        String strValueOf = String.valueOf(qg());
        if (TextUtils.isEmpty(strValueOf)) {
            return;
        }
        SharedPreferences sharedPreferencesN = com.byazt.qp.x.n(d.getContext(), "sp_download_retain", 0);
        if (strValueOf.equals(sharedPreferencesN.getString("unfinished_pushed_update_time", "0"))) {
            String string = sharedPreferencesN.getString("unfinished_pushed_id", "0");
            if (string == null) {
                string = "0";
            }
            this.n = Downloader.getInstance(d.getContext()).getDownloadInfo(Integer.parseInt(string));
        }
        if (strValueOf.equals(sharedPreferencesN.getString("uninstalled_pushed_update_time", "0"))) {
            String string2 = sharedPreferencesN.getString("uninstalled_pushed_id", "0");
            if (string2 == null) {
                string2 = "0";
            }
            this.qg = Downloader.getInstance(d.getContext()).getDownloadInfo(Integer.parseInt(string2));
        }
        if (strValueOf.equals(sharedPreferencesN.getString("unfinished_pop_up_update_time", "0"))) {
            String string3 = sharedPreferencesN.getString("unfinished_pop_up_id", "0");
            if (string3 == null) {
                string3 = "0";
            }
            this.s = Downloader.getInstance(d.getContext()).getDownloadInfo(Integer.parseInt(string3));
        }
        if (strValueOf.equals(sharedPreferencesN.getString("uninstalled_pop_up_update_time", "0"))) {
            String string4 = sharedPreferencesN.getString("uninstalled_pop_up_id", "0");
            this.q = Downloader.getInstance(d.getContext()).getDownloadInfo(Integer.parseInt(string4 != null ? string4 : "0"));
        }
        this.l = true;
    }

    private boolean n(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -2;
    }

    private boolean n(DownloadInfo downloadInfo, DownloadModel downloadModel) {
        return (downloadInfo == null || downloadModel == null || com.byazt.rz.oa.n(downloadModel)) ? false : true;
    }
}
