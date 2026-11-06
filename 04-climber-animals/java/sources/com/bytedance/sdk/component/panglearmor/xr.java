package com.bytedance.sdk.component.panglearmor;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile xr f1318ms;
    private final ah xr;

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

    private xr(Application application) {
        this.xr = ah.ms(application);
    }

    public static xr ms(Application application) {
        if (f1318ms == null) {
            synchronized (xr.class) {
                if (f1318ms == null) {
                    f1318ms = new xr(application);
                    application.registerActivityLifecycleCallbacks(f1318ms);
                }
            }
        }
        return f1318ms;
    }

    public void xr(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public String ms(String str, long j, int i, boolean z) {
        ah ahVar = this.xr;
        if (ahVar != null) {
            return ahVar.ms(str, j, i, z);
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        ah ahVar = this.xr;
        if (ahVar != null) {
            ahVar.ms(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT >= 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        ms.ms(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT < 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        ms.ms(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        ah ahVar = this.xr;
        if (ahVar != null) {
            ahVar.xr(activity);
        }
    }
}
