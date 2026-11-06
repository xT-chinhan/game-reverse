package com.byazt.mdu;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.byazt.auw.DownloadInfo;
import com.byazt.lj.Downloader;
import com.byazt.ts.lb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 769})
public class RetryJobSchedulerService extends JobService {
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.byazt.lj.hn.pr(this);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters != null) {
            int jobId = jobParameters.getJobId();
            com.byazt.p000do.pr.hn("RetrySchedulerService", "onStartJob, id = ".concat(String.valueOf(jobId)));
            lb.pr().pr(jobId);
            return false;
        }
        return false;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (com.byazt.lj.hn.vk()) {
            return 2;
        }
        return iOnStartCommand;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public static void pr(DownloadInfo downloadInfo, long j, boolean z, int i) {
        Context contextOf;
        long j2;
        com.byazt.lj.lb reserveWifiStatusListener;
        com.byazt.lj.lb reserveWifiStatusListener2;
        if (downloadInfo == null || j <= 0 || (contextOf = com.byazt.lj.hn.of()) == null) {
            return;
        }
        int i2 = 2;
        if (downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener2 = Downloader.getInstance(com.byazt.lj.hn.of()).getReserveWifiStatusListener()) != null) {
            reserveWifiStatusListener2.pr(downloadInfo, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) contextOf.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            try {
                jobScheduler.cancel(downloadInfo.getId());
            } catch (Throwable th) {
            }
            if (i == 0 || (z && i != 2)) {
                j = 1000;
                j2 = 0;
            } else {
                j2 = 60000 + j;
            }
            JobInfo.Builder minimumLatency = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(contextOf.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
            if (!z) {
                i2 = 1;
            }
            JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i2).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j2 > 0) {
                requiresDeviceIdle.setOverrideDeadline(j2);
            }
            int iSchedule = jobScheduler.schedule(requiresDeviceIdle.build());
            if (iSchedule > 0 && downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener = Downloader.getInstance(com.byazt.lj.hn.of()).getReserveWifiStatusListener()) != null) {
                reserveWifiStatusListener.pr(downloadInfo, 3, 3);
            }
            if (iSchedule <= 0) {
                com.byazt.p000do.pr.x("RetrySchedulerService", "schedule err errCode = ".concat(String.valueOf(iSchedule)));
            }
        } catch (Throwable th2) {
        }
    }
}
