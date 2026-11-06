package com.byazt.xis;

import android.os.AsyncTask;
import com.byazt.qit.fs;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 589, 26})
public abstract class qg<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public static final Executor n = new q(0, 20, 3, TimeUnit.MILLISECONDS, new SynchronousQueue(), new fs("PAsyncTask"));

    public AsyncTask<Params, Progress, Result> n(Params... paramsArr) {
        return executeOnExecutor(n, paramsArr);
    }
}
