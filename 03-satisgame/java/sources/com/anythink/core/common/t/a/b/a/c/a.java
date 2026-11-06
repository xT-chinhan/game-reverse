package com.anythink.core.common.t.a.b.a.c;

import com.anythink.core.common.t.a.b.a.b;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class a<T extends b> {
    private final InterfaceC0051a<T> c;
    private final float d = 1.5f;
    private final int e = 20;
    private final AtomicInteger f = new AtomicInteger(0);
    private int b = 5;
    private final Queue<T> a = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: com.anythink.core.common.t.a.b.a.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0051a<T extends b> {
        T a();
    }

    public a(InterfaceC0051a<T> interfaceC0051a) {
        this.c = interfaceC0051a;
    }

    private void b() {
        int iMin;
        synchronized (this) {
            double d = this.f.get();
            int i = this.b;
            if (d > ((double) i) * 0.8d && (iMin = Math.min((int) (i * 1.5f), 20)) > this.b) {
                this.b = iMin;
            }
        }
    }

    public final T a() {
        int iMin;
        T tPoll = this.a.poll();
        if (tPoll == null) {
            tPoll = (T) this.c.a();
        }
        this.f.incrementAndGet();
        synchronized (this) {
            double d = this.f.get();
            int i = this.b;
            if (d > ((double) i) * 0.8d && (iMin = Math.min((int) (i * 1.5f), 20)) > this.b) {
                this.b = iMin;
            }
        }
        return tPoll;
    }

    public final void a(T t) {
        if (t != null) {
            t.c();
            if (this.a.size() < this.b) {
                t.c();
                this.a.offer(t);
            }
            this.f.decrementAndGet();
        }
    }
}
