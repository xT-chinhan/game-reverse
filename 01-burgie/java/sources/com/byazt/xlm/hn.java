package com.byazt.xlm;

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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 20})
public final class hn {
    public static final hn pr = new hn();
    public hw hn;
    public final List<WeakReference<ThreadPoolExecutor>> hw = new ArrayList();
    public pr x;

    public interface hw {
    }

    public interface pr {
    }

    private ScheduledExecutorService hw() {
        return aj.hw.k();
    }

    public synchronized void pr(com.byazt.fr.x xVar) {
        if (hw(xVar)) {
            return;
        }
        this.hw.add(new WeakReference<>(xVar));
    }

    private boolean hw(com.byazt.fr.x xVar) {
        Iterator<WeakReference<ThreadPoolExecutor>> it = this.hw.iterator();
        while (it.hasNext()) {
            WeakReference<ThreadPoolExecutor> next = it.next();
            if (next != null) {
                ThreadPoolExecutor threadPoolExecutor = next.get();
                if (threadPoolExecutor == null) {
                    it.remove();
                } else if (threadPoolExecutor == xVar) {
                    return true;
                }
            }
        }
        return false;
    }

    public String pr(BlockingQueue blockingQueue) {
        if (blockingQueue instanceof com.byazt.rj.pr) {
            return ((com.byazt.rj.pr) blockingQueue).pr();
        }
        return blockingQueue.getClass().getName();
    }

    public ThreadPoolExecutor pr(String str, String str2) {
        List<ThreadPoolExecutor> listPr = pr(str2, false, true);
        pr(listPr, str);
        ThreadPoolExecutor threadPoolExecutor = listPr.size() > 0 ? listPr.get(0) : null;
        pr();
        return threadPoolExecutor;
    }

    private synchronized List<ThreadPoolExecutor> pr(String str, boolean z, boolean z2) {
        ArrayList arrayList;
        ThreadPoolExecutor threadPoolExecutor;
        boolean z3;
        arrayList = new ArrayList();
        for (WeakReference<ThreadPoolExecutor> weakReference : this.hw) {
            if (weakReference != null && (threadPoolExecutor = weakReference.get()) != null) {
                BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
                if (queue instanceof com.byazt.rj.pr) {
                    z3 = ((com.byazt.rj.pr) queue).hw() instanceof PriorityBlockingQueue;
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
                Collections.sort(arrayList, new Comparator<ThreadPoolExecutor>() { // from class: com.byazt.xlm.hn.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                    public int compare(ThreadPoolExecutor threadPoolExecutor2, ThreadPoolExecutor threadPoolExecutor3) {
                        int poolSize = threadPoolExecutor2.getPoolSize() - threadPoolExecutor2.getActiveCount();
                        int poolSize2 = threadPoolExecutor3.getPoolSize() - threadPoolExecutor3.getActiveCount();
                        if (poolSize2 > poolSize) {
                            return 1;
                        }
                        if (poolSize > poolSize2) {
                            return -1;
                        }
                        return 0;
                    }
                });
            } catch (Exception e) {
            }
        }
        arrayList.size();
        this.hw.size();
        return arrayList;
    }

    public void pr() {
        if (aj.hw.pr()) {
            hw().schedule(new Runnable() { // from class: com.byazt.xlm.hn.2
                @Override // java.lang.Runnable
                public void run() {
                    hn.this.hn();
                }
            }, 100L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        List<ThreadPoolExecutor> listPr = pr(null, false, false);
        if (listPr == null || listPr.size() == 0) {
            return;
        }
        if (this.hn != null) {
            x.pr();
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : listPr) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof zo) {
                    map.put(((zo) threadFactory).pr + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.byazt.rj.x) {
                    map.put(((com.byazt.rj.x) threadFactory).pr() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
                pr(threadPoolExecutor);
            }
        }
        if (this.hn != null) {
            x.pr();
        }
    }

    private void pr(final ThreadPoolExecutor threadPoolExecutor) {
        final long keepAliveTime = threadPoolExecutor.getKeepAliveTime(TimeUnit.NANOSECONDS);
        final boolean zAllowsCoreThreadTimeOut = threadPoolExecutor.allowsCoreThreadTimeOut();
        threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.NANOSECONDS);
        if (zAllowsCoreThreadTimeOut) {
            threadPoolExecutor.allowCoreThreadTimeOut(false);
        }
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        hw().schedule(new Runnable() { // from class: com.byazt.xlm.hn.3
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

    private void pr(List<ThreadPoolExecutor> list, String str) {
        if (list == null || list.size() == 0 || this.x == null) {
            return;
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : list) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof zo) {
                    map.put(((zo) threadFactory).pr + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.byazt.rj.x) {
                    map.put(((com.byazt.rj.x) threadFactory).pr() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
            }
        }
        HashMap map2 = new HashMap();
        ThreadGroup threadGroupHw = x.hw();
        int iActiveCount = threadGroupHw.activeCount();
        Thread[] threadArr = new Thread[iActiveCount + (iActiveCount / 2)];
        int iEnumerate = threadGroupHw.enumerate(threadArr);
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

    public void pr(String str) {
        List<ThreadPoolExecutor> listPr = pr(null, false, true);
        if (listPr == null || listPr.size() == 0) {
            return;
        }
        pr(listPr, str);
        listPr.size();
        ThreadPoolExecutor threadPoolExecutor = listPr.get(0);
        if (threadPoolExecutor != null) {
            pr(threadPoolExecutor);
        }
        pr();
    }

    private hn() {
        hw().schedule(new Runnable() { // from class: com.byazt.xlm.hn.4
            @Override // java.lang.Runnable
            public void run() {
            }
        }, 1L, TimeUnit.MINUTES);
    }
}
