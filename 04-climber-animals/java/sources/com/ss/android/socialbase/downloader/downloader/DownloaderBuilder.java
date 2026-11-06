package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.of;
import com.ss.android.socialbase.downloader.depend.op;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class DownloaderBuilder {
    private ab chunkAdjustCalculator;
    private x chunkCntCalculator;
    private ExecutorService chunkDownloadExecutor;
    private final Context context;
    private ExecutorService cpuThreadExecutor;
    private ExecutorService dbThreadExecutor;
    private ch downloadCache;
    private com.ss.android.socialbase.downloader.network.c downloadDns;
    private boolean downloadInMultiProcess;
    private sl downloadLaunchHandler;
    private com.ss.android.socialbase.downloader.d.xr downloadMonitorListener;
    private op downloadSetting;
    private com.ss.android.socialbase.downloader.network.x headHttpService;
    private IDownloadHttpService httpService;
    private hi idGenerator;
    private ExecutorService ioThreadExecutor;
    private int maxDownloadPoolSize;
    private ExecutorService mixApkDownloadExecutor;
    private ExecutorService mixDefaultDownloadExecutor;
    private ExecutorService mixFrequentDownloadExecutor;
    private h monitorConfig;
    private of notificationClickCallback;
    private ExecutorService okHttpDispatcherExecutor;
    private nw ttNetHandler;
    private int writeBufferSize;
    private List<com.ss.android.socialbase.downloader.depend.zb> downloadCompleteHandlers = new ArrayList();
    private boolean needAutoRefreshUnSuccessTask = true;
    private int downloadExpSwitch = 1056964607;

    public DownloaderBuilder(Context context) {
        this.context = context;
    }

    public DownloaderBuilder writeBufferSize(int i) {
        this.writeBufferSize = i;
        return this;
    }

    public DownloaderBuilder chunkAdjustCalculator(ab abVar) {
        this.chunkAdjustCalculator = abVar;
        return this;
    }

    public DownloaderBuilder idGenerator(hi hiVar) {
        this.idGenerator = hiVar;
        return this;
    }

    public DownloaderBuilder downloadCache(ch chVar) {
        this.downloadCache = chVar;
        return this;
    }

    public DownloaderBuilder maxDownloadPoolSize(int i) {
        this.maxDownloadPoolSize = i;
        return this;
    }

    public DownloaderBuilder chunkCntCalculator(x xVar) {
        this.chunkCntCalculator = xVar;
        return this;
    }

    public DownloaderBuilder httpService(IDownloadHttpService iDownloadHttpService) {
        this.httpService = iDownloadHttpService;
        return this;
    }

    public DownloaderBuilder headHttpService(com.ss.android.socialbase.downloader.network.x xVar) {
        this.headHttpService = xVar;
        return this;
    }

    public DownloaderBuilder downloadLaunchHandler(sl slVar) {
        this.downloadLaunchHandler = slVar;
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

    public DownloaderBuilder monitorConfig(h hVar) {
        this.monitorConfig = hVar;
        return this;
    }

    public DownloaderBuilder downloadExpSwitch(int i) {
        this.downloadExpSwitch = i;
        return this;
    }

    public DownloaderBuilder ttNetHandler(nw nwVar) {
        this.ttNetHandler = nwVar;
        return this;
    }

    public DownloaderBuilder addDownloadCompleteHandler(com.ss.android.socialbase.downloader.depend.zb zbVar) {
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

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean z) {
        this.needAutoRefreshUnSuccessTask = z;
        return this;
    }

    public DownloaderBuilder notificationClickCallback(of ofVar) {
        this.notificationClickCallback = ofVar;
        return this;
    }

    public DownloaderBuilder downloadSetting(op opVar) {
        this.downloadSetting = opVar;
        return this;
    }

    public DownloaderBuilder downloadMonitorListener(com.ss.android.socialbase.downloader.d.xr xrVar) {
        this.downloadMonitorListener = xrVar;
        return this;
    }

    public DownloaderBuilder downloadDns(com.ss.android.socialbase.downloader.network.c cVar) {
        this.downloadDns = cVar;
        return this;
    }

    public Context getContext() {
        return this.context;
    }

    public ch getDownloadCache() {
        return this.downloadCache;
    }

    public hi getIdGenerator() {
        return this.idGenerator;
    }

    public IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public com.ss.android.socialbase.downloader.network.x getHeadHttpService() {
        return this.headHttpService;
    }

    public sl getDownloadLaunchHandler() {
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

    public List<com.ss.android.socialbase.downloader.depend.zb> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getMaxDownloadPoolSize() {
        return this.maxDownloadPoolSize;
    }

    public x getChunkCntCalculator() {
        return this.chunkCntCalculator;
    }

    public ab getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public h getMonitorConfig() {
        return this.monitorConfig;
    }

    public int getDownloadExpSwitch() {
        return this.downloadExpSwitch;
    }

    public nw getTTNetHandler() {
        return this.ttNetHandler;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }

    public of getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public op getDownloadSetting() {
        return this.downloadSetting;
    }

    public com.ss.android.socialbase.downloader.d.xr getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public com.ss.android.socialbase.downloader.network.c getDownloadDns() {
        return this.downloadDns;
    }

    public Downloader build() {
        return new Downloader(this);
    }
}
