package com.bytedance.sdk.component.ah.xr;

import android.os.Bundle;
import android.text.TextUtils;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class ch {
    static final /* synthetic */ boolean ah = true;
    private static final Executor d = new com.bytedance.sdk.component.ch.d.d(0, Integer.MAX_VALUE, 20, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.ah.xr.ms.ah.ms("OkHttp ConnectionPool", true));
    private List<String> ab;
    private long c;
    private final Deque<com.bytedance.sdk.component.ah.xr.ms.xr.ah> ch;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final com.bytedance.sdk.component.ah.xr.ms.xr.d f1035ms;
    private final Runnable ny;
    private long x;
    boolean xr;

    public ch() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public ch(int i, long j, TimeUnit timeUnit) {
        this.ny = new Runnable() { // from class: com.bytedance.sdk.component.ah.xr.ch.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long jMs = ch.this.ms(System.nanoTime());
                    if (jMs == -1) {
                        return;
                    }
                    if (jMs > 0) {
                        long j2 = jMs / 1000000;
                        long j3 = jMs - (1000000 * j2);
                        synchronized (ch.this) {
                            try {
                                ch.this.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.ch = new ArrayDeque();
        this.f1035ms = new com.bytedance.sdk.component.ah.xr.ms.xr.d();
        this.ka = i;
        this.c = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: ".concat(String.valueOf(j)));
        }
    }

    public void ms(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.containsKey("max_idle_cnt")) {
                    int i = bundle.getInt("max_idle_cnt");
                    if (i <= 5) {
                        i = this.ka;
                    }
                    this.ka = i;
                }
                if (bundle.containsKey("max_idle_time")) {
                    long j = bundle.getLong("max_idle_time");
                    this.c = j > 5 ? TimeUnit.MINUTES.toNanos(j) : this.c;
                }
                if (bundle.containsKey("white_hosts") && bundle.containsKey("white_extra_idle_time")) {
                    this.ab = bundle.getStringArrayList("white_hosts");
                    long j2 = bundle.getLong("white_extra_idle_time");
                    this.x = j2 > 0 ? TimeUnit.MINUTES.toNanos(j2) : 0L;
                }
            } catch (Throwable unused) {
            }
        }
    }

    com.bytedance.sdk.component.ah.xr.ms.xr.ah ms(ms msVar, com.bytedance.sdk.component.ah.xr.ms.xr.ab abVar, of ofVar) {
        if (!ah && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar : this.ch) {
            if (ahVar.ms(msVar, ofVar)) {
                if (abVar != null) {
                    abVar.ms(ahVar, true);
                }
                return ahVar;
            }
        }
        return null;
    }

    Socket ms(ms msVar, com.bytedance.sdk.component.ah.xr.ms.xr.ab abVar) {
        if (!ah && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar : this.ch) {
            if (ahVar.ms(msVar, null) && ahVar.ka() && ahVar != abVar.xr()) {
                return abVar.ms(ahVar);
            }
        }
        return null;
    }

    void ms(com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar) {
        if (!ah && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.xr) {
            this.xr = true;
            d.execute(this.ny);
        }
        this.ch.add(ahVar);
    }

    boolean xr(com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar) {
        if (!ah && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (ahVar.f1125ms || this.ka == 0) {
            this.ch.remove(ahVar);
            return true;
        }
        notifyAll();
        return false;
    }

    long ms(long j) {
        try {
            synchronized (this) {
                com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar = null;
                long j2 = Long.MIN_VALUE;
                int i = 0;
                int i2 = 0;
                for (com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar2 : this.ch) {
                    if (ms(ahVar2, j) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j3 = j - ahVar2.ka;
                        com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar3 = ahVar;
                        if (this.x > 0 && ah(ahVar2)) {
                            j3 -= this.x;
                        }
                        if (j3 > j2) {
                            ahVar = ahVar2;
                            j2 = j3;
                        } else {
                            ahVar = ahVar3;
                        }
                    }
                }
                com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar4 = ahVar;
                long j4 = this.c;
                if (j2 < j4 && i <= this.ka) {
                    if (i > 0) {
                        return j4 - j2;
                    }
                    if (i2 > 0) {
                        return j4;
                    }
                    this.xr = false;
                    com.bytedance.sdk.component.utils.sl.ms("ConnectionPool", "cleanup: ");
                    return -1L;
                }
                this.ch.remove(ahVar4);
                com.bytedance.sdk.component.ah.xr.ms.ah.ms(ahVar4.ah());
                return 0L;
            }
        } catch (OutOfMemoryError unused) {
            return this.c;
        }
    }

    private int ms(com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar, long j) {
        List<Reference<com.bytedance.sdk.component.ah.xr.ms.xr.ab>> list = ahVar.d;
        int i = 0;
        while (i < list.size()) {
            Reference<com.bytedance.sdk.component.ah.xr.ms.xr.ab> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().ms("A connection to " + ahVar.ms().ms().ms() + " was leaked. Did you forget to close a response body?", ((com.bytedance.sdk.component.ah.xr.ms.xr.ab.ms) reference).f1124ms);
                list.remove(i);
                ahVar.f1125ms = true;
                if (list.isEmpty()) {
                    ahVar.ka = j - this.c;
                    return 0;
                }
            }
        }
        return list.size();
    }

    private boolean ah(com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar) {
        try {
            List<String> list = this.ab;
            if (list != null && !list.isEmpty() && ahVar.ms() != null && ahVar.ms().ms() != null && ahVar.ms().ms().ms() != null && ahVar.ms().ms().ms().ab() != null) {
                String strAb = ahVar.ms().ms().ms().ab();
                if (!TextUtils.isEmpty(strAb) && this.ab.contains(strAb)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
