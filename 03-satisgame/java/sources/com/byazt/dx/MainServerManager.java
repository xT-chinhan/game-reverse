package com.byazt.dx;

import android.app.Application;
import android.content.Context;
import com.byazt.cp.n;
import com.byazt.gc.AbsServerManager;
import com.byazt.ja.q;
import com.byazt.vx.l;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;

/* JADX INFO: loaded from: classes.dex */
@n(n = {0, 1, 1991, 1992})
public class MainServerManager extends AbsServerManager {
    @Override // com.byazt.gc.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        Context applicationContext = getContext().getApplicationContext();
        TTAppContextHolder.setContext(applicationContext);
        if (!l.n() && (applicationContext instanceof Application)) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(q.n().qg());
        }
        return super.onCreate();
    }
}
