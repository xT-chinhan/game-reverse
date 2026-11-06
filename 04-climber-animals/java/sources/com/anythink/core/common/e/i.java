package com.anythink.core.common.e;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i extends c<com.anythink.core.common.a.l> {
    private static volatile i c;
    private final String a;
    private final long b;

    public static class a {
        public static final String a = "dsp_offer_show_record";
        public static final String b = "dsp_id";
        public static final String c = "dsp_offer_id";
        public static final String d = "show_limit";
        public static final String e = "show_count";
        public static final String f = "create_time";
        public static final String g = "last_update_time";
        public static final String h = "CREATE TABLE IF NOT EXISTS dsp_offer_show_record(dsp_id TEXT ,dsp_offer_id TEXT ,show_limit INTEGER ,show_count INTEGER ,create_time INTEGER ,last_update_time INTEGER)";
    }

    private i(d dVar) {
        super(dVar);
        this.a = i.class.getName();
        this.b = 86400000L;
    }

    public static i a(d dVar) {
        if (c == null) {
            synchronized (i.class) {
                if (c == null) {
                    c = new i(dVar);
                }
            }
        }
        return c;
    }

    public final synchronized long a(com.anythink.core.common.a.l lVar) {
        if (d() == null) {
            return -1L;
        }
        if (lVar.c() <= 0) {
            return -1L;
        }
        try {
            if (a(lVar.a(), lVar.b()) == null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("dsp_id", lVar.a());
                contentValues.put("dsp_offer_id", lVar.b());
                contentValues.put(a.d, Integer.valueOf(lVar.c()));
                contentValues.put("show_count", (Integer) 0);
                contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("last_update_time", Long.valueOf(System.currentTimeMillis()));
                lVar.a();
                lVar.b();
                return d().insert(a.a, null, contentValues);
            }
            lVar.a();
            lVar.b();
            return -1L;
        } catch (Exception unused) {
        }
    }

    public final synchronized long b(com.anythink.core.common.a.l lVar) {
        if (d() == null) {
            return -1L;
        }
        if (lVar.c() <= 0) {
            return -1L;
        }
        com.anythink.core.common.a.l lVarA = a(lVar.a(), lVar.b());
        if (lVarA != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("dsp_id", lVar.a());
                contentValues.put("dsp_offer_id", lVar.b());
                contentValues.put(a.d, Integer.valueOf(lVar.c()));
                contentValues.put("show_count", Integer.valueOf(lVarA.d() + 1));
                contentValues.put("last_update_time", Long.valueOf(System.currentTimeMillis()));
                lVar.a();
                lVar.b();
                lVarA.d();
                lVar.c();
                return d().update(a.a, contentValues, "dsp_id = ? and dsp_offer_id = ? ", new String[]{lVar.a(), lVar.b()});
            } catch (Exception unused) {
            }
        }
        return -1L;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003b A[Catch: all -> 0x0051, PHI: r11
      0x003b: PHI (r11v8 android.database.Cursor) = 
      (r11v5 android.database.Cursor)
      (r11v6 android.database.Cursor)
      (r11v7 android.database.Cursor)
      (r11v10 android.database.Cursor)
     binds: [B:15:0x0039, B:20:0x0043, B:27:0x004e, B:12:0x0035] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:9:0x0030, B:16:0x003b, B:24:0x0049, B:25:0x004c, B:19:0x0040), top: B:37:0x0002, inners: #3 }] */
    private synchronized com.anythink.core.common.a.l a(String str, String str2) {
        Cursor cursorQuery;
        try {
            cursorQuery = c().query(a.a, null, "dsp_id = ?  AND dsp_offer_id = ? ", new String[]{str, str2}, null, null, null);
            try {
                List<com.anythink.core.common.a.l> listA = a(cursorQuery);
                cursorQuery.close();
                if (listA.size() > 0) {
                    com.anythink.core.common.a.l lVar = listA.get(0);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return lVar;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
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
        } catch (Exception unused4) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused5) {
            cursorQuery = null;
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
        return null;
    }

    private synchronized List<com.anythink.core.common.a.l> a(Cursor cursor) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                try {
                    com.anythink.core.common.a.l lVar = new com.anythink.core.common.a.l();
                    lVar.a(cursor.getString(cursor.getColumnIndex("dsp_id")));
                    lVar.b(cursor.getString(cursor.getColumnIndex("dsp_offer_id")));
                    lVar.a(cursor.getInt(cursor.getColumnIndex(a.d)));
                    lVar.b(cursor.getInt(cursor.getColumnIndex("show_count")));
                    arrayList.add(lVar);
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    public final synchronized List<com.anythink.core.common.a.j> a(int i) {
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = c().query(a.a, null, "show_count > show_limit", null, null, null, "last_update_time DESC", String.valueOf(i));
                List<com.anythink.core.common.a.l> listA = a(cursorQuery);
                listA.size();
                cursorQuery.close();
                arrayList.addAll(listA);
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
        return arrayList;
    }

    public final void a() {
        try {
            String str = "create_time < " + (System.currentTimeMillis() - 86400000);
            if (d() == null) {
                return;
            }
            d().delete(a.a, str, null);
        } catch (Exception unused) {
        }
    }
}
