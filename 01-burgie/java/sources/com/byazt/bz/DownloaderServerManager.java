package com.byazt.bz;

import com.byazt.dea.uc;
import com.byazt.ewn.AbsServerManager;
import com.byazt.mg.aj;
import com.byazt.vzx.pr;

/* JADX INFO: loaded from: classes.dex */
@pr(pr = {0, 1, 1820, 2377})
public class DownloaderServerManager extends AbsServerManager {
    @Override // com.byazt.ewn.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        try {
            aj.pr(getContext());
        } catch (Throwable th) {
            uc.pr(th);
        }
        return super.onCreate();
    }
}
