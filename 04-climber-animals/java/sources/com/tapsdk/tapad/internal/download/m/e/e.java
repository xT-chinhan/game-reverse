package com.tapsdk.tapad.internal.download.m.e;

import android.os.SystemClock;
import com.tapsdk.tapad.internal.download.core.breakpoint.i;
import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class e extends com.tapsdk.tapad.internal.download.m.b implements Comparable<e> {
    private static final ExecutorService j = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.tapsdk.tapad.internal.download.m.c.a("OkDownload Block", false));
    private static final String k = "DownloadCall";
    static final int l = 1;
    public final com.tapsdk.tapad.internal.download.f b;
    public final boolean c;
    final ArrayList<f> d;
    volatile d e;
    volatile boolean f;
    volatile boolean g;
    volatile Thread h;
    private final i i;

    private e(com.tapsdk.tapad.internal.download.f fVar, boolean z, i iVar) {
        this(fVar, z, new ArrayList(), iVar);
    }

    e(com.tapsdk.tapad.internal.download.f fVar, boolean z, ArrayList<f> arrayList, i iVar) {
        super("download call: " + fVar.b());
        this.b = fVar;
        this.c = z;
        this.d = arrayList;
        this.i = iVar;
    }

    public static e a(com.tapsdk.tapad.internal.download.f fVar, boolean z, i iVar) {
        return new e(fVar, z, iVar);
    }

    private void a(d dVar, EndCause endCause, Exception exc) {
        if (endCause == EndCause.CANCELED) {
            throw new IllegalAccessError("can't recognize cancelled on here");
        }
        synchronized (this) {
            if (this.f) {
                return;
            }
            this.g = true;
            this.i.a(this.b.b(), endCause, exc);
            if (endCause == EndCause.COMPLETED) {
                this.i.e(this.b.b());
                com.tapsdk.tapad.internal.download.i.j().i().a(dVar.a(), this.b);
            }
            com.tapsdk.tapad.internal.download.i.j().b().a().a(this.b, endCause, exc);
        }
    }

    private void f() {
        this.i.b(this.b.b());
        com.tapsdk.tapad.internal.download.i.j().b().a().a(this.b);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        return eVar.e() - e();
    }

    a a(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, long j2) {
        return new a(this.b, cVar, j2);
    }

    d a(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        return new d(com.tapsdk.tapad.internal.download.i.j().i().a(this.b, cVar, this.i));
    }

    Future<?> a(f fVar) {
        return j.submit(fVar);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x012f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0135  */
    /* JADX WARN: Code duplicated, block: B:35:0x0139  */
    /* JADX WARN: Code duplicated, block: B:36:0x0147  */
    /* JADX WARN: Code duplicated, block: B:37:0x0148 A[PHI: r3
      0x0148: PHI (r3v5 int) = (r3v1 int), (r3v7 int) binds: [B:32:0x0133, B:36:0x0147] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:77:0x015e A[EDGE_INSN: B:77:0x015e->B:46:0x015e BREAK  A[LOOP:0: B:3:0x0013->B:81:?], SYNTHETIC] */
    @Override // com.tapsdk.tapad.internal.download.m.b
    public void a() throws InterruptedException {
        EndCause endCause;
        IOException iOExceptionB;
        ResumeFailedCause resumeFailedCauseD;
        boolean z;
        int i;
        this.h = Thread.currentThread();
        com.tapsdk.tapad.internal.download.i iVarJ = com.tapsdk.tapad.internal.download.i.j();
        com.tapsdk.tapad.internal.download.m.g.e eVarI = iVarJ.i();
        f();
        int i2 = 0;
        do {
            if (this.b.e().length() <= 0) {
                this.e = new d.a(new IOException("unexpected url: " + this.b.e()));
                break;
            }
            if (this.f) {
                break;
            }
            try {
                com.tapsdk.tapad.internal.download.core.breakpoint.c cVarA = this.i.get(this.b.b());
                if (cVarA == null) {
                    cVarA = this.i.a(this.b);
                }
                c(cVarA);
                if (this.f) {
                    break;
                }
                d dVarA = a(cVarA);
                this.e = dVarA;
                b bVarB = b(cVarA);
                try {
                    bVarB.a();
                    dVarA.a(this.b.r());
                    eVarI.a().c(this.b.h().getAbsolutePath());
                    com.tapsdk.tapad.internal.download.i.j().f().a(this.b, cVarA, bVarB.e());
                    try {
                        if (bVarB.g()) {
                            a aVarA = a(cVarA, bVarB.e());
                            aVarA.a();
                            if (aVarA.c()) {
                                com.tapsdk.tapad.internal.download.m.c.a(k, "breakpoint invalid: download from beginning because of local check is dirty " + this.b.b() + " " + aVarA);
                                eVarI.a(this.b);
                                resumeFailedCauseD = aVarA.b();
                            } else {
                                iVarJ.b().a().a(this.b, cVarA);
                            }
                            a(dVarA, cVarA);
                            if (!this.f) {
                                break;
                            }
                            if (dVarA.h()) {
                                i = i2 + 1;
                                if (i2 < 1) {
                                    this.i.remove(this.b.b());
                                    i2 = i;
                                    z = true;
                                } else {
                                    i2 = i;
                                    z = false;
                                }
                            } else {
                                z = false;
                            }
                        } else {
                            com.tapsdk.tapad.internal.download.m.c.a(k, "breakpoint invalid: download from beginning because of remote check not resumable " + this.b.b() + " " + bVarB);
                            eVarI.a(this.b);
                            resumeFailedCauseD = bVarB.d();
                        }
                        a(cVarA, bVarB, resumeFailedCauseD);
                        a(dVarA, cVarA);
                        if (!this.f) {
                            break;
                            break;
                        }
                        if (dVarA.h()) {
                            i = i2 + 1;
                            if (i2 < 1) {
                                this.i.remove(this.b.b());
                                i2 = i;
                                z = true;
                            } else {
                                i2 = i;
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                    } catch (IOException e) {
                        dVarA.e(e);
                    }
                } catch (IOException e2) {
                    dVarA.a(e2);
                }
            } catch (IOException e3) {
                this.e = new d.a(e3);
            }
        } while (z);
        this.g = true;
        this.d.clear();
        d dVar = this.e;
        if (this.f || dVar == null) {
            return;
        }
        if (!dVar.i() && !dVar.j() && !dVar.h()) {
            iOExceptionB = null;
            if (dVar.e()) {
                endCause = EndCause.FILE_BUSY;
            } else if (dVar.g()) {
                endCause = EndCause.PRE_ALLOCATE_FAILED;
            } else {
                endCause = EndCause.COMPLETED;
            }
            a(dVar, endCause, iOExceptionB);
        }
        endCause = EndCause.ERROR;
        iOExceptionB = dVar.b();
        a(dVar, endCause, iOExceptionB);
    }

    void a(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, b bVar, ResumeFailedCause resumeFailedCause) {
        com.tapsdk.tapad.internal.download.m.c.a(this.b, cVar, bVar.e(), bVar.f());
        com.tapsdk.tapad.internal.download.i.j().b().a().a(this.b, cVar, resumeFailedCause);
    }

    void a(d dVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) throws InterruptedException {
        int iB = cVar.b();
        ArrayList arrayList = new ArrayList(cVar.b());
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < iB; i++) {
            com.tapsdk.tapad.internal.download.core.breakpoint.a aVarB = cVar.b(i);
            if (!com.tapsdk.tapad.internal.download.m.c.a(aVarB.c(), aVarB.b())) {
                com.tapsdk.tapad.internal.download.m.c.a(aVarB);
                f fVarA = f.a(i, this.b, cVar, dVar, this.i);
                arrayList.add(fVarA);
                arrayList2.add(Integer.valueOf(fVarA.c()));
            }
        }
        if (this.f) {
            return;
        }
        dVar.a().a(arrayList2);
        a(arrayList);
    }

    @Override // com.tapsdk.tapad.internal.download.m.b
    protected void a(InterruptedException interruptedException) {
    }

    void a(List<f> list) throws InterruptedException {
        ArrayList<Future> arrayList = new ArrayList(list.size());
        try {
            Iterator<f> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            this.d.addAll(list);
            for (Future future : arrayList) {
                if (!future.isDone()) {
                    try {
                        future.get();
                    } catch (CancellationException | ExecutionException unused) {
                    }
                }
            }
            this.d.removeAll(list);
        } catch (Throwable th) {
            try {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((Future) it2.next()).cancel(true);
                }
                throw th;
            } catch (Throwable th2) {
                this.d.removeAll(list);
                throw th2;
            }
        }
    }

    public boolean a(com.tapsdk.tapad.internal.download.f fVar) {
        return this.b.equals(fVar);
    }

    b b(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        return new b(this.b, cVar);
    }

    @Override // com.tapsdk.tapad.internal.download.m.b
    protected void b() {
        com.tapsdk.tapad.internal.download.i.j().e().a(this);
        com.tapsdk.tapad.internal.download.m.c.a(k, "call is finished " + this.b.b());
    }

    void c(com.tapsdk.tapad.internal.download.core.breakpoint.c cVar) {
        com.tapsdk.tapad.internal.download.f.c.a(this.b, cVar);
    }

    public boolean c() {
        synchronized (this) {
            if (this.f) {
                return false;
            }
            if (this.g) {
                return false;
            }
            this.f = true;
            long jUptimeMillis = SystemClock.uptimeMillis();
            com.tapsdk.tapad.internal.download.i.j().e().b(this);
            d dVar = this.e;
            if (dVar != null) {
                dVar.m();
            }
            Object[] array = this.d.toArray();
            if (array != null && array.length != 0) {
                for (Object obj : array) {
                    if (obj instanceof f) {
                        ((f) obj).a();
                    }
                }
            } else if (this.h != null) {
                com.tapsdk.tapad.internal.download.m.c.a(k, "interrupt thread with cancel operation because of chains are not running " + this.b.b());
                this.h.interrupt();
            }
            if (dVar != null) {
                dVar.a().b();
            }
            com.tapsdk.tapad.internal.download.m.c.a(k, "cancel task " + this.b.b() + " consume: " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
            return true;
        }
    }

    public File d() {
        return this.b.h();
    }

    int e() {
        return this.b.p();
    }

    public boolean g() {
        return this.f;
    }

    public boolean h() {
        return this.g;
    }
}
