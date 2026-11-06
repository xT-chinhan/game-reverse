package com.anythink.core.common.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.h.bo;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class p extends c<bo> {
    private static volatile p b;
    private final String a;

    public static class a {
        public static final String a = "placement_ad_impression";
        public static final String b = "format";
        public static final String c = "placement_id";
        public static final String d = "adsource_id";
        public static final String e = "hour_time";
        public static final String f = "hour_imp";
        public static final String g = "date_time";
        public static final String h = "date_imp";
        public static final String i = "show_time";
        public static final String j = "CREATE TABLE IF NOT EXISTS placement_ad_impression(format INTEGER ,placement_id TEXT ,adsource_id TEXT ,hour_time TEXT ,hour_imp INTEGER ,date_time TEXT ,date_imp INTEGER , show_time INTEGER)";
    }

    private p(d dVar) {
        super(dVar);
        this.a = p.class.getName();
    }

    public static p a(d dVar) {
        if (b == null) {
            synchronized (p.class) {
                if (b == null) {
                    b = new p(dVar);
                }
            }
        }
        return b;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x007d A[Catch: all -> 0x009d, OutOfMemoryError -> 0x00a0, Exception -> 0x00ae, TryCatch #6 {Exception -> 0x00ae, OutOfMemoryError -> 0x00a0, all -> 0x009d, blocks: (B:30:0x005c, B:32:0x007d, B:34:0x0083, B:36:0x008e, B:38:0x0094), top: B:62:0x005c }] */
    /* JADX WARN: Code duplicated, block: B:36:0x008e A[Catch: all -> 0x009d, OutOfMemoryError -> 0x00a0, Exception -> 0x00ae, TryCatch #6 {Exception -> 0x00ae, OutOfMemoryError -> 0x00a0, all -> 0x009d, blocks: (B:30:0x005c, B:32:0x007d, B:34:0x0083, B:36:0x008e, B:38:0x0094), top: B:62:0x005c }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0099 A[Catch: all -> 0x00b3, PHI: r4
      0x0099: PHI (r4v10 android.database.Cursor) = 
      (r4v7 android.database.Cursor)
      (r4v8 android.database.Cursor)
      (r4v9 android.database.Cursor)
      (r4v11 android.database.Cursor)
     binds: [B:42:0x009d, B:45:0x00a3, B:52:0x00ae, B:39:0x0097] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0002, B:16:0x0044, B:40:0x0099, B:50:0x00aa, B:51:0x00ad, B:26:0x0055, B:27:0x0058, B:20:0x004b, B:44:0x00a0), top: B:59:0x0002, inners: #0, #3 }] */
    public final synchronized int[] a(int i, String str, String str2) {
        int[] iArr;
        iArr = new int[2];
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = c().query(a.a, new String[]{"sum(date_imp)"}, "format=? AND date_time=?", new String[]{String.valueOf(i), str}, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    cursorQuery.moveToNext();
                    iArr[0] = cursorQuery.getInt(0);
                }
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    cursorQuery.close();
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                    throw th;
                }
                throw th;
            }
        } catch (Exception unused) {
            if (cursorQuery != null) {
            }
            try {
                cursorQuery = c().query(a.a, new String[]{"sum(hour_imp)"}, "format=? AND hour_time=?", new String[]{String.valueOf(i), str2}, null, null, null);
                if (cursorQuery != null) {
                    cursorQuery.moveToNext();
                    iArr[1] = cursorQuery.getInt(0);
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return iArr;
            } catch (Throwable th2) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                    throw th2;
                }
                throw th2;
            }
        } catch (OutOfMemoryError unused2) {
            System.gc();
            if (cursorQuery != null) {
            }
            cursorQuery = c().query(a.a, new String[]{"sum(hour_imp)"}, "format=? AND hour_time=?", new String[]{String.valueOf(i), str2}, null, null, null);
            if (cursorQuery != null) {
                cursorQuery.moveToNext();
                iArr[1] = cursorQuery.getInt(0);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return iArr;
        } catch (Throwable unused3) {
            if (cursorQuery != null) {
            }
            cursorQuery = c().query(a.a, new String[]{"sum(hour_imp)"}, "format=? AND hour_time=?", new String[]{String.valueOf(i), str2}, null, null, null);
            if (cursorQuery != null) {
                cursorQuery.moveToNext();
                iArr[1] = cursorQuery.getInt(0);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return iArr;
        }
        try {
            cursorQuery = c().query(a.a, new String[]{"sum(hour_imp)"}, "format=? AND hour_time=?", new String[]{String.valueOf(i), str2}, null, null, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                cursorQuery.moveToNext();
                iArr[1] = cursorQuery.getInt(0);
            }
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                cursorQuery.close();
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception unused4) {
            if (cursorQuery != null) {
            }
        } catch (OutOfMemoryError unused5) {
            System.gc();
            if (cursorQuery != null) {
            }
        } catch (Throwable unused6) {
            if (cursorQuery != null) {
            }
        }
        return iArr;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e8 A[Catch: all -> 0x00f7, PHI: r11
      0x00e8: PHI (r11v7 android.database.Cursor) = (r11v5 android.database.Cursor), (r11v6 android.database.Cursor), (r11v8 android.database.Cursor) binds: [B:30:0x00df, B:34:0x00e6, B:41:0x00f4] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {, blocks: (B:26:0x00d9, B:35:0x00e8, B:38:0x00ef, B:39:0x00f2, B:33:0x00e3), top: B:51:0x0002, inners: #1 }] */
    public final synchronized bo a(String str, String str2, String str3) {
        Cursor cursorQuery;
        bo boVar;
        try {
            cursorQuery = c().query(a.a, null, "placement_id=? AND date_time=?", new String[]{str, str2}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        boVar = new bo();
                        boVar.h = new ConcurrentHashMap<>();
                        while (cursorQuery.moveToNext()) {
                            boVar.a = cursorQuery.getInt(cursorQuery.getColumnIndex("format"));
                            boVar.b = cursorQuery.getString(cursorQuery.getColumnIndex("placement_id"));
                            bo.a aVar = new bo.a();
                            aVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("adsource_id"));
                            aVar.b = cursorQuery.getString(cursorQuery.getColumnIndex(a.e));
                            aVar.c = cursorQuery.getString(cursorQuery.getColumnIndex(a.g));
                            if (!TextUtils.equals(aVar.b, str3)) {
                                aVar.e = 0;
                            } else {
                                aVar.e = cursorQuery.getInt(cursorQuery.getColumnIndex(a.f));
                            }
                            boVar.d += aVar.e;
                            if (!TextUtils.equals(aVar.c, str2)) {
                                aVar.d = 0;
                            } else {
                                aVar.d = cursorQuery.getInt(cursorQuery.getColumnIndex(a.h));
                            }
                            boVar.c += aVar.d;
                            aVar.f = cursorQuery.getLong(cursorQuery.getColumnIndex("show_time"));
                            if (aVar.f >= boVar.e) {
                                boVar.e = aVar.f;
                            }
                            boVar.h.put(aVar.a, aVar);
                        }
                    } else {
                        boVar = null;
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
            } else {
                boVar = null;
            }
            cursorQuery.close();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return boVar;
        } catch (Exception unused4) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused5) {
            cursorQuery = null;
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
    }

    private synchronized long a(int i, String str, bo.a aVar) {
        boolean z;
        if (d() == null || aVar == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("format", Integer.valueOf(i));
            contentValues.put("placement_id", str);
            contentValues.put("adsource_id", aVar.a);
            contentValues.put(a.e, aVar.b);
            contentValues.put(a.f, Integer.valueOf(aVar.e));
            contentValues.put(a.g, aVar.c);
            contentValues.put(a.h, Integer.valueOf(aVar.d));
            contentValues.put("show_time", Long.valueOf(aVar.f));
            Cursor cursorQuery = c().query(a.a, new String[]{"adsource_id"}, "adsource_id=?", new String[]{aVar.a}, "adsource_id", null, null);
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
                return d().update(a.a, contentValues, "adsource_id = ? ", new String[]{aVar.a});
            }
            return d().insert(a.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    private boolean b(String str) {
        Cursor cursorQuery = c().query(a.a, new String[]{"adsource_id"}, "adsource_id=?", new String[]{str}, "adsource_id", null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    private static bo a(Cursor cursor, String str, String str2) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        bo boVar = new bo();
        boVar.h = new ConcurrentHashMap<>();
        while (cursor.moveToNext()) {
            boVar.a = cursor.getInt(cursor.getColumnIndex("format"));
            boVar.b = cursor.getString(cursor.getColumnIndex("placement_id"));
            bo.a aVar = new bo.a();
            aVar.a = cursor.getString(cursor.getColumnIndex("adsource_id"));
            aVar.b = cursor.getString(cursor.getColumnIndex(a.e));
            aVar.c = cursor.getString(cursor.getColumnIndex(a.g));
            if (!TextUtils.equals(aVar.b, str2)) {
                aVar.e = 0;
            } else {
                aVar.e = cursor.getInt(cursor.getColumnIndex(a.f));
            }
            boVar.d += aVar.e;
            if (!TextUtils.equals(aVar.c, str)) {
                aVar.d = 0;
            } else {
                aVar.d = cursor.getInt(cursor.getColumnIndex(a.h));
            }
            boVar.c += aVar.d;
            aVar.f = cursor.getLong(cursor.getColumnIndex("show_time"));
            if (aVar.f >= boVar.e) {
                boVar.e = aVar.f;
            }
            boVar.h.put(aVar.a, aVar);
        }
        return boVar;
    }

    public final void a(String str) {
        synchronized (this) {
            try {
                String str2 = "date_time!='" + str + "'";
                if (d() == null) {
                } else {
                    d().delete(a.a, str2, null);
                }
            } catch (Exception unused) {
            }
        }
    }
}
