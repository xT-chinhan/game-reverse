package com.smartdigimkt.m3;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements a {
    public final ScheduledThreadPoolExecutor b = com.smartdigimkt.q3.f.a().b();
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public final Handler a = new Handler(Looper.getMainLooper());

    @Override // com.smartdigimkt.m3.a
    public final void a(b bVar, long j) {
        if (bVar == null) {
            return;
        }
        if (bVar.a()) {
            this.a.postDelayed(bVar, j);
            return;
        }
        try {
            this.c.put(bVar, this.b.schedule(new e(this, bVar), j, TimeUnit.MILLISECONDS));
        } catch (Throwable unused) {
        }
    }

    @Override // com.smartdigimkt.m3.a
    public final void a(b bVar) {
        Future future;
        try {
            if (this.a != null && bVar != null && bVar.a()) {
                this.a.removeCallbacks(bVar);
            }
            if (bVar == null || bVar.a() || (future = (Future) this.c.remove(bVar)) == null) {
                return;
            }
            future.cancel(true);
        } catch (Throwable unused) {
        }
    }
}
