package com.byazt.wye;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1008, 121})
public class x extends com.byazt.nzn.x {
    public ExecutorService pr;
    public final Deque<pr.C0229pr> hw = new ArrayDeque();
    public final Deque<pr.C0229pr> hn = new ArrayDeque();
    public final Deque<pr> x = new ArrayDeque();
    public AtomicInteger c = new AtomicInteger(64);

    public x() {
        if (this.pr == null) {
            this.pr = new com.byazt.fr.x(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.byazt.wye.x.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.byazt.fr.hn hnVar = new com.byazt.fr.hn(runnable, "systemHttp Dispatcher");
                    hnVar.setDaemon(false);
                    hnVar.setPriority(10);
                    return hnVar;
                }
            });
        }
    }

    @Override // com.byazt.nzn.x
    public ExecutorService hw() {
        return this.pr;
    }

    @Override // com.byazt.nzn.x
    public void pr(int i) {
        this.c.set(i);
    }

    @Override // com.byazt.nzn.x
    public synchronized List<com.byazt.nzn.hw> hn() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            for (pr.C0229pr c0229pr : this.hw) {
                if (c0229pr != null && c0229pr.pr() != null) {
                    arrayList.add(c0229pr.pr());
                }
            }
        } catch (Throwable th) {
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.byazt.nzn.x
    public synchronized List<com.byazt.nzn.hw> x() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            arrayList.addAll(this.x);
            for (pr.C0229pr c0229pr : this.hn) {
                if (c0229pr != null && c0229pr.pr() != null) {
                    arrayList.add(c0229pr.pr());
                }
            }
        } catch (Throwable th) {
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.byazt.nzn.x
    public int pr() {
        return this.c.get();
    }

    @Override // com.byazt.nzn.x
    public void hw(int i) {
    }

    public synchronized void pr(pr.C0229pr c0229pr) {
        try {
            if (this.hn.size() < pr()) {
                this.hn.add(c0229pr);
                if (c0229pr != null) {
                    c0229pr.hw();
                }
                hw().submit(c0229pr);
                return;
            }
            this.hw.add(c0229pr);
        } catch (Throwable th) {
        }
    }

    public synchronized void pr(pr prVar) {
        this.x.add(prVar);
    }

    public void hw(pr.C0229pr c0229pr) {
        pr(this.hn, c0229pr, true);
    }

    public void hw(pr prVar) {
        pr(this.x, prVar, false);
    }

    private <T> void pr(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            deque.remove(t);
            if (z) {
                c();
            }
        }
    }

    private void c() {
        if (this.hn.size() < pr() && !this.hw.isEmpty()) {
            Iterator<pr.C0229pr> it = this.hw.iterator();
            while (it.hasNext()) {
                pr.C0229pr next = it.next();
                it.remove();
                this.hn.add(next);
                if (next != null) {
                    next.hw();
                }
                hw().submit(next);
                if (this.hn.size() >= pr()) {
                    return;
                }
            }
        }
    }
}
