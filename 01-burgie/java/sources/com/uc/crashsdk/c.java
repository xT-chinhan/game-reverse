package com.uc.crashsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes3.dex */
final class c implements Application.ActivityLifecycleCallbacks {
    private boolean a = false;
    private boolean b = false;

    c() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (g.L()) {
            b.O();
            synchronized (b.ab) {
                b.ab.remove(activity);
                a(2);
            }
        }
    }

    private void a(Activity activity, int i) {
        if (1 == i) {
            String unused = b.ad = activity.getComponentName().flattenToShortString();
        } else {
            String unused2 = b.ad = "";
        }
        b.D();
        if (g.L()) {
            b.O();
            synchronized (b.ab) {
                b.ab.put(activity, Integer.valueOf(i));
                a(i);
            }
        }
    }

    private void a(int i) {
        boolean z;
        if (e.u()) {
            com.uc.crashsdk.a.a.a("crashsdk", "[LifeCycle] ignore state change while crashing");
            return;
        }
        if (1 != i) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            Iterator it = b.ab.entrySet().iterator();
            while (it.hasNext()) {
                Object value = ((Map.Entry) it.next()).getValue();
                if (value != null && ((Integer) value).intValue() == 1) {
                    z = true;
                    break;
                }
            }
        }
        if (this.a != z) {
            b.b(z);
            this.a = z;
        }
        boolean zIsEmpty = b.ab.isEmpty();
        if (this.b != zIsEmpty) {
            if (zIsEmpty) {
                b.w();
            }
            this.b = zIsEmpty;
        }
    }
}
