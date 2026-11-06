package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.of;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ms implements com.ss.android.socialbase.downloader.x.x.ms {
    private final SparseArray<DownloadTask> xr = new SparseArray<>();
    private final SparseArray<DownloadTask> ah = new SparseArray<>();
    private final SparseArray<DownloadTask> d = new SparseArray<>();
    private final SparseArray<DownloadTask> ka = new SparseArray<>();
    private final SparseArray<DownloadTask> c = new SparseArray<>();
    private final SparseArray<SparseArray<DownloadTask>> ab = new SparseArray<>();
    private final com.ss.android.socialbase.downloader.ny.x<Integer, DownloadTask> x = new com.ss.android.socialbase.downloader.ny.x<>();
    private final SparseArray<Long> ny = new SparseArray<>();
    private final LinkedBlockingDeque<DownloadTask> ch = new LinkedBlockingDeque<>();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final com.ss.android.socialbase.downloader.x.x f4688ms = new com.ss.android.socialbase.downloader.x.x(Looper.getMainLooper(), this);
    private final com.ss.android.socialbase.downloader.downloader.ch hi = com.ss.android.socialbase.downloader.downloader.ah.w();

    protected abstract com.ss.android.socialbase.downloader.x.ah ah(int i);

    protected abstract List<Integer> ms();

    public abstract void ms(int i, long j);

    protected abstract void ms(int i, DownloadTask downloadTask);

    public abstract void ms(com.ss.android.socialbase.downloader.x.ah ahVar);

    public abstract boolean ms(int i);

    protected abstract void xr(int i);

    protected ms() {
    }

    private void xr(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.ab.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.ab.put(downloadTask.getDownloadId(), sparseArray);
        }
        com.ss.android.socialbase.downloader.ah.ms.xr("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void ms(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int status;
        DownloadInfo downloadInfo2;
        DownloadTask downloadTask2;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            com.ss.android.socialbase.downloader.d.ms.ms(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.ny.c.ah(com.ss.android.socialbase.downloader.downloader.ah.k()) && !downloadInfo.isFirstDownload()) {
            new com.ss.android.socialbase.downloader.downloader.c(downloadTask, this.f4688ms).ms(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            ms(downloadInfo);
        }
        if (this.d.get(id) != null) {
            this.d.remove(id);
        }
        if (this.ah.get(id) != null) {
            this.ah.remove(id);
        }
        if (this.ka.get(id) != null) {
            this.ka.remove(id);
        }
        if (this.c.get(id) != null) {
            this.c.remove(id);
        }
        if (ms(id) && !downloadInfo.canReStartAsyncTask()) {
            com.ss.android.socialbase.downloader.ah.ms.xr("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.ss.android.socialbase.downloader.d.ms.ms(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr("AbsDownloadEngine", "no downloading task :".concat(String.valueOf(id)));
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.ms.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.ny.ms.ms(32768) && (downloadTask2 = (DownloadTask) this.x.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(downloadTask2);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask3 = this.xr.get(id);
        if (downloadTask3 == null || (downloadInfo2 = downloadTask3.getDownloadInfo()) == null) {
            status = 0;
        } else {
            status = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(status)) {
                z2 = true;
            }
        }
        com.ss.android.socialbase.downloader.ah.ms.xr("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + status);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        xr(downloadTask);
        this.xr.put(id, downloadTask);
        this.ny.put(id, Long.valueOf(jUptimeMillis));
        ms(id, downloadTask);
    }

    public synchronized void ms(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            ah(downloadTask);
        } else {
            ms(downloadTask, true);
        }
    }

    private void ah(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.ch.isEmpty()) {
                ms(downloadTask, true);
                this.ch.put(downloadTask);
                return;
            }
            if (downloadInfo.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) {
                if (this.ch.getFirst().getDownloadId() == downloadTask.getDownloadId() && ms(downloadTask.getDownloadId())) {
                    return;
                }
                Iterator<DownloadTask> it = this.ch.iterator();
                while (it.hasNext()) {
                    DownloadTask next = it.next();
                    if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                        it.remove();
                        break;
                    }
                }
                this.ch.put(downloadTask);
                new com.ss.android.socialbase.downloader.downloader.c(downloadTask, this.f4688ms).ms();
                return;
            }
            DownloadTask first = this.ch.getFirst();
            if (first.getDownloadId() == downloadTask.getDownloadId() && ms(downloadTask.getDownloadId())) {
                return;
            }
            ka(first.getDownloadId());
            ms(downloadTask, true);
            if (first.getDownloadId() != downloadTask.getDownloadId()) {
                this.ch.putFirst(downloadTask);
            }
        } catch (InterruptedException unused) {
        }
    }

    public synchronized DownloadInfo d(int i) {
        DownloadInfo downloadInfoXr;
        DownloadTask downloadTask;
        downloadInfoXr = this.hi.xr(i);
        if (downloadInfoXr == null && (downloadTask = this.xr.get(i)) != null) {
            downloadInfoXr = downloadTask.getDownloadInfo();
        }
        return downloadInfoXr;
    }

    public synchronized List<DownloadInfo> ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> listMs = this.hi.ms(str);
        if (listMs != null && !listMs.isEmpty()) {
            return listMs;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.xr.size();
        for (int i = 0; i < size; i++) {
            DownloadTask downloadTaskValueAt = this.xr.valueAt(i);
            if (downloadTaskValueAt != null && downloadTaskValueAt.getDownloadInfo() != null && str.equals(downloadTaskValueAt.getDownloadInfo().getUrl())) {
                arrayList.add(downloadTaskValueAt.getDownloadInfo());
            }
        }
        return arrayList;
    }

    public synchronized boolean ka(int i) {
        com.ss.android.socialbase.downloader.ah.ms.xr("AbsDownloadEngine", "pause id=".concat(String.valueOf(i)));
        DownloadInfo downloadInfoXr = this.hi.xr(i);
        if (downloadInfoXr != null && downloadInfoXr.getStatus() == 11) {
            return false;
        }
        synchronized (this.xr) {
            xr(i);
        }
        if (downloadInfoXr == null) {
            DownloadTask downloadTask = this.xr.get(i);
            if (downloadTask != null) {
                new com.ss.android.socialbase.downloader.downloader.c(downloadTask, this.f4688ms).d();
                return true;
            }
        } else {
            ms(downloadInfoXr);
            if (downloadInfoXr.getStatus() == 1) {
                DownloadTask downloadTask2 = this.xr.get(i);
                if (downloadTask2 != null) {
                    new com.ss.android.socialbase.downloader.downloader.c(downloadTask2, this.f4688ms).d();
                    return true;
                }
            } else if (DownloadStatus.isDownloading(downloadInfoXr.getStatus())) {
                downloadInfoXr.setStatus(-2);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean ms(int i, boolean z) {
        DownloadTask downloadTaskUb = this.xr.get(i);
        if (downloadTaskUb == null && com.ss.android.socialbase.downloader.ny.ms.ms(65536)) {
            downloadTaskUb = ub(i);
        }
        if (downloadTaskUb != null) {
            if (!com.ss.android.socialbase.downloader.ab.ms.ms(i).xr("fix_on_cancel_call_twice", true)) {
                new com.ss.android.socialbase.downloader.downloader.c(downloadTaskUb, this.f4688ms).ah();
            }
            final DownloadInfo downloadInfo = downloadTaskUb.getDownloadInfo();
            final SparseArray<IDownloadListener> downloadListeners = downloadTaskUb.getDownloadListeners(com.ss.android.socialbase.downloader.constants.c.MAIN);
            final SparseArray<IDownloadListener> downloadListeners2 = downloadTaskUb.getDownloadListeners(com.ss.android.socialbase.downloader.constants.c.NOTIFICATION);
            this.f4688ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ms.1
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
                    if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                        return;
                    }
                    synchronized (sparseArray) {
                        for (int i3 = 0; i3 < downloadListeners2.size(); i3++) {
                            IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i3));
                            if (iDownloadListener2 != null) {
                                iDownloadListener2.onCanceled(downloadInfo);
                            }
                        }
                    }
                }
            });
        }
        DownloadInfo downloadInfoXr = this.hi.xr(i);
        if (com.ss.android.socialbase.downloader.ny.ms.ms(65536)) {
            if (downloadInfoXr != null) {
                downloadInfoXr.setStatus(-4);
            }
        } else if (downloadInfoXr != null && DownloadStatus.isDownloading(downloadInfoXr.getStatus())) {
            downloadInfoXr.setStatus(-4);
        }
        xr(i, z);
        return true;
    }

    public synchronized boolean c(int i) {
        DownloadTask downloadTask = this.xr.get(i);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            ms(downloadTask);
        } else {
            ab(i);
        }
        return true;
    }

    public synchronized boolean ab(int i) {
        DownloadTask downloadTask = this.d.get(i);
        if (downloadTask == null) {
            downloadTask = this.ka.get(i);
        }
        if (downloadTask == null) {
            return false;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setDownloadFromReserveWifi(false);
        }
        ms(downloadTask);
        return true;
    }

    private void ms(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.ss.android.socialbase.downloader.constants.ab.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.ab.DELAY_RETRY_NONE);
                    com.ss.android.socialbase.downloader.ah.ms.xr("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        }
    }

    public synchronized void ms(int i, yu yuVar) {
        DownloadTask downloadTask = this.xr.get(i);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(yuVar);
        }
    }

    public synchronized of x(int i) {
        DownloadTask downloadTask = this.xr.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.ah.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.d.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.ka.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.c.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationClickCallback();
    }

    public synchronized yu ny(int i) {
        DownloadTask downloadTask = this.xr.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.ah.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.d.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.ka.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.c.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationEventListener();
    }

    public synchronized IDownloadFileUriProvider ch(int i) {
        DownloadTask downloadTask = this.xr.get(i);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.ah.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.d.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.ka.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.c.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getFileUriProvider();
    }

    public synchronized boolean hi(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.ka.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                ms(downloadTask, false);
            }
            return true;
        }
        DownloadInfo downloadInfoXr = this.hi.xr(i);
        if (downloadInfoXr != null && downloadInfoXr.canStartRetryDelayTask()) {
            ms(new DownloadTask(downloadInfoXr), false);
        }
        return false;
    }

    public synchronized boolean sl(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.c.get(i);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            ms(downloadTask);
        }
        return true;
    }

    public synchronized void ms(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean zXr = com.ss.android.socialbase.downloader.ny.ms.ms(1048576) ? com.ss.android.socialbase.downloader.ny.c.xr(com.ss.android.socialbase.downloader.downloader.ah.k()) : true;
            for (int i = 0; i < this.d.size(); i++) {
                DownloadTask downloadTask = this.d.get(this.d.keyAt(i));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || zXr)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    ms(downloadTask);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    public synchronized void xr(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            if (com.ss.android.socialbase.downloader.ny.c.xr(com.ss.android.socialbase.downloader.downloader.ah.k())) {
                for (int i = 0; i < this.xr.size(); i++) {
                    DownloadTask downloadTask = this.xr.get(this.xr.keyAt(i));
                    if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && xr(downloadInfo)) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        ms(downloadTask);
                        downloadInfo.setDownloadFromReserveWifi(true);
                        com.ss.android.socialbase.downloader.downloader.qv reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).getReserveWifiStatusListener();
                        if (reserveWifiStatusListener != null) {
                            reserveWifiStatusListener.ms(downloadInfo, 5, 2);
                        } else {
                            continue;
                        }
                    }
                }
                return;
            }
            return;
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return;
        }
        throw th;
    }

    private boolean xr(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void xr() {
        List<Integer> listMs = ms();
        if (listMs == null) {
            return;
        }
        Iterator<Integer> it = listMs.iterator();
        while (it.hasNext()) {
            ka(it.next().intValue());
        }
    }

    public void xr(final int i, final boolean z) {
        DownloadInfo downloadInfoXr = this.hi.xr(i);
        if (downloadInfoXr != null) {
            ms(downloadInfoXr);
        }
        this.f4688ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ms.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.xr.ms().c(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.ah.ms(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ms.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask downloadTaskUb;
                if (ms.this.ah(i) == null && (downloadTaskUb = ms.this.ub(i)) != null) {
                    DownloadInfo downloadInfo = downloadTaskUb.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = downloadTaskUb.getDownloadListeners(com.ss.android.socialbase.downloader.constants.c.SUB);
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
                ms.this.d(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(int i, boolean z) {
        com.ss.android.socialbase.downloader.ah.ms.xr("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i + " deleteTargetFile=" + z);
        try {
            DownloadInfo downloadInfoXr = this.hi.xr(i);
            if (downloadInfoXr != null) {
                if (z) {
                    com.ss.android.socialbase.downloader.ny.c.ms(downloadInfoXr);
                } else {
                    com.ss.android.socialbase.downloader.ny.c.ah(downloadInfoXr.getTempPath(), downloadInfoXr.getTempName());
                }
                downloadInfoXr.erase();
            }
            try {
                this.hi.c(i);
            } catch (SQLiteException e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
            ms(i, 0, -4);
            if (this.d.get(i) != null) {
                this.d.remove(i);
            }
            if (this.ah.get(i) != null) {
                this.ah.remove(i);
            }
            this.x.remove(Integer.valueOf(i));
            com.ss.android.socialbase.downloader.ab.ms.xr(i);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    public void ah(final int i, final boolean z) {
        DownloadInfo downloadInfoXr = this.hi.xr(i);
        if (downloadInfoXr != null) {
            ms(downloadInfoXr);
        }
        this.f4688ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ms.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.xr.ms().c(i);
            }
        });
        com.ss.android.socialbase.downloader.downloader.ah.ms(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ms.5
            @Override // java.lang.Runnable
            public void run() {
                ms.this.ah(i);
                ms.this.ka(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka(int i, boolean z) {
        try {
            DownloadInfo downloadInfoXr = this.hi.xr(i);
            if (downloadInfoXr != null) {
                com.ss.android.socialbase.downloader.ny.c.ms(downloadInfoXr, z);
                downloadInfoXr.erase();
            }
            try {
                this.hi.d(i);
                this.hi.ms(downloadInfoXr);
            } catch (SQLiteException e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
            if (this.d.get(i) != null) {
                this.d.remove(i);
            }
            if (this.ah.get(i) != null) {
                this.ah.remove(i);
            }
            this.x.remove(Integer.valueOf(i));
            com.ss.android.socialbase.downloader.ab.ms.xr(i);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    public synchronized void zb(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.xr.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            ms(downloadTask);
        }
    }

    public synchronized boolean u(int i) {
        if (i != 0) {
            if (this.xr.get(i) != null || this.d.get(i) != null) {
                return true;
            }
        }
        return false;
    }

    public synchronized void ms(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z) {
        DownloadTask downloadTaskUb = ub(i);
        if (downloadTaskUb == null) {
            downloadTaskUb = this.x.get(Integer.valueOf(i));
        }
        if (downloadTaskUb != null) {
            downloadTaskUb.removeDownloadListener(i2, iDownloadListener, cVar, z);
        }
    }

    public synchronized void xr(int i, int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z) {
        ms(i, i2, iDownloadListener, cVar, z, true);
    }

    public synchronized void ms(int i, int i2, final IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.c cVar, boolean z, boolean z2) {
        DownloadInfo downloadInfoXr;
        DownloadTask downloadTaskUb = ub(i);
        if (downloadTaskUb != null) {
            downloadTaskUb.addDownloadListener(i2, iDownloadListener, cVar, z);
            final DownloadInfo downloadInfo = downloadTaskUb.getDownloadInfo();
            if (z2 && downloadInfo != null && !ms(i) && (cVar == com.ss.android.socialbase.downloader.constants.c.MAIN || cVar == com.ss.android.socialbase.downloader.constants.c.NOTIFICATION)) {
                if (cVar != com.ss.android.socialbase.downloader.constants.c.NOTIFICATION || downloadInfo.canShowNotification()) {
                    this.f4688ms.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ms.6
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
        if (com.ss.android.socialbase.downloader.ny.ms.ms(32768) && (downloadInfoXr = this.hi.xr(i)) != null && downloadInfoXr.getStatus() != -3) {
            DownloadTask downloadTask = this.x.get(Integer.valueOf(i));
            if (downloadTask == null) {
                downloadTask = new DownloadTask(downloadInfoXr);
                this.x.put(Integer.valueOf(i), downloadTask);
            }
            downloadTask.addDownloadListener(i2, iDownloadListener, cVar, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask ub(int i) {
        DownloadTask downloadTask = this.xr.get(i);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = this.d.get(i);
        if (downloadTask2 != null) {
            return downloadTask2;
        }
        DownloadTask downloadTask3 = this.ah.get(i);
        if (downloadTask3 != null) {
            return downloadTask3;
        }
        DownloadTask downloadTask4 = this.ka.get(i);
        return downloadTask4 == null ? this.c.get(i) : downloadTask4;
    }

    public List<DownloadInfo> xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = ms().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            DownloadInfo downloadInfoD = d(it.next().intValue());
            if (downloadInfoD != null && str.equals(downloadInfoD.getMimeType())) {
                arrayList.add(downloadInfoD);
            }
        }
        return arrayList;
    }

    private void ms(int i, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.c.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.c.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.ss.android.socialbase.downloader.ny.ah.ms(i, downloadListeners, true, downloadInfo, baseException);
            com.ss.android.socialbase.downloader.ny.ah.ms(i, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void ao(int i) {
        DownloadTask first;
        if (this.ch.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.ch.getFirst();
        if (first2 != null && first2.getDownloadId() == i) {
            this.ch.poll();
        }
        if (this.ch.isEmpty() || (first = this.ch.getFirst()) == null) {
            return;
        }
        ms(first, true);
    }

    private void ms(int i, int i2) {
        com.ss.android.socialbase.downloader.ah.ms.xr("AbsDownloadEngine", "removeTask id: " + i + " listener hasCode: " + i2);
        if (i2 == 0) {
            this.xr.remove(i);
            this.ab.remove(i);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.ab.get(i);
        if (sparseArray != null) {
            sparseArray.remove(i2);
            com.ss.android.socialbase.downloader.ah.ms.xr("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.xr.remove(i);
                this.ab.remove(i);
                return;
            }
            return;
        }
        this.xr.remove(i);
    }

    public synchronized void ms(int i, int i2, int i3) {
        try {
            if (i3 != -7) {
                if (i3 == -6) {
                    this.ah.put(i, this.xr.get(i));
                    ms(i, i2);
                    return;
                }
                if (i3 == -4) {
                    ms(i, i2);
                } else if (i3 == -3) {
                    this.ah.put(i, this.xr.get(i));
                    ms(i, i2);
                } else if (i3 != -1) {
                    if (i3 != 7) {
                        if (i3 == 8) {
                            DownloadTask downloadTask = this.xr.get(i);
                            if (downloadTask != null && this.c.get(i) == null) {
                                this.c.put(i, downloadTask);
                            }
                        }
                        return;
                    }
                    DownloadTask downloadTask2 = this.xr.get(i);
                    if (downloadTask2 != null) {
                        if (this.ka.get(i) == null) {
                            this.ka.put(i, downloadTask2);
                        }
                        ms(i, i2);
                    }
                    ao(i);
                    return;
                }
                ao(i);
                return;
            }
            DownloadTask downloadTask3 = this.xr.get(i);
            if (downloadTask3 != null) {
                if (this.d.get(i) == null) {
                    this.d.put(i, downloadTask3);
                }
                ms(i, i2);
            }
            ao(i);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.ss.android.socialbase.downloader.x.x.ms
    public void ms(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        com.ss.android.socialbase.downloader.ah.ms.xr("AbsDownloadEngine", "handleMsg id: " + i + " listener hasCode: " + i2);
        DownloadTask downloadTask = null;
        BaseException baseException = message.obj instanceof Exception ? (BaseException) message.obj : null;
        synchronized (this) {
            try {
                if (i2 == 0) {
                    downloadTask = this.xr.get(i);
                } else {
                    SparseArray<DownloadTask> sparseArray = this.ab.get(i);
                    if (sparseArray != null) {
                        downloadTask = sparseArray.get(i2);
                    }
                }
                if (downloadTask == null) {
                    return;
                }
                ms(message.what, baseException, downloadTask);
                ms(i, i2, message.what);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void xr(int i, long j) {
        DownloadInfo downloadInfoXr = this.hi.xr(i);
        if (downloadInfoXr != null) {
            downloadInfoXr.setThrottleNetSpeed(j);
        }
        ms(i, j);
    }
}
