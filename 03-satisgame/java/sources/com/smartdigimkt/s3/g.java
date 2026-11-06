package com.smartdigimkt.s3;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        if (j.g.compareAndSet(false, true)) {
            com.smartdigimkt.q3.f.a().c(new f());
        }
    }
}
