package com.ss.android.downloadlib.addownload.ah;

import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.downloadlib.ab.hi;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.qv;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class ms implements qv {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f4358ms;

    public void ms(int i) {
        this.f4358ms = i;
    }

    @Override // com.ss.android.socialbase.downloader.depend.qv
    public boolean ms(long j, long j2, h hVar) throws Throwable {
        long j3;
        com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(this.f4358ms);
        if (!ms(msVarMs)) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        d.ms().ah();
        long jXr = zb.xr(0L);
        ms();
        long jXr2 = zb.xr(0L);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jXr2 < j2) {
            long jXr3 = xr(msVarMs);
            if (jXr3 > 0) {
                jXr2 = zb.xr(0L);
            }
            j3 = jXr3;
        } else {
            j3 = 0;
        }
        hi.xr("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + jXr2 + ", cleaned = " + (jXr2 - jXr), null);
        long j4 = jXr2;
        ms(jXr, jXr2, j2, jCurrentTimeMillis2, j3);
        if (j4 < j2) {
            return false;
        }
        if (hVar == null) {
            return true;
        }
        hVar.ms();
        return true;
    }

    private boolean ms(com.ss.android.socialbase.downloader.ab.ms msVar) {
        if (msVar.ms("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - d.ms().xr() >= msVar.ms("clear_space_min_time_interval", 600000L);
    }

    private void ms() throws Throwable {
        com.ss.android.downloadlib.addownload.hi.ao();
        ah.ms();
        ah.xr();
    }

    private long xr(com.ss.android.socialbase.downloader.ab.ms msVar) {
        long jMs = msVar.ms("clear_space_sleep_time", 0L);
        if (jMs <= 0) {
            return 0L;
        }
        if (jMs > 5000) {
            jMs = 5000;
        }
        hi.xr("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = ".concat(String.valueOf(jMs)), null);
        try {
            Thread.sleep(jMs);
        } catch (InterruptedException e) {
            ab.ms(e);
        }
        hi.xr("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return jMs;
    }

    private void ms(long j, long j2, long j3, long j4, long j5) {
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.hi.getContext()).getDownloadInfo(this.f4358ms);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.ms.ms().ms(downloadInfo, j, j2, j3, j4, j5, j2 > j3);
        } catch (Exception e) {
            ab.ms(e);
        }
    }
}
