package com.smartdigimkt.sdk.basead.exoplayer.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.smartdigimkt.u0.a;
import com.smartdigimkt.z0.u;

/* JADX INFO: loaded from: classes3.dex */
public final class PlatformScheduler$PlatformSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        if (!new a(extras.getInt("requirements")).a(this)) {
            jobFinished(jobParameters, true);
            return false;
        }
        String string = extras.getString("service_action");
        u.a((Context) this, new Intent(string).setPackage(extras.getString("service_package")));
        return false;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
