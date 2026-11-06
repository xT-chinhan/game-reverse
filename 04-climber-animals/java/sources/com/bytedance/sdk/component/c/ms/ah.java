package com.bytedance.sdk.component.c.ms;

import com.anythink.core.express.b.a;
import com.bytedance.sdk.component.ch.d.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final TimeUnit f1190ms = TimeUnit.SECONDS;

    public static ExecutorService ms() {
        d dVar = new d(1, 2, 30L, f1190ms, new LinkedBlockingQueue(), new ms(a.f));
        dVar.allowCoreThreadTimeOut(true);
        return dVar;
    }
}
