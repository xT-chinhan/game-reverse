package com.anythink.core.common.d;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Application.ActivityLifecycleCallbacks {
    int a;
    boolean d;
    boolean c = false;
    ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap<>(3);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public g(boolean z) {
        this.d = false;
        if (z) {
            this.d = true;
            a();
        }
        s.b().a(new l() { // from class: com.anythink.core.common.d.g.1
            @Override // com.anythink.core.common.d.l
            public final void a(boolean z2) {
                r rVarC = s.b().c();
                if (z2) {
                    if (rVarC == null || !rVarC.a()) {
                        return;
                    }
                    rVarC.onAppForegroundStatusChanged(true);
                    return;
                }
                if (rVarC == null || !rVarC.a()) {
                    return;
                }
                rVarC.onAppForegroundStatusChanged(false);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        this.a++;
        this.b.put(activity.toString(), Boolean.TRUE);
        if (this.a != 1 || this.d) {
            return;
        }
        this.d = true;
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.d) {
            return;
        }
        this.d = true;
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
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
    }

    private void a() {
        com.anythink.core.common.u.b.c.a().g(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dy, new Runnable() { // from class: com.anythink.core.common.d.g.2
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.t.f.a();
                com.anythink.core.common.h.n nVar = new com.anythink.core.common.h.n();
                com.anythink.core.common.t.e.a(s.b().g());
                com.anythink.core.common.t.e.a(21, nVar);
            }
        }));
    }
}
