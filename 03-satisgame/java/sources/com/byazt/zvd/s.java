package com.byazt.zvd;

import com.byazt.xis.q;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1640, 8})
public class s {
    public static final TimeUnit n = TimeUnit.SECONDS;

    public static ExecutorService n() {
        q qVar = new q(1, 2, 30L, n, new LinkedBlockingQueue(), new n("default"));
        qVar.allowCoreThreadTimeOut(true);
        return qVar;
    }
}
