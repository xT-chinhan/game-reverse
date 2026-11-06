package com.byazt.yi;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 586, 121})
public class x implements Application.ActivityLifecycleCallbacks {
    public static volatile x pr = null;
    public final c hw;

    private x(Application application) {
        this.hw = c.pr(application);
    }

    public static x pr(Application application) {
        if (pr == null) {
            synchronized (x.class) {
                if (pr == null) {
                    pr = new x(application);
                    application.registerActivityLifecycleCallbacks(pr);
                }
            }
        }
        return pr;
    }

    public void hw(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public String pr(String str, long j, int i, boolean z) {
        c cVar = this.hw;
        if (cVar != null) {
            return cVar.pr(str, j, i, z);
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        c cVar = this.hw;
        if (cVar != null) {
            cVar.pr(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT < 29 && activity != null && activity.getWindow() != null && (decorView = activity.getWindow().getDecorView()) != null) {
            hn.pr(decorView);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT >= 29 && activity != null && activity.getWindow() != null && (decorView = activity.getWindow().getDecorView()) != null) {
            hn.pr(decorView);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        c cVar = this.hw;
        if (cVar != null) {
            cVar.hw(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }
}
