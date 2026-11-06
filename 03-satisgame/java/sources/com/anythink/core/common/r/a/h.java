package com.anythink.core.common.r.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    static volatile Executor b;
    static volatile Executor c;
    static com.anythink.core.common.r.a.a.c a = new d();
    static int d = 4096;

    private h() {
    }

    private static void a(int i) {
        if (i < 2048 || i > 65535) {
            return;
        }
        d = i;
    }

    public static void a(com.anythink.core.common.r.a.a.c cVar) {
        a = cVar;
    }

    public static void a(Executor executor) {
        b = executor;
    }

    public static void b(Executor executor) {
        c = executor;
    }

    static Executor a() {
        if (b == null) {
            synchronized (h.class) {
                if (b == null) {
                    b = Executors.newCachedThreadPool();
                }
            }
        }
        return b;
    }

    static Executor b() {
        if (c != null) {
            return c;
        }
        return a();
    }
}
