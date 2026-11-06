package com.anythink.core.common.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class q extends c<com.anythink.core.common.a.n> {
    private static volatile q b;
    private final String a;

    public static class a {
        public static final String a = "video_res_cache_info";
        public static final String b = "video_url";
        public static final String c = "file_path";
        public static final String d = "ready_rate";
        public static final String e = "download_size";
        public static final String f = "total_size";
        public static final String g = "update_time";
        public static final String h = "CREATE TABLE IF NOT EXISTS video_res_cache_info(video_url TEXT, file_path TEXT, ready_rate INTEGER, download_size INTEGER, total_size INTEGER, update_time INTEGER )";
    }

    private q(d dVar) {
        super(dVar);
        this.a = "q";
    }

    public static q a(d dVar) {
        if (b == null) {
            synchronized (o.class) {
                if (b == null) {
                    b = new q(dVar);
                }
            }
        }
        return b;
    }

    public final synchronized void a(String str, String str2, long j, long j2, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("video_url", str);
            contentValues.put("file_path", str2);
            contentValues.put(a.d, Integer.valueOf(i));
            contentValues.put(a.e, Long.valueOf(j2));
            contentValues.put(a.f, Long.valueOf(j));
            contentValues.put("update_time", Long.valueOf(System.currentTimeMillis()));
            if (e(str)) {
                d().update(a.a, contentValues, "video_url = ? ", new String[]{str});
            } else {
                d().insert(a.a, null, contentValues);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0075 A[PHI: r1
      0x0075: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:13:0x0073, B:10:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    public final com.anythink.core.common.a.n a(String str) {
        Cursor cursorQuery;
        try {
            cursorQuery = c().query(a.a, null, "video_url=?", new String[]{str}, null, null, null);
            try {
                if (cursorQuery.moveToNext()) {
                    com.anythink.core.common.a.n nVar = new com.anythink.core.common.a.n();
                    nVar.a(str);
                    nVar.b(cursorQuery.getString(cursorQuery.getColumnIndex("file_path")));
                    nVar.a(cursorQuery.getInt(cursorQuery.getColumnIndex(a.d)));
                    nVar.b(cursorQuery.getLong(cursorQuery.getColumnIndex(a.e)));
                    nVar.a(cursorQuery.getLong(cursorQuery.getColumnIndex(a.f)));
                    nVar.c(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time")));
                    cursorQuery.close();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return nVar;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable unused) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return null;
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("update_time", Long.valueOf(System.currentTimeMillis()));
            d().update(a.a, contentValues, "video_url = ? ", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public final long a() {
        Cursor cursorQuery = null;
        try {
            cursorQuery = c().query(a.a, new String[]{"sum(download_size)"}, null, null, null, null, null);
            if (cursorQuery.moveToNext()) {
                long j = cursorQuery.getLong(0);
                cursorQuery.close();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return j;
            }
            if (cursorQuery == null) {
                return 0L;
            }
        } catch (Throwable th) {
            try {
                th.getMessage();
                if (cursorQuery == null) {
                    return 0L;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00af, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00b0, code lost:
    
        r0.getMessage();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.anythink.core.common.a.n> b() {
        /*
            r11 = this;
            java.lang.String r0 = "update_time"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r11.c()     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r4 = "video_res_cache_info"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "update_time DESC"
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lb9
            int r3 = r2.getCount()     // Catch: java.lang.Throwable -> Lb9
            if (r3 <= 0) goto Lb3
            int r3 = r2.getCount()     // Catch: java.lang.Throwable -> Lb9
            double r3 = (double) r3     // Catch: java.lang.Throwable -> Lb9
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 * r5
            double r3 = r3 + r5
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r3 = r3 / r5
            long r3 = java.lang.Math.round(r3)     // Catch: java.lang.Throwable -> Lb9
            int r3 = (int) r3     // Catch: java.lang.Throwable -> Lb9
            r4 = 1
            int r3 = r3 - r4
            boolean r3 = r2.moveToPosition(r3)     // Catch: java.lang.Throwable -> Lb9
            if (r3 == 0) goto Lb3
            int r3 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Lb9
            long r5 = r2.getLong(r3)     // Catch: java.lang.Throwable -> Lb9
        L40:
            com.anythink.core.common.a.n r3 = new com.anythink.core.common.a.n     // Catch: java.lang.Throwable -> Lb9
            r3.<init>()     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r7 = "video_url"
            int r7 = r2.getColumnIndex(r7)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r7 = r2.getString(r7)     // Catch: java.lang.Throwable -> Lb9
            r3.a(r7)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r7 = "file_path"
            int r7 = r2.getColumnIndex(r7)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r7 = r2.getString(r7)     // Catch: java.lang.Throwable -> Lb9
            r3.b(r7)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r7 = "ready_rate"
            int r7 = r2.getColumnIndex(r7)     // Catch: java.lang.Throwable -> Lb9
            int r7 = r2.getInt(r7)     // Catch: java.lang.Throwable -> Lb9
            r3.a(r7)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r7 = "download_size"
            int r7 = r2.getColumnIndex(r7)     // Catch: java.lang.Throwable -> Lb9
            long r7 = r2.getLong(r7)     // Catch: java.lang.Throwable -> Lb9
            r3.b(r7)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r7 = "total_size"
            int r7 = r2.getColumnIndex(r7)     // Catch: java.lang.Throwable -> Lb9
            long r7 = r2.getLong(r7)     // Catch: java.lang.Throwable -> Lb9
            r3.a(r7)     // Catch: java.lang.Throwable -> Lb9
            int r7 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Lb9
            long r7 = r2.getLong(r7)     // Catch: java.lang.Throwable -> Lb9
            r3.c(r7)     // Catch: java.lang.Throwable -> Lb9
            r1.add(r3)     // Catch: java.lang.Throwable -> Lb9
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> Lb9
            if (r3 != 0) goto L40
            android.database.sqlite.SQLiteDatabase r0 = r11.d()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r3 = "video_res_cache_info"
            java.lang.String r7 = "update_time<=?"
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> Laf
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> Laf
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.Throwable -> Laf
            r0.delete(r3, r7, r4)     // Catch: java.lang.Throwable -> Laf
            goto Lb3
        Laf:
            r0 = move-exception
            r0.getMessage()     // Catch: java.lang.Throwable -> Lb9
        Lb3:
            if (r2 == 0) goto Lc0
        Lb5:
            r2.close()
            goto Lc0
        Lb9:
            r0 = move-exception
            r0.getMessage()     // Catch: java.lang.Throwable -> Lc1
            if (r2 == 0) goto Lc0
            goto Lb5
        Lc0:
            return r1
        Lc1:
            r0 = move-exception
            if (r2 == 0) goto Lc7
            r2.close()
        Lc7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.e.q.b():java.util.List");
    }

    private void d(String str) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = c().query(a.a, null, null, null, null, null, null);
            cursorQuery.getCount();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            try {
                th.getMessage();
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            d().delete(a.a, "video_url=?", new String[]{str});
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0039 A[PHI: r11
      0x0039: PHI (r11v3 android.database.Cursor) = (r11v2 android.database.Cursor), (r11v4 android.database.Cursor) binds: [B:16:0x0037, B:13:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    private boolean e(String str) {
        Cursor cursorQuery;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            cursorQuery = c().query(a.a, new String[]{"video_url"}, "video_url=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.close();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
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
}
