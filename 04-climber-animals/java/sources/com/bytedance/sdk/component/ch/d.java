package com.bytedance.sdk.component.ch;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final d f1203ms = new d();
    private xr ah;
    private ms d;
    private final List<WeakReference<ThreadPoolExecutor>> xr = new ArrayList();

    public interface ms {
    }

    public interface xr {
    }

    private ScheduledExecutorService xr() {
        return hi.xr.sl();
    }

    public synchronized void ms(com.bytedance.sdk.component.ch.d.d dVar) {
        xr(dVar);
        this.xr.add(new WeakReference<>(dVar));
    }

    public synchronized void xr(com.bytedance.sdk.component.ch.d.d dVar) {
        Iterator<WeakReference<ThreadPoolExecutor>> it = this.xr.iterator();
        while (it.hasNext()) {
            if (it.next().get() == dVar) {
                it.remove();
            }
        }
    }

    public String ms(BlockingQueue blockingQueue) {
        if (blockingQueue instanceof com.bytedance.sdk.component.ch.ms.ms) {
            return ((com.bytedance.sdk.component.ch.ms.ms) blockingQueue).ms();
        }
        return blockingQueue.getClass().getName();
    }

    public ThreadPoolExecutor ms(String str, String str2) {
        List<ThreadPoolExecutor> listMs = ms(str2, false, true);
        ms(listMs, str);
        ThreadPoolExecutor threadPoolExecutor = listMs.size() > 0 ? listMs.get(0) : null;
        ms();
        return threadPoolExecutor;
    }

    private synchronized List<ThreadPoolExecutor> ms(String str, boolean z, boolean z2) {
        ArrayList arrayList;
        ThreadPoolExecutor threadPoolExecutor;
        boolean z3;
        arrayList = new ArrayList();
        for (WeakReference<ThreadPoolExecutor> weakReference : this.xr) {
            if (weakReference != null && (threadPoolExecutor = weakReference.get()) != null) {
                BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
                if (queue instanceof com.bytedance.sdk.component.ch.ms.ms) {
                    z3 = ((com.bytedance.sdk.component.ch.ms.ms) queue).xr() instanceof PriorityBlockingQueue;
                } else {
                    z3 = queue instanceof PriorityBlockingQueue;
                }
                if (!threadPoolExecutor.isShutdown() && !threadPoolExecutor.isTerminated() && !threadPoolExecutor.isTerminating() && threadPoolExecutor.getQueue().isEmpty() && (str == null || !z3)) {
                    if (threadPoolExecutor.getActiveCount() < threadPoolExecutor.getPoolSize()) {
                        arrayList.add(threadPoolExecutor);
                        if (z) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (z2 && !z) {
            try {
                Collections.sort(arrayList, new Comparator<ThreadPoolExecutor>() { // from class: com.bytedance.sdk.component.ch.d.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                    public int compare(ThreadPoolExecutor threadPoolExecutor2, ThreadPoolExecutor threadPoolExecutor3) {
                        int poolSize = threadPoolExecutor2.getPoolSize() - threadPoolExecutor2.getActiveCount();
                        int poolSize2 = threadPoolExecutor3.getPoolSize() - threadPoolExecutor3.getActiveCount();
                        if (poolSize2 > poolSize) {
                            return 1;
                        }
                        return poolSize > poolSize2 ? -1 : 0;
                    }
                });
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }
        arrayList.size();
        this.xr.size();
        return arrayList;
    }

    public void ms() {
        if (hi.xr.ms()) {
            xr().schedule(new Runnable() { // from class: com.bytedance.sdk.component.ch.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.ah();
                }
            }, 100L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah() {
        List<ThreadPoolExecutor> listMs = ms(null, false, false);
        if (listMs == null || listMs.size() == 0) {
            return;
        }
        if (this.ah != null) {
            ka.ms();
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : listMs) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof ch) {
                    map.put(((ch) threadFactory).f1202ms + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.ch.ms.d) {
                    map.put(((com.bytedance.sdk.component.ch.ms.d) threadFactory).ms() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
                ms(threadPoolExecutor);
            }
        }
        if (this.ah != null) {
            ka.ms();
        }
    }

    private void ms(final ThreadPoolExecutor threadPoolExecutor) {
        final long keepAliveTime = threadPoolExecutor.getKeepAliveTime(TimeUnit.NANOSECONDS);
        final boolean zAllowsCoreThreadTimeOut = threadPoolExecutor.allowsCoreThreadTimeOut();
        threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.NANOSECONDS);
        if (zAllowsCoreThreadTimeOut) {
            threadPoolExecutor.allowCoreThreadTimeOut(false);
        }
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        xr().schedule(new Runnable() { // from class: com.bytedance.sdk.component.ch.d.3
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                long j = keepAliveTime;
                if (j == 0) {
                    j = 60;
                }
                threadPoolExecutor2.setKeepAliveTime(j, TimeUnit.NANOSECONDS);
                threadPoolExecutor.allowCoreThreadTimeOut(zAllowsCoreThreadTimeOut);
            }
        }, 10L, TimeUnit.MILLISECONDS);
    }

    private void ms(List<ThreadPoolExecutor> list, String str) {
        if (list == null || list.size() == 0 || this.d == null) {
            return;
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : list) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof ch) {
                    map.put(((ch) threadFactory).f1202ms + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.ch.ms.d) {
                    map.put(((com.bytedance.sdk.component.ch.ms.d) threadFactory).ms() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
            }
        }
        HashMap map2 = new HashMap();
        ThreadGroup threadGroupXr = ka.xr();
        int iActiveCount = threadGroupXr.activeCount();
        Thread[] threadArr = new Thread[iActiveCount + (iActiveCount / 2)];
        int iEnumerate = threadGroupXr.enumerate(threadArr);
        for (int i = 0; i < iEnumerate; i++) {
            Thread thread = threadArr[i];
            Thread.State state = thread.getState();
            if (state == Thread.State.BLOCKED || state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING) {
                String strReplaceAll = thread.getName().replaceAll("[0-9]", "");
                Integer num = (Integer) map2.get(strReplaceAll);
                map2.put(strReplaceAll, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            }
        }
    }

    public void ms(String str) {
        List<ThreadPoolExecutor> listMs = ms(null, false, true);
        if (listMs == null || listMs.size() == 0) {
            return;
        }
        ms(listMs, str);
        listMs.size();
        ThreadPoolExecutor threadPoolExecutor = listMs.get(0);
        if (threadPoolExecutor != null) {
            ms(threadPoolExecutor);
        }
        ms();
    }

    private d() {
        xr().schedule(new Runnable() { // from class: com.bytedance.sdk.component.ch.d.4
            @Override // java.lang.Runnable
            public void run() {
            }
        }, 1L, TimeUnit.MINUTES);
    }
}
