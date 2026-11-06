package com.bytedance.sdk.component.ah.xr.ms;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr implements Runnable {
    protected final String xr;

    protected abstract void ah();

    public xr(String str, Object... objArr) {
        this.xr = ah.ms(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.xr);
        try {
            ah();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
