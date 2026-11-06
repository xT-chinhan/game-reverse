package com.bytedance.embedapplog;

/* JADX INFO: loaded from: classes2.dex */
abstract class ce<T> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile T f480ms;

    protected abstract T ms(Object... objArr);

    ce() {
    }

    public final T xr(Object... objArr) {
        if (this.f480ms == null) {
            synchronized (this) {
                if (this.f480ms == null) {
                    this.f480ms = ms(objArr);
                }
            }
        }
        return this.f480ms;
    }
}
