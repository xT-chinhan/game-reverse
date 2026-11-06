package com.efs.sdk.memleaksdk.monitor.shark;

/* JADX INFO: loaded from: classes2.dex */
final class s {
    static r a;
    static long b;

    private s() {
    }

    static r a() {
        synchronized (s.class) {
            r rVar = a;
            if (rVar != null) {
                a = rVar.f;
                rVar.f = null;
                b -= 8192;
                return rVar;
            }
            return new r();
        }
    }

    static void a(r rVar) {
        if (rVar.f != null || rVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (rVar.d) {
            return;
        }
        synchronized (s.class) {
            long j = b;
            if (j + 8192 > 65536) {
                return;
            }
            b = j + 8192;
            rVar.f = a;
            rVar.c = 0;
            rVar.b = 0;
            a = rVar;
        }
    }
}
