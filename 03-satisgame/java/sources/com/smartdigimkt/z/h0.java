package com.smartdigimkt.z;

import android.app.Activity;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends com.smartdigimkt.x.a {
    public final /* synthetic */ j0 a;

    public h0(j0 j0Var) {
        this.a = j0Var;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        com.smartdigimkt.m3.d dVar = this.a.a;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        com.smartdigimkt.m3.d dVar = this.a.a;
        if (dVar != null) {
            dVar.b();
        }
    }
}
