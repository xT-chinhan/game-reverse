package com.bytedance.sdk.component.x.xr.xr.ah;

import android.os.Handler;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private xr ah;
    private final com.bytedance.sdk.component.x.xr.xr.xr c;
    private final com.bytedance.sdk.component.x.ms.ka ka;
    private volatile long d = 0;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final AtomicInteger f1579ms = new AtomicInteger(0);
    public final AtomicInteger xr = new AtomicInteger(0);

    public ka(com.bytedance.sdk.component.x.ms.ka kaVar, com.bytedance.sdk.component.x.xr.xr.xr xrVar) {
        this.ka = kaVar;
        this.c = xrVar;
    }

    public void ms(List<com.bytedance.sdk.component.x.ms.xr> list, boolean z, String str, int i, Object obj, com.bytedance.sdk.component.x.xr.ms.xr xrVar) {
        this.ah = this.c.ka();
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.x.xr.ah.ms.ms(list, i, str, this.ka);
        if (this.ka.ch() != null) {
            ms(list, z, jCurrentTimeMillis, obj, i);
        } else {
            com.bytedance.sdk.component.x.xr.ah.ms.ms(list, str, xrVar);
            ms(list, z, jCurrentTimeMillis, i, obj);
        }
    }

    private void ms(final List<com.bytedance.sdk.component.x.ms.xr> list, final boolean z, final long j, final int i, final Object obj) {
        com.bytedance.sdk.component.x.ms.d dVarD = this.ka.d();
        if (dVarD != null) {
            Executor executorAb = dVarD.ab();
            if (list.get(0).ka() == 1) {
                executorAb = dVarD.c();
            }
            Executor executor = executorAb;
            if (executor == null) {
                return;
            }
            this.xr.incrementAndGet();
            executor.execute(new com.bytedance.sdk.component.x.xr.ka.xr("csj_log_upload") { // from class: com.bytedance.sdk.component.x.xr.xr.ah.ka.1
                @Override // java.lang.Runnable
                public void run() {
                    ka.this.xr(list, z, j, i, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(List<com.bytedance.sdk.component.x.ms.xr> list, boolean z, long j, int i, Object obj) {
        ms msVarMs;
        try {
            com.bytedance.sdk.component.x.ms.xr xrVar = list.get(0);
            com.bytedance.sdk.component.x.xr.ah.xr.ms(com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.t(), 1, this.ka);
            if (xrVar.d() == 0) {
                msVarMs = com.bytedance.sdk.component.x.xr.xr.c().ms(list);
                ms(msVarMs, list);
                if (msVarMs != null) {
                    com.bytedance.sdk.component.x.xr.ah.ms.ms(list, msVarMs.d, this.ka);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<com.bytedance.sdk.component.x.ms.xr> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().ab());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e) {
                    com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "json exception:" + e.getMessage(), this.ka);
                }
                msVarMs = com.bytedance.sdk.component.x.xr.xr.c().ms(jSONObject);
            }
            ms msVar = msVarMs;
            this.xr.decrementAndGet();
            ms(z, msVar, list, j, obj, i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "inner exception:" + th.getMessage(), this.ka);
            com.bytedance.sdk.component.x.xr.ah.xr.ms(com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.ah(), 1, this.ka);
            this.xr.decrementAndGet();
        }
    }

    private void ms(ms msVar, List<com.bytedance.sdk.component.x.ms.xr> list) {
        if (msVar == null || !msVar.f1582ms) {
            return;
        }
        List<com.bytedance.sdk.component.x.ms.ah> listMs = com.bytedance.sdk.component.x.xr.ms.ms();
        if (list == null || listMs == null || listMs.size() == 0) {
            return;
        }
        for (com.bytedance.sdk.component.x.ms.xr xrVar : list) {
            if (xrVar.ka() == 1) {
                String strMs = com.bytedance.sdk.component.x.xr.ah.ms.ms(xrVar, this.ka);
                String strC = com.bytedance.sdk.component.x.xr.ah.ms.c(xrVar, this.ka);
                for (com.bytedance.sdk.component.x.ms.ah ahVar : listMs) {
                    if (ahVar != null) {
                        ahVar.ms(strMs, strC);
                    }
                }
            }
        }
    }

    private void ms(List<com.bytedance.sdk.component.x.ms.xr> list, final boolean z, final long j, final Object obj, final int i) {
        this.xr.incrementAndGet();
        com.bytedance.sdk.component.x.xr.ah.xr.ms(com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.t(), 1, this.ka);
        try {
            new Object() { // from class: com.bytedance.sdk.component.x.xr.xr.ah.ka.2
            };
        } catch (Exception e) {
            com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "outer exception：" + e.getMessage(), this.ka);
            com.bytedance.sdk.component.x.xr.ah.xr.ms(com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.ah(), 1, this.ka);
            this.xr.decrementAndGet();
        }
    }

    private void ms(boolean z, ms msVar, List<com.bytedance.sdk.component.x.ms.xr> list, long j, Object obj, int i) {
        if (z) {
            return;
        }
        if (msVar != null) {
            int i2 = msVar.xr;
            if (msVar.ka) {
                i2 = -1;
            } else if (i2 < 0) {
                i2 = -2;
            }
            if (i2 == 510 || i2 == 511) {
                i2 = -2;
            }
            int i3 = (msVar.f1582ms || ((i2 < 500 || i2 >= 509) && i2 <= 513)) ? i2 : -2;
            if (list != null) {
                list.size();
                this.xr.get();
            }
            ms(i3, list, j, obj, i, msVar);
            return;
        }
        ms(-1, list, j, obj, i, (ms) null);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0068 A[Catch: all -> 0x00c7, TryCatch #0 {all -> 0x00c7, blocks: (B:7:0x0009, B:9:0x0025, B:35:0x00c0, B:36:0x00c3, B:20:0x003c, B:22:0x0044, B:24:0x0051, B:26:0x005e, B:27:0x0068, B:29:0x0070, B:30:0x007f, B:32:0x008b, B:33:0x00b5, B:38:0x00c5), top: B:43:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0070 A[Catch: all -> 0x00c7, TryCatch #0 {all -> 0x00c7, blocks: (B:7:0x0009, B:9:0x0025, B:35:0x00c0, B:36:0x00c3, B:20:0x003c, B:22:0x0044, B:24:0x0051, B:26:0x005e, B:27:0x0068, B:29:0x0070, B:30:0x007f, B:32:0x008b, B:33:0x00b5, B:38:0x00c5), top: B:43:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x007f A[Catch: all -> 0x00c7, TryCatch #0 {all -> 0x00c7, blocks: (B:7:0x0009, B:9:0x0025, B:35:0x00c0, B:36:0x00c3, B:20:0x003c, B:22:0x0044, B:24:0x0051, B:26:0x005e, B:27:0x0068, B:29:0x0070, B:30:0x007f, B:32:0x008b, B:33:0x00b5, B:38:0x00c5), top: B:43:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x008b A[Catch: all -> 0x00c7, TryCatch #0 {all -> 0x00c7, blocks: (B:7:0x0009, B:9:0x0025, B:35:0x00c0, B:36:0x00c3, B:20:0x003c, B:22:0x0044, B:24:0x0051, B:26:0x005e, B:27:0x0068, B:29:0x0070, B:30:0x007f, B:32:0x008b, B:33:0x00b5, B:38:0x00c5), top: B:43:0x0003 }] */
    private void ms(int i, List<com.bytedance.sdk.component.x.ms.xr> list, long j, Object obj, int i2, ms msVar) {
        xr xrVar = this.ah;
        synchronized (obj) {
            try {
                if (list == null || xrVar == null) {
                    return;
                }
                Handler handlerXr = xrVar.xr();
                com.bytedance.sdk.component.x.xr.ah.ms.ms(i, list, j, this.ka, msVar);
                xrVar.ms().ms(i, list, i2);
                com.bytedance.sdk.component.x.ms.d dVarD = this.ka.d();
                if (dVarD != null) {
                    dVarD.u();
                }
                if (i == -2) {
                    if (dVarD != null) {
                        com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "net is available:" + dVarD.ms(this.ka.getContext()) + " code:" + i, this.ka);
                    }
                    this.c.ms(2);
                    ms(handlerXr, list, xrVar);
                } else if (i == -1) {
                    if (this.c.d()) {
                        com.bytedance.sdk.component.x.xr.ah.ah.ah("_flush", "send reset error", this.ka);
                        xrVar.ms(72, "handle_result");
                    } else {
                        this.c.ms(0);
                        ms(handlerXr, list, xrVar);
                    }
                } else if (i == 0) {
                    if (dVarD != null) {
                        com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "net is available:" + dVarD.ms(this.ka.getContext()) + " code:" + i, this.ka);
                    }
                    this.c.ms(2);
                    ms(handlerXr, list, xrVar);
                } else if (i == 200) {
                    if (this.c.d()) {
                        com.bytedance.sdk.component.x.xr.ah.ah.ah("_flush", "send reset error", this.ka);
                        xrVar.ms(72, "handle_result");
                    } else {
                        this.c.ms(0);
                        ms(handlerXr, list, xrVar);
                    }
                } else if (i == 509 && com.bytedance.sdk.component.x.xr.ah.ms.xr(list, this.ka)) {
                    this.c.ms(1);
                    if (!handlerXr.hasMessages(3) && System.currentTimeMillis() - this.d >= 15000) {
                        this.d = System.currentTimeMillis();
                        ms(3, 15000L, handlerXr);
                    }
                }
                if (i2 == 72) {
                    obj.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void ms(Handler handler, List<com.bytedance.sdk.component.x.ms.xr> list, xr xrVar) {
        boolean zD = xrVar.d();
        boolean zXr = com.bytedance.sdk.component.x.xr.ah.ms.xr(list, this.ka);
        if (zD && zXr) {
            if (handler.hasMessages(3)) {
                handler.removeMessages(3);
            }
            this.f1579ms.set(0);
            this.d = 0L;
            com.bytedance.sdk.component.x.xr.ah.ah.ah("_flush", "send reset busy", this.ka);
            com.bytedance.sdk.component.x.xr.ah.xr.ms(com.bytedance.sdk.component.x.xr.xr.xr.f1585ms.d(), 1, this.ka);
            xrVar.ms(72, "handle_result");
        }
    }

    public void ms(int i, long j, Handler handler) {
        if (handler == null) {
            com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "mHandler == null", this.ka);
            return;
        }
        if (i == 3) {
            if (handler.hasMessages(i)) {
                handler.removeMessages(i);
            }
            int iIncrementAndGet = this.f1579ms.incrementAndGet();
            long j2 = ((long) (((iIncrementAndGet - 1) % 4) + 1)) * j;
            com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "sendBusyMsg:" + i + "  retryCount:" + iIncrementAndGet + " delayTime:" + (j2 / 1000), this.ka);
            handler.sendEmptyMessageDelayed(i, j2);
            return;
        }
        com.bytedance.sdk.component.x.xr.ah.ah.ah("_error", "sendBusyMsg error state", this.ka);
    }
}
