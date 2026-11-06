package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: classes.dex */
class bl implements Runnable {
    final /* synthetic */ Runnable a;

    bl(Runnable runnable) {
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.run();
    }
}
