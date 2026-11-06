package com.anythink.core.common.e;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends c<com.anythink.core.common.a.l> {
    private static volatile b b;
    private final String a;

    public static class a {
        public static final String a = "adx_offer_tracking";
        public static final String b = "placement_id";
        public static final String c = "dsp_id";
        public static final String d = "offer_id";
        public static final String e = "tk_type";
        public static final String f = "extra_info";
        public static final String g = "create_time";
        public static final String h = "CREATE TABLE IF NOT EXISTS adx_offer_tracking(placement_id TEXT ,dsp_id TEXT ,offer_id TEXT ,tk_type INTEGER ,extra_info TEXT ,create_time INTEGER)";
    }

    private b(d dVar) {
        super(dVar);
        this.a = b.class.getName();
    }

    public static b a(d dVar) {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(dVar);
                }
            }
        }
        return b;
    }

    public final synchronized long a(com.anythink.core.common.a.g gVar) {
        if (d() == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("placement_id", gVar.a());
            contentValues.put("dsp_id", gVar.b());
            contentValues.put("offer_id", gVar.c());
            contentValues.put(a.e, Integer.valueOf(gVar.d()));
            contentValues.put(a.f, gVar.e());
            contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
            gVar.b();
            gVar.c();
            return d().insert(a.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003b A[Catch: all -> 0x004a, PHI: r1
      0x003b: PHI (r1v5 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v4 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:11:0x0032, B:15:0x0039, B:22:0x0047] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #5 {, blocks: (B:7:0x002c, B:16:0x003b, B:19:0x0042, B:20:0x0045, B:14:0x0036), top: B:32:0x0002, inners: #7 }] */
    public final synchronized List<com.anythink.core.common.a.g> a() {
        Cursor cursorQuery;
        try {
            cursorQuery = c().query(a.a, null, "create_time >= ? ", new String[]{String.valueOf(e())}, null, null, null);
            try {
                List<com.anythink.core.common.a.g> listA = a(cursorQuery);
                cursorQuery.close();
                listA.size();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listA;
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
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } catch (Throwable unused3) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
        } catch (Exception unused4) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused5) {
            cursorQuery = null;
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
    }

    private synchronized List<com.anythink.core.common.a.g> a(Cursor cursor) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                try {
                    com.anythink.core.common.a.g gVar = new com.anythink.core.common.a.g();
                    int columnIndex = cursor.getColumnIndex("placement_id");
                    if (columnIndex >= 0) {
                        gVar.a(cursor.getString(columnIndex));
                    }
                    int columnIndex2 = cursor.getColumnIndex("dsp_id");
                    if (columnIndex2 >= 0) {
                        gVar.b(cursor.getString(columnIndex2));
                    }
                    int columnIndex3 = cursor.getColumnIndex("offer_id");
                    if (columnIndex3 >= 0) {
                        gVar.c(cursor.getString(columnIndex3));
                    }
                    int columnIndex4 = cursor.getColumnIndex(a.e);
                    if (columnIndex4 >= 0) {
                        gVar.a(cursor.getInt(columnIndex4));
                    }
                    int columnIndex5 = cursor.getColumnIndex(a.f);
                    if (columnIndex5 >= 0) {
                        gVar.d(cursor.getString(columnIndex5));
                    }
                    arrayList.add(gVar);
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    public final void b() {
        try {
            String str = "create_time < " + e();
            if (d() == null) {
                return;
            }
            d().delete(a.a, str, null);
        } catch (Exception unused) {
        }
    }

    private static long e() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
