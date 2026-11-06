package com.byazt.xev;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 13})
public abstract class hw<T> {
    public volatile T pr;

    public abstract T pr(Object... objArr);

    public final T hw(Object... objArr) {
        if (this.pr == null) {
            synchronized (this) {
                if (this.pr == null) {
                    this.pr = pr(objArr);
                }
            }
        }
        return this.pr;
    }
}
