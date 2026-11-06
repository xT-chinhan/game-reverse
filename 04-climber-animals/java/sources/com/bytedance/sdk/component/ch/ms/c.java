package com.bytedance.sdk.component.ch.ms;

import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.ch.hi;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.bytedance.sdk.component.ch.xr {
    private volatile RejectedExecutionHandler ab;
    private final ReentrantLock ah;
    private volatile ThreadFactory c;
    private final ThreadPoolExecutor ch;
    private final Condition d;
    private boolean hi;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final AtomicInteger f1223ms = new AtomicInteger(ms(-536870912, 0));
    private volatile int ny;
    private volatile int sl;
    private volatile long x;
    private final BlockingQueue<Runnable> xr;
    private ThreadPoolExecutor zb;

    private static boolean ah(int i) {
        return i < 0;
    }

    private static boolean ah(int i, int i2) {
        return i >= i2;
    }

    private static int ms(int i) {
        return i & (-536870912);
    }

    private static int ms(int i, int i2) {
        return i | i2;
    }

    private static int xr(int i) {
        return i & 536870911;
    }

    private static boolean xr(int i, int i2) {
        return i < i2;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public long getCompletedTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public int getLargestPoolSize() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public long getTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public int prestartAllCoreThreads() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public boolean prestartCoreThread() {
        return false;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public void setCorePoolSize(int i) {
    }

    private boolean d(int i) {
        return this.f1223ms.compareAndSet(i, i + 1);
    }

    private boolean ka(int i) {
        return this.f1223ms.compareAndSet(i, i - 1);
    }

    private void ah() {
        while (!ka(this.f1223ms.get())) {
        }
    }

    private void c(int i) {
        int i2;
        do {
            i2 = this.f1223ms.get();
            if (ah(i2, i)) {
                return;
            }
        } while (!this.f1223ms.compareAndSet(i2, ms(i, xr(i2))));
    }

    public ThreadPoolExecutor ms() {
        if (this.zb == null) {
            this.zb = hi.xr.ch();
        }
        return this.zb;
    }

    final void xr() {
        while (true) {
            int i = this.f1223ms.get();
            if (ah(i) || ah(i, 1073741824)) {
                return;
            }
            if ((ms(i) == 0 && !this.xr.isEmpty()) || xr(i) != 0) {
                return;
            }
            ReentrantLock reentrantLock = this.ah;
            reentrantLock.lock();
            try {
                if (this.f1223ms.compareAndSet(i, ms(1073741824, 0))) {
                    this.f1223ms.set(ms(1610612736, 0));
                    this.d.signalAll();
                    reentrantLock.unlock();
                    return;
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    final void ms(Runnable runnable) {
        this.ab.rejectedExecution(runnable, this.ch);
    }

    private List<Runnable> d() {
        BlockingQueue<Runnable> blockingQueue = this.xr;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            for (Runnable runnable : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                if (blockingQueue.remove(runnable)) {
                    if (runnable instanceof ah) {
                        arrayList.add(((ah) runnable).ah);
                    } else {
                        arrayList.add(runnable);
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean xr(Runnable runnable, boolean z) {
        while (true) {
            int i = this.f1223ms.get();
            int iMs = ms(i);
            boolean z2 = false;
            if (iMs >= 0 && (iMs != 0 || runnable != null || this.xr.isEmpty())) {
                break;
            }
            do {
                int iXr = xr(i);
                if (iXr < 536870911) {
                    if (iXr < (z ? this.ny : this.sl)) {
                        if (!d(i)) {
                            i = this.f1223ms.get();
                        } else {
                            try {
                                ReentrantLock reentrantLock = this.ah;
                                reentrantLock.lock();
                                try {
                                    int iMs2 = ms(this.f1223ms.get());
                                    if (iMs2 < 0 || (iMs2 == 0 && runnable == null)) {
                                        ms().execute(runnable);
                                        int iXr2 = xr(this.f1223ms.get());
                                        if (iXr2 > this.ka) {
                                            this.ka = iXr2;
                                        }
                                        z2 = true;
                                    }
                                    reentrantLock.unlock();
                                    if (!z2) {
                                        ka();
                                    }
                                    return z2;
                                } catch (Throwable th) {
                                    reentrantLock.unlock();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                ka();
                                throw th2;
                            }
                        }
                    }
                }
                return false;
            } while (ms(i) == iMs);
        }
        return false;
    }

    private void ka() {
        ReentrantLock reentrantLock = this.ah;
        reentrantLock.lock();
        try {
            ah();
            xr();
        } finally {
            reentrantLock.unlock();
        }
    }

    public c(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, ThreadPoolExecutor threadPoolExecutor) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.ah = reentrantLock;
        this.d = reentrantLock.newCondition();
        if (i < 0 || i2 <= 0 || i2 < i || j < 0) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue == null || threadFactory == null || rejectedExecutionHandler == null) {
            throw null;
        }
        this.ny = i;
        this.sl = i2;
        this.xr = blockingQueue;
        this.x = timeUnit.toNanos(j);
        this.c = threadFactory;
        this.ab = rejectedExecutionHandler;
        this.ch = threadPoolExecutor;
    }

    @Override // com.bytedance.sdk.component.ch.xr, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        ah ahVar;
        if (runnable == null) {
            return;
        }
        if (runnable instanceof ah) {
            ahVar = (ah) runnable;
            ahVar.ms(this);
        } else {
            ahVar = new ah(runnable, this);
        }
        ms(ahVar);
    }

    @Override // com.bytedance.sdk.component.ch.xr, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.bytedance.sdk.component.ch.xr, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        if (callable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.bytedance.sdk.component.ch.xr, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, t);
        execute(futureTask);
        return futureTask;
    }

    private void ms(ah ahVar) {
        int i = this.f1223ms.get();
        if (xr(i) < this.ny) {
            if (xr((Runnable) ahVar, true)) {
                hi.xr.ab();
                return;
            }
            i = this.f1223ms.get();
        }
        if (xr(i) == 0) {
            if (xr((Runnable) ahVar, false)) {
                hi.xr.ab();
                return;
            }
            i = this.f1223ms.get();
        }
        if (ah(i) && this.xr.offer(ahVar)) {
            if (!ah(this.f1223ms.get()) && remove(ahVar)) {
                ms(ahVar.ms());
                hi.xr.ab();
                return;
            } else {
                hi.xr.ab();
                return;
            }
        }
        if (xr(i) < this.sl && xr((Runnable) ahVar, false)) {
            hi.xr.ab();
        } else {
            ms(ahVar.ms());
            hi.xr.ab();
        }
    }

    @Override // com.bytedance.sdk.component.ch.xr, java.util.concurrent.ExecutorService
    public void shutdown() {
        ReentrantLock reentrantLock = this.ah;
        reentrantLock.lock();
        try {
            c(0);
            reentrantLock.unlock();
            xr();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.ch.xr, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        ReentrantLock reentrantLock = this.ah;
        reentrantLock.lock();
        try {
            c(C.ENCODING_PCM_A_LAW);
            List<Runnable> listD = d();
            reentrantLock.unlock();
            xr();
            return listD;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.ch.xr, java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return !ah(this.f1223ms.get());
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public boolean isTerminating() {
        int i = this.f1223ms.get();
        return !ah(i) && xr(i, 1610612736);
    }

    @Override // com.bytedance.sdk.component.ch.xr, java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return ah(this.f1223ms.get(), 1610612736);
    }

    @Override // com.bytedance.sdk.component.ch.xr, java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.ah;
        reentrantLock.lock();
        while (!ah(this.f1223ms.get(), 1610612736)) {
            try {
                if (nanos > 0) {
                    nanos = this.d.awaitNanos(nanos);
                } else {
                    reentrantLock.unlock();
                    return false;
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    protected void finalize() {
        shutdown();
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.c = threadFactory;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public ThreadFactory getThreadFactory() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        rejectedExecutionHandler.getClass();
        this.ab = rejectedExecutionHandler;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.ab;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public int getCorePoolSize() {
        return this.ny;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public boolean allowsCoreThreadTimeOut() {
        return this.hi;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public void allowCoreThreadTimeOut(boolean z) {
        this.hi = true;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public void setMaximumPoolSize(int i) {
        if (i <= 0 || i < this.ny) {
            throw new IllegalArgumentException();
        }
        this.sl = i;
        this.f1223ms.get();
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public int getMaximumPoolSize() {
        return this.sl;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j == 0 && allowsCoreThreadTimeOut()) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        this.x = timeUnit.toNanos(j);
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.x, TimeUnit.NANOSECONDS);
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public BlockingQueue<Runnable> getQueue() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public boolean remove(Runnable runnable) {
        boolean zRemove = this.xr.remove(runnable);
        xr();
        return zRemove;
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public void purge() {
        BlockingQueue<Runnable> blockingQueue = this.xr;
        try {
            Iterator it = blockingQueue.iterator();
            while (it.hasNext()) {
                Runnable runnable = (Runnable) it.next();
                if ((runnable instanceof Future) && ((Future) runnable).isCancelled()) {
                    it.remove();
                }
            }
        } catch (ConcurrentModificationException unused) {
            for (Object obj : blockingQueue.toArray()) {
                if ((obj instanceof Future) && ((Future) obj).isCancelled()) {
                    blockingQueue.remove(obj);
                }
            }
        }
        xr();
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public int getPoolSize() {
        if (ah(this.f1223ms.get(), 1073741824)) {
            return 0;
        }
        return xr(this.f1223ms.get());
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public int getActiveCount() {
        return xr(this.f1223ms.get());
    }

    @Override // com.bytedance.sdk.component.ch.xr
    public String toString() {
        String str;
        int i = this.f1223ms.get();
        if (xr(i, 0)) {
            str = "Running";
        } else {
            str = ah(i, 1610612736) ? "Terminated" : "Shutting down";
        }
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + "[" + str + ", runnable name = , core size = " + this.ny + ", max size = " + this.sl + ", worker count = " + xr(i) + ", queued tasks = " + this.xr.size() + "]";
    }

    public void ms(Runnable runnable, boolean z) {
        int i = this.f1223ms.get();
        int iXr = xr(runnable);
        if (xr(i, C.ENCODING_PCM_A_LAW)) {
            do {
                Runnable runnablePoll = this.xr.poll();
                if (runnablePoll != null) {
                    if (ab(iXr) && (runnablePoll instanceof ah)) {
                        ah ahVar = (ah) runnablePoll;
                        ahVar.xr();
                        ahVar.ms(iXr);
                        ahVar.ms((c) null);
                        runnablePoll.run();
                    } else {
                        ms().execute(runnablePoll);
                        return;
                    }
                } else {
                    ah();
                    return;
                }
            } while (xr(i, C.ENCODING_PCM_A_LAW));
            xr();
            return;
        }
        xr();
    }

    private boolean ab(int i) {
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return com.bytedance.sdk.component.ch.ah.d.d();
        }
        return false;
    }

    private int xr(Runnable runnable) {
        if (runnable instanceof ah) {
            return ((ah) runnable).d();
        }
        return 0;
    }
}
