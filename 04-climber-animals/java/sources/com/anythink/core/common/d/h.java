package com.anythink.core.common.d;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private static final int h = 4;
    int a;
    boolean d;
    private int i;
    boolean c = false;
    ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap<>(3);

    public h(boolean z) {
        this.d = false;
        if (z) {
            this.d = true;
            a();
            s sVarC = t.b().c();
            if (sVarC != null && sVarC.a()) {
                sVarC.onApplicationBoot();
            }
        }
        t.b().e(z);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        activity.getClass().getName();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        activity.getClass().getName();
        this.a++;
        this.b.put(activity.toString(), Boolean.TRUE);
        if (this.a == 1 && !this.d) {
            this.d = true;
            a();
        }
        a(1, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        activity.getClass().getName();
        a(2, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        activity.getClass().getName();
        a(3, activity);
        if (this.d) {
            return;
        }
        this.d = true;
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        activity.getClass().getName();
        this.a--;
        boolean zContainsKey = this.b.containsKey(activity.toString());
        if (!this.c && !zContainsKey) {
            this.c = true;
            this.a++;
        }
        if (zContainsKey) {
            try {
                this.b.remove(activity.toString());
            } catch (Throwable unused) {
            }
        }
        if (this.a == 0) {
            this.d = false;
        }
        a(4, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        activity.getClass().getName();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        activity.getClass().getName();
    }

    private static void a() {
        com.anythink.core.common.u.e.a();
        com.anythink.core.common.u.c.a(t.b().g()).a(21, new com.anythink.core.common.h.n());
    }

    private void a(int i, Activity activity) {
        if (i == 1 || i == 2) {
            int i2 = this.i;
            this.i = activity != null ? activity.hashCode() : i2;
            if (i2 == 0) {
                s sVarC = t.b().c();
                if (sVarC != null && sVarC.a()) {
                    sVarC.onAppForegroundStatusChanged(true);
                }
                t.b().e(true);
                return;
            }
            return;
        }
        if (i == 3) {
            if (this.i != 0 || activity == null) {
                return;
            }
            this.i = activity.hashCode();
            return;
        }
        if (i == 4 && activity != null && activity.hashCode() == this.i) {
            this.i = 0;
            s sVarC2 = t.b().c();
            if (sVarC2 != null && sVarC2.a()) {
                sVarC2.onAppForegroundStatusChanged(false);
            }
            t.b().e(false);
        }
    }
}
