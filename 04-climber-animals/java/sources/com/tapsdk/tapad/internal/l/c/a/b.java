package com.tapsdk.tapad.internal.l.c.a;

import io.reactivex.ObservableEmitter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class b<T> extends AtomicInteger implements com.tapsdk.tapad.internal.l.c.a.a {
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private volatile a<T> a;
    private final ObservableEmitter<a<T>> b;
    private final c<T> c;

    public static class a<T> {
        public final T a;

        public a() {
            this(null);
        }

        public a(T t) {
            this.a = t;
        }
    }

    public b(c<T> cVar, ObservableEmitter<a<T>> observableEmitter) {
        this.c = cVar;
        this.b = observableEmitter;
    }

    private void a(a<T> aVar) {
        try {
            this.b.onNext(aVar);
            this.b.onComplete();
        } catch (Exception unused) {
        }
    }

    @Override // com.tapsdk.tapad.internal.l.c.a.a
    public void a(long j) {
        if (j == 0) {
            return;
        }
        while (true) {
            int i = get();
            if (i != 0) {
                if (i == 1) {
                    return;
                }
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("Unknown state: " + i);
                    }
                    return;
                } else if (compareAndSet(2, 3)) {
                    a(this.a);
                    return;
                }
            } else if (compareAndSet(0, 1)) {
                return;
            }
        }
    }

    void a(Throwable th) {
        set(3);
        try {
            this.b.onError(th);
        } catch (Exception unused) {
        }
    }

    void b(a<T> aVar) {
        int i = 0;
        while (true) {
            int i2 = get();
            if (i2 == 0) {
                this.a = aVar;
                if (compareAndSet(0, 2)) {
                    return;
                }
            } else if (i2 == 1 && compareAndSet(1, 3)) {
                a(aVar);
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
