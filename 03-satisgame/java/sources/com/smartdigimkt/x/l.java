package com.smartdigimkt.x;

import android.app.Activity;
import android.content.Context;
import com.smartdigimkt.sdk.core.SDKContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public com.smartdigimkt.c1.g a;

    public final void a(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, k kVar) {
        Activity activity;
        Activity activity2;
        try {
            if (!(context instanceof Activity) || (activity2 = (Activity) context) == null || activity2.isFinishing() || activity2.isDestroyed()) {
                j jVarA = j.a();
                synchronized (jVarA.r) {
                    WeakReference weakReference = jVarA.q;
                    activity = weakReference != null ? (Activity) weakReference.get() : null;
                }
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    activity = null;
                }
            } else {
                activity = (Activity) context;
            }
            if (activity == null) {
                return;
            }
            com.smartdigimkt.c1.g gVar = new com.smartdigimkt.c1.g(com.smartdigimkt.r4.k.a(context, "myoffer_feedback_dialog", "style"), activity);
            this.a = gVar;
            gVar.c = kVar;
            gVar.a = cVar;
            gVar.b = aVar;
            gVar.show();
        } catch (Throwable th) {
            com.smartdigimkt.n3.k.a("show feedback dialog error", th.getMessage() + ", " + com.smartdigimkt.r4.k.a(th.getStackTrace()), SDKContext.getInstance().f(), "");
        }
    }
}
