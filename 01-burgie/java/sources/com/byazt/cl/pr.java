package com.byazt.cl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.ec.w;
import com.byazt.gox.x;
import com.byazt.kg.aj;
import com.byazt.zrg.uc;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1072, 37})
public class pr implements Application.ActivityLifecycleCallbacks {
    public static long c;
    public static long hn;
    public static aj hw;
    public static String uc;
    public static String x;
    public final uc zo;
    public static int pr = 0;
    public static int fw = -1;
    public static final HashSet<Integer> aj = new HashSet<>(8);

    public pr(uc ucVar) {
        this.zo = ucVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        aj ajVarPr = pr(activity.getClass().getName(), "", System.currentTimeMillis(), x);
        hw = ajVarPr;
        ajVarPr.qa = !aj.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (!activity.isChild()) {
            try {
                fw = activity.getWindow().getDecorView().hashCode();
            } catch (Exception e) {
                w.hw(e);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        aj ajVar = hw;
        if (ajVar != null) {
            x = ajVar.g;
            long jCurrentTimeMillis = System.currentTimeMillis();
            hn = jCurrentTimeMillis;
            pr(hw, jCurrentTimeMillis);
            hw = null;
            if (!activity.isChild()) {
                fw = -1;
            }
        }
    }

    public static aj pr(String str, String str2, long j, String str3) {
        aj ajVar = new aj();
        if (!TextUtils.isEmpty(str2)) {
            ajVar.g = str + ":" + str2;
        } else {
            ajVar.g = str;
        }
        ajVar.hw = j;
        ajVar.k = -1L;
        if (str3 == null) {
            str3 = "";
        }
        ajVar.m = str3;
        x.pr(ajVar);
        return ajVar;
    }

    public static aj pr(aj ajVar, long j) {
        aj ajVar2 = (aj) ajVar.clone();
        ajVar2.hw = j;
        long j2 = j - ajVar.hw;
        if (j2 >= 0) {
            ajVar2.k = j2;
        } else {
            w.hw((Throwable) null);
        }
        x.pr(ajVar2);
        return ajVar2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        pr++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (x != null) {
            int i = pr - 1;
            pr = i;
            if (i <= 0) {
                x = null;
                uc = null;
                c = 0L;
                hn = 0L;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        aj.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        aj.add(Integer.valueOf(activity.hashCode()));
    }
}
