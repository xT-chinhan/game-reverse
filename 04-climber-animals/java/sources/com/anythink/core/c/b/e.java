package com.anythink.core.c.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.anythink.core.common.d.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.anythink.core.common.e.c<com.anythink.core.c.a.a> {
    private static final String a = "PlacementStatisticsDao";
    private static final int b = 50;
    private static volatile e c;

    public static class a {
        public static final String a = "user_value_placement";
        public static final String b = "type";
        public static final String c = "placement_id";
        public static final String d = "request_id";
        public static final String e = "network_firm_id";
        public static final String f = "ad_source_id";
        public static final String g = "dsp_id";
        public static final String h = "price";
        public static final String i = "record_time";
        public static final String j = "ps_id";
        public static final String k = "segment_id";
        public static final String l = "CREATE TABLE IF NOT EXISTS user_value_placement(type INTEGER, placement_id TEXT, request_id TEXT, network_firm_id INTEGER, ad_source_id TEXT, dsp_id TEXT, price DOUBLE, record_time INTEGER, ps_id TEXT )";
        public static final String m = "ALTER TABLE user_value_placement ADD COLUMN segment_id INTEGER";
        public static final String n = "CREATE INDEX placement_id ON user_value_placement (placement_id)";
    }

    private e(com.anythink.core.common.e.d dVar) {
        super(dVar);
    }

    public static e a() {
        if (c == null) {
            synchronized (e.class) {
                if (c == null) {
                    c = new e(com.anythink.core.common.e.e.a(t.b().g()));
                }
            }
        }
        return c;
    }

    public final synchronized void a(com.anythink.core.c.a.a aVar) {
        boolean z;
        int iK = aVar.k();
        Cursor cursor = null;
        try {
            try {
                String strJ = aVar.j();
                String strB = aVar.b();
                SQLiteDatabase sQLiteDatabaseD = d();
                ContentValues contentValues = new ContentValues();
                contentValues.put("type", Integer.valueOf(iK));
                contentValues.put("placement_id", strJ);
                contentValues.put("request_id", strB);
                contentValues.put("ad_source_id", aVar.d());
                contentValues.put("network_firm_id", Integer.valueOf(aVar.c()));
                contentValues.put("dsp_id", aVar.e());
                contentValues.put("price", Double.valueOf(aVar.f()));
                contentValues.put(a.i, Long.valueOf(aVar.g()));
                contentValues.put("ps_id", aVar.h());
                contentValues.put("segment_id", Integer.valueOf(aVar.a()));
                Cursor cursorQuery = c().query(a.a, new String[]{"placement_id", "request_id"}, "placement_id=? AND request_id=? AND type=?", new String[]{strJ, strB, String.valueOf(iK)}, null, null, null);
                if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    z = false;
                } else {
                    cursorQuery.close();
                    z = true;
                }
                if (z) {
                    d().update(a.a, contentValues, "placement_id = ? AND request_id = ? AND type = ?", new String[]{strJ, strB, String.valueOf(iK)});
                    return;
                }
                Cursor cursorQuery2 = sQLiteDatabaseD.query(a.a, new String[]{a.i}, "type = ? AND placement_id = ?", new String[]{String.valueOf(iK), strJ}, null, null, "record_time ASC");
                try {
                    int count = cursorQuery2.getCount();
                    Object[] objArr = new Object[3];
                    Integer.valueOf(count);
                    Integer.valueOf(iK);
                    if (count > 50) {
                        long j = cursorQuery2.moveToNext() ? cursorQuery2.getLong(cursorQuery2.getColumnIndexOrThrow(a.i)) : 0L;
                        if (j != 0) {
                            Object[] objArr2 = new Object[2];
                            Integer.valueOf(sQLiteDatabaseD.delete(a.a, "record_time = ?", new String[]{String.valueOf(j)}));
                            Long.valueOf(j);
                        }
                    }
                    Object[] objArr3 = new Object[2];
                    Long.valueOf(sQLiteDatabaseD.insertOrThrow(a.a, null, contentValues));
                    Thread.currentThread().getName();
                    if (cursorQuery2 != null) {
                        cursorQuery2.close();
                    }
                } catch (Exception e) {
                    e = e;
                    cursor = cursorQuery2;
                    Object[] objArr4 = new Object[2];
                    e.getMessage();
                    Thread.currentThread().getName();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private boolean a(String str, String str2, int i) {
        Cursor cursorQuery = c().query(a.a, new String[]{"placement_id", "request_id"}, "placement_id=? AND request_id=? AND type=?", new String[]{str, str2, String.valueOf(i)}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    public final synchronized List<com.anythink.core.c.a.a> a(String str, int i, long j, int i2) {
        ArrayList arrayList;
        String str2;
        String[] strArr;
        arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                if (i == -1) {
                    str2 = "placement_id = ? AND record_time > ? AND price > ?";
                    strArr = new String[]{str, String.valueOf(j), "0"};
                } else {
                    str2 = "placement_id = ? AND segment_id = ? AND record_time > ? AND price > ?";
                    strArr = new String[]{str, String.valueOf(i), String.valueOf(j), "0"};
                }
                cursorQuery = c().query(a.a, null, str2, strArr, null, null, null, String.valueOf(i2));
                while (cursorQuery.moveToNext()) {
                    arrayList.add(a(cursorQuery));
                    Object[] objArr = new Object[2];
                    Thread.currentThread().getName();
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e) {
                Object[] objArr2 = new Object[2];
                e.getMessage();
                Thread.currentThread().getName();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0076 A[Catch: all -> 0x007a, TRY_ENTER, TryCatch #3 {all -> 0x007a, blocks: (B:10:0x0054, B:21:0x006d, B:27:0x0076, B:28:0x0079), top: B:35:0x0003 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final synchronized List<com.anythink.core.c.a.a> a(int i, String str, int i2) {
        Cursor cursorQuery;
        ?? r1 = 0;
        try {
            try {
                try {
                    ArrayList arrayList = new ArrayList();
                    cursorQuery = c().query(a.a, null, "type = ? AND placement_id = ?", new String[]{String.valueOf(i), str}, null, null, "record_time DESC", String.valueOf(i2));
                    while (cursorQuery.moveToNext()) {
                        try {
                            arrayList.add(a(cursorQuery));
                        } catch (Exception e) {
                            e = e;
                            Object[] objArr = new Object[2];
                            e.getMessage();
                            Thread.currentThread().getName();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return null;
                        }
                    }
                    Object[] objArr2 = new Object[5];
                    Integer.valueOf(i);
                    Integer.valueOf(i2);
                    Integer.valueOf(arrayList.size());
                    Long.valueOf(Thread.currentThread().getId());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    r1 = str;
                    if (r1 != 0) {
                        r1.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    private static com.anythink.core.c.a.a a(Cursor cursor) {
        com.anythink.core.c.a.a aVar = new com.anythink.core.c.a.a();
        int i = cursor.getInt(cursor.getColumnIndexOrThrow("type"));
        String string = cursor.getString(cursor.getColumnIndexOrThrow("placement_id"));
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow("request_id"));
        int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("network_firm_id"));
        String string3 = cursor.getString(cursor.getColumnIndexOrThrow("ad_source_id"));
        String string4 = cursor.getString(cursor.getColumnIndexOrThrow("dsp_id"));
        double d = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
        long j = cursor.getLong(cursor.getColumnIndexOrThrow(a.i));
        String string5 = cursor.getString(cursor.getColumnIndexOrThrow("ps_id"));
        int i3 = cursor.getInt(cursor.getColumnIndexOrThrow("segment_id"));
        aVar.c(i);
        aVar.e(string);
        aVar.a(string2);
        aVar.b(i2);
        aVar.b(string3);
        aVar.c(string4);
        aVar.a(d);
        aVar.a(j);
        aVar.d(string5);
        aVar.a(i3);
        return aVar;
    }

    public final synchronized void a(String str) {
        try {
            Object[] objArr = new Object[2];
            Integer.valueOf(d().delete(a.a, "placement_id = ?", new String[]{str}));
        } catch (Exception e) {
            Object[] objArr2 = new Object[2];
            e.getMessage();
            Thread.currentThread().getName();
        }
    }

    public final synchronized double[] a(String[] strArr, String str) {
        double[] dArr;
        dArr = new double[2];
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = c().query(str, strArr, null, null, null, null, null, null);
                if (cursorQuery.moveToNext()) {
                    dArr[0] = cursorQuery.getDouble(0);
                    dArr[1] = cursorQuery.getInt(1);
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e) {
                Object[] objArr = new Object[2];
                e.getMessage();
                Thread.currentThread().getName();
                if (cursorQuery != null) {
                }
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        return dArr;
    }
}
