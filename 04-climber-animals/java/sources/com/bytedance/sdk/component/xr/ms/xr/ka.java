package com.bytedance.sdk.component.xr.ms.xr;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ka implements Runnable {
    protected final String xr;

    protected abstract void xr();

    public ka(String str, Object... objArr) {
        this.xr = ch.ms(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.xr);
        try {
            xr();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
