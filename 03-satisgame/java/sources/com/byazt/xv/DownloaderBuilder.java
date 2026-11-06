package com.byazt.xv;

import android.content.Context;
import com.byazt.je.lh;
import com.byazt.je.t;
import com.byazt.m.IDownloadHttpService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 41, 1663})
public class DownloaderBuilder {
    public x chunkAdjustCalculator;
    public fs chunkCntCalculator;
    public ExecutorService chunkDownloadExecutor;
    public final Context context;
    public ExecutorService cpuThreadExecutor;
    public ExecutorService dbThreadExecutor;
    public tj downloadCache;
    public com.byazt.m.w downloadDns;
    public boolean downloadInMultiProcess;
    public d downloadLaunchHandler;
    public com.byazt.g.qg downloadMonitorListener;
    public t downloadSetting;
    public com.byazt.m.fs headHttpService;
    public IDownloadHttpService httpService;
    public cp idGenerator;
    public ExecutorService ioThreadExecutor;
    public int maxDownloadPoolSize;
    public ExecutorService mixApkDownloadExecutor;
    public ExecutorService mixDefaultDownloadExecutor;
    public ExecutorService mixFrequentDownloadExecutor;
    public hd monitorConfig;
    public lh notificationClickCallback;
    public ExecutorService okHttpDispatcherExecutor;
    public py ttNetHandler;
    public int writeBufferSize;
    public List<com.byazt.je.oa> downloadCompleteHandlers = new ArrayList();
    public boolean needAutoRefreshUnSuccessTask = true;
    public int downloadExpSwitch = 1056964607;

    public DownloaderBuilder(Context context) {
        this.context = context;
    }

    public DownloaderBuilder writeBufferSize(int i) {
        this.writeBufferSize = i;
        return this;
    }

    public DownloaderBuilder chunkAdjustCalculator(x xVar) {
        this.chunkAdjustCalculator = xVar;
        return this;
    }

    public DownloaderBuilder idGenerator(cp cpVar) {
        this.idGenerator = cpVar;
        return this;
    }

    public DownloaderBuilder downloadCache(tj tjVar) {
        this.downloadCache = tjVar;
        return this;
    }

    public DownloaderBuilder maxDownloadPoolSize(int i) {
        this.maxDownloadPoolSize = i;
        return this;
    }

    public DownloaderBuilder chunkCntCalculator(fs fsVar) {
        this.chunkCntCalculator = fsVar;
        return this;
    }

    public DownloaderBuilder httpService(IDownloadHttpService iDownloadHttpService) {
        this.httpService = iDownloadHttpService;
        return this;
    }

    public DownloaderBuilder headHttpService(com.byazt.m.fs fsVar) {
        this.headHttpService = fsVar;
        return this;
    }

    public DownloaderBuilder downloadLaunchHandler(d dVar) {
        this.downloadLaunchHandler = dVar;
        return this;
    }

    public DownloaderBuilder cpuThreadExecutor(ExecutorService executorService) {
        this.cpuThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder ioThreadExecutor(ExecutorService executorService) {
        this.ioThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixDefaultDownloadExecutor(ExecutorService executorService) {
        this.mixDefaultDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixFrequentDownloadExecutor(ExecutorService executorService) {
        this.mixFrequentDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixApkDownloadExecutor(ExecutorService executorService) {
        this.mixApkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder dbThreadExecutor(ExecutorService executorService) {
        this.dbThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder chunkThreadExecutor(ExecutorService executorService) {
        this.chunkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder okHttpDispatcherExecutor(ExecutorService executorService) {
        this.okHttpDispatcherExecutor = executorService;
        return this;
    }

    public DownloaderBuilder downloadInMultiProcess(boolean z) {
        this.downloadInMultiProcess = z;
        return this;
    }

    public DownloaderBuilder monitorConfig(hd hdVar) {
        this.monitorConfig = hdVar;
        return this;
    }

    public DownloaderBuilder downloadExpSwitch(int i) {
        this.downloadExpSwitch = i;
        return this;
    }

    public DownloaderBuilder ttNetHandler(py pyVar) {
        this.ttNetHandler = pyVar;
        return this;
    }

    public DownloaderBuilder addDownloadCompleteHandler(com.byazt.je.oa oaVar) {
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

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean z) {
        this.needAutoRefreshUnSuccessTask = z;
        return this;
    }

    public DownloaderBuilder notificationClickCallback(lh lhVar) {
        this.notificationClickCallback = lhVar;
        return this;
    }

    public DownloaderBuilder downloadSetting(t tVar) {
        this.downloadSetting = tVar;
        return this;
    }

    public DownloaderBuilder downloadMonitorListener(com.byazt.g.qg qgVar) {
        this.downloadMonitorListener = qgVar;
        return this;
    }

    public DownloaderBuilder downloadDns(com.byazt.m.w wVar) {
        this.downloadDns = wVar;
        return this;
    }

    public Context getContext() {
        return this.context;
    }

    public tj getDownloadCache() {
        return this.downloadCache;
    }

    public cp getIdGenerator() {
        return this.idGenerator;
    }

    public IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public com.byazt.m.fs getHeadHttpService() {
        return this.headHttpService;
    }

    public d getDownloadLaunchHandler() {
        return this.downloadLaunchHandler;
    }

    public ExecutorService getCPUThreadExecutor() {
        return this.cpuThreadExecutor;
    }

    public ExecutorService getIOThreadExecutor() {
        return this.ioThreadExecutor;
    }

    public ExecutorService getMixDefaultDownloadExecutor() {
        return this.mixDefaultDownloadExecutor;
    }

    public ExecutorService getMixFrequentDownloadExecutor() {
        return this.mixFrequentDownloadExecutor;
    }

    public ExecutorService getMixApkDownloadExecutor() {
        return this.mixApkDownloadExecutor;
    }

    public ExecutorService getDBThreadExecutor() {
        return this.dbThreadExecutor;
    }

    public ExecutorService getChunkThreadExecutor() {
        return this.chunkDownloadExecutor;
    }

    public ExecutorService getOkHttpDispatcherExecutor() {
        return this.okHttpDispatcherExecutor;
    }

    public List<com.byazt.je.oa> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getMaxDownloadPoolSize() {
        return this.maxDownloadPoolSize;
    }

    public fs getChunkCntCalculator() {
        return this.chunkCntCalculator;
    }

    public x getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public hd getMonitorConfig() {
        return this.monitorConfig;
    }

    public int getDownloadExpSwitch() {
        return this.downloadExpSwitch;
    }

    public py getTTNetHandler() {
        return this.ttNetHandler;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }

    public lh getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public t getDownloadSetting() {
        return this.downloadSetting;
    }

    public com.byazt.g.qg getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public com.byazt.m.w getDownloadDns() {
        return this.downloadDns;
    }

    public Downloader build() {
        return new Downloader(this);
    }
}
