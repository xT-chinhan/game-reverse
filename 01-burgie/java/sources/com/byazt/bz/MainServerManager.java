package com.byazt.bz;

import android.app.Application;
import android.content.Context;
import com.byazt.bw.x;
import com.byazt.dea.c;
import com.byazt.ewn.AbsServerManager;
import com.byazt.vzx.pr;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;

/* JADX INFO: loaded from: classes.dex */
@pr(pr = {0, 1, 1820, 161})
public class MainServerManager extends AbsServerManager {
    @Override // com.byazt.ewn.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        Context applicationContext = getContext().getApplicationContext();
        TTAppContextHolder.setContext(applicationContext);
        if (!c.pr() && (applicationContext instanceof Application)) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(x.pr().hw());
        }
        return super.onCreate();
    }
}
