package com.byazt.ts;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.fn.IDownloadFileUriProvider;
import com.byazt.fn.IDownloadListener;
import com.byazt.fn.b;
import com.byazt.fn.y;
import com.byazt.lhc.BaseException;
import com.byazt.lj.Downloader;
import com.byazt.mrs.DownloadStatus;
import com.byazt.mrs.EnqueueType;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 37})
public abstract class pr implements com.byazt.gi.zo.pr {
    public final SparseArray<DownloadTask> hw = new SparseArray<>();
    public final SparseArray<DownloadTask> hn = new SparseArray<>();
    public final SparseArray<DownloadTask> x = new SparseArray<>();
    public final SparseArray<DownloadTask> c = new SparseArray<>();
    public final SparseArray<DownloadTask> uc = new SparseArray<>();
    public final SparseArray<SparseArray<DownloadTask>> fw = new SparseArray<>();
    public final com.byazt.tuy.zo<Integer, DownloadTask> zo = new com.byazt.tuy.zo<>();
    public final SparseArray<Long> aj = new SparseArray<>();
    public final LinkedBlockingDeque<DownloadTask> vk = new LinkedBlockingDeque<>();
    public final com.byazt.gi.zo pr = new com.byazt.gi.zo(Looper.getMainLooper(), this);
    public final com.byazt.lj.vk w = com.byazt.lj.hn.z();

    public abstract com.byazt.gi.hn hn(int i);

    public abstract void hw(int i);

    public abstract List<Integer> pr();

    public abstract void pr(int i, long j);

    public abstract void pr(int i, DownloadTask downloadTask);

    public abstract void pr(com.byazt.gi.hn hnVar);

    public abstract boolean pr(int i);

    private void hw(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.fw.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.fw.put(downloadTask.getDownloadId(), sparseArray);
        }
        com.byazt.p000do.pr.hw("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void pr(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int status;
        DownloadInfo downloadInfo2;
        DownloadTask downloadTask2;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            com.byazt.cha.pr.pr(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (com.byazt.ew.pr.pr(downloadInfo.getId()).pr("no_net_opt", 0) == 1 && !com.byazt.tuy.uc.hn(com.byazt.lj.hn.of()) && !downloadInfo.isFirstDownload()) {
            new com.byazt.lj.uc(downloadTask, this.pr).pr(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            pr(downloadInfo);
        }
        if (this.x.get(id) != null) {
            this.x.remove(id);
        }
        if (this.hn.get(id) != null) {
            this.hn.remove(id);
        }
        if (this.c.get(id) != null) {
            this.c.remove(id);
        }
        if (this.uc.get(id) != null) {
            this.uc.remove(id);
        }
        if (pr(id) && !downloadInfo.canReStartAsyncTask()) {
            com.byazt.p000do.pr.hw("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.byazt.cha.pr.pr(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.byazt.p000do.pr.hw("AbsDownloadEngine", "no downloading task :".concat(String.valueOf(id)));
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.byazt.mrs.pr.ASYNC_HANDLE_RESTART);
        }
        if (com.byazt.tuy.pr.pr(32768) && (downloadTask2 = (DownloadTask) this.zo.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(downloadTask2);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask3 = this.hw.get(id);
        if (downloadTask3 != null && (downloadInfo2 = downloadTask3.getDownloadInfo()) != null) {
            status = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(status)) {
                z2 = true;
            }
        } else {
            status = 0;
        }
        com.byazt.p000do.pr.hw("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + status);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        hw(downloadTask);
        this.hw.put(id, downloadTask);
        this.aj.put(id, Long.valueOf(jUptimeMillis));
        pr(id, downloadTask);
    }

    public synchronized void pr(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            hn(downloadTask);
        } else {
            pr(downloadTask, true);
        }
    }

    private void hn(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.vk.isEmpty()) {
                pr(downloadTask, true);
                this.vk.put(downloadTask);
                return;
            }
            if (downloadInfo.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) {
                if (this.vk.getFirst().getDownloadId() == downloadTask.getDownloadId() && pr(downloadTask.getDownloadId())) {
                    return;
                }
                Iterator<DownloadTask> it = this.vk.iterator();
                while (it.hasNext()) {
                    DownloadTask next = it.next();
                    if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                        it.remove();
                        break;
                    }
                }
                this.vk.put(downloadTask);
                new com.byazt.lj.uc(downloadTask, this.pr).pr();
                return;
            }
            DownloadTask first = this.vk.getFirst();
            if (first.getDownloadId() == downloadTask.getDownloadId() && pr(downloadTask.getDownloadId())) {
                return;
            }
            c(first.getDownloadId());
            pr(downloadTask, true);
            if (first.getDownloadId() != downloadTask.getDownloadId()) {
                this.vk.putFirst(downloadTask);
            }
        } catch (InterruptedException e) {
        }
    }

    public synchronized DownloadInfo x(int i) {
        DownloadInfo downloadInfoHw;
        DownloadTask downloadTask;
        downloadInfoHw = this.w.hw(i);
        if (downloadInfoHw == null && (downloadTask = this.hw.get(i)) != null) {
            downloadInfoHw = downloadTask.getDownloadInfo();
        }
        return downloadInfoHw;
    }

    public synchronized List<DownloadInfo> pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> listPr = this.w.pr(str);
        if (listPr != null && !listPr.isEmpty()) {
            return listPr;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.hw.size();
        for (int i = 0; i < size; i++) {
            DownloadTask downloadTaskValueAt = this.hw.valueAt(i);
            if (downloadTaskValueAt != null && downloadTaskValueAt.getDownloadInfo() != null && str.equals(downloadTaskValueAt.getDownloadInfo().getUrl())) {
                arrayList.add(downloadTaskValueAt.getDownloadInfo());
            }
        }
        return arrayList;
    }

    public synchronized boolean c(int i) {
        com.byazt.p000do.pr.hw("AbsDownloadEngine", "pause id=".concat(String.valueOf(i)));
        DownloadInfo downloadInfoHw = this.w.hw(i);
        if (downloadInfoHw != null && downloadInfoHw.getStatus() == 11) {
            return false;
        }
        synchronized (this.hw) {
            hw(i);
        }
        if (downloadInfoHw == null) {
            DownloadTask downloadTask = this.hw.get(i);
            if (downloadTask != null) {
                new com.byazt.lj.uc(downloadTask, this.pr).x();
                return true;
            }
        } else {
            pr(downloadInfoHw);
            if (downloadInfoHw.getStatus() == 1) {
                DownloadTask downloadTask2 = this.hw.get(i);
                if (downloadTask2 != null) {
                    new com.byazt.lj.uc(downloadTask2, this.pr).x();
                    return true;
                }
            } else if (DownloadStatus.isDownloading(downloadInfoHw.getStatus())) {
                downloadInfoHw.setStatus(-2);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean pr(int i, boolean z) {
        DownloadTask downloadTaskHo = this.hw.get(i);
        if (downloadTaskHo == null && com.byazt.tuy.pr.pr(65536)) {
            downloadTaskHo = ho(i);
        }
        if (downloadTaskHo != null) {
            if (!com.byazt.ew.pr.pr(i).hw("fix_on_cancel_call_twice", true)) {
                new com.byazt.lj.uc(downloadTaskHo, this.pr).hn();
            }
            final DownloadInfo downloadInfo = downloadTaskHo.getDownloadInfo();
            final SparseArray<IDownloadListener> downloadListeners = downloadTaskHo.getDownloadListeners(com.byazt.mrs.uc.MAIN);
            final SparseArray<IDownloadListener> downloadListeners2 = downloadTaskHo.getDownloadListeners(com.byazt.mrs.uc.NOTIFICATION);
            this.pr.post(new Runnable() { // from class: com.byazt.ts.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    SparseArray sparseArray;
                    SparseArray sparseArray2 = downloadListeners;
                    if (sparseArray2 != null) {
                        synchronized (sparseArray2) {
                            for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                                IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i2));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                    DownloadInfo downloadInfo2 = downloadInfo;
                    if (downloadInfo2 != null && downloadInfo2.canShowNotification() && (sparseArray = downloadListeners2) != null) {
                        synchronized (sparseArray) {
                            for (int i3 = 0; i3 < downloadListeners2.size(); i3++) {
                                IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i3));
                                if (iDownloadListener2 != null) {
                                    iDownloadListener2.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                }
            });
        }
        DownloadInfo downloadInfoHw = this.w.hw(i);
        if (com.byazt.tuy.pr.pr(65536)) {
            if (downloadInfoHw != null) {
                downloadInfoHw.setStatus(-4);
            }
        } else if (downloadInfoHw != null && DownloadStatus.isDownloading(downloadInfoHw.getStatus())) {
            downloadInfoHw.setStatus(-4);
        }
        hw(i, z);
        return true;
    }

    public synchronized boolean uc(int i) {
        DownloadTask downloadTask = this.hw.get(i);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            pr(downloadTask);
        } else {
            fw(i);
        }
        return true;
    }

    public synchronized boolean fw(int i) {
        DownloadTask downloadTask = this.x.get(i);
        if (downloadTask == null) {
            downloadTask = this.c.get(i);
        }
        if (downloadTask == null) {
            return false;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setDownloadFromReserveWifi(false);
        }
        pr(downloadTask);
        return true;
    }

    private void pr(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.byazt.mrs.fw.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(com.byazt.mrs.fw.DELAY_RETRY_NONE);
                    com.byazt.p000do.pr.hw("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
            }
        }
    }

    public synchronized void pr(int i, b bVar) {
        DownloadTask downloadTask = this.hw.get(i);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(bVar);
        }
    }

    public synchronized y zo(int i) {
        DownloadTask downloadTask = this.hw.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.hn.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.x.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.c.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.uc.get(i);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationClickCallback();
        }
        return null;
    }

    public synchronized b aj(int i) {
        DownloadTask downloadTask = this.hw.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.hn.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.x.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.c.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.uc.get(i);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationEventListener();
        }
        return null;
    }

    public synchronized IDownloadFileUriProvider vk(int i) {
        DownloadTask downloadTask = this.hw.get(i);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.hn.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.x.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.c.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.uc.get(i);
        if (downloadTask5 != null) {
            return downloadTask5.getFileUriProvider();
        }
        return null;
    }

    public synchronized boolean w(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.c.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                pr(downloadTask, false);
            }
            return true;
        }
        DownloadInfo downloadInfoHw = this.w.hw(i);
        if (downloadInfoHw != null && downloadInfoHw.canStartRetryDelayTask()) {
            pr(new DownloadTask(downloadInfoHw), false);
        }
        return false;
    }

    public synchronized boolean k(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.uc.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canReStartAsyncTask()) {
                pr(downloadTask);
            }
            return true;
        }
        return false;
    }

    public synchronized void pr(List<String> list) {
        boolean zHw;
        DownloadInfo downloadInfo;
        try {
            if (com.byazt.tuy.pr.pr(1048576)) {
                zHw = com.byazt.tuy.uc.hw(com.byazt.lj.hn.of());
            } else {
                zHw = true;
            }
            for (int i = 0; i < this.x.size(); i++) {
                DownloadTask downloadTask = this.x.get(this.x.keyAt(i));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || zHw)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    pr(downloadTask);
                }
            }
        } catch (Exception e) {
        }
    }

    public synchronized void hw(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            if (com.byazt.tuy.uc.hw(com.byazt.lj.hn.of())) {
                for (int i = 0; i < this.hw.size(); i++) {
                    DownloadTask downloadTask = this.hw.get(this.hw.keyAt(i));
                    if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && hw(downloadInfo)) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        pr(downloadTask);
                        downloadInfo.setDownloadFromReserveWifi(true);
                        com.byazt.lj.lb reserveWifiStatusListener = Downloader.getInstance(com.byazt.lj.hn.of()).getReserveWifiStatusListener();
                        if (reserveWifiStatusListener != null) {
                            reserveWifiStatusListener.pr(downloadInfo, 5, 2);
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private boolean hw(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !downloadInfo.statusInPause()) {
            return false;
        }
        return downloadInfo.isPauseReserveOnWifi();
    }

    public void hw() {
        List<Integer> listPr = pr();
        if (listPr == null) {
            return;
        }
        Iterator<Integer> it = listPr.iterator();
        while (it.hasNext()) {
            c(it.next().intValue());
        }
    }

    public void hw(final int i, final boolean z) {
        DownloadInfo downloadInfoHw = this.w.hw(i);
        if (downloadInfoHw != null) {
            pr(downloadInfoHw);
        }
        this.pr.post(new Runnable() { // from class: com.byazt.ts.pr.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.lxs.hw.pr().uc(i);
            }
        });
        com.byazt.lj.hn.pr(new Runnable() { // from class: com.byazt.ts.pr.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask downloadTaskHo;
                if (pr.this.hn(i) == null && (downloadTaskHo = pr.this.ho(i)) != null) {
                    DownloadInfo downloadInfo = downloadTaskHo.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = downloadTaskHo.getDownloadListeners(com.byazt.mrs.uc.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i2));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                }
                pr.this.x(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void x(int i, boolean z) {
        com.byazt.p000do.pr.hw("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i + " deleteTargetFile=" + z);
        try {
            DownloadInfo downloadInfoHw = this.w.hw(i);
            if (downloadInfoHw != null) {
                if (z) {
                    com.byazt.tuy.uc.pr(downloadInfoHw);
                } else {
                    com.byazt.tuy.uc.hn(downloadInfoHw.getTempPath(), downloadInfoHw.getTempName());
                }
                downloadInfoHw.erase();
            }
            try {
                this.w.uc(i);
            } catch (SQLiteException e) {
            }
            pr(i, 0, -4);
            if (this.x.get(i) != null) {
                this.x.remove(i);
            }
            if (this.hn.get(i) != null) {
                this.hn.remove(i);
            }
            this.zo.remove(Integer.valueOf(i));
            com.byazt.ew.pr.hw(i);
        } catch (Throwable th) {
        }
    }

    public void hn(final int i, final boolean z) {
        DownloadInfo downloadInfoHw = this.w.hw(i);
        if (downloadInfoHw != null) {
            pr(downloadInfoHw);
        }
        this.pr.post(new Runnable() { // from class: com.byazt.ts.pr.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.lxs.hw.pr().uc(i);
            }
        });
        com.byazt.lj.hn.pr(new Runnable() { // from class: com.byazt.ts.pr.5
            @Override // java.lang.Runnable
            public void run() {
                pr.this.hn(i);
                pr.this.c(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, boolean z) {
        try {
            DownloadInfo downloadInfoHw = this.w.hw(i);
            if (downloadInfoHw != null) {
                com.byazt.tuy.uc.pr(downloadInfoHw, z);
                downloadInfoHw.erase();
            }
            try {
                this.w.x(i);
                this.w.pr(downloadInfoHw);
            } catch (SQLiteException e) {
            }
            if (this.x.get(i) != null) {
                this.x.remove(i);
            }
            if (this.hn.get(i) != null) {
                this.hn.remove(i);
            }
            this.zo.remove(Integer.valueOf(i));
            com.byazt.ew.pr.hw(i);
        } catch (Throwable th) {
        }
    }

    public synchronized void m(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.hw.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            pr(downloadTask);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0019  */
    public synchronized boolean g(int i) {
        boolean z;
        if (i == 0) {
            z = false;
        } else if (this.hw.get(i) == null && this.x.get(i) == null) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    public synchronized void pr(int i, int i2, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z) {
        DownloadTask downloadTaskHo = ho(i);
        if (downloadTaskHo == null) {
            downloadTaskHo = this.zo.get(Integer.valueOf(i));
        }
        if (downloadTaskHo != null) {
            downloadTaskHo.removeDownloadListener(i2, iDownloadListener, ucVar, z);
        }
    }

    public synchronized void hw(int i, int i2, IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z) {
        pr(i, i2, iDownloadListener, ucVar, z, true);
    }

    public synchronized void pr(int i, int i2, final IDownloadListener iDownloadListener, com.byazt.mrs.uc ucVar, boolean z, boolean z2) {
        DownloadInfo downloadInfoHw;
        DownloadTask downloadTaskHo = ho(i);
        if (downloadTaskHo != null) {
            downloadTaskHo.addDownloadListener(i2, iDownloadListener, ucVar, z);
            final DownloadInfo downloadInfo = downloadTaskHo.getDownloadInfo();
            if (z2 && downloadInfo != null && !pr(i) && (ucVar == com.byazt.mrs.uc.MAIN || ucVar == com.byazt.mrs.uc.NOTIFICATION)) {
                boolean z3 = true;
                if (ucVar == com.byazt.mrs.uc.NOTIFICATION && !downloadInfo.canShowNotification()) {
                    z3 = false;
                }
                if (z3) {
                    this.pr.post(new Runnable() { // from class: com.byazt.ts.pr.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iDownloadListener != null) {
                                if (downloadInfo.getStatus() == -3) {
                                    iDownloadListener.onSuccessed(downloadInfo);
                                } else if (downloadInfo.getStatus() == -1) {
                                    iDownloadListener.onFailed(downloadInfo, new BaseException(1000, "try add listener for failed task"));
                                }
                            }
                        }
                    });
                }
            }
            return;
        }
        if (com.byazt.tuy.pr.pr(32768) && (downloadInfoHw = this.w.hw(i)) != null && downloadInfoHw.getStatus() != -3) {
            DownloadTask downloadTask = this.zo.get(Integer.valueOf(i));
            if (downloadTask == null) {
                downloadTask = new DownloadTask(downloadInfoHw);
                this.zo.put(Integer.valueOf(i), downloadTask);
            }
            downloadTask.addDownloadListener(i2, iDownloadListener, ucVar, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask ho(int i) {
        DownloadTask downloadTask = this.hw.get(i);
        if (downloadTask == null) {
            DownloadTask downloadTask2 = this.x.get(i);
            if (downloadTask2 == null) {
                DownloadTask downloadTask3 = this.hn.get(i);
                if (downloadTask3 == null) {
                    DownloadTask downloadTask4 = this.c.get(i);
                    if (downloadTask4 == null) {
                        return this.uc.get(i);
                    }
                    return downloadTask4;
                }
                return downloadTask3;
            }
            return downloadTask2;
        }
        return downloadTask;
    }

    public List<DownloadInfo> hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = pr().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            DownloadInfo downloadInfoX = x(it.next().intValue());
            if (downloadInfoX != null && str.equals(downloadInfoX.getMimeType())) {
                arrayList.add(downloadInfoX);
            }
        }
        return arrayList;
    }

    private void pr(int i, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.byazt.mrs.uc.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.byazt.mrs.uc.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.byazt.tuy.hn.pr(i, downloadListeners, true, downloadInfo, baseException);
            com.byazt.tuy.hn.pr(i, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void nt(int i) {
        DownloadTask first;
        if (this.vk.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.vk.getFirst();
        if (first2 != null && first2.getDownloadId() == i) {
            this.vk.poll();
        }
        if (!this.vk.isEmpty() && (first = this.vk.getFirst()) != null) {
            pr(first, true);
        }
    }

    private void pr(int i, int i2) {
        com.byazt.p000do.pr.hw("AbsDownloadEngine", "removeTask id: " + i + " listener hasCode: " + i2);
        if (i2 == 0) {
            this.hw.remove(i);
            this.fw.remove(i);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.fw.get(i);
        if (sparseArray != null) {
            sparseArray.remove(i2);
            com.byazt.p000do.pr.hw("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.hw.remove(i);
                this.fw.remove(i);
                return;
            }
            return;
        }
        this.hw.remove(i);
    }

    public synchronized void pr(int i, int i2, int i3) {
        try {
            switch (i3) {
                case DownloadStatus.INTERCEPT /* -7 */:
                case -1:
                    DownloadTask downloadTask = this.hw.get(i);
                    if (downloadTask != null) {
                        if (this.x.get(i) == null) {
                            this.x.put(i, downloadTask);
                        }
                        pr(i, i2);
                    }
                    nt(i);
                    return;
                case DownloadStatus.FIRST_SUCCESS /* -6 */:
                    this.hn.put(i, this.hw.get(i));
                    pr(i, i2);
                    return;
                case -4:
                    pr(i, i2);
                    break;
                case -3:
                    this.hn.put(i, this.hw.get(i));
                    pr(i, i2);
                    break;
                case 7:
                    DownloadTask downloadTask2 = this.hw.get(i);
                    if (downloadTask2 != null) {
                        if (this.c.get(i) == null) {
                            this.c.put(i, downloadTask2);
                        }
                        pr(i, i2);
                    }
                    nt(i);
                    return;
                case 8:
                    DownloadTask downloadTask3 = this.hw.get(i);
                    if (downloadTask3 != null && this.uc.get(i) == null) {
                        this.uc.put(i, downloadTask3);
                    }
                    break;
                default:
            }
            nt(i);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.byazt.gi.zo.pr
    public void pr(Message message) {
        BaseException baseException;
        int i = message.arg1;
        int i2 = message.arg2;
        com.byazt.p000do.pr.hw("AbsDownloadEngine", "handleMsg id: " + i + " listener hasCode: " + i2);
        DownloadTask downloadTask = null;
        if (!(message.obj instanceof Exception)) {
            baseException = null;
        } else {
            baseException = (BaseException) message.obj;
        }
        synchronized (this) {
            try {
                if (i2 == 0) {
                    downloadTask = this.hw.get(i);
                } else {
                    SparseArray<DownloadTask> sparseArray = this.fw.get(i);
                    if (sparseArray != null) {
                        downloadTask = sparseArray.get(i2);
                    }
                }
                if (downloadTask == null) {
                    return;
                }
                pr(message.what, baseException, downloadTask);
                pr(i, i2, message.what);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void hw(int i, long j) {
        DownloadInfo downloadInfoHw = this.w.hw(i);
        if (downloadInfoHw != null) {
            downloadInfoHw.setThrottleNetSpeed(j);
        }
        pr(i, j);
    }
}
