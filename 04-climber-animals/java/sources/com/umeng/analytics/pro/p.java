package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* JADX INFO: compiled from: BackgroundMonitor.java */
/* JADX INFO: loaded from: classes4.dex */
public class p implements Application.ActivityLifecycleCallbacks {
    private static p a = new p();
    private final int b = 3000;
    private boolean c = false;
    private boolean d = true;
    private Handler e = new Handler(Looper.getMainLooper());
    private ArrayList<q> f = new ArrayList<>();
    private a g = new a();

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
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* JADX INFO: compiled from: BackgroundMonitor.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.c && p.this.d) {
                p.this.c = false;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
                for (int i = 0; i < p.this.f.size(); i++) {
                    ((q) p.this.f.get(i)).n();
                }
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(a);
        }
    }

    public static p a() {
        return a;
    }

    private p() {
    }

    public synchronized void a(q qVar) {
        if (qVar != null) {
            this.f.add(qVar);
        }
    }

    public synchronized void b(q qVar) {
        if (qVar != null) {
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i) == qVar) {
                    this.f.remove(i);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.d = false;
        this.c = true;
        a aVar = this.g;
        if (aVar != null) {
            this.e.removeCallbacks(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.d = true;
        a aVar = this.g;
        if (aVar != null) {
            this.e.removeCallbacks(aVar);
            this.e.postDelayed(this.g, com.tapsdk.tapad.e.a.f);
        }
    }
}
