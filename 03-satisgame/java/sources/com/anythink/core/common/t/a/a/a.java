package com.anythink.core.common.t.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import com.anythink.core.common.f.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.anythink.core.common.f.b<com.anythink.core.common.t.a.b.a.a.a> {
    private static final String a = "com.anythink.core.common.t.a.a.a";
    private static a b = null;
    private static final int d = 1000;
    private int c;

    /* JADX INFO: renamed from: com.anythink.core.common.t.a.a.a$a, reason: collision with other inner class name */
    public static class C0049a {
        public static final String a = "agent_request_info";
        public static final String b = "id";
        public static final String c = "req_content";
        public static final String d = "is_read";
        public static final String e = "create_time";
        public static final String f = "CREATE TABLE IF NOT EXISTS agent_request_info(id TEXT, req_content TEXT, is_read INTEGER DEFAULT 0,create_time INTEGER DEFAULT 0)";
    }

    private a(c cVar) {
        super(cVar);
        this.c = 10000;
        e();
    }

    public static a a(c cVar) {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a(cVar);
                }
            }
        }
        return b;
    }

    private synchronized void d() {
        try {
            if (b() == null) {
                return;
            }
            b().delete(C0049a.a, null, null);
        } catch (Exception unused) {
        }
    }

    private synchronized int e() {
        if (b() == null) {
            return -1;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 0);
            return b().update(C0049a.a, contentValues, null, null);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final synchronized long a(com.anythink.core.common.t.a.b.a.a.a aVar) {
        if (b() == null) {
            return -1L;
        }
        try {
            if (DatabaseUtils.queryNumEntries(a(), C0049a.a) >= this.c) {
                f();
            }
        } catch (Throwable unused) {
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", aVar.a);
            contentValues.put("req_content", aVar.e);
            contentValues.put("is_read", (Integer) 0);
            contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
            return b().insert(C0049a.a, null, contentValues);
        } catch (Exception unused2) {
            return -1L;
        }
    }

    public final synchronized long c() {
        if (a() == null) {
            return 0L;
        }
        try {
            return DatabaseUtils.queryNumEntries(a(), C0049a.a, "is_read=?", new String[]{"0"});
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private synchronized void f() {
        if (b() == null) {
            return;
        }
        try {
            b().execSQL("DELETE FROM agent_request_info WHERE id IN (SELECT id FROM agent_request_info ORDER BY create_time ASC LIMIT 1000)");
        } catch (Throwable unused) {
        }
    }

    private synchronized boolean a(String str) {
        if (b() == null || str == null) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 1);
            return b().update(C0049a.a, contentValues, "id=?", new String[]{str}) > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private synchronized int b(com.anythink.core.common.t.a.b.a.a.a aVar) {
        if (b() == null || aVar == null) {
            return -1;
        }
        try {
            return b().delete(C0049a.a, "id=?", new String[]{aVar.a});
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final synchronized int a(List<com.anythink.core.common.t.a.b.a.a.a> list) {
        if (b() == null || list == null || list.isEmpty()) {
            return -1;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append("?");
                strArr[i] = list.get(i).a;
            }
            return b().delete(C0049a.a, "id IN (" + sb.toString() + ")", strArr);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private synchronized List<com.anythink.core.common.t.a.b.a.a.a> a(long j) {
        return a(j, false);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00e0 A[Catch: all -> 0x00ef, PHI: r11
      0x00e0: PHI (r11v7 android.database.Cursor) = (r11v5 android.database.Cursor), (r11v6 android.database.Cursor), (r11v8 android.database.Cursor) binds: [B:31:0x00d7, B:35:0x00de, B:42:0x00ec] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #7 {, blocks: (B:27:0x00d1, B:36:0x00e0, B:39:0x00e7, B:40:0x00ea, B:34:0x00db), top: B:54:0x0002, inners: #0 }] */
    public final synchronized List<com.anythink.core.common.t.a.b.a.a.a> a(long j, boolean z) {
        Cursor cursorQuery;
        ArrayList arrayList = null;
        try {
            cursorQuery = a().query(C0049a.a, null, "is_read=?", new String[]{"0"}, null, null, "create_time" + (z ? " DESC" : " ASC"), String.valueOf(j));
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            com.anythink.core.common.t.a.b.a.a.a aVar = new com.anythink.core.common.t.a.b.a.a.a();
                            aVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                            aVar.e = cursorQuery.getString(cursorQuery.getColumnIndex("req_content"));
                            arrayList2.add(aVar);
                            arrayList3.add(aVar.a);
                        }
                        if (!arrayList3.isEmpty()) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_read", (Integer) 1);
                            StringBuilder sb = new StringBuilder();
                            for (int i = 0; i < arrayList3.size(); i++) {
                                if (i > 0) {
                                    sb.append(",");
                                }
                                sb.append("?");
                            }
                            b().update(C0049a.a, contentValues, "id IN (" + sb.toString() + ")", (String[]) arrayList3.toArray(new String[0]));
                        }
                        arrayList = arrayList2;
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
            return arrayList;
        } catch (Exception unused4) {
            cursorQuery = null;
        } catch (OutOfMemoryError unused5) {
            cursorQuery = null;
        } catch (Throwable unused6) {
            cursorQuery = null;
        }
    }

    public final synchronized int b(List<com.anythink.core.common.t.a.b.a.a.a> list) {
        if (b() == null || list == null || list.isEmpty()) {
            return -1;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append("?");
                strArr[i] = list.get(i).a;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", (Integer) 0);
            return b().update(C0049a.a, contentValues, "id IN (" + sb.toString() + ")", strArr);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
