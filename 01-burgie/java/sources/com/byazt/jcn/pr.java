package com.byazt.jcn;

import android.os.Handler;
import com.byazt.ec.g;
import com.byazt.fr.x;
import com.byazt.xlm.zo;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1972, 37})
public class pr {
    public static final int pr = Runtime.getRuntime().availableProcessors();
    public static final com.byazt.kx.pr.AbstractC0117pr<Executor> hw = new com.byazt.kx.pr.AbstractC0117pr<Executor>() { // from class: com.byazt.jcn.pr.1
        @Override // com.byazt.kx.pr.AbstractC0117pr
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public Executor hw(Object... objArr) {
            return new x((int) (((double) pr.pr) * 0.5d), Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zo("xecutorUtil$1"));
        }
    };
    public static final com.byazt.kx.pr.AbstractC0117pr<ExecutorService> hn = new com.byazt.kx.pr.AbstractC0117pr<ExecutorService>() { // from class: com.byazt.jcn.pr.2
        @Override // com.byazt.kx.pr.AbstractC0117pr
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public ExecutorService hw(Object... objArr) {
            return new x((int) (((double) pr.pr) * 0.5d), Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new zo("xecutorUtil$2"));
        }
    };
    public static final com.byazt.kx.pr.AbstractC0117pr<Handler> x = new com.byazt.kx.pr.AbstractC0117pr<Handler>() { // from class: com.byazt.jcn.pr.3
        @Override // com.byazt.kx.pr.AbstractC0117pr
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public Handler hw(Object... objArr) {
            return new Handler(g.fw());
        }
    };

    private static Executor hn() {
        return hw.hn(new Object[0]);
    }

    private static ExecutorService x() {
        return hn.hn(new Object[0]);
    }

    public static Handler pr() {
        return x.hn(new Object[0]);
    }

    public static void pr(Runnable runnable) {
        hn().execute(runnable);
    }

    public static <T> Future<T> pr(Callable<T> callable) {
        return x().submit(callable);
    }
}
