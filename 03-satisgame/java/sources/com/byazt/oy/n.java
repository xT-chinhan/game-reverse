package com.byazt.oy;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2147, 19})
public class n {
    public static volatile n n;
    public static volatile ScheduledExecutorService q;
    public static volatile ThreadPoolExecutor qg;
    public static volatile ThreadPoolExecutor s;
    public static final ConcurrentHashMap<String, s> l = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, s> w = new ConcurrentHashMap<>();

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    private n() {
        qg = l.n();
        s = l.qg();
        q = l.s();
    }

    public void n(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("param is not be null");
        }
        if (qg != null) {
            qg.execute(sVar);
        }
    }
}
