package com.ss.android.socialbase.downloader.x;

import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.kuaishou.weapon.p0.g;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.c.hi;
import com.ss.android.socialbase.downloader.c.u;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.qv;
import com.ss.android.socialbase.downloader.depend.re;
import com.ss.android.socialbase.downloader.downloader.ch;
import com.ss.android.socialbase.downloader.downloader.y;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.ny;
import com.ss.android.socialbase.downloader.network.sl;
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

/* JADX INFO: loaded from: classes3.dex */
public class ah implements c, Runnable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4795ms = "ah";
    private volatile com.ss.android.socialbase.downloader.downloader.ka ab;
    private final DownloadTask ah;
    private DownloadInfo ao;
    private final com.ss.android.socialbase.downloader.downloader.c b;
    private boolean ch;
    private final com.ss.android.socialbase.downloader.ab.ms f;
    private com.ss.android.socialbase.downloader.downloader.x h;
    private boolean hi;
    private ny i;
    private long jw;
    private AtomicInteger ka;
    private y nw;
    private boolean ny;
    private String of;
    private qv op;
    private long pc;
    private final com.ss.android.socialbase.downloader.downloader.x qv;
    private volatile BaseException re;
    private boolean sl;
    private final com.ss.android.socialbase.downloader.downloader.ab t;
    private final ch ub;
    private com.ss.android.socialbase.downloader.network.ab w;
    private boolean x;
    private Future xr;
    private com.ss.android.socialbase.downloader.downloader.ab y;
    private re yu;
    private final AtomicBoolean zb;
    private volatile boolean d = false;
    private final ArrayList<xr> c = new ArrayList<>();
    private volatile com.ss.android.socialbase.downloader.constants.x u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_NONE;
    private volatile int le = 5;
    private boolean cv = false;
    private boolean g = false;
    private boolean p = false;
    private int ul = 0;
    private volatile hi az = null;

    private boolean az() {
        return false;
    }

    public ah(DownloadTask downloadTask, Handler handler) {
        this.ah = downloadTask;
        if (downloadTask != null) {
            this.ao = downloadTask.getDownloadInfo();
            this.h = downloadTask.getChunkStrategy();
            this.y = downloadTask.getChunkAdjustCalculator();
            this.yu = downloadTask.getForbiddenHandler();
            this.op = downloadTask.getDiskSpaceHandler();
            this.nw = ms(downloadTask);
            this.f = com.ss.android.socialbase.downloader.ab.ms.ms(this.ao.getId());
        } else {
            this.f = com.ss.android.socialbase.downloader.ab.ms.ah();
        }
        x();
        this.ub = com.ss.android.socialbase.downloader.downloader.ah.w();
        this.qv = com.ss.android.socialbase.downloader.downloader.ah.ul();
        this.t = com.ss.android.socialbase.downloader.downloader.ah.m();
        this.b = new com.ss.android.socialbase.downloader.downloader.c(downloadTask, handler);
        this.zb = new AtomicBoolean(true);
    }

    private void x() {
        DownloadInfo downloadInfo = this.ao;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.ao.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.ka;
        if (atomicInteger == null) {
            this.ka = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    public void ms() {
        this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_PAUSE;
        if (this.az != null) {
            this.az.xr();
        }
        if (this.ab != null) {
            this.ab.xr();
        }
        if (this.az == null && this.ab == null) {
            y();
            this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_PAUSE;
            ao();
        }
        try {
            for (xr xrVar : (ArrayList) this.c.clone()) {
                if (xrVar != null) {
                    xrVar.ms();
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    public void xr() {
        this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_CANCELED;
        if (this.az != null) {
            this.az.ms();
        }
        if (this.ab != null) {
            this.ab.ah();
        }
        if (this.az == null && this.ab == null) {
            y();
            this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_CANCELED;
            ao();
        }
        f();
    }

    public DownloadTask ah() {
        return this.ah;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005e  */
    private int ms(long j, List<com.ss.android.socialbase.downloader.model.xr> list) {
        int iMs;
        int iMs2;
        if (cv()) {
            if (!this.ny) {
                com.ss.android.socialbase.downloader.downloader.x xVar = this.h;
                if (xVar != null) {
                    iMs2 = xVar.ms(j);
                } else {
                    iMs2 = this.qv.ms(j);
                }
                sl slVarXr = com.ss.android.socialbase.downloader.network.hi.ms().xr();
                com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, String.format("NetworkQuality is : %s", slVarXr.name()));
                this.ao.setNetworkQuality(slVarXr.name());
                com.ss.android.socialbase.downloader.downloader.ab abVar = this.y;
                if (abVar != null) {
                    iMs = abVar.ms(iMs2, slVarXr);
                } else {
                    iMs = this.t.ms(iMs2, slVarXr);
                }
            } else if (list != null) {
                iMs = list.size();
            } else {
                iMs = this.ao.getChunkCount();
            }
            if (iMs <= 0) {
                iMs = 1;
            }
        } else {
            iMs = 1;
        }
        if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
            com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(iMs), this.ao.getName(), String.valueOf(j)));
        }
        return iMs;
    }

    private boolean ny() {
        int status = this.ao.getStatus();
        if (status == 1 || this.ao.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        xr(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00f8 A[Catch: SQLiteException -> 0x0100, TRY_LEAVE, TryCatch #5 {SQLiteException -> 0x0100, blocks: (B:80:0x00f0, B:82:0x00f8), top: B:91:0x00f0 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00ee: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:82:0x00f8, block:B:79:0x00ee */
    private void ch() throws com.ss.android.socialbase.downloader.exception.ms {
        boolean z;
        boolean z2;
        DownloadTask downloadTask;
        boolean z3 = false;
        try {
            try {
                int id = this.ao.getId();
                if (this.ub != null) {
                    if (com.ss.android.socialbase.downloader.ny.ms.ms(2048)) {
                        this.ub.ka();
                    }
                    DownloadInfo downloadInfoXr = this.ub.xr(id);
                    z = true;
                    if (downloadInfoXr == null || downloadInfoXr.isNewTask()) {
                        this.ao.reset();
                    } else {
                        String savePath = this.ao.getSavePath();
                        String md5 = this.ao.getMd5();
                        this.ao.copyFromCacheData(downloadInfoXr, true);
                        boolean z4 = com.ss.android.socialbase.downloader.ny.ms.ms(4096) && downloadInfoXr != this.ao;
                        try {
                            if (savePath.equals(downloadInfoXr.getSavePath()) && com.ss.android.socialbase.downloader.ny.c.ms(downloadInfoXr, false, md5)) {
                                try {
                                    throw new com.ss.android.socialbase.downloader.exception.ms(downloadInfoXr.getName());
                                } catch (com.ss.android.socialbase.downloader.exception.ms e) {
                                    e = e;
                                } catch (Throwable th) {
                                    th = th;
                                    z3 = z4;
                                    downloadTask = this.ah;
                                    if (downloadTask != null && this.ao != null) {
                                        com.ss.android.socialbase.downloader.d.ms.ms(downloadTask.getMonitorDepend(), this.ao, new BaseException(1003, com.ss.android.socialbase.downloader.ny.c.xr(th, "checkTaskCache")), this.ao.getStatus());
                                    }
                                    if (z3) {
                                        if (z) {
                                            try {
                                                if (!this.f.ms("fix_file_exist_update_download_info")) {
                                                    return;
                                                }
                                            } catch (SQLiteException e2) {
                                                com.bytedance.sdk.openadsdk.api.ab.ms(e2);
                                                return;
                                            }
                                        }
                                        this.ub.ms(this.ao);
                                    }
                                }
                            } else if (com.ss.android.socialbase.downloader.downloader.ah.ms(downloadInfoXr) != id) {
                                try {
                                    this.ub.c(id);
                                } catch (SQLiteException e3) {
                                    com.bytedance.sdk.openadsdk.api.ab.ms(e3);
                                }
                            } else {
                                z = z4;
                            }
                        } catch (com.ss.android.socialbase.downloader.exception.ms e4) {
                            e = e4;
                        } catch (Throwable th2) {
                            th = th2;
                            z = false;
                        }
                        throw e;
                    }
                } else {
                    z = false;
                }
                try {
                    x();
                    if (z) {
                        try {
                            this.ub.ms(this.ao);
                        } catch (SQLiteException e5) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e5);
                        }
                    }
                } catch (com.ss.android.socialbase.downloader.exception.ms e6) {
                    throw e6;
                } catch (Throwable th3) {
                    th = th3;
                    boolean z5 = z;
                    z = false;
                    z3 = z5;
                    downloadTask = this.ah;
                    if (downloadTask != null) {
                        com.ss.android.socialbase.downloader.d.ms.ms(downloadTask.getMonitorDepend(), this.ao, new BaseException(1003, com.ss.android.socialbase.downloader.ny.c.xr(th, "checkTaskCache")), this.ao.getStatus());
                    }
                    if (z3) {
                        if (z) {
                            if (!this.f.ms("fix_file_exist_update_download_info")) {
                                return;
                            }
                        }
                        this.ub.ms(this.ao);
                    }
                }
            } catch (Throwable th4) {
                if (0 != 0) {
                    if (z2) {
                        try {
                            if (this.f.ms("fix_file_exist_update_download_info")) {
                                this.ub.ms(this.ao);
                            }
                        } catch (SQLiteException e7) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e7);
                        }
                    } else {
                        this.ub.ms(this.ao);
                    }
                }
                throw th4;
            }
        } catch (com.ss.android.socialbase.downloader.exception.ms e8) {
            throw e8;
        } catch (Throwable th5) {
            th = th5;
            z = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.ah.ms(this.ah, 3);
        try {
            com.ss.android.socialbase.downloader.network.xr.ms().xr();
            hi();
            com.ss.android.socialbase.downloader.network.xr.ms().ah();
            com.ss.android.socialbase.downloader.downloader.ah.xr(this.ah, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.network.xr.ms().ah();
            throw th;
        }
    }

    private void hi() {
        Process.setThreadPriority(10);
        try {
            DownloadInfo downloadInfo = this.ao;
            if (downloadInfo != null && this.jw > 0) {
                downloadInfo.increaseDownloadPrepareTime(System.currentTimeMillis() - this.jw);
            }
        } catch (Throwable unused) {
        }
        try {
            IDownloadInterceptor interceptor = this.ah.getInterceptor();
            if (interceptor != null && interceptor.intercepte()) {
                this.b.ka();
                return;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        if (!ny()) {
            i monitorDepend = this.ah.getMonitorDepend();
            DownloadInfo downloadInfo2 = this.ao;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo3 = this.ao;
            com.ss.android.socialbase.downloader.d.ms.ms(monitorDepend, downloadInfo2, baseException, downloadInfo3 != null ? downloadInfo3.getStatus() : 0);
            return;
        }
        while (true) {
            sl();
            if (!this.cv) {
                return;
            }
            if (this.le > 0) {
                this.le--;
            } else if (this.ao.getCurBytes() != this.ao.getTotalBytes()) {
                com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, this.ao.getErrorBytesLog());
                this.b.ms(new com.ss.android.socialbase.downloader.exception.c(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.ao.getByteInvalidRetryStatus()));
                return;
            } else if (this.ao.getCurBytes() <= 0) {
                com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, this.ao.getErrorBytesLog());
                this.b.ms(new com.ss.android.socialbase.downloader.exception.c(1026, "curBytes is 0, bytes invalid retry status is : " + this.ao.getByteInvalidRetryStatus()));
                return;
            } else if (this.ao.getTotalBytes() <= 0) {
                com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, this.ao.getErrorBytesLog());
                this.b.ms(new com.ss.android.socialbase.downloader.exception.c(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.ao.getByteInvalidRetryStatus()));
                return;
            }
        }
    }

    private void sl() {
        boolean z;
        try {
            this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_NONE;
            this.ao.updateStartDownloadTime();
            this.ao.resetRealStartDownloadTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.ao.setFirstSpeedTime(-1L);
            try {
                ch();
                z = false;
            } catch (com.ss.android.socialbase.downloader.exception.ms e) {
                com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "file exist " + e.ms());
                this.of = e.ms();
                z = true;
            }
            if (!this.cv) {
                this.b.xr();
            }
            this.cv = false;
            if (b()) {
                ao();
                return;
            }
            if (!TextUtils.isEmpty(this.of) && z) {
                if (this.ao.isExpiredRedownload()) {
                    this.p = com.ss.android.socialbase.downloader.ny.c.d(this.ao);
                }
                if (!this.p) {
                    zb();
                    ao();
                    return;
                }
            }
            while (true) {
                if (b()) {
                    ao();
                    return;
                }
                try {
                    try {
                        p();
                        le();
                        of();
                        List<com.ss.android.socialbase.downloader.model.xr> listAh = this.ub.ah(this.ao.getId());
                        pc();
                        if (u()) {
                            com.ss.android.socialbase.downloader.ah.ms.ah(f4795ms, "downloadSegments return");
                            y();
                            ao();
                            return;
                        }
                        String connectionUrl = this.ao.getConnectionUrl();
                        if (b()) {
                            y();
                            ao();
                            return;
                        }
                        long jKa = this.ny ? com.ss.android.socialbase.downloader.ny.c.ka(this.ao) : 0L;
                        com.ss.android.socialbase.downloader.model.xr xrVarMs = ms(this.ao, jKa);
                        List<com.ss.android.socialbase.downloader.model.ah> listMs = ms(xrVarMs);
                        com.ss.android.socialbase.downloader.ny.c.ms(listMs, this.ao);
                        com.ss.android.socialbase.downloader.ny.c.xr(listMs, this.ao);
                        this.ao.setPreconnectLevel(0);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        try {
                            ms(connectionUrl, listMs, jKa);
                            this.ao.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                            if (b()) {
                                y();
                                ao();
                                return;
                            }
                            long totalBytes = this.ao.getTotalBytes();
                            ms(totalBytes);
                            int iMs = ms(totalBytes, listAh);
                            if (b()) {
                                y();
                                ao();
                                return;
                            }
                            if (iMs <= 0) {
                                throw new BaseException(1032, "chunkCount is 0");
                            }
                            boolean z2 = iMs == 1;
                            this.x = z2;
                            if (!z2) {
                                if (!this.ao.isNeedReuseFirstConnection()) {
                                    qv();
                                }
                                if (!b()) {
                                    ub();
                                    this.ao.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                                    if (!this.ny) {
                                        ms(totalBytes, iMs);
                                        break;
                                    } else {
                                        ms(iMs, listAh);
                                        break;
                                    }
                                }
                                y();
                                ao();
                                return;
                            }
                            if (this.i == null) {
                                try {
                                    jCurrentTimeMillis2 = System.currentTimeMillis();
                                    ms(connectionUrl, listMs);
                                    this.ao.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                } catch (Throwable th) {
                                    this.ao.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                    throw th;
                                }
                            }
                            if (!b()) {
                                this.ao.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                                ub();
                                ms(xrVarMs, connectionUrl, this.i);
                                break;
                            } else {
                                y();
                                ao();
                                return;
                            }
                        } catch (Throwable th2) {
                            this.ao.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                            throw th2;
                        }
                    } catch (com.ss.android.socialbase.downloader.exception.ms unused) {
                        zb();
                    } catch (BaseException e2) {
                        com.ss.android.socialbase.downloader.ah.ms.d(f4795ms, "downloadInner: baseException = " + e2);
                        if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_PAUSE) {
                            break;
                        }
                        if (e2.getErrorCode() != 1025 && e2.getErrorCode() != 1009) {
                            if (!ms(e2)) {
                                xr(e2);
                                break;
                            }
                            if (com.ss.android.socialbase.downloader.ny.c.ms(e2)) {
                                jw();
                            }
                            if (ms(e2, 0L) == com.ss.android.socialbase.downloader.exception.x.RETURN) {
                                y();
                                ao();
                                return;
                            }
                            y();
                        }
                        this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_END_RIGHT_NOW;
                        y();
                        ao();
                        return;
                    }
                } catch (com.ss.android.socialbase.downloader.exception.ny e3) {
                    try {
                        com.ss.android.socialbase.downloader.ah.ms.d(f4795ms, "downloadInner: retry throwable for " + e3.ms());
                        if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_PAUSE) {
                            break;
                        }
                        AtomicInteger atomicInteger = this.ka;
                        if (atomicInteger != null && atomicInteger.get() > 0) {
                            this.ao.updateCurRetryTime(this.ka.decrementAndGet());
                            this.ao.setStatus(5);
                        } else if (this.ka == null) {
                            xr(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e3.ms()));
                            break;
                        } else if (!this.ao.trySwitchToNextBackupUrl()) {
                            xr(new BaseException(PointerIconCompat.TYPE_ZOOM_IN, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.ao.getRetryCount()), e3.ms())));
                            break;
                        } else {
                            this.ao.setStatus(5);
                            this.ka.set(this.ao.getRetryCount());
                            this.ao.updateCurRetryTime(this.ka.get());
                        }
                        y();
                    } catch (Throwable th3) {
                        y();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    com.ss.android.socialbase.downloader.ah.ms.d(f4795ms, "downloadInner: throwable =  " + th4);
                    if (this.u != com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_PAUSE) {
                        xr(new BaseException(1045, th4));
                    }
                }
                y();
            }
            y();
            ao();
        } catch (Throwable th5) {
            ao();
            throw th5;
        }
    }

    private void zb() {
        com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.ab.ms.ah().xr("fix_end_for_file_exist_error", true)) {
            if (this.of.equals(this.ao.getName())) {
                this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.of.equals(this.ao.getTargetFilePath())) {
            this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private boolean u() throws InterruptedException, BaseException {
        if (this.ao.isExpiredRedownload() || this.ao.getChunkCount() != 1 || this.ao.getThrottleNetSpeed() > 0) {
            return false;
        }
        JSONObject jSONObjectD = com.ss.android.socialbase.downloader.ab.ms.ms(this.ao.getId()).d("segment_config");
        List<com.ss.android.socialbase.downloader.c.ny> listU = this.ub.u(this.ao.getId());
        if (this.ao.getCurBytes() > 0) {
            if (listU == null || listU.isEmpty()) {
                return false;
            }
            if (jSONObjectD == null) {
                jSONObjectD = new JSONObject();
            }
        }
        if (jSONObjectD == null) {
            return false;
        }
        this.az = new hi(this.ao, u.ms(jSONObjectD), this);
        if (b()) {
            com.ss.android.socialbase.downloader.ah.ms.ah(f4795ms, "downloadSegments: is stopped by user");
            if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_CANCELED) {
                this.az.ms();
            } else {
                this.az.xr();
            }
            return true;
        }
        return this.az.ms(listU);
    }

    private void ub() {
        if (com.ss.android.socialbase.downloader.ab.ms.ms(this.ao.getId()).ms("reset_retain_retry_times", 0) != 1 || this.ul >= 3) {
            return;
        }
        this.ka.set(this.ao.isBackUpUrlUsed() ? this.ao.getBackUpUrlRetryCount() : this.ao.getRetryCount());
        this.ul++;
    }

    private void ms(String str, List<com.ss.android.socialbase.downloader.model.ah> list, long j) throws com.ss.android.socialbase.downloader.exception.ny, BaseException {
        xr(str, list, j);
        com.ss.android.socialbase.downloader.network.ab abVar = this.w;
        if (abVar != null) {
            try {
                ms(str, abVar, j);
            } catch (Throwable unused) {
                this.g = true;
            }
        }
        if (this.w == null || this.g) {
            ms(str, list);
            ms(str, this.i, j);
        }
    }

    private void ao() {
        boolean zRe;
        boolean z;
        com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "endDownloadRunnable::runStatus=" + this.u);
        boolean z2 = (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_PAUSE || this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_CANCELED) ? false : true;
        try {
            zRe = re();
            z = false;
        } catch (Exception e) {
            if (e instanceof BaseException) {
                this.b.ms((BaseException) e);
            } else {
                this.b.ms(new BaseException(1046, e));
            }
            zRe = true;
            z = true;
        }
        if (zRe || z) {
            this.zb.set(false);
            if (z2) {
                try {
                    com.ss.android.socialbase.downloader.impls.ms msVarG = com.ss.android.socialbase.downloader.downloader.ah.g();
                    if (msVarG != null) {
                        msVarG.ms(this);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    i monitorDepend = this.ah.getMonitorDepend();
                    DownloadInfo downloadInfo = this.ao;
                    BaseException baseException = new BaseException(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, com.ss.android.socialbase.downloader.ny.c.xr(th, "removeDownloadRunnable"));
                    DownloadInfo downloadInfo2 = this.ao;
                    com.ss.android.socialbase.downloader.d.ms.ms(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
                    return;
                }
            }
            return;
        }
        this.cv = true;
        com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "jump to restart");
    }

    private void xr(String str, List<com.ss.android.socialbase.downloader.model.ah> list, long j) throws com.ss.android.socialbase.downloader.exception.ny, BaseException {
        com.ss.android.socialbase.downloader.network.ms.ah ahVarMs;
        boolean z = true;
        if (this.ao.getChunkCount() == 1 && (ahVarMs = com.ss.android.socialbase.downloader.network.ms.ms.ms().ms(str, list)) != null) {
            this.w = ahVarMs;
            this.ao.setPreconnectLevel(1);
        }
        if (this.w == null && !this.g && this.ao.isHeadConnectionAvailable()) {
            try {
                int iXr = this.f.xr("net_lib_strategy");
                if (this.f.ms("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.w = com.ss.android.socialbase.downloader.downloader.ah.ms(str, list, iXr, z, this.ao);
            } catch (Throwable th) {
                this.ao.setHeadConnectionException(com.ss.android.socialbase.downloader.ny.c.ch(th));
            }
        }
    }

    private void ms(String str, List<com.ss.android.socialbase.downloader.model.ah> list) throws com.ss.android.socialbase.downloader.exception.ny, BaseException {
        ny nyVarMs;
        if (this.i != null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.ms.d dVarXr = this.ao.getChunkCount() == 1 ? com.ss.android.socialbase.downloader.network.ms.ms.ms().xr(str, list) : null;
        try {
            if (dVarXr != null) {
                ms(this.i);
                this.ao.setPreconnectLevel(2);
                this.i = dVarXr;
            } else {
                try {
                    nyVarMs = com.ss.android.socialbase.downloader.downloader.ah.ms(this.ao.isNeedDefaultHttpServiceBackUp(), this.ao.getMaxBytes(), str, null, list, this.f.xr("net_lib_strategy"), this.f.ms("monitor_download_connect", 0) > 0, this.ao);
                    this.i = nyVarMs;
                } catch (BaseException e) {
                    throw e;
                } catch (Throwable th) {
                    if (this.ao.isExpiredRedownload() && com.ss.android.socialbase.downloader.ny.c.ab(th) && com.ss.android.socialbase.downloader.ny.c.ah(list)) {
                        com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.ao.getCacheControl());
                        long jNy = com.ss.android.socialbase.downloader.ny.c.ny(this.ao.getCacheControl());
                        if (jNy <= 0) {
                            jNy = com.ss.android.socialbase.downloader.ab.ms.ms(this.ao.getId()).ms("default_304_max_age", 300);
                        }
                        this.ao.setCacheExpiredTime(System.currentTimeMillis() + (jNy * 1000));
                        throw new com.ss.android.socialbase.downloader.exception.ms(this.of);
                    }
                    if (com.ss.android.socialbase.downloader.ny.c.c(th)) {
                        ms("", "http code 416");
                    } else if (com.ss.android.socialbase.downloader.ny.c.ka(th)) {
                        ms("", "http code 412");
                    } else {
                        com.ss.android.socialbase.downloader.ny.c.ms(th, "CreateFirstConnection");
                    }
                    nyVarMs = this.i;
                }
                ms(nyVarMs);
            }
            if (this.i == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            ms(this.i);
            throw th2;
        }
    }

    private void h() {
        com.ss.android.socialbase.downloader.network.ab abVar = this.w;
        if (abVar != null) {
            abVar.ah();
            this.w = null;
        }
    }

    private void qv() {
        ny nyVar = this.i;
        if (nyVar != null) {
            nyVar.d();
            this.i = null;
        }
    }

    private void y() {
        h();
        qv();
    }

    public static com.ss.android.socialbase.downloader.model.xr ms(DownloadInfo downloadInfo, long j) {
        return new com.ss.android.socialbase.downloader.model.xr.ms(downloadInfo.getId()).ms(-1).ms(0L).ka(j).xr(j).ah(0L).d(downloadInfo.getTotalBytes() - j).ms();
    }

    private List<com.ss.android.socialbase.downloader.model.ah> ms(com.ss.android.socialbase.downloader.model.xr xrVar) {
        List<com.ss.android.socialbase.downloader.model.ah> listMs = com.ss.android.socialbase.downloader.ny.c.ms(this.ao.getExtraHeaders(), this.ao.geteTag(), xrVar);
        if (this.ao.isExpiredRedownload() && this.p && this.ao.getLastModified() != null) {
            listMs.add(new com.ss.android.socialbase.downloader.model.ah("if-modified-since", this.ao.getLastModified()));
            listMs.add(new com.ss.android.socialbase.downloader.model.ah("download-tc21-1-15", "download-tc21-1-15"));
            com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "dcache::add head IF_MODIFIED_SINCE=" + this.ao.getLastModified());
        }
        return listMs;
    }

    private void t() throws BaseException {
        if (this.ab != null) {
            if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_CANCELED) {
                this.ao.setStatus(-4);
                this.ab.ah();
            } else if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_PAUSE) {
                this.ao.setStatus(-2);
                this.ab.xr();
            } else {
                this.ab.d();
            }
        }
    }

    private boolean nw() {
        return this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_CANCELED || this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_PAUSE;
    }

    private boolean b() {
        if (!nw() && this.ao.getStatus() != -2) {
            return false;
        }
        if (nw()) {
            return true;
        }
        if (this.ao.getStatus() == -2) {
            this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_PAUSE;
            return true;
        }
        if (this.ao.getStatus() != -4) {
            return true;
        }
        this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_CANCELED;
        return true;
    }

    private boolean re() {
        if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_ERROR) {
            this.b.ms(this.re);
        } else if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_CANCELED) {
            this.b.ah();
        } else if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_PAUSE) {
            this.b.d();
        } else if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.b.ab();
            } catch (BaseException e) {
                this.b.ms(e);
            }
        } else if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.b.ms(this.of);
            } catch (BaseException e2) {
                this.b.ms(e2);
            }
        } else {
            if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.b.ms(this.re, false);
                return false;
            }
            if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_RETRY_DELAY && !i()) {
                com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "doTaskStatusHandle retryDelay");
                yu();
                return this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_RETRY_DELAY;
            }
            try {
                if (!w()) {
                    return false;
                }
                this.b.c();
                com.ss.android.socialbase.downloader.impls.qv.ms().d();
            } catch (Throwable th) {
                xr(new BaseException(PointerIconCompat.TYPE_TEXT, com.ss.android.socialbase.downloader.ny.c.xr(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private boolean i() {
        if (this.ao.getChunkCount() <= 1) {
            return this.ao.getCurBytes() > 0 && this.ao.getCurBytes() == this.ao.getTotalBytes();
        }
        List<com.ss.android.socialbase.downloader.model.xr> listAh = this.ub.ah(this.ao.getId());
        if (listAh == null || listAh.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.xr xrVar : listAh) {
            if (xrVar == null || !xrVar.ny()) {
                return false;
            }
        }
        return true;
    }

    private boolean w() {
        if (this.ao.isChunked()) {
            DownloadInfo downloadInfo = this.ao;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        com.ss.android.socialbase.downloader.ah.ms.ah(f4795ms, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.ao.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.ao.getTotalBytes());
        if (this.ao.getCurBytes() > 0) {
            if (this.ao.isIgnoreDataVerify()) {
                return true;
            }
            if (this.ao.getTotalBytes() > 0 && this.ao.getCurBytes() == this.ao.getTotalBytes()) {
                return true;
            }
        }
        this.ao.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.xr.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.ao.reset();
        this.ub.ms(this.ao);
        this.ub.d(this.ao.getId());
        this.ub.zb(this.ao.getId());
        com.ss.android.socialbase.downloader.ny.c.ms(this.ao);
        return false;
    }

    private void yu() {
        this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_NONE;
    }

    private long op() {
        return this.nw.ms(this.ao.getCurRetryTimeInTotal(), this.ao.getTotalRetryCount());
    }

    private void le() throws com.ss.android.socialbase.downloader.exception.ny, BaseException {
        com.ss.android.socialbase.downloader.impls.ms msVarG;
        int id = this.ao.getId();
        int iMs = com.ss.android.socialbase.downloader.downloader.ah.ms(this.ao);
        if (this.ao.isDownloaded() && !this.ao.isExpiredRedownload() && !this.p) {
            throw new BaseException(PointerIconCompat.TYPE_VERTICAL_TEXT, "file has downloaded");
        }
        DownloadInfo downloadInfoXr = this.ub.xr(iMs);
        if (downloadInfoXr == null || (msVarG = com.ss.android.socialbase.downloader.downloader.ah.g()) == null || downloadInfoXr.getId() == id || !downloadInfoXr.equalsTask(this.ao)) {
            return;
        }
        if (msVarG.ms(downloadInfoXr.getId())) {
            this.ub.c(id);
            throw new BaseException(InputDeviceCompat.SOURCE_GAMEPAD, "another same task is downloading");
        }
        List<com.ss.android.socialbase.downloader.model.xr> listAh = this.ub.ah(iMs);
        com.ss.android.socialbase.downloader.ny.c.ms(this.ao);
        this.ub.c(iMs);
        if (downloadInfoXr == null || !downloadInfoXr.isBreakpointAvailable()) {
            return;
        }
        this.ao.copyFromCacheData(downloadInfoXr, false);
        this.ub.ms(this.ao);
        if (listAh != null) {
            for (com.ss.android.socialbase.downloader.model.xr xrVar : listAh) {
                xrVar.xr(id);
                this.ub.ms(xrVar);
            }
        }
        throw new com.ss.android.socialbase.downloader.exception.ny("retry task because id generator changed");
    }

    private void ms(int i, List<com.ss.android.socialbase.downloader.model.xr> list) throws BaseException {
        if (list.size() != i) {
            throw new BaseException(1033, new IllegalArgumentException());
        }
        ms(list, this.ao.getTotalBytes());
    }

    private void ms(long j, int i) throws BaseException {
        long j2 = j / ((long) i);
        int id = this.ao.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            com.ss.android.socialbase.downloader.model.xr xrVarMs = new com.ss.android.socialbase.downloader.model.xr.ms(id).ms(i2).ms(j3).ka(j3).xr(j3).ah(i2 == i + (-1) ? 0L : (j3 + j2) - 1).ms();
            arrayList.add(xrVarMs);
            this.ub.ms(xrVarMs);
            j3 += j2;
            i2++;
        }
        this.ao.setChunkCount(i);
        this.ub.ms(id, i);
        ms(arrayList, j);
    }

    private void ms(List<com.ss.android.socialbase.downloader.model.xr> list, long j) throws BaseException {
        long jAo;
        for (com.ss.android.socialbase.downloader.model.xr xrVar : list) {
            if (xrVar != null) {
                if (xrVar.ao() == 0) {
                    jAo = j - xrVar.u();
                } else {
                    jAo = (xrVar.ao() - xrVar.u()) + 1;
                }
                if (jAo > 0) {
                    xrVar.ms(jAo);
                    if (this.ao.isNeedReuseFirstConnection() && this.i != null && (!this.ao.isHeadConnectionAvailable() || this.g)) {
                        if (xrVar.y() == 0) {
                            this.c.add(new xr(xrVar, this.ah, this.i, this));
                        } else if (xrVar.y() > 0) {
                            this.c.add(new xr(xrVar, this.ah, this));
                        }
                    } else {
                        this.c.add(new xr(xrVar, this.ah, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.ny.ms.ms(64)) {
            ArrayList arrayList = new ArrayList(this.c.size());
            for (xr xrVar2 : this.c) {
                if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_CANCELED) {
                    xrVar2.xr();
                } else if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_PAUSE) {
                    xrVar2.ms();
                } else {
                    arrayList.add(xrVar2);
                }
            }
            try {
                List<Future> listD = com.ss.android.socialbase.downloader.impls.ka.d(arrayList);
                for (Runnable runnableKa = (Runnable) arrayList.remove(0); runnableKa != null; runnableKa = com.ss.android.socialbase.downloader.impls.ka.ka(listD)) {
                    if (b()) {
                        return;
                    }
                    try {
                        runnableKa.run();
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    }
                }
                if (listD == null || listD.isEmpty()) {
                    return;
                }
                for (Future future : listD) {
                    if (future != null && !future.isDone()) {
                        future.get();
                    }
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.c.size());
        for (xr xrVar3 : this.c) {
            if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_CANCELED) {
                xrVar3.xr();
            } else if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_PAUSE) {
                xrVar3.ms();
            } else {
                arrayList2.add(Executors.callable(xrVar3));
            }
        }
        if (b()) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.impls.ka.ah(arrayList2);
        } catch (InterruptedException e) {
            throw new BaseException(PointerIconCompat.TYPE_GRAB, e);
        }
    }

    private void ms(com.ss.android.socialbase.downloader.model.xr xrVar, String str, ny nyVar) throws BaseException {
        xrVar.ms(this.ao.getTotalBytes() - xrVar.u());
        this.ao.setChunkCount(1);
        this.ub.ms(this.ao.getId(), 1);
        this.ab = new com.ss.android.socialbase.downloader.downloader.ka(this.ao, str, nyVar, xrVar, this);
        t();
    }

    private boolean cv() {
        DownloadInfo downloadInfo = this.ao;
        return (downloadInfo == null || downloadInfo.isExpiredRedownload() || (this.ny && this.ao.getChunkCount() <= 1) || this.ao.isChunkDowngradeRetryUsed() || !this.ch || this.sl) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [long] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.ss.android.socialbase.downloader.model.ka] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17, types: [long] */
    /* JADX WARN: Type inference failed for: r7v22 */
    @Override // com.ss.android.socialbase.downloader.x.c
    public void ms(long j) throws Throwable {
        ?? D;
        com.ss.android.socialbase.downloader.model.ka kaVar;
        long j2;
        boolean z;
        com.ss.android.socialbase.downloader.model.ka kaVar2;
        com.ss.android.socialbase.downloader.model.ka kaVar3;
        ?? r7;
        String tempPath = this.ao.getTempPath();
        String tempName = this.ao.getTempName();
        if (com.ss.android.socialbase.downloader.ny.c.xr(j)) {
            return;
        }
        com.ss.android.socialbase.downloader.model.ka kaVarMs = com.ss.android.socialbase.downloader.ny.c.ms(this.ao, tempPath, tempName, -1);
        try {
            long length = new File(tempPath, tempName).length();
            long totalBytes = j - length;
            D = com.ss.android.socialbase.downloader.ny.c.d(tempPath);
            com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(this.ao.getId());
            try {
                try {
                    if (msVarMs.ms("space_fill_part_download", 0) == 1) {
                        this.pc = 0L;
                        if (totalBytes <= 0) {
                            totalBytes = this.ao.getTotalBytes() - this.ao.getCurBytes();
                        }
                        if (D < totalBytes) {
                            String str = f4795ms;
                            kaVar3 = kaVarMs;
                            com.ss.android.socialbase.downloader.ah.ms.d(str, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.ny.c.ms(j) + "MB, downloaded = " + com.ss.android.socialbase.downloader.ny.c.ms(length) + "MB, required = " + com.ss.android.socialbase.downloader.ny.c.ms(totalBytes) + "MB, available = " + com.ss.android.socialbase.downloader.ny.c.ms((long) D) + "MB");
                            if (D > 0) {
                                int iMs = msVarMs.ms("space_fill_min_keep_mb", 100);
                                if (iMs > 0) {
                                    long j3 = D - (((long) iMs) * BaseConstants.MB_VALUE);
                                    com.ss.android.socialbase.downloader.ah.ms.d(str, "checkSpaceOverflow: minKeep = " + iMs + "MB, canDownload = " + com.ss.android.socialbase.downloader.ny.c.ms(j3) + "MB");
                                    if (j3 <= 0) {
                                        throw new com.ss.android.socialbase.downloader.exception.d(D, totalBytes);
                                    }
                                    this.pc = this.ao.getCurBytes() + j3;
                                    r7 = j3;
                                } else {
                                    r7 = D;
                                }
                                kaVar = kaVar3;
                                if (length < j) {
                                    j2 = r7 + length;
                                    if (j2 > j) {
                                        kaVar2 = kaVar3;
                                        kaVar = kaVar3;
                                    }
                                }
                                kaVar2 = kaVar3;
                                z = true;
                                D = kaVar2;
                            } else {
                                if (msVarMs.ms("download_when_space_negative", 0) != 1) {
                                    throw new BaseException(1052, "availableSpace " + (D == 0 ? "=" : "<") + " 0");
                                }
                                j2 = j;
                                z = false;
                                D = kaVar3;
                            }
                            D.xr(j);
                            com.ss.android.socialbase.downloader.ny.c.ms((Closeable[]) new Closeable[]{D});
                        }
                        kaVar = kaVarMs;
                    } else {
                        kaVar = kaVarMs;
                        if (D <= 0) {
                            throw new BaseException(1052, "availableSpace " + (D == 0 ? "=" : "<") + " 0");
                        }
                        if (D < totalBytes) {
                            throw new com.ss.android.socialbase.downloader.exception.d(D, totalBytes);
                        }
                    }
                    D.xr(j);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.ah.ms.ka(f4795ms, "checkSpaceOverflow: setLength1 e = " + th + ", mustSetLength = " + z);
                    if (j2 < j && j2 > 0 && j2 > length) {
                        try {
                            D.xr(j2);
                        } catch (Throwable th2) {
                            com.ss.android.socialbase.downloader.ah.ms.ka(f4795ms, "checkSpaceOverflow: setLength2 ex = " + th2 + ", mustSetLength = " + z);
                            if (z) {
                                throw new BaseException(AVMDLDataLoader.KeyIsPreloadWaitListType, th2);
                            }
                        }
                    } else if (z) {
                        throw new BaseException(AVMDLDataLoader.KeyIsPreloadWaitListType, th);
                    }
                }
                j2 = j;
                kaVar2 = kaVar;
                kaVar2 = kaVar3;
                z = true;
                D = kaVar2;
                com.ss.android.socialbase.downloader.ny.c.ms((Closeable[]) new Closeable[]{D});
            } catch (Throwable th3) {
                th = th3;
                com.ss.android.socialbase.downloader.ny.c.ms((Closeable[]) new Closeable[]{D});
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            D = kaVarMs;
        }
    }

    private void g() throws BaseException {
        long jD;
        int iMs;
        try {
            jD = com.ss.android.socialbase.downloader.ny.c.d(this.ao.getTempPath());
        } catch (BaseException unused) {
            jD = 0;
        }
        String str = f4795ms;
        com.ss.android.socialbase.downloader.ah.ms.ah(str, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.ny.c.ms(jD) + "MB");
        if (jD > 0) {
            long totalBytes = this.ao.getTotalBytes() - this.ao.getCurBytes();
            if (jD < totalBytes && (iMs = com.ss.android.socialbase.downloader.ab.ms.ms(this.ao.getId()).ms("space_fill_min_keep_mb", 100)) > 0) {
                long j = jD - (((long) iMs) * BaseConstants.MB_VALUE);
                com.ss.android.socialbase.downloader.ah.ms.ah(str, "checkSpaceOverflowInProgress: minKeep  = " + iMs + "MB, canDownload = " + com.ss.android.socialbase.downloader.ny.c.ms(j) + "MB");
                if (j <= 0) {
                    this.pc = 0L;
                    throw new com.ss.android.socialbase.downloader.exception.d(jD, totalBytes);
                }
                this.pc = this.ao.getCurBytes() + j + BaseConstants.MB_VALUE;
                return;
            }
        }
        this.pc = 0L;
    }

    private void of() throws com.ss.android.socialbase.downloader.exception.c {
        if (this.ao.isOnlyWifi() && !com.ss.android.socialbase.downloader.ny.c.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), g.b)) {
            throw new com.ss.android.socialbase.downloader.exception.c(PointerIconCompat.TYPE_ZOOM_OUT, String.format("download task need permission:%s", g.b));
        }
        if (!this.ao.isDownloadWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.ah();
        }
        if (!this.ao.isPauseReserveWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.ka();
        }
    }

    private void p() throws BaseException {
        if (TextUtils.isEmpty(this.ao.getSavePath())) {
            throw new BaseException(1028, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.ao.getName())) {
            throw new BaseException(1029, "download name can not be empty");
        }
        File file = new File(this.ao.getSavePath());
        if (!file.exists()) {
            boolean zMkdirs = file.mkdirs();
            if (zMkdirs || file.exists()) {
                return;
            }
            int i = 0;
            if (com.ss.android.socialbase.downloader.ab.ms.ms(this.ao.getId()).ms("opt_mkdir_failed", 0) == 1) {
                while (!zMkdirs) {
                    int i2 = i + 1;
                    if (i >= 3) {
                        break;
                    }
                    try {
                        Thread.sleep(10L);
                        zMkdirs = file.mkdirs();
                        i = i2;
                    } catch (InterruptedException unused) {
                    }
                }
                if (zMkdirs || file.exists()) {
                    return;
                }
                if (com.ss.android.socialbase.downloader.ny.c.d(this.ao.getSavePath()) < 16384) {
                    throw new BaseException(1006, "download savePath directory can not created:" + this.ao.getSavePath());
                }
                throw new BaseException(1030, "download savePath directory can not created:" + this.ao.getSavePath());
            }
            throw new BaseException(1030, "download savePath directory can not created:" + this.ao.getSavePath());
        }
        if (file.isDirectory()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.ny.d.xr(this.ao)) {
            file.delete();
            if (!file.mkdirs() && !file.exists()) {
                throw new BaseException(1031, "download savePath is not directory:path=" + this.ao.getSavePath());
            }
            return;
        }
        throw new BaseException(1031, "download savePath is not a directory:" + this.ao.getSavePath());
    }

    private boolean ms(int i, String str, String str2) {
        if (i == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.hi || this.ch)) {
            return (i == 201 || i == 416) && this.ao.getCurBytes() > 0;
        }
        return true;
    }

    private void ms(String str, String str2) throws com.ss.android.socialbase.downloader.exception.ny {
        this.ub.d(this.ao.getId());
        this.ub.zb(this.ao.getId());
        com.ss.android.socialbase.downloader.ny.c.ms(this.ao);
        this.ny = false;
        this.ao.resetDataForEtagEndure(str);
        this.ub.ms(this.ao);
        throw new com.ss.android.socialbase.downloader.exception.ny(str2);
    }

    @Override // com.ss.android.socialbase.downloader.x.c
    public void ms(String str, com.ss.android.socialbase.downloader.network.ab abVar, long j) throws com.ss.android.socialbase.downloader.exception.ny, BaseException {
        com.ss.android.socialbase.downloader.network.ab abVar2;
        String str2;
        long jXr;
        boolean z;
        if (abVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.model.d dVar = new com.ss.android.socialbase.downloader.model.d(str, abVar);
            int i = dVar.ah;
            String strD = dVar.d();
            if (TextUtils.isEmpty(this.ao.getMimeType()) && !TextUtils.isEmpty(strD)) {
                this.ao.setMimeType(strD);
            }
            boolean zXr = dVar.xr();
            this.ch = zXr;
            this.ao.setSupportPartial(zXr);
            this.hi = dVar.ms();
            String str3 = this.ao.geteTag();
            String strAh = dVar.ah();
            String strC = dVar.c();
            String strAb = dVar.ab();
            String str4 = f4795ms;
            com.ss.android.socialbase.downloader.ah.ms.xr(str4, "dcache=responseCode=" + i + " last_modified=" + strC + " CACHE_CONTROL=" + strAb + " max-age=" + dVar.hi() + " isDeleteCacheIfCheckFailed=" + this.ao.isDeleteCacheIfCheckFailed());
            com.ss.android.socialbase.downloader.ah.ms.xr(str4, "dcache=firstOffset=" + j + " cur=" + strC + " before=" + this.ao.getLastModified() + " cur=" + dVar.ch() + " before=" + this.ao.getTotalBytes());
            if (!TextUtils.isEmpty(strAb)) {
                this.ao.setCacheControl(strAb);
                if (dVar.hi() > 0) {
                    this.ao.setCacheExpiredTime(System.currentTimeMillis() + (dVar.hi() * 1000));
                }
            }
            if (this.ao.isExpiredRedownload() && this.p && !TextUtils.isEmpty(this.of)) {
                if (i == 304) {
                    z = true;
                } else {
                    z = false;
                    if ((!TextUtils.isEmpty(this.ao.getLastModified()) || !this.ao.isDeleteCacheIfCheckFailed()) && TextUtils.equals(strC, this.ao.getLastModified())) {
                        z = true;
                    }
                }
                if (z) {
                    com.ss.android.socialbase.downloader.ah.ms.xr(str4, "dcache=responseCode=" + i + " lastModified not changed, use local file  " + strC);
                    throw new com.ss.android.socialbase.downloader.exception.ms(this.of);
                }
                com.ss.android.socialbase.downloader.ny.c.ms(this.ao);
            }
            if (j > 0 && this.ao.isExpiredRedownload() && !TextUtils.equals(strC, this.ao.getLastModified())) {
                com.ss.android.socialbase.downloader.ah.ms.xr(str4, "dcache cdn file change, so retry");
                ms("", "cdn file changed");
            }
            if (!TextUtils.isEmpty(strC)) {
                this.ao.setLastModified(strC);
            }
            if (ms(i, str3, strAh)) {
                abVar2 = abVar;
                if (abVar2 instanceof ny) {
                    str2 = (TextUtils.isEmpty(str3) || !str3.equals(strAh)) ? strAh : "";
                    ms(str2, "eTag of server file changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.xr(1002, i, "");
                }
            } else {
                abVar2 = abVar;
                str2 = strAh;
            }
            if (!this.ch && !this.hi) {
                if (i == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.exception.xr(1004, i, "response code error : " + i);
            }
            if (this.hi && j > 0) {
                if (abVar2 instanceof ny) {
                    ms("", "http head request not support");
                } else {
                    throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
                }
            }
            long jX = dVar.x();
            if (!(abVar2 instanceof ny) && jX < 0 && com.ss.android.socialbase.downloader.ny.d.ms(this.ao)) {
                throw new BaseException(1004, "");
            }
            String strMs = TextUtils.isEmpty(this.ao.getName()) ? com.ss.android.socialbase.downloader.ny.c.ms(abVar2, this.ao.getUrl()) : "";
            boolean zNy = dVar.ny();
            this.sl = zNy;
            if (!zNy && jX == 0 && !(abVar2 instanceof ny)) {
                throw new BaseException(1004, "");
            }
            if (zNy) {
                jXr = -1;
            } else {
                String strXr = com.ss.android.socialbase.downloader.ny.c.xr(abVar2, "Content-Range");
                com.ss.android.socialbase.downloader.ah.ms.ah(str4, "firstConnection: contentRange = " + strXr);
                if (!TextUtils.isEmpty(strXr) && this.f.xr("fix_get_total_bytes", true)) {
                    jXr = com.ss.android.socialbase.downloader.ny.c.xr(strXr);
                    com.ss.android.socialbase.downloader.ah.ms.ah(str4, "firstConnection: 1 totalLength = " + jXr);
                } else {
                    jXr = j + jX;
                    com.ss.android.socialbase.downloader.ah.ms.ka(str4, "firstConnection: 2 totalLength = " + jXr + ", contentLength = " + jX);
                }
            }
            if (!TextUtils.isEmpty(this.ao.getTaskKey()) && this.ao.getTotalBytes() > 0 && jXr != this.ao.getTotalBytes()) {
                if (abVar2 instanceof ny) {
                    ms("", "file totalLength changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.xr(1002, i, "");
                }
            }
            if (b()) {
                return;
            }
            if (this.ao.getExpectFileLength() > 0 && com.ss.android.socialbase.downloader.ab.ms.ms(this.ao.getId()).xr("force_check_file_length") == 1 && this.ao.getExpectFileLength() != jXr) {
                throw new BaseException(1070, "expectFileLength = " + this.ao.getExpectFileLength() + " , totalLength = " + jXr);
            }
            this.b.ms(jXr, str2, strMs);
        } catch (BaseException e) {
            throw e;
        } catch (com.ss.android.socialbase.downloader.exception.ny e2) {
            throw e2;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.ny.c.ms(th, "HandleFirstConnection");
        }
    }

    public boolean d() {
        return this.zb.get();
    }

    public int ka() {
        DownloadInfo downloadInfo = this.ao;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    public void c() {
        this.jw = System.currentTimeMillis();
        this.b.ms();
    }

    private void pc() {
        long jC = com.ss.android.socialbase.downloader.ny.c.c(this.ao);
        long curBytes = this.ao.getCurBytes();
        if (jC != curBytes) {
            com.ss.android.socialbase.downloader.ah.ms.d(f4795ms, "checkTaskCanResume: offset = " + jC + ", curBytes = " + curBytes);
        }
        this.ao.setCurBytes(jC);
        boolean z = jC > 0;
        this.ny = z;
        if (z || this.p) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.ah(f4795ms, "checkTaskCanResume: deleteAllDownloadFiles");
        this.ub.d(this.ao.getId());
        this.ub.zb(this.ao.getId());
        com.ss.android.socialbase.downloader.ny.c.ms(this.ao);
    }

    @Override // com.ss.android.socialbase.downloader.x.c
    public boolean xr(long j) throws BaseException {
        if (this.pc > 0 && this.ao.getCurBytes() > this.pc) {
            g();
        }
        return this.b.ms(j);
    }

    @Override // com.ss.android.socialbase.downloader.x.c
    public void ms(xr xrVar) {
        if (this.x) {
            return;
        }
        synchronized (this) {
            this.c.remove(xrVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.x.c
    public boolean ms(BaseException baseException) {
        if (this.az != null && com.ss.android.socialbase.downloader.ny.c.ny(baseException) && this.ka.get() < this.ao.getRetryCount()) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.ny.c.xr(baseException)) {
            if (this.x && !this.d) {
                com.ss.android.socialbase.downloader.ny.c.ms(this.ao);
                this.d = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.ka;
        return ((atomicInteger != null && atomicInteger.get() > 0) || this.ao.hasNextBackupUrl() || (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.ao.canReplaceHttpForRetry()))) && !(baseException instanceof com.ss.android.socialbase.downloader.exception.c);
    }

    @Override // com.ss.android.socialbase.downloader.x.c
    public void xr(BaseException baseException) {
        com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "onError:" + baseException.getMessage());
        this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_ERROR;
        this.re = baseException;
        f();
    }

    private void jw() {
        com.ss.android.socialbase.downloader.ah.ms.d(f4795ms, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.ub.d(this.ao.getId());
            this.ub.zb(this.ao.getId());
            com.ss.android.socialbase.downloader.ny.c.ms(this.ao);
            this.ny = false;
            this.ao.resetDataForEtagEndure("");
            this.ub.ms(this.ao);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.x.c
    public void ah(BaseException baseException) {
        DownloadInfo downloadInfo = this.ao;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        ms(baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.x.c
    public void ms(BaseException baseException, boolean z) {
        com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "onAllChunkRetryWithReset");
        this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.re = baseException;
        f();
        if (z ? d(baseException) : false) {
            return;
        }
        jw();
    }

    private void f() {
        try {
            for (xr xrVar : (ArrayList) this.c.clone()) {
                if (xrVar != null) {
                    xrVar.xr();
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.ah.ms.ah(f4795ms, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.ao.setForbiddenBackupUrls(list, this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.ss.android.socialbase.downloader.impls.ms msVarG = com.ss.android.socialbase.downloader.downloader.ah.g();
        if (msVarG != null) {
            msVarG.sl(this.ao.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ul() {
        com.ss.android.socialbase.downloader.impls.ms msVarG;
        if (b() || (msVarG = com.ss.android.socialbase.downloader.downloader.ah.g()) == null) {
            return;
        }
        msVarG.sl(this.ao.getId());
    }

    @Override // com.ss.android.socialbase.downloader.x.c
    public com.ss.android.socialbase.downloader.exception.x ms(com.ss.android.socialbase.downloader.model.xr xrVar, BaseException baseException, long j) {
        if (nw()) {
            return com.ss.android.socialbase.downloader.exception.x.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.ss.android.socialbase.downloader.ny.c.x(baseException))) {
            return ms(baseException, j);
        }
        this.re = baseException;
        this.ao.increaseCurBytes(-j);
        this.ub.ms(this.ao);
        if (d(baseException)) {
            return com.ss.android.socialbase.downloader.exception.x.RETURN;
        }
        this.b.ms(xrVar, baseException, this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_RETRY_DELAY);
        if (this.u != com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_RETRY_DELAY && this.ao.isNeedRetryDelay()) {
            long jOp = op();
            if (jOp > 0) {
                com.ss.android.socialbase.downloader.ah.ms.ah(f4795ms, "onSingleChunkRetry with delay time " + jOp);
                try {
                    Thread.sleep(jOp);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.ah.ms.d(f4795ms, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.exception.x.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.x.c
    public com.ss.android.socialbase.downloader.exception.x ms(BaseException baseException, long j) {
        long jMs;
        long totalBytes;
        boolean z;
        this.re = baseException;
        this.ao.increaseCurBytes(-j);
        this.ub.ms(this.ao);
        if (nw()) {
            return com.ss.android.socialbase.downloader.exception.x.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.yu == null || this.ao.isForbiddenRetryed()) {
                if (d(baseException)) {
                    return com.ss.android.socialbase.downloader.exception.x.RETURN;
                }
            } else {
                com.ss.android.socialbase.downloader.depend.xr xrVar = new com.ss.android.socialbase.downloader.depend.xr() { // from class: com.ss.android.socialbase.downloader.x.ah.1
                    @Override // com.ss.android.socialbase.downloader.depend.xr, com.ss.android.socialbase.downloader.depend.b
                    public void ms(List<String> list) {
                        super.ms(list);
                        ah.this.ms(list);
                    }
                };
                boolean zMs = this.yu.ms(xrVar);
                this.ao.setForbiddenRetryed();
                if (zMs) {
                    if (!xrVar.ms()) {
                        f();
                        this.b.x();
                        this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.exception.x.RETURN;
                    }
                    z = true;
                }
            }
            z = false;
        } else if (com.ss.android.socialbase.downloader.ny.c.x(baseException)) {
            if (this.op == null) {
                xr(baseException);
                return com.ss.android.socialbase.downloader.exception.x.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            h hVar = new h() { // from class: com.ss.android.socialbase.downloader.x.ah.2
                @Override // com.ss.android.socialbase.downloader.depend.h
                public void ms() {
                    synchronized (ah.this) {
                        atomicBoolean.set(true);
                        ah.this.ul();
                    }
                }
            };
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
                com.ss.android.socialbase.downloader.exception.d dVar = (com.ss.android.socialbase.downloader.exception.d) baseException;
                jMs = dVar.ms();
                totalBytes = dVar.xr();
            } else {
                jMs = -1;
                totalBytes = this.ao.getTotalBytes();
            }
            synchronized (this) {
                if (this.op.ms(jMs, totalBytes, hVar)) {
                    if (!com.ss.android.socialbase.downloader.ab.ms.ms(this.ao.getId()).xr("not_delete_when_clean_space", false)) {
                        w();
                    }
                    if (!atomicBoolean.get()) {
                        if (this.u != com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                            this.u = com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_WAITING_ASYNC_HANDLER;
                            f();
                            this.b.x();
                        }
                        return com.ss.android.socialbase.downloader.exception.x.RETURN;
                    }
                    if (d(baseException)) {
                        return com.ss.android.socialbase.downloader.exception.x.RETURN;
                    }
                    z = true;
                } else {
                    if (this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        return com.ss.android.socialbase.downloader.exception.x.RETURN;
                    }
                    xr(baseException);
                    return com.ss.android.socialbase.downloader.exception.x.RETURN;
                }
            }
        } else {
            if (d(baseException)) {
                return com.ss.android.socialbase.downloader.exception.x.RETURN;
            }
            z = false;
        }
        if (!z && az()) {
            f();
        }
        this.b.ms(baseException, this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_RETRY_DELAY);
        return this.u == com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_RETRY_DELAY ? com.ss.android.socialbase.downloader.exception.x.RETURN : com.ss.android.socialbase.downloader.exception.x.CONTINUE;
    }

    private boolean d(BaseException baseException) {
        AtomicInteger atomicInteger = this.ka;
        boolean z = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                if (this.ao.trySwitchToNextBackupUrl()) {
                    this.ka.set(this.ao.getBackUpUrlRetryCount());
                    this.ao.updateCurRetryTime(this.ka.get());
                } else if (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.ao.canReplaceHttpForRetry())) {
                    this.ka.set(this.ao.getRetryCount());
                    this.ao.updateCurRetryTime(this.ka.get());
                    this.ao.setHttpsToHttpRetryUsed(true);
                } else {
                    xr(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.ka), String.valueOf(this.ao.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                z = false;
            }
            if (this.u != com.ss.android.socialbase.downloader.constants.x.RUN_STATUS_RETRY_DELAY && z) {
                this.ao.updateCurRetryTime(this.ka.decrementAndGet());
            }
            return false;
        }
        xr(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.x.c
    public synchronized com.ss.android.socialbase.downloader.model.xr ms(int i) {
        com.ss.android.socialbase.downloader.model.xr xrVarMs;
        if (this.ao.getChunkCount() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.model.xr> listAh = this.ub.ah(this.ao.getId());
        if (listAh != null && !listAh.isEmpty()) {
            for (int i2 = 0; i2 < listAh.size(); i2++) {
                com.ss.android.socialbase.downloader.model.xr xrVar = listAh.get(i2);
                if (xrVar != null && (xrVarMs = ms(xrVar, i)) != null) {
                    return xrVarMs;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.x.c
    public void ms(com.ss.android.socialbase.downloader.network.ab abVar) {
        boolean z;
        if (abVar != null) {
            try {
                int iXr = abVar.xr();
                this.ao.setHttpStatusCode(iXr);
                this.ao.setHttpStatusMessage(com.ss.android.socialbase.downloader.ny.xr.ms(iXr));
                z = true;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
                z = false;
            }
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        this.ao.setHttpStatusCode(-1);
        this.ao.setHttpStatusMessage("");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0083  */
    /* JADX WARN: Code duplicated, block: B:29:0x008f  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e5 A[SYNTHETIC] */
    private com.ss.android.socialbase.downloader.model.xr ms(com.ss.android.socialbase.downloader.model.xr xrVar, int i) {
        boolean z;
        int i2;
        com.ss.android.socialbase.downloader.model.xr xrVar2;
        com.ss.android.socialbase.downloader.model.xr xrVar3 = null;
        if (!xrVar.d()) {
            return null;
        }
        long jAh = xrVar.ah(true);
        com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "reuseChunk retainLen:" + jAh + " chunkIndex:" + i);
        if (!xrVar.c() && jAh > com.ss.android.socialbase.downloader.constants.ka.c && this.ao.isNeedReuseChunkRunnable()) {
            List<com.ss.android.socialbase.downloader.model.xr> listMs = xrVar.ms(this.ao.getChunkCount(), this.ao.getTotalBytes());
            if (listMs != null) {
                Iterator<com.ss.android.socialbase.downloader.model.xr> it = listMs.iterator();
                while (it.hasNext()) {
                    this.ub.xr(it.next());
                }
            }
        } else {
            if (!xrVar.c()) {
                z = false;
            }
            if (z && xrVar.c()) {
                for (i2 = 1; i2 < xrVar.ab().size(); i2++) {
                    xrVar2 = xrVar.ab().get(i2);
                    if (xrVar2 != null) {
                        com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "check can checkUnCompletedChunk -- chunkIndex:" + xrVar2.y() + " currentOffset:" + xrVar2.u() + "  startOffset:" + xrVar2.sl() + " contentLen:" + xrVar2.h());
                        if (xrVar2.y() >= 0 || (!xrVar2.ny() && !xrVar2.ah())) {
                            xrVar3 = xrVar2;
                            break;
                        }
                    }
                }
                if (xrVar3 != null) {
                    com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "unComplete chunk " + xrVar.y() + " curOffset:" + xrVar.u() + " reuseChunk chunkIndex:" + i + " for subChunk:" + xrVar3.y());
                    this.ub.ms(xrVar3.hi(), xrVar3.y(), xrVar3.xr(), i);
                    xrVar3.ah(i);
                    xrVar3.ms(true);
                }
            }
            return xrVar3;
        }
        z = true;
        if (z) {
            while (i2 < xrVar.ab().size()) {
                xrVar2 = xrVar.ab().get(i2);
                if (xrVar2 != null) {
                    com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "check can checkUnCompletedChunk -- chunkIndex:" + xrVar2.y() + " currentOffset:" + xrVar2.u() + "  startOffset:" + xrVar2.sl() + " contentLen:" + xrVar2.h());
                    if (xrVar2.y() >= 0) {
                    }
                    xrVar3 = xrVar2;
                    break;
                }
            }
            if (xrVar3 != null) {
                com.ss.android.socialbase.downloader.ah.ms.xr(f4795ms, "unComplete chunk " + xrVar.y() + " curOffset:" + xrVar.u() + " reuseChunk chunkIndex:" + i + " for subChunk:" + xrVar3.y());
                this.ub.ms(xrVar3.hi(), xrVar3.y(), xrVar3.xr(), i);
                xrVar3.ah(i);
                xrVar3.ms(true);
            }
        }
        return xrVar3;
    }

    private y ms(DownloadTask downloadTask) {
        y retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new com.ss.android.socialbase.downloader.impls.h(retryDelayTimeArray);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.ah.lm();
    }

    public Future ab() {
        return this.xr;
    }

    public void ms(Future future) {
        this.xr = future;
    }
}
