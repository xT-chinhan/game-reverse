package com.anythink.core.common.f;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.h.bu;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e extends b<bu> {
    private static final String a = "com.anythink.core.common.f.e";
    private static volatile e b;

    public static class a {
        public static final String a = "sdkconfig";
        public static final String b = "key";
        public static final String c = "type";
        public static final String d = "value";
        public static final String e = "lastupdatetime";
        public static final String f = "CREATE TABLE IF NOT EXISTS sdkconfig(key TEXT ,type TEXT ,lastupdatetime TEXT ,value TEXT )";
    }

    private e(c cVar) {
        super(cVar);
    }

    public static e a(c cVar) {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e(cVar);
                }
            }
        }
        return b;
    }

    public final synchronized long a(String str, String str2, String str3) {
        if (b() == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(a.b, str);
            contentValues.put("type", str3);
            contentValues.put(a.d, str2);
            contentValues.put(a.e, new StringBuilder().append(System.currentTimeMillis()).toString());
            if (b(str, str3)) {
                return b().update("sdkconfig", contentValues, "key = ? AND type = ?", new String[]{str, str3});
            }
            return b().insert("sdkconfig", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    private synchronized long a(bu buVar) {
        if (b() == null || buVar == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(a.b, buVar.b());
            contentValues.put("type", buVar.c());
            contentValues.put(a.d, buVar.d());
            contentValues.put(a.e, buVar.a());
            if (b(buVar.b(), buVar.a(), buVar.c())) {
                return b().update("sdkconfig", contentValues, "key = ? AND type = ? AND lastupdatetime = ?  ", new String[]{buVar.b(), buVar.c(), buVar.a()});
            }
            return b().insert("sdkconfig", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final synchronized int a(String str) {
        if (b() == null) {
            return -1;
        }
        try {
            return b().delete("sdkconfig", "key=?", new String[]{str});
        } catch (Throwable unused) {
            return -1;
        }
    }

    private synchronized boolean b(String str, String str2) {
        Cursor cursorQuery = a().query("sdkconfig", new String[]{a.b}, "key=? AND type=?", new String[]{str, str2}, null, null, null);
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
        Cursor cursorQuery = a().query("sdkconfig", new String[]{a.b}, "key=? AND type=? AND lastupdatetime=?", new String[]{str, str3, str2}, null, null, null);
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
        List<bu> listC = c(str, str2, bu.a.a);
        if (listC != null && listC.size() > 0) {
            for (bu buVar : listC) {
                buVar.d(new StringBuilder().append(Integer.parseInt(buVar.d()) + 1).toString());
                a(buVar);
            }
            return;
        }
        bu buVar2 = new bu();
        buVar2.a(str2);
        buVar2.d("1");
        buVar2.c(bu.a.a);
        buVar2.b(str);
        a(buVar2);
    }

    private synchronized List<bu> a(Cursor cursor) {
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    bu buVar = new bu();
                    buVar.b(cursor.getString(cursor.getColumnIndex(a.b)));
                    buVar.c(cursor.getString(cursor.getColumnIndex("type")));
                    buVar.d(cursor.getString(cursor.getColumnIndex(a.d)));
                    buVar.a(cursor.getString(cursor.getColumnIndex(a.e)));
                    arrayList.add(buVar);
                }
                cursor.close();
                return arrayList;
            }
        }
        return null;
    }

    private synchronized void b(String str) {
        try {
            if (b() == null) {
                return;
            }
            b().delete("sdkconfig", "lastupdatetime< ? and type = ?", new String[]{str, bu.a.a});
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033 A[Catch: all -> 0x0042, PHI: r10
      0x0033: PHI (r10v7 android.database.Cursor) = (r10v5 android.database.Cursor), (r10v6 android.database.Cursor), (r10v8 android.database.Cursor) binds: [B:11:0x002a, B:15:0x0031, B:22:0x003f] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #1 {, blocks: (B:7:0x0024, B:16:0x0033, B:19:0x003a, B:20:0x003d, B:14:0x002e), top: B:32:0x0002, inners: #3 }] */
    private synchronized List<bu> c(String str, String str2, String str3) {
        Cursor cursorQuery;
        try {
            cursorQuery = a().query("sdkconfig", null, "key = ? and type = ? and lastupdatetime = ?", new String[]{str, str3, str2}, null, null, null);
            try {
                List<bu> listA = a(cursorQuery);
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
    public final synchronized List<bu> a(String str, String str2) {
        Cursor cursorQuery;
        try {
            cursorQuery = a().query("sdkconfig", null, "key = ? and type = ?", new String[]{str, str2}, null, null, null);
            try {
                List<bu> listA = a(cursorQuery);
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
    private synchronized List<bu> d(String str, String str2) {
        Cursor cursorQuery;
        try {
            cursorQuery = a().query("sdkconfig", null, "key != ? and type = ?", new String[]{str, str2}, null, null, null);
            try {
                List<bu> listA = a(cursorQuery);
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
    private synchronized List<bu> c(String str) {
        Cursor cursorQuery;
        try {
            cursorQuery = a().query("sdkconfig", null, "type = ?", new String[]{str}, null, null, null);
            try {
                List<bu> listA = a(cursorQuery);
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
