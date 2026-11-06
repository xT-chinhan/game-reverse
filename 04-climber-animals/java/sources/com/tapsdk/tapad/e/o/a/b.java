package com.tapsdk.tapad.e.o.a;

import io.reactivex.ObservableEmitter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class b<T> extends AtomicInteger {
    private static final long c = Long.MIN_VALUE;
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private final ObservableEmitter<? super a<T>> a;
    private long b = Long.MIN_VALUE;

    public static class a<T> {
        public final k a;
        public final T b;

        public a(k kVar) {
            this(kVar, null);
        }

        public a(k kVar, T t) {
            this.a = kVar;
            this.b = t;
        }
    }

    public b(ObservableEmitter<? super a<T>> observableEmitter) {
        this.a = observableEmitter;
        a();
    }

    private void a() {
        boolean z;
        synchronized (this) {
            z = this.b == Long.MIN_VALUE;
        }
        if (z) {
            this.b = 2147483647L;
            compareAndSet(0, 1);
        }
    }

    private void a(a<T> aVar) {
        try {
            this.a.onNext(aVar);
            this.a.onComplete();
        } catch (Exception unused) {
        }
    }

    void a(Throwable th) {
        set(3);
        try {
            this.a.onError(th);
        } catch (Exception unused) {
        }
    }

    void b(a<T> aVar) {
        int i = 0;
        while (true) {
            int i2 = get();
            if (i2 != 0) {
                if (i2 == 1 && compareAndSet(1, 3)) {
                    a(aVar);
                    return;
                }
            } else if (compareAndSet(0, 2)) {
                return;
            }
            if (i >= 10) {
                a(new Throwable("unexpected error status"));
                return;
            }
            i++;
        }
    }
}
