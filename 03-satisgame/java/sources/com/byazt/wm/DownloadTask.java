package com.byazt.wm;

import android.util.SparseArray;
import com.byazt.je.IDownloadFileUriProvider;
import com.byazt.je.IDownloadInterceptor;
import com.byazt.je.IDownloadListener;
import com.byazt.je.cd;
import com.byazt.je.h;
import com.byazt.je.lh;
import com.byazt.je.m;
import com.byazt.je.oa;
import com.byazt.je.sz;
import com.byazt.je.wm;
import com.byazt.qx.BaseException;
import com.byazt.sk.EnqueueType;
import com.byazt.sk.w;
import com.byazt.xv.cy;
import com.byazt.xv.fs;
import com.byazt.xv.um;
import com.byazt.xv.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 1647})
public class DownloadTask {
    public boolean autoSetHashCodeForSameTask;
    public x chunkAdjustCalculator;
    public fs chunkStrategy;
    public sz depend;
    public cd diskSpaceHandler;
    public final List<oa> downloadCompleteHandlers;
    public DownloadInfo downloadInfo;
    public DownloadInfo.n downloadInfoBuilder;
    public IDownloadFileUriProvider fileUriProvider;
    public wm forbiddenHandler;
    public int hashCodeForSameTask;
    public IDownloadInterceptor interceptor;
    public final SparseArray<IDownloadListener> mainThreadListeners;
    public m monitorDepend;
    public boolean needDelayForCacheSync;
    public lh notificationClickCallback;
    public h notificationEventListener;
    public final SparseArray<IDownloadListener> notificationListeners;
    public um retryDelayTimeCalculator;
    public final SparseArray<w> singleListenerHashCodeMap;
    public final Map<w, IDownloadListener> singleListenerMap;
    public final SparseArray<IDownloadListener> subThreadListeners;

    @Deprecated
    public DownloadTask newSaveTempFileEnable(boolean z) {
        return this;
    }

    public DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public DownloadTask() {
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new SparseArray<>();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new ArrayList();
        this.autoSetHashCodeForSameTask = true;
        this.downloadInfoBuilder = new DownloadInfo.n();
        this.mainThreadListeners = new SparseArray<>();
        this.subThreadListeners = new SparseArray<>();
        this.notificationListeners = new SparseArray<>();
    }

    public DownloadTask(DownloadInfo downloadInfo) {
        this();
        this.downloadInfo = downloadInfo;
    }

    public boolean isNeedDelayForCacheSync() {
        return this.needDelayForCacheSync;
    }

    public void setNeedDelayForCacheSync(boolean z) {
        this.needDelayForCacheSync = z;
    }

    public IDownloadInterceptor getInterceptor() {
        return this.interceptor;
    }

    public sz getDepend() {
        return this.depend;
    }

    public m getMonitorDepend() {
        return this.monitorDepend;
    }

    public fs getChunkStrategy() {
        return this.chunkStrategy;
    }

    public um getRetryDelayTimeCalculator() {
        return this.retryDelayTimeCalculator;
    }

    public wm getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public cd getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public h getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public lh getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public int getHashCodeForSameTask() {
        return this.hashCodeForSameTask;
    }

    public boolean isAutoSetHashCodeForSameTask() {
        return this.autoSetHashCodeForSameTask;
    }

    public IDownloadFileUriProvider getFileUriProvider() {
        return this.fileUriProvider;
    }

    public boolean canShowNotification() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            return downloadInfo.canShowNotification();
        }
        return false;
    }

    public DownloadTask chunkStategy(fs fsVar) {
        this.chunkStrategy = fsVar;
        return this;
    }

    public DownloadTask chunkAdjustCalculator(x xVar) {
        this.chunkAdjustCalculator = xVar;
        return this;
    }

    public DownloadTask retryDelayTimeCalculator(um umVar) {
        this.retryDelayTimeCalculator = umVar;
        return this;
    }

    public DownloadTask mainThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : mainThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask mainThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.mainThreadListeners) {
                this.mainThreadListeners.put(i, iDownloadListener);
            }
            this.singleListenerMap.put(w.MAIN, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, w.MAIN);
            }
        }
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : subThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask subThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.subThreadListeners) {
                this.subThreadListeners.put(i, iDownloadListener);
            }
            this.singleListenerMap.put(w.SUB, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, w.SUB);
            }
        }
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : notificationListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask notificationListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.notificationListeners) {
                this.notificationListeners.put(i, iDownloadListener);
            }
            this.singleListenerMap.put(w.NOTIFICATION, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, w.NOTIFICATION);
            }
        }
        return this;
    }

    public DownloadTask notificationEventListener(h hVar) {
        this.notificationEventListener = hVar;
        return this;
    }

    public DownloadTask interceptor(IDownloadInterceptor iDownloadInterceptor) {
        this.interceptor = iDownloadInterceptor;
        return this;
    }

    public DownloadTask depend(sz szVar) {
        this.depend = szVar;
        return this;
    }

    public DownloadTask monitorDepend(m mVar) {
        this.monitorDepend = mVar;
        return this;
    }

    public DownloadTask notificationClickCallback(lh lhVar) {
        this.notificationClickCallback = lhVar;
        return this;
    }

    public DownloadTask forbiddenHandler(wm wmVar) {
        this.forbiddenHandler = wmVar;
        return this;
    }

    public DownloadTask diskSpaceHandler(cd cdVar) {
        this.diskSpaceHandler = cdVar;
        return this;
    }

    public DownloadTask name(String str) {
        this.downloadInfoBuilder.n(str);
        return this;
    }

    public DownloadTask title(String str) {
        this.downloadInfoBuilder.qg(str);
        return this;
    }

    public DownloadTask url(String str) {
        this.downloadInfoBuilder.s(str);
        return this;
    }

    public DownloadTask savePath(String str) {
        this.downloadInfoBuilder.l(str);
        return this;
    }

    public DownloadTask tempPath(String str) {
        this.downloadInfoBuilder.w(str);
        return this;
    }

    public DownloadTask extra(String str) {
        this.downloadInfoBuilder.x(str);
        return this;
    }

    public DownloadTask onlyWifi(boolean z) {
        this.downloadInfoBuilder.n(z);
        return this;
    }

    public DownloadTask extraHeaders(List<s> list) {
        this.downloadInfoBuilder.n(list);
        return this;
    }

    public DownloadTask maxBytes(int i) {
        this.downloadInfoBuilder.n(i);
        return this;
    }

    public DownloadTask outIp(String[] strArr) {
        this.downloadInfoBuilder.n(strArr);
        return this;
    }

    public DownloadTask outSize(int[] iArr) {
        this.downloadInfoBuilder.n(iArr);
        return this;
    }

    public DownloadTask retryCount(int i) {
        this.downloadInfoBuilder.qg(i);
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int i) {
        this.downloadInfoBuilder.s(i);
        return this;
    }

    public DownloadTask force(boolean z) {
        this.downloadInfoBuilder.qg(z);
        return this;
    }

    public DownloadTask needPostProgress(boolean z) {
        this.downloadInfoBuilder.s(z);
        return this;
    }

    public DownloadTask maxProgressCount(int i) {
        this.downloadInfoBuilder.q(i);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int i) {
        this.downloadInfoBuilder.l(i);
        return this;
    }

    public DownloadTask backUpUrls(List<String> list) {
        this.downloadInfoBuilder.qg(list);
        return this;
    }

    public DownloadTask mimeType(String str) {
        this.downloadInfoBuilder.fs(str);
        return this;
    }

    public DownloadTask showNotification(boolean z) {
        this.downloadInfoBuilder.l(z);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean z) {
        this.downloadInfoBuilder.q(z);
        return this;
    }

    public DownloadTask autoResumed(boolean z) {
        this.downloadInfoBuilder.w(z);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean z) {
        this.downloadInfoBuilder.x(z);
        return this;
    }

    public DownloadTask packageName(String str) {
        this.downloadInfoBuilder.rv(str);
        return this;
    }

    public DownloadTask md5(String str) {
        this.downloadInfoBuilder.tj(str);
        return this;
    }

    public DownloadTask expectFileLength(long j) {
        this.downloadInfoBuilder.n(j);
        return this;
    }

    public DownloadTask needRetryDelay(boolean z) {
        this.downloadInfoBuilder.tj(z);
        return this;
    }

    public DownloadTask retryDelayTimeArray(String str) {
        this.downloadInfoBuilder.cp(str);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean z) {
        this.downloadInfoBuilder.fs(z);
        return this;
    }

    public DownloadTask needReuseFirstConnection(boolean z) {
        this.downloadInfoBuilder.cp(z);
        return this;
    }

    public DownloadTask needChunkDowngradeRetry(boolean z) {
        this.downloadInfoBuilder.k(z);
        return this;
    }

    public DownloadTask needReuseChunkRunnable(boolean z) {
        this.downloadInfoBuilder.rv(z);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean z) {
        this.downloadInfoBuilder.d(z);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType enqueueType) {
        this.downloadInfoBuilder.n(enqueueType);
        return this;
    }

    public DownloadTask headConnectionAvailable(boolean z) {
        this.downloadInfoBuilder.oa(z);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean z) {
        this.downloadInfoBuilder.sz(z);
        return this;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public DownloadTask addListenerToSameTask(boolean z) {
        this.downloadInfoBuilder.cy(z);
        return this;
    }

    public DownloadTask hashCodeForSameTask(int i) {
        this.hashCodeForSameTask = i;
        return this;
    }

    public DownloadTask autoSetHashCodeForSameTask(boolean z) {
        this.autoSetHashCodeForSameTask = z;
        return this;
    }

    public DownloadTask downloadSetting(JSONObject jSONObject) {
        this.downloadInfoBuilder.n(jSONObject);
        return this;
    }

    public DownloadTask iconUrl(String str) {
        this.downloadInfoBuilder.oa(str);
        return this;
    }

    public DownloadTask taskKey(String str) {
        this.downloadInfoBuilder.q(str);
        return this;
    }

    public DownloadTask executorGroup(int i) {
        this.downloadInfoBuilder.w(i);
        return this;
    }

    public DownloadTask throttleNetSpeed(long j) {
        this.downloadInfoBuilder.qg(j);
        return this;
    }

    public DownloadTask isOpenLimitSpeed(boolean z) {
        this.downloadInfoBuilder.cd(z);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean z) {
        this.downloadInfoBuilder.hd(z);
        return this;
    }

    public DownloadTask monitorScene(String str) {
        this.downloadInfoBuilder.d(str);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] iArr) {
        this.downloadInfoBuilder.qg(iArr);
        return this;
    }

    public DownloadTask expiredRedownload(boolean z) {
        this.downloadInfoBuilder.um(z);
        return this;
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean z) {
        this.downloadInfoBuilder.a(z);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long j) {
        this.downloadInfoBuilder.s(j);
        return this;
    }

    public DownloadTask distinctDirectory(boolean z) {
        this.downloadInfoBuilder.py(z);
        return this;
    }

    public DownloadTask setAutoInstall(boolean z) {
        this.downloadInfoBuilder.ou(z);
        return this;
    }

    public int download() {
        this.downloadInfo = this.downloadInfoBuilder.n();
        DownloadInfo downloadInfoQg = com.byazt.xv.s.hu().qg(this.downloadInfo.getId());
        if (downloadInfoQg == null) {
            this.downloadInfo.generateTaskId();
            com.byazt.g.n.n(this, (BaseException) null, 0);
        } else {
            this.downloadInfo.copyTaskIdFromCacheData(downloadInfoQg);
        }
        setChunkCalculator();
        com.byazt.xv.q.n().n(this);
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public void asyncDownload(final cy cyVar) {
        com.byazt.l.q.n(new Runnable() { // from class: com.byazt.wm.DownloadTask.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask.this.download();
            }
        });
    }

    public int getDownloadId() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public void addListenerToDownloadingSameTask() {
        com.byazt.fe.n.qg("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
            this.downloadInfo.setAddListenerToSameTask(true);
        }
        addListenerToDownloadingSameTask(w.MAIN);
        addListenerToDownloadingSameTask(w.SUB);
        com.byazt.g.n.n(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    private void addListenerToDownloadingSameTask(w wVar) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(wVar);
        synchronized (downloadListeners) {
            for (int i = 0; i < downloadListeners.size(); i++) {
                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i));
                if (iDownloadListener != null) {
                    com.byazt.xv.q.n().qg(getDownloadId(), iDownloadListener, wVar, false);
                }
            }
        }
    }

    public SparseArray<IDownloadListener> getDownloadListeners(w wVar) {
        if (wVar == w.MAIN) {
            return this.mainThreadListeners;
        }
        if (wVar == w.SUB) {
            return this.subThreadListeners;
        }
        if (wVar == w.NOTIFICATION) {
            return this.notificationListeners;
        }
        return null;
    }

    public int getDownloadListenerSize(w wVar) {
        int size;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(wVar);
        if (downloadListeners == null) {
            return 0;
        }
        synchronized (downloadListeners) {
            size = downloadListeners.size();
        }
        return size;
    }

    public IDownloadListener getDownloadListenerByIndex(w wVar, int i) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(wVar);
        if (downloadListeners == null || i < 0) {
            return null;
        }
        synchronized (downloadListeners) {
            if (i >= downloadListeners.size()) {
                return null;
            }
            return downloadListeners.get(downloadListeners.keyAt(i));
        }
    }

    public synchronized int autoCalAndGetHashCodeForSameTask() {
        IDownloadListener singleDownloadListener = getSingleDownloadListener(w.MAIN);
        if (singleDownloadListener == null) {
            singleDownloadListener = getSingleDownloadListener(w.SUB);
        }
        if (singleDownloadListener != null) {
            this.hashCodeForSameTask = singleDownloadListener.hashCode();
        }
        return this.hashCodeForSameTask;
    }

    public IDownloadListener getSingleDownloadListener(w wVar) {
        return this.singleListenerMap.get(wVar);
    }

    public void removeDownloadListener(int i, IDownloadListener iDownloadListener, w wVar, boolean z) {
        int iIndexOfValue;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(wVar);
        if (downloadListeners == null) {
            if (z && this.singleListenerMap.containsKey(wVar)) {
                this.singleListenerMap.remove(wVar);
                return;
            }
            return;
        }
        synchronized (downloadListeners) {
            try {
                if (z) {
                    if (this.singleListenerMap.containsKey(wVar)) {
                        iDownloadListener = this.singleListenerMap.get(wVar);
                        this.singleListenerMap.remove(wVar);
                    }
                    if (iDownloadListener != null && (iIndexOfValue = downloadListeners.indexOfValue(iDownloadListener)) >= 0 && iIndexOfValue < downloadListeners.size()) {
                        downloadListeners.removeAt(iIndexOfValue);
                    }
                } else {
                    downloadListeners.remove(i);
                    synchronized (this.singleListenerHashCodeMap) {
                        w wVar2 = this.singleListenerHashCodeMap.get(i);
                        if (wVar2 != null && this.singleListenerMap.containsKey(wVar2)) {
                            this.singleListenerMap.remove(wVar2);
                            this.singleListenerHashCodeMap.remove(i);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addDownloadListener(int i, IDownloadListener iDownloadListener, w wVar, boolean z) {
        Map<w, IDownloadListener> map;
        if (iDownloadListener == null) {
            return;
        }
        if (z && (map = this.singleListenerMap) != null) {
            map.put(wVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, wVar);
            }
        }
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(wVar);
        if (downloadListeners == null) {
            return;
        }
        synchronized (downloadListeners) {
            downloadListeners.put(i, iDownloadListener);
        }
    }

    private void copyListeners(SparseArray<IDownloadListener> sparseArray, SparseArray<IDownloadListener> sparseArray2) {
        sparseArray.clear();
        for (int i = 0; i < sparseArray2.size(); i++) {
            int iKeyAt = sparseArray2.keyAt(i);
            IDownloadListener iDownloadListener = sparseArray2.get(iKeyAt);
            if (iDownloadListener != null) {
                sparseArray.put(iKeyAt, iDownloadListener);
            }
        }
    }

    public void setDownloadListeners(SparseArray<IDownloadListener> sparseArray, w wVar) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (wVar == w.MAIN) {
                synchronized (this.mainThreadListeners) {
                    copyListeners(this.mainThreadListeners, sparseArray);
                }
            } else if (wVar == w.SUB) {
                synchronized (this.subThreadListeners) {
                    copyListeners(this.subThreadListeners, sparseArray);
                }
            } else if (wVar == w.NOTIFICATION) {
                synchronized (this.notificationListeners) {
                    copyListeners(this.notificationListeners, sparseArray);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setNotificationEventListener(h hVar) {
        this.notificationEventListener = hVar;
    }

    public x getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public void copyInterfaceFromNewTask(DownloadTask downloadTask) {
        this.chunkAdjustCalculator = downloadTask.chunkAdjustCalculator;
        this.chunkStrategy = downloadTask.chunkStrategy;
        this.singleListenerMap.clear();
        this.singleListenerMap.putAll(downloadTask.singleListenerMap);
        synchronized (this.mainThreadListeners) {
            this.mainThreadListeners.clear();
            addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
        }
        synchronized (this.subThreadListeners) {
            this.subThreadListeners.clear();
            addAll(downloadTask.subThreadListeners, this.subThreadListeners);
        }
        synchronized (this.notificationListeners) {
            this.notificationListeners.clear();
            addAll(downloadTask.notificationListeners, this.notificationListeners);
        }
        this.notificationEventListener = downloadTask.notificationEventListener;
        this.interceptor = downloadTask.interceptor;
        this.depend = downloadTask.depend;
        this.monitorDepend = downloadTask.monitorDepend;
        this.forbiddenHandler = downloadTask.forbiddenHandler;
        this.diskSpaceHandler = downloadTask.diskSpaceHandler;
        this.retryDelayTimeCalculator = downloadTask.retryDelayTimeCalculator;
        this.notificationClickCallback = downloadTask.notificationClickCallback;
        this.fileUriProvider = downloadTask.fileUriProvider;
        synchronized (this.downloadCompleteHandlers) {
            this.downloadCompleteHandlers.clear();
            this.downloadCompleteHandlers.addAll(downloadTask.downloadCompleteHandlers);
        }
    }

    public void copyListenerFromPendingTask(DownloadTask downloadTask) {
        for (Map.Entry<w, IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
            if (entry != null && !this.singleListenerMap.containsKey(entry.getKey())) {
                this.singleListenerMap.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (downloadTask.mainThreadListeners.size() != 0) {
                synchronized (this.mainThreadListeners) {
                    removeAll(this.mainThreadListeners, downloadTask.mainThreadListeners);
                    addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
                }
            }
            if (downloadTask.subThreadListeners.size() != 0) {
                synchronized (this.subThreadListeners) {
                    removeAll(this.subThreadListeners, downloadTask.subThreadListeners);
                    addAll(downloadTask.subThreadListeners, this.subThreadListeners);
                }
            }
            if (downloadTask.notificationListeners.size() != 0) {
                synchronized (this.notificationListeners) {
                    removeAll(this.notificationListeners, downloadTask.notificationListeners);
                    addAll(downloadTask.notificationListeners, this.notificationListeners);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void addAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArray.keyAt(i);
            sparseArray2.put(iKeyAt, sparseArray.get(iKeyAt));
        }
    }

    private void removeAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.remove(sparseArray2.keyAt(i));
        }
    }

    public List<oa> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public oa getDownloadCompleteHandlerByIndex(int i) {
        synchronized (this.downloadCompleteHandlers) {
            if (i >= this.downloadCompleteHandlers.size()) {
                return null;
            }
            return this.downloadCompleteHandlers.get(i);
        }
    }

    public DownloadTask addDownloadCompleteHandler(oa oaVar) {
        synchronized (this.downloadCompleteHandlers) {
            if (oaVar != null) {
                if (!this.downloadCompleteHandlers.contains(oaVar)) {
                    this.downloadCompleteHandlers.add(oaVar);
                    return this;
                }
            }
            return this;
        }
    }

    public DownloadTask setDownloadCompleteHandlers(List<oa> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<oa> it = list.iterator();
            while (it.hasNext()) {
                addDownloadCompleteHandler(it.next());
            }
        }
        return this;
    }

    private void setChunkCalculator() {
        if (this.downloadInfo.getThrottleNetSpeed() > 0) {
            chunkStategy(new fs() { // from class: com.byazt.wm.DownloadTask.2
                @Override // com.byazt.xv.fs
                public int n(long j) {
                    return 1;
                }
            });
        }
    }
}
