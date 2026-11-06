package com.anythink.basead.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    private static final int d = 1;
    private static final int e = 2;
    private static final int f = 3;
    private static final int g = 4;
    int a;
    private int h;
    boolean c = false;
    ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap<>(3);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        this.a++;
        this.b.put(activity.toString(), Boolean.TRUE);
        a(1, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        com.anythink.basead.c.a().c();
        a(2, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        com.anythink.basead.c.a().c = true;
        a(3, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        com.anythink.basead.c.a().b = true;
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
        a(4, activity);
    }

    private void a(int i, Activity activity) {
        if (i == 2) {
            int i2 = this.h;
            this.h = activity != null ? activity.hashCode() : i2;
            if (i2 == 0) {
                com.anythink.basead.c.a().a(true);
            }
            com.anythink.basead.c.a().a(activity);
            return;
        }
        if (i == 3) {
            if (this.h != 0 || activity == null) {
                return;
            }
            this.h = activity.hashCode();
            return;
        }
        if (i == 4 && activity != null && activity.hashCode() == this.h) {
            this.h = 0;
            com.anythink.basead.c.a().a(false);
        }
    }
}
