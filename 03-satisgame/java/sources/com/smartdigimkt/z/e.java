package com.smartdigimkt.z;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Application.ActivityLifecycleCallbacks {
    public int c;
    public boolean b = false;
    public final ConcurrentHashMap a = new ConcurrentHashMap(3);

    public final void a(int i, Activity activity) {
        if (i == 2) {
            int i2 = this.c;
            this.c = activity != null ? activity.hashCode() : i2;
            if (i2 == 0) {
                com.smartdigimkt.x.j.a().b(true);
                return;
            }
            return;
        }
        if (i == 3) {
            if (this.c != 0 || activity == null) {
                return;
            }
            this.c = activity.hashCode();
            return;
        }
        if (i == 4 && activity != null && activity.hashCode() == this.c) {
            this.c = 0;
            com.smartdigimkt.x.j.a().b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        com.smartdigimkt.x.j.a().m = true;
        a(3, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.x.j jVarA = com.smartdigimkt.x.j.a();
        int iA = 1;
        boolean z = !jVarA.l && jVarA.m;
        com.smartdigimkt.a0.j jVar = jVarA.k;
        if (jVar != null) {
            com.smartdigimkt.a0.k kVar = jVar.d;
            String str = kVar.a;
            if (z) {
                WeakReference weakReference = kVar.j;
                View view = weakReference != null ? (View) weakReference.get() : null;
                if (view == null) {
                    String str2 = jVar.d.a;
                } else {
                    com.smartdigimkt.p3.i iVar = jVar.d.h;
                    if (iVar != null) {
                        iVar.a();
                        jVar.d.h = null;
                    }
                    com.smartdigimkt.a0.i iVar2 = new com.smartdigimkt.a0.i(jVar);
                    com.smartdigimkt.b3.c cVar = jVar.d.c;
                    if (cVar != null && (eVar = cVar.w) != null) {
                        iA = eVar.a();
                    }
                    com.smartdigimkt.a0.k kVar2 = jVar.d;
                    view.getContext();
                    kVar2.h = new com.smartdigimkt.p3.i(iA, 0);
                    jVar.d.h.a(view, iVar2);
                }
            } else {
                com.smartdigimkt.n3.k.a(kVar.d, kVar.c, jVar.b, jVar.a, 3);
            }
            jVarA.k = null;
        }
        jVarA.m = false;
        jVarA.l = false;
        com.smartdigimkt.x.j.a().a(activity);
        a(2, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        int iHashCode;
        ConcurrentHashMap concurrentHashMap = this.a;
        if (activity == null) {
            iHashCode = 0;
        } else {
            try {
                try {
                    iHashCode = System.identityHashCode(activity);
                } catch (Throwable unused) {
                    iHashCode = activity.hashCode();
                }
            } catch (Throwable unused2) {
                iHashCode = 0;
            }
        }
        concurrentHashMap.put(Integer.valueOf(iHashCode), Boolean.TRUE);
        a(1, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        int iHashCode;
        int iHashCode2;
        com.smartdigimkt.x.j.a().l = true;
        ConcurrentHashMap concurrentHashMap = this.a;
        int i = 0;
        if (activity == null) {
            iHashCode = 0;
        } else {
            try {
                try {
                    iHashCode = System.identityHashCode(activity);
                } catch (Throwable unused) {
                    iHashCode = activity.hashCode();
                }
            } catch (Throwable unused2) {
                iHashCode = 0;
            }
        }
        boolean zContainsKey = concurrentHashMap.containsKey(Integer.valueOf(iHashCode));
        if (!this.b && !zContainsKey) {
            this.b = true;
        }
        if (zContainsKey) {
            try {
                ConcurrentHashMap concurrentHashMap2 = this.a;
                if (activity != null) {
                    try {
                        try {
                            iHashCode2 = System.identityHashCode(activity);
                        } catch (Throwable unused3) {
                            iHashCode2 = activity.hashCode();
                        }
                        i = iHashCode2;
                    } catch (Throwable unused4) {
                    }
                }
                concurrentHashMap2.remove(Integer.valueOf(i));
            } catch (Throwable unused5) {
            }
        }
        a(4, activity);
    }
}
