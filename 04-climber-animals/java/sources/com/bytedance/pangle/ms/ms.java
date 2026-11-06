package com.bytedance.pangle.ms;

import com.bytedance.pangle.ka.ka;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Throwable f648ms;
    private final CountDownLatch xr;

    /* JADX INFO: renamed from: com.bytedance.pangle.ms.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0222ms {
        void ms() throws Throwable;
    }

    private ms(boolean z, InterfaceC0222ms[] interfaceC0222msArr) {
        this.xr = new CountDownLatch(interfaceC0222msArr.length);
        for (final InterfaceC0222ms interfaceC0222ms : interfaceC0222msArr) {
            ka.ms(new Runnable() { // from class: com.bytedance.pangle.ms.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        interfaceC0222ms.ms();
                    } catch (Throwable th) {
                        ms.this.f648ms = th;
                    }
                    ms.this.xr.countDown();
                }
            }, z);
        }
    }

    public static void ms(boolean z, InterfaceC0222ms... interfaceC0222msArr) throws Throwable {
        new ms(z, interfaceC0222msArr).ms();
    }

    private void ms() throws Throwable {
        try {
            this.xr.await();
            Throwable th = this.f648ms;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
