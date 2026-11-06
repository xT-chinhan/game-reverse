package com.byazt.xv;

import android.content.Context;
import com.byazt.je.IDownloadFileUriProvider;
import com.byazt.je.IDownloadListener;
import com.byazt.je.h;
import com.byazt.je.ur;
import com.byazt.wm.DownloadInfo;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 41, 1540})
public class Downloader extends qg {
    public static volatile Downloader instance;

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        super.addMainThreadListener(i, iDownloadListener);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        super.addNotificationListener(i, iDownloadListener);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        super.addSubThreadListener(i, iDownloadListener);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ boolean canResume(int i) {
        return super.canResume(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void cancel(int i) {
        super.cancel(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void cancel(int i, boolean z) {
        super.cancel(i, z);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void clearDownloadData(int i) {
        super.clearDownloadData(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void clearDownloadData(int i, boolean z) {
        super.clearDownloadData(i, z);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void destoryDownloader() {
        super.destoryDownloader();
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void forceDownloadIngoreRecommendSize(int i) {
        super.forceDownloadIngoreRecommendSize(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ List getAllDownloadInfo() {
        return super.getAllDownloadInfo();
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ long getCurBytes(int i) {
        return super.getCurBytes(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return super.getDownloadFileUriProvider(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ int getDownloadId(String str, String str2) {
        return super.getDownloadId(str, str2);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(int i) {
        return super.getDownloadInfo(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(String str, String str2) {
        return super.getDownloadInfo(str, str2);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ List getDownloadInfoList(String str) {
        return super.getDownloadInfoList(str);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ h getDownloadNotificationEventListener(int i) {
        return super.getDownloadNotificationEventListener(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ List getDownloadingDownloadInfosWithMimeType(String str) {
        return super.getDownloadingDownloadInfosWithMimeType(str);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ List getFailedDownloadInfosWithMimeType(String str) {
        return super.getFailedDownloadInfosWithMimeType(str);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ File getGlobalSaveDir() {
        return super.getGlobalSaveDir();
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ File getGlobalSaveTempDir() {
        return super.getGlobalSaveTempDir();
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ cd getReserveWifiStatusListener() {
        return super.getReserveWifiStatusListener();
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ int getStatus(int i) {
        return super.getStatus(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ List getSuccessedDownloadInfosWithMimeType(String str) {
        return super.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ List getUnCompletedDownloadInfosWithMimeType(String str) {
        return super.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ boolean isDownloadCacheSyncSuccess() {
        return super.isDownloadCacheSyncSuccess();
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ boolean isDownloadServiceForeground(int i) {
        return super.isDownloadServiceForeground(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return super.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ boolean isDownloading(int i) {
        return super.isDownloading(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ boolean isHttpServiceInit() {
        return super.isHttpServiceInit();
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void pause(int i) {
        super.pause(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void pauseAll() {
        super.pauseAll();
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void registerDownloadCacheSyncListener(com.byazt.je.cp cpVar) {
        super.registerDownloadCacheSyncListener(cpVar);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void registerDownloaderProcessConnectedListener(ur urVar) {
        super.registerDownloaderProcessConnectedListener(urVar);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        super.removeMainThreadListener(i, iDownloadListener);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        super.removeNotificationListener(i, iDownloadListener);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        super.removeSubThreadListener(i, iDownloadListener);
    }

    @Override // com.byazt.xv.qg
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskMainListener(int i) {
        super.removeTaskMainListener(i);
    }

    @Override // com.byazt.xv.qg
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskNotificationListener(int i) {
        super.removeTaskNotificationListener(i);
    }

    @Override // com.byazt.xv.qg
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskSubListener(int i) {
        super.removeTaskSubListener(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void restart(int i) {
        super.restart(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void restartAllFailedDownloadTasks(List list) {
        super.restartAllFailedDownloadTasks(list);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void restartAllPauseReserveOnWifiDownloadTasks(List list) {
        super.restartAllPauseReserveOnWifiDownloadTasks(list);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void resume(int i) {
        super.resume(i);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void setDefaultSavePath(String str) {
        super.setDefaultSavePath(str);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void setDefaultSaveTempPath(String str) {
        super.setDefaultSaveTempPath(str);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void setDownloadInMultiProcess() {
        super.setDownloadInMultiProcess();
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void setDownloadNotificationEventListener(int i, h hVar) {
        super.setDownloadNotificationEventListener(i, hVar);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void setLogLevel(int i) {
        super.setLogLevel(i);
    }

    @Override // com.byazt.xv.qg
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        super.setMainThreadListener(i, iDownloadListener);
    }

    @Override // com.byazt.xv.qg
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        super.setMainThreadListener(i, iDownloadListener, z);
    }

    @Override // com.byazt.xv.qg
    @Deprecated
    public /* bridge */ /* synthetic */ void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        super.setNotificationListener(i, iDownloadListener);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void setReserveWifiStatusListener(cd cdVar) {
        super.setReserveWifiStatusListener(cdVar);
    }

    @Override // com.byazt.xv.qg
    @Deprecated
    public /* bridge */ /* synthetic */ void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        super.setSubThreadListener(i, iDownloadListener);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int i, long j) {
        super.setThrottleNetSpeed(i, j);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void unRegisterDownloadCacheSyncListener(com.byazt.je.cp cpVar) {
        super.unRegisterDownloadCacheSyncListener(cpVar);
    }

    @Override // com.byazt.xv.qg
    public /* bridge */ /* synthetic */ void unRegisterDownloaderProcessConnectedListener(ur urVar) {
        super.unRegisterDownloaderProcessConnectedListener(urVar);
    }

    static {
        s.n(new ou());
        instance = null;
    }

    private Downloader() {
    }

    public static synchronized void init(DownloaderBuilder downloaderBuilder) {
        initOrCover(downloaderBuilder, false);
    }

    public static synchronized void initOrCover(DownloaderBuilder downloaderBuilder, boolean z) {
        if (downloaderBuilder == null) {
            return;
        }
        if (instance == null) {
            instance = downloaderBuilder.build();
        } else if (!s.y()) {
            s.n(downloaderBuilder);
        } else {
            if (z) {
                s.qg(downloaderBuilder);
            }
        }
    }

    public Downloader(DownloaderBuilder downloaderBuilder) {
        s.n(downloaderBuilder);
    }

    public static Downloader getInstance(Context context) {
        if (instance == null) {
            synchronized (Downloader.class) {
                if (instance == null) {
                    s.n(context);
                    instance = new Downloader();
                }
            }
        }
        return instance;
    }
}
