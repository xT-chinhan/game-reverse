package com.anythink.basead.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static a a;
    private Context b;

    /* JADX INFO: renamed from: com.anythink.basead.c.a$a, reason: collision with other inner class name */
    public static class C0014a {
        public static final String a = "my_offer_cap_pacing";
        public static final String b = "offer_id";
        public static final String c = "offer_cap";
        public static final String d = "offer_pacing";
        public static final String e = "show_num";
        public static final String f = "show_time";
        public static final String g = "record_date";
        public static final String h = "CREATE TABLE IF NOT EXISTS my_offer_cap_pacing (offer_id TEXT,offer_cap INTEGER,offer_pacing INTEGER,show_num INTEGER,show_time INTEGER,record_date INTEGER )";
    }

    private a(Context context) {
        this.b = context;
    }

    public static a a(Context context) {
        if (a == null) {
            a = new a(context);
        }
        return a;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003d A[Catch: all -> 0x0053, PHI: r11
      0x003d: PHI (r11v8 android.database.Cursor) = 
      (r11v5 android.database.Cursor)
      (r11v6 android.database.Cursor)
      (r11v7 android.database.Cursor)
      (r11v9 android.database.Cursor)
     binds: [B:16:0x003b, B:21:0x0045, B:28:0x0050, B:13:0x0037] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:10:0x0032, B:17:0x003d, B:25:0x004b, B:26:0x004e, B:20:0x0042), top: B:38:0x0002, inners: #3 }] */
    public final synchronized com.anythink.basead.d.c a(String str) {
        Cursor cursorQuery;
        try {
            cursorQuery = c.a(this.b).getReadableDatabase().query(C0014a.a, null, "offer_id = ?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToNext();
                        com.anythink.basead.d.c cVarA = a(cursorQuery);
                        cursorQuery.close();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return cVarA;
                    }
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (OutOfMemoryError unused2) {
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
                } catch (Throwable unused3) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception unused4) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused5) {
            cursorQuery = null;
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004e A[Catch: all -> 0x0064, PHI: r11
      0x004e: PHI (r11v8 android.database.Cursor) = 
      (r11v5 android.database.Cursor)
      (r11v6 android.database.Cursor)
      (r11v7 android.database.Cursor)
      (r11v10 android.database.Cursor)
     binds: [B:20:0x004c, B:25:0x0056, B:32:0x0061, B:17:0x0048] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:14:0x0043, B:21:0x004e, B:29:0x005c, B:30:0x005f, B:24:0x0053), top: B:42:0x0002, inners: #2 }] */
    public final synchronized List<com.anythink.basead.d.c> b(String str) {
        Cursor cursorQuery;
        try {
            cursorQuery = c.a(this.b).getReadableDatabase().query(C0014a.a, null, "offer_cap <= show_num AND record_date = ? AND offer_cap  >= ?", new String[]{str, "0"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        ArrayList arrayList = new ArrayList();
                        while (cursorQuery.moveToNext()) {
                            arrayList.add(a(cursorQuery));
                        }
                        cursorQuery.close();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return arrayList;
                    }
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (OutOfMemoryError unused2) {
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
                } catch (Throwable unused3) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception unused4) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused5) {
            cursorQuery = null;
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
        return null;
    }

    public final synchronized void c(String str) {
        synchronized (this) {
            try {
                String str2 = "record_date != '" + str + "'";
                if (c.a(this.b).getWritableDatabase() == null) {
                } else {
                    c.a(this.b).getWritableDatabase().delete(C0014a.a, str2, null);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final synchronized long a(com.anythink.basead.d.c cVar) {
        synchronized (this) {
            if (cVar == null) {
                return 0L;
            }
            try {
                if (c.a(this.b).getWritableDatabase() == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("offer_id", cVar.a);
                contentValues.put(C0014a.e, Integer.valueOf(cVar.d));
                contentValues.put("show_time", Long.valueOf(cVar.e));
                contentValues.put(C0014a.g, cVar.f);
                contentValues.put(C0014a.c, Integer.valueOf(cVar.b));
                contentValues.put(C0014a.d, Long.valueOf(cVar.c));
                if (d(cVar.a)) {
                    return c.a(this.b).getWritableDatabase().update(C0014a.a, contentValues, "offer_id = '" + cVar.a + "'", null);
                }
                return c.a(this.b).getWritableDatabase().insert(C0014a.a, null, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                return -1L;
            }
        }
    }

    private synchronized boolean d(String str) {
        Cursor cursorQuery = c.a(this.b).getReadableDatabase().query(C0014a.a, new String[]{"offer_id"}, "offer_id = ?", new String[]{str}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }

    private static com.anythink.basead.d.c a(Cursor cursor) {
        com.anythink.basead.d.c cVar = new com.anythink.basead.d.c();
        cVar.a = cursor.getString(cursor.getColumnIndex("offer_id"));
        cVar.d = cursor.getInt(cursor.getColumnIndex(C0014a.e));
        cVar.e = cursor.getLong(cursor.getColumnIndex("show_time"));
        cVar.f = cursor.getString(cursor.getColumnIndex(C0014a.g));
        cVar.b = cursor.getInt(cursor.getColumnIndex(C0014a.c));
        cVar.c = cursor.getLong(cursor.getColumnIndex(C0014a.d));
        return cVar;
    }
}
