package com.byazt.oy;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2147, 18})
public class l {
    public static final PriorityBlockingQueue<Runnable> l;
    public static final int n;
    public static final PriorityBlockingQueue<Runnable> q;
    public static final int qg;
    public static final int s;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        n = iAvailableProcessors;
        qg = (iAvailableProcessors / 2) + 1 < 4 ? 4 : (iAvailableProcessors / 2) + 1;
        s = (iAvailableProcessors / 2) + 1 >= 4 ? (iAvailableProcessors / 2) + 1 : 4;
        q = new PriorityBlockingQueue<>();
        l = new PriorityBlockingQueue<>();
    }

    public static ThreadPoolExecutor n() {
        int i = qg;
        return new com.byazt.xis.q(i, i, 1L, TimeUnit.SECONDS, q, new q(qg.n.NORMAL, "tt-api-thread-"));
    }

    public static ThreadPoolExecutor qg() {
        int i = s;
        return new com.byazt.xis.q(i, i, 1L, TimeUnit.SECONDS, l, new q(qg.n.NORMAL, "tt-default-thread-"));
    }

    public static ScheduledExecutorService s() {
        return com.byazt.qit.qg.s(new q(qg.n.LOW, "tt-delay-thread-"));
    }
}
