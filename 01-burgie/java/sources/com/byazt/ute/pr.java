package com.byazt.ute;

import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.fn.lb;
import com.byazt.fn.yb;
import com.byazt.lj.Downloader;
import com.byazt.uk.m;
import com.byazt.uk.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST, 37})
public class pr implements lb {
    public int pr;

    public void pr(int i) {
        this.pr = i;
    }

    @Override // com.byazt.fn.lb
    public boolean pr(long j, long j2, yb ybVar) throws Throwable {
        long j3;
        com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(this.pr);
        if (!pr(prVarPr)) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        x.pr().hn();
        long jHw = m.hw(0L);
        pr();
        long jHw2 = m.hw(0L);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jHw2 >= j2) {
            j3 = 0;
        } else {
            long jHw3 = hw(prVarPr);
            if (jHw3 <= 0) {
                j3 = jHw3;
            } else {
                jHw2 = m.hw(0L);
                j3 = jHw3;
            }
        }
        w.hw("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + jHw2 + ", cleaned = " + (jHw2 - jHw), null);
        long j4 = jHw2;
        pr(jHw, jHw2, j2, jCurrentTimeMillis2, j3);
        if (j4 < j2) {
            return false;
        }
        if (ybVar != null) {
            ybVar.pr();
            return true;
        }
        return true;
    }

    private boolean pr(com.byazt.ew.pr prVar) {
        if (prVar.pr("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - x.pr().hw() >= prVar.pr("clear_space_min_time_interval", 600000L);
    }

    private void pr() throws Throwable {
        k.nt();
        hn.pr();
        hn.hw();
    }

    private long hw(com.byazt.ew.pr prVar) {
        long jPr = prVar.pr("clear_space_sleep_time", 0L);
        if (jPr <= 0) {
            return 0L;
        }
        if (jPr > 5000) {
            jPr = 5000;
        }
        w.hw("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = ".concat(String.valueOf(jPr)), null);
        try {
            Thread.sleep(jPr);
        } catch (InterruptedException e) {
        }
        w.hw("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return jPr;
    }

    private void pr(long j, long j2, long j3, long j4, long j5) {
        boolean z;
        DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(this.pr);
        if (downloadInfo == null) {
            return;
        }
        if (j2 <= j3) {
            z = false;
        } else {
            z = true;
        }
        try {
            com.byazt.cvl.pr.pr().pr(downloadInfo, j, j2, j3, j4, j5, z);
        } catch (Exception e) {
        }
    }
}
