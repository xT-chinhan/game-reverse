package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: classes.dex */
class bh implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ bg a;

    bh(bg bgVar) {
        this.a = bgVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        az.h("ThreadPoolFactory").c("线程名字=" + thread.getName() + "线程crash信息", th);
    }
}
