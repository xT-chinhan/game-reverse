package com.byazt.eld;

import com.byazt.cxa.DownloadShortInfo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, 50})
public class vk {
    public static int pr(int i, int i2) {
        if (i2 <= 0 || i2 >= 100 || !pr(i)) {
            return i2;
        }
        return (int) (Math.sqrt(i2) * 10.0d);
    }

    public static long pr(int i, long j, long j2) {
        if (!pr(i)) {
            return j;
        }
        if (j <= 0) {
            return 0L;
        }
        if (j2 <= 0) {
            return j;
        }
        return (j2 * ((long) pr(i, (int) ((j * 100) / j2)))) / 100;
    }

    public static DownloadShortInfo pr(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo == null || !pr((int) downloadShortInfo.id)) {
            return downloadShortInfo;
        }
        downloadShortInfo.currentBytes = pr((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        return downloadShortInfo;
    }

    private static boolean pr(int i) {
        return com.byazt.ew.pr.pr(i).pr("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.byazt.ew.pr.pr(i).pr("pause_optimise_switch", 0) == 1;
    }
}
