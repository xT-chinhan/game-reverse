package com.bytedance.sdk.component.ch.ms;

import com.anythink.core.express.b.a;
import com.bytedance.sdk.component.ch.ch;
import com.bytedance.sdk.component.ch.hi;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class d implements ThreadFactory {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ThreadFactory f1224ms;
    private final int xr;

    public d(ThreadFactory threadFactory, int i) {
        if (threadFactory == null) {
            this.f1224ms = new ch(a.f);
        } else {
            this.f1224ms = threadFactory;
        }
        this.xr = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f1224ms.newThread(runnable);
        return xr() ? new ab(threadNewThread) : threadNewThread;
    }

    public final String ms() {
        return this.f1224ms.getClass().getName();
    }

    protected boolean xr() {
        return hi.xr.xr(this.xr);
    }
}
