package com.byazt.eld;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadModel;
import com.byazt.lj.Downloader;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, 109})
public class w {
    public volatile boolean c;
    public volatile boolean fw;
    public volatile DownloadInfo hn;
    public volatile DownloadInfo hw;
    public volatile DownloadInfo pr;
    public volatile boolean uc;
    public volatile DownloadInfo x;

    @com.byazt.vzx.pr(pr = {0, 1, 128, 1272})
    private static class pr {
        public static w pr = new w();
    }

    public static w pr() {
        return pr.pr;
    }

    private w() {
        this.pr = null;
        this.hw = null;
        this.hn = null;
        this.x = null;
        this.c = false;
        this.uc = false;
        this.fw = false;
        com.byazt.cvl.c.pr().hw(new Runnable() { // from class: com.byazt.eld.w.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    w.this.hn();
                } catch (Exception e) {
                    com.byazt.vi.hn.pr().pr(false, e, "读取sp出错");
                }
            }
        });
    }

    public void pr(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        if (pr(downloadInfo) && k.ny() != null && k.ny().pr(downloadModel, downloadInfo)) {
            com.byazt.mf.pr.pr().pr("download_unfinished_push_retain", downloadModel.getId());
        }
    }

    public void hw(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        if (pr(downloadInfo, downloadModel) && k.ny() != null && k.ny().hw(downloadModel, downloadInfo)) {
            com.byazt.mf.pr.pr().pr("download_uninstalled_push_retain", downloadModel.getId());
        }
    }

    public long hw() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        if (this.c) {
            return;
        }
        String strValueOf = String.valueOf(hw());
        if (TextUtils.isEmpty(strValueOf)) {
            return;
        }
        SharedPreferences sharedPreferencesPr = com.byazt.zs.aj.pr(k.getContext(), "sp_download_retain", 0);
        if (strValueOf.equals(sharedPreferencesPr.getString("unfinished_pushed_update_time", "0"))) {
            String string = sharedPreferencesPr.getString("unfinished_pushed_id", "0");
            if (string == null) {
                string = "0";
            }
            this.pr = Downloader.getInstance(k.getContext()).getDownloadInfo(Integer.parseInt(string));
        }
        if (strValueOf.equals(sharedPreferencesPr.getString("uninstalled_pushed_update_time", "0"))) {
            String string2 = sharedPreferencesPr.getString("uninstalled_pushed_id", "0");
            if (string2 == null) {
                string2 = "0";
            }
            this.hw = Downloader.getInstance(k.getContext()).getDownloadInfo(Integer.parseInt(string2));
        }
        if (strValueOf.equals(sharedPreferencesPr.getString("unfinished_pop_up_update_time", "0"))) {
            String string3 = sharedPreferencesPr.getString("unfinished_pop_up_id", "0");
            if (string3 == null) {
                string3 = "0";
            }
            this.hn = Downloader.getInstance(k.getContext()).getDownloadInfo(Integer.parseInt(string3));
        }
        if (strValueOf.equals(sharedPreferencesPr.getString("uninstalled_pop_up_update_time", "0"))) {
            String string4 = sharedPreferencesPr.getString("uninstalled_pop_up_id", "0");
            this.x = Downloader.getInstance(k.getContext()).getDownloadInfo(Integer.parseInt(string4 != null ? string4 : "0"));
        }
        this.c = true;
    }

    private boolean pr(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -2;
    }

    private boolean pr(DownloadInfo downloadInfo, DownloadModel downloadModel) {
        return (downloadInfo == null || downloadModel == null || com.byazt.uk.m.pr(downloadModel)) ? false : true;
    }
}
