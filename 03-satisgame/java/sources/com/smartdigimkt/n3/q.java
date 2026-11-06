package com.smartdigimkt.n3;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements Runnable {
    public final /* synthetic */ r a;

    public q(r rVar) {
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        try {
            Context context = this.a.f;
            if (context == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - com.smartdigimkt.r4.y.b(context, "sdm_adx_rp_sdk", "LOG_SEND_TIME");
            r rVar = this.a;
            if (jCurrentTimeMillis > rVar.c || ((atomicInteger2 = rVar.h) != null && atomicInteger2.get() >= this.a.a)) {
                r rVar2 = this.a;
                if (rVar2.i || (atomicInteger = rVar2.h) == null || atomicInteger.get() <= 0) {
                    return;
                }
                this.a.b();
            }
        } catch (Throwable unused) {
        }
    }
}
