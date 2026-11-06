package com.byazt.aa;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 668, 50})
public class vk implements Runnable {
    public WeakReference<Runnable> pr;

    public vk(Runnable runnable) {
        this.pr = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.pr.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
