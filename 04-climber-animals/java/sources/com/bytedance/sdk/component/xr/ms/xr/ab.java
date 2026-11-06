package com.bytedance.sdk.component.xr.ms.xr;

/* JADX INFO: loaded from: classes2.dex */
final class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static c f1625ms;
    static long xr;

    private ab() {
    }

    static c ms() {
        synchronized (ab.class) {
            c cVar = f1625ms;
            if (cVar != null) {
                f1625ms = cVar.c;
                cVar.c = null;
                xr -= 8192;
                return cVar;
            }
            return new c();
        }
    }

    static void ms(c cVar) {
        if (cVar.c != null || cVar.ab != null) {
            throw new IllegalArgumentException();
        }
        if (cVar.d) {
            return;
        }
        synchronized (ab.class) {
            long j = xr;
            if (j + 8192 > 65536) {
                return;
            }
            xr = j + 8192;
            cVar.c = f1625ms;
            cVar.ah = 0;
            cVar.xr = 0;
            f1625ms = cVar;
        }
    }
}
