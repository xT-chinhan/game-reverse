package com.byazt.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.ta.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 225, 19})
public class n {
    public final Application.ActivityLifecycleCallbacks fs;
    public WeakReference<Activity> l;
    public Application n;
    public int q;
    public s qg;
    public final List<InterfaceC0133n> s;
    public volatile int w;
    public volatile boolean x;

    /* JADX INFO: renamed from: com.byazt.b.n$n, reason: collision with other inner class name */
    public interface InterfaceC0133n {
        void qg();

        void s();
    }

    public interface s {
    }

    public static n n() {
        return qg.n;
    }

    @com.byazt.cp.n(n = {0, 1, 225, 226})
    private static class qg {
        public static final n n = new n();
    }

    private n() {
        this.s = new ArrayList();
        this.w = -1;
        this.x = false;
        this.fs = new Application.ActivityLifecycleCallbacks() { // from class: com.byazt.b.n.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                n.this.l = new WeakReference(activity);
                int i = n.this.q;
                n.this.q = activity != null ? activity.hashCode() : i;
                n.this.x = false;
                if (i == 0) {
                    n.this.l();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i = n.this.q;
                n.this.x = false;
                n.this.q = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    n.this.l();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                n.this.x = true;
                if (n.this.q != 0 || activity == null) {
                    return;
                }
                n.this.q = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == n.this.q) {
                    n.this.q = 0;
                    n.this.w();
                }
                n.this.x = false;
            }
        };
    }

    public void n(Context context) {
        if (this.n == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.n == null) {
                    Application application = (Application) context;
                    this.n = application;
                    application.registerActivityLifecycleCallbacks(this.fs);
                }
            }
        }
    }

    public void n(s sVar) {
        this.qg = sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean qg() {
        int i = this.w;
        ?? r0 = i;
        if (i == -1) {
            ?? X = x();
            this.w = X;
            r0 = X;
        }
        return r0 == 1;
    }

    public boolean s() {
        return qg() && !this.x;
    }

    public void n(InterfaceC0133n interfaceC0133n) {
        if (interfaceC0133n == null) {
            return;
        }
        synchronized (this.s) {
            if (!this.s.contains(interfaceC0133n)) {
                this.s.add(interfaceC0133n);
            }
        }
    }

    public void qg(InterfaceC0133n interfaceC0133n) {
        synchronized (this.s) {
            this.s.remove(interfaceC0133n);
        }
    }

    private Object[] q() {
        Object[] array;
        synchronized (this.s) {
            array = this.s.size() > 0 ? this.s.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.w = 1;
        Object[] objArrQ = q();
        if (objArrQ != null) {
            for (Object obj : objArrQ) {
                ((InterfaceC0133n) obj).qg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.w = 0;
        Object[] objArrQ = q();
        if (objArrQ != null) {
            for (Object obj : objArrQ) {
                ((InterfaceC0133n) obj).s();
            }
        }
    }

    private boolean x() {
        try {
            Application application = this.n;
            if (application == null) {
                return false;
            }
            application.getSystemService("activity");
            return TextUtils.equals(application.getPackageName(), w.q(application));
        } catch (Throwable unused) {
            return false;
        }
    }
}
