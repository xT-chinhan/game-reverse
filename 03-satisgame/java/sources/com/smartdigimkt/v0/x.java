package com.smartdigimkt.v0;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class x {
    public final m b;
    public final CopyOnWriteArrayList c;
    public final int a = 0;
    public final long d = 0;

    public x(CopyOnWriteArrayList copyOnWriteArrayList, m mVar) {
        this.c = copyOnWriteArrayList;
        this.b = mVar;
    }

    public final long a(long j) {
        long jB = com.smartdigimkt.i0.b.b(j);
        if (jB == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.d + jB;
    }

    public static void a(Handler handler, Runnable runnable) {
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }
}
