package com.bytedance.sdk.component.ah.ms;

/* JADX INFO: loaded from: classes2.dex */
final class ao {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static ub f1005ms;
    static long xr;

    private ao() {
    }

    static ub ms() {
        synchronized (ao.class) {
            ub ubVar = f1005ms;
            if (ubVar != null) {
                f1005ms = ubVar.c;
                ubVar.c = null;
                xr -= 8192;
                return ubVar;
            }
            return new ub();
        }
    }

    static void ms(ub ubVar) {
        if (ubVar.c != null || ubVar.ab != null) {
            throw new IllegalArgumentException();
        }
        if (ubVar.d) {
            return;
        }
        synchronized (ao.class) {
            long j = xr;
            if (j + 8192 > 65536) {
                return;
            }
            xr = j + 8192;
            ubVar.c = f1005ms;
            ubVar.ah = 0;
            ubVar.xr = 0;
            f1005ms = ubVar;
        }
    }
}
