package com.mcto.sspsdk.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.mcto.sspsdk.remote.SimulatorDetectService;

/* JADX INFO: loaded from: classes2.dex */
public final class th extends ca {
    public static th c;
    public sh a;
    public boolean b = false;

    public static th a() {
        if (c == null) {
            synchronized (th.class) {
                if (c == null) {
                    th thVar = new th();
                    c = thVar;
                    thVar.a = new sh();
                }
            }
        }
        return c;
    }

    public final void b() {
        Context context = jd.a;
        if (context != null && "1".equals(nh.a(context).a("simdw"))) {
            long j = 0;
            long j2 = 2592000000L;
            try {
                j = Long.parseLong(nh.a(jd.a).a.getSharedPreferences("iad_dev", 0).getString("simlt", "0"));
                j2 = Long.parseLong(nh.a(jd.a).a.getSharedPreferences("iad_dev", 0).getString("simet", "2592000000"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (System.currentTimeMillis() - j < j2) {
                return;
            }
            ((Application) jd.a).registerActivityLifecycleCallbacks(this);
        }
    }

    @Override // com.mcto.sspsdk.internal.ca, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        jd.a.bindService(new Intent(jd.a, (Class<?>) SimulatorDetectService.class), this.a, 1);
        ((Application) jd.a).unregisterActivityLifecycleCallbacks(this);
    }
}
