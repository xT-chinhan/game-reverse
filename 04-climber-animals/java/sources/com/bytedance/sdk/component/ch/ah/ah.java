package com.bytedance.sdk.component.ch.ah;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends com.bytedance.sdk.component.ch.ms.ah implements Runnable {
    final Runnable d;

    public ah(Runnable runnable) {
        super(runnable);
        this.d = runnable;
        xr(false);
        ms(false);
    }

    @Override // com.bytedance.sdk.component.ch.ms.ah, java.lang.Runnable
    public void run() {
        this.d.run();
    }
}
