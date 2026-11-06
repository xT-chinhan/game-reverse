package com.anythink.core.api.bridge;

import android.app.Activity;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.by;
import com.anythink.core.common.u.b.c;
import com.anythink.core.common.u.b.d;
import com.anythink.core.common.u.b.e;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnyThinkBaseAdapter {
    boolean isRefresh;
    protected WeakReference<Activity> mActivityRef;
    private by mUnitGroupInfo;

    public final by getUnitGroupInfo() {
        return this.mUnitGroupInfo;
    }

    public final void setUnitGroupInfo(by byVar) {
        this.mUnitGroupInfo = byVar;
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
        s.b();
        s.b(runnable);
    }

    public final void postOnMainThreadDelayed(Runnable runnable, long j) {
        s.b();
        s.a(runnable, j);
    }

    public final void runOnNetworkRequestThread(Runnable runnable) {
        c.a().a(new d(e.I, runnable), false);
    }
}
