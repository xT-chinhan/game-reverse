package com.byazt.fr;

import android.os.AsyncTask;
import com.byazt.xlm.zo;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 443, 13})
public abstract class hw<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public static final Executor pr = new x(0, 20, 3, TimeUnit.MILLISECONDS, new SynchronousQueue(), new zo("PAsyncTask"));

    public AsyncTask<Params, Progress, Result> pr(Params... paramsArr) {
        return executeOnExecutor(pr, paramsArr);
    }
}
