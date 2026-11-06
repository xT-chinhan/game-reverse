package com.byazt.sf;

import com.byazt.ca.ho;
import com.byazt.fj.SSWebView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME, 121})
public final class x {
    public static final x pr = new x();
    public static final AtomicInteger hw = new AtomicInteger(0);

    private x() {
    }

    public static x pr() {
        return pr;
    }

    public hn hw() {
        return new hn(c(), uc(), fw(), zo(), 0L, aj());
    }

    public void hn() {
        AtomicInteger atomicInteger = hw;
        if (atomicInteger.get() == Integer.MAX_VALUE) {
            return;
        }
        atomicInteger.incrementAndGet();
    }

    public void x() {
        AtomicInteger atomicInteger;
        int i;
        do {
            atomicInteger = hw;
            i = atomicInteger.get();
            if (i <= 0) {
                return;
            }
        } while (!atomicInteger.compareAndSet(i, i - 1));
    }

    private static int c() {
        try {
            return SSWebView.getAliveCount();
        } catch (Throwable th) {
            return 0;
        }
    }

    private static int uc() {
        try {
            return com.byazt.p.x.pr();
        } catch (Throwable th) {
            return 0;
        }
    }

    private static int fw() {
        return hw.get();
    }

    private static int zo() {
        try {
            com.byazt.zq.hn hnVarPr = com.byazt.qn.x.pr(com.byazt.zb.pr.x(), "sp_oom");
            if (hnVarPr == null) {
                return 0;
            }
            return hnVarPr.getInt("oom_count", 0);
        } catch (Throwable th) {
            ho.hw("PerfMonitor", "countOom err: " + th.getMessage());
            return 0;
        }
    }

    private static int aj() {
        try {
            String[] list = new File("/proc/self/task").list();
            if (list != null && list.length > 0) {
                return list.length;
            }
        } catch (Throwable th) {
            ho.hw("PerfMonitor", "countThreads proc err: " + th.getMessage());
        }
        return vk();
    }

    private static int vk() {
        try {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            if (threadGroup == null) {
                return 0;
            }
            while (threadGroup.getParent() != null) {
                threadGroup = threadGroup.getParent();
            }
            return threadGroup.activeCount();
        } catch (Throwable th) {
            return 0;
        }
    }
}
