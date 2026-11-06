package com.byazt.xv;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.je.IDownloadFileUriProvider;
import com.byazt.je.IDownloadListener;
import com.byazt.je.h;
import com.byazt.je.ur;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 41, 26})
public class qg {
    public String globalDefaultSavePath;
    public String globalDefaultSaveTempPath;

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void pause(int i) {
        q.n().q(i);
    }

    public int getDownloadId(String str, String str2) {
        return q.n().n(str, str2);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return q.n().n(str);
    }

    public void cancel(int i) {
        cancel(i, true);
    }

    public void cancel(int i, boolean z) {
        q.n().s(i, z);
    }

    public void resume(int i) {
        q.n().w(i);
    }

    public boolean canResume(int i) {
        return q.n().l(i);
    }

    public void restart(int i) {
        q.n().x(i);
    }

    public void pauseAll() {
        q.n().s();
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return q.n().qg(str);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        q.n().n(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        q.n().qg(list);
    }

    public long getCurBytes(int i) {
        return q.n().fs(i);
    }

    public int getStatus(int i) {
        return q.n().rv(i);
    }

    public boolean isDownloading(int i) {
        boolean zTj;
        if (com.byazt.ta.n.n(4194304)) {
            synchronized (this) {
                zTj = q.n().tj(i);
            }
            return zTj;
        }
        return q.n().tj(i);
    }

    public DownloadInfo getDownloadInfo(int i) {
        return q.n().cp(i);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return q.n().qg(str, str2);
    }

    public h getDownloadNotificationEventListener(int i) {
        return q.n().d(i);
    }

    public void setDownloadNotificationEventListener(int i, h hVar) {
        q.n().n(i, hVar);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return q.n().s(str);
    }

    public void clearDownloadData(int i) {
        q.n().q(i, true);
    }

    public void clearDownloadData(int i, boolean z) {
        q.n().q(i, z);
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        q.n().sz(i);
    }

    @Deprecated
    public void removeTaskMainListener(int i) {
        q.n().n(i, null, com.byazt.sk.w.MAIN, true);
    }

    public void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        q.n().n(i, iDownloadListener, com.byazt.sk.w.MAIN, false);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        q.n().qg(i, iDownloadListener, com.byazt.sk.w.MAIN, true);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        q.n().n(i, iDownloadListener, com.byazt.sk.w.MAIN, true, z);
    }

    public void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        q.n().qg(i, iDownloadListener, com.byazt.sk.w.MAIN, false);
    }

    @Deprecated
    public void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        q.n().qg(i, iDownloadListener, com.byazt.sk.w.SUB, true);
    }

    public void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        q.n().qg(i, iDownloadListener, com.byazt.sk.w.SUB, false);
    }

    @Deprecated
    public void removeTaskSubListener(int i) {
        q.n().n(i, null, com.byazt.sk.w.SUB, true);
    }

    public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        q.n().n(i, iDownloadListener, com.byazt.sk.w.SUB, false);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i) {
        q.n().n(i, null, com.byazt.sk.w.NOTIFICATION, true);
    }

    public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        q.n().n(i, iDownloadListener, com.byazt.sk.w.NOTIFICATION, false);
    }

    @Deprecated
    public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        q.n().qg(i, iDownloadListener, com.byazt.sk.w.NOTIFICATION, true);
    }

    public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        q.n().qg(i, iDownloadListener, com.byazt.sk.w.NOTIFICATION, false);
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return q.n().n(downloadInfo);
    }

    public boolean isHttpServiceInit() {
        return q.n().q();
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return q.n().q(str);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return q.n().l(str);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return q.n().l();
    }

    public void destoryDownloader() {
        s.n();
    }

    public void setLogLevel(int i) {
        q.n().cy(i);
    }

    public void registerDownloadCacheSyncListener(com.byazt.je.cp cpVar) {
        q.n().n(cpVar);
    }

    public void unRegisterDownloadCacheSyncListener(com.byazt.je.cp cpVar) {
        q.n().qg(cpVar);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return q.n().w();
    }

    public void setDownloadInMultiProcess() {
        if (com.byazt.ta.n.n(4194304)) {
            synchronized (this) {
                s.qg();
            }
        } else {
            s.qg();
        }
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return q.n().cd(i);
    }

    public void registerDownloaderProcessConnectedListener(ur urVar) {
        q.n().n(urVar);
    }

    public void unRegisterDownloaderProcessConnectedListener(ur urVar) {
        q.n().qg(urVar);
    }

    public boolean isDownloadServiceForeground(int i) {
        return q.n().s(i).qg();
    }

    public cd getReserveWifiStatusListener() {
        return s.sh();
    }

    public void setReserveWifiStatusListener(cd cdVar) {
        s.n(cdVar);
    }

    public void setThrottleNetSpeed(int i, long j) {
        q.n().n(i, j);
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
