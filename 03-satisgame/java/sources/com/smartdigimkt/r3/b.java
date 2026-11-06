package com.smartdigimkt.r3;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.v3.e;
import com.smartdigimkt.v3.f;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        c cVar = this.a;
        activity.getClass();
        cVar.getClass();
        c.a(this.a, activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        c.c(this.a, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        c.e(this.a, activity);
        c.a(this.a, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        c.e(this.a, activity);
        c cVar = this.a;
        activity.getClass();
        cVar.getClass();
        this.a.c = new WeakReference(activity);
        c.f(this.a, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.a.a(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        c cVar = this.a;
        cVar.i = true;
        int i = cVar.e + 1;
        cVar.e = i;
        if (i == 1 && cVar.f) {
            cVar.f = false;
            Context applicationContext = activity != null ? activity.getApplicationContext() : activity;
            f fVarA = f.a();
            fVarA.getClass();
            com.smartdigimkt.q3.f.a().c(new e(fVarA, applicationContext, true));
            SDKContext.getInstance().l = true;
        }
        c cVar2 = this.a;
        cVar2.g = false;
        c.d(cVar2, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        c.e(this.a, activity);
        c cVar = this.a;
        int i = cVar.e - 1;
        cVar.e = i;
        if (i < 0) {
            cVar.e = 0;
        }
        cVar.g = activity.isChangingConfigurations();
        try {
            c cVar2 = this.a;
            Runnable runnable = cVar2.h;
            if (runnable != null) {
                cVar2.d.removeCallbacks(runnable);
            }
            Context applicationContext = activity.getApplicationContext() != null ? activity.getApplicationContext() : this.a.j;
            c cVar3 = this.a;
            a aVar = new a(this, applicationContext);
            cVar3.h = aVar;
            cVar3.d.postDelayed(aVar, 500L);
        } catch (Throwable unused) {
        }
        c.b(this.a, activity);
    }
}
