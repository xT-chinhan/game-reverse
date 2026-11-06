package com.bytedance.sdk.component.ah.xr;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class u {
    private Runnable ah;
    private String d;
    private ExecutorService ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f1141ms = 64;
    private int xr = 5;
    private final Deque<w.ms> c = new ArrayDeque();
    private final Deque<w.ms> ab = new ArrayDeque();
    private final Deque<w> x = new ArrayDeque();

    public u() {
    }

    public u(String str) {
        this.d = str;
    }

    public synchronized ExecutorService ms() {
        if (this.ka == null) {
            String str = this.d;
            this.ka = new com.bytedance.sdk.component.ch.d.d(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.ah.xr.ms.ah.ms((str == null || str.length() == 0) ? TKDownloadReason.KSAD_TK_NET : this.d, false));
        }
        return this.ka;
    }

    public synchronized void ms(int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
            }
            this.f1141ms = i;
            ah();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void xr(int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
            }
            this.xr = i;
            ah();
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized void ms(w.ms msVar) {
        try {
            if (this.ab.size() < this.f1141ms && ah(msVar) < this.xr) {
                this.ab.add(msVar);
                if (msVar != null) {
                    msVar.xr();
                }
                ms().execute(msVar);
                return;
            }
            this.c.add(msVar);
        } catch (Throwable unused) {
        }
    }

    private void ah() {
        if (this.ab.size() < this.f1141ms && !this.c.isEmpty()) {
            Iterator<w.ms> it = this.c.iterator();
            while (it.hasNext()) {
                w.ms next = it.next();
                if (ah(next) < this.xr) {
                    it.remove();
                    this.ab.add(next);
                    if (next != null) {
                        next.xr();
                    }
                    ms().execute(next);
                }
                if (this.ab.size() >= this.f1141ms) {
                    return;
                }
            }
        }
    }

    private int ah(w.ms msVar) {
        Iterator<w.ms> it = this.ab.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().ms().equals(msVar.ms())) {
                i++;
            }
        }
        return i;
    }

    synchronized void ms(w wVar) {
        this.x.add(wVar);
    }

    void xr(w.ms msVar) {
        ms(this.ab, msVar, true);
    }

    void xr(w wVar) {
        ms(this.x, wVar, false);
    }

    private <T> void ms(Deque<T> deque, T t, boolean z) {
        int iXr;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                ah();
            }
            iXr = xr();
            runnable = this.ah;
        }
        if (iXr != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }

    public synchronized int xr() {
        return this.ab.size() + this.x.size();
    }
}
