package com.byazt.yi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.byazt.km.cp;
import com.byazt.km.sz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import kotlin.jvm.internal.LongCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 200, 26})
public class qg {
    public static final int[] n = {1};
    public static final HashMap<String, com.byazt.yi.n> qg = new HashMap<>();
    public static final C0403qg[] s;
    public static final com.byazt.yi.n[] w;
    public final n l;
    public final com.byazt.fo.q q;
    public String x;

    static {
        n(new rv());
        n(new w(true));
        n(new tj());
        n(new fs());
        com.byazt.yi.n[] nVarArr = {new s(), new l(null, false, null), new q("", new JSONObject())};
        w = nVarArr;
        for (int i = 0; i < 3; i++) {
            n(nVarArr[i]);
        }
        s = new C0403qg[]{new C0403qg(), new C0403qg(), new C0403qg()};
    }

    private String n(String str, boolean z) {
        return "SELECT * FROM page WHERE session_id" + (z ? "='" : "!='") + str + "' ORDER BY " + (z ? "session_id," : "") + "duration DESC LIMIT 500";
    }

    private String qg(String str, boolean z) {
        return "DELETE FROM page WHERE session_id" + (z ? "='" : "!='") + str + "'";
    }

    private String n(com.byazt.yi.n nVar, String str, boolean z, int i, int i2) {
        return "SELECT * FROM " + nVar.q() + " WHERE session_id" + (z ? "='" : "!='") + str + "' AND event_type='" + i2 + "' ORDER BY _id LIMIT " + i;
    }

    private String n(String str, int i, String str2, boolean z, long j) {
        return "DELETE FROM " + str + " WHERE session_id" + (z ? "='" : "!='") + str2 + "' AND event_type='" + i + "' AND _id<=" + j;
    }

    private String n(long j, int i) {
        return "UPDATE pack SET _fail=" + i + " WHERE _id=" + j;
    }

    public qg(com.byazt.fo.q qVar) {
        this.l = new n(qVar.getContext(), "bd_embed_tea_agent.db", null, 30);
        this.q = qVar;
    }

    private static void n(com.byazt.yi.n nVar) {
        qg.put(nVar.q(), nVar);
    }

    /* JADX INFO: renamed from: com.byazt.yi.qg$qg, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 200, 201})
    static class C0403qg {
        public String n;
        public int qg;
        public int s;

        /* JADX INFO: Access modifiers changed from: private */
        public static void qg() {
            for (C0403qg c0403qg : qg.s) {
                c0403qg.n = "";
                c0403qg.qg = 0;
                c0403qg.s = 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(com.byazt.yi.n nVar) {
            String strRv = nVar.rv();
            if (strRv == null || strRv.length() <= this.qg) {
                return;
            }
            this.n = nVar.fs();
            this.qg = strRv.length();
        }

        public String toString() {
            return new StringBuilder(this.s).append("-").append(this.n).append("-").append(this.qg).toString();
        }
    }

    private boolean n(String str) {
        cp.n("needLaunch, " + this.x + ", " + str);
        if (TextUtils.equals(str, this.x)) {
            return false;
        }
        this.x = str;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public synchronized ArrayList<fs> n(JSONObject jSONObject) {
        ArrayList<fs> arrayList;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase2;
        String str;
        long[] jArr;
        JSONObject jSONObject2;
        SQLiteDatabase sQLiteDatabase3;
        HashMap<String, com.byazt.yi.n> map = qg;
        w wVar = (w) map.get("launch");
        tj tjVar = (tj) map.get("terminate");
        rv rvVar = (rv) map.get("page");
        fs fsVar = (fs) map.get("pack");
        arrayList = new ArrayList<>();
        Cursor cursor2 = null;
        try {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr2 = new long[3];
            SQLiteDatabase writableDatabase = this.l.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT * FROM launch ORDER BY _id LIMIT 5", null);
                try {
                    com.byazt.fo.x xVarW = this.q.w();
                    String strN = xVarW.n();
                    boolean zQg = xVarW.qg();
                    JSONObject jSONObject3 = jSONObject;
                    long j = Long.MIN_VALUE;
                    long j2 = Long.MAX_VALUE;
                    try {
                        while (true) {
                            if (!cursorRawQuery.moveToNext()) {
                                break;
                            }
                            try {
                                wVar.n(cursorRawQuery);
                                fsVar.q = wVar.q;
                                JSONObject jSONObjectN = n(wVar, jSONObject);
                                if (TextUtils.equals(wVar.q, strN)) {
                                    try {
                                        wVar.sz = zQg ? false : true;
                                        jSONObject2 = jSONObjectN;
                                        cursor = cursorRawQuery;
                                        sQLiteDatabase3 = writableDatabase;
                                        try {
                                            n(jSONObjectN, wVar, fsVar, writableDatabase, jSONArrayArr, jArr2, arrayList);
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor2 = cursor;
                                            sQLiteDatabase = sQLiteDatabase3;
                                            cp.qg(th);
                                            if (cursor2 != null) {
                                                try {
                                                    cursor2.close();
                                                } catch (Throwable th2) {
                                                    cp.qg(th2);
                                                }
                                            }
                                            sz.n(sQLiteDatabase);
                                            return arrayList;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        cursor = cursorRawQuery;
                                        sQLiteDatabase3 = writableDatabase;
                                    }
                                } else {
                                    jSONObject2 = jSONObjectN;
                                    cursor = cursorRawQuery;
                                    sQLiteDatabase3 = writableDatabase;
                                    try {
                                        if (wVar.n < j2) {
                                            j2 = wVar.n;
                                        }
                                        if (wVar.n > j) {
                                            j = wVar.n;
                                        }
                                        n(jSONObject2, wVar, fsVar, rvVar, tjVar, sQLiteDatabase3, jSONArrayArr, jArr2);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        sQLiteDatabase = sQLiteDatabase3;
                                    }
                                }
                                JSONObject jSONObject4 = jSONObject2;
                                sQLiteDatabase = sQLiteDatabase3;
                                try {
                                    n(jSONObject4, true, fsVar, sQLiteDatabase);
                                    jSONObject3 = jSONObject4;
                                    writableDatabase = sQLiteDatabase;
                                    strN = strN;
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
                                cp.qg(th);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                sz.n(sQLiteDatabase);
                            } catch (Throwable th7) {
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Throwable th8) {
                                        cp.qg(th8);
                                    }
                                }
                                sz.n(sQLiteDatabase);
                                throw th7;
                            }
                        }
                        if (cursor.getCount() >= 5 || TextUtils.isEmpty(str)) {
                            sQLiteDatabase2 = sQLiteDatabase;
                        } else {
                            JSONObject jSONObject5 = jSONObject3;
                            sQLiteDatabase2 = sQLiteDatabase;
                            try {
                                n(jSONObject3, wVar, tjVar, rvVar, fsVar, sQLiteDatabase, str, jSONArrayArr, jArr);
                                n(jSONObject5, false, fsVar, sQLiteDatabase2);
                            } catch (Throwable th9) {
                                th = th9;
                                sQLiteDatabase = sQLiteDatabase2;
                                cursor2 = cursor;
                                cp.qg(th);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                sz.n(sQLiteDatabase);
                            }
                        }
                        sQLiteDatabase2.setTransactionSuccessful();
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th10) {
                                cp.qg(th10);
                            }
                        }
                        sz.n(sQLiteDatabase2);
                    } catch (Throwable th11) {
                        th = th11;
                        cursor2 = cursor;
                        cp.qg(th);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        sz.n(sQLiteDatabase);
                    }
                    str = strN;
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

    private void n(JSONObject jSONObject, boolean z, fs fsVar, SQLiteDatabase sQLiteDatabase) {
        for (int i : n) {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr = new long[3];
            int iN = n(0, sQLiteDatabase, fsVar.q, z, i, jSONArrayArr, jArr);
            if (n(jArr)) {
                int i2 = iN;
                while (true) {
                    fsVar.n(jSONObject, null, null, null, jSONArrayArr, jArr, i);
                    n(fsVar, z, sQLiteDatabase, true);
                    int iN2 = i2;
                    while (true) {
                        if (iN2 < w.length) {
                            iN2 = n(iN2, sQLiteDatabase, fsVar.q, z, i, jSONArrayArr, jArr);
                            if (n(jArr)) {
                                i2 = iN2;
                            }
                        }
                    }
                }
            }
        }
    }

    private JSONObject n(w wVar, JSONObject jSONObject) {
        if (TextUtils.equals(wVar.oa, this.q.q().s()) && wVar.d == this.q.q().qg()) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            sz.s(jSONObject2, jSONObject);
            jSONObject2.put("app_version", wVar.oa);
            jSONObject2.put("version_code", wVar.d);
            return jSONObject2;
        } catch (JSONException e) {
            cp.qg(e);
            return jSONObject;
        }
    }

    private void n(JSONObject jSONObject, w wVar, fs fsVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, ArrayList<fs> arrayList) {
        SQLiteDatabase sQLiteDatabase2;
        qg qgVar;
        fs fsVar2;
        int iN;
        cp.n("packCurrentData, " + wVar.q);
        boolean zN = n(wVar.q);
        int iN2 = n(0, sQLiteDatabase, wVar.q, true, 0, jSONArrayArr, jArr);
        if (zN || n(jArr)) {
            fsVar.n(jSONObject, zN ? wVar : null, null, null, jSONArrayArr, jArr, 0);
            if (iN2 >= w.length) {
                fs fsVar3 = (fs) fsVar.clone();
                fsVar3.tj();
                arrayList.add(fsVar3);
                sQLiteDatabase2 = sQLiteDatabase;
                iN = iN2;
                qgVar = this;
                fsVar2 = fsVar;
            } else {
                sQLiteDatabase2 = sQLiteDatabase;
                qgVar = this;
                fsVar2 = fsVar;
                qgVar.n(fsVar2, true, sQLiteDatabase2, true);
                iN = iN2;
            }
        } else {
            sQLiteDatabase2 = sQLiteDatabase;
            iN = iN2;
            qgVar = this;
            fsVar2 = fsVar;
        }
        while (iN < w.length) {
            iN = qgVar.n(iN, sQLiteDatabase2, wVar.q, true, 0, jSONArrayArr, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x008d: INVOKE (r12v4 'iN' int) = 
                  (r7v2 'qgVar' com.byazt.yi.qg)
                  (r12v3 'iN' int)
                  (r3v6 'sQLiteDatabase2' android.database.sqlite.SQLiteDatabase)
                  (wrap java.lang.String:0x0082: IGET (r23v0 'wVar' com.byazt.yi.w) A[WRAPPED] (LINE:277) com.byazt.yi.w.q java.lang.String)
                  true
                  (0 int)
                  (r26v0 'jSONArrayArr' org.json.JSONArray[] A[IMMUTABLE_TYPE, METHOD_ARGUMENT])
                  (r2v1 long[])
                 DIRECT call: com.byazt.yi.qg.n(int, android.database.sqlite.SQLiteDatabase, java.lang.String, boolean, int, org.json.JSONArray[], long[]):int A[MD:(int, android.database.sqlite.SQLiteDatabase, java.lang.String, boolean, int, org.json.JSONArray[], long[]):int (m)] (LINE:277) in method: com.byazt.yi.qg.n(org.json.JSONObject, com.byazt.yi.w, com.byazt.yi.fs, android.database.sqlite.SQLiteDatabase, org.json.JSONArray[], long[], java.util.ArrayList<com.byazt.yi.fs>):void, file: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:226)
                	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v1 long[]
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                */
            /*
                this = this;
                r8 = r21
                r9 = r23
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "packCurrentData, "
                r0.<init>(r1)
                java.lang.String r1 = r9.q
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                com.byazt.km.cp.n(r0)
                java.lang.String r0 = r9.q
                boolean r10 = r8.n(r0)
                r1 = 0
                java.lang.String r3 = r9.q
                r4 = 1
                r5 = 0
                r0 = r21
                r2 = r25
                r6 = r26
                r7 = r27
                int r0 = r0.n(r1, r2, r3, r4, r5, r6, r7)
                r1 = 0
                r2 = r27
                if (r10 != 0) goto L3a
                boolean r3 = r8.n(r2)
                if (r3 == 0) goto L61
            L3a:
                if (r10 == 0) goto L3e
                r13 = r9
                goto L3f
            L3e:
                r13 = r1
            L3f:
                r14 = 0
                r15 = 0
                r18 = 0
                r11 = r24
                r12 = r22
                r16 = r26
                r17 = r27
                r11.n(r12, r13, r14, r15, r16, r17, r18)
                com.byazt.yi.n[] r3 = com.byazt.yi.qg.w
                int r3 = r3.length
                if (r0 < r3) goto L6d
                com.byazt.yi.n r3 = r24.clone()
                com.byazt.yi.fs r3 = (com.byazt.yi.fs) r3
                r3.tj()
                r4 = r28
                r4.add(r3)
            L61:
                r3 = r25
                r4 = r26
                r12 = r0
                r5 = r2
                r7 = r8
                r0 = r22
                r2 = r24
                goto L7d
            L6d:
                r3 = r25
                r4 = r26
                r6 = r0
                r5 = r2
                r7 = r8
                r0 = r22
                r2 = r24
            L78:
                r10 = 1
                r7.n(r2, r10, r3, r10)
                r12 = r6
            L7d:
                com.byazt.yi.n[] r6 = com.byazt.yi.qg.w
                int r6 = r6.length
                if (r12 >= r6) goto Lb3
                java.lang.String r14 = r9.q
                r15 = 1
                r16 = 0
                r11 = r7
                r13 = r3
                r17 = r4
                r18 = r5
                int r12 = r11.n(r12, r13, r14, r15, r16, r17, r18)
                boolean r6 = r7.n(r5)
                if (r6 == 0) goto L7d
                java.lang.String r6 = r9.q
                boolean r6 = r7.n(r6)
                if (r6 == 0) goto La1
                r15 = r9
                goto La2
            La1:
                r15 = r1
            La2:
                r16 = 0
                r17 = 0
                r20 = 0
                r13 = r2
                r14 = r0
                r18 = r4
                r19 = r5
                r13.n(r14, r15, r16, r17, r18, r19, r20)
                r6 = r12
                goto L78
            Lb3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.byazt.yi.qg.n(org.json.JSONObject, com.byazt.yi.w, com.byazt.yi.fs, android.database.sqlite.SQLiteDatabase, org.json.JSONArray[], long[], java.util.ArrayList):void");
        }

        private void n(JSONObject jSONObject, w wVar, fs fsVar, rv rvVar, tj tjVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr) {
            cp.n("packHistoryData, " + wVar.q);
            JSONArray jSONArrayN = n(wVar, true, tjVar, rvVar, sQLiteDatabase);
            boolean z = true;
            wVar.sz = jSONArrayN.length() == 0;
            int iN = n(0, sQLiteDatabase, wVar.q, true, 0, jSONArrayArr, jArr);
            if (wVar.sz) {
                fsVar.n(jSONObject, n(wVar.q) ? wVar : null, null, null, jSONArrayArr, jArr, 0);
            } else {
                fsVar.n(jSONObject, null, tjVar, jSONArrayN, jSONArrayArr, jArr, 0);
            }
            while (true) {
                n(fsVar, z, sQLiteDatabase, z);
                int iN2 = iN;
                while (iN2 < w.length) {
                    boolean z2 = z;
                    iN2 = n(iN2, sQLiteDatabase, wVar.q, true, 0, jSONArrayArr, jArr);
                    if (n(jArr)) {
                        fsVar.n(jSONObject, null, null, null, jSONArrayArr, jArr, 0);
                        iN = iN2;
                        z = z2;
                    } else {
                        z = z2;
                    }
                }
                return;
            }
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00b5  */
        /* JADX WARN: Code duplicated, block: B:30:0x00d1 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:32:? A[LOOP:0: B:22:0x00b0->B:32:?, LOOP_END, SYNTHETIC] */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private void n(org.json.JSONObject r17, com.byazt.yi.w r18, com.byazt.yi.tj r19, com.byazt.yi.rv r20, com.byazt.yi.fs r21, android.database.sqlite.SQLiteDatabase r22, java.lang.String r23, org.json.JSONArray[] r24, long[] r25) {
            /*
                Method dump skipped, instruction units count: 214
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.byazt.yi.qg.n(org.json.JSONObject, com.byazt.yi.w, com.byazt.yi.tj, com.byazt.yi.rv, com.byazt.yi.fs, android.database.sqlite.SQLiteDatabase, java.lang.String, org.json.JSONArray[], long[]):void");
        }

        private boolean n(long[] jArr) {
            return jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0;
        }

        public void n(fs fsVar, boolean z, SQLiteDatabase sQLiteDatabase, boolean z2) {
            boolean z3;
            if (sQLiteDatabase == null) {
                sQLiteDatabase = this.l.getWritableDatabase();
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                try {
                    sQLiteDatabase.beginTransaction();
                } catch (Throwable th) {
                    try {
                        cp.qg(th);
                        if (z3) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (z3) {
                            sz.n(sQLiteDatabase);
                        }
                    }
                }
            }
            if (z2 && sQLiteDatabase.insert("pack", null, fsVar.qg((ContentValues) null)) < 0) {
                if (fsVar.um != null) {
                    n((String) null);
                }
                if (z3) {
                    sz.n(sQLiteDatabase);
                    return;
                }
                return;
            }
            if (fsVar.cy > 0) {
                sQLiteDatabase.execSQL(n(NotificationCompat.CATEGORY_EVENT, fsVar.tj, fsVar.q, z, fsVar.cy));
            }
            if (fsVar.cd > 0) {
                sQLiteDatabase.execSQL(n("eventv3", fsVar.tj, fsVar.q, z, fsVar.cd));
            }
            if (fsVar.py > 0) {
                sQLiteDatabase.execSQL(n("event_misc", fsVar.tj, fsVar.q, z, fsVar.py));
            }
            if (z3) {
                sQLiteDatabase.setTransactionSuccessful();
            }
            if (z3) {
                sz.n(sQLiteDatabase);
            }
        }

        private int n(int i, SQLiteDatabase sQLiteDatabase, String str, boolean z, int i2, JSONArray[] jSONArrayArr, long[] jArr) {
            C0403qg.qg();
            int i3 = 0;
            while (i3 < i) {
                jSONArrayArr[i3] = null;
                jArr[i3] = 0;
                i3++;
            }
            int i4 = i3;
            int i5 = 200;
            while (i5 > 0 && i4 < w.length) {
                n(sQLiteDatabase, str, i5, i4, z, jSONArrayArr, jArr, i2);
                int length = jSONArrayArr[i4].length();
                i5 -= length;
                s[i4].s = length;
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

        private void n(SQLiteDatabase sQLiteDatabase, String str, int i, int i2, boolean z, JSONArray[] jSONArrayArr, long[] jArr, int i3) {
            com.byazt.yi.n nVar = w[i2];
            JSONArray jSONArray = new JSONArray();
            Cursor cursor = null;
            long j = 0;
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery(n(nVar, str, z, i, i3), null);
                for (int i4 = 0; cursorRawQuery.moveToNext() && i4 <= 200; i4++) {
                    try {
                        nVar.n(cursorRawQuery);
                        s[i2].n(nVar);
                        if (cp.qg) {
                            cp.n("queryEvent, " + nVar, null);
                        }
                        jSONArray.put(nVar.w());
                        if (nVar.n > j) {
                            j = nVar.n;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorRawQuery;
                        try {
                            cp.qg(th);
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

        /* JADX WARN: Code duplicated, block: B:47:0x00e0 A[PHI: r12 r15 r17 r18
          0x00e0: PHI (r12v2 android.database.Cursor) = (r12v3 android.database.Cursor), (r12v6 android.database.Cursor) binds: [B:46:0x00de, B:36:0x00ca] A[DONT_GENERATE, DONT_INLINE]
          0x00e0: PHI (r15v2 long) = (r15v3 long), (r15v5 long) binds: [B:46:0x00de, B:36:0x00ca] A[DONT_GENERATE, DONT_INLINE]
          0x00e0: PHI (r17v3 java.lang.String) = (r17v4 java.lang.String), (r17v7 java.lang.String) binds: [B:46:0x00de, B:36:0x00ca] A[DONT_GENERATE, DONT_INLINE]
          0x00e0: PHI (r18v2 java.lang.String) = (r18v3 java.lang.String), (r18v5 java.lang.String) binds: [B:46:0x00de, B:36:0x00ca] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:50:0x00ed  */
        /* JADX WARN: Code duplicated, block: B:52:0x00f1  */
        /* JADX WARN: Code duplicated, block: B:55:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:56:0x0101  */
        /* JADX WARN: Code duplicated, block: B:59:0x0134  */
        /* JADX WARN: Code duplicated, block: B:60:0x0139  */
        /* JADX WARN: Code duplicated, block: B:62:0x013f  */
        private JSONArray n(w wVar, boolean z, tj tjVar, rv rvVar, SQLiteDatabase sQLiteDatabase) {
            Cursor cursorRawQuery;
            String str;
            String str2;
            long j;
            String str3;
            String str4;
            long j2;
            JSONArray jSONArray = new JSONArray();
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery(n(wVar.q, z), null);
                try {
                    HashMap map = new HashMap(8);
                    boolean z2 = false;
                    str = null;
                    str2 = null;
                    j = 0;
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            rvVar.n(cursorRawQuery);
                            if (cp.qg) {
                                cp.n("queryPage, " + rvVar, null);
                            }
                            Integer num = (Integer) map.get(rvVar.sz);
                            z2 = true;
                            if (!rvVar.tj()) {
                                map.put(rvVar.sz, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                                j = rvVar.d >= 1000 ? j + rvVar.d : j + 1000;
                                jSONArray.put(rvVar.w());
                                if (TextUtils.isEmpty(rvVar.a)) {
                                    continue;
                                } else {
                                    String str5 = rvVar.a;
                                    try {
                                        str = str5;
                                        str2 = rvVar.w;
                                    } catch (Throwable th) {
                                        th = th;
                                        str = str5;
                                        try {
                                            cp.qg(th);
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            str3 = str;
                                            str4 = str2;
                                            if (jSONArray.length() > 0) {
                                                j2 = j > 1000 ? j : 1000L;
                                                tjVar.d = j2;
                                                if (z) {
                                                    tjVar.q = wVar.q;
                                                    tjVar.n(wVar.qg + j2);
                                                } else {
                                                    tjVar.q = UUID.randomUUID().toString();
                                                    tjVar.n(0L);
                                                }
                                                tjVar.l = wVar.l;
                                                tjVar.w = wVar.w;
                                                tjVar.x = wVar.x;
                                                tjVar.fs = wVar.fs;
                                                tjVar.oa = tjVar.qg;
                                                tjVar.s = com.byazt.fo.x.q();
                                                tjVar.sz = null;
                                                if (!TextUtils.isEmpty(wVar.k)) {
                                                    tjVar.sz = wVar.k;
                                                } else if (!TextUtils.isEmpty(str3)) {
                                                    tjVar.sz = str3;
                                                    tjVar.w = str4;
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
                                    map.put(rvVar.sz, numValueOf);
                                } else {
                                    map.remove(rvVar.sz);
                                }
                            } else {
                                rvVar.d = 1000L;
                                j += rvVar.d;
                                jSONArray.put(rvVar.w());
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    if (z2) {
                        sQLiteDatabase.execSQL(qg(wVar.q, z));
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str = null;
                    str2 = str;
                    j = 0;
                    cp.qg(th);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    str3 = str;
                    str4 = str2;
                    if (jSONArray.length() > 0) {
                        if (j > 1000) {
                        }
                        tjVar.d = j2;
                        if (z) {
                            tjVar.q = wVar.q;
                            tjVar.n(wVar.qg + j2);
                        } else {
                            tjVar.q = UUID.randomUUID().toString();
                            tjVar.n(0L);
                        }
                        tjVar.l = wVar.l;
                        tjVar.w = wVar.w;
                        tjVar.x = wVar.x;
                        tjVar.fs = wVar.fs;
                        tjVar.oa = tjVar.qg;
                        tjVar.s = com.byazt.fo.x.q();
                        tjVar.sz = null;
                        if (!TextUtils.isEmpty(wVar.k)) {
                            tjVar.sz = wVar.k;
                        } else if (!TextUtils.isEmpty(str3)) {
                            tjVar.sz = str3;
                            tjVar.w = str4;
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
                tjVar.d = j2;
                if (z) {
                    tjVar.q = wVar.q;
                    tjVar.n(wVar.qg + j2);
                } else {
                    tjVar.q = UUID.randomUUID().toString();
                    tjVar.n(0L);
                }
                tjVar.l = wVar.l;
                tjVar.w = wVar.w;
                tjVar.x = wVar.x;
                tjVar.fs = wVar.fs;
                tjVar.oa = tjVar.qg;
                tjVar.s = com.byazt.fo.x.q();
                tjVar.sz = null;
                if (!TextUtils.isEmpty(wVar.k)) {
                    tjVar.sz = wVar.k;
                } else if (!TextUtils.isEmpty(str3)) {
                    tjVar.sz = str3;
                    tjVar.w = str4;
                }
            }
            return jSONArray;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x003b A[PHI: r3
          0x003b: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v6 android.database.Cursor) binds: [B:15:0x0039, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
        public ArrayList<fs> n() {
            Cursor cursorRawQuery;
            ArrayList<fs> arrayList = new ArrayList<>();
            fs fsVar = (fs) qg.get("pack");
            try {
                cursorRawQuery = this.l.getWritableDatabase().rawQuery("SELECT * FROM pack ORDER BY _id DESC LIMIT 8", null);
                while (cursorRawQuery.moveToNext()) {
                    try {
                        fsVar = (fs) fsVar.clone();
                        fsVar.n(cursorRawQuery);
                        arrayList.add(fsVar);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            cp.qg(th);
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
            cp.n("queryPack, " + arrayList, null);
            return arrayList;
        }

        public void setResult(ArrayList<fs> arrayList, ArrayList<fs> arrayList2, ArrayList<fs> arrayList3) {
            SQLiteDatabase sQLiteDatabase = null;
            cp.n("setResult, " + arrayList + ", " + arrayList2, null);
            Iterator<fs> it = arrayList2.iterator();
            while (it.hasNext()) {
                fs next = it.next();
                if (!arrayList3.contains(next) && Math.abs(System.currentTimeMillis() - next.qg) > 864000000) {
                    arrayList.add(next);
                    it.remove();
                }
            }
            try {
                SQLiteDatabase writableDatabase = this.l.getWritableDatabase();
                try {
                    writableDatabase.beginTransaction();
                    try {
                        for (fs fsVar : arrayList) {
                            if (arrayList3.contains(fsVar)) {
                                n(fsVar, true, writableDatabase, false);
                            } else {
                                writableDatabase.execSQL("DELETE FROM pack WHERE _id=?", new String[]{String.valueOf(fsVar.n)});
                            }
                        }
                    } catch (Throwable th) {
                        cp.qg(th);
                    }
                    for (fs fsVar2 : arrayList2) {
                        if (fsVar2.um != null) {
                            n((String) null);
                        }
                        if (!arrayList3.contains(fsVar2)) {
                            long j = fsVar2.n;
                            int i = fsVar2.oa + 1;
                            fsVar2.oa = i;
                            writableDatabase.execSQL(n(j, i));
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    sz.n(writableDatabase);
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = writableDatabase;
                    try {
                        cp.qg(th);
                    } finally {
                        sz.n(sQLiteDatabase);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public void n(ArrayList<com.byazt.yi.n> arrayList) {
            ArrayList arrayList2 = new ArrayList(4);
            ArrayList arrayList3 = new ArrayList(4);
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase writableDatabase = this.l.getWritableDatabase();
                try {
                    writableDatabase.beginTransaction();
                    ContentValues contentValuesQg = null;
                    for (com.byazt.yi.n nVar : arrayList) {
                        String strQ = nVar.q();
                        contentValuesQg = nVar.qg(contentValuesQg);
                        nVar.n = writableDatabase.insert(strQ, null, contentValuesQg);
                        if (NotificationCompat.CATEGORY_EVENT.equals(nVar.q())) {
                            arrayList3.add(nVar);
                        } else if ("eventv3".equals(nVar.q())) {
                            arrayList3.add(nVar);
                        } else if (nVar instanceof w) {
                            arrayList2.add((w) nVar);
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    sz.n(writableDatabase);
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = writableDatabase;
                    try {
                        cp.qg(th);
                    } finally {
                        sz.n(sQLiteDatabase);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @com.byazt.cp.n(n = {0, 1, 200, 48})
        private static class n extends SQLiteOpenHelper {
            public n(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
                super(new com.byazt.qyu.n(context), str, cursorFactory, i);
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                try {
                    sQLiteDatabase.beginTransaction();
                    Iterator<com.byazt.yi.n> it = qg.qg.values().iterator();
                    while (it.hasNext()) {
                        String strS = it.next().s();
                        if (strS != null) {
                            sQLiteDatabase.execSQL(strS);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sz.n(sQLiteDatabase);
                } catch (Throwable th) {
                    try {
                        cp.qg(th);
                    } finally {
                        sz.n(sQLiteDatabase);
                    }
                }
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                cp.q("onUpgrade, " + i + ", " + i2, null);
                try {
                    sQLiteDatabase.beginTransaction();
                    Iterator<com.byazt.yi.n> it = qg.qg.values().iterator();
                    while (it.hasNext()) {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().q());
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Throwable th) {
                    try {
                        cp.s("", th);
                    } catch (Throwable th2) {
                        sz.n(sQLiteDatabase);
                        throw th2;
                    }
                }
                sz.n(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                onUpgrade(sQLiteDatabase, i, i2);
            }
        }
    }
