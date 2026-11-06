package com.byazt.qit;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 8})
public final class s {
    public static final s n = new s();
    public n q;
    public final List<WeakReference<ThreadPoolExecutor>> qg = new ArrayList();
    public qg s;

    public interface n {
    }

    public interface qg {
    }

    private ScheduledExecutorService qg() {
        return rv.qg.oa();
    }

    public synchronized void n(com.byazt.xis.q qVar) {
        if (qg(qVar)) {
            return;
        }
        this.qg.add(new WeakReference<>(qVar));
    }

    private boolean qg(com.byazt.xis.q qVar) {
        Iterator<WeakReference<ThreadPoolExecutor>> it = this.qg.iterator();
        while (it.hasNext()) {
            WeakReference<ThreadPoolExecutor> next = it.next();
            if (next != null) {
                ThreadPoolExecutor threadPoolExecutor = next.get();
                if (threadPoolExecutor == null) {
                    it.remove();
                } else if (threadPoolExecutor == qVar) {
                    return true;
                }
            }
        }
        return false;
    }

    public String n(BlockingQueue blockingQueue) {
        if (blockingQueue instanceof com.byazt.ncu.n) {
            return ((com.byazt.ncu.n) blockingQueue).n();
        }
        return blockingQueue.getClass().getName();
    }

    public ThreadPoolExecutor n(String str, String str2) {
        List<ThreadPoolExecutor> listN = n(str2, false, true);
        n(listN, str);
        ThreadPoolExecutor threadPoolExecutor = listN.size() > 0 ? listN.get(0) : null;
        n();
        return threadPoolExecutor;
    }

    private synchronized List<ThreadPoolExecutor> n(String str, boolean z, boolean z2) {
        ArrayList arrayList;
        ThreadPoolExecutor threadPoolExecutor;
        boolean z3;
        arrayList = new ArrayList();
        for (WeakReference<ThreadPoolExecutor> weakReference : this.qg) {
            if (weakReference != null && (threadPoolExecutor = weakReference.get()) != null) {
                BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
                if (queue instanceof com.byazt.ncu.n) {
                    z3 = ((com.byazt.ncu.n) queue).qg() instanceof PriorityBlockingQueue;
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
                Collections.sort(arrayList, new Comparator<ThreadPoolExecutor>() { // from class: com.byazt.qit.s.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                    public int compare(ThreadPoolExecutor threadPoolExecutor2, ThreadPoolExecutor threadPoolExecutor3) {
                        int poolSize = threadPoolExecutor2.getPoolSize() - threadPoolExecutor2.getActiveCount();
                        int poolSize2 = threadPoolExecutor3.getPoolSize() - threadPoolExecutor3.getActiveCount();
                        if (poolSize2 > poolSize) {
                            return 1;
                        }
                        return poolSize > poolSize2 ? -1 : 0;
                    }
                });
            } catch (Exception unused) {
            }
        }
        arrayList.size();
        this.qg.size();
        return arrayList;
    }

    public void n() {
        if (rv.qg.n()) {
            qg().schedule(new Runnable() { // from class: com.byazt.qit.s.2
                @Override // java.lang.Runnable
                public void run() {
                    s.this.s();
                }
            }, 100L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        List<ThreadPoolExecutor> listN = n(null, false, false);
        if (listN == null || listN.size() == 0) {
            return;
        }
        if (this.s != null) {
            q.n();
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : listN) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof fs) {
                    map.put(((fs) threadFactory).n + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.byazt.ncu.q) {
                    map.put(((com.byazt.ncu.q) threadFactory).n() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
                n(threadPoolExecutor);
            }
        }
        if (this.s != null) {
            q.n();
        }
    }

    private void n(final ThreadPoolExecutor threadPoolExecutor) {
        final long keepAliveTime = threadPoolExecutor.getKeepAliveTime(TimeUnit.NANOSECONDS);
        final boolean zAllowsCoreThreadTimeOut = threadPoolExecutor.allowsCoreThreadTimeOut();
        threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.NANOSECONDS);
        if (zAllowsCoreThreadTimeOut) {
            threadPoolExecutor.allowCoreThreadTimeOut(false);
        }
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        qg().schedule(new Runnable() { // from class: com.byazt.qit.s.3
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

    private void n(List<ThreadPoolExecutor> list, String str) {
        if (list == null || list.size() == 0 || this.q == null) {
            return;
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : list) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof fs) {
                    map.put(((fs) threadFactory).n + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.byazt.ncu.q) {
                    map.put(((com.byazt.ncu.q) threadFactory).n() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
            }
        }
        HashMap map2 = new HashMap();
        ThreadGroup threadGroupQg = q.qg();
        int iActiveCount = threadGroupQg.activeCount();
        Thread[] threadArr = new Thread[iActiveCount + (iActiveCount / 2)];
        int iEnumerate = threadGroupQg.enumerate(threadArr);
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

    public void n(String str) {
        List<ThreadPoolExecutor> listN = n(null, false, true);
        if (listN == null || listN.size() == 0) {
            return;
        }
        n(listN, str);
        listN.size();
        ThreadPoolExecutor threadPoolExecutor = listN.get(0);
        if (threadPoolExecutor != null) {
            n(threadPoolExecutor);
        }
        n();
    }

    private s() {
        qg().schedule(new Runnable() { // from class: com.byazt.qit.s.4
            @Override // java.lang.Runnable
            public void run() {
            }
        }, 1L, TimeUnit.MINUTES);
    }
}
