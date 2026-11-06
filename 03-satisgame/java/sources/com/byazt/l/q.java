package com.byazt.l;

import android.util.SparseArray;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 18, 5})
public class q {
    public static ExecutorService n = new com.byazt.xis.q(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new n("Download_OP_Thread"));
    public int s = 0;
    public volatile SparseArray<s> qg = new SparseArray<>();

    public static void n(Runnable runnable) {
        n.execute(runnable);
    }

    public void n(s sVar) {
        sVar.w();
        synchronized (q.class) {
            int i = this.s;
            if (i >= 500) {
                qg();
                this.s = 0;
            } else {
                this.s = i + 1;
            }
            this.qg.put(sVar.l(), sVar);
        }
        DownloadTask downloadTaskS = sVar.s();
        try {
            ExecutorService executorServiceCy = com.byazt.xv.s.cy();
            if (downloadTaskS != null && downloadTaskS.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(downloadTaskS.getDownloadInfo().getMimeType()) && com.byazt.f.n.s().n("divide_plugin", 1) == 1) {
                    downloadTaskS.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = downloadTaskS.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    executorServiceCy = com.byazt.xv.s.sz();
                } else if (executorGroup == 4) {
                    executorServiceCy = com.byazt.xv.s.k();
                }
            }
            if (executorServiceCy != null) {
                if (com.byazt.f.n.n(sVar.l()).qg("pause_with_interrupt", false)) {
                    sVar.n(executorServiceCy.submit(sVar));
                    return;
                } else {
                    executorServiceCy.execute(sVar);
                    return;
                }
            }
            com.byazt.g.n.n(downloadTaskS.getMonitorDepend(), downloadTaskS.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), downloadTaskS.getDownloadInfo() != null ? downloadTaskS.getDownloadInfo().getStatus() : 0);
        } catch (Exception e) {
            if (downloadTaskS != null) {
                com.byazt.g.n.n(downloadTaskS.getMonitorDepend(), downloadTaskS.getDownloadInfo(), new BaseException(1003, com.byazt.ta.w.qg(e, "DownloadThreadPoolExecute")), downloadTaskS.getDownloadInfo() != null ? downloadTaskS.getDownloadInfo().getStatus() : 0);
            }
        } catch (OutOfMemoryError unused) {
            if (downloadTaskS != null) {
                com.byazt.g.n.n(downloadTaskS.getMonitorDepend(), downloadTaskS.getDownloadInfo(), new BaseException(1003, "execute OOM"), downloadTaskS.getDownloadInfo() != null ? downloadTaskS.getDownloadInfo().getStatus() : 0);
            }
        }
    }

    private void qg() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.qg.size(); i++) {
                int iKeyAt = this.qg.keyAt(i);
                if (!this.qg.get(iKeyAt).q()) {
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    Integer num = (Integer) arrayList.get(i2);
                    if (num != null) {
                        this.qg.remove(num.intValue());
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public void qg(s sVar) {
        if (sVar == null) {
            return;
        }
        synchronized (q.class) {
            if (com.byazt.ta.n.n(524288)) {
                int iIndexOfValue = this.qg.indexOfValue(sVar);
                if (iIndexOfValue >= 0) {
                    this.qg.removeAt(iIndexOfValue);
                }
            } else {
                this.qg.remove(sVar.l());
            }
        }
    }

    public boolean n(int i) {
        synchronized (q.class) {
            boolean z = false;
            if (this.qg != null && this.qg.size() > 0) {
                s sVar = this.qg.get(i);
                if (sVar != null && sVar.q()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public s qg(int i) {
        synchronized (q.class) {
            qg();
            s sVar = this.qg.get(i);
            if (sVar == null) {
                return null;
            }
            sVar.qg();
            s(sVar);
            this.qg.remove(i);
            return sVar;
        }
    }

    public void s(int i) {
        synchronized (q.class) {
            qg();
            s sVar = this.qg.get(i);
            if (sVar != null) {
                sVar.n();
                s(sVar);
                this.qg.remove(i);
            }
        }
    }

    private void s(s sVar) {
        Future futureX;
        if (sVar == null) {
            return;
        }
        try {
            ExecutorService executorServiceCy = com.byazt.xv.s.cy();
            DownloadTask downloadTaskS = sVar.s();
            if (downloadTaskS != null && downloadTaskS.getDownloadInfo() != null) {
                int executorGroup = downloadTaskS.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    executorServiceCy = com.byazt.xv.s.sz();
                } else if (executorGroup == 4) {
                    executorServiceCy = com.byazt.xv.s.k();
                }
            }
            if (executorServiceCy == null || !(executorServiceCy instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) executorServiceCy).remove(sVar);
            if (!com.byazt.f.n.n(sVar.l()).qg("pause_with_interrupt", false) || (futureX = sVar.x()) == null) {
                return;
            }
            futureX.cancel(true);
        } catch (Exception unused) {
        }
    }

    public List<Integer> n() {
        ArrayList arrayList;
        synchronized (q.class) {
            qg();
            arrayList = new ArrayList();
            for (int i = 0; i < this.qg.size(); i++) {
                s sVar = this.qg.get(this.qg.keyAt(i));
                if (sVar != null) {
                    arrayList.add(Integer.valueOf(sVar.l()));
                }
            }
        }
        return arrayList;
    }

    public void n(int i, long j) {
        this.qg.get(i);
    }
}
