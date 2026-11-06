package com.byazt.dp;

import android.os.Handler;
import com.byazt.km.sz;
import com.byazt.qit.fs;
import com.byazt.xis.q;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1055, 19})
public class n {
    public static final int n = Runtime.getRuntime().availableProcessors();
    public static final com.byazt.sd.n.AbstractC0332n<Executor> qg = new com.byazt.sd.n.AbstractC0332n<Executor>() { // from class: com.byazt.dp.n.1
        @Override // com.byazt.sd.n.AbstractC0332n
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Executor qg(Object... objArr) {
            return new q((int) (((double) n.n) * 0.5d), Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new fs("xecutorUtil$1"));
        }
    };
    public static final com.byazt.sd.n.AbstractC0332n<ExecutorService> s = new com.byazt.sd.n.AbstractC0332n<ExecutorService>() { // from class: com.byazt.dp.n.2
        @Override // com.byazt.sd.n.AbstractC0332n
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public ExecutorService qg(Object... objArr) {
            return new q((int) (((double) n.n) * 0.5d), Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new fs("xecutorUtil$2"));
        }
    };
    public static final com.byazt.sd.n.AbstractC0332n<Handler> q = new com.byazt.sd.n.AbstractC0332n<Handler>() { // from class: com.byazt.dp.n.3
        @Override // com.byazt.sd.n.AbstractC0332n
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Handler qg(Object... objArr) {
            return new Handler(sz.x());
        }
    };

    private static Executor s() {
        return qg.s(new Object[0]);
    }

    private static ExecutorService q() {
        return s.s(new Object[0]);
    }

    public static Handler n() {
        return q.s(new Object[0]);
    }

    public static void n(Runnable runnable) {
        s().execute(runnable);
    }

    public static <T> Future<T> n(Callable<T> callable) {
        return q().submit(callable);
    }
}
