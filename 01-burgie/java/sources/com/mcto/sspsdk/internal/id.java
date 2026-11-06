package com.mcto.sspsdk.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class id extends ca {
    @Override // com.mcto.sspsdk.internal.ca, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        try {
            jd.g = new WeakReference(activity);
            jd.e = false;
            HashSet hashSet = jd.f;
            hashSet.size();
            hashSet.add(Integer.valueOf(activity.hashCode()));
            if (hashSet.size() == 1) {
                Iterator it = jd.d.iterator();
                while (it.hasNext()) {
                    ((w3) it.next()).a(Boolean.FALSE);
                }
            }
        } catch (Exception e) {
            r9.a("ssp_ctx", "onActivityStarted", e);
        }
    }

    @Override // com.mcto.sspsdk.internal.ca, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        try {
            HashSet hashSet = jd.f;
            hashSet.remove(Integer.valueOf(activity.hashCode()));
            if (hashSet.isEmpty()) {
                jd.e = true;
                Iterator it = jd.d.iterator();
                while (it.hasNext()) {
                    ((w3) it.next()).a(Boolean.TRUE);
                }
            }
        } catch (Exception e) {
            r9.a("ssp_ctx", "onActivityStopped", e);
        }
    }
}
