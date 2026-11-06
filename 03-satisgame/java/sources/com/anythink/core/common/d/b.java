package com.anythink.core.common.d;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
    private static volatile b c = null;
    private static final long f = 500;
    private volatile boolean d;
    private String e;
    private Runnable k;
    private final Handler g = new Handler(Looper.getMainLooper());
    private int h = 0;
    private boolean i = true;
    private boolean j = false;
    private final List<Application.ActivityLifecycleCallbacks> l = new ArrayList();
    private final Set<WeakReference<a>> b = new HashSet();

    public interface a {
        void onCreate(Activity activity);

        void onDestroy(Activity activity);

        void onPause(Activity activity);

        void onResume(Activity activity);

        void onStart(Activity activity);

        void onStop(Activity activity);
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.h;
        bVar.h = i + 1;
        return i;
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.h;
        bVar.h = i - 1;
        return i;
    }

    b() {
    }

    public final String a() {
        return this.e;
    }

    public final boolean b() {
        return this.i;
    }

    public final void a(Application application) {
        try {
            if (this.d) {
                return;
            }
            if (application != null) {
                application.registerActivityLifecycleCallbacks(new AnonymousClass1());
            }
            this.d = true;
        } catch (Throwable unused) {
        }
    }

    public static b c() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.b$1, reason: invalid class name */
    final class AnonymousClass1 implements Application.ActivityLifecycleCallbacks {
        AnonymousClass1() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            b.a(b.this);
            if (b.this.h == 1 && b.this.i) {
                b.this.i = false;
                s.b().e(true);
            }
            b.this.j = false;
            s.b().a(activity);
            b.a(b.this, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            b.this.e = activity.getClass().getName();
            b.a(b.this, activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            b.this.e = activity.getClass().getName();
            b.b(b.this, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            b.c(b.this, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            b.d(b.this);
            b.this.j = activity.isChangingConfigurations();
            try {
                if (b.this.k != null) {
                    b.this.g.removeCallbacks(b.this.k);
                }
                b.this.k = new Runnable() { // from class: com.anythink.core.common.d.b.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (b.this.h != 0 || b.this.j) {
                            return;
                        }
                        b.this.i = true;
                        s.b().e(false);
                    }
                };
                b.this.g.postDelayed(b.this.k, 500L);
            } catch (Throwable unused) {
            }
            b.d(b.this, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            b.this.a(activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            b.e(b.this, activity);
        }
    }

    private void b(Application application) {
        if (application == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new AnonymousClass1());
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
            synchronized (this.l) {
                if (!this.l.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.l) {
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
            synchronized (this.l) {
                if (!this.l.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.l) {
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
            synchronized (this.l) {
                if (!this.l.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.l) {
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
            synchronized (this.l) {
                if (!this.l.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.l) {
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
            com.anythink.core.common.e.a.a().a(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void d(Activity activity) {
        try {
            synchronized (this.l) {
                if (!this.l.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.l) {
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
            synchronized (this.l) {
                if (!this.l.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.l) {
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
            synchronized (this.l) {
                if (!this.l.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.l) {
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
            synchronized (this.l) {
                if (!this.l.contains(activityLifecycleCallbacks)) {
                    this.l.add(activityLifecycleCallbacks);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void a(b bVar, Activity activity) {
        try {
            synchronized (bVar.l) {
                if (!bVar.l.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : bVar.l) {
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
            synchronized (bVar.l) {
                if (!bVar.l.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : bVar.l) {
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
            synchronized (bVar.l) {
                if (!bVar.l.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : bVar.l) {
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
            com.anythink.core.common.e.a.a().a(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static /* synthetic */ void c(b bVar, Activity activity) {
        try {
            synchronized (bVar.l) {
                if (!bVar.l.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : bVar.l) {
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
            synchronized (bVar.l) {
                if (!bVar.l.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : bVar.l) {
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
            synchronized (bVar.l) {
                if (!bVar.l.isEmpty()) {
                    for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : bVar.l) {
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
