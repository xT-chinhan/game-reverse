package com.bytedance.sdk.openadsdk.core.jw;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Window;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Application.ActivityLifecycleCallbacks {
    public static long ah = 0;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static boolean f2716ms = false;
    public static long xr;
    private volatile xr c;
    private volatile InterfaceC0293ms d;
    private volatile Application.ActivityLifecycleCallbacks ka;
    private Handler u;
    private volatile WeakReference<Activity> ub;
    private volatile WeakReference<Activity> zb;
    private final AtomicBoolean ab = new AtomicBoolean(false);
    private final HashSet<Integer> x = new HashSet<>();
    private volatile CopyOnWriteArrayList<WeakReference<com.bytedance.sdk.component.adexpress.ms>> ny = new CopyOnWriteArrayList<>();
    private volatile CopyOnWriteArrayList<xr> ch = new CopyOnWriteArrayList<>();
    private final ArrayList<String> hi = new ArrayList<>();
    private SparseArray<Set<Runnable>> sl = new SparseArray<>();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.jw.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0293ms {
        void ms();
    }

    public interface xr {
        void ms();

        void xr();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public WeakReference<Activity> ms() {
        return this.zb;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.ka != null) {
            this.ka.onActivityCreated(activity, bundle);
        }
    }

    private Handler ka() {
        if (this.u == null) {
            if (com.bytedance.sdk.openadsdk.core.re.xr().zh()) {
                this.u = com.bytedance.sdk.component.utils.x.ah();
            } else {
                this.u = com.bytedance.sdk.component.utils.x.xr();
            }
        }
        return this.u;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(final Activity activity) {
        ka().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.ms.1
            @Override // java.lang.Runnable
            public void run() {
                ms.this.xr(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(Activity activity) {
        if (this.ab.get()) {
            xr(true);
        }
        if (!this.hi.contains(activity.toString())) {
            this.hi.add(activity.toString());
            this.ab.set(false);
            com.bytedance.sdk.openadsdk.ms.xr.xr.ka();
        }
        if (this.ub != null && this.ub.get() != null && this.ub.get() == activity) {
            x();
        }
        if (this.ka != null) {
            this.ka.onActivityStarted(activity);
        }
        ul.ka(activity);
    }

    private void xr(boolean z) {
        try {
            if (z) {
                if (this.c != null) {
                    this.c.xr();
                }
                for (xr xrVar : this.ch) {
                    if (xrVar != null) {
                        xrVar.xr();
                    }
                }
                return;
            }
            if (this.c != null) {
                this.c.ms();
            }
            for (xr xrVar2 : this.ch) {
                if (xrVar2 != null) {
                    xrVar2.ms();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(final Activity activity) {
        ka().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.ms.2
            @Override // java.lang.Runnable
            public void run() {
                ms.this.ah(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Activity activity) {
        if (activity != null) {
            this.x.add(Integer.valueOf(activity.hashCode()));
        }
        if (this.d != null) {
            this.d.ms();
        }
        if (this.ka != null) {
            this.ka.onActivityResumed(activity);
        }
        com.bytedance.sdk.component.ny.ah.ms.ms(com.bytedance.sdk.openadsdk.core.re.getContext(), Integer.parseInt("1371"));
        if (!f2716ms) {
            xr = System.currentTimeMillis();
            f2716ms = true;
        }
        com.bytedance.sdk.openadsdk.core.cv.ms();
        this.zb = new WeakReference<>(activity);
        if (com.bytedance.sdk.openadsdk.core.ch.ub().cv()) {
            return;
        }
        if (activity != null && activity.getComponentName() != null) {
            com.bytedance.sdk.openadsdk.core.jw.xr.ms().ms(activity.getComponentName().getClassName());
        }
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        u.ms().ms(activity.getIntent());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(final Activity activity) {
        ka().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.ms.3
            @Override // java.lang.Runnable
            public void run() {
                ms.this.d(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Activity activity) {
        if (this.ka != null) {
            this.ka.onActivityPaused(activity);
        }
        if (com.bytedance.sdk.openadsdk.core.ch.ub().cv() || activity == null || activity.getComponentName() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.xr.ms().ah(activity.getComponentName().getClassName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(final Activity activity) {
        ka().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.ms.4
            @Override // java.lang.Runnable
            public void run() {
                ms.this.ka(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka(Activity activity) {
        if (this.hi.contains(activity.toString())) {
            this.hi.remove(activity.toString());
            if (this.hi.size() == 0) {
                this.ab.set(true);
                com.bytedance.sdk.openadsdk.ms.xr.xr.d();
                xr(false);
            }
        }
        this.ub = new WeakReference<>(activity);
        if (this.ka != null) {
            this.ka.onActivityStopped(activity);
        }
        ab();
        ((com.bytedance.sdk.component.d.xr) AutoService.ms(com.bytedance.sdk.component.d.xr.class)).ms();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(final Activity activity) {
        ka().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.ms.5
            @Override // java.lang.Runnable
            public void run() {
                ms.this.c(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        if (activity != null) {
            this.x.remove(Integer.valueOf(activity.hashCode()));
        }
        if (this.ka != null) {
            this.ka.onActivityDestroyed(activity);
        }
        if (this.ny != null && this.ny.size() > 0) {
            for (WeakReference<com.bytedance.sdk.component.adexpress.ms> weakReference : this.ny) {
                if (weakReference != null && weakReference.get() != null) {
                    try {
                        weakReference.get().ms(activity);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.sl.ms(th);
                    }
                }
            }
        }
        if (this.zb != null && this.zb.get() == activity) {
            this.zb = null;
        }
        if (activity != null) {
            int iHashCode = activity.hashCode();
            synchronized (this.sl) {
                Set<Runnable> set = this.sl.get(iHashCode);
                if (set != null) {
                    for (Runnable runnable : set) {
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                    this.sl.remove(iHashCode);
                }
            }
        }
    }

    public boolean xr() {
        return c();
    }

    public boolean ms(boolean z) {
        Activity activity;
        Window window;
        WeakReference<Activity> weakReference = this.zb;
        return (weakReference == null || (activity = weakReference.get()) == null || (window = activity.getWindow()) == null) ? z : window.getDecorView().hasWindowFocus();
    }

    private boolean c() {
        Bridge bridgeAm = com.bytedance.sdk.openadsdk.core.ch.ub().am();
        if (bridgeAm != null) {
            try {
                return ((Boolean) bridgeAm.call(2, null, Boolean.class)).booleanValue();
            } catch (Exception unused) {
            }
        }
        return this.ab.get();
    }

    public boolean ms(Activity activity) {
        return activity != null && this.x.contains(Integer.valueOf(activity.hashCode()));
    }

    private void ab() {
        if (!com.bytedance.sdk.openadsdk.core.ch.ub().cv() && xr()) {
            com.bytedance.sdk.component.ch.ab.ah(new com.bytedance.sdk.component.ch.ny("reportSdkUseTime") { // from class: com.bytedance.sdk.openadsdk.core.jw.ms.6
                @Override // java.lang.Runnable
                public void run() {
                    ms.f2716ms = false;
                    ms.ah = System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.core.t.u.ms().ms(ms.xr / 1000, ms.ah / 1000, !com.bytedance.sdk.openadsdk.core.nw.xr.get() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.core.nw.xr.set(false);
                }
            });
        }
    }

    private void x() {
        if (com.bytedance.sdk.openadsdk.core.ch.ub().cv()) {
            return;
        }
        com.bytedance.sdk.openadsdk.op.ab.xr(new com.bytedance.sdk.component.ch.ny("upload_dpl") { // from class: com.bytedance.sdk.openadsdk.core.jw.ms.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
                long jXr = xrVarMs.xr("save_jump_success_time", 0L);
                if (jXr <= 0) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - jXr;
                if (jCurrentTimeMillis >= 86400000 || jCurrentTimeMillis <= 0) {
                    return;
                }
                String strXr = xrVarMs.xr("save_jump_success_ad_tag", "");
                String strXr2 = xrVarMs.xr("save_dpl_success_materialmeta", "");
                if (TextUtils.isEmpty(strXr) || TextUtils.isEmpty(strXr2)) {
                    return;
                }
                xrVarMs.ms("save_dpl_success_materialmeta");
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(jCurrentTimeMillis, strXr, strXr2);
            }
        });
    }

    public void ms(InterfaceC0293ms interfaceC0293ms) {
        this.d = interfaceC0293ms;
    }

    public void ms(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.ka = activityLifecycleCallbacks;
    }

    public void ms(com.bytedance.sdk.component.adexpress.ms msVar) {
        this.ny.add(new WeakReference<>(msVar));
    }

    public boolean xr(com.bytedance.sdk.component.adexpress.ms msVar) {
        return this.ny.remove(new WeakReference(msVar));
    }

    public void ms(xr xrVar) {
        if (this.ch.contains(xrVar)) {
            return;
        }
        this.ch.add(xrVar);
    }

    public void xr(xr xrVar) {
        this.c = xrVar;
    }

    public void ah() {
        if (this.d != null) {
            this.d = null;
        }
    }

    public boolean ms(Activity activity, Runnable runnable) {
        boolean zAdd;
        if (activity == null) {
            return false;
        }
        int iHashCode = activity.hashCode();
        synchronized (this.sl) {
            Set<Runnable> hashSet = this.sl.get(iHashCode);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.sl.put(iHashCode, hashSet);
            }
            zAdd = hashSet.add(runnable);
        }
        return zAdd;
    }

    public void d() {
        com.bytedance.sdk.openadsdk.core.jw.xr.ms().xr();
    }
}
