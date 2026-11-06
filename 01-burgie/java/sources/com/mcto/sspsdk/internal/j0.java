package com.mcto.sspsdk.internal;

import android.os.SystemClock;
import com.mcto.unionsdk.QiClient;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 implements QiClient.NativeAdListener {
    public final /* synthetic */ p a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ List c;
    public final /* synthetic */ AtomicInteger d;
    public final /* synthetic */ ScheduledExecutorService e;
    public final /* synthetic */ com.mcto.sspsdk.ssp.taskpage.a f;
    public final /* synthetic */ long g;

    public j0(p pVar, AtomicBoolean atomicBoolean, List list, AtomicInteger atomicInteger, ScheduledExecutorService scheduledExecutorService, com.mcto.sspsdk.ssp.taskpage.a aVar, long j) {
        this.a = pVar;
        this.b = atomicBoolean;
        this.c = list;
        this.d = atomicInteger;
        this.e = scheduledExecutorService;
        this.f = aVar;
        this.g = j;
    }

    public final void a(Integer num, String str) {
        if (this.d.decrementAndGet() == 0) {
            this.e.shutdownNow();
            this.f.a(this.c);
        }
        if (num == null) {
            za zaVarD = za.d();
            p pVar = this.a;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.g;
            zaVarD.getClass();
            za.a(pVar, jElapsedRealtime, "", 0, true);
            return;
        }
        za zaVarD2 = za.d();
        p pVar2 = this.a;
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - this.g;
        int iIntValue = num.intValue();
        zaVarD2.getClass();
        za.a(pVar2, jElapsedRealtime2, str, iIntValue, false);
    }

    public final void onError(int i, String str) {
        if (this.b.compareAndSet(false, true)) {
            a(Integer.valueOf(i), str);
        }
    }

    public final void onNativeAdLoad(List list) {
        if (this.b.compareAndSet(false, true)) {
            List list2 = this.c;
            p pVar = this.a;
            list2.add(new oj(pVar));
            a(null, "");
        }
    }
}
