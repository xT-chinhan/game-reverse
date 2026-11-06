package com.bytedance.embedapplog;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class qv implements Application.ActivityLifecycleCallbacks {
    private static int ab = -1;
    private static long ah;
    private static String c;
    private static String d;
    private static long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static int f518ms;
    private static final HashSet<Integer> ny = new HashSet<>(8);
    private static rt xr;
    private final c x;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public qv(c cVar) {
        this.x = cVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        rt rtVarMs = ms(activity.getClass().getName(), "", System.currentTimeMillis(), d);
        xr = rtVarMs;
        rtVarMs.y = !ny.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild()) {
            return;
        }
        try {
            ab = activity.getWindow().getDecorView().hashCode();
        } catch (Exception e) {
            oh.xr(e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        rt rtVar = xr;
        if (rtVar != null) {
            d = rtVar.u;
            long jCurrentTimeMillis = System.currentTimeMillis();
            ah = jCurrentTimeMillis;
            ms(xr, jCurrentTimeMillis);
            xr = null;
            if (activity.isChild()) {
                return;
            }
            ab = -1;
        }
    }

    public static rt ms(String str, String str2, long j, String str3) {
        rt rtVar = new rt();
        if (!TextUtils.isEmpty(str2)) {
            rtVar.u = str + ":" + str2;
        } else {
            rtVar.u = str;
        }
        rtVar.xr = j;
        rtVar.sl = -1L;
        if (str3 == null) {
            str3 = "";
        }
        rtVar.zb = str3;
        b.ms(rtVar);
        return rtVar;
    }

    public static rt ms(rt rtVar, long j) {
        rt rtVar2 = (rt) rtVar.clone();
        rtVar2.xr = j;
        long j2 = j - rtVar.xr;
        if (j2 >= 0) {
            rtVar2.sl = j2;
        } else {
            oh.xr((Throwable) null);
        }
        b.ms(rtVar2);
        return rtVar2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        f518ms++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (d != null) {
            int i = f518ms - 1;
            f518ms = i;
            if (i <= 0) {
                d = null;
                c = null;
                ka = 0L;
                ah = 0L;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        ny.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        ny.add(Integer.valueOf(activity.hashCode()));
    }
}
