package com.anythink.core.common.n.c;

/* JADX INFO: loaded from: classes.dex */
final class t {
    static final long a = 65536;
    static s b;
    static long c;

    private t() {
    }

    static s a() {
        synchronized (t.class) {
            s sVar = b;
            if (sVar != null) {
                b = sVar.h;
                sVar.h = null;
                c -= 8192;
                return sVar;
            }
            return new s();
        }
    }

    static void a(s sVar) {
        if (sVar.h != null || sVar.i != null) {
            throw new IllegalArgumentException();
        }
        if (sVar.f) {
            return;
        }
        synchronized (t.class) {
            long j = c;
            if (j + 8192 > a) {
                return;
            }
            c = j + 8192;
            sVar.h = b;
            sVar.e = 0;
            sVar.d = 0;
            b = sVar;
        }
    }
}
