package com.byazt.auw;

import android.util.SparseArray;
import com.byazt.fn.IDownloadFileUriProvider;
import com.byazt.fn.IDownloadInterceptor;
import com.byazt.fn.IDownloadListener;
import com.byazt.fn.b;
import com.byazt.fn.fo;
import com.byazt.fn.g;
import com.byazt.fn.lb;
import com.byazt.fn.m;
import com.byazt.fn.rc;
import com.byazt.fn.y;
import com.byazt.lhc.BaseException;
import com.byazt.lj.fw;
import com.byazt.lj.nt;
import com.byazt.lj.qa;
import com.byazt.lj.zo;
import com.byazt.mrs.EnqueueType;
import com.byazt.mrs.uc;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME, AVMDLDataLoader.KeyIsSpeedCoefficientValue})
public class DownloadTask {
    public boolean autoSetHashCodeForSameTask;
    public fw chunkAdjustCalculator;
    public zo chunkStrategy;
    public g depend;
    public lb diskSpaceHandler;
    public final List<m> downloadCompleteHandlers;
    public DownloadInfo downloadInfo;
    public DownloadInfo.pr downloadInfoBuilder;
    public IDownloadFileUriProvider fileUriProvider;
    public fo forbiddenHandler;
    public int hashCodeForSameTask;
    public IDownloadInterceptor interceptor;
    public final SparseArray<IDownloadListener> mainThreadListeners;
    public rc monitorDepend;
    public boolean needDelayForCacheSync;
    public y notificationClickCallback;
    public b notificationEventListener;
    public final SparseArray<IDownloadListener> notificationListeners;
    public qa retryDelayTimeCalculator;
    public final SparseArray<uc> singleListenerHashCodeMap;
    public final Map<uc, IDownloadListener> singleListenerMap;
    public final SparseArray<IDownloadListener> subThreadListeners;

    public DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public DownloadTask() {
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new SparseArray<>();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new ArrayList();
        this.autoSetHashCodeForSameTask = true;
        this.downloadInfoBuilder = new DownloadInfo.pr();
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

    public g getDepend() {
        return this.depend;
    }

    public rc getMonitorDepend() {
        return this.monitorDepend;
    }

    public zo getChunkStrategy() {
        return this.chunkStrategy;
    }

    public qa getRetryDelayTimeCalculator() {
        return this.retryDelayTimeCalculator;
    }

    public fo getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public lb getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public b getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public y getNotificationClickCallback() {
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

    public DownloadTask chunkStategy(zo zoVar) {
        this.chunkStrategy = zoVar;
        return this;
    }

    public DownloadTask chunkAdjustCalculator(fw fwVar) {
        this.chunkAdjustCalculator = fwVar;
        return this;
    }

    public DownloadTask retryDelayTimeCalculator(qa qaVar) {
        this.retryDelayTimeCalculator = qaVar;
        return this;
    }

    public DownloadTask mainThreadListener(IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return this;
        }
        return mainThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask mainThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.mainThreadListeners) {
                this.mainThreadListeners.put(i, iDownloadListener);
            }
            this.singleListenerMap.put(uc.MAIN, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, uc.MAIN);
            }
        }
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return this;
        }
        return subThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask subThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.subThreadListeners) {
                this.subThreadListeners.put(i, iDownloadListener);
            }
            this.singleListenerMap.put(uc.SUB, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, uc.SUB);
            }
        }
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return this;
        }
        return notificationListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask notificationListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.notificationListeners) {
                this.notificationListeners.put(i, iDownloadListener);
            }
            this.singleListenerMap.put(uc.NOTIFICATION, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, uc.NOTIFICATION);
            }
        }
        return this;
    }

    public DownloadTask notificationEventListener(b bVar) {
        this.notificationEventListener = bVar;
        return this;
    }

    public DownloadTask interceptor(IDownloadInterceptor iDownloadInterceptor) {
        this.interceptor = iDownloadInterceptor;
        return this;
    }

    public DownloadTask depend(g gVar) {
        this.depend = gVar;
        return this;
    }

    public DownloadTask monitorDepend(rc rcVar) {
        this.monitorDepend = rcVar;
        return this;
    }

    public DownloadTask notificationClickCallback(y yVar) {
        this.notificationClickCallback = yVar;
        return this;
    }

    public DownloadTask forbiddenHandler(fo foVar) {
        this.forbiddenHandler = foVar;
        return this;
    }

    public DownloadTask diskSpaceHandler(lb lbVar) {
        this.diskSpaceHandler = lbVar;
        return this;
    }

    public DownloadTask name(String str) {
        this.downloadInfoBuilder.pr(str);
        return this;
    }

    public DownloadTask title(String str) {
        this.downloadInfoBuilder.hw(str);
        return this;
    }

    public DownloadTask url(String str) {
        this.downloadInfoBuilder.hn(str);
        return this;
    }

    public DownloadTask savePath(String str) {
        this.downloadInfoBuilder.c(str);
        return this;
    }

    public DownloadTask tempPath(String str) {
        this.downloadInfoBuilder.uc(str);
        return this;
    }

    public DownloadTask extra(String str) {
        this.downloadInfoBuilder.fw(str);
        return this;
    }

    public DownloadTask onlyWifi(boolean z) {
        this.downloadInfoBuilder.pr(z);
        return this;
    }

    public DownloadTask extraHeaders(List<hn> list) {
        this.downloadInfoBuilder.pr(list);
        return this;
    }

    public DownloadTask maxBytes(int i) {
        this.downloadInfoBuilder.pr(i);
        return this;
    }

    public DownloadTask outIp(String[] strArr) {
        this.downloadInfoBuilder.pr(strArr);
        return this;
    }

    public DownloadTask outSize(int[] iArr) {
        this.downloadInfoBuilder.pr(iArr);
        return this;
    }

    public DownloadTask retryCount(int i) {
        this.downloadInfoBuilder.hw(i);
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int i) {
        this.downloadInfoBuilder.hn(i);
        return this;
    }

    public DownloadTask force(boolean z) {
        this.downloadInfoBuilder.hw(z);
        return this;
    }

    public DownloadTask needPostProgress(boolean z) {
        this.downloadInfoBuilder.hn(z);
        return this;
    }

    public DownloadTask maxProgressCount(int i) {
        this.downloadInfoBuilder.x(i);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int i) {
        this.downloadInfoBuilder.c(i);
        return this;
    }

    public DownloadTask backUpUrls(List<String> list) {
        this.downloadInfoBuilder.hw(list);
        return this;
    }

    public DownloadTask mimeType(String str) {
        this.downloadInfoBuilder.zo(str);
        return this;
    }

    public DownloadTask showNotification(boolean z) {
        this.downloadInfoBuilder.c(z);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean z) {
        this.downloadInfoBuilder.x(z);
        return this;
    }

    public DownloadTask autoResumed(boolean z) {
        this.downloadInfoBuilder.uc(z);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean z) {
        this.downloadInfoBuilder.fw(z);
        return this;
    }

    public DownloadTask packageName(String str) {
        this.downloadInfoBuilder.aj(str);
        return this;
    }

    public DownloadTask md5(String str) {
        this.downloadInfoBuilder.vk(str);
        return this;
    }

    public DownloadTask expectFileLength(long j) {
        this.downloadInfoBuilder.pr(j);
        return this;
    }

    public DownloadTask needRetryDelay(boolean z) {
        this.downloadInfoBuilder.vk(z);
        return this;
    }

    public DownloadTask retryDelayTimeArray(String str) {
        this.downloadInfoBuilder.w(str);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean z) {
        this.downloadInfoBuilder.zo(z);
        return this;
    }

    public DownloadTask needReuseFirstConnection(boolean z) {
        this.downloadInfoBuilder.w(z);
        return this;
    }

    public DownloadTask needChunkDowngradeRetry(boolean z) {
        this.downloadInfoBuilder.ho(z);
        return this;
    }

    public DownloadTask needReuseChunkRunnable(boolean z) {
        this.downloadInfoBuilder.aj(z);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean z) {
        this.downloadInfoBuilder.k(z);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType enqueueType) {
        this.downloadInfoBuilder.pr(enqueueType);
        return this;
    }

    public DownloadTask headConnectionAvailable(boolean z) {
        this.downloadInfoBuilder.m(z);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean z) {
        this.downloadInfoBuilder.g(z);
        return this;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    @Deprecated
    public DownloadTask newSaveTempFileEnable(boolean z) {
        return this;
    }

    public DownloadTask addListenerToSameTask(boolean z) {
        this.downloadInfoBuilder.nt(z);
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
        this.downloadInfoBuilder.pr(jSONObject);
        return this;
    }

    public DownloadTask iconUrl(String str) {
        this.downloadInfoBuilder.m(str);
        return this;
    }

    public DownloadTask taskKey(String str) {
        this.downloadInfoBuilder.x(str);
        return this;
    }

    public DownloadTask executorGroup(int i) {
        this.downloadInfoBuilder.uc(i);
        return this;
    }

    public DownloadTask throttleNetSpeed(long j) {
        this.downloadInfoBuilder.hw(j);
        return this;
    }

    public DownloadTask isOpenLimitSpeed(boolean z) {
        this.downloadInfoBuilder.lb(z);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean z) {
        this.downloadInfoBuilder.yb(z);
        return this;
    }

    public DownloadTask monitorScene(String str) {
        this.downloadInfoBuilder.k(str);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] iArr) {
        this.downloadInfoBuilder.hw(iArr);
        return this;
    }

    public DownloadTask expiredRedownload(boolean z) {
        this.downloadInfoBuilder.qa(z);
        return this;
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean z) {
        this.downloadInfoBuilder.a(z);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long j) {
        this.downloadInfoBuilder.hn(j);
        return this;
    }

    public DownloadTask distinctDirectory(boolean z) {
        this.downloadInfoBuilder.cz(z);
        return this;
    }

    public DownloadTask setAutoInstall(boolean z) {
        this.downloadInfoBuilder.ny(z);
        return this;
    }

    public int download() {
        this.downloadInfo = this.downloadInfoBuilder.pr();
        DownloadInfo downloadInfoHw = com.byazt.lj.hn.z().hw(this.downloadInfo.getId());
        if (downloadInfoHw == null) {
            this.downloadInfo.generateTaskId();
            com.byazt.cha.pr.pr(this, (BaseException) null, 0);
        } else {
            this.downloadInfo.copyTaskIdFromCacheData(downloadInfoHw);
        }
        setChunkCalculator();
        com.byazt.lj.x.pr().pr(this);
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public void asyncDownload(final nt ntVar) {
        com.byazt.gi.x.pr(new Runnable() { // from class: com.byazt.auw.DownloadTask.1
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
        com.byazt.p000do.pr.hw("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
            this.downloadInfo.setAddListenerToSameTask(true);
        }
        addListenerToDownloadingSameTask(uc.MAIN);
        addListenerToDownloadingSameTask(uc.SUB);
        com.byazt.cha.pr.pr(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    private void addListenerToDownloadingSameTask(uc ucVar) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(ucVar);
        synchronized (downloadListeners) {
            for (int i = 0; i < downloadListeners.size(); i++) {
                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i));
                if (iDownloadListener != null) {
                    com.byazt.lj.x.pr().hw(getDownloadId(), iDownloadListener, ucVar, false);
                }
            }
        }
    }

    public SparseArray<IDownloadListener> getDownloadListeners(uc ucVar) {
        if (ucVar == uc.MAIN) {
            return this.mainThreadListeners;
        }
        if (ucVar == uc.SUB) {
            return this.subThreadListeners;
        }
        if (ucVar == uc.NOTIFICATION) {
            return this.notificationListeners;
        }
        return null;
    }

    public int getDownloadListenerSize(uc ucVar) {
        int size;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(ucVar);
        if (downloadListeners == null) {
            return 0;
        }
        synchronized (downloadListeners) {
            size = downloadListeners.size();
        }
        return size;
    }

    public IDownloadListener getDownloadListenerByIndex(uc ucVar, int i) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(ucVar);
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
        IDownloadListener singleDownloadListener = getSingleDownloadListener(uc.MAIN);
        if (singleDownloadListener == null) {
            singleDownloadListener = getSingleDownloadListener(uc.SUB);
        }
        if (singleDownloadListener != null) {
            this.hashCodeForSameTask = singleDownloadListener.hashCode();
        }
        return this.hashCodeForSameTask;
    }

    public IDownloadListener getSingleDownloadListener(uc ucVar) {
        return this.singleListenerMap.get(ucVar);
    }

    public void removeDownloadListener(int i, IDownloadListener iDownloadListener, uc ucVar, boolean z) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(ucVar);
        if (downloadListeners == null) {
            if (z && this.singleListenerMap.containsKey(ucVar)) {
                this.singleListenerMap.remove(ucVar);
                return;
            }
            return;
        }
        synchronized (downloadListeners) {
            try {
                if (z) {
                    if (this.singleListenerMap.containsKey(ucVar)) {
                        iDownloadListener = this.singleListenerMap.get(ucVar);
                        this.singleListenerMap.remove(ucVar);
                    }
                    if (iDownloadListener != null) {
                        int iIndexOfValue = downloadListeners.indexOfValue(iDownloadListener);
                        if (iIndexOfValue >= 0 && iIndexOfValue < downloadListeners.size()) {
                            downloadListeners.removeAt(iIndexOfValue);
                        }
                    }
                } else {
                    downloadListeners.remove(i);
                    synchronized (this.singleListenerHashCodeMap) {
                        uc ucVar2 = this.singleListenerHashCodeMap.get(i);
                        if (ucVar2 != null && this.singleListenerMap.containsKey(ucVar2)) {
                            this.singleListenerMap.remove(ucVar2);
                            this.singleListenerHashCodeMap.remove(i);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addDownloadListener(int i, IDownloadListener iDownloadListener, uc ucVar, boolean z) {
        Map<uc, IDownloadListener> map;
        if (iDownloadListener == null) {
            return;
        }
        if (z && (map = this.singleListenerMap) != null) {
            map.put(ucVar, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i, ucVar);
            }
        }
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(ucVar);
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

    public void setDownloadListeners(SparseArray<IDownloadListener> sparseArray, uc ucVar) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (ucVar == uc.MAIN) {
                synchronized (this.mainThreadListeners) {
                    copyListeners(this.mainThreadListeners, sparseArray);
                }
            } else if (ucVar == uc.SUB) {
                synchronized (this.subThreadListeners) {
                    copyListeners(this.subThreadListeners, sparseArray);
                }
            } else if (ucVar == uc.NOTIFICATION) {
                synchronized (this.notificationListeners) {
                    copyListeners(this.notificationListeners, sparseArray);
                }
            }
        } catch (Throwable th) {
        }
    }

    public void setNotificationEventListener(b bVar) {
        this.notificationEventListener = bVar;
    }

    public fw getChunkAdjustCalculator() {
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
        for (Map.Entry<uc, IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
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

    public List<m> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public m getDownloadCompleteHandlerByIndex(int i) {
        synchronized (this.downloadCompleteHandlers) {
            if (i < this.downloadCompleteHandlers.size()) {
                return this.downloadCompleteHandlers.get(i);
            }
            return null;
        }
    }

    public DownloadTask addDownloadCompleteHandler(m mVar) {
        synchronized (this.downloadCompleteHandlers) {
            if (mVar != null) {
                if (!this.downloadCompleteHandlers.contains(mVar)) {
                    this.downloadCompleteHandlers.add(mVar);
                    return this;
                }
            }
            return this;
        }
    }

    public DownloadTask setDownloadCompleteHandlers(List<m> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<m> it = list.iterator();
            while (it.hasNext()) {
                addDownloadCompleteHandler(it.next());
            }
        }
        return this;
    }

    private void setChunkCalculator() {
        if (this.downloadInfo.getThrottleNetSpeed() > 0) {
            chunkStategy(new zo() { // from class: com.byazt.auw.DownloadTask.2
                @Override // com.byazt.lj.zo
                public int pr(long j) {
                    return 1;
                }
            });
        }
    }
}
