package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ti {
    static final xr[] ah;
    private static final tz[] c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final int[] f526ms = {1};
    static final HashMap<String, tz> xr = new HashMap<>();
    private String ab;
    private final b d;
    private final ms ka;

    static {
        ms(new rt());
        ms(new vm(true));
        ms(new vy());
        ms(new zf());
        tz[] tzVarArr = {new s(), new qk(null, false, null), new v("", new JSONObject())};
        c = tzVarArr;
        for (int i = 0; i < 3; i++) {
            ms(tzVarArr[i]);
        }
        ah = new xr[]{new xr(), new xr(), new xr()};
    }

    private String ms(String str, boolean z) {
        return "SELECT * FROM page WHERE session_id" + (z ? "='" : "!='") + str + "' ORDER BY " + (z ? "session_id," : "") + "duration DESC LIMIT 500";
    }

    private String xr(String str, boolean z) {
        return "DELETE FROM page WHERE session_id" + (z ? "='" : "!='") + str + "'";
    }

    private String ms(tz tzVar, String str, boolean z, int i, int i2) {
        return "SELECT * FROM " + tzVar.d() + " WHERE session_id" + (z ? "='" : "!='") + str + "' AND event_type='" + i2 + "' ORDER BY _id LIMIT " + i;
    }

    private String ms(String str, int i, String str2, boolean z, long j) {
        return "DELETE FROM " + str + " WHERE session_id" + (z ? "='" : "!='") + str2 + "' AND event_type='" + i + "' AND _id<=" + j;
    }

    private String ms(long j, int i) {
        return "UPDATE pack SET _fail=" + i + " WHERE _id=" + j;
    }

    public ti(b bVar) {
        this.ka = new ms(bVar.xr(), "bd_embed_tea_agent.db", null, 30);
        this.d = bVar;
    }

    private static void ms(tz tzVar) {
        xr.put(tzVar.d(), tzVar);
    }

    static class xr {
        int ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        String f527ms;
        int xr;

        xr() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void xr() {
            for (xr xrVar : ti.ah) {
                xrVar.f527ms = "";
                xrVar.xr = 0;
                xrVar.ah = 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ms(tz tzVar) {
            String strNy = tzVar.ny();
            if (strNy == null || strNy.length() <= this.xr) {
                return;
            }
            this.f527ms = tzVar.x();
            this.xr = strNy.length();
        }

        public String toString() {
            return new StringBuilder(this.ah).append("-").append(this.f527ms).append("-").append(this.xr).toString();
        }
    }

    private boolean ms(String str) {
        oh.ms("needLaunch, " + this.ab + ", " + str);
        if (TextUtils.equals(str, this.ab)) {
            return false;
        }
        this.ab = str;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public synchronized ArrayList<zf> ms(JSONObject jSONObject) {
        ArrayList<zf> arrayList;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase2;
        String str;
        long[] jArr;
        JSONObject jSONObject2;
        SQLiteDatabase sQLiteDatabase3;
        HashMap<String, tz> map = xr;
        vm vmVar = (vm) map.get("launch");
        vy vyVar = (vy) map.get("terminate");
        rt rtVar = (rt) map.get("page");
        zf zfVar = (zf) map.get("pack");
        arrayList = new ArrayList<>();
        Cursor cursor2 = null;
        try {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr2 = new long[3];
            SQLiteDatabase writableDatabase = this.ka.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT * FROM launch ORDER BY _id LIMIT 5", null);
                try {
                    w wVarAb = this.d.ab();
                    String strMs = wVarAb.ms();
                    boolean zXr = wVarAb.xr();
                    JSONObject jSONObject3 = jSONObject;
                    long j = Long.MIN_VALUE;
                    long j2 = Long.MAX_VALUE;
                    try {
                        while (true) {
                            if (!cursorRawQuery.moveToNext()) {
                                break;
                            }
                            try {
                                vmVar.ms(cursorRawQuery);
                                zfVar.d = vmVar.d;
                                JSONObject jSONObjectMs = ms(vmVar, jSONObject);
                                if (TextUtils.equals(vmVar.d, strMs)) {
                                    try {
                                        vmVar.u = zXr ? false : true;
                                        jSONObject2 = jSONObjectMs;
                                        cursor = cursorRawQuery;
                                        sQLiteDatabase3 = writableDatabase;
                                        try {
                                            ms(jSONObjectMs, vmVar, zfVar, writableDatabase, jSONArrayArr, jArr2, arrayList);
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor2 = cursor;
                                            sQLiteDatabase = sQLiteDatabase3;
                                            oh.xr(th);
                                            if (cursor2 != null) {
                                                try {
                                                    cursor2.close();
                                                } catch (Throwable th2) {
                                                    oh.xr(th2);
                                                }
                                            }
                                            zd.ms(sQLiteDatabase);
                                            return arrayList;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        cursor = cursorRawQuery;
                                        sQLiteDatabase3 = writableDatabase;
                                    }
                                } else {
                                    jSONObject2 = jSONObjectMs;
                                    cursor = cursorRawQuery;
                                    sQLiteDatabase3 = writableDatabase;
                                    try {
                                        if (vmVar.f529ms < j2) {
                                            j2 = vmVar.f529ms;
                                        }
                                        if (vmVar.f529ms > j) {
                                            j = vmVar.f529ms;
                                        }
                                        ms(jSONObject2, vmVar, zfVar, rtVar, vyVar, sQLiteDatabase3, jSONArrayArr, jArr2);
                                    } catch (Throwable th4) {
                                        th = th4;
                                        sQLiteDatabase = sQLiteDatabase3;
                                    }
                                }
                                JSONObject jSONObject4 = jSONObject2;
                                sQLiteDatabase = sQLiteDatabase3;
                                try {
                                    ms(jSONObject4, true, zfVar, sQLiteDatabase);
                                    jSONObject3 = jSONObject4;
                                    writableDatabase = sQLiteDatabase;
                                    strMs = strMs;
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
                                oh.xr(th);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                zd.ms(sQLiteDatabase);
                            } catch (Throwable th7) {
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Throwable th8) {
                                        oh.xr(th8);
                                    }
                                }
                                zd.ms(sQLiteDatabase);
                                throw th7;
                            }
                        }
                        if (cursor.getCount() >= 5 || TextUtils.isEmpty(str)) {
                            sQLiteDatabase2 = sQLiteDatabase;
                        } else {
                            JSONObject jSONObject5 = jSONObject3;
                            sQLiteDatabase2 = sQLiteDatabase;
                            try {
                                ms(jSONObject3, vmVar, vyVar, rtVar, zfVar, sQLiteDatabase, str, jSONArrayArr, jArr);
                                ms(jSONObject5, false, zfVar, sQLiteDatabase2);
                            } catch (Throwable th9) {
                                th = th9;
                                sQLiteDatabase = sQLiteDatabase2;
                                cursor2 = cursor;
                                oh.xr(th);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                zd.ms(sQLiteDatabase);
                            }
                        }
                        sQLiteDatabase2.setTransactionSuccessful();
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th10) {
                                oh.xr(th10);
                            }
                        }
                        zd.ms(sQLiteDatabase2);
                    } catch (Throwable th11) {
                        th = th11;
                        cursor2 = cursor;
                        oh.xr(th);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        zd.ms(sQLiteDatabase);
                    }
                    str = strMs;
                    cursor = cursorRawQuery;
                    jArr = jArr2;
                    sQLiteDatabase = writableDatabase;
                    if (j2 != Long.MAX_VALUE && j != Long.MIN_VALUE) {
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

    private void ms(JSONObject jSONObject, boolean z, zf zfVar, SQLiteDatabase sQLiteDatabase) {
        for (int i : f526ms) {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr = new long[3];
            int iMs = ms(0, sQLiteDatabase, zfVar.d, z, i, jSONArrayArr, jArr);
            if (ms(jArr)) {
                int i2 = iMs;
                while (true) {
                    zfVar.ms(jSONObject, null, null, null, jSONArrayArr, jArr, i);
                    ms(zfVar, z, sQLiteDatabase, true);
                    int iMs2 = i2;
                    while (true) {
                        if (iMs2 < c.length) {
                            iMs2 = ms(iMs2, sQLiteDatabase, zfVar.d, z, i, jSONArrayArr, jArr);
                            if (ms(jArr)) {
                                i2 = iMs2;
                            }
                        }
                    }
                }
            }
        }
    }

    private JSONObject ms(vm vmVar, JSONObject jSONObject) {
        if (TextUtils.equals(vmVar.zb, this.d.ka().ah()) && vmVar.sl == this.d.ka().xr()) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            zd.xr(jSONObject2, jSONObject);
            jSONObject2.put("app_version", vmVar.zb);
            jSONObject2.put("version_code", vmVar.sl);
            return jSONObject2;
        } catch (JSONException e) {
            oh.xr(e);
            return jSONObject;
        }
    }

    private void ms(JSONObject jSONObject, vm vmVar, zf zfVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, ArrayList<zf> arrayList) {
        SQLiteDatabase sQLiteDatabase2;
        ti tiVar;
        zf zfVar2;
        int iMs;
        oh.ms("packCurrentData, " + vmVar.d);
        boolean zMs = ms(vmVar.d);
        int iMs2 = ms(0, sQLiteDatabase, vmVar.d, true, 0, jSONArrayArr, jArr);
        if (zMs || ms(jArr)) {
            zfVar.ms(jSONObject, zMs ? vmVar : null, null, null, jSONArrayArr, jArr, 0);
            if (iMs2 >= c.length) {
                zf zfVar3 = (zf) zfVar.clone();
                zfVar3.ch();
                arrayList.add(zfVar3);
                sQLiteDatabase2 = sQLiteDatabase;
                iMs = iMs2;
                tiVar = this;
                zfVar2 = zfVar;
            } else {
                sQLiteDatabase2 = sQLiteDatabase;
                tiVar = this;
                zfVar2 = zfVar;
                tiVar.ms(zfVar2, true, sQLiteDatabase2, true);
                iMs = iMs2;
            }
        } else {
            sQLiteDatabase2 = sQLiteDatabase;
            iMs = iMs2;
            tiVar = this;
            zfVar2 = zfVar;
        }
        while (iMs < c.length) {
            iMs = tiVar.ms(iMs, sQLiteDatabase2, vmVar.d, true, 0, jSONArrayArr, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x008d: INVOKE (r12v4 'iMs' int) = 
                  (r7v2 'tiVar' com.bytedance.embedapplog.ti)
                  (r12v3 'iMs' int)
                  (r3v6 'sQLiteDatabase2' android.database.sqlite.SQLiteDatabase)
                  (wrap java.lang.String:0x0082: IGET (r23v0 'vmVar' com.bytedance.embedapplog.vm) A[WRAPPED] (LINE:277) com.bytedance.embedapplog.vm.d java.lang.String)
                  true
                  (0 int)
                  (r26v0 'jSONArrayArr' org.json.JSONArray[] A[IMMUTABLE_TYPE, METHOD_ARGUMENT])
                  (r2v1 long[])
                 DIRECT call: com.bytedance.embedapplog.ti.ms(int, android.database.sqlite.SQLiteDatabase, java.lang.String, boolean, int, org.json.JSONArray[], long[]):int A[MD:(int, android.database.sqlite.SQLiteDatabase, java.lang.String, boolean, int, org.json.JSONArray[], long[]):int (m)] (LINE:277) in method: com.bytedance.embedapplog.ti.ms(org.json.JSONObject, com.bytedance.embedapplog.vm, com.bytedance.embedapplog.zf, android.database.sqlite.SQLiteDatabase, org.json.JSONArray[], long[], java.util.ArrayList<com.bytedance.embedapplog.zf>):void, file: classes2.dex
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
                java.lang.String r1 = r9.d
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                com.bytedance.embedapplog.oh.ms(r0)
                java.lang.String r0 = r9.d
                boolean r10 = r8.ms(r0)
                r1 = 0
                java.lang.String r3 = r9.d
                r4 = 1
                r5 = 0
                r0 = r21
                r2 = r25
                r6 = r26
                r7 = r27
                int r0 = r0.ms(r1, r2, r3, r4, r5, r6, r7)
                r1 = 0
                r2 = r27
                if (r10 != 0) goto L3a
                boolean r3 = r8.ms(r2)
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
                r11.ms(r12, r13, r14, r15, r16, r17, r18)
                com.bytedance.embedapplog.tz[] r3 = com.bytedance.embedapplog.ti.c
                int r3 = r3.length
                if (r0 < r3) goto L6d
                com.bytedance.embedapplog.tz r3 = r24.clone()
                com.bytedance.embedapplog.zf r3 = (com.bytedance.embedapplog.zf) r3
                r3.ch()
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
                r7.ms(r2, r10, r3, r10)
                r12 = r6
            L7d:
                com.bytedance.embedapplog.tz[] r6 = com.bytedance.embedapplog.ti.c
                int r6 = r6.length
                if (r12 >= r6) goto Lb3
                java.lang.String r14 = r9.d
                r15 = 1
                r16 = 0
                r11 = r7
                r13 = r3
                r17 = r4
                r18 = r5
                int r12 = r11.ms(r12, r13, r14, r15, r16, r17, r18)
                boolean r6 = r7.ms(r5)
                if (r6 == 0) goto L7d
                java.lang.String r6 = r9.d
                boolean r6 = r7.ms(r6)
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
                r13.ms(r14, r15, r16, r17, r18, r19, r20)
                r6 = r12
                goto L78
            Lb3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.ti.ms(org.json.JSONObject, com.bytedance.embedapplog.vm, com.bytedance.embedapplog.zf, android.database.sqlite.SQLiteDatabase, org.json.JSONArray[], long[], java.util.ArrayList):void");
        }

        private void ms(JSONObject jSONObject, vm vmVar, zf zfVar, rt rtVar, vy vyVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr) {
            oh.ms("packHistoryData, " + vmVar.d);
            JSONArray jSONArrayMs = ms(vmVar, true, vyVar, rtVar, sQLiteDatabase);
            boolean z = true;
            vmVar.u = jSONArrayMs.length() == 0;
            int iMs = ms(0, sQLiteDatabase, vmVar.d, true, 0, jSONArrayArr, jArr);
            if (vmVar.u) {
                zfVar.ms(jSONObject, ms(vmVar.d) ? vmVar : null, null, null, jSONArrayArr, jArr, 0);
            } else {
                zfVar.ms(jSONObject, null, vyVar, jSONArrayMs, jSONArrayArr, jArr, 0);
            }
            while (true) {
                ms(zfVar, z, sQLiteDatabase, z);
                int iMs2 = iMs;
                while (iMs2 < c.length) {
                    boolean z2 = z;
                    iMs2 = ms(iMs2, sQLiteDatabase, vmVar.d, true, 0, jSONArrayArr, jArr);
                    if (ms(jArr)) {
                        zfVar.ms(jSONObject, null, null, null, jSONArrayArr, jArr, 0);
                        iMs = iMs2;
                        z = z2;
                    } else {
                        z = z2;
                    }
                }
                return;
            }
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:30:0x00cc A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:32:? A[LOOP:0: B:22:0x00ab->B:32:?, LOOP_END, SYNTHETIC] */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private void ms(org.json.JSONObject r17, com.bytedance.embedapplog.vm r18, com.bytedance.embedapplog.vy r19, com.bytedance.embedapplog.rt r20, com.bytedance.embedapplog.zf r21, android.database.sqlite.SQLiteDatabase r22, java.lang.String r23, org.json.JSONArray[] r24, long[] r25) {
            /*
                Method dump skipped, instruction units count: 209
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.ti.ms(org.json.JSONObject, com.bytedance.embedapplog.vm, com.bytedance.embedapplog.vy, com.bytedance.embedapplog.rt, com.bytedance.embedapplog.zf, android.database.sqlite.SQLiteDatabase, java.lang.String, org.json.JSONArray[], long[]):void");
        }

        private boolean ms(long[] jArr) {
            return jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0;
        }

        public void ms(zf zfVar, boolean z, SQLiteDatabase sQLiteDatabase, boolean z2) {
            boolean z3;
            if (sQLiteDatabase == null) {
                sQLiteDatabase = this.ka.getWritableDatabase();
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                try {
                    sQLiteDatabase.beginTransaction();
                } catch (Throwable th) {
                    try {
                        oh.xr(th);
                        if (z3) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (z3) {
                            zd.ms(sQLiteDatabase);
                        }
                    }
                }
            }
            if (z2 && sQLiteDatabase.insert("pack", null, zfVar.xr((ContentValues) null)) < 0) {
                if (zfVar.y != null) {
                    ms((String) null);
                }
                if (z3) {
                    zd.ms(sQLiteDatabase);
                    return;
                }
                return;
            }
            if (zfVar.ao > 0) {
                sQLiteDatabase.execSQL(ms(NotificationCompat.CATEGORY_EVENT, zfVar.ch, zfVar.d, z, zfVar.ao));
            }
            if (zfVar.qv > 0) {
                sQLiteDatabase.execSQL(ms("eventv3", zfVar.ch, zfVar.d, z, zfVar.qv));
            }
            if (zfVar.nw > 0) {
                sQLiteDatabase.execSQL(ms("event_misc", zfVar.ch, zfVar.d, z, zfVar.nw));
            }
            if (z3) {
                sQLiteDatabase.setTransactionSuccessful();
            }
            if (z3) {
                zd.ms(sQLiteDatabase);
            }
        }

        private int ms(int i, SQLiteDatabase sQLiteDatabase, String str, boolean z, int i2, JSONArray[] jSONArrayArr, long[] jArr) {
            xr.xr();
            int i3 = 0;
            while (i3 < i) {
                jSONArrayArr[i3] = null;
                jArr[i3] = 0;
                i3++;
            }
            int i4 = i3;
            int i5 = 200;
            while (i5 > 0 && i4 < c.length) {
                ms(sQLiteDatabase, str, i5, i4, z, jSONArrayArr, jArr, i2);
                int length = jSONArrayArr[i4].length();
                i5 -= length;
                ah[i4].ah = length;
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

        private void ms(SQLiteDatabase sQLiteDatabase, String str, int i, int i2, boolean z, JSONArray[] jSONArrayArr, long[] jArr, int i3) {
            tz tzVar = c[i2];
            JSONArray jSONArray = new JSONArray();
            Cursor cursor = null;
            long j = 0;
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery(ms(tzVar, str, z, i, i3), null);
                for (int i4 = 0; cursorRawQuery.moveToNext() && i4 <= 200; i4++) {
                    try {
                        tzVar.ms(cursorRawQuery);
                        ah[i2].ms(tzVar);
                        if (oh.xr) {
                            oh.ms("queryEvent, ".concat(String.valueOf(tzVar)), null);
                        }
                        jSONArray.put(tzVar.c());
                        if (tzVar.f529ms > j) {
                            j = tzVar.f529ms;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorRawQuery;
                        try {
                            oh.xr(th);
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Throwable th2) {
                            if (cursor == null) {
                                throw th2;
                            }
                            cursor.close();
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

        /* JADX WARN: Code duplicated, block: B:47:0x00da A[PHI: r12 r15 r17 r18
          0x00da: PHI (r12v2 android.database.Cursor) = (r12v3 android.database.Cursor), (r12v6 android.database.Cursor) binds: [B:46:0x00d8, B:36:0x00c4] A[DONT_GENERATE, DONT_INLINE]
          0x00da: PHI (r15v2 long) = (r15v3 long), (r15v5 long) binds: [B:46:0x00d8, B:36:0x00c4] A[DONT_GENERATE, DONT_INLINE]
          0x00da: PHI (r17v3 java.lang.String) = (r17v4 java.lang.String), (r17v7 java.lang.String) binds: [B:46:0x00d8, B:36:0x00c4] A[DONT_GENERATE, DONT_INLINE]
          0x00da: PHI (r18v2 java.lang.String) = (r18v3 java.lang.String), (r18v5 java.lang.String) binds: [B:46:0x00d8, B:36:0x00c4] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:50:0x00e7  */
        /* JADX WARN: Code duplicated, block: B:52:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:55:0x00f0  */
        /* JADX WARN: Code duplicated, block: B:56:0x00fb  */
        /* JADX WARN: Code duplicated, block: B:59:0x012e  */
        /* JADX WARN: Code duplicated, block: B:60:0x0133  */
        /* JADX WARN: Code duplicated, block: B:62:0x0139  */
        private JSONArray ms(vm vmVar, boolean z, vy vyVar, rt rtVar, SQLiteDatabase sQLiteDatabase) {
            Cursor cursorRawQuery;
            String str;
            String str2;
            long j;
            String str3;
            String str4;
            long j2;
            JSONArray jSONArray = new JSONArray();
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery(ms(vmVar.d, z), null);
                try {
                    HashMap map = new HashMap(8);
                    boolean z2 = false;
                    str = null;
                    str2 = null;
                    j = 0;
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            rtVar.ms(cursorRawQuery);
                            if (oh.xr) {
                                oh.ms("queryPage, ".concat(String.valueOf(rtVar)), null);
                            }
                            Integer num = (Integer) map.get(rtVar.u);
                            z2 = true;
                            if (!rtVar.ch()) {
                                map.put(rtVar.u, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                                j = rtVar.sl >= 1000 ? j + rtVar.sl : j + 1000;
                                jSONArray.put(rtVar.c());
                                if (TextUtils.isEmpty(rtVar.t)) {
                                    continue;
                                } else {
                                    String str5 = rtVar.t;
                                    try {
                                        str = str5;
                                        str2 = rtVar.c;
                                    } catch (Throwable th) {
                                        th = th;
                                        str = str5;
                                        try {
                                            oh.xr(th);
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            str3 = str;
                                            str4 = str2;
                                            if (jSONArray.length() > 0) {
                                                j2 = j > 1000 ? j : 1000L;
                                                vyVar.sl = j2;
                                                if (z) {
                                                    vyVar.d = vmVar.d;
                                                    vyVar.ms(vmVar.xr + j2);
                                                } else {
                                                    vyVar.d = UUID.randomUUID().toString();
                                                    vyVar.ms(0L);
                                                }
                                                vyVar.ka = vmVar.ka;
                                                vyVar.c = vmVar.c;
                                                vyVar.ab = vmVar.ab;
                                                vyVar.x = vmVar.x;
                                                vyVar.zb = vyVar.xr;
                                                vyVar.ah = w.d();
                                                vyVar.u = null;
                                                if (!TextUtils.isEmpty(vmVar.ub)) {
                                                    vyVar.u = vmVar.ub;
                                                } else if (!TextUtils.isEmpty(str3)) {
                                                    vyVar.u = str3;
                                                    vyVar.c = str4;
                                                }
                                            }
                                            return jSONArray;
                                        } catch (Throwable th2) {
                                            if (cursorRawQuery == null) {
                                                throw th2;
                                            }
                                            cursorRawQuery.close();
                                            throw th2;
                                        }
                                    }
                                }
                            } else if (num != null) {
                                Integer numValueOf = Integer.valueOf(num.intValue() - 1);
                                if (numValueOf.intValue() > 0) {
                                    map.put(rtVar.u, numValueOf);
                                } else {
                                    map.remove(rtVar.u);
                                }
                            } else {
                                rtVar.sl = 1000L;
                                j += rtVar.sl;
                                jSONArray.put(rtVar.c());
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    if (z2) {
                        sQLiteDatabase.execSQL(xr(vmVar.d, z));
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str = null;
                    str2 = str;
                    j = 0;
                    oh.xr(th);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    str3 = str;
                    str4 = str2;
                    if (jSONArray.length() > 0) {
                        if (j > 1000) {
                        }
                        vyVar.sl = j2;
                        if (z) {
                            vyVar.d = vmVar.d;
                            vyVar.ms(vmVar.xr + j2);
                        } else {
                            vyVar.d = UUID.randomUUID().toString();
                            vyVar.ms(0L);
                        }
                        vyVar.ka = vmVar.ka;
                        vyVar.c = vmVar.c;
                        vyVar.ab = vmVar.ab;
                        vyVar.x = vmVar.x;
                        vyVar.zb = vyVar.xr;
                        vyVar.ah = w.d();
                        vyVar.u = null;
                        if (!TextUtils.isEmpty(vmVar.ub)) {
                            vyVar.u = vmVar.ub;
                        } else if (!TextUtils.isEmpty(str3)) {
                            vyVar.u = str3;
                            vyVar.c = str4;
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
                vyVar.sl = j2;
                if (z) {
                    vyVar.d = vmVar.d;
                    vyVar.ms(vmVar.xr + j2);
                } else {
                    vyVar.d = UUID.randomUUID().toString();
                    vyVar.ms(0L);
                }
                vyVar.ka = vmVar.ka;
                vyVar.c = vmVar.c;
                vyVar.ab = vmVar.ab;
                vyVar.x = vmVar.x;
                vyVar.zb = vyVar.xr;
                vyVar.ah = w.d();
                vyVar.u = null;
                if (!TextUtils.isEmpty(vmVar.ub)) {
                    vyVar.u = vmVar.ub;
                } else if (!TextUtils.isEmpty(str3)) {
                    vyVar.u = str3;
                    vyVar.c = str4;
                }
            }
            return jSONArray;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x003b A[PHI: r3
          0x003b: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v6 android.database.Cursor) binds: [B:15:0x0039, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
        public ArrayList<zf> ms() {
            Cursor cursorRawQuery;
            ArrayList<zf> arrayList = new ArrayList<>();
            zf zfVar = (zf) xr.get("pack");
            try {
                cursorRawQuery = this.ka.getWritableDatabase().rawQuery("SELECT * FROM pack ORDER BY _id DESC LIMIT 8", null);
                while (cursorRawQuery.moveToNext()) {
                    try {
                        zfVar = (zf) zfVar.clone();
                        zfVar.ms(cursorRawQuery);
                        arrayList.add(zfVar);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            oh.xr(th);
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
            oh.ms("queryPack, ".concat(String.valueOf(arrayList)), null);
            return arrayList;
        }

        public void ms(ArrayList<zf> arrayList, ArrayList<zf> arrayList2, ArrayList<zf> arrayList3) {
            SQLiteDatabase sQLiteDatabase = null;
            oh.ms("setResult, " + arrayList + ", " + arrayList2, null);
            Iterator<zf> it = arrayList2.iterator();
            while (it.hasNext()) {
                zf next = it.next();
                if (!arrayList3.contains(next) && Math.abs(System.currentTimeMillis() - next.xr) > 864000000) {
                    arrayList.add(next);
                    it.remove();
                }
            }
            try {
                SQLiteDatabase writableDatabase = this.ka.getWritableDatabase();
                try {
                    writableDatabase.beginTransaction();
                    try {
                        for (zf zfVar : arrayList) {
                            if (arrayList3.contains(zfVar)) {
                                ms(zfVar, true, writableDatabase, false);
                            } else {
                                writableDatabase.execSQL("DELETE FROM pack WHERE _id=?", new String[]{String.valueOf(zfVar.f529ms)});
                            }
                        }
                    } catch (Throwable th) {
                        oh.xr(th);
                    }
                    for (zf zfVar2 : arrayList2) {
                        if (zfVar2.y != null) {
                            ms((String) null);
                        }
                        if (!arrayList3.contains(zfVar2)) {
                            long j = zfVar2.f529ms;
                            int i = zfVar2.zb + 1;
                            zfVar2.zb = i;
                            writableDatabase.execSQL(ms(j, i));
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    zd.ms(writableDatabase);
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = writableDatabase;
                    try {
                        oh.xr(th);
                    } finally {
                        zd.ms(sQLiteDatabase);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public void ms(ArrayList<tz> arrayList) {
            ArrayList arrayList2 = new ArrayList(4);
            ArrayList arrayList3 = new ArrayList(4);
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase writableDatabase = this.ka.getWritableDatabase();
                try {
                    writableDatabase.beginTransaction();
                    ContentValues contentValuesXr = null;
                    for (tz tzVar : arrayList) {
                        String strD = tzVar.d();
                        contentValuesXr = tzVar.xr(contentValuesXr);
                        tzVar.f529ms = writableDatabase.insert(strD, null, contentValuesXr);
                        if (NotificationCompat.CATEGORY_EVENT.equals(tzVar.d())) {
                            arrayList3.add(tzVar);
                        } else if ("eventv3".equals(tzVar.d())) {
                            arrayList3.add(tzVar);
                        } else if (tzVar instanceof vm) {
                            arrayList2.add((vm) tzVar);
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    zd.ms(writableDatabase);
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = writableDatabase;
                    try {
                        oh.xr(th);
                    } finally {
                        zd.ms(sQLiteDatabase);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        static class ms extends SQLiteOpenHelper {
            ms(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
                super(new com.bytedance.sdk.openadsdk.api.plugin.ms(context), str, cursorFactory, i);
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                try {
                    sQLiteDatabase.beginTransaction();
                    Iterator<tz> it = ti.xr.values().iterator();
                    while (it.hasNext()) {
                        String strAh = it.next().ah();
                        if (strAh != null) {
                            sQLiteDatabase.execSQL(strAh);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    zd.ms(sQLiteDatabase);
                } catch (Throwable th) {
                    try {
                        oh.xr(th);
                    } finally {
                        zd.ms(sQLiteDatabase);
                    }
                }
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                oh.d("onUpgrade, " + i + ", " + i2, null);
                try {
                    sQLiteDatabase.beginTransaction();
                    Iterator<tz> it = ti.xr.values().iterator();
                    while (it.hasNext()) {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().d());
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Throwable th) {
                    try {
                        oh.ah("", th);
                    } catch (Throwable th2) {
                        zd.ms(sQLiteDatabase);
                        throw th2;
                    }
                }
                zd.ms(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                onUpgrade(sQLiteDatabase, i, i2);
            }
        }
    }
