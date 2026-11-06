package com.anythink.basead.exoplayer.scheduler;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.anythink.basead.exoplayer.k.af;

/* JADX INFO: loaded from: classes.dex */
public final class PlatformScheduler implements c {
    private static final String b = "PlatformScheduler";
    private static final String c = "service_action";
    private static final String d = "service_package";
    private static final String e = "requirements";
    private final int f;
    private final ComponentName g;
    private final JobScheduler h;

    private static void b() {
    }

    private static /* synthetic */ void c() {
    }

    private PlatformScheduler(Context context, int i) {
        this.f = i;
        this.g = new ComponentName(context, (Class<?>) PlatformSchedulerService.class);
        this.h = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.anythink.basead.exoplayer.scheduler.c
    public final boolean a(a aVar, String str, String str2) {
        int i;
        JobInfo.Builder builder = new JobInfo.Builder(this.f, this.g);
        int iA = aVar.a();
        if (iA == 0) {
            i = 0;
        } else if (iA != 1) {
            i = 2;
            if (iA != 2) {
                i = 3;
                if (iA != 3) {
                    i = 4;
                    if (iA == 4) {
                        if (af.a < 26) {
                            throw new UnsupportedOperationException();
                        }
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else if (af.a < 24) {
                    throw new UnsupportedOperationException();
                }
            }
        } else {
            i = 1;
        }
        builder.setRequiredNetworkType(i);
        builder.setRequiresDeviceIdle(aVar.c());
        builder.setRequiresCharging(aVar.b());
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(c, str2);
        persistableBundle.putString(d, str);
        persistableBundle.putInt(e, aVar.d());
        builder.setExtras(persistableBundle);
        return this.h.schedule(builder.build()) == 1;
    }

    @Override // com.anythink.basead.exoplayer.scheduler.c
    public final boolean a() {
        this.h.cancel(this.f);
        return true;
    }

    private static JobInfo a(int i, ComponentName componentName, a aVar, String str, String str2) {
        int i2;
        JobInfo.Builder builder = new JobInfo.Builder(i, componentName);
        int iA = aVar.a();
        if (iA == 0) {
            i2 = 0;
        } else if (iA != 1) {
            i2 = 2;
            if (iA != 2) {
                i2 = 3;
                if (iA != 3) {
                    i2 = 4;
                    if (iA == 4) {
                        if (af.a < 26) {
                            throw new UnsupportedOperationException();
                        }
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else if (af.a < 24) {
                    throw new UnsupportedOperationException();
                }
            }
        } else {
            i2 = 1;
        }
        builder.setRequiredNetworkType(i2);
        builder.setRequiresDeviceIdle(aVar.c());
        builder.setRequiresCharging(aVar.b());
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(c, str);
        persistableBundle.putString(d, str2);
        persistableBundle.putInt(e, aVar.d());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    public static final class PlatformSchedulerService extends JobService {
        @Override // android.app.job.JobService
        public final boolean onStopJob(JobParameters jobParameters) {
            return false;
        }

        @Override // android.app.job.JobService
        public final boolean onStartJob(JobParameters jobParameters) {
            PersistableBundle extras = jobParameters.getExtras();
            if (new a(extras.getInt(PlatformScheduler.e)).a(this)) {
                String string = extras.getString(PlatformScheduler.c);
                af.a((Context) this, new Intent(string).setPackage(extras.getString(PlatformScheduler.d)));
                return false;
            }
            jobFinished(jobParameters, true);
            return false;
        }
    }
}
