package com.anythink.core.common.f;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.anythink.core.common.h.am;
import com.anythink.core.common.h.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f extends b<am> {
    private static final String a = "f";
    private static volatile f b;

    public static class a {
        static final String a = "dyn_wf_ad_source_filter";
        static final String b = "placement_id";
        static final String c = "ad_source_id";
        static final String d = "request_id";
        static final String e = "expired_timestamp";
        static final String f = "match_error_code";
        public static final String g = "CREATE TABLE IF NOT EXISTS dyn_wf_ad_source_filter(placement_id TEXT ,ad_source_id TEXT ,request_id TEXT ,match_error_code TEXT ,expired_timestamp INTEGER)";
        public static final String h = "CREATE INDEX IF NOT EXISTS idx_placement_id ON dyn_wf_ad_source_filter(placement_id)";
        public static final String i = "CREATE INDEX IF NOT EXISTS idx_ad_source_id ON dyn_wf_ad_source_filter(ad_source_id)";
        public static final String j = "CREATE INDEX IF NOT EXISTS idx_ad_request_id ON dyn_wf_ad_source_filter(request_id)";
        public static final String k = "CREATE INDEX IF NOT EXISTS idx_expired_timestamp ON dyn_wf_ad_source_filter(expired_timestamp)";
        public static final String l = "CREATE INDEX IF NOT EXISTS idx_match_error_code ON dyn_wf_ad_source_filter(match_error_code)";
    }

    private f(c cVar) {
        super(cVar);
    }

    public static f a(Context context) {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new f(d.a(context));
                }
            }
        }
        return b;
    }

    public final synchronized void a(am amVar) {
        boolean z;
        if (amVar == null) {
            return;
        }
        try {
            SQLiteDatabase sQLiteDatabaseB = b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("placement_id", amVar.b());
            contentValues.put("ad_source_id", amVar.a());
            contentValues.put("request_id", amVar.g());
            contentValues.put("match_error_code", amVar.h());
            contentValues.put("expired_timestamp", Long.valueOf(amVar.f()));
            Cursor cursorQuery = a().query("dyn_wf_ad_source_filter", new String[]{"request_id"}, "request_id = ? AND ad_source_id = ?", new String[]{amVar.g(), amVar.a()}, null, null, null);
            if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                z = false;
            } else {
                cursorQuery.close();
                z = true;
            }
            if (z) {
                sQLiteDatabaseB.update("dyn_wf_ad_source_filter", contentValues, "request_id = ? AND ad_source_id = ?", new String[]{amVar.g(), amVar.a()});
            } else {
                sQLiteDatabaseB.insertOrThrow("dyn_wf_ad_source_filter", null, contentValues);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x004e A[PHI: r12
      0x004e: PHI (r12v3 android.database.Cursor) = (r12v2 android.database.Cursor), (r12v5 android.database.Cursor) binds: [B:11:0x004c, B:8:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    private Map<String, Integer> c(String str) {
        Cursor cursorQuery;
        HashMap map = new HashMap();
        try {
            cursorQuery = a().query("dyn_wf_ad_source_filter", new String[]{"ad_source_id", "count(request_id)"}, "placement_id = ? AND expired_timestamp >= ?", new String[]{str, String.valueOf(System.currentTimeMillis())}, "ad_source_id", null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    map.put(cursorQuery.getString(a(cursorQuery, "ad_source_id")), Integer.valueOf(cursorQuery.getInt(1)));
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
        return map;
    }

    public final synchronized an a(String str) {
        an anVar;
        Cursor cursorQuery;
        anVar = new an(str);
        try {
            cursorQuery = a().query("dyn_wf_ad_source_filter", new String[]{"ad_source_id", "match_error_code", "count(request_id)"}, "placement_id = ? AND match_error_code IS NOT NULL AND match_error_code != ? AND expired_timestamp >= ?", new String[]{str, "", String.valueOf(System.currentTimeMillis())}, "ad_source_id,match_error_code", null, "ad_source_id");
            try {
                HashMap map = new HashMap();
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(a(cursorQuery, "ad_source_id"));
                    String string2 = cursorQuery.getString(a(cursorQuery, "match_error_code"));
                    int i = cursorQuery.getInt(2);
                    List<an.a> arrayList = map.get(string);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(new an.a(string2, i));
                    map.put(string, arrayList);
                }
                anVar.a(map);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable unused) {
                if (cursorQuery != null) {
                }
                anVar.b(c(str));
                return anVar;
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        anVar.b(c(str));
        return anVar;
    }

    public final synchronized void b(String str) {
        try {
            b().delete("dyn_wf_ad_source_filter", "placement_id = ? AND expired_timestamp < ?", new String[]{str, String.valueOf(System.currentTimeMillis())});
        } catch (Throwable unused) {
        }
    }

    private static int a(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        throw new IllegalArgumentException("columnIndex must >= 0.");
    }

    private boolean b(am amVar) {
        Cursor cursorQuery = a().query("dyn_wf_ad_source_filter", new String[]{"request_id"}, "request_id = ? AND ad_source_id = ?", new String[]{amVar.g(), amVar.a()}, null, null, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.close();
            return true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return false;
    }
}
