package com.byazt.l;

import android.os.Process;
import com.byazt.m.rv;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
import com.byazt.xv.tj;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 18, 26})
public class qg implements Runnable {
    public static final String n = "qg";
    public volatile boolean cp;
    public boolean d;
    public rv fs;
    public final DownloadTask l;
    public com.byazt.xv.l q;
    public com.byazt.wm.qg qg;
    public tj rv;
    public com.byazt.wm.qg s;
    public volatile boolean tj;
    public DownloadInfo w;
    public final w x;

    public qg(com.byazt.wm.qg qgVar, DownloadTask downloadTask, w wVar) {
        this.d = false;
        this.s = qgVar;
        this.l = downloadTask;
        if (downloadTask != null) {
            this.w = downloadTask.getDownloadInfo();
        }
        this.x = wVar;
        this.rv = com.byazt.xv.s.hu();
        this.s.n(this);
    }

    public qg(com.byazt.wm.qg qgVar, DownloadTask downloadTask, rv rvVar, w wVar) {
        this(qgVar, downloadTask, wVar);
        this.fs = rvVar;
    }

    private String s() {
        return this.w.getConnectionUrl();
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.qg = this.s;
        while (true) {
            try {
                this.qg.n(this);
                if (!n(this.qg)) {
                    this.qg.n(false);
                    break;
                }
                this.qg.n(false);
                if (l()) {
                    break;
                }
                this.qg = this.x.n(this.qg.um());
                if (l() || this.qg == null) {
                    break;
                } else {
                    Thread.sleep(50L);
                }
            } finally {
                com.byazt.wm.qg qgVar = this.qg;
                if (qgVar != null) {
                    qgVar.n(false);
                }
                q();
                this.x.n(this);
            }
        }
    }

    public void n(long j, long j2) {
        com.byazt.xv.l lVar = this.q;
        if (lVar == null) {
            return;
        }
        lVar.n(j, j2);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x018e A[Catch: all -> 0x0195, TRY_LEAVE, TryCatch #7 {all -> 0x0195, blocks: (B:101:0x0186, B:104:0x018e), top: B:191:0x0186 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x01c4 A[Catch: all -> 0x0287, TRY_ENTER, TryCatch #1 {all -> 0x0287, blocks: (B:124:0x01ba, B:128:0x01c4, B:130:0x01ca, B:133:0x01d3, B:135:0x01db, B:137:0x01e1, B:141:0x01ec, B:143:0x01f0, B:145:0x01f8, B:147:0x0209, B:156:0x022f, B:158:0x0235, B:160:0x0242, B:164:0x024a, B:159:0x023c, B:150:0x0216, B:151:0x0222, B:166:0x0255, B:168:0x025d, B:170:0x0265, B:172:0x026d, B:174:0x0275, B:177:0x027e, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:187:0x01ba, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x01d3 A[Catch: all -> 0x0287, TRY_ENTER, TryCatch #1 {all -> 0x0287, blocks: (B:124:0x01ba, B:128:0x01c4, B:130:0x01ca, B:133:0x01d3, B:135:0x01db, B:137:0x01e1, B:141:0x01ec, B:143:0x01f0, B:145:0x01f8, B:147:0x0209, B:156:0x022f, B:158:0x0235, B:160:0x0242, B:164:0x024a, B:159:0x023c, B:150:0x0216, B:151:0x0222, B:166:0x0255, B:168:0x025d, B:170:0x0265, B:172:0x026d, B:174:0x0275, B:177:0x027e, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:187:0x01ba, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x01db A[Catch: all -> 0x0287, TryCatch #1 {all -> 0x0287, blocks: (B:124:0x01ba, B:128:0x01c4, B:130:0x01ca, B:133:0x01d3, B:135:0x01db, B:137:0x01e1, B:141:0x01ec, B:143:0x01f0, B:145:0x01f8, B:147:0x0209, B:156:0x022f, B:158:0x0235, B:160:0x0242, B:164:0x024a, B:159:0x023c, B:150:0x0216, B:151:0x0222, B:166:0x0255, B:168:0x025d, B:170:0x0265, B:172:0x026d, B:174:0x0275, B:177:0x027e, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:187:0x01ba, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ec A[Catch: all -> 0x0287, TRY_ENTER, TryCatch #1 {all -> 0x0287, blocks: (B:124:0x01ba, B:128:0x01c4, B:130:0x01ca, B:133:0x01d3, B:135:0x01db, B:137:0x01e1, B:141:0x01ec, B:143:0x01f0, B:145:0x01f8, B:147:0x0209, B:156:0x022f, B:158:0x0235, B:160:0x0242, B:164:0x024a, B:159:0x023c, B:150:0x0216, B:151:0x0222, B:166:0x0255, B:168:0x025d, B:170:0x0265, B:172:0x026d, B:174:0x0275, B:177:0x027e, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:187:0x01ba, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x01f0 A[Catch: all -> 0x0287, TryCatch #1 {all -> 0x0287, blocks: (B:124:0x01ba, B:128:0x01c4, B:130:0x01ca, B:133:0x01d3, B:135:0x01db, B:137:0x01e1, B:141:0x01ec, B:143:0x01f0, B:145:0x01f8, B:147:0x0209, B:156:0x022f, B:158:0x0235, B:160:0x0242, B:164:0x024a, B:159:0x023c, B:150:0x0216, B:151:0x0222, B:166:0x0255, B:168:0x025d, B:170:0x0265, B:172:0x026d, B:174:0x0275, B:177:0x027e, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:187:0x01ba, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x01f8 A[Catch: all -> 0x0287, TryCatch #1 {all -> 0x0287, blocks: (B:124:0x01ba, B:128:0x01c4, B:130:0x01ca, B:133:0x01d3, B:135:0x01db, B:137:0x01e1, B:141:0x01ec, B:143:0x01f0, B:145:0x01f8, B:147:0x0209, B:156:0x022f, B:158:0x0235, B:160:0x0242, B:164:0x024a, B:159:0x023c, B:150:0x0216, B:151:0x0222, B:166:0x0255, B:168:0x025d, B:170:0x0265, B:172:0x026d, B:174:0x0275, B:177:0x027e, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:187:0x01ba, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x0209 A[Catch: all -> 0x0287, TryCatch #1 {all -> 0x0287, blocks: (B:124:0x01ba, B:128:0x01c4, B:130:0x01ca, B:133:0x01d3, B:135:0x01db, B:137:0x01e1, B:141:0x01ec, B:143:0x01f0, B:145:0x01f8, B:147:0x0209, B:156:0x022f, B:158:0x0235, B:160:0x0242, B:164:0x024a, B:159:0x023c, B:150:0x0216, B:151:0x0222, B:166:0x0255, B:168:0x025d, B:170:0x0265, B:172:0x026d, B:174:0x0275, B:177:0x027e, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:187:0x01ba, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x0213 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:149:0x0215  */
    /* JADX WARN: Code duplicated, block: B:150:0x0216 A[Catch: all -> 0x0287, TryCatch #1 {all -> 0x0287, blocks: (B:124:0x01ba, B:128:0x01c4, B:130:0x01ca, B:133:0x01d3, B:135:0x01db, B:137:0x01e1, B:141:0x01ec, B:143:0x01f0, B:145:0x01f8, B:147:0x0209, B:156:0x022f, B:158:0x0235, B:160:0x0242, B:164:0x024a, B:159:0x023c, B:150:0x0216, B:151:0x0222, B:166:0x0255, B:168:0x025d, B:170:0x0265, B:172:0x026d, B:174:0x0275, B:177:0x027e, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:187:0x01ba, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x022b A[PHI: r21
      0x022b: PHI (r21v1 long) = (r21v0 long), (r21v2 long), (r21v0 long) binds: [B:140:0x01ea, B:150:0x0216, B:149:0x0215] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:158:0x0235 A[Catch: all -> 0x0287, TryCatch #1 {all -> 0x0287, blocks: (B:124:0x01ba, B:128:0x01c4, B:130:0x01ca, B:133:0x01d3, B:135:0x01db, B:137:0x01e1, B:141:0x01ec, B:143:0x01f0, B:145:0x01f8, B:147:0x0209, B:156:0x022f, B:158:0x0235, B:160:0x0242, B:164:0x024a, B:159:0x023c, B:150:0x0216, B:151:0x0222, B:166:0x0255, B:168:0x025d, B:170:0x0265, B:172:0x026d, B:174:0x0275, B:177:0x027e, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:187:0x01ba, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x023c A[Catch: all -> 0x0287, TryCatch #1 {all -> 0x0287, blocks: (B:124:0x01ba, B:128:0x01c4, B:130:0x01ca, B:133:0x01d3, B:135:0x01db, B:137:0x01e1, B:141:0x01ec, B:143:0x01f0, B:145:0x01f8, B:147:0x0209, B:156:0x022f, B:158:0x0235, B:160:0x0242, B:164:0x024a, B:159:0x023c, B:150:0x0216, B:151:0x0222, B:166:0x0255, B:168:0x025d, B:170:0x0265, B:172:0x026d, B:174:0x0275, B:177:0x027e, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:187:0x01ba, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x024a A[Catch: all -> 0x0287, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0287, blocks: (B:124:0x01ba, B:128:0x01c4, B:130:0x01ca, B:133:0x01d3, B:135:0x01db, B:137:0x01e1, B:141:0x01ec, B:143:0x01f0, B:145:0x01f8, B:147:0x0209, B:156:0x022f, B:158:0x0235, B:160:0x0242, B:164:0x024a, B:159:0x023c, B:150:0x0216, B:151:0x0222, B:166:0x0255, B:168:0x025d, B:170:0x0265, B:172:0x026d, B:174:0x0275, B:177:0x027e, B:112:0x019d, B:116:0x01a7, B:119:0x01ae), top: B:187:0x01ba, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:200:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:206:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:207:0x0164 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:211:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:0x01ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:213:0x0255 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:0x01e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x0222 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x0246 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00e3 A[Catch: all -> 0x019b, BaseException -> 0x01b7, TRY_ENTER, TRY_LEAVE, TryCatch #13 {BaseException -> 0x01b7, all -> 0x019b, blocks: (B:22:0x004e, B:26:0x0058, B:30:0x0063, B:35:0x00b2, B:37:0x00b6, B:56:0x00e3, B:60:0x00ed, B:62:0x00f1, B:73:0x011f, B:70:0x0117, B:72:0x011e, B:47:0x00d0, B:49:0x00d4), top: B:202:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00ed A[Catch: all -> 0x019b, BaseException -> 0x01b7, TRY_ENTER, TryCatch #13 {BaseException -> 0x01b7, all -> 0x019b, blocks: (B:22:0x004e, B:26:0x0058, B:30:0x0063, B:35:0x00b2, B:37:0x00b6, B:56:0x00e3, B:60:0x00ed, B:62:0x00f1, B:73:0x011f, B:70:0x0117, B:72:0x011e, B:47:0x00d0, B:49:0x00d4), top: B:202:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00f1 A[Catch: all -> 0x019b, BaseException -> 0x01b7, TRY_LEAVE, TryCatch #13 {BaseException -> 0x01b7, all -> 0x019b, blocks: (B:22:0x004e, B:26:0x0058, B:30:0x0063, B:35:0x00b2, B:37:0x00b6, B:56:0x00e3, B:60:0x00ed, B:62:0x00f1, B:73:0x011f, B:70:0x0117, B:72:0x011e, B:47:0x00d0, B:49:0x00d4), top: B:202:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:67:0x0100 A[Catch: all -> 0x0116, BaseException -> 0x011d, TryCatch #14 {BaseException -> 0x011d, all -> 0x0116, blocks: (B:64:0x00f5, B:67:0x0100, B:68:0x0115), top: B:200:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0135 A[Catch: all -> 0x0196, BaseException -> 0x0198, TryCatch #5 {BaseException -> 0x0198, blocks: (B:75:0x012e, B:77:0x0135, B:81:0x0141, B:82:0x0147, B:89:0x0166, B:90:0x0174, B:97:0x017e, B:99:0x0182, B:105:0x0195), top: B:190:0x012e }] */
    /* JADX WARN: Code duplicated, block: B:79:0x013d  */
    private boolean n(com.byazt.wm.qg qgVar) {
        com.byazt.wm.qg qgVarL;
        boolean z;
        long j;
        long jN;
        com.byazt.qx.fs fsVarN;
        int iQg;
        w wVar;
        rv rvVar;
        int iQg2;
        rv rvVar2;
        int iQg3;
        long jS;
        int iQg4;
        while (true) {
            if (!qgVar.q() || !qgVar.w() || (qgVarL = qgVar.l()) == null || qgVarL.um() != qgVar.um()) {
                qgVarL = null;
            }
            com.byazt.wm.qg qgVar2 = qgVarL;
            if (qgVar2 != null && qgVar2.rv()) {
                return true;
            }
            long jSz = qgVar.sz();
            long jCy = qgVar.cy();
            long jSz2 = qgVar.sz();
            if (qgVar2 != null) {
                jSz2 = qgVar2.sz();
                jSz = qgVar2.sz();
                jCy = qgVar2.cy();
            }
            long j2 = jSz;
            long j3 = jCy;
            long jN2 = 0;
            boolean z2 = false;
            try {
                if (l()) {
                    q();
                    return false;
                }
                String strS = s();
                boolean z3 = this.fs != null;
                this.d = z3;
                qgVar.qg(z3);
                try {
                    try {
                        if (!this.d) {
                            List<com.byazt.wm.s> listN = com.byazt.ta.w.n(this.w.getExtraHeaders(), this.w.geteTag(), j2, j3);
                            listN.add(new com.byazt.wm.s("Chunk-Index", String.valueOf(qgVar.um())));
                            com.byazt.ta.w.n(listN, this.w);
                            com.byazt.ta.w.qg(listN, this.w);
                            this.fs = com.byazt.xv.s.n(this.w.isNeedDefaultHttpServiceBackUp(), this.w.getMaxBytes(), strS, listN);
                        }
                        rv rvVar3 = this.fs;
                        if (rvVar3 != null && this.x != null && ((iQg4 = rvVar3.qg()) < 200 || iQg4 >= 300)) {
                            wVar = this.x;
                            wVar.n(this.fs);
                            if (l()) {
                                q();
                                return false;
                            }
                            rvVar2 = this.fs;
                            if (rvVar2 == null) {
                                throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                            }
                            if (!this.d) {
                                iQg3 = rvVar2.qg();
                                if (!com.byazt.ta.w.q(iQg3)) {
                                    throw new BaseException(1002, String.format("Http response error , code is : %s ", String.valueOf(iQg3)));
                                }
                            }
                            z = false;
                            j = jSz2;
                            this.q = new com.byazt.xv.l(this.w, strS, this.fs, qgVar, this.x);
                            if (qgVar2 != null) {
                                jS = qgVar2.s(false);
                                if (j3 != 0) {
                                    jS = (j3 - j2) + 1;
                                }
                                this.q.n(qgVar2.sz(), qgVar2.cy(), jS);
                            }
                            this.q.q();
                            q();
                            return true;
                        }
                        if (l()) {
                            q();
                            return false;
                        }
                        rvVar2 = this.fs;
                        if (rvVar2 == null) {
                            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                        }
                        if (!this.d) {
                            try {
                                iQg3 = rvVar2.qg();
                                if (!com.byazt.ta.w.q(iQg3)) {
                                    throw new BaseException(1002, String.format("Http response error , code is : %s ", String.valueOf(iQg3)));
                                }
                            } catch (BaseException e) {
                                throw e;
                            } catch (Throwable th) {
                                com.byazt.ta.w.n(th, "ChunkRunnableGetResponseCode");
                            }
                        }
                        z = false;
                        j = jSz2;
                        try {
                            try {
                                this.q = new com.byazt.xv.l(this.w, strS, this.fs, qgVar, this.x);
                                if (qgVar2 != null) {
                                    jS = qgVar2.s(false);
                                    if (j3 != 0 && j3 >= j2) {
                                        jS = (j3 - j2) + 1;
                                    }
                                    this.q.n(qgVar2.sz(), qgVar2.cy(), jS);
                                }
                                try {
                                    this.q.q();
                                    q();
                                    return true;
                                } catch (BaseException e2) {
                                    e = e2;
                                    z2 = true;
                                }
                            } catch (BaseException e3) {
                                e = e3;
                                z2 = false;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (l()) {
                                q();
                                return true;
                            }
                            try {
                                com.byazt.ta.w.n(th, "downloadChunkInner");
                            } catch (BaseException e4) {
                                this.x.qg(e4);
                            }
                            q();
                            return z;
                        }
                    } catch (Throwable unused) {
                    }
                } catch (BaseException e5) {
                    try {
                        throw e5;
                    } catch (Throwable th3) {
                        th = th3;
                        rvVar = this.fs;
                        if (rvVar != null) {
                            try {
                                iQg2 = rvVar.qg();
                                if (iQg2 >= 200) {
                                    this.x.n(this.fs);
                                } else {
                                    this.x.n(this.fs);
                                }
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    try {
                        com.byazt.ta.w.n(th4, "ChunkRunnableConnection");
                        rv rvVar4 = this.fs;
                        if (rvVar4 == null || this.x == null || ((iQg = rvVar4.qg()) >= 200 && iQg < 300)) {
                            if (l()) {
                                q();
                                return false;
                            }
                            rvVar2 = this.fs;
                            if (rvVar2 == null) {
                                throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                            }
                            if (!this.d) {
                                iQg3 = rvVar2.qg();
                                if (!com.byazt.ta.w.q(iQg3)) {
                                    throw new BaseException(1002, String.format("Http response error , code is : %s ", String.valueOf(iQg3)));
                                }
                            }
                            z = false;
                            j = jSz2;
                            this.q = new com.byazt.xv.l(this.w, strS, this.fs, qgVar, this.x);
                            if (qgVar2 != null) {
                                jS = qgVar2.s(false);
                                if (j3 != 0) {
                                    jS = (j3 - j2) + 1;
                                }
                                this.q.n(qgVar2.sz(), qgVar2.cy(), jS);
                            }
                            this.q.q();
                            q();
                            return true;
                        }
                        wVar = this.x;
                    } catch (Throwable th5) {
                        th = th5;
                        rvVar = this.fs;
                        if (rvVar != null && this.x != null) {
                            iQg2 = rvVar.qg();
                            if (iQg2 >= 200 || iQg2 >= 300) {
                                this.x.n(this.fs);
                            }
                        }
                        throw th;
                    }
                    if (l()) {
                        q();
                        return true;
                    }
                    if (com.byazt.ta.w.qg(e)) {
                        this.x.n(e, z);
                        q();
                        return z;
                    }
                    if (this.x.n(e)) {
                        if (this.w.isNeedChunkDowngradeRetry()) {
                        }
                        this.x.qg(e);
                        q();
                        return z;
                    }
                    if (com.byazt.ta.w.n(e)) {
                        this.x.n(e, true);
                        q();
                        return z;
                    }
                    if (!z2) {
                        jN = jN2;
                    } else {
                        if (this.q != null) {
                            this.x.qg(e);
                            q();
                            return z;
                        }
                        if (com.byazt.ta.n.n(32)) {
                            jN = this.q.n() - this.q.l();
                            if (jN > 0) {
                                n(qgVar, this.q.l());
                            } else if (jN < 0) {
                            }
                        } else {
                            jN2 = this.q.n() - j;
                            n(qgVar, j);
                        }
                        jN = jN2;
                    }
                    if (com.byazt.ta.n.n(16)) {
                        fsVarN = this.x.n(qgVar, e, jN);
                    } else {
                        fsVarN = this.x.n(e, jN);
                    }
                    if (fsVarN == com.byazt.qx.fs.RETURN) {
                        q();
                        return z;
                    }
                    qgVar.qg(z);
                    q();
                    q();
                }
            } catch (BaseException e6) {
                e = e6;
                z = false;
                j = jSz2;
            } catch (Throwable th6) {
                th = th6;
                z = false;
            }
            try {
                if (l()) {
                    q();
                    return true;
                }
                if (com.byazt.ta.w.qg(e)) {
                    this.x.n(e, z);
                    q();
                    return z;
                }
                if (this.x.n(e)) {
                    if (this.w.isNeedChunkDowngradeRetry() || this.w.isChunkDowngradeRetryUsed() || this.w.getChunkCount() <= 1 || !com.byazt.ta.w.n(e, this.w)) {
                        this.x.qg(e);
                        q();
                        return z;
                    }
                    this.x.s(e);
                    q();
                    return z;
                }
                if (com.byazt.ta.w.n(e)) {
                    this.x.n(e, true);
                    q();
                    return z;
                }
                if (!z2) {
                    jN = jN2;
                } else {
                    if (this.q != null) {
                        this.x.qg(e);
                        q();
                        return z;
                    }
                    if (com.byazt.ta.n.n(32)) {
                        jN = this.q.n() - this.q.l();
                        if (jN > 0) {
                            n(qgVar, this.q.l());
                        } else if (jN < 0) {
                        }
                    } else {
                        jN2 = this.q.n() - j;
                        n(qgVar, j);
                    }
                    jN = jN2;
                }
                if (com.byazt.ta.n.n(16)) {
                    fsVarN = this.x.n(qgVar, e, jN);
                } else {
                    fsVarN = this.x.n(e, jN);
                }
                if (fsVarN == com.byazt.qx.fs.RETURN) {
                    q();
                    return z;
                }
                qgVar.qg(z);
                q();
                q();
            } catch (Throwable th7) {
                q();
                throw th7;
            }
        }
    }

    private void n(com.byazt.wm.qg qgVar, long j) {
        com.byazt.wm.qg qgVarL = qgVar.q() ? qgVar.l() : qgVar;
        if (qgVarL != null) {
            if (qgVarL.fs()) {
                this.rv.n(qgVarL.cp(), qgVarL.qg(), j);
            }
            qgVarL.qg(j);
            this.rv.n(qgVarL.cp(), qgVarL.um(), qgVarL.qg(), j);
            return;
        }
        if (qgVar.q()) {
            this.rv.n(qgVar.cp(), qgVar.um(), j);
        }
    }

    private void q() {
        rv rvVar = this.fs;
        if (rvVar != null) {
            rvVar.q();
            this.fs = null;
        }
    }

    private boolean l() {
        return this.tj || this.cp;
    }

    public void n() {
        this.tj = true;
        com.byazt.xv.l lVar = this.q;
        if (lVar != null) {
            lVar.qg();
        }
    }

    public void qg() {
        this.cp = true;
        com.byazt.xv.l lVar = this.q;
        if (lVar != null) {
            lVar.s();
        }
    }
}
