package com.anythink.core.common.t.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.text.TextUtils;
import com.anythink.core.common.t.a.b.a.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.anythink.core.common.f.b<c> {
    private static final String a = "com.anythink.core.common.t.a.a.b";
    private static b b = null;
    private static final int d = 1000;
    private int c;

    public static class a {
        public static final String a = "track_request_info";
        public static final String b = "id";
        public static final String c = "req_content";
        public static final String d = "is_read";
        public static final String e = "is_ofl";
        public static final String f = "create_time";
        public static final String g = "CREATE TABLE IF NOT EXISTS track_request_info(id TEXT, req_content TEXT, is_read INTEGER DEFAULT 0,is_ofl INTEGER DEFAULT 0,create_time INTEGER NOT NULL)";
    }

    private b(com.anythink.core.common.f.c cVar) {
        super(cVar);
        this.c = 10000;
        e();
    }

    public static b a(com.anythink.core.common.f.c cVar) {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(cVar);
                }
            }
        }
        return b;
    }

    private synchronized void d() {
        try {
            if (b() == null) {
                return;
            }
            b().delete(a.a, null, null);
        } catch (Exception unused) {
        }
    }

    private synchronized int e() {
        if (b() == null) {
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 0);
            b().beginTransaction();
            try {
                int iUpdate = b().update(a.a, contentValues, null, null);
                b().setTransactionSuccessful();
                b().endTransaction();
                return iUpdate;
            } catch (Throwable th) {
                b().endTransaction();
                throw th;
            }
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final synchronized long a(c cVar) {
        if (b() == null) {
            return -1L;
        }
        try {
            if (DatabaseUtils.queryNumEntries(a(), a.a) >= this.c) {
                f();
            }
        } catch (Throwable unused) {
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", cVar.a);
            contentValues.put("req_content", cVar.e);
            contentValues.put("is_read", (Integer) 0);
            contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
            return b().insert(a.a, null, contentValues);
        } catch (Exception unused2) {
            return -1L;
        }
    }

    public final synchronized long c() {
        if (a() == null) {
            return 0L;
        }
        try {
            return DatabaseUtils.queryNumEntries(a(), a.a, "is_read=?", new String[]{"0"});
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private synchronized void f() {
        if (b() == null) {
            return;
        }
        try {
            b().execSQL("DELETE FROM track_request_info WHERE id IN (SELECT id FROM track_request_info ORDER BY is_ofl ASC, create_time ASC LIMIT 1000)");
        } catch (Throwable unused) {
        }
    }

    private synchronized int b(c cVar) {
        if (b() == null || cVar == null) {
            return -1;
        }
        try {
            return b().delete(a.a, "id=?", new String[]{cVar.a});
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final synchronized int a(List<c> list) {
        if (b() == null || list == null || list.isEmpty()) {
            return -1;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append("?");
                strArr[i] = list.get(i).a;
            }
            return b().delete(a.a, "id IN (" + sb.toString() + ")", strArr);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00fd A[Catch: all -> 0x010c, PHI: r11
      0x00fd: PHI (r11v7 android.database.Cursor) = (r11v5 android.database.Cursor), (r11v6 android.database.Cursor), (r11v8 android.database.Cursor) binds: [B:30:0x00f4, B:34:0x00fb, B:41:0x0109] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #8 {, blocks: (B:26:0x00ee, B:35:0x00fd, B:38:0x0104, B:39:0x0107, B:33:0x00f8), top: B:55:0x0002, inners: #0 }] */
    public final synchronized List<c> a(long j, boolean z) {
        Cursor cursorQuery;
        ArrayList arrayList = null;
        try {
            cursorQuery = a().query(a.a, null, "is_read=?", new String[]{"0"}, null, null, "create_time" + (z ? " DESC" : " ASC"), String.valueOf(j));
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            c cVar = new c();
                            cVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                            cVar.e = cursorQuery.getString(cursorQuery.getColumnIndex("req_content"));
                            cVar.a(cursorQuery.getInt(cursorQuery.getColumnIndex(a.e)));
                            arrayList2.add(cVar);
                            arrayList3.add(cVar.a);
                        }
                        if (!arrayList3.isEmpty()) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_read", (Integer) 1);
                            String str = "id IN (" + TextUtils.join(",", Collections.nCopies(arrayList3.size(), "?")) + ")";
                            b().beginTransaction();
                            try {
                                b().update(a.a, contentValues, str, (String[]) arrayList3.toArray(new String[0]));
                                b().setTransactionSuccessful();
                                b().endTransaction();
                            } catch (Throwable th) {
                                b().endTransaction();
                                throw th;
                            }
                        }
                        arrayList = arrayList2;
                    }
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                } catch (OutOfMemoryError unused2) {
                    try {
                        System.gc();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th2;
                    }
                } catch (Throwable unused3) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Exception unused4) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused5) {
            cursorQuery = null;
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
    }

    private synchronized List<c> a(long j) {
        return a(j, true);
    }

    public final synchronized int b(List<c> list) {
        if (b() == null || list == null || list.isEmpty()) {
            return -1;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append("?");
                strArr[i] = list.get(i).a;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 0);
            contentValues.put(a.e, (Integer) 1);
            return b().update(a.a, contentValues, "id IN (" + sb.toString() + ")", strArr);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
