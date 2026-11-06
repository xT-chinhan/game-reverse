package com.mcto.sspsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public final class kd extends Handler {
    public final /* synthetic */ ld a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kd(ld ldVar, Looper looper) {
        super(looper);
        this.a = ldVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        synchronized (this.a) {
            ld ldVar = this.a;
            if (ldVar.d) {
                return;
            }
            long jElapsedRealtime = ldVar.c - SystemClock.elapsedRealtime();
            long j = 0;
            if (jElapsedRealtime <= 0) {
                this.a.b();
            } else {
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                this.a.a(jElapsedRealtime);
                long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                long j2 = this.a.b;
                if (jElapsedRealtime < j2) {
                    long j3 = jElapsedRealtime - jElapsedRealtime3;
                    if (j3 >= 0) {
                        j = j3;
                    }
                } else {
                    long j4 = j2 - jElapsedRealtime3;
                    while (j4 < 0) {
                        j4 += this.a.b;
                    }
                    j = j4;
                }
                sendMessageDelayed(obtainMessage(1), j);
            }
        }
    }
}
