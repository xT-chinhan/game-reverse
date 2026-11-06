package com.anythink.core.common.f;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k extends b<com.anythink.core.common.a.f> {
    private static volatile k b;
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

    private k(c cVar) {
        super(cVar);
        this.a = "k";
    }

    public static k a(c cVar) {
        if (b == null) {
            synchronized (i.class) {
                if (b == null) {
                    b = new k(cVar);
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
            contentValues.put(a.c, str2);
            contentValues.put(a.d, Integer.valueOf(i));
            contentValues.put(a.e, Long.valueOf(j2));
            contentValues.put(a.f, Long.valueOf(j));
            contentValues.put(a.g, Long.valueOf(System.currentTimeMillis()));
            if (d(str)) {
                b().update(a.a, contentValues, "video_url = ? ", new String[]{str});
            } else {
                b().insert(a.a, null, contentValues);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0075 A[PHI: r1
      0x0075: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:13:0x0073, B:10:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    public final com.anythink.core.common.a.f a(String str) {
        Cursor cursorQuery;
        try {
            cursorQuery = a().query(a.a, null, "video_url=?", new String[]{str}, null, null, null);
            try {
                if (cursorQuery.moveToNext()) {
                    com.anythink.core.common.a.f fVar = new com.anythink.core.common.a.f();
                    fVar.a(str);
                    fVar.b(cursorQuery.getString(cursorQuery.getColumnIndex(a.c)));
                    fVar.a(cursorQuery.getInt(cursorQuery.getColumnIndex(a.d)));
                    fVar.b(cursorQuery.getLong(cursorQuery.getColumnIndex(a.e)));
                    fVar.a(cursorQuery.getLong(cursorQuery.getColumnIndex(a.f)));
                    fVar.c(cursorQuery.getLong(cursorQuery.getColumnIndex(a.g)));
                    cursorQuery.close();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return fVar;
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
            contentValues.put(a.g, Long.valueOf(System.currentTimeMillis()));
            b().update(a.a, contentValues, "video_url = ? ", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public final long c() {
        Cursor cursorQuery;
        try {
            cursorQuery = a().query(a.a, new String[]{"sum(download_size)"}, null, null, null, null, null);
            try {
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
            } catch (Throwable unused) {
                if (cursorQuery == null) {
                    return 0L;
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        cursorQuery.close();
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x00b3 A[PHI: r2
      0x00b3: PHI (r2v2 android.database.Cursor) = (r2v1 android.database.Cursor), (r2v4 android.database.Cursor) binds: [B:15:0x00b1, B:12:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
    public final List<com.anythink.core.common.a.f> d() {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            cursorQuery = a().query(a.a, null, null, null, null, null, "update_time DESC");
            try {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToPosition(((int) Math.round(((((double) cursorQuery.getCount()) * 1.0d) + 1.0d) / 2.0d)) - 1)) {
                    long j = cursorQuery.getLong(cursorQuery.getColumnIndex(a.g));
                    do {
                        com.anythink.core.common.a.f fVar = new com.anythink.core.common.a.f();
                        fVar.a(cursorQuery.getString(cursorQuery.getColumnIndex("video_url")));
                        fVar.b(cursorQuery.getString(cursorQuery.getColumnIndex(a.c)));
                        fVar.a(cursorQuery.getInt(cursorQuery.getColumnIndex(a.d)));
                        fVar.b(cursorQuery.getLong(cursorQuery.getColumnIndex(a.e)));
                        fVar.a(cursorQuery.getLong(cursorQuery.getColumnIndex(a.f)));
                        fVar.c(cursorQuery.getLong(cursorQuery.getColumnIndex(a.g)));
                        arrayList.add(fVar);
                    } while (cursorQuery.moveToNext());
                    b().delete(a.a, "update_time<=?", new String[]{String.valueOf(j)});
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
        return arrayList;
    }

    private void e() {
        try {
            Cursor cursorQuery = a().query(a.a, null, null, null, null, null, null);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable unused) {
        }
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b().delete(a.a, "video_url=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0039 A[PHI: r11
      0x0039: PHI (r11v3 android.database.Cursor) = (r11v2 android.database.Cursor), (r11v4 android.database.Cursor) binds: [B:16:0x0037, B:13:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    private boolean d(String str) {
        Cursor cursorQuery;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            cursorQuery = a().query(a.a, new String[]{"video_url"}, "video_url=?", new String[]{str}, null, null, null);
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
