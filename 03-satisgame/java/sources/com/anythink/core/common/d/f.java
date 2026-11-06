package com.anythink.core.common.d;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.anythink.core.common.u.ad;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements Application.ActivityLifecycleCallbacks {
    public static final String a = "start_time";
    public static final String b = "end_time";
    public static final String c = "psid";
    public static final String d = "launch_mode";
    public static final int e = 0;
    public static final int f = 1;
    long g;
    JSONObject i;
    volatile ScheduledFuture<?> j;
    private final String l = "f";
    Runnable k = new Runnable() { // from class: com.anythink.core.common.d.f.1
        @Override // java.lang.Runnable
        public final void run() {
            f.a(f.this);
        }
    };
    int h = 0;

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

    private void a() {
        if (this.i != null) {
            ad.b(s.b().g(), t.b.a, s.b().p() + "playRecord", "");
            this.g = 0L;
            JSONObject jSONObject = this.i;
            long jOptLong = jSONObject.optLong(a);
            long jOptLong2 = jSONObject.optLong(b);
            String strOptString = jSONObject.optString(c);
            int iOptInt = jSONObject.optInt(d);
            this.i = null;
            com.anythink.core.common.t.f.a(iOptInt == 1 ? 3 : 1, jOptLong, jOptLong2, strOptString);
        }
    }

    public f(long j) {
        this.g = j;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.Q, new Runnable() { // from class: com.anythink.core.common.d.f.2
            @Override // java.lang.Runnable
            public final void run() {
                f.b(f.this);
            }
        }));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.P, new Runnable() { // from class: com.anythink.core.common.d.f.3
            @Override // java.lang.Runnable
            public final void run() {
                f.c(f.this);
            }
        }));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0085  */
    private void b() {
        long j;
        com.anythink.core.common.u.b.c.a();
        com.anythink.core.common.u.b.c.a(this.j);
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(s.b().g()).b(s.b().p());
        JSONObject jSONObject = this.i;
        if (jSONObject != null) {
            long jOptLong = jSONObject.optLong(a);
            long jOptLong2 = jSONObject.optLong(b);
            String strOptString = jSONObject.optString(c);
            int iOptInt = jSONObject.optInt(d);
            if (System.currentTimeMillis() - jOptLong2 > bVarB.E()) {
                ad.b(s.b().g(), t.b.a, s.b().p() + "playRecord", "");
                com.anythink.core.common.t.f.a(iOptInt == 1 ? 3 : 1, jOptLong, jOptLong2, strOptString);
                j = 0;
                this.g = 0L;
            } else {
                j = 0;
            }
        } else {
            j = 0;
        }
        this.i = null;
        if (this.g == j) {
            this.h = 1;
            try {
                this.g = s.b().a(s.b().g(), s.b().p(), 1);
            } catch (Exception unused) {
            }
        } else {
            ad.b(s.b().g(), t.b.a, s.b().p() + "playRecord", "");
        }
        if (this.g == 0) {
            this.g = System.currentTimeMillis();
        }
    }

    private void c() {
        String strP = s.b().p();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(c, s.b().r());
            jSONObject.put(a, this.g);
            jSONObject.put(b, System.currentTimeMillis());
            jSONObject.put(d, this.h);
            this.i = jSONObject;
            ad.b(s.b().g(), t.b.a, strP + "playRecord", jSONObject.toString());
        } catch (Exception unused) {
        }
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(s.b().g()).b(strP);
        if (bVarB.G() == 1) {
            this.j = com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.O, this.k), bVarB.E());
        }
    }

    static /* synthetic */ void a(f fVar) {
        if (fVar.i != null) {
            ad.b(s.b().g(), t.b.a, s.b().p() + "playRecord", "");
            fVar.g = 0L;
            JSONObject jSONObject = fVar.i;
            long jOptLong = jSONObject.optLong(a);
            long jOptLong2 = jSONObject.optLong(b);
            String strOptString = jSONObject.optString(c);
            int iOptInt = jSONObject.optInt(d);
            fVar.i = null;
            com.anythink.core.common.t.f.a(iOptInt == 1 ? 3 : 1, jOptLong, jOptLong2, strOptString);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0085  */
    static /* synthetic */ void b(f fVar) {
        long j;
        com.anythink.core.common.u.b.c.a();
        com.anythink.core.common.u.b.c.a(fVar.j);
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(s.b().g()).b(s.b().p());
        JSONObject jSONObject = fVar.i;
        if (jSONObject != null) {
            long jOptLong = jSONObject.optLong(a);
            long jOptLong2 = jSONObject.optLong(b);
            String strOptString = jSONObject.optString(c);
            int iOptInt = jSONObject.optInt(d);
            if (System.currentTimeMillis() - jOptLong2 > bVarB.E()) {
                ad.b(s.b().g(), t.b.a, s.b().p() + "playRecord", "");
                com.anythink.core.common.t.f.a(iOptInt == 1 ? 3 : 1, jOptLong, jOptLong2, strOptString);
                j = 0;
                fVar.g = 0L;
            } else {
                j = 0;
            }
        } else {
            j = 0;
        }
        fVar.i = null;
        if (fVar.g == j) {
            fVar.h = 1;
            try {
                fVar.g = s.b().a(s.b().g(), s.b().p(), 1);
            } catch (Exception unused) {
            }
        } else {
            ad.b(s.b().g(), t.b.a, s.b().p() + "playRecord", "");
        }
        if (fVar.g == 0) {
            fVar.g = System.currentTimeMillis();
        }
    }

    static /* synthetic */ void c(f fVar) {
        String strP = s.b().p();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(c, s.b().r());
            jSONObject.put(a, fVar.g);
            jSONObject.put(b, System.currentTimeMillis());
            jSONObject.put(d, fVar.h);
            fVar.i = jSONObject;
            ad.b(s.b().g(), t.b.a, strP + "playRecord", jSONObject.toString());
        } catch (Exception unused) {
        }
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(s.b().g()).b(strP);
        if (bVarB.G() == 1) {
            fVar.j = com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.O, fVar.k), bVarB.E());
        }
    }
}
