package com.smartdigimkt.q3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h implements Runnable {
    public String a = "sdm_default_thread";

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        Thread.currentThread().setName(this.a);
        b();
    }
}
