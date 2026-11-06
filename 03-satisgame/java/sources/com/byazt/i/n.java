package com.byazt.i;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.je.IDownloadFileUriProvider;
import com.byazt.je.IDownloadListener;
import com.byazt.je.h;
import com.byazt.je.lh;
import com.byazt.qx.BaseException;
import com.byazt.sk.DownloadStatus;
import com.byazt.sk.EnqueueType;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 19})
public abstract class n implements com.byazt.l.fs.n {
    public final SparseArray<DownloadTask> qg = new SparseArray<>();
    public final SparseArray<DownloadTask> s = new SparseArray<>();
    public final SparseArray<DownloadTask> q = new SparseArray<>();
    public final SparseArray<DownloadTask> l = new SparseArray<>();
    public final SparseArray<DownloadTask> w = new SparseArray<>();
    public final SparseArray<SparseArray<DownloadTask>> x = new SparseArray<>();
    public final com.byazt.ta.fs<Integer, DownloadTask> fs = new com.byazt.ta.fs<>();
    public final SparseArray<Long> rv = new SparseArray<>();
    public final LinkedBlockingDeque<DownloadTask> tj = new LinkedBlockingDeque<>();
    public final com.byazt.l.fs n = new com.byazt.l.fs(Looper.getMainLooper(), this);
    public final com.byazt.xv.tj cp = com.byazt.xv.s.hu();

    public abstract List<Integer> n();

    public abstract void n(int i, long j);

    public abstract void n(int i, DownloadTask downloadTask);

    public abstract void n(com.byazt.l.s sVar);

    public abstract boolean n(int i);

    public abstract void qg(int i);

    public abstract com.byazt.l.s s(int i);

    private void qg(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.x.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.x.put(downloadTask.getDownloadId(), sparseArray);
        }
        com.byazt.fe.n.qg("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void n(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int status;
        DownloadInfo downloadInfo2;
        DownloadTask downloadTask2;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            com.byazt.g.n.n(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (com.byazt.f.n.n(downloadInfo.getId()).n("no_net_opt", 0) == 1 && !com.byazt.ta.w.s(com.byazt.xv.s.u()) && !downloadInfo.isFirstDownload()) {
            new com.byazt.xv.w(downloadTask, this.n).n(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            n(downloadInfo);
        }
        if (this.q.get(id) != null) {
            this.q.remove(id);
        }
        if (this.s.get(id) != null) {
            this.s.remove(id);
        }
        if (this.l.get(id) != null) {
            this.l.remove(id);
        }
        if (this.w.get(id) != null) {
            this.w.remove(id);
        }
        if (n(id) && !downloadInfo.canReStartAsyncTask()) {
            com.byazt.fe.n.qg("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.byazt.g.n.n(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.byazt.fe.n.qg("AbsDownloadEngine", "no downloading task :".concat(String.valueOf(id)));
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.byazt.sk.n.ASYNC_HANDLE_RESTART);
        }
        if (com.byazt.ta.n.n(32768) && (downloadTask2 = (DownloadTask) this.fs.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(downloadTask2);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask3 = this.qg.get(id);
        if (downloadTask3 == null || (downloadInfo2 = downloadTask3.getDownloadInfo()) == null) {
            status = 0;
        } else {
            status = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(status)) {
                z2 = true;
            }
        }
        com.byazt.fe.n.qg("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + status);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        qg(downloadTask);
        this.qg.put(id, downloadTask);
        this.rv.put(id, Long.valueOf(jUptimeMillis));
        n(id, downloadTask);
    }

    public synchronized void n(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            s(downloadTask);
        } else {
            n(downloadTask, true);
        }
    }

    private void s(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.tj.isEmpty()) {
                n(downloadTask, true);
                this.tj.put(downloadTask);
                return;
            }
            if (downloadInfo.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) {
                if (this.tj.getFirst().getDownloadId() == downloadTask.getDownloadId() && n(downloadTask.getDownloadId())) {
                    return;
                }
                Iterator<DownloadTask> it = this.tj.iterator();
                while (it.hasNext()) {
                    DownloadTask next = it.next();
                    if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                        it.remove();
                        break;
                    }
                }
                this.tj.put(downloadTask);
                new com.byazt.xv.w(downloadTask, this.n).n();
                return;
            }
            DownloadTask first = this.tj.getFirst();
            if (first.getDownloadId() == downloadTask.getDownloadId() && n(downloadTask.getDownloadId())) {
                return;
            }
            l(first.getDownloadId());
            n(downloadTask, true);
            if (first.getDownloadId() != downloadTask.getDownloadId()) {
                this.tj.putFirst(downloadTask);
            }
        } catch (InterruptedException unused) {
        }
    }

    public synchronized DownloadInfo q(int i) {
        DownloadInfo downloadInfoQg;
        DownloadTask downloadTask;
        downloadInfoQg = this.cp.qg(i);
        if (downloadInfoQg == null && (downloadTask = this.qg.get(i)) != null) {
            downloadInfoQg = downloadTask.getDownloadInfo();
        }
        return downloadInfoQg;
    }

    public synchronized List<DownloadInfo> n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> listN = this.cp.n(str);
        if (listN != null && !listN.isEmpty()) {
            return listN;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.qg.size();
        for (int i = 0; i < size; i++) {
            DownloadTask downloadTaskValueAt = this.qg.valueAt(i);
            if (downloadTaskValueAt != null && downloadTaskValueAt.getDownloadInfo() != null && str.equals(downloadTaskValueAt.getDownloadInfo().getUrl())) {
                arrayList.add(downloadTaskValueAt.getDownloadInfo());
            }
        }
        return arrayList;
    }

    public synchronized boolean l(int i) {
        com.byazt.fe.n.qg("AbsDownloadEngine", "pause id=".concat(String.valueOf(i)));
        DownloadInfo downloadInfoQg = this.cp.qg(i);
        if (downloadInfoQg != null && downloadInfoQg.getStatus() == 11) {
            return false;
        }
        synchronized (this.qg) {
            qg(i);
        }
        if (downloadInfoQg == null) {
            DownloadTask downloadTask = this.qg.get(i);
            if (downloadTask != null) {
                new com.byazt.xv.w(downloadTask, this.n).q();
                return true;
            }
        } else {
            n(downloadInfoQg);
            if (downloadInfoQg.getStatus() == 1) {
                DownloadTask downloadTask2 = this.qg.get(i);
                if (downloadTask2 != null) {
                    new com.byazt.xv.w(downloadTask2, this.n).q();
                    return true;
                }
            } else if (DownloadStatus.isDownloading(downloadInfoQg.getStatus())) {
                downloadInfoQg.setStatus(-2);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean n(int i, boolean z) {
        DownloadTask downloadTaskK = this.qg.get(i);
        if (downloadTaskK == null && com.byazt.ta.n.n(65536)) {
            downloadTaskK = k(i);
        }
        if (downloadTaskK != null) {
            if (!com.byazt.f.n.n(i).qg("fix_on_cancel_call_twice", true)) {
                new com.byazt.xv.w(downloadTaskK, this.n).s();
            }
            final DownloadInfo downloadInfo = downloadTaskK.getDownloadInfo();
            final SparseArray<IDownloadListener> downloadListeners = downloadTaskK.getDownloadListeners(com.byazt.sk.w.MAIN);
            final SparseArray<IDownloadListener> downloadListeners2 = downloadTaskK.getDownloadListeners(com.byazt.sk.w.NOTIFICATION);
            this.n.post(new Runnable() { // from class: com.byazt.i.n.1
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
        DownloadInfo downloadInfoQg = this.cp.qg(i);
        if (com.byazt.ta.n.n(65536)) {
            if (downloadInfoQg != null) {
                downloadInfoQg.setStatus(-4);
            }
        } else if (downloadInfoQg != null && DownloadStatus.isDownloading(downloadInfoQg.getStatus())) {
            downloadInfoQg.setStatus(-4);
        }
        qg(i, z);
        return true;
    }

    public synchronized boolean w(int i) {
        DownloadTask downloadTask = this.qg.get(i);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            n(downloadTask);
        } else {
            x(i);
        }
        return true;
    }

    public synchronized boolean x(int i) {
        DownloadTask downloadTask = this.q.get(i);
        if (downloadTask == null) {
            downloadTask = this.l.get(i);
        }
        if (downloadTask == null) {
            return false;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setDownloadFromReserveWifi(false);
        }
        n(downloadTask);
        return true;
    }

    private void n(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.byazt.sk.x.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(com.byazt.sk.x.DELAY_RETRY_NONE);
                    com.byazt.fe.n.qg("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void n(int i, h hVar) {
        DownloadTask downloadTask = this.qg.get(i);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(hVar);
        }
    }

    public synchronized lh fs(int i) {
        DownloadTask downloadTask = this.qg.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.s.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.q.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.l.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.w.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationClickCallback();
    }

    public synchronized h rv(int i) {
        DownloadTask downloadTask = this.qg.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.s.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.q.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.l.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.w.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getNotificationEventListener();
    }

    public synchronized IDownloadFileUriProvider tj(int i) {
        DownloadTask downloadTask = this.qg.get(i);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.s.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.q.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.l.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.w.get(i);
        if (downloadTask5 == null) {
            return null;
        }
        return downloadTask5.getFileUriProvider();
    }

    public synchronized boolean cp(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.l.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                n(downloadTask, false);
            }
            return true;
        }
        DownloadInfo downloadInfoQg = this.cp.qg(i);
        if (downloadInfoQg != null && downloadInfoQg.canStartRetryDelayTask()) {
            n(new DownloadTask(downloadInfoQg), false);
        }
        return false;
    }

    public synchronized boolean d(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.w.get(i);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            n(downloadTask);
        }
        return true;
    }

    public synchronized void n(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean zQg = com.byazt.ta.n.n(1048576) ? com.byazt.ta.w.qg(com.byazt.xv.s.u()) : true;
            for (int i = 0; i < this.q.size(); i++) {
                DownloadTask downloadTask = this.q.get(this.q.keyAt(i));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || zQg)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    n(downloadTask);
                }
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void qg(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            if (com.byazt.ta.w.qg(com.byazt.xv.s.u())) {
                for (int i = 0; i < this.qg.size(); i++) {
                    DownloadTask downloadTask = this.qg.get(this.qg.keyAt(i));
                    if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && qg(downloadInfo)) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        n(downloadTask);
                        downloadInfo.setDownloadFromReserveWifi(true);
                        com.byazt.xv.cd reserveWifiStatusListener = Downloader.getInstance(com.byazt.xv.s.u()).getReserveWifiStatusListener();
                        if (reserveWifiStatusListener != null) {
                            reserveWifiStatusListener.n(downloadInfo, 5, 2);
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private boolean qg(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void qg() {
        List<Integer> listN = n();
        if (listN == null) {
            return;
        }
        Iterator<Integer> it = listN.iterator();
        while (it.hasNext()) {
            l(it.next().intValue());
        }
    }

    public void qg(final int i, final boolean z) {
        DownloadInfo downloadInfoQg = this.cp.qg(i);
        if (downloadInfoQg != null) {
            n(downloadInfoQg);
        }
        this.n.post(new Runnable() { // from class: com.byazt.i.n.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.av.qg.n().w(i);
            }
        });
        com.byazt.xv.s.n(new Runnable() { // from class: com.byazt.i.n.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask downloadTaskK;
                if (n.this.s(i) == null && (downloadTaskK = n.this.k(i)) != null) {
                    DownloadInfo downloadInfo = downloadTaskK.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = downloadTaskK.getDownloadListeners(com.byazt.sk.w.SUB);
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
                n.this.q(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(int i, boolean z) {
        com.byazt.fe.n.qg("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i + " deleteTargetFile=" + z);
        try {
            DownloadInfo downloadInfoQg = this.cp.qg(i);
            if (downloadInfoQg != null) {
                if (z) {
                    com.byazt.ta.w.n(downloadInfoQg);
                } else {
                    com.byazt.ta.w.s(downloadInfoQg.getTempPath(), downloadInfoQg.getTempName());
                }
                downloadInfoQg.erase();
            }
            try {
                this.cp.w(i);
            } catch (SQLiteException unused) {
            }
            n(i, 0, -4);
            if (this.q.get(i) != null) {
                this.q.remove(i);
            }
            if (this.s.get(i) != null) {
                this.s.remove(i);
            }
            this.fs.remove(Integer.valueOf(i));
            com.byazt.f.n.qg(i);
        } catch (Throwable unused2) {
        }
    }

    public void s(final int i, final boolean z) {
        DownloadInfo downloadInfoQg = this.cp.qg(i);
        if (downloadInfoQg != null) {
            n(downloadInfoQg);
        }
        this.n.post(new Runnable() { // from class: com.byazt.i.n.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.av.qg.n().w(i);
            }
        });
        com.byazt.xv.s.n(new Runnable() { // from class: com.byazt.i.n.5
            @Override // java.lang.Runnable
            public void run() {
                n.this.s(i);
                n.this.l(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, boolean z) {
        try {
            DownloadInfo downloadInfoQg = this.cp.qg(i);
            if (downloadInfoQg != null) {
                com.byazt.ta.w.n(downloadInfoQg, z);
                downloadInfoQg.erase();
            }
            try {
                this.cp.q(i);
                this.cp.n(downloadInfoQg);
            } catch (SQLiteException unused) {
            }
            if (this.q.get(i) != null) {
                this.q.remove(i);
            }
            if (this.s.get(i) != null) {
                this.s.remove(i);
            }
            this.fs.remove(Integer.valueOf(i));
            com.byazt.f.n.qg(i);
        } catch (Throwable unused2) {
        }
    }

    public synchronized void oa(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.qg.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            n(downloadTask);
        }
    }

    public synchronized boolean sz(int i) {
        if (i != 0) {
            if (this.qg.get(i) != null || this.q.get(i) != null) {
                return true;
            }
        }
        return false;
    }

    public synchronized void n(int i, int i2, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z) {
        DownloadTask downloadTaskK = k(i);
        if (downloadTaskK == null) {
            downloadTaskK = this.fs.get(Integer.valueOf(i));
        }
        if (downloadTaskK != null) {
            downloadTaskK.removeDownloadListener(i2, iDownloadListener, wVar, z);
        }
    }

    public synchronized void qg(int i, int i2, IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z) {
        n(i, i2, iDownloadListener, wVar, z, true);
    }

    public synchronized void n(int i, int i2, final IDownloadListener iDownloadListener, com.byazt.sk.w wVar, boolean z, boolean z2) {
        DownloadInfo downloadInfoQg;
        DownloadTask downloadTaskK = k(i);
        if (downloadTaskK != null) {
            downloadTaskK.addDownloadListener(i2, iDownloadListener, wVar, z);
            final DownloadInfo downloadInfo = downloadTaskK.getDownloadInfo();
            if (z2 && downloadInfo != null && !n(i) && (wVar == com.byazt.sk.w.MAIN || wVar == com.byazt.sk.w.NOTIFICATION)) {
                if (wVar != com.byazt.sk.w.NOTIFICATION || downloadInfo.canShowNotification()) {
                    this.n.post(new Runnable() { // from class: com.byazt.i.n.6
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
        if (com.byazt.ta.n.n(32768) && (downloadInfoQg = this.cp.qg(i)) != null && downloadInfoQg.getStatus() != -3) {
            DownloadTask downloadTask = this.fs.get(Integer.valueOf(i));
            if (downloadTask == null) {
                downloadTask = new DownloadTask(downloadInfoQg);
                this.fs.put(Integer.valueOf(i), downloadTask);
            }
            downloadTask.addDownloadListener(i2, iDownloadListener, wVar, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask k(int i) {
        DownloadTask downloadTask = this.qg.get(i);
        if (downloadTask != null) {
            return downloadTask;
        }
        DownloadTask downloadTask2 = this.q.get(i);
        if (downloadTask2 != null) {
            return downloadTask2;
        }
        DownloadTask downloadTask3 = this.s.get(i);
        if (downloadTask3 != null) {
            return downloadTask3;
        }
        DownloadTask downloadTask4 = this.l.get(i);
        return downloadTask4 == null ? this.w.get(i) : downloadTask4;
    }

    public List<DownloadInfo> qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Integer> it = n().iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            DownloadInfo downloadInfoQ = q(it.next().intValue());
            if (downloadInfoQ != null && str.equals(downloadInfoQ.getMimeType())) {
                arrayList.add(downloadInfoQ);
            }
        }
        return arrayList;
    }

    private void n(int i, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.byazt.sk.w.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.byazt.sk.w.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.byazt.ta.s.n(i, downloadListeners, true, downloadInfo, baseException);
            com.byazt.ta.s.n(i, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void cy(int i) {
        DownloadTask first;
        if (this.tj.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.tj.getFirst();
        if (first2 != null && first2.getDownloadId() == i) {
            this.tj.poll();
        }
        if (this.tj.isEmpty() || (first = this.tj.getFirst()) == null) {
            return;
        }
        n(first, true);
    }

    private void n(int i, int i2) {
        com.byazt.fe.n.qg("AbsDownloadEngine", "removeTask id: " + i + " listener hasCode: " + i2);
        if (i2 == 0) {
            this.qg.remove(i);
            this.x.remove(i);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.x.get(i);
        if (sparseArray != null) {
            sparseArray.remove(i2);
            com.byazt.fe.n.qg("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.qg.remove(i);
                this.x.remove(i);
                return;
            }
            return;
        }
        this.qg.remove(i);
    }

    public synchronized void n(int i, int i2, int i3) {
        try {
            if (i3 != -7) {
                if (i3 == -6) {
                    this.s.put(i, this.qg.get(i));
                    n(i, i2);
                    return;
                }
                if (i3 == -4) {
                    n(i, i2);
                } else if (i3 == -3) {
                    this.s.put(i, this.qg.get(i));
                    n(i, i2);
                } else if (i3 != -1) {
                    if (i3 != 7) {
                        if (i3 == 8) {
                            DownloadTask downloadTask = this.qg.get(i);
                            if (downloadTask != null && this.w.get(i) == null) {
                                this.w.put(i, downloadTask);
                            }
                        }
                        return;
                    }
                    DownloadTask downloadTask2 = this.qg.get(i);
                    if (downloadTask2 != null) {
                        if (this.l.get(i) == null) {
                            this.l.put(i, downloadTask2);
                        }
                        n(i, i2);
                    }
                    cy(i);
                    return;
                }
                cy(i);
                return;
            }
            DownloadTask downloadTask3 = this.qg.get(i);
            if (downloadTask3 != null) {
                if (this.q.get(i) == null) {
                    this.q.put(i, downloadTask3);
                }
                n(i, i2);
            }
            cy(i);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.byazt.l.fs.n
    public void n(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        com.byazt.fe.n.qg("AbsDownloadEngine", "handleMsg id: " + i + " listener hasCode: " + i2);
        DownloadTask downloadTask = null;
        BaseException baseException = message.obj instanceof Exception ? (BaseException) message.obj : null;
        synchronized (this) {
            try {
                if (i2 == 0) {
                    downloadTask = this.qg.get(i);
                } else {
                    SparseArray<DownloadTask> sparseArray = this.x.get(i);
                    if (sparseArray != null) {
                        downloadTask = sparseArray.get(i2);
                    }
                }
                if (downloadTask == null) {
                    return;
                }
                n(message.what, baseException, downloadTask);
                n(i, i2, message.what);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void qg(int i, long j) {
        DownloadInfo downloadInfoQg = this.cp.qg(i);
        if (downloadInfoQg != null) {
            downloadInfoQg.setThrottleNetSpeed(j);
        }
        n(i, j);
    }
}
