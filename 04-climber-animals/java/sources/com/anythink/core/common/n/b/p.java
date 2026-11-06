package com.anythink.core.common.n.b;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class p {
    static final /* synthetic */ boolean a = true;
    private Runnable d;
    private ExecutorService e;
    private int b = 64;
    private int c = 5;
    private final Deque<ac.a> f = new ArrayDeque();
    private final Deque<ac.a> g = new ArrayDeque();
    private final Deque<ac> h = new ArrayDeque();

    public p(ExecutorService executorService) {
        this.e = executorService;
    }

    public p() {
    }

    private synchronized ExecutorService a() {
        if (this.e == null) {
            this.e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.anythink.core.common.n.b.a.c.a(aa.a + "-HttpDispatcher", false));
        }
        return this.e;
    }

    private void a(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
        }
        synchronized (this) {
            this.b = i;
        }
        e();
    }

    private synchronized int b() {
        return this.b;
    }

    private void b(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
        }
        synchronized (this) {
            this.c = i;
        }
        e();
    }

    private synchronized int c() {
        return this.c;
    }

    private synchronized void a(Runnable runnable) {
        this.d = runnable;
    }

    final void a(ac.a aVar) {
        ac.a next;
        synchronized (this) {
            this.f.add(aVar);
            if (!ac.this.c) {
                String strB = aVar.b();
                Iterator<ac.a> it = this.g.iterator();
                do {
                    if (!it.hasNext()) {
                        Iterator<ac.a> it2 = this.f.iterator();
                        do {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                        } while (!next.b().equals(strB));
                    } else {
                        next = it.next();
                    }
                } while (!next.b().equals(strB));
                if (next != null) {
                    aVar.a(next);
                }
            }
        }
        e();
    }

    private ac.a a(String str) {
        for (ac.a aVar : this.g) {
            if (aVar.b().equals(str)) {
                return aVar;
            }
        }
        for (ac.a aVar2 : this.f) {
            if (aVar2.b().equals(str)) {
                return aVar2;
            }
        }
        return null;
    }

    private synchronized void d() {
        Iterator<ac.a> it = this.f.iterator();
        while (it.hasNext()) {
            ac.this.c();
        }
        Iterator<ac.a> it2 = this.g.iterator();
        while (it2.hasNext()) {
            ac.this.c();
        }
        Iterator<ac> it3 = this.h.iterator();
        while (it3.hasNext()) {
            it3.next().c();
        }
    }

    private boolean e() {
        int i;
        boolean z;
        if (!a && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<ac.a> it = this.f.iterator();
            while (it.hasNext()) {
                ac.a next = it.next();
                if (this.g.size() >= this.b) {
                    break;
                }
                if (next.a().get() < this.c) {
                    it.remove();
                    next.a().incrementAndGet();
                    arrayList.add(next);
                    this.g.add(next);
                }
            }
            z = i() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((ac.a) arrayList.get(i)).a(a());
        }
        return z;
    }

    final synchronized void a(ac acVar) {
        this.h.add(acVar);
    }

    final void b(ac.a aVar) {
        aVar.a().decrementAndGet();
        a(this.g, aVar);
    }

    final void b(ac acVar) {
        a(this.h, acVar);
    }

    private <T> void a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.d;
        }
        if (e() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private synchronized List<e> f() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<ac.a> it = this.f.iterator();
        while (it.hasNext()) {
            arrayList.add(ac.this);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized List<e> g() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.h);
        Iterator<ac.a> it = this.g.iterator();
        while (it.hasNext()) {
            arrayList.add(ac.this);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized int h() {
        return this.f.size();
    }

    private synchronized int i() {
        return this.g.size() + this.h.size();
    }
}
