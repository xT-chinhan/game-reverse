package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.le;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes3.dex */
public class xr {
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    xr() {
    }

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void pause(int i) {
        d.ms().d(i);
    }

    public int getDownloadId(String str, String str2) {
        return d.ms().ms(str, str2);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return d.ms().ms(str);
    }

    public void cancel(int i) {
        cancel(i, true);
    }

    public void cancel(int i, boolean z) {
        d.ms().ah(i, z);
    }

    public void resume(int i) {
        d.ms().c(i);
    }

    public boolean canResume(int i) {
        return d.ms().ka(i);
    }

    public void restart(int i) {
        d.ms().ab(i);
    }

    public void pauseAll() {
        d.ms().ah();
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return d.ms().xr(str);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        d.ms().ms(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        d.ms().xr(list);
    }

    public long getCurBytes(int i) {
        return d.ms().x(i);
    }

    public int getStatus(int i) {
        return d.ms().ny(i);
    }

    public boolean isDownloading(int i) {
        boolean zCh;
        if (com.ss.android.socialbase.downloader.ny.ms.ms(4194304)) {
            synchronized (this) {
                zCh = d.ms().ch(i);
            }
            return zCh;
        }
        return d.ms().ch(i);
    }

    public DownloadInfo getDownloadInfo(int i) {
        return d.ms().hi(i);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return d.ms().xr(str, str2);
    }

    public yu getDownloadNotificationEventListener(int i) {
        return d.ms().sl(i);
    }

    public void setDownloadNotificationEventListener(int i, yu yuVar) {
        d.ms().ms(i, yuVar);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return d.ms().ah(str);
    }

    public void clearDownloadData(int i) {
        d.ms().d(i, true);
    }

    public void clearDownloadData(int i, boolean z) {
        d.ms().d(i, z);
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        d.ms().u(i);
    }

    @Deprecated
    public void removeTaskMainListener(int i) {
        d.ms().ms(i, null, com.ss.android.socialbase.downloader.constants.c.MAIN, true);
    }

    public void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.ms().ms(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.c.MAIN, false);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.ms().xr(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.c.MAIN, true);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        d.ms().ms(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.c.MAIN, true, z);
    }

    public void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.ms().xr(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.c.MAIN, false);
    }

    @Deprecated
    public void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.ms().xr(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.c.SUB, true);
    }

    public void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.ms().xr(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.c.SUB, false);
    }

    @Deprecated
    public void removeTaskSubListener(int i) {
        d.ms().ms(i, null, com.ss.android.socialbase.downloader.constants.c.SUB, true);
    }

    public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.ms().ms(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.c.SUB, false);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i) {
        d.ms().ms(i, null, com.ss.android.socialbase.downloader.constants.c.NOTIFICATION, true);
    }

    public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.ms().ms(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.c.NOTIFICATION, false);
    }

    @Deprecated
    public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.ms().xr(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.c.NOTIFICATION, true);
    }

    public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.ms().xr(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.c.NOTIFICATION, false);
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return d.ms().ms(downloadInfo);
    }

    public boolean isHttpServiceInit() {
        return d.ms().d();
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return d.ms().d(str);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return d.ms().ka(str);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return d.ms().ka();
    }

    public void destoryDownloader() {
        ah.ms();
    }

    public void setLogLevel(int i) {
        d.ms().ao(i);
    }

    public void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.hi hiVar) {
        d.ms().ms(hiVar);
    }

    public void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.hi hiVar) {
        d.ms().xr(hiVar);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return d.ms().c();
    }

    public void setDownloadInMultiProcess() {
        if (com.ss.android.socialbase.downloader.ny.ms.ms(4194304)) {
            synchronized (this) {
                ah.xr();
            }
        } else {
            ah.xr();
        }
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return d.ms().qv(i);
    }

    public void registerDownloaderProcessConnectedListener(le leVar) {
        d.ms().ms(leVar);
    }

    public void unRegisterDownloaderProcessConnectedListener(le leVar) {
        d.ms().xr(leVar);
    }

    public boolean isDownloadServiceForeground(int i) {
        return d.ms().ah(i).xr();
    }

    public qv getReserveWifiStatusListener() {
        return ah.xn();
    }

    public void setReserveWifiStatusListener(qv qvVar) {
        ah.ms(qvVar);
    }

    public void setThrottleNetSpeed(int i, long j) {
        d.ms().ms(i, j);
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
            } catch (Throwable unused) {
                file = file2;
                return file;
            }
        } catch (Throwable unused2) {
        }
    }

    public void setDefaultSavePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSavePath = str;
    }

    public void setDefaultSaveTempPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSaveTempPath = str;
    }
}
