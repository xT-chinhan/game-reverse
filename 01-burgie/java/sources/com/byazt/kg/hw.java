package com.byazt.kg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.ec.g;
import com.byazt.ec.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import kotlin.jvm.internal.LongCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 421, 13})
public class hw {
    public static final C0115hw[] hn;
    public static final com.byazt.kg.pr[] uc;
    public final pr c;
    public String fw;
    public final com.byazt.gox.x x;
    public static final int[] pr = {1};
    public static final HashMap<String, com.byazt.kg.pr> hw = new HashMap<>();

    static {
        pr(new aj());
        pr(new uc(true));
        pr(new vk());
        pr(new zo());
        com.byazt.kg.pr[] prVarArr = {new hn(), new c(null, false, null), new x("", new JSONObject())};
        uc = prVarArr;
        for (int i = 0; i < 3; i++) {
            pr(prVarArr[i]);
        }
        hn = new C0115hw[]{new C0115hw(), new C0115hw(), new C0115hw()};
    }

    private String pr(String str, boolean z) {
        return "SELECT * FROM page WHERE session_id" + (z ? "='" : "!='") + str + "' ORDER BY " + (z ? "session_id," : "") + "duration DESC LIMIT 500";
    }

    private String hw(String str, boolean z) {
        return "DELETE FROM page WHERE session_id" + (z ? "='" : "!='") + str + "'";
    }

    private String pr(com.byazt.kg.pr prVar, String str, boolean z, int i, int i2) {
        return "SELECT * FROM " + prVar.x() + " WHERE session_id" + (z ? "='" : "!='") + str + "' AND event_type='" + i2 + "' ORDER BY _id LIMIT " + i;
    }

    private String pr(String str, int i, String str2, boolean z, long j) {
        return "DELETE FROM " + str + " WHERE session_id" + (z ? "='" : "!='") + str2 + "' AND event_type='" + i + "' AND _id<=" + j;
    }

    private String pr(long j, int i) {
        return "UPDATE pack SET _fail=" + i + " WHERE _id=" + j;
    }

    public hw(com.byazt.gox.x xVar) {
        this.c = new pr(xVar.getContext(), "bd_embed_tea_agent.db", null, 30);
        this.x = xVar;
    }

    private static void pr(com.byazt.kg.pr prVar) {
        hw.put(prVar.x(), prVar);
    }

    /* JADX INFO: renamed from: com.byazt.kg.hw$hw, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 421, 497})
    static class C0115hw {
        public int hn;
        public int hw;
        public String pr;

        /* JADX INFO: Access modifiers changed from: private */
        public static void hw() {
            for (C0115hw c0115hw : hw.hn) {
                c0115hw.pr = "";
                c0115hw.hw = 0;
                c0115hw.hn = 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pr(com.byazt.kg.pr prVar) {
            String strAj = prVar.aj();
            if (strAj != null && strAj.length() > this.hw) {
                this.pr = prVar.zo();
                this.hw = strAj.length();
            }
        }

        public String toString() {
            return new StringBuilder(this.hn).append("-").append(this.pr).append("-").append(this.hw).toString();
        }
    }

    private boolean pr(String str) {
        w.pr("needLaunch, " + this.fw + ", " + str);
        if (TextUtils.equals(str, this.fw)) {
            return false;
        }
        this.fw = str;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:114:0x016a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public synchronized ArrayList<zo> pr(JSONObject jSONObject) {
        ArrayList<zo> arrayList;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase2;
        String str;
        long[] jArr;
        JSONObject jSONObject2;
        SQLiteDatabase sQLiteDatabase3;
        HashMap<String, com.byazt.kg.pr> map = hw;
        uc ucVar = (uc) map.get("launch");
        vk vkVar = (vk) map.get("terminate");
        aj ajVar = (aj) map.get("page");
        zo zoVar = (zo) map.get("pack");
        arrayList = new ArrayList<>();
        Cursor cursor2 = null;
        try {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr2 = new long[3];
            SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT * FROM launch ORDER BY _id LIMIT 5", null);
                try {
                    com.byazt.gox.fw fwVarUc = this.x.uc();
                    String strPr = fwVarUc.pr();
                    boolean zHw = fwVarUc.hw();
                    JSONObject jSONObject3 = jSONObject;
                    long j = Long.MIN_VALUE;
                    long j2 = Long.MAX_VALUE;
                    try {
                        while (true) {
                            if (!cursorRawQuery.moveToNext()) {
                                break;
                            }
                            try {
                                ucVar.pr(cursorRawQuery);
                                zoVar.x = ucVar.x;
                                JSONObject jSONObjectPr = pr(ucVar, jSONObject);
                                if (TextUtils.equals(ucVar.x, strPr)) {
                                    try {
                                        ucVar.g = zHw ? false : true;
                                        jSONObject2 = jSONObjectPr;
                                        cursor = cursorRawQuery;
                                        sQLiteDatabase3 = writableDatabase;
                                        try {
                                            pr(jSONObjectPr, ucVar, zoVar, writableDatabase, jSONArrayArr, jArr2, arrayList);
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor2 = cursor;
                                            sQLiteDatabase = sQLiteDatabase3;
                                            w.hw(th);
                                            if (cursor2 != null) {
                                                try {
                                                    cursor2.close();
                                                } catch (Throwable th2) {
                                                    w.hw(th2);
                                                }
                                            }
                                            g.pr(sQLiteDatabase);
                                            return arrayList;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        cursor = cursorRawQuery;
                                        sQLiteDatabase3 = writableDatabase;
                                    }
                                } else {
                                    jSONObject2 = jSONObjectPr;
                                    cursor = cursorRawQuery;
                                    sQLiteDatabase3 = writableDatabase;
                                    try {
                                        if (ucVar.pr < j2) {
                                            j2 = ucVar.pr;
                                        }
                                        if (ucVar.pr > j) {
                                            j = ucVar.pr;
                                        }
                                        pr(jSONObject2, ucVar, zoVar, ajVar, vkVar, sQLiteDatabase3, jSONArrayArr, jArr2);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        sQLiteDatabase = sQLiteDatabase3;
                                    }
                                }
                                JSONObject jSONObject4 = jSONObject2;
                                sQLiteDatabase = sQLiteDatabase3;
                                try {
                                    pr(jSONObject4, true, zoVar, sQLiteDatabase);
                                    jSONObject3 = jSONObject4;
                                    writableDatabase = sQLiteDatabase;
                                    strPr = strPr;
                                    cursorRawQuery = cursor;
                                    jArr2 = jArr2;
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                cursor = cursorRawQuery;
                                sQLiteDatabase = writableDatabase;
                            }
                            cursor2 = cursor;
                            try {
                                w.hw(th);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                g.pr(sQLiteDatabase);
                            } catch (Throwable th7) {
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Throwable th8) {
                                        w.hw(th8);
                                    }
                                }
                                g.pr(sQLiteDatabase);
                                throw th7;
                            }
                        }
                        if (cursor.getCount() >= 5 || TextUtils.isEmpty(str)) {
                            sQLiteDatabase2 = sQLiteDatabase;
                        } else {
                            JSONObject jSONObject5 = jSONObject3;
                            sQLiteDatabase2 = sQLiteDatabase;
                            try {
                                pr(jSONObject3, ucVar, vkVar, ajVar, zoVar, sQLiteDatabase, str, jSONArrayArr, jArr);
                                pr(jSONObject5, false, zoVar, sQLiteDatabase2);
                            } catch (Throwable th9) {
                                th = th9;
                                sQLiteDatabase = sQLiteDatabase2;
                                cursor2 = cursor;
                                w.hw(th);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                g.pr(sQLiteDatabase);
                            }
                        }
                        sQLiteDatabase2.setTransactionSuccessful();
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th10) {
                                w.hw(th10);
                            }
                        }
                        g.pr(sQLiteDatabase2);
                    } catch (Throwable th11) {
                        th = th11;
                        cursor2 = cursor;
                        w.hw(th);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        g.pr(sQLiteDatabase);
                    }
                    str = strPr;
                    cursor = cursorRawQuery;
                    jArr = jArr2;
                    sQLiteDatabase = writableDatabase;
                    if (j2 != LongCompanionObject.MAX_VALUE && j != Long.MIN_VALUE) {
                        sQLiteDatabase.execSQL("DELETE FROM launch WHERE _id>=? AND _id<=?", new String[]{String.valueOf(j2), String.valueOf(j)});
                    }
                } catch (Throwable th12) {
                    th = th12;
                    cursor = cursorRawQuery;
                    sQLiteDatabase2 = writableDatabase;
                }
            } catch (Throwable th13) {
                th = th13;
                sQLiteDatabase = writableDatabase;
            }
        } catch (Throwable th14) {
            th = th14;
            sQLiteDatabase = null;
        }
        return arrayList;
    }

    private void pr(JSONObject jSONObject, boolean z, zo zoVar, SQLiteDatabase sQLiteDatabase) {
        for (int i : pr) {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr = new long[3];
            int iPr = pr(0, sQLiteDatabase, zoVar.x, z, i, jSONArrayArr, jArr);
            if (pr(jArr)) {
                int i2 = iPr;
                while (true) {
                    zoVar.pr(jSONObject, null, null, null, jSONArrayArr, jArr, i);
                    pr(zoVar, z, sQLiteDatabase, true);
                    int iPr2 = i2;
                    while (true) {
                        if (iPr2 < uc.length) {
                            iPr2 = pr(iPr2, sQLiteDatabase, zoVar.x, z, i, jSONArrayArr, jArr);
                            if (pr(jArr)) {
                                i2 = iPr2;
                            }
                        }
                    }
                }
            }
        }
    }

    private JSONObject pr(uc ucVar, JSONObject jSONObject) {
        if (!TextUtils.equals(ucVar.m, this.x.x().hn()) || ucVar.k != this.x.x().hw()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                g.hn(jSONObject2, jSONObject);
                jSONObject2.put("app_version", ucVar.m);
                jSONObject2.put("version_code", ucVar.k);
                return jSONObject2;
            } catch (JSONException e) {
                w.hw(e);
                return jSONObject;
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0086  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:29:0x009b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0081 A[SYNTHETIC] */
    private void pr(JSONObject jSONObject, uc ucVar, zo zoVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, ArrayList<zo> arrayList) {
        long[] jArr2;
        SQLiteDatabase sQLiteDatabase2;
        long[] jArr3;
        hw hwVar;
        zo zoVar2;
        int iPr;
        uc ucVar2;
        w.pr("packCurrentData, " + ucVar.x);
        boolean zPr = pr(ucVar.x);
        int iPr2 = pr(0, sQLiteDatabase, ucVar.x, true, 0, jSONArrayArr, jArr);
        if (!zPr) {
            jArr2 = jArr;
            if (!pr(jArr2)) {
                sQLiteDatabase2 = sQLiteDatabase;
                iPr = iPr2;
                jArr3 = jArr2;
                hwVar = this;
                zoVar2 = zoVar;
            }
            while (iPr < uc.length) {
                iPr = hwVar.pr(iPr, sQLiteDatabase2, ucVar.x, true, 0, jSONArrayArr, jArr3);
                if (!hwVar.pr(jArr3)) {
                    if (hwVar.pr(ucVar.x)) {
                        ucVar2 = ucVar;
                    } else {
                        ucVar2 = null;
                    }
                    zoVar2.pr(jSONObject, ucVar2, null, null, jSONArrayArr, jArr3, 0);
                    hwVar.pr(zoVar2, true, sQLiteDatabase2, true);
                    iPr = iPr;
                }
            }
        }
        jArr2 = jArr;
        zoVar.pr(jSONObject, zPr ? ucVar : null, null, null, jSONArrayArr, jArr, 0);
        if (iPr2 < uc.length) {
            sQLiteDatabase2 = sQLiteDatabase;
            jArr3 = jArr2;
            hwVar = this;
            zoVar2 = zoVar;
            hwVar.pr(zoVar2, true, sQLiteDatabase2, true);
            iPr = iPr2;
        } else {
            zo zoVar3 = (zo) zoVar.clone();
            zoVar3.vk();
            arrayList.add(zoVar3);
            sQLiteDatabase2 = sQLiteDatabase;
            iPr = iPr2;
            jArr3 = jArr2;
            hwVar = this;
            zoVar2 = zoVar;
        }
        while (iPr < uc.length) {
            iPr = hwVar.pr(iPr, sQLiteDatabase2, ucVar.x, true, 0, jSONArrayArr, jArr3);
            if (!hwVar.pr(jArr3)) {
                if (hwVar.pr(ucVar.x)) {
                    ucVar2 = ucVar;
                } else {
                    ucVar2 = null;
                }
                zoVar2.pr(jSONObject, ucVar2, null, null, jSONArrayArr, jArr3, 0);
                hwVar.pr(zoVar2, true, sQLiteDatabase2, true);
                iPr = iPr;
            }
        }
    }

    private void pr(JSONObject jSONObject, uc ucVar, zo zoVar, aj ajVar, vk vkVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr) {
        w.pr("packHistoryData, " + ucVar.x);
        JSONArray jSONArrayPr = pr(ucVar, true, vkVar, ajVar, sQLiteDatabase);
        boolean z = true;
        ucVar.g = jSONArrayPr.length() == 0;
        int iPr = pr(0, sQLiteDatabase, ucVar.x, true, 0, jSONArrayArr, jArr);
        if (ucVar.g) {
            zoVar.pr(jSONObject, pr(ucVar.x) ? ucVar : null, null, null, jSONArrayArr, jArr, 0);
        } else {
            zoVar.pr(jSONObject, null, vkVar, jSONArrayPr, jSONArrayArr, jArr, 0);
        }
        while (true) {
            pr(zoVar, z, sQLiteDatabase, z);
            int iPr2 = iPr;
            while (iPr2 < uc.length) {
                boolean z2 = z;
                iPr2 = pr(iPr2, sQLiteDatabase, ucVar.x, true, 0, jSONArrayArr, jArr);
                if (pr(jArr)) {
                    zoVar.pr(jSONObject, null, null, null, jSONArrayArr, jArr, 0);
                    iPr = iPr2;
                    z = z2;
                } else {
                    z = z2;
                }
            }
            return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:30:0x00d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:? A[LOOP:0: B:22:0x00b0->B:32:?, LOOP_END, SYNTHETIC] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void pr(org.json.JSONObject r17, com.byazt.kg.uc r18, com.byazt.kg.vk r19, com.byazt.kg.aj r20, com.byazt.kg.zo r21, android.database.sqlite.SQLiteDatabase r22, java.lang.String r23, org.json.JSONArray[] r24, long[] r25) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.kg.hw.pr(org.json.JSONObject, com.byazt.kg.uc, com.byazt.kg.vk, com.byazt.kg.aj, com.byazt.kg.zo, android.database.sqlite.SQLiteDatabase, java.lang.String, org.json.JSONArray[], long[]):void");
    }

    private boolean pr(long[] jArr) {
        return jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0;
    }

    public void pr(zo zoVar, boolean z, SQLiteDatabase sQLiteDatabase, boolean z2) {
        boolean z3;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = this.c.getWritableDatabase();
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Throwable th) {
                try {
                    w.hw(th);
                    if (!z3) {
                        return;
                    }
                } finally {
                    if (z3) {
                        g.pr(sQLiteDatabase);
                    }
                }
            }
        }
        if (z2 && sQLiteDatabase.insert("pack", null, zoVar.hw((ContentValues) null)) < 0) {
            if (zoVar.qa != null) {
                pr((String) null);
            }
            if (z3) {
                g.pr(sQLiteDatabase);
                return;
            }
            return;
        }
        if (zoVar.nt > 0) {
            sQLiteDatabase.execSQL(pr(NotificationCompat.CATEGORY_EVENT, zoVar.vk, zoVar.x, z, zoVar.nt));
        }
        if (zoVar.lb > 0) {
            sQLiteDatabase.execSQL(pr("eventv3", zoVar.vk, zoVar.x, z, zoVar.lb));
        }
        if (zoVar.cz > 0) {
            sQLiteDatabase.execSQL(pr("event_misc", zoVar.vk, zoVar.x, z, zoVar.cz));
        }
        if (z3) {
            sQLiteDatabase.setTransactionSuccessful();
        }
        if (!z3) {
        }
    }

    private int pr(int i, SQLiteDatabase sQLiteDatabase, String str, boolean z, int i2, JSONArray[] jSONArrayArr, long[] jArr) {
        C0115hw.hw();
        int i3 = 0;
        while (i3 < i) {
            jSONArrayArr[i3] = null;
            jArr[i3] = 0;
            i3++;
        }
        int i4 = i3;
        int i5 = 200;
        while (i5 > 0 && i4 < uc.length) {
            pr(sQLiteDatabase, str, i5, i4, z, jSONArrayArr, jArr, i2);
            int length = jSONArrayArr[i4].length();
            i5 -= length;
            hn[i4].hn = length;
            if (i5 > 0) {
                i4++;
            }
        }
        for (int i6 = i4 + 1; i6 < jSONArrayArr.length; i6++) {
            jSONArrayArr[i6] = null;
            jArr[i6] = 0;
        }
        return i4;
    }

    private void pr(SQLiteDatabase sQLiteDatabase, String str, int i, int i2, boolean z, JSONArray[] jSONArrayArr, long[] jArr, int i3) {
        com.byazt.kg.pr prVar = uc[i2];
        JSONArray jSONArray = new JSONArray();
        Cursor cursor = null;
        long j = 0;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery(pr(prVar, str, z, i, i3), null);
            for (int i4 = 0; cursorRawQuery.moveToNext() && i4 <= 200; i4++) {
                try {
                    prVar.pr(cursorRawQuery);
                    hn[i2].pr(prVar);
                    if (w.hw) {
                        w.pr("queryEvent, " + prVar, null);
                    }
                    jSONArray.put(prVar.uc());
                    if (prVar.pr > j) {
                        j = prVar.pr;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    try {
                        w.hw(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th2) {
                        if (cursor != null) {
                            cursor.close();
                            throw th2;
                        }
                        throw th2;
                    }
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable th3) {
            th = th3;
        }
        jSONArrayArr[i2] = jSONArray;
        jArr[i2] = j;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00e8 A[PHI: r12 r16 r18 r19
      0x00e8: PHI (r12v2 android.database.Cursor) = (r12v3 android.database.Cursor), (r12v6 android.database.Cursor) binds: [B:48:0x00e6, B:38:0x00d2] A[DONT_GENERATE, DONT_INLINE]
      0x00e8: PHI (r16v2 long) = (r16v3 long), (r16v5 long) binds: [B:48:0x00e6, B:38:0x00d2] A[DONT_GENERATE, DONT_INLINE]
      0x00e8: PHI (r18v3 java.lang.String) = (r18v4 java.lang.String), (r18v7 java.lang.String) binds: [B:48:0x00e6, B:38:0x00d2] A[DONT_GENERATE, DONT_INLINE]
      0x00e8: PHI (r19v2 java.lang.String) = (r19v3 java.lang.String), (r19v5 java.lang.String) binds: [B:48:0x00e6, B:38:0x00d2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:52:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:58:0x010a  */
    /* JADX WARN: Code duplicated, block: B:61:0x013d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0142  */
    /* JADX WARN: Code duplicated, block: B:64:0x0148  */
    private JSONArray pr(uc ucVar, boolean z, vk vkVar, aj ajVar, SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery;
        String str;
        String str2;
        long j;
        String str3;
        String str4;
        long j2;
        JSONArray jSONArray = new JSONArray();
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(pr(ucVar.x, z), null);
            boolean z2 = false;
            try {
                HashMap map = new HashMap(8);
                str = null;
                str2 = null;
                j = 0;
                while (cursorRawQuery.moveToNext()) {
                    try {
                        ajVar.pr(cursorRawQuery);
                        if (w.hw) {
                            w.pr("queryPage, " + ajVar, null);
                        }
                        Integer num = (Integer) map.get(ajVar.g);
                        if (!ajVar.vk()) {
                            map.put(ajVar.g, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                            if (ajVar.k >= 1000) {
                                j += ajVar.k;
                            } else {
                                j += 1000;
                            }
                            jSONArray.put(ajVar.uc());
                            if (TextUtils.isEmpty(ajVar.a)) {
                                continue;
                            } else {
                                String str5 = ajVar.a;
                                try {
                                    str = str5;
                                    str2 = ajVar.uc;
                                } catch (Throwable th) {
                                    th = th;
                                    str = str5;
                                    try {
                                        w.hw(th);
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                        }
                                        str3 = str;
                                        str4 = str2;
                                        if (jSONArray.length() > 0) {
                                            j2 = j > 1000 ? j : 1000L;
                                            vkVar.k = j2;
                                            if (z) {
                                                vkVar.x = ucVar.x;
                                                vkVar.pr(ucVar.hw + j2);
                                            } else {
                                                vkVar.x = UUID.randomUUID().toString();
                                                vkVar.pr(0L);
                                            }
                                            vkVar.c = ucVar.c;
                                            vkVar.uc = ucVar.uc;
                                            vkVar.fw = ucVar.fw;
                                            vkVar.zo = ucVar.zo;
                                            vkVar.m = vkVar.hw;
                                            vkVar.hn = com.byazt.gox.fw.x();
                                            vkVar.g = null;
                                            if (!TextUtils.isEmpty(ucVar.ho)) {
                                                vkVar.g = ucVar.ho;
                                            } else if (!TextUtils.isEmpty(str3)) {
                                                vkVar.g = str3;
                                                vkVar.uc = str4;
                                            }
                                        }
                                        return jSONArray;
                                    } catch (Throwable th2) {
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                            throw th2;
                                        }
                                        throw th2;
                                    }
                                }
                            }
                        } else if (num != null) {
                            Integer numValueOf = Integer.valueOf(num.intValue() - 1);
                            if (numValueOf.intValue() > 0) {
                                map.put(ajVar.g, numValueOf);
                            } else {
                                map.remove(ajVar.g);
                            }
                        } else {
                            ajVar.k = 1000L;
                            j += ajVar.k;
                            jSONArray.put(ajVar.uc());
                        }
                        z2 = true;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                if (z2) {
                    sQLiteDatabase.execSQL(hw(ucVar.x, z));
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Throwable th4) {
                th = th4;
                str = null;
                str2 = str;
                j = 0;
                w.hw(th);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                str3 = str;
                str4 = str2;
                if (jSONArray.length() > 0) {
                    if (j > 1000) {
                    }
                    vkVar.k = j2;
                    if (z) {
                        vkVar.x = ucVar.x;
                        vkVar.pr(ucVar.hw + j2);
                    } else {
                        vkVar.x = UUID.randomUUID().toString();
                        vkVar.pr(0L);
                    }
                    vkVar.c = ucVar.c;
                    vkVar.uc = ucVar.uc;
                    vkVar.fw = ucVar.fw;
                    vkVar.zo = ucVar.zo;
                    vkVar.m = vkVar.hw;
                    vkVar.hn = com.byazt.gox.fw.x();
                    vkVar.g = null;
                    if (!TextUtils.isEmpty(ucVar.ho)) {
                        vkVar.g = ucVar.ho;
                    } else if (!TextUtils.isEmpty(str3)) {
                        vkVar.g = str3;
                        vkVar.uc = str4;
                    }
                }
                return jSONArray;
            }
        } catch (Throwable th5) {
            th = th5;
            cursorRawQuery = null;
            str = null;
        }
        str3 = str;
        str4 = str2;
        if (jSONArray.length() > 0) {
            if (j > 1000) {
            }
            vkVar.k = j2;
            if (z) {
                vkVar.x = ucVar.x;
                vkVar.pr(ucVar.hw + j2);
            } else {
                vkVar.x = UUID.randomUUID().toString();
                vkVar.pr(0L);
            }
            vkVar.c = ucVar.c;
            vkVar.uc = ucVar.uc;
            vkVar.fw = ucVar.fw;
            vkVar.zo = ucVar.zo;
            vkVar.m = vkVar.hw;
            vkVar.hn = com.byazt.gox.fw.x();
            vkVar.g = null;
            if (!TextUtils.isEmpty(ucVar.ho)) {
                vkVar.g = ucVar.ho;
            } else if (!TextUtils.isEmpty(str3)) {
                vkVar.g = str3;
                vkVar.uc = str4;
            }
        }
        return jSONArray;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003c A[PHI: r3
      0x003c: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v6 android.database.Cursor) binds: [B:15:0x003a, B:8:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    public ArrayList<zo> pr() {
        Cursor cursorRawQuery;
        ArrayList<zo> arrayList = new ArrayList<>();
        zo zoVar = (zo) hw.get("pack");
        try {
            cursorRawQuery = this.c.getWritableDatabase().rawQuery("SELECT * FROM pack ORDER BY _id DESC LIMIT 8", null);
            while (cursorRawQuery.moveToNext()) {
                try {
                    zoVar = (zo) zoVar.clone();
                    zoVar.pr(cursorRawQuery);
                    arrayList.add(zoVar);
                } catch (Throwable th) {
                    th = th;
                    try {
                        w.hw(th);
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } catch (Throwable th2) {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        throw th2;
                    }
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable th3) {
            th = th3;
            cursorRawQuery = null;
        }
        w.pr("queryPack, " + arrayList, null);
        return arrayList;
    }

    public void setResult(ArrayList<zo> arrayList, ArrayList<zo> arrayList2, ArrayList<zo> arrayList3) {
        SQLiteDatabase sQLiteDatabase = null;
        w.pr("setResult, " + arrayList + ", " + arrayList2, null);
        Iterator<zo> it = arrayList2.iterator();
        while (it.hasNext()) {
            zo next = it.next();
            if (!arrayList3.contains(next) && Math.abs(System.currentTimeMillis() - next.hw) > 864000000) {
                arrayList.add(next);
                it.remove();
            }
        }
        try {
            SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                try {
                    for (zo zoVar : arrayList) {
                        if (arrayList3.contains(zoVar)) {
                            pr(zoVar, true, writableDatabase, false);
                        } else {
                            writableDatabase.execSQL("DELETE FROM pack WHERE _id=?", new String[]{String.valueOf(zoVar.pr)});
                        }
                    }
                } catch (Throwable th) {
                    w.hw(th);
                }
                for (zo zoVar2 : arrayList2) {
                    if (zoVar2.qa != null) {
                        pr((String) null);
                    }
                    if (!arrayList3.contains(zoVar2)) {
                        long j = zoVar2.pr;
                        int i = zoVar2.m + 1;
                        zoVar2.m = i;
                        writableDatabase.execSQL(pr(j, i));
                    }
                }
                writableDatabase.setTransactionSuccessful();
                g.pr(writableDatabase);
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
                try {
                    w.hw(th);
                } finally {
                    g.pr(sQLiteDatabase);
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void pr(ArrayList<com.byazt.kg.pr> arrayList) {
        ArrayList arrayList2 = new ArrayList(4);
        ArrayList arrayList3 = new ArrayList(4);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValuesHw = null;
                for (com.byazt.kg.pr prVar : arrayList) {
                    String strX = prVar.x();
                    contentValuesHw = prVar.hw(contentValuesHw);
                    prVar.pr = writableDatabase.insert(strX, null, contentValuesHw);
                    if (NotificationCompat.CATEGORY_EVENT.equals(prVar.x())) {
                        arrayList3.add(prVar);
                    } else if ("eventv3".equals(prVar.x())) {
                        arrayList3.add(prVar);
                    } else if (prVar instanceof uc) {
                        arrayList2.add((uc) prVar);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                g.pr(writableDatabase);
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = writableDatabase;
                try {
                    w.hw(th);
                } finally {
                    g.pr(sQLiteDatabase);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 421, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static class pr extends SQLiteOpenHelper {
        public pr(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(new com.byazt.mg.pr(context), str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<com.byazt.kg.pr> it = hw.hw.values().iterator();
                while (it.hasNext()) {
                    String strHn = it.next().hn();
                    if (strHn != null) {
                        sQLiteDatabase.execSQL(strHn);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    w.hw(th);
                } finally {
                    g.pr(sQLiteDatabase);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            w.x("onUpgrade, " + i + ", " + i2, null);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<com.byazt.kg.pr> it = hw.hw.values().iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().x());
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    w.hn("", th);
                } catch (Throwable th2) {
                    g.pr(sQLiteDatabase);
                    throw th2;
                }
            }
            g.pr(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
