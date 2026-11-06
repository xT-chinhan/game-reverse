package com.bytedance.sdk.component.ch.ms;

import com.bytedance.sdk.component.ch.hi;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements Comparable<ah>, Runnable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final AtomicInteger f1222ms = new AtomicInteger(0);
    public static boolean xr = false;
    public final Runnable ah;
    private c d;
    private long x;
    private boolean ka = true;
    private boolean c = true;
    private final long ab = System.currentTimeMillis();
    private int ny = 0;
    private int ch = 0;

    public ah(Runnable runnable) {
        this.ah = runnable;
    }

    public ah(Runnable runnable, c cVar) {
        this.ah = runnable;
        this.d = cVar;
    }

    public void ms(c cVar) {
        this.d = cVar;
    }

    Runnable ms() {
        return this.ah;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003a  */
    /* JADX WARN: Code duplicated, block: B:14:0x0060  */
    /* JADX WARN: Code duplicated, block: B:26:0x0094 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0095  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00bd  */
    public void run() {
        ny nyVar;
        int i;
        boolean zT;
        long j;
        long j2;
        int i2;
        int i3;
        long jCurrentTimeMillis;
        boolean z;
        com.bytedance.sdk.component.d.ms msVar;
        String name;
        Thread threadCurrentThread = Thread.currentThread();
        int priority = threadCurrentThread.getPriority();
        Runnable runnable = this.ah;
        try {
            if (runnable instanceof ny) {
                nyVar = (ny) runnable;
                int iMin = Math.min(nyVar.ms(), 10);
                try {
                    threadCurrentThread.setPriority(iMin);
                    i = iMin;
                } catch (Throwable th) {
                    sl.xr("BizRunnable", th);
                    i = priority;
                }
                zT = hi.xr.t();
                if (zT) {
                    int activeCount = hi.xr.ny().getActiveCount();
                    int activeCount2 = hi.xr.ch().getActiveCount();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    j2 = jCurrentTimeMillis2;
                    j = (jCurrentTimeMillis2 - this.x) - this.ab;
                    i3 = activeCount2;
                    i2 = activeCount;
                } else {
                    j = 0;
                    j2 = 0;
                    i2 = 0;
                    i3 = 0;
                }
                this.ah.run();
                jCurrentTimeMillis = System.currentTimeMillis() - j2;
                if (!this.ka && this.ny == 2) {
                    f1222ms.decrementAndGet();
                }
                threadCurrentThread.setPriority(priority);
                z = false;
                ah(z);
                if (zT) {
                    if (!ms(j) || jCurrentTimeMillis > hi.xr.y()) {
                        msVar = (com.bytedance.sdk.component.d.ms) AutoService.ms(com.bytedance.sdk.component.d.ms.class);
                        if (msVar == null) {
                            sl.xr("BizRunnable", "IEvent service is null");
                            return;
                        }
                        if (nyVar != null) {
                            name = nyVar.xr();
                        } else {
                            name = this.ah.getClass().getName();
                        }
                        ms(j, jCurrentTimeMillis, name, i, i2, i3, msVar);
                    }
                    return;
                }
                return;
            }
            nyVar = null;
            threadCurrentThread.setPriority(priority);
            z = false;
        } catch (Throwable th2) {
            z = false;
            sl.xr("BizRunnable", th2);
        }
        i = priority;
        zT = hi.xr.t();
        if (zT) {
            int activeCount3 = hi.xr.ny().getActiveCount();
            int activeCount4 = hi.xr.ch().getActiveCount();
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            j2 = jCurrentTimeMillis3;
            j = (jCurrentTimeMillis3 - this.x) - this.ab;
            i3 = activeCount4;
            i2 = activeCount3;
        } else {
            j = 0;
            j2 = 0;
            i2 = 0;
            i3 = 0;
        }
        this.ah.run();
        jCurrentTimeMillis = System.currentTimeMillis() - j2;
        if (!this.ka) {
            f1222ms.decrementAndGet();
        }
        ah(z);
        if (zT) {
            return;
        }
        if (ms(j)) {
        }
        msVar = (com.bytedance.sdk.component.d.ms) AutoService.ms(com.bytedance.sdk.component.d.ms.class);
        if (msVar == null) {
            sl.xr("BizRunnable", "IEvent service is null");
            return;
        }
        if (nyVar != null) {
            name = nyVar.xr();
        } else {
            name = this.ah.getClass().getName();
        }
        ms(j, jCurrentTimeMillis, name, i, i2, i3, msVar);
    }

    public void xr() {
        this.x = System.currentTimeMillis() - this.ab;
    }

    private boolean ms(long j) {
        if (this.ch == 1) {
            return j > hi.xr.h();
        }
        return j > hi.xr.qv();
    }

    private void ms(long j, long j2, String str, int i, int i2, int i3, com.bytedance.sdk.component.d.ms msVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("create_time", this.ab);
            jSONObject.put("is_wrap", this.ah instanceof ah);
            jSONObject.put("is_oom", xr);
            jSONObject.put("pool_wait_time", j);
            jSONObject.put("priority", i);
            jSONObject.put("wait_in_queue", this.x);
            jSONObject.put("pool_type", this.ny);
            jSONObject.put("origin_pool_type", this.ch);
            jSONObject.put("run_cost", j2);
            jSONObject.put("task_name", str);
            jSONObject.put("thread_name", Thread.currentThread().getName());
            hi hiVar = hi.xr;
            jSONObject.put("little_active_count", i2);
            jSONObject.put("big_active_count", i3);
            jSONObject.put("is_crash", hiVar.u());
            jSONObject.put("auto_size", com.bytedance.sdk.component.ch.ab.ka());
            jSONObject.put("pri_task_in_little", f1222ms.get());
            jSONObject.put("core_count", hiVar.x());
            jSONObject.put("max_pool_size", hiVar.hi());
            jSONObject.put("use_little_pool", hiVar.ao());
        } catch (Exception unused) {
        }
        msVar.ms("task_run_cost", jSONObject);
    }

    private void ah(boolean z) {
        c cVar = this.d;
        if (cVar != null) {
            cVar.ms(this, z);
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public int compareTo(ah ahVar) {
        Class<?> cls = this.ah.getClass();
        Class<?> cls2 = ahVar.ah.getClass();
        if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
            return 0;
        }
        Runnable runnable = this.ah;
        if (!(runnable instanceof Comparable)) {
            return 0;
        }
        Runnable runnable2 = ahVar.ah;
        if (runnable2 instanceof Comparable) {
            return ((Comparable) runnable).compareTo(runnable2);
        }
        return 0;
    }

    public void ms(boolean z) {
        this.ka = z;
    }

    public boolean ah() {
        return this.c;
    }

    public void xr(boolean z) {
        this.c = z;
    }

    public void ms(int i) {
        int i2 = this.ny;
        if (i2 == 0) {
            this.ch = i;
        } else {
            this.ch = i2;
        }
        this.ny = i;
    }

    public int d() {
        return this.ny;
    }
}
