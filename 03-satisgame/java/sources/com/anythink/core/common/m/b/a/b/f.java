package com.anythink.core.common.m.b.a.b;

import com.anythink.core.common.m.b.ah;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    static final /* synthetic */ boolean c = true;
    private static final Executor d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.anythink.core.common.m.b.a.c.a("anythink ConnectionPool", true));
    boolean b;
    private final int e;
    private final long f;
    private final Runnable g = new Runnable() { // from class: com.anythink.core.common.m.b.a.b.f.1
        @Override // java.lang.Runnable
        public final void run() {
            while (true) {
                long jA = f.this.a(System.nanoTime());
                if (jA == -1) {
                    return;
                }
                if (jA > 0) {
                    long j = jA / C.MICROS_PER_SECOND;
                    long j2 = jA - (C.MICROS_PER_SECOND * j);
                    synchronized (f.this) {
                        try {
                            f.this.wait(j, (int) j2);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    };
    private final Deque<e> h = new ArrayDeque();
    final g a = new g();

    public f(int i, TimeUnit timeUnit) {
        this.e = i;
        this.f = timeUnit.toNanos(5L);
    }

    public final synchronized int a() {
        int i;
        Iterator<e> it = this.h.iterator();
        i = 0;
        while (it.hasNext()) {
            if (it.next().e.isEmpty()) {
                i++;
            }
        }
        return i;
    }

    public final synchronized int b() {
        return this.h.size();
    }

    final boolean a(com.anythink.core.common.m.b.a aVar, j jVar, List<ah> list, boolean z) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (e eVar : this.h) {
            if (!z || eVar.g()) {
                if (eVar.a(aVar, list)) {
                    jVar.a(eVar);
                    return true;
                }
            }
        }
        return false;
    }

    final void a(e eVar) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.b) {
            this.b = true;
            d.execute(this.g);
        }
        this.h.add(eVar);
    }

    final boolean b(e eVar) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (eVar.b || this.e == 0) {
            this.h.remove(eVar);
            return true;
        }
        notifyAll();
        return false;
    }

    public final void c() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<e> it = this.h.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.e.isEmpty()) {
                    next.b = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            com.anythink.core.common.m.b.a.c.a(((e) it2.next()).b());
        }
    }

    final long a(long j) {
        int size;
        synchronized (this) {
            e eVar = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (e eVar2 : this.h) {
                List<Reference<j>> list = eVar2.e;
                int i3 = 0;
                while (true) {
                    if (i3 < list.size()) {
                        Reference<j> reference = list.get(i3);
                        if (reference.get() == null) {
                            com.anythink.core.common.m.b.a.g.c.e().a("A connection to " + eVar2.a().a().a() + " was leaked. Did you forget to close a response body?", ((j.a) reference).a);
                            list.remove(i3);
                            eVar2.b = true;
                            if (list.isEmpty()) {
                                eVar2.f = j - this.f;
                                size = 0;
                                break;
                            }
                        } else {
                            i3++;
                        }
                    } else {
                        size = list.size();
                        break;
                    }
                }
                if (size > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - eVar2.f;
                    if (j3 > j2) {
                        eVar = eVar2;
                        j2 = j3;
                    }
                }
            }
            long j4 = this.f;
            if (j2 < j4 && i <= this.e) {
                if (i > 0) {
                    return j4 - j2;
                }
                if (i2 > 0) {
                    return j4;
                }
                this.b = false;
                return -1L;
            }
            this.h.remove(eVar);
            com.anythink.core.common.m.b.a.c.a(eVar.b());
            return 0L;
        }
    }

    private int a(e eVar, long j) {
        List<Reference<j>> list = eVar.e;
        int i = 0;
        while (i < list.size()) {
            Reference<j> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                com.anythink.core.common.m.b.a.g.c.e().a("A connection to " + eVar.a().a().a() + " was leaked. Did you forget to close a response body?", ((j.a) reference).a);
                list.remove(i);
                eVar.b = true;
                if (list.isEmpty()) {
                    eVar.f = j - this.f;
                    return 0;
                }
            }
        }
        return list.size();
    }

    private void a(ah ahVar, IOException iOException) {
        if (ahVar.b().type() != Proxy.Type.DIRECT) {
            com.anythink.core.common.m.b.a aVarA = ahVar.a();
            aVarA.g().connectFailed(aVarA.a().a(), ahVar.b().address(), iOException);
        }
        this.a.a(ahVar);
    }
}
