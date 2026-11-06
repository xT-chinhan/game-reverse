package com.byazt.e;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.byazt.i.cd;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 837})
public class RetryJobSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.byazt.xv.s.n(this);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        int jobId = jobParameters.getJobId();
        com.byazt.fe.n.s("RetrySchedulerService", "onStartJob, id = ".concat(String.valueOf(jobId)));
        cd.n().n(jobId);
        return false;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (com.byazt.xv.s.tj()) {
            return 2;
        }
        return iOnStartCommand;
    }

    public static void n(DownloadInfo downloadInfo, long j, boolean z, int i) {
        Context contextU;
        long j2;
        com.byazt.xv.cd reserveWifiStatusListener;
        com.byazt.xv.cd reserveWifiStatusListener2;
        if (downloadInfo == null || j <= 0 || (contextU = com.byazt.xv.s.u()) == null) {
            return;
        }
        int i2 = 2;
        if (downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener2 = Downloader.getInstance(com.byazt.xv.s.u()).getReserveWifiStatusListener()) != null) {
            reserveWifiStatusListener2.n(downloadInfo, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) contextU.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            try {
                jobScheduler.cancel(downloadInfo.getId());
            } catch (Throwable unused) {
            }
            if (i == 0 || (z && i != 2)) {
                j = 1000;
                j2 = 0;
            } else {
                j2 = 60000 + j;
            }
            JobInfo.Builder minimumLatency = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(contextU.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
            if (!z) {
                i2 = 1;
            }
            JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i2).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j2 > 0) {
                requiresDeviceIdle.setOverrideDeadline(j2);
            }
            int iSchedule = jobScheduler.schedule(requiresDeviceIdle.build());
            if (iSchedule > 0 && downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener = Downloader.getInstance(com.byazt.xv.s.u()).getReserveWifiStatusListener()) != null) {
                reserveWifiStatusListener.n(downloadInfo, 3, 3);
            }
            if (iSchedule <= 0) {
                com.byazt.fe.n.q("RetrySchedulerService", "schedule err errCode = ".concat(String.valueOf(iSchedule)));
            }
        } catch (Throwable unused2) {
        }
    }
}
