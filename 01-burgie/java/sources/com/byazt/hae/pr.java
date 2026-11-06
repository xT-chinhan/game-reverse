package com.byazt.hae;

import com.byazt.wo.c;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1001, 37})
public class pr {
    public final CountDownLatch hw;
    public Throwable pr;

    /* JADX INFO: renamed from: com.byazt.hae.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0082pr {
        void pr() throws Throwable;
    }

    private pr(boolean z, InterfaceC0082pr[] interfaceC0082prArr) {
        this.hw = new CountDownLatch(interfaceC0082prArr.length);
        for (final InterfaceC0082pr interfaceC0082pr : interfaceC0082prArr) {
            c.pr(new Runnable() { // from class: com.byazt.hae.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        interfaceC0082pr.pr();
                    } catch (Throwable th) {
                        pr.this.pr = th;
                    }
                    pr.this.hw.countDown();
                }
            }, z);
        }
    }

    public static void pr(boolean z, InterfaceC0082pr... interfaceC0082prArr) throws Throwable {
        new pr(z, interfaceC0082prArr).pr();
    }

    private void pr() throws Throwable {
        try {
            this.hw.await();
            Throwable th = this.pr;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
