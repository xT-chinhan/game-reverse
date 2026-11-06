package com.byazt.xv;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.byazt.je.IDownloadListener;
import com.byazt.je.an;
import com.byazt.je.m;
import com.byazt.qx.BaseException;
import com.byazt.sk.DownloadStatus;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 41, 13})
public class w {
    public static final String n = "w";
    public com.byazt.je.sz cy;
    public SparseArray<IDownloadListener> fs;
    public m hd;
    public long k;
    public final Handler l;
    public final tj q;
    public final boolean qg;
    public SparseArray<IDownloadListener> rv;
    public DownloadInfo s;
    public int sz;
    public DownloadTask w;
    public SparseArray<IDownloadListener> x;
    public boolean tj = false;
    public volatile long cp = 0;
    public final AtomicLong d = new AtomicLong();
    public boolean oa = false;

    public w(DownloadTask downloadTask, Handler handler) {
        this.w = downloadTask;
        tj();
        this.l = handler;
        this.q = s.hu();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.qg = com.byazt.f.n.n(downloadInfo.getId()).n("fix_start_with_file_exist_update_error");
        } else {
            this.qg = false;
        }
    }

    private void tj() {
        DownloadTask downloadTask = this.w;
        if (downloadTask != null) {
            this.s = downloadTask.getDownloadInfo();
            this.x = this.w.getDownloadListeners(com.byazt.sk.w.MAIN);
            this.rv = this.w.getDownloadListeners(com.byazt.sk.w.NOTIFICATION);
            this.fs = this.w.getDownloadListeners(com.byazt.sk.w.SUB);
            this.cy = this.w.getDepend();
            this.hd = this.w.getMonitorDepend();
        }
    }

    public void n() {
        if (this.s.canSkipStatusHandler()) {
            return;
        }
        this.s.setStatus(1);
        cp();
    }

    private void cp() {
        ExecutorService executorServiceD = s.d();
        if (executorServiceD != null) {
            executorServiceD.execute(new Runnable() { // from class: com.byazt.xv.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w.this.q.rv(w.this.s.getId());
                    w.this.n(1, (BaseException) null);
                }
            });
        }
    }

    public void qg() {
        if (this.s.canSkipStatusHandler()) {
            this.s.changeSkipStatus();
            return;
        }
        this.q.x(this.s.getId());
        if (this.s.isFirstDownload()) {
            n(6, (BaseException) null);
        }
        n(2, (BaseException) null);
    }

    public void n(long j, String str, String str2) {
        this.s.setTotalBytes(j);
        this.s.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.s.getName())) {
            this.s.setName(str2);
        }
        try {
            this.q.n(this.s.getId(), j, str, str2);
        } catch (Exception unused) {
        }
        n(3, (BaseException) null);
        this.k = this.s.getMinByteIntervalForPostToMainThread(j);
        this.sz = this.s.getMinProgressTimeMsInterval();
        this.tj = true;
        com.byazt.i.cd.n().l();
    }

    public boolean n(long j) {
        this.d.addAndGet(j);
        this.s.increaseCurBytes(j);
        long jUptimeMillis = SystemClock.uptimeMillis();
        return n(jUptimeMillis, qg(jUptimeMillis));
    }

    public void s() {
        n(-4, (BaseException) null);
    }

    public void q() {
        this.s.setStatus(-2);
        try {
            this.q.q(this.s.getId(), this.s.getCurBytes());
        } catch (SQLiteException unused) {
        }
        n(-2, (BaseException) null);
    }

    public void l() {
        this.s.setStatus(-7);
        try {
            this.q.tj(this.s.getId());
        } catch (SQLiteException unused) {
        }
        n(-7, (BaseException) null);
    }

    public void n(BaseException baseException, boolean z) {
        this.s.setFirstDownload(false);
        this.d.set(0L);
        qg(baseException, z);
    }

    public void n(com.byazt.wm.qg qgVar, BaseException baseException, boolean z) {
        this.s.setFirstDownload(false);
        this.d.set(0L);
        this.q.fs(this.s.getId());
        n(z ? 10 : 9, baseException, true);
    }

    public void n(BaseException baseException) {
        this.s.setFirstDownload(false);
        qg(baseException);
    }

    private void qg(BaseException baseException) {
        Log.getStackTraceString(new Throwable());
        try {
            if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
                this.q.w(this.s.getId());
            } else {
                try {
                    this.q.qg(this.s.getId(), this.s.getCurBytes());
                } catch (SQLiteException unused) {
                    this.q.w(this.s.getId());
                }
            }
        } catch (SQLiteException unused2) {
        }
        BaseException baseExceptionS = s(baseException);
        this.s.setFailedException(baseExceptionS);
        n(baseExceptionS instanceof com.byazt.qx.l ? -2 : -1, baseExceptionS);
        if (com.byazt.f.n.n(this.s.getId()).n("retry_schedule", 0) > 0) {
            com.byazt.i.cd.n().n(this.s);
        }
    }

    private BaseException s(BaseException baseException) {
        Context contextU;
        if (com.byazt.f.n.n(this.s.getId()).n("download_failed_check_net", 1) != 1 || !com.byazt.ta.w.rv(baseException) || (contextU = s.u()) == null || com.byazt.ta.w.s(contextU)) {
            return baseException;
        }
        return new BaseException(this.s.isOnlyWifi() ? PointerIconCompat.TYPE_ALL_SCROLL : 1049, baseException.getErrorMessage());
    }

    public void w() {
        this.s.setFirstDownload(false);
        if (!this.s.isIgnoreDataVerify() && this.s.getCurBytes() != this.s.getTotalBytes()) {
            com.byazt.fe.n.qg(n, this.s.getErrorBytesLog());
            n(new com.byazt.qx.w(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.s.getByteInvalidRetryStatus()));
            return;
        }
        if (this.s.getCurBytes() <= 0) {
            com.byazt.fe.n.qg(n, this.s.getErrorBytesLog());
            n(new com.byazt.qx.w(1026, "curBytes is 0, bytes changed with process : " + this.s.getByteInvalidRetryStatus()));
            return;
        }
        if (!this.s.isIgnoreDataVerify() && this.s.getTotalBytes() <= 0) {
            com.byazt.fe.n.qg(n, this.s.getErrorBytesLog());
            n(new com.byazt.qx.w(1044, "TotalBytes is 0, bytes changed with process : " + this.s.getByteInvalidRetryStatus()));
            return;
        }
        com.byazt.fe.n.qg(n, this.s.getName() + " onCompleted start save file as target name");
        m monitorDepend = this.hd;
        DownloadTask downloadTask = this.w;
        if (downloadTask != null) {
            monitorDepend = downloadTask.getMonitorDepend();
        }
        com.byazt.ta.w.n(this.s, monitorDepend, new an() { // from class: com.byazt.xv.w.2
            @Override // com.byazt.je.an
            public void n() {
                w.this.d();
            }

            @Override // com.byazt.je.an
            public void n(BaseException baseException) {
                com.byazt.fe.n.qg(w.n, "saveFileAsTargetName onFailed : " + (baseException != null ? baseException.getErrorMessage() : ""));
                w.this.n(baseException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            com.byazt.fe.n.qg(n, "saveFileAsTargetName onSuccess");
            try {
                oa();
                this.s.setFirstSuccess(false);
                this.s.setSuccessByCache(false);
                n(-3, (BaseException) null);
                this.q.s(this.s.getId(), this.s.getTotalBytes());
                this.q.q(this.s.getId());
                this.q.oa(this.s.getId());
            } catch (BaseException e) {
                n(e);
            }
        } catch (Throwable th) {
            n(new BaseException(PointerIconCompat.TYPE_TEXT, com.byazt.ta.w.qg(th, "onCompleted")));
        }
    }

    public void x() throws BaseException {
        if (this.qg) {
            oa();
            com.byazt.fe.n.qg(n, "onCompleteForFileExist");
            this.s.setSuccessByCache(true);
            n(-3, (BaseException) null);
            this.q.s(this.s.getId(), this.s.getTotalBytes());
            this.q.q(this.s.getId());
            this.q.n(this.s);
            this.q.oa(this.s.getId());
            return;
        }
        oa();
        com.byazt.fe.n.qg(n, "onCompleteForFileExist");
        this.s.setSuccessByCache(true);
        n(-3, (BaseException) null);
        this.q.s(this.s.getId(), this.s.getTotalBytes());
        this.q.q(this.s.getId());
        this.q.oa(this.s.getId());
    }

    public void n(String str) throws BaseException {
        com.byazt.fe.n.qg(n, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.s.getName());
        if (this.qg) {
            com.byazt.ta.w.n(this.s, str);
            oa();
            this.s.setSuccessByCache(true);
            n(-3, (BaseException) null);
            this.q.n(this.s);
            return;
        }
        this.q.n(this.s);
        com.byazt.ta.w.n(this.s, str);
        this.s.setSuccessByCache(true);
        oa();
        n(-3, (BaseException) null);
    }

    private void oa() throws BaseException {
        List<com.byazt.je.oa> downloadCompleteHandlers = this.w.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.s;
        n(11, (BaseException) null);
        this.q.n(downloadInfo);
        for (com.byazt.je.oa oaVar : downloadCompleteHandlers) {
            try {
                if (oaVar.qg(downloadInfo)) {
                    oaVar.n(downloadInfo);
                    this.q.n(downloadInfo);
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    private boolean n(long j, boolean z) {
        boolean z2 = false;
        if (this.s.getCurBytes() == this.s.getTotalBytes()) {
            try {
                this.q.n(this.s.getId(), this.s.getCurBytes());
            } catch (Exception unused) {
            }
            return false;
        }
        if (this.tj) {
            this.tj = false;
            this.s.setStatus(4);
        }
        if (this.s.isNeedPostProgress() && z) {
            z2 = true;
        }
        n(4, (BaseException) null, z2);
        return z;
    }

    private boolean qg(long j) {
        boolean z = true;
        if (!this.oa) {
            this.oa = true;
            return true;
        }
        long j2 = j - this.cp;
        if (this.d.get() < this.k && j2 < this.sz) {
            z = false;
        }
        if (z) {
            this.cp = j;
            this.d.set(0L);
        }
        return z;
    }

    private void qg(BaseException baseException, boolean z) {
        this.q.fs(this.s.getId());
        n(z ? 7 : 5, baseException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, BaseException baseException) {
        n(i, baseException, true);
    }

    public void fs() {
        this.s.setStatus(8);
        this.s.setAsyncHandleStatus(com.byazt.sk.n.ASYNC_HANDLE_WAITING);
        com.byazt.i.n nVarLn = s.ln();
        if (nVarLn != null) {
            nVarLn.n(this.s.getId(), this.w.getHashCodeForSameTask(), 8);
        }
    }

    private void n(int i, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.s.getStatus();
        if (status == -3 && i == 4) {
            return;
        }
        tj();
        if (i != 4 && DownloadStatus.isRealTimeUploadStatus(i)) {
            this.s.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i)) {
                this.s.updateDownloadTime();
            }
        }
        if (!this.s.isAddListenerToSameTask()) {
            com.byazt.g.n.n(this.w, baseException, i);
        }
        if (i == 6) {
            this.s.setStatus(2);
        } else if (i == -6) {
            this.s.setStatus(-3);
        } else {
            this.s.setStatus(i);
        }
        if (status == -3 || status == -1) {
            if (this.s.getRetryDelayStatus() == com.byazt.sk.x.DELAY_RETRY_DOWNLOADING) {
                this.s.setRetryDelayStatus(com.byazt.sk.x.DELAY_RETRY_DOWNLOADED);
            }
            if (this.s.getAsyncHandleStatus() == com.byazt.sk.n.ASYNC_HANDLE_DOWNLOADING) {
                this.s.setAsyncHandleStatus(com.byazt.sk.n.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.s.getByteInvalidRetryStatus() == com.byazt.sk.qg.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.s.setByteInvalidRetryStatus(com.byazt.sk.qg.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.byazt.ta.s.n(i, this.fs, true, this.s, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.l != null && (((sparseArray = this.x) != null && sparseArray.size() > 0) || ((sparseArray2 = this.rv) != null && sparseArray2.size() > 0 && (this.s.canShowNotification() || this.s.isAutoInstallWithoutNotification())))) {
            this.l.obtainMessage(i, this.s.getId(), this.w.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.byazt.i.n nVarLn = s.ln();
        if (nVarLn != null) {
            nVarLn.n(this.s.getId(), this.w.getHashCodeForSameTask(), i);
        }
    }
}
