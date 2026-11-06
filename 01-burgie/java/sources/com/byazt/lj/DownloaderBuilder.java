package com.byazt.lj;

import android.content.Context;
import com.byazt.edb.IDownloadHttpService;
import com.byazt.fn.iu;
import com.byazt.fn.y;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 1526})
public class DownloaderBuilder {
    public fw chunkAdjustCalculator;
    public zo chunkCntCalculator;
    public ExecutorService chunkDownloadExecutor;
    public final Context context;
    public ExecutorService cpuThreadExecutor;
    public ExecutorService dbThreadExecutor;
    public vk downloadCache;
    public com.byazt.edb.uc downloadDns;
    public boolean downloadInMultiProcess;
    public k downloadLaunchHandler;
    public com.byazt.cha.hw downloadMonitorListener;
    public iu downloadSetting;
    public com.byazt.edb.zo headHttpService;
    public IDownloadHttpService httpService;
    public w idGenerator;
    public ExecutorService ioThreadExecutor;
    public int maxDownloadPoolSize;
    public ExecutorService mixApkDownloadExecutor;
    public ExecutorService mixDefaultDownloadExecutor;
    public ExecutorService mixFrequentDownloadExecutor;
    public yb monitorConfig;
    public y notificationClickCallback;
    public ExecutorService okHttpDispatcherExecutor;
    public cz ttNetHandler;
    public int writeBufferSize;
    public List<com.byazt.fn.m> downloadCompleteHandlers = new ArrayList();
    public boolean needAutoRefreshUnSuccessTask = true;
    public int downloadExpSwitch = 1056964607;

    public DownloaderBuilder(Context context) {
        this.context = context;
    }

    public DownloaderBuilder writeBufferSize(int i) {
        this.writeBufferSize = i;
        return this;
    }

    public DownloaderBuilder chunkAdjustCalculator(fw fwVar) {
        this.chunkAdjustCalculator = fwVar;
        return this;
    }

    public DownloaderBuilder idGenerator(w wVar) {
        this.idGenerator = wVar;
        return this;
    }

    public DownloaderBuilder downloadCache(vk vkVar) {
        this.downloadCache = vkVar;
        return this;
    }

    public DownloaderBuilder maxDownloadPoolSize(int i) {
        this.maxDownloadPoolSize = i;
        return this;
    }

    public DownloaderBuilder chunkCntCalculator(zo zoVar) {
        this.chunkCntCalculator = zoVar;
        return this;
    }

    public DownloaderBuilder httpService(IDownloadHttpService iDownloadHttpService) {
        this.httpService = iDownloadHttpService;
        return this;
    }

    public DownloaderBuilder headHttpService(com.byazt.edb.zo zoVar) {
        this.headHttpService = zoVar;
        return this;
    }

    public DownloaderBuilder downloadLaunchHandler(k kVar) {
        this.downloadLaunchHandler = kVar;
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

    public DownloaderBuilder monitorConfig(yb ybVar) {
        this.monitorConfig = ybVar;
        return this;
    }

    public DownloaderBuilder downloadExpSwitch(int i) {
        this.downloadExpSwitch = i;
        return this;
    }

    public DownloaderBuilder ttNetHandler(cz czVar) {
        this.ttNetHandler = czVar;
        return this;
    }

    public DownloaderBuilder addDownloadCompleteHandler(com.byazt.fn.m mVar) {
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

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean z) {
        this.needAutoRefreshUnSuccessTask = z;
        return this;
    }

    public DownloaderBuilder notificationClickCallback(y yVar) {
        this.notificationClickCallback = yVar;
        return this;
    }

    public DownloaderBuilder downloadSetting(iu iuVar) {
        this.downloadSetting = iuVar;
        return this;
    }

    public DownloaderBuilder downloadMonitorListener(com.byazt.cha.hw hwVar) {
        this.downloadMonitorListener = hwVar;
        return this;
    }

    public DownloaderBuilder downloadDns(com.byazt.edb.uc ucVar) {
        this.downloadDns = ucVar;
        return this;
    }

    public Context getContext() {
        return this.context;
    }

    public vk getDownloadCache() {
        return this.downloadCache;
    }

    public w getIdGenerator() {
        return this.idGenerator;
    }

    public IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public com.byazt.edb.zo getHeadHttpService() {
        return this.headHttpService;
    }

    public k getDownloadLaunchHandler() {
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

    public List<com.byazt.fn.m> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getMaxDownloadPoolSize() {
        return this.maxDownloadPoolSize;
    }

    public zo getChunkCntCalculator() {
        return this.chunkCntCalculator;
    }

    public fw getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public yb getMonitorConfig() {
        return this.monitorConfig;
    }

    public int getDownloadExpSwitch() {
        return this.downloadExpSwitch;
    }

    public cz getTTNetHandler() {
        return this.ttNetHandler;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }

    public y getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public iu getDownloadSetting() {
        return this.downloadSetting;
    }

    public com.byazt.cha.hw getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public com.byazt.edb.uc getDownloadDns() {
        return this.downloadDns;
    }

    public Downloader build() {
        return new Downloader(this);
    }
}
