package com.tapsdk.tapad.internal.download;

import com.tapsdk.tapad.internal.download.core.cause.EndCause;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class e extends com.tapsdk.tapad.internal.download.m.i.b implements Runnable {
    private static final Executor g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), com.tapsdk.tapad.internal.download.m.c.a("OkDownload DynamicSerial", false));
    static final int h = 0;
    private static final String i = "DownloadSerialQueue";
    volatile boolean a;
    volatile boolean b;
    volatile boolean c;
    volatile f d;
    private final ArrayList<f> e;
    com.tapsdk.tapad.internal.download.m.i.f f;

    public e() {
        this(null);
    }

    public e(c cVar) {
        this(cVar, new ArrayList());
    }

    e(c cVar, ArrayList<f> arrayList) {
        this.a = false;
        this.b = false;
        this.c = false;
        this.f = new com.tapsdk.tapad.internal.download.m.i.f.a().a(this).a(cVar).a();
        this.e = arrayList;
    }

    public int a() {
        return this.e.size();
    }

    public void a(c cVar) {
        this.f = new com.tapsdk.tapad.internal.download.m.i.f.a().a(this).a(cVar).a();
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public void a(f fVar) {
        this.d = fVar;
    }

    @Override // com.tapsdk.tapad.internal.download.c
    public synchronized void a(f fVar, EndCause endCause, Exception exc) {
        if (endCause != EndCause.CANCELED && fVar == this.d) {
            this.d = null;
        }
    }

    public int b() {
        if (this.d != null) {
            return this.d.b();
        }
        return 0;
    }

    public synchronized void b(f fVar) {
        this.e.add(fVar);
        Collections.sort(this.e);
        if (!this.c && !this.b) {
            this.b = true;
            f();
        }
    }

    public synchronized void c() {
        if (this.c) {
            com.tapsdk.tapad.internal.download.m.c.c(i, "require pause this queue(remain " + this.e.size() + "), butit has already been paused");
            return;
        }
        this.c = true;
        if (this.d != null) {
            this.d.f();
            this.e.add(0, this.d);
            this.d = null;
        }
    }

    public synchronized void d() {
        if (!this.c) {
            com.tapsdk.tapad.internal.download.m.c.c(i, "require resume this queue(remain " + this.e.size() + "), but it is still running");
            return;
        }
        this.c = false;
        if (!this.e.isEmpty() && !this.b) {
            this.b = true;
            f();
        }
    }

    public synchronized f[] e() {
        f[] fVarArr;
        this.a = true;
        if (this.d != null) {
            this.d.f();
        }
        fVarArr = new f[this.e.size()];
        this.e.toArray(fVarArr);
        this.e.clear();
        return fVarArr;
    }

    void f() {
        g.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVarRemove;
        while (!this.a) {
            synchronized (this) {
                if (!this.e.isEmpty() && !this.c) {
                    fVarRemove = this.e.remove(0);
                }
                this.d = null;
                this.b = false;
                return;
            }
            fVarRemove.b(this.f);
        }
    }
}
