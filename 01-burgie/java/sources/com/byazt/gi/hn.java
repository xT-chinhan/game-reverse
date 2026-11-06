package com.byazt.gi;

import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.edb.aj;
import com.byazt.edb.k;
import com.byazt.fn.IDownloadInterceptor;
import com.byazt.fn.fo;
import com.byazt.fn.lb;
import com.byazt.fn.rc;
import com.byazt.fn.yb;
import com.byazt.lhc.BaseException;
import com.byazt.lj.qa;
import com.byazt.lj.vk;
import com.byazt.stx.g;
import com.byazt.stx.w;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.update.download.core.Util;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 587, 20})
public class hn implements uc, Runnable {
    public static final String pr = hn.class.getSimpleName();
    public final com.byazt.lj.fw a;
    public boolean aj;
    public fo b;
    public AtomicInteger c;
    public qa cz;
    public long e;
    public volatile BaseException fo;
    public volatile com.byazt.lj.c fw;
    public final DownloadTask hn;
    public final vk ho;
    public Future hw;
    public lb iu;
    public boolean k;
    public final com.byazt.lj.zo lb;
    public final AtomicBoolean m;
    public long n;
    public DownloadInfo nt;
    public final com.byazt.lj.uc ny;
    public com.byazt.lj.fw qa;
    public aj rc;
    public final com.byazt.ew.pr s;
    public boolean vk;
    public boolean w;
    public String y;
    public com.byazt.lj.zo yb;
    public com.byazt.edb.fw z;
    public boolean zo;
    public volatile boolean x = false;
    public final ArrayList<hw> uc = new ArrayList<>();
    public volatile com.byazt.mrs.zo g = com.byazt.mrs.zo.RUN_STATUS_NONE;
    public volatile int ve = 5;
    public boolean gz = false;
    public boolean nl = false;
    public boolean ww = false;
    public int ls = 0;
    public volatile w er = null;

    public hn(DownloadTask downloadTask, Handler handler) {
        this.hn = downloadTask;
        if (downloadTask != null) {
            this.nt = downloadTask.getDownloadInfo();
            this.yb = downloadTask.getChunkStrategy();
            this.qa = downloadTask.getChunkAdjustCalculator();
            this.b = downloadTask.getForbiddenHandler();
            this.iu = downloadTask.getDiskSpaceHandler();
            this.cz = pr(downloadTask);
            this.s = com.byazt.ew.pr.pr(this.nt.getId());
        } else {
            this.s = com.byazt.ew.pr.hn();
        }
        zo();
        this.ho = com.byazt.lj.hn.z();
        this.lb = com.byazt.lj.hn.ls();
        this.a = com.byazt.lj.hn.v();
        this.ny = new com.byazt.lj.uc(downloadTask, handler);
        this.m = new AtomicBoolean(true);
    }

    private void zo() {
        DownloadInfo downloadInfo = this.nt;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.nt.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger == null) {
            this.c = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    public void pr() {
        this.g = com.byazt.mrs.zo.RUN_STATUS_PAUSE;
        if (this.er != null) {
            this.er.hw();
        }
        if (this.fw != null) {
            this.fw.hw();
        }
        if (this.er == null && this.fw == null) {
            qa();
            this.g = com.byazt.mrs.zo.RUN_STATUS_PAUSE;
            nt();
        }
        try {
            for (hw hwVar : (ArrayList) this.uc.clone()) {
                if (hwVar != null) {
                    hwVar.pr();
                }
            }
        } catch (Throwable th) {
        }
    }

    public void hw() {
        this.g = com.byazt.mrs.zo.RUN_STATUS_CANCELED;
        if (this.er != null) {
            this.er.pr();
        }
        if (this.fw != null) {
            this.fw.hn();
        }
        if (this.er == null && this.fw == null) {
            qa();
            this.g = com.byazt.mrs.zo.RUN_STATUS_CANCELED;
            nt();
        }
        s();
    }

    public DownloadTask hn() {
        return this.hn;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005e  */
    private int pr(long j, List<com.byazt.auw.hw> list) {
        int iPr;
        int iPr2;
        if (gz()) {
            if (this.aj) {
                if (list != null) {
                    iPr = list.size();
                } else {
                    iPr = this.nt.getChunkCount();
                }
            } else {
                com.byazt.lj.zo zoVar = this.yb;
                if (zoVar != null) {
                    iPr2 = zoVar.pr(j);
                } else {
                    iPr2 = this.lb.pr(j);
                }
                k kVarHw = com.byazt.edb.w.pr().hw();
                com.byazt.p000do.pr.hw(pr, String.format("NetworkQuality is : %s", kVarHw.name()));
                this.nt.setNetworkQuality(kVarHw.name());
                com.byazt.lj.fw fwVar = this.qa;
                if (fwVar != null) {
                    iPr = fwVar.pr(iPr2, kVarHw);
                } else {
                    iPr = this.a.pr(iPr2, kVarHw);
                }
            }
            if (iPr <= 0) {
                iPr = 1;
            }
        } else {
            iPr = 1;
        }
        if (com.byazt.p000do.pr.pr()) {
            com.byazt.p000do.pr.hw(pr, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(iPr), this.nt.getName(), String.valueOf(j)));
        }
        return iPr;
    }

    private boolean aj() {
        int status = this.nt.getStatus();
        if (status == 1 || this.nt.canSkipStatusHandler()) {
            return true;
        }
        if (status != -2 && status != -4) {
            hw(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
            return false;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:65:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f6 A[Catch: SQLiteException -> 0x00fe, TRY_LEAVE, TryCatch #7 {SQLiteException -> 0x00fe, blocks: (B:77:0x00ee, B:79:0x00f6), top: B:86:0x00ee }] */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    private void vk() throws com.byazt.lhc.pr {
        Throwable th;
        DownloadTask downloadTask;
        com.byazt.lhc.pr prVar;
        boolean z = false;
        boolean z2 = true;
        try {
            try {
                try {
                    int id = this.nt.getId();
                    if (this.ho != null) {
                        if (com.byazt.tuy.pr.pr(2048)) {
                            this.ho.c();
                        }
                        DownloadInfo downloadInfoHw = this.ho.hw(id);
                        if (downloadInfoHw != null && !downloadInfoHw.isNewTask()) {
                            String savePath = this.nt.getSavePath();
                            String md5 = this.nt.getMd5();
                            this.nt.copyFromCacheData(downloadInfoHw, true);
                            boolean z3 = com.byazt.tuy.pr.pr(4096) && downloadInfoHw != this.nt;
                            try {
                                if (savePath.equals(downloadInfoHw.getSavePath()) && com.byazt.tuy.uc.pr(downloadInfoHw, false, md5)) {
                                    try {
                                        throw new com.byazt.lhc.pr(downloadInfoHw.getName());
                                    } catch (com.byazt.lhc.pr e) {
                                        prVar = e;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z = z3;
                                        downloadTask = this.hn;
                                        if (downloadTask != null && this.nt != null) {
                                            com.byazt.cha.pr.pr(downloadTask.getMonitorDepend(), this.nt, new BaseException(1003, com.byazt.tuy.uc.hw(th, "checkTaskCache")), this.nt.getStatus());
                                        }
                                        if (z) {
                                            if (z2 || this.s.pr("fix_file_exist_update_download_info")) {
                                                this.ho.pr(this.nt);
                                            }
                                            return;
                                        }
                                    }
                                } else if (com.byazt.lj.hn.pr(downloadInfoHw) != id) {
                                    try {
                                        this.ho.uc(id);
                                    } catch (SQLiteException e2) {
                                    }
                                } else {
                                    z2 = z3;
                                }
                            } catch (com.byazt.lhc.pr e3) {
                                prVar = e3;
                            } catch (Throwable th3) {
                                th = th3;
                                z2 = false;
                            }
                            throw prVar;
                        }
                        this.nt.reset();
                    } else {
                        z2 = false;
                    }
                    try {
                        zo();
                        if (z2) {
                            this.ho.pr(this.nt);
                        }
                    } catch (com.byazt.lhc.pr e4) {
                    } catch (Throwable th4) {
                        th = th4;
                        boolean z4 = z2;
                        z2 = false;
                        z = z4;
                        downloadTask = this.hn;
                        if (downloadTask != null) {
                            com.byazt.cha.pr.pr(downloadTask.getMonitorDepend(), this.nt, new BaseException(1003, com.byazt.tuy.uc.hw(th, "checkTaskCache")), this.nt.getStatus());
                        }
                        if (z) {
                            if (z2) {
                            }
                            this.ho.pr(this.nt);
                        }
                    }
                } catch (Throwable th5) {
                    if (0 != 0) {
                        if (1 != 0) {
                            try {
                                if (this.s.pr("fix_file_exist_update_download_info")) {
                                    this.ho.pr(this.nt);
                                }
                            } catch (SQLiteException e5) {
                            }
                        } else {
                            this.ho.pr(this.nt);
                        }
                    }
                    throw th5;
                }
            } catch (com.byazt.lhc.pr e6) {
                throw e6;
            } catch (Throwable th6) {
                th = th6;
                z2 = false;
            }
        } catch (SQLiteException e7) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.byazt.lj.hn.pr(this.hn, 3);
        try {
            com.byazt.edb.hw.pr().hw();
            w();
            com.byazt.edb.hw.pr().hn();
            com.byazt.lj.hn.hw(this.hn, 3);
        } catch (Throwable th) {
            com.byazt.edb.hw.pr().hn();
            throw th;
        }
    }

    private void w() {
        Process.setThreadPriority(10);
        try {
            DownloadInfo downloadInfo = this.nt;
            if (downloadInfo != null && this.e > 0) {
                downloadInfo.increaseDownloadPrepareTime(System.currentTimeMillis() - this.e);
            }
        } catch (Throwable th) {
        }
        try {
            IDownloadInterceptor interceptor = this.hn.getInterceptor();
            if (interceptor != null && interceptor.intercepte()) {
                this.ny.c();
                return;
            }
        } catch (Throwable th2) {
        }
        if (!aj()) {
            rc monitorDepend = this.hn.getMonitorDepend();
            DownloadInfo downloadInfo2 = this.nt;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo3 = this.nt;
            com.byazt.cha.pr.pr(monitorDepend, downloadInfo2, baseException, downloadInfo3 != null ? downloadInfo3.getStatus() : 0);
            return;
        }
        while (true) {
            k();
            if (this.gz) {
                if (this.ve > 0) {
                    this.ve--;
                } else if (this.nt.getCurBytes() != this.nt.getTotalBytes()) {
                    com.byazt.p000do.pr.hw(pr, this.nt.getErrorBytesLog());
                    this.ny.pr(new com.byazt.lhc.uc(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.nt.getByteInvalidRetryStatus()));
                    return;
                } else if (this.nt.getCurBytes() <= 0) {
                    com.byazt.p000do.pr.hw(pr, this.nt.getErrorBytesLog());
                    this.ny.pr(new com.byazt.lhc.uc(1026, "curBytes is 0, bytes invalid retry status is : " + this.nt.getByteInvalidRetryStatus()));
                    return;
                } else if (this.nt.getTotalBytes() <= 0) {
                    com.byazt.p000do.pr.hw(pr, this.nt.getErrorBytesLog());
                    this.ny.pr(new com.byazt.lhc.uc(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.nt.getByteInvalidRetryStatus()));
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void k() {
        boolean z;
        try {
            this.g = com.byazt.mrs.zo.RUN_STATUS_NONE;
            this.nt.updateStartDownloadTime();
            this.nt.resetRealStartDownloadTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.nt.setFirstSpeedTime(-1L);
            try {
                vk();
                z = false;
            } catch (com.byazt.lhc.pr e) {
                com.byazt.p000do.pr.hw(pr, "file exist " + e.pr());
                this.y = e.pr();
                z = true;
            }
            if (!this.gz) {
                this.ny.hw();
            }
            this.gz = false;
            if (ny()) {
                nt();
                return;
            }
            if (!TextUtils.isEmpty(this.y) && z) {
                if (this.nt.isExpiredRedownload()) {
                    this.ww = com.byazt.tuy.uc.x(this.nt);
                }
                if (!this.ww) {
                    m();
                    nt();
                    return;
                }
            }
            while (true) {
                if (ny()) {
                    nt();
                    return;
                }
                try {
                    try {
                        try {
                            ww();
                            ve();
                            y();
                            List<com.byazt.auw.hw> listHn = this.ho.hn(this.nt.getId());
                            n();
                            if (g()) {
                                com.byazt.p000do.pr.hn(pr, "downloadSegments return");
                                qa();
                                nt();
                                return;
                            }
                            String connectionUrl = this.nt.getConnectionUrl();
                            if (ny()) {
                                qa();
                                nt();
                                return;
                            }
                            long jC = this.aj ? com.byazt.tuy.uc.c(this.nt) : 0L;
                            com.byazt.auw.hw hwVarPr = pr(this.nt, jC);
                            List<com.byazt.auw.hn> listPr = pr(hwVarPr);
                            com.byazt.tuy.uc.pr(listPr, this.nt);
                            com.byazt.tuy.uc.hw(listPr, this.nt);
                            this.nt.setPreconnectLevel(0);
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            try {
                                pr(connectionUrl, listPr, jC);
                                this.nt.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                if (ny()) {
                                    qa();
                                    nt();
                                    return;
                                }
                                long totalBytes = this.nt.getTotalBytes();
                                pr(totalBytes);
                                int iPr = pr(totalBytes, listHn);
                                if (ny()) {
                                    qa();
                                    nt();
                                    return;
                                }
                                if (iPr <= 0) {
                                    throw new BaseException(1032, "chunkCount is 0");
                                }
                                boolean z2 = iPr == 1;
                                this.zo = z2;
                                if (!z2) {
                                    if (!this.nt.isNeedReuseFirstConnection()) {
                                        lb();
                                    }
                                    if (!ny()) {
                                        ho();
                                        this.nt.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                                        if (!this.aj) {
                                            pr(totalBytes, iPr);
                                            break;
                                        } else {
                                            pr(iPr, listHn);
                                            break;
                                        }
                                    }
                                    qa();
                                    nt();
                                    return;
                                }
                                if (this.rc == null) {
                                    try {
                                        jCurrentTimeMillis2 = System.currentTimeMillis();
                                        pr(connectionUrl, listPr);
                                        this.nt.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                    } catch (Throwable th) {
                                        this.nt.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                        throw th;
                                    }
                                }
                                if (!ny()) {
                                    this.nt.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                                    ho();
                                    pr(hwVarPr, connectionUrl, this.rc);
                                    break;
                                } else {
                                    qa();
                                    nt();
                                    return;
                                }
                            } catch (Throwable th2) {
                                this.nt.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                throw th2;
                            }
                        } catch (com.byazt.lhc.aj e2) {
                            try {
                                com.byazt.p000do.pr.x(pr, "downloadInner: retry throwable for " + e2.pr());
                                if (this.g == com.byazt.mrs.zo.RUN_STATUS_PAUSE) {
                                    break;
                                }
                                AtomicInteger atomicInteger = this.c;
                                if (atomicInteger != null && atomicInteger.get() > 0) {
                                    this.nt.updateCurRetryTime(this.c.decrementAndGet());
                                    this.nt.setStatus(5);
                                } else if (this.c == null) {
                                    hw(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e2.pr()));
                                    break;
                                } else if (!this.nt.trySwitchToNextBackupUrl()) {
                                    hw(new BaseException(PointerIconCompat.TYPE_ZOOM_IN, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.nt.getRetryCount()), e2.pr())));
                                    break;
                                } else {
                                    this.nt.setStatus(5);
                                    this.c.set(this.nt.getRetryCount());
                                    this.nt.updateCurRetryTime(this.c.get());
                                }
                                qa();
                            } catch (Throwable th3) {
                                qa();
                                throw th3;
                            }
                        }
                    } catch (BaseException e3) {
                        com.byazt.p000do.pr.x(pr, "downloadInner: baseException = " + e3);
                        if (this.g == com.byazt.mrs.zo.RUN_STATUS_PAUSE) {
                            break;
                        }
                        if (e3.getErrorCode() != 1025 && e3.getErrorCode() != 1009) {
                            if (!pr(e3)) {
                                hw(e3);
                                break;
                            }
                            if (com.byazt.tuy.uc.pr(e3)) {
                                e();
                            }
                            if (pr(e3, 0L) == com.byazt.lhc.zo.RETURN) {
                                qa();
                                nt();
                                return;
                            }
                            qa();
                        }
                        this.g = com.byazt.mrs.zo.RUN_STATUS_END_RIGHT_NOW;
                        qa();
                        nt();
                        return;
                    }
                } catch (com.byazt.lhc.pr e4) {
                    m();
                } catch (Throwable th4) {
                    com.byazt.p000do.pr.x(pr, "downloadInner: throwable =  " + th4);
                    if (this.g != com.byazt.mrs.zo.RUN_STATUS_PAUSE) {
                        hw(new BaseException(1045, th4));
                    }
                }
                qa();
            }
            qa();
            nt();
        } catch (Throwable th5) {
            nt();
            throw th5;
        }
    }

    private void m() {
        com.byazt.p000do.pr.hw(pr, "finishWithFileExist");
        if (com.byazt.ew.pr.hn().hw("fix_end_for_file_exist_error", true)) {
            if (this.y.equals(this.nt.getName())) {
                this.g = com.byazt.mrs.zo.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.g = com.byazt.mrs.zo.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.y.equals(this.nt.getTargetFilePath())) {
            this.g = com.byazt.mrs.zo.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.g = com.byazt.mrs.zo.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private boolean g() throws InterruptedException, BaseException {
        if (this.nt.isExpiredRedownload() || this.nt.getChunkCount() != 1 || this.nt.getThrottleNetSpeed() > 0) {
            return false;
        }
        JSONObject jSONObjectX = com.byazt.ew.pr.pr(this.nt.getId()).x("segment_config");
        List<com.byazt.stx.aj> listG = this.ho.g(this.nt.getId());
        if (this.nt.getCurBytes() > 0) {
            if (listG == null || listG.isEmpty()) {
                return false;
            }
            if (jSONObjectX == null) {
                jSONObjectX = new JSONObject();
            }
        }
        if (jSONObjectX == null) {
            return false;
        }
        this.er = new w(this.nt, g.pr(jSONObjectX), this);
        if (ny()) {
            com.byazt.p000do.pr.hn(pr, "downloadSegments: is stopped by user");
            if (this.g == com.byazt.mrs.zo.RUN_STATUS_CANCELED) {
                this.er.pr();
            } else {
                this.er.hw();
            }
            return true;
        }
        return this.er.pr(listG);
    }

    private void ho() {
        if (com.byazt.ew.pr.pr(this.nt.getId()).pr("reset_retain_retry_times", 0) == 1 && this.ls < 3) {
            this.c.set(this.nt.isBackUpUrlUsed() ? this.nt.getBackUpUrlRetryCount() : this.nt.getRetryCount());
            this.ls++;
        }
    }

    private void pr(String str, List<com.byazt.auw.hn> list, long j) throws com.byazt.lhc.aj, BaseException {
        hw(str, list, j);
        com.byazt.edb.fw fwVar = this.z;
        if (fwVar != null) {
            try {
                pr(str, fwVar, j);
            } catch (Throwable th) {
                this.nl = true;
            }
        }
        if (this.z == null || this.nl) {
            pr(str, list);
            pr(str, this.rc, j);
        }
    }

    private void nt() {
        boolean zFo;
        boolean z;
        com.byazt.p000do.pr.hw(pr, "endDownloadRunnable::runStatus=" + this.g);
        boolean z2 = (this.g == com.byazt.mrs.zo.RUN_STATUS_PAUSE || this.g == com.byazt.mrs.zo.RUN_STATUS_CANCELED) ? false : true;
        try {
            zFo = fo();
            z = false;
        } catch (Exception e) {
            if (e instanceof BaseException) {
                this.ny.pr((BaseException) e);
            } else {
                this.ny.pr(new BaseException(1046, e));
            }
            zFo = true;
            z = true;
        }
        if (zFo || z) {
            this.m.set(false);
            if (z2) {
                try {
                    com.byazt.ts.pr prVarNl = com.byazt.lj.hn.nl();
                    if (prVarNl != null) {
                        prVarNl.pr(this);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    rc monitorDepend = this.hn.getMonitorDepend();
                    DownloadInfo downloadInfo = this.nt;
                    BaseException baseException = new BaseException(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, com.byazt.tuy.uc.hw(th, "removeDownloadRunnable"));
                    DownloadInfo downloadInfo2 = this.nt;
                    com.byazt.cha.pr.pr(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
                    return;
                }
            }
            return;
        }
        this.gz = true;
        com.byazt.p000do.pr.hw(pr, "jump to restart");
    }

    private void hw(String str, List<com.byazt.auw.hn> list, long j) throws com.byazt.lhc.aj, BaseException {
        com.byazt.udn.hn hnVarPr;
        boolean z = true;
        if (this.nt.getChunkCount() == 1 && (hnVarPr = com.byazt.udn.pr.pr().pr(str, list)) != null) {
            this.z = hnVarPr;
            this.nt.setPreconnectLevel(1);
        }
        if (this.z == null && !this.nl && this.nt.isHeadConnectionAvailable()) {
            try {
                int iHw = this.s.hw("net_lib_strategy");
                if (this.s.pr("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.z = com.byazt.lj.hn.pr(str, list, iHw, z, this.nt);
            } catch (Throwable th) {
                this.nt.setHeadConnectionException(com.byazt.tuy.uc.vk(th));
            }
        }
    }

    private void pr(String str, List<com.byazt.auw.hn> list) throws com.byazt.lhc.aj, BaseException {
        aj ajVarPr;
        if (this.rc != null) {
            return;
        }
        com.byazt.udn.x xVarHw = null;
        if (this.nt.getChunkCount() == 1) {
            xVarHw = com.byazt.udn.pr.pr().hw(str, list);
        }
        try {
            if (xVarHw != null) {
                pr(this.rc);
                this.nt.setPreconnectLevel(2);
                this.rc = xVarHw;
            } else {
                try {
                    ajVarPr = com.byazt.lj.hn.pr(this.nt.isNeedDefaultHttpServiceBackUp(), this.nt.getMaxBytes(), str, null, list, this.s.hw("net_lib_strategy"), this.s.pr("monitor_download_connect", 0) > 0, this.nt);
                    this.rc = ajVarPr;
                } catch (BaseException e) {
                    throw e;
                } catch (Throwable th) {
                    if (this.nt.isExpiredRedownload() && com.byazt.tuy.uc.fw(th) && com.byazt.tuy.uc.hn(list)) {
                        com.byazt.p000do.pr.hw(pr, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.nt.getCacheControl());
                        long jAj = com.byazt.tuy.uc.aj(this.nt.getCacheControl());
                        if (jAj <= 0) {
                            jAj = com.byazt.ew.pr.pr(this.nt.getId()).pr("default_304_max_age", TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
                        }
                        this.nt.setCacheExpiredTime(System.currentTimeMillis() + (jAj * 1000));
                        throw new com.byazt.lhc.pr(this.y);
                    }
                    if (com.byazt.tuy.uc.uc(th)) {
                        pr("", "http code 416");
                    } else if (com.byazt.tuy.uc.c(th)) {
                        pr("", "http code 412");
                    } else {
                        com.byazt.tuy.uc.pr(th, "CreateFirstConnection");
                    }
                    ajVarPr = this.rc;
                }
                pr(ajVarPr);
            }
            if (this.rc == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            pr(this.rc);
            throw th2;
        }
    }

    private void yb() {
        com.byazt.edb.fw fwVar = this.z;
        if (fwVar != null) {
            fwVar.hn();
            this.z = null;
        }
    }

    private void lb() {
        aj ajVar = this.rc;
        if (ajVar != null) {
            ajVar.x();
            this.rc = null;
        }
    }

    private void qa() {
        yb();
        lb();
    }

    public static com.byazt.auw.hw pr(DownloadInfo downloadInfo, long j) {
        return new com.byazt.auw.hw.pr(downloadInfo.getId()).pr(-1).pr(0L).c(j).hw(j).hn(0L).x(downloadInfo.getTotalBytes() - j).pr();
    }

    private List<com.byazt.auw.hn> pr(com.byazt.auw.hw hwVar) {
        List<com.byazt.auw.hn> listPr = com.byazt.tuy.uc.pr(this.nt.getExtraHeaders(), this.nt.geteTag(), hwVar);
        if (this.nt.isExpiredRedownload() && this.ww && this.nt.getLastModified() != null) {
            listPr.add(new com.byazt.auw.hn("if-modified-since", this.nt.getLastModified()));
            listPr.add(new com.byazt.auw.hn("download-tc21-1-15", "download-tc21-1-15"));
            com.byazt.p000do.pr.hw(pr, "dcache::add head IF_MODIFIED_SINCE=" + this.nt.getLastModified());
        }
        return listPr;
    }

    private void a() throws BaseException {
        if (this.fw != null) {
            if (this.g == com.byazt.mrs.zo.RUN_STATUS_CANCELED) {
                this.nt.setStatus(-4);
                this.fw.hn();
            } else if (this.g == com.byazt.mrs.zo.RUN_STATUS_PAUSE) {
                this.nt.setStatus(-2);
                this.fw.hw();
            } else {
                this.fw.x();
            }
        }
    }

    private boolean cz() {
        return this.g == com.byazt.mrs.zo.RUN_STATUS_CANCELED || this.g == com.byazt.mrs.zo.RUN_STATUS_PAUSE;
    }

    private boolean ny() {
        if (cz() || this.nt.getStatus() == -2) {
            if (!cz()) {
                if (this.nt.getStatus() == -2) {
                    this.g = com.byazt.mrs.zo.RUN_STATUS_PAUSE;
                    return true;
                }
                if (this.nt.getStatus() == -4) {
                    this.g = com.byazt.mrs.zo.RUN_STATUS_CANCELED;
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean fo() {
        if (this.g == com.byazt.mrs.zo.RUN_STATUS_ERROR) {
            this.ny.pr(this.fo);
        } else if (this.g == com.byazt.mrs.zo.RUN_STATUS_CANCELED) {
            this.ny.hn();
        } else if (this.g == com.byazt.mrs.zo.RUN_STATUS_PAUSE) {
            this.ny.x();
        } else if (this.g == com.byazt.mrs.zo.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.ny.fw();
            } catch (BaseException e) {
                this.ny.pr(e);
            }
        } else if (this.g == com.byazt.mrs.zo.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.ny.pr(this.y);
            } catch (BaseException e2) {
                this.ny.pr(e2);
            }
        } else {
            if (this.g == com.byazt.mrs.zo.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.ny.pr(this.fo, false);
                return false;
            }
            if (this.g == com.byazt.mrs.zo.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            if (this.g == com.byazt.mrs.zo.RUN_STATUS_RETRY_DELAY && !rc()) {
                com.byazt.p000do.pr.hw(pr, "doTaskStatusHandle retryDelay");
                b();
                return this.g == com.byazt.mrs.zo.RUN_STATUS_RETRY_DELAY;
            }
            try {
                if (!z()) {
                    return false;
                }
                this.ny.uc();
                com.byazt.ts.lb.pr().x();
            } catch (Throwable th) {
                hw(new BaseException(1008, com.byazt.tuy.uc.hw(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private boolean rc() {
        if (this.nt.getChunkCount() <= 1) {
            return this.nt.getCurBytes() > 0 && this.nt.getCurBytes() == this.nt.getTotalBytes();
        }
        List<com.byazt.auw.hw> listHn = this.ho.hn(this.nt.getId());
        if (listHn == null || listHn.size() <= 1) {
            return false;
        }
        for (com.byazt.auw.hw hwVar : listHn) {
            if (hwVar == null || !hwVar.aj()) {
                return false;
            }
        }
        return true;
    }

    private boolean z() {
        if (this.nt.isChunked()) {
            DownloadInfo downloadInfo = this.nt;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        com.byazt.p000do.pr.hn(pr, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.nt.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.nt.getTotalBytes());
        if (this.nt.getCurBytes() > 0) {
            if (this.nt.isIgnoreDataVerify()) {
                return true;
            }
            if (this.nt.getTotalBytes() > 0 && this.nt.getCurBytes() == this.nt.getTotalBytes()) {
                return true;
            }
        }
        this.nt.setByteInvalidRetryStatus(com.byazt.mrs.hw.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.nt.reset();
        this.ho.pr(this.nt);
        this.ho.x(this.nt.getId());
        this.ho.m(this.nt.getId());
        com.byazt.tuy.uc.pr(this.nt);
        return false;
    }

    private void b() {
        this.g = com.byazt.mrs.zo.RUN_STATUS_NONE;
    }

    private long iu() {
        return this.cz.pr(this.nt.getCurRetryTimeInTotal(), this.nt.getTotalRetryCount());
    }

    private void ve() throws com.byazt.lhc.aj, BaseException {
        com.byazt.ts.pr prVarNl;
        int id = this.nt.getId();
        int iPr = com.byazt.lj.hn.pr(this.nt);
        if (this.nt.isDownloaded() && !this.nt.isExpiredRedownload() && !this.ww) {
            throw new BaseException(1009, "file has downloaded");
        }
        DownloadInfo downloadInfoHw = this.ho.hw(iPr);
        if (downloadInfoHw != null && (prVarNl = com.byazt.lj.hn.nl()) != null && downloadInfoHw.getId() != id && downloadInfoHw.equalsTask(this.nt)) {
            if (prVarNl.pr(downloadInfoHw.getId())) {
                this.ho.uc(id);
                throw new BaseException(InputDeviceCompat.SOURCE_GAMEPAD, "another same task is downloading");
            }
            List<com.byazt.auw.hw> listHn = this.ho.hn(iPr);
            com.byazt.tuy.uc.pr(this.nt);
            this.ho.uc(iPr);
            if (downloadInfoHw != null && downloadInfoHw.isBreakpointAvailable()) {
                this.nt.copyFromCacheData(downloadInfoHw, false);
                this.ho.pr(this.nt);
                if (listHn != null) {
                    for (com.byazt.auw.hw hwVar : listHn) {
                        hwVar.hw(id);
                        this.ho.pr(hwVar);
                    }
                }
                throw new com.byazt.lhc.aj("retry task because id generator changed");
            }
        }
    }

    private void pr(int i, List<com.byazt.auw.hw> list) throws BaseException {
        if (list.size() != i) {
            throw new BaseException(1033, new IllegalArgumentException());
        }
        pr(list, this.nt.getTotalBytes());
    }

    private void pr(long j, int i) throws BaseException {
        long j2;
        long j3 = j / ((long) i);
        int id = this.nt.getId();
        ArrayList arrayList = new ArrayList();
        long j4 = 0;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == i - 1) {
                j2 = 0;
            } else {
                j2 = (j4 + j3) - 1;
            }
            com.byazt.auw.hw hwVarPr = new com.byazt.auw.hw.pr(id).pr(i2).pr(j4).c(j4).hw(j4).hn(j2).pr();
            arrayList.add(hwVarPr);
            this.ho.pr(hwVarPr);
            j4 += j3;
        }
        this.nt.setChunkCount(i);
        this.ho.pr(id, i);
        pr(arrayList, j);
    }

    private void pr(List<com.byazt.auw.hw> list, long j) throws BaseException {
        long jNt;
        for (com.byazt.auw.hw hwVar : list) {
            if (hwVar != null) {
                if (hwVar.nt() == 0) {
                    jNt = j - hwVar.g();
                } else {
                    jNt = (hwVar.nt() - hwVar.g()) + 1;
                }
                if (jNt > 0) {
                    hwVar.pr(jNt);
                    if (this.nt.isNeedReuseFirstConnection() && this.rc != null && (!this.nt.isHeadConnectionAvailable() || this.nl)) {
                        if (hwVar.qa() == 0) {
                            this.uc.add(new hw(hwVar, this.hn, this.rc, this));
                        } else if (hwVar.qa() > 0) {
                            this.uc.add(new hw(hwVar, this.hn, this));
                        }
                    } else {
                        this.uc.add(new hw(hwVar, this.hn, this));
                    }
                }
            }
        }
        if (com.byazt.tuy.pr.pr(64)) {
            ArrayList arrayList = new ArrayList(this.uc.size());
            for (hw hwVar2 : this.uc) {
                if (this.g == com.byazt.mrs.zo.RUN_STATUS_CANCELED) {
                    hwVar2.hw();
                } else if (this.g == com.byazt.mrs.zo.RUN_STATUS_PAUSE) {
                    hwVar2.pr();
                } else {
                    arrayList.add(hwVar2);
                }
            }
            try {
                List<Future> listX = com.byazt.ts.c.x(arrayList);
                for (Runnable runnableC = (Runnable) arrayList.remove(0); runnableC != null; runnableC = com.byazt.ts.c.c(listX)) {
                    if (ny()) {
                        return;
                    }
                    try {
                        runnableC.run();
                    } catch (Throwable th) {
                    }
                }
                if (listX != null && !listX.isEmpty()) {
                    for (Future future : listX) {
                        if (future != null && !future.isDone()) {
                            future.get();
                        }
                    }
                    return;
                }
                return;
            } catch (Throwable th2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.uc.size());
        for (hw hwVar3 : this.uc) {
            if (this.g == com.byazt.mrs.zo.RUN_STATUS_CANCELED) {
                hwVar3.hw();
            } else if (this.g == com.byazt.mrs.zo.RUN_STATUS_PAUSE) {
                hwVar3.pr();
            } else {
                arrayList2.add(Executors.callable(hwVar3));
            }
        }
        if (ny()) {
            return;
        }
        try {
            com.byazt.ts.c.hn(arrayList2);
        } catch (InterruptedException e) {
            throw new BaseException(PointerIconCompat.TYPE_GRAB, e);
        }
    }

    private void pr(com.byazt.auw.hw hwVar, String str, aj ajVar) throws BaseException {
        hwVar.pr(this.nt.getTotalBytes() - hwVar.g());
        this.nt.setChunkCount(1);
        this.ho.pr(this.nt.getId(), 1);
        this.fw = new com.byazt.lj.c(this.nt, str, ajVar, hwVar, this);
        a();
    }

    private boolean gz() {
        DownloadInfo downloadInfo = this.nt;
        return (downloadInfo == null || downloadInfo.isExpiredRedownload() || (this.aj && this.nt.getChunkCount() <= 1) || this.nt.isChunkDowngradeRetryUsed() || !this.vk || this.k) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0113  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [long] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.byazt.auw.c] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [long] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24, types: [com.byazt.auw.c] */
    @Override // com.byazt.gi.uc
    public void pr(long j) throws Throwable {
        ?? X;
        long j2;
        boolean z;
        ?? r7;
        String tempPath = this.nt.getTempPath();
        String tempName = this.nt.getTempName();
        if (com.byazt.tuy.uc.hw(j)) {
            return;
        }
        com.byazt.auw.c cVarPr = com.byazt.tuy.uc.pr(this.nt, tempPath, tempName, -1);
        try {
            long length = new File(tempPath, tempName).length();
            long totalBytes = j - length;
            X = com.byazt.tuy.uc.x(tempPath);
            com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(this.nt.getId());
            try {
                try {
                    if (prVarPr.pr("space_fill_part_download", 0) == 1) {
                        this.n = 0L;
                        if (totalBytes <= 0) {
                            totalBytes = this.nt.getTotalBytes() - this.nt.getCurBytes();
                        }
                        if (X < totalBytes) {
                            String str = pr;
                            com.byazt.auw.c cVar = cVarPr;
                            com.byazt.p000do.pr.x(str, "checkSpaceOverflow: contentLength = " + com.byazt.tuy.uc.pr(j) + "MB, downloaded = " + com.byazt.tuy.uc.pr(length) + "MB, required = " + com.byazt.tuy.uc.pr(totalBytes) + "MB, available = " + com.byazt.tuy.uc.pr((long) X) + "MB");
                            if (X > 0) {
                                int iPr = prVarPr.pr("space_fill_min_keep_mb", 100);
                                if (iPr > 0) {
                                    long j3 = X - (((long) iPr) * 1048576);
                                    com.byazt.p000do.pr.x(str, "checkSpaceOverflow: minKeep = " + iPr + "MB, canDownload = " + com.byazt.tuy.uc.pr(j3) + "MB");
                                    if (j3 > 0) {
                                        this.n = this.nt.getCurBytes() + j3;
                                        r7 = j3;
                                    } else {
                                        throw new com.byazt.lhc.x(X, totalBytes);
                                    }
                                } else {
                                    r7 = X;
                                }
                                if (length < j) {
                                    j2 = r7 + length;
                                    if (j2 > j) {
                                        j2 = j;
                                    }
                                } else {
                                    j2 = j;
                                }
                                z = true;
                                X = cVar;
                            } else if (prVarPr.pr("download_when_space_negative", 0) == 1) {
                                j2 = j;
                                z = false;
                                X = cVar;
                            } else {
                                throw new BaseException(1052, "availableSpace " + (X == 0 ? "=" : "<") + " 0");
                            }
                        }
                        X.hw(j);
                        com.byazt.tuy.uc.pr((Closeable[]) new Closeable[]{X});
                    }
                    if (X <= 0) {
                        throw new BaseException(1052, "availableSpace " + (X == 0 ? "=" : "<") + " 0");
                    }
                    if (X < totalBytes) {
                        throw new com.byazt.lhc.x(X, totalBytes);
                    }
                    X.hw(j);
                } catch (Throwable th) {
                    com.byazt.p000do.pr.c(pr, "checkSpaceOverflow: setLength1 e = " + th + ", mustSetLength = " + z);
                    if (j2 < j && j2 > 0 && j2 > length) {
                        try {
                            X.hw(j2);
                        } catch (Throwable th2) {
                            com.byazt.p000do.pr.c(pr, "checkSpaceOverflow: setLength2 ex = " + th2 + ", mustSetLength = " + z);
                            if (z) {
                                throw new BaseException(AVMDLDataLoader.KeyIsPreloadWaitListType, th2);
                            }
                        }
                    } else if (z) {
                        throw new BaseException(AVMDLDataLoader.KeyIsPreloadWaitListType, th);
                    }
                }
                j2 = j;
                z = true;
                X = cVarPr;
                com.byazt.tuy.uc.pr((Closeable[]) new Closeable[]{X});
            } catch (Throwable th3) {
                th = th3;
                com.byazt.tuy.uc.pr((Closeable[]) new Closeable[]{X});
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            X = cVarPr;
        }
    }

    private void nl() throws BaseException {
        long jX;
        int iPr;
        try {
            jX = com.byazt.tuy.uc.x(this.nt.getTempPath());
        } catch (BaseException e) {
            jX = 0;
        }
        String str = pr;
        com.byazt.p000do.pr.hn(str, "checkSpaceOverflowInProgress: available = " + com.byazt.tuy.uc.pr(jX) + "MB");
        if (jX > 0) {
            long totalBytes = this.nt.getTotalBytes() - this.nt.getCurBytes();
            if (jX < totalBytes && (iPr = com.byazt.ew.pr.pr(this.nt.getId()).pr("space_fill_min_keep_mb", 100)) > 0) {
                long j = jX - (((long) iPr) * 1048576);
                com.byazt.p000do.pr.hn(str, "checkSpaceOverflowInProgress: minKeep  = " + iPr + "MB, canDownload = " + com.byazt.tuy.uc.pr(j) + "MB");
                if (j <= 0) {
                    this.n = 0L;
                    throw new com.byazt.lhc.x(jX, totalBytes);
                }
                this.n = this.nt.getCurBytes() + j + 1048576;
                return;
            }
        }
        this.n = 0L;
    }

    private void y() throws com.byazt.lhc.uc {
        if (this.nt.isOnlyWifi() && !com.byazt.tuy.uc.pr(com.byazt.lj.hn.of(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.byazt.lhc.uc(PointerIconCompat.TYPE_ZOOM_OUT, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.nt.isDownloadWithWifiValid()) {
            throw new com.byazt.lhc.hn();
        }
        if (!this.nt.isPauseReserveWithWifiValid()) {
            throw new com.byazt.lhc.c();
        }
    }

    private void ww() throws BaseException {
        if (TextUtils.isEmpty(this.nt.getSavePath())) {
            throw new BaseException(1028, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.nt.getName())) {
            throw new BaseException(1029, "download name can not be empty");
        }
        File file = new File(this.nt.getSavePath());
        if (!file.exists()) {
            boolean zMkdirs = file.mkdirs();
            if (!zMkdirs && !file.exists()) {
                int i = 0;
                if (com.byazt.ew.pr.pr(this.nt.getId()).pr("opt_mkdir_failed", 0) == 1) {
                    while (!zMkdirs) {
                        int i2 = i + 1;
                        if (i >= 3) {
                            break;
                        }
                        try {
                            Thread.sleep(10L);
                            zMkdirs = file.mkdirs();
                            i = i2;
                        } catch (InterruptedException e) {
                        }
                    }
                    if (zMkdirs || file.exists()) {
                        return;
                    }
                    if (com.byazt.tuy.uc.x(this.nt.getSavePath()) < PlaybackStateCompat.ACTION_PREPARE) {
                        throw new BaseException(1006, "download savePath directory can not created:" + this.nt.getSavePath());
                    }
                    throw new BaseException(1030, "download savePath directory can not created:" + this.nt.getSavePath());
                }
                throw new BaseException(1030, "download savePath directory can not created:" + this.nt.getSavePath());
            }
            return;
        }
        if (!file.isDirectory()) {
            if (com.byazt.tuy.x.hw(this.nt)) {
                file.delete();
                if (!file.mkdirs() && !file.exists()) {
                    throw new BaseException(1031, "download savePath is not directory:path=" + this.nt.getSavePath());
                }
                return;
            }
            throw new BaseException(1031, "download savePath is not a directory:" + this.nt.getSavePath());
        }
    }

    private boolean pr(int i, String str, String str2) {
        if (i == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.w || this.vk)) {
            return (i == 201 || i == 416) && this.nt.getCurBytes() > 0;
        }
        return true;
    }

    private void pr(String str, String str2) throws com.byazt.lhc.aj {
        this.ho.x(this.nt.getId());
        this.ho.m(this.nt.getId());
        com.byazt.tuy.uc.pr(this.nt);
        this.aj = false;
        this.nt.resetDataForEtagEndure(str);
        this.ho.pr(this.nt);
        throw new com.byazt.lhc.aj(str2);
    }

    @Override // com.byazt.gi.uc
    public void pr(String str, com.byazt.edb.fw fwVar, long j) throws com.byazt.lhc.aj, BaseException {
        com.byazt.edb.fw fwVar2;
        String str2;
        String strPr;
        long jHw;
        if (fwVar == null) {
            return;
        }
        try {
            com.byazt.auw.x xVar = new com.byazt.auw.x(str, fwVar);
            int i = xVar.hn;
            String strX = xVar.x();
            if (TextUtils.isEmpty(this.nt.getMimeType()) && !TextUtils.isEmpty(strX)) {
                this.nt.setMimeType(strX);
            }
            boolean zHw = xVar.hw();
            this.vk = zHw;
            this.nt.setSupportPartial(zHw);
            this.w = xVar.pr();
            String str3 = this.nt.geteTag();
            String strHn = xVar.hn();
            String strUc = xVar.uc();
            String strFw = xVar.fw();
            String str4 = pr;
            com.byazt.p000do.pr.hw(str4, "dcache=responseCode=" + i + " last_modified=" + strUc + " CACHE_CONTROL=" + strFw + " max-age=" + xVar.w() + " isDeleteCacheIfCheckFailed=" + this.nt.isDeleteCacheIfCheckFailed());
            com.byazt.p000do.pr.hw(str4, "dcache=firstOffset=" + j + " cur=" + strUc + " before=" + this.nt.getLastModified() + " cur=" + xVar.vk() + " before=" + this.nt.getTotalBytes());
            if (!TextUtils.isEmpty(strFw)) {
                this.nt.setCacheControl(strFw);
                if (xVar.w() > 0) {
                    this.nt.setCacheExpiredTime(System.currentTimeMillis() + (xVar.w() * 1000));
                }
            }
            if (this.nt.isExpiredRedownload() && this.ww && !TextUtils.isEmpty(this.y)) {
                boolean z = false;
                if (i == 304) {
                    z = true;
                } else if ((!TextUtils.isEmpty(this.nt.getLastModified()) || !this.nt.isDeleteCacheIfCheckFailed()) && TextUtils.equals(strUc, this.nt.getLastModified())) {
                    z = true;
                }
                if (z) {
                    com.byazt.p000do.pr.hw(str4, "dcache=responseCode=" + i + " lastModified not changed, use local file  " + strUc);
                    throw new com.byazt.lhc.pr(this.y);
                }
                com.byazt.tuy.uc.pr(this.nt);
            }
            if (j > 0 && this.nt.isExpiredRedownload() && !TextUtils.equals(strUc, this.nt.getLastModified())) {
                com.byazt.p000do.pr.hw(str4, "dcache cdn file change, so retry");
                pr("", "cdn file changed");
            }
            if (!TextUtils.isEmpty(strUc)) {
                this.nt.setLastModified(strUc);
            }
            if (!pr(i, str3, strHn)) {
                fwVar2 = fwVar;
                str2 = strHn;
            } else {
                fwVar2 = fwVar;
                if (fwVar2 instanceof aj) {
                    if (!TextUtils.isEmpty(str3) && str3.equals(strHn)) {
                        str2 = "";
                    } else {
                        str2 = strHn;
                    }
                    pr(str2, "eTag of server file changed");
                } else {
                    throw new com.byazt.lhc.hw(1002, i, "");
                }
            }
            if (!this.vk && !this.w) {
                if (i == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                throw new com.byazt.lhc.hw(1004, i, "response code error : " + i);
            }
            if (this.w && j > 0) {
                if (fwVar2 instanceof aj) {
                    pr("", "http head request not support");
                } else {
                    throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
                }
            }
            long jZo = xVar.zo();
            if (!(fwVar2 instanceof aj) && jZo < 0 && com.byazt.tuy.x.pr(this.nt)) {
                throw new BaseException(1004, "");
            }
            if (!TextUtils.isEmpty(this.nt.getName())) {
                strPr = "";
            } else {
                strPr = com.byazt.tuy.uc.pr(fwVar2, this.nt.getUrl());
            }
            boolean zAj = xVar.aj();
            this.k = zAj;
            if (!zAj && jZo == 0 && !(fwVar2 instanceof aj)) {
                throw new BaseException(1004, "");
            }
            if (!zAj) {
                String strHw = com.byazt.tuy.uc.hw(fwVar2, Util.CONTENT_RANGE);
                com.byazt.p000do.pr.hn(str4, "firstConnection: contentRange = " + strHw);
                if (!TextUtils.isEmpty(strHw) && this.s.hw("fix_get_total_bytes", true)) {
                    jHw = com.byazt.tuy.uc.hw(strHw);
                    com.byazt.p000do.pr.hn(str4, "firstConnection: 1 totalLength = " + jHw);
                } else {
                    jHw = j + jZo;
                    com.byazt.p000do.pr.c(str4, "firstConnection: 2 totalLength = " + jHw + ", contentLength = " + jZo);
                }
            } else {
                jHw = -1;
            }
            if (!TextUtils.isEmpty(this.nt.getTaskKey()) && this.nt.getTotalBytes() > 0 && jHw != this.nt.getTotalBytes()) {
                if (fwVar2 instanceof aj) {
                    pr("", "file totalLength changed");
                } else {
                    throw new com.byazt.lhc.hw(1002, i, "");
                }
            }
            if (ny()) {
                return;
            }
            if (this.nt.getExpectFileLength() > 0 && com.byazt.ew.pr.pr(this.nt.getId()).hw("force_check_file_length") == 1 && this.nt.getExpectFileLength() != jHw) {
                throw new BaseException(1070, "expectFileLength = " + this.nt.getExpectFileLength() + " , totalLength = " + jHw);
            }
            this.ny.pr(jHw, str2, strPr);
        } catch (BaseException e) {
            throw e;
        } catch (com.byazt.lhc.aj e2) {
            throw e2;
        } catch (Throwable th) {
            com.byazt.tuy.uc.pr(th, "HandleFirstConnection");
        }
    }

    public boolean x() {
        return this.m.get();
    }

    public int c() {
        DownloadInfo downloadInfo = this.nt;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    public void uc() {
        this.e = System.currentTimeMillis();
        this.ny.pr();
    }

    private void n() {
        long jUc = com.byazt.tuy.uc.uc(this.nt);
        long curBytes = this.nt.getCurBytes();
        if (jUc != curBytes) {
            com.byazt.p000do.pr.x(pr, "checkTaskCanResume: offset = " + jUc + ", curBytes = " + curBytes);
        }
        this.nt.setCurBytes(jUc);
        boolean z = jUc > 0;
        this.aj = z;
        if (!z && !this.ww) {
            com.byazt.p000do.pr.hn(pr, "checkTaskCanResume: deleteAllDownloadFiles");
            this.ho.x(this.nt.getId());
            this.ho.m(this.nt.getId());
            com.byazt.tuy.uc.pr(this.nt);
        }
    }

    @Override // com.byazt.gi.uc
    public boolean hw(long j) throws BaseException {
        if (this.n > 0 && this.nt.getCurBytes() > this.n) {
            nl();
        }
        return this.ny.pr(j);
    }

    @Override // com.byazt.gi.uc
    public void pr(hw hwVar) {
        if (!this.zo) {
            synchronized (this) {
                this.uc.remove(hwVar);
            }
        }
    }

    @Override // com.byazt.gi.uc
    public boolean pr(BaseException baseException) {
        if (this.er != null && com.byazt.tuy.uc.aj(baseException) && this.c.get() < this.nt.getRetryCount()) {
            return false;
        }
        if (com.byazt.tuy.uc.hw(baseException)) {
            if (this.zo && !this.x) {
                com.byazt.tuy.uc.pr(this.nt);
                this.x = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.c;
        return ((atomicInteger != null && atomicInteger.get() > 0) || this.nt.hasNextBackupUrl() || (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.nt.canReplaceHttpForRetry()))) && !(baseException instanceof com.byazt.lhc.uc);
    }

    @Override // com.byazt.gi.uc
    public void hw(BaseException baseException) {
        com.byazt.p000do.pr.hw(pr, "onError:" + baseException.getMessage());
        this.g = com.byazt.mrs.zo.RUN_STATUS_ERROR;
        this.fo = baseException;
        s();
    }

    private void e() {
        com.byazt.p000do.pr.x(pr, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.ho.x(this.nt.getId());
            this.ho.m(this.nt.getId());
            com.byazt.tuy.uc.pr(this.nt);
            this.aj = false;
            this.nt.resetDataForEtagEndure("");
            this.ho.pr(this.nt);
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.gi.uc
    public void hn(BaseException baseException) {
        DownloadInfo downloadInfo = this.nt;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        pr(baseException, false);
    }

    @Override // com.byazt.gi.uc
    public void pr(BaseException baseException, boolean z) {
        boolean zX;
        com.byazt.p000do.pr.hw(pr, "onAllChunkRetryWithReset");
        this.g = com.byazt.mrs.zo.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.fo = baseException;
        s();
        if (!z) {
            zX = false;
        } else {
            zX = x(baseException);
        }
        if (!zX) {
            e();
        }
    }

    private void s() {
        try {
            for (hw hwVar : (ArrayList) this.uc.clone()) {
                if (hwVar != null) {
                    hwVar.hw();
                }
            }
        } catch (Throwable th) {
            com.byazt.p000do.pr.hn(pr, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.nt.setForbiddenBackupUrls(list, this.g == com.byazt.mrs.zo.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.byazt.ts.pr prVarNl = com.byazt.lj.hn.nl();
        if (prVarNl != null) {
            prVarNl.k(this.nt.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls() {
        com.byazt.ts.pr prVarNl;
        if (!ny() && (prVarNl = com.byazt.lj.hn.nl()) != null) {
            prVarNl.k(this.nt.getId());
        }
    }

    @Override // com.byazt.gi.uc
    public com.byazt.lhc.zo pr(com.byazt.auw.hw hwVar, BaseException baseException, long j) {
        if (cz()) {
            return com.byazt.lhc.zo.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.byazt.tuy.uc.zo(baseException))) {
            return pr(baseException, j);
        }
        this.fo = baseException;
        this.nt.increaseCurBytes(-j);
        this.ho.pr(this.nt);
        if (x(baseException)) {
            return com.byazt.lhc.zo.RETURN;
        }
        this.ny.pr(hwVar, baseException, this.g == com.byazt.mrs.zo.RUN_STATUS_RETRY_DELAY);
        if (this.g != com.byazt.mrs.zo.RUN_STATUS_RETRY_DELAY && this.nt.isNeedRetryDelay()) {
            long jIu = iu();
            if (jIu > 0) {
                com.byazt.p000do.pr.hn(pr, "onSingleChunkRetry with delay time " + jIu);
                try {
                    Thread.sleep(jIu);
                } catch (Throwable th) {
                    com.byazt.p000do.pr.x(pr, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.byazt.lhc.zo.CONTINUE;
    }

    @Override // com.byazt.gi.uc
    public com.byazt.lhc.zo pr(BaseException baseException, long j) {
        long totalBytes;
        long jPr;
        boolean z;
        this.fo = baseException;
        this.nt.increaseCurBytes(-j);
        this.ho.pr(this.nt);
        if (cz()) {
            return com.byazt.lhc.zo.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.b == null || this.nt.isForbiddenRetryed()) {
                if (x(baseException)) {
                    return com.byazt.lhc.zo.RETURN;
                }
                z = false;
            } else {
                com.byazt.fn.hw hwVar = new com.byazt.fn.hw() { // from class: com.byazt.gi.hn.1
                    @Override // com.byazt.fn.hw, com.byazt.fn.ny
                    public void pr(List<String> list) {
                        super.pr(list);
                        hn.this.pr(list);
                    }
                };
                boolean zPr = this.b.pr(hwVar);
                this.nt.setForbiddenRetryed();
                if (!zPr) {
                    z = false;
                } else {
                    if (!hwVar.pr()) {
                        s();
                        this.ny.zo();
                        this.g = com.byazt.mrs.zo.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.byazt.lhc.zo.RETURN;
                    }
                    z = true;
                }
            }
        } else if (com.byazt.tuy.uc.zo(baseException)) {
            if (this.iu == null) {
                hw(baseException);
                return com.byazt.lhc.zo.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            yb ybVar = new yb() { // from class: com.byazt.gi.hn.2
                @Override // com.byazt.fn.yb
                public void pr() {
                    synchronized (hn.this) {
                        atomicBoolean.set(true);
                        hn.this.ls();
                    }
                }
            };
            if (baseException instanceof com.byazt.lhc.x) {
                com.byazt.lhc.x xVar = (com.byazt.lhc.x) baseException;
                jPr = xVar.pr();
                totalBytes = xVar.hw();
            } else {
                totalBytes = this.nt.getTotalBytes();
                jPr = -1;
            }
            synchronized (this) {
                if (this.iu.pr(jPr, totalBytes, ybVar)) {
                    if (!com.byazt.ew.pr.pr(this.nt.getId()).hw("not_delete_when_clean_space", false)) {
                        z();
                    }
                    if (!atomicBoolean.get()) {
                        if (this.g != com.byazt.mrs.zo.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                            this.g = com.byazt.mrs.zo.RUN_STATUS_WAITING_ASYNC_HANDLER;
                            s();
                            this.ny.zo();
                        }
                        return com.byazt.lhc.zo.RETURN;
                    }
                    if (x(baseException)) {
                        return com.byazt.lhc.zo.RETURN;
                    }
                    z = true;
                } else {
                    if (this.g == com.byazt.mrs.zo.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        return com.byazt.lhc.zo.RETURN;
                    }
                    hw(baseException);
                    return com.byazt.lhc.zo.RETURN;
                }
            }
        } else {
            if (x(baseException)) {
                return com.byazt.lhc.zo.RETURN;
            }
            z = false;
        }
        if (!z && er()) {
            s();
        }
        this.ny.pr(baseException, this.g == com.byazt.mrs.zo.RUN_STATUS_RETRY_DELAY);
        return this.g == com.byazt.mrs.zo.RUN_STATUS_RETRY_DELAY ? com.byazt.lhc.zo.RETURN : com.byazt.lhc.zo.CONTINUE;
    }

    private boolean x(BaseException baseException) {
        AtomicInteger atomicInteger = this.c;
        boolean z = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                if (this.nt.trySwitchToNextBackupUrl()) {
                    this.c.set(this.nt.getBackUpUrlRetryCount());
                    this.nt.updateCurRetryTime(this.c.get());
                } else if (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.nt.canReplaceHttpForRetry())) {
                    this.c.set(this.nt.getRetryCount());
                    this.nt.updateCurRetryTime(this.c.get());
                    this.nt.setHttpsToHttpRetryUsed(true);
                } else {
                    hw(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.c), String.valueOf(this.nt.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                z = false;
            }
            if (this.g != com.byazt.mrs.zo.RUN_STATUS_RETRY_DELAY && z) {
                this.nt.updateCurRetryTime(this.c.decrementAndGet());
            }
            return false;
        }
        hw(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
        return true;
    }

    @Override // com.byazt.gi.uc
    public synchronized com.byazt.auw.hw pr(int i) {
        com.byazt.auw.hw hwVarPr;
        if (this.nt.getChunkCount() < 2) {
            return null;
        }
        List<com.byazt.auw.hw> listHn = this.ho.hn(this.nt.getId());
        if (listHn != null && !listHn.isEmpty()) {
            for (int i2 = 0; i2 < listHn.size(); i2++) {
                com.byazt.auw.hw hwVar = listHn.get(i2);
                if (hwVar != null && (hwVarPr = pr(hwVar, i)) != null) {
                    return hwVarPr;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.byazt.gi.uc
    public void pr(com.byazt.edb.fw fwVar) {
        boolean z;
        if (fwVar != null) {
            try {
                int iHw = fwVar.hw();
                this.nt.setHttpStatusCode(iHw);
                this.nt.setHttpStatusMessage(com.byazt.tuy.hw.pr(iHw));
                z = true;
            } catch (Throwable th) {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z) {
            this.nt.setHttpStatusCode(-1);
            this.nt.setHttpStatusMessage("");
        }
    }

    private com.byazt.auw.hw pr(com.byazt.auw.hw hwVar, int i) {
        com.byazt.auw.hw hwVar2 = null;
        if (!hwVar.x()) {
            return null;
        }
        long jHn = hwVar.hn(true);
        com.byazt.p000do.pr.hw(pr, "reuseChunk retainLen:" + jHn + " chunkIndex:" + i);
        boolean z = false;
        if (!hwVar.uc() && jHn > com.byazt.mrs.c.uc && this.nt.isNeedReuseChunkRunnable()) {
            List<com.byazt.auw.hw> listPr = hwVar.pr(this.nt.getChunkCount(), this.nt.getTotalBytes());
            if (listPr != null) {
                Iterator<com.byazt.auw.hw> it = listPr.iterator();
                while (it.hasNext()) {
                    this.ho.hw(it.next());
                }
            }
            z = true;
        } else if (hwVar.uc()) {
            z = true;
        }
        if (!z || !hwVar.uc()) {
            return null;
        }
        for (int i2 = 1; i2 < hwVar.fw().size(); i2++) {
            com.byazt.auw.hw hwVar3 = hwVar.fw().get(i2);
            if (hwVar3 != null) {
                com.byazt.p000do.pr.hw(pr, "check can checkUnCompletedChunk -- chunkIndex:" + hwVar3.qa() + " currentOffset:" + hwVar3.g() + "  startOffset:" + hwVar3.k() + " contentLen:" + hwVar3.yb());
                if (hwVar3.qa() < 0 || (!hwVar3.aj() && !hwVar3.hn())) {
                    hwVar2 = hwVar3;
                    break;
                }
            }
        }
        if (hwVar2 != null) {
            com.byazt.p000do.pr.hw(pr, "unComplete chunk " + hwVar.qa() + " curOffset:" + hwVar.g() + " reuseChunk chunkIndex:" + i + " for subChunk:" + hwVar2.qa());
            this.ho.pr(hwVar2.w(), hwVar2.qa(), hwVar2.hw(), i);
            hwVar2.hn(i);
            hwVar2.pr(true);
        }
        return hwVar2;
    }

    private boolean er() {
        return false;
    }

    private qa pr(DownloadTask downloadTask) {
        qa retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new com.byazt.ts.yb(retryDelayTimeArray);
            }
        }
        return com.byazt.lj.hn.qi();
    }

    public Future fw() {
        return this.hw;
    }

    public void pr(Future future) {
        this.hw = future;
    }
}
