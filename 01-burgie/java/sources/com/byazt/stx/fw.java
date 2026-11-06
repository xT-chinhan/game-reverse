package com.byazt.stx;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.auw.DownloadInfo;
import com.byazt.lhc.BaseException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 62})
public class fw {
    public final com.byazt.ew.pr c;
    public final hn fw;
    public final long g;
    public final DownloadInfo hn;
    public final long ho;
    public final boolean m;
    public final boolean nt;
    public final com.byazt.gi.uc uc;
    public long yb;
    public BaseException zo;
    public final List<k> pr = new LinkedList();
    public final List<k> hw = new ArrayList();
    public volatile boolean aj = false;
    public volatile boolean vk = false;
    public volatile boolean w = false;
    public volatile long lb = 0;
    public volatile long qa = 0;
    public final com.byazt.lj.vk x = com.byazt.lj.hn.z();
    public final com.byazt.wel.pr k = com.byazt.wel.pr.pr();

    public fw(DownloadInfo downloadInfo, com.byazt.gi.uc ucVar, hn hnVar) {
        this.hn = downloadInfo;
        this.uc = ucVar;
        this.fw = hnVar;
        com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(downloadInfo.getId());
        this.c = prVarPr;
        boolean z = prVarPr.pr("sync_strategy", 0) == 1;
        this.m = z;
        if (z) {
            long jPr = prVarPr.pr("sync_interval_ms_fg", 5000);
            long jPr2 = prVarPr.pr("sync_interval_ms_bg", 1000);
            this.g = Math.max(jPr, 500L);
            this.ho = Math.max(jPr2, 500L);
        } else {
            this.g = 0L;
            this.ho = 0L;
        }
        this.nt = prVarPr.hw("monitor_rw") == 1;
    }

    public void pr(k kVar) {
        synchronized (this) {
            this.pr.add(kVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:162:0x0202 A[Catch: all -> 0x03bd, TryCatch #16 {all -> 0x03bd, blocks: (B:160:0x01fe, B:162:0x0202, B:165:0x0208, B:166:0x021a, B:203:0x029a, B:204:0x029c, B:242:0x031d, B:244:0x0327, B:246:0x032b, B:283:0x03a8, B:284:0x03bc), top: B:343:0x002b, inners: #35 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0222  */
    /* JADX WARN: Code duplicated, block: B:184:0x027a  */
    /* JADX WARN: Code duplicated, block: B:186:0x027e  */
    /* JADX WARN: Code duplicated, block: B:198:0x0295 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:206:0x029f  */
    /* JADX WARN: Code duplicated, block: B:222:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:224:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:236:0x0312 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:244:0x0327 A[Catch: all -> 0x03bd, TryCatch #16 {all -> 0x03bd, blocks: (B:160:0x01fe, B:162:0x0202, B:165:0x0208, B:166:0x021a, B:203:0x029a, B:204:0x029c, B:242:0x031d, B:244:0x0327, B:246:0x032b, B:283:0x03a8, B:284:0x03bc), top: B:343:0x002b, inners: #35 }] */
    /* JADX WARN: Code duplicated, block: B:265:0x0389  */
    /* JADX WARN: Code duplicated, block: B:279:0x03a4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:294:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:310:0x042b  */
    /* JADX WARN: Code duplicated, block: B:312:0x042f  */
    /* JADX WARN: Code duplicated, block: B:324:0x0446  */
    /* JADX WARN: Code duplicated, block: B:331:0x0355 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:335:0x02aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:337:0x022d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:344:0x043c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:350:0x03f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:360:0x039a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:362:0x03db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:366:0x028b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:368:0x0308 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:370:0x02c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:372:0x0246 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:399:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:400:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:401:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:402:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [int] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v29 */
    /* JADX WARN: Type inference failed for: r15v30 */
    /* JADX WARN: Type inference failed for: r15v31 */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v33 */
    /* JADX WARN: Type inference failed for: r15v44 */
    /* JADX WARN: Type inference failed for: r15v46 */
    /* JADX WARN: Type inference failed for: r15v47 */
    /* JADX WARN: Type inference failed for: r15v5, types: [int] */
    /* JADX WARN: Type inference failed for: r15v7, types: [int] */
    /* JADX WARN: Type inference failed for: r15v9 */
    public void pr(x xVar) throws BaseException {
        boolean z;
        long j;
        boolean z2;
        long j2;
        boolean z3;
        long jNanoTime;
        Throwable th;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        boolean z4;
        ?? r15;
        Throwable th5;
        boolean z5;
        ?? r16;
        boolean z6;
        boolean z7;
        Throwable th6;
        boolean z8;
        if (this.vk || this.w) {
            return;
        }
        com.byazt.edb.hw.c();
        this.zo = null;
        DownloadInfo downloadInfo = this.hn;
        com.byazt.gi.uc ucVar = this.uc;
        hn hnVar = this.fw;
        long curBytes = downloadInfo.getCurBytes();
        long jNanoTime2 = System.nanoTime();
        boolean z9 = this.nt;
        long jNanoTime3 = 0;
        boolean z10 = true;
        z = true;
        z = true;
        boolean z11 = true;
        z = true;
        z = true;
        boolean z12 = true;
        z = true;
        z = true;
        boolean z13 = true;
        z = true;
        z = true;
        boolean z14 = true;
        z10 = true;
        z10 = true;
        ?? r17 = 0;
        boolean z15 = false;
        ?? r18 = 0;
        ?? r19 = 0;
        r17 = 0;
        try {
            try {
                downloadInfo.updateRealStartDownloadTime();
                long jNanoTime4 = 0;
                jNanoTime = 0;
                long j3 = 0;
                ?? r13 = 0;
                while (true) {
                    if (z9) {
                        try {
                            jNanoTime4 = System.nanoTime();
                        } catch (nt e) {
                            e = e;
                            z8 = z15 ? 1 : 0;
                            jNanoTime = jNanoTime;
                            r18 = r13;
                            z3 = z8;
                            try {
                                this.zo = e;
                                throw e;
                            } catch (Throwable th7) {
                                th = th7;
                                jNanoTime3 = jNanoTime3;
                                j = jNanoTime;
                                r15 = r18;
                                z4 = z3;
                                if (r15 > 0) {
                                    try {
                                        ucVar.hw((long) r15);
                                    } catch (Throwable th8) {
                                    }
                                }
                                if (!this.w) {
                                    try {
                                        hn();
                                    } catch (Throwable th9) {
                                        com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th9)));
                                        th5 = th9;
                                        synchronized (this) {
                                            hn(this.pr);
                                            this.pr.clear();
                                            com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                            if (th5 == null) {
                                                throw th;
                                            }
                                            if (!this.vk) {
                                                z12 = z4;
                                            }
                                            if (z12) {
                                                throw th;
                                            }
                                            try {
                                                com.byazt.tuy.uc.pr(th5, "loopAndWrite_finally");
                                                throw th;
                                            } catch (BaseException e2) {
                                                this.zo = e2;
                                                throw e2;
                                            }
                                        }
                                    }
                                }
                                th5 = null;
                                synchronized (this) {
                                    hn(this.pr);
                                    this.pr.clear();
                                    com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                    if (th5 == null) {
                                        throw th;
                                    }
                                    if (!this.vk) {
                                        z12 = z4;
                                    }
                                    if (z12) {
                                        throw th;
                                    }
                                    com.byazt.tuy.uc.pr(th5, "loopAndWrite_finally");
                                    throw th;
                                }
                            }
                        } catch (BaseException e3) {
                            e = e3;
                            jNanoTime3 = jNanoTime3;
                            j2 = jNanoTime;
                            r19 = r13;
                            z2 = z15;
                            if (this.c.pr("ignore_base_ex_on_stop_status") || !(this.vk || this.w)) {
                                com.byazt.p000do.pr.pr();
                                com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                                this.zo = e;
                                throw e;
                            }
                            if (r19 > 0) {
                                try {
                                    ucVar.hw((long) r19);
                                } catch (Throwable th10) {
                                }
                            }
                            if (!this.w) {
                                try {
                                    hn();
                                } catch (Throwable th11) {
                                    th4 = th11;
                                    com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th4)));
                                    synchronized (this) {
                                        hn(this.pr);
                                        this.pr.clear();
                                    }
                                    com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j2, this.yb, null);
                                    if (th4 != null) {
                                        if (!this.vk && !this.w && this.zo == null) {
                                            z13 = z2;
                                        }
                                        if (z13) {
                                            return;
                                        }
                                        try {
                                            com.byazt.tuy.uc.pr(th4, "loopAndWrite_finally");
                                            return;
                                        } catch (BaseException e4) {
                                            this.zo = e4;
                                            throw e4;
                                        }
                                    }
                                    return;
                                }
                            }
                            th4 = null;
                            synchronized (this) {
                                hn(this.pr);
                                this.pr.clear();
                                com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j2, this.yb, null);
                                if (th4 != null) {
                                    if (!this.vk) {
                                        z13 = z2;
                                    }
                                    if (z13) {
                                        com.byazt.tuy.uc.pr(th4, "loopAndWrite_finally");
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th12) {
                            th = th12;
                            jNanoTime3 = jNanoTime3;
                            j = jNanoTime;
                            r17 = r13;
                            z = z15;
                            if (!this.vk && !this.w) {
                                com.byazt.p000do.pr.pr();
                                com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite:  e = ".concat(String.valueOf(th)));
                                try {
                                    com.byazt.tuy.uc.pr(th, "loopAndWrite");
                                    if (r17 > 0) {
                                        try {
                                            ucVar.hw(r17 == true ? 1L : 0L);
                                        } catch (Throwable th13) {
                                        }
                                    }
                                    if (!this.w) {
                                        try {
                                            hn();
                                        } catch (Throwable th14) {
                                            th3 = th14;
                                            com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th3)));
                                            synchronized (this) {
                                                hn(this.pr);
                                                this.pr.clear();
                                            }
                                            com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                            if (th3 != null) {
                                                if (!this.vk && !this.w && this.zo == null) {
                                                    z14 = z;
                                                }
                                                if (z14) {
                                                    return;
                                                }
                                                try {
                                                    com.byazt.tuy.uc.pr(th3, "loopAndWrite_finally");
                                                    return;
                                                } catch (BaseException e5) {
                                                    this.zo = e5;
                                                    throw e5;
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    th3 = null;
                                    synchronized (this) {
                                        hn(this.pr);
                                        this.pr.clear();
                                        com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                        if (th3 != null) {
                                            if (!this.vk) {
                                                z14 = z;
                                            }
                                            if (z14) {
                                                com.byazt.tuy.uc.pr(th3, "loopAndWrite_finally");
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                } catch (BaseException e6) {
                                    this.zo = e6;
                                    throw e6;
                                }
                            }
                            if (r17 > 0) {
                                try {
                                    ucVar.hw(r17 == true ? 1L : 0L);
                                } catch (Throwable th15) {
                                }
                            }
                            if (!this.w) {
                                try {
                                    hn();
                                } catch (Throwable th16) {
                                    th2 = th16;
                                    com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th2)));
                                    synchronized (this) {
                                        hn(this.pr);
                                        this.pr.clear();
                                    }
                                    com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                    if (th2 != null) {
                                        if (!this.vk && !this.w && this.zo == null) {
                                            z10 = z;
                                        }
                                        if (z10) {
                                            return;
                                        }
                                        try {
                                            com.byazt.tuy.uc.pr(th2, "loopAndWrite_finally");
                                            return;
                                        } catch (BaseException e7) {
                                            this.zo = e7;
                                            throw e7;
                                        }
                                    }
                                    return;
                                }
                            }
                            th2 = null;
                            synchronized (this) {
                                hn(this.pr);
                                this.pr.clear();
                                com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                if (th2 != null) {
                                    if (!this.vk) {
                                        z10 = z;
                                    }
                                    if (z10) {
                                        com.byazt.tuy.uc.pr(th2, "loopAndWrite_finally");
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    try {
                        pr prVarPr = xVar.pr();
                        if (z9) {
                            jNanoTime3 += System.nanoTime() - jNanoTime4;
                        }
                        jNanoTime3 = jNanoTime3;
                        try {
                            int i = prVarPr.hn;
                            if (i == -1) {
                                try {
                                    pr(prVarPr.hw);
                                    hnVar.pr(prVarPr);
                                    jNanoTime3 = jNanoTime3;
                                } catch (nt e8) {
                                    e = e8;
                                    jNanoTime = jNanoTime;
                                    jNanoTime3 = jNanoTime3;
                                    z8 = z15;
                                    r18 = r13;
                                    z3 = z8;
                                    this.zo = e;
                                    throw e;
                                } catch (BaseException e9) {
                                    e = e9;
                                    j2 = jNanoTime;
                                    r19 = r13;
                                    z2 = z15;
                                    if (this.c.pr("ignore_base_ex_on_stop_status")) {
                                    }
                                    com.byazt.p000do.pr.pr();
                                    com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                                    this.zo = e;
                                    throw e;
                                } catch (Throwable th17) {
                                    th = th17;
                                    j = jNanoTime;
                                    r17 = r13;
                                    z = z15;
                                    if (!this.vk) {
                                        com.byazt.p000do.pr.pr();
                                        com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite:  e = ".concat(String.valueOf(th)));
                                        com.byazt.tuy.uc.pr(th, "loopAndWrite");
                                        if (r17 > 0) {
                                            ucVar.hw(r17 == true ? 1L : 0L);
                                        }
                                        if (!this.w) {
                                            hn();
                                        }
                                        th3 = null;
                                        synchronized (this) {
                                            hn(this.pr);
                                            this.pr.clear();
                                            com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                            if (th3 != null) {
                                                if (!this.vk) {
                                                    z14 = z;
                                                }
                                                if (z14) {
                                                    com.byazt.tuy.uc.pr(th3, "loopAndWrite_finally");
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (r17 > 0) {
                                        ucVar.hw(r17 == true ? 1L : 0L);
                                    }
                                    if (!this.w) {
                                        hn();
                                    }
                                    th2 = null;
                                    synchronized (this) {
                                        hn(this.pr);
                                        this.pr.clear();
                                        com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                        if (th2 != null) {
                                            if (!this.vk) {
                                                z10 = z;
                                            }
                                            if (z10) {
                                                com.byazt.tuy.uc.pr(th2, "loopAndWrite_finally");
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                            } else {
                                if (z9) {
                                    jNanoTime4 = System.nanoTime();
                                }
                                prVarPr.hw.hw(prVarPr);
                                if (z9) {
                                    jNanoTime += System.nanoTime() - jNanoTime4;
                                }
                                jNanoTime = jNanoTime;
                                try {
                                    hnVar.pr(prVarPr);
                                    if (this.aj) {
                                        if (this.vk) {
                                            break;
                                        }
                                        try {
                                            if (this.w) {
                                                break;
                                            } else {
                                                this.aj = z15;
                                            }
                                        } catch (nt e10) {
                                            e = e10;
                                            jNanoTime3 = jNanoTime3;
                                            z8 = z15;
                                            r18 = r13;
                                            z3 = z8;
                                        } catch (BaseException e11) {
                                            e = e11;
                                            j2 = jNanoTime;
                                            r19 = r13;
                                            z2 = z15;
                                            if (this.c.pr("ignore_base_ex_on_stop_status")) {
                                            }
                                            com.byazt.p000do.pr.pr();
                                            com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                                            this.zo = e;
                                            throw e;
                                        } catch (Throwable th18) {
                                            th = th18;
                                            j = jNanoTime;
                                            r17 = r13;
                                            z = z15;
                                            if (!this.vk) {
                                                com.byazt.p000do.pr.pr();
                                                com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite:  e = ".concat(String.valueOf(th)));
                                                com.byazt.tuy.uc.pr(th, "loopAndWrite");
                                                if (r17 > 0) {
                                                    ucVar.hw(r17 == true ? 1L : 0L);
                                                }
                                                if (!this.w) {
                                                    hn();
                                                }
                                                th3 = null;
                                                synchronized (this) {
                                                    hn(this.pr);
                                                    this.pr.clear();
                                                    com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                                    if (th3 != null) {
                                                        if (!this.vk) {
                                                            z14 = z;
                                                        }
                                                        if (z14) {
                                                            com.byazt.tuy.uc.pr(th3, "loopAndWrite_finally");
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                            }
                                            if (r17 > 0) {
                                                ucVar.hw(r17 == true ? 1L : 0L);
                                            }
                                            if (!this.w) {
                                                hn();
                                            }
                                            th2 = null;
                                            synchronized (this) {
                                                hn(this.pr);
                                                this.pr.clear();
                                                com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                                if (th2 != null) {
                                                    if (!this.vk) {
                                                        z10 = z;
                                                    }
                                                    if (z10) {
                                                        com.byazt.tuy.uc.pr(th2, "loopAndWrite_finally");
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        this.zo = e;
                                        throw e;
                                    }
                                    r13 += i;
                                    if (r13 >= 65536) {
                                        try {
                                            long jUptimeMillis = SystemClock.uptimeMillis();
                                            if (jUptimeMillis - j3 > 100) {
                                                jNanoTime4 = jNanoTime4;
                                                try {
                                                    pr(jUptimeMillis, ucVar.hw((long) r13));
                                                    if (!com.byazt.edb.hw.pr) {
                                                        if (downloadInfo.isOnlyWifi()) {
                                                            throw new com.byazt.lhc.hn();
                                                        }
                                                        if (downloadInfo.isDownloadFromReserveWifi() && downloadInfo.isPauseReserveOnWifi()) {
                                                            throw new com.byazt.lhc.c();
                                                        }
                                                    }
                                                    j3 = jUptimeMillis;
                                                    boolean z16 = z15;
                                                    z15 = z16;
                                                    r13 = z16;
                                                } catch (nt e12) {
                                                    e = e12;
                                                    jNanoTime3 = jNanoTime3;
                                                    r18 = z15;
                                                    z3 = z15;
                                                } catch (BaseException e13) {
                                                    e = e13;
                                                    j2 = jNanoTime;
                                                    r19 = z15;
                                                    z2 = z15;
                                                    if (this.c.pr("ignore_base_ex_on_stop_status")) {
                                                    }
                                                    com.byazt.p000do.pr.pr();
                                                    com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                                                    this.zo = e;
                                                    throw e;
                                                } catch (Throwable th19) {
                                                    th = th19;
                                                    j = jNanoTime;
                                                    r17 = z15;
                                                    z = z15;
                                                    if (!this.vk) {
                                                        com.byazt.p000do.pr.pr();
                                                        com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite:  e = ".concat(String.valueOf(th)));
                                                        com.byazt.tuy.uc.pr(th, "loopAndWrite");
                                                        if (r17 > 0) {
                                                            ucVar.hw(r17 == true ? 1L : 0L);
                                                        }
                                                        if (!this.w) {
                                                            hn();
                                                        }
                                                        th3 = null;
                                                        synchronized (this) {
                                                            hn(this.pr);
                                                            this.pr.clear();
                                                            com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                                            if (th3 != null) {
                                                                if (!this.vk) {
                                                                    z14 = z;
                                                                }
                                                                if (z14) {
                                                                    com.byazt.tuy.uc.pr(th3, "loopAndWrite_finally");
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                    }
                                                    if (r17 > 0) {
                                                        ucVar.hw(r17 == true ? 1L : 0L);
                                                    }
                                                    if (!this.w) {
                                                        hn();
                                                    }
                                                    th2 = null;
                                                    synchronized (this) {
                                                        hn(this.pr);
                                                        this.pr.clear();
                                                        com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                                        if (th2 != null) {
                                                            if (!this.vk) {
                                                                z10 = z;
                                                            }
                                                            if (z10) {
                                                                com.byazt.tuy.uc.pr(th2, "loopAndWrite_finally");
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                }
                                            }
                                            jNanoTime4 = jNanoTime4;
                                        } catch (nt e14) {
                                            e = e14;
                                            r16 = r13;
                                            z5 = z15;
                                            jNanoTime3 = jNanoTime3;
                                            r18 = r16;
                                            z3 = z5;
                                        } catch (BaseException e15) {
                                            e = e15;
                                            r19 = r13;
                                            j2 = jNanoTime;
                                            z2 = z7;
                                            if (this.c.pr("ignore_base_ex_on_stop_status")) {
                                            }
                                            com.byazt.p000do.pr.pr();
                                            com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                                            this.zo = e;
                                            throw e;
                                        } catch (Throwable th20) {
                                            th = th20;
                                            r17 = r13;
                                            j = jNanoTime;
                                            z = z6;
                                            if (!this.vk) {
                                                com.byazt.p000do.pr.pr();
                                                com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite:  e = ".concat(String.valueOf(th)));
                                                com.byazt.tuy.uc.pr(th, "loopAndWrite");
                                                if (r17 > 0) {
                                                    ucVar.hw(r17 == true ? 1L : 0L);
                                                }
                                                if (!this.w) {
                                                    hn();
                                                }
                                                th3 = null;
                                                synchronized (this) {
                                                    hn(this.pr);
                                                    this.pr.clear();
                                                    com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                                    if (th3 != null) {
                                                        if (!this.vk) {
                                                            z14 = z;
                                                        }
                                                        if (z14) {
                                                            com.byazt.tuy.uc.pr(th3, "loopAndWrite_finally");
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                            }
                                            if (r17 > 0) {
                                                ucVar.hw(r17 == true ? 1L : 0L);
                                            }
                                            if (!this.w) {
                                                hn();
                                            }
                                            th2 = null;
                                            synchronized (this) {
                                                hn(this.pr);
                                                this.pr.clear();
                                                com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                                if (th2 != null) {
                                                    if (!this.vk) {
                                                        z10 = z;
                                                    }
                                                    if (z10) {
                                                        com.byazt.tuy.uc.pr(th2, "loopAndWrite_finally");
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                    }
                                    z15 = z15 ? 1 : 0;
                                    r13 = r13;
                                    jNanoTime4 = jNanoTime4;
                                } catch (nt e16) {
                                    e = e16;
                                    z15 = z15 ? 1 : 0;
                                } catch (BaseException e17) {
                                    e = e17;
                                    z7 = z15 ? 1 : 0;
                                } catch (Throwable th21) {
                                    th = th21;
                                    z6 = z15 ? 1 : 0;
                                }
                            }
                        } catch (nt e18) {
                            e = e18;
                            z5 = z15 ? 1 : 0;
                            r16 = r13;
                            jNanoTime = jNanoTime;
                        } catch (BaseException e19) {
                            e = e19;
                            r19 = r13;
                            j2 = jNanoTime;
                            z2 = z15;
                            if (this.c.pr("ignore_base_ex_on_stop_status")) {
                            }
                            com.byazt.p000do.pr.pr();
                            com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                            this.zo = e;
                            throw e;
                        } catch (Throwable th22) {
                            th = th22;
                            r17 = r13;
                            j = jNanoTime;
                            z = z15;
                            if (!this.vk) {
                                com.byazt.p000do.pr.pr();
                                com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite:  e = ".concat(String.valueOf(th)));
                                com.byazt.tuy.uc.pr(th, "loopAndWrite");
                                if (r17 > 0) {
                                    ucVar.hw(r17 == true ? 1L : 0L);
                                }
                                if (!this.w) {
                                    hn();
                                }
                                th3 = null;
                                synchronized (this) {
                                    hn(this.pr);
                                    this.pr.clear();
                                    com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                    if (th3 != null) {
                                        if (!this.vk) {
                                            z14 = z;
                                        }
                                        if (z14) {
                                            com.byazt.tuy.uc.pr(th3, "loopAndWrite_finally");
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (r17 > 0) {
                                ucVar.hw(r17 == true ? 1L : 0L);
                            }
                            if (!this.w) {
                                hn();
                            }
                            th2 = null;
                            synchronized (this) {
                                hn(this.pr);
                                this.pr.clear();
                                com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                                if (th2 != null) {
                                    if (!this.vk) {
                                        z10 = z;
                                    }
                                    if (z10) {
                                        com.byazt.tuy.uc.pr(th2, "loopAndWrite_finally");
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (nt e20) {
                        e = e20;
                        z3 = z15 ? 1 : 0;
                        r18 = r13;
                        jNanoTime = jNanoTime;
                    } catch (BaseException e21) {
                        e = e21;
                        jNanoTime3 = jNanoTime3;
                    } catch (Throwable th23) {
                        th = th23;
                        jNanoTime3 = jNanoTime3;
                    }
                }
                if (r13 > 0) {
                    try {
                        ucVar.hw((long) r13);
                    } catch (Throwable th24) {
                    }
                }
                if (!this.w) {
                    try {
                        hn();
                    } catch (Throwable th25) {
                        th6 = th25;
                        com.byazt.p000do.pr.x("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th6)));
                    }
                }
                th6 = null;
                synchronized (this) {
                    hn(this.pr);
                    this.pr.clear();
                }
                long curBytes2 = downloadInfo.getCurBytes() - curBytes;
                long jNanoTime5 = System.nanoTime() - jNanoTime2;
                com.byazt.ew.pr prVar = this.c;
                String url = downloadInfo.getUrl();
                boolean z17 = this.vk;
                boolean z18 = this.w;
                BaseException baseException = this.zo;
                long j4 = this.yb;
                boolean z19 = z15 ? 1 : 0;
                com.byazt.cha.pr.pr(prVar, downloadInfo, url, null, z17, z18, baseException, curBytes2, jNanoTime5, z9, jNanoTime3, jNanoTime, j4, null);
                if (th6 != null) {
                    if (!this.vk && !this.w && this.zo == null) {
                        z11 = z19 ? 1 : 0;
                    }
                    if (z11) {
                        return;
                    }
                    try {
                        com.byazt.tuy.uc.pr(th6, "loopAndWrite_finally");
                    } catch (BaseException e22) {
                        this.zo = e22;
                        throw e22;
                    }
                }
            } catch (Throwable th26) {
                th = th26;
                r15 = r17;
                z4 = z;
                if (r15 > 0) {
                    ucVar.hw((long) r15);
                }
                if (!this.w) {
                    hn();
                }
                th5 = null;
                synchronized (this) {
                    hn(this.pr);
                    this.pr.clear();
                }
                com.byazt.cha.pr.pr(this.c, downloadInfo, downloadInfo.getUrl(), null, this.vk, this.w, this.zo, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime2, z9, jNanoTime3, j, this.yb, null);
                if (th5 == null) {
                    throw th;
                }
                if (!this.vk && !this.w && this.zo == null) {
                    z12 = z4;
                }
                if (z12) {
                    throw th;
                }
                com.byazt.tuy.uc.pr(th5, "loopAndWrite_finally");
                throw th;
            }
        } catch (nt e23) {
            e = e23;
            z3 = false;
            jNanoTime = 0;
        } catch (BaseException e24) {
            e = e24;
            z2 = false;
            j2 = 0;
            jNanoTime3 = 0;
        } catch (Throwable th27) {
            th = th27;
            z = false;
            j = 0;
            jNanoTime3 = 0;
        }
    }

    private void pr(long j, boolean z) throws IOException {
        long j2 = j - this.qa;
        if (this.m) {
            if (j2 <= (this.k.hw() ? this.g : this.ho)) {
                return;
            }
        } else {
            long curBytes = this.hn.getCurBytes() - this.lb;
            if (!z && !pr(curBytes, j2)) {
                return;
            }
        }
        hn();
        this.qa = j;
    }

    private boolean pr(long j, long j2) {
        return j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j2 > 500;
    }

    private void pr(c cVar) {
        synchronized (this) {
            this.hw.add((k) cVar);
        }
    }

    private void hn() throws IOException {
        boolean z = this.nt;
        long jNanoTime = z ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.hn;
        com.byazt.lj.vk vkVar = this.x;
        List<k> list = this.pr;
        List<k> list2 = this.hw;
        Map<Long, aj> mapK = vkVar.k(downloadInfo.getId());
        if (mapK == null) {
            mapK = new HashMap<>(4);
        }
        boolean z2 = false;
        synchronized (this) {
            pr(list);
            try {
                hw(list);
                z2 = true;
            } catch (Throwable th) {
            }
            pr(list, mapK);
            if (list2.size() > 0) {
                hn(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z2) {
            downloadInfo.updateRealDownloadTime(true);
            vkVar.pr(downloadInfo.getId(), mapK);
            vkVar.pr(downloadInfo);
            this.lb = downloadInfo.getCurBytes();
        }
        if (z) {
            this.yb += System.nanoTime() - jNanoTime;
        }
    }

    private void pr(List<k> list) throws IOException {
        Iterator<k> it = list.iterator();
        while (it.hasNext()) {
            it.next().hw();
        }
    }

    private void hw(List<k> list) throws IOException {
        Iterator<k> it = list.iterator();
        while (it.hasNext()) {
            it.next().hn();
        }
    }

    private void hn(List<k> list) {
        Iterator<k> it = list.iterator();
        while (it.hasNext()) {
            it.next().x();
        }
    }

    private void pr(List<k> list, Map<Long, aj> map) {
        Iterator<k> it = list.iterator();
        while (it.hasNext()) {
            aj ajVarC = it.next().c();
            aj ajVar = map.get(Long.valueOf(ajVarC.hn()));
            if (ajVar == null) {
                map.put(Long.valueOf(ajVarC.hn()), new aj(ajVarC));
            } else {
                ajVar.pr(ajVarC.x());
                ajVar.hn(ajVarC.uc());
            }
        }
    }

    public void pr() {
        this.w = true;
        this.aj = true;
    }

    public void hw() {
        this.vk = true;
        this.aj = true;
    }
}
