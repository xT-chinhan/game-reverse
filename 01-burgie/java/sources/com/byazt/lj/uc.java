package com.byazt.lj;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.fn.IDownloadListener;
import com.byazt.fn.e;
import com.byazt.fn.rc;
import com.byazt.lhc.BaseException;
import com.byazt.mrs.DownloadStatus;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 5})
public class uc {
    public static final String pr = uc.class.getSimpleName();
    public SparseArray<IDownloadListener> aj;
    public final Handler c;
    public SparseArray<IDownloadListener> fw;
    public int g;
    public DownloadInfo hn;
    public long ho;
    public final boolean hw;
    public com.byazt.fn.g nt;
    public DownloadTask uc;
    public final vk x;
    public rc yb;
    public SparseArray<IDownloadListener> zo;
    public boolean vk = false;
    public volatile long w = 0;
    public final AtomicLong k = new AtomicLong();
    public boolean m = false;

    public uc(DownloadTask downloadTask, Handler handler) {
        this.uc = downloadTask;
        vk();
        this.c = handler;
        this.x = hn.z();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.hw = com.byazt.ew.pr.pr(downloadInfo.getId()).pr("fix_start_with_file_exist_update_error");
        } else {
            this.hw = false;
        }
    }

    private void vk() {
        DownloadTask downloadTask = this.uc;
        if (downloadTask != null) {
            this.hn = downloadTask.getDownloadInfo();
            this.fw = this.uc.getDownloadListeners(com.byazt.mrs.uc.MAIN);
            this.aj = this.uc.getDownloadListeners(com.byazt.mrs.uc.NOTIFICATION);
            this.zo = this.uc.getDownloadListeners(com.byazt.mrs.uc.SUB);
            this.nt = this.uc.getDepend();
            this.yb = this.uc.getMonitorDepend();
        }
    }

    public void pr() {
        if (this.hn.canSkipStatusHandler()) {
            return;
        }
        this.hn.setStatus(1);
        w();
    }

    private void w() {
        ExecutorService executorServiceK = hn.k();
        if (executorServiceK != null) {
            executorServiceK.execute(new Runnable() { // from class: com.byazt.lj.uc.1
                @Override // java.lang.Runnable
                public void run() {
                    uc.this.x.aj(uc.this.hn.getId());
                    uc.this.pr(1, (BaseException) null);
                }
            });
        }
    }

    public void hw() {
        if (this.hn.canSkipStatusHandler()) {
            this.hn.changeSkipStatus();
            return;
        }
        this.x.fw(this.hn.getId());
        if (this.hn.isFirstDownload()) {
            pr(6, (BaseException) null);
        }
        pr(2, (BaseException) null);
    }

    public void pr(long j, String str, String str2) {
        this.hn.setTotalBytes(j);
        this.hn.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.hn.getName())) {
            this.hn.setName(str2);
        }
        try {
            this.x.pr(this.hn.getId(), j, str, str2);
        } catch (Exception e) {
        }
        pr(3, (BaseException) null);
        this.ho = this.hn.getMinByteIntervalForPostToMainThread(j);
        this.g = this.hn.getMinProgressTimeMsInterval();
        this.vk = true;
        com.byazt.ts.lb.pr().c();
    }

    public boolean pr(long j) {
        this.k.addAndGet(j);
        this.hn.increaseCurBytes(j);
        long jUptimeMillis = SystemClock.uptimeMillis();
        return pr(jUptimeMillis, hw(jUptimeMillis));
    }

    public void hn() {
        pr(-4, (BaseException) null);
    }

    public void x() {
        this.hn.setStatus(-2);
        try {
            this.x.x(this.hn.getId(), this.hn.getCurBytes());
        } catch (SQLiteException e) {
        }
        pr(-2, (BaseException) null);
    }

    public void c() {
        this.hn.setStatus(-7);
        try {
            this.x.vk(this.hn.getId());
        } catch (SQLiteException e) {
        }
        pr(-7, (BaseException) null);
    }

    public void pr(BaseException baseException, boolean z) {
        this.hn.setFirstDownload(false);
        this.k.set(0L);
        hw(baseException, z);
    }

    public void pr(com.byazt.auw.hw hwVar, BaseException baseException, boolean z) {
        this.hn.setFirstDownload(false);
        this.k.set(0L);
        this.x.zo(this.hn.getId());
        pr(z ? 10 : 9, baseException, true);
    }

    public void pr(BaseException baseException) {
        this.hn.setFirstDownload(false);
        hw(baseException);
    }

    private void hw(BaseException baseException) {
        Log.getStackTraceString(new Throwable());
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.x.uc(this.hn.getId());
            } catch (SQLiteException e) {
            }
        } else {
            try {
                this.x.hw(this.hn.getId(), this.hn.getCurBytes());
            } catch (SQLiteException e2) {
                try {
                    this.x.uc(this.hn.getId());
                } catch (SQLiteException e3) {
                }
            }
        }
        BaseException baseExceptionHn = hn(baseException);
        this.hn.setFailedException(baseExceptionHn);
        pr(baseExceptionHn instanceof com.byazt.lhc.c ? -2 : -1, baseExceptionHn);
        if (com.byazt.ew.pr.pr(this.hn.getId()).pr("retry_schedule", 0) > 0) {
            com.byazt.ts.lb.pr().pr(this.hn);
        }
    }

    private BaseException hn(BaseException baseException) {
        Context contextOf;
        if (com.byazt.ew.pr.pr(this.hn.getId()).pr("download_failed_check_net", 1) == 1 && com.byazt.tuy.uc.aj(baseException) && (contextOf = hn.of()) != null && !com.byazt.tuy.uc.hn(contextOf)) {
            return new BaseException(this.hn.isOnlyWifi() ? PointerIconCompat.TYPE_ALL_SCROLL : 1049, baseException.getErrorMessage());
        }
        return baseException;
    }

    public void uc() {
        this.hn.setFirstDownload(false);
        if (!this.hn.isIgnoreDataVerify() && this.hn.getCurBytes() != this.hn.getTotalBytes()) {
            com.byazt.p000do.pr.hw(pr, this.hn.getErrorBytesLog());
            pr(new com.byazt.lhc.uc(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.hn.getByteInvalidRetryStatus()));
            return;
        }
        if (this.hn.getCurBytes() <= 0) {
            com.byazt.p000do.pr.hw(pr, this.hn.getErrorBytesLog());
            pr(new com.byazt.lhc.uc(1026, "curBytes is 0, bytes changed with process : " + this.hn.getByteInvalidRetryStatus()));
            return;
        }
        if (!this.hn.isIgnoreDataVerify() && this.hn.getTotalBytes() <= 0) {
            com.byazt.p000do.pr.hw(pr, this.hn.getErrorBytesLog());
            pr(new com.byazt.lhc.uc(1044, "TotalBytes is 0, bytes changed with process : " + this.hn.getByteInvalidRetryStatus()));
            return;
        }
        com.byazt.p000do.pr.hw(pr, this.hn.getName() + " onCompleted start save file as target name");
        rc monitorDepend = this.yb;
        DownloadTask downloadTask = this.uc;
        if (downloadTask != null) {
            monitorDepend = downloadTask.getMonitorDepend();
        }
        com.byazt.tuy.uc.pr(this.hn, monitorDepend, new e() { // from class: com.byazt.lj.uc.2
            @Override // com.byazt.fn.e
            public void pr() {
                uc.this.k();
            }

            @Override // com.byazt.fn.e
            public void pr(BaseException baseException) {
                com.byazt.p000do.pr.hw(uc.pr, "saveFileAsTargetName onFailed : " + (baseException != null ? baseException.getErrorMessage() : ""));
                uc.this.pr(baseException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            com.byazt.p000do.pr.hw(pr, "saveFileAsTargetName onSuccess");
            try {
                m();
                this.hn.setFirstSuccess(false);
                this.hn.setSuccessByCache(false);
                pr(-3, (BaseException) null);
                this.x.hn(this.hn.getId(), this.hn.getTotalBytes());
                this.x.x(this.hn.getId());
                this.x.m(this.hn.getId());
            } catch (BaseException e) {
                pr(e);
            }
        } catch (Throwable th) {
            pr(new BaseException(1008, com.byazt.tuy.uc.hw(th, "onCompleted")));
        }
    }

    public void fw() throws BaseException {
        if (this.hw) {
            m();
            com.byazt.p000do.pr.hw(pr, "onCompleteForFileExist");
            this.hn.setSuccessByCache(true);
            pr(-3, (BaseException) null);
            this.x.hn(this.hn.getId(), this.hn.getTotalBytes());
            this.x.x(this.hn.getId());
            this.x.pr(this.hn);
            this.x.m(this.hn.getId());
            return;
        }
        m();
        com.byazt.p000do.pr.hw(pr, "onCompleteForFileExist");
        this.hn.setSuccessByCache(true);
        pr(-3, (BaseException) null);
        this.x.hn(this.hn.getId(), this.hn.getTotalBytes());
        this.x.x(this.hn.getId());
        this.x.m(this.hn.getId());
    }

    public void pr(String str) throws BaseException {
        com.byazt.p000do.pr.hw(pr, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.hn.getName());
        if (this.hw) {
            com.byazt.tuy.uc.pr(this.hn, str);
            m();
            this.hn.setSuccessByCache(true);
            pr(-3, (BaseException) null);
            this.x.pr(this.hn);
            return;
        }
        this.x.pr(this.hn);
        com.byazt.tuy.uc.pr(this.hn, str);
        this.hn.setSuccessByCache(true);
        m();
        pr(-3, (BaseException) null);
    }

    private void m() throws BaseException {
        List<com.byazt.fn.m> downloadCompleteHandlers = this.uc.getDownloadCompleteHandlers();
        if (!downloadCompleteHandlers.isEmpty()) {
            DownloadInfo downloadInfo = this.hn;
            pr(11, (BaseException) null);
            this.x.pr(downloadInfo);
            for (com.byazt.fn.m mVar : downloadCompleteHandlers) {
                try {
                    if (mVar.hw(downloadInfo)) {
                        mVar.pr(downloadInfo);
                        this.x.pr(downloadInfo);
                    }
                } catch (BaseException e) {
                    throw e;
                } catch (Throwable th) {
                    throw new BaseException(1071, th);
                }
            }
        }
    }

    private boolean pr(long j, boolean z) {
        boolean z2 = false;
        if (this.hn.getCurBytes() == this.hn.getTotalBytes()) {
            try {
                this.x.pr(this.hn.getId(), this.hn.getCurBytes());
            } catch (Exception e) {
            }
            return false;
        }
        if (this.vk) {
            this.vk = false;
            this.hn.setStatus(4);
        }
        if (this.hn.isNeedPostProgress() && z) {
            z2 = true;
        }
        pr(4, (BaseException) null, z2);
        return z;
    }

    private boolean hw(long j) {
        boolean z = true;
        if (!this.m) {
            this.m = true;
            return true;
        }
        long j2 = j - this.w;
        if (this.k.get() < this.ho && j2 < this.g) {
            z = false;
        }
        if (z) {
            this.w = j;
            this.k.set(0L);
        }
        return z;
    }

    private void hw(BaseException baseException, boolean z) {
        this.x.zo(this.hn.getId());
        pr(z ? 7 : 5, baseException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, BaseException baseException) {
        pr(i, baseException, true);
    }

    public void zo() {
        this.hn.setStatus(8);
        this.hn.setAsyncHandleStatus(com.byazt.mrs.pr.ASYNC_HANDLE_WAITING);
        com.byazt.ts.pr prVarNl = hn.nl();
        if (prVarNl != null) {
            prVarNl.pr(this.hn.getId(), this.uc.getHashCodeForSameTask(), 8);
        }
    }

    private void pr(int i, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.hn.getStatus();
        if (status == -3 && i == 4) {
            return;
        }
        vk();
        if (i != 4 && DownloadStatus.isRealTimeUploadStatus(i)) {
            this.hn.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i)) {
                this.hn.updateDownloadTime();
            }
        }
        if (!this.hn.isAddListenerToSameTask()) {
            com.byazt.cha.pr.pr(this.uc, baseException, i);
        }
        if (i == 6) {
            this.hn.setStatus(2);
        } else if (i == -6) {
            this.hn.setStatus(-3);
        } else {
            this.hn.setStatus(i);
        }
        if (status == -3 || status == -1) {
            if (this.hn.getRetryDelayStatus() == com.byazt.mrs.fw.DELAY_RETRY_DOWNLOADING) {
                this.hn.setRetryDelayStatus(com.byazt.mrs.fw.DELAY_RETRY_DOWNLOADED);
            }
            if (this.hn.getAsyncHandleStatus() == com.byazt.mrs.pr.ASYNC_HANDLE_DOWNLOADING) {
                this.hn.setAsyncHandleStatus(com.byazt.mrs.pr.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.hn.getByteInvalidRetryStatus() == com.byazt.mrs.hw.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.hn.setByteInvalidRetryStatus(com.byazt.mrs.hw.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.byazt.tuy.hn.pr(i, this.zo, true, this.hn, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.c != null && (((sparseArray = this.fw) != null && sparseArray.size() > 0) || ((sparseArray2 = this.aj) != null && sparseArray2.size() > 0 && (this.hn.canShowNotification() || this.hn.isAutoInstallWithoutNotification())))) {
            this.c.obtainMessage(i, this.hn.getId(), this.uc.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.byazt.ts.pr prVarNl = hn.nl();
        if (prVarNl != null) {
            prVarNl.pr(this.hn.getId(), this.uc.getHashCodeForSameTask(), i);
        }
    }
}
