package com.byazt.lj;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.fn.IDownloadFileUriProvider;
import com.byazt.fn.IDownloadListener;
import com.byazt.fn.b;
import com.byazt.fn.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 13})
public class hw {
    public String globalDefaultSavePath;
    public String globalDefaultSaveTempPath;

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void pause(int i) {
        x.pr().x(i);
    }

    public int getDownloadId(String str, String str2) {
        return x.pr().pr(str, str2);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return x.pr().pr(str);
    }

    public void cancel(int i) {
        cancel(i, true);
    }

    public void cancel(int i, boolean z) {
        x.pr().hn(i, z);
    }

    public void resume(int i) {
        x.pr().uc(i);
    }

    public boolean canResume(int i) {
        return x.pr().c(i);
    }

    public void restart(int i) {
        x.pr().fw(i);
    }

    public void pauseAll() {
        x.pr().hn();
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return x.pr().hw(str);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        x.pr().pr(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        x.pr().hw(list);
    }

    public long getCurBytes(int i) {
        return x.pr().zo(i);
    }

    public int getStatus(int i) {
        return x.pr().aj(i);
    }

    public boolean isDownloading(int i) {
        boolean zVk;
        if (com.byazt.tuy.pr.pr(4194304)) {
            synchronized (this) {
                zVk = x.pr().vk(i);
            }
            return zVk;
        }
        return x.pr().vk(i);
    }

    public DownloadInfo getDownloadInfo(int i) {
        return x.pr().w(i);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return x.pr().hw(str, str2);
    }

    public b getDownloadNotificationEventListener(int i) {
        return x.pr().k(i);
    }

    public void setDownloadNotificationEventListener(int i, b bVar) {
        x.pr().pr(i, bVar);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return x.pr().hn(str);
    }

    public void clearDownloadData(int i) {
        x.pr().x(i, true);
    }

    public void clearDownloadData(int i, boolean z) {
        x.pr().x(i, z);
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        x.pr().g(i);
    }

    @Deprecated
    public void removeTaskMainListener(int i) {
        x.pr().pr(i, null, com.byazt.mrs.uc.MAIN, true);
    }

    public void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        x.pr().pr(i, iDownloadListener, com.byazt.mrs.uc.MAIN, false);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        x.pr().hw(i, iDownloadListener, com.byazt.mrs.uc.MAIN, true);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        x.pr().pr(i, iDownloadListener, com.byazt.mrs.uc.MAIN, true, z);
    }

    public void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        x.pr().hw(i, iDownloadListener, com.byazt.mrs.uc.MAIN, false);
    }

    @Deprecated
    public void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        x.pr().hw(i, iDownloadListener, com.byazt.mrs.uc.SUB, true);
    }

    public void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        x.pr().hw(i, iDownloadListener, com.byazt.mrs.uc.SUB, false);
    }

    @Deprecated
    public void removeTaskSubListener(int i) {
        x.pr().pr(i, null, com.byazt.mrs.uc.SUB, true);
    }

    public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        x.pr().pr(i, iDownloadListener, com.byazt.mrs.uc.SUB, false);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i) {
        x.pr().pr(i, null, com.byazt.mrs.uc.NOTIFICATION, true);
    }

    public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        x.pr().pr(i, iDownloadListener, com.byazt.mrs.uc.NOTIFICATION, false);
    }

    @Deprecated
    public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        x.pr().hw(i, iDownloadListener, com.byazt.mrs.uc.NOTIFICATION, true);
    }

    public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        x.pr().hw(i, iDownloadListener, com.byazt.mrs.uc.NOTIFICATION, false);
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return x.pr().pr(downloadInfo);
    }

    public boolean isHttpServiceInit() {
        return x.pr().x();
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return x.pr().x(str);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return x.pr().c(str);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return x.pr().c();
    }

    public void destoryDownloader() {
        hn.pr();
    }

    public void setLogLevel(int i) {
        x.pr().nt(i);
    }

    public void registerDownloadCacheSyncListener(com.byazt.fn.w wVar) {
        x.pr().pr(wVar);
    }

    public void unRegisterDownloadCacheSyncListener(com.byazt.fn.w wVar) {
        x.pr().hw(wVar);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return x.pr().uc();
    }

    public void setDownloadInMultiProcess() {
        if (com.byazt.tuy.pr.pr(4194304)) {
            synchronized (this) {
                hn.hw();
            }
        } else {
            hn.hw();
        }
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return x.pr().lb(i);
    }

    public void registerDownloaderProcessConnectedListener(ve veVar) {
        x.pr().pr(veVar);
    }

    public void unRegisterDownloaderProcessConnectedListener(ve veVar) {
        x.pr().hw(veVar);
    }

    public boolean isDownloadServiceForeground(int i) {
        return x.pr().hn(i).hw();
    }

    public lb getReserveWifiStatusListener() {
        return hn.r();
    }

    public void setReserveWifiStatusListener(lb lbVar) {
        hn.pr(lbVar);
    }

    public void setThrottleNetSpeed(int i, long j) {
        x.pr().pr(i, j);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath, true);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath, false);
    }

    private File getGlobalSaveDir(String str, boolean z) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file2 = new File(str);
            try {
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (!file2.isDirectory()) {
                    if (!z) {
                        return null;
                    }
                    file2.delete();
                    file2.mkdirs();
                }
                return file2;
            } catch (Throwable th) {
                file = file2;
                return file;
            }
        } catch (Throwable th2) {
        }
    }

    public void setDefaultSavePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.globalDefaultSavePath = str;
        }
    }

    public void setDefaultSaveTempPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.globalDefaultSaveTempPath = str;
        }
    }
}
