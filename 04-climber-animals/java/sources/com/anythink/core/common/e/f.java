package com.anythink.core.common.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.h.bs;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f extends c<bs> {
    private static final String a = "com.anythink.core.common.e.f";
    private static volatile f b;

    public static class a {
        public static final String a = "sdkconfig";
        public static final String b = "key";
        public static final String c = "type";
        public static final String d = "value";
        public static final String e = "lastupdatetime";
        public static final String f = "CREATE TABLE IF NOT EXISTS sdkconfig(key TEXT ,type TEXT ,lastupdatetime TEXT ,value TEXT )";
    }

    private f(d dVar) {
        super(dVar);
    }

    public static f a(d dVar) {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new f(dVar);
                }
            }
        }
        return b;
    }

    public final synchronized long a(String str, String str2, String str3) {
        if (d() == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(a.b, str);
            contentValues.put("type", str3);
            contentValues.put(a.d, str2);
            contentValues.put(a.e, new StringBuilder().append(System.currentTimeMillis()).toString());
            if (b(str, str3)) {
                return d().update(a.a, contentValues, "key = ? AND type = ?", new String[]{str, str3});
            }
            return d().insert(a.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    private synchronized long a(bs bsVar) {
        if (d() == null || bsVar == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(a.b, bsVar.b());
            contentValues.put("type", bsVar.c());
            contentValues.put(a.d, bsVar.d());
            contentValues.put(a.e, bsVar.a());
            if (b(bsVar.b(), bsVar.a(), bsVar.c())) {
                return d().update(a.a, contentValues, "key = ? AND type = ? AND lastupdatetime = ?  ", new String[]{bsVar.b(), bsVar.c(), bsVar.a()});
            }
            return d().insert(a.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    private synchronized boolean b(String str, String str2) {
        Cursor cursorQuery = c().query(a.a, new String[]{a.b}, "key=? AND type=?", new String[]{str, str2}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    private synchronized boolean b(String str, String str2, String str3) {
        Cursor cursorQuery = c().query(a.a, new String[]{a.b}, "key=? AND type=? AND lastupdatetime=?", new String[]{str, str3, str2}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    private synchronized void c(String str, String str2) {
        List<bs> listC = c(str, str2, bs.a.a);
        if (listC != null && listC.size() > 0) {
            for (bs bsVar : listC) {
                bsVar.d(new StringBuilder().append(Integer.parseInt(bsVar.d()) + 1).toString());
                a(bsVar);
            }
            return;
        }
        bs bsVar2 = new bs();
        bsVar2.a(str2);
        bsVar2.d("1");
        bsVar2.c(bs.a.a);
        bsVar2.b(str);
        a(bsVar2);
    }

    private synchronized List<bs> a(Cursor cursor) {
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    bs bsVar = new bs();
                    bsVar.b(cursor.getString(cursor.getColumnIndex(a.b)));
                    bsVar.c(cursor.getString(cursor.getColumnIndex("type")));
                    bsVar.d(cursor.getString(cursor.getColumnIndex(a.d)));
                    bsVar.a(cursor.getString(cursor.getColumnIndex(a.e)));
                    arrayList.add(bsVar);
                }
                cursor.close();
                return arrayList;
            }
        }
        return null;
    }

    private synchronized void a(String str) {
        try {
            if (d() == null) {
                return;
            }
            d().delete(a.a, "lastupdatetime< ? and type = ?", new String[]{str, bs.a.a});
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033 A[Catch: all -> 0x0042, PHI: r10
      0x0033: PHI (r10v7 android.database.Cursor) = (r10v5 android.database.Cursor), (r10v6 android.database.Cursor), (r10v8 android.database.Cursor) binds: [B:11:0x002a, B:15:0x0031, B:22:0x003f] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #1 {, blocks: (B:7:0x0024, B:16:0x0033, B:19:0x003a, B:20:0x003d, B:14:0x002e), top: B:32:0x0002, inners: #3 }] */
    private synchronized List<bs> c(String str, String str2, String str3) {
        Cursor cursorQuery;
        try {
            cursorQuery = c().query(a.a, null, "key = ? and type = ? and lastupdatetime = ?", new String[]{str, str3, str2}, null, null, null);
            try {
                List<bs> listA = a(cursorQuery);
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

    /* JADX WARN: Code duplicated, block: B:16:0x0030 A[Catch: all -> 0x003f, PHI: r10
      0x0030: PHI (r10v7 android.database.Cursor) = (r10v5 android.database.Cursor), (r10v6 android.database.Cursor), (r10v8 android.database.Cursor) binds: [B:11:0x0027, B:15:0x002e, B:22:0x003c] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #7 {, blocks: (B:7:0x0021, B:16:0x0030, B:19:0x0037, B:20:0x003a, B:14:0x002b), top: B:34:0x0002, inners: #0 }] */
    public final synchronized List<bs> a(String str, String str2) {
        Cursor cursorQuery;
        try {
            cursorQuery = c().query(a.a, null, "key = ? and type = ?", new String[]{str, str2}, null, null, null);
            try {
                List<bs> listA = a(cursorQuery);
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

    /* JADX WARN: Code duplicated, block: B:16:0x0030 A[Catch: all -> 0x003f, PHI: r10
      0x0030: PHI (r10v7 android.database.Cursor) = (r10v5 android.database.Cursor), (r10v6 android.database.Cursor), (r10v8 android.database.Cursor) binds: [B:11:0x0027, B:15:0x002e, B:22:0x003c] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #7 {, blocks: (B:7:0x0021, B:16:0x0030, B:19:0x0037, B:20:0x003a, B:14:0x002b), top: B:34:0x0002, inners: #0 }] */
    private synchronized List<bs> d(String str, String str2) {
        Cursor cursorQuery;
        try {
            cursorQuery = c().query(a.a, null, "key != ? and type = ?", new String[]{str, str2}, null, null, null);
            try {
                List<bs> listA = a(cursorQuery);
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

    /* JADX WARN: Code duplicated, block: B:16:0x002d A[Catch: all -> 0x003c, PHI: r10
      0x002d: PHI (r10v7 android.database.Cursor) = (r10v5 android.database.Cursor), (r10v6 android.database.Cursor), (r10v8 android.database.Cursor) binds: [B:11:0x0024, B:15:0x002b, B:22:0x0039] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #7 {, blocks: (B:7:0x001e, B:16:0x002d, B:19:0x0034, B:20:0x0037, B:14:0x0028), top: B:34:0x0002, inners: #0 }] */
    private synchronized List<bs> b(String str) {
        Cursor cursorQuery;
        try {
            cursorQuery = c().query(a.a, null, "type = ?", new String[]{str}, null, null, null);
            try {
                List<bs> listA = a(cursorQuery);
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
}
