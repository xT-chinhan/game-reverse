package com.anythink.core.common.d;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import com.anythink.core.common.v.af;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g implements Application.ActivityLifecycleCallbacks {
    public static final String a = "start_time";
    public static final String b = "end_time";
    public static final String c = "psid";
    public static final String d = "launch_mode";
    public static final int e = 0;
    public static final int f = 1;
    long g;
    JSONObject i;
    private final String k = com.anythink.basead.f.g.i;
    Runnable j = new Runnable() { // from class: com.anythink.core.common.d.g.1
        @Override // java.lang.Runnable
        public final void run() {
            g.a(g.this);
        }
    };
    int h = 0;
    private final Handler l = com.anythink.core.common.v.b.b.a().a(14);

    private void a() {
        if (this.i != null) {
            af.b(t.b().g(), u.b.a, t.b().p() + "playRecord", "");
            this.g = 0L;
            JSONObject jSONObject = this.i;
            long jOptLong = jSONObject.optLong("start_time");
            long jOptLong2 = jSONObject.optLong("end_time");
            String strOptString = jSONObject.optString(c);
            int iOptInt = jSONObject.optInt(d);
            this.i = null;
            com.anythink.core.common.u.e.a(iOptInt == 1 ? 3 : 1, jOptLong, jOptLong2, strOptString);
            long j = (jOptLong2 - jOptLong) / 1000;
        }
    }

    public g(long j) {
        this.g = j;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        activity.getClass().getName();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        activity.getClass().getName();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        activity.getClass().getName();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.anythink.core.common.d.g.2
                @Override // java.lang.Runnable
                public final void run() {
                    g.a(g.this, jCurrentTimeMillis);
                }
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        activity.getClass().getName();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.anythink.core.common.d.g.3
                @Override // java.lang.Runnable
                public final void run() {
                    g.b(g.this, jCurrentTimeMillis);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x008b  */
    private void a(long j) {
        long j2;
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacks(this.j);
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
        JSONObject jSONObject = this.i;
        if (jSONObject != null) {
            long jOptLong = jSONObject.optLong("start_time");
            long jOptLong2 = jSONObject.optLong("end_time");
            String strOptString = jSONObject.optString(c);
            int iOptInt = jSONObject.optInt(d);
            if (System.currentTimeMillis() - jOptLong2 > bVarB.M()) {
                long j3 = (jOptLong2 - jOptLong) / 1000;
                af.b(t.b().g(), u.b.a, t.b().p() + "playRecord", "");
                com.anythink.core.common.u.e.a(iOptInt == 1 ? 3 : 1, jOptLong, jOptLong2, strOptString);
                j2 = 0;
                this.g = 0L;
            } else {
                j2 = 0;
            }
        } else {
            j2 = 0;
        }
        this.i = null;
        if (this.g == j2) {
            this.h = 1;
            try {
                this.g = t.b().a(t.b().g(), t.b().p(), 1);
            } catch (Exception unused) {
            }
        } else {
            af.b(t.b().g(), u.b.a, t.b().p() + "playRecord", "");
        }
        if (this.g == 0) {
            this.g = System.currentTimeMillis();
        }
        System.currentTimeMillis();
    }

    private void b(long j) {
        String strP = t.b().p();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(c, t.b().r());
            jSONObject.put("start_time", this.g);
            jSONObject.put("end_time", System.currentTimeMillis());
            jSONObject.put(d, this.h);
            this.i = jSONObject;
            af.b(t.b().g(), u.b.a, strP + "playRecord", jSONObject.toString());
            jSONObject.toString();
        } catch (Exception unused) {
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(strP);
        if (bVarB.O() == 1) {
            this.l.postDelayed(this.j, bVarB.M());
        }
        System.currentTimeMillis();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        activity.getClass().getName();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        activity.getClass().getName();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        activity.getClass().getName();
    }

    static /* synthetic */ void a(g gVar) {
        if (gVar.i != null) {
            af.b(t.b().g(), u.b.a, t.b().p() + "playRecord", "");
            gVar.g = 0L;
            JSONObject jSONObject = gVar.i;
            long jOptLong = jSONObject.optLong("start_time");
            long jOptLong2 = jSONObject.optLong("end_time");
            String strOptString = jSONObject.optString(c);
            int iOptInt = jSONObject.optInt(d);
            gVar.i = null;
            com.anythink.core.common.u.e.a(iOptInt == 1 ? 3 : 1, jOptLong, jOptLong2, strOptString);
            long j = (jOptLong2 - jOptLong) / 1000;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x008b  */
    static /* synthetic */ void a(g gVar, long j) {
        long j2;
        Handler handler = gVar.l;
        if (handler != null) {
            handler.removeCallbacks(gVar.j);
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
        JSONObject jSONObject = gVar.i;
        if (jSONObject != null) {
            long jOptLong = jSONObject.optLong("start_time");
            long jOptLong2 = jSONObject.optLong("end_time");
            String strOptString = jSONObject.optString(c);
            int iOptInt = jSONObject.optInt(d);
            if (System.currentTimeMillis() - jOptLong2 > bVarB.M()) {
                long j3 = (jOptLong2 - jOptLong) / 1000;
                af.b(t.b().g(), u.b.a, t.b().p() + "playRecord", "");
                com.anythink.core.common.u.e.a(iOptInt == 1 ? 3 : 1, jOptLong, jOptLong2, strOptString);
                j2 = 0;
                gVar.g = 0L;
            } else {
                j2 = 0;
            }
        } else {
            j2 = 0;
        }
        gVar.i = null;
        if (gVar.g == j2) {
            gVar.h = 1;
            try {
                gVar.g = t.b().a(t.b().g(), t.b().p(), 1);
            } catch (Exception unused) {
            }
        } else {
            af.b(t.b().g(), u.b.a, t.b().p() + "playRecord", "");
        }
        if (gVar.g == 0) {
            gVar.g = System.currentTimeMillis();
        }
        System.currentTimeMillis();
    }

    static /* synthetic */ void b(g gVar, long j) {
        String strP = t.b().p();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(c, t.b().r());
            jSONObject.put("start_time", gVar.g);
            jSONObject.put("end_time", System.currentTimeMillis());
            jSONObject.put(d, gVar.h);
            gVar.i = jSONObject;
            af.b(t.b().g(), u.b.a, strP + "playRecord", jSONObject.toString());
            jSONObject.toString();
        } catch (Exception unused) {
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(strP);
        if (bVarB.O() == 1) {
            gVar.l.postDelayed(gVar.j, bVarB.M());
        }
        System.currentTimeMillis();
    }
}
