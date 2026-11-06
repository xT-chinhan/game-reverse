package com.anythink.core.common.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.h.at;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l extends c<at> {
    private static final String a = "com.anythink.core.common.e.l";
    private static volatile l b;
    private int c;
    private int d;

    public static class a {
        public static final String a = "inspect_info";
        public static final String b = "inspect_id";
        public static final String c = "update_time";
        public static final String d = "inspect_result";
        public static final String e = "pgk_name";
        public static final String f = "CREATE TABLE IF NOT EXISTS inspect_info(inspect_id TEXT, inspect_result INTEGER, pgk_name TEXT, update_time INTEGER )";
        public static final String g = "CREATE TABLE IF NOT EXISTS inspect_info(inspect_id TEXT, update_time INTEGER )";
        public static final String h = "ALTER TABLE inspect_info ADD COLUMN inspect_result INTEGER DEFAULT 1";
        public static final String i = "ALTER TABLE inspect_info DROP COLUMN pgk_name";
    }

    private l(d dVar) {
        super(dVar);
        this.c = 500;
        this.d = -1627869184;
    }

    public static l a(d dVar) {
        if (b == null) {
            synchronized (l.class) {
                if (b == null) {
                    b = new l(dVar);
                }
            }
        }
        return b;
    }

    public final synchronized long a(String str, boolean z) {
        if (d() == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(a.b, str);
            contentValues.put(a.d, Integer.valueOf(z ? 1 : 2));
            contentValues.put("update_time", Long.valueOf(System.currentTimeMillis()));
            if (a(str)) {
                return d().update(a.a, contentValues, "inspect_id = ? ", new String[]{str});
            }
            return d().insert(a.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0038 A[Catch: all -> 0x003c, PHI: r11
      0x0038: PHI (r11v4 android.database.Cursor) = (r11v3 android.database.Cursor), (r11v5 android.database.Cursor) binds: [B:19:0x0036, B:16:0x0032] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x003c, blocks: (B:13:0x002d, B:20:0x0038), top: B:32:0x0002 }] */
    private synchronized boolean a(String str) {
        Cursor cursorQuery;
        try {
            if (str == null) {
                return false;
            }
            try {
                cursorQuery = c().query(a.a, new String[]{a.b}, "inspect_id=?", new String[]{str}, null, null, null);
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
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void b(String str) {
        try {
            d().delete(a.a, "inspect_id = ? ", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public final synchronized void a() {
        Cursor cursorQuery = null;
        long j = -1;
        try {
            try {
                cursorQuery = c().query(a.a, null, null, null, null, null, "update_time DESC", String.valueOf(this.c));
                if (cursorQuery != null && cursorQuery.getCount() >= this.c) {
                    cursorQuery.moveToLast();
                    j = cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"));
                    cursorQuery.close();
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Exception unused) {
            if (cursorQuery != null) {
            }
        } catch (OutOfMemoryError unused2) {
            System.gc();
            if (cursorQuery != null) {
            }
        } catch (Throwable unused3) {
            if (cursorQuery != null) {
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - ((long) this.d);
        if (j == 0 || j > jCurrentTimeMillis) {
            j = jCurrentTimeMillis;
        }
        if (j > 0) {
            try {
                d().delete(a.a, "update_time<?", new String[]{String.valueOf(j)});
            } catch (Throwable unused4) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006d A[Catch: all -> 0x0083, PHI: r1
      0x006d: PHI (r1v6 android.database.Cursor) = 
      (r1v3 android.database.Cursor)
      (r1v4 android.database.Cursor)
      (r1v5 android.database.Cursor)
      (r1v8 android.database.Cursor)
     binds: [B:24:0x006b, B:29:0x0075, B:36:0x0080, B:21:0x0067] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #3 {, blocks: (B:18:0x0062, B:25:0x006d, B:33:0x007b, B:34:0x007e, B:28:0x0072), top: B:49:0x0002, inners: #4 }] */
    public final synchronized List<at> b() {
        Cursor cursorQuery;
        try {
            cursorQuery = c().query(a.a, null, null, null, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        ArrayList arrayList = new ArrayList();
                        while (cursorQuery.moveToNext()) {
                            try {
                                at atVar = new at();
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex(a.b));
                                if (!TextUtils.isEmpty(string)) {
                                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex(a.d));
                                    long j = cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"));
                                    atVar.a(string);
                                    atVar.a(i);
                                    atVar.a(j);
                                    arrayList.add(atVar);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        cursorQuery.close();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return arrayList;
                    }
                } catch (Exception unused2) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (OutOfMemoryError unused3) {
                    try {
                        System.gc();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } catch (Throwable th) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                } catch (Throwable unused4) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception unused5) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused6) {
            cursorQuery = null;
        } catch (Throwable unused7) {
            cursorQuery = null;
        }
        return null;
    }
}
