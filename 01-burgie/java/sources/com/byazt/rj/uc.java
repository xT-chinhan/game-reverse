package com.byazt.rj;

import com.byazt.xlm.aj;
import com.bykv.vk.component.ttvideo.player.C;
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
@com.byazt.vzx.pr(pr = {0, 1, 1628, 5})
public class uc implements com.byazt.xlm.pr {
    public volatile int aj;
    public int c;
    public volatile RejectedExecutionHandler fw;
    public final ReentrantLock hn;
    public final BlockingQueue<Runnable> hw;
    public volatile int k;
    public ThreadPoolExecutor m;
    public final AtomicInteger pr = new AtomicInteger(pr(-536870912, 0));
    public volatile ThreadFactory uc;
    public final ThreadPoolExecutor vk;
    public boolean w;
    public final Condition x;
    public volatile long zo;

    private static int pr(int i) {
        return i & (-536870912);
    }

    private static int hw(int i) {
        return i & 536870911;
    }

    private static int pr(int i, int i2) {
        return i | i2;
    }

    private static boolean hw(int i, int i2) {
        return i < i2;
    }

    private static boolean hn(int i, int i2) {
        return i >= i2;
    }

    private static boolean hn(int i) {
        return i < 0;
    }

    private boolean x(int i) {
        return this.pr.compareAndSet(i, i + 1);
    }

    private void x() {
        while (true) {
            int i = this.pr.get();
            if (!this.pr.compareAndSet(i, i - 1)) {
                Thread.yield();
            } else {
                return;
            }
        }
    }

    private void c(int i) {
        int i2;
        do {
            i2 = this.pr.get();
            if (hn(i2, i)) {
                return;
            }
        } while (!this.pr.compareAndSet(i2, pr(i, hw(i2))));
    }

    public ThreadPoolExecutor pr() {
        if (this.m == null) {
            this.m = aj.hw.vk();
        }
        return this.m;
    }

    public final void hw() {
        while (true) {
            int i = this.pr.get();
            if (!hn(i) && !hn(i, 1073741824)) {
                if ((pr(i) == 0 && !this.hw.isEmpty()) || hw(i) != 0) {
                    return;
                }
                ReentrantLock reentrantLock = this.hn;
                reentrantLock.lock();
                try {
                    if (this.pr.compareAndSet(i, pr(1073741824, 0))) {
                        this.pr.set(pr(1610612736, 0));
                        this.x.signalAll();
                        reentrantLock.unlock();
                        return;
                    }
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    public final void pr(Runnable runnable) {
        this.fw.rejectedExecution(runnable, this.vk);
    }

    private List<Runnable> c() {
        BlockingQueue<Runnable> blockingQueue = this.hw;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            for (Runnable runnable : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                if (blockingQueue.remove(runnable)) {
                    if (runnable instanceof hn) {
                        arrayList.add(((hn) runnable).hn);
                    } else {
                        arrayList.add(runnable);
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean hw(Runnable runnable, boolean z) {
        boolean z2;
        while (true) {
            int i = this.pr.get();
            int iPr = pr(i);
            boolean z3 = false;
            if (iPr >= 0 && (iPr != 0 || runnable != null || this.hw.isEmpty())) {
                break;
            }
            do {
                int iHw = hw(i);
                if (iHw < 536870911) {
                    if (iHw < (z ? this.aj : this.k)) {
                        if (!x(i)) {
                            i = this.pr.get();
                        } else {
                            try {
                                ReentrantLock reentrantLock = this.hn;
                                reentrantLock.lock();
                                try {
                                    int iPr2 = pr(this.pr.get());
                                    if (iPr2 < 0 || (iPr2 == 0 && runnable == null)) {
                                        pr().execute(runnable);
                                        int iHw2 = hw(this.pr.get());
                                        if (iHw2 > this.c) {
                                            this.c = iHw2;
                                        }
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        uc();
                                    }
                                    return z3;
                                } finally {
                                    reentrantLock.unlock();
                                }
                            } catch (Throwable th) {
                                uc();
                                throw th;
                            }
                        }
                    }
                }
                return false;
            } while (pr(i) == iPr);
        }
        return false;
    }

    private void uc() {
        ReentrantLock reentrantLock = this.hn;
        reentrantLock.lock();
        try {
            x();
            hw();
        } finally {
            reentrantLock.unlock();
        }
    }

    public uc(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, ThreadPoolExecutor threadPoolExecutor) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.hn = reentrantLock;
        this.x = reentrantLock.newCondition();
        if (i < 0 || i2 <= 0 || i2 < i || j < 0) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue == null || threadFactory == null || rejectedExecutionHandler == null) {
            throw new NullPointerException();
        }
        this.aj = i;
        this.k = i2;
        this.hw = blockingQueue;
        this.zo = timeUnit.toNanos(j);
        this.uc = threadFactory;
        this.fw = rejectedExecutionHandler;
        this.vk = threadPoolExecutor;
    }

    @Override // com.byazt.xlm.pr, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        hn hnVar;
        if (runnable == null) {
            return;
        }
        if (runnable instanceof hn) {
            hnVar = (hn) runnable;
            hnVar.pr(this);
        } else {
            hnVar = new hn(runnable, this);
        }
        pr(hnVar);
    }

    @Override // com.byazt.xlm.pr, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.byazt.xlm.pr, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        if (callable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.byazt.xlm.pr, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, t);
        execute(futureTask);
        return futureTask;
    }

    private void pr(hn hnVar) {
        int i = this.pr.get();
        if (hw(i) < this.aj) {
            if (hw((Runnable) hnVar, true)) {
                aj.hw.fw();
                return;
            }
            i = this.pr.get();
        }
        if (hw(i) == 0) {
            if (hw((Runnable) hnVar, false)) {
                aj.hw.fw();
                return;
            }
            i = this.pr.get();
        }
        if (hn(i) && this.hw.offer(hnVar)) {
            if (!hn(this.pr.get()) && remove(hnVar)) {
                pr(hnVar.pr());
                aj.hw.fw();
                return;
            } else {
                aj.hw.fw();
                return;
            }
        }
        if (hw(i) < this.k && hw((Runnable) hnVar, false)) {
            aj.hw.fw();
        } else {
            pr(hnVar.pr());
            aj.hw.fw();
        }
    }

    @Override // com.byazt.xlm.pr, java.util.concurrent.ExecutorService
    public void shutdown() {
        ReentrantLock reentrantLock = this.hn;
        reentrantLock.lock();
        try {
            c(0);
            reentrantLock.unlock();
            hw();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.byazt.xlm.pr, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        ReentrantLock reentrantLock = this.hn;
        reentrantLock.lock();
        try {
            c(C.ENCODING_PCM_A_LAW);
            List<Runnable> listC = c();
            reentrantLock.unlock();
            hw();
            return listC;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.byazt.xlm.pr, java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return !hn(this.pr.get());
    }

    @Override // com.byazt.xlm.pr
    public boolean isTerminating() {
        int i = this.pr.get();
        return !hn(i) && hw(i, 1610612736);
    }

    @Override // com.byazt.xlm.pr, java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return hn(this.pr.get(), 1610612736);
    }

    @Override // com.byazt.xlm.pr, java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.hn;
        reentrantLock.lock();
        while (!hn(this.pr.get(), 1610612736)) {
            try {
                if (nanos > 0) {
                    nanos = this.x.awaitNanos(nanos);
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

    public void finalize() {
        hn();
        try {
            super.finalize();
        } catch (Throwable th) {
        }
    }

    public void hn() {
        c(0);
        ReentrantLock reentrantLock = this.hn;
        if (reentrantLock.tryLock()) {
            try {
                int i = this.pr.get();
                if (hw(i) == 0 && this.hw.isEmpty() && this.pr.compareAndSet(i, pr(1073741824, 0))) {
                    this.pr.set(pr(1610612736, 0));
                    this.x.signalAll();
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.byazt.xlm.pr
    public void setThreadFactory(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException();
        }
        this.uc = threadFactory;
    }

    @Override // com.byazt.xlm.pr
    public ThreadFactory getThreadFactory() {
        return this.uc;
    }

    @Override // com.byazt.xlm.pr
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        if (rejectedExecutionHandler == null) {
            throw new NullPointerException();
        }
        this.fw = rejectedExecutionHandler;
    }

    @Override // com.byazt.xlm.pr
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.fw;
    }

    @Override // com.byazt.xlm.pr
    public void setCorePoolSize(int i) {
    }

    @Override // com.byazt.xlm.pr
    public int getCorePoolSize() {
        return this.aj;
    }

    @Override // com.byazt.xlm.pr
    public boolean prestartCoreThread() {
        return false;
    }

    @Override // com.byazt.xlm.pr
    public int prestartAllCoreThreads() {
        return 0;
    }

    @Override // com.byazt.xlm.pr
    public boolean allowsCoreThreadTimeOut() {
        return this.w;
    }

    @Override // com.byazt.xlm.pr
    public void allowCoreThreadTimeOut(boolean z) {
        this.w = true;
    }

    @Override // com.byazt.xlm.pr
    public void setMaximumPoolSize(int i) {
        if (i <= 0 || i < this.aj) {
            throw new IllegalArgumentException();
        }
        this.k = i;
        this.pr.get();
    }

    @Override // com.byazt.xlm.pr
    public int getMaximumPoolSize() {
        return this.k;
    }

    @Override // com.byazt.xlm.pr
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j == 0 && allowsCoreThreadTimeOut()) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        this.zo = timeUnit.toNanos(j);
    }

    @Override // com.byazt.xlm.pr
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zo, TimeUnit.NANOSECONDS);
    }

    @Override // com.byazt.xlm.pr
    public BlockingQueue<Runnable> getQueue() {
        return this.hw;
    }

    @Override // com.byazt.xlm.pr
    public boolean remove(Runnable runnable) {
        boolean zRemove = this.hw.remove(runnable);
        hw();
        return zRemove;
    }

    @Override // com.byazt.xlm.pr
    public void purge() {
        BlockingQueue<Runnable> blockingQueue = this.hw;
        try {
            Iterator it = blockingQueue.iterator();
            while (it.hasNext()) {
                Runnable runnable = (Runnable) it.next();
                if ((runnable instanceof Future) && ((Future) runnable).isCancelled()) {
                    it.remove();
                }
            }
        } catch (ConcurrentModificationException e) {
            for (Object obj : blockingQueue.toArray()) {
                if ((obj instanceof Future) && ((Future) obj).isCancelled()) {
                    blockingQueue.remove(obj);
                }
            }
        }
        hw();
    }

    @Override // com.byazt.xlm.pr
    public int getPoolSize() {
        if (hn(this.pr.get(), 1073741824)) {
            return 0;
        }
        return hw(this.pr.get());
    }

    @Override // com.byazt.xlm.pr
    public int getActiveCount() {
        return hw(this.pr.get());
    }

    @Override // com.byazt.xlm.pr
    public int getLargestPoolSize() {
        return 0;
    }

    @Override // com.byazt.xlm.pr
    public long getTaskCount() {
        return 0L;
    }

    @Override // com.byazt.xlm.pr
    public long getCompletedTaskCount() {
        return 0L;
    }

    @Override // com.byazt.xlm.pr
    public String toString() {
        String str;
        int i = this.pr.get();
        if (hw(i, 0)) {
            str = "Running";
        } else {
            str = hn(i, 1610612736) ? "Terminated" : "Shutting down";
        }
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + "[" + str + ", runnable name = , core size = " + this.aj + ", max size = " + this.k + ", worker count = " + hw(i) + ", queued tasks = " + this.hw.size() + "]";
    }

    public void pr(Runnable runnable, boolean z) {
        int i = this.pr.get();
        int iHw = hw(runnable);
        if (hw(i, C.ENCODING_PCM_A_LAW)) {
            do {
                Runnable runnablePoll = this.hw.poll();
                if (runnablePoll != null) {
                    if (uc(iHw) && (runnablePoll instanceof hn)) {
                        hn hnVar = (hn) runnablePoll;
                        hnVar.hw();
                        hnVar.pr(iHw);
                        hnVar.pr((uc) null);
                        runnablePoll.run();
                    } else {
                        pr().execute(runnablePoll);
                        return;
                    }
                } else {
                    x();
                    return;
                }
            } while (hw(i, C.ENCODING_PCM_A_LAW));
            hw();
            return;
        }
        hw();
    }

    private boolean uc(int i) {
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return com.byazt.mz.x.hn();
        }
        return false;
    }

    private int hw(Runnable runnable) {
        if (runnable instanceof hn) {
            return ((hn) runnable).x();
        }
        return 0;
    }
}
