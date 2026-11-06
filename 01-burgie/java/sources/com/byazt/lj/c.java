package com.byazt.lj;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.auw.DownloadInfo;
import com.byazt.lhc.BaseException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static String hw = "ResponseHandler";
    public final com.byazt.ew.pr a;
    public a aj;
    public boolean b;
    public final com.byazt.auw.hw c;
    public final com.byazt.wel.pr cz;
    public final long fo;
    public vk fw;
    public final com.byazt.gi.uc g;
    public long gz;
    public final DownloadInfo hn;
    public long ho;
    public long iu;
    public volatile boolean k;
    public volatile long lb;
    public volatile boolean m;
    public long nl;
    public long nt;
    public final boolean ny;
    public final boolean qa;
    public final long rc;
    public final com.byazt.edb.aj uc;
    public long ve;
    public com.byazt.auw.c vk;
    public BaseException w;
    public final String x;
    public volatile long yb;
    public final boolean z;
    public com.byazt.ts.w zo;
    public boolean pr = false;
    public volatile long y = 0;
    public volatile long ww = 0;

    public c(DownloadInfo downloadInfo, String str, com.byazt.edb.aj ajVar, com.byazt.auw.hw hwVar, com.byazt.gi.uc ucVar) {
        this.hn = downloadInfo;
        this.x = str;
        vk vkVarZ = hn.z();
        this.fw = vkVarZ;
        if (vkVarZ instanceof com.byazt.ts.x) {
            com.byazt.ts.x xVar = (com.byazt.ts.x) vkVarZ;
            this.zo = xVar.pr();
            this.aj = xVar.uc();
        }
        this.uc = ajVar;
        this.c = hwVar;
        this.g = ucVar;
        long jG = hwVar.g();
        this.ho = jG;
        this.nt = jG;
        if (hwVar.x()) {
            this.lb = hwVar.yb();
        } else {
            this.lb = hwVar.hn(false);
        }
        this.yb = hwVar.nt();
        this.cz = com.byazt.wel.pr.pr();
        com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(downloadInfo.getId());
        this.a = prVarPr;
        boolean z = prVarPr.pr("sync_strategy", 0) == 1;
        this.ny = z;
        if (z) {
            long jPr = prVarPr.pr("sync_interval_ms_fg", 5000);
            long jPr2 = prVarPr.pr("sync_interval_ms_bg", 1000);
            this.fo = Math.max(jPr, 500L);
            this.rc = Math.max(jPr2, 500L);
        } else {
            this.fo = 0L;
            this.rc = 0L;
        }
        this.z = prVarPr.hw("monitor_rw") == 1;
        this.qa = com.byazt.tuy.pr.pr(65536);
    }

    public long pr() {
        return this.ho;
    }

    private boolean uc() {
        return this.k || this.m;
    }

    public void hw() {
        if (this.k) {
            return;
        }
        this.k = true;
        fw();
    }

    public void hn() {
        if (this.m) {
            return;
        }
        synchronized (this.g) {
            this.m = true;
        }
        fw();
    }

    private void fw() {
        ExecutorService executorServiceK;
        if (this.uc != null && (executorServiceK = hn.k()) != null) {
            executorServiceK.execute(new Runnable() { // from class: com.byazt.lj.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.this.uc.x();
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }

    public void pr(long j, long j2, long j3) {
        this.ho = j;
        this.nt = j;
        this.yb = j2;
        this.lb = j3;
    }

    public void pr(long j, long j2) {
        this.yb = j;
        this.lb = j2;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01c5 A[Catch: all -> 0x0223, BaseException -> 0x0225, TryCatch #35 {BaseException -> 0x0225, all -> 0x0223, blocks: (B:92:0x0198, B:93:0x01a5, B:100:0x01bd, B:102:0x01c5, B:104:0x01cd, B:106:0x01d5, B:108:0x01dd, B:110:0x01e8, B:114:0x01f0, B:118:0x01fc, B:122:0x0202, B:124:0x0214, B:125:0x0219, B:126:0x021a, B:127:0x021f, B:130:0x0222, B:94:0x01a6, B:96:0x01aa, B:99:0x01bc, B:98:0x01ae), top: B:358:0x0198, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x01cd A[Catch: all -> 0x0223, BaseException -> 0x0225, TryCatch #35 {BaseException -> 0x0225, all -> 0x0223, blocks: (B:92:0x0198, B:93:0x01a5, B:100:0x01bd, B:102:0x01c5, B:104:0x01cd, B:106:0x01d5, B:108:0x01dd, B:110:0x01e8, B:114:0x01f0, B:118:0x01fc, B:122:0x0202, B:124:0x0214, B:125:0x0219, B:126:0x021a, B:127:0x021f, B:130:0x0222, B:94:0x01a6, B:96:0x01aa, B:99:0x01bc, B:98:0x01ae), top: B:358:0x0198, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x0304  */
    /* JADX WARN: Code duplicated, block: B:193:0x0308  */
    /* JADX WARN: Code duplicated, block: B:195:0x030d  */
    /* JADX WARN: Code duplicated, block: B:198:0x0314 A[Catch: all -> 0x037a, TryCatch #17 {all -> 0x037a, blocks: (B:196:0x0310, B:198:0x0314, B:199:0x0316, B:209:0x032b, B:210:0x032c, B:212:0x0335, B:200:0x0317, B:202:0x031b, B:204:0x0324, B:205:0x0327), top: B:343:0x0310, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x031b A[Catch: all -> 0x0329, TryCatch #9 {, blocks: (B:200:0x0317, B:202:0x031b, B:204:0x0324, B:205:0x0327), top: B:334:0x0317, outer: #17 }] */
    /* JADX WARN: Code duplicated, block: B:204:0x0324 A[Catch: all -> 0x0329, TryCatch #9 {, blocks: (B:200:0x0317, B:202:0x031b, B:204:0x0324, B:205:0x0327), top: B:334:0x0317, outer: #17 }] */
    /* JADX WARN: Code duplicated, block: B:210:0x032c A[Catch: all -> 0x037a, TryCatch #17 {all -> 0x037a, blocks: (B:196:0x0310, B:198:0x0314, B:199:0x0316, B:209:0x032b, B:210:0x032c, B:212:0x0335, B:200:0x0317, B:202:0x031b, B:204:0x0324, B:205:0x0327), top: B:343:0x0310, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x0335 A[Catch: all -> 0x037a, TRY_LEAVE, TryCatch #17 {all -> 0x037a, blocks: (B:196:0x0310, B:198:0x0314, B:199:0x0316, B:209:0x032b, B:210:0x032c, B:212:0x0335, B:200:0x0317, B:202:0x031b, B:204:0x0324, B:205:0x0327), top: B:343:0x0310, inners: #9 }] */
    /* JADX WARN: Code duplicated, block: B:218:0x0387 A[Catch: all -> 0x0530, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x0530, blocks: (B:189:0x02ef, B:218:0x0387, B:219:0x038a, B:260:0x0480, B:261:0x0482, B:265:0x0488, B:267:0x04a1, B:296:0x052a, B:297:0x052f), top: B:338:0x0029, inners: #18 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x0394  */
    /* JADX WARN: Code duplicated, block: B:224:0x0399  */
    /* JADX WARN: Code duplicated, block: B:227:0x03a0 A[Catch: all -> 0x0472, TryCatch #13 {all -> 0x0472, blocks: (B:225:0x039c, B:227:0x03a0, B:228:0x03a2, B:238:0x03b7, B:239:0x03b8, B:241:0x03c1, B:229:0x03a3, B:231:0x03a7, B:233:0x03b0, B:234:0x03b3), top: B:339:0x039c, inners: #15 }] */
    /* JADX WARN: Code duplicated, block: B:231:0x03a7 A[Catch: all -> 0x03b5, TryCatch #15 {, blocks: (B:229:0x03a3, B:231:0x03a7, B:233:0x03b0, B:234:0x03b3), top: B:340:0x03a3, outer: #13 }] */
    /* JADX WARN: Code duplicated, block: B:233:0x03b0 A[Catch: all -> 0x03b5, TryCatch #15 {, blocks: (B:229:0x03a3, B:231:0x03a7, B:233:0x03b0, B:234:0x03b3), top: B:340:0x03a3, outer: #13 }] */
    /* JADX WARN: Code duplicated, block: B:239:0x03b8 A[Catch: all -> 0x0472, TryCatch #13 {all -> 0x0472, blocks: (B:225:0x039c, B:227:0x03a0, B:228:0x03a2, B:238:0x03b7, B:239:0x03b8, B:241:0x03c1, B:229:0x03a3, B:231:0x03a7, B:233:0x03b0, B:234:0x03b3), top: B:339:0x039c, inners: #15 }] */
    /* JADX WARN: Code duplicated, block: B:241:0x03c1 A[Catch: all -> 0x0472, TRY_LEAVE, TryCatch #13 {all -> 0x0472, blocks: (B:225:0x039c, B:227:0x03a0, B:228:0x03a2, B:238:0x03b7, B:239:0x03b8, B:241:0x03c1, B:229:0x03a3, B:231:0x03a7, B:233:0x03b0, B:234:0x03b3), top: B:339:0x039c, inners: #15 }] */
    /* JADX WARN: Code duplicated, block: B:245:0x040e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:246:0x040f  */
    /* JADX WARN: Code duplicated, block: B:248:0x041a  */
    /* JADX WARN: Code duplicated, block: B:255:0x0471 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:329:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:334:0x0317 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:340:0x03a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:373:0x0231 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:374:0x021a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:375:0x0214 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x011e A[Catch: all -> 0x010c, BaseException -> 0x0113, TRY_ENTER, TRY_LEAVE, TryCatch #31 {BaseException -> 0x0113, all -> 0x010c, blocks: (B:47:0x0107, B:55:0x011e), top: B:364:0x0107 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x012e A[Catch: all -> 0x02a5, BaseException -> 0x02ac, TRY_LEAVE, TryCatch #34 {BaseException -> 0x02ac, all -> 0x02a5, blocks: (B:53:0x0118, B:56:0x012a, B:58:0x012e), top: B:359:0x0118 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0136  */
    /* JADX WARN: Code duplicated, block: B:80:0x016d  */
    /* JADX WARN: Code duplicated, block: B:82:0x0174 A[Catch: all -> 0x017b, BaseException -> 0x017f, TRY_LEAVE, TryCatch #29 {BaseException -> 0x017f, all -> 0x017b, blocks: (B:65:0x013f, B:67:0x0146, B:69:0x0153, B:82:0x0174, B:90:0x018c), top: B:368:0x013f }] */
    /* JADX WARN: Code duplicated, block: B:90:0x018c A[Catch: all -> 0x017b, BaseException -> 0x017f, TRY_ENTER, TRY_LEAVE, TryCatch #29 {BaseException -> 0x017f, all -> 0x017b, blocks: (B:65:0x013f, B:67:0x0146, B:69:0x0153, B:82:0x0174, B:90:0x018c), top: B:368:0x013f }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01ae A[Catch: all -> 0x0220, TryCatch #0 {, blocks: (B:94:0x01a6, B:96:0x01aa, B:99:0x01bc, B:98:0x01ae), top: B:329:0x01a6, outer: #35 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
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
    /* JADX WARN: Type inference failed for: r4v7 */
    public void x() throws BaseException {
        long j;
        long j2;
        int iPr;
        com.byazt.sy.hw hwVarPr;
        com.byazt.edb.aj ajVar;
        com.byazt.ew.pr prVar;
        DownloadInfo downloadInfo;
        String str;
        com.byazt.edb.aj ajVar2;
        boolean z;
        boolean z2;
        BaseException baseException;
        long j3;
        com.byazt.edb.aj ajVar3;
        ?? r4;
        ?? r5;
        long j4;
        boolean z3;
        com.byazt.stx.pr prVarPr;
        int i;
        com.byazt.sy.hw hwVar;
        com.byazt.sy.hw hwVar2;
        long j5;
        if (uc() || this.c == null) {
            return;
        }
        long jPr = com.byazt.tuy.uc.pr(this.uc);
        ?? r6 = 0;
        if (jPr == 0) {
            throw new com.byazt.lhc.uc(1004, "the content-length is 0");
        }
        long jK = this.c.k();
        long jNanoTime = System.nanoTime();
        boolean z4 = this.z;
        int i2 = 1;
        try {
            try {
                DownloadInfo downloadInfo2 = this.hn;
                String tempPath = downloadInfo2.getTempPath();
                String tempName = this.hn.getTempName();
                int i3 = -1;
                iPr = this.a.pr("flush_buffer_size_byte", -1);
                com.byazt.auw.c cVarPr = com.byazt.tuy.uc.pr(downloadInfo2, tempPath, tempName, iPr);
                this.vk = cVarPr;
                try {
                    try {
                        cVarPr.pr(this.ho);
                        InputStream inputStreamPr = this.uc.pr();
                        if (inputStreamPr == null) {
                            throw new BaseException(1042, new IOException("inputStream is null"));
                        }
                        this.hn.updateRealStartDownloadTime();
                        hwVarPr = pr(inputStreamPr);
                        try {
                            this.hn.setIsRwConcurrent(this.b);
                            this.pr = this.hn.getOpenLimitSpeed();
                            long j6 = com.byazt.mrs.c.x;
                            long j7 = com.byazt.mrs.c.c;
                            long j8 = j6 / (1000 / j7);
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            long jNanoTime2 = 0;
                            long j9 = 0;
                            z4 = z4;
                            try {
                                while (true) {
                                    if (uc()) {
                                        com.byazt.edb.aj ajVar4 = this.uc;
                                        if (ajVar4 != null) {
                                            ajVar4.x();
                                        }
                                        if (hwVarPr != null) {
                                            hwVarPr.hw();
                                        }
                                        try {
                                            if (this.qa) {
                                                synchronized (this.g) {
                                                    if (!this.m) {
                                                        pr(this.zo);
                                                        if (this.vk != null) {
                                                            zo();
                                                        }
                                                    }
                                                }
                                            } else {
                                                pr(this.zo);
                                                if (this.vk != null) {
                                                    zo();
                                                }
                                            }
                                            Closeable[] closeableArr = new Closeable[i2];
                                            closeableArr[0] = this.vk;
                                            com.byazt.tuy.uc.pr(closeableArr);
                                            this.nl = System.nanoTime() - jNanoTime;
                                            com.byazt.cha.pr.pr(this.a, this.hn, this.x, this.uc, this.k, this.m, this.w, this.ho - this.nt, this.nl, z4 ? 1 : 0, this.iu, this.ve, this.gz, null);
                                            return;
                                        } catch (Throwable th) {
                                            Closeable[] closeableArr2 = new Closeable[i2];
                                            closeableArr2[0] = this.vk;
                                            com.byazt.tuy.uc.pr(closeableArr2);
                                            throw th;
                                        }
                                    }
                                    z3 = z4 ? 1 : 0;
                                    if (!z3) {
                                        prVarPr = hwVarPr.pr();
                                        if (z3) {
                                            this.iu += System.nanoTime() - jNanoTime2;
                                        }
                                        i = prVarPr.hn;
                                        if (i != i3) {
                                            j = jK;
                                            j2 = jNanoTime;
                                            hwVar = hwVarPr;
                                            break;
                                        }
                                        if (this.hn.isIgnoreDataVerify()) {
                                            j = jK;
                                            j2 = jNanoTime;
                                            hwVar2 = hwVarPr;
                                        } else {
                                            j = jK;
                                            j2 = jNanoTime;
                                            hwVar2 = hwVarPr;
                                            if (this.lb > this.ho - this.nt) {
                                                i = (int) (this.lb - (this.ho - this.nt));
                                            }
                                        }
                                        if (z3) {
                                            jNanoTime2 = System.nanoTime();
                                        }
                                        this.vk.pr(prVarPr.pr, 0, i);
                                        if (z3) {
                                            this.ve += System.nanoTime() - jNanoTime2;
                                        }
                                        hwVar = hwVar2;
                                        hwVar.pr(prVarPr);
                                        j5 = i;
                                        this.ho += j5;
                                        j9 += j5;
                                        synchronized (this.g) {
                                            if (this.qa) {
                                                boolean zHw = this.g.hw(j5);
                                                pr(this.zo);
                                                pr(zHw);
                                            } else {
                                                boolean zHw2 = this.g.hw(j5);
                                                pr(this.zo);
                                                pr(zHw2);
                                            }
                                            if (this.hn.isDownloadWithWifiValid()) {
                                                throw new com.byazt.lhc.hn();
                                            }
                                            if (this.hn.isPauseReserveWithWifiValid()) {
                                                throw new com.byazt.lhc.c();
                                            }
                                            if (this.hn.isIgnoreDataVerify()) {
                                            }
                                            if (!this.pr) {
                                            }
                                            z4 = z3;
                                            hwVarPr = hwVar;
                                            jNanoTime = j2;
                                            jK = j;
                                            i3 = -1;
                                            i2 = 1;
                                        }
                                    } else {
                                        try {
                                            jNanoTime2 = System.nanoTime();
                                            try {
                                                prVarPr = hwVarPr.pr();
                                                if (z3) {
                                                    this.iu += System.nanoTime() - jNanoTime2;
                                                }
                                                i = prVarPr.hn;
                                                if (i != i3) {
                                                    j = jK;
                                                    j2 = jNanoTime;
                                                    hwVar = hwVarPr;
                                                    break;
                                                }
                                                if (this.hn.isIgnoreDataVerify()) {
                                                    j = jK;
                                                    try {
                                                        j2 = jNanoTime;
                                                        try {
                                                            hwVar2 = hwVarPr;
                                                            try {
                                                                if (this.lb > this.ho - this.nt && this.lb < (this.ho - this.nt) + ((long) i)) {
                                                                    i = (int) (this.lb - (this.ho - this.nt));
                                                                }
                                                            } catch (BaseException e) {
                                                                e = e;
                                                                hwVarPr = hwVar2;
                                                                r4 = z3;
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                hwVarPr = hwVar2;
                                                                r6 = z3;
                                                                com.byazt.p000do.pr.x(hw, "handleResponse: e = ".concat(String.valueOf(th)));
                                                                if (uc()) {
                                                                    ajVar3 = this.uc;
                                                                    if (ajVar3 != null) {
                                                                        ajVar3.x();
                                                                    }
                                                                    if (hwVarPr != null) {
                                                                        hwVarPr.hw();
                                                                    }
                                                                    try {
                                                                        if (this.qa) {
                                                                            synchronized (this.g) {
                                                                                if (!this.m) {
                                                                                    pr(this.zo);
                                                                                    if (this.vk != null) {
                                                                                        zo();
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            pr(this.zo);
                                                                            if (this.vk != null) {
                                                                                zo();
                                                                            }
                                                                        }
                                                                        com.byazt.tuy.uc.pr(this.vk);
                                                                        this.nl = System.nanoTime() - j2;
                                                                        com.byazt.cha.pr.pr(this.a, this.hn, this.x, this.uc, this.k, this.m, this.w, this.ho - this.nt, this.nl, r6, this.iu, this.ve, this.gz, null);
                                                                        return;
                                                                    } catch (Throwable th3) {
                                                                        com.byazt.tuy.uc.pr(this.vk);
                                                                        throw th3;
                                                                    }
                                                                }
                                                                com.byazt.p000do.pr.pr();
                                                                try {
                                                                    com.byazt.tuy.uc.pr(th, "ResponseHandler");
                                                                    ajVar = this.uc;
                                                                    if (ajVar != null) {
                                                                        ajVar.x();
                                                                    }
                                                                    if (hwVarPr != null) {
                                                                        hwVarPr.hw();
                                                                    }
                                                                    try {
                                                                        if (this.qa) {
                                                                            synchronized (this.g) {
                                                                                if (!this.m) {
                                                                                    pr(this.zo);
                                                                                    if (this.vk != null) {
                                                                                        zo();
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            pr(this.zo);
                                                                            if (this.vk != null) {
                                                                                zo();
                                                                            }
                                                                        }
                                                                        com.byazt.tuy.uc.pr(this.vk);
                                                                        this.nl = System.nanoTime() - j2;
                                                                        prVar = this.a;
                                                                        downloadInfo = this.hn;
                                                                        str = this.x;
                                                                        ajVar2 = this.uc;
                                                                        z = this.k;
                                                                        z2 = this.m;
                                                                        baseException = this.w;
                                                                        j3 = this.ho - this.nt;
                                                                        r5 = r6;
                                                                        com.byazt.cha.pr.pr(prVar, downloadInfo, str, ajVar2, z, z2, baseException, j3, this.nl, r5, this.iu, this.ve, this.gz, null);
                                                                        if (this.hn.isIgnoreDataVerify()) {
                                                                            return;
                                                                        }
                                                                        j4 = this.ho - this.nt;
                                                                        if (j4 < 0) {
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } catch (Throwable th4) {
                                                                        com.byazt.tuy.uc.pr(this.vk);
                                                                        throw th4;
                                                                    }
                                                                } catch (BaseException e2) {
                                                                    this.w = e2;
                                                                    throw e2;
                                                                }
                                                            }
                                                        } catch (BaseException e3) {
                                                            e = e3;
                                                            r4 = z3;
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            r6 = z3;
                                                            com.byazt.p000do.pr.x(hw, "handleResponse: e = ".concat(String.valueOf(th)));
                                                            if (uc()) {
                                                                ajVar3 = this.uc;
                                                                if (ajVar3 != null) {
                                                                    ajVar3.x();
                                                                }
                                                                if (hwVarPr != null) {
                                                                    hwVarPr.hw();
                                                                }
                                                                if (this.qa) {
                                                                    synchronized (this.g) {
                                                                        if (!this.m) {
                                                                            pr(this.zo);
                                                                            if (this.vk != null) {
                                                                                zo();
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    pr(this.zo);
                                                                    if (this.vk != null) {
                                                                        zo();
                                                                    }
                                                                }
                                                                com.byazt.tuy.uc.pr(this.vk);
                                                                this.nl = System.nanoTime() - j2;
                                                                com.byazt.cha.pr.pr(this.a, this.hn, this.x, this.uc, this.k, this.m, this.w, this.ho - this.nt, this.nl, r6, this.iu, this.ve, this.gz, null);
                                                                return;
                                                            }
                                                            com.byazt.p000do.pr.pr();
                                                            com.byazt.tuy.uc.pr(th, "ResponseHandler");
                                                            ajVar = this.uc;
                                                            if (ajVar != null) {
                                                                ajVar.x();
                                                            }
                                                            if (hwVarPr != null) {
                                                                hwVarPr.hw();
                                                            }
                                                            if (this.qa) {
                                                                synchronized (this.g) {
                                                                    if (!this.m) {
                                                                        pr(this.zo);
                                                                        if (this.vk != null) {
                                                                            zo();
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                pr(this.zo);
                                                                if (this.vk != null) {
                                                                    zo();
                                                                }
                                                            }
                                                            com.byazt.tuy.uc.pr(this.vk);
                                                            this.nl = System.nanoTime() - j2;
                                                            prVar = this.a;
                                                            downloadInfo = this.hn;
                                                            str = this.x;
                                                            ajVar2 = this.uc;
                                                            z = this.k;
                                                            z2 = this.m;
                                                            baseException = this.w;
                                                            j3 = this.ho - this.nt;
                                                            r5 = r6;
                                                            com.byazt.cha.pr.pr(prVar, downloadInfo, str, ajVar2, z, z2, baseException, j3, this.nl, r5, this.iu, this.ve, this.gz, null);
                                                            if (this.hn.isIgnoreDataVerify()) {
                                                                return;
                                                            }
                                                            j4 = this.ho - this.nt;
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
                                                    j = jK;
                                                    j2 = jNanoTime;
                                                    hwVar2 = hwVarPr;
                                                }
                                                if (z3) {
                                                    jNanoTime2 = System.nanoTime();
                                                }
                                                try {
                                                    this.vk.pr(prVarPr.pr, 0, i);
                                                    if (z3) {
                                                        this.ve += System.nanoTime() - jNanoTime2;
                                                    }
                                                    hwVar = hwVar2;
                                                    try {
                                                        hwVar.pr(prVarPr);
                                                        j5 = i;
                                                        this.ho += j5;
                                                        j9 += j5;
                                                        synchronized (this.g) {
                                                            if (this.qa || !this.m) {
                                                                boolean zHw3 = this.g.hw(j5);
                                                                pr(this.zo);
                                                                pr(zHw3);
                                                            }
                                                        }
                                                        if (this.hn.isDownloadWithWifiValid()) {
                                                            throw new com.byazt.lhc.hn();
                                                        }
                                                        if (this.hn.isPauseReserveWithWifiValid()) {
                                                            throw new com.byazt.lhc.c();
                                                        }
                                                        if (this.hn.isIgnoreDataVerify() && this.lb >= 0 && this.lb <= this.ho - this.nt) {
                                                            break;
                                                        }
                                                        if (!this.pr && j9 > j8) {
                                                            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                                            if (jCurrentTimeMillis2 < j7) {
                                                                try {
                                                                    Thread.sleep(j7 - jCurrentTimeMillis2);
                                                                } catch (InterruptedException e5) {
                                                                }
                                                            }
                                                            jCurrentTimeMillis = System.currentTimeMillis();
                                                            j9 = 0;
                                                        }
                                                        z4 = z3;
                                                        hwVarPr = hwVar;
                                                        jNanoTime = j2;
                                                        jK = j;
                                                        i3 = -1;
                                                        i2 = 1;
                                                    } catch (BaseException e6) {
                                                        e = e6;
                                                        hwVarPr = hwVar;
                                                        r4 = z3;
                                                        com.byazt.p000do.pr.x(hw, "handleResponse: BaseException e = ".concat(String.valueOf(e)));
                                                        if (this.a.pr("ignore_base_ex_on_stop_status")) {
                                                        }
                                                        com.byazt.p000do.pr.pr();
                                                        this.w = e;
                                                        throw e;
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        hwVarPr = hwVar;
                                                        r6 = z3;
                                                        com.byazt.p000do.pr.x(hw, "handleResponse: e = ".concat(String.valueOf(th)));
                                                        if (uc()) {
                                                            ajVar3 = this.uc;
                                                            if (ajVar3 != null) {
                                                                ajVar3.x();
                                                            }
                                                            if (hwVarPr != null) {
                                                                hwVarPr.hw();
                                                            }
                                                            if (this.qa) {
                                                                synchronized (this.g) {
                                                                    if (!this.m) {
                                                                        pr(this.zo);
                                                                        if (this.vk != null) {
                                                                            zo();
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                pr(this.zo);
                                                                if (this.vk != null) {
                                                                    zo();
                                                                }
                                                            }
                                                            com.byazt.tuy.uc.pr(this.vk);
                                                            this.nl = System.nanoTime() - j2;
                                                            com.byazt.cha.pr.pr(this.a, this.hn, this.x, this.uc, this.k, this.m, this.w, this.ho - this.nt, this.nl, r6, this.iu, this.ve, this.gz, null);
                                                            return;
                                                        }
                                                        com.byazt.p000do.pr.pr();
                                                        com.byazt.tuy.uc.pr(th, "ResponseHandler");
                                                        ajVar = this.uc;
                                                        if (ajVar != null) {
                                                            ajVar.x();
                                                        }
                                                        if (hwVarPr != null) {
                                                            hwVarPr.hw();
                                                        }
                                                        if (this.qa) {
                                                            synchronized (this.g) {
                                                                if (!this.m) {
                                                                    pr(this.zo);
                                                                    if (this.vk != null) {
                                                                        zo();
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            pr(this.zo);
                                                            if (this.vk != null) {
                                                                zo();
                                                            }
                                                        }
                                                        com.byazt.tuy.uc.pr(this.vk);
                                                        this.nl = System.nanoTime() - j2;
                                                        prVar = this.a;
                                                        downloadInfo = this.hn;
                                                        str = this.x;
                                                        ajVar2 = this.uc;
                                                        z = this.k;
                                                        z2 = this.m;
                                                        baseException = this.w;
                                                        j3 = this.ho - this.nt;
                                                        r5 = r6;
                                                    }
                                                } catch (BaseException e7) {
                                                    e = e7;
                                                    hwVar = hwVar2;
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    hwVar = hwVar2;
                                                }
                                            } catch (BaseException e8) {
                                                e = e8;
                                                j2 = jNanoTime;
                                                r4 = z3;
                                            } catch (Throwable th9) {
                                                th = th9;
                                                j = jK;
                                                j2 = jNanoTime;
                                                r6 = z3;
                                            }
                                        } catch (BaseException e9) {
                                            e = e9;
                                            j2 = jNanoTime;
                                            r4 = z3;
                                        } catch (Throwable th10) {
                                            th = th10;
                                            j = jK;
                                            j2 = jNanoTime;
                                            r6 = z3;
                                            com.byazt.p000do.pr.x(hw, "handleResponse: e = ".concat(String.valueOf(th)));
                                            if (uc()) {
                                                ajVar3 = this.uc;
                                                if (ajVar3 != null) {
                                                    ajVar3.x();
                                                }
                                                if (hwVarPr != null) {
                                                    hwVarPr.hw();
                                                }
                                                if (this.qa) {
                                                    synchronized (this.g) {
                                                        if (!this.m) {
                                                            pr(this.zo);
                                                            if (this.vk != null) {
                                                                zo();
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    pr(this.zo);
                                                    if (this.vk != null) {
                                                        zo();
                                                    }
                                                }
                                                com.byazt.tuy.uc.pr(this.vk);
                                                this.nl = System.nanoTime() - j2;
                                                com.byazt.cha.pr.pr(this.a, this.hn, this.x, this.uc, this.k, this.m, this.w, this.ho - this.nt, this.nl, r6, this.iu, this.ve, this.gz, null);
                                                return;
                                            }
                                            com.byazt.p000do.pr.pr();
                                            com.byazt.tuy.uc.pr(th, "ResponseHandler");
                                            ajVar = this.uc;
                                            if (ajVar != null) {
                                                ajVar.x();
                                            }
                                            if (hwVarPr != null) {
                                                hwVarPr.hw();
                                            }
                                            if (this.qa) {
                                                synchronized (this.g) {
                                                    if (!this.m) {
                                                        pr(this.zo);
                                                        if (this.vk != null) {
                                                            zo();
                                                        }
                                                    }
                                                }
                                            } else {
                                                pr(this.zo);
                                                if (this.vk != null) {
                                                    zo();
                                                }
                                            }
                                            com.byazt.tuy.uc.pr(this.vk);
                                            this.nl = System.nanoTime() - j2;
                                            prVar = this.a;
                                            downloadInfo = this.hn;
                                            str = this.x;
                                            ajVar2 = this.uc;
                                            z = this.k;
                                            z2 = this.m;
                                            baseException = this.w;
                                            j3 = this.ho - this.nt;
                                            r5 = r6;
                                            com.byazt.cha.pr.pr(prVar, downloadInfo, str, ajVar2, z, z2, baseException, j3, this.nl, r5, this.iu, this.ve, this.gz, null);
                                            if (this.hn.isIgnoreDataVerify()) {
                                                return;
                                            }
                                            j4 = this.ho - this.nt;
                                            if (j4 < 0) {
                                                return;
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    com.byazt.cha.pr.pr(prVar, downloadInfo, str, ajVar2, z, z2, baseException, j3, this.nl, r5, this.iu, this.ve, this.gz, null);
                                    if (this.hn.isIgnoreDataVerify()) {
                                        return;
                                    }
                                    j4 = this.ho - this.nt;
                                    if (j4 < 0 && this.lb >= 0 && this.lb != j4) {
                                        throw new BaseException(1051, String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", Long.valueOf(j4), Long.valueOf(jPr), Long.valueOf(this.lb), Long.valueOf(j), Long.valueOf(this.yb), Long.valueOf(this.ho), Long.valueOf(this.nt)));
                                    }
                                    return;
                                }
                                if (this.qa) {
                                    synchronized (this.g) {
                                        if (!this.m) {
                                            pr(this.zo);
                                            if (this.vk != null) {
                                                zo();
                                            }
                                        }
                                    }
                                } else {
                                    pr(this.zo);
                                    if (this.vk != null) {
                                        zo();
                                    }
                                }
                                com.byazt.tuy.uc.pr(this.vk);
                                this.nl = System.nanoTime() - j2;
                                prVar = this.a;
                                downloadInfo = this.hn;
                                str = this.x;
                                ajVar2 = this.uc;
                                z = this.k;
                                z2 = this.m;
                                baseException = this.w;
                                j3 = this.ho - this.nt;
                                r5 = z3;
                            } catch (Throwable th11) {
                                com.byazt.tuy.uc.pr(this.vk);
                                throw th11;
                            }
                            com.byazt.edb.aj ajVar5 = this.uc;
                            if (ajVar5 != null) {
                                ajVar5.x();
                            }
                            if (hwVar != null) {
                                hwVar.hw();
                            }
                        } catch (BaseException e10) {
                            e = e10;
                            j2 = jNanoTime;
                            r4 = z4;
                        } catch (Throwable th12) {
                            th = th12;
                            j = jK;
                            j2 = jNanoTime;
                            r6 = z4;
                        }
                        com.byazt.cha.pr.pr(prVar, downloadInfo, str, ajVar2, z, z2, baseException, j3, this.nl, r5, this.iu, this.ve, this.gz, null);
                        if (this.hn.isIgnoreDataVerify()) {
                            return;
                        }
                        j4 = this.ho - this.nt;
                        if (j4 < 0) {
                            return;
                        } else {
                            return;
                        }
                    } catch (IOException e11) {
                        throw new BaseException(1054, e11);
                    }
                } catch (BaseException e12) {
                    e = e12;
                    hwVarPr = null;
                    r4 = iPr;
                } catch (Throwable th13) {
                    th = th13;
                    hwVarPr = null;
                    r6 = iPr;
                    com.byazt.p000do.pr.x(hw, "handleResponse: e = ".concat(String.valueOf(th)));
                    if (uc()) {
                        ajVar3 = this.uc;
                        if (ajVar3 != null) {
                            ajVar3.x();
                        }
                        if (hwVarPr != null) {
                            hwVarPr.hw();
                        }
                        if (this.qa) {
                            synchronized (this.g) {
                                if (!this.m) {
                                    pr(this.zo);
                                    if (this.vk != null) {
                                        zo();
                                    }
                                }
                            }
                        } else {
                            pr(this.zo);
                            if (this.vk != null) {
                                zo();
                            }
                        }
                        com.byazt.tuy.uc.pr(this.vk);
                        this.nl = System.nanoTime() - j2;
                        com.byazt.cha.pr.pr(this.a, this.hn, this.x, this.uc, this.k, this.m, this.w, this.ho - this.nt, this.nl, r6, this.iu, this.ve, this.gz, null);
                        return;
                    }
                    com.byazt.p000do.pr.pr();
                    com.byazt.tuy.uc.pr(th, "ResponseHandler");
                    ajVar = this.uc;
                    if (ajVar != null) {
                        ajVar.x();
                    }
                    if (hwVarPr != null) {
                        hwVarPr.hw();
                    }
                    if (this.qa) {
                        synchronized (this.g) {
                            if (!this.m) {
                                pr(this.zo);
                                if (this.vk != null) {
                                    zo();
                                }
                            }
                        }
                    } else {
                        pr(this.zo);
                        if (this.vk != null) {
                            zo();
                        }
                    }
                    com.byazt.tuy.uc.pr(this.vk);
                    this.nl = System.nanoTime() - j2;
                    prVar = this.a;
                    downloadInfo = this.hn;
                    str = this.x;
                    ajVar2 = this.uc;
                    z = this.k;
                    z2 = this.m;
                    baseException = this.w;
                    j3 = this.ho - this.nt;
                    r5 = r6;
                    com.byazt.cha.pr.pr(prVar, downloadInfo, str, ajVar2, z, z2, baseException, j3, this.nl, r5, this.iu, this.ve, this.gz, null);
                    if (this.hn.isIgnoreDataVerify()) {
                        return;
                    }
                    j4 = this.ho - this.nt;
                    if (j4 < 0) {
                        return;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th14) {
                com.byazt.edb.aj ajVar6 = this.uc;
                if (ajVar6 != null) {
                    ajVar6.x();
                }
                if (hwVarPr != null) {
                    hwVarPr.hw();
                }
                try {
                    if (this.qa) {
                        synchronized (this.g) {
                            if (!this.m) {
                                pr(this.zo);
                                if (this.vk != null) {
                                    zo();
                                }
                            }
                        }
                    } else {
                        pr(this.zo);
                        if (this.vk != null) {
                            zo();
                        }
                    }
                    com.byazt.tuy.uc.pr(this.vk);
                    this.nl = System.nanoTime() - j2;
                    com.byazt.cha.pr.pr(this.a, this.hn, this.x, this.uc, this.k, this.m, this.w, this.ho - this.nt, this.nl, r6, this.iu, this.ve, this.gz, null);
                    throw th14;
                } catch (Throwable th15) {
                    com.byazt.tuy.uc.pr(this.vk);
                    throw th15;
                }
            }
        } catch (BaseException e13) {
            e = e13;
            j2 = jNanoTime;
            iPr = z4 ? 1 : 0;
        } catch (Throwable th16) {
            th = th16;
            j = jK;
            j2 = jNanoTime;
            iPr = z4 ? 1 : 0;
        }
        hwVarPr = null;
        r4 = iPr;
        com.byazt.p000do.pr.x(hw, "handleResponse: BaseException e = ".concat(String.valueOf(e)));
        if (this.a.pr("ignore_base_ex_on_stop_status") || !uc()) {
            com.byazt.p000do.pr.pr();
            this.w = e;
            throw e;
        }
        com.byazt.edb.aj ajVar7 = this.uc;
        if (ajVar7 != null) {
            ajVar7.x();
        }
        if (hwVarPr != null) {
            hwVarPr.hw();
        }
        try {
            if (this.qa) {
                synchronized (this.g) {
                    if (!this.m) {
                        pr(this.zo);
                        if (this.vk != null) {
                            zo();
                        }
                    }
                }
            } else {
                pr(this.zo);
                if (this.vk != null) {
                    zo();
                }
            }
            com.byazt.tuy.uc.pr(this.vk);
            this.nl = System.nanoTime() - j2;
            com.byazt.cha.pr.pr(this.a, this.hn, this.x, this.uc, this.k, this.m, this.w, this.ho - this.nt, this.nl, r4, this.iu, this.ve, this.gz, null);
        } catch (Throwable th17) {
            com.byazt.tuy.uc.pr(this.vk);
            throw th17;
        }
    }

    private com.byazt.sy.hw pr(InputStream inputStream) {
        int iS = hn.s();
        if (this.a.pr("rw_concurrent", 0) == 1 && this.hn.getChunkCount() == 1 && this.hn.getTotalBytes() > 20971520) {
            try {
                com.byazt.sy.pr prVar = new com.byazt.sy.pr(inputStream, iS, this.a.pr("rw_concurrent_max_buffer_count", 4));
                this.b = true;
                return prVar;
            } catch (Throwable th) {
            }
        }
        com.byazt.sy.hn hnVar = new com.byazt.sy.hn(inputStream, iS);
        this.b = false;
        return hnVar;
    }

    private void pr(boolean z) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.ww;
        if (this.ny) {
            if (j <= (this.cz.hw() ? this.fo : this.rc)) {
                return;
            }
        } else {
            long j2 = this.ho - this.y;
            if (!z && !hw(j2, j)) {
                return;
            }
        }
        zo();
        this.ww = jUptimeMillis;
    }

    private boolean hw(long j, long j2) {
        return j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j2 > 500;
    }

    public long c() {
        return this.y;
    }

    private void zo() {
        boolean z;
        long jNanoTime = this.z ? System.nanoTime() : 0L;
        try {
            this.vk.pr();
            z = true;
        } catch (Exception e) {
            z = false;
        }
        if (z) {
            this.hn.updateRealDownloadTime(true);
            boolean z2 = this.hn.getChunkCount() > 1;
            m mVarPr = com.byazt.ts.k.pr(com.byazt.tuy.uc.hw());
            if (z2) {
                pr(this.aj);
                if (mVarPr != null) {
                    mVarPr.hn(this.hn);
                } else {
                    this.aj.pr(this.hn.getId(), this.hn.getCurBytes());
                }
            } else if (mVarPr != null) {
                mVarPr.hn(this.hn);
            } else {
                this.aj.pr(this.c.w(), this.ho);
            }
            this.y = this.ho;
        }
        if (this.z) {
            this.gz += System.nanoTime() - jNanoTime;
        }
    }

    private void pr(vk vkVar) {
        m mVar;
        com.byazt.auw.hw hwVarC;
        if (vkVar == null) {
            return;
        }
        boolean z = vkVar instanceof com.byazt.mef.c;
        if (!z) {
            mVar = null;
        } else {
            m mVarPr = com.byazt.ts.k.pr(com.byazt.tuy.uc.hw());
            if (mVarPr != null) {
                mVar = mVarPr;
            } else {
                return;
            }
        }
        if (this.c.x()) {
            hwVarC = this.c.c();
        } else {
            hwVarC = this.c;
        }
        if (hwVarC != null) {
            hwVarC.hw(this.ho);
            if (!z || mVar == null) {
                vkVar.pr(hwVarC.w(), hwVarC.qa(), hwVarC.hw(), this.ho);
            } else {
                mVar.pr(hwVarC.w(), hwVarC.qa(), hwVarC.hw(), this.ho);
            }
            if (hwVarC.zo()) {
                boolean z2 = false;
                if (hwVarC.aj()) {
                    long jVk = hwVarC.vk();
                    if (jVk > this.ho) {
                        if (z && mVar != null) {
                            mVar.pr(hwVarC.w(), hwVarC.hw(), jVk);
                        } else {
                            vkVar.pr(hwVarC.w(), hwVarC.hw(), jVk);
                        }
                        z2 = true;
                    }
                }
                if (!z2) {
                    if (!z || mVar == null) {
                        vkVar.pr(hwVarC.w(), hwVarC.hw(), this.ho);
                        return;
                    } else {
                        mVar.pr(hwVarC.w(), hwVarC.hw(), this.ho);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (this.c.x()) {
            if (!z || mVar == null) {
                vkVar.pr(this.c.w(), this.c.qa(), this.ho);
            } else {
                mVar.pr(this.c.w(), this.c.qa(), this.ho);
            }
        }
    }
}
