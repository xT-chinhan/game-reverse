package com.anythink.basead.exoplayer.k;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
final class aa implements c {
    aa() {
    }

    @Override // com.anythink.basead.exoplayer.k.c
    public final long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.anythink.basead.exoplayer.k.c
    public final long b() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.anythink.basead.exoplayer.k.c
    public final void a(long j) {
        SystemClock.sleep(j);
    }

    @Override // com.anythink.basead.exoplayer.k.c
    public final k a(Looper looper, Handler.Callback callback) {
        return new ab(new Handler(looper, callback));
    }
}
