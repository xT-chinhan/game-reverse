package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class yh implements Runnable {
    public final /* synthetic */ di a;

    public yh(di diVar) {
        this.a = diVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        di diVar = this.a;
        if (diVar.a != null && diVar.e.compareAndSet(false, true)) {
            this.a.d.post(new xh(this));
        }
    }
}
