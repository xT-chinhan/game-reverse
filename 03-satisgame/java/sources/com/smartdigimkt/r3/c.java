package com.smartdigimkt.r3;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.v3.e;
import com.smartdigimkt.v3.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static volatile c l;
    public volatile boolean b;
    public volatile WeakReference c;
    public Runnable h;
    public Context j;
    public final Handler d = new Handler(Looper.getMainLooper());
    public int e = 0;
    public boolean f = true;
    public boolean g = false;
    public boolean i = false;
    public final ArrayList k = new ArrayList();
    public final HashSet a = new HashSet();

    public static void a(c cVar, Activity activity) {
        cVar.getClass();
        try {
            synchronized (cVar.k) {
                if (!cVar.k.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : cVar.k) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityPaused(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(cVar.a).iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() != null) {
                    throw new ClassCastException();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(c cVar, Activity activity) {
        cVar.getClass();
        try {
            synchronized (cVar.k) {
                if (!cVar.k.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : cVar.k) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityStopped(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(cVar.a).iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() != null) {
                    throw new ClassCastException();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void c(c cVar, Activity activity) {
        cVar.getClass();
        try {
            synchronized (cVar.k) {
                if (!cVar.k.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : cVar.k) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityDestroyed(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(cVar.a).iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() != null) {
                    throw new ClassCastException();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(c cVar, Activity activity) {
        cVar.getClass();
        try {
            synchronized (cVar.k) {
                if (!cVar.k.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : cVar.k) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityStarted(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(cVar.a).iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() != null) {
                    throw new ClassCastException();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(c cVar, Activity activity) {
        if (cVar.i) {
            return;
        }
        cVar.i = true;
        cVar.e = 1;
        cVar.f = false;
        Context applicationContext = activity != null ? activity.getApplicationContext() : cVar.j;
        f fVarA = f.a();
        fVarA.getClass();
        com.smartdigimkt.q3.f.a().c(new e(fVarA, applicationContext, true));
        SDKContext.getInstance().l = true;
    }

    public static void f(c cVar, Activity activity) {
        cVar.getClass();
        try {
            synchronized (cVar.k) {
                if (!cVar.k.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : cVar.k) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityResumed(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(cVar.a).iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() != null) {
                    throw new ClassCastException();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(c cVar, Activity activity, Bundle bundle) {
        cVar.getClass();
        try {
            synchronized (cVar.k) {
                if (!cVar.k.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : cVar.k) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityCreated(activity, bundle);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(cVar.a).iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() != null) {
                    throw new ClassCastException();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(Application application) {
        try {
            if (this.b) {
                return;
            }
            if (application != null) {
                this.j = application.getApplicationContext();
            }
            if (application != null) {
                application.registerActivityLifecycleCallbacks(new b(this));
            }
            this.b = true;
        } catch (Throwable unused) {
        }
    }

    public static c a() {
        if (l == null) {
            synchronized (c.class) {
                if (l == null) {
                    l = new c();
                }
            }
        }
        return l;
    }

    public final void a(Activity activity, Bundle bundle) {
        try {
            synchronized (this.k) {
                try {
                    if (!this.k.isEmpty()) {
                        for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.k) {
                            if (activityLifecycleCallbacks != null) {
                                activityLifecycleCallbacks.onActivitySaveInstanceState(activity, bundle);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
