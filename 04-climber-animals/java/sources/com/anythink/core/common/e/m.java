package com.anythink.core.common.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.anythink.core.common.h.bd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class m extends c<m> {
    private static final String a = "com.anythink.core.common.e.m";
    private static m b;

    public static class a {
        public List<bd> a;
        public Map<String, bd> b;
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

    private m(d dVar) {
        super(dVar);
    }

    public static m a(d dVar) {
        if (b == null) {
            synchronized (m.class) {
                if (b == null) {
                    b = new m(dVar);
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
            d().delete(b.a, null, null);
        } catch (Exception unused) {
        }
    }

    public final synchronized long a(bd bdVar) {
        if (d() == null || bdVar == null) {
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", bdVar.a);
            contentValues.put("req_type", Integer.valueOf(bdVar.b));
            contentValues.put("req_url", bdVar.d);
            contentValues.put("req_head", bdVar.c);
            contentValues.put(b.f, Long.valueOf(bdVar.e));
            contentValues.put(b.g, Long.valueOf(bdVar.f));
            contentValues.put(b.h, Integer.valueOf(bdVar.g));
            if (a(bdVar.a)) {
                return d().update(b.a, contentValues, "id = ? ", new String[]{bdVar.a});
            }
            return d().insert(b.a, null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033 A[PHI: r11
      0x0033: PHI (r11v3 android.database.Cursor) = (r11v2 android.database.Cursor), (r11v4 android.database.Cursor) binds: [B:14:0x0031, B:11:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    private boolean a(String str) {
        Cursor cursorQuery;
        try {
            cursorQuery = c().query(b.a, new String[]{"id"}, "id=?", new String[]{str}, "id", null, null);
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

    public final synchronized int b(bd bdVar) {
        if (d() == null || bdVar == null) {
            return -1;
        }
        try {
            return d().delete(b.a, "id=?", new String[]{bdVar.a});
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final synchronized a a() {
        a aVar = new a();
        List<bd> listSynchronizedList = Collections.synchronizedList(new ArrayList(8));
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(8);
        aVar.a = listSynchronizedList;
        aVar.b = concurrentHashMap;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = c().query(b.a, null, null, null, null, null, b.f);
                if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                    if (cursorQuery != null) {
                    }
                    return aVar;
                }
                ArrayList<bd> arrayList = new ArrayList(4);
                while (cursorQuery.moveToNext()) {
                    bd bdVar = new bd();
                    bdVar.a = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    bdVar.b = cursorQuery.getInt(cursorQuery.getColumnIndex("req_type"));
                    bdVar.d = cursorQuery.getString(cursorQuery.getColumnIndex("req_url"));
                    bdVar.c = cursorQuery.getString(cursorQuery.getColumnIndex("req_head"));
                    bdVar.e = cursorQuery.getLong(cursorQuery.getColumnIndex(b.f));
                    bdVar.f = cursorQuery.getLong(cursorQuery.getColumnIndex(b.g));
                    bdVar.g = cursorQuery.getInt(cursorQuery.getColumnIndex(b.h));
                    if (System.currentTimeMillis() < bdVar.f) {
                        listSynchronizedList.add(bdVar);
                        concurrentHashMap.put(bdVar.a, bdVar);
                    } else {
                        arrayList.add(bdVar);
                    }
                }
                cursorQuery.close();
                if (arrayList.size() > 0) {
                    for (bd bdVar2 : arrayList) {
                        bdVar2.a();
                        b(bdVar2);
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
