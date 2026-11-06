package com.tapsdk.tapad.internal.download.m.d;

import android.os.SystemClock;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.download.StatusUtil;
import com.tapsdk.tapad.internal.download.core.breakpoint.i;
import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.f;
import com.tapsdk.tapad.internal.download.m.c;
import com.tapsdk.tapad.internal.download.m.e.e;
import java.io.File;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static final String j = "DownloadDispatcher";
    int a;
    private final List<e> b;
    private final List<e> c;
    private final List<e> d;
    private final List<e> e;
    private final AtomicInteger f;
    private volatile ExecutorService g;
    private final AtomicInteger h;
    private i i;

    public b() {
        this(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
    }

    b(List<e> list, List<e> list2, List<e> list3, List<e> list4) {
        this.a = 5;
        this.f = new AtomicInteger();
        this.h = new AtomicInteger();
        this.b = list;
        this.c = list2;
        this.d = list3;
        this.e = list4;
    }

    private synchronized void a(com.tapsdk.tapad.internal.download.m.a aVar, List<e> list, List<e> list2) {
        Iterator<e> it = this.b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            f fVar = next.b;
            if (fVar == aVar || fVar.b() == aVar.b()) {
                if (!next.g() && !next.h()) {
                    it.remove();
                    list.add(next);
                    return;
                }
                return;
            }
        }
        for (e eVar : this.c) {
            f fVar2 = eVar.b;
            if (fVar2 == aVar || fVar2.b() == aVar.b()) {
                list.add(eVar);
                list2.add(eVar);
                return;
            }
        }
        for (e eVar2 : this.d) {
            f fVar3 = eVar2.b;
            if (fVar3 == aVar || fVar3.b() == aVar.b()) {
                list.add(eVar2);
                list2.add(eVar2);
                return;
            }
        }
    }

    private synchronized void a(List<e> list, List<e> list2) {
        c.a(j, "handle cancel calls, cancel calls: " + list2.size());
        if (!list2.isEmpty()) {
            for (e eVar : list2) {
                if (!eVar.c()) {
                    list.remove(eVar);
                }
            }
        }
        c.a(j, "handle cancel calls, callback cancel event: " + list.size());
        if (!list.isEmpty()) {
            if (list.size() <= 1) {
                com.tapsdk.tapad.internal.download.i.j().b().a().a(list.get(0).b, EndCause.CANCELED, (Exception) null);
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<e> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().b);
                }
                com.tapsdk.tapad.internal.download.i.j().b().a(arrayList);
            }
        }
    }

    private boolean a(f fVar, Collection<f> collection, Collection<f> collection2) {
        return a(fVar, this.b, collection, collection2) || a(fVar, this.c, collection, collection2) || a(fVar, this.d, collection, collection2);
    }

    public static void b(int i) {
        b bVarE = com.tapsdk.tapad.internal.download.i.j().e();
        if (bVarE.getClass() != b.class) {
            throw new IllegalStateException("The current dispatcher is " + bVarE + " not DownloadDispatcher exactly!");
        }
        bVarE.a = Math.max(1, i);
    }

    private synchronized void b(f fVar) {
        e eVarA = e.a(fVar, true, this.i);
        if (d() < this.a) {
            this.c.add(eVarA);
            b().execute(eVarA);
        } else {
            this.b.add(eVarA);
        }
    }

    private synchronized void b(f[] fVarArr) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        c.a(j, "start enqueueLocked for bunch task: " + fVarArr.length);
        ArrayList<f> arrayList = new ArrayList();
        Collections.addAll(arrayList, fVarArr);
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        int size = this.b.size();
        try {
            com.tapsdk.tapad.internal.download.i.j().f().a();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (f fVar : arrayList) {
                if (!a(fVar, arrayList2) && !a(fVar, (Collection<f>) arrayList3, (Collection<f>) arrayList4)) {
                    b(fVar);
                }
            }
            com.tapsdk.tapad.internal.download.i.j().b().a(arrayList2, arrayList3, arrayList4);
        } catch (UnknownHostException e) {
            com.tapsdk.tapad.internal.download.i.j().b().a(new ArrayList(arrayList), e);
        }
        if (size != this.b.size()) {
            Collections.sort(this.b);
        }
        c.a(j, "end enqueueLocked for bunch task: " + fVarArr.length + " consume " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
    }

    private synchronized void b(com.tapsdk.tapad.internal.download.m.a[] aVarArr) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        c.a(j, "start cancel bunch task manually: " + aVarArr.length);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            for (com.tapsdk.tapad.internal.download.m.a aVar : aVarArr) {
                a(aVar, arrayList, arrayList2);
            }
            a(arrayList, arrayList2);
            c.a(j, "finish cancel bunch task manually: " + aVarArr.length + " consume " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
        } catch (Throwable th) {
            a(arrayList, arrayList2);
            c.a(j, "finish cancel bunch task manually: " + aVarArr.length + " consume " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
            throw th;
        }
    }

    private synchronized void c() {
        if (this.h.get() > 0) {
            return;
        }
        if (d() >= this.a) {
            return;
        }
        if (this.b.isEmpty()) {
            return;
        }
        Iterator<e> it = this.b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            it.remove();
            f fVar = next.b;
            if (h(fVar)) {
                com.tapsdk.tapad.internal.download.i.j().b().a().a(fVar, EndCause.FILE_BUSY, (Exception) null);
            } else {
                this.c.add(next);
                b().execute(next);
                if (d() >= this.a) {
                    return;
                }
            }
        }
    }

    private synchronized void c(f fVar) {
        c.a(j, "enqueueLocked for single task: " + fVar);
        if (f(fVar)) {
            return;
        }
        if (g(fVar)) {
            return;
        }
        int size = this.b.size();
        b(fVar);
        if (size != this.b.size()) {
            Collections.sort(this.b);
        }
    }

    private int d() {
        return this.c.size() - this.f.get();
    }

    private boolean g(f fVar) {
        return a(fVar, (Collection<f>) null, (Collection<f>) null);
    }

    public void a() {
        this.h.incrementAndGet();
        ArrayList arrayList = new ArrayList();
        Iterator<e> it = this.b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().b);
        }
        Iterator<e> it2 = this.c.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().b);
        }
        Iterator<e> it3 = this.d.iterator();
        while (it3.hasNext()) {
            arrayList.add(it3.next().b);
        }
        if (!arrayList.isEmpty()) {
            b((com.tapsdk.tapad.internal.download.m.a[]) arrayList.toArray(new f[arrayList.size()]));
        }
        this.h.decrementAndGet();
    }

    public void a(i iVar) {
        this.i = iVar;
    }

    public void a(f fVar) {
        this.h.incrementAndGet();
        c(fVar);
        this.h.decrementAndGet();
    }

    public synchronized void a(e eVar) {
        List<e> list;
        boolean z = eVar.c;
        if (this.e.contains(eVar)) {
            list = this.e;
        } else {
            list = z ? this.c : this.d;
        }
        if (!list.remove(eVar)) {
            throw new AssertionError("Call wasn't in-flight!");
        }
        if (z && eVar.g()) {
            this.f.decrementAndGet();
        }
        if (z) {
            c();
        }
    }

    public void a(f[] fVarArr) {
        this.h.incrementAndGet();
        b(fVarArr);
        this.h.decrementAndGet();
    }

    public void a(com.tapsdk.tapad.internal.download.m.a[] aVarArr) {
        this.h.incrementAndGet();
        b(aVarArr);
        this.h.decrementAndGet();
        c();
    }

    public boolean a(int i) {
        this.h.incrementAndGet();
        boolean zB = b(f.c(i));
        this.h.decrementAndGet();
        c();
        return zB;
    }

    boolean a(f fVar, Collection<f> collection) {
        if (!fVar.A() || !StatusUtil.c(fVar)) {
            return false;
        }
        if (fVar.a() == null && !com.tapsdk.tapad.internal.download.i.j().f().b(fVar)) {
            return false;
        }
        com.tapsdk.tapad.internal.download.i.j().f().a(fVar, this.i);
        if (collection != null) {
            collection.add(fVar);
            return true;
        }
        com.tapsdk.tapad.internal.download.i.j().b().a().a(fVar, EndCause.COMPLETED, new Exception(Constants.q.b));
        return true;
    }

    boolean a(f fVar, Collection<e> collection, Collection<f> collection2, Collection<f> collection3) {
        a aVarB = com.tapsdk.tapad.internal.download.i.j().b();
        Iterator<e> it = collection.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (!next.g()) {
                if (next.a(fVar)) {
                    if (next.h()) {
                        c.a(j, "task: " + fVar.b() + " is finishing, move it to finishing list");
                        this.e.add(next);
                        it.remove();
                        return false;
                    }
                    if (collection2 != null) {
                        collection2.add(fVar);
                    } else {
                        aVarB.a().a(fVar, EndCause.SAME_TASK_BUSY, (Exception) null);
                    }
                    return true;
                }
                File fileD = next.d();
                File fileH = fVar.h();
                if (fileD != null && fileH != null && fileD.equals(fileH)) {
                    if (collection3 != null) {
                        collection3.add(fVar);
                    } else {
                        aVarB.a().a(fVar, EndCause.FILE_BUSY, (Exception) null);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(com.tapsdk.tapad.internal.download.m.a aVar) {
        this.h.incrementAndGet();
        boolean zB = b(aVar);
        this.h.decrementAndGet();
        c();
        return zB;
    }

    synchronized ExecutorService b() {
        if (this.g == null) {
            this.g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkDownload Download", false));
        }
        return this.g;
    }

    public synchronized void b(e eVar) {
        c.a(j, "flying canceled: " + eVar.b.b());
        if (eVar.c) {
            this.f.incrementAndGet();
        }
    }

    synchronized boolean b(com.tapsdk.tapad.internal.download.m.a aVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        c.a(j, "cancel manually: " + aVar.b());
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        try {
            a(aVar, arrayList, arrayList2);
            a(arrayList, arrayList2);
        } catch (Throwable th) {
            a(arrayList, arrayList2);
            throw th;
        }
        return arrayList.size() > 0 || arrayList2.size() > 0;
    }

    void c(e eVar) {
        eVar.run();
    }

    public void d(f fVar) {
        c.a(j, "execute: " + fVar);
        synchronized (this) {
            if (f(fVar)) {
                return;
            }
            if (g(fVar)) {
                return;
            }
            e eVarA = e.a(fVar, false, this.i);
            this.d.add(eVarA);
            c(eVarA);
        }
    }

    public synchronized f e(f fVar) {
        c.a(j, "findSameTask: " + fVar.b());
        for (e eVar : this.b) {
            if (!eVar.g() && eVar.a(fVar)) {
                return eVar.b;
            }
        }
        for (e eVar2 : this.c) {
            if (!eVar2.g() && eVar2.a(fVar)) {
                return eVar2.b;
            }
        }
        for (e eVar3 : this.d) {
            if (!eVar3.g() && eVar3.a(fVar)) {
                return eVar3.b;
            }
        }
        return null;
    }

    boolean f(f fVar) {
        return a(fVar, (Collection<f>) null);
    }

    public synchronized boolean h(f fVar) {
        f fVar2;
        File fileH;
        f fVar3;
        File fileH2;
        c.a(j, "is file conflict after run: " + fVar.b());
        File fileH3 = fVar.h();
        if (fileH3 == null) {
            return false;
        }
        for (e eVar : this.d) {
            if (!eVar.g() && (fVar3 = eVar.b) != fVar && (fileH2 = fVar3.h()) != null && fileH3.equals(fileH2)) {
                return true;
            }
        }
        for (e eVar2 : this.c) {
            if (!eVar2.g() && (fVar2 = eVar2.b) != fVar && (fileH = fVar2.h()) != null && fileH3.equals(fileH)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean i(f fVar) {
        c.a(j, "isPending: " + fVar.b());
        for (e eVar : this.b) {
            if (!eVar.g() && eVar.a(fVar)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean j(f fVar) {
        c.a(j, "isRunning: " + fVar.b());
        for (e eVar : this.d) {
            if (!eVar.g() && eVar.a(fVar)) {
                return true;
            }
        }
        for (e eVar2 : this.c) {
            if (!eVar2.g() && eVar2.a(fVar)) {
                return true;
            }
        }
        return false;
    }
}
