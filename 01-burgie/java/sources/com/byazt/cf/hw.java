package com.byazt.cf;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.byazt.hg.zo;
import com.byazt.sd.a;
import com.byazt.xlm.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.ar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 440, 13})
public class hw {
    public static final hw pr = new hw();
    public final LruCache<String, pr> hw = new LruCache<>(64);
    public final ConcurrentHashMap<String, Boolean> hn = new ConcurrentHashMap<>();

    public static hw pr() {
        return pr;
    }

    public long pr(int i, String str) {
        long j;
        long j2;
        zo.hn hnVarPr = zo.pr(i);
        if (hnVarPr == null || hnVarPr.yb() == null) {
            return -1L;
        }
        zo.c cVarYb = hnVarPr.yb();
        if (!cVarYb.hw() || cVarYb.hn() <= 0) {
            return -1L;
        }
        String strPr = pr(cVarYb, i, str);
        if (TextUtils.isEmpty(strPr)) {
            return -1L;
        }
        pr prVar = this.hw.get(strPr);
        if (prVar == null) {
            j = -1;
        } else {
            if (!prVar.pr(cVarYb)) {
                return prVar.pr;
            }
            j = prVar.pr;
        }
        pr prVarPr = pr(strPr);
        if (prVarPr == null) {
            j2 = j;
        } else {
            if (!prVarPr.pr(cVarYb)) {
                this.hw.put(strPr, prVarPr);
                return prVarPr.pr;
            }
            j2 = prVarPr.pr;
        }
        pr(strPr, cVarYb, i, str, j2);
        if (j2 > 0) {
            return j2;
        }
        return -1L;
    }

    private void pr(final String str, final zo.c cVar, final int i, final String str2, final long j) {
        if (this.hn.putIfAbsent(str, Boolean.TRUE) != null) {
            return;
        }
        com.byazt.zp.zo.pr(new fw("dynamic_tmax_calc") { // from class: com.byazt.cf.hw.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pr prVarPr = hw.this.pr(cVar, i, str2, j);
                    if (prVarPr != null) {
                        hw.this.hw.put(str, prVarPr);
                        hw.this.pr(str, prVarPr);
                    }
                } finally {
                    hw.this.hn.remove(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public pr pr(zo.c cVar, int i, String str, long j) {
        Cursor cursorPr;
        long jMin;
        long jCurrentTimeMillis = System.currentTimeMillis() - 604800000;
        long j2 = 0;
        if (jCurrentTimeMillis <= 0) {
            return null;
        }
        try {
            if (cVar.c() != 0) {
                cursorPr = c.pr(i, jCurrentTimeMillis, "record_time DESC");
            } else {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                cursorPr = c.pr(i, str, jCurrentTimeMillis, "record_time DESC");
            }
            if (cursorPr == null) {
                if (cursorPr != null) {
                    try {
                        cursorPr.close();
                    } catch (Throwable th) {
                    }
                }
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int columnIndex = cursorPr.getColumnIndex("loaded_duration");
                int columnIndex2 = cursorPr.getColumnIndex("is_shown");
                if (columnIndex >= 0 && columnIndex2 >= 0) {
                    long jHn = j <= 0 ? cVar.hn() : j;
                    if (jHn <= 0) {
                        if (cursorPr != null) {
                            try {
                                cursorPr.close();
                            } catch (Throwable th2) {
                            }
                        }
                        return null;
                    }
                    long jFloor = (long) Math.floor(jHn * 0.8d);
                    long j3 = 0;
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (cursorPr.moveToNext() && i2 < cVar.fw()) {
                        i2++;
                        long j4 = cursorPr.getLong(columnIndex);
                        int i6 = cursorPr.getInt(columnIndex2);
                        if (j4 > j2 && j4 >= cVar.x() && j4 <= cVar.hn()) {
                            arrayList.add(Long.valueOf(j4));
                            if (i6 == 1) {
                                arrayList2.add(Long.valueOf(j4));
                            }
                        }
                        if (j4 <= j2 || j4 > jHn) {
                            j3 = j3;
                        } else {
                            i3++;
                            j3 += j4;
                            i4++;
                            if (j4 >= jFloor) {
                                i5++;
                            }
                        }
                        j2 = 0;
                    }
                    long j5 = j3;
                    if (arrayList.isEmpty()) {
                        if (cursorPr == null) {
                            return null;
                        }
                        try {
                            cursorPr.close();
                            return null;
                        } catch (Throwable th3) {
                            return null;
                        }
                    }
                    int iMax = Math.max(0, cVar.uc());
                    if (iMax > 0 && arrayList.size() < iMax) {
                        if (cursorPr == null) {
                            return null;
                        }
                        try {
                            cursorPr.close();
                            return null;
                        } catch (Throwable th4) {
                            return null;
                        }
                    }
                    Collections.sort(arrayList);
                    if (!arrayList2.isEmpty()) {
                        Collections.sort(arrayList2);
                    }
                    com.byazt.cf.pr.pr(arrayList, (int) (cVar.aj() * 100.0f));
                    long jPr = com.byazt.cf.pr.pr(arrayList, (int) (cVar.vk() * 100.0f));
                    com.byazt.cf.pr.pr(arrayList, (int) (cVar.w() * 100.0f));
                    float f = i2 > 0 ? (i3 * 1.0f) / i2 : 0.0f;
                    float f2 = i4 > 0 ? ((j5 * 1.0f) / i4) / jHn : 0.0f;
                    float f3 = i3 > 0 ? (i5 * 1.0f) / i3 : 0.0f;
                    float f4 = jPr > 0 ? ((jHn - jPr) * 1.0f) / jPr : 0.0f;
                    int iMin = Math.min(99, Math.max(1, Math.round(cVar.m() * 100.0f)));
                    int iMin2 = Math.min(99, Math.max(1, Math.round(cVar.g() * 100.0f)));
                    int iMin3 = Math.min(99, Math.max(1, Math.round(cVar.ho() * 100.0f)));
                    long jPr2 = arrayList2.isEmpty() ? 0L : com.byazt.cf.pr.pr(arrayList2, iMin);
                    if (!arrayList2.isEmpty()) {
                        com.byazt.cf.pr.pr(arrayList2, iMin2);
                    }
                    long jPr3 = arrayList2.isEmpty() ? 0L : com.byazt.cf.pr.pr(arrayList2, iMin3);
                    float size = !arrayList.isEmpty() ? (arrayList2.size() * 1.0f) / arrayList.size() : 0.0f;
                    float f5 = (jPr3 <= 0 || jPr <= 0) ? 0.0f : (jPr3 * 1.0f) / jPr;
                    long jPr4 = pr(jHn, jPr, f, f2, f3, f4, cVar);
                    if ((arrayList2.size() >= 5) && size > 0.02f && f5 > 0.0f && f5 < 0.95f) {
                        float f6 = jPr3;
                        long jFloor2 = (long) Math.floor(cVar.k() * f6);
                        if (jFloor2 > 0) {
                            float f7 = jHn;
                            float fMin = (Math.min(1.0f, (Math.abs(jHn - jFloor2) * 1.0f) / f7) * 0.35f) + 0.15f;
                            jPr4 = (long) ((f7 * (1.0f - fMin)) + (jFloor2 * fMin));
                        }
                        long jFloor3 = (long) Math.floor(f6 * cVar.nt());
                        jMin = jFloor3 > 0 ? Math.min(jPr4, jFloor3) : jPr4;
                    } else {
                        jMin = (f4 <= cVar.yb() || f3 >= cVar.lb() || jPr2 <= 0) ? jPr4 : jPr2;
                    }
                    long jPr5 = com.byazt.cf.pr.pr(jMin, cVar.x(), cVar.hn());
                    if (jPr5 > 0) {
                        pr prVar = new pr(jPr5, System.currentTimeMillis());
                        if (cursorPr != null) {
                            try {
                                cursorPr.close();
                            } catch (Throwable th5) {
                            }
                        }
                        return prVar;
                    }
                    if (cursorPr == null) {
                        return null;
                    }
                    try {
                        cursorPr.close();
                        return null;
                    } catch (Throwable th6) {
                        return null;
                    }
                }
                if (cursorPr == null) {
                    return null;
                }
                try {
                    cursorPr.close();
                    return null;
                } catch (Throwable th7) {
                    return null;
                }
            } catch (Throwable th8) {
                if (cursorPr == null) {
                    return null;
                }
                try {
                    cursorPr.close();
                    return null;
                } catch (Throwable th9) {
                    return null;
                }
            }
        } catch (Throwable th10) {
            cursorPr = null;
        }
    }

    public static long pr(long j, long j2, float f, float f2, float f3, float f4, zo.c cVar) {
        float f5;
        if (j <= 0 || j2 <= 0) {
            return -1L;
        }
        boolean z = false;
        boolean z2 = f2 < cVar.qa() || (f4 > cVar.yb() && f3 < cVar.lb());
        if (f < cVar.a() || f3 > cVar.ny() || (f4 < cVar.fo() && f < cVar.cz())) {
            z = true;
        }
        if (z2 && !z) {
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
        if (z) {
            long jCeil = (long) Math.ceil(j2 * 1.15d);
            if (jCeil <= j) {
                return j;
            }
            if (f < 0.85f) {
                f5 = 0.4f;
            } else if (f < 0.9f) {
                f5 = 0.25f;
            } else {
                f5 = 0.15f;
            }
            return Math.min(((long) Math.ceil((jCeil - j) * f5)) + j, (long) Math.floor(j * 1.25d));
        }
        return j;
    }

    private static String pr(zo.c cVar, int i, String str) {
        if (cVar == null) {
            return null;
        }
        if (cVar.c() == 0) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return "slot_" + i + "_" + str;
        }
        return "type_".concat(String.valueOf(i));
    }

    private SharedPreferences hw() {
        return com.byazt.mg.hw.hw(a.getContext(), "sp_dynamic_tmax_timeout", 0);
    }

    private pr pr(String str) {
        long jPr;
        long jPr2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (com.byazt.mp.hn.pr().hw()) {
                jPr = com.byazt.jc.hw.pr("sp_dynamic_tmax_timeout", str + "_v", -1L);
                jPr2 = com.byazt.jc.hw.pr("sp_dynamic_tmax_timeout", str + ar.h, 0L);
            } else {
                SharedPreferences sharedPreferencesHw = hw();
                jPr = sharedPreferencesHw.getLong(str + "_v", -1L);
                jPr2 = sharedPreferencesHw.getLong(str + ar.h, 0L);
            }
            if (jPr <= 0) {
                return null;
            }
            return new pr(jPr, jPr2);
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str, pr prVar) {
        if (TextUtils.isEmpty(str) || prVar == null) {
            return;
        }
        try {
            if (com.byazt.mp.hn.pr().hw()) {
                com.byazt.jc.hw.pr("sp_dynamic_tmax_timeout", str + "_v", Long.valueOf(prVar.pr));
                com.byazt.jc.hw.pr("sp_dynamic_tmax_timeout", str + ar.h, Long.valueOf(prVar.hw));
            } else {
                SharedPreferences.Editor editorEdit = hw().edit();
                editorEdit.putLong(str + "_v", prVar.pr);
                editorEdit.putLong(str + ar.h, prVar.hw);
                editorEdit.apply();
            }
        } catch (Throwable th) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 440, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static class pr {
        public final long hw;
        public final long pr;

        public pr(long j, long j2) {
            this.pr = j;
            this.hw = j2;
        }

        public boolean pr(zo.c cVar) {
            return this.hw <= 0 || System.currentTimeMillis() - this.hw > ((long) cVar.zo()) * 1000;
        }
    }
}
