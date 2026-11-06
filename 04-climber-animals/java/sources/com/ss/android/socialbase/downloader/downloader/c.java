package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.jw;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4659ms = "c";
    private SparseArray<IDownloadListener> ab;
    private DownloadInfo ah;
    private com.ss.android.socialbase.downloader.depend.u ao;
    private DownloadTask c;
    private final ch d;
    private i h;
    private final Handler ka;
    private SparseArray<IDownloadListener> ny;
    private int u;
    private long ub;
    private SparseArray<IDownloadListener> x;
    private final boolean xr;
    private boolean ch = false;
    private volatile long hi = 0;
    private final AtomicLong sl = new AtomicLong();
    private boolean zb = false;

    public c(DownloadTask downloadTask, Handler handler) {
        this.c = downloadTask;
        ch();
        this.ka = handler;
        this.d = ah.w();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.xr = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("fix_start_with_file_exist_update_error");
        } else {
            this.xr = false;
        }
    }

    private void ch() {
        DownloadTask downloadTask = this.c;
        if (downloadTask != null) {
            this.ah = downloadTask.getDownloadInfo();
            this.ab = this.c.getDownloadListeners(com.ss.android.socialbase.downloader.constants.c.MAIN);
            this.ny = this.c.getDownloadListeners(com.ss.android.socialbase.downloader.constants.c.NOTIFICATION);
            this.x = this.c.getDownloadListeners(com.ss.android.socialbase.downloader.constants.c.SUB);
            this.ao = this.c.getDepend();
            this.h = this.c.getMonitorDepend();
        }
    }

    public void ms() {
        if (this.ah.canSkipStatusHandler()) {
            return;
        }
        this.ah.setStatus(1);
        hi();
    }

    private void hi() {
        ExecutorService executorServiceSl = ah.sl();
        if (executorServiceSl != null) {
            executorServiceSl.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.d.ny(c.this.ah.getId());
                    c.this.ms(1, (BaseException) null);
                }
            });
        }
    }

    public void xr() {
        if (this.ah.canSkipStatusHandler()) {
            this.ah.changeSkipStatus();
            return;
        }
        this.d.ab(this.ah.getId());
        if (this.ah.isFirstDownload()) {
            ms(6, (BaseException) null);
        }
        ms(2, (BaseException) null);
    }

    public void ms(long j, String str, String str2) {
        this.ah.setTotalBytes(j);
        this.ah.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.ah.getName())) {
            this.ah.setName(str2);
        }
        try {
            this.d.ms(this.ah.getId(), j, str, str2);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        ms(3, (BaseException) null);
        this.ub = this.ah.getMinByteIntervalForPostToMainThread(j);
        this.u = this.ah.getMinProgressTimeMsInterval();
        this.ch = true;
        com.ss.android.socialbase.downloader.impls.qv.ms().ka();
    }

    public boolean ms(long j) {
        this.sl.addAndGet(j);
        this.ah.increaseCurBytes(j);
        long jUptimeMillis = SystemClock.uptimeMillis();
        return ms(jUptimeMillis, xr(jUptimeMillis));
    }

    public void ah() {
        ms(-4, (BaseException) null);
    }

    public void d() {
        this.ah.setStatus(-2);
        try {
            this.d.d(this.ah.getId(), this.ah.getCurBytes());
        } catch (SQLiteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        ms(-2, (BaseException) null);
    }

    public void ka() {
        this.ah.setStatus(-7);
        try {
            this.d.ch(this.ah.getId());
        } catch (SQLiteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        ms(-7, (BaseException) null);
    }

    public void ms(BaseException baseException, boolean z) {
        this.ah.setFirstDownload(false);
        this.sl.set(0L);
        xr(baseException, z);
    }

    public void ms(com.ss.android.socialbase.downloader.model.xr xrVar, BaseException baseException, boolean z) {
        this.ah.setFirstDownload(false);
        this.sl.set(0L);
        this.d.x(this.ah.getId());
        ms(z ? 10 : 9, baseException, true);
    }

    public void ms(BaseException baseException) {
        this.ah.setFirstDownload(false);
        xr(baseException);
    }

    private void xr(BaseException baseException) {
        com.bytedance.sdk.openadsdk.api.ab.xr(f4659ms, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.d.c(this.ah.getId());
            } catch (SQLiteException e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        } else {
            try {
                try {
                    this.d.xr(this.ah.getId(), this.ah.getCurBytes());
                } catch (SQLiteException unused) {
                    this.d.c(this.ah.getId());
                }
            } catch (SQLiteException e2) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e2);
            }
        }
        BaseException baseExceptionAh = ah(baseException);
        this.ah.setFailedException(baseExceptionAh);
        ms(baseExceptionAh instanceof com.ss.android.socialbase.downloader.exception.ka ? -2 : -1, baseExceptionAh);
        if (com.ss.android.socialbase.downloader.ab.ms.ms(this.ah.getId()).ms("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.qv.ms().ms(this.ah);
        }
    }

    private BaseException ah(BaseException baseException) {
        Context contextK;
        if (com.ss.android.socialbase.downloader.ab.ms.ms(this.ah.getId()).ms("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.ny.c.ny(baseException) || (contextK = ah.k()) == null || com.ss.android.socialbase.downloader.ny.c.ah(contextK)) {
            return baseException;
        }
        return new BaseException(this.ah.isOnlyWifi() ? PointerIconCompat.TYPE_ALL_SCROLL : 1049, baseException.getErrorMessage());
    }

    public void c() {
        this.ah.setFirstDownload(false);
        if (!this.ah.isIgnoreDataVerify() && this.ah.getCurBytes() != this.ah.getTotalBytes()) {
            com.ss.android.socialbase.downloader.ah.ms.xr(f4659ms, this.ah.getErrorBytesLog());
            ms(new com.ss.android.socialbase.downloader.exception.c(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.ah.getByteInvalidRetryStatus()));
            return;
        }
        if (this.ah.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.ah.ms.xr(f4659ms, this.ah.getErrorBytesLog());
            ms(new com.ss.android.socialbase.downloader.exception.c(1026, "curBytes is 0, bytes changed with process : " + this.ah.getByteInvalidRetryStatus()));
            return;
        }
        if (!this.ah.isIgnoreDataVerify() && this.ah.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.ah.ms.xr(f4659ms, this.ah.getErrorBytesLog());
            ms(new com.ss.android.socialbase.downloader.exception.c(1044, "TotalBytes is 0, bytes changed with process : " + this.ah.getByteInvalidRetryStatus()));
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(f4659ms, this.ah.getName() + " onCompleted start save file as target name");
        i monitorDepend = this.h;
        DownloadTask downloadTask = this.c;
        if (downloadTask != null) {
            monitorDepend = downloadTask.getMonitorDepend();
        }
        com.ss.android.socialbase.downloader.ny.c.ms(this.ah, monitorDepend, new jw() { // from class: com.ss.android.socialbase.downloader.downloader.c.2
            @Override // com.ss.android.socialbase.downloader.depend.jw
            public void ms() {
                c.this.sl();
            }

            @Override // com.ss.android.socialbase.downloader.depend.jw
            public void ms(BaseException baseException) {
                com.ss.android.socialbase.downloader.ah.ms.xr(c.f4659ms, "saveFileAsTargetName onFailed : " + (baseException != null ? baseException.getErrorMessage() : ""));
                c.this.ms(baseException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl() {
        try {
            com.ss.android.socialbase.downloader.ah.ms.xr(f4659ms, "saveFileAsTargetName onSuccess");
            try {
                zb();
                this.ah.setFirstSuccess(false);
                this.ah.setSuccessByCache(false);
                ms(-3, (BaseException) null);
                this.d.ah(this.ah.getId(), this.ah.getTotalBytes());
                this.d.d(this.ah.getId());
                this.d.zb(this.ah.getId());
            } catch (BaseException e) {
                ms(e);
            }
        } catch (Throwable th) {
            ms(new BaseException(PointerIconCompat.TYPE_TEXT, com.ss.android.socialbase.downloader.ny.c.xr(th, "onCompleted")));
        }
    }

    public void ab() throws BaseException {
        if (this.xr) {
            zb();
            com.ss.android.socialbase.downloader.ah.ms.xr(f4659ms, "onCompleteForFileExist");
            this.ah.setSuccessByCache(true);
            ms(-3, (BaseException) null);
            this.d.ah(this.ah.getId(), this.ah.getTotalBytes());
            this.d.d(this.ah.getId());
            this.d.ms(this.ah);
            this.d.zb(this.ah.getId());
            return;
        }
        zb();
        com.ss.android.socialbase.downloader.ah.ms.xr(f4659ms, "onCompleteForFileExist");
        this.ah.setSuccessByCache(true);
        ms(-3, (BaseException) null);
        this.d.ah(this.ah.getId(), this.ah.getTotalBytes());
        this.d.d(this.ah.getId());
        this.d.zb(this.ah.getId());
    }

    public void ms(String str) throws BaseException {
        com.ss.android.socialbase.downloader.ah.ms.xr(f4659ms, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.ah.getName());
        if (this.xr) {
            com.ss.android.socialbase.downloader.ny.c.ms(this.ah, str);
            zb();
            this.ah.setSuccessByCache(true);
            ms(-3, (BaseException) null);
            this.d.ms(this.ah);
            return;
        }
        this.d.ms(this.ah);
        com.ss.android.socialbase.downloader.ny.c.ms(this.ah, str);
        this.ah.setSuccessByCache(true);
        zb();
        ms(-3, (BaseException) null);
    }

    private void zb() throws BaseException {
        List<com.ss.android.socialbase.downloader.depend.zb> downloadCompleteHandlers = this.c.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.ah;
        ms(11, (BaseException) null);
        this.d.ms(downloadInfo);
        for (com.ss.android.socialbase.downloader.depend.zb zbVar : downloadCompleteHandlers) {
            try {
                if (zbVar.xr(downloadInfo)) {
                    zbVar.ms(downloadInfo);
                    this.d.ms(downloadInfo);
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    private boolean ms(long j, boolean z) {
        boolean z2 = false;
        if (this.ah.getCurBytes() == this.ah.getTotalBytes()) {
            try {
                this.d.ms(this.ah.getId(), this.ah.getCurBytes());
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
            return false;
        }
        if (this.ch) {
            this.ch = false;
            this.ah.setStatus(4);
        }
        if (this.ah.isNeedPostProgress() && z) {
            z2 = true;
        }
        ms(4, (BaseException) null, z2);
        return z;
    }

    private boolean xr(long j) {
        boolean z = true;
        if (!this.zb) {
            this.zb = true;
            return true;
        }
        long j2 = j - this.hi;
        if (this.sl.get() < this.ub && j2 < this.u) {
            z = false;
        }
        if (z) {
            this.hi = j;
            this.sl.set(0L);
        }
        return z;
    }

    private void xr(BaseException baseException, boolean z) {
        this.d.x(this.ah.getId());
        ms(z ? 7 : 5, baseException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, BaseException baseException) {
        ms(i, baseException, true);
    }

    public void x() {
        this.ah.setStatus(8);
        this.ah.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.ms.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.ms msVarG = ah.g();
        if (msVarG != null) {
            msVarG.ms(this.ah.getId(), this.c.getHashCodeForSameTask(), 8);
        }
    }

    private void ms(int i, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.ah.getStatus();
        if (status == -3 && i == 4) {
            return;
        }
        ch();
        if (i != 4 && DownloadStatus.isRealTimeUploadStatus(i)) {
            this.ah.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i)) {
                this.ah.updateDownloadTime();
            }
        }
        if (!this.ah.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.d.ms.ms(this.c, baseException, i);
        }
        if (i == 6) {
            this.ah.setStatus(2);
        } else if (i == -6) {
            this.ah.setStatus(-3);
        } else {
            this.ah.setStatus(i);
        }
        if (status == -3 || status == -1) {
            if (this.ah.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.ab.DELAY_RETRY_DOWNLOADING) {
                this.ah.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.ab.DELAY_RETRY_DOWNLOADED);
            }
            if (this.ah.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.ms.ASYNC_HANDLE_DOWNLOADING) {
                this.ah.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.ms.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.ah.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.xr.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.ah.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.xr.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.ny.ah.ms(i, this.x, true, this.ah, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.ka != null && (((sparseArray = this.ab) != null && sparseArray.size() > 0) || ((sparseArray2 = this.ny) != null && sparseArray2.size() > 0 && (this.ah.canShowNotification() || this.ah.isAutoInstallWithoutNotification())))) {
            this.ka.obtainMessage(i, this.ah.getId(), this.c.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.ms msVarG = ah.g();
        if (msVarG != null) {
            msVarG.ms(this.ah.getId(), this.c.getHashCodeForSameTask(), i);
        }
    }
}
