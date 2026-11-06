package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class xh implements Runnable {
    public final /* synthetic */ yh a;

    public xh(yh yhVar) {
        this.a = yhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.a.onTimeout();
    }
}
