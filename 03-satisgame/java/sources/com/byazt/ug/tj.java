package com.byazt.ug;

import com.byazt.os.DownloadShortInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public static int n(int i, int i2) {
        return (i2 <= 0 || i2 >= 100 || !n(i)) ? i2 : (int) (Math.sqrt(i2) * 10.0d);
    }

    public static long n(int i, long j, long j2) {
        if (!n(i)) {
            return j;
        }
        if (j <= 0) {
            return 0L;
        }
        return j2 <= 0 ? j : (j2 * ((long) n(i, (int) ((j * 100) / j2)))) / 100;
    }

    public static DownloadShortInfo n(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && n((int) downloadShortInfo.id)) {
            downloadShortInfo.currentBytes = n((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    private static boolean n(int i) {
        return com.byazt.f.n.n(i).n("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.byazt.f.n.n(i).n("pause_optimise_switch", 0) == 1;
    }
}
