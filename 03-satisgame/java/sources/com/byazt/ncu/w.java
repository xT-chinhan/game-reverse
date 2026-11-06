package com.byazt.ncu;

import com.byazt.qit.rv;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE, 13})
public class w implements com.byazt.qit.n {
    public boolean cp;
    public volatile int d;
    public volatile long fs;
    public int l;
    public final AtomicInteger n = new AtomicInteger(n(-536870912, 0));
    public ThreadPoolExecutor oa;
    public final Condition q;
    public final BlockingQueue<Runnable> qg;
    public volatile int rv;
    public final ReentrantLock s;
    public final ThreadPoolExecutor tj;
    public volatile ThreadFactory w;
    public volatile RejectedExecutionHandler x;

    private static int n(int i) {
        return i & (-536870912);
    }

    private static int n(int i, int i2) {
        return i | i2;
    }

    private static int qg(int i) {
        return i & 536870911;
    }

    private static boolean qg(int i, int i2) {
        return i < i2;
    }

    private static boolean s(int i) {
        return i < 0;
    }

    private static boolean s(int i, int i2) {
        return i >= i2;
    }

    @Override // com.byazt.qit.n
    public long getCompletedTaskCount() {
        return 0L;
    }

    @Override // com.byazt.qit.n
    public int getLargestPoolSize() {
        return 0;
    }

    @Override // com.byazt.qit.n
    public long getTaskCount() {
        return 0L;
    }

    @Override // com.byazt.qit.n
    public int prestartAllCoreThreads() {
        return 0;
    }

    @Override // com.byazt.qit.n
    public boolean prestartCoreThread() {
        return false;
    }

    @Override // com.byazt.qit.n
    public void setCorePoolSize(int i) {
    }

    private boolean q(int i) {
        return this.n.compareAndSet(i, i + 1);
    }

    private void q() {
        while (true) {
            int i = this.n.get();
            if (this.n.compareAndSet(i, i - 1)) {
                return;
            } else {
                Thread.yield();
            }
        }
    }

    private void l(int i) {
        int i2;
        do {
            i2 = this.n.get();
            if (s(i2, i)) {
                return;
            }
        } while (!this.n.compareAndSet(i2, n(i, qg(i2))));
    }

    public ThreadPoolExecutor n() {
        if (this.oa == null) {
            this.oa = rv.qg.tj();
        }
        return this.oa;
    }

    public final void qg() {
        while (true) {
            int i = this.n.get();
            if (s(i) || s(i, C.ENCODING_PCM_32BIT)) {
                return;
            }
            if ((n(i) == 0 && !this.qg.isEmpty()) || qg(i) != 0) {
                return;
            }
            ReentrantLock reentrantLock = this.s;
            reentrantLock.lock();
            try {
                if (this.n.compareAndSet(i, n(C.ENCODING_PCM_32BIT, 0))) {
                    this.n.set(n(1610612736, 0));
                    this.q.signalAll();
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

    public final void n(Runnable runnable) {
        this.x.rejectedExecution(runnable, this.tj);
    }

    private List<Runnable> l() {
        BlockingQueue<Runnable> blockingQueue = this.qg;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            for (Runnable runnable : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                if (blockingQueue.remove(runnable)) {
                    if (runnable instanceof s) {
                        arrayList.add(((s) runnable).s);
                    } else {
                        arrayList.add(runnable);
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean qg(Runnable runnable, boolean z) {
        while (true) {
            int i = this.n.get();
            int iN = n(i);
            boolean z2 = false;
            if (iN >= 0 && (iN != 0 || runnable != null || this.qg.isEmpty())) {
                break;
            }
            do {
                int iQg = qg(i);
                if (iQg < 536870911) {
                    if (iQg < (z ? this.rv : this.d)) {
                        if (!q(i)) {
                            i = this.n.get();
                        } else {
                            try {
                                ReentrantLock reentrantLock = this.s;
                                reentrantLock.lock();
                                try {
                                    int iN2 = n(this.n.get());
                                    if (iN2 < 0 || (iN2 == 0 && runnable == null)) {
                                        n().execute(runnable);
                                        int iQg2 = qg(this.n.get());
                                        if (iQg2 > this.l) {
                                            this.l = iQg2;
                                        }
                                        z2 = true;
                                    }
                                    reentrantLock.unlock();
                                    if (!z2) {
                                        w();
                                    }
                                    return z2;
                                } catch (Throwable th) {
                                    reentrantLock.unlock();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                w();
                                throw th2;
                            }
                        }
                    }
                }
                return false;
            } while (n(i) == iN);
        }
        return false;
    }

    private void w() {
        ReentrantLock reentrantLock = this.s;
        reentrantLock.lock();
        try {
            q();
            qg();
        } finally {
            reentrantLock.unlock();
        }
    }

    public w(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, ThreadPoolExecutor threadPoolExecutor) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.s = reentrantLock;
        this.q = reentrantLock.newCondition();
        if (i < 0 || i2 <= 0 || i2 < i || j < 0) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue == null || threadFactory == null || rejectedExecutionHandler == null) {
            throw null;
        }
        this.rv = i;
        this.d = i2;
        this.qg = blockingQueue;
        this.fs = timeUnit.toNanos(j);
        this.w = threadFactory;
        this.x = rejectedExecutionHandler;
        this.tj = threadPoolExecutor;
    }

    @Override // com.byazt.qit.n
    public void execute(Runnable runnable) {
        s sVar;
        if (runnable == null) {
            return;
        }
        if (runnable instanceof s) {
            sVar = (s) runnable;
            sVar.n(this);
        } else {
            sVar = new s(runnable, this);
        }
        n(sVar);
    }

    @Override // com.byazt.qit.n
    public Future<?> submit(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.byazt.qit.n
    public <T> Future<T> submit(Callable<T> callable) {
        if (callable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.byazt.qit.n
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, t);
        execute(futureTask);
        return futureTask;
    }

    private void n(s sVar) {
        int i = this.n.get();
        if (qg(i) < this.rv) {
            if (qg((Runnable) sVar, true)) {
                rv.qg.x();
                return;
            }
            i = this.n.get();
        }
        if (qg(i) == 0) {
            if (qg((Runnable) sVar, false)) {
                rv.qg.x();
                return;
            }
            i = this.n.get();
        }
        if (s(i) && this.qg.offer(sVar)) {
            if (!s(this.n.get()) && remove(sVar)) {
                n(sVar.n());
                rv.qg.x();
                return;
            } else {
                rv.qg.x();
                return;
            }
        }
        if (qg(i) < this.d && qg((Runnable) sVar, false)) {
            rv.qg.x();
        } else {
            n(sVar.n());
            rv.qg.x();
        }
    }

    @Override // com.byazt.qit.n
    public void shutdown() {
        ReentrantLock reentrantLock = this.s;
        reentrantLock.lock();
        try {
            l(0);
            reentrantLock.unlock();
            qg();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.byazt.qit.n
    public List<Runnable> shutdownNow() {
        ReentrantLock reentrantLock = this.s;
        reentrantLock.lock();
        try {
            l(C.ENCODING_PCM_A_LAW);
            List<Runnable> listL = l();
            reentrantLock.unlock();
            qg();
            return listL;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.byazt.qit.n
    public boolean isShutdown() {
        return !s(this.n.get());
    }

    @Override // com.byazt.qit.n
    public boolean isTerminating() {
        int i = this.n.get();
        return !s(i) && qg(i, 1610612736);
    }

    @Override // com.byazt.qit.n
    public boolean isTerminated() {
        return s(this.n.get(), 1610612736);
    }

    @Override // com.byazt.qit.n
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.s;
        reentrantLock.lock();
        while (!s(this.n.get(), 1610612736)) {
            try {
                if (nanos > 0) {
                    nanos = this.q.awaitNanos(nanos);
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
        s();
        try {
            super.finalize();
        } catch (Throwable unused) {
        }
    }

    public void s() {
        l(0);
        ReentrantLock reentrantLock = this.s;
        if (reentrantLock.tryLock()) {
            try {
                int i = this.n.get();
                if (qg(i) == 0 && this.qg.isEmpty() && this.n.compareAndSet(i, n(C.ENCODING_PCM_32BIT, 0))) {
                    this.n.set(n(1610612736, 0));
                    this.q.signalAll();
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // com.byazt.qit.n
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.w = threadFactory;
    }

    @Override // com.byazt.qit.n
    public ThreadFactory getThreadFactory() {
        return this.w;
    }

    @Override // com.byazt.qit.n
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        rejectedExecutionHandler.getClass();
        this.x = rejectedExecutionHandler;
    }

    @Override // com.byazt.qit.n
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.x;
    }

    @Override // com.byazt.qit.n
    public int getCorePoolSize() {
        return this.rv;
    }

    @Override // com.byazt.qit.n
    public boolean allowsCoreThreadTimeOut() {
        return this.cp;
    }

    @Override // com.byazt.qit.n
    public void allowCoreThreadTimeOut(boolean z) {
        this.cp = true;
    }

    @Override // com.byazt.qit.n
    public void setMaximumPoolSize(int i) {
        if (i <= 0 || i < this.rv) {
            throw new IllegalArgumentException();
        }
        this.d = i;
        this.n.get();
    }

    @Override // com.byazt.qit.n
    public int getMaximumPoolSize() {
        return this.d;
    }

    @Override // com.byazt.qit.n
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j == 0 && allowsCoreThreadTimeOut()) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        this.fs = timeUnit.toNanos(j);
    }

    @Override // com.byazt.qit.n
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.fs, TimeUnit.NANOSECONDS);
    }

    @Override // com.byazt.qit.n
    public BlockingQueue<Runnable> getQueue() {
        return this.qg;
    }

    @Override // com.byazt.qit.n
    public boolean remove(Runnable runnable) {
        boolean zRemove = this.qg.remove(runnable);
        qg();
        return zRemove;
    }

    @Override // com.byazt.qit.n
    public void purge() {
        BlockingQueue<Runnable> blockingQueue = this.qg;
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
        qg();
    }

    @Override // com.byazt.qit.n
    public int getPoolSize() {
        if (s(this.n.get(), C.ENCODING_PCM_32BIT)) {
            return 0;
        }
        return qg(this.n.get());
    }

    @Override // com.byazt.qit.n
    public int getActiveCount() {
        return qg(this.n.get());
    }

    @Override // com.byazt.qit.n
    public String toString() {
        String str;
        int i = this.n.get();
        if (qg(i, 0)) {
            str = "Running";
        } else {
            str = s(i, 1610612736) ? "Terminated" : "Shutting down";
        }
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + "[" + str + ", runnable name = , core size = " + this.rv + ", max size = " + this.d + ", worker count = " + qg(i) + ", queued tasks = " + this.qg.size() + "]";
    }

    public void n(Runnable runnable, boolean z) {
        int i = this.n.get();
        int iQg = qg(runnable);
        if (qg(i, C.ENCODING_PCM_A_LAW)) {
            do {
                Runnable runnablePoll = this.qg.poll();
                if (runnablePoll != null) {
                    if (w(iQg) && (runnablePoll instanceof s)) {
                        s sVar = (s) runnablePoll;
                        sVar.qg();
                        sVar.n(iQg);
                        sVar.n((w) null);
                        runnablePoll.run();
                    } else {
                        n().execute(runnablePoll);
                        return;
                    }
                } else {
                    q();
                    return;
                }
            } while (qg(i, C.ENCODING_PCM_A_LAW));
            qg();
            return;
        }
        qg();
    }

    private boolean w(int i) {
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return com.byazt.oo.q.s();
        }
        return false;
    }

    private int qg(Runnable runnable) {
        if (runnable instanceof s) {
            return ((s) runnable).q();
        }
        return 0;
    }
}
