package com.ss.android.socialbase.downloader.model;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.c;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.of;
import com.ss.android.socialbase.downloader.depend.qv;
import com.ss.android.socialbase.downloader.depend.re;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.depend.zb;
import com.ss.android.socialbase.downloader.downloader.ab;
import com.ss.android.socialbase.downloader.downloader.ao;
import com.ss.android.socialbase.downloader.downloader.x;
import com.ss.android.socialbase.downloader.downloader.y;
import com.ss.android.socialbase.downloader.exception.BaseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadTask {
    private boolean autoSetHashCodeForSameTask;
    private ab chunkAdjustCalculator;
    private x chunkStrategy;
    private u depend;
    private qv diskSpaceHandler;
    private final List<zb> downloadCompleteHandlers;
    private DownloadInfo downloadInfo;
    private DownloadInfo.ms downloadInfoBuilder;
    private IDownloadFileUriProvider fileUriProvider;
    private re forbiddenHandler;
    private int hashCodeForSameTask;
    private IDownloadInterceptor interceptor;
    private final SparseArray<IDownloadListener> mainThreadListeners;
    private i monitorDepend;
    private boolean needDelayForCacheSync;
    private of notificationClickCallback;
    private yu notificationEventListener;
    private final SparseArray<IDownloadListener> notificationListeners;
    private y retryDelayTimeCalculator;
    private final SparseArray<c> singleListenerHashCodeMap;
    private final Map<c, IDownloadListener> singleListenerMap;
    private final SparseArray<IDownloadListener> subThreadListeners;

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
        this.downloadInfoBuilder = new DownloadInfo.ms();
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

    public u getDepend() {
        return this.depend;
    }

    public i getMonitorDepend() {
        return this.monitorDepend;
    }

    public x getChunkStrategy() {
        return this.chunkStrategy;
    }

    public y getRetryDelayTimeCalculator() {
        return this.retryDelayTimeCalculator;
    }

    public re getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public qv getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public yu getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public of getNotificationClickCallback() {
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

    public DownloadTask chunkStategy(x xVar) {
        this.chunkStrategy = xVar;
        return this;
    }

    public DownloadTask chunkAdjustCalculator(ab abVar) {
        this.chunkAdjustCalculator = abVar;
        return this;
    }

    public DownloadTask retryDelayTimeCalculator(y yVar) {
        this.retryDelayTimeCalculator = yVar;
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
            this.singleListenerMap.put(c.MAIN, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, c.MAIN);
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
            this.singleListenerMap.put(c.SUB, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, c.SUB);
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
            this.singleListenerMap.put(c.NOTIFICATION, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, c.NOTIFICATION);
            }
        }
        return this;
    }

    public DownloadTask notificationEventListener(yu yuVar) {
        this.notificationEventListener = yuVar;
        return this;
    }

    public DownloadTask interceptor(IDownloadInterceptor iDownloadInterceptor) {
        this.interceptor = iDownloadInterceptor;
        return this;
    }

    public DownloadTask depend(u uVar) {
        this.depend = uVar;
        return this;
    }

    public DownloadTask monitorDepend(i iVar) {
        this.monitorDepend = iVar;
        return this;
    }

    public DownloadTask notificationClickCallback(of ofVar) {
        this.notificationClickCallback = ofVar;
        return this;
    }

    public DownloadTask forbiddenHandler(re reVar) {
        this.forbiddenHandler = reVar;
        return this;
    }

    public DownloadTask diskSpaceHandler(qv qvVar) {
        this.diskSpaceHandler = qvVar;
        return this;
    }

    public DownloadTask name(String str) {
        this.downloadInfoBuilder.ms(str);
        return this;
    }

    public DownloadTask title(String str) {
        this.downloadInfoBuilder.xr(str);
        return this;
    }

    public DownloadTask url(String str) {
        this.downloadInfoBuilder.ah(str);
        return this;
    }

    public DownloadTask savePath(String str) {
        this.downloadInfoBuilder.ka(str);
        return this;
    }

    public DownloadTask tempPath(String str) {
        this.downloadInfoBuilder.c(str);
        return this;
    }

    public DownloadTask extra(String str) {
        this.downloadInfoBuilder.ab(str);
        return this;
    }

    public DownloadTask onlyWifi(boolean z) {
        this.downloadInfoBuilder.ms(z);
        return this;
    }

    public DownloadTask extraHeaders(List<ah> list) {
        this.downloadInfoBuilder.ms(list);
        return this;
    }

    public DownloadTask maxBytes(int i) {
        this.downloadInfoBuilder.ms(i);
        return this;
    }

    public DownloadTask outIp(String[] strArr) {
        this.downloadInfoBuilder.ms(strArr);
        return this;
    }

    public DownloadTask outSize(int[] iArr) {
        this.downloadInfoBuilder.ms(iArr);
        return this;
    }

    public DownloadTask retryCount(int i) {
        this.downloadInfoBuilder.xr(i);
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int i) {
        this.downloadInfoBuilder.ah(i);
        return this;
    }

    public DownloadTask force(boolean z) {
        this.downloadInfoBuilder.xr(z);
        return this;
    }

    public DownloadTask needPostProgress(boolean z) {
        this.downloadInfoBuilder.ah(z);
        return this;
    }

    public DownloadTask maxProgressCount(int i) {
        this.downloadInfoBuilder.d(i);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int i) {
        this.downloadInfoBuilder.ka(i);
        return this;
    }

    public DownloadTask backUpUrls(List<String> list) {
        this.downloadInfoBuilder.xr(list);
        return this;
    }

    public DownloadTask mimeType(String str) {
        this.downloadInfoBuilder.x(str);
        return this;
    }

    public DownloadTask showNotification(boolean z) {
        this.downloadInfoBuilder.ka(z);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean z) {
        this.downloadInfoBuilder.d(z);
        return this;
    }

    public DownloadTask autoResumed(boolean z) {
        this.downloadInfoBuilder.c(z);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean z) {
        this.downloadInfoBuilder.ab(z);
        return this;
    }

    public DownloadTask packageName(String str) {
        this.downloadInfoBuilder.ny(str);
        return this;
    }

    public DownloadTask md5(String str) {
        this.downloadInfoBuilder.ch(str);
        return this;
    }

    public DownloadTask expectFileLength(long j) {
        this.downloadInfoBuilder.ms(j);
        return this;
    }

    public DownloadTask needRetryDelay(boolean z) {
        this.downloadInfoBuilder.ch(z);
        return this;
    }

    public DownloadTask retryDelayTimeArray(String str) {
        this.downloadInfoBuilder.hi(str);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean z) {
        this.downloadInfoBuilder.x(z);
        return this;
    }

    public DownloadTask needReuseFirstConnection(boolean z) {
        this.downloadInfoBuilder.hi(z);
        return this;
    }

    public DownloadTask needChunkDowngradeRetry(boolean z) {
        this.downloadInfoBuilder.ub(z);
        return this;
    }

    public DownloadTask needReuseChunkRunnable(boolean z) {
        this.downloadInfoBuilder.ny(z);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean z) {
        this.downloadInfoBuilder.sl(z);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType enqueueType) {
        this.downloadInfoBuilder.ms(enqueueType);
        return this;
    }

    public DownloadTask headConnectionAvailable(boolean z) {
        this.downloadInfoBuilder.zb(z);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean z) {
        this.downloadInfoBuilder.u(z);
        return this;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public DownloadTask addListenerToSameTask(boolean z) {
        this.downloadInfoBuilder.ao(z);
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
        this.downloadInfoBuilder.ms(jSONObject);
        return this;
    }

    public DownloadTask iconUrl(String str) {
        this.downloadInfoBuilder.zb(str);
        return this;
    }

    public DownloadTask taskKey(String str) {
        this.downloadInfoBuilder.d(str);
        return this;
    }

    public DownloadTask executorGroup(int i) {
        this.downloadInfoBuilder.c(i);
        return this;
    }

    public DownloadTask throttleNetSpeed(long j) {
        this.downloadInfoBuilder.xr(j);
        return this;
    }

    public DownloadTask isOpenLimitSpeed(boolean z) {
        this.downloadInfoBuilder.qv(z);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean z) {
        this.downloadInfoBuilder.h(z);
        return this;
    }

    public DownloadTask monitorScene(String str) {
        this.downloadInfoBuilder.sl(str);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] iArr) {
        this.downloadInfoBuilder.xr(iArr);
        return this;
    }

    public DownloadTask expiredRedownload(boolean z) {
        this.downloadInfoBuilder.y(z);
        return this;
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean z) {
        this.downloadInfoBuilder.t(z);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long j) {
        this.downloadInfoBuilder.ah(j);
        return this;
    }

    public DownloadTask distinctDirectory(boolean z) {
        this.downloadInfoBuilder.nw(z);
        return this;
    }

    public DownloadTask setAutoInstall(boolean z) {
        this.downloadInfoBuilder.b(z);
        return this;
    }

    public int download() {
        this.downloadInfo = this.downloadInfoBuilder.ms();
        DownloadInfo downloadInfoXr = com.ss.android.socialbase.downloader.downloader.ah.w().xr(this.downloadInfo.getId());
        if (downloadInfoXr == null) {
            this.downloadInfo.generateTaskId();
            com.ss.android.socialbase.downloader.d.ms.ms(this, (BaseException) null, 0);
        } else {
            this.downloadInfo.copyTaskIdFromCacheData(downloadInfoXr);
        }
        setChunkCalculator();
        com.ss.android.socialbase.downloader.downloader.d.ms().ms(this);
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public void asyncDownload(final ao aoVar) {
        com.ss.android.socialbase.downloader.x.d.ms(new Runnable() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.1
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
        com.ss.android.socialbase.downloader.ah.ms.xr("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
            this.downloadInfo.setAddListenerToSameTask(true);
        }
        addListenerToDownloadingSameTask(c.MAIN);
        addListenerToDownloadingSameTask(c.SUB);
        com.ss.android.socialbase.downloader.d.ms.ms(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    private void addListenerToDownloadingSameTask(c cVar) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(cVar);
        synchronized (downloadListeners) {
            for (int i = 0; i < downloadListeners.size(); i++) {
                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i));
                if (iDownloadListener != null) {
                    com.ss.android.socialbase.downloader.downloader.d.ms().xr(getDownloadId(), iDownloadListener, cVar, false);
                }
            }
        }
    }

    public SparseArray<IDownloadListener> getDownloadListeners(c cVar) {
        if (cVar == c.MAIN) {
            return this.mainThreadListeners;
        }
        if (cVar == c.SUB) {
            return this.subThreadListeners;
        }
        if (cVar == c.NOTIFICATION) {
            return this.notificationListeners;
        }
        return null;
    }

    public int getDownloadListenerSize(c cVar) {
        int size;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(cVar);
        if (downloadListeners == null) {
            return 0;
        }
        synchronized (downloadListeners) {
            size = downloadListeners.size();
        }
        return size;
    }

    public IDownloadListener getDownloadListenerByIndex(c cVar, int i) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(cVar);
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
        IDownloadListener singleDownloadListener = getSingleDownloadListener(c.MAIN);
        if (singleDownloadListener == null) {
            singleDownloadListener = getSingleDownloadListener(c.SUB);
        }
        if (singleDownloadListener != null) {
            this.hashCodeForSameTask = singleDownloadListener.hashCode();
        }
        return this.hashCodeForSameTask;
    }

    public IDownloadListener getSingleDownloadListener(c cVar) {
        return this.singleListenerMap.get(cVar);
    }

    public void removeDownloadListener(int i, IDownloadListener iDownloadListener, c cVar, boolean z) {
        int iIndexOfValue;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(cVar);
        if (downloadListeners == null) {
            if (z && this.singleListenerMap.containsKey(cVar)) {
                this.singleListenerMap.remove(cVar);
                return;
            }
            return;
        }
        synchronized (downloadListeners) {
            try {
                if (z) {
                    if (this.singleListenerMap.containsKey(cVar)) {
                        iDownloadListener = this.singleListenerMap.get(cVar);
                        this.singleListenerMap.remove(cVar);
                    }
                    if (iDownloadListener != null && (iIndexOfValue = downloadListeners.indexOfValue(iDownloadListener)) >= 0 && iIndexOfValue < downloadListeners.size()) {
                        downloadListeners.removeAt(iIndexOfValue);
                    }
                } else {
                    downloadListeners.remove(i);
                    synchronized (this.singleListenerHashCodeMap) {
                        c cVar2 = this.singleListenerHashCodeMap.get(i);
                        if (cVar2 != null && this.singleListenerMap.containsKey(cVar2)) {
                            this.singleListenerMap.remove(cVar2);
                            this.singleListenerHashCodeMap.remove(i);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addDownloadListener(int i, IDownloadListener iDownloadListener, c cVar, boolean z) {
        Map<c, IDownloadListener> map;
        if (iDownloadListener == null) {
            return;
        }
        if (z && (map = this.singleListenerMap) != null) {
            map.put(cVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, cVar);
            }
        }
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(cVar);
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

    public void setDownloadListeners(SparseArray<IDownloadListener> sparseArray, c cVar) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (cVar == c.MAIN) {
                synchronized (this.mainThreadListeners) {
                    copyListeners(this.mainThreadListeners, sparseArray);
                }
                return;
            } else if (cVar == c.SUB) {
                synchronized (this.subThreadListeners) {
                    copyListeners(this.subThreadListeners, sparseArray);
                }
                return;
            } else {
                if (cVar == c.NOTIFICATION) {
                    synchronized (this.notificationListeners) {
                        copyListeners(this.notificationListeners, sparseArray);
                    }
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        com.bytedance.sdk.openadsdk.api.ab.ms(th);
    }

    public void setNotificationEventListener(yu yuVar) {
        this.notificationEventListener = yuVar;
    }

    public ab getChunkAdjustCalculator() {
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
        for (Map.Entry<c, IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
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
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
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

    public List<zb> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public zb getDownloadCompleteHandlerByIndex(int i) {
        synchronized (this.downloadCompleteHandlers) {
            if (i >= this.downloadCompleteHandlers.size()) {
                return null;
            }
            return this.downloadCompleteHandlers.get(i);
        }
    }

    public DownloadTask addDownloadCompleteHandler(zb zbVar) {
        synchronized (this.downloadCompleteHandlers) {
            if (zbVar != null) {
                if (!this.downloadCompleteHandlers.contains(zbVar)) {
                    this.downloadCompleteHandlers.add(zbVar);
                    return this;
                }
            }
            return this;
        }
    }

    public DownloadTask setDownloadCompleteHandlers(List<zb> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<zb> it = list.iterator();
            while (it.hasNext()) {
                addDownloadCompleteHandler(it.next());
            }
        }
        return this;
    }

    private void setChunkCalculator() {
        if (this.downloadInfo.getThrottleNetSpeed() > 0) {
            chunkStategy(new x() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.2
                @Override // com.ss.android.socialbase.downloader.downloader.x
                public int ms(long j) {
                    return 1;
                }
            });
        }
    }
}
