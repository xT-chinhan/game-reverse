package com.bytedance.adsdk.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public class zb<T> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static Executor f296ms = com.bytedance.sdk.component.ch.ah.xr(new com.bytedance.sdk.component.ch.ch("ie/LottieTask"));
    private final Set<ch<Throwable>> ah;
    private final Handler d;
    private volatile sl<T> ka;
    private final Set<ch<T>> xr;

    public zb(Callable<sl<T>> callable) {
        this(callable, false);
    }

    zb(Callable<sl<T>> callable, boolean z) {
        this.xr = new LinkedHashSet(1);
        this.ah = new LinkedHashSet(1);
        this.d = new Handler(Looper.getMainLooper());
        this.ka = null;
        if (z) {
            try {
                setResult(callable.call());
                return;
            } catch (Throwable th) {
                setResult(new sl<>(th));
                return;
            }
        }
        f296ms.execute(new ms(callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(sl<T> slVar) {
        if (this.ka != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.ka = slVar;
        ms();
    }

    public synchronized zb<T> ms(ch<T> chVar) {
        sl<T> slVar = this.ka;
        if (slVar != null && slVar.ms() != null) {
            chVar.ms(slVar.ms());
        }
        this.xr.add(chVar);
        return this;
    }

    public synchronized zb<T> xr(ch<T> chVar) {
        this.xr.remove(chVar);
        return this;
    }

    public synchronized zb<T> ah(ch<Throwable> chVar) {
        sl<T> slVar = this.ka;
        if (slVar != null && slVar.xr() != null) {
            chVar.ms(slVar.xr());
        }
        this.ah.add(chVar);
        return this;
    }

    public synchronized zb<T> d(ch<Throwable> chVar) {
        this.ah.remove(chVar);
        return this;
    }

    private void ms() {
        this.d.post(new Runnable() { // from class: com.bytedance.adsdk.lottie.zb.1
            @Override // java.lang.Runnable
            public void run() {
                sl slVar = zb.this.ka;
                if (slVar == null) {
                    return;
                }
                if (slVar.ms() != null) {
                    zb.this.ms(slVar.ms());
                } else {
                    zb.this.ms(slVar.xr());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ms(T t) {
        Iterator it = new ArrayList(this.xr).iterator();
        while (it.hasNext()) {
            ((ch) it.next()).ms(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ms(Throwable th) {
        ArrayList arrayList = new ArrayList(this.ah);
        if (arrayList.isEmpty()) {
            com.bytedance.adsdk.lottie.ka.ka.ms("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ch) it.next()).ms(th);
        }
    }

    private class ms extends FutureTask<sl<T>> {
        ms(Callable<sl<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                zb.this.setResult(get());
            } catch (InterruptedException | ExecutionException e) {
                zb.this.setResult(new sl(e));
            }
        }
    }
}
