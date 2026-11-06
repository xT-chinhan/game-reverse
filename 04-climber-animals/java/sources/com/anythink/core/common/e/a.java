package com.anythink.core.common.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends c<com.anythink.core.common.h.f> {
    public static final String a = "1";
    public static final String b = "2";
    public static final String c = "3";
    public static final String d = "4";
    private static volatile a g;
    private final String f;

    /* JADX INFO: renamed from: com.anythink.core.common.e.a$a, reason: collision with other inner class name */
    public static class C0080a implements BaseColumns {
        public static final String a = "ad_frequency";
        public static final String b = "event_type";
        public static final String c = "app";
        public static final String d = "format";
        public static final String e = "network_id";
        public static final String f = "network_format";
        public static final String g = "placement_id";
        public static final String h = "source_id";
        public static final String i = "extra";
        public static final String j = "month";
        public static final String k = "day";
        public static final String l = "hour";
        public static final String m = "time_stamp";
        public static final String n = "req_num";
        public static final String o = "rule_id";
        public static final String p = "fail_count";
        public static final String q = "next_req_timestamp";
        public static final String r = "CREATE TABLE IF NOT EXISTS ad_frequency(_id INTEGER PRIMARY KEY AUTOINCREMENT ,event_type TEXT ,app TEXT ,network_id TEXT ,format TEXT ,network_format TEXT ,placement_id TEXT ,source_id TEXT ,extra TEXT ,month INTEGER ,day INTEGER ,hour INTEGER , req_num INTEGER , time_stamp INTEGER)";
        public static final String s = "ALTER TABLE ad_frequency ADD COLUMN rule_id INTEGER;";
        public static final String t = "ALTER TABLE ad_frequency ADD COLUMN fail_count INTEGER;";
        public static final String u = "ALTER TABLE ad_frequency ADD COLUMN next_req_timestamp INTEGER;";
    }

    private a(d dVar) {
        super(dVar);
        this.f = "AdFrequencyDao";
    }

    public static a a(d dVar) {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a(dVar);
                }
            }
        }
        return g;
    }

    public final void a(final com.anythink.core.common.h.f fVar) {
        try {
            com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.e.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.b(fVar);
                }
            }, 2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b(com.anythink.core.common.h.f fVar) {
        synchronized (this) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0080a.b, "2");
                contentValues.put(C0080a.c, fVar.j());
                contentValues.put("placement_id", fVar.d());
                contentValues.put("network_id", fVar.b());
                contentValues.put("format", fVar.c());
                contentValues.put(C0080a.f, fVar.k());
                contentValues.put(C0080a.h, fVar.e());
                contentValues.put(C0080a.j, Integer.valueOf(fVar.f()));
                contentValues.put(C0080a.k, Integer.valueOf(fVar.g()));
                contentValues.put(C0080a.l, Integer.valueOf(fVar.h()));
                contentValues.put(C0080a.m, Long.valueOf(fVar.i()));
                d().insert(C0080a.a, null, contentValues);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final List<com.anythink.core.common.h.f> a(String str, String str2) {
        List<com.anythink.core.common.h.f> listA;
        Cursor cursorQuery;
        synchronized (this) {
            Date date = new Date();
            listA = null;
            try {
                cursorQuery = c().query(C0080a.a, null, String.format("event_type = ? and %s = ? and month = ? and day = ?", str2), new String[]{"2", str, com.anythink.core.a.b.a(date), com.anythink.core.a.b.b(date)}, null, null, null);
                try {
                    listA = a(cursorQuery);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (cursorQuery != null) {
                        }
                        return listA;
                    } catch (Throwable th2) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                            throw th2;
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                cursorQuery = null;
            }
        }
        return listA;
    }

    public final List<com.anythink.core.common.h.f> b(String str, String str2) {
        List<com.anythink.core.common.h.f> listA;
        Cursor cursorQuery;
        synchronized (this) {
            Date date = new Date();
            listA = null;
            try {
                cursorQuery = c().query(C0080a.a, null, String.format("event_type = ? and %s = ? and month = ? and day = ? and hour = ?", str2), new String[]{"2", str, com.anythink.core.a.b.a(date), com.anythink.core.a.b.b(date), com.anythink.core.a.b.c(date)}, null, null, null);
                try {
                    listA = a(cursorQuery);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (cursorQuery != null) {
                        }
                        return listA;
                    } catch (Throwable th2) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                            throw th2;
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                cursorQuery = null;
            }
        }
        return listA;
    }

    public final com.anythink.core.common.h.f c(String str, String str2) {
        com.anythink.core.common.h.f fVar;
        Cursor cursorRawQuery;
        synchronized (this) {
            fVar = null;
            try {
                cursorRawQuery = c().rawQuery(String.format("select * from ad_frequency where event_type = '2' and %s = '" + str + "' order by time_stamp DESC limit 1", str2), null);
                try {
                    List<com.anythink.core.common.h.f> listA = a(cursorRawQuery);
                    fVar = listA.isEmpty() ? null : listA.get(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        try {
                            th.printStackTrace();
                            if (cursorRawQuery != null) {
                            }
                            return fVar;
                        } catch (Throwable th2) {
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                cursorRawQuery = null;
            }
        }
        return fVar;
    }

    private static List<com.anythink.core.common.h.f> a(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    arrayList.add(new com.anythink.core.common.h.f(cursor.getString(cursor.getColumnIndex(C0080a.b)), cursor.getString(cursor.getColumnIndex(C0080a.c)), cursor.getString(cursor.getColumnIndex("network_id")), cursor.getString(cursor.getColumnIndex("format")), cursor.getString(cursor.getColumnIndex(C0080a.f)), cursor.getString(cursor.getColumnIndex("placement_id")), cursor.getString(cursor.getColumnIndex(C0080a.h)), cursor.getInt(cursor.getColumnIndex(C0080a.j)), cursor.getInt(cursor.getColumnIndex(C0080a.k)), cursor.getInt(cursor.getColumnIndex(C0080a.l)), cursor.getLong(cursor.getColumnIndex(C0080a.m))));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public final void a(String str, String str2, int i, long j) {
        synchronized (this) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0080a.n, Integer.valueOf(i));
                contentValues.put(C0080a.m, Long.valueOf(j));
                d().update(C0080a.a, contentValues, String.format("event_type = ? and %s = ?", str2), new String[]{"1", str});
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b(final String str, final String str2, final int i, final long j) {
        try {
            com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.e.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.d(str, str2) != null) {
                        a.this.a(str, str2, i, j);
                    } else {
                        a.this.c(str, str2, i, j);
                    }
                }
            }, 2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0068  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void c(String str, String str2, int i, long j) {
        byte b2;
        synchronized (this) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0080a.b, "1");
                contentValues.put(C0080a.n, Integer.valueOf(i));
                contentValues.put(C0080a.m, Long.valueOf(j));
                switch (str2.hashCode()) {
                    case -1928631512:
                        if (!str2.equals(C0080a.f)) {
                            b2 = -1;
                        } else {
                            b2 = 3;
                        }
                        break;
                    case -1698410561:
                        if (!str2.equals(C0080a.h)) {
                            b2 = -1;
                        } else {
                            b2 = 5;
                        }
                        break;
                    case -1268779017:
                        if (!str2.equals("format")) {
                            b2 = -1;
                        } else {
                            b2 = 1;
                        }
                        break;
                    case -478232372:
                        if (!str2.equals("network_id")) {
                            b2 = -1;
                        } else {
                            b2 = 2;
                        }
                        break;
                    case 96801:
                        if (!str2.equals(C0080a.c)) {
                            b2 = -1;
                        } else {
                            b2 = 0;
                        }
                        break;
                    case 1224358069:
                        if (!str2.equals("placement_id")) {
                            b2 = -1;
                        } else {
                            b2 = 4;
                        }
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                if (b2 == 0) {
                    contentValues.put(C0080a.c, str);
                } else if (b2 == 1) {
                    contentValues.put("format", str);
                } else if (b2 == 2) {
                    contentValues.put("network_id", str);
                } else if (b2 == 3) {
                    contentValues.put(C0080a.f, str);
                } else if (b2 == 4) {
                    contentValues.put("placement_id", str);
                } else if (b2 == 5) {
                    contentValues.put(C0080a.h, str);
                }
                d().insert(C0080a.a, null, contentValues);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final com.anythink.core.common.h.f d(String str, String str2) {
        com.anythink.core.common.h.f fVar;
        synchronized (this) {
            Cursor cursor = null;
            try {
                try {
                    Cursor cursorQuery = c().query(C0080a.a, null, String.format("event_type = ? and %s = ?", str2), new String[]{"1", str}, null, null, null, "1");
                    fVar = null;
                    while (cursorQuery.moveToNext()) {
                        try {
                            fVar = new com.anythink.core.common.h.f(cursorQuery.getString(cursorQuery.getColumnIndex(C0080a.b)), cursorQuery.getString(cursorQuery.getColumnIndex(str2)), str2, cursorQuery.getLong(cursorQuery.getColumnIndex(C0080a.m)), cursorQuery.getInt(cursorQuery.getColumnIndex(C0080a.n)));
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            try {
                                th.printStackTrace();
                                if (cursor != null) {
                                    cursor.close();
                                }
                            } catch (Throwable th2) {
                                if (cursor != null) {
                                    cursor.close();
                                    throw th2;
                                }
                                throw th2;
                            }
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            } catch (Throwable th4) {
                th = th4;
                fVar = null;
            }
        }
        return fVar;
    }

    public final void e(String str, String str2) {
        synchronized (this) {
            try {
                if (d() == null) {
                } else {
                    d().delete(C0080a.a, "event_type = ? and month != ? or day != ?", new String[]{"2", str, str2});
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(final com.anythink.core.common.h.f fVar, final boolean z) {
        if (fVar == null) {
            return;
        }
        try {
            com.anythink.core.common.v.b.b.a().c(new Runnable() { // from class: com.anythink.core.common.e.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (z) {
                        a.a(a.this, fVar);
                    } else {
                        a.b(a.this, fVar);
                    }
                }
            }, 13);
        } catch (Throwable unused) {
        }
    }

    private void c(com.anythink.core.common.h.f fVar) {
        synchronized (this) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0080a.b, fVar.a());
                contentValues.put(C0080a.o, Integer.valueOf(fVar.l()));
                contentValues.put(C0080a.h, fVar.e());
                contentValues.put(C0080a.m, Long.valueOf(fVar.i()));
                contentValues.put(C0080a.q, Long.valueOf(fVar.n()));
                contentValues.put(C0080a.p, Integer.valueOf(fVar.m()));
                contentValues.put(C0080a.n, Integer.valueOf(fVar.a));
                long jInsert = d().insert(C0080a.a, null, contentValues);
                if (jInsert < 0) {
                    Object[] objArr = new Object[2];
                    fVar.e();
                    Long.valueOf(jInsert);
                }
            } catch (Throwable unused) {
                Object[] objArr2 = new Object[1];
                fVar.e();
            }
        }
    }

    private void d(com.anythink.core.common.h.f fVar) {
        synchronized (this) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0080a.m, Long.valueOf(fVar.i()));
                contentValues.put(C0080a.q, Long.valueOf(fVar.n()));
                contentValues.put(C0080a.p, Integer.valueOf(fVar.m()));
                contentValues.put(C0080a.n, Integer.valueOf(fVar.a));
                int iUpdate = d().update(C0080a.a, contentValues, String.format("%s = ? and %s = ? and %s = ?", C0080a.b, C0080a.h, C0080a.o), new String[]{fVar.a(), fVar.e(), String.valueOf(fVar.l())});
                if (iUpdate < 0) {
                    Object[] objArr = new Object[2];
                    fVar.e();
                    Integer.valueOf(iUpdate);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final List<com.anythink.core.common.h.f> a(List<Pair<String, String>> list, int i) {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Pair<String, String[]> pairC = c(list);
                if (i > 0) {
                    cursorQuery = c().query(C0080a.a, null, (String) pairC.first, (String[]) pairC.second, null, null, "time_stamp DESC", String.valueOf(i));
                } else {
                    cursorQuery = c().query(C0080a.a, null, (String) pairC.first, (String[]) pairC.second, null, null, "time_stamp DESC", null);
                }
                while (cursorQuery.moveToNext()) {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(C0080a.b));
                        long j = cursorQuery.getLong(cursorQuery.getColumnIndex(C0080a.m));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(C0080a.n));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(C0080a.h));
                        int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex(C0080a.o));
                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex(C0080a.p));
                        long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex(C0080a.q));
                        com.anythink.core.common.h.f fVar = new com.anythink.core.common.h.f(string, string2, C0080a.h, j, i2);
                        fVar.a(i3);
                        fVar.b(i4);
                        fVar.b(j2);
                        arrayList.add(fVar);
                    } catch (Throwable unused) {
                        if (cursorQuery != null) {
                        }
                        return arrayList;
                    }
                }
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable unused3) {
                cursorQuery = null;
            }
        }
        return arrayList;
    }

    public final void a(final List<Pair<String, String>> list) {
        com.anythink.core.common.v.b.b.a().c(new Runnable() { // from class: com.anythink.core.common.e.a.4
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (this) {
                    try {
                        Pair pairC = a.c((List<Pair<String, String>>) list);
                        a.this.d().delete(C0080a.a, (String) pairC.first, (String[]) pairC.second);
                    } catch (Throwable unused) {
                    }
                }
            }
        }, 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Pair<String, String[]> c(List<Pair<String, String>> list) {
        String[] strArr;
        StringBuilder sb = new StringBuilder();
        if (list == null || list.isEmpty()) {
            strArr = null;
        } else {
            strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Pair<String, String> pair = list.get(i);
                sb.append((String) pair.first);
                if (i != list.size() - 1) {
                    sb.append(" and ");
                }
                strArr[i] = (String) pair.second;
            }
        }
        return new Pair<>(sb.toString(), strArr);
    }

    static /* synthetic */ void a(a aVar, com.anythink.core.common.h.f fVar) {
        synchronized (aVar) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0080a.m, Long.valueOf(fVar.i()));
                contentValues.put(C0080a.q, Long.valueOf(fVar.n()));
                contentValues.put(C0080a.p, Integer.valueOf(fVar.m()));
                contentValues.put(C0080a.n, Integer.valueOf(fVar.a));
                int iUpdate = aVar.d().update(C0080a.a, contentValues, String.format("%s = ? and %s = ? and %s = ?", C0080a.b, C0080a.h, C0080a.o), new String[]{fVar.a(), fVar.e(), String.valueOf(fVar.l())});
                if (iUpdate < 0) {
                    Object[] objArr = new Object[2];
                    fVar.e();
                    Integer.valueOf(iUpdate);
                }
            } catch (Throwable unused) {
            }
        }
    }

    static /* synthetic */ void b(a aVar, com.anythink.core.common.h.f fVar) {
        synchronized (aVar) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0080a.b, fVar.a());
                contentValues.put(C0080a.o, Integer.valueOf(fVar.l()));
                contentValues.put(C0080a.h, fVar.e());
                contentValues.put(C0080a.m, Long.valueOf(fVar.i()));
                contentValues.put(C0080a.q, Long.valueOf(fVar.n()));
                contentValues.put(C0080a.p, Integer.valueOf(fVar.m()));
                contentValues.put(C0080a.n, Integer.valueOf(fVar.a));
                long jInsert = aVar.d().insert(C0080a.a, null, contentValues);
                if (jInsert < 0) {
                    Object[] objArr = new Object[2];
                    fVar.e();
                    Long.valueOf(jInsert);
                }
            } catch (Throwable unused) {
                Object[] objArr2 = new Object[1];
                fVar.e();
            }
        }
    }
}
