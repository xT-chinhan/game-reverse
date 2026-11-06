package com.anythink.core.common.f;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends b<com.anythink.core.common.h.f> {
    public static final String a = "1";
    public static final String b = "2";
    public static final String c = "3";
    public static final String d = "4";
    private static volatile a g;
    private final String f;

    /* JADX INFO: renamed from: com.anythink.core.common.f.a$a, reason: collision with other inner class name */
    public static class C0017a implements BaseColumns {
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

    private a(c cVar) {
        super(cVar);
        this.f = "AdFrequencyDao";
    }

    public static a a(c cVar) {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a(cVar);
                }
            }
        }
        return g;
    }

    public final void a(final com.anythink.core.common.h.f fVar) {
        try {
            com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.n, new Runnable() { // from class: com.anythink.core.common.f.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.b(fVar);
                }
            }));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b(com.anythink.core.common.h.f fVar) {
        synchronized (this) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("event_type", "2");
                contentValues.put(C0017a.c, fVar.j());
                contentValues.put("placement_id", fVar.d());
                contentValues.put("network_id", fVar.b());
                contentValues.put(C0017a.d, fVar.c());
                contentValues.put(C0017a.f, fVar.k());
                contentValues.put(C0017a.h, fVar.e());
                contentValues.put(C0017a.j, Integer.valueOf(fVar.f()));
                contentValues.put(C0017a.k, Integer.valueOf(fVar.g()));
                contentValues.put(C0017a.l, Integer.valueOf(fVar.h()));
                contentValues.put(C0017a.m, Long.valueOf(fVar.i()));
                b().insert(C0017a.a, null, contentValues);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final long a(String str, String str2) {
        synchronized (this) {
            Date date = new Date();
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = a().rawQuery("SELECT COUNT(*) FROM ad_frequency WHERE event_type = ? AND " + str2 + " = ? AND month = ? AND day = ?", new String[]{"2", str, com.anythink.core.a.b.a(date), com.anythink.core.a.b.b(date)});
                if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
                    if (cursorRawQuery != null) {
                    }
                    return 0L;
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    if (cursorRawQuery != null) {
                    }
                } catch (Throwable th2) {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    throw th2;
                }
            }
            cursorRawQuery.close();
            return 0L;
        }
    }

    public final long b(String str, String str2) {
        synchronized (this) {
            Date date = new Date();
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = a().rawQuery("SELECT COUNT(*) FROM ad_frequency WHERE event_type = ? AND " + str2 + " = ? AND month = ? AND day = ? AND hour = ?", new String[]{"2", str, com.anythink.core.a.b.a(date), com.anythink.core.a.b.b(date), com.anythink.core.a.b.c(date)});
                if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
                    if (cursorRawQuery != null) {
                    }
                    return 0L;
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    if (cursorRawQuery != null) {
                    }
                } catch (Throwable th2) {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    throw th2;
                }
            }
            cursorRawQuery.close();
            return 0L;
        }
    }

    public final com.anythink.core.common.h.f c(String str, String str2) {
        com.anythink.core.common.h.f fVar;
        Cursor cursorRawQuery;
        synchronized (this) {
            fVar = null;
            try {
                cursorRawQuery = a().rawQuery(String.format("select * from ad_frequency where event_type = '2' and %s = '" + str + "' order by time_stamp DESC limit 1", str2), null);
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
                    arrayList.add(new com.anythink.core.common.h.f(cursor.getString(cursor.getColumnIndex("event_type")), cursor.getString(cursor.getColumnIndex(C0017a.c)), cursor.getString(cursor.getColumnIndex("network_id")), cursor.getString(cursor.getColumnIndex(C0017a.d)), cursor.getString(cursor.getColumnIndex(C0017a.f)), cursor.getString(cursor.getColumnIndex("placement_id")), cursor.getString(cursor.getColumnIndex(C0017a.h)), cursor.getInt(cursor.getColumnIndex(C0017a.j)), cursor.getInt(cursor.getColumnIndex(C0017a.k)), cursor.getInt(cursor.getColumnIndex(C0017a.l)), cursor.getLong(cursor.getColumnIndex(C0017a.m))));
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
                contentValues.put(C0017a.n, Integer.valueOf(i));
                contentValues.put(C0017a.m, Long.valueOf(j));
                b().update(C0017a.a, contentValues, String.format("event_type = ? and %s = ?", str2), new String[]{"1", str});
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b(final String str, final String str2, final int i, final long j) {
        try {
            com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.o, new Runnable() { // from class: com.anythink.core.common.f.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.d(str, str2) != null) {
                        a.this.a(str, str2, i, j);
                    } else {
                        a.this.c(str, str2, i, j);
                    }
                }
            }));
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
                contentValues.put("event_type", "1");
                contentValues.put(C0017a.n, Integer.valueOf(i));
                contentValues.put(C0017a.m, Long.valueOf(j));
                switch (str2.hashCode()) {
                    case -1928631512:
                        if (!str2.equals(C0017a.f)) {
                            b2 = -1;
                        } else {
                            b2 = 3;
                        }
                        break;
                    case -1698410561:
                        if (!str2.equals(C0017a.h)) {
                            b2 = -1;
                        } else {
                            b2 = 5;
                        }
                        break;
                    case -1268779017:
                        if (!str2.equals(C0017a.d)) {
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
                        if (!str2.equals(C0017a.c)) {
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
                    contentValues.put(C0017a.c, str);
                } else if (b2 == 1) {
                    contentValues.put(C0017a.d, str);
                } else if (b2 == 2) {
                    contentValues.put("network_id", str);
                } else if (b2 == 3) {
                    contentValues.put(C0017a.f, str);
                } else if (b2 == 4) {
                    contentValues.put("placement_id", str);
                } else if (b2 == 5) {
                    contentValues.put(C0017a.h, str);
                }
                b().insert(C0017a.a, null, contentValues);
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
                    Cursor cursorQuery = a().query(C0017a.a, null, String.format("event_type = ? and %s = ?", str2), new String[]{"1", str}, null, null, null, "1");
                    fVar = null;
                    while (cursorQuery.moveToNext()) {
                        try {
                            fVar = new com.anythink.core.common.h.f(cursorQuery.getString(cursorQuery.getColumnIndex("event_type")), cursorQuery.getString(cursorQuery.getColumnIndex(str2)), str2, cursorQuery.getLong(cursorQuery.getColumnIndex(C0017a.m)), cursorQuery.getInt(cursorQuery.getColumnIndex(C0017a.n)));
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
                if (b() == null) {
                } else {
                    b().delete(C0017a.a, "event_type = ? and (month != ? or day != ?)", new String[]{"2", str, str2});
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
            com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.p, new Runnable() { // from class: com.anythink.core.common.f.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (z) {
                        a.a(a.this, fVar);
                    } else {
                        a.b(a.this, fVar);
                    }
                }
            }));
        } catch (Throwable unused) {
        }
    }

    private void c(com.anythink.core.common.h.f fVar) {
        synchronized (this) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("event_type", fVar.a());
                contentValues.put(C0017a.o, Integer.valueOf(fVar.l()));
                contentValues.put(C0017a.h, fVar.e());
                contentValues.put(C0017a.m, Long.valueOf(fVar.i()));
                contentValues.put(C0017a.q, Long.valueOf(fVar.n()));
                contentValues.put(C0017a.p, Integer.valueOf(fVar.m()));
                contentValues.put(C0017a.n, Integer.valueOf(fVar.a));
                b().insert(C0017a.a, null, contentValues);
            } catch (Throwable unused) {
            }
        }
    }

    private void d(com.anythink.core.common.h.f fVar) {
        synchronized (this) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C0017a.m, Long.valueOf(fVar.i()));
                contentValues.put(C0017a.q, Long.valueOf(fVar.n()));
                contentValues.put(C0017a.p, Integer.valueOf(fVar.m()));
                contentValues.put(C0017a.n, Integer.valueOf(fVar.a));
                b().update(C0017a.a, contentValues, String.format("%s = ? and %s = ? and %s = ?", "event_type", C0017a.h, C0017a.o), new String[]{fVar.a(), fVar.e(), String.valueOf(fVar.l())});
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
                    cursorQuery = a().query(C0017a.a, null, (String) pairC.first, (String[]) pairC.second, null, null, "time_stamp DESC", String.valueOf(i));
                } else {
                    cursorQuery = a().query(C0017a.a, null, (String) pairC.first, (String[]) pairC.second, null, null, "time_stamp DESC", null);
                }
                while (cursorQuery.moveToNext()) {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("event_type"));
                        long j = cursorQuery.getLong(cursorQuery.getColumnIndex(C0017a.m));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(C0017a.n));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(C0017a.h));
                        int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex(C0017a.o));
                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex(C0017a.p));
                        long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex(C0017a.q));
                        com.anythink.core.common.h.f fVar = new com.anythink.core.common.h.f(string, string2, C0017a.h, j, i2);
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
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.m, new Runnable() { // from class: com.anythink.core.common.f.a.4
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (this) {
                    try {
                        Pair pairC = a.c((List<Pair<String, String>>) list);
                        a.this.b().delete(C0017a.a, (String) pairC.first, (String[]) pairC.second);
                    } catch (Throwable unused) {
                    }
                }
            }
        }));
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
                contentValues.put(C0017a.m, Long.valueOf(fVar.i()));
                contentValues.put(C0017a.q, Long.valueOf(fVar.n()));
                contentValues.put(C0017a.p, Integer.valueOf(fVar.m()));
                contentValues.put(C0017a.n, Integer.valueOf(fVar.a));
                aVar.b().update(C0017a.a, contentValues, String.format("%s = ? and %s = ? and %s = ?", "event_type", C0017a.h, C0017a.o), new String[]{fVar.a(), fVar.e(), String.valueOf(fVar.l())});
            } catch (Throwable unused) {
            }
        }
    }

    static /* synthetic */ void b(a aVar, com.anythink.core.common.h.f fVar) {
        synchronized (aVar) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("event_type", fVar.a());
                contentValues.put(C0017a.o, Integer.valueOf(fVar.l()));
                contentValues.put(C0017a.h, fVar.e());
                contentValues.put(C0017a.m, Long.valueOf(fVar.i()));
                contentValues.put(C0017a.q, Long.valueOf(fVar.n()));
                contentValues.put(C0017a.p, Integer.valueOf(fVar.m()));
                contentValues.put(C0017a.n, Integer.valueOf(fVar.a));
                aVar.b().insert(C0017a.a, null, contentValues);
            } catch (Throwable unused) {
            }
        }
    }
}
