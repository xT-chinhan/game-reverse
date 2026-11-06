package com.tapsdk.tapad.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes3.dex */
public class LottieTask<T> {
    public static Executor EXECUTOR = Executors.newCachedThreadPool();
    private final Set<LottieListener<Throwable>> failureListeners;
    private final Handler handler;
    private volatile LottieResult<T> result;
    private final Set<LottieListener<T>> successListeners;
    private final FutureTask<LottieResult<T>> task;

    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFailureListeners(Throwable th) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.failureListeners);
            this.successListeners.clear();
            this.failureListeners.clear();
        }
        if (arrayList.isEmpty()) {
            return;
        }
        int i = 0;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((LottieListener) obj).onResult(th);
        }
    }

    private void notifyListeners() {
        this.handler.post(new Runnable() { // from class: com.tapsdk.tapad.lottie.LottieTask.2
            @Override // java.lang.Runnable
            public void run() {
                if (LottieTask.this.result == null || LottieTask.this.task.isCancelled()) {
                    return;
                }
                LottieResult lottieResult = LottieTask.this.result;
                if (lottieResult.getValue() != null) {
                    LottieTask.this.notifySuccessListeners(lottieResult.getValue());
                } else {
                    LottieTask.this.notifyFailureListeners(lottieResult.getException());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySuccessListeners(T t) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.successListeners);
            this.successListeners.clear();
            this.failureListeners.clear();
        }
        int i = 0;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((LottieListener) obj).onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setResult(LottieResult<T> lottieResult) {
        if (this.result != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.result = lottieResult;
        notifyListeners();
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        if (this.result == null) {
            this.failureListeners.add(lottieListener);
            return this;
        }
        if (this.result.getException() != null) {
            lottieListener.onResult(this.result.getException());
        }
        return this;
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> lottieListener) {
        if (this.result == null) {
            this.successListeners.add(lottieListener);
            return this;
        }
        if (this.result.getValue() != null) {
            lottieListener.onResult(this.result.getValue());
        }
        return this;
    }

    public synchronized LottieTask<T> removeFailureListener(LottieListener<Throwable> lottieListener) {
        this.failureListeners.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        this.successListeners.remove(lottieListener);
        return this;
    }

    public LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        FutureTask<LottieResult<T>> futureTask = new FutureTask<LottieResult<T>>(callable) { // from class: com.tapsdk.tapad.lottie.LottieTask.1
            @Override // java.util.concurrent.FutureTask
            public void done() {
                if (isCancelled()) {
                    return;
                }
                try {
                    LottieTask.this.setResult(get());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    LottieTask.this.setResult(new LottieResult((Throwable) e));
                } catch (ExecutionException e2) {
                    LottieTask.this.setResult(new LottieResult((Throwable) e2));
                }
            }
        };
        this.task = futureTask;
        if (z) {
            futureTask.run();
        } else {
            EXECUTOR.execute(futureTask);
        }
    }
}
