package com.byazt.xv;

import android.os.SystemClock;
import com.anythink.china.a.c;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 41, 18})
public class l {
    public static String qg = "ResponseHandler";
    public final com.byazt.f.n a;
    public long bb;
    public volatile long cd;
    public BaseException cp;
    public long cy;
    public volatile boolean d;
    public com.byazt.i.cp fs;
    public boolean h;
    public volatile long hd;
    public final boolean hu;
    public long k;
    public final com.byazt.wm.qg l;
    public long ln;
    public final long m;
    public volatile boolean oa;
    public final boolean ou;
    public final com.byazt.b.n py;
    public final String q;
    public a rv;
    public final DownloadInfo s;
    public final com.byazt.l.w sz;
    public long t;
    public com.byazt.wm.l tj;
    public final boolean um;
    public long ur;
    public final com.byazt.m.rv w;
    public final long wm;
    public tj x;
    public boolean n = false;
    public volatile long lh = 0;
    public volatile long v = 0;

    private boolean qg(long j, long j2) {
        return j > c.q && j2 > 500;
    }

    public l(DownloadInfo downloadInfo, String str, com.byazt.m.rv rvVar, com.byazt.wm.qg qgVar, com.byazt.l.w wVar) {
        this.s = downloadInfo;
        this.q = str;
        tj tjVarHu = s.hu();
        this.x = tjVarHu;
        if (tjVarHu instanceof com.byazt.i.q) {
            com.byazt.i.q qVar = (com.byazt.i.q) tjVarHu;
            this.fs = qVar.n();
            this.rv = qVar.w();
        }
        this.w = rvVar;
        this.l = qgVar;
        this.sz = wVar;
        long jSz = qgVar.sz();
        this.k = jSz;
        this.cy = jSz;
        if (qgVar.q()) {
            this.cd = qgVar.hd();
        } else {
            this.cd = qgVar.s(false);
        }
        this.hd = qgVar.cy();
        this.py = com.byazt.b.n.n();
        com.byazt.f.n nVarN = com.byazt.f.n.n(downloadInfo.getId());
        this.a = nVarN;
        boolean z = nVarN.n("sync_strategy", 0) == 1;
        this.ou = z;
        if (z) {
            long jN = nVarN.n("sync_interval_ms_fg", 5000);
            long jN2 = nVarN.n("sync_interval_ms_bg", 1000);
            this.wm = Math.max(jN, 500L);
            this.m = Math.max(jN2, 500L);
        } else {
            this.wm = 0L;
            this.m = 0L;
        }
        this.hu = nVarN.qg("monitor_rw") == 1;
        this.um = com.byazt.ta.n.n(65536);
    }

    public long n() {
        return this.k;
    }

    private boolean w() {
        return this.d || this.oa;
    }

    public void qg() {
        if (this.d) {
            return;
        }
        this.d = true;
        x();
    }

    public void s() {
        if (this.oa) {
            return;
        }
        synchronized (this.sz) {
            this.oa = true;
        }
        x();
    }

    private void x() {
        ExecutorService executorServiceD;
        if (this.w == null || (executorServiceD = s.d()) == null) {
            return;
        }
        executorServiceD.execute(new Runnable() { // from class: com.byazt.xv.l.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    l.this.w.q();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void n(long j, long j2, long j3) {
        this.k = j;
        this.cy = j;
        this.hd = j2;
        this.cd = j3;
    }

    public void n(long j, long j2) {
        this.hd = j;
        this.cd = j2;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01c0 A[Catch: all -> 0x021b, BaseException -> 0x021d, TryCatch #32 {BaseException -> 0x021d, all -> 0x021b, blocks: (B:93:0x0193, B:94:0x01a0, B:101:0x01b8, B:103:0x01c0, B:105:0x01c8, B:107:0x01d0, B:109:0x01d8, B:111:0x01e3, B:115:0x01eb, B:119:0x01f7, B:120:0x01fa, B:122:0x020c, B:123:0x0211, B:124:0x0212, B:125:0x0217, B:128:0x021a), top: B:362:0x0193 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x01c8 A[Catch: all -> 0x021b, BaseException -> 0x021d, TryCatch #32 {BaseException -> 0x021d, all -> 0x021b, blocks: (B:93:0x0193, B:94:0x01a0, B:101:0x01b8, B:103:0x01c0, B:105:0x01c8, B:107:0x01d0, B:109:0x01d8, B:111:0x01e3, B:115:0x01eb, B:119:0x01f7, B:120:0x01fa, B:122:0x020c, B:123:0x0211, B:124:0x0212, B:125:0x0217, B:128:0x021a), top: B:362:0x0193 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:191:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:193:0x0304  */
    /* JADX WARN: Code duplicated, block: B:196:0x030b A[Catch: all -> 0x0350, TryCatch #23 {all -> 0x0350, blocks: (B:194:0x0307, B:196:0x030b, B:197:0x030d, B:207:0x0322, B:208:0x0323, B:210:0x032c, B:198:0x030e, B:200:0x0312, B:202:0x031b, B:203:0x031e), top: B:345:0x0307, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:200:0x0312 A[Catch: all -> 0x0320, TryCatch #0 {, blocks: (B:198:0x030e, B:200:0x0312, B:202:0x031b, B:203:0x031e), top: B:327:0x030e, outer: #23 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x031b A[Catch: all -> 0x0320, TryCatch #0 {, blocks: (B:198:0x030e, B:200:0x0312, B:202:0x031b, B:203:0x031e), top: B:327:0x030e, outer: #23 }] */
    /* JADX WARN: Code duplicated, block: B:208:0x0323 A[Catch: all -> 0x0350, TryCatch #23 {all -> 0x0350, blocks: (B:194:0x0307, B:196:0x030b, B:197:0x030d, B:207:0x0322, B:208:0x0323, B:210:0x032c, B:198:0x030e, B:200:0x0312, B:202:0x031b, B:203:0x031e), top: B:345:0x0307, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:210:0x032c A[Catch: all -> 0x0350, TRY_LEAVE, TryCatch #23 {all -> 0x0350, blocks: (B:194:0x0307, B:196:0x030b, B:197:0x030d, B:207:0x0322, B:208:0x0323, B:210:0x032c, B:198:0x030e, B:200:0x0312, B:202:0x031b, B:203:0x031e), top: B:345:0x0307, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:216:0x035d A[Catch: all -> 0x04ce, TRY_ENTER, TRY_LEAVE, TryCatch #20 {all -> 0x04ce, blocks: (B:187:0x02e6, B:216:0x035d, B:217:0x0360, B:258:0x0453, B:259:0x0455, B:263:0x045b, B:265:0x0474, B:293:0x04c8, B:294:0x04cd), top: B:341:0x0028, inners: #13 }] */
    /* JADX WARN: Code duplicated, block: B:220:0x0369  */
    /* JADX WARN: Code duplicated, block: B:222:0x036e  */
    /* JADX WARN: Code duplicated, block: B:225:0x0375 A[Catch: all -> 0x0445, TryCatch #17 {all -> 0x0445, blocks: (B:223:0x0371, B:225:0x0375, B:226:0x0377, B:236:0x038c, B:237:0x038d, B:239:0x0396, B:227:0x0378, B:229:0x037c, B:231:0x0385, B:232:0x0388), top: B:338:0x0371, inners: #19 }] */
    /* JADX WARN: Code duplicated, block: B:229:0x037c A[Catch: all -> 0x038a, TryCatch #19 {, blocks: (B:227:0x0378, B:229:0x037c, B:231:0x0385, B:232:0x0388), top: B:339:0x0378, outer: #17 }] */
    /* JADX WARN: Code duplicated, block: B:231:0x0385 A[Catch: all -> 0x038a, TryCatch #19 {, blocks: (B:227:0x0378, B:229:0x037c, B:231:0x0385, B:232:0x0388), top: B:339:0x0378, outer: #17 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x038d A[Catch: all -> 0x0445, TryCatch #17 {all -> 0x0445, blocks: (B:223:0x0371, B:225:0x0375, B:226:0x0377, B:236:0x038c, B:237:0x038d, B:239:0x0396, B:227:0x0378, B:229:0x037c, B:231:0x0385, B:232:0x0388), top: B:338:0x0371, inners: #19 }] */
    /* JADX WARN: Code duplicated, block: B:239:0x0396 A[Catch: all -> 0x0445, TRY_LEAVE, TryCatch #17 {all -> 0x0445, blocks: (B:223:0x0371, B:225:0x0375, B:226:0x0377, B:236:0x038c, B:237:0x038d, B:239:0x0396, B:227:0x0378, B:229:0x037c, B:231:0x0385, B:232:0x0388), top: B:338:0x0371, inners: #19 }] */
    /* JADX WARN: Code duplicated, block: B:243:0x03e1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:244:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:246:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:253:0x0444 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:327:0x030e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:339:0x0378 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:348:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:371:0x0229 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:372:0x0212 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:373:0x020c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0119 A[Catch: all -> 0x0107, BaseException -> 0x010e, TRY_ENTER, TRY_LEAVE, TryCatch #28 {BaseException -> 0x010e, all -> 0x0107, blocks: (B:48:0x0102, B:56:0x0119), top: B:368:0x0102 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0129 A[Catch: all -> 0x029c, BaseException -> 0x02a3, TRY_LEAVE, TryCatch #35 {BaseException -> 0x02a3, all -> 0x029c, blocks: (B:54:0x0113, B:57:0x0125, B:59:0x0129), top: B:358:0x0113 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0131  */
    /* JADX WARN: Code duplicated, block: B:81:0x0168  */
    /* JADX WARN: Code duplicated, block: B:83:0x016f A[Catch: all -> 0x0176, BaseException -> 0x017a, TRY_LEAVE, TryCatch #29 {BaseException -> 0x017a, all -> 0x0176, blocks: (B:66:0x013a, B:68:0x0141, B:70:0x014e, B:83:0x016f, B:91:0x0187), top: B:366:0x013a }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0187 A[Catch: all -> 0x0176, BaseException -> 0x017a, TRY_ENTER, TRY_LEAVE, TryCatch #29 {BaseException -> 0x017a, all -> 0x0176, blocks: (B:66:0x013a, B:68:0x0141, B:70:0x014e, B:83:0x016f, B:91:0x0187), top: B:366:0x013a }] */
    /* JADX WARN: Code duplicated, block: B:99:0x01a9 A[Catch: all -> 0x0218, TryCatch #26 {, blocks: (B:95:0x01a1, B:97:0x01a5, B:100:0x01b7, B:99:0x01a9), top: B:348:0x01a1 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v45 */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public void q() throws BaseException {
        long j;
        long j2;
        com.byazt.x.qg qgVarN;
        com.byazt.m.rv rvVar;
        com.byazt.f.n nVar;
        DownloadInfo downloadInfo;
        String str;
        com.byazt.m.rv rvVar2;
        boolean z;
        boolean z2;
        BaseException baseException;
        long j3;
        com.byazt.m.rv rvVar3;
        boolean z3;
        boolean z4;
        com.byazt.m.rv rvVar4;
        String str2;
        DownloadInfo downloadInfo2;
        com.byazt.f.n nVar2;
        ?? r4;
        ?? r5;
        ?? r6;
        ?? r7;
        long j4;
        boolean z5;
        com.byazt.kl.n nVarN;
        int i;
        com.byazt.x.qg qgVar;
        com.byazt.x.qg qgVar2;
        long j5;
        if (w() || this.l == null) {
            return;
        }
        long jN = com.byazt.ta.w.n(this.w);
        ?? r8 = 0;
        ?? r9 = 0;
        ?? r10 = 0;
        if (jN == 0) {
            throw new com.byazt.qx.w(1004, "the content-length is 0");
        }
        long jD = this.l.d();
        long jNanoTime = System.nanoTime();
        boolean z6 = this.hu;
        int i2 = 1;
        try {
            try {
                try {
                    DownloadInfo downloadInfo3 = this.s;
                    int i3 = -1;
                    com.byazt.wm.l lVarN = com.byazt.ta.w.n(downloadInfo3, downloadInfo3.getTempPath(), this.s.getTempName(), this.a.n("flush_buffer_size_byte", -1));
                    this.tj = lVarN;
                    try {
                        lVarN.n(this.k);
                        InputStream inputStreamN = this.w.n();
                        if (inputStreamN == null) {
                            throw new BaseException(1042, new IOException("inputStream is null"));
                        }
                        this.s.updateRealStartDownloadTime();
                        qgVarN = n(inputStreamN);
                        try {
                            this.s.setIsRwConcurrent(this.h);
                            this.n = this.s.getOpenLimitSpeed();
                            long j6 = com.byazt.sk.l.q;
                            long j7 = com.byazt.sk.l.l;
                            long j8 = j6 / (1000 / j7);
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            long jNanoTime2 = 0;
                            long j9 = 0;
                            z6 = z6;
                            while (true) {
                                if (w()) {
                                    com.byazt.m.rv rvVar5 = this.w;
                                    if (rvVar5 != null) {
                                        rvVar5.q();
                                    }
                                    if (qgVarN != null) {
                                        qgVarN.qg();
                                    }
                                    try {
                                        if (this.um) {
                                            synchronized (this.sz) {
                                                if (!this.oa) {
                                                    n(this.fs);
                                                    if (this.tj != null) {
                                                        fs();
                                                    }
                                                }
                                            }
                                        } else {
                                            n(this.fs);
                                            if (this.tj != null) {
                                                fs();
                                            }
                                        }
                                        Closeable[] closeableArr = new Closeable[i2];
                                        closeableArr[0] = this.tj;
                                        com.byazt.ta.w.n(closeableArr);
                                        this.ln = System.nanoTime() - jNanoTime;
                                        nVar2 = this.a;
                                        downloadInfo2 = this.s;
                                        str2 = this.q;
                                        rvVar4 = this.w;
                                        z4 = this.d;
                                        boolean z7 = this.oa;
                                        r4 = z6 ? 1 : 0;
                                        z3 = z7;
                                        com.byazt.g.n.n(nVar2, downloadInfo2, str2, rvVar4, z4, z3, this.cp, this.k - this.cy, this.ln, r4, this.t, this.ur, this.bb, null);
                                    } catch (Throwable th) {
                                        Closeable[] closeableArr2 = new Closeable[i2];
                                        closeableArr2[0] = this.tj;
                                        com.byazt.ta.w.n(closeableArr2);
                                        throw th;
                                    }
                                }
                                z5 = z6 ? 1 : 0;
                                if (!z5) {
                                    nVarN = qgVarN.n();
                                    if (z5) {
                                        this.t += System.nanoTime() - jNanoTime2;
                                    }
                                    i = nVarN.s;
                                    if (i != i3) {
                                        j = jD;
                                        j2 = jNanoTime;
                                        qgVar = qgVarN;
                                        break;
                                    }
                                    if (this.s.isIgnoreDataVerify()) {
                                        j = jD;
                                        j2 = jNanoTime;
                                        qgVar2 = qgVarN;
                                    } else {
                                        j = jD;
                                        j2 = jNanoTime;
                                        qgVar2 = qgVarN;
                                        if (this.cd > this.k - this.cy) {
                                            i = (int) (this.cd - (this.k - this.cy));
                                        }
                                    }
                                    if (z5) {
                                        jNanoTime2 = System.nanoTime();
                                    }
                                    this.tj.n(nVarN.n, 0, i);
                                    if (z5) {
                                        this.ur += System.nanoTime() - jNanoTime2;
                                    }
                                    qgVar = qgVar2;
                                    qgVar.n(nVarN);
                                    j5 = i;
                                    this.k += j5;
                                    j9 += j5;
                                    synchronized (this.sz) {
                                        if (this.um) {
                                            boolean zQg = this.sz.qg(j5);
                                            n(this.fs);
                                            n(zQg);
                                        } else {
                                            boolean zQg2 = this.sz.qg(j5);
                                            n(this.fs);
                                            n(zQg2);
                                        }
                                        if (this.s.isDownloadWithWifiValid()) {
                                            throw new com.byazt.qx.s();
                                        }
                                        if (this.s.isPauseReserveWithWifiValid()) {
                                            throw new com.byazt.qx.l();
                                        }
                                        if (this.s.isIgnoreDataVerify()) {
                                        }
                                        if (!this.n) {
                                        }
                                        z6 = z5;
                                        qgVarN = qgVar;
                                        jNanoTime = j2;
                                        jD = j;
                                        i3 = -1;
                                        i2 = 1;
                                    }
                                } else {
                                    try {
                                        jNanoTime2 = System.nanoTime();
                                        try {
                                            nVarN = qgVarN.n();
                                            if (z5) {
                                                this.t += System.nanoTime() - jNanoTime2;
                                            }
                                            i = nVarN.s;
                                            if (i != i3) {
                                                j = jD;
                                                j2 = jNanoTime;
                                                qgVar = qgVarN;
                                                break;
                                            }
                                            if (this.s.isIgnoreDataVerify()) {
                                                j = jD;
                                                try {
                                                    j2 = jNanoTime;
                                                    try {
                                                        qgVar2 = qgVarN;
                                                        try {
                                                            if (this.cd > this.k - this.cy && this.cd < (this.k - this.cy) + ((long) i)) {
                                                                i = (int) (this.cd - (this.k - this.cy));
                                                            }
                                                        } catch (BaseException e) {
                                                            e = e;
                                                            qgVarN = qgVar2;
                                                            r6 = z5;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            qgVarN = qgVar2;
                                                            r8 = z5;
                                                            com.byazt.fe.n.q(qg, "handleResponse: e = ".concat(String.valueOf(th)));
                                                            if (w()) {
                                                                rvVar3 = this.w;
                                                                if (rvVar3 != null) {
                                                                    rvVar3.q();
                                                                }
                                                                if (qgVarN != null) {
                                                                    qgVarN.qg();
                                                                }
                                                                try {
                                                                    if (this.um) {
                                                                        synchronized (this.sz) {
                                                                            if (!this.oa) {
                                                                                n(this.fs);
                                                                                if (this.tj != null) {
                                                                                    fs();
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        n(this.fs);
                                                                        if (this.tj != null) {
                                                                            fs();
                                                                        }
                                                                    }
                                                                    com.byazt.ta.w.n(this.tj);
                                                                    r5 = r8;
                                                                    this.ln = System.nanoTime() - j2;
                                                                    nVar2 = this.a;
                                                                    downloadInfo2 = this.s;
                                                                    str2 = this.q;
                                                                    rvVar4 = this.w;
                                                                    z4 = this.d;
                                                                    z3 = this.oa;
                                                                    r4 = r5;
                                                                    com.byazt.g.n.n(nVar2, downloadInfo2, str2, rvVar4, z4, z3, this.cp, this.k - this.cy, this.ln, r4, this.t, this.ur, this.bb, null);
                                                                } catch (Throwable th3) {
                                                                    com.byazt.ta.w.n(this.tj);
                                                                    throw th3;
                                                                }
                                                            }
                                                            com.byazt.fe.n.n();
                                                            try {
                                                                com.byazt.ta.w.n(th, "ResponseHandler");
                                                                rvVar = this.w;
                                                                if (rvVar != null) {
                                                                    rvVar.q();
                                                                }
                                                                if (qgVarN != null) {
                                                                    qgVarN.qg();
                                                                }
                                                                try {
                                                                    if (this.um) {
                                                                        synchronized (this.sz) {
                                                                            if (!this.oa) {
                                                                                n(this.fs);
                                                                                if (this.tj != null) {
                                                                                    fs();
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        n(this.fs);
                                                                        if (this.tj != null) {
                                                                            fs();
                                                                        }
                                                                    }
                                                                    com.byazt.ta.w.n(this.tj);
                                                                    this.ln = System.nanoTime() - j2;
                                                                    nVar = this.a;
                                                                    downloadInfo = this.s;
                                                                    str = this.q;
                                                                    rvVar2 = this.w;
                                                                    z = this.d;
                                                                    z2 = this.oa;
                                                                    baseException = this.cp;
                                                                    j3 = this.k - this.cy;
                                                                    r7 = r8;
                                                                    com.byazt.g.n.n(nVar, downloadInfo, str, rvVar2, z, z2, baseException, j3, this.ln, r7, this.t, this.ur, this.bb, null);
                                                                    if (this.s.isIgnoreDataVerify()) {
                                                                        return;
                                                                    }
                                                                    j4 = this.k - this.cy;
                                                                    if (j4 < 0) {
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                } catch (Throwable th4) {
                                                                    com.byazt.ta.w.n(this.tj);
                                                                    throw th4;
                                                                }
                                                            } catch (BaseException e2) {
                                                                this.cp = e2;
                                                                throw e2;
                                                            }
                                                        }
                                                    } catch (BaseException e3) {
                                                        e = e3;
                                                        r6 = z5;
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        r8 = z5;
                                                        com.byazt.fe.n.q(qg, "handleResponse: e = ".concat(String.valueOf(th)));
                                                        if (w()) {
                                                            rvVar3 = this.w;
                                                            if (rvVar3 != null) {
                                                                rvVar3.q();
                                                            }
                                                            if (qgVarN != null) {
                                                                qgVarN.qg();
                                                            }
                                                            if (this.um) {
                                                                synchronized (this.sz) {
                                                                    if (!this.oa) {
                                                                        n(this.fs);
                                                                        if (this.tj != null) {
                                                                            fs();
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                n(this.fs);
                                                                if (this.tj != null) {
                                                                    fs();
                                                                }
                                                            }
                                                            com.byazt.ta.w.n(this.tj);
                                                            r5 = r8;
                                                            this.ln = System.nanoTime() - j2;
                                                            nVar2 = this.a;
                                                            downloadInfo2 = this.s;
                                                            str2 = this.q;
                                                            rvVar4 = this.w;
                                                            z4 = this.d;
                                                            z3 = this.oa;
                                                            r4 = r5;
                                                            com.byazt.g.n.n(nVar2, downloadInfo2, str2, rvVar4, z4, z3, this.cp, this.k - this.cy, this.ln, r4, this.t, this.ur, this.bb, null);
                                                        }
                                                        com.byazt.fe.n.n();
                                                        com.byazt.ta.w.n(th, "ResponseHandler");
                                                        rvVar = this.w;
                                                        if (rvVar != null) {
                                                            rvVar.q();
                                                        }
                                                        if (qgVarN != null) {
                                                            qgVarN.qg();
                                                        }
                                                        if (this.um) {
                                                            synchronized (this.sz) {
                                                                if (!this.oa) {
                                                                    n(this.fs);
                                                                    if (this.tj != null) {
                                                                        fs();
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            n(this.fs);
                                                            if (this.tj != null) {
                                                                fs();
                                                            }
                                                        }
                                                        com.byazt.ta.w.n(this.tj);
                                                        this.ln = System.nanoTime() - j2;
                                                        nVar = this.a;
                                                        downloadInfo = this.s;
                                                        str = this.q;
                                                        rvVar2 = this.w;
                                                        z = this.d;
                                                        z2 = this.oa;
                                                        baseException = this.cp;
                                                        j3 = this.k - this.cy;
                                                        r7 = r8;
                                                        com.byazt.g.n.n(nVar, downloadInfo, str, rvVar2, z, z2, baseException, j3, this.ln, r7, this.t, this.ur, this.bb, null);
                                                        if (this.s.isIgnoreDataVerify()) {
                                                            return;
                                                        }
                                                        j4 = this.k - this.cy;
                                                        if (j4 < 0) {
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                } catch (BaseException e4) {
                                                    e = e4;
                                                    j2 = jNanoTime;
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    j2 = jNanoTime;
                                                }
                                            } else {
                                                j = jD;
                                                j2 = jNanoTime;
                                                qgVar2 = qgVarN;
                                            }
                                            if (z5) {
                                                jNanoTime2 = System.nanoTime();
                                            }
                                            try {
                                                this.tj.n(nVarN.n, 0, i);
                                                if (z5) {
                                                    this.ur += System.nanoTime() - jNanoTime2;
                                                }
                                                qgVar = qgVar2;
                                                try {
                                                    qgVar.n(nVarN);
                                                    j5 = i;
                                                    this.k += j5;
                                                    j9 += j5;
                                                    synchronized (this.sz) {
                                                        if (this.um || !this.oa) {
                                                            boolean zQg3 = this.sz.qg(j5);
                                                            n(this.fs);
                                                            n(zQg3);
                                                        }
                                                    }
                                                    if (this.s.isDownloadWithWifiValid()) {
                                                        throw new com.byazt.qx.s();
                                                    }
                                                    if (this.s.isPauseReserveWithWifiValid()) {
                                                        throw new com.byazt.qx.l();
                                                    }
                                                    if (this.s.isIgnoreDataVerify() && this.cd >= 0 && this.cd <= this.k - this.cy) {
                                                        break;
                                                    }
                                                    if (!this.n && j9 > j8) {
                                                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                                        if (jCurrentTimeMillis2 < j7) {
                                                            try {
                                                                Thread.sleep(j7 - jCurrentTimeMillis2);
                                                            } catch (InterruptedException unused) {
                                                            }
                                                        }
                                                        jCurrentTimeMillis = System.currentTimeMillis();
                                                        j9 = 0;
                                                    }
                                                    z6 = z5;
                                                    qgVarN = qgVar;
                                                    jNanoTime = j2;
                                                    jD = j;
                                                    i3 = -1;
                                                    i2 = 1;
                                                } catch (BaseException e5) {
                                                    e = e5;
                                                    qgVarN = qgVar;
                                                    r6 = z5;
                                                    com.byazt.fe.n.q(qg, "handleResponse: BaseException e = ".concat(String.valueOf(e)));
                                                    if (this.a.n("ignore_base_ex_on_stop_status")) {
                                                    }
                                                    com.byazt.fe.n.n();
                                                    this.cp = e;
                                                    throw e;
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    qgVarN = qgVar;
                                                    r8 = z5;
                                                    com.byazt.fe.n.q(qg, "handleResponse: e = ".concat(String.valueOf(th)));
                                                    if (w()) {
                                                        rvVar3 = this.w;
                                                        if (rvVar3 != null) {
                                                            rvVar3.q();
                                                        }
                                                        if (qgVarN != null) {
                                                            qgVarN.qg();
                                                        }
                                                        if (this.um) {
                                                            synchronized (this.sz) {
                                                                if (!this.oa) {
                                                                    n(this.fs);
                                                                    if (this.tj != null) {
                                                                        fs();
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            n(this.fs);
                                                            if (this.tj != null) {
                                                                fs();
                                                            }
                                                        }
                                                        com.byazt.ta.w.n(this.tj);
                                                        r5 = r8;
                                                        this.ln = System.nanoTime() - j2;
                                                        nVar2 = this.a;
                                                        downloadInfo2 = this.s;
                                                        str2 = this.q;
                                                        rvVar4 = this.w;
                                                        z4 = this.d;
                                                        z3 = this.oa;
                                                        r4 = r5;
                                                        com.byazt.g.n.n(nVar2, downloadInfo2, str2, rvVar4, z4, z3, this.cp, this.k - this.cy, this.ln, r4, this.t, this.ur, this.bb, null);
                                                    }
                                                    com.byazt.fe.n.n();
                                                    com.byazt.ta.w.n(th, "ResponseHandler");
                                                    rvVar = this.w;
                                                    if (rvVar != null) {
                                                        rvVar.q();
                                                    }
                                                    if (qgVarN != null) {
                                                        qgVarN.qg();
                                                    }
                                                    if (this.um) {
                                                        synchronized (this.sz) {
                                                            if (!this.oa) {
                                                                n(this.fs);
                                                                if (this.tj != null) {
                                                                    fs();
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        n(this.fs);
                                                        if (this.tj != null) {
                                                            fs();
                                                        }
                                                    }
                                                    com.byazt.ta.w.n(this.tj);
                                                    this.ln = System.nanoTime() - j2;
                                                    nVar = this.a;
                                                    downloadInfo = this.s;
                                                    str = this.q;
                                                    rvVar2 = this.w;
                                                    z = this.d;
                                                    z2 = this.oa;
                                                    baseException = this.cp;
                                                    j3 = this.k - this.cy;
                                                    r7 = r8;
                                                }
                                            } catch (BaseException e6) {
                                                e = e6;
                                                qgVar = qgVar2;
                                            } catch (Throwable th8) {
                                                th = th8;
                                                qgVar = qgVar2;
                                            }
                                        } catch (BaseException e7) {
                                            e = e7;
                                            j2 = jNanoTime;
                                            r6 = z5;
                                        } catch (Throwable th9) {
                                            th = th9;
                                            j = jD;
                                            j2 = jNanoTime;
                                            r8 = z5;
                                        }
                                    } catch (BaseException e8) {
                                        e = e8;
                                        j2 = jNanoTime;
                                        r6 = z5;
                                    } catch (Throwable th10) {
                                        th = th10;
                                        j = jD;
                                        j2 = jNanoTime;
                                        r8 = z5;
                                        com.byazt.fe.n.q(qg, "handleResponse: e = ".concat(String.valueOf(th)));
                                        if (w()) {
                                            rvVar3 = this.w;
                                            if (rvVar3 != null) {
                                                rvVar3.q();
                                            }
                                            if (qgVarN != null) {
                                                qgVarN.qg();
                                            }
                                            if (this.um) {
                                                synchronized (this.sz) {
                                                    if (!this.oa) {
                                                        n(this.fs);
                                                        if (this.tj != null) {
                                                            fs();
                                                        }
                                                    }
                                                }
                                            } else {
                                                n(this.fs);
                                                if (this.tj != null) {
                                                    fs();
                                                }
                                            }
                                            com.byazt.ta.w.n(this.tj);
                                            r5 = r8;
                                            this.ln = System.nanoTime() - j2;
                                            nVar2 = this.a;
                                            downloadInfo2 = this.s;
                                            str2 = this.q;
                                            rvVar4 = this.w;
                                            z4 = this.d;
                                            z3 = this.oa;
                                            r4 = r5;
                                            com.byazt.g.n.n(nVar2, downloadInfo2, str2, rvVar4, z4, z3, this.cp, this.k - this.cy, this.ln, r4, this.t, this.ur, this.bb, null);
                                        }
                                        com.byazt.fe.n.n();
                                        com.byazt.ta.w.n(th, "ResponseHandler");
                                        rvVar = this.w;
                                        if (rvVar != null) {
                                            rvVar.q();
                                        }
                                        if (qgVarN != null) {
                                            qgVarN.qg();
                                        }
                                        if (this.um) {
                                            synchronized (this.sz) {
                                                if (!this.oa) {
                                                    n(this.fs);
                                                    if (this.tj != null) {
                                                        fs();
                                                    }
                                                }
                                            }
                                        } else {
                                            n(this.fs);
                                            if (this.tj != null) {
                                                fs();
                                            }
                                        }
                                        com.byazt.ta.w.n(this.tj);
                                        this.ln = System.nanoTime() - j2;
                                        nVar = this.a;
                                        downloadInfo = this.s;
                                        str = this.q;
                                        rvVar2 = this.w;
                                        z = this.d;
                                        z2 = this.oa;
                                        baseException = this.cp;
                                        j3 = this.k - this.cy;
                                        r7 = r8;
                                        com.byazt.g.n.n(nVar, downloadInfo, str, rvVar2, z, z2, baseException, j3, this.ln, r7, this.t, this.ur, this.bb, null);
                                        if (this.s.isIgnoreDataVerify()) {
                                            return;
                                        }
                                        j4 = this.k - this.cy;
                                        if (j4 < 0) {
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                com.byazt.g.n.n(nVar2, downloadInfo2, str2, rvVar4, z4, z3, this.cp, this.k - this.cy, this.ln, r4, this.t, this.ur, this.bb, null);
                            }
                            com.byazt.m.rv rvVar6 = this.w;
                            if (rvVar6 != null) {
                                rvVar6.q();
                            }
                            if (qgVar != null) {
                                qgVar.qg();
                            }
                            try {
                                if (this.um) {
                                    synchronized (this.sz) {
                                        if (!this.oa) {
                                            n(this.fs);
                                            if (this.tj != null) {
                                                fs();
                                            }
                                        }
                                    }
                                } else {
                                    n(this.fs);
                                    if (this.tj != null) {
                                        fs();
                                    }
                                }
                                com.byazt.ta.w.n(this.tj);
                                this.ln = System.nanoTime() - j2;
                                nVar = this.a;
                                downloadInfo = this.s;
                                str = this.q;
                                rvVar2 = this.w;
                                z = this.d;
                                z2 = this.oa;
                                baseException = this.cp;
                                j3 = this.k - this.cy;
                                r7 = z5;
                            } catch (Throwable th11) {
                                com.byazt.ta.w.n(this.tj);
                                throw th11;
                            }
                        } catch (BaseException e9) {
                            e = e9;
                            j2 = jNanoTime;
                            r6 = z6;
                        } catch (Throwable th12) {
                            th = th12;
                            j = jD;
                            j2 = jNanoTime;
                            r8 = z6;
                        }
                        com.byazt.g.n.n(nVar, downloadInfo, str, rvVar2, z, z2, baseException, j3, this.ln, r7, this.t, this.ur, this.bb, null);
                        if (this.s.isIgnoreDataVerify()) {
                            return;
                        }
                        j4 = this.k - this.cy;
                        if (j4 < 0 && this.cd >= 0 && this.cd != j4) {
                            throw new BaseException(1051, String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", Long.valueOf(j4), Long.valueOf(jN), Long.valueOf(this.cd), Long.valueOf(j), Long.valueOf(this.hd), Long.valueOf(this.k), Long.valueOf(this.cy)));
                        }
                        return;
                    } catch (IOException e10) {
                        throw new BaseException(1054, e10);
                    }
                } catch (Throwable th13) {
                    com.byazt.m.rv rvVar7 = this.w;
                    if (rvVar7 != null) {
                        rvVar7.q();
                    }
                    if (qgVarN != null) {
                        qgVarN.qg();
                    }
                    try {
                        if (this.um) {
                            synchronized (this.sz) {
                                if (!this.oa) {
                                    n(this.fs);
                                    if (this.tj != null) {
                                        fs();
                                    }
                                }
                            }
                        } else {
                            n(this.fs);
                            if (this.tj != null) {
                                fs();
                            }
                        }
                        com.byazt.ta.w.n(this.tj);
                        this.ln = System.nanoTime() - j2;
                        com.byazt.g.n.n(this.a, this.s, this.q, this.w, this.d, this.oa, this.cp, this.k - this.cy, this.ln, r8, this.t, this.ur, this.bb, null);
                        throw th13;
                    } catch (Throwable th14) {
                        com.byazt.ta.w.n(this.tj);
                        throw th14;
                    }
                }
            } catch (BaseException e11) {
                e = e11;
                qgVarN = null;
                r6 = r9;
            } catch (Throwable th15) {
                th = th15;
                qgVarN = null;
                r8 = r10;
                com.byazt.fe.n.q(qg, "handleResponse: e = ".concat(String.valueOf(th)));
                if (w()) {
                    rvVar3 = this.w;
                    if (rvVar3 != null) {
                        rvVar3.q();
                    }
                    if (qgVarN != null) {
                        qgVarN.qg();
                    }
                    if (this.um) {
                        synchronized (this.sz) {
                            if (!this.oa) {
                                n(this.fs);
                                if (this.tj != null) {
                                    fs();
                                }
                            }
                        }
                    } else {
                        n(this.fs);
                        if (this.tj != null) {
                            fs();
                        }
                    }
                    com.byazt.ta.w.n(this.tj);
                    r5 = r8;
                    this.ln = System.nanoTime() - j2;
                    nVar2 = this.a;
                    downloadInfo2 = this.s;
                    str2 = this.q;
                    rvVar4 = this.w;
                    z4 = this.d;
                    z3 = this.oa;
                    r4 = r5;
                    com.byazt.g.n.n(nVar2, downloadInfo2, str2, rvVar4, z4, z3, this.cp, this.k - this.cy, this.ln, r4, this.t, this.ur, this.bb, null);
                }
                com.byazt.fe.n.n();
                com.byazt.ta.w.n(th, "ResponseHandler");
                rvVar = this.w;
                if (rvVar != null) {
                    rvVar.q();
                }
                if (qgVarN != null) {
                    qgVarN.qg();
                }
                if (this.um) {
                    synchronized (this.sz) {
                        if (!this.oa) {
                            n(this.fs);
                            if (this.tj != null) {
                                fs();
                            }
                        }
                    }
                } else {
                    n(this.fs);
                    if (this.tj != null) {
                        fs();
                    }
                }
                com.byazt.ta.w.n(this.tj);
                this.ln = System.nanoTime() - j2;
                nVar = this.a;
                downloadInfo = this.s;
                str = this.q;
                rvVar2 = this.w;
                z = this.d;
                z2 = this.oa;
                baseException = this.cp;
                j3 = this.k - this.cy;
                r7 = r8;
                com.byazt.g.n.n(nVar, downloadInfo, str, rvVar2, z, z2, baseException, j3, this.ln, r7, this.t, this.ur, this.bb, null);
                if (this.s.isIgnoreDataVerify()) {
                    return;
                }
                j4 = this.k - this.cy;
                if (j4 < 0) {
                    return;
                } else {
                    return;
                }
            }
        } catch (BaseException e12) {
            e = e12;
            j2 = jNanoTime;
            r9 = z6 ? 1 : 0;
            qgVarN = null;
            r6 = r9;
        } catch (Throwable th16) {
            th = th16;
            j = jD;
            j2 = jNanoTime;
            r10 = z6 ? 1 : 0;
            qgVarN = null;
            r8 = r10;
            com.byazt.fe.n.q(qg, "handleResponse: e = ".concat(String.valueOf(th)));
            if (w()) {
                rvVar3 = this.w;
                if (rvVar3 != null) {
                    rvVar3.q();
                }
                if (qgVarN != null) {
                    qgVarN.qg();
                }
                if (this.um) {
                    synchronized (this.sz) {
                        if (!this.oa) {
                            n(this.fs);
                            if (this.tj != null) {
                                fs();
                            }
                        }
                    }
                } else {
                    n(this.fs);
                    if (this.tj != null) {
                        fs();
                    }
                }
                com.byazt.ta.w.n(this.tj);
                r5 = r8;
                this.ln = System.nanoTime() - j2;
                nVar2 = this.a;
                downloadInfo2 = this.s;
                str2 = this.q;
                rvVar4 = this.w;
                z4 = this.d;
                z3 = this.oa;
                r4 = r5;
                com.byazt.g.n.n(nVar2, downloadInfo2, str2, rvVar4, z4, z3, this.cp, this.k - this.cy, this.ln, r4, this.t, this.ur, this.bb, null);
            }
            com.byazt.fe.n.n();
            com.byazt.ta.w.n(th, "ResponseHandler");
            rvVar = this.w;
            if (rvVar != null) {
                rvVar.q();
            }
            if (qgVarN != null) {
                qgVarN.qg();
            }
            if (this.um) {
                synchronized (this.sz) {
                    if (!this.oa) {
                        n(this.fs);
                        if (this.tj != null) {
                            fs();
                        }
                    }
                }
            } else {
                n(this.fs);
                if (this.tj != null) {
                    fs();
                }
            }
            com.byazt.ta.w.n(this.tj);
            this.ln = System.nanoTime() - j2;
            nVar = this.a;
            downloadInfo = this.s;
            str = this.q;
            rvVar2 = this.w;
            z = this.d;
            z2 = this.oa;
            baseException = this.cp;
            j3 = this.k - this.cy;
            r7 = r8;
            com.byazt.g.n.n(nVar, downloadInfo, str, rvVar2, z, z2, baseException, j3, this.ln, r7, this.t, this.ur, this.bb, null);
            if (this.s.isIgnoreDataVerify()) {
                return;
            }
            j4 = this.k - this.cy;
            if (j4 < 0) {
                return;
            } else {
                return;
            }
        }
        com.byazt.fe.n.q(qg, "handleResponse: BaseException e = ".concat(String.valueOf(e)));
        if (this.a.n("ignore_base_ex_on_stop_status") || !w()) {
            com.byazt.fe.n.n();
            this.cp = e;
            throw e;
        }
        com.byazt.m.rv rvVar8 = this.w;
        if (rvVar8 != null) {
            rvVar8.q();
        }
        if (qgVarN != null) {
            qgVarN.qg();
        }
        try {
            if (this.um) {
                synchronized (this.sz) {
                    if (!this.oa) {
                        n(this.fs);
                        if (this.tj != null) {
                            fs();
                        }
                    }
                }
            } else {
                n(this.fs);
                if (this.tj != null) {
                    fs();
                }
            }
            com.byazt.ta.w.n(this.tj);
            r5 = r6;
            this.ln = System.nanoTime() - j2;
            nVar2 = this.a;
            downloadInfo2 = this.s;
            str2 = this.q;
            rvVar4 = this.w;
            z4 = this.d;
            z3 = this.oa;
            r4 = r5;
            com.byazt.g.n.n(nVar2, downloadInfo2, str2, rvVar4, z4, z3, this.cp, this.k - this.cy, this.ln, r4, this.t, this.ur, this.bb, null);
        } catch (Throwable th17) {
            com.byazt.ta.w.n(this.tj);
            throw th17;
        }
    }

    private com.byazt.x.qg n(InputStream inputStream) {
        int iAe = s.ae();
        if (this.a.n("rw_concurrent", 0) == 1 && this.s.getChunkCount() == 1 && this.s.getTotalBytes() > 20971520) {
            try {
                com.byazt.x.n nVar = new com.byazt.x.n(inputStream, iAe, this.a.n("rw_concurrent_max_buffer_count", 4));
                this.h = true;
                return nVar;
            } catch (Throwable unused) {
            }
        }
        com.byazt.x.s sVar = new com.byazt.x.s(inputStream, iAe);
        this.h = false;
        return sVar;
    }

    private void n(boolean z) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.v;
        if (this.ou) {
            if (j <= (this.py.qg() ? this.wm : this.m)) {
                return;
            }
        } else {
            long j2 = this.k - this.lh;
            if (!z && !qg(j2, j)) {
                return;
            }
        }
        fs();
        this.v = jUptimeMillis;
    }

    public long l() {
        return this.lh;
    }

    private void fs() {
        boolean z;
        long jNanoTime = this.hu ? System.nanoTime() : 0L;
        try {
            this.tj.n();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.s.updateRealDownloadTime(true);
            boolean z2 = this.s.getChunkCount() > 1;
            oa oaVarN = com.byazt.i.d.n(com.byazt.ta.w.qg());
            if (z2) {
                n(this.rv);
                if (oaVarN != null) {
                    oaVarN.s(this.s);
                } else {
                    this.rv.n(this.s.getId(), this.s.getCurBytes());
                }
            } else if (oaVarN != null) {
                oaVarN.s(this.s);
            } else {
                this.rv.n(this.l.cp(), this.k);
            }
            this.lh = this.k;
        }
        if (this.hu) {
            this.bb += System.nanoTime() - jNanoTime;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0091  */
    private void n(tj tjVar) {
        oa oaVarN;
        com.byazt.wm.qg qgVarL;
        boolean z;
        if (tjVar == null) {
            return;
        }
        boolean z2 = tjVar instanceof com.byazt.u.l;
        if (z2) {
            oaVarN = com.byazt.i.d.n(com.byazt.ta.w.qg());
            if (oaVarN == null) {
                return;
            }
        } else {
            oaVarN = null;
        }
        oa oaVar = oaVarN;
        if (this.l.q()) {
            qgVarL = this.l.l();
        } else {
            qgVarL = this.l;
        }
        com.byazt.wm.qg qgVar = qgVarL;
        if (qgVar != null) {
            qgVar.qg(this.k);
            if (z2 && oaVar != null) {
                oaVar.n(qgVar.cp(), qgVar.um(), qgVar.qg(), this.k);
            } else {
                tjVar.n(qgVar.cp(), qgVar.um(), qgVar.qg(), this.k);
            }
            if (qgVar.fs()) {
                if (qgVar.rv()) {
                    long jTj = qgVar.tj();
                    if (jTj > this.k) {
                        if (z2 && oaVar != null) {
                            oaVar.n(qgVar.cp(), qgVar.qg(), jTj);
                        } else {
                            tjVar.n(qgVar.cp(), qgVar.qg(), jTj);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
                if (z2 && oaVar != null) {
                    oaVar.n(qgVar.cp(), qgVar.qg(), this.k);
                    return;
                } else {
                    tjVar.n(qgVar.cp(), qgVar.qg(), this.k);
                    return;
                }
            }
            return;
        }
        if (this.l.q()) {
            if (z2 && oaVar != null) {
                oaVar.n(this.l.cp(), this.l.um(), this.k);
            } else {
                tjVar.n(this.l.cp(), this.l.um(), this.k);
            }
        }
    }
}
