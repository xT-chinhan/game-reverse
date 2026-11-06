package com.byazt.dx;

import com.byazt.cp.n;
import com.byazt.gc.AbsServerManager;
import com.byazt.qyu.rv;
import com.byazt.vx.w;

/* JADX INFO: loaded from: classes.dex */
@n(n = {0, 1, 1991, 2565})
public class DownloaderServerManager extends AbsServerManager {
    @Override // com.byazt.gc.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        try {
            rv.n(getContext());
        } catch (Throwable th) {
            w.n(th);
        }
        return super.onCreate();
    }
}
