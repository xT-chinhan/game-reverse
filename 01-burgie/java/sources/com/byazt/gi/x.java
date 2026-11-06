package com.byazt.gi;

import android.util.SparseArray;
import com.byazt.auw.DownloadTask;
import com.byazt.lhc.BaseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 587, 121})
public class x {
    public static ExecutorService pr = new com.byazt.fr.x(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new pr("Download_OP_Thread"));
    public int hn = 0;
    public volatile SparseArray<hn> hw = new SparseArray<>();

    public static void pr(Runnable runnable) {
        pr.execute(runnable);
    }

    public void pr(hn hnVar) {
        hnVar.uc();
        synchronized (x.class) {
            int i = this.hn;
            if (i >= 500) {
                hw();
                this.hn = 0;
            } else {
                this.hn = i + 1;
            }
            this.hw.put(hnVar.c(), hnVar);
        }
        DownloadTask downloadTaskHn = hnVar.hn();
        try {
            ExecutorService executorServiceNt = com.byazt.lj.hn.nt();
            if (downloadTaskHn != null && downloadTaskHn.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(downloadTaskHn.getDownloadInfo().getMimeType()) && com.byazt.ew.pr.hn().pr("divide_plugin", 1) == 1) {
                    downloadTaskHn.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                switch (downloadTaskHn.getDownloadInfo().getExecutorGroup()) {
                    case 3:
                        executorServiceNt = com.byazt.lj.hn.g();
                        break;
                    case 4:
                        executorServiceNt = com.byazt.lj.hn.ho();
                        break;
                }
            }
            if (executorServiceNt == null) {
                com.byazt.cha.pr.pr(downloadTaskHn.getMonitorDepend(), downloadTaskHn.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), downloadTaskHn.getDownloadInfo() != null ? downloadTaskHn.getDownloadInfo().getStatus() : 0);
            } else if (com.byazt.ew.pr.pr(hnVar.c()).hw("pause_with_interrupt", false)) {
                hnVar.pr(executorServiceNt.submit(hnVar));
            } else {
                executorServiceNt.execute(hnVar);
            }
        } catch (Exception e) {
            if (downloadTaskHn != null) {
                com.byazt.cha.pr.pr(downloadTaskHn.getMonitorDepend(), downloadTaskHn.getDownloadInfo(), new BaseException(1003, com.byazt.tuy.uc.hw(e, "DownloadThreadPoolExecute")), downloadTaskHn.getDownloadInfo() != null ? downloadTaskHn.getDownloadInfo().getStatus() : 0);
            }
        } catch (OutOfMemoryError e2) {
            if (downloadTaskHn != null) {
                com.byazt.cha.pr.pr(downloadTaskHn.getMonitorDepend(), downloadTaskHn.getDownloadInfo(), new BaseException(1003, "execute OOM"), downloadTaskHn.getDownloadInfo() != null ? downloadTaskHn.getDownloadInfo().getStatus() : 0);
            }
        }
    }

    private void hw() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.hw.size(); i++) {
                int iKeyAt = this.hw.keyAt(i);
                if (!this.hw.get(iKeyAt).x()) {
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    Integer num = (Integer) arrayList.get(i2);
                    if (num != null) {
                        this.hw.remove(num.intValue());
                    }
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
    }

    public void hw(hn hnVar) {
        if (hnVar == null) {
            return;
        }
        synchronized (x.class) {
            try {
                if (com.byazt.tuy.pr.pr(524288)) {
                    int iIndexOfValue = this.hw.indexOfValue(hnVar);
                    if (iIndexOfValue >= 0) {
                        this.hw.removeAt(iIndexOfValue);
                    }
                } else {
                    this.hw.remove(hnVar.c());
                }
            } catch (Throwable th) {
            }
        }
    }

    public boolean pr(int i) {
        synchronized (x.class) {
            boolean z = false;
            if (this.hw != null && this.hw.size() > 0) {
                hn hnVar = this.hw.get(i);
                if (hnVar != null && hnVar.x()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public hn hw(int i) {
        synchronized (x.class) {
            hw();
            hn hnVar = this.hw.get(i);
            if (hnVar != null) {
                hnVar.hw();
                hn(hnVar);
                this.hw.remove(i);
                return hnVar;
            }
            return null;
        }
    }

    public void hn(int i) {
        synchronized (x.class) {
            hw();
            hn hnVar = this.hw.get(i);
            if (hnVar != null) {
                hnVar.pr();
                hn(hnVar);
                this.hw.remove(i);
            }
        }
    }

    private void hn(hn hnVar) {
        Future futureFw;
        if (hnVar == null) {
            return;
        }
        try {
            ExecutorService executorServiceNt = com.byazt.lj.hn.nt();
            DownloadTask downloadTaskHn = hnVar.hn();
            if (downloadTaskHn != null && downloadTaskHn.getDownloadInfo() != null) {
                switch (downloadTaskHn.getDownloadInfo().getExecutorGroup()) {
                    case 3:
                        executorServiceNt = com.byazt.lj.hn.g();
                        break;
                    case 4:
                        executorServiceNt = com.byazt.lj.hn.ho();
                        break;
                }
            }
            if (executorServiceNt != null && (executorServiceNt instanceof ThreadPoolExecutor)) {
                ((ThreadPoolExecutor) executorServiceNt).remove(hnVar);
                if (com.byazt.ew.pr.pr(hnVar.c()).hw("pause_with_interrupt", false) && (futureFw = hnVar.fw()) != null) {
                    futureFw.cancel(true);
                }
            }
        } catch (Exception e) {
        }
    }

    public List<Integer> pr() {
        ArrayList arrayList;
        synchronized (x.class) {
            hw();
            arrayList = new ArrayList();
            for (int i = 0; i < this.hw.size(); i++) {
                hn hnVar = this.hw.get(this.hw.keyAt(i));
                if (hnVar != null) {
                    arrayList.add(Integer.valueOf(hnVar.c()));
                }
            }
        }
        return arrayList;
    }

    public void pr(int i, long j) {
        this.hw.get(i);
    }
}
