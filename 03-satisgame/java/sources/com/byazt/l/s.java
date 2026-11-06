package com.byazt.l;

import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.anythink.china.a.c;
import com.byazt.je.IDownloadInterceptor;
import com.byazt.je.cd;
import com.byazt.je.hd;
import com.byazt.je.m;
import com.byazt.je.wm;
import com.byazt.kl.cp;
import com.byazt.kl.sz;
import com.byazt.m.d;
import com.byazt.m.rv;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
import com.byazt.xv.tj;
import com.byazt.xv.um;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.TTAdConstant;
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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 18, 8})
public class s implements w, Runnable {
    public static final String n = "s";
    public final com.byazt.xv.x a;
    public final com.byazt.f.n ae;
    public long an;
    public final com.byazt.xv.fs cd;
    public boolean cp;
    public DownloadInfo cy;
    public boolean d;
    public boolean fs;
    public wm h;
    public com.byazt.xv.fs hd;
    public com.byazt.m.x hu;
    public long j;
    public final tj k;
    public AtomicInteger l;
    public String lh;
    public rv m;
    public final AtomicBoolean oa;
    public final com.byazt.xv.w ou;
    public um py;
    public Future qg;
    public boolean rv;
    public final DownloadTask s;
    public cd t;
    public boolean tj;
    public com.byazt.xv.x um;
    public volatile BaseException wm;
    public volatile com.byazt.xv.l x;
    public volatile boolean q = false;
    public final ArrayList<qg> w = new ArrayList<>();
    public volatile com.byazt.sk.fs sz = com.byazt.sk.fs.RUN_STATUS_NONE;
    public volatile int ur = 5;
    public boolean bb = false;
    public boolean ln = false;
    public boolean v = false;
    public int f = 0;
    public volatile cp fi = null;

    private boolean fi() {
        return false;
    }

    public s(DownloadTask downloadTask, Handler handler) {
        this.s = downloadTask;
        if (downloadTask != null) {
            this.cy = downloadTask.getDownloadInfo();
            this.hd = downloadTask.getChunkStrategy();
            this.um = downloadTask.getChunkAdjustCalculator();
            this.h = downloadTask.getForbiddenHandler();
            this.t = downloadTask.getDiskSpaceHandler();
            this.py = n(downloadTask);
            this.ae = com.byazt.f.n.n(this.cy.getId());
        } else {
            this.ae = com.byazt.f.n.s();
        }
        fs();
        this.k = com.byazt.xv.s.hu();
        this.cd = com.byazt.xv.s.f();
        this.a = com.byazt.xv.s.df();
        this.ou = new com.byazt.xv.w(downloadTask, handler);
        this.oa = new AtomicBoolean(true);
    }

    private void fs() {
        DownloadInfo downloadInfo = this.cy;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.cy.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.l;
        if (atomicInteger == null) {
            this.l = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    public void n() {
        this.sz = com.byazt.sk.fs.RUN_STATUS_PAUSE;
        if (this.fi != null) {
            this.fi.qg();
        }
        if (this.x != null) {
            this.x.qg();
        }
        if (this.fi == null && this.x == null) {
            um();
            this.sz = com.byazt.sk.fs.RUN_STATUS_PAUSE;
            cy();
        }
        try {
            for (qg qgVar : (ArrayList) this.w.clone()) {
                if (qgVar != null) {
                    qgVar.n();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void qg() {
        this.sz = com.byazt.sk.fs.RUN_STATUS_CANCELED;
        if (this.fi != null) {
            this.fi.n();
        }
        if (this.x != null) {
            this.x.s();
        }
        if (this.fi == null && this.x == null) {
            um();
            this.sz = com.byazt.sk.fs.RUN_STATUS_CANCELED;
            cy();
        }
        ae();
    }

    public DownloadTask s() {
        return this.s;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005e  */
    private int n(long j, List<com.byazt.wm.qg> list) {
        int iN;
        int iN2;
        if (bb()) {
            if (!this.rv) {
                com.byazt.xv.fs fsVar = this.hd;
                if (fsVar != null) {
                    iN2 = fsVar.n(j);
                } else {
                    iN2 = this.cd.n(j);
                }
                d dVarQg = com.byazt.m.cp.n().qg();
                com.byazt.fe.n.qg(n, String.format("NetworkQuality is : %s", dVarQg.name()));
                this.cy.setNetworkQuality(dVarQg.name());
                com.byazt.xv.x xVar = this.um;
                if (xVar != null) {
                    iN = xVar.n(iN2, dVarQg);
                } else {
                    iN = this.a.n(iN2, dVarQg);
                }
            } else if (list != null) {
                iN = list.size();
            } else {
                iN = this.cy.getChunkCount();
            }
            if (iN <= 0) {
                iN = 1;
            }
        } else {
            iN = 1;
        }
        if (com.byazt.fe.n.n()) {
            com.byazt.fe.n.qg(n, String.format("chunk count : %s for %s contentLen:%s", String.valueOf(iN), this.cy.getName(), String.valueOf(j)));
        }
        return iN;
    }

    private boolean rv() {
        int status = this.cy.getStatus();
        if (status == 1 || this.cy.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        qg(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00e7 A[Catch: SQLiteException -> 0x00ee, TRY_LEAVE, TryCatch #12 {SQLiteException -> 0x00ee, blocks: (B:71:0x00df, B:73:0x00e7), top: B:86:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:79:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00dd: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:73:0x00e7, block:B:70:0x00dd */
    private void tj() throws com.byazt.qx.n {
        boolean z;
        boolean z2;
        DownloadTask downloadTask;
        boolean z3 = false;
        try {
            try {
                int id = this.cy.getId();
                if (this.k != null) {
                    if (com.byazt.ta.n.n(2048)) {
                        this.k.l();
                    }
                    DownloadInfo downloadInfoQg = this.k.qg(id);
                    z = true;
                    if (downloadInfoQg == null || downloadInfoQg.isNewTask()) {
                        this.cy.reset();
                    } else {
                        String savePath = this.cy.getSavePath();
                        String md5 = this.cy.getMd5();
                        this.cy.copyFromCacheData(downloadInfoQg, true);
                        boolean z4 = com.byazt.ta.n.n(4096) && downloadInfoQg != this.cy;
                        try {
                            if (savePath.equals(downloadInfoQg.getSavePath()) && com.byazt.ta.w.n(downloadInfoQg, false, md5)) {
                                try {
                                    throw new com.byazt.qx.n(downloadInfoQg.getName());
                                } catch (com.byazt.qx.n e) {
                                    e = e;
                                } catch (Throwable th) {
                                    th = th;
                                    z3 = z4;
                                    downloadTask = this.s;
                                    if (downloadTask != null && this.cy != null) {
                                        com.byazt.g.n.n(downloadTask.getMonitorDepend(), this.cy, new BaseException(1003, com.byazt.ta.w.qg(th, "checkTaskCache")), this.cy.getStatus());
                                    }
                                    if (z3) {
                                        if (z) {
                                            try {
                                                if (!this.ae.n("fix_file_exist_update_download_info")) {
                                                    return;
                                                }
                                            } catch (SQLiteException unused) {
                                                return;
                                            }
                                        }
                                        this.k.n(this.cy);
                                    }
                                }
                            } else if (com.byazt.xv.s.n(downloadInfoQg) != id) {
                                try {
                                    this.k.w(id);
                                } catch (SQLiteException unused2) {
                                }
                            } else {
                                z = z4;
                            }
                        } catch (com.byazt.qx.n e2) {
                            e = e2;
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
                    fs();
                    if (z) {
                        try {
                            this.k.n(this.cy);
                        } catch (SQLiteException unused3) {
                        }
                    }
                } catch (com.byazt.qx.n e3) {
                    throw e3;
                } catch (Throwable th3) {
                    th = th3;
                    boolean z5 = z;
                    z = false;
                    z3 = z5;
                    downloadTask = this.s;
                    if (downloadTask != null) {
                        com.byazt.g.n.n(downloadTask.getMonitorDepend(), this.cy, new BaseException(1003, com.byazt.ta.w.qg(th, "checkTaskCache")), this.cy.getStatus());
                    }
                    if (z3) {
                        if (z) {
                            if (!this.ae.n("fix_file_exist_update_download_info")) {
                                return;
                            }
                        }
                        this.k.n(this.cy);
                    }
                }
            } catch (Throwable th4) {
                if (0 != 0) {
                    if (z2) {
                        try {
                            if (this.ae.n("fix_file_exist_update_download_info")) {
                                this.k.n(this.cy);
                            }
                        } catch (SQLiteException unused4) {
                        }
                    } else {
                        this.k.n(this.cy);
                    }
                }
                throw th4;
            }
        } catch (com.byazt.qx.n e4) {
            throw e4;
        } catch (Throwable th5) {
            th = th5;
            z = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.byazt.xv.s.n(this.s, 3);
        try {
            com.byazt.m.qg.n().qg();
            cp();
            com.byazt.m.qg.n().s();
            com.byazt.xv.s.qg(this.s, 3);
        } catch (Throwable th) {
            com.byazt.m.qg.n().s();
            throw th;
        }
    }

    private void cp() {
        Process.setThreadPriority(10);
        try {
            DownloadInfo downloadInfo = this.cy;
            if (downloadInfo != null && this.an > 0) {
                downloadInfo.increaseDownloadPrepareTime(System.currentTimeMillis() - this.an);
            }
        } catch (Throwable unused) {
        }
        try {
            IDownloadInterceptor interceptor = this.s.getInterceptor();
            if (interceptor != null && interceptor.intercepte()) {
                this.ou.l();
                return;
            }
        } catch (Throwable unused2) {
        }
        if (!rv()) {
            m monitorDepend = this.s.getMonitorDepend();
            DownloadInfo downloadInfo2 = this.cy;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo3 = this.cy;
            com.byazt.g.n.n(monitorDepend, downloadInfo2, baseException, downloadInfo3 != null ? downloadInfo3.getStatus() : 0);
            return;
        }
        while (true) {
            d();
            if (!this.bb) {
                return;
            }
            if (this.ur > 0) {
                this.ur--;
            } else if (this.cy.getCurBytes() != this.cy.getTotalBytes()) {
                com.byazt.fe.n.qg(n, this.cy.getErrorBytesLog());
                this.ou.n(new com.byazt.qx.w(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.cy.getByteInvalidRetryStatus()));
                return;
            } else if (this.cy.getCurBytes() <= 0) {
                com.byazt.fe.n.qg(n, this.cy.getErrorBytesLog());
                this.ou.n(new com.byazt.qx.w(1026, "curBytes is 0, bytes invalid retry status is : " + this.cy.getByteInvalidRetryStatus()));
                return;
            } else if (this.cy.getTotalBytes() <= 0) {
                com.byazt.fe.n.qg(n, this.cy.getErrorBytesLog());
                this.ou.n(new com.byazt.qx.w(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.cy.getByteInvalidRetryStatus()));
                return;
            }
        }
    }

    private void d() {
        boolean z;
        try {
            this.sz = com.byazt.sk.fs.RUN_STATUS_NONE;
            this.cy.updateStartDownloadTime();
            this.cy.resetRealStartDownloadTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.cy.setFirstSpeedTime(-1L);
            try {
                tj();
                z = false;
            } catch (com.byazt.qx.n e) {
                com.byazt.fe.n.qg(n, "file exist " + e.n());
                this.lh = e.n();
                z = true;
            }
            if (!this.bb) {
                this.ou.qg();
            }
            this.bb = false;
            if (ou()) {
                cy();
                return;
            }
            if (!TextUtils.isEmpty(this.lh) && z) {
                if (this.cy.isExpiredRedownload()) {
                    this.v = com.byazt.ta.w.q(this.cy);
                }
                if (!this.v) {
                    oa();
                    cy();
                    return;
                }
            }
            while (true) {
                if (ou()) {
                    cy();
                    return;
                }
                try {
                    try {
                        try {
                            try {
                                v();
                                ur();
                                lh();
                                List<com.byazt.wm.qg> listS = this.k.s(this.cy.getId());
                                j();
                                if (sz()) {
                                    com.byazt.fe.n.s(n, "downloadSegments return");
                                    um();
                                    cy();
                                    return;
                                }
                                String connectionUrl = this.cy.getConnectionUrl();
                                if (ou()) {
                                    um();
                                    cy();
                                    return;
                                }
                                long jL = this.rv ? com.byazt.ta.w.l(this.cy) : 0L;
                                com.byazt.wm.qg qgVarN = n(this.cy, jL);
                                List<com.byazt.wm.s> listN = n(qgVarN);
                                com.byazt.ta.w.n(listN, this.cy);
                                com.byazt.ta.w.qg(listN, this.cy);
                                this.cy.setPreconnectLevel(0);
                                long jCurrentTimeMillis2 = System.currentTimeMillis();
                                try {
                                    n(connectionUrl, listN, jL);
                                    this.cy.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                    if (ou()) {
                                        um();
                                        cy();
                                        return;
                                    }
                                    long totalBytes = this.cy.getTotalBytes();
                                    n(totalBytes);
                                    int iN = n(totalBytes, listS);
                                    if (ou()) {
                                        um();
                                        cy();
                                        return;
                                    }
                                    if (iN <= 0) {
                                        throw new BaseException(1032, "chunkCount is 0");
                                    }
                                    boolean z2 = iN == 1;
                                    this.fs = z2;
                                    if (!z2) {
                                        if (!this.cy.isNeedReuseFirstConnection()) {
                                            cd();
                                        }
                                        if (!ou()) {
                                            k();
                                            this.cy.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                                            if (!this.rv) {
                                                n(totalBytes, iN);
                                                break;
                                            } else {
                                                n(iN, listS);
                                                break;
                                            }
                                        }
                                        um();
                                        cy();
                                        return;
                                    }
                                    if (this.m == null) {
                                        try {
                                            jCurrentTimeMillis2 = System.currentTimeMillis();
                                            n(connectionUrl, listN);
                                            this.cy.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                        } catch (Throwable th) {
                                            this.cy.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                            throw th;
                                        }
                                    }
                                    if (!ou()) {
                                        this.cy.setFirstSpeedTime(System.currentTimeMillis() - jCurrentTimeMillis);
                                        k();
                                        n(qgVarN, connectionUrl, this.m);
                                        break;
                                    } else {
                                        um();
                                        cy();
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    this.cy.increaseAllConnectTime(System.currentTimeMillis() - jCurrentTimeMillis2);
                                    throw th2;
                                }
                            } catch (com.byazt.qx.n unused) {
                                oa();
                            }
                        } catch (BaseException e2) {
                            com.byazt.fe.n.q(n, "downloadInner: baseException = " + e2);
                            if (this.sz == com.byazt.sk.fs.RUN_STATUS_PAUSE) {
                                break;
                            }
                            if (e2.getErrorCode() != 1025 && e2.getErrorCode() != 1009) {
                                if (!n(e2)) {
                                    qg(e2);
                                    break;
                                }
                                if (com.byazt.ta.w.n(e2)) {
                                    an();
                                }
                                if (n(e2, 0L) == com.byazt.qx.fs.RETURN) {
                                    um();
                                    cy();
                                    return;
                                }
                                um();
                            }
                            this.sz = com.byazt.sk.fs.RUN_STATUS_END_RIGHT_NOW;
                            um();
                            cy();
                            return;
                        }
                    } catch (com.byazt.qx.rv e3) {
                        try {
                            com.byazt.fe.n.q(n, "downloadInner: retry throwable for " + e3.n());
                            if (this.sz == com.byazt.sk.fs.RUN_STATUS_PAUSE) {
                                break;
                            }
                            AtomicInteger atomicInteger = this.l;
                            if (atomicInteger != null && atomicInteger.get() > 0) {
                                this.cy.updateCurRetryTime(this.l.decrementAndGet());
                                this.cy.setStatus(5);
                            } else if (this.l == null) {
                                qg(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e3.n()));
                                break;
                            } else if (!this.cy.trySwitchToNextBackupUrl()) {
                                qg(new BaseException(PointerIconCompat.TYPE_ZOOM_IN, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.cy.getRetryCount()), e3.n())));
                                break;
                            } else {
                                this.cy.setStatus(5);
                                this.l.set(this.cy.getRetryCount());
                                this.cy.updateCurRetryTime(this.l.get());
                            }
                            um();
                        } catch (Throwable th3) {
                            um();
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    com.byazt.fe.n.q(n, "downloadInner: throwable =  " + th4);
                    if (this.sz != com.byazt.sk.fs.RUN_STATUS_PAUSE) {
                        qg(new BaseException(1045, th4));
                    }
                }
                um();
            }
            um();
            cy();
        } catch (Throwable th5) {
            cy();
            throw th5;
        }
    }

    private void oa() {
        com.byazt.fe.n.qg(n, "finishWithFileExist");
        if (com.byazt.f.n.s().qg("fix_end_for_file_exist_error", true)) {
            if (this.lh.equals(this.cy.getName())) {
                this.sz = com.byazt.sk.fs.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.sz = com.byazt.sk.fs.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.lh.equals(this.cy.getTargetFilePath())) {
            this.sz = com.byazt.sk.fs.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.sz = com.byazt.sk.fs.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private boolean sz() throws InterruptedException, BaseException {
        if (this.cy.isExpiredRedownload() || this.cy.getChunkCount() != 1 || this.cy.getThrottleNetSpeed() > 0) {
            return false;
        }
        JSONObject jSONObjectQ = com.byazt.f.n.n(this.cy.getId()).q("segment_config");
        List<com.byazt.kl.rv> listSz = this.k.sz(this.cy.getId());
        if (this.cy.getCurBytes() > 0) {
            if (listSz == null || listSz.isEmpty()) {
                return false;
            }
            if (jSONObjectQ == null) {
                jSONObjectQ = new JSONObject();
            }
        }
        if (jSONObjectQ == null) {
            return false;
        }
        this.fi = new cp(this.cy, sz.n(jSONObjectQ), this);
        if (ou()) {
            com.byazt.fe.n.s(n, "downloadSegments: is stopped by user");
            if (this.sz == com.byazt.sk.fs.RUN_STATUS_CANCELED) {
                this.fi.n();
            } else {
                this.fi.qg();
            }
            return true;
        }
        return this.fi.n(listSz);
    }

    private void k() {
        if (com.byazt.f.n.n(this.cy.getId()).n("reset_retain_retry_times", 0) != 1 || this.f >= 3) {
            return;
        }
        this.l.set(this.cy.isBackUpUrlUsed() ? this.cy.getBackUpUrlRetryCount() : this.cy.getRetryCount());
        this.f++;
    }

    private void n(String str, List<com.byazt.wm.s> list, long j) throws BaseException, com.byazt.qx.rv {
        qg(str, list, j);
        com.byazt.m.x xVar = this.hu;
        if (xVar != null) {
            try {
                n(str, xVar, j);
            } catch (Throwable unused) {
                this.ln = true;
            }
        }
        if (this.hu == null || this.ln) {
            n(str, list);
            n(str, this.m, j);
        }
    }

    private void cy() {
        boolean zWm;
        boolean z;
        com.byazt.fe.n.qg(n, "endDownloadRunnable::runStatus=" + this.sz);
        boolean z2 = (this.sz == com.byazt.sk.fs.RUN_STATUS_PAUSE || this.sz == com.byazt.sk.fs.RUN_STATUS_CANCELED) ? false : true;
        try {
            zWm = wm();
            z = false;
        } catch (Exception e) {
            if (e instanceof BaseException) {
                this.ou.n((BaseException) e);
            } else {
                this.ou.n(new BaseException(1046, e));
            }
            zWm = true;
            z = true;
        }
        if (zWm || z) {
            this.oa.set(false);
            if (z2) {
                try {
                    com.byazt.i.n nVarLn = com.byazt.xv.s.ln();
                    if (nVarLn != null) {
                        nVarLn.n(this);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    m monitorDepend = this.s.getMonitorDepend();
                    DownloadInfo downloadInfo = this.cy;
                    BaseException baseException = new BaseException(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, com.byazt.ta.w.qg(th, "removeDownloadRunnable"));
                    DownloadInfo downloadInfo2 = this.cy;
                    com.byazt.g.n.n(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
                    return;
                }
            }
            return;
        }
        this.bb = true;
        com.byazt.fe.n.qg(n, "jump to restart");
    }

    private void qg(String str, List<com.byazt.wm.s> list, long j) throws BaseException, com.byazt.qx.rv {
        com.byazt.r.s sVarN;
        boolean z = true;
        if (this.cy.getChunkCount() == 1 && (sVarN = com.byazt.r.n.n().n(str, list)) != null) {
            this.hu = sVarN;
            this.cy.setPreconnectLevel(1);
        }
        if (this.hu == null && !this.ln && this.cy.isHeadConnectionAvailable()) {
            try {
                int iQg = this.ae.qg("net_lib_strategy");
                if (this.ae.n("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.hu = com.byazt.xv.s.n(str, list, iQg, z, this.cy);
            } catch (Throwable th) {
                this.cy.setHeadConnectionException(com.byazt.ta.w.tj(th));
            }
        }
    }

    private void n(String str, List<com.byazt.wm.s> list) throws BaseException, com.byazt.qx.rv {
        rv rvVarN;
        if (this.m != null) {
            return;
        }
        com.byazt.r.q qVarQg = this.cy.getChunkCount() == 1 ? com.byazt.r.n.n().qg(str, list) : null;
        try {
            if (qVarQg != null) {
                n(this.m);
                this.cy.setPreconnectLevel(2);
                this.m = qVarQg;
            } else {
                try {
                    rvVarN = com.byazt.xv.s.n(this.cy.isNeedDefaultHttpServiceBackUp(), this.cy.getMaxBytes(), str, null, list, this.ae.qg("net_lib_strategy"), this.ae.n("monitor_download_connect", 0) > 0, this.cy);
                    this.m = rvVarN;
                } catch (BaseException e) {
                    throw e;
                } catch (Throwable th) {
                    if (this.cy.isExpiredRedownload() && com.byazt.ta.w.x(th) && com.byazt.ta.w.s(list)) {
                        com.byazt.fe.n.qg(n, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.cy.getCacheControl());
                        long jRv = com.byazt.ta.w.rv(this.cy.getCacheControl());
                        if (jRv <= 0) {
                            jRv = com.byazt.f.n.n(this.cy.getId()).n("default_304_max_age", TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
                        }
                        this.cy.setCacheExpiredTime(System.currentTimeMillis() + (jRv * 1000));
                        throw new com.byazt.qx.n(this.lh);
                    }
                    if (com.byazt.ta.w.w(th)) {
                        n("", "http code 416");
                    } else if (com.byazt.ta.w.l(th)) {
                        n("", "http code 412");
                    } else {
                        com.byazt.ta.w.n(th, "CreateFirstConnection");
                    }
                    rvVarN = this.m;
                }
                n(rvVarN);
            }
            if (this.m == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            n(this.m);
            throw th2;
        }
    }

    private void hd() {
        com.byazt.m.x xVar = this.hu;
        if (xVar != null) {
            xVar.s();
            this.hu = null;
        }
    }

    private void cd() {
        rv rvVar = this.m;
        if (rvVar != null) {
            rvVar.q();
            this.m = null;
        }
    }

    private void um() {
        hd();
        cd();
    }

    public static com.byazt.wm.qg n(DownloadInfo downloadInfo, long j) {
        return new com.byazt.wm.qg.n(downloadInfo.getId()).n(-1).n(0L).l(j).qg(j).s(0L).q(downloadInfo.getTotalBytes() - j).n();
    }

    private List<com.byazt.wm.s> n(com.byazt.wm.qg qgVar) {
        List<com.byazt.wm.s> listN = com.byazt.ta.w.n(this.cy.getExtraHeaders(), this.cy.geteTag(), qgVar);
        if (this.cy.isExpiredRedownload() && this.v && this.cy.getLastModified() != null) {
            listN.add(new com.byazt.wm.s("if-modified-since", this.cy.getLastModified()));
            listN.add(new com.byazt.wm.s("download-tc21-1-15", "download-tc21-1-15"));
            com.byazt.fe.n.qg(n, "dcache::add head IF_MODIFIED_SINCE=" + this.cy.getLastModified());
        }
        return listN;
    }

    private void a() throws BaseException {
        if (this.x != null) {
            if (this.sz == com.byazt.sk.fs.RUN_STATUS_CANCELED) {
                this.cy.setStatus(-4);
                this.x.s();
            } else if (this.sz == com.byazt.sk.fs.RUN_STATUS_PAUSE) {
                this.cy.setStatus(-2);
                this.x.qg();
            } else {
                this.x.q();
            }
        }
    }

    private boolean py() {
        return this.sz == com.byazt.sk.fs.RUN_STATUS_CANCELED || this.sz == com.byazt.sk.fs.RUN_STATUS_PAUSE;
    }

    private boolean ou() {
        if (!py() && this.cy.getStatus() != -2) {
            return false;
        }
        if (py()) {
            return true;
        }
        if (this.cy.getStatus() == -2) {
            this.sz = com.byazt.sk.fs.RUN_STATUS_PAUSE;
            return true;
        }
        if (this.cy.getStatus() != -4) {
            return true;
        }
        this.sz = com.byazt.sk.fs.RUN_STATUS_CANCELED;
        return true;
    }

    private boolean wm() {
        if (this.sz == com.byazt.sk.fs.RUN_STATUS_ERROR) {
            this.ou.n(this.wm);
        } else if (this.sz == com.byazt.sk.fs.RUN_STATUS_CANCELED) {
            this.ou.s();
        } else if (this.sz == com.byazt.sk.fs.RUN_STATUS_PAUSE) {
            this.ou.q();
        } else if (this.sz == com.byazt.sk.fs.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.ou.x();
            } catch (BaseException e) {
                this.ou.n(e);
            }
        } else if (this.sz == com.byazt.sk.fs.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.ou.n(this.lh);
            } catch (BaseException e2) {
                this.ou.n(e2);
            }
        } else {
            if (this.sz == com.byazt.sk.fs.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.ou.n(this.wm, false);
                return false;
            }
            if (this.sz == com.byazt.sk.fs.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            if (this.sz == com.byazt.sk.fs.RUN_STATUS_RETRY_DELAY && !m()) {
                com.byazt.fe.n.qg(n, "doTaskStatusHandle retryDelay");
                h();
                return this.sz == com.byazt.sk.fs.RUN_STATUS_RETRY_DELAY;
            }
            try {
                if (!hu()) {
                    return false;
                }
                this.ou.w();
                com.byazt.i.cd.n().q();
            } catch (Throwable th) {
                qg(new BaseException(PointerIconCompat.TYPE_TEXT, com.byazt.ta.w.qg(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private boolean m() {
        if (this.cy.getChunkCount() <= 1) {
            return this.cy.getCurBytes() > 0 && this.cy.getCurBytes() == this.cy.getTotalBytes();
        }
        List<com.byazt.wm.qg> listS = this.k.s(this.cy.getId());
        if (listS == null || listS.size() <= 1) {
            return false;
        }
        for (com.byazt.wm.qg qgVar : listS) {
            if (qgVar == null || !qgVar.rv()) {
                return false;
            }
        }
        return true;
    }

    private boolean hu() {
        if (this.cy.isChunked()) {
            DownloadInfo downloadInfo = this.cy;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        com.byazt.fe.n.s(n, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.cy.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.cy.getTotalBytes());
        if (this.cy.getCurBytes() > 0) {
            if (this.cy.isIgnoreDataVerify()) {
                return true;
            }
            if (this.cy.getTotalBytes() > 0 && this.cy.getCurBytes() == this.cy.getTotalBytes()) {
                return true;
            }
        }
        this.cy.setByteInvalidRetryStatus(com.byazt.sk.qg.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.cy.reset();
        this.k.n(this.cy);
        this.k.q(this.cy.getId());
        this.k.oa(this.cy.getId());
        com.byazt.ta.w.n(this.cy);
        return false;
    }

    private void h() {
        this.sz = com.byazt.sk.fs.RUN_STATUS_NONE;
    }

    private long t() {
        return this.py.n(this.cy.getCurRetryTimeInTotal(), this.cy.getTotalRetryCount());
    }

    private void ur() throws BaseException, com.byazt.qx.rv {
        com.byazt.i.n nVarLn;
        int id = this.cy.getId();
        int iN = com.byazt.xv.s.n(this.cy);
        if (this.cy.isDownloaded() && !this.cy.isExpiredRedownload() && !this.v) {
            throw new BaseException(PointerIconCompat.TYPE_VERTICAL_TEXT, "file has downloaded");
        }
        DownloadInfo downloadInfoQg = this.k.qg(iN);
        if (downloadInfoQg == null || (nVarLn = com.byazt.xv.s.ln()) == null || downloadInfoQg.getId() == id || !downloadInfoQg.equalsTask(this.cy)) {
            return;
        }
        if (nVarLn.n(downloadInfoQg.getId())) {
            this.k.w(id);
            throw new BaseException(InputDeviceCompat.SOURCE_GAMEPAD, "another same task is downloading");
        }
        List<com.byazt.wm.qg> listS = this.k.s(iN);
        com.byazt.ta.w.n(this.cy);
        this.k.w(iN);
        if (downloadInfoQg == null || !downloadInfoQg.isBreakpointAvailable()) {
            return;
        }
        this.cy.copyFromCacheData(downloadInfoQg, false);
        this.k.n(this.cy);
        if (listS != null) {
            for (com.byazt.wm.qg qgVar : listS) {
                qgVar.qg(id);
                this.k.n(qgVar);
            }
        }
        throw new com.byazt.qx.rv("retry task because id generator changed");
    }

    private void n(int i, List<com.byazt.wm.qg> list) throws BaseException {
        if (list.size() != i) {
            throw new BaseException(1033, new IllegalArgumentException());
        }
        n(list, this.cy.getTotalBytes());
    }

    private void n(long j, int i) throws BaseException {
        long j2 = j / ((long) i);
        int id = this.cy.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            com.byazt.wm.qg qgVarN = new com.byazt.wm.qg.n(id).n(i2).n(j3).l(j3).qg(j3).s(i2 == i + (-1) ? 0L : (j3 + j2) - 1).n();
            arrayList.add(qgVarN);
            this.k.n(qgVarN);
            j3 += j2;
            i2++;
        }
        this.cy.setChunkCount(i);
        this.k.n(id, i);
        n(arrayList, j);
    }

    private void n(List<com.byazt.wm.qg> list, long j) throws BaseException {
        long jCy;
        for (com.byazt.wm.qg qgVar : list) {
            if (qgVar != null) {
                if (qgVar.cy() == 0) {
                    jCy = j - qgVar.sz();
                } else {
                    jCy = (qgVar.cy() - qgVar.sz()) + 1;
                }
                if (jCy > 0) {
                    qgVar.n(jCy);
                    if (this.cy.isNeedReuseFirstConnection() && this.m != null && (!this.cy.isHeadConnectionAvailable() || this.ln)) {
                        if (qgVar.um() == 0) {
                            this.w.add(new qg(qgVar, this.s, this.m, this));
                        } else if (qgVar.um() > 0) {
                            this.w.add(new qg(qgVar, this.s, this));
                        }
                    } else {
                        this.w.add(new qg(qgVar, this.s, this));
                    }
                }
            }
        }
        if (com.byazt.ta.n.n(64)) {
            ArrayList arrayList = new ArrayList(this.w.size());
            for (qg qgVar2 : this.w) {
                if (this.sz == com.byazt.sk.fs.RUN_STATUS_CANCELED) {
                    qgVar2.qg();
                } else if (this.sz == com.byazt.sk.fs.RUN_STATUS_PAUSE) {
                    qgVar2.n();
                } else {
                    arrayList.add(qgVar2);
                }
            }
            try {
                List<Future> listQ = com.byazt.i.l.q(arrayList);
                for (Runnable runnableL = (Runnable) arrayList.remove(0); runnableL != null; runnableL = com.byazt.i.l.l(listQ)) {
                    if (ou()) {
                        return;
                    }
                    try {
                        runnableL.run();
                    } catch (Throwable unused) {
                    }
                }
                if (listQ == null || listQ.isEmpty()) {
                    return;
                }
                for (Future future : listQ) {
                    if (future != null && !future.isDone()) {
                        future.get();
                    }
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.w.size());
        for (qg qgVar3 : this.w) {
            if (this.sz == com.byazt.sk.fs.RUN_STATUS_CANCELED) {
                qgVar3.qg();
            } else if (this.sz == com.byazt.sk.fs.RUN_STATUS_PAUSE) {
                qgVar3.n();
            } else {
                arrayList2.add(Executors.callable(qgVar3));
            }
        }
        if (ou()) {
            return;
        }
        try {
            com.byazt.i.l.s(arrayList2);
        } catch (InterruptedException e) {
            throw new BaseException(PointerIconCompat.TYPE_GRAB, e);
        }
    }

    private void n(com.byazt.wm.qg qgVar, String str, rv rvVar) throws BaseException {
        qgVar.n(this.cy.getTotalBytes() - qgVar.sz());
        this.cy.setChunkCount(1);
        this.k.n(this.cy.getId(), 1);
        this.x = new com.byazt.xv.l(this.cy, str, rvVar, qgVar, this);
        a();
    }

    private boolean bb() {
        DownloadInfo downloadInfo = this.cy;
        return (downloadInfo == null || downloadInfo.isExpiredRedownload() || (this.rv && this.cy.getChunkCount() <= 1) || this.cy.isChunkDowngradeRetryUsed() || !this.tj || this.d) ? false : true;
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
    /* JADX WARN: Type inference failed for: r5v8, types: [com.byazt.wm.l] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17, types: [long] */
    /* JADX WARN: Type inference failed for: r7v22 */
    @Override // com.byazt.l.w
    public void n(long j) throws Throwable {
        ?? Q;
        com.byazt.wm.l lVar;
        long j2;
        boolean z;
        com.byazt.wm.l lVar2;
        com.byazt.wm.l lVar3;
        ?? r7;
        String tempPath = this.cy.getTempPath();
        String tempName = this.cy.getTempName();
        if (com.byazt.ta.w.qg(j)) {
            return;
        }
        com.byazt.wm.l lVarN = com.byazt.ta.w.n(this.cy, tempPath, tempName, -1);
        try {
            long length = new File(tempPath, tempName).length();
            long totalBytes = j - length;
            Q = com.byazt.ta.w.q(tempPath);
            com.byazt.f.n nVarN = com.byazt.f.n.n(this.cy.getId());
            try {
                try {
                    if (nVarN.n("space_fill_part_download", 0) == 1) {
                        this.j = 0L;
                        if (totalBytes <= 0) {
                            totalBytes = this.cy.getTotalBytes() - this.cy.getCurBytes();
                        }
                        if (Q < totalBytes) {
                            String str = n;
                            lVar3 = lVarN;
                            com.byazt.fe.n.q(str, "checkSpaceOverflow: contentLength = " + com.byazt.ta.w.n(j) + "MB, downloaded = " + com.byazt.ta.w.n(length) + "MB, required = " + com.byazt.ta.w.n(totalBytes) + "MB, available = " + com.byazt.ta.w.n((long) Q) + "MB");
                            if (Q > 0) {
                                int iN = nVarN.n("space_fill_min_keep_mb", 100);
                                if (iN > 0) {
                                    long j3 = Q - (((long) iN) * 1048576);
                                    com.byazt.fe.n.q(str, "checkSpaceOverflow: minKeep = " + iN + "MB, canDownload = " + com.byazt.ta.w.n(j3) + "MB");
                                    if (j3 <= 0) {
                                        throw new com.byazt.qx.q(Q, totalBytes);
                                    }
                                    this.j = this.cy.getCurBytes() + j3;
                                    r7 = j3;
                                } else {
                                    r7 = Q;
                                }
                                lVar = lVar3;
                                if (length < j) {
                                    j2 = r7 + length;
                                    if (j2 > j) {
                                        lVar2 = lVar3;
                                        lVar = lVar3;
                                    }
                                }
                                lVar2 = lVar3;
                                z = true;
                                Q = lVar2;
                            } else {
                                if (nVarN.n("download_when_space_negative", 0) != 1) {
                                    throw new BaseException(1052, "availableSpace " + (Q == 0 ? "=" : "<") + " 0");
                                }
                                j2 = j;
                                z = false;
                                Q = lVar3;
                            }
                            Q.qg(j);
                            com.byazt.ta.w.n((Closeable[]) new Closeable[]{Q});
                        }
                        lVar = lVarN;
                    } else {
                        lVar = lVarN;
                        if (Q <= 0) {
                            throw new BaseException(1052, "availableSpace " + (Q == 0 ? "=" : "<") + " 0");
                        }
                        if (Q < totalBytes) {
                            throw new com.byazt.qx.q(Q, totalBytes);
                        }
                    }
                    Q.qg(j);
                } catch (Throwable th) {
                    com.byazt.fe.n.l(n, "checkSpaceOverflow: setLength1 e = " + th + ", mustSetLength = " + z);
                    if (j2 < j && j2 > 0 && j2 > length) {
                        try {
                            Q.qg(j2);
                        } catch (Throwable th2) {
                            com.byazt.fe.n.l(n, "checkSpaceOverflow: setLength2 ex = " + th2 + ", mustSetLength = " + z);
                            if (z) {
                                throw new BaseException(AVMDLDataLoader.KeyIsPreloadWaitListType, th2);
                            }
                        }
                    } else if (z) {
                        throw new BaseException(AVMDLDataLoader.KeyIsPreloadWaitListType, th);
                    }
                }
                j2 = j;
                lVar2 = lVar;
                lVar2 = lVar3;
                z = true;
                Q = lVar2;
                com.byazt.ta.w.n((Closeable[]) new Closeable[]{Q});
            } catch (Throwable th3) {
                th = th3;
                com.byazt.ta.w.n((Closeable[]) new Closeable[]{Q});
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            Q = lVarN;
        }
    }

    private void ln() throws BaseException {
        long jQ;
        int iN;
        try {
            jQ = com.byazt.ta.w.q(this.cy.getTempPath());
        } catch (BaseException unused) {
            jQ = 0;
        }
        String str = n;
        com.byazt.fe.n.s(str, "checkSpaceOverflowInProgress: available = " + com.byazt.ta.w.n(jQ) + "MB");
        if (jQ > 0) {
            long totalBytes = this.cy.getTotalBytes() - this.cy.getCurBytes();
            if (jQ < totalBytes && (iN = com.byazt.f.n.n(this.cy.getId()).n("space_fill_min_keep_mb", 100)) > 0) {
                long j = jQ - (((long) iN) * 1048576);
                com.byazt.fe.n.s(str, "checkSpaceOverflowInProgress: minKeep  = " + iN + "MB, canDownload = " + com.byazt.ta.w.n(j) + "MB");
                if (j <= 0) {
                    this.j = 0L;
                    throw new com.byazt.qx.q(jQ, totalBytes);
                }
                this.j = this.cy.getCurBytes() + j + 1048576;
                return;
            }
        }
        this.j = 0L;
    }

    private void lh() throws com.byazt.qx.w {
        if (this.cy.isOnlyWifi() && !com.byazt.ta.w.n(com.byazt.xv.s.u(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.byazt.qx.w(PointerIconCompat.TYPE_ZOOM_OUT, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.cy.isDownloadWithWifiValid()) {
            throw new com.byazt.qx.s();
        }
        if (!this.cy.isPauseReserveWithWifiValid()) {
            throw new com.byazt.qx.l();
        }
    }

    private void v() throws BaseException {
        if (TextUtils.isEmpty(this.cy.getSavePath())) {
            throw new BaseException(1028, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.cy.getName())) {
            throw new BaseException(1029, "download name can not be empty");
        }
        File file = new File(this.cy.getSavePath());
        if (!file.exists()) {
            boolean zMkdirs = file.mkdirs();
            if (zMkdirs || file.exists()) {
                return;
            }
            int i = 0;
            if (com.byazt.f.n.n(this.cy.getId()).n("opt_mkdir_failed", 0) == 1) {
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
                if (com.byazt.ta.w.q(this.cy.getSavePath()) < c.o) {
                    throw new BaseException(1006, "download savePath directory can not created:" + this.cy.getSavePath());
                }
                throw new BaseException(1030, "download savePath directory can not created:" + this.cy.getSavePath());
            }
            throw new BaseException(1030, "download savePath directory can not created:" + this.cy.getSavePath());
        }
        if (file.isDirectory()) {
            return;
        }
        if (com.byazt.ta.q.qg(this.cy)) {
            file.delete();
            if (!file.mkdirs() && !file.exists()) {
                throw new BaseException(1031, "download savePath is not directory:path=" + this.cy.getSavePath());
            }
            return;
        }
        throw new BaseException(1031, "download savePath is not a directory:" + this.cy.getSavePath());
    }

    private boolean n(int i, String str, String str2) {
        if (i == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.cp || this.tj)) {
            return (i == 201 || i == 416) && this.cy.getCurBytes() > 0;
        }
        return true;
    }

    private void n(String str, String str2) throws com.byazt.qx.rv {
        this.k.q(this.cy.getId());
        this.k.oa(this.cy.getId());
        com.byazt.ta.w.n(this.cy);
        this.rv = false;
        this.cy.resetDataForEtagEndure(str);
        this.k.n(this.cy);
        throw new com.byazt.qx.rv(str2);
    }

    @Override // com.byazt.l.w
    public void n(String str, com.byazt.m.x xVar, long j) throws BaseException, com.byazt.qx.rv {
        com.byazt.m.x xVar2;
        String str2;
        long jQg;
        boolean z;
        if (xVar == null) {
            return;
        }
        try {
            com.byazt.wm.q qVar = new com.byazt.wm.q(str, xVar);
            int i = qVar.s;
            String strQ = qVar.q();
            if (TextUtils.isEmpty(this.cy.getMimeType()) && !TextUtils.isEmpty(strQ)) {
                this.cy.setMimeType(strQ);
            }
            boolean zQg = qVar.qg();
            this.tj = zQg;
            this.cy.setSupportPartial(zQg);
            this.cp = qVar.n();
            String str3 = this.cy.geteTag();
            String strS = qVar.s();
            String strW = qVar.w();
            String strX = qVar.x();
            String str4 = n;
            com.byazt.fe.n.qg(str4, "dcache=responseCode=" + i + " last_modified=" + strW + " CACHE_CONTROL=" + strX + " max-age=" + qVar.cp() + " isDeleteCacheIfCheckFailed=" + this.cy.isDeleteCacheIfCheckFailed());
            com.byazt.fe.n.qg(str4, "dcache=firstOffset=" + j + " cur=" + strW + " before=" + this.cy.getLastModified() + " cur=" + qVar.tj() + " before=" + this.cy.getTotalBytes());
            if (!TextUtils.isEmpty(strX)) {
                this.cy.setCacheControl(strX);
                if (qVar.cp() > 0) {
                    this.cy.setCacheExpiredTime(System.currentTimeMillis() + (qVar.cp() * 1000));
                }
            }
            if (this.cy.isExpiredRedownload() && this.v && !TextUtils.isEmpty(this.lh)) {
                if (i == 304) {
                    z = true;
                } else {
                    z = false;
                    if ((!TextUtils.isEmpty(this.cy.getLastModified()) || !this.cy.isDeleteCacheIfCheckFailed()) && TextUtils.equals(strW, this.cy.getLastModified())) {
                        z = true;
                    }
                }
                if (z) {
                    com.byazt.fe.n.qg(str4, "dcache=responseCode=" + i + " lastModified not changed, use local file  " + strW);
                    throw new com.byazt.qx.n(this.lh);
                }
                com.byazt.ta.w.n(this.cy);
            }
            if (j > 0 && this.cy.isExpiredRedownload() && !TextUtils.equals(strW, this.cy.getLastModified())) {
                com.byazt.fe.n.qg(str4, "dcache cdn file change, so retry");
                n("", "cdn file changed");
            }
            if (!TextUtils.isEmpty(strW)) {
                this.cy.setLastModified(strW);
            }
            if (n(i, str3, strS)) {
                xVar2 = xVar;
                if (xVar2 instanceof rv) {
                    str2 = (TextUtils.isEmpty(str3) || !str3.equals(strS)) ? strS : "";
                    n(str2, "eTag of server file changed");
                } else {
                    throw new com.byazt.qx.qg(1002, i, "");
                }
            } else {
                xVar2 = xVar;
                str2 = strS;
            }
            if (!this.tj && !this.cp) {
                if (i == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                throw new com.byazt.qx.qg(1004, i, "response code error : " + i);
            }
            if (this.cp && j > 0) {
                if (xVar2 instanceof rv) {
                    n("", "http head request not support");
                } else {
                    throw new BaseException(1004, "isResponseFromBegin but firstOffset > 0");
                }
            }
            long jFs = qVar.fs();
            if (!(xVar2 instanceof rv) && jFs < 0 && com.byazt.ta.q.n(this.cy)) {
                throw new BaseException(1004, "");
            }
            String strN = TextUtils.isEmpty(this.cy.getName()) ? com.byazt.ta.w.n(xVar2, this.cy.getUrl()) : "";
            boolean zRv = qVar.rv();
            this.d = zRv;
            if (!zRv && jFs == 0 && !(xVar2 instanceof rv)) {
                throw new BaseException(1004, "");
            }
            if (zRv) {
                jQg = -1;
            } else {
                String strQg = com.byazt.ta.w.qg(xVar2, "Content-Range");
                com.byazt.fe.n.s(str4, "firstConnection: contentRange = " + strQg);
                if (!TextUtils.isEmpty(strQg) && this.ae.qg("fix_get_total_bytes", true)) {
                    jQg = com.byazt.ta.w.qg(strQg);
                    com.byazt.fe.n.s(str4, "firstConnection: 1 totalLength = " + jQg);
                } else {
                    jQg = j + jFs;
                    com.byazt.fe.n.l(str4, "firstConnection: 2 totalLength = " + jQg + ", contentLength = " + jFs);
                }
            }
            if (!TextUtils.isEmpty(this.cy.getTaskKey()) && this.cy.getTotalBytes() > 0 && jQg != this.cy.getTotalBytes()) {
                if (xVar2 instanceof rv) {
                    n("", "file totalLength changed");
                } else {
                    throw new com.byazt.qx.qg(1002, i, "");
                }
            }
            if (ou()) {
                return;
            }
            if (this.cy.getExpectFileLength() > 0 && com.byazt.f.n.n(this.cy.getId()).qg("force_check_file_length") == 1 && this.cy.getExpectFileLength() != jQg) {
                throw new BaseException(1070, "expectFileLength = " + this.cy.getExpectFileLength() + " , totalLength = " + jQg);
            }
            this.ou.n(jQg, str2, strN);
        } catch (BaseException e) {
            throw e;
        } catch (com.byazt.qx.rv e2) {
            throw e2;
        } catch (Throwable th) {
            com.byazt.ta.w.n(th, "HandleFirstConnection");
        }
    }

    public boolean q() {
        return this.oa.get();
    }

    public int l() {
        DownloadInfo downloadInfo = this.cy;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    public void w() {
        this.an = System.currentTimeMillis();
        this.ou.n();
    }

    private void j() {
        long jW = com.byazt.ta.w.w(this.cy);
        long curBytes = this.cy.getCurBytes();
        if (jW != curBytes) {
            com.byazt.fe.n.q(n, "checkTaskCanResume: offset = " + jW + ", curBytes = " + curBytes);
        }
        this.cy.setCurBytes(jW);
        boolean z = jW > 0;
        this.rv = z;
        if (z || this.v) {
            return;
        }
        com.byazt.fe.n.s(n, "checkTaskCanResume: deleteAllDownloadFiles");
        this.k.q(this.cy.getId());
        this.k.oa(this.cy.getId());
        com.byazt.ta.w.n(this.cy);
    }

    @Override // com.byazt.l.w
    public boolean qg(long j) throws BaseException {
        if (this.j > 0 && this.cy.getCurBytes() > this.j) {
            ln();
        }
        return this.ou.n(j);
    }

    @Override // com.byazt.l.w
    public void n(qg qgVar) {
        if (this.fs) {
            return;
        }
        synchronized (this) {
            this.w.remove(qgVar);
        }
    }

    @Override // com.byazt.l.w
    public boolean n(BaseException baseException) {
        if (this.fi != null && com.byazt.ta.w.rv(baseException) && this.l.get() < this.cy.getRetryCount()) {
            return false;
        }
        if (com.byazt.ta.w.qg(baseException)) {
            if (this.fs && !this.q) {
                com.byazt.ta.w.n(this.cy);
                this.q = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.l;
        return ((atomicInteger != null && atomicInteger.get() > 0) || this.cy.hasNextBackupUrl() || (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.cy.canReplaceHttpForRetry()))) && !(baseException instanceof com.byazt.qx.w);
    }

    @Override // com.byazt.l.w
    public void qg(BaseException baseException) {
        com.byazt.fe.n.qg(n, "onError:" + baseException.getMessage());
        this.sz = com.byazt.sk.fs.RUN_STATUS_ERROR;
        this.wm = baseException;
        ae();
    }

    private void an() {
        com.byazt.fe.n.q(n, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.k.q(this.cy.getId());
            this.k.oa(this.cy.getId());
            com.byazt.ta.w.n(this.cy);
            this.rv = false;
            this.cy.resetDataForEtagEndure("");
            this.k.n(this.cy);
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.l.w
    public void s(BaseException baseException) {
        DownloadInfo downloadInfo = this.cy;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        n(baseException, false);
    }

    @Override // com.byazt.l.w
    public void n(BaseException baseException, boolean z) {
        com.byazt.fe.n.qg(n, "onAllChunkRetryWithReset");
        this.sz = com.byazt.sk.fs.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.wm = baseException;
        ae();
        if (z ? q(baseException) : false) {
            return;
        }
        an();
    }

    private void ae() {
        try {
            for (qg qgVar : (ArrayList) this.w.clone()) {
                if (qgVar != null) {
                    qgVar.qg();
                }
            }
        } catch (Throwable th) {
            com.byazt.fe.n.s(n, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.cy.setForbiddenBackupUrls(list, this.sz == com.byazt.sk.fs.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.byazt.i.n nVarLn = com.byazt.xv.s.ln();
        if (nVarLn != null) {
            nVarLn.d(this.cy.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.byazt.i.n nVarLn;
        if (ou() || (nVarLn = com.byazt.xv.s.ln()) == null) {
            return;
        }
        nVarLn.d(this.cy.getId());
    }

    @Override // com.byazt.l.w
    public com.byazt.qx.fs n(com.byazt.wm.qg qgVar, BaseException baseException, long j) {
        if (py()) {
            return com.byazt.qx.fs.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.byazt.ta.w.fs(baseException))) {
            return n(baseException, j);
        }
        this.wm = baseException;
        this.cy.increaseCurBytes(-j);
        this.k.n(this.cy);
        if (q(baseException)) {
            return com.byazt.qx.fs.RETURN;
        }
        this.ou.n(qgVar, baseException, this.sz == com.byazt.sk.fs.RUN_STATUS_RETRY_DELAY);
        if (this.sz != com.byazt.sk.fs.RUN_STATUS_RETRY_DELAY && this.cy.isNeedRetryDelay()) {
            long jT = t();
            if (jT > 0) {
                com.byazt.fe.n.s(n, "onSingleChunkRetry with delay time " + jT);
                try {
                    Thread.sleep(jT);
                } catch (Throwable th) {
                    com.byazt.fe.n.q(n, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.byazt.qx.fs.CONTINUE;
    }

    @Override // com.byazt.l.w
    public com.byazt.qx.fs n(BaseException baseException, long j) {
        long jN;
        long totalBytes;
        boolean z;
        this.wm = baseException;
        this.cy.increaseCurBytes(-j);
        this.k.n(this.cy);
        if (py()) {
            return com.byazt.qx.fs.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.h == null || this.cy.isForbiddenRetryed()) {
                if (q(baseException)) {
                    return com.byazt.qx.fs.RETURN;
                }
            } else {
                com.byazt.je.qg qgVar = new com.byazt.je.qg() { // from class: com.byazt.l.s.1
                    @Override // com.byazt.je.qg, com.byazt.je.ou
                    public void n(List<String> list) {
                        super.n(list);
                        s.this.n(list);
                    }
                };
                boolean zN = this.h.n(qgVar);
                this.cy.setForbiddenRetryed();
                if (zN) {
                    if (!qgVar.n()) {
                        ae();
                        this.ou.fs();
                        this.sz = com.byazt.sk.fs.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.byazt.qx.fs.RETURN;
                    }
                    z = true;
                }
            }
            z = false;
        } else if (com.byazt.ta.w.fs(baseException)) {
            if (this.t == null) {
                qg(baseException);
                return com.byazt.qx.fs.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            hd hdVar = new hd() { // from class: com.byazt.l.s.2
                @Override // com.byazt.je.hd
                public void n() {
                    synchronized (s.this) {
                        atomicBoolean.set(true);
                        s.this.f();
                    }
                }
            };
            if (baseException instanceof com.byazt.qx.q) {
                com.byazt.qx.q qVar = (com.byazt.qx.q) baseException;
                jN = qVar.n();
                totalBytes = qVar.qg();
            } else {
                jN = -1;
                totalBytes = this.cy.getTotalBytes();
            }
            synchronized (this) {
                if (this.t.n(jN, totalBytes, hdVar)) {
                    if (!com.byazt.f.n.n(this.cy.getId()).qg("not_delete_when_clean_space", false)) {
                        hu();
                    }
                    if (!atomicBoolean.get()) {
                        if (this.sz != com.byazt.sk.fs.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                            this.sz = com.byazt.sk.fs.RUN_STATUS_WAITING_ASYNC_HANDLER;
                            ae();
                            this.ou.fs();
                        }
                        return com.byazt.qx.fs.RETURN;
                    }
                    if (q(baseException)) {
                        return com.byazt.qx.fs.RETURN;
                    }
                    z = true;
                } else {
                    if (this.sz == com.byazt.sk.fs.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        return com.byazt.qx.fs.RETURN;
                    }
                    qg(baseException);
                    return com.byazt.qx.fs.RETURN;
                }
            }
        } else {
            if (q(baseException)) {
                return com.byazt.qx.fs.RETURN;
            }
            z = false;
        }
        if (!z && fi()) {
            ae();
        }
        this.ou.n(baseException, this.sz == com.byazt.sk.fs.RUN_STATUS_RETRY_DELAY);
        return this.sz == com.byazt.sk.fs.RUN_STATUS_RETRY_DELAY ? com.byazt.qx.fs.RETURN : com.byazt.qx.fs.CONTINUE;
    }

    private boolean q(BaseException baseException) {
        AtomicInteger atomicInteger = this.l;
        boolean z = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                if (this.cy.trySwitchToNextBackupUrl()) {
                    this.l.set(this.cy.getBackUpUrlRetryCount());
                    this.cy.updateCurRetryTime(this.l.get());
                } else if (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.cy.canReplaceHttpForRetry())) {
                    this.l.set(this.cy.getRetryCount());
                    this.cy.updateCurRetryTime(this.l.get());
                    this.cy.setHttpsToHttpRetryUsed(true);
                } else {
                    qg(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.l), String.valueOf(this.cy.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                z = false;
            }
            if (this.sz != com.byazt.sk.fs.RUN_STATUS_RETRY_DELAY && z) {
                this.cy.updateCurRetryTime(this.l.decrementAndGet());
            }
            return false;
        }
        qg(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
        return true;
    }

    @Override // com.byazt.l.w
    public synchronized com.byazt.wm.qg n(int i) {
        com.byazt.wm.qg qgVarN;
        if (this.cy.getChunkCount() < 2) {
            return null;
        }
        List<com.byazt.wm.qg> listS = this.k.s(this.cy.getId());
        if (listS != null && !listS.isEmpty()) {
            for (int i2 = 0; i2 < listS.size(); i2++) {
                com.byazt.wm.qg qgVar = listS.get(i2);
                if (qgVar != null && (qgVarN = n(qgVar, i)) != null) {
                    return qgVarN;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.byazt.l.w
    public void n(com.byazt.m.x xVar) {
        boolean z;
        if (xVar != null) {
            try {
                int iQg = xVar.qg();
                this.cy.setHttpStatusCode(iQg);
                this.cy.setHttpStatusMessage(com.byazt.ta.qg.n(iQg));
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        this.cy.setHttpStatusCode(-1);
        this.cy.setHttpStatusMessage("");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0083  */
    /* JADX WARN: Code duplicated, block: B:29:0x008f  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e5 A[SYNTHETIC] */
    private com.byazt.wm.qg n(com.byazt.wm.qg qgVar, int i) {
        boolean z;
        int i2;
        com.byazt.wm.qg qgVar2;
        com.byazt.wm.qg qgVar3 = null;
        if (!qgVar.q()) {
            return null;
        }
        long jS = qgVar.s(true);
        com.byazt.fe.n.qg(n, "reuseChunk retainLen:" + jS + " chunkIndex:" + i);
        if (!qgVar.w() && jS > com.byazt.sk.l.w && this.cy.isNeedReuseChunkRunnable()) {
            List<com.byazt.wm.qg> listN = qgVar.n(this.cy.getChunkCount(), this.cy.getTotalBytes());
            if (listN != null) {
                Iterator<com.byazt.wm.qg> it = listN.iterator();
                while (it.hasNext()) {
                    this.k.qg(it.next());
                }
            }
        } else {
            if (!qgVar.w()) {
                z = false;
            }
            if (z && qgVar.w()) {
                for (i2 = 1; i2 < qgVar.x().size(); i2++) {
                    qgVar2 = qgVar.x().get(i2);
                    if (qgVar2 != null) {
                        com.byazt.fe.n.qg(n, "check can checkUnCompletedChunk -- chunkIndex:" + qgVar2.um() + " currentOffset:" + qgVar2.sz() + "  startOffset:" + qgVar2.d() + " contentLen:" + qgVar2.hd());
                        if (qgVar2.um() >= 0 || (!qgVar2.rv() && !qgVar2.s())) {
                            qgVar3 = qgVar2;
                            break;
                        }
                    }
                }
                if (qgVar3 != null) {
                    com.byazt.fe.n.qg(n, "unComplete chunk " + qgVar.um() + " curOffset:" + qgVar.sz() + " reuseChunk chunkIndex:" + i + " for subChunk:" + qgVar3.um());
                    this.k.n(qgVar3.cp(), qgVar3.um(), qgVar3.qg(), i);
                    qgVar3.s(i);
                    qgVar3.n(true);
                }
            }
            return qgVar3;
        }
        z = true;
        if (z) {
            while (i2 < qgVar.x().size()) {
                qgVar2 = qgVar.x().get(i2);
                if (qgVar2 != null) {
                    com.byazt.fe.n.qg(n, "check can checkUnCompletedChunk -- chunkIndex:" + qgVar2.um() + " currentOffset:" + qgVar2.sz() + "  startOffset:" + qgVar2.d() + " contentLen:" + qgVar2.hd());
                    if (qgVar2.um() >= 0) {
                    }
                    qgVar3 = qgVar2;
                    break;
                }
            }
            if (qgVar3 != null) {
                com.byazt.fe.n.qg(n, "unComplete chunk " + qgVar.um() + " curOffset:" + qgVar.sz() + " reuseChunk chunkIndex:" + i + " for subChunk:" + qgVar3.um());
                this.k.n(qgVar3.cp(), qgVar3.um(), qgVar3.qg(), i);
                qgVar3.s(i);
                qgVar3.n(true);
            }
        }
        return qgVar3;
    }

    private um n(DownloadTask downloadTask) {
        um retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new com.byazt.i.hd(retryDelayTimeArray);
            }
        }
        return com.byazt.xv.s.oj();
    }

    public Future x() {
        return this.qg;
    }

    public void n(Future future) {
        this.qg = future;
    }
}
