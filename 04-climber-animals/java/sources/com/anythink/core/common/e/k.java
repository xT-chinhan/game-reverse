package com.anythink.core.common.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.h.aq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k extends c<aq> {
    private static final String a = "com.anythink.core.common.e.k";
    private static k b;
    private int c;

    public static class a {
        public static final String a = "request_info";
        public static final String b = "id";
        public static final String c = "req_type";
        public static final String d = "req_url";
        public static final String e = "req_head";
        public static final String f = "req_content";
        public static final String g = "time";
        public static final String h = "extra";
        public static final String i = "CREATE TABLE IF NOT EXISTS request_info(id TEXT, req_type INTEGER, req_url TEXT, req_head TEXT, req_content TEXT, time INTEGER, extra TEXT )";
    }

    private k(d dVar) {
        super(dVar);
        this.c = 1000;
    }

    public static k a(d dVar) {
        if (b == null) {
            synchronized (k.class) {
                if (b == null) {
                    b = new k(dVar);
                }
            }
        }
        return b;
    }

    private synchronized void b() {
        try {
            if (d() == null) {
                return;
            }
            d().delete(a.a, null, null);
        } catch (Exception unused) {
        }
    }

    public final synchronized long a(aq aqVar) {
        Cursor cursorQuery;
        if (d() == null) {
            return -1L;
        }
        Cursor cursor = null;
        try {
            try {
                cursorQuery = c().query(a.a, null, null, null, null, null, null);
                try {
                    if (cursorQuery.getCount() >= this.c) {
                        b();
                    }
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                    if (cursorQuery != null) {
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", aqVar.a);
                    contentValues.put("req_type", Integer.valueOf(aqVar.b));
                    contentValues.put("req_url", aqVar.d);
                    contentValues.put("req_head", aqVar.c);
                    contentValues.put(a.f, aqVar.e);
                    contentValues.put("time", Long.valueOf(aqVar.f));
                    contentValues.put("extra", aqVar.g);
                    return d().insert(a.a, null, contentValues);
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused4) {
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("id", aqVar.a);
            contentValues2.put("req_type", Integer.valueOf(aqVar.b));
            contentValues2.put("req_url", aqVar.d);
            contentValues2.put("req_head", aqVar.c);
            contentValues2.put(a.f, aqVar.e);
            contentValues2.put("time", Long.valueOf(aqVar.f));
            contentValues2.put("extra", aqVar.g);
            return d().insert(a.a, null, contentValues2);
        } catch (Exception unused5) {
            return -1L;
        }
    }

    public final synchronized int b(aq aqVar) {
        if (d() == null || aqVar == null) {
            return -1;
        }
        try {
            return d().delete(a.a, "id=?", new String[]{aqVar.a});
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00a0 A[Catch: all -> 0x00af, PHI: r1
      0x00a0: PHI (r1v5 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v4 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:22:0x0097, B:26:0x009e, B:33:0x00ac] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #7 {, blocks: (B:14:0x008a, B:18:0x0091, B:27:0x00a0, B:30:0x00a7, B:31:0x00aa, B:25:0x009b), top: B:45:0x0002, inners: #0 }] */
    public final synchronized List<aq> a() {
        Cursor cursorQuery;
        try {
            cursorQuery = c().query(a.a, null, null, null, null, null, "time", "10");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        ArrayList arrayList = new ArrayList();
                        while (cursorQuery.moveToNext()) {
                            aq aqVar = new aq();
                            aqVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                            aqVar.b = cursorQuery.getInt(cursorQuery.getColumnIndex("req_type"));
                            aqVar.d = cursorQuery.getString(cursorQuery.getColumnIndex("req_url"));
                            aqVar.c = cursorQuery.getString(cursorQuery.getColumnIndex("req_head"));
                            aqVar.e = cursorQuery.getString(cursorQuery.getColumnIndex(a.f));
                            aqVar.f = cursorQuery.getLong(cursorQuery.getColumnIndex("time"));
                            aqVar.g = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                            arrayList.add(aqVar);
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
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Exception unused4) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused5) {
            cursorQuery = null;
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
    }
}
