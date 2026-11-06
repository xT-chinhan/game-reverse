package com.byazt.lb;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.bytedance.pangle.log.ZeusLogger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 48, 13})
public class hw implements Application.ActivityLifecycleCallbacks {
    public Fragment pr;

    public hw(Fragment fragment) {
        this.pr = fragment;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
        if (this.pr.getActivity() != activity || activity.getClassLoader() == this.pr.getClass().getClassLoader()) {
            return;
        }
        try {
            Object obj = bundle.get("androidx.lifecycle.BundlableSavedStateRegistry.key");
            if (obj != null) {
                ((Bundle) obj).remove("android:support:fragments");
            }
            bundle.remove("android:support:fragments");
            ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "clear fragment, Activity:".concat(String.valueOf(activity)));
        } catch (Exception e) {
        }
    }
}
