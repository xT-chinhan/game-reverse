package com.byazt.stx;

import android.os.Process;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.fi.BaseConstants;
import com.byazt.lhc.BaseException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.z;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 108})
public class m implements Runnable {
    public volatile long a;
    public String aj;
    public volatile boolean b;
    public volatile long c;
    public boolean e;
    public boolean er;
    public Future fo;
    public volatile long fw;
    public final com.byazt.ew.pr g;
    public int gz;
    public final int hn;
    public com.byazt.edb.aj ho;
    public yb hw;
    public Thread iu;
    public final hn k;
    public long lb;
    public boolean ls;
    public final DownloadInfo m;
    public int n;
    public int nl;
    public com.byazt.auw.x nt;
    public volatile long ny;
    public volatile aj pr;
    public volatile long qa;
    public volatile boolean rc;
    public BaseException s;
    public volatile long uc;
    public com.byazt.tuy.c v;
    public volatile boolean ve;
    public String vk;
    public final uc w;
    public long ww;
    public volatile long x;
    public int y;
    public volatile boolean z;
    public String zo;
    public final List<aj> yb = new ArrayList();
    public volatile long cz = -1;

    public m(DownloadInfo downloadInfo, w wVar, hn hnVar, yb ybVar, int i) {
        this.m = downloadInfo;
        this.w = wVar;
        this.k = hnVar;
        this.g = com.byazt.ew.pr.pr(downloadInfo.getId());
        this.hw = ybVar;
        this.hn = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        uc ucVar;
        uc ucVar2;
        Process.setThreadPriority(10);
        try {
            this.iu = Thread.currentThread();
            this.w.pr(this);
            this.hw.pr(this);
            while (true) {
                aj ajVarPr = this.w.pr(this, this.hw);
                if (ajVarPr == null) {
                    com.byazt.p000do.pr.hn("SegmentReader", "no more segment, thread_index = " + this.hn);
                } else {
                    this.pr = ajVarPr;
                    try {
                        try {
                            if (pr(ajVarPr)) {
                                this.yb.add(ajVarPr);
                                this.pr = null;
                                ucVar2 = this.w;
                            } else {
                                if (!this.rc) {
                                    com.byazt.p000do.pr.c("SegmentReader", "download segment failed, segment = " + ajVarPr + ", thread_index = " + this.hn + ", failedException = " + this.s);
                                }
                                this.pr = null;
                                ucVar = this.w;
                                ucVar.pr(this, ajVarPr);
                            }
                        } catch (vk e) {
                            com.byazt.p000do.pr.c("SegmentReader", "run: SegmentApplyException, e = ".concat(String.valueOf(e)));
                            int i = this.gz;
                            if (i >= 50) {
                                com.byazt.p000do.pr.c("SegmentReader", "segment apply failed " + this.gz + "times, thread_index = " + this.hn);
                                this.pr = null;
                                ucVar = this.w;
                                ucVar.pr(this, ajVarPr);
                            } else {
                                this.gz = i + 1;
                                this.pr = null;
                                ucVar2 = this.w;
                            }
                        }
                        ucVar2.pr(this, ajVarPr);
                    } catch (Throwable th) {
                        this.pr = null;
                        this.w.pr(this, ajVarPr);
                        throw th;
                    }
                }
                try {
                    this.hw.hw(this);
                    this.w.hw(this);
                } catch (Throwable th2) {
                }
                this.iu = null;
                return;
            }
        } catch (Throwable th3) {
            try {
                this.hw.hw(this);
                this.w.hw(this);
            } catch (Throwable th4) {
            }
        }
    }

    private boolean pr(aj ajVar) throws BaseException {
        w();
        while (true) {
            try {
                try {
                    hw(ajVar);
                    x(ajVar);
                    aj();
                    return true;
                } catch (vk e) {
                    this.s = e;
                    throw e;
                }
            } catch (Throwable th) {
                try {
                    com.byazt.p000do.pr.c("SegmentReader", "download: e = " + th + ", threadIndex = " + this.hn + ", reconnect = " + this.z + ", closed = " + this.rc);
                    if (this.rc) {
                        aj();
                        return false;
                    }
                    if (this.z) {
                        this.z = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th2) {
                        }
                        if (this.b) {
                            this.b = false;
                            throw new vk(5, "download");
                        }
                    } else {
                        BaseException e2 = null;
                        if (th instanceof BaseException) {
                            e2 = th;
                        } else {
                            try {
                                com.byazt.tuy.uc.pr((Throwable) th, "download");
                            } catch (BaseException e3) {
                                e2 = e3;
                            }
                        }
                        if (e2 == null || !pr(ajVar, e2)) {
                            aj();
                            return false;
                        }
                    }
                    aj();
                } catch (Throwable th3) {
                    aj();
                    throw th3;
                }
            }
        }
    }

    private void aj() {
        this.ww = this.x;
        this.x = -1L;
        this.c = -1L;
        this.uc = -1L;
        this.fw = -1L;
        vk();
    }

    private void vk() {
        com.byazt.edb.aj ajVar = this.ho;
        if (ajVar != null) {
            try {
                com.byazt.p000do.pr.hn("SegmentReader", "closeConnection: thread = " + this.hn);
                ajVar.x();
                ajVar.hn();
            } catch (Throwable th) {
            }
        }
    }

    private void w() {
        this.e = false;
        k();
    }

    private void k() {
        this.nl = this.hw.x ? this.m.getRetryCount() : this.m.getBackUpUrlRetryCount();
        this.y = 0;
    }

    public boolean pr(yb ybVar) {
        int i = this.n;
        if (i >= 30) {
            return false;
        }
        this.n = i + 1;
        yb ybVar2 = this.hw;
        if (ybVar2 != null) {
            ybVar2.hw(this);
        }
        ybVar.pr(this);
        this.hw = ybVar;
        k();
        return true;
    }

    private boolean pr(aj ajVar, BaseException baseException) {
        com.byazt.p000do.pr.c("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.y + ", retryCount = " + this.nl);
        this.s = baseException;
        this.hw.hw();
        this.w.pr(this, this.hw, ajVar, baseException, this.y, this.nl);
        int i = this.y;
        if (i < this.nl) {
            this.y = i + 1;
            return true;
        }
        if (pr(baseException)) {
            return true;
        }
        this.w.pr(this, this.hw, ajVar, baseException);
        return false;
    }

    private boolean pr(BaseException baseException) {
        if (!com.byazt.tuy.uc.hn(baseException)) {
            return false;
        }
        String str = this.hw.pr;
        if (TextUtils.isEmpty(str) || !str.startsWith(BaseConstants.SCHEME_HTTPS) || !this.m.isNeedHttpsToHttpRetry() || this.e) {
            return false;
        }
        this.e = true;
        k();
        return true;
    }

    private void hw(aj ajVar) throws com.byazt.lhc.aj, BaseException {
        hn(ajVar);
        this.w.pr(this, ajVar, this.hw, this.nt);
        this.hw.hn();
    }

    private void hn(aj ajVar) throws BaseException {
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.c = 0L;
                this.x = jCurrentTimeMillis;
                this.lb = ajVar.c();
                this.a = ajVar.uc();
                if (this.a > 0 && this.lb > this.a) {
                    throw new vk(6, "createConn, ".concat(String.valueOf(ajVar)));
                }
                this.v = new com.byazt.tuy.c();
                List<com.byazt.auw.hn> listPr = com.byazt.tuy.uc.pr(this.m.getExtraHeaders(), this.m.geteTag(), this.lb, this.a);
                listPr.add(new com.byazt.auw.hn("Segment-Index", String.valueOf(ajVar.fw())));
                listPr.add(new com.byazt.auw.hn("Thread-Index", String.valueOf(this.hn)));
                com.byazt.tuy.uc.pr(listPr, this.m);
                com.byazt.tuy.uc.hw(listPr, this.m);
                String strReplaceFirst = this.hw.pr;
                if (this.e && !TextUtils.isEmpty(strReplaceFirst) && strReplaceFirst.startsWith(BaseConstants.SCHEME_HTTPS)) {
                    strReplaceFirst = strReplaceFirst.replaceFirst(BaseConstants.SCHEME_HTTPS, "http");
                }
                String str = this.hw.hw;
                com.byazt.p000do.pr.hn("SegmentReader", "createConnectionBegin: url = " + strReplaceFirst + ", ip = " + str + ", segment = " + ajVar + ", threadIndex = " + this.hn);
                this.zo = strReplaceFirst;
                this.aj = str;
                com.byazt.edb.aj ajVarPr = com.byazt.lj.hn.pr(this.m.isNeedDefaultHttpServiceBackUp(), this.m.getMaxBytes(), strReplaceFirst, str, listPr, 0, jCurrentTimeMillis - this.ww > 3000 && this.g.hw("monitor_download_connect") > 0, this.m);
                if (ajVarPr == null) {
                    throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                }
                this.ho = ajVarPr;
                this.nt = new com.byazt.auw.x(strReplaceFirst, ajVarPr);
                if (this.rc) {
                    throw new nt("createConn");
                }
                if (ajVarPr instanceof com.byazt.edb.pr) {
                    this.vk = ((com.byazt.edb.pr) ajVarPr).c();
                }
                this.c = System.currentTimeMillis();
            } catch (Throwable th) {
                this.c = System.currentTimeMillis();
                throw th;
            }
        } catch (BaseException e) {
            throw e;
        } catch (Throwable th2) {
            com.byazt.tuy.uc.pr(th2, "createConn");
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0167 */
    /* JADX WARN: Code duplicated, block: B:139:0x027a  */
    /* JADX WARN: Code duplicated, block: B:175:0x030b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:182:0x031f  */
    /* JADX WARN: Code duplicated, block: B:184:0x0322  */
    /* JADX WARN: Code duplicated, block: B:187:0x032f  */
    /* JADX WARN: Code duplicated, block: B:189:0x033d  */
    /* JADX WARN: Code duplicated, block: B:193:0x0346  */
    /* JADX WARN: Code duplicated, block: B:214:0x037a  */
    /* JADX WARN: Code duplicated, block: B:217:0x0387  */
    /* JADX WARN: Code duplicated, block: B:223:0x039d  */
    /* JADX WARN: Code duplicated, block: B:241:0x030d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:258:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x018b A[Catch: all -> 0x028c, BaseException -> 0x028e, TryCatch #21 {BaseException -> 0x028e, all -> 0x028c, blocks: (B:27:0x0072, B:28:0x0076, B:53:0x00e5, B:92:0x0179, B:94:0x0184, B:95:0x018b, B:97:0x0191, B:99:0x0197, B:102:0x01a0, B:103:0x01a4, B:140:0x027c), top: B:250:0x0061 }] */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0168, code lost:
    
        r0 = th;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void x(com.byazt.stx.aj r32) throws com.byazt.lhc.BaseException {
        /*
            Method dump skipped, instruction units count: 965
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.stx.m.x(com.byazt.stx.aj):void");
    }

    private pr pr(hn hnVar, InputStream inputStream) throws Throwable {
        int i;
        pr prVarHw = hnVar.hw();
        try {
            i = inputStream.read(prVarHw.pr);
            try {
                if (i == -1) {
                    throw new BaseException(1073, z.s);
                }
                prVarHw.hn = i;
                if (i == -1) {
                    hnVar.pr(prVarHw);
                }
                return prVarHw;
            } catch (Throwable th) {
                th = th;
                if (i == -1) {
                    hnVar.pr(prVarHw);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i = -1;
        }
    }

    private long m() {
        long j = this.qa;
        this.qa = 0L;
        if (j <= 0) {
            return LongCompanionObject.MAX_VALUE;
        }
        return j;
    }

    public boolean pr(long j) {
        long j2 = this.a;
        if (j <= 0 && j2 > 0) {
            return false;
        }
        if (j > j2 && j2 > 0) {
            return false;
        }
        this.qa = j;
        this.ve = true;
        return true;
    }

    public void pr() {
        yb ybVar = this.hw;
        try {
            synchronized (this.w) {
                long jHn = hn();
                if (jHn > 0) {
                    this.ny += jHn;
                    ybVar.pr(jHn);
                }
                this.cz = -1L;
            }
        } catch (Throwable th) {
        }
    }

    public long hw() {
        long jHn;
        synchronized (this.w) {
            jHn = this.ny + hn();
        }
        return jHn;
    }

    public long hn() {
        synchronized (this.w) {
            long j = this.cz;
            long j2 = this.lb;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    public long x() {
        return this.cz;
    }

    public void c() {
        com.byazt.p000do.pr.hn("SegmentReader", "close: threadIndex = " + this.hn);
        synchronized (this) {
            this.rc = true;
            this.ve = true;
        }
        vk();
        Future future = this.fo;
        if (future != null) {
            this.fo = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
            }
        }
    }

    public void uc() {
        pr(false);
    }

    public void pr(boolean z) {
        com.byazt.p000do.pr.hn("SegmentReader", "reconnect: threadIndex = " + this.hn);
        synchronized (this) {
            this.b = z;
            this.z = true;
            this.ve = true;
        }
        vk();
        Thread thread = this.iu;
        if (thread != null) {
            try {
                thread.interrupt();
            } catch (Throwable th) {
            }
        }
    }

    public void pr(Future future) {
        this.fo = future;
    }

    public void hw(boolean z) {
        this.ls = z;
    }

    public boolean fw() {
        return this.ls;
    }

    public void hn(boolean z) {
        this.er = z;
    }

    public void hw(long j) {
        long j2 = this.cz;
        com.byazt.tuy.c cVar = this.v;
        if (j2 < 0 || cVar == null) {
            return;
        }
        cVar.pr(j2, j);
    }

    public long pr(long j, long j2) {
        com.byazt.tuy.c cVar = this.v;
        if (cVar == null) {
            return -1L;
        }
        return cVar.hw(j, j2);
    }

    public long zo() {
        return this.lb;
    }
}
