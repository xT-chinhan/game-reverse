package com.byazt.i;

import com.byazt.sk.DownloadStatus;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 18})
public class l extends n {
    public static com.byazt.l.q qg;

    public static void s(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService executorServiceHd = com.byazt.xv.s.hd();
        if (executorServiceHd != null) {
            executorServiceHd.invokeAll(list);
        }
    }

    public static List<Future> q(List<Runnable> list) {
        ExecutorService executorServiceHd = com.byazt.xv.s.hd();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(executorServiceHd.submit(it.next()));
        }
        return arrayList;
    }

    public l() {
        qg = new com.byazt.l.q();
    }

    public static Runnable l(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService executorServiceHd = com.byazt.xv.s.hd();
                if ((executorServiceHd instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) executorServiceHd).getQueue()) != null && !queue.isEmpty()) {
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
                com.byazt.fe.n.q("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    @Override // com.byazt.i.n
    public boolean n(int i) {
        DownloadInfo downloadInfoQ;
        com.byazt.l.q qVar = qg;
        if (qVar == null || !qVar.n(i) || (downloadInfoQ = q(i)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(downloadInfoQ.getStatus())) {
            return true;
        }
        qg(i);
        return false;
    }

    @Override // com.byazt.i.n
    public void n(com.byazt.l.s sVar) {
        com.byazt.l.q qVar = qg;
        if (qVar == null) {
            return;
        }
        qVar.qg(sVar);
    }

    @Override // com.byazt.i.n
    public void n(int i, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.byazt.fe.n.qg("DownloadTask", "start doDownload for task : ".concat(String.valueOf(i)));
        qg.n(new com.byazt.l.s(downloadTask, this.n));
    }

    @Override // com.byazt.i.n
    public void qg(int i) {
        com.byazt.l.q qVar = qg;
        if (qVar == null) {
            return;
        }
        qVar.s(i);
    }

    @Override // com.byazt.i.n
    public com.byazt.l.s s(int i) {
        com.byazt.l.q qVar = qg;
        if (qVar == null) {
            return null;
        }
        return qVar.qg(i);
    }

    @Override // com.byazt.i.n
    public List<Integer> n() {
        return qg.n();
    }

    @Override // com.byazt.i.n
    public void n(int i, long j) {
        com.byazt.l.q qVar = qg;
        if (qVar == null) {
            return;
        }
        qVar.n(i, j);
    }
}
