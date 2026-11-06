package com.anythink.core.common.t;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class d implements a {
    private static final String a = "TimeOutHandlerImpl";
    private static volatile d b;
    private final Handler d = com.anythink.core.common.v.b.b.a().a(12);
    private final Handler c = new Handler(Looper.getMainLooper());

    public static a a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    private d() {
    }

    private Handler a(boolean z) {
        return z ? this.c : this.d;
    }

    @Override // com.anythink.core.common.t.a
    public final void a(b bVar) {
        a(bVar, com.tapsdk.tapad.e.a.f, true);
    }

    @Override // com.anythink.core.common.t.a
    public final void a(b bVar, long j, boolean z) {
        Handler handlerA = a(z);
        if (handlerA == null) {
            return;
        }
        handlerA.postDelayed(bVar, j);
    }

    @Override // com.anythink.core.common.t.a
    public final void b(b bVar) {
        Handler handler = this.c;
        if (handler != null && bVar != null) {
            handler.removeCallbacks(bVar);
        }
        Handler handler2 = this.d;
        if (handler2 == null || bVar == null) {
            return;
        }
        handler2.removeCallbacks(bVar);
    }
}
