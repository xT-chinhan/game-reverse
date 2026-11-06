package com.byazt.tka;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 689, 5})
public class q implements Application.ActivityLifecycleCallbacks {
    public static volatile q n;
    public final l qg;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    private q(Application application) {
        this.qg = l.n(application);
    }

    public static q n(Application application) {
        if (n == null) {
            synchronized (q.class) {
                if (n == null) {
                    n = new q(application);
                    application.registerActivityLifecycleCallbacks(n);
                }
            }
        }
        return n;
    }

    public String n(String str, long j, int i, boolean z) {
        l lVar = this.qg;
        if (lVar != null) {
            return lVar.n(str, j, i, z);
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        l lVar = this.qg;
        if (lVar != null) {
            lVar.n(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT >= 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        s.n(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT < 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        s.n(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        l lVar = this.qg;
        if (lVar != null) {
            lVar.qg(activity);
        }
    }
}
