package com.smartdigimkt.z2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.smartdigimkt.t2.v;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends b {
    public static volatile r b;

    public r(d dVar) {
        super(dVar);
    }

    public final v a(String str) {
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabaseA;
        try {
            synchronized (this) {
                sQLiteDatabaseA = this.a.a();
            }
            cursorQuery = sQLiteDatabaseA.query(com.anythink.core.common.f.k.a.a, null, "video_url=?", new String[]{str}, null, null, null);
            try {
                if (cursorQuery.moveToNext()) {
                    v vVar = new v();
                    vVar.a = str;
                    vVar.b = cursorQuery.getString(cursorQuery.getColumnIndex(com.anythink.core.common.f.k.a.c));
                    vVar.c = cursorQuery.getInt(cursorQuery.getColumnIndex(com.anythink.core.common.f.k.a.d));
                    vVar.e = cursorQuery.getLong(cursorQuery.getColumnIndex(com.anythink.core.common.f.k.a.e));
                    vVar.d = cursorQuery.getLong(cursorQuery.getColumnIndex(com.anythink.core.common.f.k.a.f));
                    cursorQuery.getLong(cursorQuery.getColumnIndex(com.anythink.core.common.f.k.a.g));
                    cursorQuery.close();
                    cursorQuery.close();
                    return vVar;
                }
            } catch (Throwable unused) {
                if (cursorQuery != null) {
                }
                return null;
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        cursorQuery.close();
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003e A[PHI: r11
      0x003e: PHI (r11v3 android.database.Cursor) = (r11v2 android.database.Cursor), (r11v5 android.database.Cursor) binds: [B:21:0x003c, B:15:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    public final boolean b(String str) {
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabaseA;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            synchronized (this) {
                sQLiteDatabaseA = this.a.a();
            }
            cursorQuery = sQLiteDatabaseA.query(com.anythink.core.common.f.k.a.a, new String[]{"video_url"}, "video_url=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.close();
                        cursorQuery.close();
                        return true;
                    }
                } catch (Throwable unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return false;
    }

    public final void c(String str) {
        SQLiteDatabase sQLiteDatabaseB;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this) {
            sQLiteDatabaseB = this.a.b();
        }
        if (sQLiteDatabaseB == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(com.anythink.core.common.f.k.a.g, Long.valueOf(System.currentTimeMillis()));
            sQLiteDatabaseB.update(com.anythink.core.common.f.k.a.a, contentValues, "video_url = ? ", new String[]{str});
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ac, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00ad, code lost:
    
        r2.getMessage();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.ArrayList d() {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            monitor-enter(r11)     // Catch: java.lang.Throwable -> Lb4
            com.smartdigimkt.z2.d r2 = r11.a     // Catch: java.lang.Throwable -> Lb1
            android.database.sqlite.SQLiteDatabase r3 = r2.a()     // Catch: java.lang.Throwable -> Lb1
            monitor-exit(r11)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r4 = "video_res_cache_info"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "update_time DESC"
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lb4
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> Lb4
            if (r2 <= 0) goto Lba
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> Lb4
            double r2 = (double) r2     // Catch: java.lang.Throwable -> Lb4
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r2 = r2 * r4
            double r2 = r2 + r4
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = r2 / r4
            long r2 = java.lang.Math.round(r2)     // Catch: java.lang.Throwable -> Lb4
            int r2 = (int) r2     // Catch: java.lang.Throwable -> Lb4
            r3 = 1
            int r2 = r2 - r3
            boolean r2 = r1.moveToPosition(r2)     // Catch: java.lang.Throwable -> Lb4
            if (r2 == 0) goto Lba
            java.lang.String r2 = "update_time"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lb4
            long r4 = r1.getLong(r2)     // Catch: java.lang.Throwable -> Lb4
        L44:
            com.smartdigimkt.t2.v r2 = new com.smartdigimkt.t2.v     // Catch: java.lang.Throwable -> Lb4
            r2.<init>()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = "video_url"
            int r6 = r1.getColumnIndex(r6)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = r1.getString(r6)     // Catch: java.lang.Throwable -> Lb4
            r2.a = r6     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = "file_path"
            int r6 = r1.getColumnIndex(r6)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = r1.getString(r6)     // Catch: java.lang.Throwable -> Lb4
            r2.b = r6     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = "ready_rate"
            int r6 = r1.getColumnIndex(r6)     // Catch: java.lang.Throwable -> Lb4
            int r6 = r1.getInt(r6)     // Catch: java.lang.Throwable -> Lb4
            r2.c = r6     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = "download_size"
            int r6 = r1.getColumnIndex(r6)     // Catch: java.lang.Throwable -> Lb4
            long r6 = r1.getLong(r6)     // Catch: java.lang.Throwable -> Lb4
            r2.e = r6     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = "total_size"
            int r6 = r1.getColumnIndex(r6)     // Catch: java.lang.Throwable -> Lb4
            long r6 = r1.getLong(r6)     // Catch: java.lang.Throwable -> Lb4
            r2.d = r6     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r6 = "update_time"
            int r6 = r1.getColumnIndex(r6)     // Catch: java.lang.Throwable -> Lb4
            r1.getLong(r6)     // Catch: java.lang.Throwable -> Lb4
            r0.add(r2)     // Catch: java.lang.Throwable -> Lb4
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> Lb4
            if (r2 != 0) goto L44
            android.database.sqlite.SQLiteDatabase r2 = r11.b()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r6 = "video_res_cache_info"
            java.lang.String r7 = "update_time<=?"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> Lac
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> Lac
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.Throwable -> Lac
            r2.delete(r6, r7, r3)     // Catch: java.lang.Throwable -> Lac
            goto Lba
        Lac:
            r2 = move-exception
            r2.getMessage()     // Catch: java.lang.Throwable -> Lb4
            goto Lba
        Lb1:
            r2 = move-exception
            monitor-exit(r11)     // Catch: java.lang.Throwable -> Lb4
            throw r2     // Catch: java.lang.Throwable -> Lb4
        Lb4:
            r2 = move-exception
            r2.getMessage()     // Catch: java.lang.Throwable -> Lbe
            if (r1 == 0) goto Lbd
        Lba:
            r1.close()
        Lbd:
            return r0
        Lbe:
            r0 = move-exception
            if (r1 == 0) goto Lc4
            r1.close()
        Lc4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.z2.r.d():java.util.ArrayList");
    }

    public final long c() {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorQuery = null;
        try {
            synchronized (this) {
                sQLiteDatabaseA = this.a.a();
            }
            cursorQuery = sQLiteDatabaseA.query(com.anythink.core.common.f.k.a.a, new String[]{"sum(download_size)"}, null, null, null, null, null);
            if (cursorQuery.moveToNext()) {
                long j = cursorQuery.getLong(0);
                cursorQuery.close();
                cursorQuery.close();
                return j;
            }
        } catch (Throwable th) {
            try {
                th.getMessage();
                if (cursorQuery == null) {
                    return 0L;
                }
            } finally {
                if (0 != 0) {
                    cursorQuery.close();
                }
            }
        }
        return 0L;
    }
}
