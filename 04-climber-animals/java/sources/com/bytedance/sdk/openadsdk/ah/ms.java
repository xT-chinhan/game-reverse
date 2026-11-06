package com.bytedance.sdk.openadsdk.ah;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
class ms implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile boolean f1648ms = false;
    private volatile WeakReference<Activity> ah;
    private InterfaceC0260ms d;
    private int xr = 0;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.ah.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0260ms {
        void ms();

        void xr();
    }

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

    ms() {
    }

    public Boolean ms() {
        return Boolean.valueOf(f1648ms);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.xr++;
        f1648ms = false;
        InterfaceC0260ms interfaceC0260ms = this.d;
        if (interfaceC0260ms != null) {
            interfaceC0260ms.xr();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.ah = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.xr - 1;
        this.xr = i;
        if (i == 0) {
            f1648ms = true;
            InterfaceC0260ms interfaceC0260ms = this.d;
            if (interfaceC0260ms != null) {
                interfaceC0260ms.ms();
            }
        }
    }

    public void ms(InterfaceC0260ms interfaceC0260ms) {
        this.d = interfaceC0260ms;
    }

    public Activity xr() {
        if (this.ah == null) {
            return null;
        }
        return this.ah.get();
    }
}
