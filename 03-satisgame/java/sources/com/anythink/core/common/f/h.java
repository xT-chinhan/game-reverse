package com.anythink.core.common.f;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.h.bf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class h extends com.anythink.core.common.f.b<h> {
    private static final String a = "com.anythink.core.common.f.h";
    private static h b;

    public static class a {
        public List<bf> a;
        public Map<String, bf> b;
    }

    public static class b {
        public static final String a = "notice_url_fail_info";
        public static final String b = "id";
        public static final String c = "req_type";
        public static final String d = "req_url";
        public static final String e = "req_head";
        public static final String f = "first_fail_time";
        public static final String g = "offer_out_date_time";
        public static final String h = "retry_count";
        public static final String i = "CREATE TABLE IF NOT EXISTS notice_url_fail_info(id TEXT, req_type INTEGER, req_url TEXT, req_head TEXT, first_fail_time INTEGER, offer_out_date_time INTEGER, retry_count INTEGER )";
    }

    private h(c cVar) {
        super(cVar);
    }

    public static h a(c cVar) {
        if (b == null) {
            synchronized (h.class) {
                if (b == null) {
                    b = new h(cVar);
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
            b().delete(b.a, null, null);
        } catch (Exception unused) {
        }
    }

    public final synchronized long a(bf bfVar) {
        if (b() == null || bfVar == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", bfVar.a);
            contentValues.put(b.c, Integer.valueOf(bfVar.b));
            contentValues.put(b.d, bfVar.d);
            contentValues.put(b.e, bfVar.c);
            contentValues.put(b.f, Long.valueOf(bfVar.e));
            contentValues.put(b.g, Long.valueOf(bfVar.f));
            contentValues.put(b.h, Integer.valueOf(bfVar.g));
            if (a(bfVar.a)) {
                return b().update(b.a, contentValues, "id = ? ", new String[]{bfVar.a});
            }
            return b().insert(b.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033 A[PHI: r11
      0x0033: PHI (r11v3 android.database.Cursor) = (r11v2 android.database.Cursor), (r11v4 android.database.Cursor) binds: [B:14:0x0031, B:11:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    private boolean a(String str) {
        Cursor cursorQuery;
        try {
            cursorQuery = a().query(b.a, new String[]{"id"}, "id=?", new String[]{str}, "id", null, null);
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
    }

    public final synchronized int b(bf bfVar) {
        if (b() == null || bfVar == null) {
            return -1;
        }
        try {
            return b().delete(b.a, "id=?", new String[]{bfVar.a});
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final synchronized a c() {
        a aVar = new a();
        List<bf> listSynchronizedList = Collections.synchronizedList(new ArrayList(8));
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(8);
        aVar.a = listSynchronizedList;
        aVar.b = concurrentHashMap;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = a().query(b.a, null, null, null, null, null, b.f);
                if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                    if (cursorQuery != null) {
                    }
                    return aVar;
                }
                ArrayList arrayList = new ArrayList(4);
                while (cursorQuery.moveToNext()) {
                    bf bfVar = new bf();
                    bfVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    bfVar.b = cursorQuery.getInt(cursorQuery.getColumnIndex(b.c));
                    bfVar.d = cursorQuery.getString(cursorQuery.getColumnIndex(b.d));
                    bfVar.c = cursorQuery.getString(cursorQuery.getColumnIndex(b.e));
                    bfVar.e = cursorQuery.getLong(cursorQuery.getColumnIndex(b.f));
                    bfVar.f = cursorQuery.getLong(cursorQuery.getColumnIndex(b.g));
                    bfVar.g = cursorQuery.getInt(cursorQuery.getColumnIndex(b.h));
                    if (System.currentTimeMillis() < bfVar.f) {
                        listSynchronizedList.add(bfVar);
                        concurrentHashMap.put(bfVar.a, bfVar);
                    } else {
                        arrayList.add(bfVar);
                    }
                }
                cursorQuery.close();
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        b((bf) it.next());
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return aVar;
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
        cursorQuery.close();
        return aVar;
    }
}
