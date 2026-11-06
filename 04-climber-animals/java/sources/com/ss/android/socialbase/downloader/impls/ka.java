package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public class ka extends ms {
    private static com.ss.android.socialbase.downloader.x.d xr;

    public static void ah(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService executorServiceH = com.ss.android.socialbase.downloader.downloader.ah.h();
        if (executorServiceH != null) {
            executorServiceH.invokeAll(list);
        }
    }

    public static List<Future> d(List<Runnable> list) {
        ExecutorService executorServiceH = com.ss.android.socialbase.downloader.downloader.ah.h();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(executorServiceH.submit(it.next()));
        }
        return arrayList;
    }

    public ka() {
        xr = new com.ss.android.socialbase.downloader.x.d();
    }

    public static Runnable ka(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService executorServiceH = com.ss.android.socialbase.downloader.downloader.ah.h();
                if ((executorServiceH instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) executorServiceH).getQueue()) != null && !queue.isEmpty()) {
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
                com.ss.android.socialbase.downloader.ah.ms.d("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.ms
    public boolean ms(int i) {
        DownloadInfo downloadInfoD;
        com.ss.android.socialbase.downloader.x.d dVar = xr;
        if (dVar == null || !dVar.ms(i) || (downloadInfoD = d(i)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(downloadInfoD.getStatus())) {
            return true;
        }
        xr(i);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.ms
    public void ms(com.ss.android.socialbase.downloader.x.ah ahVar) {
        com.ss.android.socialbase.downloader.x.d dVar = xr;
        if (dVar == null) {
            return;
        }
        dVar.xr(ahVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.ms
    public void ms(int i, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr("DownloadTask", "start doDownload for task : ".concat(String.valueOf(i)));
        xr.ms(new com.ss.android.socialbase.downloader.x.ah(downloadTask, this.f4688ms));
    }

    @Override // com.ss.android.socialbase.downloader.impls.ms
    public void xr(int i) {
        com.ss.android.socialbase.downloader.x.d dVar = xr;
        if (dVar == null) {
            return;
        }
        dVar.ah(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.ms
    protected com.ss.android.socialbase.downloader.x.ah ah(int i) {
        com.ss.android.socialbase.downloader.x.d dVar = xr;
        if (dVar == null) {
            return null;
        }
        return dVar.xr(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.ms
    public List<Integer> ms() {
        return xr.ms();
    }

    @Override // com.ss.android.socialbase.downloader.impls.ms
    public void ms(int i, long j) {
        com.ss.android.socialbase.downloader.x.d dVar = xr;
        if (dVar == null) {
            return;
        }
        dVar.ms(i, j);
    }
}
