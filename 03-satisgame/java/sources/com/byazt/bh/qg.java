package com.byazt.bh;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.anythink.core.e.i;
import com.byazt.gct.fs;
import com.byazt.qit.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 125, 26})
public class qg {
    public static final qg n = new qg();
    public final LruCache<String, n> qg = new LruCache<>(64);
    public final ConcurrentHashMap<String, Boolean> s = new ConcurrentHashMap<>();

    public static qg n() {
        return n;
    }

    public long n(int i, String str) {
        n nVarW = w(i, str);
        if (nVarW != null) {
            return nVarW.n;
        }
        return -1L;
    }

    public long qg(int i, String str) {
        n nVarW = w(i, str);
        if (nVarW != null) {
            return nVarW.x;
        }
        return -1L;
    }

    public long s(int i, String str) {
        n nVarW = w(i, str);
        if (nVarW != null && nVarW.l && nVarW.n > 0) {
            fs.s sVarN = fs.n(i);
            fs.w wVarHd = sVarN != null ? sVarN.hd() : null;
            if (wVarHd != null && wVarHd.n(i) && wVarHd.py()) {
                return nVarW.w;
            }
        }
        return -1L;
    }

    public boolean q(int i, String str) {
        n nVarW = w(i, str);
        return nVarW != null && nVarW.l;
    }

    public long l(int i, String str) {
        n nVarW = w(i, str);
        if (nVarW != null) {
            return nVarW.w;
        }
        return -1L;
    }

    private n w(int i, String str) {
        long j;
        fs.s sVarN = fs.n(i);
        if (sVarN != null && sVarN.hd() != null) {
            fs.w wVarHd = sVarN.hd();
            if (wVarHd.n(i) && wVarHd.qg() > 0) {
                String strN = n(wVarHd, i, str);
                if (TextUtils.isEmpty(strN)) {
                    return null;
                }
                n nVar = this.qg.get(strN);
                if (nVar == null) {
                    j = -1;
                } else {
                    if (!nVar.n(wVarHd)) {
                        return nVar;
                    }
                    j = nVar.n;
                }
                n nVarN = n(strN);
                if (nVarN != null) {
                    if (!nVarN.n(wVarHd)) {
                        this.qg.put(strN, nVarN);
                        return nVarN;
                    }
                    j = nVarN.n;
                }
                long j2 = j;
                n(strN, wVarHd, i, str, j2);
                if (j2 > 0) {
                    return new n(j2, 0L, 0, 0, false);
                }
            }
        }
        return null;
    }

    private void n(final String str, final fs.w wVar, final int i, final String str2, final long j) {
        if (this.s.putIfAbsent(str, Boolean.TRUE) != null) {
            return;
        }
        com.byazt.ag.qg.n(new x("dynamic_tmax_calc") { // from class: com.byazt.bh.qg.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n nVarN = qg.this.n(wVar, i, str2, j);
                    if (nVarN != null) {
                        qg.this.qg.put(str, nVarN);
                        qg.this.n(str, nVarN);
                    }
                } finally {
                    qg.this.s.remove(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:174:0x0330 A[PHI: r4 r13
      0x0330: PHI (r4v10 long) = (r4v9 long), (r4v9 long), (r4v9 long), (r4v19 long) binds: [B:168:0x031f, B:170:0x0327, B:172:0x032d, B:165:0x030e] A[DONT_GENERATE, DONT_INLINE]
      0x0330: PHI (r13v4 long) = (r13v3 long), (r13v3 long), (r13v3 long), (r13v7 long) binds: [B:168:0x031f, B:170:0x0327, B:172:0x032d, B:165:0x030e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:197:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:73:0x013c A[Catch: all -> 0x03e9, TryCatch #5 {all -> 0x03e9, blocks: (B:17:0x0034, B:23:0x0071, B:35:0x0092, B:36:0x00ad, B:38:0x00b5, B:40:0x00bb, B:42:0x00c7, B:45:0x00d0, B:51:0x00e4, B:53:0x00f1, B:56:0x00f9, B:58:0x0101, B:60:0x0109, B:62:0x0115, B:67:0x0125, B:69:0x0131, B:73:0x013c, B:77:0x014d, B:80:0x0158, B:84:0x0169, B:87:0x0182, B:93:0x0195, B:95:0x01a2, B:101:0x01af, B:103:0x01b8, B:104:0x01bb, B:26:0x007a), top: B:246:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0143  */
    /* JADX WARN: Code duplicated, block: B:77:0x014d A[Catch: all -> 0x03e9, TryCatch #5 {all -> 0x03e9, blocks: (B:17:0x0034, B:23:0x0071, B:35:0x0092, B:36:0x00ad, B:38:0x00b5, B:40:0x00bb, B:42:0x00c7, B:45:0x00d0, B:51:0x00e4, B:53:0x00f1, B:56:0x00f9, B:58:0x0101, B:60:0x0109, B:62:0x0115, B:67:0x0125, B:69:0x0131, B:73:0x013c, B:77:0x014d, B:80:0x0158, B:84:0x0169, B:87:0x0182, B:93:0x0195, B:95:0x01a2, B:101:0x01af, B:103:0x01b8, B:104:0x01bb, B:26:0x007a), top: B:246:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0154  */
    /* JADX WARN: Code duplicated, block: B:80:0x0158 A[Catch: all -> 0x03e9, TryCatch #5 {all -> 0x03e9, blocks: (B:17:0x0034, B:23:0x0071, B:35:0x0092, B:36:0x00ad, B:38:0x00b5, B:40:0x00bb, B:42:0x00c7, B:45:0x00d0, B:51:0x00e4, B:53:0x00f1, B:56:0x00f9, B:58:0x0101, B:60:0x0109, B:62:0x0115, B:67:0x0125, B:69:0x0131, B:73:0x013c, B:77:0x014d, B:80:0x0158, B:84:0x0169, B:87:0x0182, B:93:0x0195, B:95:0x01a2, B:101:0x01af, B:103:0x01b8, B:104:0x01bb, B:26:0x007a), top: B:246:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x015f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0169 A[Catch: all -> 0x03e9, TryCatch #5 {all -> 0x03e9, blocks: (B:17:0x0034, B:23:0x0071, B:35:0x0092, B:36:0x00ad, B:38:0x00b5, B:40:0x00bb, B:42:0x00c7, B:45:0x00d0, B:51:0x00e4, B:53:0x00f1, B:56:0x00f9, B:58:0x0101, B:60:0x0109, B:62:0x0115, B:67:0x0125, B:69:0x0131, B:73:0x013c, B:77:0x014d, B:80:0x0158, B:84:0x0169, B:87:0x0182, B:93:0x0195, B:95:0x01a2, B:101:0x01af, B:103:0x01b8, B:104:0x01bb, B:26:0x007a), top: B:246:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0172  */
    public n n(fs.w wVar, int i, String str, long j) {
        Cursor cursor;
        Cursor cursorN;
        Cursor cursor2;
        long jFs;
        int i2;
        float f;
        float f2;
        boolean z;
        boolean z2;
        long j2;
        long jN;
        long j3;
        long j4;
        int i3;
        int i4;
        int i5;
        long j5;
        int i6;
        long j6;
        long jCurrentTimeMillis = System.currentTimeMillis() - i.f;
        if (jCurrentTimeMillis <= 0) {
            return null;
        }
        try {
            if (wVar.q() != 0) {
                cursorN = l.n(i, jCurrentTimeMillis, "record_time DESC");
            } else {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                cursorN = l.n(i, str, jCurrentTimeMillis, "record_time DESC");
            }
            if (cursorN == null) {
                if (cursorN != null) {
                    try {
                        cursorN.close();
                    } catch (Throwable unused) {
                    }
                }
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                int columnIndex = cursorN.getColumnIndex("loaded_duration");
                int columnIndex2 = cursorN.getColumnIndex("cached_duration");
                int columnIndex3 = cursorN.getColumnIndex("shown_duration");
                int columnIndex4 = cursorN.getColumnIndex("is_shown");
                int columnIndex5 = cursorN.getColumnIndex("pre_time");
                int columnIndex6 = cursorN.getColumnIndex("after_time");
                if (columnIndex >= 0 && columnIndex4 >= 0) {
                    if (j <= 0) {
                        jFs = wVar.fs();
                        if (jFs <= 0) {
                            jFs = wVar.qg();
                        }
                    } else {
                        jFs = j;
                    }
                    if (jFs <= 0) {
                        if (cursorN != null) {
                            try {
                                cursorN.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        return null;
                    }
                    long jFloor = (long) Math.floor(jFs * 0.8d);
                    int i7 = columnIndex5;
                    int i8 = columnIndex6;
                    int i9 = 0;
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    long j7 = 0;
                    int i15 = 0;
                    int i16 = 0;
                    long j8 = 0;
                    long j9 = 0;
                    while (true) {
                        i2 = i10;
                        if (!cursorN.moveToNext() || i14 >= wVar.w()) {
                            break;
                        }
                        i14++;
                        long j10 = cursorN.getLong(columnIndex);
                        int i17 = cursorN.getInt(columnIndex4);
                        long j11 = columnIndex2 >= 0 ? cursorN.getLong(columnIndex2) : 0L;
                        if (columnIndex3 >= 0) {
                            j4 = cursorN.getLong(columnIndex3);
                            j3 = 0;
                        } else {
                            j3 = 0;
                            j4 = 0;
                        }
                        int i18 = columnIndex;
                        if (j11 > j3 && i17 == 1) {
                            i11++;
                            arrayList3.add(Long.valueOf(j11));
                            if (j4 > j11) {
                                i9++;
                            }
                        }
                        if (j10 <= 0 || j10 < wVar.s() || j10 > wVar.qg()) {
                            i3 = i9;
                        } else {
                            i3 = i9;
                            arrayList.add(Long.valueOf(j10));
                            if (i17 == 1) {
                                arrayList2.add(Long.valueOf(j10));
                            }
                        }
                        if (j10 <= 0 || j10 > jFs) {
                            j7 = j7;
                        } else {
                            i13++;
                            j7 += j10;
                            i12++;
                            if (j10 >= jFloor) {
                                i4 = i2 + 1;
                            }
                            if (i7 >= 0) {
                                i5 = i7;
                                j5 = cursorN.getLong(i5);
                            } else {
                                i5 = i7;
                                j5 = 0;
                            }
                            if (j5 > 0) {
                                j8 += j5;
                                i15++;
                            }
                            if (i8 >= 0) {
                                i6 = i8;
                                j6 = cursorN.getLong(i6);
                            } else {
                                i6 = i8;
                                j6 = 0;
                            }
                            if (j6 > 0) {
                                j9 += j6;
                                i16++;
                            }
                            i10 = i4;
                            i7 = i5;
                            i8 = i6;
                            i9 = i3;
                            columnIndex = i18;
                        }
                        i4 = i2;
                        if (i7 >= 0) {
                            i5 = i7;
                            j5 = cursorN.getLong(i5);
                        } else {
                            i5 = i7;
                            j5 = 0;
                        }
                        if (j5 > 0) {
                            j8 += j5;
                            i15++;
                        }
                        if (i8 >= 0) {
                            i6 = i8;
                            j6 = cursorN.getLong(i6);
                        } else {
                            i6 = i8;
                            j6 = 0;
                        }
                        if (j6 > 0) {
                            j9 += j6;
                            i16++;
                        }
                        i10 = i4;
                        i7 = i5;
                        i8 = i6;
                        i9 = i3;
                        columnIndex = i18;
                    }
                    long j12 = j7;
                    int i19 = i15;
                    int i20 = i16;
                    if (arrayList.isEmpty()) {
                        if (cursorN == null) {
                            return null;
                        }
                        try {
                            cursorN.close();
                            return null;
                        } catch (Throwable unused3) {
                            return null;
                        }
                    }
                    int iMax = Math.max(0, wVar.l());
                    if (iMax > 0 && arrayList.size() < iMax) {
                        if (cursorN == null) {
                            return null;
                        }
                        try {
                            cursorN.close();
                            return null;
                        } catch (Throwable unused4) {
                            return null;
                        }
                    }
                    Collections.sort(arrayList);
                    if (!arrayList2.isEmpty()) {
                        Collections.sort(arrayList2);
                    }
                    long jN2 = com.byazt.bh.n.n(arrayList, (int) (wVar.rv() * 100.0f));
                    cursor2 = cursorN;
                    float f3 = i14 > 0 ? (i13 * 1.0f) / i14 : 0.0f;
                    float f4 = i12 > 0 ? ((j12 * 1.0f) / i12) / jFs : 0.0f;
                    float f5 = i13 > 0 ? (i2 * 1.0f) / i13 : 0.0f;
                    float f6 = jN2 > 0 ? ((jFs - jN2) * 1.0f) / jN2 : 0.0f;
                    try {
                        int iMin = Math.min(99, Math.max(1, Math.round(wVar.cp() * 100.0f)));
                        int iMin2 = Math.min(99, Math.max(1, Math.round(wVar.d() * 100.0f)));
                        long jN3 = arrayList2.isEmpty() ? 0L : com.byazt.bh.n.n(arrayList2, iMin);
                        long jN4 = arrayList2.isEmpty() ? 0L : com.byazt.bh.n.n(arrayList2, iMin2);
                        float size = !arrayList.isEmpty() ? (arrayList2.size() * 1.0f) / arrayList.size() : 0.0f;
                        if (jN4 <= 0 || jN2 <= 0) {
                            f = 1.0f;
                            f2 = 0.0f;
                        } else {
                            f = 1.0f;
                            f2 = (jN4 * 1.0f) / jN2;
                        }
                        float f7 = i11 > 0 ? (i9 * f) / i11 : 0.0f;
                        if (!wVar.py() || i11 < iMax || f7 < wVar.ou() / 100.0f) {
                            z = false;
                            z2 = false;
                        } else {
                            z = false;
                            z2 = true;
                        }
                        long jN5 = n(jFs, jN2, f3, f4, f5, f6, wVar);
                        if ((!(arrayList2.size() >= 5 ? true : z) || size <= 0.02f || f2 <= 0.0f || f2 >= 0.95f) ? z : true) {
                            float f8 = jN4;
                            long jFloor2 = (long) Math.floor(wVar.tj() * f8);
                            if (jFloor2 > 0) {
                                float fAbs = Math.abs(jFs - jFloor2) * 1.0f;
                                j2 = jFs;
                                float f9 = j2;
                                float fMin = (Math.min(1.0f, fAbs / f9) * 0.35f) + 0.15f;
                                jN5 = (long) ((f9 * (1.0f - fMin)) + (jFloor2 * fMin));
                            } else {
                                j2 = jFs;
                            }
                            long jFloor3 = (long) Math.floor(f8 * wVar.oa());
                            if (jFloor3 > 0) {
                                jN3 = Math.min(jN5, jFloor3);
                            } else {
                                j2 = jFs;
                                j2 = jFs;
                                j2 = jFs;
                                jN3 = jN5;
                            }
                        } else if (f6 <= wVar.sz() || f5 >= wVar.k() || jN3 <= 0) {
                            j2 = jFs;
                            j2 = jFs;
                            j2 = jFs;
                            jN3 = jN5;
                        } else {
                            j2 = jFs;
                        }
                        if (wVar.wm()) {
                            long jN6 = com.byazt.bh.n.n(arrayList, wVar.m());
                            float fHu = wVar.hu() / 100.0f;
                            if (jN6 > 0 && jN6 < j2 && size < fHu) {
                                jN3 = wVar.s();
                            }
                        }
                        long jN7 = com.byazt.bh.n.n(jN3, wVar.s(), wVar.qg());
                        if (jN7 <= 0) {
                            if (cursor2 == null) {
                                return null;
                            }
                            try {
                                cursor2.close();
                                return null;
                            } catch (Throwable unused5) {
                                return null;
                            }
                        }
                        if (!z2 || arrayList3.isEmpty()) {
                            jN = jN7;
                        } else {
                            Collections.sort(arrayList3);
                            long jN8 = com.byazt.bh.n.n(arrayList3, (int) (wVar.rv() * 100.0f));
                            if (jN8 > 0) {
                                jN = com.byazt.bh.n.n(jN8, wVar.s(), wVar.qg());
                            } else {
                                jN = jN7;
                            }
                        }
                        long j13 = ((z2 ? jN : jN7) - (i19 > 0 ? j8 / ((long) i19) : 0L)) - (i20 > 0 ? j9 / ((long) i20) : 0L);
                        n nVar = new n(jN7, System.currentTimeMillis(), -1, -1, z2, jN, j13 < 0 ? 0L : j13);
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Throwable unused6) {
                            }
                        }
                        return nVar;
                    } catch (Throwable unused7) {
                    }
                    cursor = cursor2;
                    if (cursor == null) {
                        return null;
                    }
                    try {
                        cursor.close();
                        return null;
                    } catch (Throwable unused8) {
                        return null;
                    }
                }
                Cursor cursor3 = cursorN;
                if (cursor3 == null) {
                    return null;
                }
                try {
                    cursor3.close();
                    return null;
                } catch (Throwable unused9) {
                    return null;
                }
            } catch (Throwable unused10) {
                cursor2 = cursorN;
            }
        } catch (Throwable unused11) {
            cursor = null;
        }
    }

    public static long n(long j, long j2, float f, float f2, float f3, float f4, fs.w wVar) {
        float f5;
        if (j <= 0 || j2 <= 0) {
            return -1L;
        }
        boolean z = false;
        boolean z2 = f2 < wVar.cy() || (f4 > wVar.sz() && f3 < wVar.k());
        if (f < wVar.hd() || f3 > wVar.um() || (f4 < wVar.a() && f < wVar.cd())) {
            z = true;
        }
        if (!z2 || z) {
            if (!z) {
                return j;
            }
            long jCeil = (long) Math.ceil(j2 * 1.15d);
            if (jCeil <= j) {
                return j;
            }
            if (f < 0.85f) {
                f5 = 0.4f;
            } else {
                f5 = f < 0.9f ? 0.25f : 0.15f;
            }
            return Math.min(((long) Math.ceil((jCeil - j) * f5)) + j, (long) Math.floor(j * 1.25d));
        }
        float f6 = 0.1f;
        if (f3 > 0.1f) {
            return j;
        }
        if (f2 < 0.2f) {
            f6 = 0.3f;
        } else if (f2 < 0.3f) {
            f6 = 0.2f;
        } else if (f4 < 0.2f || f4 > 0.3f) {
            f6 = 0.0f;
        }
        return Math.max(Math.max((long) ((j * (1.0f - f6)) + (j2 * f6)), (long) Math.ceil(j * 0.85d)), j2);
    }

    private static String n(fs.w wVar, int i, String str) {
        if (wVar == null) {
            return null;
        }
        if (wVar.q() == 0) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return "slot_" + i + "_" + str;
        }
        return "type_".concat(String.valueOf(i));
    }

    private n n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            com.byazt.gwu.s sVarQg = qg();
            long j = sVarQg.getLong(str + "_v", -1L);
            long j2 = sVarQg.getLong(str + "_ts", 0L);
            int i = sVarQg.getInt(str + "_price", 0);
            int i2 = sVarQg.getInt(str + "_min_price", 0);
            boolean z = sVarQg.getBoolean(str + "_cache_cb", false);
            long j3 = sVarQg.getLong(str + "_cached_tmax", j);
            long j4 = sVarQg.getLong(str + "_predict_server_tmax", 0L);
            if (j <= 0) {
                return null;
            }
            return new n(j, j2, i, i2, z, j3, j4);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, n nVar) {
        if (TextUtils.isEmpty(str) || nVar == null) {
            return;
        }
        try {
            com.byazt.gwu.s sVarQg = qg();
            String str2 = str + "_v";
            String str3 = str + "_ts";
            String str4 = str + "_price";
            String str5 = str + "_min_price";
            String str6 = str + "_cache_cb";
            String str7 = str + "_cached_tmax";
            sVarQg.n(str2, nVar.n);
            sVarQg.n(str3, nVar.qg);
            sVarQg.n(str4, nVar.s);
            sVarQg.n(str5, nVar.q);
            sVarQg.n(str6, nVar.l);
            sVarQg.n(str7, nVar.w);
            sVarQg.n(str + "_predict_server_tmax", nVar.x);
        } catch (Throwable unused) {
        }
    }

    private com.byazt.gwu.s qg() {
        return com.byazt.lk.l.qg(com.byazt.vgx.s.q(), "sp_dynamic_tmax_timeout", 0, null);
    }

    @com.byazt.cp.n(n = {0, 1, 125, 48})
    private static class n {
        public final boolean l;
        public final long n;
        public final int q;
        public final long qg;
        public final int s;
        public final long w;
        public final long x;

        public n(long j, long j2, int i, int i2, boolean z) {
            this(j, j2, i, i2, z, j);
        }

        public n(long j, long j2, int i, int i2, boolean z, long j3) {
            this(j, j2, i, i2, z, j3, 0L);
        }

        public n(long j, long j2, int i, int i2, boolean z, long j3, long j4) {
            this.n = j;
            this.qg = j2;
            this.s = i;
            this.q = i2;
            this.l = z;
            this.w = j3 > 0 ? j3 : j;
            this.x = j4;
        }

        public boolean n(fs.w wVar) {
            return this.qg <= 0 || System.currentTimeMillis() - this.qg > ((long) wVar.x()) * 1000;
        }
    }
}
