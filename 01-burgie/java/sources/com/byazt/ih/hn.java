package com.byazt.ih;

import com.byazt.fr.x;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1059, 20})
public class hn {
    public static final TimeUnit pr = TimeUnit.SECONDS;

    public static ExecutorService pr() {
        x xVar = new x(1, 2, 30L, pr, new LinkedBlockingQueue(), new pr("default"));
        xVar.allowCoreThreadTimeOut(true);
        return xVar;
    }
}
