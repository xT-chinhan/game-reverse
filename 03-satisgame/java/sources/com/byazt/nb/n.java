package com.byazt.nb;

import com.byazt.je.cd;
import com.byazt.je.hd;
import com.byazt.rz.cp;
import com.byazt.rz.oa;
import com.byazt.ug.d;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1478, 19})
public class n implements cd {
    public int n;

    public void n(int i) {
        this.n = i;
    }

    @Override // com.byazt.je.cd
    public boolean n(long j, long j2, hd hdVar) throws Throwable {
        long j3;
        com.byazt.f.n nVarN = com.byazt.f.n.n(this.n);
        if (!n(nVarN)) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        q.n().s();
        long jQg = oa.qg(0L);
        n();
        long jQg2 = oa.qg(0L);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jQg2 < j2) {
            long jQg3 = qg(nVarN);
            if (jQg3 > 0) {
                jQg2 = oa.qg(0L);
            }
            j3 = jQg3;
        } else {
            j3 = 0;
        }
        cp.qg("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + jQg2 + ", cleaned = " + (jQg2 - jQg), null);
        long j4 = jQg2;
        n(jQg, jQg2, j2, jCurrentTimeMillis2, j3);
        if (j4 < j2) {
            return false;
        }
        if (hdVar == null) {
            return true;
        }
        hdVar.n();
        return true;
    }

    private boolean n(com.byazt.f.n nVar) {
        if (nVar.n("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - q.n().qg() >= nVar.n("clear_space_min_time_interval", 600000L);
    }

    private void n() throws Throwable {
        d.cy();
        s.n();
        s.qg();
    }

    private long qg(com.byazt.f.n nVar) {
        long jN = nVar.n("clear_space_sleep_time", 0L);
        if (jN <= 0) {
            return 0L;
        }
        if (jN > 5000) {
            jN = 5000;
        }
        cp.qg("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = ".concat(String.valueOf(jN)), null);
        try {
            Thread.sleep(jN);
        } catch (InterruptedException unused) {
        }
        cp.qg("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return jN;
    }

    private void n(long j, long j2, long j3, long j4, long j5) {
        DownloadInfo downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(this.n);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.byazt.s.n.n().n(downloadInfo, j, j2, j3, j4, j5, j2 > j3);
        } catch (Exception unused) {
        }
    }
}
