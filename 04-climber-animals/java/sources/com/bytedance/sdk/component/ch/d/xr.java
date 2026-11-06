package com.bytedance.sdk.component.ch.d;

import android.os.AsyncTask;
import com.bytedance.sdk.component.ch.ch;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static Executor f1215ms = new d(0, 20, 3, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ch("PAsyncTask"));

    public AsyncTask<Params, Progress, Result> ms(Params... paramsArr) {
        return executeOnExecutor(f1215ms, paramsArr);
    }
}
