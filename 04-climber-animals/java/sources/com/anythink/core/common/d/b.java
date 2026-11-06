package com.anythink.core.common.d;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String a = "AdLifecycleManager";
    private static volatile b c;
    private volatile boolean d;
    private String e;
    private final List<Application.ActivityLifecycleCallbacks> f = new ArrayList();
    private final Set<WeakReference<a>> b = new HashSet();

    public interface a {
        void onCreate(Activity activity);

        void onDestroy(Activity activity);

        void onPause(Activity activity);

        void onResume(Activity activity);

        void onStart(Activity activity);

        void onStop(Activity activity);
    }

    b() {
    }

    public final String a() {
        return this.e;
    }

    public final void a(Application application) {
        try {
            if (this.d) {
                return;
            }
            if (application == null) {
                Log.e(a, "activityCallBack error, application is null");
            } else {
                application.registerActivityLifecycleCallbacks(new AnonymousClass1());
            }
            this.d = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static b b() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    private void b(Application application) {
        if (application == null) {
            Log.e(a, "activityCallBack error, application is null");
        } else {
            application.registerActivityLifecycleCallbacks(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.b$1, reason: invalid class name */
    final class AnonymousClass1 implements Application.ActivityLifecycleCallbacks {
        AnonymousClass1() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            Log.e(b.a, "onActivityStarted() called with: activity = [" + activity + "]");
            t.b().a(activity);
            b.a(b.this, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            Log.e(b.a, "onActivityCreated() called with: activity = [" + activity + "], savedInstanceState = [" + bundle + "]");
            b.this.e = activity.getClass().getName();
            b.a(b.this, activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            Log.e(b.a, "onActivityResumed() called with: activity = [" + activity + "]");
            b.this.e = activity.getClass().getName();
            b.b(b.this, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            Log.e(b.a, "onActivityPaused() called with: activity = [" + activity + "]");
            b.c(b.this, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            Log.e(b.a, "onActivityStopped() called with: activity = [" + activity + "]");
            b.d(b.this, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Log.e(b.a, "onActivitySaveInstanceState() called with: activity = [" + activity + "], outState = [" + bundle + "]");
            b.this.a(activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            Log.e(b.a, "onActivityDestroyed() called with: activity = [" + activity + "]");
            b.e(b.this, activity);
        }
    }

    public final void a(a aVar) {
        try {
            synchronized (this.b) {
                if (!c(aVar)) {
                    this.b.add(new WeakReference<>(aVar));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean c(a aVar) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.b).iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() == aVar) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private WeakReference<a> d(a aVar) {
        for (WeakReference<a> weakReference : new CopyOnWriteArraySet(this.b)) {
            if (weakReference.get() == aVar) {
                return weakReference;
            }
        }
        return null;
    }

    public final void b(a aVar) {
        try {
            synchronized (this.b) {
                Iterator<WeakReference<a>> it = this.b.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == aVar) {
                        it.remove();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(Activity activity, Bundle bundle) {
        try {
            synchronized (this.f) {
                if (!this.f.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.f) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityCreated(activity, bundle);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(this.b).iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.onCreate(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(Activity activity) {
        try {
            synchronized (this.f) {
                if (!this.f.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.f) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityStarted(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(this.b).iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.onStart(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(Activity activity) {
        try {
            synchronized (this.f) {
                if (!this.f.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.f) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityPaused(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(this.b).iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.onPause(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c(Activity activity) {
        try {
            synchronized (this.f) {
                if (!this.f.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.f) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityResumed(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(this.b).iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.onResume(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d(Activity activity) {
        try {
            synchronized (this.f) {
                if (!this.f.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.f) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityStopped(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(this.b).iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.onStop(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(Activity activity, Bundle bundle) {
        try {
            synchronized (this.f) {
                if (!this.f.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.f) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivitySaveInstanceState(activity, bundle);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void e(Activity activity) {
        try {
            synchronized (this.f) {
                if (!this.f.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.f) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityDestroyed(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(this.b).iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.onDestroy(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        try {
            synchronized (this.f) {
                if (!this.f.contains(activityLifecycleCallbacks)) {
                    this.f.add(activityLifecycleCallbacks);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void a(b bVar, Activity activity) {
        try {
            synchronized (bVar.f) {
                if (!bVar.f.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : bVar.f) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityStarted(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(bVar.b).iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.onStart(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void a(b bVar, Activity activity, Bundle bundle) {
        try {
            synchronized (bVar.f) {
                if (!bVar.f.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : bVar.f) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityCreated(activity, bundle);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(bVar.b).iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.onCreate(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void b(b bVar, Activity activity) {
        try {
            synchronized (bVar.f) {
                if (!bVar.f.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : bVar.f) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityResumed(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(bVar.b).iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.onResume(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void c(b bVar, Activity activity) {
        try {
            synchronized (bVar.f) {
                if (!bVar.f.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : bVar.f) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityPaused(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(bVar.b).iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.onPause(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void d(b bVar, Activity activity) {
        try {
            synchronized (bVar.f) {
                if (!bVar.f.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : bVar.f) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityStopped(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(bVar.b).iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.onStop(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void e(b bVar, Activity activity) {
        try {
            synchronized (bVar.f) {
                if (!bVar.f.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : bVar.f) {
                        if (activityLifecycleCallbacks != null) {
                            activityLifecycleCallbacks.onActivityDestroyed(activity);
                        }
                    }
                }
            }
            Iterator it = new CopyOnWriteArraySet(bVar.b).iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.onDestroy(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
