package com.ss.android.socialbase.downloader.ms;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.ab;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.ny.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ms {
    private volatile boolean ab;
    private final List<InterfaceC0570ms> ah;
    private volatile int c;
    private int d;
    private WeakReference<Activity> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Application f4717ms;
    private final Application.ActivityLifecycleCallbacks x;
    private ah xr;

    public interface ah {
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.ms.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0570ms {
        void ah();

        void xr();
    }

    public static ms ms() {
        return xr.f4719ms;
    }

    private static class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final ms f4719ms = new ms();
    }

    private ms() {
        this.ah = new ArrayList();
        this.c = -1;
        this.ab = false;
        this.x = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.ms.ms.1
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
                ms.this.ka = new WeakReference(activity);
                int i = ms.this.d;
                ms.this.d = activity != null ? activity.hashCode() : i;
                ms.this.ab = false;
                if (i == 0) {
                    ms.this.ka();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i = ms.this.d;
                ms.this.ab = false;
                ms.this.d = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    ms.this.ka();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ms.this.ab = true;
                if (ms.this.d != 0 || activity == null) {
                    return;
                }
                ms.this.d = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == ms.this.d) {
                    ms.this.d = 0;
                    ms.this.c();
                }
                ms.this.ab = false;
            }
        };
    }

    public void ms(Context context) {
        if (this.f4717ms == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.f4717ms == null) {
                    Application application = (Application) context;
                    this.f4717ms = application;
                    application.registerActivityLifecycleCallbacks(this.x);
                }
            }
        }
    }

    public void ms(ah ahVar) {
        this.xr = ahVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean xr() {
        int i = this.c;
        ?? r0 = i;
        if (i == -1) {
            ?? Ab = ab();
            this.c = Ab;
            r0 = Ab;
        }
        return r0 == 1;
    }

    public boolean ah() {
        return xr() && !this.ab;
    }

    public void ms(InterfaceC0570ms interfaceC0570ms) {
        if (interfaceC0570ms == null) {
            return;
        }
        synchronized (this.ah) {
            if (!this.ah.contains(interfaceC0570ms)) {
                this.ah.add(interfaceC0570ms);
            }
        }
    }

    public void xr(InterfaceC0570ms interfaceC0570ms) {
        synchronized (this.ah) {
            this.ah.remove(interfaceC0570ms);
        }
    }

    private Object[] d() {
        Object[] array;
        synchronized (this.ah) {
            array = this.ah.size() > 0 ? this.ah.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        this.c = 1;
        Object[] objArrD = d();
        if (objArrD != null) {
            for (Object obj : objArrD) {
                ((InterfaceC0570ms) obj).xr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.c = 0;
        Object[] objArrD = d();
        if (objArrD != null) {
            for (Object obj : objArrD) {
                ((InterfaceC0570ms) obj).ah();
            }
        }
    }

    private boolean ab() {
        try {
            Application application = this.f4717ms;
            if (application == null) {
                return false;
            }
            application.getSystemService(TTDownloadField.TT_ACTIVITY);
            return TextUtils.equals(application.getPackageName(), c.d(application));
        } catch (Throwable th) {
            ab.ms(th);
            return false;
        }
    }
}
