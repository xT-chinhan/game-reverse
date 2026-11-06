package com.byazt.ts;

import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.mrs.DownloadStatus;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends pr {
    public static com.byazt.gi.x hw;

    public static void hn(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService executorServiceYb = com.byazt.lj.hn.yb();
        if (executorServiceYb != null) {
            executorServiceYb.invokeAll(list);
        }
    }

    public static List<Future> x(List<Runnable> list) {
        ExecutorService executorServiceYb = com.byazt.lj.hn.yb();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(executorServiceYb.submit(it.next()));
        }
        return arrayList;
    }

    public c() {
        hw = new com.byazt.gi.x();
    }

    public static Runnable c(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            ExecutorService executorServiceYb = com.byazt.lj.hn.yb();
            if ((executorServiceYb instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) executorServiceYb).getQueue()) != null && !queue.isEmpty()) {
                Iterator<Future> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        runnable = null;
                        break;
                    }
                    Future next = it.next();
                    if ((next instanceof Runnable) && queue.remove(next)) {
                        runnable = (Runnable) next;
                        break;
                    }
                }
                if (runnable != null) {
                    list.remove(runnable);
                    return runnable;
                }
            }
        } catch (Throwable th) {
            com.byazt.p000do.pr.x("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
        }
        return null;
    }

    @Override // com.byazt.ts.pr
    public boolean pr(int i) {
        DownloadInfo downloadInfoX;
        com.byazt.gi.x xVar = hw;
        if (xVar == null || !xVar.pr(i) || (downloadInfoX = x(i)) == null) {
            return false;
        }
        if (!DownloadStatus.isDownloading(downloadInfoX.getStatus())) {
            hw(i);
            return false;
        }
        return true;
    }

    @Override // com.byazt.ts.pr
    public void pr(com.byazt.gi.hn hnVar) {
        com.byazt.gi.x xVar = hw;
        if (xVar == null) {
            return;
        }
        xVar.hw(hnVar);
    }

    @Override // com.byazt.ts.pr
    public void pr(int i, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.byazt.p000do.pr.hw("DownloadTask", "start doDownload for task : ".concat(String.valueOf(i)));
        hw.pr(new com.byazt.gi.hn(downloadTask, this.pr));
    }

    @Override // com.byazt.ts.pr
    public void hw(int i) {
        com.byazt.gi.x xVar = hw;
        if (xVar == null) {
            return;
        }
        xVar.hn(i);
    }

    @Override // com.byazt.ts.pr
    public com.byazt.gi.hn hn(int i) {
        com.byazt.gi.x xVar = hw;
        if (xVar == null) {
            return null;
        }
        return xVar.hw(i);
    }

    @Override // com.byazt.ts.pr
    public List<Integer> pr() {
        return hw.pr();
    }

    @Override // com.byazt.ts.pr
    public void pr(int i, long j) {
        com.byazt.gi.x xVar = hw;
        if (xVar == null) {
            return;
        }
        xVar.pr(i, j);
    }
}
