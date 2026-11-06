package com.bytedance.sdk.component.x.xr.xr;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.x.ms.d;
import com.bytedance.sdk.component.x.ms.ka;
import com.bytedance.sdk.component.x.ms.ny;
import com.bytedance.sdk.component.x.xr.ah.ah;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ny {
    private ka ab;
    private volatile Handler c;
    private volatile com.bytedance.sdk.component.x.xr.xr.ah.xr ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final com.bytedance.sdk.component.x.xr.xr.ms.ms f1585ms = new com.bytedance.sdk.component.x.xr.xr.ms.ms();
    public static final long ah = System.currentTimeMillis();
    public static long d = 0;
    public volatile int xr = 0;
    private final Comparator<com.bytedance.sdk.component.x.ms.xr> x = new Comparator<com.bytedance.sdk.component.x.ms.xr>() { // from class: com.bytedance.sdk.component.x.xr.xr.xr.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.sdk.component.x.ms.xr xrVar, com.bytedance.sdk.component.x.ms.xr xrVar2) {
            return xr.this.ms(xrVar, xrVar2);
        }
    };

    public xr(ka kaVar) {
        this.ab = kaVar;
    }

    public void ms(int i) {
        this.xr = i;
    }

    public boolean ah() {
        return this.xr == 1;
    }

    public boolean d() {
        return this.xr == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ms(com.bytedance.sdk.component.x.ms.xr xrVar, com.bytedance.sdk.component.x.ms.xr xrVar2) {
        long jMs;
        long jXr;
        long jXr2;
        long jMs2;
        if (xrVar == null) {
            return xrVar2 == null ? 0 : -1;
        }
        if (xrVar2 == null) {
            return 1;
        }
        if (xrVar.ka() == xrVar2.ka()) {
            if (xrVar.ms() != null) {
                jMs = xrVar.ms().ms();
                jXr = xrVar.ms().xr();
            } else {
                jMs = 0;
                jXr = 0;
            }
            if (xrVar2.ms() != null) {
                jMs2 = xrVar2.ms().ms();
                jXr2 = xrVar2.ms().xr();
            } else {
                jXr2 = 0;
                jMs2 = 0;
            }
            if (jMs == 0 || jMs2 == 0) {
                return 0;
            }
            long j = jMs - jMs2;
            if (Math.abs(j) > 2147483647L) {
                return 0;
            }
            if (j != 0) {
                return (int) j;
            }
            if (jXr == 0 || jXr2 == 0) {
                return 0;
            }
            return (int) (jXr - jXr2);
        }
        return xrVar.ka() - xrVar2.ka();
    }

    @Override // com.bytedance.sdk.component.x.ms.ny
    public void ms() {
        ka kaVar = this.ab;
        if (kaVar == null) {
            return;
        }
        ms(kaVar.ka());
        xr();
    }

    public com.bytedance.sdk.component.x.xr.xr.ah.xr ka() {
        return this.ka;
    }

    public void ms(Handler handler) {
        this.c = handler;
    }

    public boolean ms(String str) {
        try {
            if (this.ka != null || com.bytedance.sdk.component.x.xr.ms.ms(str) || this.ab == null) {
                return false;
            }
            synchronized (this) {
                if (this.ka != null) {
                    return false;
                }
                this.ka = new com.bytedance.sdk.component.x.xr.xr.ah.xr(this.ab, this);
                this.ka.c();
                return true;
            }
        } catch (Throwable th) {
            ah.ah(th.getMessage(), this.ab);
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.x.ms.ny
    public void ms(com.bytedance.sdk.component.x.ms.xr xrVar) {
        ka kaVar;
        if (xrVar == null || (kaVar = this.ab) == null) {
            ah.d("error : log config is null", this.ab);
            return;
        }
        String strKa = kaVar.ka();
        xrVar.ms(System.currentTimeMillis());
        ms(strKa);
        d dVarD = this.ab.d();
        com.bytedance.sdk.component.x.xr.xr.ah.xr xrVar2 = this.ka;
        if (xrVar2 != null) {
            ms(dVarD, xrVar);
            xrVar2.ms(xrVar, xrVar.ka() == 4);
        }
    }

    private void ms(final d dVar, com.bytedance.sdk.component.x.ms.xr xrVar) {
        if (dVar != null) {
            try {
                if (dVar.ny()) {
                    final long jXr = (xrVar == null || xrVar.ms() == null) ? 0L : xrVar.ms().xr();
                    if (jXr == 1) {
                        d = System.currentTimeMillis();
                    }
                    AtomicLong atomicLongH = f1585ms.h();
                    com.bytedance.sdk.component.x.xr.ah.xr.ms(atomicLongH, 1, this.ab);
                    if (atomicLongH.get() == 200) {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            Executor executorC = dVar.c();
                            if (executorC == null) {
                                executorC = dVar.ab();
                            }
                            if (executorC != null) {
                                executorC.execute(new com.bytedance.sdk.component.x.xr.ka.xr("report") { // from class: com.bytedance.sdk.component.x.xr.xr.xr.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        xr.this.ms(dVar, jXr);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        ms(dVar, jXr);
                    }
                }
            } catch (Exception e) {
                sl.ms(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(d dVar, long j) {
        com.bytedance.sdk.component.x.xr.xr.ah.xr xrVar = this.ka;
        if (dVar == null || xrVar == null) {
            return;
        }
        com.bytedance.sdk.component.x.xr.xr.ms.ms msVar = f1585ms;
        xrVar.ms(dVar.ms(msVar.ms(j, this.ab)), true);
        msVar.c();
    }

    @Override // com.bytedance.sdk.component.x.ms.ny
    public void xr() {
        ka kaVar = this.ab;
        if (kaVar == null || kaVar.d() == null) {
            ah.xr("discard flush config is null", kaVar);
            return;
        }
        ah.xr("flushMemoryAndDB", kaVar);
        d dVarD = kaVar.d();
        final com.bytedance.sdk.component.x.xr.xr.ah.xr xrVar = this.ka;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (xrVar != null) {
                xrVar.ms(72, "start_child2");
                return;
            }
            return;
        }
        Executor executorC = dVarD.c();
        if (executorC == null) {
            executorC = dVarD.ab();
        }
        if (executorC == null) {
            ah.xr("discard flush executor is null", kaVar);
        } else {
            executorC.execute(new com.bytedance.sdk.component.x.xr.ka.xr("flush") { // from class: com.bytedance.sdk.component.x.xr.xr.xr.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.x.xr.xr.ah.xr xrVar2 = xrVar;
                    if (xrVar2 != null) {
                        xrVar2.ms(72, "start_child1");
                    }
                }
            });
        }
    }
}
