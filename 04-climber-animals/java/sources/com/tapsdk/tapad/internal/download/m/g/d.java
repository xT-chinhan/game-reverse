package com.tapsdk.tapad.internal.download.m.g;

import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tapsdk.tapad.internal.download.core.breakpoint.i;
import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static final String y = "MultiPointOutputStream";
    private static final ExecutorService z = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.tapsdk.tapad.internal.download.m.c.a("OkDownload file io", false));
    final SparseArray<com.tapsdk.tapad.internal.download.m.g.a> a;
    final SparseArray<AtomicLong> b;
    final AtomicLong c;
    final AtomicLong d;
    boolean e;
    private final int f;
    private final int g;
    private final int h;
    private final com.tapsdk.tapad.internal.download.core.breakpoint.c i;
    private final f j;
    private final i k;
    private final boolean l;
    private final boolean m;
    volatile Future n;
    volatile Thread o;
    final SparseArray<Thread> p;
    private final Runnable q;
    private String r;
    IOException s;
    ArrayList<Integer> t;
    List<Integer> u;
    final c v;
    c w;
    private volatile boolean x;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.m();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a();
        }
    }

    static class c {
        boolean a;
        List<Integer> b = new ArrayList();
        List<Integer> c = new ArrayList();

        c() {
        }

        boolean a() {
            return this.a || this.c.size() > 0;
        }
    }

    public d(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, i iVar) {
        this(fVar, cVar, iVar, null);
    }

    d(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, i iVar, Runnable runnable) {
        this.a = new SparseArray<>();
        this.b = new SparseArray<>();
        this.c = new AtomicLong();
        this.d = new AtomicLong();
        this.e = false;
        this.p = new SparseArray<>();
        this.v = new c();
        this.w = new c();
        this.x = true;
        this.j = fVar;
        this.f = fVar.j();
        this.g = fVar.v();
        this.h = fVar.u();
        this.i = cVar;
        this.k = iVar;
        this.l = com.tapsdk.tapad.internal.download.i.j().h().a();
        this.m = com.tapsdk.tapad.internal.download.i.j().i().b(fVar);
        this.t = new ArrayList<>();
        if (runnable == null) {
            this.q = new a();
        } else {
            this.q = runnable;
        }
        File fileH = fVar.h();
        if (fileH != null) {
            this.r = fileH.getAbsolutePath();
        }
    }

    private void g() {
        if (this.r != null || this.j.h() == null) {
            return;
        }
        this.r = this.j.h().getAbsolutePath();
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d4 A[Catch: all -> 0x0182, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:12:0x000e, B:17:0x0022, B:18:0x0028, B:20:0x002e, B:21:0x0034, B:24:0x003d, B:25:0x0070, B:39:0x00c8, B:40:0x00ce, B:42:0x00d4, B:43:0x00da, B:46:0x00e3, B:47:0x0116, B:51:0x0126, B:52:0x012c, B:54:0x0132, B:55:0x0138, B:58:0x0141, B:59:0x0174, B:60:0x0181, B:14:0x0016, B:28:0x007f, B:30:0x0083, B:32:0x008b, B:35:0x00a3, B:37:0x00b6, B:38:0x00c7), top: B:64:0x0001, inners: #2, #3, #4, #5 }] */
    public synchronized void a() {
        List<Integer> list = this.u;
        if (list == null) {
            return;
        }
        if (this.e) {
            return;
        }
        this.e = true;
        this.t.addAll(list);
        try {
            if (this.c.get() <= 0) {
                for (Integer num : this.u) {
                    try {
                        b(num.intValue());
                    } catch (IOException e) {
                        com.tapsdk.tapad.internal.download.m.c.a(y, "OutputStream close failed task[" + this.j.b() + "] block[" + num + "]" + e);
                    }
                }
                this.k.a(this.j.b(), EndCause.CANCELED, (Exception) null);
                return;
            }
            if (this.n == null || this.n.isDone()) {
                for (Integer num2 : this.u) {
                    try {
                        b(num2.intValue());
                    } catch (IOException e2) {
                        com.tapsdk.tapad.internal.download.m.c.a(y, "OutputStream close failed task[" + this.j.b() + "] block[" + num2 + "]" + e2);
                    }
                }
                this.k.a(this.j.b(), EndCause.CANCELED, (Exception) null);
                return;
            }
            g();
            com.tapsdk.tapad.internal.download.i.j().i().a().b(this.r);
            try {
                a(true, -1);
                com.tapsdk.tapad.internal.download.i.j().i().a().a(this.r);
                while (r1.hasNext()) {
                    b(num2.intValue());
                }
                this.k.a(this.j.b(), EndCause.CANCELED, (Exception) null);
                return;
            } catch (Throwable th) {
                com.tapsdk.tapad.internal.download.i.j().i().a().a(this.r);
                throw th;
            }
        } catch (Throwable th2) {
            for (Integer num3 : this.u) {
                try {
                    b(num3.intValue());
                } catch (IOException e3) {
                    com.tapsdk.tapad.internal.download.m.c.a(y, "OutputStream close failed task[" + this.j.b() + "] block[" + num3 + "]" + e3);
                }
            }
            this.k.a(this.j.b(), EndCause.CANCELED, (Exception) null);
            throw th2;
        }
        throw th;
    }

    public void a(int i) {
        this.t.add(Integer.valueOf(i));
    }

    public synchronized void a(int i, byte[] bArr, int i2) throws IOException {
        if (this.e) {
            return;
        }
        e(i).a(bArr, 0, i2);
        long j = i2;
        this.c.addAndGet(j);
        this.b.get(i).addAndGet(j);
        f();
    }

    void a(long j) {
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(j));
    }

    void a(StatFs statFs, long j) throws com.tapsdk.tapad.internal.download.m.f.e {
        long jA = com.tapsdk.tapad.internal.download.m.c.a(statFs);
        if (jA < j) {
            throw new com.tapsdk.tapad.internal.download.m.f.e(j, jA);
        }
    }

    void a(c cVar) {
        cVar.c.clear();
        int size = new HashSet((List) this.t.clone()).size();
        if (size != this.u.size()) {
            com.tapsdk.tapad.internal.download.m.c.a(y, "task[" + this.j.b() + "] current need fetching block count " + this.u.size() + " is not equal to no more stream block count " + size);
            cVar.a = false;
        } else {
            com.tapsdk.tapad.internal.download.m.c.a(y, "task[" + this.j.b() + "] current need fetching block count " + this.u.size() + " is equal to no more stream block count " + size);
            cVar.a = true;
        }
        SparseArray<com.tapsdk.tapad.internal.download.m.g.a> sparseArrayClone = this.a.clone();
        int size2 = sparseArrayClone.size();
        for (int i = 0; i < size2; i++) {
            int iKeyAt = sparseArrayClone.keyAt(i);
            if (this.t.contains(Integer.valueOf(iKeyAt)) && !cVar.b.contains(Integer.valueOf(iKeyAt))) {
                cVar.b.add(Integer.valueOf(iKeyAt));
                cVar.c.add(Integer.valueOf(iKeyAt));
            }
        }
    }

    void a(Thread thread) {
        LockSupport.unpark(thread);
    }

    public void a(List<Integer> list) {
        this.u = list;
    }

    void a(boolean z2, int i) {
        if (this.n == null || this.n.isDone()) {
            return;
        }
        if (!z2) {
            this.p.put(i, Thread.currentThread());
        }
        if (this.o == null) {
            while (!i()) {
                a(25L);
            }
        }
        a(this.o);
        if (!z2) {
            k();
            return;
        }
        a(this.o);
        try {
            this.n.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public void b() {
        z.execute(new b());
    }

    synchronized void b(int i) throws IOException {
        com.tapsdk.tapad.internal.download.m.g.a aVar = this.a.get(i);
        if (aVar != null) {
            aVar.close();
            synchronized (this.b) {
                this.a.remove(i);
                this.b.remove(i);
            }
            com.tapsdk.tapad.internal.download.m.c.a(y, "OutputStream close task[" + this.j.b() + "] block[" + i + "]");
        }
    }

    Future c() {
        return z.submit(this.q);
    }

    public void c(int i) throws IOException {
        this.t.add(Integer.valueOf(i));
        try {
            IOException iOException = this.s;
            if (iOException != null) {
                throw iOException;
            }
            if (this.n == null || this.n.isDone()) {
                com.tapsdk.tapad.internal.download.m.c.a(y, (this.n == null ? new StringBuilder("OutputStream done but no need to ensure sync, because the sync job not run yet. task[").append(this.j.b()).append("] block[").append(i).append("]") : new StringBuilder("OutputStream done but no need to ensure sync, because the syncFuture.isDone[").append(this.n.isDone()).append("] task[").append(this.j.b()).append("] block[").append(i).append("]")).toString());
            } else {
                AtomicLong atomicLong = this.b.get(i);
                if (atomicLong != null && atomicLong.get() > 0) {
                    a(this.v);
                    a(this.v.a, i);
                }
            }
            b(i);
        } catch (Throwable th) {
            b(i);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005a  */
    /* JADX WARN: Code duplicated, block: B:19:0x0060 A[LOOP:1: B:18:0x005e->B:19:0x0060, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    void d() throws IOException {
        int size;
        long j;
        boolean z2;
        int size2;
        synchronized (this.b) {
            size = this.b.size();
        }
        SparseArray sparseArray = new SparseArray(size);
        int i = 0;
        while (true) {
            j = 0;
            if (i >= size) {
                break;
            }
            try {
                int iKeyAt = this.a.keyAt(i);
                long j2 = this.b.get(iKeyAt).get();
                if (j2 > 0) {
                    sparseArray.put(iKeyAt, Long.valueOf(j2));
                    this.a.get(iKeyAt).a();
                }
                i++;
            } catch (IOException e) {
                com.tapsdk.tapad.internal.download.m.c.c(y, "OutputStream flush and sync data to filesystem failed " + e);
                z2 = false;
            }
            if (z2) {
                size2 = sparseArray.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    int iKeyAt2 = sparseArray.keyAt(i2);
                    long jLongValue = ((Long) sparseArray.valueAt(i2)).longValue();
                    this.k.a(this.i, iKeyAt2, jLongValue);
                    j += jLongValue;
                    this.b.get(iKeyAt2).addAndGet(-jLongValue);
                    com.tapsdk.tapad.internal.download.m.c.a(y, "OutputStream sync success (" + this.j.b() + ") block(" + iKeyAt2 + ")  syncLength(" + jLongValue + ") currentOffset(" + this.i.b(iKeyAt2).c() + ")");
                }
                this.c.addAndGet(-j);
                this.d.set(SystemClock.uptimeMillis());
            }
        }
        z2 = true;
        if (z2) {
            size2 = sparseArray.size();
            while (i2 < size2) {
                int iKeyAt3 = sparseArray.keyAt(i2);
                long jLongValue2 = ((Long) sparseArray.valueAt(i2)).longValue();
                this.k.a(this.i, iKeyAt3, jLongValue2);
                j += jLongValue2;
                this.b.get(iKeyAt3).addAndGet(-jLongValue2);
                com.tapsdk.tapad.internal.download.m.c.a(y, "OutputStream sync success (" + this.j.b() + ") block(" + iKeyAt3 + ")  syncLength(" + jLongValue2 + ") currentOffset(" + this.i.b(iKeyAt3).c() + ")");
            }
            this.c.addAndGet(-j);
            this.d.set(SystemClock.uptimeMillis());
        }
    }

    public void d(int i) throws IOException {
        com.tapsdk.tapad.internal.download.core.breakpoint.a aVarB = this.i.b(i);
        if (!com.tapsdk.tapad.internal.download.m.c.a(aVarB.c(), aVarB.b())) {
            throw new IOException("The current offset on block-info isn't update correct, " + aVarB.c() + " != " + aVarB.b() + " on " + i);
        }
    }

    long e() {
        return ((long) this.h) - (j() - this.d.get());
    }

    synchronized com.tapsdk.tapad.internal.download.m.g.a e(int i) throws IOException {
        com.tapsdk.tapad.internal.download.m.g.a aVar;
        Uri uriX;
        aVar = this.a.get(i);
        if (aVar == null) {
            boolean zD = com.tapsdk.tapad.internal.download.m.c.d(this.j.x());
            if (zD) {
                File fileH = this.j.h();
                if (fileH == null) {
                    throw new FileNotFoundException("Filename is not ready!");
                }
                File fileC = this.j.c();
                if (!fileC.exists() && !fileC.mkdirs()) {
                    throw new IOException("Create parent folder failed!");
                }
                if (fileH.createNewFile()) {
                    com.tapsdk.tapad.internal.download.m.c.a(y, "Create new file: " + fileH.getName());
                }
                uriX = Uri.fromFile(fileH);
            } else {
                uriX = this.j.x();
            }
            com.tapsdk.tapad.internal.download.m.g.a aVarA = com.tapsdk.tapad.internal.download.i.j().h().a(com.tapsdk.tapad.internal.download.i.j().d(), uriX, this.f);
            if (this.l) {
                long jD = this.i.b(i).d();
                if (jD > 0) {
                    aVarA.b(jD);
                    com.tapsdk.tapad.internal.download.m.c.a(y, "Create output stream write from (" + this.j.b() + ") block(" + i + ") " + jD);
                }
            }
            if (this.x) {
                this.k.c(this.j.b());
            }
            if (!this.i.k() && this.x && this.m) {
                long jH = this.i.h();
                if (zD) {
                    File fileH2 = this.j.h();
                    long length = jH - fileH2.length();
                    if (length > 0) {
                        a(new StatFs(fileH2.getAbsolutePath()), length);
                        aVarA.a(jH);
                    }
                    throw th;
                }
                aVarA.a(jH);
            }
            synchronized (this.b) {
                this.a.put(i, aVarA);
                this.b.put(i, new AtomicLong());
            }
            this.x = false;
            aVar = aVarA;
        }
        return aVar;
    }

    void f() throws IOException {
        IOException iOException = this.s;
        if (iOException != null) {
            throw iOException;
        }
        if (this.n == null) {
            synchronized (this.q) {
                if (this.n == null) {
                    this.n = c();
                }
            }
        }
    }

    boolean h() {
        return this.c.get() < ((long) this.g);
    }

    boolean i() {
        return this.o != null;
    }

    long j() {
        return SystemClock.uptimeMillis();
    }

    void k() {
        LockSupport.park();
    }

    void l() throws IOException {
        com.tapsdk.tapad.internal.download.m.c.a(y, "OutputStream start flush looper task[" + this.j.b() + "] with syncBufferIntervalMills[" + this.h + "] syncBufferSize[" + this.g + "]");
        this.o = Thread.currentThread();
        long jE = this.h;
        d();
        while (true) {
            a(jE);
            a(this.w);
            if (this.w.a()) {
                com.tapsdk.tapad.internal.download.m.c.a(y, "runSync state change isNoMoreStream[" + this.w.a + "] newNoMoreStreamBlockList[" + this.w.c + "]");
                if (this.c.get() > 0) {
                    d();
                }
                for (Integer num : this.w.c) {
                    Thread thread = this.p.get(num.intValue());
                    this.p.remove(num.intValue());
                    if (thread != null) {
                        a(thread);
                    }
                }
                if (this.w.a) {
                    break;
                }
            } else {
                if (!h()) {
                    jE = e();
                    if (jE <= 0) {
                        d();
                    }
                }
                jE = this.h;
            }
        }
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            Thread threadValueAt = this.p.valueAt(i);
            if (threadValueAt != null) {
                a(threadValueAt);
            }
        }
        this.p.clear();
        com.tapsdk.tapad.internal.download.m.c.a(y, "OutputStream stop flush looper task[" + this.j.b() + "]");
    }

    void m() {
        try {
            l();
        } catch (IOException e) {
            this.s = e;
            com.tapsdk.tapad.internal.download.m.c.c(y, "Sync to breakpoint-store for task[" + this.j.b() + "] failed with cause: " + e);
        }
    }
}
