package com.byazt.kl;

import android.os.Process;
import android.text.TextUtils;
import com.byazt.ho.BaseConstants;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 445, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa implements Runnable {
    public volatile long a;
    public BaseException ae;
    public boolean an;
    public int bb;
    public long cd;
    public final w cp;
    public com.byazt.wm.q cy;
    public final s d;
    public com.byazt.ta.l df;
    public boolean f;
    public boolean fi;
    public String fs;
    public volatile boolean h;
    public volatile boolean hu;
    public int j;
    public com.byazt.m.rv k;
    public volatile long l;
    public int lh;
    public int ln;
    public volatile boolean m;
    public volatile rv n;
    public final DownloadInfo oa;
    public volatile long ou;
    public volatile long q;
    public hd qg;
    public String rv;
    public final int s;
    public final com.byazt.f.n sz;
    public Thread t;
    public String tj;
    public volatile long um;
    public volatile boolean ur;
    public long v;
    public volatile long w;
    public Future wm;
    public volatile long x;
    public final List<rv> hd = new ArrayList();
    public volatile long py = -1;

    public oa(DownloadInfo downloadInfo, cp cpVar, s sVar, hd hdVar, int i) {
        this.oa = downloadInfo;
        this.cp = cpVar;
        this.d = sVar;
        this.sz = com.byazt.f.n.n(downloadInfo.getId());
        this.qg = hdVar;
        this.s = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        try {
            this.t = Thread.currentThread();
            this.cp.n(this);
            this.qg.n(this);
            while (true) {
                rv rvVarN = this.cp.n(this, this.qg);
                if (rvVarN == null) {
                    com.byazt.fe.n.s("SegmentReader", "no more segment, thread_index = " + this.s);
                } else {
                    this.n = rvVarN;
                    try {
                        try {
                            try {
                                if (n(rvVarN)) {
                                    this.hd.add(rvVarN);
                                    this.n = null;
                                    this.cp.n(this, rvVarN);
                                } else {
                                    if (!this.m) {
                                        com.byazt.fe.n.l("SegmentReader", "download segment failed, segment = " + rvVarN + ", thread_index = " + this.s + ", failedException = " + this.ae);
                                    }
                                    this.n = null;
                                    this.cp.n(this, rvVarN);
                                }
                            } catch (Throwable unused) {
                                this.t = null;
                            }
                        } catch (Throwable th) {
                            this.n = null;
                            this.cp.n(this, rvVarN);
                            throw th;
                        }
                    } catch (tj e) {
                        com.byazt.fe.n.l("SegmentReader", "run: SegmentApplyException, e = ".concat(String.valueOf(e)));
                        int i = this.bb;
                        if (i >= 50) {
                            com.byazt.fe.n.l("SegmentReader", "segment apply failed " + this.bb + "times, thread_index = " + this.s);
                            this.n = null;
                            this.cp.n(this, rvVarN);
                        } else {
                            this.bb = i + 1;
                            this.n = null;
                        }
                    }
                }
                try {
                    this.qg.qg(this);
                    this.cp.qg(this);
                } catch (Throwable unused2) {
                }
                this.t = null;
                return;
            }
        } catch (Throwable unused3) {
            this.qg.qg(this);
            this.cp.qg(this);
            this.t = null;
        }
    }

    private boolean n(rv rvVar) throws BaseException {
        cp();
        while (true) {
            try {
                try {
                    qg(rvVar);
                    q(rvVar);
                    rv();
                    return true;
                } catch (tj e) {
                    this.ae = e;
                    throw e;
                }
            } catch (Throwable th) {
                try {
                    com.byazt.fe.n.l("SegmentReader", "download: e = " + th + ", threadIndex = " + this.s + ", reconnect = " + this.hu + ", closed = " + this.m);
                    if (this.m) {
                        rv();
                        return false;
                    }
                    if (this.hu) {
                        this.hu = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable unused) {
                        }
                        if (this.h) {
                            this.h = false;
                            throw new tj(5, "download");
                        }
                    } else {
                        if (th instanceof BaseException) {
                            e = th;
                        } else {
                            try {
                                com.byazt.ta.w.n((Throwable) th, "download");
                                e = null;
                            } catch (BaseException e2) {
                                e = e2;
                            }
                        }
                        if (e == null || !n(rvVar, e)) {
                            rv();
                            return false;
                        }
                    }
                    rv();
                } catch (Throwable th2) {
                    rv();
                    throw th2;
                }
            }
        }
    }

    private void rv() {
        this.v = this.q;
        this.q = -1L;
        this.l = -1L;
        this.w = -1L;
        this.x = -1L;
        tj();
    }

    private void tj() {
        com.byazt.m.rv rvVar = this.k;
        if (rvVar != null) {
            try {
                com.byazt.fe.n.s("SegmentReader", "closeConnection: thread = " + this.s);
                rvVar.q();
                rvVar.s();
            } catch (Throwable unused) {
            }
        }
    }

    private void cp() {
        this.an = false;
        d();
    }

    private void d() {
        this.ln = this.qg.q ? this.oa.getRetryCount() : this.oa.getBackUpUrlRetryCount();
        this.lh = 0;
    }

    public boolean n(hd hdVar) {
        int i = this.j;
        if (i >= 30) {
            return false;
        }
        this.j = i + 1;
        hd hdVar2 = this.qg;
        if (hdVar2 != null) {
            hdVar2.qg(this);
        }
        hdVar.n(this);
        this.qg = hdVar;
        d();
        return true;
    }

    private boolean n(rv rvVar, BaseException baseException) {
        com.byazt.fe.n.l("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.lh + ", retryCount = " + this.ln);
        this.ae = baseException;
        this.qg.qg();
        this.cp.n(this, this.qg, rvVar, baseException, this.lh, this.ln);
        int i = this.lh;
        if (i < this.ln) {
            this.lh = i + 1;
            return true;
        }
        if (n(baseException)) {
            return true;
        }
        this.cp.n(this, this.qg, rvVar, baseException);
        return false;
    }

    private boolean n(BaseException baseException) {
        if (!com.byazt.ta.w.s(baseException)) {
            return false;
        }
        String str = this.qg.n;
        if (TextUtils.isEmpty(str) || !str.startsWith(BaseConstants.SCHEME_HTTPS) || !this.oa.isNeedHttpsToHttpRetry() || this.an) {
            return false;
        }
        this.an = true;
        d();
        return true;
    }

    private void qg(rv rvVar) throws BaseException, com.byazt.qx.rv {
        s(rvVar);
        this.cp.n(this, rvVar, this.qg, this.cy);
        this.qg.s();
    }

    private void s(rv rvVar) throws BaseException {
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.l = 0L;
                this.q = jCurrentTimeMillis;
                this.cd = rvVar.l();
                this.a = rvVar.w();
                if (this.a > 0 && this.cd > this.a) {
                    throw new tj(6, "createConn, ".concat(String.valueOf(rvVar)));
                }
                this.df = new com.byazt.ta.l();
                List<com.byazt.wm.s> listN = com.byazt.ta.w.n(this.oa.getExtraHeaders(), this.oa.geteTag(), this.cd, this.a);
                listN.add(new com.byazt.wm.s("Segment-Index", String.valueOf(rvVar.x())));
                listN.add(new com.byazt.wm.s("Thread-Index", String.valueOf(this.s)));
                com.byazt.ta.w.n(listN, this.oa);
                com.byazt.ta.w.qg(listN, this.oa);
                String strReplaceFirst = this.qg.n;
                if (this.an && !TextUtils.isEmpty(strReplaceFirst) && strReplaceFirst.startsWith(BaseConstants.SCHEME_HTTPS)) {
                    strReplaceFirst = strReplaceFirst.replaceFirst(BaseConstants.SCHEME_HTTPS, "http");
                }
                String str = this.qg.qg;
                com.byazt.fe.n.s("SegmentReader", "createConnectionBegin: url = " + strReplaceFirst + ", ip = " + str + ", segment = " + rvVar + ", threadIndex = " + this.s);
                this.fs = strReplaceFirst;
                this.rv = str;
                com.byazt.m.rv rvVarN = com.byazt.xv.s.n(this.oa.isNeedDefaultHttpServiceBackUp(), this.oa.getMaxBytes(), strReplaceFirst, str, listN, 0, jCurrentTimeMillis - this.v > 3000 && this.sz.qg("monitor_download_connect") > 0, this.oa);
                if (rvVarN == null) {
                    throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                }
                this.k = rvVarN;
                this.cy = new com.byazt.wm.q(strReplaceFirst, rvVarN);
                if (this.m) {
                    throw new cy("createConn");
                }
                if (rvVarN instanceof com.byazt.m.n) {
                    this.tj = ((com.byazt.m.n) rvVarN).l();
                }
                this.l = System.currentTimeMillis();
            } catch (Throwable th) {
                this.l = System.currentTimeMillis();
                throw th;
            }
        } catch (BaseException e) {
            throw e;
        } catch (Throwable th2) {
            com.byazt.ta.w.n(th2, "createConn");
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x015a */
    /* JADX WARN: Code duplicated, block: B:131:0x0260  */
    /* JADX WARN: Code duplicated, block: B:167:0x02ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:171:0x02fd A[PHI: r15
      0x02fd: PHI (r15v7 com.byazt.kl.n) = (r15v6 com.byazt.kl.n), (r15v9 com.byazt.kl.n) binds: [B:166:0x02ed, B:213:0x02fd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:173:0x0300  */
    /* JADX WARN: Code duplicated, block: B:176:0x030d  */
    /* JADX WARN: Code duplicated, block: B:178:0x031b  */
    /* JADX WARN: Code duplicated, block: B:182:0x0324  */
    /* JADX WARN: Code duplicated, block: B:200:0x0351  */
    /* JADX WARN: Code duplicated, block: B:203:0x035e  */
    /* JADX WARN: Code duplicated, block: B:209:0x0374  */
    /* JADX WARN: Code duplicated, block: B:236:0x02f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:247:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:248:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x017e A[Catch: all -> 0x0271, BaseException -> 0x0273, TryCatch #20 {BaseException -> 0x0273, all -> 0x0271, blocks: (B:27:0x006e, B:28:0x0072, B:50:0x00da, B:88:0x016c, B:90:0x0177, B:91:0x017e, B:93:0x0184, B:95:0x018a, B:98:0x0193, B:99:0x0197, B:132:0x0262), top: B:241:0x005d }] */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x015b, code lost:
    
        r0 = th;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void q(com.byazt.kl.rv r32) throws com.byazt.qx.BaseException {
        /*
            Method dump skipped, instruction units count: 924
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.kl.oa.q(com.byazt.kl.rv):void");
    }

    private n n(s sVar, InputStream inputStream) throws Throwable {
        int i;
        n nVarQg = sVar.qg();
        try {
            i = inputStream.read(nVarQg.n);
            try {
                if (i == -1) {
                    throw new BaseException(1073, "probe");
                }
                nVarQg.s = i;
                if (i == -1) {
                    sVar.n(nVarQg);
                }
                return nVarQg;
            } catch (Throwable th) {
                th = th;
                if (i == -1) {
                    sVar.n(nVarQg);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i = -1;
        }
    }

    private long oa() {
        long j = this.um;
        this.um = 0L;
        return j <= 0 ? LongCompanionObject.MAX_VALUE : j;
    }

    public boolean n(long j) {
        long j2 = this.a;
        if (j <= 0 && j2 > 0) {
            return false;
        }
        if (j > j2 && j2 > 0) {
            return false;
        }
        this.um = j;
        this.ur = true;
        return true;
    }

    public void n() {
        hd hdVar = this.qg;
        try {
            synchronized (this.cp) {
                long jS = s();
                if (jS > 0) {
                    this.ou += jS;
                    hdVar.n(jS);
                }
                this.py = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public long qg() {
        long jS;
        synchronized (this.cp) {
            jS = this.ou + s();
        }
        return jS;
    }

    public long s() {
        synchronized (this.cp) {
            long j = this.py;
            long j2 = this.cd;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    public long q() {
        return this.py;
    }

    public void l() {
        com.byazt.fe.n.s("SegmentReader", "close: threadIndex = " + this.s);
        synchronized (this) {
            this.m = true;
            this.ur = true;
        }
        tj();
        Future future = this.wm;
        if (future != null) {
            this.wm = null;
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
        }
    }

    public void w() {
        n(false);
    }

    public void n(boolean z) {
        com.byazt.fe.n.s("SegmentReader", "reconnect: threadIndex = " + this.s);
        synchronized (this) {
            this.h = z;
            this.hu = true;
            this.ur = true;
        }
        tj();
        Thread thread = this.t;
        if (thread != null) {
            try {
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    public void n(Future future) {
        this.wm = future;
    }

    public void qg(boolean z) {
        this.f = z;
    }

    public boolean x() {
        return this.f;
    }

    public void s(boolean z) {
        this.fi = z;
    }

    public void qg(long j) {
        long j2 = this.py;
        com.byazt.ta.l lVar = this.df;
        if (j2 < 0 || lVar == null) {
            return;
        }
        lVar.n(j2, j);
    }

    public long n(long j, long j2) {
        com.byazt.ta.l lVar = this.df;
        if (lVar == null) {
            return -1L;
        }
        return lVar.qg(j, j2);
    }

    public long fs() {
        return this.cd;
    }
}
