package com.smartdigimkt.n3;

import android.content.Context;
import android.os.Handler;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w {
    public final Handler b;
    public final ScheduledThreadPoolExecutor c;
    public ScheduledFuture e;
    public final ArrayList a = new ArrayList();
    public final AtomicBoolean d = new AtomicBoolean(false);
    public final u f = new u(this);

    public w(Context context) {
        context.getApplicationContext();
        SDKContext.getInstance().a();
        com.smartdigimkt.q3.b bVar = com.smartdigimkt.q3.f.a().a;
        bVar.getClass();
        this.b = bVar.a(com.smartdigimkt.q3.b.a(9));
        this.c = com.smartdigimkt.q3.f.a().b();
    }

    public void a(com.smartdigimkt.f3.e eVar) {
    }

    public final synchronized void a(com.smartdigimkt.f3.e eVar, boolean z) {
        if (SDKContext.getInstance().e) {
            boolean z2 = true;
            if (z) {
                this.a.add(eVar);
                a(eVar);
                a(true);
            } else {
                com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
                if (this.d.compareAndSet(false, true)) {
                    long j = aVarA.l;
                    if (j > 0) {
                        ScheduledFuture scheduledFuture = this.e;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                            this.e = null;
                        }
                        Handler handler = this.b;
                        if (handler != null) {
                            handler.removeCallbacks(this.f);
                        }
                        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.c;
                        if (scheduledThreadPoolExecutor != null) {
                            try {
                                this.e = scheduledThreadPoolExecutor.schedule(new v(this), j, TimeUnit.MILLISECONDS);
                                z2 = false;
                            } catch (Throwable unused) {
                                this.d.set(false);
                            }
                        }
                    }
                    this.d.set(false);
                } else {
                    z2 = false;
                }
                this.a.add(eVar);
                a(eVar);
                a(z2);
            }
        } else {
            this.a.add(eVar);
            a(eVar);
        }
    }

    public abstract void a(ArrayList arrayList);

    public final synchronized void a(boolean z) {
        try {
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.a);
                if (arrayList.size() > 0) {
                    a(arrayList);
                }
                this.a.clear();
            } else {
                com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
                ArrayList arrayList2 = new ArrayList();
                int size = this.a.size();
                int i = aVarA.k;
                if (size >= i) {
                    for (int i2 = i - 1; i2 >= 0; i2--) {
                        arrayList2.add((com.smartdigimkt.f3.e) this.a.get(i2));
                        this.a.remove(i2);
                    }
                    if (arrayList2.size() > 0) {
                        a(arrayList2);
                    }
                }
            }
            if (this.a.isEmpty()) {
                ScheduledFuture scheduledFuture = this.e;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                    this.e = null;
                }
                Handler handler = this.b;
                if (handler != null) {
                    handler.removeCallbacks(this.f);
                }
                this.d.set(false);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
