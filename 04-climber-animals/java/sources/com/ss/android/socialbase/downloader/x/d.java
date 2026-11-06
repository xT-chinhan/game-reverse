package com.ss.android.socialbase.downloader.x;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static ExecutorService f4798ms = new com.bytedance.sdk.component.ch.d.d(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ms("Download_OP_Thread"));
    private int ah = 0;
    private volatile SparseArray<ah> xr = new SparseArray<>();

    public static void ms(Runnable runnable) {
        f4798ms.execute(runnable);
    }

    public void ms(ah ahVar) {
        ahVar.c();
        synchronized (d.class) {
            int i = this.ah;
            if (i >= 500) {
                xr();
                this.ah = 0;
            } else {
                this.ah = i + 1;
            }
            this.xr.put(ahVar.ka(), ahVar);
        }
        DownloadTask downloadTaskAh = ahVar.ah();
        try {
            ExecutorService executorServiceAo = com.ss.android.socialbase.downloader.downloader.ah.ao();
            if (downloadTaskAh != null && downloadTaskAh.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(downloadTaskAh.getDownloadInfo().getMimeType()) && com.ss.android.socialbase.downloader.ab.ms.ah().ms("divide_plugin", 1) == 1) {
                    downloadTaskAh.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = downloadTaskAh.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    executorServiceAo = com.ss.android.socialbase.downloader.downloader.ah.u();
                } else if (executorGroup == 4) {
                    executorServiceAo = com.ss.android.socialbase.downloader.downloader.ah.ub();
                }
            }
            if (executorServiceAo != null) {
                if (com.ss.android.socialbase.downloader.ab.ms.ms(ahVar.ka()).xr("pause_with_interrupt", false)) {
                    ahVar.ms(executorServiceAo.submit(ahVar));
                    return;
                } else {
                    executorServiceAo.execute(ahVar);
                    return;
                }
            }
            com.ss.android.socialbase.downloader.d.ms.ms(downloadTaskAh.getMonitorDepend(), downloadTaskAh.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), downloadTaskAh.getDownloadInfo() != null ? downloadTaskAh.getDownloadInfo().getStatus() : 0);
        } catch (Exception e) {
            if (downloadTaskAh != null) {
                com.ss.android.socialbase.downloader.d.ms.ms(downloadTaskAh.getMonitorDepend(), downloadTaskAh.getDownloadInfo(), new BaseException(1003, com.ss.android.socialbase.downloader.ny.c.xr(e, "DownloadThreadPoolExecute")), downloadTaskAh.getDownloadInfo() != null ? downloadTaskAh.getDownloadInfo().getStatus() : 0);
            }
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        } catch (OutOfMemoryError e2) {
            if (downloadTaskAh != null) {
                com.ss.android.socialbase.downloader.d.ms.ms(downloadTaskAh.getMonitorDepend(), downloadTaskAh.getDownloadInfo(), new BaseException(1003, "execute OOM"), downloadTaskAh.getDownloadInfo() != null ? downloadTaskAh.getDownloadInfo().getStatus() : 0);
            }
            com.bytedance.sdk.openadsdk.api.ab.ms(e2);
        }
    }

    private void xr() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.xr.size(); i++) {
                int iKeyAt = this.xr.keyAt(i);
                if (!this.xr.get(iKeyAt).d()) {
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    Integer num = (Integer) arrayList.get(i2);
                    if (num != null) {
                        this.xr.remove(num.intValue());
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th2);
        }
    }

    public void xr(ah ahVar) {
        if (ahVar == null) {
            return;
        }
        synchronized (d.class) {
            try {
                if (com.ss.android.socialbase.downloader.ny.ms.ms(524288)) {
                    int iIndexOfValue = this.xr.indexOfValue(ahVar);
                    if (iIndexOfValue >= 0) {
                        this.xr.removeAt(iIndexOfValue);
                    }
                } else {
                    this.xr.remove(ahVar.ka());
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        }
    }

    public boolean ms(int i) {
        synchronized (d.class) {
            boolean z = false;
            if (this.xr != null && this.xr.size() > 0) {
                ah ahVar = this.xr.get(i);
                if (ahVar != null && ahVar.d()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public ah xr(int i) {
        synchronized (d.class) {
            xr();
            ah ahVar = this.xr.get(i);
            if (ahVar == null) {
                return null;
            }
            ahVar.xr();
            ah(ahVar);
            this.xr.remove(i);
            return ahVar;
        }
    }

    public void ah(int i) {
        synchronized (d.class) {
            xr();
            ah ahVar = this.xr.get(i);
            if (ahVar != null) {
                ahVar.ms();
                ah(ahVar);
                this.xr.remove(i);
            }
        }
    }

    private void ah(ah ahVar) {
        Future futureAb;
        if (ahVar == null) {
            return;
        }
        try {
            ExecutorService executorServiceAo = com.ss.android.socialbase.downloader.downloader.ah.ao();
            DownloadTask downloadTaskAh = ahVar.ah();
            if (downloadTaskAh != null && downloadTaskAh.getDownloadInfo() != null) {
                int executorGroup = downloadTaskAh.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    executorServiceAo = com.ss.android.socialbase.downloader.downloader.ah.u();
                } else if (executorGroup == 4) {
                    executorServiceAo = com.ss.android.socialbase.downloader.downloader.ah.ub();
                }
            }
            if (executorServiceAo == null || !(executorServiceAo instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) executorServiceAo).remove(ahVar);
            if (!com.ss.android.socialbase.downloader.ab.ms.ms(ahVar.ka()).xr("pause_with_interrupt", false) || (futureAb = ahVar.ab()) == null) {
                return;
            }
            futureAb.cancel(true);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    public List<Integer> ms() {
        ArrayList arrayList;
        synchronized (d.class) {
            xr();
            arrayList = new ArrayList();
            for (int i = 0; i < this.xr.size(); i++) {
                ah ahVar = this.xr.get(this.xr.keyAt(i));
                if (ahVar != null) {
                    arrayList.add(Integer.valueOf(ahVar.ka()));
                }
            }
        }
        return arrayList;
    }

    public void ms(int i, long j) {
        this.xr.get(i);
    }
}
