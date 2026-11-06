package com.anythink.core.common.d;

import android.app.Activity;
import android.os.Looper;
import com.anythink.core.common.h.bv;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    boolean isRefresh;
    protected WeakReference<Activity> mActivityRef;
    private com.anythink.core.common.h.n mTrackingInfo;
    private bv mUnitGroupInfo;

    public void setTrackingInfo(com.anythink.core.common.h.n nVar) {
        this.mTrackingInfo = nVar;
    }

    public final com.anythink.core.common.h.n getTrackingInfo() {
        return this.mTrackingInfo;
    }

    public final bv getUnitGroupInfo() {
        return this.mUnitGroupInfo;
    }

    public final void setUnitGroupInfo(bv bvVar) {
        this.mUnitGroupInfo = bvVar;
    }

    public final void setRefresh(boolean z) {
        this.isRefresh = z;
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }

    public final void refreshActivityContext(Activity activity) {
        this.mActivityRef = new WeakReference<>(activity);
    }

    public final void postOnMainThread(Runnable runnable) {
        t.b().b(runnable);
    }

    public final void postOnMainThreadDelayed(Runnable runnable, long j) {
        t.b().a(runnable, j);
    }

    public final void runOnNetworkRequestThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.anythink.core.common.v.b.b.a().b(runnable);
        } else {
            runnable.run();
        }
    }
}
