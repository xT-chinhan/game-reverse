package com.ss.android.socialbase.appdownloader;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.qv;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class RetryJobSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.ah.ms(this);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        int jobId = jobParameters.getJobId();
        com.ss.android.socialbase.downloader.ah.ms.ah("RetrySchedulerService", "onStartJob, id = ".concat(String.valueOf(jobId)));
        qv.ms().ms(jobId);
        return false;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.downloader.ah.ch()) {
            return 2;
        }
        return iOnStartCommand;
    }

    static void ms(DownloadInfo downloadInfo, long j, boolean z, int i) {
        Context contextK;
        long j2;
        com.ss.android.socialbase.downloader.downloader.qv reserveWifiStatusListener;
        com.ss.android.socialbase.downloader.downloader.qv reserveWifiStatusListener2;
        if (downloadInfo == null || j <= 0 || (contextK = com.ss.android.socialbase.downloader.downloader.ah.k()) == null) {
            return;
        }
        int i2 = 2;
        if (downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener2 = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).getReserveWifiStatusListener()) != null) {
            reserveWifiStatusListener2.ms(downloadInfo, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) contextK.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            try {
                jobScheduler.cancel(downloadInfo.getId());
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
            if (i == 0 || (z && i != 2)) {
                j = 1000;
                j2 = 0;
            } else {
                j2 = 60000 + j;
            }
            JobInfo.Builder minimumLatency = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(contextK.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j);
            if (!z) {
                i2 = 1;
            }
            JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i2).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j2 > 0) {
                requiresDeviceIdle.setOverrideDeadline(j2);
            }
            int iSchedule = jobScheduler.schedule(requiresDeviceIdle.build());
            if (iSchedule > 0 && downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).getReserveWifiStatusListener()) != null) {
                reserveWifiStatusListener.ms(downloadInfo, 3, 3);
            }
            if (iSchedule <= 0) {
                com.ss.android.socialbase.downloader.ah.ms.d("RetrySchedulerService", "schedule err errCode = ".concat(String.valueOf(iSchedule)));
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th2);
        }
    }
}
