package com.byazt.ni;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.fo.q;
import com.byazt.km.cp;
import com.byazt.wv.w;
import com.byazt.yi.rv;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1085, 19})
public class n implements Application.ActivityLifecycleCallbacks {
    public static long l = 0;
    public static int n = 0;
    public static String q = null;
    public static rv qg = null;
    public static final HashSet<Integer> rv = new HashSet<>(8);
    public static long s = 0;
    public static String w = null;
    public static int x = -1;
    public final w fs;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public n(w wVar) {
        this.fs = wVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        rv rvVarN = n(activity.getClass().getName(), "", System.currentTimeMillis(), q);
        qg = rvVarN;
        rvVarN.um = !rv.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild()) {
            return;
        }
        try {
            x = activity.getWindow().getDecorView().hashCode();
        } catch (Exception e) {
            cp.qg(e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        rv rvVar = qg;
        if (rvVar != null) {
            q = rvVar.sz;
            long jCurrentTimeMillis = System.currentTimeMillis();
            s = jCurrentTimeMillis;
            n(qg, jCurrentTimeMillis);
            qg = null;
            if (activity.isChild()) {
                return;
            }
            x = -1;
        }
    }

    public static rv n(String str, String str2, long j, String str3) {
        rv rvVar = new rv();
        if (!TextUtils.isEmpty(str2)) {
            rvVar.sz = str + ":" + str2;
        } else {
            rvVar.sz = str;
        }
        rvVar.qg = j;
        rvVar.d = -1L;
        if (str3 == null) {
            str3 = "";
        }
        rvVar.oa = str3;
        q.n(rvVar);
        return rvVar;
    }

    public static rv n(rv rvVar, long j) {
        rv rvVar2 = (rv) rvVar.clone();
        rvVar2.qg = j;
        long j2 = j - rvVar.qg;
        if (j2 >= 0) {
            rvVar2.d = j2;
        } else {
            cp.qg((Throwable) null);
        }
        q.n(rvVar2);
        return rvVar2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        n++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (q != null) {
            int i = n - 1;
            n = i;
            if (i <= 0) {
                q = null;
                w = null;
                l = 0L;
                s = 0L;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        rv.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        rv.add(Integer.valueOf(activity.hashCode()));
    }
}
